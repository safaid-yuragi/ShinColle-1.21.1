package com.lulan.shincolle.blockentity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.crafting.LargeRecipes;
import com.lulan.shincolle.item.BasicEquip;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.registry.ModBlockEntities;
import com.lulan.shincolle.registry.ModBlocks;
import com.lulan.shincolle.registry.ModItems;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.TileEntityHelper;
import com.lulan.shincolle.utility.TileEntityHelper.ITileLiquidFurnace;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

/** Fuel Cost = BaseCost + CostPerMaterial * ( TotalMaterialAmount - minAmount * 4 )
 *  Total Build Time = FuelCost / buildSpeed
 *  MaxBuildTime / MaxFuelCost = 24min / 1382400  (48 fuel per tick)
 *  MinBuildTime / MinFuelCost = 8min / 460800
 *  MaxMaterial / MaxFuelCost = 1000*4 / 1382400
 *  MinMaterial / MinFuelCost = 100*4 / 460800 = BaseCost(460800) CostPerMaterial(256)
 *
 *  port of legacy TileMultiGrudgeHeavy (large shipyard master).
 *
 *  Slots:
 *    0: output
 *    1~9: material/fuel input
 */
public class TileMultiGrudgeHeavy extends BasicMultiBlockEntity
    implements ITileLiquidFurnace
{

    //furnace
    private int powerConsumed = 0;  //spent power
    private int powerRemained = 0;  //fuel left
    private int powerGoal = 0;      //goal power to finish build
    private int buildType = 0;      //0:none 1:ship 2:equip 3:ship loop 4:equip loop
    private int invMode = 0;        //0:add to stock 1:release from stock
    private int selectMat = 0;      //0:grudge 1:abyss 2:ammo 3:poly
    private boolean isActive;       //isBuilding state for change detect
    private int[] matsBuild;        //build material amount
    private int[] matsStock;        //stock material amount
    private int syncTime = 0;

    //config values (lazy: config may not be loaded at ctor time)
    private int powerMax = -1;
    private int buildSpeed;
    private float fuelMagn;
    private int powerInst;

    public static final int SLOTS_NUM = 10;  //total slots
    public static final int SLOTS_OUT = 0;   //output slot
    public static final int[] ALLSLOTS =
        new int[] {0,2,3,4,5,6,7,8,9}; //slot 1 for fuel

    //field indices for GUI sync (ContainerData, small ints only)
    public static final int FIELDTYPE_BUILDTYPE = 0;
    public static final int FIELDTYPE_SELECTMAT = 1;
    public static final int FIELDTYPE_INVMODE = 2;
    public static final int FIELDTYPE_MATBUILD0 = 3;    //3~6: matsBuild

    //fluid tank (lava, internal; capability fill-only registered elsewhere)
    protected final FluidTank tank = new FluidTank(2000,
        fs -> fs.is(Fluids.LAVA));


    public TileMultiGrudgeHeavy(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TILEMULTIGRUDGEHEAVY.get(), pos, state, SLOTS_NUM);
        this.isActive = false;
        this.matsBuild = new int[] {0, 0, 0, 0};
        this.matsStock = new int[] {0, 0, 0, 0};
        this.fields = new int[7];
    }

    private void loadConfig()
    {
        if (this.powerMax >= 0) return;
        this.powerMax = (int) ShinColleConfig.tileShipyardLarge[0];
        this.buildSpeed = (int) ShinColleConfig.tileShipyardLarge[1];
        this.fuelMagn = (float) ShinColleConfig.tileShipyardLarge[2];
        this.powerInst = this.buildSpeed * 1200;
    }

    /* ==================== CAPABILITY ==================== */

    /** fluid tank for fluid capability registration (fill only) */
    public IFluidHandler getTank()
    {
        return this.tank;
    }

    /* ==================== SLOT RULES ==================== */

    //slot use: 0:output 1~9:inventory
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        //output slot
        if (slot == SLOTS_OUT) return false;

        if (stack != null && !stack.isEmpty())
        {
            //fluid container: 1 per slot
            if (stack.getCapability(Capabilities.FluidHandler.ITEM) != null &&
                !this.itemHandler.getStackInSlot(slot).isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    /* ==================== NBT ==================== */

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.saveAdditional(tag, registries);
        tag.put("tank", this.tank.writeToNBT(registries, new CompoundTag()));
        tag.putInt("powerConsumed", this.powerConsumed);
        tag.putInt("powerRemained", this.powerRemained);
        tag.putInt("powerGoal", this.powerGoal);
        tag.putInt("buildType", this.buildType);
        tag.putInt("invMode", this.invMode);
        tag.putInt("selectMat", this.selectMat);
        tag.putIntArray("matsBuild", this.getMatBuild());
        tag.putIntArray("matsStock", this.getMatStock());
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.loadAdditional(tag, registries);
        this.tank.readFromNBT(registries, tag.getCompound("tank"));
        this.powerConsumed = tag.getInt("powerConsumed");
        this.powerRemained = tag.getInt("powerRemained");
        this.powerGoal = tag.getInt("powerGoal");
        this.buildType = tag.getInt("buildType");
        this.invMode = tag.getInt("invMode");
        this.selectMat = tag.getInt("selectMat");
        this.setMatBuild(tag.getIntArray("matsBuild"));
        this.setMatStock(tag.getIntArray("matsStock"));
    }

    /* ==================== FIELDS (GUI sync) ==================== */

    @Override
    public int getField(int id)
    {
        return switch (id)
        {
        case FIELDTYPE_BUILDTYPE -> this.buildType;
        case FIELDTYPE_SELECTMAT -> this.selectMat;
        case FIELDTYPE_INVMODE -> this.invMode;
        case FIELDTYPE_MATBUILD0 -> this.getMatBuild(0);
        case FIELDTYPE_MATBUILD0 + 1 -> this.getMatBuild(1);
        case FIELDTYPE_MATBUILD0 + 2 -> this.getMatBuild(2);
        case FIELDTYPE_MATBUILD0 + 3 -> this.getMatBuild(3);
        default -> 0;
        };
    }

    @Override
    public void setField(int id, int value)
    {
        switch (id)
        {
        case FIELDTYPE_BUILDTYPE -> this.buildType = value;
        case FIELDTYPE_SELECTMAT -> this.selectMat = value;
        case FIELDTYPE_INVMODE -> this.invMode = value;
        case FIELDTYPE_MATBUILD0 -> this.setMatBuild(0, value);
        case FIELDTYPE_MATBUILD0 + 1 -> this.setMatBuild(1, value);
        case FIELDTYPE_MATBUILD0 + 2 -> this.setMatBuild(2, value);
        case FIELDTYPE_MATBUILD0 + 3 -> this.setMatBuild(3, value);
        default -> {}
        }
    }

    /* ==================== BUILD ==================== */

    //build complete, put product to output slot
    public void buildComplete()
    {
        switch (this.buildType)
        {
        default:
        case ID.Build.SHIP:         //build ship
        case ID.Build.SHIP_LOOP:
            itemHandler.setStackInSlot(SLOTS_OUT,
                LargeRecipes.getBuildResultShip(getMatBuild()));
        break;
        case ID.Build.EQUIP:        //build equip
        case ID.Build.EQUIP_LOOP:
            itemHandler.setStackInSlot(SLOTS_OUT,
                LargeRecipes.getBuildResultEquip(getMatBuild(),
                    this.level.registryAccess()));
        break;
        }
    }

    public boolean isBuilding()
    {
        return hasPowerRemained() && canBuild();
    }

    public boolean hasPowerRemained()
    {
        loadConfig();
        return this.powerRemained > this.buildSpeed;
    }

    public boolean canBuild()
    {
        return this.powerGoal > 0 &&
               itemHandler.getStackInSlot(SLOTS_OUT).isEmpty();
    }

    /* ==================== TICK ==================== */

    @Override
    public void tick()
    {
        loadConfig();

        //do not update if no structure
        if (this.getStructType() <= 0) return;

        boolean sendUpdate = false;

        //server side
        if (!this.level.isClientSide())
        {
            //update goalPower
            if (this.buildType != 0)
            {
                this.powerGoal = LargeRecipes.calcGoalPower(getMatBuild());
            }
            else
            {
                this.powerGoal = 0;
            }

            //add item fuel (slot 1)
            if (TileEntityHelper.decrItemFuel(this, 1))
            {
                sendUpdate = true;
            }

            //add liquid fuel
            TileEntityHelper.decrLiquidFuel(this);

            //inventory mode 0:ADD 1:RELEASE
            if (this.invMode == 0)
            {
                //RECYCLE MODE
                for (int i = SLOTS_OUT + 1; i < SLOTS_NUM; i++)
                {
                    ItemStack item = itemHandler.getStackInSlot(i);

                    //add material
                    if (LargeRecipes.addMaterialStock(this, item))
                    {
                        item.shrink(1);

                        if (item.isEmpty())
                        {
                            itemHandler.setStackInSlot(i, ItemStack.EMPTY);
                        }

                        sendUpdate = true;
                        break;      //one material per tick
                    }
                }
            }
            else
            {
                //RELEASE MODE
                int compressNum = 9;    //output block
                int normalNum = 1;      //output single item

                if (ShinColleConfig.easyMode)
                {
                    compressNum = 90;
                    normalNum = 10;
                }

                //compressed form
                if (getMatStock(this.selectMat) >= compressNum)
                {
                    if (LargeRecipes.outputMaterialToSlot(this, this.selectMat, true))
                    {
                        this.addMatStock(this.selectMat, -compressNum);
                        sendUpdate = true;
                    }
                }
                //single item form
                else if (getMatStock(this.selectMat) >= normalNum)
                {
                    if (LargeRecipes.outputMaterialToSlot(this, this.selectMat, false))
                    {
                        this.addMatStock(this.selectMat, -normalNum);
                        sendUpdate = true;
                    }
                }
            }

            //is building: progress++
            if (this.isBuilding())
            {
                this.syncTime++;
                this.powerRemained -= this.buildSpeed;  //fuel bar --
                this.powerConsumed += this.buildSpeed;  //build bar ++

                //instant build material
                for (int i = SLOTS_OUT + 1; i < SLOTS_NUM; i++)
                {
                    ItemStack item = itemHandler.getStackInSlot(i);

                    if (!item.isEmpty() &&
                        item.getItem() == ModItems.INSTANT_CON_MAT.get())
                    {
                        item.shrink(1);
                        this.powerConsumed += this.powerInst;

                        if (item.isEmpty())
                        {
                            itemHandler.setStackInSlot(i, ItemStack.EMPTY);
                        }

                        sendUpdate = true;
                        break;
                    }
                }

                //build complete
                if (this.powerConsumed >= this.powerGoal)
                {
                    this.buildComplete();
                    this.powerConsumed = 0;
                    this.powerGoal = 0;

                    //continue build if loop mode
                    switch (this.buildType)
                    {
                    default:
                    case ID.Build.SHIP:
                    case ID.Build.EQUIP:
                        this.buildType = ID.Build.NONE;
                        this.setMatBuild(new int[] {0, 0, 0, 0});
                    break;
                    case ID.Build.SHIP_LOOP:
                    case ID.Build.EQUIP_LOOP:
                        this.setRepeatBuild();
                    break;
                    }

                    sendUpdate = true;
                }
            }

            //not building: reset build bar
            if (!this.canBuild())
            {
                this.powerConsumed = 0;
            }

            //state changed
            if (this.isActive != this.isBuilding())
            {
                this.isActive = this.isBuilding();
                sendUpdate = true;
            }

            //need update
            if (sendUpdate)
            {
                this.syncTime = 0;
                //update blockstate & send packet
                com.lulan.shincolle.block.BasicBlockMulti.updateBlockState(
                    this.isBuilding() ? 2 : 1, this.level, this.worldPosition);
                this.setChanged();
                this.sendSyncPacket();
            }

            //force update every 12000 ticks if no update
            if (this.syncTime > 12000)
            {
                this.syncTime = 0;
                this.sendSyncPacket();
            }
        }//end server side
        //client side
        else
        {
            //valid tile
            if (!this.level.getBlockState(this.worldPosition)
                    .is(ModBlocks.BLOCK_GRUDGE_HEAVY.get()))
            {
                this.level.removeBlockEntity(this.worldPosition);
                return;
            }
        }
    }

    //set materials for repeat build
    public void setRepeatBuild()
    {
        for (int i = 0; i < 4; i++)
        {
            //has enough materials
            if (getMatStock(i) >= getMatBuild(i))
            {
                addMatStock(i, -getMatBuild(i));
            }
            //no materials, reset matsBuild
            else
            {
                setMatBuild(i, 0);
                this.buildType = ID.Build.NONE;
            }
        }
    }

    /* ==================== GUI values ==================== */

    public int getPowerRemainingScaled(int i)
    {
        loadConfig();
        return this.powerMax > 0 ? (this.powerRemained * i) / this.powerMax : 0;
    }

    //get remaining build time string
    public String getBuildTimeString()
    {
        loadConfig();
        int timeSec = (int) ((this.powerGoal - this.powerConsumed) /
            this.buildSpeed * 0.05F);
        return CalcHelper.getTimeFormated(timeSec);
    }

    /* ==================== GETTER ==================== */

    public int getPowerConsumed()
    {
        return this.powerConsumed;
    }

    @Override
    public int getPowerRemained()
    {
        return this.powerRemained;
    }

    public int getPowerGoal()
    {
        return this.powerGoal;
    }

    @Override
    public int getPowerMax()
    {
        loadConfig();
        return this.powerMax;
    }

    public int getBuildType()
    {
        return this.buildType;
    }

    public int getInvMode()
    {
        return this.invMode;
    }

    public int getSelectMat()
    {
        return this.selectMat;
    }

    public int[] getMatBuild()
    {
        if (this.matsBuild == null || this.matsBuild.length < 4)
        {
            this.matsBuild = new int[] {0, 0, 0, 0};
        }
        return this.matsBuild;
    }

    public int[] getMatStock()
    {
        if (this.matsStock == null || this.matsStock.length < 4)
        {
            this.matsStock = new int[] {0, 0, 0, 0};
        }
        return this.matsStock;
    }

    public int getMatBuild(int id)
    {
        return this.getMatBuild()[id];
    }

    public int getMatStock(int id)
    {
        return this.getMatStock()[id];
    }

    /* ==================== SETTER ==================== */

    public void setPowerConsumed(int par1)
    {
        this.powerConsumed = par1;
    }

    @Override
    public void setPowerRemained(int par1)
    {
        this.powerRemained = par1;
    }

    public void setPowerGoal(int par1)
    {
        this.powerGoal = par1;
    }

    public void setBuildType(int par1)
    {
        this.buildType = par1;
    }

    public void setInvMode(int par1)
    {
        this.invMode = par1;
    }

    public void setSelectMat(int par1)
    {
        this.selectMat = par1;
    }

    public void setMatBuild(int[] par1)
    {
        if (par1 == null || par1.length < 4)
        {
            this.matsBuild = new int[] {0, 0, 0, 0};
        }
        else
        {
            this.matsBuild = par1;
        }
    }

    public void setMatStock(int[] par1)
    {
        if (par1 == null || par1.length < 4)
        {
            this.matsStock = new int[] {0, 0, 0, 0};
        }
        else
        {
            this.matsStock = par1;
        }
    }

    public void setMatBuild(int id, int par1)
    {
        this.getMatBuild()[id] = par1;
    }

    public void setMatStock(int id, int par1)
    {
        this.getMatStock()[id] = par1;
    }

    public void addMatBuild(int id, int par1)
    {
        this.getMatBuild()[id] += par1;
    }

    public void addMatStock(int id, int par1)
    {
        this.getMatStock()[id] += par1;
    }

    /* ==================== LIQUID FUEL ==================== */

    @Override
    public int getFluidFuelAmount()
    {
        return this.tank.getFluidAmount();
    }

    @Override
    public int consumeFluidFuel(int amount)
    {
        FluidStack fluid = this.tank.drain(amount, IFluidHandler.FluidAction.EXECUTE);
        return fluid.isEmpty() ? 0 : fluid.getAmount();
    }

    @Override
    public float getFuelMagni()
    {
        loadConfig();
        return this.fuelMagn;
    }

    /** fill lava into internal tank (capability wrapper) */
    public int fillLava(FluidStack resource, IFluidHandler.FluidAction action)
    {
        if (!resource.is(Fluids.LAVA)) return 0;
        return this.tank.fill(resource, action);
    }

    /* ==================== MULTIBLOCK ==================== */

    /** GUI opens on the master tile */
    public TileMultiGrudgeHeavy getMasterShipyard()
    {
        BasicMultiBlockEntity m = this.getMaster();
        return m instanceof TileMultiGrudgeHeavy t ? t : null;
    }

    /** hopper/io slots for automation faces (legacy getSlotsForFace) */
    public int[] getSlotsForFace()
    {
        return this.structType == 1 ? ALLSLOTS : new int[] {};
    }

    /** block break check: can this stack be extracted by automation */
    public boolean canExtractItem(int slot, ItemStack stack)
    {
        //output slot or release mode
        if (slot == SLOTS_OUT || this.invMode == 1) return true;
        if (stack == null || stack.isEmpty()) return false;

        //fluid container: empty container always extracted
        if (TileEntityHelper.isFluidContainer(stack))
        {
            var fh = stack.getCapability(Capabilities.FluidHandler.ITEM);
            if (fh != null)
            {
                FluidStack f = fh.drain(new FluidStack(Fluids.LAVA, 1000),
                    IFluidHandler.FluidAction.SIMULATE);
                if (f.isEmpty() || f.getAmount() < 1000) return true;
            }
            return false;
        }

        //special items never extracted
        if (stack.getItem() == ModItems.INSTANT_CON_MAT.get() ||
            stack.getItem() instanceof com.lulan.shincolle.item.ShipSpawnEgg ||
            stack.getItem() instanceof BasicEquip ||
            TileEntityHelper.getItemFuelValue(stack) > 0) return false;

        return this.invMode != 0;
    }

    /** render bounding box (used by the large shipyard BER) */
    public net.minecraft.world.phys.AABB getRenderBoundingBox()
    {
        BlockPos pos = this.getBlockPos();
        return new net.minecraft.world.phys.AABB(
            net.minecraft.world.phys.Vec3.atLowerCornerOf(pos.offset(-2, -3, -2)),
            net.minecraft.world.phys.Vec3.atLowerCornerOf(pos.offset(3, 3, 3)));
    }


}

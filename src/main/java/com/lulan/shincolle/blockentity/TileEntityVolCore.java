package com.lulan.shincolle.blockentity;

import java.util.List;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.entity.BasicEntityAirplane;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.registry.ModBlockEntities;
import com.lulan.shincolle.registry.ModBlocks;
import com.lulan.shincolle.registry.ModItems;
import com.lulan.shincolle.utility.BlockHelper;
import com.lulan.shincolle.utility.EntityHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

/** Fuel Cost = BaseCost + CostPerMaterial * ( TotalMaterialAmount - minAmount * 4 )
 *  Total Build Time = FuelCost / buildSpeed
 *  MaxBuildTime / MaxFuelCost = 8min / 460800  (48 fuel per tick)
 *  MinBuildTime / MinFuelCost = 1min / 57600
 *  MaxMaterial / MaxFuelCost = 64*4 / 460800
 *  MinMaterial / MinFuelCost = 16*4 / 57600 = BaseCost(57600) CostPerMaterial(2100)
 *
 *  port of legacy TileEntityVolCore.
 */
public class TileEntityVolCore extends BasicBlockEntity
{

    private final RandomSource rand = RandomSource.create();
    private boolean canWork;            //fuel is enough to run
    private int remainedPower = 0;      //fuel reserve
    private int syncTime = 0;

    //config values (read lazily: config may not be loaded at ctor time)
    private int powerMax = -1;
    private int consumeSpeed;
    private int fuelMagn;


    public TileEntityVolCore(BlockPos pos, BlockState state)
    {
        //0~8: fuel slots
        super(ModBlockEntities.TILEENTITYVOLCORE.get(), pos, state, 9);
        this.fields = new int[1];
    }

    private void loadConfig()
    {
        if (this.powerMax >= 0) return;
        this.powerMax = (int) ShinColleConfig.tileVolCore[0];
        this.consumeSpeed = (int) ShinColleConfig.tileVolCore[1];
        this.fuelMagn = (int) ShinColleConfig.tileVolCore[2];
    }

    /** slot 0~8 accept grudge fuel only */
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        if (stack == null || stack.isEmpty()) return false;
        Item item = stack.getItem();
        return item == ModItems.GRUDGE.get() ||
               item == ModBlocks.ITEM_GRUDGE.get();
    }

    /* ==================== NBT ==================== */

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.saveAdditional(tag, registries);
        tag.putInt("power", this.remainedPower);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.loadAdditional(tag, registries);
        this.remainedPower = tag.getInt("power");
    }

    /* ==================== TICK ==================== */

    @Override
    public void tick()
    {
        loadConfig();
        this.syncTime++;

        //server side
        if (!this.level.isClientSide())
        {
            boolean checkActive = this.isWorking();

            //check every 16 ticks
            if (this.syncTime % 16 == 0)
            {
                //fuel enough -> can work
                this.canWork = this.remainedPower >= this.consumeSpeed;

                //fuel--
                if (this.isWorking()) this.remainedPower -= this.consumeSpeed;

                //check every 32 ticks
                if (this.syncTime % 32 == 0)
                {
                    //add item fuel
                    decrItemFuel();

                    if (this.isWorking())
                    {
                        volcoreFunction();
                    }

                    //check every 256 ticks
                    if (this.syncTime % 256 == 0 && this.isWorking())
                    {
                        double dx = this.worldPosition.getX() + 0.5D;
                        double dy = this.worldPosition.getY() + 2.5D;
                        double dz = this.worldPosition.getZ() + 0.5D;
                        int emotes = switch (this.rand.nextInt(5))
                        {
                            case 0 -> 2;    //panic
                            case 1 -> 30;   //pif
                            case 2 -> 10;   //spin
                            default -> 27;  //-w-
                        };

                        AABB box = new AABB(dx - 6D, dy - 6D, dz - 6D,
                            dx + 6D, dy + 6D, dz + 6D);
                        List<BasicEntityShip> slist = this.level
                            .getEntitiesOfClass(BasicEntityShip.class, box);

                        EntityHelper.applyEmotesAOE(slist, emotes);
                    }
                }
            }

            //need sync
            if (checkActive != this.isWorking())
            {
                this.sendSyncPacket();
            }
        }
        //client side
        else
        {
            //valid tile
            if (!this.level.getBlockState(this.worldPosition)
                    .is(ModBlocks.BLOCK_VOL_CORE.get()))
            {
                return;
            }

            //spawn bubble particle
            if ((this.syncTime & 15) == 0 &&
                this.remainedPower > this.consumeSpeed && this.getField(0) != 0)
            {
                int maxpar = 25;

                for (int i = 0; i < maxpar; i++)
                {
                    double dx = this.worldPosition.getX() + 0.5D +
                        this.rand.nextFloat() * 13F - 6.5F;
                    double dy = this.worldPosition.getY() + 1.5D +
                        this.rand.nextFloat() * 13F - 4.5F;
                    double dz = this.worldPosition.getZ() + 0.5D +
                        this.rand.nextFloat() * 13F - 6.5F;

                    this.level.addParticle(ParticleTypes.BUBBLE_COLUMN_UP,
                        dx, dy, dz, 0D, 0.05D, 0D);
                }
            }
        }
    }

    /** consume fuel item, return true = add fuel success */
    public boolean decrItemFuel()
    {
        if (this.itemHandler == null) return false;
        boolean sendUpdate = false;

        for (int i = 0; i < this.itemHandler.getSlots(); i++)
        {
            ItemStack stack = this.itemHandler.getStackInSlot(i);
            if (stack.isEmpty()) continue;

            Item item = stack.getItem();
            int fuelx = 0;

            if (item == ModItems.GRUDGE.get())
            {
                fuelx = this.fuelMagn;
            }
            else if (item == ModBlocks.ITEM_GRUDGE.get())
            {
                fuelx = this.fuelMagn * 9;
            }

            //add disposable fuel
            if (fuelx > 0 && fuelx + this.remainedPower < this.powerMax)
            {
                ItemStack container = stack.getCraftingRemainingItem();
                stack.shrink(1);
                this.remainedPower += fuelx;

                if (stack.isEmpty())
                {
                    stack = container;
                }

                this.itemHandler.setStackInSlot(i, stack);
                sendUpdate = true;
                break;  //only consume 1 fuel every tick
            }
        }

        return sendUpdate;
    }

    public boolean isWorking()
    {
        return this.canWork && this.getField(0) != 0;
    }

    /**
     * restore morale/HP or ignite nearby entity, SERVER SIDE ONLY.
     * no owner checking on ship, all ships in range get the buff.
     */
    private void volcoreFunction()
    {
        double dx = this.worldPosition.getX() + 0.5D;
        double dy = this.worldPosition.getY() + 0.5D;
        double dz = this.worldPosition.getZ() + 0.5D;
        AABB box = new AABB(dx - 6D, dy - 6D, dz - 6D,
            dx + 6D, dy + 6D, dz + 6D);

        //check nearby water block, start to function
        if (BlockHelper.checkBlockNearbyIsLiquid(this.level,
            this.worldPosition, 1))
        {
            List<BasicEntityShip> slist =
                this.level.getEntitiesOfClass(BasicEntityShip.class, box);

            for (BasicEntityShip s : slist)
            {
                //check ship is out of combat and in liquid
                if (EntityHelper.checkShipOutOfCombat(s) &&
                    EntityHelper.checkEntityIsInLiquid(s))
                {
                    if (s.getHealth() < s.getMaxHealth())
                    {
                        s.heal(s.getMaxHealth() * 0.01F + 4F);
                    }

                    if (s.getMorale() < (int) (ID.Morale.L_Excited * 1.8F))
                    {
                        s.addMorale(80);
                    }
                }
            }
        }
        //no water, ignite nearby entity
        else
        {
            List<LivingEntity> slist =
                this.level.getEntitiesOfClass(LivingEntity.class, box);

            for (LivingEntity ent : slist)
            {
                if (ent instanceof BasicEntityShip ||
                    ent instanceof BasicEntityMount ||
                    ent instanceof BasicEntityAirplane ||
                    ent instanceof BasicEntityShipHostile)
                {
                    //ship immune fire, return
                    return;
                }
                else
                {
                    ent.igniteForSeconds(2F);
                    ent.hurt(this.level.damageSources().inFire(), 4F);

                    int emotes = switch (this.rand.nextInt(5))
                    {
                        case 0 -> 12;   //omg
                        case 1 -> 28;   //-o-
                        case 2 -> 0;    //drop
                        default -> 2;   //panic
                    };

                    EntityHelper.applyEmotesAOE(java.util.List.of(ent), emotes);
                }
            }
        }
    }

    /* ==================== GUI values ==================== */

    public int getPowerRemainingScaled(int i)
    {
        loadConfig();
        return this.powerMax > 0 ? (this.remainedPower * i) / this.powerMax : 0;
    }

    public int getPowerRemained()
    {
        return this.remainedPower;
    }

    public void setPowerRemained(int par1)
    {
        this.remainedPower = par1;
    }

    public int getPowerMax()
    {
        loadConfig();
        return this.powerMax;
    }

    public int getPowerConsumed()
    {
        loadConfig();
        return this.consumeSpeed;
    }


}

package com.lulan.shincolle.crafting;

import java.util.Random;

import com.lulan.shincolle.blockentity.TileMultiGrudgeHeavy;
import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.item.BasicEquip;
import com.lulan.shincolle.item.ShipSpawnEgg;
import com.lulan.shincolle.registry.ModBlocks;
import com.lulan.shincolle.registry.ModComponents;
import com.lulan.shincolle.registry.ModItems;
import com.lulan.shincolle.utility.TileEntityHelper;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

/** Large Shipyard Recipe Helper (legacy LargeRecipes).
 *  Fuel Cost = BaseCost + CostPerMaterial * ( TotalMaterialAmount - minAmount * 4 )
 *  Total Build Time = FuelCost / buildSpeed
 *  MaxBuildTime / MaxFuelCost = 24min / 1382400  (48 fuel per tick)
 *  MinBuildTime / MinFuelCost = 8min / 460800
 *  MaxMaterial / MaxFuelCost = 1000*4 / 1382400
 *  MinMaterial / MinFuelCost = 100*4 / 460800 = BaseCost(460800) CostPerMaterial(256)
 */
public class LargeRecipes
{

    private static final Random rand = new Random();
    private static final int MIN_AMOUNT = 100;      //material min amount
    private static final int MAX_STOCK = 1000000;   //max amount in stock
    private static final int BASE_POWER = 460800;   //base cost power
    private static final int POWER_PER_MAT = 256;   //cost per item


    private LargeRecipes() {}

    //check materials are enough to build
    public static boolean canRecipeBuild(int[] matAmount)
    {
        return matAmount[0] >= MIN_AMOUNT && matAmount[1] >= MIN_AMOUNT &&
               matAmount[2] >= MIN_AMOUNT && matAmount[3] >= MIN_AMOUNT;
    }

    //total fuel cost
    public static int calcGoalPower(int[] matAmount)
    {
        if (canRecipeBuild(matAmount))
        {
            int extraAmount = matAmount[0] + matAmount[1] + matAmount[2] +
                matAmount[3] - MIN_AMOUNT * 4;
            return BASE_POWER + POWER_PER_MAT * extraAmount;
        }

        return 0;
    }

    //add or set item to slot
    private static void addSlotContents(TileMultiGrudgeHeavy tile, Item item, int slot)
    {
        ItemStack cur = tile.getItemHandler().getStackInSlot(slot);
        if (cur.isEmpty())
        {
            tile.getItemHandler().setStackInSlot(slot, new ItemStack(item, 1));
        }
        else
        {
            cur.grow(1);
            tile.getItemHandler().setStackInSlot(slot, cur);
        }
    }

    //get fit or empty slot with item
    private static int getFitSlot(TileMultiGrudgeHeavy tile, Item item)
    {
        //search slot 1~9
        for (int i = TileMultiGrudgeHeavy.SLOTS_OUT + 1;
             i < TileMultiGrudgeHeavy.SLOTS_NUM; i++)
        {
            ItemStack cur = tile.getItemHandler().getStackInSlot(i);
            if (cur.isEmpty() ||
                (cur.is(item) && cur.getCount() < cur.getMaxStackSize()))
            {
                return i;
            }
        }
        return -1;
    }

    //output material to slots
    public static boolean outputMaterialToSlot(TileMultiGrudgeHeavy tile,
            int selectMat, boolean compress)
    {
        Item matchItem = null;

        if (compress)
        {   //compressed: blocks / containers
            switch (selectMat)
            {
            case 0: matchItem = ModBlocks.ITEM_GRUDGE.get(); break;
            case 1: matchItem = ModBlocks.ITEM_ABYSSIUM.get(); break;
            case 2: matchItem = ModItems.AMMO_1.get(); break;      //light ammo container
            case 3: matchItem = ModBlocks.ITEM_POLYMETAL.get(); break;
            }
        }
        else
        {   //single items
            switch (selectMat)
            {
            case 0: matchItem = ModItems.GRUDGE.get(); break;
            case 1: matchItem = ModItems.ABYSS_METAL.get(); break;
            case 2: matchItem = ModItems.AMMO.get(); break;
            case 3: matchItem = ModItems.ABYSS_METAL_1.get(); break;
            }
        }

        if (matchItem != null)
        {
            int slot = getFitSlot(tile, matchItem);
            if (slot > -1)
            {
                addSlotContents(tile, matchItem, slot);
                return true;
            }
        }

        return false;
    }

    /**
     * resource value of an item stack: int[4] = grudge/abyssium/ammo/poly.
     * (legacy IShipResourceItem per-item getResourceValue tables)
     */
    public static int[] getResourceValue(ItemStack stack)
    {
        if (stack == null || stack.isEmpty()) return null;
        Item item = stack.getItem();

        if (item == ModItems.GRUDGE.get())
            return new int[] {1, 0, 0, 0};
        if (item == ModBlocks.ITEM_GRUDGE.get())
            return new int[] {9, 0, 0, 0};
        if (item == ModItems.ABYSS_METAL.get())
            return new int[] {0, 1, 0, 0};
        if (item == ModItems.ABYSS_METAL_1.get())
            return new int[] {0, 0, 0, 1};
        if (item == ModBlocks.ITEM_ABYSSIUM.get())
            return new int[] {0, 9, 0, 0};
        if (item == ModBlocks.ITEM_POLYMETAL.get())
            return new int[] {0, 0, 0, 9};
        if (item == ModBlocks.ITEM_POLYMETAL_GRAVEL.get())
            return new int[] {0, 0, 0, 4};
        if (item == ModBlocks.ITEM_GRUDGE_HEAVY_DECO.get())
            return new int[] {18, 0, 0, 0};
        if (item == ModItems.AMMO.get())
            return new int[] {0, 0, 1, 0};
        if (item == ModItems.AMMO_1.get())
            return new int[] {0, 0, 9, 0};
        if (item == ModItems.AMMO_2.get())
            return new int[] {0, 0, 4, 0};
        if (item == ModItems.AMMO_3.get())
            return new int[] {0, 0, 36, 0};

        //equips: resource value by equip type (legacy per-item tables)
        if (item instanceof BasicEquip equip)
        {
            return getEquipResourceValue(equip.getEquipTypeID());
        }

        return null;
    }

    /** equip resource values by equip type id (legacy per-equip tables) */
    private static int[] getEquipResourceValue(int equipType)
    {
        return switch (equipType)
        {
        case com.lulan.shincolle.reference.ID.EquipType.AIR_T_LO,
             com.lulan.shincolle.reference.ID.EquipType.AIR_F_LO,
             com.lulan.shincolle.reference.ID.EquipType.AIR_B_LO ->
            new int[] {rand.nextInt(20) + 80, rand.nextInt(30) + 100,
                       rand.nextInt(40) + 120, rand.nextInt(50) + 150};
        case com.lulan.shincolle.reference.ID.EquipType.AIR_T_HI,
             com.lulan.shincolle.reference.ID.EquipType.AIR_F_HI,
             com.lulan.shincolle.reference.ID.EquipType.AIR_B_HI ->
            new int[] {rand.nextInt(50) + 130, rand.nextInt(60) + 170,
                       rand.nextInt(70) + 210, rand.nextInt(75) + 230};
        case com.lulan.shincolle.reference.ID.EquipType.AIR_R_LO ->
            new int[] {rand.nextInt(12) + 3, rand.nextInt(14) + 5,
                       rand.nextInt(14) + 5, rand.nextInt(16) + 11};
        case com.lulan.shincolle.reference.ID.EquipType.AIR_R_HI ->
            new int[] {rand.nextInt(10) + 40, rand.nextInt(15) + 50,
                       rand.nextInt(20) + 60, rand.nextInt(25) + 80};
        case com.lulan.shincolle.reference.ID.EquipType.AMMO_LO ->
            new int[] {rand.nextInt(3) + 4, rand.nextInt(4) + 7,
                       rand.nextInt(5) + 9, rand.nextInt(2) + 4};
        case com.lulan.shincolle.reference.ID.EquipType.AMMO_HI ->
            new int[] {rand.nextInt(25) + 35, rand.nextInt(30) + 45,
                       rand.nextInt(40) + 70, rand.nextInt(20) + 40};
        case com.lulan.shincolle.reference.ID.EquipType.ARMOR_LO ->
            new int[] {rand.nextInt(3) + 3, rand.nextInt(4) + 4,
                       rand.nextInt(2) + 2, rand.nextInt(2) + 2};
        case com.lulan.shincolle.reference.ID.EquipType.ARMOR_HI ->
            new int[] {rand.nextInt(15) + 35, rand.nextInt(20) + 45,
                       rand.nextInt(10) + 25, rand.nextInt(5) + 15};
        case com.lulan.shincolle.reference.ID.EquipType.CANNON_SI ->
            new int[] {rand.nextInt(4) + 5, rand.nextInt(4) + 5,
                       rand.nextInt(5) + 11, rand.nextInt(3) + 3};
        case com.lulan.shincolle.reference.ID.EquipType.CANNON_TW_LO ->
            new int[] {rand.nextInt(7) + 10, rand.nextInt(7) + 10,
                       rand.nextInt(8) + 16, rand.nextInt(6) + 6};
        case com.lulan.shincolle.reference.ID.EquipType.CANNON_TW_HI ->
            new int[] {rand.nextInt(10) + 50, rand.nextInt(15) + 70,
                       rand.nextInt(35) + 90, rand.nextInt(20) + 80};
        case com.lulan.shincolle.reference.ID.EquipType.CANNON_TR ->
            new int[] {rand.nextInt(60) + 170, rand.nextInt(70) + 210,
                       rand.nextInt(80) + 250, rand.nextInt(50) + 130};
        case com.lulan.shincolle.reference.ID.EquipType.CATAPULT_LO ->
            new int[] {rand.nextInt(40) + 120, rand.nextInt(50) + 150,
                       rand.nextInt(30) + 80, rand.nextInt(60) + 180};
        case com.lulan.shincolle.reference.ID.EquipType.CATAPULT_HI ->
            new int[] {rand.nextInt(70) + 190, rand.nextInt(85) + 230,
                       rand.nextInt(55) + 150, rand.nextInt(90) + 250};
        case com.lulan.shincolle.reference.ID.EquipType.COMPASS_LO ->
            new int[] {rand.nextInt(5) + 5, rand.nextInt(3) + 4,
                       rand.nextInt(2) + 2, rand.nextInt(2) + 2};
        case com.lulan.shincolle.reference.ID.EquipType.DRUM_LO ->
            new int[] {rand.nextInt(4) + 5, rand.nextInt(5) + 9,
                       rand.nextInt(4) + 4, rand.nextInt(3) + 3};
        case com.lulan.shincolle.reference.ID.EquipType.FLARE_LO ->
            new int[] {rand.nextInt(2) + 2, rand.nextInt(3) + 3,
                       rand.nextInt(4) + 4, rand.nextInt(2) + 2};
        case com.lulan.shincolle.reference.ID.EquipType.GUN_LO ->
            new int[] {rand.nextInt(3) + 4, rand.nextInt(4) + 7,
                       rand.nextInt(5) + 8, rand.nextInt(2) + 4};
        case com.lulan.shincolle.reference.ID.EquipType.GUN_HI ->
            new int[] {rand.nextInt(20) + 30, rand.nextInt(25) + 40,
                       rand.nextInt(30) + 50, rand.nextInt(15) + 20};
        case com.lulan.shincolle.reference.ID.EquipType.RADAR_LO ->
            new int[] {rand.nextInt(7) + 12, rand.nextInt(6) + 10,
                       rand.nextInt(5) + 9, rand.nextInt(4) + 7};
        case com.lulan.shincolle.reference.ID.EquipType.RADAR_HI ->
            new int[] {rand.nextInt(40) + 110, rand.nextInt(35) + 90,
                       rand.nextInt(30) + 70, rand.nextInt(25) + 50};
        case com.lulan.shincolle.reference.ID.EquipType.SEARCHLIGHT_LO ->
            new int[] {rand.nextInt(4) + 4, rand.nextInt(3) + 3,
                       rand.nextInt(2) + 2, rand.nextInt(2) + 2};
        case com.lulan.shincolle.reference.ID.EquipType.TORPEDO_LO ->
            new int[] {rand.nextInt(4) + 8, rand.nextInt(5) + 8,
                       rand.nextInt(6) + 12, rand.nextInt(4) + 5};
        case com.lulan.shincolle.reference.ID.EquipType.TORPEDO_HI ->
            new int[] {rand.nextInt(20) + 60, rand.nextInt(25) + 70,
                       rand.nextInt(30) + 80, rand.nextInt(15) + 45};
        case com.lulan.shincolle.reference.ID.EquipType.TURBINE_LO ->
            new int[] {rand.nextInt(35) + 90, rand.nextInt(25) + 80,
                       rand.nextInt(15) + 45, rand.nextInt(20) + 60};
        case com.lulan.shincolle.reference.ID.EquipType.TURBINE_HI ->
            new int[] {rand.nextInt(70) + 200, rand.nextInt(55) + 170,
                       rand.nextInt(25) + 90, rand.nextInt(40) + 130};
        default -> null;
        };
    }

    //add materials to matsStock
    public static boolean addMaterialStock(TileMultiGrudgeHeavy tile,
            ItemStack stack)
    {
        if (stack == null || stack.isEmpty()) return false;

        try
        {
            //check MAX amount
            for (int j = 0; j < 4; ++j)
            {
                if (tile.getMatStock(j) > MAX_STOCK) return false;
            }

            //is resource item
            int[] addMats = getResourceValue(stack);
            if (addMats != null)
            {
                if (ShinColleConfig.easyMode)
                {
                    for (int i = 0; i < 4; i++) addMats[i] *= 10;
                }

                for (int k = 0; k < 4; k++)
                {
                    tile.addMatStock(k, addMats[k]);
                }

                return true;
            }
            //is ship spawn egg
            else if (stack.getItem() instanceof ShipSpawnEgg)
            {
                //get ship recycle items
                int meta = stack.getOrDefault(
                    ModComponents.SHIP_CLASS.get(), 0);
                ItemStack[] items = ShipCalc.getKaitaiItems(meta - 2);

                for (ItemStack i : items)
                {
                    if (i != null && !i.isEmpty())
                    {
                        int size = i.getCount();
                        int[] kaitai = getResourceValue(i);
                        if (kaitai == null) return false;

                        int[] mats = new int[] {
                            kaitai[0] * size, kaitai[1] * size,
                            kaitai[2] * size, kaitai[3] * size};

                        if (ShinColleConfig.easyMode)
                        {
                            for (int j = 0; j < 4; j++) mats[j] *= 10;
                        }

                        for (int k = 0; k < 4; k++)
                        {
                            tile.addMatStock(k, mats[k]);
                        }
                    }
                    else
                    {
                        //invalid ship id
                        return false;
                    }
                }

                return true;
            }
            //is heavy grudge block
            else if (stack.is(ModBlocks.ITEM_GRUDGE_HEAVY.get()))
            {
                int[] addMats2 = new int[] {81, 0, 0, 0};

                CustomData data = stack.get(ModComponents.SHIP_DATA.get());
                if (data != null)
                {
                    int[] mats = data.copyTag().getIntArray("mats");
                    addMats2[0] = 81 + mats[0];
                    addMats2[1] = mats[1];
                    addMats2[2] = mats[2];
                    addMats2[3] = mats[3];
                }

                if (ShinColleConfig.easyMode)
                {
                    for (int i = 0; i < 4; i++) addMats2[i] *= 10;
                }

                for (int k = 0; k < 4; k++)
                {
                    tile.addMatStock(k, addMats2[k]);
                }

                return true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    /** ship egg with material record (meta 1 = large ship) */
    public static ItemStack getBuildResultShip(int[] matAmount)
    {
        ItemStack buildResult = new ItemStack(ModItems.SHIP_SPAWN_EGG.get());
        buildResult.set(ModComponents.SHIP_CLASS.get(), 1);

        CompoundTag tag = new CompoundTag();
        tag.putInt("Grudge", matAmount[0]);
        tag.putInt("Abyssium", matAmount[1]);
        tag.putInt("Ammo", matAmount[2]);
        tag.putInt("Polymetal", matAmount[3]);
        buildResult.set(ModComponents.SHIP_DATA.get(), CustomData.of(tag));

        return buildResult;
    }

    /** ROLL: equip type then equip of the type */
    public static ItemStack getBuildResultEquip(int[] matAmount,
            HolderLookup.Provider registries)
    {
        int totalMats = matAmount[0] + matAmount[1] + matAmount[2] + matAmount[3];

        int rollType = EquipCalc.rollEquipType(1, matAmount);
        return EquipCalc.rollEquipsOfTheType(rollType, totalMats, 1, registries);
    }


}

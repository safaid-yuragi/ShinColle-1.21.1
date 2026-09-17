package com.lulan.shincolle.crafting;

import java.util.Random;

import com.lulan.shincolle.registry.ModBlocks;
import com.lulan.shincolle.registry.ModComponents;
import com.lulan.shincolle.registry.ModItems;
import com.lulan.shincolle.utility.LogHelper;
import com.lulan.shincolle.utility.TileEntityHelper;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

/**Small Shipyard Recipe Helper (legacy SmallRecipes).
 *  Fuel Cost = BaseCost + CostPerMaterial * ( TotalMaterialAmount - minAmount * 4 )
 *  Total Build Time = FuelCost / buildSpeed
 *  MaxBuildTime / MaxFuelCost = 8min / 460800  (48 fuel per tick)
 *  MinBuildTime / MinFuelCost = 1min / 57600
 *  MaxMaterial / MaxFuelCost = 64*4 / 460800
 *  MinMaterial / MinFuelCost = 16*4 / 57600 = BaseCost(57600) CostPerMaterial(2100)
 *
 * Equip Build Rate: first roll -> second roll -> third roll
 *   1. FIRST: roll ammo or equip
 *      ammo rate: total 64 (16x4) = 50%, total 128 = 0%
 *      equip rate: 1 - ammo
 *   2. SECOND: if equip, roll equip type; if ammo, roll ammo type and quantity
 *   3. THIRD: roll equips of the type
 */
public class SmallRecipes
{

    private static final Random rand = new Random();
    public static final int MIN_AMOUNT = 16;        //material min amount
    private static final int BASE_POWER = 57600;    //base cost power
    private static final int POWER_PER_MAT = 2100;  //cost per item


    private SmallRecipes() {}

    //check materials are enough to build
    public static boolean canRecipeBuild(int[] matAmount)
    {
        return matAmount[0] >= MIN_AMOUNT &&
               matAmount[1] >= MIN_AMOUNT &&
               matAmount[2] >= MIN_AMOUNT &&
               matAmount[3] >= MIN_AMOUNT;
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

    /** is building material */
    public static boolean isMaterial(ItemStack itemstack)
    {
        return getMaterialSlotId(itemstack) >= 0 && getMaterialSlotId(itemstack) <= 3;
    }

    /**
     * material type: 0:grudge 1:abyssium 2:ammo 3:poly 4:fuel -1:other
     * (legacy meta values are separate items now:
     *  AbyssMetal meta0 -> ABYSS_METAL, meta1 -> ABYSS_METAL_1,
     *  Ammo meta0 -> AMMO)
     */
    public static int getMaterialType(ItemStack itemstack)
    {
        if (itemstack == null || itemstack.isEmpty()) return -1;
        Item item = itemstack.getItem();

        if (item == ModItems.GRUDGE.get()) return 0;
        if (item == ModItems.ABYSS_METAL.get()) return 1;
        if (item == ModItems.AMMO.get()) return 2;
        if (item == ModItems.ABYSS_METAL_1.get()) return 3;
        if (TileEntityHelper.getItemFuelValue(itemstack) > 0) return 4;
        if (item == ModItems.INSTANT_CON_MAT.get()) return 4;

        return -1;
    }

    /** slot id for the material (0~3), -1 when not a material */
    private static int getMaterialSlotId(ItemStack itemstack)
    {
        int type = getMaterialType(itemstack);
        return type <= 3 ? type : -1;
    }

    /** material amounts of slots 0~3 with null check */
    public static int[] getMaterialAmount(
        net.neoforged.neoforge.items.IItemHandler handler)
    {
        int[] itemAmount = new int[4];

        for (int i = 0; i < 4; i++)
        {
            ItemStack s = handler.getStackInSlot(i);
            itemAmount[i] = s.isEmpty() ? 0 : s.getCount();
        }

        return itemAmount;
    }

    /** ship egg with material record (legacy ShipSpawnEgg meta 0 + NBT) */
    public static ItemStack getBuildResultShip(int[] matAmount)
    {
        ItemStack buildResult = new ItemStack(ModItems.SHIP_SPAWN_EGG.get());

        CompoundTag tag = new CompoundTag();
        tag.putInt("Grudge", matAmount[0]);
        tag.putInt("Abyssium", matAmount[1]);
        tag.putInt("Ammo", matAmount[2]);
        tag.putInt("Polymetal", matAmount[3]);
        buildResult.set(ModComponents.SHIP_DATA.get(),
            CustomData.of(tag));

        return buildResult;
    }

    /**
     * ROLL SYSTEM
     *  1. roll junk or equips
     *  2. roll equip type by mat.amounts
     *  3. roll equip by equip type and mat.amounts
     */
    public static ItemStack getBuildResultEquip(int[] matAmount,
            HolderLookup.Provider registries)
    {
        int totalMats = matAmount[0] + matAmount[1] + matAmount[2] + matAmount[3];
        float equipRate = totalMats / 128F;     //if total mats < 128, could get ammo
        float randRate = rand.nextFloat();

        if (equipRate > 1F) equipRate = 1F;
        LogHelper.debug("DEBUG : equip build roll: rate / random " +
            String.format("%.2f", equipRate) + " " + String.format("%.2f", randRate));

        //first roll: equip or ammo
        if (randRate < equipRate)
        {
            //second roll: equip type
            int rollType = EquipCalc.rollEquipType(0, matAmount);

            //third roll: equip of the type
            return EquipCalc.rollEquipsOfTheType(rollType, totalMats, 0,
                registries);
        }
        else
        {
            //second roll: ammo type and quantity
            //50% for light or heavy ammo container
            if (rand.nextInt(2) == 0)
            {   //light ammo container (legacy Ammo meta 1)
                return new ItemStack(ModItems.AMMO_1.get(),
                    11 + rand.nextInt(11));
            }
            else
            {   //heavy ammo container (legacy Ammo meta 3)
                return new ItemStack(ModItems.AMMO_3.get(),
                    2 + rand.nextInt(2));
            }
        }
    }


}

package com.lulan.shincolle.crafting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.lulan.shincolle.item.BasicEquip;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.registry.ModItems;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.EnchantHelper;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * equip build roll system (legacy EquipCalc roll methods).
 *
 * Equips are separate items now: {@link BasicEquip#getEquipID()} =
 * equipType + subId * 100, matching legacy EquipType*100 + meta.
 */
public class EquipCalc
{

    private static final Random rand = new Random();

    /** roll table: {equip type, material mean, modified material type} */
    private static final List<int[]> EQUIP_SMALL = new ArrayList<>();
    private static final List<int[]> EQUIP_LARGE = new ArrayList<>();

    static
    {
        //small build
        EQUIP_SMALL.add(new int[] {ID.EquipType.ARMOR_LO,      80,   1});
        EQUIP_SMALL.add(new int[] {ID.EquipType.FLARE_LO,      80,   2});
        EQUIP_SMALL.add(new int[] {ID.EquipType.SEARCHLIGHT_LO,80,   0});
        EQUIP_SMALL.add(new int[] {ID.EquipType.COMPASS_LO,    90,   0});
        EQUIP_SMALL.add(new int[] {ID.EquipType.GUN_LO,        100,  2});
        EQUIP_SMALL.add(new int[] {ID.EquipType.DRUM_LO,       120,  1});
        EQUIP_SMALL.add(new int[] {ID.EquipType.AMMO_LO,       120,  2});
        EQUIP_SMALL.add(new int[] {ID.EquipType.CANNON_SI,     128,  2});
        EQUIP_SMALL.add(new int[] {ID.EquipType.TORPEDO_LO,    160,  2});
        EQUIP_SMALL.add(new int[] {ID.EquipType.RADAR_LO,      200,  0});
        EQUIP_SMALL.add(new int[] {ID.EquipType.AIR_R_LO,      256,  3});
        EQUIP_SMALL.add(new int[] {ID.EquipType.CANNON_TW_LO,  320,  2});

        //large build
        EQUIP_LARGE.add(new int[] {ID.EquipType.ARMOR_HI,      500,  1});
        EQUIP_LARGE.add(new int[] {ID.EquipType.GUN_HI,        800,  2});
        EQUIP_LARGE.add(new int[] {ID.EquipType.AMMO_HI,       1000, 2});
        EQUIP_LARGE.add(new int[] {ID.EquipType.AIR_R_HI,      1000, 3});
        EQUIP_LARGE.add(new int[] {ID.EquipType.TORPEDO_HI,    1200, 2});
        EQUIP_LARGE.add(new int[] {ID.EquipType.TURBINE_LO,    1400, 0});
        EQUIP_LARGE.add(new int[] {ID.EquipType.CANNON_TW_HI,  1600, 2});
        EQUIP_LARGE.add(new int[] {ID.EquipType.RADAR_HI,      2000, 0});
        EQUIP_LARGE.add(new int[] {ID.EquipType.AIR_T_LO,      2400, 3});
        EQUIP_LARGE.add(new int[] {ID.EquipType.AIR_F_LO,      2400, 3});
        EQUIP_LARGE.add(new int[] {ID.EquipType.AIR_B_LO,      2400, 3});
        EQUIP_LARGE.add(new int[] {ID.EquipType.CATAPULT_LO,   2800, 3});
        EQUIP_LARGE.add(new int[] {ID.EquipType.TURBINE_HI,    3200, 0});
        EQUIP_LARGE.add(new int[] {ID.EquipType.AIR_T_HI,      3800, 3});
        EQUIP_LARGE.add(new int[] {ID.EquipType.AIR_F_HI,      3800, 3});
        EQUIP_LARGE.add(new int[] {ID.EquipType.AIR_B_HI,      3800, 3});
        EQUIP_LARGE.add(new int[] {ID.EquipType.CANNON_TR,     4400, 2});
        EQUIP_LARGE.add(new int[] {ID.EquipType.CATAPULT_HI,   5000, 3});
    }


    private EquipCalc() {}

    /** roll equip type by material amounts; type 0: small build, 1: large */
    public static int rollEquipType(int type, int[] matAmount)
    {
        List<int[]> eqlistOrg = type == 0 ? EQUIP_SMALL : EQUIP_LARGE;
        int totalMats = matAmount[0] + matAmount[1] + matAmount[2] + matAmount[3];

        //prob list: <equip ID, prob parameter>
        Map<Integer, Float> probList = new HashMap<>();

        for (int[] i : eqlistOrg)
        {
            //get material discount, reduce the mean
            int meanNew = (i[2] >= 0 && i[2] <= 3) ? i[1] - matAmount[i[2]] : i[1];

            //get mean distance
            int meanDist = Math.abs(totalMats - meanNew);

            //small build: scale 256 -> 4000 resolution
            if (type == 0) meanDist = (int) (meanDist * 15.625F);

            probList.put(i[0], CalcHelper.getNormDist(meanDist));
        }

        //roll equip type
        float random = rand.nextFloat();
        float totalProb = 0F;
        float sumProb = 0.0125F;    //prevent float comparison bug
        int rollresult = -1;

        for (float p : probList.values()) totalProb += p;

        random *= totalProb;

        for (Map.Entry<Integer, Float> entry : probList.entrySet())
        {
            sumProb += entry.getValue();
            if (sumProb > random)
            {
                rollresult = entry.getKey();
                break;
            }
        }

        LogHelper.debug("DEBUG: roll equip type: " + rollresult);
        return rollresult;
    }

    /**
     * roll an equip of the given type.
     * totalMats: total material amount; buildType: 0 small / 1 large.
     */
    public static ItemStack rollEquipsOfTheType(int type, int totalMats,
            int buildType, HolderLookup.Provider registries)
    {
        if (type == -1) return ItemStack.EMPTY;

        //equip roll list: <equip id, prob parameter>
        Map<Integer, Float> equipList = new HashMap<>();

        for (Map.Entry<Integer, int[]> entry : Values.EquipAttrsMisc.entrySet())
        {
            int eid = entry.getKey();
            int[] val = entry.getValue();

            if (val[ID.EquipMisc.RARE_TYPE] == type)
            {
                int totalMat = totalMats;

                //small build: scale 256 -> 4000
                if (buildType == 0) totalMat = (int) (totalMats * 15.625F);

                int meanDist = Math.abs(totalMat - val[ID.EquipMisc.RARE_MEAN]);
                equipList.put(eid, CalcHelper.getNormDist(meanDist));
            }
        }

        //roll equip
        float random = rand.nextFloat();
        float totalProb = 0F;
        float sumProb = 0.0125F;
        int rollResult = -1;

        for (float p : equipList.values()) totalProb += p;

        random *= totalProb;

        for (Map.Entry<Integer, Float> entry : equipList.entrySet())
        {
            sumProb += entry.getValue();
            if (sumProb > random)
            {
                rollResult = entry.getKey();
                break;
            }
        }

        //enchant level by material amount
        int enchLv = 0;
        if (buildType == 0)     //small build: max mats = 256
        {
            if (totalMats > 220) enchLv = 3;
            else if (totalMats > 200) enchLv = 2;
            else if (totalMats > 180) enchLv = 1;
        }
        else                    //large build: max mats = 4000
        {
            if (totalMats > 3500) enchLv = 3;
            else if (totalMats > 3000) enchLv = 2;
            else if (totalMats > 2000) enchLv = 1;
        }

        return getItemStackFromId(rollResult, enchLv, registries);
    }

    /**
     * equip itemstack from equipID with enchant level.
     * itemID = equip type + sub id * 100 (legacy meta encoding).
     */
    private static ItemStack getItemStackFromId(int itemID, int enchLv,
            HolderLookup.Provider registries)
    {
        if (itemID < 0) return ItemStack.EMPTY;

        //find the registered BasicEquip with matching equipID
        ItemStack item = ItemStack.EMPTY;
        int enchType = 0;

        for (var holder : ModItems.ITEMS.getEntries())
        {
            Item it = holder.get();
            if (it instanceof BasicEquip equip &&
                equip.getEquipID() == itemID)
            {
                item = new ItemStack(equip);
                break;
            }
        }

        if (item.isEmpty())
        {
            LogHelper.info("INFO: equip calc: no item for equipID " + itemID);
            return ItemStack.EMPTY;
        }

        //enchant type: 0:weapon, 1:armor, 2:misc
        int itemType = itemID % 100;
        enchType = switch (itemType)
        {
            case ID.EquipType.ARMOR_LO, ID.EquipType.ARMOR_HI -> 1;
            case ID.EquipType.RADAR_LO, ID.EquipType.RADAR_HI,
                 ID.EquipType.TURBINE_LO, ID.EquipType.TURBINE_HI,
                 ID.EquipType.CATAPULT_LO, ID.EquipType.CATAPULT_HI,
                 ID.EquipType.DRUM_LO,
                 ID.EquipType.COMPASS_LO,
                 ID.EquipType.FLARE_LO,
                 ID.EquipType.SEARCHLIGHT_LO -> 2;
            default -> 0;
        };

        if (enchLv > 0)
        {
            EnchantHelper.applyRandomEnchantToEquip(item, enchType, enchLv,
                registries);
        }

        return item;
    }


}

package com.lulan.shincolle.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

/**
 * enchant helper for equip enchantment (legacy EnchantHelper).
 * Legacy numeric enchantment ids are mapped to vanilla registry keys.
 */
public class EnchantHelper
{

    /** legacy 1.12 numeric enchantment id -> registry key */
    private static final Map<Integer, ResourceLocation> ENCH_ID_MAP =
        new HashMap<>();

    static
    {
        String[] names = {
            "protection",           //0
            "fire_protection",      //1
            "feather_falling",      //2
            "blast_protection",     //3
            "projectile_protection",//4
            "respiration",          //5
            "aqua_affinity",        //6
            "thorns",               //7
            "depth_strider",        //8
            "frost_walker",         //9
            "binding_curse",        //10
            null, null, null, null, //11-14
            null,                   //15
            "sharpness",            //16
            "smite",                //17
            "bane_of_arthropods",   //18
            "knockback",            //19
            "fire_aspect",          //20
            "looting",              //21
            "sweeping_edge",        //22
            null, null, null, null, null, null, null, null, null, //23-31
            "efficiency",           //32
            "silk_touch",           //33
            "unbreaking",           //34
            "fortune",              //35
            null, null, null, null, null, null, null, null, null, null,
            null, null,             //36-47
            "power",                //48
            "punch",                //49
            "flame",                //50
            "infinity",             //51
            null, null, null, null, null, null, null, null, null, //52-60
            "luck_of_the_sea",      //61
            "lure",                 //62
            null, null, null, null, null, null, null,             //63-69
            "mending",              //70
        };

        for (int i = 0; i < names.length; i++)
        {
            if (names[i] != null)
            {
                ENCH_ID_MAP.put(i,
                    ResourceLocation.withDefaultNamespace(names[i]));
            }
        }
    }

    /** roll table: 0:weapon, 1:armor, 2:misc (legacy numeric ids) */
    private static final int[][] ENCHANT_TABLE = new int[][] {
        //weapon
        {5, 7, 9, 16, 17, 18, 19, 20, 21, 32, 35, 48, 49, 50, 51, 61},
        //armor
        {0, 1, 3, 4, 33, 34, 70},
        //misc
        {2, 6, 8, 33, 62, 70},
    };


    private EnchantHelper() {}

    /**
     * apply random enchant to equip by lv and type
     * (legacy applyRandomEnchantToEquip).
     *
     * enchLv: 0:none, 1:40%=1 ench, 2:30%=1 30%=2, 3:30%=1 30%=2 20%=3
     */
    public static void applyRandomEnchantToEquip(ItemStack stack, int enchType,
            int enchLv, HolderLookup.Provider registries)
    {
        if (stack == null || stack.isEmpty() || enchLv == 0) return;

        //roll #enchant
        Random rand = new Random();
        int enchNum = 0;
        int ranNum = rand.nextInt(10);

        switch (enchLv)
        {
        case 1:
            enchNum = ranNum > 5 ? 1 : 0;
        break;
        case 2:
            enchNum = ranNum > 6 ? 2 : ranNum > 3 ? 1 : 0;
        break;
        case 3:
            enchNum = ranNum > 7 ? 3 : ranNum > 4 ? 2 : ranNum > 1 ? 1 : 0;
        break;
        }

        if (enchNum <= 0) return;

        var enchReg = registries.lookupOrThrow(Registries.ENCHANTMENT);

        //roll enchant ids
        int[] enchs = ENCHANT_TABLE[Math.min(enchType, ENCHANT_TABLE.length - 1)];
        HashMap<Holder<Enchantment>, Integer> enchmap = new HashMap<>();

        for (int i = 0; i < enchNum; i++)
        {
            ResourceLocation key = ENCH_ID_MAP.get(enchs[rand.nextInt(enchs.length)]);
            if (key == null) continue;

            Holder<Enchantment> ench =
                enchReg.get(net.minecraft.resources.ResourceKey
                    .create(Registries.ENCHANTMENT, key)).orElse(null);
            if (ench == null) continue;

            //if enchant already exists, lv++
            int lv = enchmap.getOrDefault(ench, 0) + 1;
            int max = ench.value().getMaxLevel();
            if (lv > max) lv = max;
            enchmap.put(ench, lv);
        }

        //apply enchants
        enchmap.forEach(stack::enchant);
    }


}

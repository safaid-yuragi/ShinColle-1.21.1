package com.lulan.shincolle.registry;

import java.util.ArrayList;
import java.util.List;

import com.lulan.shincolle.item.BasicEquip;
import com.lulan.shincolle.item.BasicItem;
import com.lulan.shincolle.item.ShipSpawnEgg;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * item registration hub (Phase 2-4).
 *
 * Legacy meta variants are separate items named {@code <family>} for
 * meta 0 and {@code <family>_<meta>} for meta > 0 (see
 * TO_RegistryNames.md). Equip items carry their EquipType/SubID in
 * the item instance itself.
 */
public final class ModItems
{

    public static final DeferredRegister.Items ITEMS =
        DeferredRegister.createItems(Reference.MOD_ID);

    /** all items for the creative tab (registration order) */
    private static final List<DeferredItem<?>> ALL_ITEMS = new ArrayList<>();

    //spawn egg
    public static final DeferredItem<ShipSpawnEgg> SHIP_SPAWN_EGG =
        ITEMS.register("ship_spawn_egg", () -> new ShipSpawnEgg(new Item.Properties().stacksTo(16)));


    //materials
    public static final DeferredItem<BasicItem> ABYSS_METAL = item("abyss_metal");
    public static final DeferredItem<BasicItem> ABYSS_METAL_1 = item("abyss_metal_1");
    public static final DeferredItem<BasicItem> ABYSS_NUGGET = item("abyss_nugget");
    public static final DeferredItem<BasicItem> ABYSS_NUGGET_1 = item("abyss_nugget_1");
    public static final DeferredItem<BasicItem> AMMO = item("ammo");
    public static final DeferredItem<BasicItem> AMMO_1 = item("ammo_1");
    public static final DeferredItem<BasicItem> AMMO_2 = item("ammo_2");
    public static final DeferredItem<BasicItem> AMMO_3 = item("ammo_3");
    public static final DeferredItem<BasicItem> COMBAT_RATION = item("combat_ration");
    public static final DeferredItem<BasicItem> COMBAT_RATION_1 = item("combat_ration_1");
    public static final DeferredItem<BasicItem> COMBAT_RATION_2 = item("combat_ration_2");
    public static final DeferredItem<BasicItem> COMBAT_RATION_3 = item("combat_ration_3");
    public static final DeferredItem<BasicItem> COMBAT_RATION_4 = item("combat_ration_4");
    public static final DeferredItem<BasicItem> COMBAT_RATION_5 = item("combat_ration_5");
    public static final DeferredItem<BasicItem> GRUDGE = item("grudge");
    public static final DeferredItem<BasicItem> GRUDGE_1 = item("grudge_1");
    public static final DeferredItem<BasicItem> SHIP_TANK = item("ship_tank");
    public static final DeferredItem<BasicItem> SHIP_TANK_1 = item("ship_tank_1");
    public static final DeferredItem<BasicItem> SHIP_TANK_2 = item("ship_tank_2");
    public static final DeferredItem<BasicItem> SHIP_TANK_3 = item("ship_tank_3");

    //misc items
    public static final DeferredItem<BasicItem> BUCKET_REPAIR = item("bucket_repair");
    public static final DeferredItem<BasicItem> DESK_ITEM_BOOK = item("desk_item_book");
    public static final DeferredItem<BasicItem> DESK_ITEM_RADAR = item("desk_item_radar");
    public static final DeferredItem<BasicItem> INSTANT_CON_MAT = item("instant_con_mat");
    public static final DeferredItem<BasicItem> KAITAI_HAMMER = item("kaitai_hammer");
    public static final DeferredItem<BasicItem> MARRIAGE_RING = item("marriage_ring");
    public static final DeferredItem<BasicItem> MODERN_KIT = item("modern_kit");
    public static final DeferredItem<BasicItem> OWNER_PAPER = item("owner_paper");
    public static final DeferredItem<BasicItem> OP_TOOL = item("op_tool");
    public static final DeferredItem<BasicItem> POINTER_ITEM = item("pointer_item");
    public static final DeferredItem<com.lulan.shincolle.item.RecipePaperItem> RECIPE_PAPER =
        registerAll("recipe_paper",
            () -> new com.lulan.shincolle.item.RecipePaperItem(new Item.Properties()));
    public static final DeferredItem<BasicItem> REPAIR_GODDESS = item("repair_goddess");
    public static final DeferredItem<BasicItem> TARGET_WRENCH = item("target_wrench");
    public static final DeferredItem<BasicItem> TRAINING_BOOK = item("training_book");
    public static final DeferredItem<BasicItem> TOY_AIRPLANE = item("toy_airplane");

    //equipment families (variant count per legacy meta)
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE = equip("equip_airplane", ID.EquipType.AIR_T_LO, 0);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_1 = equip("equip_airplane_1", ID.EquipType.AIR_T_LO, 1);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_2 = equip("equip_airplane_2", ID.EquipType.AIR_T_LO, 2);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_3 = equip("equip_airplane_3", ID.EquipType.AIR_T_HI, 3);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_4 = equip("equip_airplane_4", ID.EquipType.AIR_F_LO, 4);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_5 = equip("equip_airplane_5", ID.EquipType.AIR_F_LO, 5);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_6 = equip("equip_airplane_6", ID.EquipType.AIR_F_LO, 6);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_7 = equip("equip_airplane_7", ID.EquipType.AIR_F_HI, 7);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_8 = equip("equip_airplane_8", ID.EquipType.AIR_F_HI, 8);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_9 = equip("equip_airplane_9", ID.EquipType.AIR_B_LO, 9);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_10 = equip("equip_airplane_10", ID.EquipType.AIR_B_LO, 10);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_11 = equip("equip_airplane_11", ID.EquipType.AIR_B_HI, 11);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_12 = equip("equip_airplane_12", ID.EquipType.AIR_B_HI, 12);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_13 = equip("equip_airplane_13", ID.EquipType.AIR_R_LO, 13);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_14 = equip("equip_airplane_14", ID.EquipType.AIR_R_HI, 14);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_15 = equip("equip_airplane_15", ID.EquipType.AIR_T_HI, 15);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_16 = equip("equip_airplane_16", ID.EquipType.AIR_F_HI, 16);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_17 = equip("equip_airplane_17", ID.EquipType.AIR_B_HI, 17);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_18 = equip("equip_airplane_18", ID.EquipType.AIR_F_HI, 18);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_19 = equip("equip_airplane_19", ID.EquipType.AIR_B_HI, 19);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_20 = equip("equip_airplane_20", ID.EquipType.AIR_B_HI, 20);
    public static final DeferredItem<BasicEquip> EQUIP_AIRPLANE_21 = equip("equip_airplane_21", ID.EquipType.AIR_F_HI, 21);
    public static final DeferredItem<BasicEquip> EQUIP_AMMO = equip("equip_ammo", ID.EquipType.AMMO_LO, 0);
    public static final DeferredItem<BasicEquip> EQUIP_AMMO_1 = equip("equip_ammo_1", ID.EquipType.AMMO_HI, 1);
    public static final DeferredItem<BasicEquip> EQUIP_AMMO_2 = equip("equip_ammo_2", ID.EquipType.AMMO_LO, 2);
    public static final DeferredItem<BasicEquip> EQUIP_AMMO_3 = equip("equip_ammo_3", ID.EquipType.AMMO_HI, 3);
    public static final DeferredItem<BasicEquip> EQUIP_AMMO_4 = equip("equip_ammo_4", ID.EquipType.AMMO_HI, 4);
    public static final DeferredItem<BasicEquip> EQUIP_AMMO_5 = equip("equip_ammo_5", ID.EquipType.AMMO_HI, 5);
    public static final DeferredItem<BasicEquip> EQUIP_AMMO_6 = equip("equip_ammo_6", ID.EquipType.AMMO_HI, 6);
    public static final DeferredItem<BasicEquip> EQUIP_AMMO_7 = equip("equip_ammo_7", ID.EquipType.AMMO_HI, 7);
    public static final DeferredItem<BasicEquip> EQUIP_AMMO_8 = equip("equip_ammo_8", ID.EquipType.AMMO_HI, 8);
    public static final DeferredItem<BasicEquip> EQUIP_ARMOR = equip("equip_armor", ID.EquipType.ARMOR_LO, 0);
    public static final DeferredItem<BasicEquip> EQUIP_ARMOR_1 = equip("equip_armor_1", ID.EquipType.ARMOR_HI, 1);
    public static final DeferredItem<BasicEquip> EQUIP_ARMOR_2 = equip("equip_armor_2", ID.EquipType.ARMOR_LO, 2);
    public static final DeferredItem<BasicEquip> EQUIP_ARMOR_3 = equip("equip_armor_3", ID.EquipType.ARMOR_LO, 3);
    public static final DeferredItem<BasicEquip> EQUIP_ARMOR_4 = equip("equip_armor_4", ID.EquipType.ARMOR_HI, 4);
    public static final DeferredItem<BasicEquip> EQUIP_ARMOR_5 = equip("equip_armor_5", ID.EquipType.ARMOR_LO, 5);
    public static final DeferredItem<BasicEquip> EQUIP_ARMOR_6 = equip("equip_armor_6", ID.EquipType.ARMOR_HI, 6);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON = equip("equip_cannon", ID.EquipType.CANNON_SI, 0);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_1 = equip("equip_cannon_1", ID.EquipType.CANNON_SI, 1);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_2 = equip("equip_cannon_2", ID.EquipType.CANNON_TW_LO, 2);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_3 = equip("equip_cannon_3", ID.EquipType.CANNON_TW_LO, 3);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_4 = equip("equip_cannon_4", ID.EquipType.CANNON_TW_LO, 4);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_5 = equip("equip_cannon_5", ID.EquipType.CANNON_TW_LO, 5);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_6 = equip("equip_cannon_6", ID.EquipType.CANNON_TW_HI, 6);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_7 = equip("equip_cannon_7", ID.EquipType.CANNON_TW_HI, 7);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_8 = equip("equip_cannon_8", ID.EquipType.CANNON_TW_HI, 8);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_9 = equip("equip_cannon_9", ID.EquipType.CANNON_TR, 9);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_10 = equip("equip_cannon_10", ID.EquipType.CANNON_TR, 10);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_11 = equip("equip_cannon_11", ID.EquipType.CANNON_TR, 11);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_12 = equip("equip_cannon_12", ID.EquipType.CANNON_SI, 12);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_13 = equip("equip_cannon_13", ID.EquipType.CANNON_TW_LO, 13);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_14 = equip("equip_cannon_14", ID.EquipType.CANNON_TR, 14);
    public static final DeferredItem<BasicEquip> EQUIP_CANNON_15 = equip("equip_cannon_15", ID.EquipType.CANNON_TR, 15);
    public static final DeferredItem<BasicEquip> EQUIP_CATAPULT = equip("equip_catapult", ID.EquipType.CATAPULT_LO, 0);
    public static final DeferredItem<BasicEquip> EQUIP_CATAPULT_1 = equip("equip_catapult_1", ID.EquipType.CATAPULT_LO, 1);
    public static final DeferredItem<BasicEquip> EQUIP_CATAPULT_2 = equip("equip_catapult_2", ID.EquipType.CATAPULT_HI, 2);
    public static final DeferredItem<BasicEquip> EQUIP_CATAPULT_3 = equip("equip_catapult_3", ID.EquipType.CATAPULT_HI, 3);
    public static final DeferredItem<BasicEquip> EQUIP_COMPASS = equip("equip_compass", ID.EquipType.COMPASS_LO, 0);
    public static final DeferredItem<BasicEquip> EQUIP_DRUM = equip("equip_drum", ID.EquipType.DRUM_LO, 0);
    public static final DeferredItem<BasicEquip> EQUIP_DRUM_1 = equip("equip_drum_1", ID.EquipType.DRUM_LO, 1);
    public static final DeferredItem<BasicEquip> EQUIP_DRUM_2 = equip("equip_drum_2", ID.EquipType.DRUM_LO, 2);
    public static final DeferredItem<BasicEquip> EQUIP_FLARE = equip("equip_flare", ID.EquipType.FLARE_LO, 0);
    public static final DeferredItem<BasicEquip> EQUIP_MACHINEGUN = equip("equip_machinegun", ID.EquipType.GUN_LO, 0);
    public static final DeferredItem<BasicEquip> EQUIP_MACHINEGUN_1 = equip("equip_machinegun_1", ID.EquipType.GUN_LO, 1);
    public static final DeferredItem<BasicEquip> EQUIP_MACHINEGUN_2 = equip("equip_machinegun_2", ID.EquipType.GUN_LO, 2);
    public static final DeferredItem<BasicEquip> EQUIP_MACHINEGUN_3 = equip("equip_machinegun_3", ID.EquipType.GUN_LO, 3);
    public static final DeferredItem<BasicEquip> EQUIP_MACHINEGUN_4 = equip("equip_machinegun_4", ID.EquipType.GUN_HI, 4);
    public static final DeferredItem<BasicEquip> EQUIP_MACHINEGUN_5 = equip("equip_machinegun_5", ID.EquipType.GUN_HI, 5);
    public static final DeferredItem<BasicEquip> EQUIP_MACHINEGUN_6 = equip("equip_machinegun_6", ID.EquipType.GUN_HI, 6);
    public static final DeferredItem<BasicEquip> EQUIP_RADAR = equip("equip_radar", ID.EquipType.RADAR_LO, 0);
    public static final DeferredItem<BasicEquip> EQUIP_RADAR_1 = equip("equip_radar_1", ID.EquipType.RADAR_LO, 1);
    public static final DeferredItem<BasicEquip> EQUIP_RADAR_2 = equip("equip_radar_2", ID.EquipType.RADAR_LO, 2);
    public static final DeferredItem<BasicEquip> EQUIP_RADAR_3 = equip("equip_radar_3", ID.EquipType.RADAR_LO, 3);
    public static final DeferredItem<BasicEquip> EQUIP_RADAR_4 = equip("equip_radar_4", ID.EquipType.RADAR_LO, 4);
    public static final DeferredItem<BasicEquip> EQUIP_RADAR_5 = equip("equip_radar_5", ID.EquipType.RADAR_HI, 5);
    public static final DeferredItem<BasicEquip> EQUIP_RADAR_6 = equip("equip_radar_6", ID.EquipType.RADAR_HI, 6);
    public static final DeferredItem<BasicEquip> EQUIP_RADAR_7 = equip("equip_radar_7", ID.EquipType.RADAR_HI, 7);
    public static final DeferredItem<BasicEquip> EQUIP_RADAR_8 = equip("equip_radar_8", ID.EquipType.RADAR_HI, 8);
    public static final DeferredItem<BasicEquip> EQUIP_SEARCHLIGHT = equip("equip_searchlight", ID.EquipType.SEARCHLIGHT_LO, 0);
    public static final DeferredItem<BasicEquip> EQUIP_TORPEDO = equip("equip_torpedo", ID.EquipType.TORPEDO_LO, 0);
    public static final DeferredItem<BasicEquip> EQUIP_TORPEDO_1 = equip("equip_torpedo_1", ID.EquipType.TORPEDO_LO, 1);
    public static final DeferredItem<BasicEquip> EQUIP_TORPEDO_2 = equip("equip_torpedo_2", ID.EquipType.TORPEDO_LO, 2);
    public static final DeferredItem<BasicEquip> EQUIP_TORPEDO_3 = equip("equip_torpedo_3", ID.EquipType.TORPEDO_HI, 3);
    public static final DeferredItem<BasicEquip> EQUIP_TORPEDO_4 = equip("equip_torpedo_4", ID.EquipType.TORPEDO_HI, 4);
    public static final DeferredItem<BasicEquip> EQUIP_TORPEDO_5 = equip("equip_torpedo_5", ID.EquipType.TORPEDO_HI, 5);
    public static final DeferredItem<BasicEquip> EQUIP_TORPEDO_6 = equip("equip_torpedo_6", ID.EquipType.TORPEDO_HI, 6);
    public static final DeferredItem<BasicEquip> EQUIP_TURBINE = equip("equip_turbine", ID.EquipType.TURBINE_LO, 0);
    public static final DeferredItem<BasicEquip> EQUIP_TURBINE_1 = equip("equip_turbine_1", ID.EquipType.TURBINE_LO, 1);
    public static final DeferredItem<BasicEquip> EQUIP_TURBINE_2 = equip("equip_turbine_2", ID.EquipType.TURBINE_HI, 2);
    public static final DeferredItem<BasicEquip> EQUIP_TURBINE_3 = equip("equip_turbine_3", ID.EquipType.TURBINE_HI, 3);
    public static final DeferredItem<BasicEquip> EQUIP_TURBINE_4 = equip("equip_turbine_4", ID.EquipType.TURBINE_HI, 4);

    private static DeferredItem<BasicItem> item(String name)
    {
        DeferredItem<BasicItem> h = ITEMS.register(name, () -> new BasicItem(new Item.Properties()));
        ALL_ITEMS.add(h);
        return h;
    }

    private static <T extends Item> DeferredItem<T> registerAll(String name,
            java.util.function.Supplier<T> sup)
    {
        DeferredItem<T> h = ITEMS.register(name, sup);
        ALL_ITEMS.add(h);
        return h;
    }

    private static DeferredItem<BasicEquip> equip(String name, int equipType, int subId)
    {
        DeferredItem<BasicEquip> h = ITEMS.register(name,
            () -> new BasicEquip(new Item.Properties(), equipType, subId));
        ALL_ITEMS.add(h);
        return h;
    }

    /** every registered mod item (not including block items) */
    public static List<DeferredItem<?>> allItems()
    {
        List<DeferredItem<?>> all = new ArrayList<>(ALL_ITEMS);
        all.add(0, SHIP_SPAWN_EGG);
        return all;
    }


    private ModItems() {}

}

package com.lulan.shincolle.registry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;

/**
 * ship class registry
 *
 * central table: legacy {@link ID.ShipClass} numeric id (short, kept for
 * gameplay/save data) <-> new 1.21.1 registry name (snake_case, lowercase
 * only per ResourceLocation rules) <-> EntityType.
 *
 * Hostile "mob" variants keep the legacy convention of classId + 2000 and
 * get the registry name "<base>_mob".
 *
 * NOTE: EntityType entries are registered in Phase 2 (ModEntities); lookups
 * via {@link #entityTypeOf(short)} resolve through BuiltInRegistries at
 * runtime, so this table is safe to use before registration happens.
 */
public final class ShipClassRegistry
{

    /** offset for hostile mob variants of player ships */
    public static final int MOB_OFFSET = 2000;

    /** ship class id -> registry path (snake_case) */
    private static final Map<Short, String> CLASS_TO_NAME;
    /** registry path -> ship class id */
    private static final Map<String, Short> NAME_TO_CLASS;
    /** ship class id -> legacy entity class simple name (for reference/debug) */
    private static final Map<Short, String> CLASS_TO_LEGACY;
    /** legacy entity class simple name -> ship class id */
    private static final Map<String, Short> LEGACY_TO_CLASS;

    /**
     * misc entity (mounts / summons / projectiles) legacy name -> registry path.
     * These have no ShipClass id; EntityType is registered under these names.
     */
    public static final Map<String, String> MISC_NAME_MAP;

    static
    {
        Map<Short, String> names = new HashMap<Short, String>();
        Map<Short, String> legacy = new HashMap<Short, String>();

        //destroyers (abyssal)
        put(names, legacy, ID.ShipClass.DDI,   "EntityDestroyerI",   "destroyer_i");
        put(names, legacy, ID.ShipClass.DDRO,  "EntityDestroyerRo",  "destroyer_ro");
        put(names, legacy, ID.ShipClass.DDHA,  "EntityDestroyerHa",  "destroyer_ha");
        put(names, legacy, ID.ShipClass.DDNI,  "EntityDestroyerNi",  "destroyer_ni");
        put(names, legacy, ID.ShipClass.DDNA,  "EntityDestroyerNa",  "destroyer_na");

        //light cruisers (abyssal)
        put(names, legacy, ID.ShipClass.CLHO,   "EntityLightCruiserHo",  "light_cruiser_ho");
        put(names, legacy, ID.ShipClass.CLHE,   "EntityLightCruiserHe",  "light_cruiser_he");
        put(names, legacy, ID.ShipClass.CLTO,   "EntityLightCruiserTo",  "light_cruiser_to");
        put(names, legacy, ID.ShipClass.CLTSU,  "EntityLightCruiserTsu", "light_cruiser_tsu");
        put(names, legacy, ID.ShipClass.CLTCHI, "EntityLightCruiserChi", "light_cruiser_chi");

        //heavy cruisers (abyssal)
        put(names, legacy, ID.ShipClass.CARI, "EntityHeavyCruiserRi", "heavy_cruiser_ri");
        put(names, legacy, ID.ShipClass.CANE, "EntityHeavyCruiserNe", "heavy_cruiser_ne");

        //carriers (abyssal)
        put(names, legacy, ID.ShipClass.CVLNU, "EntityCarrierNu", "carrier_nu");
        put(names, legacy, ID.ShipClass.CVWO,  "EntityCarrierWo", "carrier_wo");

        //battleships (abyssal)
        put(names, legacy, ID.ShipClass.BBRU, "EntityBattleshipRu", "battleship_ru");
        put(names, legacy, ID.ShipClass.BBTA, "EntityBattleshipTa", "battleship_ta");
        put(names, legacy, ID.ShipClass.BBRE, "EntityBattleshipRe", "battleship_re");

        //transport / submarines (abyssal)
        put(names, legacy, ID.ShipClass.APWA, "EntityTransportWa", "transport_wa");
        put(names, legacy, ID.ShipClass.SSKA, "EntitySubmKa",       "submarine_ka");
        put(names, legacy, ID.ShipClass.SSYO, "EntitySubmYo",       "submarine_yo");
        put(names, legacy, ID.ShipClass.SSSO, "EntitySubmSo",       "submarine_so");

        //hime / water demon / princess classes (abyssal)
        put(names, legacy, ID.ShipClass.CVHime,          "EntityCarrierHime",        "carrier_hime");
        put(names, legacy, ID.ShipClass.AirfieldHime,    "EntityAirfieldHime",       "airfield_hime");
        put(names, legacy, ID.ShipClass.ArmoredCVHime,   "EntityArmoredCarrierHime", "armored_carrier_hime");
        put(names, legacy, ID.ShipClass.AnchorageHime,   "EntityAnchorageHime",      "anchorage_hime");
        put(names, legacy, ID.ShipClass.HarbourWD,       "EntityHarbourWD",          "harbour_wd");
        put(names, legacy, ID.ShipClass.AnchorageWD,     "EntityAnchorageWD",        "anchorage_wd");
        put(names, legacy, ID.ShipClass.BBHime,          "EntityBattleshipHime",     "battleship_hime");
        put(names, legacy, ID.ShipClass.DDHime,          "EntityDestroyerHime",      "destroyer_hime");
        put(names, legacy, ID.ShipClass.HarbourHime,     "EntityHarbourHime",        "harbour_hime");
        put(names, legacy, ID.ShipClass.IsolatedHime,    "EntityIsolatedHime",       "isolated_hime");
        put(names, legacy, ID.ShipClass.MidwayHime,      "EntityMidwayHime",         "midway_hime");
        put(names, legacy, ID.ShipClass.NorthernHime,    "EntityNorthernHime",       "northern_hime");
        put(names, legacy, ID.ShipClass.SouthernHime,    "EntitySouthernHime",       "southern_hime");
        put(names, legacy, ID.ShipClass.CVWD,            "EntityCarrierWD",          "carrier_wd");
        put(names, legacy, ID.ShipClass.CLDemon,         "EntityLightCruiserDemon",  "light_cruiser_demon");
        put(names, legacy, ID.ShipClass.BBWD,            "EntityBattleshipWD",       "battleship_wd");
        put(names, legacy, ID.ShipClass.STHime,          "EntitySeaplaneHime",       "seaplane_hime");
        put(names, legacy, ID.ShipClass.AirdefenseHime,  "EntityAirdefenseHime",     "air_defense_hime");
        put(names, legacy, ID.ShipClass.CLHime,          "EntityCLHime",             "cl_hime");
        put(names, legacy, ID.ShipClass.SSHime,          "EntitySubmHime",           "submarine_hime");
        put(names, legacy, ID.ShipClass.DDWD,            "EntityDestroyerWD",        "destroyer_wd");
        put(names, legacy, ID.ShipClass.CAHime,          "EntityCAHime",             "ca_hime");
        put(names, legacy, ID.ShipClass.SupplyDepotHime, "EntitySDHime",             "supply_depot_hime");
        put(names, legacy, ID.ShipClass.DDAH,            "EntityDestroyerAH",        "destroyer_ah");
        put(names, legacy, ID.ShipClass.STWH,            "EntitySeaplaneWH",         "seaplane_wh");
        put(names, legacy, ID.ShipClass.NorthernWH,      "EntityNorthernWH",         "northern_wh");
        put(names, legacy, ID.ShipClass.JellyfishHime,   "EntityJellyfishHime",      "jellyfish_hime");
        put(names, legacy, ID.ShipClass.EscortHime,      "EntityEscortHime",         "escort_hime");
        put(names, legacy, ID.ShipClass.EuropeanHime,    "EntityEuropeanHime",       "european_hime");
        put(names, legacy, ID.ShipClass.CentralHime,     "EntityCentralHime",        "central_hime");
        put(names, legacy, ID.ShipClass.SSNH,            "EntitySubmNewHime",        "submarine_new_hime");
        put(names, legacy, ID.ShipClass.FrenchHime,      "EntityFrenchHime",         "french_hime");
        put(names, legacy, ID.ShipClass.NightStraitHime, "EntityNightStraitHime",    "night_strait_hime");
        put(names, legacy, ID.ShipClass.EntombedAAHime,  "EntityEntombedAAHime",     "entombed_aa_hime");
        put(names, legacy, ID.ShipClass.NorthlandHime,   "EntityNorthlandHime",      "northland_hime");
        put(names, legacy, ID.ShipClass.SupplyDepotSH,   "EntitySDSH",               "supply_depot_sh");
        put(names, legacy, ID.ShipClass.SSSH,            "EntitySubmSH",             "submarine_sh");
        put(names, legacy, ID.ShipClass.BBSH,            "EntityBattleshipSH",       "battleship_sh");
        put(names, legacy, ID.ShipClass.CASH,            "EntityCASH",               "ca_sh");
        put(names, legacy, ID.ShipClass.CVSH,            "EntityCarrierSH",          "carrier_sh");
        put(names, legacy, ID.ShipClass.HarbourSH,       "EntityHarbourSH",          "harbour_sh");
        put(names, legacy, ID.ShipClass.LycorisHime,     "EntityLycorisHime",        "lycoris_hime");
        put(names, legacy, ID.ShipClass.TwinHime,        "EntityTwinHime",           "twin_hime");

        //player ships (with hostile Mob variant at classId + 2000)
        putMob(names, legacy, ID.ShipClass.DDShimakaze, "EntityDestroyerShimakaze", "destroyer_shimakaze");
        putMob(names, legacy, ID.ShipClass.BBNagato,    "EntityBattleshipNGT",      "battleship_nagato");
        putMob(names, legacy, ID.ShipClass.BBYamato,    "EntityBattleshipYMT",      "battleship_yamato");
        putMob(names, legacy, ID.ShipClass.SSU511,      "EntitySubmU511",           "submarine_u511");
        putMob(names, legacy, ID.ShipClass.SSRo500,     "EntitySubmRo500",          "submarine_ro500");
        putMob(names, legacy, ID.ShipClass.APMamiya,    "EntityAPMamiya",           "transport_mamiya");
        putMob(names, legacy, ID.ShipClass.DDAkatsuki,  "EntityDestroyerAkatsuki",  "destroyer_akatsuki");
        putMob(names, legacy, ID.ShipClass.DDHibiki,    "EntityDestroyerHibiki",    "destroyer_hibiki");
        putMob(names, legacy, ID.ShipClass.DDIkazuchi,  "EntityDestroyerIkazuchi",  "destroyer_ikazuchi");
        putMob(names, legacy, ID.ShipClass.DDInazuma,   "EntityDestroyerInazuma",   "destroyer_inazuma");
        putMob(names, legacy, ID.ShipClass.CLTenryuu,   "EntityCruiserTenryuu",     "cruiser_tenryuu");
        putMob(names, legacy, ID.ShipClass.CLTatsuta,   "EntityCruiserTatsuta",     "cruiser_tatsuta");
        putMob(names, legacy, ID.ShipClass.CAAtago,     "EntityCruiserAtago",       "cruiser_atago");
        putMob(names, legacy, ID.ShipClass.CATakao,     "EntityCruiserTakao",       "cruiser_takao");
        putMob(names, legacy, ID.ShipClass.CVKaga,      "EntityCarrierKaga",        "carrier_kaga");
        putMob(names, legacy, ID.ShipClass.CVAkagi,     "EntityCarrierAkagi",       "carrier_akagi");
        putMob(names, legacy, ID.ShipClass.BBKongou,    "EntityBattleshipKongou",   "battleship_kongou");
        putMob(names, legacy, ID.ShipClass.BBHiei,      "EntityBattleshipHiei",     "battleship_hiei");
        putMob(names, legacy, ID.ShipClass.BBHaruna,    "EntityBattleshipHaruna",   "battleship_haruna");
        putMob(names, legacy, ID.ShipClass.BBKirishima, "EntityBattleshipKirishima","battleship_kirishima");

        //special: Raiden (combined unit of Ikazuma/Inazuma), legacy map pointed at "Entity"
        put(names, legacy, ID.ShipClass.Raiden, "Entity", "raiden");

        CLASS_TO_NAME = Collections.unmodifiableMap(names);
        CLASS_TO_LEGACY = Collections.unmodifiableMap(legacy);

        Map<String, Short> n2c = new HashMap<String, Short>();
        Map<String, Short> l2c = new HashMap<String, Short>();
        names.forEach((id, name) -> n2c.put(name, id));
        legacy.forEach((id, name) -> l2c.put(name, id));
        NAME_TO_CLASS = Collections.unmodifiableMap(n2c);
        LEGACY_TO_CLASS = Collections.unmodifiableMap(l2c);

        Map<String, String> misc = new HashMap<String, String>();
        //mounts
        misc.put(ID.NameMinions.MountAfH,         "mount_airfield");
        misc.put(ID.NameMinions.MountBaH,         "mount_battleship");
        misc.put(ID.NameMinions.MountCaH,         "mount_carrier");
        misc.put(ID.NameMinions.MountCaWD,        "mount_carrier_wd");
        misc.put(ID.NameMinions.MountHbH,         "mount_harbour");
        misc.put(ID.NameMinions.MountIsH,         "mount_isolated");
        misc.put(ID.NameMinions.MountMiH,         "mount_midway");
        misc.put(ID.NameMinions.MountSuH,         "mount_submarine");
        //projectiles
        misc.put(ID.NameMinions.AbyssMissile,     "abyss_missile");
        misc.put(ID.NameMinions.ProjectileBeam,   "projectile_beam");
        misc.put(ID.NameMinions.ProjectileStatic, "projectile_static");
        misc.put(ID.NameMinions.ShipFishingHook,  "ship_fishing_hook");
        //summons
        misc.put(ID.NameMinions.Rensouhou,        "rensouhou");
        misc.put(ID.NameMinions.RensouhouMob,     "rensouhou_mob");
        misc.put(ID.NameMinions.RensouhouS,       "rensouhou_s");
        misc.put(ID.NameMinions.Airplane,         "airplane");
        misc.put(ID.NameMinions.AirplaneTakoyaki, "airplane_takoyaki");
        misc.put(ID.NameMinions.AirplaneT,        "airplane_t");
        misc.put(ID.NameMinions.AirplaneZero,     "airplane_zero");
        misc.put(ID.NameMinions.AirplaneTMob,     "airplane_t_mob");
        misc.put(ID.NameMinions.AirplaneZeroMob,  "airplane_zero_mob");
        misc.put(ID.NameMinions.FloatingFort,     "floating_fort");
        //item entity
        misc.put(ID.NameMinions.BasicEntityItem,  "basic_entity_item");

        MISC_NAME_MAP = Collections.unmodifiableMap(misc);
    }


    private ShipClassRegistry() {}

    private static void put(Map<Short, String> names, Map<Short, String> legacy,
                            short classId, String legacyClass, String name)
    {
        names.put(classId, name);
        legacy.put(classId, legacyClass);
    }

    /** register base class plus hostile Mob variant (classId + MOB_OFFSET -> name_mob) */
    private static void putMob(Map<Short, String> names, Map<Short, String> legacy,
                               short classId, String legacyClass, String name)
    {
        put(names, legacy, classId, legacyClass, name);
        put(names, legacy, (short) (classId + MOB_OFFSET), legacyClass + "Mob", name + "_mob");
    }

    /** sanity check + log (call in common setup) */
    public static void bootstrap()
    {
        //duplicate name check
        if (CLASS_TO_NAME.size() != NAME_TO_CLASS.size())
        {
            LogHelper.error("ShipClassRegistry: duplicate registry name detected! "+
                            CLASS_TO_NAME.size() + " ids vs " + NAME_TO_CLASS.size() + " names");
        }

        LogHelper.info("INFO: ShipClassRegistry: " + CLASS_TO_NAME.size() +
                       " ship classes, " + MISC_NAME_MAP.size() + " misc entities mapped");
    }

    /* ============ lookup ============ */

    /** ship class id -> registry path ("destroyer_i"), null if unmapped */
    public static String registryNameOf(short classId)
    {
        return CLASS_TO_NAME.get(classId);
    }

    /** ship class id -> ResourceLocation ("shincolle:destroyer_i"), null if unmapped */
    public static ResourceLocation idOf(short classId)
    {
        String name = CLASS_TO_NAME.get(classId);
        return name == null ? null : Reference.modLoc(name);
    }

    /** legacy entity class simple name ("EntityDestroyerI") -> registry path */
    public static String registryNameOf(Class<?> entityClass)
    {
        if (entityClass == null) return null;
        Short id = LEGACY_TO_CLASS.get(entityClass.getSimpleName());
        return id == null ? null : CLASS_TO_NAME.get(id);
    }

    /** registry path -> ship class id, -1 if unmapped */
    public static short classIdOf(String path)
    {
        Short id = NAME_TO_CLASS.get(path);
        return id == null ? -1 : id;
    }

    /** ResourceLocation -> ship class id, -1 if not ours/unmapped */
    public static short classIdOf(ResourceLocation loc)
    {
        if (loc == null || !Reference.MOD_ID.equals(loc.getNamespace())) return -1;
        return classIdOf(loc.getPath());
    }

    /** ship class id -> registered EntityType (Phase 2+), null before registration */
    public static EntityType<?> entityTypeOf(short classId)
    {
        ResourceLocation id = idOf(classId);
        return id == null ? null : BuiltInRegistries.ENTITY_TYPE.get(id);
    }

    /** ship class id -> legacy entity class simple name, null if unmapped */
    public static String legacyNameOf(short classId)
    {
        return CLASS_TO_LEGACY.get(classId);
    }

    /** all ship class ids (including mob variants) */
    public static java.util.Set<Short> allClassIds()
    {
        return CLASS_TO_NAME.keySet();
    }


}

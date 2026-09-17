package com.lulan.shincolle.config;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.utility.LogHelper;

import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * main config (1.21.1 NeoForge port of legacy handler/ConfigHandler)
 *
 * spec values are baked into the public static fields on
 * ModConfigEvent.Loading / ModConfigEvent.Reloading (see {@link #bake()}),
 * keeping the legacy "ConfigHandler.xxx" style access for later phases.
 */
public final class ShinColleConfig
{

    public static final ModConfigSpec COMMON_SPEC;
    public static final ModConfigSpec CLIENT_SPEC;

    //custom INI configs (loaded to config/shincolle/)
    public static ConfigSound configSound;    //sound
    public static ConfigLoot configLoot;      //loot
    public static ConfigMining configMining;  //mining

    /********************* GENERAL **********************/
    public static boolean debugMode = false;
    public static boolean easyMode = false;
    public static boolean friendlyFire = true;
    public static boolean useWakamoto = true;
    public static boolean polyAsMn = false;
    public static boolean mobAttackPlayer = true;

    public static float dropGrudge = 1.0F;

    public static int closeGUIDist = 64;
    public static int bossCooldown = 4800;
    public static int teamCooldown = 6000;
    public static int despawnBoss = 12000;
    public static int despawnMinion = 600;
    public static int despawnEgg = 12000;
    public static int kaitaiAmountSmall = 20;
    public static int kaitaiAmountLarge = 20;
    public static int baseCaressMorale = 20;
    public static int spawnBossNum = 2;
    public static int spawnMobNum = 4;
    public static int shipNumPerPage = 5;
    public static int chunkloaderMode = 2;
    public static int deathMaxTick = 400;
    public static int radarUpdate = 64;  //radar update interval (ticks)
    public static int shipAttackPlayer = 0;
    public static int pairDistChest = 16;
    public static int pairDistWp = 48;

    //tile entity setting                                    max storage, build speed, fuel magn
    public static double[] tileShipyardSmall = new double[] {460800D,     48D,         1D};
    public static double[] tileShipyardLarge = new double[] {1382400D,    48D,         1D};
    public static double[] tileVolCore = new double[] {      9600D,       16D,         240D};

    //crane setting                            liquid tank capa
    public static int[] tileCrane = new int[] {2048000};

    //ship tank setting                           0      1       2       3
    public static int[] itemShipTank = new int[] {32000, 128000, 512000, 2048000};

    /********************* BUFF **********************/
    public static int buffSaturation = 100;   //not configurable for now

    /********************* SHIP **********************/
    //                                                    HP, ATK_L, ATK_H, ATK_AL, ATK_AH
    public static double[] limitShipAttrs = new double[] {-1D, -1D, -1D, -1D, -1D,
    //                                                    DEF,   SPD, MOV,  HIT, CRI
                                                          0.95D, 4D,  0.6D, 64D, 0.95D,
    //                                                    DHIT,  THIT,  MISS,  AA, ASM
                                                          0.95D, 0.95D, 0.95D, -1D, -1D,
    //                                                    DODGE, XP, GRUDGE, AMMO, HPRES
                                                          0.75D, -1D, -1D, -1D, -1D,
    //                                                    KB
                                                          1D};
    public static double[] scaleShip = new double[] {1D, 1D, 1D, 1D, 1D, 1D};
    //                                                      HP,    ATK,  DEF,   SPD,  MOV,   HIT
    public static double[] scaleBossSmall = new double[] {1600D, 120D, 0.5D,  1.6D, 0.38D, 18D};
    public static double[] scaleBossLarge = new double[] {3200D, 240D, 0.75D, 2D,   0.35D, 22D};
    //                                                        HP,    ATK,  DEF,   SPD,  MOV,   HIT
    public static double[] scaleMobSmall = new double[] {250D,   25D,  0.15D, 0.7D, 0.45D, 12D};
    public static double[] scaleMobLarge = new double[] {500D,   50D,  0.30D, 0.9D, 0.4D,  15D};
    //item scaling                                       scale, offX, offY, offZ
    public static double[] scaleHeldItem = new double[] {2.5D,    0D,   0D,   0D};
    //ammo consumption:                              DD CL CA CAV CLT CVL CV BB BBV SS AP
    public static int[] consumeAmmoShip = new int[] {1, 2, 2, 2,  2,  3,  3, 4, 4,  1, 1};
    //grudge consumption:                                  DD CL CA CAV CLT CVL CV BB BBV SS AP
    public static int[] consumeGrudgeShipIdle = new int[] {5, 7, 8, 9,  8,  11, 12,15,14, 4, 3};
    /** grudge consumption:                              LAtk, HAtk, LAir, HAir, moving */
    public static int[] consumeGrudgeAction = new int[] {4,    8,    6,    12,   3};
    //grudge consumption:                              cook fish mine craft
    public static int[] consumeGrudgeTask = new int[] {3,   30,  300, 2};
    //attack speed                                    melee, Latk, Hatk, CV,  Air
    public static int[] baseAttackSpeed = new int[] { 40,    80,   120,  100, 100};
    public static int[] fixedAttackDelay = new int[] {0,     20,   50,   35,  35};
    //exp gain                               melee, LAtk, HAtk, LAir, HAir, move/b, pick
    public static int[] expGain = new int[] {2,     4,    5,    8,    10,   1,      2};
    //exp gain by task                           cook fish mine craft
    public static int[] expGainTask = new int[] {2,   20,  10,  1};
    //fishing time                               base, random
    public static int[] tickFishing = new int[] {400,  600};
    //mining time                                base, random
    public static int[] tickMining = new int[]  {100,  200};
    //mob spawn                               Max, Prob, GroupNum, MinPS, MaxPS
    public static int[] mobSpawn = new int[] {50,  10,   1,        1,     1};
    //marriage ring ability                      breath, fly, dig, fog, immune fire
    public static int[] ringAbility = new int[] {0,      6,   30,  20,  12};
    //liquid drum setting                       base, enchant
    public static int[] drumLiquid = new int[] {40,   5};
    //can ship pump infinite liquid            min water depth, min lava depth
    public static int[] infLiquid = new int[] {12,              8};
    //ship teleport AI setting                    cooldown(ticks), distance(blocks^2)
    public static int[] shipTeleport = new int[] {200,             256};
    //task enable setting                               cook  fish  mine  craft
    public static boolean[] enableTask = new boolean[] {true, true, true, true};

    public static int dmgSvS = 100;     //ship vs ship damage modifier, 20 = dmg * 20%
    public static int expMod = 20;      //ship exp per level, ex: 20 => lv 15 exp req = 15*20+20
    public static int modernLimit = 3;  //ship attrs upgrade level limit
    public static int searchlightCD = 4;
    public static int maxLevel = 150;        //not configurable now
    public static int midLimitLevel = 100;   //not configurable now
    public static int airplaneDelay = 2400;  //airplane recovery base delay ticks
    public static int baseGrudge = 300;      //base grudge value per item
    public static int baseLightAmmo = 30;    //base light ammo value per item
    public static int baseHeavyAmmo = 15;    //base heavy ammo value per item
    public static int maxDmgOnPlayer = 59;   //ship's max damage on player target

    public static boolean timeKeeping = true;
    public static boolean checkRing = true;
    public static boolean canTeleport = true;

    //slots setting
    //item slots by ship type                      DD CL CA CAV CLT CVL CV BB BBV SS AP
    public static int[] itemSlotsType = new int[] {3, 4, 5, 6,  4,  6,  6, 6, 6,  2, 18};
    //item slots by ship class                       DD, Cru, CV, BB, AP, SS, De, Pr
    private static int[] itemSlotsClass = new int[] {6,  9,   12, 10, 18, 4,  12, 12};
    //item slots by level
    public static int itemSlotsLevel = 10;
    //equip page by level                       page 1  2   3
    public static int[] equipPagesLevel = new int[] {1, 75, 120};
    //equip slots by class                           DD, Cru, CV, BB, AP, SS, De, Pr
    public static int[] equipSlotsClass = new int[] {0,  1,   2,  2,  0,  0,  2,  3};
    //equip slots by level
    public static int equipSlotsLevel = 20;

    /********************* WORLD GEN **********************/
    public static int polyOreBaseRate = 7;
    public static int polyGravelBaseRate = 4;
    public static boolean[] polyGravelBaseBlock = new boolean[] {true, true, false, false};    //stone gravel sand dirt

    /********************* CLIENT **********************/
    public static boolean showTag = true;
    public static boolean alwaysShowTeamParticle = false;
    public static boolean vortexDepth = false;
    public static int nameTagDist = 16;
    public static boolean canFlare = true;
    public static boolean canSearchlight = true;
    public static float volumeTimekeep = 1.0F;
    public static float volumeShip = 1.0F;
    public static float volumeFire = 0.7F;
    //HUD position                                x     y
    public static double[] posHUD = new double[] {0.5D, 0.6D};

    /* ================= SPEC VALUE HOLDERS ================= */

    private static ModConfigSpec.IntValue cBossCooldown;
    private static ModConfigSpec.IntValue cCloseGUIDist;
    private static ModConfigSpec.IntValue cChunkloaderMode;
    private static ModConfigSpec.IntValue cDeathMaxTick;
    private static ModConfigSpec.BooleanValue cDebugMode;
    private static ModConfigSpec.IntValue cDespawnBoss;
    private static ModConfigSpec.IntValue cDespawnMinion;
    private static ModConfigSpec.IntValue cDespawnEgg;
    private static ModConfigSpec.DoubleValue cDropGrudge;
    private static ModConfigSpec.BooleanValue cEasyMode;
    private static ModConfigSpec.BooleanValue cFriendlyFire;
    private static ModConfigSpec.IntValue cKaitaiAmountSmall;
    private static ModConfigSpec.IntValue cKaitaiAmountLarge;
    private static ModConfigSpec.BooleanValue cMobAttackPlayer;
    private static ModConfigSpec.IntValue cShipAttackPlayer;
    private static ModConfigSpec.BooleanValue cPolyAsMn;
    private static ModConfigSpec.IntValue cRadarUpdate;
    private static ModConfigSpec.IntValue cShipNumPerPage;
    private static ModConfigSpec.IntValue cTeamCooldown;
    private static ModConfigSpec.BooleanValue cUseWakamoto;
    private static ModConfigSpec.IntValue cSpawnBossNum;
    private static ModConfigSpec.IntValue cSpawnMobNum;
    private static ModConfigSpec.IntValue cPairDistChest;
    private static ModConfigSpec.IntValue cPairDistWp;
    private static ModConfigSpec.ConfigValue<List<? extends Double>> cTileShipyardSmall;
    private static ModConfigSpec.ConfigValue<List<? extends Double>> cTileShipyardLarge;
    private static ModConfigSpec.ConfigValue<List<? extends Double>> cTileVolCore;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cTileCrane;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cRingAbility;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cInfLiquid;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cItemShipTank;

    private static ModConfigSpec.BooleanValue cCanTeleport;
    private static ModConfigSpec.BooleanValue cCheckRing;
    private static ModConfigSpec.BooleanValue cTimeKeeping;
    private static ModConfigSpec.IntValue cBaseCaressMorale;
    private static ModConfigSpec.IntValue cModernLimit;
    private static ModConfigSpec.IntValue cSearchlightCD;
    private static ModConfigSpec.IntValue cAirplaneDelay;
    private static ModConfigSpec.IntValue cBaseGrudge;
    private static ModConfigSpec.IntValue cBaseLightAmmo;
    private static ModConfigSpec.IntValue cBaseHeavyAmmo;
    private static ModConfigSpec.IntValue cMaxDmgOnPlayer;
    private static ModConfigSpec.IntValue cItemSlotsLevel;
    private static ModConfigSpec.IntValue cEquipSlotsLevel;
    private static ModConfigSpec.IntValue cDmgSvS;
    private static ModConfigSpec.IntValue cExpMod;
    private static ModConfigSpec.ConfigValue<List<? extends Double>> cScaleShip;
    private static ModConfigSpec.ConfigValue<List<? extends Double>> cLimitShipAttrs;
    private static ModConfigSpec.ConfigValue<List<? extends Double>> cScaleBossSmall;
    private static ModConfigSpec.ConfigValue<List<? extends Double>> cScaleBossLarge;
    private static ModConfigSpec.ConfigValue<List<? extends Double>> cScaleMobSmall;
    private static ModConfigSpec.ConfigValue<List<? extends Double>> cScaleMobLarge;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cConsumeAmmoShip;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cConsumeGrudgeShipIdle;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cConsumeGrudgeAction;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cConsumeGrudgeTask;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cBaseAttackSpeed;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cFixedAttackDelay;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cExpGain;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cExpGainTask;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cMobSpawn;
    private static ModConfigSpec.ConfigValue<List<? extends Double>> cScaleHeldItem;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cDrumLiquid;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cShipTeleport;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cTickFishing;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cTickMining;
    private static ModConfigSpec.ConfigValue<List<? extends Boolean>> cEnableTask;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cItemSlotsClass;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cItemSlotsType;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cEquipSlotsClass;
    private static ModConfigSpec.ConfigValue<List<? extends Integer>> cEquipPagesLevel;

    private static ModConfigSpec.IntValue cPolyOreBaseRate;
    private static ModConfigSpec.IntValue cPolyGravelBaseRate;
    private static ModConfigSpec.ConfigValue<List<? extends Boolean>> cPolyGravelBaseBlock;

    private static ModConfigSpec.BooleanValue clShowTag;
    private static ModConfigSpec.BooleanValue clAlwaysShowTeamParticleClient;
    private static ModConfigSpec.BooleanValue clVortexDepth;
    private static ModConfigSpec.IntValue clNameTagDist;
    private static ModConfigSpec.BooleanValue clCanFlare;
    private static ModConfigSpec.BooleanValue clCanSearchlight;
    private static ModConfigSpec.DoubleValue clVolumeTimekeep;
    private static ModConfigSpec.DoubleValue clVolumeShip;
    private static ModConfigSpec.DoubleValue clVolumeFire;
    private static ModConfigSpec.ConfigValue<List<? extends Double>> clPosHUD;

    private static final Predicate<Object> IS_INT = o -> o instanceof Number;
    private static final Predicate<Object> IS_DBL = o -> o instanceof Number;
    private static final Predicate<Object> IS_BOOL = o -> o instanceof Boolean;

    /* ================= COMMON SPEC ================= */
    static
    {
        ModConfigSpec.Builder b = new ModConfigSpec.Builder();

        b.comment("general setting").push("general");

        cBossCooldown = b.comment("Boss spawn cooldown (ticks)")
                .defineInRange("Cooldown_Boss", 4800, 20, 1728000);
        cCloseGUIDist = b.comment("Close inventory GUI if ship away from player X blocks")
                .defineInRange("Close_GUI_Distance", 64, 2, 64);
        cChunkloaderMode = b.comment("Chunk loader mode: 0: disable, 1: only 1 chunk each ship, 2: 3x3 chunks each ship")
                .defineInRange("Mode_ChunkLoader", 2, 0, 2);
        cDeathMaxTick = b.comment("Ship death animation time")
                .defineInRange("Death_Time", 400, 0, 3600);
        cDebugMode = b.comment("Enable debug message (SPAM WARNING)")
                .define("Mode_Debug", false);
        cDespawnBoss = b.comment("Despawn time of boss ship , -1 = do NOT despawn")
                .defineInRange("Despawn_Boss", 12000, -1, 1728000);
        cDespawnMinion = b.comment("Despawn time of nonboss ship, -1 = do NOT despawn")
                .defineInRange("Despawn_Minion", 600, -1, 1728000);
        cDespawnEgg = b.comment("Despawn time of spawn egg of ship mob, -1 = do NOT despawn")
                .defineInRange("Despawn_Egg", 12000, -1, 1728000);
        cDropGrudge = b.comment("Grudge drop rate (ex: 0.5 = 50% drop 1 grudge, 5.5 = drop 5 grudge + 50% drop 1 grudge)")
                .defineInRange("DropRate_Grudge", 1.0D, 0.0D, 64.0D);
        cEasyMode = b.comment("Easy mode: decrease Large Construction resources requirement, increase ammo / grudge gained from items (10x)")
                .define("Mode_Easy", false);
        cFriendlyFire = b.comment("false: disable damage done by player (except owner)")
                .define("Friendly_Fire", true);
        cKaitaiAmountSmall = b.comment("Recycle amount by Dismantle Hammer for copmmon ship, ex: Ro500.")
                .defineInRange("Recycle_Small", 20, 0, 1000);
        cKaitaiAmountLarge = b.comment("Recycle amount by Dismantle Hammer for rare ship, ex: Yamato.")
                .defineInRange("Recycle_Large", 20, 0, 1000);
        cMobAttackPlayer = b.comment("for mob ship, true: attack player automatically")
                .define("Attack_Player_ShipMob", true);
        cShipAttackPlayer = b.comment("for pet ship, 0: ship don't attack player automatically, 1: attack hostile player, 2: attack hostile and neutral player, 3: attack all player even if the player isn't in a team")
                .defineInRange("Attack_Player_Ship", 0, 0, 3);
        cPolyAsMn = b.comment("true: Polymetallic Nodules = Manganese Dust, Polymetallic Ore = Manganese Ore")
                .define("Polymetal_as_Mn", false);
        cRadarUpdate = b.comment("Radar update interval (ticks) in Admiral's Desk GUI")
                .defineInRange("Radar_Update", 64, 20, 6000);
        cShipNumPerPage = b.comment("#Ship per page for command: /ship list")
                .defineInRange("Command_ShipNum", 5, 1, 5000);
        cTeamCooldown = b.comment("Create/Disband Team Cooldown")
                .defineInRange("Cooldown_Team", 6000, 20, 1728000);
        cUseWakamoto = b.comment("enable Wakamoto sound for mounts")
                .define("Sound_Wakamoto", true);
        cSpawnBossNum = b.comment("large hostile ship (boss) number per spawn")
                .defineInRange("Spawn_Boss_Number", 2, 1, 10);
        cSpawnMobNum = b.comment("small hostile ship number per spawn")
                .defineInRange("Spawn_Mob_Number", 4, 1, 10);
        cPairDistChest = b.comment("Max pairing distance between waypoint and chest")
                .defineInRange("PairingDist_Chest", 16, 0, 64);
        cPairDistWp = b.comment("Max pairing distance between waypoints")
                .defineInRange("PairingDist_Waypoint", 48, 0, 64);
        cTileShipyardSmall = b.comment("Small shipyard: max fuel storage, build speed, fuel magnification")
                .defineList("Tile_SmallShipyard", Arrays.asList(460800D, 48D, 1D), IS_DBL);
        cTileShipyardLarge = b.comment("Large shipyard: max fuel storage, build speed, fuel magnification")
                .defineList("Tile_LargeShipyard", Arrays.asList(1382400D, 48D, 1D), IS_DBL);
        cTileVolCore = b.comment("Volcano Core: max fuel storage, fuel consume speed, fuel value per grudge item")
                .defineList("Tile_VolCore", Arrays.asList(9600D, 16D, 240D), IS_DBL);
        cTileCrane = b.comment("Crane: internal fluid tank capacity (mB)")
                .defineList("Tile_Crane", Arrays.asList(2048000), IS_INT);
        cRingAbility = b.comment("Ring ability related married number, -1 = disable, 0~N = active or max limit number: water breath (active number), fly in water (active number), dig speed boost (max limit number), fog in liquid (max limit number), immune to fire (active number)")
                .defineList("Ring_Ability", Arrays.asList(0, 6, 30, 20, 12), IS_INT);
        cInfLiquid = b.comment("Can ship pump infinite water or lava without destroying block: min water depth, min lava depth")
                .defineList("Infinite_Pump", Arrays.asList(12, 8), IS_INT);
        cItemShipTank = b.comment("Fluid Drum: fluid capacity (mB) for S, M, L, XL")
                .defineList("Item_FluidDrum", Arrays.asList(32000, 128000, 512000, 2048000), IS_INT);

        b.pop();

        b.comment("ship setting").push("ship setting");

        cCanTeleport = b.comment("Can ship teleport to owner/guarding position if too far away. NOTE: set false if ship usually disappear/despawn after teleport!")
                .define("Can_Teleport", true);
        cCheckRing = b.comment("Should check wedding ring when spawning NON-BOSS ship mob")
                .define("Check_Ring", true);
        cTimeKeeping = b.comment("Play timekeeping sound every 1000 ticks (1 minecraft hour)")
                .define("Can_Timekeeping", true);
        cBaseCaressMorale = b.comment("base morale value per CaressTick (4 ticks)")
                .defineInRange("Caress_BaseMorale", 20, 1, 5000);
        cModernLimit = b.comment("Max upgrade level by Modernization Toolkit")
                .defineInRange("Attrs_Limit_Modernization", 3, 3, 100);
        cSearchlightCD = b.comment("Cooldown for placing light block of searchlight")
                .defineInRange("CD_SearchLight", 4, 1, 256);
        cAirplaneDelay = b.comment("Base cooldown for airplane recovery, actual recovery time = CD_AirplaneRecovery / attack speed + 20")
                .defineInRange("CD_AirplaneRecovery", 3600, 1, 30000);
        cBaseGrudge = b.comment("Grudge value per grudge item. Block = 9x")
                .defineInRange("Item_Grudge", 300, 1, 30000);
        cBaseLightAmmo = b.comment("Light ammo value per light ammo item. Container = 9x")
                .defineInRange("Item_LightAmmo", 30, 1, 30000);
        cBaseHeavyAmmo = b.comment("Heavy ammo value per heavy ammo item. Container = 9x")
                .defineInRange("Item_HeavyAmmo", 15, 1, 30000);
        cMaxDmgOnPlayer = b.comment("Max ship damage on player target.")
                .defineInRange("Max_Damage_Player", 59, 0, 30000);

        String totalItemSlots = "Total Item Slots = ship level / Slots_Item_ByLevel + Slots_Item_ByIcon + Slots_Item_ByType.";
        cItemSlotsLevel = b.comment("item slots +1 per N level. " + totalItemSlots)
                .defineInRange("Slots_Item_ByLevel", 10, 1, 151);

        String totalEquipSlots = "Total Equip Slots = ship level / Slots_Equip_ByLevel + Slots_Equip_ByIcon.";
        cEquipSlotsLevel = b.comment("equip slots +1 per N level. " + totalEquipSlots)
                .defineInRange("Slots_Equip_ByLevel", 20, 1, 151);

        cDmgSvS = b.comment("Ship vs Ship damage modifier, 20 = damage * 20% ")
                .defineInRange("DmgTaken_SvS", 100, 0, 10000);
        cExpMod = b.comment("ship experience modifier, 20 = level 150: 150*20+20 = 3020")
                .defineInRange("EXP_Modifier", 20, 1, 10000);

        cScaleShip = b.comment("Ship attributes SCALE: HP, firepower, armor, attack speed, move speed, range")
                .defineList("Attrs_Scale", Arrays.asList(1D, 1D, 1D, 1D, 1D, 1D), IS_DBL);
        cLimitShipAttrs = b.comment("Ship attributes max limit (-1 = no limit): HP, damage(light), damage(heavy), damage(air_light), damage(air_heavy), armor%, attack speed, move speed, range(blocks), critical, double hit, triple hit, miss reduction, anti-air, anti-ss, dodge, xp gain, grudge gain, ammo gain, hp regen, knockback resist")
                .defineList("Attrs_Limit", Arrays.asList(-1D, -1D, -1D, -1D, -1D,
                        0.95D, 4D, 0.6D, 64D, 0.95D,
                        0.95D, 0.95D, 0.95D, -1D, -1D,
                        0.75D, -1D, -1D, -1D, -1D, 1D), IS_DBL);
        cScaleBossSmall = b.comment("Small boss base attribute values: HP, firepower, armor, attack speed, move speed, range")
                .defineList("Attrs_Hostile_SmallBoss", Arrays.asList(1600D, 120D, 0.5D, 1.6D, 0.38D, 18D), IS_DBL);
        cScaleBossLarge = b.comment("Large boss base attribute values: HP, firepower, armor, attack speed, move speed, range")
                .defineList("Attrs_Hostile_LargeBoss", Arrays.asList(3200D, 240D, 0.75D, 2D, 0.35D, 22D), IS_DBL);
        cScaleMobSmall = b.comment("Small mob ship like DD and SS base attribute values: HP, firepower, armor, attack speed, move speed, range")
                .defineList("Attrs_Hostile_SmallMob", Arrays.asList(250D, 25D, 0.15D, 0.7D, 0.45D, 12D), IS_DBL);
        cScaleMobLarge = b.comment("Large mob ship like CL and CA base attribute values: HP, firepower, armor, attack speed, move speed, range")
                .defineList("Attrs_Hostile_LargeMob", Arrays.asList(500D, 50D, 0.30D, 0.9D, 0.4D, 15D), IS_DBL);
        cConsumeAmmoShip = b.comment("Ammo consumption for ship type: DD CL CA CAV CLT CVL CV BB BBV SS AP (MAX = 45)")
                .defineList("Consume_Ammo", Arrays.asList(1, 2, 2, 2, 2, 3, 3, 4, 4, 1, 1), IS_INT);
        cConsumeGrudgeShipIdle = b.comment("Grudge consumption for ship type: DD CL CA CAV CLT CVL CV BB BBV SS AP (MAX = 120)")
                .defineList("Consume_Grudge_Idle", Arrays.asList(5, 7, 8, 9, 8, 11, 12, 15, 14, 4, 3), IS_INT);
        cConsumeGrudgeAction = b.comment("Grudge consumption for ship action: Light attack, Heavy attack, Light aircraft, Heavy aircraft, Moving per block")
                .defineList("Consume_Grudge_Action", Arrays.asList(4, 8, 6, 12, 3), IS_INT);
        cConsumeGrudgeTask = b.comment("Grudge consumption for task: Cooking, Fishing, Mining, Crafting")
                .defineList("Consume_Grudge_Task", Arrays.asList(3, 30, 300, 2), IS_INT);
        cBaseAttackSpeed = b.comment("Base attack speed for: Melee, Light attack, Heavy attack, Carrier attack, Airplane attack, ex: base speed 160, fixed delay 30 means (160 / ship attack speed +30) ticks per attack")
                .defineList("Attack_Base_Speed", Arrays.asList(40, 80, 120, 100, 100), IS_INT);
        cFixedAttackDelay = b.comment("Fixed attack delay for: Melee, Light attack, Heavy attack, Carrier attack, Airplane attack, ex: base speed 160, fixed delay 30 means (160 / ship attack speed +30) ticks per attack")
                .defineList("Attack_Fixed_Delay", Arrays.asList(0, 20, 50, 35, 35), IS_INT);
        cExpGain = b.comment("Exp gain for: Melee, Light Attack, Heavy Attack, Light Aircraft, Heavy Aircraft, Move per Block(AP only), Other Action(AP only)")
                .defineList("Exp_Gain", Arrays.asList(2, 4, 5, 8, 10, 1, 2), IS_INT);
        cExpGainTask = b.comment("Exp gain for task: Cooking, Fishing, Mining, Crafting")
                .defineList("Exp_Gain_Task", Arrays.asList(2, 20, 10, 1), IS_INT);
        cMobSpawn = b.comment("Mob ship spawn MAX number in the world, Spawn prob (roll once per player every 128 ticks), #groups each spawn, #min each group, #max each group")
                .defineList("Limit_MobSpawnNumber", Arrays.asList(50, 10, 1, 1, 1), IS_INT);
        cScaleHeldItem = b.comment("Ship held item scaling: scale, offset X, offset Y, offset Z")
                .defineList("Held_Item", Arrays.asList(2.5D, 0D, 0D, 0D), IS_DBL);
        cDrumLiquid = b.comment("liquid transport rate: base transfer rate (mB/t), additional rate per enchantment (mB/t). Total Rate = (ShipLV * 0.1 + 1) * (BaseRate * #TotalPumps + EnchantRate * #TotalEnchantments)")
                .defineList("Drum_Liquid", Arrays.asList(40, 5), IS_INT);
        cShipTeleport = b.comment("Ship teleport when following and guarding: cooldown (ticks), distance (blocks^2)")
                .defineList("ship_teleport", Arrays.asList(200, 256), IS_INT);
        cTickFishing = b.comment("Fishing time setting: base, random (ticks)")
                .defineList("Tick_Fishing", Arrays.asList(400, 600), IS_INT);
        cTickMining = b.comment("Mining time setting: base, random (ticks)")
                .defineList("Tick_Mining", Arrays.asList(100, 200), IS_INT);
        cEnableTask = b.comment("set true to enable the task: cooking, fishing, mining, crafting")
                .defineList("Task_Enable", Arrays.asList(true, true, true, true), IS_BOOL);
        cItemSlotsClass = b.comment("add item slots by ship icon, index: Destroyer, Cruiser, Carrier, Battleship, Transport, Submarine, Demon, Princess. " + totalItemSlots)
                .defineList("Slots_Item_ByIcon", Arrays.asList(6, 9, 12, 10, 18, 4, 12, 12), IS_INT);
        cItemSlotsType = b.comment("add item slots by ship type, index: DD CL CA CAV CLT CVL CV BB BBV SS AP. " + totalItemSlots)
                .defineList("Slots_Item_ByType", Arrays.asList(3, 4, 5, 6, 4, 6, 6, 6, 6, 2, 18), IS_INT);
        cEquipSlotsClass = b.comment("add equip slots by ship icon class, index: Destroyer, Cruiser, Carrier, Battleship, Transport, Submarine, Demon, Princess. " + totalEquipSlots)
                .defineList("Slots_Equip_ByIcon", Arrays.asList(0, 1, 2, 2, 0, 0, 2, 3), IS_INT);
        cEquipPagesLevel = b.comment("enable equip pages by ship level, index: page1, page2, page3. " + totalEquipSlots)
                .defineList("Slots_Equip_Page", Arrays.asList(1, 75, 120), IS_INT);

        b.pop();

        b.comment("world generate setting").push("world gen");

        cPolyOreBaseRate = b.comment("Polymetallic Ore clusters in one chunk")
                .defineInRange("Polymetal_Ore", 7, 0, 100);
        cPolyGravelBaseRate = b.comment("Polymetallic Gravel clusters in one chunk")
                .defineInRange("Polymetal_Gravel", 4, 0, 100);
        cPolyGravelBaseBlock = b.comment("PolyGravel replaced block: stone, gravel, sand, dirt")
                .defineList("Polymetal_Gravel_Replace", Arrays.asList(true, true, false, false), IS_BOOL);

        b.pop();

        COMMON_SPEC = b.build();
    }

    /* ================= CLIENT SPEC ================= */
    static
    {
        ModConfigSpec.Builder b = new ModConfigSpec.Builder();

        b.comment("client only setting").push("client");

        clShowTag = b.comment("Always show custom name tag")
                .define("NameTag_AlwaysShow", true);
        clNameTagDist = b.comment("Show name tag if player get close to ship X blocks")
                .defineInRange("NameTag_Distance", 16, 1, 64);
        clAlwaysShowTeamParticleClient = b.comment("Always show team circle indicator particle")
                .define("AlwaysShow_TeamCircle", false);
        clVortexDepth = b.comment("Enable depth while rendering Hadal Vortex block.")
                .define("Depth_HadalVortex", false);
        clCanFlare = b.comment("Can ship spawn Flare lighting effect, CLIENT SIDE only")
                .define("Can_Flare", true);
        clCanSearchlight = b.comment("Can ship spawn Searchlight lighting effect, CLIENT SIDE only")
                .define("Can_Searchlight", true);
        clVolumeTimekeep = b.comment("Timekeeping sound volume")
                .defineInRange("Volume_Timekeeping", 1.0D, 0.0D, 10.0D);
        clVolumeShip = b.comment("Other sound volume")
                .defineInRange("Volume_Ship", 1.0D, 0.0D, 10.0D);
        clVolumeFire = b.comment("Attack sound volume")
                .defineInRange("Volume_Attack", 0.7D, 0.0D, 10.0D);
        clPosHUD = b.comment("HUD position of mounts skills: x, y (0.5D = middle of window)")
                .defineList("Position_HUD", Arrays.asList(0.5D, 0.6D), IS_DBL);

        b.pop();

        CLIENT_SPEC = b.build();
    }


    private ShinColleConfig() {}

    /** bake spec values into static fields (call on config loading/reloading) */
    public static void bake()
    {
        //common
        bossCooldown = cBossCooldown.get();
        closeGUIDist = cCloseGUIDist.get();
        chunkloaderMode = cChunkloaderMode.get();
        deathMaxTick = cDeathMaxTick.get();
        debugMode = cDebugMode.get();
        despawnBoss = cDespawnBoss.get();
        despawnMinion = cDespawnMinion.get();
        despawnEgg = cDespawnEgg.get();
        dropGrudge = cDropGrudge.get().floatValue();
        easyMode = cEasyMode.get();
        friendlyFire = cFriendlyFire.get();
        kaitaiAmountSmall = cKaitaiAmountSmall.get();
        kaitaiAmountLarge = cKaitaiAmountLarge.get();
        mobAttackPlayer = cMobAttackPlayer.get();
        shipAttackPlayer = cShipAttackPlayer.get();
        polyAsMn = cPolyAsMn.get();
        radarUpdate = cRadarUpdate.get();
        shipNumPerPage = cShipNumPerPage.get();
        teamCooldown = cTeamCooldown.get();
        useWakamoto = cUseWakamoto.get();
        spawnBossNum = cSpawnBossNum.get();
        spawnMobNum = cSpawnMobNum.get();
        pairDistChest = cPairDistChest.get();
        pairDistWp = cPairDistWp.get();
        tileShipyardSmall = toDoubleArray(tileShipyardSmall, cTileShipyardSmall.get());
        tileShipyardLarge = toDoubleArray(tileShipyardLarge, cTileShipyardLarge.get());
        tileVolCore = toDoubleArray(tileVolCore, cTileVolCore.get());
        tileCrane = toIntArray(tileCrane, cTileCrane.get());
        ringAbility = toIntArray(ringAbility, cRingAbility.get());
        infLiquid = toIntArray(infLiquid, cInfLiquid.get());
        itemShipTank = toIntArray(itemShipTank, cItemShipTank.get());

        canTeleport = cCanTeleport.get();
        checkRing = cCheckRing.get();
        timeKeeping = cTimeKeeping.get();
        baseCaressMorale = cBaseCaressMorale.get();
        modernLimit = cModernLimit.get();
        searchlightCD = cSearchlightCD.get();
        airplaneDelay = cAirplaneDelay.get();
        baseGrudge = cBaseGrudge.get();
        baseLightAmmo = cBaseLightAmmo.get();
        baseHeavyAmmo = cBaseHeavyAmmo.get();
        maxDmgOnPlayer = cMaxDmgOnPlayer.get();
        itemSlotsLevel = cItemSlotsLevel.get();
        equipSlotsLevel = cEquipSlotsLevel.get();
        dmgSvS = cDmgSvS.get();
        expMod = cExpMod.get();
        scaleShip = toDoubleArray(scaleShip, cScaleShip.get());
        limitShipAttrs = toDoubleArray(limitShipAttrs, cLimitShipAttrs.get());
        scaleBossSmall = toDoubleArray(scaleBossSmall, cScaleBossSmall.get());
        scaleBossLarge = toDoubleArray(scaleBossLarge, cScaleBossLarge.get());
        scaleMobSmall = toDoubleArray(scaleMobSmall, cScaleMobSmall.get());
        scaleMobLarge = toDoubleArray(scaleMobLarge, cScaleMobLarge.get());
        consumeAmmoShip = toIntArray(consumeAmmoShip, cConsumeAmmoShip.get());
        consumeGrudgeShipIdle = toIntArray(consumeGrudgeShipIdle, cConsumeGrudgeShipIdle.get());
        consumeGrudgeAction = toIntArray(consumeGrudgeAction, cConsumeGrudgeAction.get());
        consumeGrudgeTask = toIntArray(consumeGrudgeTask, cConsumeGrudgeTask.get());
        baseAttackSpeed = toIntArray(baseAttackSpeed, cBaseAttackSpeed.get());
        fixedAttackDelay = toIntArray(fixedAttackDelay, cFixedAttackDelay.get());
        expGain = toIntArray(expGain, cExpGain.get());
        expGainTask = toIntArray(expGainTask, cExpGainTask.get());
        mobSpawn = toIntArray(mobSpawn, cMobSpawn.get());
        scaleHeldItem = toDoubleArray(scaleHeldItem, cScaleHeldItem.get());
        drumLiquid = toIntArray(drumLiquid, cDrumLiquid.get());
        shipTeleport = toIntArray(shipTeleport, cShipTeleport.get());
        tickFishing = toIntArray(tickFishing, cTickFishing.get());
        tickMining = toIntArray(tickMining, cTickMining.get());
        enableTask = toBooleanArray(enableTask, cEnableTask.get());
        itemSlotsClass = toIntArray(itemSlotsClass, cItemSlotsClass.get());
        itemSlotsType = toIntArray(itemSlotsType, cItemSlotsType.get());
        equipSlotsClass = toIntArray(equipSlotsClass, cEquipSlotsClass.get());
        equipPagesLevel = toIntArray(equipPagesLevel, cEquipPagesLevel.get());

        polyOreBaseRate = cPolyOreBaseRate.get();
        polyGravelBaseRate = cPolyGravelBaseRate.get();
        polyGravelBaseBlock = toBooleanArray(polyGravelBaseBlock, cPolyGravelBaseBlock.get());
    }

    /** bake CLIENT spec only */
    public static void bakeClient()
    {
        showTag = clShowTag.get();
        nameTagDist = clNameTagDist.get();
        alwaysShowTeamParticle = clAlwaysShowTeamParticleClient.get();
        vortexDepth = clVortexDepth.get();
        canFlare = clCanFlare.get();
        canSearchlight = clCanSearchlight.get();
        volumeTimekeep = clVolumeTimekeep.get().floatValue();
        volumeShip = clVolumeShip.get().floatValue();
        volumeFire = clVolumeFire.get().floatValue();
        posHUD = toDoubleArray(posHUD, clPosHUD.get());
    }

    /* ================= helpers ================= */

    /** keep array size, copy list values in (same contract as legacy getIntArrayFromConfig) */
    private static int[] toIntArray(int[] defaultValue, List<? extends Integer> list)
    {
        if (list != null && list.size() == defaultValue.length)
        {
            int[] out = new int[defaultValue.length];
            for (int i = 0; i < out.length; i++) out[i] = list.get(i);
            return out;
        }
        return defaultValue;
    }

    private static double[] toDoubleArray(double[] defaultValue, List<? extends Double> list)
    {
        if (list != null && list.size() == defaultValue.length)
        {
            double[] out = new double[defaultValue.length];
            for (int i = 0; i < out.length; i++) out[i] = list.get(i);
            return out;
        }
        return defaultValue;
    }

    private static boolean[] toBooleanArray(boolean[] defaultValue, List<? extends Boolean> list)
    {
        if (list != null && list.size() == defaultValue.length)
        {
            boolean[] out = new boolean[defaultValue.length];
            for (int i = 0; i < out.length; i++) out[i] = list.get(i);
            return out;
        }
        return defaultValue;
    }

    /** init custom INI configs into <gamedir>/config/shincolle/ */
    public static void initFileConfigs() throws Exception
    {
        File dir = FMLPaths.CONFIGDIR.get().resolve(Reference.MOD_ID).toFile();

        configSound = new ConfigSound(new File(dir, "sounds.cfg"));
        configLoot = new ConfigLoot(new File(dir, "loottable.cfg"));
        configMining = new ConfigMining(new File(dir, "mining.cfg"));

        configSound.runConfig();
        configLoot.runConfig();
        configMining.runConfig();

        LogHelper.info("INFO: custom config loaded from " + dir);
    }

    /* ================= legacy getters (need baked arrays) ================= */

    public static int getSlotsItemByIcon(int shipIcon)
    {
        switch (shipIcon)
        {
        case ID.ShipIconType.DESTROYER:
            return itemSlotsClass[0];
        case ID.ShipIconType.LIGHT_CRUISER:
        case ID.ShipIconType.HEAVY_CRUISER:
        case ID.ShipIconType.TORPEDO_CRUISER:
            return itemSlotsClass[1];
        case ID.ShipIconType.LIGHT_CARRIER:
        case ID.ShipIconType.STANDARD_CARRIER:
            return itemSlotsClass[2];
        case ID.ShipIconType.BATTLESHIP:
            return itemSlotsClass[3];
        case ID.ShipIconType.TRANSPORT:
            return itemSlotsClass[4];
        case ID.ShipIconType.SUBMARINE:
            return itemSlotsClass[5];
        case ID.ShipIconType.DEMON:
            return itemSlotsClass[6];
        case ID.ShipIconType.HIME:
            return itemSlotsClass[7];
        default:
            return 0;
        }
    }

    public static int getSlotsEquipByIcon(int shipIcon)
    {
        switch (shipIcon)
        {
        case ID.ShipIconType.DESTROYER:
            return equipSlotsClass[0];
        case ID.ShipIconType.LIGHT_CRUISER:
        case ID.ShipIconType.HEAVY_CRUISER:
        case ID.ShipIconType.TORPEDO_CRUISER:
            return equipSlotsClass[1];
        case ID.ShipIconType.LIGHT_CARRIER:
        case ID.ShipIconType.STANDARD_CARRIER:
            return equipSlotsClass[2];
        case ID.ShipIconType.BATTLESHIP:
            return equipSlotsClass[3];
        case ID.ShipIconType.TRANSPORT:
            return equipSlotsClass[4];
        case ID.ShipIconType.SUBMARINE:
            return equipSlotsClass[5];
        case ID.ShipIconType.DEMON:
            return equipSlotsClass[6];
        case ID.ShipIconType.HIME:
            return equipSlotsClass[7];
        default:
            return 0;
        }
    }

    /** input page number, return enable level */
    public static int getPagesEquipEnableLevel(int page)
    {
        switch (page)
        {
        case 0:
            return equipPagesLevel[0];
        case 1:
            return equipPagesLevel[1];
        case 2:
            return equipPagesLevel[2];
        default:
            return 0;
        }
    }


}

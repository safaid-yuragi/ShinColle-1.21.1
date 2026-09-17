package com.lulan.shincolle.registry;

import java.util.function.Supplier;

import com.lulan.shincolle.entity.*;
import com.lulan.shincolle.item.BasicEntityItem;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * entity type registration hub (Phase 2-8).
 *
 * 87 entity types: 44 player ships + 20 hostile mobs + 22 summons/
 * projectiles + 1 custom item entity. Class id <-> registry name mapping
 * lives in {@link ShipClassRegistry}.
 */
public final class ModEntities
{

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
        DeferredRegister.create(net.minecraft.core.registries.BuiltInRegistries.ENTITY_TYPE, Reference.MOD_ID);



    public static final DeferredHolder<EntityType<?>, EntityType<EntityAbyssMissile>> ABYSS_MISSILE =
        ENTITY_TYPES.register("abyss_missile", () -> EntityType.Builder.<EntityAbyssMissile>of(EntityAbyssMissile::new, MobCategory.MISC)
            .sized(1.0F, 1.0F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "abyss_missile"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityAirfieldHime>> AIRFIELD_HIME =
        ENTITY_TYPES.register("airfield_hime", () -> EntityType.Builder.of(EntityAirfieldHime::new, MobCategory.CREATURE)
            .sized(0.7F, 1.9F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "airfield_hime"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityAirplane>> AIRPLANE =
        ENTITY_TYPES.register("airplane", () -> EntityType.Builder.of(EntityAirplane::new, MobCategory.CREATURE)
            .sized(0.5F, 0.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "airplane"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityAirplaneT>> AIRPLANE_T =
        ENTITY_TYPES.register("airplane_t", () -> EntityType.Builder.of(EntityAirplaneT::new, MobCategory.CREATURE)
            .sized(0.5F, 0.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "airplane_t"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityAirplaneTMob>> AIRPLANE_T_MOB =
        ENTITY_TYPES.register("airplane_t_mob", () -> EntityType.Builder.of(EntityAirplaneTMob::new, MobCategory.CREATURE)
            .sized(0.5F, 0.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "airplane_t_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityAirplaneTakoyaki>> AIRPLANE_TAKOYAKI =
        ENTITY_TYPES.register("airplane_takoyaki", () -> EntityType.Builder.of(EntityAirplaneTakoyaki::new, MobCategory.CREATURE)
            .sized(0.6F, 0.6F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "airplane_takoyaki"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityAirplaneZero>> AIRPLANE_ZERO =
        ENTITY_TYPES.register("airplane_zero", () -> EntityType.Builder.of(EntityAirplaneZero::new, MobCategory.CREATURE)
            .sized(0.5F, 0.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "airplane_zero"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityAirplaneZeroMob>> AIRPLANE_ZERO_MOB =
        ENTITY_TYPES.register("airplane_zero_mob", () -> EntityType.Builder.of(EntityAirplaneZeroMob::new, MobCategory.CREATURE)
            .sized(0.5F, 0.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "airplane_zero_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBBHaruna>> BATTLESHIP_HARUNA =
        ENTITY_TYPES.register("battleship_haruna", () -> EntityType.Builder.of(EntityBBHaruna::new, MobCategory.CREATURE)
            .sized(0.6F, 1.875F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_haruna"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBBHarunaMob>> BATTLESHIP_HARUNA_MOB =
        ENTITY_TYPES.register("battleship_haruna_mob", () -> EntityType.Builder.of(EntityBBHarunaMob::new, MobCategory.MONSTER)
            .sized(0.6F, 1.875F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_haruna_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBBHiei>> BATTLESHIP_HIEI =
        ENTITY_TYPES.register("battleship_hiei", () -> EntityType.Builder.of(EntityBBHiei::new, MobCategory.CREATURE)
            .sized(0.6F, 1.875F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_hiei"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBBHieiMob>> BATTLESHIP_HIEI_MOB =
        ENTITY_TYPES.register("battleship_hiei_mob", () -> EntityType.Builder.of(EntityBBHieiMob::new, MobCategory.MONSTER)
            .sized(0.6F, 1.875F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_hiei_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBBKirishima>> BATTLESHIP_KIRISHIMA =
        ENTITY_TYPES.register("battleship_kirishima", () -> EntityType.Builder.of(EntityBBKirishima::new, MobCategory.CREATURE)
            .sized(0.6F, 1.875F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_kirishima"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBBKirishimaMob>> BATTLESHIP_KIRISHIMA_MOB =
        ENTITY_TYPES.register("battleship_kirishima_mob", () -> EntityType.Builder.of(EntityBBKirishimaMob::new, MobCategory.MONSTER)
            .sized(0.6F, 1.875F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_kirishima_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBBKongou>> BATTLESHIP_KONGOU =
        ENTITY_TYPES.register("battleship_kongou", () -> EntityType.Builder.of(EntityBBKongou::new, MobCategory.CREATURE)
            .sized(0.6F, 1.875F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_kongou"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBBKongouMob>> BATTLESHIP_KONGOU_MOB =
        ENTITY_TYPES.register("battleship_kongou_mob", () -> EntityType.Builder.of(EntityBBKongouMob::new, MobCategory.MONSTER)
            .sized(0.6F, 1.875F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_kongou_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBattleshipHime>> BATTLESHIP_HIME =
        ENTITY_TYPES.register("battleship_hime", () -> EntityType.Builder.of(EntityBattleshipHime::new, MobCategory.CREATURE)
            .sized(0.7F, 2.05F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_hime"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBattleshipNGT>> BATTLESHIP_NAGATO =
        ENTITY_TYPES.register("battleship_nagato", () -> EntityType.Builder.of(EntityBattleshipNGT::new, MobCategory.CREATURE)
            .sized(0.7F, 2.0F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_nagato"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBattleshipNGTMob>> BATTLESHIP_NAGATO_MOB =
        ENTITY_TYPES.register("battleship_nagato_mob", () -> EntityType.Builder.of(EntityBattleshipNGTMob::new, MobCategory.MONSTER)
            .sized(0.7F, 2.0F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_nagato_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBattleshipRe>> BATTLESHIP_RE =
        ENTITY_TYPES.register("battleship_re", () -> EntityType.Builder.of(EntityBattleshipRe::new, MobCategory.CREATURE)
            .sized(0.6F, 1.55F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_re"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBattleshipRu>> BATTLESHIP_RU =
        ENTITY_TYPES.register("battleship_ru", () -> EntityType.Builder.of(EntityBattleshipRu::new, MobCategory.CREATURE)
            .sized(0.7F, 1.8F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_ru"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBattleshipTa>> BATTLESHIP_TA =
        ENTITY_TYPES.register("battleship_ta", () -> EntityType.Builder.of(EntityBattleshipTa::new, MobCategory.CREATURE)
            .sized(0.7F, 1.8F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_ta"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBattleshipYMT>> BATTLESHIP_YAMATO =
        ENTITY_TYPES.register("battleship_yamato", () -> EntityType.Builder.of(EntityBattleshipYMT::new, MobCategory.CREATURE)
            .sized(0.8F, 2.1F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_yamato"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityBattleshipYMTMob>> BATTLESHIP_YAMATO_MOB =
        ENTITY_TYPES.register("battleship_yamato_mob", () -> EntityType.Builder.of(EntityBattleshipYMTMob::new, MobCategory.MONSTER)
            .sized(0.8F, 2.1F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "battleship_yamato_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCAAtago>> CRUISER_ATAGO =
        ENTITY_TYPES.register("cruiser_atago", () -> EntityType.Builder.of(EntityCAAtago::new, MobCategory.CREATURE)
            .sized(0.7F, 1.75F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "cruiser_atago"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCAAtagoMob>> CRUISER_ATAGO_MOB =
        ENTITY_TYPES.register("cruiser_atago_mob", () -> EntityType.Builder.of(EntityCAAtagoMob::new, MobCategory.MONSTER)
            .sized(0.75F, 1.75F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "cruiser_atago_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCAHime>> CA_HIME =
        ENTITY_TYPES.register("ca_hime", () -> EntityType.Builder.of(EntityCAHime::new, MobCategory.CREATURE)
            .sized(0.7F, 1.2F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "ca_hime"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCANe>> HEAVY_CRUISER_NE =
        ENTITY_TYPES.register("heavy_cruiser_ne", () -> EntityType.Builder.of(EntityCANe::new, MobCategory.CREATURE)
            .sized(0.6F, 1.3F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "heavy_cruiser_ne"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCARi>> HEAVY_CRUISER_RI =
        ENTITY_TYPES.register("heavy_cruiser_ri", () -> EntityType.Builder.of(EntityCARi::new, MobCategory.CREATURE)
            .sized(0.75F, 1.7F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "heavy_cruiser_ri"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCATakao>> CRUISER_TAKAO =
        ENTITY_TYPES.register("cruiser_takao", () -> EntityType.Builder.of(EntityCATakao::new, MobCategory.CREATURE)
            .sized(0.7F, 1.75F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "cruiser_takao"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCATakaoMob>> CRUISER_TAKAO_MOB =
        ENTITY_TYPES.register("cruiser_takao_mob", () -> EntityType.Builder.of(EntityCATakaoMob::new, MobCategory.MONSTER)
            .sized(0.75F, 1.75F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "cruiser_takao_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCLTatsuta>> CRUISER_TATSUTA =
        ENTITY_TYPES.register("cruiser_tatsuta", () -> EntityType.Builder.of(EntityCLTatsuta::new, MobCategory.CREATURE)
            .sized(0.75F, 1.65F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "cruiser_tatsuta"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCLTatsutaMob>> CRUISER_TATSUTA_MOB =
        ENTITY_TYPES.register("cruiser_tatsuta_mob", () -> EntityType.Builder.of(EntityCLTatsutaMob::new, MobCategory.MONSTER)
            .sized(0.75F, 1.65F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "cruiser_tatsuta_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCLTenryuu>> CRUISER_TENRYUU =
        ENTITY_TYPES.register("cruiser_tenryuu", () -> EntityType.Builder.of(EntityCLTenryuu::new, MobCategory.CREATURE)
            .sized(0.75F, 1.65F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "cruiser_tenryuu"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCLTenryuuMob>> CRUISER_TENRYUU_MOB =
        ENTITY_TYPES.register("cruiser_tenryuu_mob", () -> EntityType.Builder.of(EntityCLTenryuuMob::new, MobCategory.MONSTER)
            .sized(0.75F, 1.65F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "cruiser_tenryuu_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCarrierAkagi>> CARRIER_AKAGI =
        ENTITY_TYPES.register("carrier_akagi", () -> EntityType.Builder.of(EntityCarrierAkagi::new, MobCategory.CREATURE)
            .sized(0.6F, 1.875F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "carrier_akagi"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCarrierAkagiMob>> CARRIER_AKAGI_MOB =
        ENTITY_TYPES.register("carrier_akagi_mob", () -> EntityType.Builder.of(EntityCarrierAkagiMob::new, MobCategory.MONSTER)
            .sized(0.6F, 1.875F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "carrier_akagi_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCarrierHime>> CARRIER_HIME =
        ENTITY_TYPES.register("carrier_hime", () -> EntityType.Builder.of(EntityCarrierHime::new, MobCategory.CREATURE)
            .sized(0.7F, 1.9F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "carrier_hime"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCarrierKaga>> CARRIER_KAGA =
        ENTITY_TYPES.register("carrier_kaga", () -> EntityType.Builder.of(EntityCarrierKaga::new, MobCategory.CREATURE)
            .sized(0.6F, 1.875F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "carrier_kaga"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCarrierKagaMob>> CARRIER_KAGA_MOB =
        ENTITY_TYPES.register("carrier_kaga_mob", () -> EntityType.Builder.of(EntityCarrierKagaMob::new, MobCategory.MONSTER)
            .sized(0.6F, 1.875F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "carrier_kaga_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCarrierWD>> CARRIER_WD =
        ENTITY_TYPES.register("carrier_wd", () -> EntityType.Builder.of(EntityCarrierWD::new, MobCategory.CREATURE)
            .sized(0.7F, 1.9F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "carrier_wd"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityCarrierWo>> CARRIER_WO =
        ENTITY_TYPES.register("carrier_wo", () -> EntityType.Builder.of(EntityCarrierWo::new, MobCategory.CREATURE)
            .sized(0.7F, 1.9F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "carrier_wo"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerAkatsuki>> DESTROYER_AKATSUKI =
        ENTITY_TYPES.register("destroyer_akatsuki", () -> EntityType.Builder.of(EntityDestroyerAkatsuki::new, MobCategory.CREATURE)
            .sized(0.5F, 1.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_akatsuki"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerAkatsukiMob>> DESTROYER_AKATSUKI_MOB =
        ENTITY_TYPES.register("destroyer_akatsuki_mob", () -> EntityType.Builder.of(EntityDestroyerAkatsukiMob::new, MobCategory.MONSTER)
            .sized(0.5F, 1.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_akatsuki_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerHa>> DESTROYER_HA =
        ENTITY_TYPES.register("destroyer_ha", () -> EntityType.Builder.of(EntityDestroyerHa::new, MobCategory.CREATURE)
            .sized(0.9F, 1.7F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_ha"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerHibiki>> DESTROYER_HIBIKI =
        ENTITY_TYPES.register("destroyer_hibiki", () -> EntityType.Builder.of(EntityDestroyerHibiki::new, MobCategory.CREATURE)
            .sized(0.5F, 1.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_hibiki"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerHibikiMob>> DESTROYER_HIBIKI_MOB =
        ENTITY_TYPES.register("destroyer_hibiki_mob", () -> EntityType.Builder.of(EntityDestroyerHibikiMob::new, MobCategory.MONSTER)
            .sized(0.5F, 1.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_hibiki_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerHime>> DESTROYER_HIME =
        ENTITY_TYPES.register("destroyer_hime", () -> EntityType.Builder.of(EntityDestroyerHime::new, MobCategory.CREATURE)
            .sized(0.6F, 1.55F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_hime"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerI>> DESTROYER_I =
        ENTITY_TYPES.register("destroyer_i", () -> EntityType.Builder.of(EntityDestroyerI::new, MobCategory.CREATURE)
            .sized(0.9F, 1.7F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_i"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerIkazuchi>> DESTROYER_IKAZUCHI =
        ENTITY_TYPES.register("destroyer_ikazuchi", () -> EntityType.Builder.of(EntityDestroyerIkazuchi::new, MobCategory.CREATURE)
            .sized(0.5F, 1.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_ikazuchi"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerIkazuchiMob>> DESTROYER_IKAZUCHI_MOB =
        ENTITY_TYPES.register("destroyer_ikazuchi_mob", () -> EntityType.Builder.of(EntityDestroyerIkazuchiMob::new, MobCategory.MONSTER)
            .sized(0.5F, 1.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_ikazuchi_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerInazuma>> DESTROYER_INAZUMA =
        ENTITY_TYPES.register("destroyer_inazuma", () -> EntityType.Builder.of(EntityDestroyerInazuma::new, MobCategory.CREATURE)
            .sized(0.5F, 1.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_inazuma"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerInazumaMob>> DESTROYER_INAZUMA_MOB =
        ENTITY_TYPES.register("destroyer_inazuma_mob", () -> EntityType.Builder.of(EntityDestroyerInazumaMob::new, MobCategory.MONSTER)
            .sized(0.5F, 1.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_inazuma_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerNi>> DESTROYER_NI =
        ENTITY_TYPES.register("destroyer_ni", () -> EntityType.Builder.of(EntityDestroyerNi::new, MobCategory.CREATURE)
            .sized(0.9F, 1.9F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_ni"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerRo>> DESTROYER_RO =
        ENTITY_TYPES.register("destroyer_ro", () -> EntityType.Builder.of(EntityDestroyerRo::new, MobCategory.CREATURE)
            .sized(0.9F, 1.7F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_ro"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerShimakaze>> DESTROYER_SHIMAKAZE =
        ENTITY_TYPES.register("destroyer_shimakaze", () -> EntityType.Builder.of(EntityDestroyerShimakaze::new, MobCategory.CREATURE)
            .sized(0.5F, 1.6F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_shimakaze"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerShimakazeMob>> DESTROYER_SHIMAKAZE_MOB =
        ENTITY_TYPES.register("destroyer_shimakaze_mob", () -> EntityType.Builder.of(EntityDestroyerShimakazeMob::new, MobCategory.MONSTER)
            .sized(0.5F, 1.6F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "destroyer_shimakaze_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityFloatingFort>> FLOATING_FORT =
        ENTITY_TYPES.register("floating_fort", () -> EntityType.Builder.of(EntityFloatingFort::new, MobCategory.CREATURE)
            .sized(0.5F, 0.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "floating_fort"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityHarbourHime>> HARBOUR_HIME =
        ENTITY_TYPES.register("harbour_hime", () -> EntityType.Builder.of(EntityHarbourHime::new, MobCategory.CREATURE)
            .sized(0.7F, 2.2F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "harbour_hime"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityIsolatedHime>> ISOLATED_HIME =
        ENTITY_TYPES.register("isolated_hime", () -> EntityType.Builder.of(EntityIsolatedHime::new, MobCategory.CREATURE)
            .sized(0.6F, 1.6F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "isolated_hime"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityMidwayHime>> MIDWAY_HIME =
        ENTITY_TYPES.register("midway_hime", () -> EntityType.Builder.of(EntityMidwayHime::new, MobCategory.CREATURE)
            .sized(0.7F, 2.0F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "midway_hime"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityMountAfH>> MOUNT_AIRFIELD =
        ENTITY_TYPES.register("mount_airfield", () -> EntityType.Builder.of(EntityMountAfH::new, MobCategory.CREATURE)
            .sized(1.9F, 1.3F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "mount_airfield"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityMountBaH>> MOUNT_BATTLESHIP =
        ENTITY_TYPES.register("mount_battleship", () -> EntityType.Builder.of(EntityMountBaH::new, MobCategory.CREATURE)
            .sized(1.9F, 3.1F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "mount_battleship"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityMountCaH>> MOUNT_CARRIER =
        ENTITY_TYPES.register("mount_carrier", () -> EntityType.Builder.of(EntityMountCaH::new, MobCategory.CREATURE)
            .sized(1.9F, 2.1F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "mount_carrier"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityMountCaWD>> MOUNT_CARRIER_WD =
        ENTITY_TYPES.register("mount_carrier_wd", () -> EntityType.Builder.of(EntityMountCaWD::new, MobCategory.CREATURE)
            .sized(1.9F, 2.1F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "mount_carrier_wd"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityMountHbH>> MOUNT_HARBOUR =
        ENTITY_TYPES.register("mount_harbour", () -> EntityType.Builder.of(EntityMountHbH::new, MobCategory.CREATURE)
            .sized(1.9F, 1.6F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "mount_harbour"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityMountIsH>> MOUNT_ISOLATED =
        ENTITY_TYPES.register("mount_isolated", () -> EntityType.Builder.of(EntityMountIsH::new, MobCategory.CREATURE)
            .sized(1.6F, 2.2F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "mount_isolated"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityMountMiH>> MOUNT_MIDWAY =
        ENTITY_TYPES.register("mount_midway", () -> EntityType.Builder.of(EntityMountMiH::new, MobCategory.CREATURE)
            .sized(2.5F, 2.9F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "mount_midway"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityMountSuH>> MOUNT_SUBMARINE =
        ENTITY_TYPES.register("mount_submarine", () -> EntityType.Builder.of(EntityMountSuH::new, MobCategory.CREATURE)
            .sized(1.8F, 1.6F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "mount_submarine"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityNorthernHime>> NORTHERN_HIME =
        ENTITY_TYPES.register("northern_hime", () -> EntityType.Builder.of(EntityNorthernHime::new, MobCategory.CREATURE)
            .sized(0.5F, 0.9F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "northern_hime"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityProjectileBeam>> PROJECTILE_BEAM =
        ENTITY_TYPES.register("projectile_beam", () -> EntityType.Builder.of(EntityProjectileBeam::new, MobCategory.MISC)
            .sized(1.0F, 1.0F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "projectile_beam"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityProjectileStatic>> PROJECTILE_STATIC =
        ENTITY_TYPES.register("projectile_static", () -> EntityType.Builder.of(EntityProjectileStatic::new, MobCategory.MISC)
            .sized(0.5F, 0.5F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "projectile_static"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityRensouhou>> RENSOUHOU =
        ENTITY_TYPES.register("rensouhou", () -> EntityType.Builder.of(EntityRensouhou::new, MobCategory.CREATURE)
            .sized(0.3F, 0.7F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "rensouhou"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityRensouhouMob>> RENSOUHOU_MOB =
        ENTITY_TYPES.register("rensouhou_mob", () -> EntityType.Builder.of(EntityRensouhouMob::new, MobCategory.CREATURE)
            .sized(0.3F, 0.7F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "rensouhou_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityRensouhouS>> RENSOUHOU_S =
        ENTITY_TYPES.register("rensouhou_s", () -> EntityType.Builder.of(EntityRensouhouS::new, MobCategory.CREATURE)
            .sized(0.5F, 1.4F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "rensouhou_s"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntitySSNH>> SUBMARINE_NEW_HIME =
        ENTITY_TYPES.register("submarine_new_hime", () -> EntityType.Builder.of(EntitySSNH::new, MobCategory.CREATURE)
            .sized(0.5F, 0.9F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "submarine_new_hime"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityShipFishingHook>> SHIP_FISHING_HOOK =
        ENTITY_TYPES.register("ship_fishing_hook", () -> EntityType.Builder.of(EntityShipFishingHook::new, MobCategory.MISC)
            .sized(0.25F, 0.25F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "ship_fishing_hook"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntitySubmHime>> SUBMARINE_HIME =
        ENTITY_TYPES.register("submarine_hime", () -> EntityType.Builder.of(EntitySubmHime::new, MobCategory.CREATURE)
            .sized(0.7F, 1.85F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "submarine_hime"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntitySubmKa>> SUBMARINE_KA =
        ENTITY_TYPES.register("submarine_ka", () -> EntityType.Builder.of(EntitySubmKa::new, MobCategory.CREATURE)
            .sized(0.6F, 1.8F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "submarine_ka"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntitySubmRo500>> SUBMARINE_RO500 =
        ENTITY_TYPES.register("submarine_ro500", () -> EntityType.Builder.of(EntitySubmRo500::new, MobCategory.CREATURE)
            .sized(0.6F, 1.4F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "submarine_ro500"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntitySubmRo500Mob>> SUBMARINE_RO500_MOB =
        ENTITY_TYPES.register("submarine_ro500_mob", () -> EntityType.Builder.of(EntitySubmRo500Mob::new, MobCategory.MONSTER)
            .sized(0.6F, 1.4F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "submarine_ro500_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntitySubmSo>> SUBMARINE_SO =
        ENTITY_TYPES.register("submarine_so", () -> EntityType.Builder.of(EntitySubmSo::new, MobCategory.CREATURE)
            .sized(0.6F, 1.8F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "submarine_so"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntitySubmU511>> SUBMARINE_U511 =
        ENTITY_TYPES.register("submarine_u511", () -> EntityType.Builder.of(EntitySubmU511::new, MobCategory.CREATURE)
            .sized(0.6F, 1.4F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "submarine_u511"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntitySubmU511Mob>> SUBMARINE_U511_MOB =
        ENTITY_TYPES.register("submarine_u511_mob", () -> EntityType.Builder.of(EntitySubmU511Mob::new, MobCategory.MONSTER)
            .sized(0.6F, 1.4F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "submarine_u511_mob"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntitySubmYo>> SUBMARINE_YO =
        ENTITY_TYPES.register("submarine_yo", () -> EntityType.Builder.of(EntitySubmYo::new, MobCategory.CREATURE)
            .sized(0.6F, 1.8F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "submarine_yo"));

    public static final DeferredHolder<EntityType<?>, EntityType<EntityTransportWa>> TRANSPORT_WA =
        ENTITY_TYPES.register("transport_wa", () -> EntityType.Builder.of(EntityTransportWa::new, MobCategory.CREATURE)
            .sized(0.7F, 1.53F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "transport_wa"));

    public static final DeferredHolder<EntityType<?>, EntityType<BasicEntityItem>> BASIC_ENTITY_ITEM =
        ENTITY_TYPES.register("basic_entity_item", () -> EntityType.Builder.<BasicEntityItem>of(BasicEntityItem::new, MobCategory.MISC)
            .sized(0.25F, 0.25F).clientTrackingRange(10).updateInterval(3).fireImmune()
            .build(Reference.MOD_ID + ":" + "basic_entity_item"));


    /** Phase 2-9: attribute supplier registration (called from mod ctor) */
    public static void registerAttributes(net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent event)
    {
        event.put(ABYSS_MISSILE.get(), EntityAbyssMissile.createAttributes().build());
        event.put(AIRFIELD_HIME.get(), BasicEntityShip.createAttributes().build());
        event.put(BATTLESHIP_HARUNA.get(), BasicEntityShip.createAttributes().build());
        event.put(BATTLESHIP_HIEI.get(), BasicEntityShip.createAttributes().build());
        event.put(BATTLESHIP_HIME.get(), BasicEntityShip.createAttributes().build());
        event.put(BATTLESHIP_KIRISHIMA.get(), BasicEntityShip.createAttributes().build());
        event.put(BATTLESHIP_KONGOU.get(), BasicEntityShip.createAttributes().build());
        event.put(BATTLESHIP_NAGATO.get(), BasicEntityShip.createAttributes().build());
        event.put(BATTLESHIP_RE.get(), BasicEntityShip.createAttributes().build());
        event.put(BATTLESHIP_RU.get(), BasicEntityShip.createAttributes().build());
        event.put(BATTLESHIP_TA.get(), BasicEntityShip.createAttributes().build());
        event.put(BATTLESHIP_YAMATO.get(), BasicEntityShip.createAttributes().build());
        event.put(CARRIER_AKAGI.get(), BasicEntityShip.createAttributes().build());
        event.put(CARRIER_HIME.get(), BasicEntityShip.createAttributes().build());
        event.put(CARRIER_KAGA.get(), BasicEntityShip.createAttributes().build());
        event.put(CARRIER_WD.get(), BasicEntityShip.createAttributes().build());
        event.put(CARRIER_WO.get(), BasicEntityShip.createAttributes().build());
        event.put(CA_HIME.get(), BasicEntityShip.createAttributes().build());
        event.put(CRUISER_ATAGO.get(), BasicEntityShip.createAttributes().build());
        event.put(CRUISER_TAKAO.get(), BasicEntityShip.createAttributes().build());
        event.put(CRUISER_TATSUTA.get(), BasicEntityShip.createAttributes().build());
        event.put(CRUISER_TENRYUU.get(), BasicEntityShip.createAttributes().build());
        event.put(DESTROYER_AKATSUKI.get(), BasicEntityShip.createAttributes().build());
        event.put(DESTROYER_HA.get(), BasicEntityShip.createAttributes().build());
        event.put(DESTROYER_HIBIKI.get(), BasicEntityShip.createAttributes().build());
        event.put(DESTROYER_HIME.get(), BasicEntityShip.createAttributes().build());
        event.put(DESTROYER_I.get(), BasicEntityShip.createAttributes().build());
        event.put(DESTROYER_IKAZUCHI.get(), BasicEntityShip.createAttributes().build());
        event.put(DESTROYER_INAZUMA.get(), BasicEntityShip.createAttributes().build());
        event.put(DESTROYER_NI.get(), BasicEntityShip.createAttributes().build());
        event.put(DESTROYER_RO.get(), BasicEntityShip.createAttributes().build());
        event.put(DESTROYER_SHIMAKAZE.get(), BasicEntityShip.createAttributes().build());
        event.put(HARBOUR_HIME.get(), BasicEntityShip.createAttributes().build());
        event.put(HEAVY_CRUISER_NE.get(), BasicEntityShip.createAttributes().build());
        event.put(HEAVY_CRUISER_RI.get(), BasicEntityShip.createAttributes().build());
        event.put(ISOLATED_HIME.get(), BasicEntityShip.createAttributes().build());
        event.put(MIDWAY_HIME.get(), BasicEntityShip.createAttributes().build());
        event.put(NORTHERN_HIME.get(), BasicEntityShip.createAttributes().build());
        event.put(SUBMARINE_HIME.get(), BasicEntityShip.createAttributes().build());
        event.put(SUBMARINE_KA.get(), BasicEntityShip.createAttributes().build());
        event.put(SUBMARINE_NEW_HIME.get(), BasicEntityShip.createAttributes().build());
        event.put(SUBMARINE_RO500.get(), BasicEntityShip.createAttributes().build());
        event.put(SUBMARINE_SO.get(), BasicEntityShip.createAttributes().build());
        event.put(SUBMARINE_U511.get(), BasicEntityShip.createAttributes().build());
        event.put(SUBMARINE_YO.get(), BasicEntityShip.createAttributes().build());
        event.put(TRANSPORT_WA.get(), BasicEntityShip.createAttributes().build());
        event.put(AIRPLANE.get(), BasicEntitySummon.createAttributes().build());
        event.put(AIRPLANE_T.get(), BasicEntitySummon.createAttributes().build());
        event.put(AIRPLANE_TAKOYAKI.get(), BasicEntitySummon.createAttributes().build());
        event.put(AIRPLANE_T_MOB.get(), BasicEntitySummon.createAttributes().build());
        event.put(AIRPLANE_ZERO.get(), BasicEntitySummon.createAttributes().build());
        event.put(AIRPLANE_ZERO_MOB.get(), BasicEntitySummon.createAttributes().build());
        event.put(FLOATING_FORT.get(), BasicEntitySummon.createAttributes().build());
        event.put(MOUNT_AIRFIELD.get(), BasicEntitySummon.createAttributes().build());
        event.put(MOUNT_BATTLESHIP.get(), BasicEntitySummon.createAttributes().build());
        event.put(MOUNT_CARRIER.get(), BasicEntitySummon.createAttributes().build());
        event.put(MOUNT_CARRIER_WD.get(), BasicEntitySummon.createAttributes().build());
        event.put(MOUNT_HARBOUR.get(), BasicEntitySummon.createAttributes().build());
        event.put(MOUNT_ISOLATED.get(), BasicEntitySummon.createAttributes().build());
        event.put(MOUNT_MIDWAY.get(), BasicEntitySummon.createAttributes().build());
        event.put(MOUNT_SUBMARINE.get(), BasicEntitySummon.createAttributes().build());
        event.put(RENSOUHOU.get(), BasicEntitySummon.createAttributes().build());
        event.put(RENSOUHOU_MOB.get(), BasicEntitySummon.createAttributes().build());
        event.put(RENSOUHOU_S.get(), BasicEntitySummon.createAttributes().build());
        event.put(BATTLESHIP_HARUNA_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(BATTLESHIP_HIEI_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(BATTLESHIP_KIRISHIMA_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(BATTLESHIP_KONGOU_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(BATTLESHIP_NAGATO_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(BATTLESHIP_YAMATO_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(CARRIER_AKAGI_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(CARRIER_KAGA_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(CRUISER_ATAGO_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(CRUISER_TAKAO_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(CRUISER_TATSUTA_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(CRUISER_TENRYUU_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(DESTROYER_AKATSUKI_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(DESTROYER_HIBIKI_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(DESTROYER_IKAZUCHI_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(DESTROYER_INAZUMA_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(DESTROYER_SHIMAKAZE_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(SUBMARINE_RO500_MOB.get(), BasicEntityShipHostile.createAttributes().build());
        event.put(SUBMARINE_U511_MOB.get(), BasicEntityShipHostile.createAttributes().build());
    }

    private ModEntities() {}

}

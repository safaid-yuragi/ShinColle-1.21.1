package com.lulan.shincolle.client;

import com.lulan.shincolle.client.render.AbyssMissileRenderer;
import com.lulan.shincolle.client.render.BasicEntityItemRenderer;
import com.lulan.shincolle.client.render.InvisibleEntityRenderer;
import com.lulan.shincolle.client.render.ModModelLayers;
import com.lulan.shincolle.client.render.MountRenderer;
import com.lulan.shincolle.client.render.ShipFishingHookRenderer;
import com.lulan.shincolle.client.render.ShipRenderer;
import com.lulan.shincolle.client.render.SummonRenderer;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.registry.ModEntities;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

/**
 * client-side init (replaces legacy ClientProxy).
 *
 * renderers / layer definitions / particle providers / key mappings are
 * registered here.
 */
@EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT)
public final class ClientSetup
{


    private ClientSetup() {}

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
    {
        //block render layers etc. go here (Phase 7-4)
        LogHelper.info("INFO: client setup done.");
    }

    /** bake all converted model layers */
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        ModModelLayers.register(event);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void ship(EntityRenderersEvent.RegisterRenderers event,
                             DeferredHolder<EntityType<?>, ? extends EntityType<?>> holder)
    {
        event.registerEntityRenderer((EntityType) holder.get(), (EntityRendererProvider) ShipRenderer::new);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void summon(EntityRenderersEvent.RegisterRenderers event,
                               DeferredHolder<EntityType<?>, ? extends EntityType<?>> holder, int miscId)
    {
        event.registerEntityRenderer((EntityType) holder.get(),
            (EntityRendererProvider) (ctx -> new SummonRenderer(ctx, miscId)));
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void mount(EntityRenderersEvent.RegisterRenderers event,
                              DeferredHolder<EntityType<?>, ? extends EntityType<?>> holder, int miscId)
    {
        event.registerEntityRenderer((EntityType) holder.get(),
            (EntityRendererProvider) (ctx -> new MountRenderer(ctx, miscId)));
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        //ships (model/texture resolved per entity via ship class)
        ship(event, ModEntities.AIRFIELD_HIME);
        ship(event, ModEntities.BATTLESHIP_HARUNA);
        ship(event, ModEntities.BATTLESHIP_HARUNA_MOB);
        ship(event, ModEntities.BATTLESHIP_HIEI);
        ship(event, ModEntities.BATTLESHIP_HIEI_MOB);
        ship(event, ModEntities.BATTLESHIP_KIRISHIMA);
        ship(event, ModEntities.BATTLESHIP_KIRISHIMA_MOB);
        ship(event, ModEntities.BATTLESHIP_KONGOU);
        ship(event, ModEntities.BATTLESHIP_KONGOU_MOB);
        ship(event, ModEntities.BATTLESHIP_HIME);
        ship(event, ModEntities.BATTLESHIP_NAGATO);
        ship(event, ModEntities.BATTLESHIP_NAGATO_MOB);
        ship(event, ModEntities.BATTLESHIP_RE);
        ship(event, ModEntities.BATTLESHIP_RU);
        ship(event, ModEntities.BATTLESHIP_TA);
        ship(event, ModEntities.BATTLESHIP_YAMATO);
        ship(event, ModEntities.BATTLESHIP_YAMATO_MOB);
        ship(event, ModEntities.CRUISER_ATAGO);
        ship(event, ModEntities.CRUISER_ATAGO_MOB);
        ship(event, ModEntities.CA_HIME);
        ship(event, ModEntities.HEAVY_CRUISER_NE);
        ship(event, ModEntities.HEAVY_CRUISER_RI);
        ship(event, ModEntities.CRUISER_TAKAO);
        ship(event, ModEntities.CRUISER_TAKAO_MOB);
        ship(event, ModEntities.CRUISER_TATSUTA);
        ship(event, ModEntities.CRUISER_TATSUTA_MOB);
        ship(event, ModEntities.CRUISER_TENRYUU);
        ship(event, ModEntities.CRUISER_TENRYUU_MOB);
        ship(event, ModEntities.CARRIER_AKAGI);
        ship(event, ModEntities.CARRIER_AKAGI_MOB);
        ship(event, ModEntities.CARRIER_HIME);
        ship(event, ModEntities.CARRIER_KAGA);
        ship(event, ModEntities.CARRIER_KAGA_MOB);
        ship(event, ModEntities.CARRIER_WD);
        ship(event, ModEntities.CARRIER_WO);
        ship(event, ModEntities.DESTROYER_AKATSUKI);
        ship(event, ModEntities.DESTROYER_AKATSUKI_MOB);
        ship(event, ModEntities.DESTROYER_HA);
        ship(event, ModEntities.DESTROYER_HIBIKI);
        ship(event, ModEntities.DESTROYER_HIBIKI_MOB);
        ship(event, ModEntities.DESTROYER_HIME);
        ship(event, ModEntities.DESTROYER_I);
        ship(event, ModEntities.DESTROYER_IKAZUCHI);
        ship(event, ModEntities.DESTROYER_IKAZUCHI_MOB);
        ship(event, ModEntities.DESTROYER_INAZUMA);
        ship(event, ModEntities.DESTROYER_INAZUMA_MOB);
        ship(event, ModEntities.DESTROYER_NI);
        ship(event, ModEntities.DESTROYER_RO);
        ship(event, ModEntities.DESTROYER_SHIMAKAZE);
        ship(event, ModEntities.DESTROYER_SHIMAKAZE_MOB);
        ship(event, ModEntities.HARBOUR_HIME);
        ship(event, ModEntities.ISOLATED_HIME);
        ship(event, ModEntities.MIDWAY_HIME);
        ship(event, ModEntities.NORTHERN_HIME);
        ship(event, ModEntities.SUBMARINE_NEW_HIME);
        ship(event, ModEntities.SUBMARINE_HIME);
        ship(event, ModEntities.SUBMARINE_KA);
        ship(event, ModEntities.SUBMARINE_RO500);
        ship(event, ModEntities.SUBMARINE_RO500_MOB);
        ship(event, ModEntities.SUBMARINE_SO);
        ship(event, ModEntities.SUBMARINE_U511);
        ship(event, ModEntities.SUBMARINE_U511_MOB);
        ship(event, ModEntities.SUBMARINE_YO);
        ship(event, ModEntities.TRANSPORT_WA);

        //summons / aircraft
        summon(event, ModEntities.AIRPLANE, ID.ShipMisc.Airplane);
        summon(event, ModEntities.AIRPLANE_T, ID.ShipMisc.AirplaneT);
        summon(event, ModEntities.AIRPLANE_T_MOB, ID.ShipMisc.AirplaneT);
        summon(event, ModEntities.AIRPLANE_TAKOYAKI, ID.ShipMisc.AirplaneTako);
        summon(event, ModEntities.AIRPLANE_ZERO, ID.ShipMisc.AirplaneZero);
        summon(event, ModEntities.AIRPLANE_ZERO_MOB, ID.ShipMisc.AirplaneZero);
        summon(event, ModEntities.FLOATING_FORT, ID.ShipMisc.FloatingFort);
        summon(event, ModEntities.RENSOUHOU, ID.ShipMisc.Rensouhou);
        summon(event, ModEntities.RENSOUHOU_MOB, ID.ShipMisc.Rensouhou);
        summon(event, ModEntities.RENSOUHOU_S, ID.ShipMisc.RensouhouS);

        //mounts
        mount(event, ModEntities.MOUNT_AIRFIELD, ID.ShipMisc.AirfieldMount);
        mount(event, ModEntities.MOUNT_BATTLESHIP, ID.ShipMisc.BattleshipMount);
        mount(event, ModEntities.MOUNT_CARRIER, ID.ShipMisc.CarrierMount);
        mount(event, ModEntities.MOUNT_CARRIER_WD, ID.ShipMisc.CarrierWDMount);
        mount(event, ModEntities.MOUNT_HARBOUR, ID.ShipMisc.HarbourMount);
        mount(event, ModEntities.MOUNT_ISOLATED, ID.ShipMisc.IsloatedMount);
        mount(event, ModEntities.MOUNT_MIDWAY, ID.ShipMisc.MidwayMount);
        mount(event, ModEntities.MOUNT_SUBMARINE, ID.ShipMisc.SubmMount);

        //misc
        event.registerEntityRenderer(ModEntities.ABYSS_MISSILE.get(), AbyssMissileRenderer::new);
        event.registerEntityRenderer(ModEntities.PROJECTILE_BEAM.get(), InvisibleEntityRenderer::new);
        event.registerEntityRenderer(ModEntities.PROJECTILE_STATIC.get(), InvisibleEntityRenderer::new);
        event.registerEntityRenderer(ModEntities.SHIP_FISHING_HOOK.get(), ShipFishingHookRenderer::new);
        event.registerEntityRenderer(ModEntities.BASIC_ENTITY_ITEM.get(), BasicEntityItemRenderer::new);
    }


}

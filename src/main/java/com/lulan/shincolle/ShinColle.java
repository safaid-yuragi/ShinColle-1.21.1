package com.lulan.shincolle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.entity.BasicEntitySummon;
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.registry.ModAttachments;
import com.lulan.shincolle.registry.ModBlockEntities;
import com.lulan.shincolle.registry.ModBlocks;
import com.lulan.shincolle.registry.ModComponents;
import com.lulan.shincolle.registry.ModFeatures;
import com.lulan.shincolle.registry.ModLootModifiers;
import com.lulan.shincolle.registry.ModRecipeSerializers;
import com.lulan.shincolle.registry.ModEntities;
import com.lulan.shincolle.registry.ModItems;
import com.lulan.shincolle.registry.ModMenus;
import com.lulan.shincolle.registry.ModParticles;
import com.lulan.shincolle.registry.ModSounds;
import com.lulan.shincolle.registry.ModTabs;
import com.lulan.shincolle.registry.ShipClassRegistry;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(Reference.MOD_ID)
public class ShinColle
{

    public static final String MOD_ID = Reference.MOD_ID;
    public static final Logger LOGGER = LoggerFactory.getLogger(Reference.MOD_NAME);


    public ShinColle(IEventBus modBus, ModContainer container)
    {
        //registry (deferred)
        ModBlocks.BLOCKS.register(modBus);
        ModBlocks.ITEMS.register(modBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modBus);
        ModItems.ITEMS.register(modBus);
        ModEntities.ENTITY_TYPES.register(modBus);
        ModSounds.SOUNDS.register(modBus);
        ModParticles.PARTICLE_TYPES.register(modBus);
        ModMenus.MENUS.register(modBus);
        ModAttachments.ATTACHMENTS.register(modBus);
        ModTabs.TABS.register(modBus);
        ModComponents.COMPONENTS.register(modBus);
        ModRecipeSerializers.RECIPE_SERIALIZERS.register(modBus);
        ModLootModifiers.LOOT_MODIFIERS.register(modBus);
        ModFeatures.FEATURES.register(modBus);

        //config (shincolle-common.toml / shincolle-client.toml)
        container.registerConfig(ModConfig.Type.COMMON, ShinColleConfig.COMMON_SPEC);
        container.registerConfig(ModConfig.Type.CLIENT, ShinColleConfig.CLIENT_SPEC);

        //lifecycle
        modBus.addListener(this::commonSetup);
        modBus.addListener(this::onConfigLoad);
        modBus.addListener(this::onConfigReload);
        modBus.addListener(this::registerAttributes);
        modBus.addListener(this::registerSpawnPlacements);
    }

    /**
     * Phase 2-11: hostile ships spawn on the ocean surface.
     * IN_WATER placement + water check; actual spawn weights come from
     * data/shincolle/neoforge/biome_modifier/add_mob_ship_spawns.json.
     */
    @SuppressWarnings("unchecked")
    private void registerSpawnPlacements(
            net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent event)
    {
        for (var entry : ModEntities.ENTITY_TYPES.getEntries())
        {
            EntityType<?> type = entry.get();
            if (type.getCategory() == net.minecraft.world.entity.MobCategory.MONSTER)
            {
                event.register(
                    (EntityType<? extends net.minecraft.world.entity.Mob>) type,
                    net.minecraft.world.entity.SpawnPlacementTypes.IN_WATER,
                    net.minecraft.world.level.levelgen.Heightmap.Types.OCEAN_FLOOR,
                    (t, level, spawnType, pos, rand) ->
                        level.getFluidState(pos).is(net.minecraft.tags.FluidTags.WATER)
                        && level.getFluidState(pos.below()).is(net.minecraft.tags.FluidTags.WATER)
                        && level.getFluidState(pos.above()).is(net.minecraft.tags.FluidTags.WATER),
                    net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent.Operation.AND);
            }
        }
    }

    /** Phase 2-9: entity attribute suppliers */
    private void registerAttributes(
            net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent event)
    {
        ModEntities.registerAttributes(event);
    }

    /** common init: custom INI configs, ship class table */
    private void commonSetup(FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            //custom INI configs (sounds.cfg / loottable.cfg / mining.cfg in config/shincolle/)
            try
            {
                ShinColleConfig.initFileConfigs();
            }
            catch (Exception e)
            {
                LogHelper.error("ERROR: load custom config fail: " + e);
            }

            //ship class id <-> registry name table
            ShipClassRegistry.bootstrap();
        });

        LogHelper.info("INFO: common setup done.");
    }

    private void onConfigLoad(ModConfigEvent.Loading event)
    {
        bake(event.getConfig().getType());
    }

    private void onConfigReload(ModConfigEvent.Reloading event)
    {
        bake(event.getConfig().getType());
    }

    private static void bake(ModConfig.Type type)
    {
        if (type == ModConfig.Type.COMMON) ShinColleConfig.bake();
        else if (type == ModConfig.Type.CLIENT) ShinColleConfig.bakeClient();
    }


}

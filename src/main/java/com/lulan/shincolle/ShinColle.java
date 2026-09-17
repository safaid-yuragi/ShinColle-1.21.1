package com.lulan.shincolle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.registry.ModAttachments;
import com.lulan.shincolle.registry.ModBlocks;
import com.lulan.shincolle.registry.ModComponents;
import com.lulan.shincolle.registry.ModEntities;
import com.lulan.shincolle.registry.ModItems;
import com.lulan.shincolle.registry.ModMenus;
import com.lulan.shincolle.registry.ModParticles;
import com.lulan.shincolle.registry.ModSounds;
import com.lulan.shincolle.registry.ModTabs;
import com.lulan.shincolle.registry.ShipClassRegistry;
import com.lulan.shincolle.utility.LogHelper;

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
        ModBlocks.BLOCK_ENTITIES.register(modBus);
        ModItems.ITEMS.register(modBus);
        ModEntities.ENTITY_TYPES.register(modBus);
        ModSounds.SOUNDS.register(modBus);
        ModParticles.PARTICLE_TYPES.register(modBus);
        ModMenus.MENUS.register(modBus);
        ModAttachments.ATTACHMENTS.register(modBus);
        ModTabs.TABS.register(modBus);
        ModComponents.COMPONENTS.register(modBus);

        //config (shincolle-common.toml / shincolle-client.toml)
        container.registerConfig(ModConfig.Type.COMMON, ShinColleConfig.COMMON_SPEC);
        container.registerConfig(ModConfig.Type.CLIENT, ShinColleConfig.CLIENT_SPEC);

        //lifecycle
        modBus.addListener(this::commonSetup);
        modBus.addListener(this::onConfigLoad);
        modBus.addListener(this::onConfigReload);
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

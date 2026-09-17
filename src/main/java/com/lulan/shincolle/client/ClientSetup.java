package com.lulan.shincolle.client;

import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.utility.LogHelper;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * client-side init (replaces legacy ClientProxy).
 *
 * renderers / layer definitions / particle providers / key mappings are
 * registered here in later phases.
 */
@EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT)
public final class ClientSetup
{


    private ClientSetup() {}

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
    {
        //block render layers, entity renderers etc. go here (Phase 7)
        LogHelper.info("INFO: client setup done.");
    }


}

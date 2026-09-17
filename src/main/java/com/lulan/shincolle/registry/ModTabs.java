package com.lulan.shincolle.registry;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * creative tab registration hub.
 * (the shincolle tab is added in Phase 2)
 */
public final class ModTabs
{

    public static final DeferredRegister<CreativeModeTab> TABS =
        DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, Reference.MOD_ID);


    private ModTabs() {}

}

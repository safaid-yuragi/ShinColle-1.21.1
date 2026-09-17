package com.lulan.shincolle.registry;

import com.lulan.shincolle.reference.Reference;

import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * item registration hub.
 * (entries are added in Phase 2)
 */
public final class ModItems
{

    public static final DeferredRegister.Items ITEMS =
        DeferredRegister.createItems(Reference.MOD_ID);


    private ModItems() {}

}

package com.lulan.shincolle.registry;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * block / block item / block entity registration hub.
 * (entries are added in Phase 2)
 */
public final class ModBlocks
{

    public static final DeferredRegister.Blocks BLOCKS =
        DeferredRegister.createBlocks(Reference.MOD_ID);

    /** block items */
    public static final DeferredRegister.Items ITEMS =
        DeferredRegister.createItems(Reference.MOD_ID);

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Reference.MOD_ID);


    private ModBlocks() {}

}

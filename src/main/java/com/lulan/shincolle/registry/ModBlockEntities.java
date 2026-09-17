package com.lulan.shincolle.registry;

import com.lulan.shincolle.blockentity.*;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * block entity type registration hub (Phase 2-3).
 */
public final class ModBlockEntities
{

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Reference.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileEntityCrane>> TILEENTITYCRANE =
        BLOCK_ENTITIES.register("tile_entity_crane", () ->
            BlockEntityType.Builder.of(TileEntityCrane::new, ModBlocks.BLOCK_CRANE.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileEntityDesk>> TILEENTITYDESK =
        BLOCK_ENTITIES.register("tile_entity_desk", () ->
            BlockEntityType.Builder.of(TileEntityDesk::new, ModBlocks.BLOCK_DESK.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileEntityLightBlock>> TILEENTITYLIGHTBLOCK =
        BLOCK_ENTITIES.register("tile_entity_light_block", () ->
            BlockEntityType.Builder.of(TileEntityLightBlock::new, ModBlocks.BLOCK_LIGHT_AIR.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileEntitySmallShipyard>> TILEENTITYSMALLSHIPYARD =
        BLOCK_ENTITIES.register("tile_entity_small_shipyard", () ->
            BlockEntityType.Builder.of(TileEntitySmallShipyard::new, ModBlocks.BLOCK_SMALL_SHIPYARD.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileEntityVolCore>> TILEENTITYVOLCORE =
        BLOCK_ENTITIES.register("tile_entity_vol_core", () ->
            BlockEntityType.Builder.of(TileEntityVolCore::new, ModBlocks.BLOCK_VOL_CORE.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileEntityWaypoint>> TILEENTITYWAYPOINT =
        BLOCK_ENTITIES.register("tile_entity_waypoint", () ->
            BlockEntityType.Builder.of(TileEntityWaypoint::new, ModBlocks.BLOCK_WAYPOINT.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileMultiGrudgeHeavy>> TILEMULTIGRUDGEHEAVY =
        BLOCK_ENTITIES.register("tile_multi_grudge_heavy", () ->
            BlockEntityType.Builder.of(TileMultiGrudgeHeavy::new, ModBlocks.BLOCK_GRUDGE_HEAVY.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TileMultiPolymetal>> TILEMULTIPOLYMETAL =
        BLOCK_ENTITIES.register("tile_multi_polymetal", () ->
            BlockEntityType.Builder.of(TileMultiPolymetal::new, ModBlocks.BLOCK_POLYMETAL.get()).build(null));


    private ModBlockEntities() {}

}

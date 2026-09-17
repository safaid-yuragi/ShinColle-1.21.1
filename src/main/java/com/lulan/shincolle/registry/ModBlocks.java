package com.lulan.shincolle.registry;

import com.lulan.shincolle.block.*;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * block / block item registration hub (Phase 2-2).
 * Block entity types live in {@link ModBlockEntities}.
 */
public final class ModBlocks
{

    public static final DeferredRegister.Blocks BLOCKS =
        DeferredRegister.createBlocks(Reference.MOD_ID);

    /** block items */
    public static final DeferredRegister.Items ITEMS =
        DeferredRegister.createItems(Reference.MOD_ID);

    //materials / deco
    public static final DeferredBlock<BlockAbyssium> BLOCK_ABYSSIUM =
        BLOCKS.register("abyssium_block", BlockAbyssium::new);
    public static final DeferredBlock<BlockFrame> BLOCK_FRAME =
        BLOCKS.register("frame_block", BlockFrame::new);
    public static final DeferredBlock<BlockGrudge> BLOCK_GRUDGE =
        BLOCKS.register("grudge_block", BlockGrudge::new);
    public static final DeferredBlock<BlockGrudgeXP> BLOCK_GRUDGE_XP =
        BLOCKS.register("grudge_xp_block", BlockGrudgeXP::new);
    public static final DeferredBlock<BlockGrudgeHeavy> BLOCK_GRUDGE_HEAVY =
        BLOCKS.register("grudge_heavy_block", BlockGrudgeHeavy::new);
    public static final DeferredBlock<BlockGrudgeHeavyDeco> BLOCK_GRUDGE_HEAVY_DECO =
        BLOCKS.register("grudge_heavy_deco_block", BlockGrudgeHeavyDeco::new);
    public static final DeferredBlock<BlockPolymetal> BLOCK_POLYMETAL =
        BLOCKS.register("polymetal_block", BlockPolymetal::new);
    public static final DeferredBlock<BlockPolymetalGravel> BLOCK_POLYMETAL_GRAVEL =
        BLOCKS.register("polymetal_gravel", BlockPolymetalGravel::new);
    public static final DeferredBlock<BlockPolymetalOre> BLOCK_POLYMETAL_ORE =
        BLOCKS.register("polymetal_ore", BlockPolymetalOre::new);
    public static final DeferredBlock<BlockVolBlock> BLOCK_VOL_BLOCK =
        BLOCKS.register("vol_block", BlockVolBlock::new);

    //machines / markers
    public static final DeferredBlock<BlockCrane> BLOCK_CRANE =
        BLOCKS.register("crane_block", BlockCrane::new);
    public static final DeferredBlock<BlockDesk> BLOCK_DESK =
        BLOCKS.register("desk_block", BlockDesk::new);
    public static final DeferredBlock<BlockSmallShipyard> BLOCK_SMALL_SHIPYARD =
        BLOCKS.register("small_shipyard", BlockSmallShipyard::new);
    public static final DeferredBlock<BlockVolCore> BLOCK_VOL_CORE =
        BLOCKS.register("vol_core", BlockVolCore::new);
    public static final DeferredBlock<BlockWaypoint> BLOCK_WAYPOINT =
        BLOCKS.register("waypoint", BlockWaypoint::new);

    //light blocks
    public static final DeferredBlock<BlockLightAir> BLOCK_LIGHT_AIR =
        BLOCKS.register("light_air", BlockLightAir::new);
    public static final DeferredBlock<BlockLightLiquid> BLOCK_LIGHT_LIQUID =
        BLOCKS.register("light_liquid", BlockLightLiquid::new);

    //block items
    public static final DeferredItem<BlockItem> ITEM_ABYSSIUM = item(BLOCK_ABYSSIUM);
    public static final DeferredItem<BlockItem> ITEM_FRAME = item(BLOCK_FRAME);
    public static final DeferredItem<BlockItem> ITEM_GRUDGE = item(BLOCK_GRUDGE);
    public static final DeferredItem<BlockItem> ITEM_GRUDGE_XP = item(BLOCK_GRUDGE_XP);
    public static final DeferredItem<BlockItem> ITEM_GRUDGE_HEAVY = item(BLOCK_GRUDGE_HEAVY);
    public static final DeferredItem<BlockItem> ITEM_GRUDGE_HEAVY_DECO = item(BLOCK_GRUDGE_HEAVY_DECO);
    public static final DeferredItem<BlockItem> ITEM_POLYMETAL = item(BLOCK_POLYMETAL);
    public static final DeferredItem<BlockItem> ITEM_POLYMETAL_GRAVEL = item(BLOCK_POLYMETAL_GRAVEL);
    public static final DeferredItem<BlockItem> ITEM_POLYMETAL_ORE = item(BLOCK_POLYMETAL_ORE);
    public static final DeferredItem<BlockItem> ITEM_VOL_BLOCK = item(BLOCK_VOL_BLOCK);
    public static final DeferredItem<BlockItem> ITEM_CRANE = item(BLOCK_CRANE);
    public static final DeferredItem<BlockItem> ITEM_DESK = item(BLOCK_DESK);
    public static final DeferredItem<BlockItem> ITEM_SMALL_SHIPYARD = item(BLOCK_SMALL_SHIPYARD);
    public static final DeferredItem<BlockItem> ITEM_VOL_CORE = item(BLOCK_VOL_CORE);
    public static final DeferredItem<BlockItem> ITEM_WAYPOINT = item(BLOCK_WAYPOINT);


    private static DeferredItem<BlockItem> item(DeferredBlock<? extends Block> block)
    {
        return ITEMS.register(block.getId().getPath(),
            () -> new BlockItem(block.get(), new Item.Properties()));
    }


    private ModBlocks() {}

}

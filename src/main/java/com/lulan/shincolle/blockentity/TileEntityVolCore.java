package com.lulan.shincolle.blockentity;

import com.lulan.shincolle.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

/**
 * port of legacy TileEntityVolCore. Full machine logic is ported in Phase 5.
 */
public class TileEntityVolCore extends BasicBlockEntity
{


    public TileEntityVolCore(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TILEENTITYVOLCORE.get(), pos, state, 9);
    }


}

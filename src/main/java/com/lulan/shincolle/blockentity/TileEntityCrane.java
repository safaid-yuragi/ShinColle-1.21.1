package com.lulan.shincolle.blockentity;

import com.lulan.shincolle.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

/**
 * port of legacy TileEntityCrane. Full machine logic is ported in Phase 5.
 */
public class TileEntityCrane extends BasicBlockEntity
{


    public TileEntityCrane(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TILEENTITYCRANE.get(), pos, state, 18);
    }


}

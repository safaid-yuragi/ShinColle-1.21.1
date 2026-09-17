package com.lulan.shincolle.blockentity;

import com.lulan.shincolle.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

/**
 * port of legacy TileEntityWaypoint. Full machine logic is ported in Phase 5.
 */
public class TileEntityWaypoint extends BasicBlockEntity
{


    public TileEntityWaypoint(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TILEENTITYWAYPOINT.get(), pos, state, 1);
    }


}

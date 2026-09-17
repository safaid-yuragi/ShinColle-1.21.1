package com.lulan.shincolle.blockentity;

import com.lulan.shincolle.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

/**
 * port of legacy TileEntitySmallShipyard. Full machine logic is ported in Phase 5.
 */
public class TileEntitySmallShipyard extends BasicBlockEntity
{


    public TileEntitySmallShipyard(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TILEENTITYSMALLSHIPYARD.get(), pos, state, 6);
    }


}

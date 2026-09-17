package com.lulan.shincolle.blockentity;

import com.lulan.shincolle.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

/**
 * port of legacy TileEntityLightBlock. Full machine logic is ported in Phase 5.
 */
public class TileEntityLightBlock extends BasicBlockEntity
{


    public TileEntityLightBlock(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TILEENTITYLIGHTBLOCK.get(), pos, state, 0);
    }


}

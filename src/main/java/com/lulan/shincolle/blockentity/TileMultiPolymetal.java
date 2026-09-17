package com.lulan.shincolle.blockentity;

import com.lulan.shincolle.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

/**
 * port of legacy TileMultiPolymetal. Full machine logic is ported in Phase 5.
 */
public class TileMultiPolymetal extends BasicBlockEntity
{


    public TileMultiPolymetal(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TILEMULTIPOLYMETAL.get(), pos, state, 9);
    }


}

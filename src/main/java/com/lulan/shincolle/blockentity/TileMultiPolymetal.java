package com.lulan.shincolle.blockentity;

import com.lulan.shincolle.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

/**
 * port of legacy TileMultiPolymetal (large shipyard slave part).
 */
public class TileMultiPolymetal extends BasicMultiBlockEntity
{


    public TileMultiPolymetal(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TILEMULTIPOLYMETAL.get(), pos, state, 9);
    }


}

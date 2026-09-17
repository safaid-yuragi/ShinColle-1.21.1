package com.lulan.shincolle.blockentity;

import com.lulan.shincolle.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

/**
 * port of legacy TileMultiGrudgeHeavy. Full machine logic is ported in Phase 5.
 */
public class TileMultiGrudgeHeavy extends BasicBlockEntity
{


    public TileMultiGrudgeHeavy(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TILEMULTIGRUDGEHEAVY.get(), pos, state, 9);
    }


}

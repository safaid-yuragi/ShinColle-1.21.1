package com.lulan.shincolle.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

/**
 * block base (legacy BasicBlock). Holds the legacy model-state count
 * used by the renderer state system.
 */
public class BasicBlock extends Block
{


    public BasicBlock(Properties props)
    {
        super(props);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
    }


}

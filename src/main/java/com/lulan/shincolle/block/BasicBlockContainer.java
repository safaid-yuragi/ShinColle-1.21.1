package com.lulan.shincolle.block;

import javax.annotation.Nullable;

import com.lulan.shincolle.blockentity.BasicBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * block entity provider base (legacy BasicBlockContainer).
 * Drops the block entity inventory on removal.
 */
abstract public class BasicBlockContainer extends BasicBlock implements EntityBlock
{


    public BasicBlockContainer(Properties props)
    {
        super(props);
    }

    @Nullable
    @Override
    public abstract BlockEntity newBlockEntity(BlockPos pos, BlockState state);

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState,
                            boolean movedByPiston)
    {
        if (!state.is(newState.getBlock()))
        {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof BasicBlockEntity inv && inv.hasInventory())
            {
                Containers.dropContents(level, pos, inv.getItemHandlerContents());
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }


}

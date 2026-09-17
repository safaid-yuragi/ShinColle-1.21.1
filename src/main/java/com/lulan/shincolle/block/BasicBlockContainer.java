package com.lulan.shincolle.block;

import javax.annotation.Nullable;

import com.lulan.shincolle.blockentity.BasicBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

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

    /** legacy ITickable: route server ticks to BasicBlockEntity.tick() */
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level, BlockState state, BlockEntityType<T> type)
    {
        return (lvl, p, st, be) ->
        {
            if (be instanceof BasicBlockEntity tile) tile.tick();
        };
    }

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

    /**
     * right-click opens the block entity menu server-side.
     * The open buffer carries the BlockPos (resolved client-side into the BE).
     * Blocks needing custom interaction (multiblock, sneaking) override this.
     */
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level,
            BlockPos pos, Player player, BlockHitResult hitResult)
    {
        if (!level.isClientSide() && !player.isSecondaryUseActive())
        {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof BasicBlockEntity tile)
            {
                player.openMenu(tile, pos);
                return InteractionResult.CONSUME;
            }
        }
        return level.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.PASS;
    }


}

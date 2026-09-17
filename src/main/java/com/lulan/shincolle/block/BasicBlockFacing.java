package com.lulan.shincolle.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

/**
 * horizontal-facing block base (legacy BasicBlockFacing).
 */
public class BasicBlockFacing extends BasicBlock
{

    public static final net.minecraft.world.level.block.state.properties.DirectionProperty FACING =
        BlockStateProperties.HORIZONTAL_FACING;


    public BasicBlockFacing(Properties props)
    {
        super(props);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return this.defaultBlockState()
            .setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, net.minecraft.world.level.block.Rotation rotation)
    {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, net.minecraft.world.level.block.Mirror mirror)
    {
        return state.setValue(FACING, mirror.mirror(state.getValue(FACING)));
    }


}

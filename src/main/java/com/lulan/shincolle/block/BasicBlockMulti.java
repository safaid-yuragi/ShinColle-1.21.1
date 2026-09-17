package com.lulan.shincolle.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

/**
 * multi-block part base (legacy BasicBlockMulti, PropertyInteger MBS 0..2).
 * MBS = 0 master block; 1/2 = slave parts placed by the master.
 */
abstract public class BasicBlockMulti extends BasicBlockContainer
{

    public static final IntegerProperty MBS = IntegerProperty.create("mbs", 0, 2);


    public BasicBlockMulti(Properties props)
    {
        super(props);
        this.registerDefaultState(this.defaultBlockState().setValue(MBS, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(MBS);
    }


}

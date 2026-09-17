package com.lulan.shincolle.block;

import javax.annotation.Nullable;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

/**
 * port of legacy BlockGrudgeXP.
 */
public class BlockGrudgeXP extends BasicBlock
{


    public BlockGrudgeXP()
    {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(1F, 200F).sound(SoundType.SAND).lightLevel(s -> 15));
    }


}

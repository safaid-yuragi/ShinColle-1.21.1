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
 * port of legacy BlockVolBlock.
 */
public class BlockVolBlock extends BasicBlock
{


    public BlockVolBlock()
    {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).requiresCorrectToolForDrops().strength(3F, 200F).sound(SoundType.SAND).lightLevel(s -> 15));
    }


}

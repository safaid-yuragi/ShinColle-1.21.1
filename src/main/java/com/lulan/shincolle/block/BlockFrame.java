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
 * port of legacy BlockFrame.
 */
public class BlockFrame extends BasicBlock
{


    public BlockFrame()
    {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).strength(0.1F, 40F).sound(SoundType.METAL).noOcclusion());
    }


}

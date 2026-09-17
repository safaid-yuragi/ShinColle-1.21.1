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
 * port of legacy BlockGrudgeHeavyDeco.
 */
public class BlockGrudgeHeavyDeco extends BasicBlock
{


    public BlockGrudgeHeavyDeco()
    {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(3F, 300F).sound(SoundType.SAND).lightLevel(s -> 15));
    }


}

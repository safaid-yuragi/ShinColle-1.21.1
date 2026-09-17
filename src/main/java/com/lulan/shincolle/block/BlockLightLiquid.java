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
 * port of legacy BlockLightLiquid.
 */
public class BlockLightLiquid extends BasicBlock
{


    public BlockLightLiquid()
    {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100F).noCollission().noOcclusion().lightLevel(s -> 15));
    }


}

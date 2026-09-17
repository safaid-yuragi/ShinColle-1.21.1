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
 * port of legacy BlockPolymetalOre.
 */
public class BlockPolymetalOre extends BasicBlock
{


    public BlockPolymetalOre()
    {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3F));
    }


}

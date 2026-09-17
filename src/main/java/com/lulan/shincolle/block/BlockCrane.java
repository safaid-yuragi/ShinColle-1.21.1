package com.lulan.shincolle.block;

import javax.annotation.Nullable;

import com.lulan.shincolle.blockentity.TileEntityCrane;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

/**
 * port of legacy BlockCrane.
 */
public class BlockCrane extends BasicBlockFacingContainer
{


    public BlockCrane()
    {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(1F, 10F).sound(SoundType.METAL));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new TileEntityCrane(pos, state);
    }


}

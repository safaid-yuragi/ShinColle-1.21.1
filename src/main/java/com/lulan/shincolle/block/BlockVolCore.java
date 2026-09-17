package com.lulan.shincolle.block;

import javax.annotation.Nullable;

import com.lulan.shincolle.blockentity.TileEntityVolCore;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

/**
 * port of legacy BlockVolCore.
 */
public class BlockVolCore extends BasicBlockFacingContainer
{


    public BlockVolCore()
    {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(6F, 600F).sound(SoundType.METAL).lightLevel(s -> 15));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new TileEntityVolCore(pos, state);
    }


}

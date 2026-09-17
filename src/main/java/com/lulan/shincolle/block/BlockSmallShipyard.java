package com.lulan.shincolle.block;

import javax.annotation.Nullable;

import com.lulan.shincolle.blockentity.TileEntitySmallShipyard;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

/**
 * port of legacy BlockSmallShipyard.
 */
public class BlockSmallShipyard extends BasicBlockFacingContainer
{


    public BlockSmallShipyard()
    {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(10F).sound(SoundType.METAL).lightLevel(s -> 15));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new TileEntitySmallShipyard(pos, state);
    }


}

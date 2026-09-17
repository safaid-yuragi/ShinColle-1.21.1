package com.lulan.shincolle.block;

import javax.annotation.Nullable;

import com.lulan.shincolle.blockentity.TileEntityWaypoint;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

/**
 * port of legacy BlockWaypoint.
 */
public class BlockWaypoint extends BasicBlockFacingContainer
{


    public BlockWaypoint()
    {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).instabreak().sound(SoundType.GLASS).noOcclusion());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new TileEntityWaypoint(pos, state);
    }


}

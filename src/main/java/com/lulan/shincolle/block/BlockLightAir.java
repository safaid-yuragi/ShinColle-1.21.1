package com.lulan.shincolle.block;

import javax.annotation.Nullable;

import com.lulan.shincolle.blockentity.TileEntityLightBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

/**
 * port of legacy BlockLightAir.
 */
public class BlockLightAir extends BasicBlockContainer
{


    public BlockLightAir()
    {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).strength(100F).noCollission().noOcclusion().lightLevel(s -> 15).air());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new TileEntityLightBlock(pos, state);
    }


}

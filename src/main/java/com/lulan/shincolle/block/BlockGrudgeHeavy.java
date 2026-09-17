package com.lulan.shincolle.block;

import javax.annotation.Nullable;

import com.lulan.shincolle.blockentity.TileMultiGrudgeHeavy;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

/**
 * port of legacy BlockGrudgeHeavy.
 */
public class BlockGrudgeHeavy extends BasicBlockMulti
{


    public BlockGrudgeHeavy()
    {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(3F, 600F).sound(SoundType.SAND).lightLevel(s -> 15));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new TileMultiGrudgeHeavy(pos, state);
    }


}

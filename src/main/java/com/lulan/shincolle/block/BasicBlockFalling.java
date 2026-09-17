package com.lulan.shincolle.block;

import com.mojang.serialization.MapCodec;

import net.minecraft.world.level.block.FallingBlock;

/**
 * gravity block base (legacy BasicBlockFalling).
 */
public class BasicBlockFalling extends FallingBlock
{

    public static final MapCodec<BasicBlockFalling> CODEC = simpleCodec(BasicBlockFalling::new);


    public BasicBlockFalling(Properties props)
    {
        super(props);
    }

    @Override
    public MapCodec<BasicBlockFalling> codec()
    {
        return CODEC;
    }


}

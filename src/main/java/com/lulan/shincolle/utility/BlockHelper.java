package com.lulan.shincolle.utility;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

/**
 * block position helpers (legacy BlockHelper subset).
 */
public class BlockHelper
{

    private static final Random RAND = new Random();


    /**
     * random position near anchor within range (legacy findRandomPosition).
     * scans down/up for a non-suffocating spot; returns anchor pos if none.
     */
    public static double[] findRandomPosition(Entity host, Entity anchor,
            double rangeXZ, double rangeY, int tries)
    {
        Level level = host.level();

        for (int i = 0; i < tries + 8; i++)
        {
            double x = anchor.getX() + (RAND.nextDouble() * 2D - 1D) * rangeXZ;
            double y = anchor.getY() + (RAND.nextDouble() * 2D - 1D) * rangeY;
            double z = anchor.getZ() + (RAND.nextDouble() * 2D - 1D) * rangeXZ;
            BlockPos pos = BlockPos.containing(x, y, z);
            BlockState state = level.getBlockState(pos);

            //air or liquid is fine for ships
            if (state.isAir() || !state.getFluidState().isEmpty())
            {
                return new double[] {x, y, z};
            }
        }

        return new double[] {anchor.getX(), anchor.getY(), anchor.getZ()};
    }

    /**
     * nearest safe standing position at/above pos: moves up out of solid
     * blocks, allows water surface landing for ships.
     */
    public static BlockPos getSafeTopPos(Level level, BlockPos pos)
    {
        BlockPos.MutableBlockPos mp = pos.mutable();

        //scan up while feet inside solid block
        for (int i = 0; i < 8 && mp.getY() < level.getMaxBuildHeight() - 2; i++)
        {
            BlockState feet = level.getBlockState(mp);
            BlockState head = level.getBlockState(mp.above());

            if (!feet.isSolidRender(level, mp) && !head.isSolidRender(level, mp.above()))
            {
                break;
            }

            mp.move(0, 1, 0);
        }

        return mp.immutable();
    }

    /** block state is liquid (legacy checkBlockIsLiquid) */
    public static boolean checkBlockIsLiquid(BlockState state)
    {
        return !state.getFluidState().isEmpty();
    }


}

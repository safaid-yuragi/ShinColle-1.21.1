package com.lulan.shincolle.worldgen;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.registry.ModBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

/**
 * generate polymetallic gravel on the seabed (legacy WorldGenPolyGravel).
 *
 * The placed feature positions the origin one block above the top
 * motion-blocking block (MOTION_BLOCKING heightmap = 1.12
 * getTopSolidOrLiquidBlock). In frozen oceans the surface block is ice with
 * water beneath: scan down to the sea floor. Otherwise the origin must be
 * water at y <= 55, which effectively limits generation to iced-over oceans,
 * same as the 1.12.2 generator.
 *
 * Replaces a flat disc (radius 1~2, y +- 1) of stone/gravel/sand/dirt (per
 * ShinColleConfig.polyGravelBaseBlock) with polymetal_gravel.
 */
public class PolymetalGravelFeature extends Feature<NoneFeatureConfiguration>
{

    public PolymetalGravelFeature()
    {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context)
    {
        WorldGenLevel level = context.level();
        RandomSource rand = context.random();
        BlockPos pos = context.origin();

        boolean notFrozen = true;
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        //frozen ocean: ice on the surface with water below -> find the sea floor
        if (level.getBlockState(pos.below()).is(Blocks.ICE) &&
            level.getFluidState(pos.below(2)).is(FluidTags.WATER))
        {
            //scan down from y-3; water depth must be at least 3 blocks
            for (int newy = y - 3; newy > 3; newy--)
            {
                //first non-water block = sea floor
                if (!level.getFluidState(new BlockPos(x, newy, z)).is(FluidTags.WATER))
                {
                    y = newy;
                    notFrozen = false;
                    break;
                }
            }
        }

        //normal ocean: origin is air above the surface -> never generates
        //(same as legacy: y > 55 or not water -> skip)
        if (notFrozen && (!level.getFluidState(new BlockPos(x, y, z)).is(FluidTags.WATER) || y > 55))
        {
            return false;
        }

        //legacy: new WorldGenPolyGravel(2 + rand.nextInt(2)) then l = rand.nextInt(num - 1) + 1
        int numBlocks = 2 + rand.nextInt(2);
        int l = rand.nextInt(numBlocks - 1) + 1;    //disc radius 1~2

        boolean[] baseBlock = ShinColleConfig.polyGravelBaseBlock;    //stone gravel sand dirt
        BlockState gravel = ModBlocks.BLOCK_POLYMETAL_GRAVEL.get().defaultBlockState();

        for (int i1 = x - l; i1 <= x + l; ++i1)
        {
            for (int j1 = z - l; j1 <= z + l; ++j1)
            {
                int dx = i1 - x;
                int dz = j1 - z;

                if (dx * dx + dz * dz <= l * l)
                {
                    for (int i2 = y - 1; i2 <= y + 1; ++i2)
                    {
                        BlockPos bp = new BlockPos(i1, i2, j1);
                        BlockState state = level.getBlockState(bp);

                        if ((baseBlock[0] && state.is(Blocks.STONE)) ||
                            (baseBlock[1] && state.is(Blocks.GRAVEL)) ||
                            (baseBlock[2] && state.is(Blocks.SAND)) ||
                            (baseBlock[3] && state.is(Blocks.DIRT)))
                        {
                            this.setBlock(level, bp, gravel);
                        }
                    }
                }
            }
        }

        return true;
    }


}

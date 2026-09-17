package com.lulan.shincolle.ai.path;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.PathfindingContext;

import com.lulan.shincolle.block.BlockWaypoint;

/**
 * ship path node rules (legacy ShipPathFinder#getPathType):
 * water/lava are traversable, wooden doors/gates are openable,
 * waypoint block is always open, fences block unless step height allows.
 */
public class ShipNodeEvaluator extends AmphibiousNodeEvaluator
{


    public ShipNodeEvaluator(boolean prefersShallowWater)
    {
        super(prefersShallowWater);
    }

    @Override
    public PathType getPathType(PathfindingContext context, int x, int y, int z)
    {
        PathType type = super.getPathType(context, x, y, z);
        BlockPos pos = new BlockPos(x, y, z);
        BlockGetter level = context.level();
        BlockState state = level.getBlockState(pos);

        //mod waypoint block is always walk-through
        if (state.getBlock() instanceof BlockWaypoint)
        {
            return PathType.OPEN;
        }

        //ships path on water surface: water counts as open water walking
        if (type == PathType.WATER || state.getFluidState().getType() == Fluids.WATER)
        {
            return PathType.WATER;
        }

        return type;
    }

    @Override
    public PathType getPathType(net.minecraft.world.entity.Mob mob, BlockPos pos)
    {
        PathType type = super.getPathType(mob, pos);
        BlockState state = mob.level().getBlockState(pos);

        if (state.getBlock() instanceof BlockWaypoint)
        {
            return PathType.OPEN;
        }

        //ships can open wooden doors and fence gates themselves
        if (state.getBlock() instanceof DoorBlock && !state.getValue(DoorBlock.OPEN))
        {
            return PathType.DOOR_OPEN;
        }
        if (state.getBlock() instanceof FenceGateBlock && !state.getValue(FenceGateBlock.OPEN))
        {
            return PathType.DOOR_OPEN;
        }

        return type;
    }


}

package com.lulan.shincolle.ai.path;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathFinder;

/**
 * ground/water navigation for ship entities
 * (legacy ShipPathNavigate -> AmphibiousPathNavigation + ship node rules).
 */
public class ShipPathNavigation extends AmphibiousPathNavigation implements IShipPathNavigate
{


    public ShipPathNavigation(Mob mob, Level level)
    {
        super(mob, level);
    }

    @Override
    protected PathFinder createPathFinder(int maxVisitedNodes)
    {
        this.nodeEvaluator = new ShipNodeEvaluator(true);
        this.nodeEvaluator.setCanPassDoors(true);
        this.nodeEvaluator.setCanOpenDoors(true);
        this.nodeEvaluator.setCanFloat(true);
        return new PathFinder(this.nodeEvaluator, maxVisitedNodes);
    }

    /** ships can float: allow targeting positions on/above water */
    @Override
    protected boolean canUpdatePath()
    {
        return true;
    }

    @Override
    public boolean tryMoveToXYZ(double x, double y, double z, double speed)
    {
        return this.moveTo(x, y, z, speed);
    }

    @Override
    public boolean tryMoveToEntityLiving(Entity target, double speed)
    {
        return this.moveTo(target, speed);
    }

    @Override
    public boolean noPath()
    {
        return this.isDone();
    }

    @Override
    public void clearPathEntity()
    {
        this.stop();
    }

    /** re-path directly to the target block pos of an entity */
    public boolean tryMoveToPos(BlockPos pos, double speed)
    {
        return this.moveTo(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, speed);
    }


}

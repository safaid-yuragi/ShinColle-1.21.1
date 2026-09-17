package com.lulan.shincolle.ai.path;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathFinder;

/**
 * air navigation for aircraft entities (planes, flying forts).
 */
public class ShipFlyingNavigation extends FlyingPathNavigation implements IShipPathNavigate
{


    public ShipFlyingNavigation(Mob mob, Level level)
    {
        super(mob, level);
    }

    @Override
    protected PathFinder createPathFinder(int maxVisitedNodes)
    {
        this.nodeEvaluator = new ShipFlyingNodeEvaluator();
        this.nodeEvaluator.setCanPassDoors(true);
        this.nodeEvaluator.setCanOpenDoors(false);
        this.nodeEvaluator.setCanFloat(true);
        return new PathFinder(this.nodeEvaluator, maxVisitedNodes);
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


}

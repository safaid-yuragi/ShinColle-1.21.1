package com.lulan.shincolle.ai.path;

import javax.annotation.Nullable;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.pathfinder.Path;

/**
 * legacy ShipPathNavigate method surface shared by the ground/water
 * ({@link ShipPathNavigation}) and air ({@link ShipFlyingNavigation})
 * navigations.
 */
public interface IShipPathNavigate
{

    /** move to position, false if no path found */
    boolean tryMoveToXYZ(double x, double y, double z, double speed);

    /** move to entity, false if no path found */
    boolean tryMoveToEntityLiving(Entity target, double speed);

    /** true if no active path */
    boolean noPath();

    /** stop and clear current path */
    void clearPathEntity();

    @Nullable
    Path getPath();


}

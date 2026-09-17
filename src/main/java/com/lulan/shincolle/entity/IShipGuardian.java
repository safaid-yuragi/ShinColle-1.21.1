package com.lulan.shincolle.entity;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;

/**
 * entity that can guard a position or another entity.
 */
public interface IShipGuardian extends IShipAttackBase
{

    @Nullable
    Entity getGuardedEntity();

    void setGuardedEntity(@Nullable Entity entity);

    /** index 0..3: x, y, z, dim */
    int getGuardedPos(int index);

    void setGuardedPos(int x, int y, int z, int dim, int type);

    BlockPos getLastWaypoint();

    void setLastWaypoint(BlockPos pos);

    int getWpStayTime();

    int getWpStayTimeMax();

    void setWpStayTime(int time);


}

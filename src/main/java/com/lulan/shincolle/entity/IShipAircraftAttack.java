package com.lulan.shincolle.entity;

import net.minecraft.world.entity.Entity;

/**
 * entity that can launch aircraft attacks (carriers).
 */
public interface IShipAircraftAttack extends IShipAttackBase
{

    int getNumAircraftLight();

    int getNumAircraftHeavy();

    boolean hasAirLight();

    boolean hasAirHeavy();

    void setNumAircraftLight(int num);

    void setNumAircraftHeavy(int num);

    boolean attackEntityWithAircraft(Entity target);

    boolean attackEntityWithHeavyAircraft(Entity target);


}

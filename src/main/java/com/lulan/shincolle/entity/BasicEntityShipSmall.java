package com.lulan.shincolle.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * small ship base (legacy BasicEntityShipSmall).
 * Used by most non-carrier ship classes; mounts/riding are added in Phase 7.
 */
abstract public class BasicEntityShipSmall extends BasicEntityShip
{


    public BasicEntityShipSmall(EntityType<? extends BasicEntityShip> type, Level level)
    {
        super(type, level);
    }


}

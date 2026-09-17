package com.lulan.shincolle.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * hostile carrier ship base (legacy BasicEntityShipHostileCV).
 * Carrier mobs summon hostile aircraft (Phase 4).
 */
abstract public class BasicEntityShipHostileCV extends BasicEntityShipHostile
{


    public BasicEntityShipHostileCV(EntityType<? extends BasicEntityShipHostile> type, Level level)
    {
        super(type, level);
    }


}

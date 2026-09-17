package com.lulan.shincolle.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * large multi-seat mount base (legacy BasicEntityMountLarge).
 */
abstract public class BasicEntityMountLarge extends BasicEntityMount
{


    public BasicEntityMountLarge(EntityType<? extends BasicEntityMount> type, Level level)
    {
        super(type, level);
    }


}

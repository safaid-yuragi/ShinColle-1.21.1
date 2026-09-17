package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntityAirplane.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntityAirplane extends BasicEntityAirplane
{


    public EntityAirplane(EntityType<? extends BasicEntitySummon> type, Level level)
    {
        super(type, level);
    }


}

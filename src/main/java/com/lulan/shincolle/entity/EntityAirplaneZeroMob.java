package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntityAirplaneZeroMob.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntityAirplaneZeroMob extends EntityAirplaneZero
{


    public EntityAirplaneZeroMob(EntityType<? extends BasicEntitySummon> type, Level level)
    {
        super(type, level);
        this.setScaleDims(0.5F, 0.5F, 1.0F, 1.0F, 1.5F, 1.5F, 2.0F, 2.0F);
    }


}

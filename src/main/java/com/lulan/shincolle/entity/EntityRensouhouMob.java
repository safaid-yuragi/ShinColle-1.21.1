package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntityRensouhouMob.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntityRensouhouMob extends BasicEntitySummon
{


    public EntityRensouhouMob(EntityType<? extends BasicEntitySummon> type, Level level)
    {
        super(type, level);
        this.setScaleDims(0.3F, 0.7F, 0.7F, 1.4F, 1.1F, 2.1F, 1.5F, 2.8F);
    }


}

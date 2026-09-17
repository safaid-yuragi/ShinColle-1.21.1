package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntitySubmRo500Mob.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntitySubmRo500Mob extends BasicEntityShipHostile
{


    public EntitySubmRo500Mob(EntityType<? extends BasicEntityShipHostile> type, Level level)
    {
        super(type, level);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.SSRo500);
        this.setScaleDims(0.6F, 1.4F, 0.9F, 2.8F, 1.2F, 4.2F, 1.5F, 5.6F);
    }


}

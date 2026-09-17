package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntityDestroyerShimakazeMob.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntityDestroyerShimakazeMob extends BasicEntityShipHostile
{


    public EntityDestroyerShimakazeMob(EntityType<? extends BasicEntityShipHostile> type, Level level)
    {
        super(type, level);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.DDShimakaze);
        this.setScaleDims(0.5F, 1.6F, 0.9F, 3.2F, 1.3F, 4.8F, 1.7F, 6.4F);
    }


}

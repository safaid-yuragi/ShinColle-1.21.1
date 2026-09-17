package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntityCarrierKagaMob.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntityCarrierKagaMob extends BasicEntityShipHostileCV
{


    public EntityCarrierKagaMob(EntityType<? extends BasicEntityShipHostile> type, Level level)
    {
        super(type, level);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.CVKaga);
        this.setScaleDims(0.6F, 1.875F, 1.2F, 3.75F, 1.8F, 5.625F, 2.4F, 7.5F);
    }


}

package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntityCATakaoMob.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntityCATakaoMob extends BasicEntityShipHostile
{


    public EntityCATakaoMob(EntityType<? extends BasicEntityShipHostile> type, Level level)
    {
        super(type, level);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.CATakao);
        this.setScaleDims(0.75F, 1.75F, 0.9F, 3.5F, 1.3F, 5.25F, 1.7F, 7.0F);
    }


}

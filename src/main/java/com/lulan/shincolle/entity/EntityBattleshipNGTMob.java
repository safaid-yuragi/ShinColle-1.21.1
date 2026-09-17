package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntityBattleshipNGTMob.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntityBattleshipNGTMob extends BasicEntityShipHostile
{


    public EntityBattleshipNGTMob(EntityType<? extends BasicEntityShipHostile> type, Level level)
    {
        super(type, level);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.BBNagato);
        this.setScaleDims(0.7F, 2.0F, 1.2F, 4.0F, 1.7F, 6.0F, 2.2F, 8.0F);
    }


}

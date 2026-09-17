package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntityBattleshipYMTMob.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntityBattleshipYMTMob extends BasicEntityShipHostile
{


    public EntityBattleshipYMTMob(EntityType<? extends BasicEntityShipHostile> type, Level level)
    {
        super(type, level);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.BBYamato);
        this.setScaleDims(0.8F, 2.1F, 1.3F, 4.2F, 1.8F, 6.3F, 2.3F, 8.4F);
    }


}

package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntityBBKirishima.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntityBBKirishima extends BasicEntityShipSmall
{


    public EntityBBKirishima(EntityType<? extends BasicEntityShip> type, Level level)
    {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipIconType.BATTLESHIP);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.BBKirishima);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.BATTLESHIP);
        this.setStateMinor(ID.M.NumState, 3);
        this.setGrudgeConsumeIdle(ShinColleConfig.consumeGrudgeShipIdle[ID.ShipConsume.BB]);
        this.setAmmoConsumption(ShinColleConfig.consumeAmmoShip[ID.ShipConsume.BB]);
        this.StateFlag[ID.F.AtkType_AirLight] = false;
        this.StateFlag[ID.F.AtkType_AirHeavy] = false;
    }


}

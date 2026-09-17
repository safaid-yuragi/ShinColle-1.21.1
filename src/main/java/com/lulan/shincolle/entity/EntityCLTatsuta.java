package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntityCLTatsuta.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntityCLTatsuta extends BasicEntityShipSmall
{


    public EntityCLTatsuta(EntityType<? extends BasicEntityShip> type, Level level)
    {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipIconType.LIGHT_CRUISER);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.CLTatsuta);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.CRUISER);
        this.setStateMinor(ID.M.NumState, 3);
        this.setGrudgeConsumeIdle(ShinColleConfig.consumeGrudgeShipIdle[ID.ShipConsume.CL]);
        this.setAmmoConsumption(ShinColleConfig.consumeAmmoShip[ID.ShipConsume.CL]);
        this.StateFlag[ID.F.AtkType_AirLight] = false;
        this.StateFlag[ID.F.AtkType_AirHeavy] = false;
    }


}

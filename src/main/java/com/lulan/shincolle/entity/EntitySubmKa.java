package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntitySubmKa.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntitySubmKa extends BasicEntityShipSmall
{


    public EntitySubmKa(EntityType<? extends BasicEntityShip> type, Level level)
    {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipIconType.SUBMARINE);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.SSKA);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.SUBMARINE);
        this.setStateMinor(ID.M.NumState, 4);
        this.setGrudgeConsumeIdle(ShinColleConfig.consumeGrudgeShipIdle[ID.ShipConsume.SS]);
        this.setAmmoConsumption(ShinColleConfig.consumeAmmoShip[ID.ShipConsume.SS]);
        this.StateFlag[ID.F.AtkType_AirLight] = false;
        this.StateFlag[ID.F.AtkType_AirHeavy] = false;
        this.StateFlag[ID.F.CanPickItem] = true;
    }


}

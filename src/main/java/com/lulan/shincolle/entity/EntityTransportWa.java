package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntityTransportWa.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntityTransportWa extends BasicEntityShipSmall
{


    public EntityTransportWa(EntityType<? extends BasicEntityShip> type, Level level)
    {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipIconType.TRANSPORT);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.APWA);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.UNDEFINED);
        this.setStateMinor(ID.M.NumState, 3);
        this.setGrudgeConsumeIdle(ShinColleConfig.consumeGrudgeShipIdle[ID.ShipConsume.AP]);
        this.setAmmoConsumption(ShinColleConfig.consumeAmmoShip[ID.ShipConsume.AP]);
        this.StateFlag[ID.F.AtkType_Light] = false;
        this.StateFlag[ID.F.AtkType_Heavy] = false;
        this.StateFlag[ID.F.AtkType_AirLight] = false;
        this.StateFlag[ID.F.AtkType_AirHeavy] = false;
        this.StateFlag[ID.F.CanPickItem] = true;
    }


}

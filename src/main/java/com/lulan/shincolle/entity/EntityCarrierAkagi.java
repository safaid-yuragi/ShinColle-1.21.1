package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntityCarrierAkagi.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntityCarrierAkagi extends BasicEntityShipCV
{


    public EntityCarrierAkagi(EntityType<? extends BasicEntityShip> type, Level level)
    {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipIconType.STANDARD_CARRIER);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.CVAkagi);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.CARRIER);
        this.setStateMinor(ID.M.NumState, 8);
        this.setGrudgeConsumeIdle(ShinColleConfig.consumeGrudgeShipIdle[ID.ShipConsume.CV]);
        this.setAmmoConsumption(ShinColleConfig.consumeAmmoShip[ID.ShipConsume.CV]);
        this.StateFlag[ID.F.AtkType_Light] = false;
        this.StateFlag[ID.F.AtkType_Heavy] = false;
    }


}

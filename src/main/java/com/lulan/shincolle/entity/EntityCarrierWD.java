package com.lulan.shincolle.entity;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * port of legacy EntityCarrierWD.
 * AI/attack goals and skill behaviour are added in Phase 4.
 */
public class EntityCarrierWD extends BasicEntityShipCV
{


    public EntityCarrierWD(EntityType<? extends BasicEntityShip> type, Level level)
    {
        super(type, level);
        this.setStateMinor(ID.M.ShipType, ID.ShipIconType.DEMON);
        this.setStateMinor(ID.M.ShipClass, ID.ShipClass.CVWD);
        this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.CARRIER);
        this.setStateMinor(ID.M.NumState, 2);
        this.setGrudgeConsumeIdle(ShinColleConfig.consumeGrudgeShipIdle[ID.ShipConsume.CV]);
        this.setAmmoConsumption(ShinColleConfig.consumeAmmoShip[ID.ShipConsume.CV]);
        this.StateFlag[ID.F.AtkType_Heavy] = false;
    }


}

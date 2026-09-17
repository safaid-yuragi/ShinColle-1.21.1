package com.lulan.shincolle.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * carrier ship base (legacy BasicEntityShipCV).
 * Carrier ships can hold aircraft equips and summon planes (Phase 4).
 */
abstract public class BasicEntityShipCV extends BasicEntityShip
{


    public BasicEntityShipCV(EntityType<? extends BasicEntityShip> type, Level level)
    {
        super(type, level);
    }

    /** equip type 3: airplane + misc slots */
    @Override
    public int getEquipType()
    {
        return 3;
    }

    @Override
    public boolean canSummonMounts()
    {
        return true;
    }


}

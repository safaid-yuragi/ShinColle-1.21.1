package com.lulan.shincolle.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * carrier aircraft base (legacy BasicEntityAirplane).
 * Flies, ignores gravity/fall damage, returns to host when done.
 */
abstract public class BasicEntityAirplane extends BasicEntitySummon
{

    protected boolean backHome = false;
    protected boolean canFindTarget = true;


    public BasicEntityAirplane(EntityType<? extends BasicEntitySummon> type, Level level)
    {
        super(type, level);
        this.setStepHeight(7F);
        this.setNoGravity(true);
    }

    @Override
    public boolean isNoGravity()
    {
        return true;
    }

    @Override
    public boolean onGround()
    {
        //aircraft never count as grounded
        return false;
    }

    @Override
    public boolean causeFallDamage(float distance, float multiplier,
                                   net.minecraft.world.damagesource.DamageSource source)
    {
        return false;
    }

    public boolean isBackHome()
    {
        return this.backHome;
    }

    public void setBackHome(boolean value)
    {
        this.backHome = value;
    }

    public boolean canFindTarget()
    {
        return this.canFindTarget;
    }


}

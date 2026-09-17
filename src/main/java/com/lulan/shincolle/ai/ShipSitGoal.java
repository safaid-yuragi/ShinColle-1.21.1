package com.lulan.shincolle.ai;

import java.util.EnumSet;

import com.lulan.shincolle.entity.BasicEntityShip;

import net.minecraft.world.entity.ai.goal.Goal;

/**
 * sit goal for ships (legacy EntityAIShipSit).
 * Ships can sit in liquid.
 */
public class ShipSitGoal extends Goal
{

    private final BasicEntityShip host;


    public ShipSitGoal(BasicEntityShip entity)
    {
        this.host = entity;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse()
    {
        return this.host.getIsSitting();
    }

    @Override
    public void start()
    {
        this.host.setEntitySit(true);
        this.host.setJumping(false);
    }

    @Override
    public void tick()
    {
        this.host.getShipNavigate().clearPathEntity();
        this.host.setTarget(null);
        this.host.setEntityTarget(null);
    }

    @Override
    public void stop()
    {
        this.host.setEntitySit(false);
    }


}

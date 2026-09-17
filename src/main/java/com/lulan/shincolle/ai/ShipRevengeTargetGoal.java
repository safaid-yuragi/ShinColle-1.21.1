package com.lulan.shincolle.ai;

import java.util.EnumSet;

import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.entity.IShipAttackBase;
import com.lulan.shincolle.utility.TargetHelper;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.Goal;

/**
 * revenge target goal (legacy EntityAIShipRevengeTarget).
 * Copies the revenge target to the attack target when it changes.
 */
public class ShipRevengeTargetGoal extends Goal
{

    private final IShipAttackBase host;
    private final java.util.function.Predicate<Entity> targetSelector;
    private int oldRevengeTime;


    public ShipRevengeTargetGoal(IShipAttackBase host)
    {
        this.host = host;
        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
        this.oldRevengeTime = 0;

        if (host instanceof BasicEntityShipHostile)
        {
            this.targetSelector = new TargetHelper.RevengeSelectorForHostile((Entity) host);
        }
        else
        {
            this.targetSelector = new TargetHelper.RevengeSelector((Entity) host);
        }
    }

    @Override
    public boolean canUse()
    {
        if (this.oldRevengeTime != this.host.getEntityRevengeTime() &&
            this.host.getEntityRevengeTarget() != null)
        {
            return this.targetSelector.test(this.host.getEntityRevengeTarget());
        }

        return false;
    }

    @Override
    public void start()
    {
        this.host.setEntityTarget(this.host.getEntityRevengeTarget());
        this.oldRevengeTime = this.host.getEntityRevengeTime();

        this.host.setEntityRevengeTarget(null);
    }


}

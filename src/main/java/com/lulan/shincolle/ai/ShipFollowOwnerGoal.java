package com.lulan.shincolle.ai;

import java.util.EnumSet;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

/**
 * follow owner goal (port of EntityAIShipFollowOwner, simplified).
 * Respects ID.F.CanFollow, ID.M.FollowMin/FollowMax and sit order.
 */
public class ShipFollowOwnerGoal extends Goal
{

    private final BasicEntityShip ship;
    private LivingEntity owner;
    private int timeToRecalcPath;


    public ShipFollowOwnerGoal(BasicEntityShip ship)
    {
        this.ship = ship;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse()
    {
        LivingEntity owner = this.ship.getOwner();

        if (owner == null || !owner.isAlive()) return false;
        if (this.ship.isOrderedToSit()) return false;
        if (!this.ship.getStateFlag(ID.F.CanFollow)) return false;

        double dist = this.ship.distanceToSqr(owner);
        if (dist < (double) this.ship.getStateMinor(ID.M.FollowMin) * this.ship.getStateMinor(ID.M.FollowMin))
        {
            return false;
        }

        this.owner = owner;
        return true;
    }

    @Override
    public boolean canContinueToUse()
    {
        if (this.ship.getNavigation().isDone()) return false;
        if (this.ship.isOrderedToSit()) return false;
        if (!this.ship.getStateFlag(ID.F.CanFollow)) return false;

        double max = this.ship.getStateMinor(ID.M.FollowMax);
        return this.ship.distanceToSqr(this.owner) > max * max * 0.25D
            || this.ship.distanceToSqr(this.owner) > (double) this.ship.getStateMinor(ID.M.FollowMin)
                                               * this.ship.getStateMinor(ID.M.FollowMin);
    }

    @Override
    public void start()
    {
        this.timeToRecalcPath = 0;
    }

    @Override
    public void stop()
    {
        this.owner = null;
        this.ship.getNavigation().stop();
    }

    @Override
    public void tick()
    {
        this.ship.getLookControl().setLookAt(this.owner, 10.0F, this.ship.getMaxHeadXRot());

        if (--this.timeToRecalcPath <= 0)
        {
            this.timeToRecalcPath = 10;
            this.ship.getNavigation().moveTo(this.owner, 1.0D);
        }
    }


}

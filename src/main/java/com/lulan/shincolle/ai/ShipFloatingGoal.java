package com.lulan.shincolle.ai;

import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IFloatingEntity;
import com.lulan.shincolle.entity.IShipGuardian;
import com.lulan.shincolle.reference.ID;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Blocks;

/**
 * float-on-water goal (legacy EntityAIShipFloating).
 * If in liquid and the block above is air, float up to the surface.
 */
public class ShipFloatingGoal extends Goal
{

    private final IFloatingEntity host;
    private final BasicEntityShip hostShip;
    private final BasicEntityMount hostMount;
    private final LivingEntity hostLiving;


    public ShipFloatingGoal(IFloatingEntity entity)
    {
        this.host = entity;
        this.hostLiving = (LivingEntity) entity;

        if (entity instanceof BasicEntityShip ship)
        {
            this.hostShip = ship;
            this.hostMount = null;
        }
        else if (entity instanceof BasicEntityMount mount)
        {
            this.hostShip = null;
            this.hostMount = mount;
        }
        else
        {
            this.hostShip = null;
            this.hostMount = null;
        }
    }

    @Override
    public boolean canUse()
    {
        //ship: check sit state
        if (this.hostShip != null)
        {
            if (this.hostShip.getStateFlag(ID.F.CanFloatUp) &&
                this.hostShip.getEntityDepth() > this.hostShip.getEntityFloatingDepth())
            {
                if (this.hostShip.isPassenger() || this.hostShip.isOrderedToSit() ||
                    this.hostShip.getStateMinor(ID.M.CraneState) > 0 ||
                    !this.hostShip.getShipNavigate().noPath() ||
                    isInGuardPosition(this.hostShip))
                {
                    return false;
                }

                return true;
            }

            return false;
        }
        //mount: check mount depth + host sit state
        else if (this.hostMount != null && this.hostMount.getHostEntity() != null)
        {
            if (this.hostMount.getEntityDepth() > this.hostMount.getEntityFloatingDepth())
            {
                BasicEntityShip ship = (BasicEntityShip) this.hostMount.getHostEntity();

                if (ship.isOrderedToSit() || ship.getStateMinor(ID.M.CraneState) > 0 ||
                    !ship.getShipNavigate().noPath() || isInGuardPosition(ship))
                {
                    return false;
                }

                if (!this.hostMount.getShipNavigate().noPath() ||
                    isInGuardPosition(this.hostMount))
                {
                    return false;
                }

                return true;
            }

            return false;
        }

        return this.host.getEntityDepth() > this.host.getEntityFloatingDepth();
    }

    @Override
    public void tick()
    {
        double depth = this.host.getEntityDepth();
        var mot = this.hostLiving.getDeltaMovement();

        if (depth > 4D) mot = mot.add(0D, 0.025D, 0D);
        else if (depth > 2D) mot = mot.add(0D, 0.015D, 0D);
        else if (depth > 1.3D) mot = mot.add(0D, 0.007D, 0D);
        else if (depth > 0.47D) mot = mot.add(0D, 0.003D, 0D);
        else if (depth > 0.15D) mot = mot.add(0D, 0.0015D, 0D);
        else return;

        this.hostLiving.setDeltaMovement(mot);
    }

    /** check is in guard position (legacy EntityAIShipFloating.isInGuardPosition) */
    public static boolean isInGuardPosition(IShipGuardian host)
    {
        Entity ent = (Entity) host;

        //if the block above is air, floating is allowed
        if (ent.level().getBlockState(ent.blockPosition().above()).is(Blocks.AIR))
        {
            return false;
        }

        if (!host.getStateFlag(ID.F.CanFollow))
        {
            float fMin = host.getStateMinor(ID.M.FollowMin) + ent.getBbWidth() * 0.5F;
            fMin = fMin * fMin;

            if (host.getGuardedEntity() != null)
            {
                if (ent.distanceToSqr(host.getGuardedEntity()) < fMin) return true;
            }
            else if (host.getStateMinor(ID.M.GuardY) > 0)
            {
                double distSq = ent.distanceToSqr(
                    host.getStateMinor(ID.M.GuardX),
                    host.getStateMinor(ID.M.GuardY),
                    host.getStateMinor(ID.M.GuardZ));
                if (distSq < fMin && ent.getY() >= host.getStateMinor(ID.M.GuardY))
                {
                    return true;
                }
            }
        }
        else
        {
            float fMax = host.getStateMinor(ID.M.FollowMax) + ent.getBbWidth() * 0.5F;
            fMax = fMax * fMax;

            if (host.getHostEntity() != null)
            {
                if (host.getHostEntity().distanceToSqr(ent) <= fMax) return true;
            }
        }

        return false;
    }


}

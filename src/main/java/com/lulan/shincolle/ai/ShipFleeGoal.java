package com.lulan.shincolle.ai;

import java.util.EnumSet;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

/**
 * flee goal (legacy EntityAIShipFlee).
 * If ship HP falls below fleeHP%, it stops attacking and moves to the owner.
 */
public class ShipFleeGoal extends Goal
{

    private final BasicEntityShip host;
    private LivingEntity owner;
    private float distSq;
    private float fleehp;
    private int findCooldown;


    public ShipFleeGoal(BasicEntityShip entity)
    {
        this.host = entity;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse()
    {
        this.fleehp = (float) this.host.getStateMinor(ID.M.FleeHP) * 0.01F;

        if (!this.host.isOrderedToSit() && !this.host.isLeashed() &&
            (this.host.getHealth() / this.host.getMaxHealth()) <= this.fleehp &&
            this.host.getStateMinor(ID.M.NumGrudge) > 0)
        {
            Entity ownerEntity = this.host.getHostEntity();

            if (ownerEntity instanceof LivingEntity living)
            {
                this.owner = living;

                double dx = this.owner.getX() - this.host.getX();
                double dy = this.owner.getY() - this.host.getY();
                double dz = this.owner.getZ() - this.host.getZ();
                this.distSq = (float) (dx * dx + dy * dy + dz * dz);

                return this.distSq > 6F && this.distSq < 3600F;
            }
        }

        return false;
    }

    @Override
    public boolean canContinueToUse()
    {
        return this.canUse();
    }

    @Override
    public void start()
    {
        this.findCooldown = 0;
    }

    @Override
    public void stop()
    {
        this.owner = null;
        this.host.getShipNavigate().clearPathEntity();
    }

    @Override
    public void tick()
    {
        this.findCooldown--;

        this.host.getLookControl().setLookAt(this.owner, 10.0F,
            (float) this.host.getMaxHeadXRot());

        if (this.findCooldown <= 0)
        {
            this.findCooldown = 16;
            boolean canMove;

            if (this.host.isPassenger() &&
                this.host.getVehicle() instanceof BasicEntityMount mount)
            {
                canMove = mount.getShipNavigate().tryMoveToEntityLiving(this.owner, 1.2D);
            }
            else
            {
                canMove = this.host.getShipNavigate().tryMoveToEntityLiving(this.owner, 1.2D);
            }

            //move failed: teleport entity
            if (!canMove)
            {
                if (!ShinColleConfig.canTeleport) return;

                if (this.distSq > 100F)
                {
                    LogHelper.debug("DEBUG: flee AI: moving fail, teleport entity " + this.host);

                    if (this.host.level().dimension() == this.owner.level().dimension())
                    {
                        EntityHelper.applyTeleport(this.host, this.distSq, new Vec3(
                            this.owner.getX(), this.owner.getY() + 0.5D, this.owner.getZ()));
                    }
                }
            }
        }
    }


}

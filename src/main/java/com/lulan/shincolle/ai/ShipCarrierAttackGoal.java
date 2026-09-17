package com.lulan.shincolle.ai;

import java.util.EnumSet;

import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.IShipAircraftAttack;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.CombatHelper;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

/**
 * carrier range attack goal (legacy EntityAIShipCarrierAttack).
 * Host must implement IShipAircraftAttack.
 */
public class ShipCarrierAttackGoal extends Goal
{

    private final IShipAircraftAttack host;
    private final Mob host2;
    private Entity target;
    private int launchDelay = 20;
    private int launchDelayMax = 40;
    private boolean launchType;
    private float range;
    private float rangeSq;
    private double distSq;


    public ShipCarrierAttackGoal(IShipAircraftAttack host)
    {
        this.host = host;
        this.host2 = (Mob) host;
        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
    }

    @Override
    public boolean canUse()
    {
        if (this.host.getIsSitting() || this.host.getStateMinor(ID.M.CraneState) > 0)
        {
            return false;
        }

        if (this.host.getIsRiding() &&
            this.host2.getVehicle() instanceof BasicEntityMount)
        {
            return false;
        }

        Entity target = this.host.getEntityTarget();

        if (target != null && target.isAlive() &&
            ((this.host.getAttackType(ID.F.AtkType_AirLight) &&
              this.host.getStateFlag(ID.F.UseAirLight) &&
              this.host.hasAmmoLight() && this.host.hasAirLight()) ||
             (this.host.getAttackType(ID.F.AtkType_AirHeavy) &&
              this.host.getStateFlag(ID.F.UseAirHeavy) &&
              this.host.hasAmmoHeavy() && this.host.hasAirHeavy())))
        {
            this.target = target;
            return true;
        }

        return false;
    }

    @Override
    public void start()
    {
        this.distSq = 0D;
    }

    @Override
    public boolean canContinueToUse()
    {
        if (this.target != null && this.target.isAlive() &&
            !this.host.getShipNavigate().noPath())
        {
            return true;
        }

        return this.canUse();
    }

    @Override
    public void stop()
    {
        this.target = null;
    }

    @Override
    public void tick()
    {
        if (this.target == null) return;

        boolean onSight = this.host2.getSensing().hasLineOfSight(this.target);

        if (!onSight && this.host.getStateFlag(ID.F.OnSightChase))
        {
            this.stop();
            return;
        }

        if (this.host2.tickCount % 64 == 0)
        {
            this.launchDelayMax = CombatHelper.getAttackDelay(
                this.host.getAttrs().getAttackSpeed(), this.launchType ? 3 : 4);
            this.range = this.host.getAttrs().getAttackRange();
            this.rangeSq = this.range * this.range;
        }

        if (this.distSq >= this.rangeSq)
        {
            double dx = this.target.getX() - this.host2.getX();
            double dy = this.target.getY() - this.host2.getY();
            double dz = this.target.getZ() - this.host2.getZ();
            this.distSq = dx * dx + dy * dy + dz * dz;

            if (this.distSq < this.rangeSq && onSight &&
                !this.host.getStateFlag(ID.F.UseMelee))
            {
                this.host.getShipNavigate().clearPathEntity();
            }
            else if (this.host2.tickCount % 32 == 0)
            {
                this.host.getShipNavigate().tryMoveToEntityLiving(this.target, 1D);
            }
        }

        this.host2.getLookControl().setLookAt(this.target.getX(),
            this.target.getY() + 2D, this.target.getZ(), 30.0F, 60.0F);

        this.launchDelay--;

        //single ammo type: disable launch type switching
        if (!this.host.getStateFlag(ID.F.UseAirLight)) this.launchType = false;
        if (!this.host.getStateFlag(ID.F.UseAirHeavy)) this.launchType = true;

        if (onSight && this.distSq <= this.rangeSq && this.launchDelay <= 0)
        {
            if (this.launchType && this.host.hasAmmoLight() && this.host.hasAirLight())
            {
                this.host.attackEntityWithAircraft(this.target);
                this.launchDelay = this.launchDelayMax;
            }

            if (!this.launchType && this.host.hasAmmoHeavy() && this.host.hasAirHeavy())
            {
                this.host.attackEntityWithHeavyAircraft(this.target);
                this.launchDelay = this.launchDelayMax;
            }

            this.launchType = !this.launchType;
        }

        if (this.launchDelay < -80)
        {
            this.launchDelay = 20;
            this.stop();
        }
    }


}

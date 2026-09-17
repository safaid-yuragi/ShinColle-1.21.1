package com.lulan.shincolle.ai;

import java.util.EnumSet;

import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.IShipCannonAttack;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.CombatHelper;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

/**
 * cannon range attack goal (legacy EntityAIShipRangeAttack).
 * Host must implement IShipCannonAttack.
 */
public class ShipRangeAttackGoal extends Goal
{

    private final IShipCannonAttack host;
    private final Mob host2;
    private Entity target;
    private int delayLight = 20;
    private int maxDelayLight = 20;
    private int delayHeavy = 40;
    private int maxDelayHeavy = 40;
    private int onSightTime;
    private float range;
    private float rangeSq;
    private int aimTime;


    public ShipRangeAttackGoal(IShipCannonAttack host)
    {
        this.host = host;
        this.host2 = (Mob) host;
        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
    }

    @Override
    public boolean canUse()
    {
        //sitting / being craned: no attack
        if (this.host.getIsSitting() || this.host.getStateMinor(ID.M.CraneState) > 0)
        {
            return false;
        }

        //riding a ship mount: mount handles the attack
        if (this.host.getIsRiding() &&
            this.host2.getVehicle() instanceof BasicEntityMount)
        {
            return false;
        }

        Entity target = this.host.getEntityTarget();

        if (target != null && target.isAlive() &&
            ((this.host.getAttackType(ID.F.AtkType_Light) &&
              this.host.getStateFlag(ID.F.UseAmmoLight) && this.host.hasAmmoLight()) ||
             (this.host.getAttackType(ID.F.AtkType_Heavy) &&
              this.host.getStateFlag(ID.F.UseAmmoHeavy) && this.host.hasAmmoHeavy())))
        {
            this.target = target;
            return true;
        }

        return false;
    }

    @Override
    public void start()
    {
        this.updateAttackParms();

        if (this.delayLight <= this.aimTime)
        {
            this.delayLight = this.aimTime;
        }

        if (this.delayHeavy <= this.aimTime * 2)
        {
            this.delayHeavy = this.aimTime * 2;
        }
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
        this.onSightTime = 0;
    }

    @Override
    public void tick()
    {
        if (this.target == null) return;

        if (this.host2.tickCount % 64 == 0)
        {
            this.updateAttackParms();
        }

        this.delayLight--;
        this.delayHeavy--;

        double distX = this.target.getX() - this.host2.getX();
        double distY = this.target.getY() - this.host2.getY();
        double distZ = this.target.getZ() - this.host2.getZ();
        double distSq = distX * distX + distY * distY + distZ * distZ;

        boolean onSight = this.host2.getSensing().hasLineOfSight(this.target);

        if (onSight)
        {
            ++this.onSightTime;
        }
        else
        {
            this.onSightTime = 0;

            //OnSightChase: lose target when out of sight
            if (this.host.getStateFlag(ID.F.OnSightChase))
            {
                this.stop();
                return;
            }
        }

        //in range and on sight: stop chasing (unless melee mode)
        if (distSq < this.rangeSq && onSight && !this.host.getStateFlag(ID.F.UseMelee))
        {
            this.host.getShipNavigate().clearPathEntity();
        }
        else
        {
            if (this.host2.tickCount % 32 == 0)
            {
                this.host.getShipNavigate().tryMoveToEntityLiving(this.target, 1D);
            }
        }

        this.host2.getLookControl().setLookAt(this.target, 30F, 30F);

        if (onSight && distSq <= this.rangeSq && this.onSightTime >= this.aimTime)
        {
            if (this.delayLight <= 0 && this.host.useAmmoLight() && this.host.hasAmmoLight())
            {
                this.host.attackEntityWithAmmo(this.target);
                this.delayLight = this.maxDelayLight;
            }

            if (this.delayHeavy <= 0 && this.host.useAmmoHeavy() && this.host.hasAmmoHeavy())
            {
                this.host.attackEntityWithHeavyAmmo(this.target);
                this.delayHeavy = this.maxDelayHeavy;
            }
        }

        //can't reach the target for too long: reset
        if (this.delayHeavy < -40 && this.delayLight < -40)
        {
            this.delayLight = 20;
            this.delayHeavy = 20;
            this.stop();
        }
    }

    private void updateAttackParms()
    {
        this.maxDelayLight = CombatHelper.getAttackDelay(this.host.getAttrs().getAttackSpeed(), 1);
        this.maxDelayHeavy = CombatHelper.getAttackDelay(this.host.getAttrs().getAttackSpeed(), 2);
        this.aimTime = (int) (20F * (150 - this.host.getLevel()) / 150F) + 10;
        this.range = this.host.getAttrs().getAttackRange();
        this.rangeSq = this.range * this.range;
    }


}

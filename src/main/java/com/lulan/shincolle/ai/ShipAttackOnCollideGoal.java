package com.lulan.shincolle.ai;

import java.util.EnumSet;

import com.lulan.shincolle.entity.IShipAttackBase;
import com.lulan.shincolle.utility.CombatHelper;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

/**
 * melee attack goal (legacy EntityAIShipAttackOnCollide).
 * Host must be a Mob implementing IShipAttackBase.
 */
public class ShipAttackOnCollideGoal extends Goal
{

    private final IShipAttackBase host;
    private final Mob host2;
    private Entity target;
    private final double moveSpeed;
    private int delayAttack = 20;
    private int delayMax = 20;


    public ShipAttackOnCollideGoal(IShipAttackBase host, double speed)
    {
        this.host = host;
        this.host2 = (Mob) host;
        this.moveSpeed = speed;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse()
    {
        if (this.host2.isPassenger() || this.host.getIsSitting())
        {
            return false;
        }

        this.target = this.host.getEntityTarget();

        return this.target != null && this.target.isAlive();
    }

    @Override
    public boolean canContinueToUse()
    {
        return this.canUse();
    }

    @Override
    public void tick()
    {
        if (this.target == null || !this.target.isAlive()) return;

        this.host2.getLookControl().setLookAt(this.target, 30.0F, 30.0F);

        double distTarget = this.host2.distanceToSqr(
            this.target.getX(), this.target.getBoundingBox().minY, this.target.getZ());
        double distAttack = this.host2.getBbWidth() * this.host2.getBbWidth() * 16F;

        if (this.host2.tickCount % 32 == 0)
        {
            this.delayMax = CombatHelper.getAttackDelay(
                this.host.getAttrs().getAttackSpeed(), 0);

            if (distTarget > distAttack)
            {
                this.host.getShipNavigate().tryMoveToEntityLiving(this.target, this.moveSpeed);
            }
            else
            {
                this.host.getShipNavigate().clearPathEntity();
            }
        }

        if (distTarget <= distAttack && --this.delayAttack == 0)
        {
            this.delayAttack = this.delayMax;

            if (!this.host2.getMainHandItem().isEmpty())
            {
                this.host2.swing(InteractionHand.MAIN_HAND);
            }

            this.host2.doHurtTarget(this.target);
        }
    }


}

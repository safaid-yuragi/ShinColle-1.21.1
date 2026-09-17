package com.lulan.shincolle.ai;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

/**
 * look idle goal (legacy EntityAIShipLookIdle).
 */
public class ShipLookIdleGoal extends Goal
{

    private final Mob host;
    private final IShipEmotion host2;
    private double lookX;
    private double lookZ;
    private int idleTime;


    public ShipLookIdleGoal(Mob entity)
    {
        this.host = entity;
        this.host2 = (IShipEmotion) entity;
    }

    @Override
    public boolean canUse()
    {
        if (this.host2.getStateFlag(ID.F.NoFuel) ||
            this.host.getVehicle() instanceof BasicEntityShip)
        {
            return false;
        }

        return this.host.getRandom().nextFloat() < 0.02F;
    }

    @Override
    public boolean canContinueToUse()
    {
        return this.idleTime >= 0;
    }

    @Override
    public void start()
    {
        double d0 = (Math.PI * 2D) * this.host.getRandom().nextDouble();
        this.lookX = Math.cos(d0);
        this.lookZ = Math.sin(d0);
        this.idleTime = 20 + this.host.getRandom().nextInt(20);
    }

    @Override
    public void tick()
    {
        --this.idleTime;
        this.host.getLookControl().setLookAt(
            this.host.getX() + this.lookX,
            this.host.getY() + (double) this.host.getEyeHeight(),
            this.host.getZ() + this.lookZ,
            (float) this.host.getHeadRotSpeed(),
            (float) this.host.getMaxHeadXRot());
    }


}

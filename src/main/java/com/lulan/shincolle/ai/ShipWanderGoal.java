package com.lulan.shincolle.ai;

import java.util.EnumSet;

import javax.annotation.Nullable;

import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipAttackBase;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.phys.Vec3;

/**
 * wander goal (legacy EntityAIShipWander).
 */
public class ShipWanderGoal extends Goal
{

    private final IShipAttackBase host;
    private final PathfinderMob host2;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private final double speed;
    private final int ranXZ, ranY;


    public ShipWanderGoal(PathfinderMob host, int rangeXZ, int rangeY, double speed)
    {
        if (!(host instanceof IShipAttackBase))
        {
            throw new IllegalArgumentException("Wander goal requires IShipAttackBase host");
        }

        this.host = (IShipAttackBase) host;
        this.host2 = host;
        this.ranXZ = rangeXZ;
        this.ranY = rangeY;
        this.speed = speed;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
    }

    @Override
    public boolean canUse()
    {
        if (this.host.getIsRiding() || this.host.getIsSitting() ||
            this.host.getStateMinor(ID.M.CraneState) > 0 ||
            this.host2.getRandom().nextInt(180) != 0)
        {
            return false;
        }

        //fishing check
        if (this.host instanceof BasicEntityShip ship && ship.fishHook != null)
        {
            return false;
        }
        else if (this.host instanceof BasicEntityMount mount &&
                 mount.getHostEntity() instanceof BasicEntityShip ship &&
                 ship.fishHook != null)
        {
            return false;
        }

        Vec3 vec = DefaultRandomPos.getPos(this.host2, this.ranXZ, this.ranY);

        if (vec == null)
        {
            return false;
        }

        this.xPosition = vec.x;
        this.yPosition = vec.y;
        this.zPosition = vec.z;
        return true;
    }

    @Override
    public boolean canContinueToUse()
    {
        return !this.host.getShipNavigate().noPath();
    }

    @Override
    public void start()
    {
        this.host.getShipNavigate().tryMoveToXYZ(
            this.xPosition, this.yPosition, this.zPosition, this.speed);
    }


}

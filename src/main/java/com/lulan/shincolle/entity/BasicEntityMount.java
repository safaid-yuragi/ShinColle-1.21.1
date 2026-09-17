package com.lulan.shincolle.entity;

import javax.annotation.Nullable;

import com.lulan.shincolle.reference.ID;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/**
 * rideable ship-mount base (legacy BasicEntityMount).
 * Mounts are summoned by hime-class ships and can be ridden by the
 * host ship (and the player, Phase 7).
 */
abstract public class BasicEntityMount extends BasicEntitySummon
        implements IShipGuardian
{

    /** ship riding position offsets */
    protected float[] seatPos = new float[] {0F, 0F, 0F};
    protected float[] seatPos2 = new float[] {0F, 0F, 0F};

    @Nullable
    protected Entity guardedEntity;
    protected BlockPos lastWaypoint = BlockPos.ZERO;

    /** rider jump key state (server, fed by MountMovePayload) */
    protected int riderJumpTicks = 0;


    public BasicEntityMount(EntityType<? extends BasicEntityMount> type, Level level)
    {
        super(type, level);
        this.setStepHeight(3F);
    }

    @Nullable
    public BasicEntityShip getHostShip()
    {
        return this.host instanceof BasicEntityShip s ? s : null;
    }

    /* ==================== riding ==================== */

    @Nullable
    @Override
    public net.minecraft.world.entity.LivingEntity getControllingPassenger()
    {
        return this.getFirstPassenger() instanceof net.minecraft.world.entity.LivingEntity le
            ? le : null;
    }

    /**
     * ridden movement: follow passenger input. Vanilla syncs player
     * directional input for vehicles, so no extra packet is needed.
     */
    @Override
    public void travel(Vec3 input)
    {
        if (!this.isAlive()) return;

        if (this.isVehicle() && this.getControllingPassenger() instanceof
                net.minecraft.world.entity.player.Player player)
        {
            this.setYRot(player.getYRot());
            this.yRotO = this.getYRot();
            this.setXRot(player.getXRot() * 0.5F);
            this.setRot(this.getYRot(), this.getXRot());
            this.yHeadRot = this.yBodyRot = this.getYRot();

            float strafe = player.xxa * 0.5F;
            float forward = player.zza;
            if (forward <= 0F) forward *= 0.25F;

            if (this.riderJumpTicks > 0 && (this.onGround() || this.isInWater()))
            {
                this.jumpFromGround();
            }

            var speed = this.getAttribute(
                net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED);
            if (speed != null) this.setSpeed((float) speed.getValue());

            super.travel(new Vec3(strafe, input.y, forward));
        }
        else
        {
            super.travel(input);
        }
    }

    @Override
    public boolean canDrownInFluidType(net.neoforged.neoforge.fluids.FluidType type)
    {
    	return false;
    }

    /** set by MountMovePayload; held for a couple of ticks */
    public void setRiderJump(boolean jumping)
    {
        this.riderJumpTicks = jumping ? 2 : 0;
    }

    @Override
    public void tick()
    {
        super.tick();
        if (this.riderJumpTicks > 0) this.riderJumpTicks--;
    }

    /* ==================== IShipGuardian ==================== */

    @Nullable
    @Override
    public Entity getGuardedEntity()
    {
        if (this.guardedEntity == null && this.getStateMinor(ID.M.GuardID) > 0)
        {
            Entity e = this.level().getEntity(this.getStateMinor(ID.M.GuardID));
            if (e != null && e.isAlive()) this.guardedEntity = e;
        }
        return this.guardedEntity;
    }

    @Override
    public void setGuardedEntity(@Nullable Entity entity)
    {
        if (entity != null && entity.isAlive())
        {
            this.guardedEntity = entity;
            this.setStateMinor(ID.M.GuardID, entity.getId());
        }
        else
        {
            this.guardedEntity = null;
            this.setStateMinor(ID.M.GuardID, -1);
        }
    }

    @Override
    public int getGuardedPos(int index)
    {
        return switch (index)
        {
            case 0 -> this.getStateMinor(ID.M.GuardX);
            case 1 -> this.getStateMinor(ID.M.GuardY);
            case 2 -> this.getStateMinor(ID.M.GuardZ);
            case 3 -> this.getStateMinor(ID.M.GuardDim);
            case 4 -> this.getStateMinor(ID.M.GuardType);
            default -> -1;
        };
    }

    @Override
    public void setGuardedPos(int x, int y, int z, int dim, int type)
    {
        this.setStateMinor(ID.M.GuardX, x);
        this.setStateMinor(ID.M.GuardY, y);
        this.setStateMinor(ID.M.GuardZ, z);
        this.setStateMinor(ID.M.GuardDim, dim);
        this.setStateMinor(ID.M.GuardType, type);
    }

    @Override
    public BlockPos getLastWaypoint()
    {
        return this.lastWaypoint;
    }

    @Override
    public void setLastWaypoint(BlockPos pos)
    {
        this.lastWaypoint = pos;
    }

    @Override
    public int getWpStayTime()
    {
        return this.getStateTimer(ID.T.WpStayTime);
    }

    @Override
    public int getWpStayTimeMax()
    {
        return BasicEntityShip.wpStayTime2Ticks(this.getStateMinor(ID.M.WpStay));
    }

    @Override
    public void setWpStayTime(int time)
    {
        this.setStateTimer(ID.T.WpStayTime, time);
    }


}

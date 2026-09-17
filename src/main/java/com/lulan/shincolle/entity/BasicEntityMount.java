package com.lulan.shincolle.entity;

import javax.annotation.Nullable;

import com.lulan.shincolle.reference.ID;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

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

    @Override
    public boolean canDrownInFluidType(net.neoforged.neoforge.fluids.FluidType type)
    {
    	return false;
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

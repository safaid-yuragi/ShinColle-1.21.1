package com.lulan.shincolle.entity;

import javax.annotation.Nullable;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * rideable ship-mount base (legacy BasicEntityMount).
 * Mounts are summoned by hime-class ships and can be ridden by the
 * host ship (and the player, Phase 7).
 */
abstract public class BasicEntityMount extends BasicEntitySummon
{

    /** ship riding position offsets */
    protected float[] seatPos = new float[] {0F, 0F, 0F};
    protected float[] seatPos2 = new float[] {0F, 0F, 0F};


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


}

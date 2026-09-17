package com.lulan.shincolle.ai;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;

/**
 * watch closest player goal (legacy EntityAIShipWatchClosest).
 * Skips when out of fuel, riding a ship, or target is riding/invisible.
 */
public class ShipWatchClosestGoal extends LookAtPlayerGoal
{

    private final Mob host;
    private final IShipEmotion host2;
    private final float range;


    public ShipWatchClosestGoal(Mob entity, Class<? extends LivingEntity> target,
            float range, float rate)
    {
        super(entity, target, range, rate);
        this.host = entity;
        this.host2 = (IShipEmotion) entity;
        this.range = range;
    }

    @Override
    public boolean canUse()
    {
        Player target = this.host.level().getNearestPlayer(this.host, this.range);

        if (this.host2 != null)
        {
            if (this.host2.getStateFlag(ID.F.NoFuel) ||
                this.host.getVehicle() instanceof BasicEntityShip)
            {
                return false;
            }
        }

        if (target != null && (target.isPassenger() || target.isInvisible()))
        {
            return false;
        }

        return super.canUse();
    }


}

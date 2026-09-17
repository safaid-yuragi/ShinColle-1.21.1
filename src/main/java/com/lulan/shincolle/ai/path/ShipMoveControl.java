package com.lulan.shincolle.ai.path;

import com.lulan.shincolle.utility.EntityHelper;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;

/**
 * ship move control (legacy ShipMoveHelper).
 *
 * Adds vertical motion for flying entities and entities in liquid;
 * vanilla MoveControl only drives horizontal movement.
 */
public class ShipMoveControl extends MoveControl
{

    /** max turn per tick (deg) */
    private final float rotateLimit;
    private final boolean canFly;


    public ShipMoveControl(Mob mob, float rotateLimit, boolean canFly)
    {
        super(mob);
        this.rotateLimit = rotateLimit;
        this.canFly = canFly;
    }

    @Override
    public void tick()
    {
        if (this.operation == Operation.MOVE_TO)
        {
            this.operation = Operation.WAIT;

            double x1 = this.wantedX - this.mob.getX();
            double y1 = this.wantedY - this.mob.getY();
            double z1 = this.wantedZ - this.mob.getZ();
            double moveSq = x1 * x1 + y1 * y1 + z1 * z1;

            if (moveSq < 0.001D)
            {
                this.mob.setZza(0F);
                return;
            }

            float yawDeg = (float) (Mth.atan2(z1, x1) * Mth.RAD_TO_DEG) - 90F;
            float moveSpeed = (float) (this.speedModifier *
                this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED));

            this.mob.setYRot(this.rotlerp(this.mob.getYRot(), yawDeg, this.rotateLimit));

            //vertical motion
            if (this.canFly)
            {
                if (y1 > 0.5D)
                {
                    this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(0D, moveSpeed * 0.12D, 0D));
                    moveSpeed *= 0.8F;
                }
                else if (y1 < -0.5D)
                {
                    this.mob.setDeltaMovement(this.mob.getDeltaMovement().subtract(0D, moveSpeed * 0.16D, 0D));
                    moveSpeed *= 0.92F;
                }
            }
            else if (EntityHelper.checkEntityIsInLiquid(this.mob))
            {
                if (y1 > 1D)
                {
                    this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(0D, moveSpeed * 0.2D, 0D));
                    moveSpeed *= 0.5F;
                }
                else if (y1 > 0.35D)
                {
                    this.mob.setDeltaMovement(this.mob.getDeltaMovement().add(0D, moveSpeed * 0.1D, 0D));
                    moveSpeed *= 0.5F;
                }
                else if (y1 < -1D)
                {
                    this.mob.setDeltaMovement(this.mob.getDeltaMovement().subtract(0D, moveSpeed * 0.25D, 0D));
                    moveSpeed *= 0.82F;
                }
            }
            else if (y1 > this.mob.maxUpStep() && x1 * x1 + z1 * z1 < 1D)
            {
                this.mob.getJumpControl().jump();
            }

            this.mob.setSpeed(moveSpeed);
        }
        else
        {
            super.tick();
        }
    }


}

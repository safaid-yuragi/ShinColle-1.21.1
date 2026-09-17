package com.lulan.shincolle.ai;

import java.util.EnumSet;

import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.IShipAttackBase;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

/**
 * skill attack goal (legacy EntityAIShipSkillAttack).
 * While ID.S.Phase > 0, keeps calling updateSkillAttack(target).
 */
public class ShipSkillAttackGoal extends Goal
{

    private final IShipAttackBase host;
    private final Mob host2;


    public ShipSkillAttackGoal(IShipAttackBase host)
    {
        if (!(host instanceof Mob))
        {
            throw new IllegalArgumentException("SkillAttack goal requires Mob host");
        }

        this.host = host;
        this.host2 = (Mob) host;
        this.setFlags(EnumSet.allOf(Goal.Flag.class));
    }

    @Override
    public boolean canUse()
    {
        //sitting / being craned: no skill attack, reset phase
        if (this.host.getIsSitting() || this.host.getStateMinor(ID.M.CraneState) > 0)
        {
            if (this.host.getStateEmotion(ID.S.Phase) > 0)
            {
                this.host.setStateEmotion(ID.S.Phase, 0, true);
            }
            return false;
        }

        //riding a mount: attack handled by the mount
        if (this.host.getIsRiding() &&
            this.host2.getVehicle() instanceof BasicEntityMount)
        {
            return false;
        }

        return this.host.getStateEmotion(ID.S.Phase) > 0;
    }

    @Override
    public boolean canContinueToUse()
    {
        return this.canUse();
    }

    @Override
    public void tick()
    {
        this.host.updateSkillAttack(this.host.getEntityTarget());
    }


}

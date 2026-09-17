package com.lulan.shincolle.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.entity.IShipAttackBase;
import com.lulan.shincolle.entity.IShipFlyable;
import com.lulan.shincolle.entity.IShipInvisible;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.TargetHelper;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;

/**
 * range target goal (legacy EntityAIShipRangeTarget).
 *
 * Target priority: PVP > AntiAir > AntiSubm > normal target.
 * Registered to targetSelector.
 */
public class ShipRangeTargetGoal extends Goal
{

    protected final Class<? extends Entity> targetClass;
    protected final TargetHelper.Sorter targetSorter;
    protected Predicate<Entity> targetSelector;
    protected final IShipAttackBase host;
    protected final Mob host2;
    @Nullable
    protected final BasicEntityShip hostShip;
    protected Entity targetEntity;
    protected int range;


    public ShipRangeTargetGoal(IShipAttackBase host)
    {
        this(host, LivingEntity.class);
    }

    public ShipRangeTargetGoal(IShipAttackBase host, Class<? extends Entity> targetClass)
    {
        this.setFlags(EnumSet.of(Goal.Flag.TARGET));
        this.host = host;
        this.host2 = (Mob) host;
        this.targetClass = targetClass;
        this.targetSorter = new TargetHelper.Sorter((Entity) host);

        if (host instanceof BasicEntityShipHostile)
        {
            this.hostShip = null;
            this.targetSelector = new TargetHelper.SelectorForHostile((Entity) host);
        }
        else if (host instanceof BasicEntityShip ship)
        {
            this.hostShip = ship;
            this.targetSelector = new TargetHelper.Selector((Entity) host);
        }
        else
        {
            this.hostShip = null;
            this.targetSelector = new TargetHelper.Selector((Entity) host);
        }

        updateRange();
    }

    @Override
    public boolean canUse()
    {
        if (this.host.getIsSitting() || this.host.getStateMinor(ID.M.CraneState) > 0 ||
            this.host.getTickExisted() % 8 != 0)
        {
            return false;
        }

        updateRange();

        List<? extends Entity> list1 = null;
        List<? extends Entity> list2 = null;

        var box = this.host2.getBoundingBox()
            .inflate(this.range, this.range * 0.75D, this.range);

        if (this.hostShip != null)
        {
            //Anti Air first
            if (this.hostShip.getStateFlag(ID.F.AntiAir))
            {
                var l1 = this.host2.level().getEntitiesOfClass(
                    Entity.class, box,
                    e -> e instanceof IShipFlyable && this.targetSelector.test(e));
                var l2 = this.host2.level().getEntitiesOfClass(
                    FlyingMob.class, box, this.targetSelector);

                list1 = CalcHelper.listUnion(
                    new ArrayList<>(l1), new ArrayList<>(l2));
            }

            //if no AA target, find ASM target
            if (list1 == null || list1.isEmpty())
            {
                if (this.hostShip.getStateFlag(ID.F.AntiSS))
                {
                    list1 = this.host2.level().getEntitiesOfClass(
                        Entity.class, box,
                        e -> e instanceof IShipInvisible && this.targetSelector.test(e));
                }

                //find PVP target
                if (list1 == null || list1.isEmpty())
                {
                    if (this.hostShip.getStateFlag(ID.F.PVPFirst))
                    {
                        list1 = this.host2.level().getEntitiesOfClass(
                            BasicEntityShip.class, box, this.targetSelector);
                    }
                }
            }
        }

        //find normal target
        if (list1 == null || list1.isEmpty())
        {
            list1 = this.host2.level().getEntitiesOfClass(
                this.targetClass, box, this.targetSelector);
        }

        if (list1 != null && !list1.isEmpty())
        {
            var sorted = new ArrayList<>(list1);
            Collections.sort(sorted, this.targetSorter);

            this.targetEntity = sorted.get(0);

            //get random 0~2 target if >2 targets
            if (sorted.size() > 2)
            {
                this.targetEntity = sorted.get(this.host2.getRandom().nextInt(3));
            }

            return true;
        }

        return false;
    }

    @Override
    public void start()
    {
        this.host.setEntityTarget(this.targetEntity);
    }

    @Override
    public boolean canContinueToUse()
    {
        Entity target = this.host.getEntityTarget();

        if (target == null || !target.isAlive())
        {
            return false;
        }

        double d0 = (double) this.range * this.range;

        if (this.host2.distanceToSqr(target) > d0)
        {
            return false;
        }

        if (target instanceof Player p && p.getAbilities().invulnerable)
        {
            return false;
        }

        return true;
    }

    private void updateRange()
    {
        this.range = (int) this.host.getAttrs().getAttackRange();

        if (this.range < 2)
        {
            this.range = Math.max(2, this.host.getStateMinor(ID.M.FollowMax) + 2);
        }
    }


}

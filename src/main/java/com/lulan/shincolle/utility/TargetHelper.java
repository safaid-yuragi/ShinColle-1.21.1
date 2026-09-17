package com.lulan.shincolle.utility;

import java.util.Comparator;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.entity.BasicEntityAirplane;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.entity.EntityAbyssMissile;
import com.lulan.shincolle.entity.IShipAttackBase;
import com.lulan.shincolle.entity.IShipInvisible;
import com.lulan.shincolle.entity.IShipOwner;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;

/**
 * target selection predicates and sorting (legacy TargetHelper).
 *
 * Rules: PVP > AntiAir > AntiSubm > normal target. Team ally/ban lists
 * degrade to same-owner checks until the team GUI data lands in Phase 6.
 */
public class TargetHelper
{


    /** nearest-first entity sorter */
    public static class Sorter implements Comparator<Entity>
    {
        private final Entity targetEntity;

        public Sorter(Entity entity)
        {
            this.targetEntity = entity;
        }

        @Override
        public int compare(Entity t1, Entity t2)
        {
            double d0 = this.targetEntity.distanceToSqr(t1);
            double d1 = this.targetEntity.distanceToSqr(t2);
            return Double.compare(d0, d1);
        }
    }

    /** normal target selector for owned ships and summons */
    public static class Selector implements Predicate<Entity>
    {
        protected final Entity host;
        protected boolean isPVP;
        protected boolean isAA;
        protected boolean isASM;

        public Selector(Entity host)
        {
            this.host = host;
        }

        @Override
        public boolean test(Entity target)
        {
            //update flags
            if (host instanceof BasicEntityShip ship)
            {
                this.isPVP = ship.getStateFlag(ID.F.PVPFirst);
                this.isAA = ship.getStateFlag(ID.F.AntiAir);
                this.isASM = ship.getStateFlag(ID.F.AntiSS);
            }
            else
            {
                this.isPVP = false;
            }

            if (target == null || !target.isAlive() || this.host == null || host.equals(target))
            {
                return false;
            }

            //player target rules by config
            if (target instanceof Player player)
            {
                if (player.getAbilities().invulnerable) return false;

                switch (ShinColleConfig.shipAttackPlayer)
                {
                case 1:
                    if (TeamHelper.checkIsBanned(host, target)) return true;
                    break;
                case 2:
                    if (!TeamHelper.checkIsAlly(host, target)) return true;
                    break;
                case 3:
                    if (!TeamHelper.checkSameOwner(host, target)) return true;
                    break;
                default:
                    break;
                }
            }

            if (isEntityInvulnerable(target)) return false;

            //invisible target needs flare/searchlight equip
            if (target.isInvisible() && !canDetectInvisible(this.host)) return false;

            //ship with onsight-chase flag requires line of sight
            if (host instanceof BasicEntityShip ship)
            {
                if (ship.getStateFlag(ID.F.OnSightChase) && !ship.getSensing().hasLineOfSight(target))
                {
                    return false;
                }
            }
            else if (host instanceof Mob mob)
            {
                if (!mob.getSensing().hasLineOfSight(target)) return false;
            }

            //AA target: no pvp check
            if (target instanceof BasicEntityAirplane || target instanceof EntityAbyssMissile)
            {
                return isAA && TeamHelper.checkIsBanned(host, target);
            }

            //ASM target
            if (target instanceof IShipInvisible)
            {
                return isASM && TeamHelper.checkIsBanned(host, target);
            }

            //PVP: attack enemy-team ships/mounts
            if (this.isPVP && (target instanceof BasicEntityShip || target instanceof BasicEntityMount))
            {
                if (TeamHelper.checkIsBanned(host, target)) return true;
            }

            //mobs are always valid
            if (target instanceof Monster || target instanceof Slime)
            {
                return true;
            }

            return false;
        }
    }

    /** revenge target selector for owned ships */
    public static class RevengeSelector implements Predicate<Entity>
    {
        protected final Entity host;

        public RevengeSelector(Entity host)
        {
            this.host = host;
        }

        @Override
        public boolean test(Entity target)
        {
            if (target == null || !target.isAlive() || this.host == null || host.equals(target))
            {
                return false;
            }

            if (target instanceof Player player && player.getAbilities().invulnerable)
            {
                return false;
            }

            if (isEntityInvulnerable(target)) return false;

            if (target.isInvisible() && !canDetectInvisible(this.host)) return false;

            //ship-owned entities: ally check
            if (target instanceof IShipOwner)
            {
                return !TeamHelper.checkIsAlly(host, target);
            }

            return !TeamHelper.checkSameOwner(host, target);
        }
    }

    /** target selector for hostile (mob-owned) ships */
    public static class SelectorForHostile implements Predicate<Entity>
    {
        private final Entity host;

        public SelectorForHostile(Entity host)
        {
            this.host = host;
        }

        @Override
        public boolean test(Entity target)
        {
            if (target == null || !target.isAlive() || this.host == null || host.equals(target))
            {
                return false;
            }

            if (target instanceof Player player)
            {
                if (player.getAbilities().invulnerable) return false;
                return ShinColleConfig.mobAttackPlayer;
            }

            if (isEntityInvulnerable(target)) return false;

            if (!target.isInvisible())
            {
                //hostile ships do not fight each other
                if (target instanceof BasicEntityShipHostile) return false;

                if (target instanceof BasicEntityShip || target instanceof BasicEntityMount)
                {
                    return true;
                }

                if (target instanceof IShipOwner)
                {
                    return !TeamHelper.checkSameOwner(host, target);
                }
            }

            return false;
        }
    }

    /** revenge selector for hostile ships */
    public static class RevengeSelectorForHostile implements Predicate<Entity>
    {
        private final Entity host;

        public RevengeSelectorForHostile(Entity host)
        {
            this.host = host;
        }

        @Override
        public boolean test(Entity target)
        {
            if (target == null || this.host == null || host.equals(target)) return false;

            if (target instanceof Player player)
            {
                return !player.getAbilities().invulnerable;
            }

            if (isEntityInvulnerable(target)) return false;

            if (target.isAlive() && !target.isInvisible())
            {
                if (target instanceof BasicEntityShipHostile) return false;

                if (target instanceof BasicEntityShip) return true;

                if (target instanceof IShipOwner)
                {
                    return !TeamHelper.checkSameOwner(host, target);
                }

                return !TeamHelper.checkSameOwner(host, target);
            }

            return false;
        }
    }

    /** host can see invisible entities via flare/searchlight equip */
    private static boolean canDetectInvisible(Entity host)
    {
        if (host instanceof BasicEntityShip ship)
        {
            return ship.getStateMinor(ID.M.LevelFlare) > 0 ||
                   ship.getStateMinor(ID.M.LevelSearchlight) > 0;
        }
        else if (host instanceof IShipOwner owner &&
                 owner.getHostEntity() instanceof BasicEntityShip ship)
        {
            return ship.getStateMinor(ID.M.LevelFlare) > 0 ||
                   ship.getStateMinor(ID.M.LevelSearchlight) > 0;
        }

        return false;
    }

    /** invulnerable entities ships must not target */
    public static boolean isEntityInvulnerable(Entity target)
    {
        return target.isInvulnerable() ||
               (target instanceof Player p && (p.isCreative() || p.isSpectator()));
    }

    /** per-tick target cleanup (legacy updateTarget) */
    public static void updateTarget(IShipAttackBase host)
    {
        if (host.getEntityTarget() != null)
        {
            if (!host.getEntityTarget().isAlive() ||
                TeamHelper.checkSameOwner((Entity) host, host.getEntityTarget()))
            {
                host.setEntityTarget(null);
            }
        }

        if (host.getEntityRevengeTarget() != null)
        {
            if (!host.getEntityRevengeTarget().isAlive() ||
                host.getTickExisted() - host.getEntityRevengeTime() > 200)
            {
                host.setEntityRevengeTarget(null);
            }
        }
    }


}

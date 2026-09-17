package com.lulan.shincolle.ai;

import java.util.EnumSet;

import com.lulan.shincolle.ai.path.IShipPathNavigate;
import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipAttackBase;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.FormationHelper;
import com.lulan.shincolle.utility.LogHelper;
import com.lulan.shincolle.utility.ParticleHelper;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

/**
 * follow owner goal (legacy EntityAIShipFollowOwner).
 *
 * Starts moving when the owner is beyond maxDist, stops inside minDist,
 * and teleports back if the distance/time limits are exceeded.
 * Supports formation offsets via FormationHelper.
 */
public class ShipFollowOwnerGoal extends Goal
{

    private final IShipAttackBase host;
    private final Mob host2;
    private LivingEntity owner;
    private Player player;
    private int checkTP_T, checkTP_D;               //teleport cooldown counts
    private int findCooldown;                       //path navi cooldown
    private final IShipPathNavigate navigator;
    private double maxDistSq;
    private double minDistSq;
    private double distSq;
    private double[] pos, ownerPosOld;


    public ShipFollowOwnerGoal(IShipAttackBase entity)
    {
        this.host = entity;
        this.host2 = (Mob) entity;
        this.navigator = entity.getShipNavigate();
        this.distSq = 1D;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));

        this.pos = new double[] {host2.getX(), host2.getY(), host2.getZ()};
        this.ownerPosOld = new double[] {host2.getX(), host2.getY(), host2.getZ()};
    }

    @Override
    public boolean canUse()
    {
        if (!this.host.getIsSitting() && !this.host.getIsRiding() &&
            !this.host.getIsLeashed() && this.host.getStateFlag(ID.F.CanFollow) &&
            this.host.getStateMinor(ID.M.CraneState) < 1 &&
            this.host.getStateMinor(ID.M.NumGrudge) > 0)
        {
            LivingEntity ownerEntity = EntityHelper.getEntityPlayerByUID(
                this.host2, this.host.getPlayerUID());

            if (ownerEntity != null)
            {
                this.owner = ownerEntity;

                if (this.owner.level().dimension() != this.host2.level().dimension())
                {
                    return false;
                }

                updateDistance();

                return this.distSq > this.maxDistSq;
            }
        }

        return false;
    }

    @Override
    public boolean canContinueToUse()
    {
        if (this.owner != null)
        {
            if (!this.host.getIsSitting() && !this.host.getIsRiding() &&
                !this.host.getIsLeashed() && this.host.getStateFlag(ID.F.CanFollow) &&
                this.host.getStateMinor(ID.M.CraneState) < 1 &&
                this.host.getStateMinor(ID.M.NumGrudge) > 0)
            {
                if (this.distSq > this.minDistSq)
                {
                    return true;
                }

                return !this.navigator.noPath() || this.canUse();
            }
            else
            {
                this.stop();
                return false;
            }
        }

        return false;
    }

    @Override
    public void start()
    {
        this.findCooldown = 10;
        this.checkTP_T = 0;
        this.checkTP_D = 0;
    }

    @Override
    public void stop()
    {
        this.owner = null;
        this.navigator.clearPathEntity();
    }

    @Override
    public void tick()
    {
        this.findCooldown--;
        this.checkTP_T++;

        //update follow range every 32 ticks
        if (this.host2.tickCount % 32 == 0)
        {
            LivingEntity ownerEntity = EntityHelper.getEntityPlayerByUID(
                this.host2, this.host.getPlayerUID());

            if (ownerEntity != null)
            {
                this.owner = ownerEntity;

                if (this.owner.level().dimension() != this.host2.level().dimension())
                {
                    this.stop();
                    return;
                }

                updateDistance();
            }
            else
            {
                this.stop();
                return;
            }
        }

        //end move inside min range
        if (this.distSq <= this.minDistSq)
        {
            this.navigator.clearPathEntity();
        }

        //re-path on cooldown
        if (this.findCooldown <= 0)
        {
            this.findCooldown = 32;
            this.navigator.tryMoveToXYZ(this.pos[0], this.pos[1], this.pos[2], 1D);
        }

        this.host2.getLookControl().setLookAt(this.owner, 20F, 40F);

        //teleport: same DIM and (dist > TP_DIST or time > TP_TIME)
        if (this.host2.level().dimension() == this.owner.level().dimension())
        {
            if (!ShinColleConfig.canTeleport) return;

            if (this.distSq > ShinColleConfig.shipTeleport[1])
            {
                this.checkTP_D++;

                if (this.checkTP_D > ShinColleConfig.shipTeleport[0])
                {
                    this.checkTP_D = 0;

                    LogHelper.debug("DEBUG: follow AI: distSQ > " +
                        ShinColleConfig.shipTeleport[1] + ", teleport to target.");
                    EntityHelper.applyTeleport(this.host, this.distSq, new Vec3(
                        this.owner.getX(), this.owner.getY() + 0.75D, this.owner.getZ()));
                    return;
                }
            }

            if (this.checkTP_T > ShinColleConfig.shipTeleport[0])
            {
                this.checkTP_T = 0;

                LogHelper.debug("DEBUG: follow AI: teleport entity.");
                EntityHelper.applyTeleport(this.host, this.distSq, new Vec3(
                    this.owner.getX(), this.owner.getY() + 0.75D, this.owner.getZ()));
            }
        }
    }

    //update distance
    private void updateDistance()
    {
        //if ship with formation
        if (this.host.getStateMinor(ID.M.FormatType) > 0)
        {
            this.minDistSq = 4;
            this.maxDistSq = 7;

            //if owner moved distSQ > 7, get new position
            double dx = this.ownerPosOld[0] - this.owner.getX();
            double dy = this.ownerPosOld[1] - this.owner.getY();
            double dz = this.ownerPosOld[2] - this.owner.getZ();
            double dsq = dx * dx + dy * dy + dz * dz;

            if (dsq > 7)
            {
                this.pos = FormationHelper.getFormationGuardingPos(
                    this.host, this.owner, this.ownerPosOld[0], this.ownerPosOld[2]);

                this.ownerPosOld[0] = this.owner.getX();
                this.ownerPosOld[1] = this.owner.getY();
                this.ownerPosOld[2] = this.owner.getZ();

                drawFormationParticle(4);
            }

            if (this.host2.tickCount % 16 == 0)
            {
                drawFormationParticle(6);
            }

            if (this.host.getStateFlag(ID.F.PickItem)) this.maxDistSq = 64D;
        }
        //no formation
        else
        {
            float fMin = this.host.getStateMinor(ID.M.FollowMin) + this.host2.getBbWidth() * 0.75F;
            float fMax = this.host.getStateMinor(ID.M.FollowMax) + this.host2.getBbWidth() * 0.75F;

            if (this.host.getStateFlag(ID.F.PickItem)) fMax += 5D;

            this.minDistSq = fMin * fMin;
            this.maxDistSq = fMax * fMax;

            this.pos[0] = this.owner.getX();
            this.pos[1] = this.owner.getY();
            this.pos[2] = this.owner.getZ();
        }

        double dx = this.pos[0] - this.host2.getX();
        double dy = this.pos[1] - this.host2.getY();
        double dz = this.pos[2] - this.host2.getZ();
        this.distSq = dx * dx + dy * dy + dz * dz;
    }

    /** formation move marker particle (legacy S2CSpawnParticle type 25) */
    private void drawFormationParticle(int count)
    {
        //resolved lazily: entity state arrays are not initialized during registerGoals
        Player player = EntityHelper.getEntityPlayerByUID(this.host2, this.host.getPlayerUID());
        this.player = player;

        if (player instanceof ServerPlayer sp &&
            (ShinColleConfig.alwaysShowTeamParticle ||
             EntityHelper.getPointerInUse(player) != null) &&
            player.level().dimension() == this.host2.level().dimension() &&
            this.host2.level() instanceof ServerLevel sl)
        {
            ParticleHelper.spawnWaypointMarker(sl, this.pos[0], this.pos[1], this.pos[2]);
        }
    }


}

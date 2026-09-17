package com.lulan.shincolle.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import com.lulan.shincolle.ai.path.IShipPathNavigate;
import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipAircraftAttack;
import com.lulan.shincolle.entity.IShipCannonAttack;
import com.lulan.shincolle.entity.IShipGuardian;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.FormationHelper;
import com.lulan.shincolle.utility.LogHelper;
import com.lulan.shincolle.utility.ParticleHelper;
import com.lulan.shincolle.utility.TargetHelper;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

/**
 * guarding goal (legacy EntityAIShipGuarding).
 *
 * Active while CanFollow = false. Holds position within followMax of the
 * guard point, returns inside followMin, teleports back after limits.
 * Guard types: 0 guard block + move, 1 guard block + attack while moving,
 * 2 guard entity.
 */
public class ShipGuardingGoal extends Goal
{

    private final IShipGuardian host;
    private final Mob host2;
    private Player owner;
    private Entity guarded;
    private final IShipPathNavigate navigator;
    private final TargetHelper.Sorter targetSorter;
    private final TargetHelper.Selector targetSelector;
    private int checkTP_T, checkTP_D;
    private int findCooldown;
    private double maxDistSq, minDistSq;
    private double distSq;
    private double[] pos;
    private final double[] guardPosOld;

    //attack parms, ships only
    private IShipCannonAttack ship;
    private IShipAircraftAttack ship2;
    private LivingEntity target;
    private final int[] delayTime = new int[] {20, 20, 20};
    private final int[] maxDelayTime = new int[] {20, 40, 40};
    private int onSightTime;
    private int aimTime = 20;
    private float range = 1F;
    private float rangeSq = 1F;
    private boolean launchType;
    private boolean isMoving;
    private double tarDistSq;


    public ShipGuardingGoal(IShipGuardian entity)
    {
        this.host = entity;
        this.host2 = (Mob) entity;
        this.navigator = entity.getShipNavigate();
        this.targetSorter = new TargetHelper.Sorter((Entity) entity);
        this.targetSelector = new TargetHelper.Selector((Entity) entity);
        this.distSq = 1D;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));

        if (entity instanceof IShipCannonAttack cannon)
        {
            this.ship = cannon;
            if (entity instanceof IShipAircraftAttack aircraft)
            {
                this.ship2 = aircraft;
            }
        }

        if (entity instanceof BasicEntityShip || entity instanceof BasicEntityMount)
        {
            this.owner = EntityHelper.getEntityPlayerByUID((Entity) entity, entity.getPlayerUID());
        }

        this.pos = new double[] {-1D, -1D, -1D};
        this.guardPosOld = new double[] {-1D, -100D, -1D};
    }

    @Override
    public boolean canUse()
    {
        if (!this.host.getIsRiding() && !this.host.getIsSitting() &&
            !this.host.getStateFlag(ID.F.CanFollow) &&
            this.host.getStateMinor(ID.M.CraneState) < 1 &&
            this.host.getStateMinor(ID.M.NumGrudge) > 0)
        {
            return checkGuardTarget();
        }

        return false;
    }

    @Override
    public boolean canContinueToUse()
    {
        if (!this.host.getIsRiding() && !this.host.getIsSitting() &&
            !this.host.getStateFlag(ID.F.CanFollow) &&
            this.host.getStateMinor(ID.M.CraneState) < 1 &&
            this.host.getStateMinor(ID.M.NumGrudge) > 0)
        {
            if (this.distSq > this.minDistSq)
            {
                return true;
            }

            return !this.navigator.noPath() || this.canUse();
        }

        this.stop();
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
        this.guarded = null;
        this.isMoving = false;
        this.findCooldown = 10;
        this.navigator.clearPathEntity();
    }

    @Override
    public void tick()
    {
        //attack while moving: ship + active AI + guard type > 0
        if (this.isMoving && this.ship != null &&
            !this.ship.getStateFlag(ID.F.PassiveAI) &&
            this.ship.getStateMinor(ID.M.GuardType) > 0)
        {
            if (this.host2.tickCount % 64 == 0)
            {
                updateAttackParms();
            }

            this.delayTime[0]--;
            this.delayTime[1]--;
            this.delayTime[2]--;

            if (this.host2.tickCount % 32 == 0)
            {
                findTarget();

                if (this.target != null && !this.target.isAlive())
                {
                    this.target = null;
                }
            }

            if (this.target != null && this.host2.getSensing().hasLineOfSight(this.target))
            {
                this.onSightTime++;

                double dx = this.target.getX() - this.host2.getX();
                double dy = this.target.getY() - this.host2.getY();
                double dz = this.target.getZ() - this.host2.getZ();
                this.tarDistSq = dx * dx + dy * dy + dz * dz;

                if (this.tarDistSq <= this.rangeSq && this.onSightTime >= this.aimTime)
                {
                    attackTarget();
                }
            }
            else
            {
                this.onSightTime = 0;
            }
        }

        //update guarding
        this.findCooldown--;

        var mot = this.host2.getDeltaMovement();
        if (mot.x * mot.x < 0.0003D && mot.z * mot.z < 0.0003D)
        {
            this.checkTP_T++;
        }

        if (this.host2.tickCount % 8 == 0)
        {
            if (!checkGuardTarget()) return;
        }

        if (this.distSq <= this.minDistSq)
        {
            this.isMoving = false;
            this.navigator.clearPathEntity();
        }

        if (this.findCooldown <= 0)
        {
            this.findCooldown = 32;
            this.isMoving = this.navigator.tryMoveToXYZ(this.pos[0], this.pos[1], this.pos[2], 1D);
        }

        this.host2.getLookControl().setLookAt(this.pos[0], this.pos[1], this.pos[2],
            30F, (float) this.host2.getMaxHeadXRot());

        //teleport: same DIM and (dist > TP_DIST or time > TP_TIME)
        if (this.host2.level().dimension() == dimKey(this.host.getGuardedPos(3)))
        {
            if (!ShinColleConfig.canTeleport) return;

            if (this.distSq > ShinColleConfig.shipTeleport[1])
            {
                this.checkTP_D++;

                if (this.checkTP_D > ShinColleConfig.shipTeleport[0])
                {
                    this.checkTP_D = 0;

                    LogHelper.debug("DEBUG: guard AI: distSQ > " +
                        ShinColleConfig.shipTeleport[1] + ", teleport to target.");
                    EntityHelper.applyTeleport(this.host, this.distSq,
                        new Vec3(this.pos[0], this.pos[1] + 0.75D, this.pos[2]));
                    return;
                }
            }

            if (this.checkTP_T > ShinColleConfig.shipTeleport[0])
            {
                this.checkTP_T = 0;

                LogHelper.debug("DEBUG: guard AI: teleport entity.");
                EntityHelper.applyTeleport(this.host, this.distSq,
                    new Vec3(this.pos[0], this.pos[1] + 0.75D, this.pos[2]));
            }
        }
        else
        {
            //dim changed: reset guard mode
            this.host.setGuardedPos(-1, -1, -1, 0, 0);
            this.host.setGuardedEntity(null);
            this.host.setStateFlag(ID.F.CanFollow, true);
        }
    }

    private void updateAttackParms()
    {
        if (this.ship != null)
        {
            this.range = this.ship.getAttrs().getAttackRange();
            if (this.range < 1) this.range = 1;

            this.rangeSq = this.range * this.range;

            this.maxDelayTime[0] = (int) (ShinColleConfig.baseAttackSpeed[1] /
                this.ship.getAttrs().getAttackSpeed()) + ShinColleConfig.fixedAttackDelay[1];
            this.maxDelayTime[1] = (int) (ShinColleConfig.baseAttackSpeed[2] /
                this.ship.getAttrs().getAttackSpeed()) + ShinColleConfig.fixedAttackDelay[2];
            this.maxDelayTime[2] = (int) (ShinColleConfig.baseAttackSpeed[3] /
                this.ship.getAttrs().getAttackSpeed()) + ShinColleConfig.fixedAttackDelay[3];

            this.aimTime = (int) (20F * (150 - this.host.getLevel()) / 150F) + 10;
        }
    }

    private void findTarget()
    {
        List<LivingEntity> list = this.host2.level().getEntitiesOfClass(
            LivingEntity.class,
            this.host2.getBoundingBox().inflate(this.range * 0.9D, this.range * 0.6D, this.range * 0.9D),
            this.targetSelector);

        Collections.sort(list, this.targetSorter);

        if (list.size() > 2)
        {
            this.target = list.get(this.host2.getRandom().nextInt(3));
        }
        else if (!list.isEmpty())
        {
            this.target = list.get(0);
        }
    }

    private void attackTarget()
    {
        //light attack
        if (this.ship.getStateFlag(ID.F.AtkType_Light) && this.delayTime[0] <= 0 &&
            this.ship.useAmmoLight() && this.ship.hasAmmoLight())
        {
            this.ship.attackEntityWithAmmo(this.target);
            this.delayTime[0] = this.maxDelayTime[0];
        }

        //heavy attack
        if (this.ship.getStateFlag(ID.F.AtkType_Heavy) && this.delayTime[1] <= 0 &&
            this.ship.useAmmoHeavy() && this.ship.hasAmmoHeavy())
        {
            this.ship.attackEntityWithHeavyAmmo(this.target);
            this.delayTime[1] = this.maxDelayTime[1];
        }

        //aircraft attack
        if (this.ship2 != null && this.delayTime[2] <= 0 &&
            (this.ship2.getStateFlag(ID.F.UseAirLight) || this.ship2.getStateFlag(ID.F.UseAirHeavy)))
        {
            if (!this.ship2.getStateFlag(ID.F.UseAirLight)) this.launchType = false;
            if (!this.ship2.getStateFlag(ID.F.UseAirHeavy)) this.launchType = true;

            if (this.launchType && this.ship2.hasAmmoLight() && this.ship2.hasAirLight())
            {
                this.ship2.attackEntityWithAircraft(this.target);
                this.delayTime[2] = this.maxDelayTime[2];
            }

            if (!this.launchType && this.ship2.hasAmmoHeavy() && this.ship2.hasAirHeavy())
            {
                this.ship2.attackEntityWithHeavyAircraft(this.target);
                this.delayTime[2] = this.maxDelayTime[2];
            }

            this.launchType = !this.launchType;
        }
    }

    private boolean checkGuardTarget()
    {
        this.guarded = this.host.getGuardedEntity();

        if (this.guarded != null)
        {
            //target dead or dimension changed: reset to follow mode
            if (!this.guarded.isAlive() ||
                this.guarded.level().dimension() != this.host2.level().dimension())
            {
                this.host.setGuardedPos(-1, -1, -1, 0, 0);
                this.host.setGuardedEntity(null);
                this.host.setStateFlag(ID.F.CanFollow, true);
                this.stop();
                return false;
            }

            //guard with formation
            if (this.host.getStateMinor(ID.M.FormatType) > 0)
            {
                double dx = this.guardPosOld[0] - this.guarded.getX();
                double dy = this.guardPosOld[1] - this.guarded.getY();
                double dz = this.guardPosOld[2] - this.guarded.getZ();

                if (dx * dx + dy * dy + dz * dz > 6)
                {
                    this.pos = FormationHelper.getFormationGuardingPos(
                        this.host, this.guarded, this.guardPosOld[0], this.guardPosOld[2]);

                    this.guardPosOld[0] = this.guarded.getX();
                    this.guardPosOld[1] = this.guarded.getY();
                    this.guardPosOld[2] = this.guarded.getZ();

                    drawGuardParticle();
                }

                if (this.host2.tickCount % 16 == 0)
                {
                    drawGuardParticle();
                }
            }
            else
            {
                this.pos[0] = this.guarded.getX();
                this.pos[1] = this.guarded.getY();
                this.pos[2] = this.guarded.getZ();
            }
        }
        else
        {
            this.pos[0] = this.host.getStateMinor(ID.M.GuardX) + 0.5D;
            this.pos[1] = this.host.getStateMinor(ID.M.GuardY) + 0.5D;
            this.pos[2] = this.host.getStateMinor(ID.M.GuardZ) + 0.5D;
        }

        //gy <= 0 or different dim: cancel guard
        if (this.pos[1] <= 0 ||
            this.host2.level().dimension() != dimKey(this.host.getGuardedPos(3)))
        {
            this.host.setGuardedPos(-1, -1, -1, 0, 0);
            this.host.setGuardedEntity(null);
            this.host.setStateFlag(ID.F.CanFollow, true);
            this.stop();
            return false;
        }

        //formation distances
        if (this.ship != null && this.ship.getStateMinor(ID.M.FormatType) > 0)
        {
            if (this.ship.getStateMinor(ID.M.GuardType) == 2)
            {
                this.minDistSq = 5D;
                this.maxDistSq = 9D;
            }
            else
            {
                this.minDistSq = 4D;
                this.maxDistSq = 7D;
            }

            if (this.host.getStateFlag(ID.F.PickItem)) this.maxDistSq = 64D;
        }
        else
        {
            float fMin = this.host.getStateMinor(ID.M.FollowMin) + this.host2.getBbWidth() * 0.75F;
            float fMax = this.host.getStateMinor(ID.M.FollowMax) + this.host2.getBbWidth() * 0.75F;

            if (this.host.getStateFlag(ID.F.PickItem)) fMax += 5D;

            this.minDistSq = fMin * fMin;
            this.maxDistSq = fMax * fMax;
        }

        double dx = this.pos[0] - this.host2.getX();
        double dy = this.pos[1] - this.host2.getY();
        double dz = this.pos[2] - this.host2.getZ();
        this.distSq = dx * dx + dy * dy + dz * dz;

        return this.distSq > this.maxDistSq &&
            this.host2.level().dimension() == dimKey(this.host.getStateMinor(ID.M.GuardDim));
    }

    private void drawGuardParticle()
    {
        if (this.owner instanceof ServerPlayer &&
            (ShinColleConfig.alwaysShowTeamParticle ||
             EntityHelper.getPointerInUse(this.owner) != null) &&
            this.owner.level().dimension() == this.host2.level().dimension() &&
            this.host2.level() instanceof ServerLevel sl)
        {
            ParticleHelper.spawnWaypointMarker(sl, this.pos[0], this.pos[1], this.pos[2]);
        }
    }

    /** int dim id -> dimension key (0:overworld -1:nether 1:end else hash) */
    private static net.minecraft.resources.ResourceKey<net.minecraft.world.level.Level> dimKey(int dim)
    {
        return switch (dim)
        {
            case -1 -> net.minecraft.world.level.Level.NETHER;
            case 1 -> net.minecraft.world.level.Level.END;
            default -> net.minecraft.world.level.Level.OVERWORLD;
        };
    }


}

package com.lulan.shincolle.utility;

import java.util.Random;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntitySummon;
import com.lulan.shincolle.entity.EntityProjectileStatic;
import com.lulan.shincolle.entity.IShipAttackBase;
import com.lulan.shincolle.entity.IShipInvisible;
import com.lulan.shincolle.entity.IShipOwner;
import com.lulan.shincolle.reference.Enums.AtkType;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.reference.dataclass.Attrs;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

/**
 * combat calculation helpers (legacy CombatHelper).
 * Damage source wiring lives in {@link #getAttackDelay} users and the
 * entity attack methods; packet/particle effects are Phase 5.
 */
public class CombatHelper
{

    private static final Random RAND = new Random();


    public static int getExpByAction(AtkType type)
    {
        return switch (type)
        {
            case GENERIC_MELEE -> ShinColleConfig.expGain[0];
            case GENERIC_LIGHT -> ShinColleConfig.expGain[1];
            case GENERIC_HEAVY, YAMATO_CANNON -> ShinColleConfig.expGain[2];
            case GENERIC_AIR_LIGHT -> ShinColleConfig.expGain[3];
            case GENERIC_AIR_HEAVY -> ShinColleConfig.expGain[4];
            default -> 0;
        };
    }

    /** apply DEF */
    public static float applyDamageReduceByDEF(Random rand, Attrs attrs, float rawAtk)
    {
        return rawAtk * (1F - attrs.getDefense() + (rand.nextFloat() * 0.5F - 0.25F));
    }

    /** damage reduction on player target */
    public static float applyDamageReduceOnPlayer(Entity target, float rawAtk)
    {
        if (target instanceof Player)
        {
            rawAtk *= 0.25F;
            if (rawAtk > 59F) rawAtk = 59F;
        }

        return rawAtk;
    }

    /**
     * roll miss/cri/double/triple hit, return new damage.
     * priority: miss > cri > dhit > thit
     */
    public static float applyCombatRateToDamage(IShipAttackBase host, Entity target,
            boolean canMultiHit, float distance, float rawAtk)
    {
        if (host != null)
        {
            //minion delegates to its ship host
            if ((host instanceof BasicEntitySummon || host instanceof BasicEntityMount) &&
                host.getHostEntity() instanceof IShipAttackBase)
            {
                host = (IShipAttackBase) host.getHostEntity();
            }

            float miss = calcMissRate(host, distance);
            float cri = host.getAttrs().getAttrsBuffed(ID.Attrs.CRI);
            float dhit = host.getAttrs().getAttrsBuffed(ID.Attrs.DHIT);
            float thit = host.getAttrs().getAttrsBuffed(ID.Attrs.THIT);

            cri = Math.max(cri + miss, miss);
            dhit = Math.max(dhit + cri, cri);
            thit = Math.max(thit + dhit, dhit);

            float roll = host.getRand().nextFloat();

            if (roll <= miss)
            {
                if (host instanceof Entity ent) ParticleHelper.spawnAttackTextParticle(ent, 0);
                return 0F;
            }
            else if (roll <= cri)
            {
                if (host instanceof Entity ent) ParticleHelper.spawnAttackTextParticle(ent, 1);
                return rawAtk * 1.5F;
            }
            else if (canMultiHit && roll <= dhit)
            {
                if (host instanceof Entity ent) ParticleHelper.spawnAttackTextParticle(ent, 2);
                return rawAtk * 2F;
            }
            else if (canMultiHit && roll <= thit)
            {
                if (host instanceof Entity ent) ParticleHelper.spawnAttackTextParticle(ent, 3);
                return rawAtk * 3F;
            }
        }

        return rawAtk;
    }

    /** miss rate = base + dist% - level - equip(-MISS) + nausea */
    public static float calcMissRate(IShipAttackBase host, float distance)
    {
        float range = host.getAttrs().getAttackRange();
        float miss;

        if (range <= 3F)
        {
            miss = 0.25F - 0.001F * host.getLevel();
        }
        else if (range <= 6F)
        {
            miss = 0.25F + 0.15F * (distance / range) - 0.001F * host.getLevel();
        }
        else
        {
            miss = 0.25F + 0.25F * (distance / range) - 0.001F * host.getLevel();
        }

        miss -= host.getAttrs().getAttrsBuffed(ID.Attrs.MISS);

        if (miss > 0.5F) miss = 0.5F;
        else if (miss < 0F) miss = 0F;

        //nausea (mob effect id 9)
        if (BuffHelper.getPotionLevel(host.getBuffMap(), 9) > 0) miss += 0.4F;

        return miss;
    }

    /** roll dodge, distSq = distance^2 */
    public static boolean canDodge(IShipAttackBase host, float distSq)
    {
        if (host != null && !((Entity) host).level().isClientSide)
        {
            float dodge = host.getAttrs().getAttrsBuffed(ID.Attrs.DODGE);

            if (host instanceof IShipInvisible sub)
            {
                if (distSq > 36F)
                {
                    dodge += sub.getInvisibleLevel();
                    double limit = ShinColleConfig.limitShipAttrs[ID.Attrs.DODGE];
                    if (limit >= 0D && dodge > limit) dodge = (float) limit;
                }

                //submarine dodge bonus past 16 blocks, without limit
                if (distSq > 256F)
                {
                    dodge += 0.5F;
                }
            }

            if (RAND.nextFloat() <= dodge)
            {
                ParticleHelper.spawnAttackTextParticle((Entity) host, 4);
                return true;
            }
        }

        return false;
    }

    /** tweak damage by day/night ship type table */
    public static float modDamageByLight(float dmg, int typeAtk, int typeDef, float lightCoef)
    {
        if (typeAtk <= 0 || typeDef <= 0) return dmg;

        lightCoef = Math.clamp(lightCoef, 0F, 1F);

        float modDay = Values.ModDmgNight[typeAtk - 1][typeDef - 1];
        float modNight = Values.ModDmgDay[typeAtk - 1][typeDef - 1];
        float mod = modNight + (modDay - modNight) * lightCoef;

        return dmg * mod;
    }

    /** tweak damage by special attack type (call after modDamageByAttrs) */
    public static float modDamageByAtkType(AtkType type, Entity target, float dmg)
    {
        return switch (type)
        {
            case AP91_FIST -> dmg * 4F;
            case YAMATO_CANNON -> dmg * 1.5F;
            default -> dmg;
        };
    }

    /** tweak damage by AA / ASM attrs vs target move type */
    public static float modDamageByAttrs(IShipAttackBase host, Entity target, float dmg)
    {
        return switch (EntityHelper.getEntityMoveType(target))
        {
            case FLY -> dmg + host.getAttrs().getAttrsBuffed(ID.Attrs.AA);
            case UNDERSEA -> dmg + host.getAttrs().getAttrsBuffed(ID.Attrs.ASM);
            default -> dmg;
        };
    }

    /**
     * attack delay ticks; type: 0 melee, 1 light, 2 heavy, 3 air light, 4 air heavy
     */
    public static int getAttackDelay(float aspd, int type)
    {
        if (aspd < 0.01F) aspd = 0.01F;

        if (type >= 0 && type <= 4)
        {
            return (int) (ShinColleConfig.baseAttackSpeed[type] / aspd) +
                   ShinColleConfig.fixedAttackDelay[type];
        }

        return 40;
    }

    /** missile move type; -1 in MissileData = auto-select by liquid depth */
    public static int calcMissileMoveType(IShipAttackBase host, double tarY, int type)
    {
        int moveType = host.getMissileData(type).movetype;

        if (moveType < 0)
        {
            double depth = host.getShipDepth(0);
            double hostY = ((Entity) host).getY();

            if (depth > 2D)
            {
                moveType = 0;                  //in water
            }
            else if (depth > 0D)
            {
                moveType = (tarY <= hostY || tarY - hostY < depth) ? 2 : 1;
            }
            else
            {
                moveType = 1;                  //on solid block
            }
        }

        return moveType;
    }

    /** missile move type for airplane */
    public static int calcMissileMoveTypeForAirplane(IShipAttackBase host, Entity target, int type)
    {
        int moveType = host.getMissileData(type).movetype;

        if (moveType < 0)
        {
            boolean targetliq = EntityHelper.checkEntityIsInLiquid(target);
            boolean hostliq = EntityHelper.checkEntityIsInLiquid((Entity) host);
            Entity hostEnt = (Entity) host;
            boolean hostUnderLiq = BlockHelper.checkBlockIsLiquid(
                target.level().getBlockState(BlockPos.containing(
                    hostEnt.getX(), target.getY(), hostEnt.getZ())));

            if (hostliq)
            {
                moveType = 0;
            }
            else if (targetliq && hostUnderLiq)
            {
                moveType = target.getY() <= hostEnt.getY() ? 2 : 0;
            }
            else
            {
                moveType = 0;
            }
        }

        return moveType;
    }

    /**
     * special attack effect.
     * type 5: black hole, data = {x, y, z}
     */
    public static void specialAttackEffect(IShipAttackBase host, int type, float[] data)
    {
        if (type == 5 && host instanceof Entity hostEnt)
        {
            EntityProjectileStatic beam = new EntityProjectileStatic(
                com.lulan.shincolle.registry.ModEntities.PROJECTILE_STATIC.get(), hostEnt.level());
            //black hole params: pos + radius/pull/damage (Phase 7 visuals)
            beam.setPos(data[0], data[1], data[2]);
            beam.init(hostEnt, 4F + host.getLevel() * 0.035F);
            hostEnt.level().addFreshEntity(beam);
        }
    }


}

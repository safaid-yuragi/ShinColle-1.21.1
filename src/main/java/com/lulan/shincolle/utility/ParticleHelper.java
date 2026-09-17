package com.lulan.shincolle.utility;

import javax.annotation.Nullable;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

/**
 * particle spawn helper (legacy ParticleHelper subset).
 *
 * Custom ShinColle particles (emotions, attack text, beams) are client-side
 * renders driven by the S2C particle payload - that payload lands in Phase 5,
 * so the type-specific spawns currently degrade to vanilla particles.
 */
public class ParticleHelper
{


    /**
     * attack text popup (miss/cri/dhit/thit/dodge), type 0..4.
     * Custom text particles are Phase 5 client payload work; emits a
     * vanilla marker so the feedback is still visible.
     */
    public static void spawnAttackTextParticle(Entity host, int type)
    {
        if (!(host.level() instanceof ServerLevel sl)) return;

        ParticleOptions p = switch (type)
        {
            case 1 -> ParticleTypes.CRIT;          //critical
            case 2, 3 -> ParticleTypes.ENCHANTED_HIT; //double/triple
            case 4 -> ParticleTypes.SNEEZE;        //dodge
            default -> ParticleTypes.SMOKE;        //miss
        };

        sl.sendParticles(p, host.getX(), host.getY() + host.getBbHeight() + 0.3D,
            host.getZ(), 1, 0.1D, 0.1D, 0.1D, 0D);
    }

    /**
     * generic attack particle burst at position.
     * par1: host, pos xyz, scale, type (legacy particle type id).
     */
    public static void spawnAttackParticle(Entity host, double x, double y, double z,
            double scale, int type)
    {
        if (!(host.level() instanceof ServerLevel sl)) return;

        ParticleOptions p = switch (type)
        {
            case 2 -> ParticleTypes.EXPLOSION;
            case 3 -> ParticleTypes.FLAME;
            case 4 -> ParticleTypes.SOUL_FIRE_FLAME;
            case 5 -> ParticleTypes.PORTAL;
            case 25 -> ParticleTypes.HAPPY_VILLAGER; //waypoint marker
            default -> ParticleTypes.POOF;
        };

        int count = Math.max(1, (int) (scale * 4D));
        sl.sendParticles(p, x, y, z, count, 0.1D * scale, 0.1D * scale, 0.1D * scale, 0.02D);
    }

    /** particle burst on entity (muzzle flash equivalent) */
    public static void spawnAttackParticleAtEntity(Entity target, double scale,
            double ox, double oy, int type)
    {
        spawnAttackParticle(target, target.getX() + ox, target.getY() + oy,
            target.getZ(), scale, type);
    }

    /** particle trail from host to target (cannon fire) */
    public static void spawnAttackParticleAtEntity(Entity host, Entity target,
            double scale, double oy, double unused, int type, boolean alongPath)
    {
        if (!(host.level() instanceof ServerLevel sl)) return;

        Vec3 from = new Vec3(host.getX(), host.getY() + host.getBbHeight() * 0.5D, host.getZ());
        Vec3 to = new Vec3(target.getX(), target.getY() + target.getBbHeight() * 0.5D, target.getZ());
        int steps = 6;

        for (int i = 0; i <= steps; i++)
        {
            Vec3 p = from.lerp(to, (double) i / steps);
            sl.sendParticles(ParticleTypes.CRIT, p.x, p.y, p.z, 1, 0D, 0D, 0D, 0D);
        }
    }

    /** waypoint/formation marker for the owning player */
    public static void spawnWaypointMarker(ServerLevel level, double x, double y, double z)
    {
        level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y + 0.5D, z, 4, 0.3D, 0.5D, 0.3D, 0D);
    }


}

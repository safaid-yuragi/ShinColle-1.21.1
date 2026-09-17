package com.lulan.shincolle.registry;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * particle type registration hub (Phase 2-7).
 * Client-side particle providers are wired in Phase 7.
 */
public final class ModParticles
{

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
        DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, Reference.MOD_ID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TYPE91 = reg("type91");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CHI = reg("chi");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CRANING = reg("craning");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> CUBE = reg("cube");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> DEBUG_PLANE = reg("debug_plane");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> EMOTION = reg("emotion");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GRADIENT = reg("gradient");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LASER = reg("laser");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LASER_NO_TEXTURE = reg("laser_no_texture");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LIGHTNING = reg("lightning");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LINE = reg("line");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SMOKE = reg("smoke");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPARKLE = reg("sparkle");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPHERE_LIGHT = reg("sphere_light");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPRAY = reg("spray");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> STICKY_LIGHTNING = reg("sticky_lightning");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SWEEP = reg("sweep");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TEAM = reg("team");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TEXTS = reg("texts");
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TEXTS_CUSTOM = reg("texts_custom");


    private static DeferredHolder<ParticleType<?>, SimpleParticleType> reg(String name)
    {
        return PARTICLE_TYPES.register(name, () -> new SimpleParticleType(false));
    }


    private ModParticles() {}

}

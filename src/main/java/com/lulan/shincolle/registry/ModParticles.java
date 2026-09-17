package com.lulan.shincolle.registry;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * particle type registration hub.
 * (20 SimpleParticleType entries are added in Phase 2,
 *  providers are registered in Phase 7)
 */
public final class ModParticles
{

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
        DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, Reference.MOD_ID);


    private ModParticles() {}

}

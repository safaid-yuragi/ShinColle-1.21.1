package com.lulan.shincolle.client.particle;

import net.minecraft.client.particle.SpriteSet;

/**
 * sprite sets captured during RegisterParticleProvidersEvent so particles
 * constructed directly (ParticleData path, not the provider path) can still
 * pick atlas sprites.
 */
public final class ShipParticleSprites
{

    public static SpriteSet SMOKE;
    public static SpriteSet SPRAY;


    private ShipParticleSprites() {}


}

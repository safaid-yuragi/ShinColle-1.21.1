package com.lulan.shincolle.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;

/**
 * custom scale smoke (legacy ParticleSmoke extends ParticleSmokeNormal).
 * Uses the smoke sprite set captured by {@link ModParticles} registration.
 */
public class ParticleSmoke extends TextureSheetParticle
{


    public ParticleSmoke(ClientLevel level, double x, double y, double z,
            double speedX, double speedY, double speedZ, float scale)
    {
        this(level, x, y, z, speedX, speedY, speedZ, scale, ShipParticleSprites.SMOKE);
    }

    public ParticleSmoke(ClientLevel level, double x, double y, double z,
            double speedX, double speedY, double speedZ, float scale, SpriteSet sprites)
    {
        super(level, x, y, z, speedX, speedY, speedZ);
        this.friction = 0.96F;
        this.xd = speedX;
        this.yd = speedY;
        this.zd = speedZ;
        this.quadSize *= scale;
        this.lifetime = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
        if (sprites != null) this.setSpriteFromAge(sprites);
    }

    @Override
    public void tick()
    {
        super.tick();
        //smoke sprite set is captured at registration; refresh by age
        if (ShipParticleSprites.SMOKE != null) this.setSpriteFromAge(ShipParticleSprites.SMOKE);
    }

    @Override
    public ParticleRenderType getRenderType()
    {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }


}

package com.lulan.shincolle.network.payload;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

/**
 * S2C: custom particle spawn (legacy S2CSpawnParticle).
 *
 * The particle type travels as its registry name so the full vanilla +
 * modded particle set is addressable; (dx, dy, dz) act as the custom
 * parameter vector used by legacy particle types (scale/color/life).
 */
public record SpawnParticlePayload(ResourceLocation particle,
        double x, double y, double z, double dx, double dy, double dz,
        int count, float param) implements CustomPacketPayload
{

    public static final Type<SpawnParticlePayload> TYPE =
        new Type<>(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "spawn_particle"));

    public static final StreamCodec<RegistryFriendlyByteBuf, SpawnParticlePayload> STREAM_CODEC =
        new StreamCodec<>()
        {
            @Override
            public SpawnParticlePayload decode(RegistryFriendlyByteBuf buf)
            {
                ResourceLocation p = ResourceLocation.STREAM_CODEC.decode(buf);
                double x = buf.readDouble(), y = buf.readDouble(), z = buf.readDouble();
                double dx = buf.readDouble(), dy = buf.readDouble(), dz = buf.readDouble();
                int count = buf.readVarInt();
                float param = buf.readFloat();
                return new SpawnParticlePayload(p, x, y, z, dx, dy, dz, count, param);
            }

            @Override
            public void encode(RegistryFriendlyByteBuf buf, SpawnParticlePayload p)
            {
                ResourceLocation.STREAM_CODEC.encode(buf, p.particle);
                buf.writeDouble(p.x); buf.writeDouble(p.y); buf.writeDouble(p.z);
                buf.writeDouble(p.dx); buf.writeDouble(p.dy); buf.writeDouble(p.dz);
                buf.writeVarInt(p.count); buf.writeFloat(p.param);
            }
        };

    public SpawnParticlePayload(ParticleOptions options,
            double x, double y, double z, double dx, double dy, double dz,
            int count, float param)
    {
        this(BuiltInRegistries.PARTICLE_TYPE.getKey(options.getType()),
            x, y, z, dx, dy, dz, count, param);
    }

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }

    /** resolve registry name back to a particle type (client side) */
    public ParticleType<?> particleType()
    {
        return BuiltInRegistries.PARTICLE_TYPE.get(this.particle);
    }


}

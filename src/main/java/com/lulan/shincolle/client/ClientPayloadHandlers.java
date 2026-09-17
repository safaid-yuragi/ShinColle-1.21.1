package com.lulan.shincolle.client;

import com.lulan.shincolle.entity.IShipState;
import com.lulan.shincolle.network.payload.EntityMotionPayload;
import com.lulan.shincolle.network.payload.EntityPosRotPayload;
import com.lulan.shincolle.network.payload.ShipSyncPayload;
import com.lulan.shincolle.network.payload.SpawnParticlePayload;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/**
 * client-side S2C payload handlers.
 */
public final class ClientPayloadHandlers
{


    /** ship state tag -> IShipState.unpackStateTag */
    public static void handleShipSync(ShipSyncPayload payload, IPayloadContext context)
    {
        context.enqueueWork(() ->
        {
            ClientLevel level = Minecraft.getInstance().level;
            if (level == null) return;

            Entity e = level.getEntity(payload.entityId());
            if (e instanceof IShipState state)
            {
                state.unpackStateTag(payload.tag());
            }
        });
    }

    /** lerp position/rotation (mounts, projectiles) */
    public static void handlePosRot(EntityPosRotPayload payload, IPayloadContext context)
    {
        context.enqueueWork(() ->
        {
            ClientLevel level = Minecraft.getInstance().level;
            if (level == null) return;

            Entity e = level.getEntity(payload.entityId());
            if (e != null && e != Minecraft.getInstance().player)
            {
                e.lerpTo(payload.x(), payload.y(), payload.z(),
                    payload.yaw(), payload.pitch(), 3);
            }
        });
    }

    /** velocity override */
    public static void handleMotion(EntityMotionPayload payload, IPayloadContext context)
    {
        context.enqueueWork(() ->
        {
            ClientLevel level = Minecraft.getInstance().level;
            if (level == null) return;

            Entity e = level.getEntity(payload.entityId());
            if (e != null)
            {
                e.lerpMotion(payload.mx(), payload.my(), payload.mz());
            }
        });
    }

    /** spawn custom particles */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void handleSpawnParticle(SpawnParticlePayload payload,
            IPayloadContext context)
    {
        context.enqueueWork(() ->
        {
            ClientLevel level = Minecraft.getInstance().level;
            if (level == null) return;

            ParticleType type = payload.particleType();
            if (!(type instanceof ParticleOptions options)) return;

            for (int i = 0; i < Math.max(1, payload.count()); i++)
            {
                level.addParticle(options,
                    payload.x(), payload.y(), payload.z(),
                    payload.dx(), payload.dy(), payload.dz());
            }
        });
    }


    /** legacy ParticleData particle spawn -> client particle factory dispatch */
    public static void handleParticleData(com.lulan.shincolle.network.payload.ParticleDataPayload payload,
            IPayloadContext context)
    {
        context.enqueueWork(() ->
        {
            try
            {
                com.lulan.shincolle.client.particle.ClientParticleHelper.spawn(
                    payload.toData());
            }
            catch (Throwable t)
            {
                com.lulan.shincolle.utility.LogHelper.info("EXCEPTION: client spawn particle fail: " + t);
            }
        });
    }


    private ClientPayloadHandlers() {}

}

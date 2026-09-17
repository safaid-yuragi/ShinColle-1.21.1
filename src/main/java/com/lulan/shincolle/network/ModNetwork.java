package com.lulan.shincolle.network;

import com.lulan.shincolle.client.ClientPayloadHandlers;
import com.lulan.shincolle.entity.IShipState;
import com.lulan.shincolle.network.payload.EntityMotionPayload;
import com.lulan.shincolle.network.payload.MountMovePayload;
import com.lulan.shincolle.network.payload.ParticleDataPayload;
import com.lulan.shincolle.network.payload.EntityPosRotPayload;
import com.lulan.shincolle.network.payload.PairingPayload;
import com.lulan.shincolle.network.payload.PlayerSkillPayload;
import com.lulan.shincolle.network.payload.PointerItemPayload;
import com.lulan.shincolle.network.payload.RidingRequestPayload;
import com.lulan.shincolle.network.payload.ShipActionPayload;
import com.lulan.shincolle.network.payload.ShipSyncPayload;
import com.lulan.shincolle.network.payload.SpawnParticlePayload;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

/**
 * NeoForge payload registration + send helpers (Phase 5).
 *
 * Replaces the legacy 4-channel SimpleNetworkWrapper setup.
 * Protocol version string must be bumped when payloads change.
 */
public final class ModNetwork
{


    public static void register(RegisterPayloadHandlersEvent event)
    {
        var registrar = event.registrar("1");

        //S2C
        registrar.playToClient(ShipSyncPayload.TYPE, ShipSyncPayload.STREAM_CODEC,
            ClientPayloadHandlers::handleShipSync);
        registrar.playToClient(EntityPosRotPayload.TYPE, EntityPosRotPayload.STREAM_CODEC,
            ClientPayloadHandlers::handlePosRot);
        registrar.playToClient(EntityMotionPayload.TYPE, EntityMotionPayload.STREAM_CODEC,
            ClientPayloadHandlers::handleMotion);
        registrar.playToClient(SpawnParticlePayload.TYPE, SpawnParticlePayload.STREAM_CODEC,
            ClientPayloadHandlers::handleSpawnParticle);
        registrar.playToClient(ParticleDataPayload.TYPE, ParticleDataPayload.STREAM_CODEC,
            ClientPayloadHandlers::handleParticleData);

        //C2S
        registrar.playToServer(PlayerSkillPayload.TYPE, PlayerSkillPayload.STREAM_CODEC,
            ServerPayloadHandlers::handlePlayerSkill);
        registrar.playToServer(PairingPayload.TYPE, PairingPayload.STREAM_CODEC,
            ServerPayloadHandlers::handlePairing);
        registrar.playToServer(RidingRequestPayload.TYPE, RidingRequestPayload.STREAM_CODEC,
            ServerPayloadHandlers::handleRiding);
        registrar.playToServer(ShipActionPayload.TYPE, ShipActionPayload.STREAM_CODEC,
            ServerPayloadHandlers::handleShipAction);
        registrar.playToServer(MountMovePayload.TYPE, MountMovePayload.STREAM_CODEC,
            ServerPayloadHandlers::handleMountMove);
        registrar.playToServer(PointerItemPayload.TYPE, PointerItemPayload.STREAM_CODEC,
            ServerPayloadHandlers::handlePointer);
    }

    /* ==================== send helpers ==================== */

    /** sync a ship's full state tag to tracking players */
    public static void sendShipSync(Entity entity, CompoundTag tag)
    {
        PacketDistributor.sendToPlayersTrackingEntity(entity,
            new ShipSyncPayload(entity.getId(), tag));
    }

    /** sync one ship to a specific player */
    public static void sendShipSync(ServerPlayer player, Entity entity, CompoundTag tag)
    {
        PacketDistributor.sendToPlayer(player,
            new ShipSyncPayload(entity.getId(), tag));
    }

    /** velocity sync to tracking players */
    public static void sendMotion(Entity entity, Vec3 motion)
    {
        PacketDistributor.sendToPlayersTrackingEntity(entity,
            new EntityMotionPayload(entity.getId(), motion.x, motion.y, motion.z));
    }

    /** pos/rot sync to tracking players (mounts, projectiles) */
    public static void sendPosRot(Entity entity)
    {
        PacketDistributor.sendToPlayersTrackingEntity(entity,
            new EntityPosRotPayload(entity.getId(), entity.getX(), entity.getY(),
                entity.getZ(), entity.getYRot(), entity.getXRot()));
    }

    /** custom particle burst around an entity's trackers */
    public static void sendParticle(Entity anchor, ParticleOptions options,
            double x, double y, double z, double dx, double dy, double dz,
            int count, float param)
    {
        PacketDistributor.sendToPlayersTrackingEntity(anchor,
            new SpawnParticlePayload(options, x, y, z, dx, dy, dz, count, param));
    }

    /** legacy ParticleData packet to players near the anchor entity (64 blocks) */
    public static void sendParticleData(Entity anchor,
            com.lulan.shincolle.reference.dataclass.ParticleData data)
    {
        if (anchor == null || anchor.level() == null) return;
        PacketDistributor.sendToPlayersNear(
            (net.minecraft.server.level.ServerLevel) anchor.level(),
            null, anchor.getX(), anchor.getY(), anchor.getZ(), 64D,
            new ParticleDataPayload(data));
    }

    /** legacy ParticleData packet to players near a fixed position (64 blocks) */
    public static void sendParticleData(net.minecraft.server.level.ServerLevel level,
            double x, double y, double z,
            com.lulan.shincolle.reference.dataclass.ParticleData data)
    {
        PacketDistributor.sendToPlayersNear(level, null, x, y, z, 64D,
            new ParticleDataPayload(data));
    }


    private ModNetwork() {}

}

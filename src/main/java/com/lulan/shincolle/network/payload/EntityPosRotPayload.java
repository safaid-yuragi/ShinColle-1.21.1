package com.lulan.shincolle.network.payload;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

/**
 * S2C: position/rotation sync for fast-moving entities
 * (legacy SyncEntity_PosRot / SyncEntity_Rot).
 */
public record EntityPosRotPayload(int entityId,
        double x, double y, double z, float yaw, float pitch)
        implements CustomPacketPayload
{

    public static final Type<EntityPosRotPayload> TYPE =
        new Type<>(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "entity_pos_rot"));

    public static final StreamCodec<RegistryFriendlyByteBuf, EntityPosRotPayload> STREAM_CODEC =
        StreamCodec.composite(
            ByteBufCodecs.VAR_INT, EntityPosRotPayload::entityId,
            ByteBufCodecs.DOUBLE, EntityPosRotPayload::x,
            ByteBufCodecs.DOUBLE, EntityPosRotPayload::y,
            ByteBufCodecs.DOUBLE, EntityPosRotPayload::z,
            ByteBufCodecs.FLOAT, EntityPosRotPayload::yaw,
            ByteBufCodecs.FLOAT, EntityPosRotPayload::pitch,
            EntityPosRotPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }


}

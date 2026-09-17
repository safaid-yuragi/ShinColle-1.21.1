package com.lulan.shincolle.network.payload;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

/**
 * S2C: velocity sync (legacy SyncEntity_Motion).
 */
public record EntityMotionPayload(int entityId, double mx, double my, double mz)
        implements CustomPacketPayload
{

    public static final Type<EntityMotionPayload> TYPE =
        new Type<>(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "entity_motion"));

    public static final StreamCodec<RegistryFriendlyByteBuf, EntityMotionPayload> STREAM_CODEC =
        StreamCodec.composite(
            ByteBufCodecs.VAR_INT, EntityMotionPayload::entityId,
            ByteBufCodecs.DOUBLE, EntityMotionPayload::mx,
            ByteBufCodecs.DOUBLE, EntityMotionPayload::my,
            ByteBufCodecs.DOUBLE, EntityMotionPayload::mz,
            EntityMotionPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }


}

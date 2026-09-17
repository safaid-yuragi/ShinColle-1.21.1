package com.lulan.shincolle.network.payload;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

/**
 * C2S: request to start/stop riding an entity (legacy Request_Riding).
 * mountId: target entity id; dismount: true to request dismount instead.
 */
public record RidingRequestPayload(int mountId, boolean dismount)
        implements CustomPacketPayload
{

    public static final Type<RidingRequestPayload> TYPE =
        new Type<>(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "riding_request"));

    public static final StreamCodec<RegistryFriendlyByteBuf, RidingRequestPayload> STREAM_CODEC =
        StreamCodec.composite(
            ByteBufCodecs.VAR_INT, RidingRequestPayload::mountId,
            ByteBufCodecs.BOOL, RidingRequestPayload::dismount,
            RidingRequestPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }


}

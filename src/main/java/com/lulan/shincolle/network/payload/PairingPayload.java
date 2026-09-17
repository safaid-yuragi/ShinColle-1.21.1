package com.lulan.shincolle.network.payload;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

/**
 * C2S: pair a waypoint block with a chest for task automation
 * (legacy C2SInputPackets Request_ChestSet).
 * Null/zero chest (y<0) clears the pairing.
 */
public record PairingPayload(BlockPos waypoint, BlockPos chest)
        implements CustomPacketPayload
{

    public static final Type<PairingPayload> TYPE =
        new Type<>(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "pairing"));

    public static final StreamCodec<RegistryFriendlyByteBuf, PairingPayload> STREAM_CODEC =
        StreamCodec.composite(
            BlockPos.STREAM_CODEC, PairingPayload::waypoint,
            BlockPos.STREAM_CODEC, PairingPayload::chest,
            PairingPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }


}

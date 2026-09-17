package com.lulan.shincolle.network.payload;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

/**
 * C2S: rider jump key state (legacy MountMove subset).
 * Directional input rides vanilla's vehicle input sync; only the jump
 * flag is missing server-side, so it travels here.
 */
public record MountMovePayload(boolean jumping) implements CustomPacketPayload
{

    public static final Type<MountMovePayload> TYPE =
        new Type<>(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "mount_move"));

    public static final StreamCodec<RegistryFriendlyByteBuf, MountMovePayload> STREAM_CODEC =
        StreamCodec.composite(
            ByteBufCodecs.BOOL, MountMovePayload::jumping,
            MountMovePayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }


}

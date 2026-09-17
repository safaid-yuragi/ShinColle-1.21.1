package com.lulan.shincolle.network.payload;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

/**
 * C2S: generic ship GUI button action (legacy C2SGUIPackets ShipBtn).
 * action: button id (sit/follow/guard/AI flags...), value: payload int.
 * Detailed actions land with the Phase 6 menus; the transport exists now.
 */
public record ShipActionPayload(int entityId, int action, int value)
        implements CustomPacketPayload
{

    public static final Type<ShipActionPayload> TYPE =
        new Type<>(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "ship_action"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ShipActionPayload> STREAM_CODEC =
        StreamCodec.composite(
            ByteBufCodecs.VAR_INT, ShipActionPayload::entityId,
            ByteBufCodecs.VAR_INT, ShipActionPayload::action,
            ByteBufCodecs.VAR_INT, ShipActionPayload::value,
            ShipActionPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }


}

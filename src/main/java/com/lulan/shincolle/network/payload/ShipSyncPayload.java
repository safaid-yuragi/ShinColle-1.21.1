package com.lulan.shincolle.network.payload;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

/**
 * S2C: generic ship state sync (legacy S2CEntitySync SyncShip_*).
 * Carries the IShipState tag (state arrays + misc ints).
 */
public record ShipSyncPayload(int entityId, CompoundTag tag)
        implements CustomPacketPayload
{

    public static final Type<ShipSyncPayload> TYPE =
        new Type<>(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "ship_sync"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ShipSyncPayload> STREAM_CODEC =
        StreamCodec.composite(
            ByteBufCodecs.VAR_INT, ShipSyncPayload::entityId,
            ByteBufCodecs.COMPOUND_TAG, ShipSyncPayload::tag,
            ShipSyncPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }


}

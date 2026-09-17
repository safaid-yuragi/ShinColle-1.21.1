package com.lulan.shincolle.network.payload;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

/**
 * C2S: GUI button click (legacy C2SGUIPackets ShipBtn/TileBtn/MorphBtn).
 *
 * channel:
 *   0 = ship entity GUI   (entityId, button, value)
 *   1 = tile entity GUI   (pos, button, value, value2)
 *   2 = morph entity GUI  (entityId, button, value)
 *   3 = morph GUI type 2  (entityId, button, value)
 *
 * button = ID.B.* constant; value/value2 = arguments.
 */
public record GuiButtonPayload(int channel, int entityId, BlockPos pos,
        int button, int value, int value2)
        implements CustomPacketPayload
{

    public static final int CH_SHIP = 0;
    public static final int CH_TILE = 1;
    public static final int CH_MORPH = 2;
    public static final int CH_MORPH2 = 3;

    public static final Type<GuiButtonPayload> TYPE =
        new Type<>(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "gui_button"));

    public static final StreamCodec<RegistryFriendlyByteBuf, GuiButtonPayload> STREAM_CODEC =
        StreamCodec.composite(
            ByteBufCodecs.VAR_INT, GuiButtonPayload::channel,
            ByteBufCodecs.VAR_INT, GuiButtonPayload::entityId,
            BlockPos.STREAM_CODEC, GuiButtonPayload::pos,
            ByteBufCodecs.VAR_INT, GuiButtonPayload::button,
            ByteBufCodecs.VAR_INT, GuiButtonPayload::value,
            ByteBufCodecs.VAR_INT, GuiButtonPayload::value2,
            GuiButtonPayload::new);


    /** ship/morph entity button */
    public static GuiButtonPayload entity(int channel, int entityId, int button, int value)
    {
        return new GuiButtonPayload(channel, entityId, BlockPos.ZERO, button, value, 0);
    }

    /** tile entity button */
    public static GuiButtonPayload tile(BlockPos pos, int button, int value, int value2)
    {
        return new GuiButtonPayload(CH_TILE, 0, pos, button, value, value2);
    }

    public BlockPos getPos()
    {
        return this.pos;
    }

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }


}

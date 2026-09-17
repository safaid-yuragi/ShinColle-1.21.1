package com.lulan.shincolle.network.payload;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

/**
 * C2S: pointer item / OP-tool key actions (legacy C2SGUIPackets subset).
 *
 * action:
 *   0 = set pointer team id (value = team, value2 = held slot to restore)
 *   1 = sync pointer mode   (value = mode, writes POINTER_MODE component)
 *   2 = set unattackable class (text = entity class simple name)
 *   3 = show unattackable class list
 */
public record PointerItemPayload(int action, int value, int value2, String text)
        implements CustomPacketPayload
{

    public static final int ACT_SET_TEAM = 0;
    public static final int ACT_SYNC_MODE = 1;
    public static final int ACT_SET_UNATK_CLASS = 2;
    public static final int ACT_SHOW_UNATK_CLASS = 3;
    /** value1 = player uid; text = entity class simple name */
    public static final int ACT_SET_TAR_CLASS = 4;

    public static final Type<PointerItemPayload> TYPE =
        new Type<>(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "pointer_item"));

    public static final StreamCodec<RegistryFriendlyByteBuf, PointerItemPayload> STREAM_CODEC =
        StreamCodec.composite(
            ByteBufCodecs.VAR_INT, PointerItemPayload::action,
            ByteBufCodecs.VAR_INT, PointerItemPayload::value,
            ByteBufCodecs.VAR_INT, PointerItemPayload::value2,
            ByteBufCodecs.STRING_UTF8, PointerItemPayload::text,
            PointerItemPayload::new);


    public static PointerItemPayload setTeam(int team, int slot)
    {
        return new PointerItemPayload(ACT_SET_TEAM, team, slot, "");
    }

    public static PointerItemPayload syncMode(int mode)
    {
        return new PointerItemPayload(ACT_SYNC_MODE, mode, -1, "");
    }

    public static PointerItemPayload setUnatkClass(String name)
    {
        return new PointerItemPayload(ACT_SET_UNATK_CLASS, 0, -1, name);
    }

    public static PointerItemPayload setTarClass(int pid, String name)
    {
        return new PointerItemPayload(ACT_SET_TAR_CLASS, pid, 0, name);
    }

    public static PointerItemPayload showUnatkClass()
    {
        return new PointerItemPayload(ACT_SHOW_UNATK_CLASS, 0, -1, "");
    }

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }


}

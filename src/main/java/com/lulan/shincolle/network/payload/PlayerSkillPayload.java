package com.lulan.shincolle.network.payload;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

/**
 * C2S: player skill key while riding a mount / carrying a ship
 * (legacy C2SInputPackets PlayerSkill).
 *
 * skill: 0 light cannon, 1 heavy cannon, 2 air light, 3 air heavy.
 * targetId >= 0 -> entity target, otherwise pos (y<0 means no pos).
 */
public record PlayerSkillPayload(int skill, int targetId, BlockPos pos)
        implements CustomPacketPayload
{

    public static final Type<PlayerSkillPayload> TYPE =
        new Type<>(ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "player_skill"));

    public static final StreamCodec<RegistryFriendlyByteBuf, PlayerSkillPayload> STREAM_CODEC =
        StreamCodec.composite(
            ByteBufCodecs.VAR_INT, PlayerSkillPayload::skill,
            ByteBufCodecs.VAR_INT, PlayerSkillPayload::targetId,
            BlockPos.STREAM_CODEC, PlayerSkillPayload::pos,
            PlayerSkillPayload::new);

    /** entity target variant */
    public static PlayerSkillPayload entity(int skill, int entityId)
    {
        return new PlayerSkillPayload(skill, entityId, new BlockPos(0, -1, 0));
    }

    /** block target variant */
    public static PlayerSkillPayload block(int skill, BlockPos pos)
    {
        return new PlayerSkillPayload(skill, -1, pos);
    }

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }


}

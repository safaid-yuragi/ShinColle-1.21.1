package com.lulan.shincolle.entity;

import net.minecraft.nbt.CompoundTag;

/**
 * ship state storage contract.
 *
 * The legacy mod keeps ship state in flat arrays indexed by the numeric
 * constants in {@link com.lulan.shincolle.reference.ID}:
 *   F (flags, boolean), M (minor ints), T (timers), S (emotions/states).
 *
 * Implementors hold the arrays; these default methods reproduce the
 * legacy accessor names so callers ported from 1.12.2 need no changes.
 * Dirty marking drives {@link net.minecraft.network.syncher.SynchedEntityData}
 * based sync in the base entity classes.
 */
public interface IShipState
{

    boolean[] stateFlags();

    int[] stateMinor();

    int[] stateTimer();

    int[] stateEmotion();

    /** mark state changed so it is pushed to the synched data */
    void markStateDirty();

    default boolean getStateFlag(int id)
    {
        return stateFlags()[id];
    }

    default void setStateFlag(int id, boolean value)
    {
        if (stateFlags()[id] != value)
        {
            stateFlags()[id] = value;
            markStateDirty();
        }
    }

    default int getStateMinor(int id)
    {
        return stateMinor()[id];
    }

    default void setStateMinor(int id, int value)
    {
        if (stateMinor()[id] != value)
        {
            stateMinor()[id] = value;
            markStateDirty();
        }
    }

    default int getStateTimer(int id)
    {
        return stateTimer()[id];
    }

    default void setStateTimer(int id, int value)
    {
        if (stateTimer()[id] != value)
        {
            stateTimer()[id] = value;
            markStateDirty();
        }
    }

    default int getStateEmotion(int id)
    {
        return stateEmotion()[id];
    }

    default void setStateEmotion(int id, int value)
    {
        setStateEmotion(id, value, true);
    }

    /** syncless=false keeps the change server side only */
    default void setStateEmotion(int id, int value, boolean sync)
    {
        if (stateEmotion()[id] != value)
        {
            stateEmotion()[id] = value;
            if (sync) markStateDirty();
        }
    }

    default void writeStateToNBT(CompoundTag tag)
    {
        tag.putIntArray("StateMinor", stateMinor());
        tag.putIntArray("StateTimer", stateTimer());
        tag.putIntArray("StateEmotion", stateEmotion());

        byte[] flags = new byte[stateFlags().length];
        for (int i = 0; i < flags.length; i++) flags[i] = (byte) (stateFlags()[i] ? 1 : 0);
        tag.putByteArray("StateFlag", flags);
    }

    default void readStateFromNBT(CompoundTag tag)
    {
        copyInto(tag.getIntArray("StateMinor"), stateMinor());
        copyInto(tag.getIntArray("StateTimer"), stateTimer());
        copyInto(tag.getIntArray("StateEmotion"), stateEmotion());

        byte[] flags = tag.getByteArray("StateFlag");
        boolean[] target = stateFlags();
        for (int i = 0; i < flags.length && i < target.length; i++) target[i] = flags[i] != 0;
    }

    static void copyInto(int[] src, int[] dst)
    {
        int len = Math.min(src.length, dst.length);
        System.arraycopy(src, 0, dst, 0, len);
    }

    /** pack all state into a tag for entity-data sync */
    default CompoundTag packStateTag()
    {
        CompoundTag tag = new CompoundTag();
        writeStateToNBT(tag);
        return tag;
    }

    /** unpack a synced state tag (client side) */
    default void unpackStateTag(CompoundTag tag)
    {
        readStateFromNBT(tag);
    }

}

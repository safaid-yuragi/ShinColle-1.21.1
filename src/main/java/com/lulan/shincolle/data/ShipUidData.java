package com.lulan.shincolle.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

/**
 * persistent ship uid allocator (legacy ShipList used a world-saved counter).
 */
public class ShipUidData extends SavedData
{

    private static final String DATA_NAME = "shincolle_ship_uid";

    private int nextUID = 1;


    public ShipUidData() {}

    @Override
    public CompoundTag save(CompoundTag tag, HolderLookup.Provider registries)
    {
        tag.putInt("NextUID", this.nextUID);
        return tag;
    }

    public static ShipUidData load(CompoundTag tag, HolderLookup.Provider registries)
    {
        ShipUidData data = new ShipUidData();
        data.nextUID = tag.getInt("NextUID");
        return data;
    }

    public static ShipUidData get(ServerLevel level)
    {
        return level.getDataStorage().computeIfAbsent(
            new SavedData.Factory<>(ShipUidData::new, ShipUidData::load, null), DATA_NAME);
    }

    /** allocate a new unique ship uid */
    public int nextUID()
    {
        int id = this.nextUID++;
        this.setDirty();
        return id;
    }


}

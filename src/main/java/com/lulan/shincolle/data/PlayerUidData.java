package com.lulan.shincolle.data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

/**
 * persistent player uid allocator (legacy CapaTeitoku assigned each player
 * a positive int uid, stored on ships as owner id).
 */
public class PlayerUidData extends SavedData
{

    private static final String DATA_NAME = "shincolle_player_uid";

    private int nextUID = 1;
    private final Map<UUID, Integer> uidMap = new HashMap<>();


    public PlayerUidData() {}

    @Override
    public CompoundTag save(CompoundTag tag, HolderLookup.Provider registries)
    {
        tag.putInt("NextUID", this.nextUID);
        ListTag list = new ListTag();

        for (Map.Entry<UUID, Integer> e : this.uidMap.entrySet())
        {
            CompoundTag t = new CompoundTag();
            t.putUUID("UUID", e.getKey());
            t.putInt("UID", e.getValue());
            list.add(t);
        }

        tag.put("Map", list);
        return tag;
    }

    public static PlayerUidData load(CompoundTag tag, HolderLookup.Provider registries)
    {
        PlayerUidData data = new PlayerUidData();
        data.nextUID = tag.getInt("NextUID");

        for (Tag t : tag.getList("Map", Tag.TAG_COMPOUND))
        {
            CompoundTag c = (CompoundTag) t;
            data.uidMap.put(c.getUUID("UUID"), c.getInt("UID"));
        }

        return data;
    }

    public static PlayerUidData get(ServerLevel level)
    {
        return level.getDataStorage().computeIfAbsent(
            new SavedData.Factory<>(PlayerUidData::new, PlayerUidData::load, null), DATA_NAME);
    }

    /** get or allocate uid for player uuid, uid > 0 */
    public int getUID(UUID uuid)
    {
        Integer id = this.uidMap.get(uuid);

        if (id == null)
        {
            id = this.nextUID++;
            this.uidMap.put(uuid, id);
            this.setDirty();
        }

        return id;
    }


}

package com.lulan.shincolle.data;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

/**
 * persistent per-player attack-target class list (legacy ServerProxy
 * customTagetClass + its NBT section).
 * Pointer GUI adds/removes entries; targeting AI consults it.
 */
public class PlayerTargetClassData extends SavedData
{

    private static final String DATA_NAME = "shincolle_player_target_class";

    /** player uid -> (class simple-name hash -> class simple name) */
    private final HashMap<Integer, HashMap<Integer, String>> players =
        new HashMap<>();


    public PlayerTargetClassData() {}

    @Override
    public CompoundTag save(CompoundTag tag, HolderLookup.Provider registries)
    {
        ListTag plist = new ListTag();
        this.players.forEach((pid, map) ->
        {
            CompoundTag pe = new CompoundTag();
            pe.putInt("pid", pid);
            ListTag list = new ListTag();
            map.forEach((k, v) ->
            {
                CompoundTag e = new CompoundTag();
                e.putInt("key", k);
                e.putString("name", v);
                list.add(e);
            });
            pe.put("list", list);
            plist.add(pe);
        });
        tag.put("TargetClass", plist);
        return tag;
    }

    public static PlayerTargetClassData load(CompoundTag tag,
        HolderLookup.Provider registries)
    {
        PlayerTargetClassData data = new PlayerTargetClassData();
        for (Tag pt : tag.getList("TargetClass", Tag.TAG_COMPOUND))
        {
            CompoundTag pe = (CompoundTag) pt;
            HashMap<Integer, String> map = new HashMap<>();
            for (Tag t : pe.getList("list", Tag.TAG_COMPOUND))
            {
                CompoundTag e = (CompoundTag) t;
                map.put(e.getInt("key"), e.getString("name"));
            }
            data.players.put(pe.getInt("pid"), map);
        }
        return data;
    }

    public static PlayerTargetClassData get(ServerLevel level)
    {
        return level.getDataStorage().computeIfAbsent(
            new SavedData.Factory<>(PlayerTargetClassData::new,
                PlayerTargetClassData::load, null), DATA_NAME);
    }

    /** toggle: returns true when the class was added, false when removed */
    public boolean toggle(int pid, String name)
    {
        if (pid <= 0) return false;
        HashMap<Integer, String> map =
            this.players.computeIfAbsent(pid, k -> new HashMap<>());
        int key = name.hashCode();
        boolean added = !map.containsKey(key);
        if (added) map.put(key, name);
        else map.remove(key);
        if (map.isEmpty()) this.players.remove(pid);
        this.setDirty();
        return added;
    }

    /** target class list for the player uid, null when none */
    public Map<Integer, String> get(int pid)
    {
        return pid > 0 ? this.players.get(pid) : null;
    }


}

package com.lulan.shincolle.data;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

/**
 * persistent unattackable entity class list (legacy ServerProxy
 * unattackableTargetClass + its NBT section).
 * OP tool debug keys add/remove entries; targeting AI consults it.
 */
public class UnattackableClassData extends SavedData
{

    private static final String DATA_NAME = "shincolle_unattackable";

    /** class simple-name hash -> class simple name */
    private final HashMap<Integer, String> classes = new HashMap<>();


    public UnattackableClassData() {}

    @Override
    public CompoundTag save(CompoundTag tag, HolderLookup.Provider registries)
    {
        ListTag list = new ListTag();
        this.classes.forEach((k, v) ->
        {
            CompoundTag e = new CompoundTag();
            e.putInt("key", k);
            e.putString("name", v);
            list.add(e);
        });
        tag.put("UnatkClass", list);
        return tag;
    }

    public static UnattackableClassData load(CompoundTag tag, HolderLookup.Provider registries)
    {
        UnattackableClassData data = new UnattackableClassData();
        for (Tag t : tag.getList("UnatkClass", Tag.TAG_COMPOUND))
        {
            CompoundTag e = (CompoundTag) t;
            data.classes.put(e.getInt("key"), e.getString("name"));
        }
        return data;
    }

    public static UnattackableClassData get(ServerLevel level)
    {
        return level.getDataStorage().computeIfAbsent(
            new SavedData.Factory<>(UnattackableClassData::new,
                UnattackableClassData::load, null), DATA_NAME);
    }

    /** toggle: returns true when the class was added, false when removed */
    public boolean toggle(String name)
    {
        int key = name.hashCode();
        boolean added = !this.classes.containsKey(key);
        if (added) this.classes.put(key, name);
        else this.classes.remove(key);
        this.setDirty();
        return added;
    }

    /** true if the entity class is listed */
    public boolean contains(Class<?> cls)
    {
        return this.classes.containsKey(cls.getSimpleName().hashCode());
    }

    public Map<Integer, String> getAll()
    {
        return this.classes;
    }


}

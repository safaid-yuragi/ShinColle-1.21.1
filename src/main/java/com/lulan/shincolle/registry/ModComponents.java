package com.lulan.shincolle.registry;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.world.item.component.CustomData;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import com.mojang.serialization.Codec;

/**
 * data component type registration hub (Phase 2).
 */
public final class ModComponents
{

    public static final DeferredRegister<DataComponentType<?>> COMPONENTS =
        DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, Reference.MOD_ID);

    /** ship class id stored on the spawn egg */
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> SHIP_CLASS =
        COMPONENTS.register("ship_class", () -> DataComponentType.<Integer>builder()
            .persistent(Codec.INT)
            .networkSynchronized(ByteBufCodecs.INT)
            .build());

    /** saved ship state (spawn egg / own paper) */
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CustomData>> SHIP_DATA =
        COMPONENTS.register("ship_data", () -> DataComponentType.<CustomData>builder()
            .persistent(CustomData.CODEC)
            .networkSynchronized(CustomData.STREAM_CODEC)
            .build());

    /** equip variant id on equip items (legacy meta value) */
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> EQUIP_SUB_ID =
        COMPONENTS.register("equip_sub_id", () -> DataComponentType.<Integer>builder()
            .persistent(Codec.INT)
            .networkSynchronized(ByteBufCodecs.INT)
            .build());


    private ModComponents() {}

}

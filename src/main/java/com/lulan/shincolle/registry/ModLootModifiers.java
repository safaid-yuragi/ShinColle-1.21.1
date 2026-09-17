package com.lulan.shincolle.registry;

import com.lulan.shincolle.loot.ChestLootModifier;
import com.lulan.shincolle.reference.Reference;
import com.mojang.serialization.MapCodec;

import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/**
 * global loot modifier serializer registration hub (Phase 8-5).
 *
 * Modifier instances are data-driven: data/shincolle/loot_modifiers/*.json
 * enabled by data/neoforge/loot_modifiers/global_loot_modifiers.json.
 */
public final class ModLootModifiers
{

    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS =
        DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,
            Reference.MOD_ID);

    /** appends an extra loot pool to a chest loot table */
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<ChestLootModifier>> CHEST_LOOT =
        LOOT_MODIFIERS.register("chest_loot", () -> ChestLootModifier.CODEC);


    private ModLootModifiers() {}

}

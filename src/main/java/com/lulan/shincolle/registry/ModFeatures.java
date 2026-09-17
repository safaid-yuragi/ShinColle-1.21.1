package com.lulan.shincolle.registry;

import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.worldgen.PolymetalGravelFeature;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * worldgen feature registration hub (Phase 8-6).
 *
 * polymetal_ore uses the vanilla minecraft:ore configured/placed feature
 * JSONs; polymetal_gravel needs code (sea-floor disc) so it is registered
 * here and referenced from data/shincolle/worldgen/configured_feature/.
 */
public final class ModFeatures
{

    public static final DeferredRegister<Feature<?>> FEATURES =
        DeferredRegister.create(BuiltInRegistries.FEATURE, Reference.MOD_ID);

    public static final DeferredHolder<Feature<?>, PolymetalGravelFeature> POLYMETAL_GRAVEL =
        FEATURES.register("polymetal_gravel", PolymetalGravelFeature::new);


    private ModFeatures() {}

}

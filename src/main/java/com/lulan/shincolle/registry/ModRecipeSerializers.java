package com.lulan.shincolle.registry;

import com.lulan.shincolle.crafting.RecipeEnchantShell;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * recipe serializer registration hub (Phase 8-4).
 *
 * The enchant-shell recipe is a dynamic (special) crafting recipe: the output
 * depends on potion contents, so it is registered as a
 * crafting_special_* style serializer and activated by a stub JSON in
 * data/shincolle/recipe/.
 */
public final class ModRecipeSerializers
{

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
        DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, Reference.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<RecipeEnchantShell>> ENCHANT_SHELL =
        RECIPE_SERIALIZERS.register("crafting_special_enchant_shell",
            () -> new SimpleCraftingRecipeSerializer<>(RecipeEnchantShell::new));


    private ModRecipeSerializers() {}

}

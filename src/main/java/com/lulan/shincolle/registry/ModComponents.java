package com.lulan.shincolle.registry;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * data component type registration hub.
 * (ammo type / potion list / ship data components are added in Phase 2+)
 */
public final class ModComponents
{

    public static final DeferredRegister<DataComponentType<?>> COMPONENTS =
        DeferredRegister.create(BuiltInRegistries.DATA_COMPONENT_TYPE, Reference.MOD_ID);


    private ModComponents() {}

}

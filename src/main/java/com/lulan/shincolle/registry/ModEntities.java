package com.lulan.shincolle.registry;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * entity type registration hub.
 * (87 entity types are added in Phase 2; the class id mapping lives in
 *  {@link ShipClassRegistry})
 */
public final class ModEntities
{

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
        DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Reference.MOD_ID);


    private ModEntities() {}

}

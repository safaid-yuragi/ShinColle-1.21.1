package com.lulan.shincolle.registry;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * menu (container) registration hub.
 * (9 menu types are added in Phase 6; legacy MORPHINVENTORY is dropped)
 */
public final class ModMenus
{

    public static final DeferredRegister<MenuType<?>> MENUS =
        DeferredRegister.create(BuiltInRegistries.MENU, Reference.MOD_ID);


    private ModMenus() {}

}

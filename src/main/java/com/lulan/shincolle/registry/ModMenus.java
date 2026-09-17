package com.lulan.shincolle.registry;

import com.lulan.shincolle.menu.CraneMenu;
import com.lulan.shincolle.menu.DeskMenu;
import com.lulan.shincolle.menu.LargeShipyardMenu;
import com.lulan.shincolle.menu.ShipInventoryMenu;
import com.lulan.shincolle.menu.SmallShipyardMenu;
import com.lulan.shincolle.menu.VolCoreMenu;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

/**
 * menu (container) registration hub.
 */
public final class ModMenus
{

    public static final DeferredRegister<MenuType<?>> MENUS =
        DeferredRegister.create(BuiltInRegistries.MENU, Reference.MOD_ID);

    /** ship inventory (entity-backed; entity id sent in open buffer) */
    public static final DeferredHolder<MenuType<?>, MenuType<ShipInventoryMenu>> SHIP_INVENTORY =
        MENUS.register("ship_inventory", () ->
            IMenuTypeExtension.create(ShipInventoryMenu::new));

    /* tile menus: BlockPos sent in open buffer, resolved client-side */
    public static final DeferredHolder<MenuType<?>, MenuType<VolCoreMenu>> VOLCORE =
        MENUS.register("volcore", () ->
            IMenuTypeExtension.create(VolCoreMenu::new));

    public static final DeferredHolder<MenuType<?>, MenuType<SmallShipyardMenu>> SMALL_SHIPYARD =
        MENUS.register("small_shipyard", () ->
            IMenuTypeExtension.create(SmallShipyardMenu::new));

    public static final DeferredHolder<MenuType<?>, MenuType<LargeShipyardMenu>> LARGE_SHIPYARD =
        MENUS.register("large_shipyard", () ->
            IMenuTypeExtension.create(LargeShipyardMenu::new));

    public static final DeferredHolder<MenuType<?>, MenuType<CraneMenu>> CRANE =
        MENUS.register("crane", () ->
            IMenuTypeExtension.create(CraneMenu::new));

    public static final DeferredHolder<MenuType<?>, MenuType<DeskMenu>> DESK =
        MENUS.register("desk", () ->
            IMenuTypeExtension.create(DeskMenu::new));


    private ModMenus() {}

}

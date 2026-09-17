package com.lulan.shincolle.registry;

import com.lulan.shincolle.item.ShipSpawnEgg;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * creative tab registration hub (Phase 2-5).
 */
public final class ModTabs
{

    public static final DeferredRegister<CreativeModeTab> TABS =
        DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, Reference.MOD_ID);

    /** ship class ids offered as spawn eggs: every registered normal
     *  ship (class id < MOB_OFFSET) in ShipClassRegistry order */
    private static short[] tabEggs()
    {
        java.util.List<Short> ids = new java.util.ArrayList<>();
        for (short id : ShipClassRegistry.allClassIds())
        {
            //only normal ships whose entity type is actually registered
            //(unregistered classes resolve to nothing and would not spawn)
            if (id >= 0 && id < ShipClassRegistry.MOB_OFFSET &&
                ShipClassRegistry.entityTypeOf(id) != null) ids.add(id);
        }
        short[] arr = new short[ids.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = ids.get(i);
        return arr;
    }


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB =
        TABS.register("shincolle", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.shincolle"))
            .icon(() -> new ItemStack(ModItems.GRUDGE.get()))
            .displayItems((params, output) ->
            {
                //spawn egg + class eggs
                output.accept(ModItems.SHIP_SPAWN_EGG.get());
                for (short classId : tabEggs())
                {
                    output.accept(ShipSpawnEgg.eggOf(classId));
                }
                //all simple items and equips
                ModItems.allItems().stream().skip(1)
                    .forEach(h -> output.accept(h.get()));
                //block items
                ModBlocks.ITEMS.getEntries()
                    .forEach(h -> output.accept(h.get()));
            })
            .build());


    private ModTabs() {}

}

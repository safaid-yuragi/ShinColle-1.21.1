package com.lulan.shincolle.menu;

import javax.annotation.Nonnull;

import com.lulan.shincolle.item.BasicEquip;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

/**
 * slot for ship equips (legacy SlotShipEquip).
 * fixed index 0~5 in the ship inventory; accepts BasicEquip items only.
 */
public class SlotShipEquip extends SlotItemHandler
{


    public SlotShipEquip(IItemHandler itemHandler, int index, int x, int y)
    {
        super(itemHandler, index, x, y);
    }

    /** accept equip item only */
    @Override
    public boolean mayPlace(@Nonnull ItemStack stack)
    {
        return stack.getItem() instanceof BasicEquip;
    }


}

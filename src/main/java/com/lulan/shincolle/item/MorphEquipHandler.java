package com.lulan.shincolle.item;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;

/**
 * player morph-equipment inventory (legacy CapaTeitoku equip slots).
 * 6 slots holding BasicEquip items while the player is morphed into a ship.
 * Stored as a CompoundTag attachment; {@link #markDirty} persists it.
 */
public class MorphEquipHandler extends ItemStackHandler
{

    private Runnable dirtyCallback = () -> {};


    public MorphEquipHandler()
    {
        super(6);
    }

    public void setDirtyCallback(Runnable cb)
    {
        this.dirtyCallback = cb;
    }

    @Override
    protected void onContentsChanged(int slot)
    {
        this.dirtyCallback.run();
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack)
    {
        return stack.getItem() instanceof BasicEquip;
    }


}

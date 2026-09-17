package com.lulan.shincolle.menu;

import javax.annotation.Nonnull;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

/**
 * SlotItemHandler backed by IItemHandler but resolving the real slot index
 * dynamically from a page number (legacy CapaInventoryExtend#getBaseSlotIndex).
 * Replicates {@link net.neoforged.neoforge.items.SlotItemHandler} behaviour.
 */
public class PagedSlotItemHandler extends Slot
{

    private static final Container EMPTY_INVENTORY = new SimpleContainer(0);
    protected final IItemHandler itemHandler;
    /** local slot index within the page */
    protected final int localIndex;
    /** base index: page * slotsPerPage, supplied by the menu */
    protected final java.util.function.IntSupplier baseIndex;


    public PagedSlotItemHandler(IItemHandler itemHandler, java.util.function.IntSupplier baseIndex,
                                int localIndex, int xPosition, int yPosition)
    {
        super(EMPTY_INVENTORY, localIndex, xPosition, yPosition);
        this.itemHandler = itemHandler;
        this.localIndex = localIndex;
        this.baseIndex = baseIndex;
    }

    /** real index into the IItemHandler = page base + local */
    public int getItemHandlerIndex()
    {
        return this.baseIndex.getAsInt() + this.localIndex;
    }

    /** true when the resolved index is inside the handler's slot range */
    protected boolean inRange()
    {
        int i = this.getItemHandlerIndex();
        return i >= 0 && i < this.itemHandler.getSlots();
    }

    public IItemHandler getItemHandler()
    {
        return this.itemHandler;
    }

    @Override
    public boolean mayPlace(@Nonnull ItemStack stack)
    {
        if (stack.isEmpty() || !this.inRange()) return false;
        return this.itemHandler.isItemValid(this.getItemHandlerIndex(), stack);
    }

    @Override
    @Nonnull
    public ItemStack getItem()
    {
        if (!this.inRange()) return ItemStack.EMPTY;
        return this.itemHandler.getStackInSlot(this.getItemHandlerIndex());
    }

    @Override
    public void set(@Nonnull ItemStack stack)
    {
        if (!this.inRange()) return;
        ((IItemHandlerModifiable) this.itemHandler).setStackInSlot(this.getItemHandlerIndex(), stack);
        this.setChanged();
    }

    @Override
    public void onQuickCraft(@Nonnull ItemStack oldStackIn, @Nonnull ItemStack newStackIn) {}

    @Override
    public int getMaxStackSize()
    {
        if (!this.inRange()) return 0;
        return this.itemHandler.getSlotLimit(this.getItemHandlerIndex());
    }

    @Override
    public int getMaxStackSize(@Nonnull ItemStack stack)
    {
        if (!this.inRange()) return 0;
        ItemStack maxAdd = stack.copy();
        int maxInput = stack.getMaxStackSize();
        maxAdd.setCount(maxInput);

        IItemHandler handler = this.getItemHandler();
        int slotIndex = this.getItemHandlerIndex();
        ItemStack currentStack = handler.getStackInSlot(slotIndex);

        if (handler instanceof IItemHandlerModifiable handlerModifiable)
        {
            handlerModifiable.setStackInSlot(slotIndex, ItemStack.EMPTY);
            ItemStack remainder = handlerModifiable.insertItem(slotIndex, maxAdd, true);
            handlerModifiable.setStackInSlot(slotIndex, currentStack);
            return maxInput - remainder.getCount();
        }
        else
        {
            ItemStack remainder = handler.insertItem(slotIndex, maxAdd, true);
            int current = currentStack.getCount();
            int added = maxInput - remainder.getCount();
            return current + added;
        }
    }

    @Override
    public boolean mayPickup(@Nonnull Player playerIn)
    {
        if (!this.inRange()) return false;
        return !this.itemHandler.extractItem(this.getItemHandlerIndex(), 1, true).isEmpty();
    }

    @Override
    @Nonnull
    public ItemStack remove(int amount)
    {
        if (!this.inRange()) return ItemStack.EMPTY;
        return this.itemHandler.extractItem(this.getItemHandlerIndex(), amount, false);
    }

    @Override
    public boolean isSameInventory(Slot other)
    {
        return other instanceof PagedSlotItemHandler p &&
               p.getItemHandler() == this.itemHandler;
    }


}

package com.lulan.shincolle.menu;

import com.lulan.shincolle.blockentity.BasicBlockEntity;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

/**
 * base for block-entity backed menus.
 *
 * handles: tile ref, ContainerData state sync (legacy getField/setField),
 * player-inventory slot layout, stillValid distance check, and a generic
 * shift-click transfer. Subclasses add the tile's own slots in their ctor
 * then call {@link #addPlayerSlots}.
 */
public abstract class BasicTileMenu extends AbstractContainerMenu
{

    protected final BasicBlockEntity tile;
    protected final ContainerData data;
    /** number of tile slots added before the player inventory (for quickMove) */
    protected int tileSlotCount = 0;

    protected BasicTileMenu(MenuType<?> type, int id, BasicBlockEntity tile)
    {
        super(type, id);
        this.tile = tile;
        this.data = (tile != null) ? tile.getFieldData() : EMPTY_DATA;
        if (this.data.getCount() > 0) this.addDataSlots(this.data);
    }

    private static final ContainerData EMPTY_DATA = new ContainerData()
    {
        @Override public int get(int i) { return 0; }
        @Override public void set(int i, int v) {}
        @Override public int getCount() { return 0; }
    };

    public BasicBlockEntity getTile()
    {
        return this.tile;
    }

    /** read BlockPos from open buffer and resolve the client-side block entity */
    protected static BasicBlockEntity resolveTile(Inventory invPlayer, net.minecraft.network.FriendlyByteBuf buf)
    {
        net.minecraft.core.BlockPos pos = buf.readBlockPos();
        net.minecraft.world.level.block.entity.BlockEntity be =
            invPlayer.player.level().getBlockEntity(pos);
        return (be instanceof BasicBlockEntity b) ? b : null;
    }

    public int getField(int id)
    {
        return this.data.get(id);
    }

    /* ==================== SLOT LAYOUT ==================== */

    /** add a tile slot delegating item-validity to tile.isItemValidForSlot */
    protected Slot addTileSlot(IItemHandler inv, int index, int x, int y)
    {
        Slot s = new TileSlotItemHandler(inv, index, x, y, this.tile);
        this.addSlot(s);
        this.tileSlotCount++;
        return s;
    }

    /** standard player inventory (3x9) + hotbar. yInv = top row of the 3x9. */
    protected void addPlayerSlots(Inventory inv, int x, int yInv)
    {
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 9; col++)
            {
                this.addSlot(new Slot(inv, col + row * 9 + 9, x + col * 18, yInv + row * 18));
            }
        }
        for (int col = 0; col < 9; col++)
        {
            this.addSlot(new Slot(inv, col, x + col * 18, yInv + 58));
        }
    }

    /* ==================== VALIDITY ==================== */

    @Override
    public boolean stillValid(Player player)
    {
        if (this.tile == null || this.tile.isRemoved()) return false;
        return player.distanceToSqr(
            this.tile.getBlockPos().getX() + 0.5,
            this.tile.getBlockPos().getY() + 0.5,
            this.tile.getBlockPos().getZ() + 0.5) <= 64.0;
    }

    /* ==================== SHIFT-CLICK ==================== */

    /**
     * generic transfer: tile slots -> player inv; player inv -> tile slots.
     * subclasses may override for finer control.
     */
    @Override
    public ItemStack quickMoveStack(Player player, int index)
    {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot == null || !slot.hasItem()) return ItemStack.EMPTY;

        ItemStack stack = slot.getItem();
        result = stack.copy();

        int playerStart = this.tileSlotCount;
        int playerEnd = this.slots.size();

        if (index < playerStart)
        {
            // tile slot -> player inventory
            if (!this.moveItemStackTo(stack, playerStart, playerEnd, true))
                return ItemStack.EMPTY;
        }
        else
        {
            // player inventory -> tile slots
            if (!this.moveItemStackTo(stack, 0, playerStart, false))
                return ItemStack.EMPTY;
        }

        if (stack.isEmpty()) slot.setByPlayer(ItemStack.EMPTY);
        else slot.setChanged();

        if (stack.getCount() == result.getCount()) return ItemStack.EMPTY;
        slot.onTake(player, stack);
        return result;
    }

    /* ==================== TILE SLOT ==================== */

    /** SlotItemHandler delegating placement rules to tile.isItemValidForSlot */
    public static class TileSlotItemHandler extends SlotItemHandler
    {
        private final BasicBlockEntity tile;
        private final int index;

        public TileSlotItemHandler(IItemHandler inv, int index, int x, int y, BasicBlockEntity tile)
        {
            super(inv, index, x, y);
            this.tile = tile;
            this.index = index;
        }

        @Override
        public boolean mayPlace(ItemStack stack)
        {
            return this.tile.isItemValidForSlot(this.index, stack);
        }
    }

}

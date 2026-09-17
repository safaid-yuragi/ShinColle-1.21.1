package com.lulan.shincolle.menu;

import javax.annotation.Nonnull;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.item.BasicEquip;
import com.lulan.shincolle.registry.ModMenus;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;

/**
 * ship inventory menu (legacy ContainerShipInventory).
 * slots: equip 0~5, ship item 6~23 (paged x18), player inv 24~50, hotbar 51~59
 */
public class ShipInventoryMenu extends AbstractContainerMenu
{

    /** ship item slots start index in the entity inventory (after 6 equip) */
    public static final int SLOTS_SHIPINV = 6;
    /** item slots shown per page */
    public static final int SLOTS_PER_PAGE = 18;
    /** player inventory start index in this menu */
    public static final int SLOTS_PLAYERINV = SLOTS_SHIPINV + SLOTS_PER_PAGE;	//24

    protected final BasicEntityShip entity;
    protected final ContainerData fieldData;


    /** server side */
    public ShipInventoryMenu(int containerId, Inventory invPlayer, BasicEntityShip entity)
    {
        super(ModMenus.SHIP_INVENTORY.get(), containerId);
        this.entity = entity;
        this.fieldData = entity != null ? entity.getFieldData() : emptyData(35);
        this.addDataSlots(this.fieldData);

        IItemHandler inv = entity != null ? entity.getShipInventory() : emptyInv();
        int i, j;

        //ship equip = 0~5
        for (i = 0; i < 6; i++)
        {
            this.addSlot(new SlotShipEquip(inv, i, 144, 18 + i * 18));
        }

        //ship inventory = 6~23, paged by entity.inventoryPage (field 27)
        for (i = 0; i < 6; i++)
        {
            for (j = 0; j < 3; j++)
            {
                this.addSlot(new PagedSlotItemHandler(inv,
                    () -> SLOTS_SHIPINV + this.getPage() * SLOTS_PER_PAGE,
                    j + i * 3, 8 + j * 18, 18 + i * 18));
            }
        }

        //player inventory
        for (i = 0; i < 3; i++)
        {
            for (j = 0; j < 9; j++)
            {
                this.addSlot(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 132 + i * 18));
            }
        }

        //player hotbar
        for (i = 0; i < 9; i++)
        {
            this.addSlot(new Slot(invPlayer, i, 8 + i * 18, 190));
        }
    }

    /** client side: entity id is appended to the open buffer */
    public ShipInventoryMenu(int containerId, Inventory invPlayer, FriendlyByteBuf buf)
    {
        this(containerId, invPlayer, resolveEntity(invPlayer, buf));
    }

    private static BasicEntityShip resolveEntity(Inventory invPlayer, FriendlyByteBuf buf)
    {
        int id = buf.readInt();
        var ent = invPlayer.player.level().getEntity(id);
        return ent instanceof BasicEntityShip s ? s : null;
    }

    private static IItemHandler emptyInv()
    {
        return new net.neoforged.neoforge.items.ItemStackHandler(0);
    }

    private static ContainerData emptyData(int n)
    {
        return new ContainerData()
        {
            public int get(int i) { return 0; }
            public void set(int i, int v) {}
            public int getCount() { return n; }
        };
    }

    public BasicEntityShip getEntity()
    {
        return this.entity;
    }

    /** inventory page from synced field 27 */
    public int getPage()
    {
        return this.fieldData != null ? this.fieldData.get(27) : 0;
    }

    /** read a synced entity field (client + server) */
    public int getField(int id)
    {
        return this.fieldData != null ? this.fieldData.get(id) : 0;
    }

    @Override
    public boolean stillValid(@Nonnull Player player)
    {
        return this.entity != null && this.entity.isAlive() &&
               this.entity.distanceToSqr(player) <= 64D;
    }

    /**
     * GUI button clicks (server side): 0 = prev page, 1 = next page.
     * New page is written to field 27 -> ContainerData syncs it to the client.
     */
    @Override
    public boolean clickMenuButton(@Nonnull Player player, int id)
    {
        if (this.entity == null) return false;
        int page = this.entity.getInventoryPage();
        int maxPage = (this.entity.getShipInventory().getSlots() - SLOTS_SHIPINV) / SLOTS_PER_PAGE;

        switch (id)
        {
        case 0: page = (page - 1 + maxPage) % maxPage; break;
        case 1: page = (page + 1) % maxPage; break;
        default: return false;
        }

        this.entity.setField(27, page);
        return true;
    }

    /**
     * shift-click move (legacy transferStackInSlot).
     * equip -> ship inv + player; ship inv -> equip or player; player -> equip or ship inv.
     */
    @Override
    @Nonnull
    public ItemStack quickMoveStack(@Nonnull Player player, int slotid)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotid);
        int slotsEnd = SLOTS_PLAYERINV + 36;

        if (slot != null && slot.hasItem())
        {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            boolean isEquip = itemstack1.getItem() instanceof BasicEquip;

            if (slotid < SLOTS_SHIPINV)
            {   //click equip slot -> ship inv + player
                if (!this.moveItemStackTo(itemstack1, SLOTS_SHIPINV, slotsEnd, true))
                {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(itemstack1, itemstack);
            }
            else if (slotid < SLOTS_PLAYERINV)
            {   //click ship inventory
                if (isEquip)
                {
                    if (!this.moveItemStackTo(itemstack1, 0, SLOTS_SHIPINV, false))
                    {
                        if (!this.moveItemStackTo(itemstack1, SLOTS_PLAYERINV, slotsEnd, true))
                        {
                            return ItemStack.EMPTY;
                        }
                    }
                }
                else
                {
                    if (!this.moveItemStackTo(itemstack1, SLOTS_PLAYERINV, slotsEnd, true))
                    {
                        return ItemStack.EMPTY;
                    }
                }
            }
            else
            {   //click player inventory
                if (isEquip)
                {
                    if (!this.moveItemStackTo(itemstack1, 0, SLOTS_SHIPINV, false))
                    {
                        if (!this.moveItemStackTo(itemstack1, SLOTS_SHIPINV, SLOTS_PLAYERINV, true))
                        {
                            return ItemStack.EMPTY;
                        }
                    }
                }
                else
                {
                    if (!this.moveItemStackTo(itemstack1, SLOTS_SHIPINV, SLOTS_PLAYERINV, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
            }

            if (itemstack1.getCount() == 0) slot.setByPlayer(ItemStack.EMPTY);
            else slot.setChanged();
        }

        return itemstack;
    }


}

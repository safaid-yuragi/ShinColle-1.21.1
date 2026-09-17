package com.lulan.shincolle.menu;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.item.MorphEquipHandler;
import com.lulan.shincolle.registry.ModAttachments;
import com.lulan.shincolle.registry.ModMenus;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.SlotItemHandler;

/**
 * port of legacy ContainerMorphInventory. 6 morph-equipment slots (on the
 * player's MORPH_EQUIP attachment) + player inventory + the morph target
 * entity's field sync (field 27 = page etc.).
 *
 * The morph target is the ship the player is currently morphed into
 * (legacy capa.morphEntity); it may be null until morph is implemented.
 */
public class MorphInventoryMenu extends AbstractContainerMenu
{

    public static final int SLOTS_MORPH = 6;	//morph equip slots

    private final Player player;
    private final BasicEntityShip entity;
    private final ContainerData data;


    public MorphInventoryMenu(int containerId, Inventory invPlayer, BasicEntityShip entity)
    {
        super(ModMenus.MORPH_INVENTORY.get(), containerId);
        this.player = invPlayer.player;
        this.entity = entity;
        this.data = (entity != null) ? entity.getFieldData() : EMPTY_DATA;
        if (this.data.getCount() > 0) this.addDataSlots(this.data);

        //morph equip slots from the player attachment (column on the right)
        MorphEquipHandler capa = this.player.getData(ModAttachments.MORPH_EQUIP.get());
        if (capa != null)
        {
            capa.setDirtyCallback(() -> this.player.setData(
                ModAttachments.MORPH_EQUIP.get(), capa));
            for (int i = 0; i < SLOTS_MORPH; i++)
            {
                this.addSlot(new SlotItemHandler(capa, i, 144, 18 + i * 18));
            }
        }

        //player inventory + hotbar
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                this.addSlot(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 132 + i * 18));
            }
        }
        for (int i = 0; i < 9; i++)
        {
            this.addSlot(new Slot(invPlayer, i, 8 + i * 18, 190));
        }
    }

    public MorphInventoryMenu(int containerId, Inventory invPlayer, FriendlyByteBuf buf)
    {
        this(containerId, invPlayer, resolveEntity(invPlayer, buf));
    }

    private static BasicEntityShip resolveEntity(Inventory invPlayer, FriendlyByteBuf buf)
    {
        int id = buf.readInt();
        Entity e = invPlayer.player.level().getEntity(id);
        return (e instanceof BasicEntityShip s) ? s : null;
    }

    private static final ContainerData EMPTY_DATA = new ContainerData()
    {
        @Override public int get(int i) { return 0; }
        @Override public void set(int i, int v) {}
        @Override public int getCount() { return 0; }
    };

    public BasicEntityShip getEntity()
    {
        return this.entity;
    }

    public int getField(int id)
    {
        return this.data.get(id);
    }

    @Override
    public boolean stillValid(Player player)
    {
        return true;
    }

    /* ==================== SHIFT-CLICK ==================== */

    //morph 0-5, player inv 6-32, hotbar 33-41
    @Override
    public ItemStack quickMoveStack(Player player, int index)
    {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot == null || !slot.hasItem()) return ItemStack.EMPTY;

        ItemStack stack = slot.getItem();
        result = stack.copy();

        if (index < SLOTS_MORPH)
        {
            if (!this.moveItemStackTo(stack, SLOTS_MORPH, this.slots.size(), true))
                return ItemStack.EMPTY;
        }
        else
        {
            if (!this.moveItemStackTo(stack, 0, SLOTS_MORPH, false))
                return ItemStack.EMPTY;
        }

        if (stack.isEmpty()) slot.setByPlayer(ItemStack.EMPTY);
        else slot.setChanged();
        if (stack.getCount() == result.getCount()) return ItemStack.EMPTY;
        slot.onTake(player, stack);
        return result;
    }

}

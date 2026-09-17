package com.lulan.shincolle.menu;

import com.lulan.shincolle.registry.ModMenus;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.TransientCraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.core.component.DataComponents;

import java.util.List;
import java.util.Optional;

/**
 * port of legacy ContainerRecipePaper. A 3x3 pattern editor on the held
 * recipe-paper stack; result slot previews the matching crafting recipe.
 * The grid persists to the stack's ItemContainerContents on close.
 */
public class RecipePaperMenu extends AbstractContainerMenu
{

    public final TransientCraftingContainer craftMatrix;
    public final ResultContainer craftResult = new ResultContainer();
    private final Player player;
    private final ItemStack hostStack;


    public RecipePaperMenu(int containerId, Inventory invPlayer, ItemStack hostStack)
    {
        super(ModMenus.RECIPE_PAPER.get(), containerId);
        this.player = invPlayer.player;
        this.hostStack = hostStack;
        this.craftMatrix = new TransientCraftingContainer(this, 3, 3);

        //3x3 recipe grid
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                this.addSlot(new Slot(this.craftMatrix, j + i * 3, 30 + j * 18, 17 + i * 18));
            }
        }

        //result preview slot (display only)
        this.addSlot(new PreviewSlot(this.craftResult, 0, 124, 35));

        //player inventory + hotbar
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 9; col++)
            {
                this.addSlot(new Slot(invPlayer, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
        for (int col = 0; col < 9; col++)
        {
            this.addSlot(new Slot(invPlayer, col, 8 + col * 18, 142));
        }

        //load stored grid
        this.loadFromStack();
        this.slotsChanged(this.craftMatrix);
    }

    public RecipePaperMenu(int containerId, Inventory invPlayer, FriendlyByteBuf buf)
    {
        this(containerId, invPlayer, invPlayer.player.getMainHandItem());
    }

    private void loadFromStack()
    {
        ItemContainerContents contents = this.hostStack.get(DataComponents.CONTAINER);
        if (contents == null) return;
        for (int i = 0; i < Math.min(9, contents.getSlots()); i++)
        {
            ItemStack s = contents.getStackInSlot(i);
            if (!s.isEmpty()) this.craftMatrix.setItem(i, s.copy());
        }
    }

    private void saveToStack()
    {
        java.util.List<ItemStack> items = new java.util.ArrayList<>(9);
        for (int i = 0; i < 9; i++) items.add(this.craftMatrix.getItem(i).copy());
        this.hostStack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(items));
    }

    /* ==================== RECIPE ==================== */

    @Override
    public void slotsChanged(net.minecraft.world.Container container)
    {
        if (container == this.craftMatrix && this.player.level() != null)
        {
            CraftingInput input = this.craftMatrix.asCraftInput();
            Optional<RecipeHolder<CraftingRecipe>> opt =
                this.player.level().getRecipeManager()
                    .getRecipeFor(RecipeType.CRAFTING, input, this.player.level());
            ItemStack result = opt.map(h -> h.value().assemble(input,
                this.player.level().registryAccess())).orElse(ItemStack.EMPTY);
            this.craftResult.setItem(0, result);
        }
        super.slotsChanged(container);
    }

    /* ==================== CLOSE / VALID ==================== */

    @Override
    public void removed(Player player)
    {
        super.removed(player);
        if (!player.level().isClientSide()) this.saveToStack();
    }

    @Override
    public boolean stillValid(Player player)
    {
        return !this.hostStack.isEmpty();
    }

    /* ==================== SHIFT-CLICK ==================== */

    //grid 0-8, result 9, player inv 10-36, hotbar 37-45
    @Override
    public ItemStack quickMoveStack(Player player, int index)
    {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot == null || !slot.hasItem()) return ItemStack.EMPTY;

        ItemStack stack = slot.getItem();
        result = stack.copy();

        if (index < 10)
        {
            if (!this.moveItemStackTo(stack, 10, 46, true)) return ItemStack.EMPTY;
        }
        else
        {
            if (!this.moveItemStackTo(stack, 0, 9, false)) return ItemStack.EMPTY;
        }

        if (stack.isEmpty()) slot.setByPlayer(ItemStack.EMPTY);
        else slot.setChanged();
        if (stack.getCount() == result.getCount()) return ItemStack.EMPTY;
        slot.onTake(player, stack);
        return result;
    }

    /* ==================== PREVIEW SLOT ==================== */

    /** result preview: not placeable, not takeable */
    public static class PreviewSlot extends Slot
    {
        public PreviewSlot(net.minecraft.world.Container c, int idx, int x, int y)
        {
            super(c, idx, x, y);
        }

        @Override public boolean mayPlace(ItemStack s) { return false; }
        @Override public boolean mayPickup(Player p) { return false; }
        @Override public void onTake(Player p, ItemStack s) {}
    }

}

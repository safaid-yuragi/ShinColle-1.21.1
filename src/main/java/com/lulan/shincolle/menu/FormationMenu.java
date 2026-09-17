package com.lulan.shincolle.menu;

import com.lulan.shincolle.registry.ModMenus;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

/**
 * port of legacy ContainerFormation. Empty menu — the formation GUI is a
 * client-driven grid of ship icons; all state changes go through custom
 * payloads, so there are no inventory slots.
 */
public class FormationMenu extends AbstractContainerMenu
{

    private final Player player;


    public FormationMenu(int containerId, Inventory invPlayer)
    {
        super(ModMenus.FORMATION.get(), containerId);
        this.player = invPlayer.player;
    }

    public FormationMenu(int containerId, Inventory invPlayer, FriendlyByteBuf buf)
    {
        this(containerId, invPlayer);
    }

    public Player getPlayer()
    {
        return this.player;
    }

    @Override
    public boolean stillValid(Player player)
    {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index)
    {
        return ItemStack.EMPTY;
    }

}

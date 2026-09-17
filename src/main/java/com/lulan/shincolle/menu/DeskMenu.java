package com.lulan.shincolle.menu;

import com.lulan.shincolle.blockentity.BasicBlockEntity;
import com.lulan.shincolle.registry.ModMenus;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;

/**
 * port of legacy ContainerDesk. No item slots — the desk GUI is a radar/book
 * UI driven purely by synced fields (4 fields) + custom payloads.
 */
public class DeskMenu extends BasicTileMenu
{

    public DeskMenu(int containerId, Inventory invPlayer, BasicBlockEntity tile)
    {
        super(ModMenus.DESK.get(), containerId, tile);
        this.addPlayerSlots(invPlayer, 8, 140);
    }

    public DeskMenu(int containerId, Inventory invPlayer, FriendlyByteBuf buf)
    {
        this(containerId, invPlayer, resolveTile(invPlayer, buf));
    }

}

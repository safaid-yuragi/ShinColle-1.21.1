package com.lulan.shincolle.client.gui.screen;

import com.lulan.shincolle.menu.CraneMenu;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

/** port of legacy GuiCrane. 18 storage slots + player inv + mode config. */
public class CraneScreen extends BasicTileScreen<CraneMenu>
{

    public CraneScreen(CraneMenu menu, Inventory inv, Component title)
    {
        super(menu, inv, title, "guicrane.png", 176, 201);
    }

}

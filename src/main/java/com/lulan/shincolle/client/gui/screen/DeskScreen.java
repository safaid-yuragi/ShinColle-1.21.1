package com.lulan.shincolle.client.gui.screen;

import com.lulan.shincolle.menu.DeskMenu;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

/**
 * port of legacy GuiDesk. The full desk UI is a multi-page radar/book/team
 * interface; this baseline renders the main texture + synced fields. The
 * radar/book sub-pages and target list are pending (custom payloads).
 */
public class DeskScreen extends BasicTileScreen<DeskMenu>
{

    public DeskScreen(DeskMenu menu, Inventory inv, Component title)
    {
        super(menu, inv, title, "guidesk.png", 256, 200);
    }

    @Override
    protected void renderLabels(GuiGraphics g, int mouseX, int mouseY)
    {
        g.drawString(this.font, this.title, 8, 6, 0x404040, false);
    }

}

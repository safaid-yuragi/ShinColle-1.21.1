package com.lulan.shincolle.client.gui.screen;

import com.lulan.shincolle.menu.VolCoreMenu;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

/** port of legacy GuiVolCore. 3x3 fuel grid + player inv; field0 = power. */
public class VolCoreScreen extends BasicTileScreen<VolCoreMenu>
{

    public VolCoreScreen(VolCoreMenu menu, Inventory inv, Component title)
    {
        super(menu, inv, title, "guivolcore.png", 176, 166);
    }

    @Override
    protected void renderLabels(GuiGraphics g, int mouseX, int mouseY)
    {
        super.renderLabels(g, mouseX, mouseY);
        g.drawString(this.font, "Power " + this.menu.getField(0),
            8, 66, 0x404040, false);
    }

}

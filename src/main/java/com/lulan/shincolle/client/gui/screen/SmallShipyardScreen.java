package com.lulan.shincolle.client.gui.screen;

import com.lulan.shincolle.blockentity.TileEntitySmallShipyard;
import com.lulan.shincolle.menu.SmallShipyardMenu;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

/** port of legacy GuiSmallShipyard. 4 material + fuel + output slots + player inv. */
public class SmallShipyardScreen extends BasicTileScreen<SmallShipyardMenu>
{

    public SmallShipyardScreen(SmallShipyardMenu menu, Inventory inv, Component title)
    {
        super(menu, inv, title, "guismallshipyard.png", 176, 164);
    }

    @Override
    protected void renderLabels(GuiGraphics g, int mouseX, int mouseY)
    {
        super.renderLabels(g, mouseX, mouseY);
        g.drawString(this.font, "Power " + this.menu.getField(TileEntitySmallShipyard.FIELD_POWER),
            8, 66, 0x404040, false);
    }

}

package com.lulan.shincolle.client.gui.screen;

import com.lulan.shincolle.blockentity.TileMultiGrudgeHeavy;
import com.lulan.shincolle.menu.LargeShipyardMenu;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

/** port of legacy GuiLargeShipyard. output + 9 material slots + player inv. */
public class LargeShipyardScreen extends BasicTileScreen<LargeShipyardMenu>
{

    public LargeShipyardScreen(LargeShipyardMenu menu, Inventory inv, Component title)
    {
        super(menu, inv, title, "guilargeshipyard.png", 208, 223);
    }

    @Override
    protected void renderLabels(GuiGraphics g, int mouseX, int mouseY)
    {
        g.drawString(this.font, this.title, 8, 6, 0x404040, false);
        g.drawString(this.font,
            "Type " + this.menu.getField(TileMultiGrudgeHeavy.FIELDTYPE_BUILDTYPE) +
            "  Mat " + this.menu.getField(TileMultiGrudgeHeavy.FIELDTYPE_MATBUILD0),
            8, 100, 0x404040, false);
        g.drawString(this.font, this.playerInventoryTitle,
            this.inventoryLabelX, this.inventoryLabelY, 0x404040, false);
    }

}

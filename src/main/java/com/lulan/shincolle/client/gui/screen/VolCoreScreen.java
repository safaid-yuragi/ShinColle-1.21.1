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
    protected void init()
    {
        super.init();
        if (this.menu.getTile() == null) return;
        //power toggle -> tile button (legacy ID.B.VolCore_Power)
        this.addRenderableWidget(net.minecraft.client.gui.components.Button
            .builder(Component.literal("On/Off"),
                b -> net.neoforged.neoforge.network.PacketDistributor.sendToServer(
                    com.lulan.shincolle.network.payload.GuiButtonPayload.tile(
                        this.menu.getTile().getBlockPos(),
                        com.lulan.shincolle.reference.ID.B.VolCore_Power,
                        this.menu.getField(0) == 0 ? 1 : 0, 0)))
            .bounds(this.leftPos + 120, this.topPos + 60, 48, 14).build());
    }

    @Override
    protected void renderLabels(GuiGraphics g, int mouseX, int mouseY)
    {
        super.renderLabels(g, mouseX, mouseY);
        g.drawString(this.font, "Power " + this.menu.getField(0),
            8, 66, 0x404040, false);
    }

}

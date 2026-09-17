package com.lulan.shincolle.client.gui.screen;

import com.lulan.shincolle.menu.FormationMenu;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

/**
 * port of legacy GuiFormation. 256x192 formation grid of ship icons driven by
 * the player team/formation data (CapaTeitoku). Baseline renders the texture;
 * the icon grid + formation-select payloads are pending the teitoku data port.
 */
public class FormationScreen extends AbstractContainerScreen<FormationMenu>
{

    private static final ResourceLocation TEXTURE_BG =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/gui/guiformation.png");


    public FormationScreen(FormationMenu menu, Inventory inv, Component title)
    {
        super(menu, inv, title);
        this.imageWidth = 256;
        this.imageHeight = 192;
    }

    @Override
    protected void renderBg(GuiGraphics g, float partialTick, int mouseX, int mouseY)
    {
        g.blit(TEXTURE_BG, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float partialTick)
    {
        super.render(g, mouseX, mouseY, partialTick);
        this.renderTooltip(g, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(GuiGraphics g, int mouseX, int mouseY)
    {
        g.drawString(this.font, this.title, 8, 6, 0xFFFFFF, false);
    }

}

package com.lulan.shincolle.client.gui.screen;

import com.lulan.shincolle.menu.RecipePaperMenu;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

/** port of legacy GuiRecipePaper. 3x3 grid + result preview + player inv. */
public class RecipePaperScreen extends AbstractContainerScreen<RecipePaperMenu>
{

    private static final ResourceLocation TEXTURE_BG =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/gui/guirecipepaper.png");


    public RecipePaperScreen(RecipePaperMenu menu, Inventory inv, Component title)
    {
        super(menu, inv, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
        this.inventoryLabelY = this.imageHeight - 94;
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
        g.drawString(this.font, this.title, 8, 6, 0x404040, false);
        g.drawString(this.font, this.playerInventoryTitle,
            this.inventoryLabelX, this.inventoryLabelY, 0x404040, false);
    }

}

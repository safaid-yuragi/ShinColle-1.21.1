package com.lulan.shincolle.client.gui.screen;

import com.lulan.shincolle.blockentity.BasicBlockEntity;
import com.lulan.shincolle.menu.BasicTileMenu;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

/**
 * base for block-entity backed screens. Renders the gui texture, slots, and
 * the title; subclasses override {@link #renderLabels} to draw synced fields.
 */
public abstract class BasicTileScreen<M extends BasicTileMenu> extends AbstractContainerScreen<M>
{

    private final ResourceLocation texture;


    public BasicTileScreen(M menu, Inventory inv, Component title,
                           String textureName, int imageWidth, int imageHeight)
    {
        super(menu, inv, title);
        this.texture = ResourceLocation.fromNamespaceAndPath(
            Reference.MOD_ID, "textures/gui/" + textureName);
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.inventoryLabelY = imageHeight - 94;
    }

    public BasicBlockEntity getTile()
    {
        return this.menu.getTile();
    }

    @Override
    protected void renderBg(GuiGraphics g, float partialTick, int mouseX, int mouseY)
    {
        g.blit(this.texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
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

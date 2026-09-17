package com.lulan.shincolle.client.gui.screen;

import com.lulan.shincolle.menu.DeskMenu;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

/**
 * port of legacy GuiDesk. Multi-page UI: radar(0/1), book(2), team(3),
 * target(4). Baseline renders the page texture + title; the radar sweep,
 * book content (GuiBook), and team/target lists render once the teitoku
 * team/formation data is ported.
 */
public class DeskScreen extends AbstractContainerScreen<DeskMenu>
{

    private static final ResourceLocation TEX_MAIN =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/gui/guidesk.png");
    private static final ResourceLocation TEX_RADAR =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/gui/guideskradar.png");
    private static final ResourceLocation TEX_BOOK =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/gui/guideskbook.png");
    private static final ResourceLocation TEX_TEAM =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/gui/guideskteam.png");
    private static final ResourceLocation TEX_TARGET =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/gui/guidesktarget.png");


    public DeskScreen(DeskMenu menu, Inventory inv, Component title)
    {
        super(menu, inv, title);
        this.imageWidth = 256;
        this.imageHeight = 200;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    private ResourceLocation textureFor(int page)
    {
        return switch (page)
        {
        case 1 -> TEX_RADAR;
        case 2 -> TEX_BOOK;
        case 3 -> TEX_TEAM;
        case 4 -> TEX_TARGET;
        default -> TEX_MAIN;
        };
    }

    @Override
    protected void renderBg(GuiGraphics g, float partialTick, int mouseX, int mouseY)
    {
        g.blit(textureFor(this.menu.getPage()), this.leftPos, this.topPos,
            0, 0, this.imageWidth, this.imageHeight);
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
    }

}

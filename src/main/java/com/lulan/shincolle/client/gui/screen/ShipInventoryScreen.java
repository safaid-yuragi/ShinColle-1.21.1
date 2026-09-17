package com.lulan.shincolle.client.gui.screen;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.menu.ShipInventoryMenu;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

/**
 * ship inventory screen (legacy GuiShipInventory).
 * texture 256x214; equip column + paged item grid + player inv + field text.
 */
public class ShipInventoryScreen extends AbstractContainerScreen<ShipInventoryMenu>
{

    private static final ResourceLocation TEXTURE_BG =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/gui/guishipinventory.png");

    private BasicEntityShip entity;


    public ShipInventoryScreen(ShipInventoryMenu menu, Inventory inv, Component title)
    {
        super(menu, inv, title);
        this.imageWidth = 256;
        this.imageHeight = 214;
        this.entity = menu.getEntity();
    }

    @Override
    protected void init()
    {
        super.init();

        //page buttons: prev / next, send clickMenuButton id 0/1 to server
        this.addRenderableWidget(Button.builder(Component.literal("<"),
                b -> this.sendButton(0))
            .bounds(this.leftPos + 62, this.topPos + 124, 12, 12).build());
        this.addRenderableWidget(Button.builder(Component.literal(">"),
                b -> this.sendButton(1))
            .bounds(this.leftPos + 135, this.topPos + 124, 12, 12).build());
    }

    private void sendButton(int id)
    {
        if (this.minecraft != null && this.minecraft.gameMode != null)
        {
            this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, id);
        }
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
        if (this.entity == null)
        {
            g.drawString(this.font, this.title, 8, 6, 0x404040, false);
            return;
        }

        //title + key synced fields
        g.drawString(this.font, this.entity.getDisplayName(), 8, 6, 0x404040, false);
        g.drawString(this.font,
            "Lv " + this.entity.getShipLevel() + "  Exp " + this.menu.getField(0),
            8, 96, 0x404040, false);
        g.drawString(this.font,
            "Ammo " + this.menu.getField(1) + " / " + this.menu.getField(2),
            8, 106, 0x404040, false);
        g.drawString(this.font,
            "Page " + (this.menu.getPage() + 1),
            90, 126, 0x404040, false);

        //ship model preview (legacy renders entity in GUI)
        InventoryScreen.renderEntityInInventoryFollowsMouse(g,
            this.leftPos + 33, this.topPos + 88,
            this.leftPos + 33, this.topPos + 88, 30, 0.0625F,
            mouseX, mouseY, this.entity);
    }


}

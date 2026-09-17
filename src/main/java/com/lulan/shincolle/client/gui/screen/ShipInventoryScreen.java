package com.lulan.shincolle.client.gui.screen;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.menu.ShipInventoryMenu;
import com.lulan.shincolle.reference.ID;
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

        //state toggle buttons (legacy ID.B.ShipInv_*): send GuiButtonPayload
        this.addRenderableWidget(Button.builder(Component.literal("Melee"),
                b -> this.sendShipButton(ID.B.ShipInv_Melee, toggle(ID.F.UseMelee)))
            .bounds(this.leftPos + 8, this.topPos + 140, 40, 12).build());
        this.addRenderableWidget(Button.builder(Component.literal("Passive"),
                b -> this.sendShipButton(ID.B.ShipInv_TarAI, toggle(ID.F.PassiveAI)))
            .bounds(this.leftPos + 50, this.topPos + 140, 40, 12).build());
    }

    private void sendButton(int id)
    {
        if (this.minecraft != null && this.minecraft.gameMode != null)
        {
            this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, id);
        }
    }

    /** send a ship-GUI button to the server (legacy C2SGUIPackets ShipBtn) */
    private void sendShipButton(int buttonId, int value)
    {
        if (this.entity != null)
        {
            net.neoforged.neoforge.network.PacketDistributor.sendToServer(
                com.lulan.shincolle.network.payload.GuiButtonPayload.entity(
                    com.lulan.shincolle.network.payload.GuiButtonPayload.CH_SHIP,
                    this.entity.getId(), buttonId, value));
        }
    }

    /** toggle a synced flag field -> next value to send */
    private int toggle(int flagId)
    {
        return this.menu.getField(fieldForFlag(flagId)) == 0 ? 1 : 0;
    }

    /** map ID.F flag -> its synced GUI field index */
    private static int fieldForFlag(int flagId)
    {
        //fields 5-10 = UseMelee..IsMarried; 14-20 = PassiveAI..TimeKeeper; etc.
        return switch (flagId)
        {
        case ID.F.UseMelee -> 5;  case ID.F.UseAmmoLight -> 6;
        case ID.F.UseAmmoHeavy -> 7; case ID.F.UseAirLight -> 8;
        case ID.F.UseAirHeavy -> 9;  case ID.F.IsMarried -> 10;
        case ID.F.PassiveAI -> 14;   case ID.F.UseRingEffect -> 15;
        case ID.F.OnSightChase -> 16; case ID.F.PVPFirst -> 17;
        case ID.F.AntiAir -> 18;     case ID.F.AntiSS -> 19;
        case ID.F.TimeKeeper -> 20;  case ID.F.PickItem -> 23;
        case ID.F.ShowHeldItem -> 28; case ID.F.AutoPump -> 30;
        default -> -1;
        };
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

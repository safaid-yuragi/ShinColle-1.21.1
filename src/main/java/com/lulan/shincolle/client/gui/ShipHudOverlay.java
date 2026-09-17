package com.lulan.shincolle.client.gui;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipCV;
import com.lulan.shincolle.reference.Enums;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.utility.CombatHelper;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.client.gui.Font;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

/**
 * mount skill HUD overlay (legacy RenderHelper.drawPlayerSkillIcon).
 * Draws the 5 mount-skill buttons with cooldown frames above the hotbar
 * plus a small cross marker at screen center while riding a ship mount.
 */
public final class ShipHudOverlay implements LayeredDraw.Layer
{

    public static final ShipHudOverlay INSTANCE = new ShipHudOverlay();

    private static final ResourceLocation GUI_HUD =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/gui/guihud.png");


    @Override
    public void render(GuiGraphics gui, DeltaTracker deltaTracker)
    {
        Minecraft mc = Minecraft.getInstance();
        if (mc == null || mc.level == null || mc.options.hideGui) return;

        Font fr = mc.font;
        LocalPlayer player = mc.player;
        if (player == null) return;

        //get ship: riding a mount or carrying a ship passenger
        BasicEntityShip ship = null;
        boolean isMorph = false;
        boolean[] drawBtn = new boolean[5];
        int[] drawCD = new int[5];
        int[] drawCDMax = new int[5];
        int[] drawAirNum = new int[2];

        Entity vehicle = player.getVehicle();
        if (vehicle instanceof BasicEntityMount mount &&
            mount.getHostShip() != null)
        {
            ship = mount.getHostShip();
        }
        else if (!player.getPassengers().isEmpty() &&
                 player.getPassengers().get(0) instanceof BasicEntityShip s)
        {
            ship = s;
        }
        else
        {
            return;
        }

        //init skill button state
        drawBtn[0] = ship.getStateFlag(ID.F.AtkType_Light);
        drawBtn[1] = ship.getStateFlag(ID.F.AtkType_Heavy);
        drawBtn[2] = ship.getStateFlag(ID.F.AtkType_AirLight);
        drawBtn[3] = ship.getStateFlag(ID.F.AtkType_AirHeavy);
        drawBtn[4] = isMorph;
        drawCD[0] = ship.getStateTimer(ID.T.MountSkillCD1);
        drawCD[1] = ship.getStateTimer(ID.T.MountSkillCD2);
        drawCD[2] = ship.getStateTimer(ID.T.MountSkillCD3);
        drawCD[3] = ship.getStateTimer(ID.T.MountSkillCD4);
        drawCD[4] = ship.getStateTimer(ID.T.MountSkillCD5);
        drawCDMax[0] = CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 1);
        drawCDMax[1] = CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 2);
        drawCDMax[2] = CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 3);
        drawCDMax[3] = CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 4);
        drawCDMax[4] = CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 0);

        if (ship instanceof BasicEntityShipCV cv)
        {
            drawAirNum[0] = cv.getNumAircraftLight();
            drawAirNum[1] = cv.getNumAircraftHeavy();
        }

        try
        {
            int i = gui.guiWidth();
            int j = gui.guiHeight();
            int px = (int)(i * ShinColleConfig.posHUD[0]);
            int py = (int)(j * ShinColleConfig.posHUD[1]);

            //draw mount skill buttons
            for (int k = 0; k < 5; k++)
            {
                if (drawBtn[k])
                {
                    int px2 = px - 40 + k * 21;
                    int len = drawCDMax[k] > 0 ?
                        (int)((float) drawCD[k] / (float) drawCDMax[k] * 18F) : 0;
                    //button icon
                    gui.blit(GUI_HUD, px2, py, 0 + k * 18, 0, 18, 18);
                    //cooldown frame
                    if (len > 0)
                        gui.blit(GUI_HUD, px2, py + 18 - len, 0, 36 - len, 18, len);
                    //cooldown text
                    if (len > 0)
                        gui.drawString(fr, String.format("%.1f", drawCD[k] * 0.05F),
                            px2 + 5, py + 18, Enums.EnumColors.YELLOW.getValue(), true);
                    //key-press flash
                    if (k < mc.options.keyHotbarSlots.length &&
                        mc.options.keyHotbarSlots[k].isDown())
                    {
                        gui.fill(px2, py, px2 + 18, py + 18, 1073741823);
                    }

                    if (k == 2)
                        gui.drawString(fr, String.valueOf(drawAirNum[0]),
                            px2 + 7, py - 8, Enums.EnumColors.GREEN.getValue(), true);
                    else if (k == 3)
                        gui.drawString(fr, String.valueOf(drawAirNum[1]),
                            px2 + 7, py - 8, Enums.EnumColors.CYAN.getValue(), true);
                }
            }

            //draw cross
            gui.blit(GUI_HUD, (int)(i * 0.5F), (int)(j * 0.5F) - 4, 0, 7, 1, 9);
            gui.blit(GUI_HUD, (int)(i * 0.5F) - 4, (int)(j * 0.5F), 7, 0, 9, 1);
        }
        catch (Exception e)
        {
            LogHelper.info("EXCEPTION: render game overlay fail: " + e);
        }
    }


    private ShipHudOverlay() {}

}

package com.lulan.shincolle.client.gui.screen;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.menu.ShipInventoryMenu;
import com.lulan.shincolle.network.payload.GuiButtonPayload;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.utility.GuiHelper;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.network.PacketDistributor;

import org.joml.Quaternionf;
import org.joml.Vector3f;

/**
 * ship inventory screen (legacy GuiShipInventory).
 * texture 256x214; ship item grid + equip column + attribute panel + AI panel.
 * <p>
 * Layout (relative to leftPos/topPos):
 * <ul>
 *   <li>title (8,6); HP / Lv top-right</li>
 *   <li>ship item grid  x=8..62  (container)</li>
 *   <li>attribute panel x=75..133, attribute-page selector x=133..142</li>
 *   <li>equip column    x=144    (container)</li>
 *   <li>model viewport  x=160..250, y=6..128 (red frame in texture)</li>
 *   <li>AI panel        icons x=174, labels x=187, page markers x=239/246</li>
 *   <li>player inventory y=132.., hotbar y=190</li>
 * </ul>
 */
public class ShipInventoryScreen extends AbstractContainerScreen<ShipInventoryMenu>
{

    private static final ResourceLocation TEXTURE_BG =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/gui/guishipinventory.png");

    /** icon sprites in texture: on(0,214) off(11,214) marker(74,214) bar(31,214) knob(22,214) */
    private static final int TEX = 256;

    private final BasicEntityShip entity;
    private int showPage = 1;		//attribute page 1~3
    private int showPageAI = 1;		//AI page 1~7+
    private int mousePressBar = -1;	//dragged slider index, -1 = none
    private int barPos = 0;			//slider drag x-offset


    public ShipInventoryScreen(ShipInventoryMenu menu, Inventory inv, Component title)
    {
        super(menu, inv, title);
        this.imageWidth = 256;
        this.imageHeight = 214;
        this.entity = menu.getEntity();
        this.inventoryLabelX = 8;
        this.inventoryLabelY = 120;
    }

    /* ------------------------------------------------------------------ */
    /*  background                                                         */
    /* ------------------------------------------------------------------ */

    @Override
    protected void renderBg(GuiGraphics g, float partialTick, int mouseX, int mouseY)
    {
        //main panel
        g.blit(TEXTURE_BG, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, TEX, TEX);

        if (this.entity == null) return;

        //inventory-page marker (x=62, y=18/54/90)
        int invPage = this.menu.getPage();
        g.blit(TEXTURE_BG, this.leftPos + 62, this.topPos + invPageMarkerY(invPage), 74, 214, 6, 34, TEX, TEX);

        //attribute-page marker (x=135)
        g.blit(TEXTURE_BG, this.leftPos + 135, this.topPos + attrMarkerY(this.showPage), 74, 214, 6, 34, TEX, TEX);

        //AI-page marker (x=239 pages1-6 / x=246 pages7-12, y=131+13*row)
        int[] aiMark = aiMarkerPos(this.showPageAI);
        g.blit(TEXTURE_BG, this.leftPos + aiMark[0], this.topPos + aiMark[1], 74, 214, 6, 11, TEX, TEX);

        drawAIControls(g);
    }

    private static int invPageMarkerY(int page) { return 18 + Math.max(0, Math.min(2, page)) * 36; }
    private static int attrMarkerY(int page)    { return page == 2 ? 54 : (page == 3 ? 90 : 18); }

    /** AI page -> [markerX, markerY]: pages 1-6 col x=239, 7-12 col x=246 */
    private static int[] aiMarkerPos(int page)
    {
        if (page <= 6) return new int[]{239, 131 + (page - 1) * 13};
        return new int[]{246, 131 + (page - 7) * 13};
    }

    /** draw AI toggle icons / sliders for the active AI page */
    private void drawAIControls(GuiGraphics g)
    {
        switch (this.showPageAI)
        {
        case 1:
            //attack toggles, rows gated by attack-type flags
            drawIcon(g, 0, this.entity.getStateFlag(ID.F.UseMelee), true);
            drawIcon(g, 1, this.entity.getStateFlag(ID.F.UseAmmoLight), this.entity.getAttackType(ID.F.AtkType_Light));
            drawIcon(g, 2, this.entity.getStateFlag(ID.F.UseAmmoHeavy), this.entity.getAttackType(ID.F.AtkType_Heavy));
            drawIcon(g, 3, this.entity.getStateFlag(ID.F.UseAirLight), this.entity.getAttackType(ID.F.AtkType_AirLight));
            drawIcon(g, 4, this.entity.getStateFlag(ID.F.UseAirHeavy), this.entity.getAttackType(ID.F.AtkType_AirHeavy));
            drawIcon(g, 5, this.entity.getStateFlag(ID.F.UseRingEffect), this.entity.getAttackType(ID.F.HaveRingEffect));
            break;
        case 2:
            //sliders: FollowMin / FollowMax / FleeHP
            drawBar(g, 0);
            drawBar(g, 1);
            drawBar(g, 2);
            int fMin = (int)(((this.entity.getStateMinor(ID.M.FollowMin) - 1) / 30F) * 42F);
            int fMax = (int)(((this.entity.getStateMinor(ID.M.FollowMax) - 2) / 30F) * 42F);
            int flee = (int)((this.entity.getStateMinor(ID.M.FleeHP) / 100F) * 42F);
            if (this.mousePressBar == 0) drawKnob(g, 0, this.barPos);
            else if (this.mousePressBar == 1) drawKnob(g, 1, this.barPos);
            else if (this.mousePressBar == 2) drawKnob(g, 2, this.barPos);
            else { drawKnob(g, 0, fMin); drawKnob(g, 1, fMax); drawKnob(g, 2, flee); }
            break;
        case 3:
            //target-AI toggles
            drawIcon(g, 0, this.entity.getStateFlag(ID.F.PassiveAI), true);
            drawIcon(g, 1, this.entity.getStateFlag(ID.F.OnSightChase), true);
            drawIcon(g, 2, this.entity.getStateFlag(ID.F.PVPFirst), true);
            drawIcon(g, 3, this.entity.getStateFlag(ID.F.AntiAir), true);
            drawIcon(g, 4, this.entity.getStateFlag(ID.F.AntiSS), true);
            drawIcon(g, 5, this.entity.getStateFlag(ID.F.TimeKeeper), true);
            break;
        case 4:
            //PickItem (gated by CanPickItem) / AutoPump
            drawIcon(g, 0, this.entity.getStateFlag(ID.F.PickItem), this.entity.getStateFlag(ID.F.CanPickItem));
            drawIcon(g, 1, this.entity.getStateFlag(ID.F.AutoPump), true);
            break;
        case 5:
            //sliders: WpStay / UseCombatRation
            drawBar(g, 0);
            drawBar(g, 1);
            int wp = (int)(this.entity.getStateMinor(ID.M.WpStay) * 0.0625F * 42F);
            int cr = (this.entity.getStateMinor(ID.M.UseCombatRation) - 1) * 14;
            if (this.mousePressBar == 3) drawKnob(g, 0, this.barPos);
            else if (this.mousePressBar == 4) drawKnob(g, 1, this.barPos);
            else { drawKnob(g, 0, wp); drawKnob(g, 1, cr); }
            break;
        case 6:
            //ShowHeldItem + model-state grid
            drawIcon(g, 0, this.entity.getStateFlag(ID.F.ShowHeldItem), true);
            int modelState = this.entity.getStateEmotion(ID.S.State);
            int maxState = this.entity.getStateMinor(ID.M.NumState);
            int num = 0;
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    if (++num > maxState) break;
                    boolean on = (modelState & (1 << num)) != 0;
                    int u = on ? 0 : 11;
                    g.blit(TEXTURE_BG, this.leftPos + 176 + j * 16, this.topPos + 157 + i * 13,
                        u, 214, 11, 11, TEX, TEX);
                }
            }
            break;
        default:
            break;
        }
    }

    /** 11x11 on/off icon at row i (x=174, y=131+13*i); drawn only if {@code shown} */
    private void drawIcon(GuiGraphics g, int row, boolean on, boolean shown)
    {
        if (!shown) return;
        g.blit(TEXTURE_BG, this.leftPos + 174, this.topPos + 131 + row * 13,
            on ? 0 : 11, 214, 11, 11, TEX, TEX);
    }

    /** 43x3 slider bar at row i (x=191, y=148+24*i) */
    private void drawBar(GuiGraphics g, int row)
    {
        g.blit(TEXTURE_BG, this.leftPos + 191, this.topPos + 148 + row * 24, 31, 214, 43, 3, TEX, TEX);
    }

    /** 9x9 slider knob at row i (x=187+pos, y=145+24*i) */
    private void drawKnob(GuiGraphics g, int row, int pos)
    {
        g.blit(TEXTURE_BG, this.leftPos + 187 + pos, this.topPos + 145 + row * 24, 22, 214, 9, 9, TEX, TEX);
    }

    /* ------------------------------------------------------------------ */
    /*  foreground labels                                                  */
    /* ------------------------------------------------------------------ */

    @Override
    protected void renderLabels(GuiGraphics g, int mouseX, int mouseY)
    {
        if (this.entity == null)
        {
            g.drawString(this.font, this.title, 8, 6, 0x404040, false);
            return;
        }

        //title (ship name)
        g.drawString(this.font, this.entity.getDisplayName(), 8, 6, 0x404040, false);

        drawTopBar(g);
        drawAttributes(g);
        drawAILabels(g);
    }

    /** top-right: HP cur/max + Lv */
    private void drawTopBar(GuiGraphics g)
    {
        int lv = this.entity.getShipLevel();
        int hpCur = (int) Math.ceil(this.entity.getHealth());
        int hpMax = (int) Math.ceil(this.entity.getMaxHealth());

        Component lvMark = Component.translatable("gui.shincolle.level");
        Component hpMark = Component.translatable("gui.shincolle.hp");
        g.drawString(this.font, lvMark, 231 - this.font.width(lvMark), 6, 0xFFFF, true);
        g.drawString(this.font, hpMark, 145 - this.font.width(hpMark), 6, 0xFFFF, true);

        int lvColor = lv < 150 ? 0xFFFFFF : 0xFFD800;
        g.drawString(this.font, String.valueOf(lv), 250 - this.font.width(String.valueOf(lv)), 6, lvColor, true);

        g.drawString(this.font, "/" + hpMax, 148 + this.font.width(String.valueOf(hpCur)), 6, 0xFFFFFF, true);
        int hpColor = hpCur < hpMax ? 0xCCCCCC : 0xFFFFFF;
        g.drawString(this.font, String.valueOf(hpCur), 147, 6, hpColor, true);
    }

    /** attribute text in the middle panel (labels x=75, values right-aligned x=133) */
    private void drawAttributes(GuiGraphics g)
    {
        switch (this.showPage)
        {
        case 2:	//stats page
            boolean cannon = this.entity.getAttackType(ID.F.AtkType_Light) || this.entity.getAttackType(ID.F.AtkType_Heavy);
            var attrs = this.entity.getAttrs();
            if (cannon)
            {
                g.drawString(this.font, Component.translatable("gui.shincolle.firepower1"), 75, 20, 0, false);
                String v = String.format("%.1f / %.1f",
                    attrs.getAttrsBuffed(ID.Attrs.ATK_L), attrs.getAttrsBuffed(ID.Attrs.ATK_H));
                g.drawString(this.font, v, 133 - this.font.width(v), 30, 0xFFFFFF, true);
            }
            else
            {
                g.drawString(this.font, Component.translatable("gui.shincolle.firepower2"), 75, 20, 0, false);
                String v = String.format("%.1f / %.1f",
                    attrs.getAttrsBuffed(ID.Attrs.ATK_AL), attrs.getAttrsBuffed(ID.Attrs.ATK_AH));
                g.drawString(this.font, v, 133 - this.font.width(v), 30, 0xFFFFFF, true);
            }
            attrRow(g, "gui.shincolle.armor",       String.format("%.1f%%", attrs.getAttrsBuffed(ID.Attrs.DEF) * 100F), 41, 51);
            attrRow(g, "gui.shincolle.attackspeed", String.format("%.2f",  attrs.getAttrsBuffed(ID.Attrs.SPD)),        62, 72);
            attrRow(g, "gui.shincolle.movespeed",   String.format("%.2f",  attrs.getAttrsBuffed(ID.Attrs.MOV)),        83, 93);
            attrRow(g, "gui.shincolle.range",       String.format("%.1f",  attrs.getAttrsBuffed(ID.Attrs.HIT)),        104, 114);
            break;
        case 3:	//marriage / formation / airplane
            g.drawString(this.font, Component.translatable("gui.shincolle.marriage"), 75, 20, 0, false);
            boolean wed = this.entity.getStateFlag(ID.F.IsMarried);
            String wedS = Component.translatable(wed ? "gui.shincolle.married" : "gui.shincolle.unmarried").getString();
            g.drawString(this.font, wedS, 133 - this.font.width(wedS), 30, 0xFFFF00, true);
            g.drawString(this.font, Component.translatable("gui.shincolle.airplanelight"), 75, 62, 0, false);
            g.drawString(this.font, Component.translatable("gui.shincolle.airplaneheavy"), 75, 83, 0, false);
            String al = String.valueOf(this.entity.getStateMinor(ID.M.NumAirLight));
            String ah = String.valueOf(this.entity.getStateMinor(ID.M.NumAirHeavy));
            g.drawString(this.font, al, 133 - this.font.width(al), 72, 0xFFFF00, true);
            g.drawString(this.font, ah, 133 - this.font.width(ah), 93, 0xFFFF00, true);
            break;
        case 1:
        default:	//page 1: kills / exp / ammo / grudge
            attrRow(g, "gui.shincolle.kills",     String.valueOf(this.entity.getStateMinor(ID.M.Kills)),         20, 30);
            attrRow(g, "gui.shincolle.exp",       expText(),                                                      41, 51);
            attrRow(g, "gui.shincolle.ammolight", String.valueOf(this.entity.getStateMinor(ID.M.NumAmmoLight)),  62, 72);
            attrRow(g, "gui.shincolle.ammoheavy", String.valueOf(this.entity.getStateMinor(ID.M.NumAmmoHeavy)),  83, 93);
            attrRow(g, "gui.shincolle.grudge",    String.valueOf(this.entity.getStateMinor(ID.M.NumGrudge)),     104, 114);
            break;
        }
    }

    private String expText()
    {
        int cur = this.entity.getStateMinor(ID.M.ExpCurrent);
        int next = this.entity.getStateMinor(ID.M.ExpNext);
        return cur + "/" + next;
    }

    /** label at x=75 / value right-aligned at x=133 */
    private void attrRow(GuiGraphics g, String labelKey, String value, int labelY, int valueY)
    {
        g.drawString(this.font, Component.translatable(labelKey), 75, labelY, 0, false);
        g.drawString(this.font, value, 133 - this.font.width(value), valueY, 0xFFFFFF, true);
    }

    /** AI-panel labels at x=174/187, y=133+13*i */
    private void drawAILabels(GuiGraphics g)
    {
        switch (this.showPageAI)
        {
        case 1:
            aiLabel(g, "gui.shincolle.canmelee", 0, true);
            aiLabel(g, "gui.shincolle.canlightattack",    1, this.entity.getAttackType(ID.F.AtkType_Light));
            aiLabel(g, "gui.shincolle.canheavyattack",    2, this.entity.getAttackType(ID.F.AtkType_Heavy));
            aiLabel(g, "gui.shincolle.canairlightattack", 3, this.entity.getAttackType(ID.F.AtkType_AirLight));
            aiLabel(g, "gui.shincolle.canairheavyattack", 4, this.entity.getAttackType(ID.F.AtkType_AirHeavy));
            aiLabel(g, "gui.shincolle.auraeffect",        5, this.entity.getAttackType(ID.F.HaveRingEffect));
            break;
        case 2:
            barLabel(g, "gui.shincolle.followmin", 0, String.valueOf(this.entity.getStateMinor(ID.M.FollowMin)));
            barLabel(g, "gui.shincolle.followmax", 1, String.valueOf(this.entity.getStateMinor(ID.M.FollowMax)));
            barLabel(g, "gui.shincolle.fleehp",    2, String.valueOf(this.entity.getStateMinor(ID.M.FleeHP)));
            break;
        case 3:
            aiLabel(g, "gui.shincolle.targetAI",       0, true);
            aiLabel(g, "gui.shincolle.onsightAI",      1, true);
            aiLabel(g, "gui.shincolle.ai.pvp",         2, true);
            aiLabel(g, "gui.shincolle.ai.aa",          3, true);
            aiLabel(g, "gui.shincolle.ai.asm",         4, true);
            aiLabel(g, "gui.shincolle.ai.timekeeper",  5, true);
            break;
        case 4:
            aiLabel(g, "gui.shincolle.ai.pickitem", 0, this.entity.getStateFlag(ID.F.CanPickItem));
            aiLabel(g, "gui.shincolle.autopump",    1, true);
            break;
        case 5:
            barLabel(g, "gui.shincolle.ai.wpstay",           0,
                com.lulan.shincolle.utility.CalcHelper.tick2SecOrMin(
                    BasicEntityShip.wpStayTime2Ticks(this.entity.getStateMinor(ID.M.WpStay))));
            int cr = this.entity.getStateMinor(ID.M.UseCombatRation);
            barLabel(g, "gui.shincolle.autocombatration",    1, cr <= 0 ? "OFF" : "Lv." + cr);
            break;
        case 6:
            aiLabel(g, "gui.shincolle.showhelditem", 0, true);
            g.drawString(this.font, Component.translatable("gui.shincolle.appearance"), 177, 146, 0, false);
            break;
        case 7:
            g.drawString(this.font, Component.translatable("gui.shincolle.ai.cooking"), 187, 159, 0, false);
            g.drawString(this.font, Component.translatable("gui.shincolle.ai.fishing"), 187, 172, 0, false);
            g.drawString(this.font, Component.translatable("gui.shincolle.ai.mining"),  187, 185, 0, false);
            g.drawString(this.font, Component.translatable("gui.shincolle.ai.crafting"),187, 198, 0, false);
            break;
        default:
            break;
        }
    }

    /** toggle label at x=187, y=133+13*row */
    private void aiLabel(GuiGraphics g, String key, int row, boolean shown)
    {
        if (!shown) return;
        g.drawString(this.font, Component.translatable(key), 187, 133 + row * 13, 0, false);
    }

    /** slider label at x=174, y=134+24*row; value shadowed at y+11 */
    private void barLabel(GuiGraphics g, String key, int row, String value)
    {
        g.drawString(this.font, Component.translatable(key), 174, 134 + row * 24, 0, false);
        g.drawString(this.font, value, 174, 145 + row * 24, 0xFFFF00, true);
    }

    /* ------------------------------------------------------------------ */
    /*  render (entity preview + tooltip)                                  */
    /* ------------------------------------------------------------------ */

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float partialTick)
    {
        super.render(g, mouseX, mouseY, partialTick);

        //ship model preview inside the red viewport (x=165..249, y=18..118)
        if (this.entity != null)
        {
            renderShipModel(g, mouseX, mouseY);
        }

        this.renderTooltip(g, mouseX, mouseY);
    }

    /**
     * legacy GuiShipInventory.drawEntityModel: the entity ORIGIN (feet) is
     * placed at guiLeft+218, guiTop+100 with per-class GUI scale, facing the
     * camera with mouse-follow. Rendered via InventoryScreen.renderEntityInInventory
     * (origin-based) rather than the bbox-centering FollowsMouse helper so the
     * model lands exactly where the legacy layout intends.
     */
    private void renderShipModel(GuiGraphics g, int mouseX, int mouseY)
    {
        float[] mp = this.entity.modelPosInGUI;    //{x,y,z,scale}
        float scale = mp.length > 3 ? mp[3] : 50F;

        //mouse-follow angles; legacy reference point is guiLeft+215, guiTop+60
        float yaw = (float) Math.atan((this.leftPos + 215 - mouseX) / 40.0F);
        float pitch = (float) Math.atan((this.topPos + 60 - mouseY) / 40.0F);

        Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
        Quaternionf cam = new Quaternionf().rotateX(pitch * 20.0F * Mth.DEG_TO_RAD);
        pose.mul(cam);

        //save + face the camera
        float bodyRot = this.entity.yBodyRot, yRot = this.entity.getYRot(),
              xRot = this.entity.getXRot(), headRotO = this.entity.yHeadRotO,
              headRot = this.entity.yHeadRot;
        this.entity.yBodyRot = 180.0F + yaw * 20.0F;
        this.entity.setYRot(180.0F + yaw * 40.0F);
        this.entity.setXRot(-pitch * 20.0F);
        this.entity.yHeadRot = this.entity.getYRot();
        this.entity.yHeadRotO = this.entity.getYRot();

        g.enableScissor(this.leftPos + 165, this.topPos + 18,
                        this.leftPos + 249, this.topPos + 118);
        InventoryScreen.renderEntityInInventory(g,
            this.leftPos + 218 + mp[0], this.topPos + 100 + mp[1],
            scale, new Vector3f(0F, 0F, 0F), pose, cam, this.entity);
        g.disableScissor();

        this.entity.yBodyRot = bodyRot; this.entity.setYRot(yRot);
        this.entity.setXRot(xRot); this.entity.yHeadRotO = headRotO;
        this.entity.yHeadRot = headRot;
    }

    /* ------------------------------------------------------------------ */
    /*  input: page nav + AI toggles + sliders                             */
    /* ------------------------------------------------------------------ */

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        int x = (int) mouseX - this.leftPos;
        int y = (int) mouseY - this.topPos;

        //slider press on AI slider pages
        if (this.showPageAI == 2 || this.showPageAI == 5)
        {
            int hit = GuiHelper.getButton(ID.Gui.SHIPINVENTORY, 2, x, y);
            this.mousePressBar = hit < 0 ? -1 : hit + (this.showPageAI == 5 ? 3 : 0);
            if (this.mousePressBar >= 0)
            {
                this.barPos = clampBar(x - 187);
                sendBarValue();
                return true;
            }
        }
        else
        {
            this.mousePressBar = -1;
        }

        int btn = GuiHelper.getButton(ID.Gui.SHIPINVENTORY, 0, x, y);
        switch (btn)
        {
        case 0: this.showPage = 1; return true;
        case 1: this.showPage = 2; return true;
        case 2: this.showPage = 3; return true;
        case 3: case 4: case 5: case 6: case 7: case 8:
            onAIToggle(btn - 3);
            return true;
        case 9:  case 10: case 11: case 12: case 13: case 14:
            this.showPageAI = btn - 8;              //AI pages 1-6
            return true;
        case 15: case 16: case 17:
            sendShipButton(ID.B.ShipInv_InvPage, btn - 15);   //inv page 0-2
            return true;
        case 18: case 19: case 20: case 21: case 22: case 23:
            this.showPageAI = btn - 11;             //AI pages 7-12
            return true;
        default:
            break;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dx, double dy)
    {
        if (this.mousePressBar >= 0)
        {
            int x = (int) mouseX - this.leftPos;
            this.barPos = clampBar(x - 187);
            sendBarValue();
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, dx, dy);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button)
    {
        this.mousePressBar = -1;
        return super.mouseReleased(mouseX, mouseY, button);
    }

    private static int clampBar(int pos) { return Math.max(0, Math.min(42, pos)); }

    /** send the dragged slider's value to the server */
    private void sendBarValue()
    {
        int v;
        int bid;
        switch (this.mousePressBar)
        {
        case 0: v = (int)(this.barPos / 42F * 30F + 1F);  bid = ID.B.ShipInv_FollowMin; break;
        case 1: v = (int)(this.barPos / 42F * 30F + 2F);  bid = ID.B.ShipInv_FollowMax; break;
        case 2: v = (int)(this.barPos / 42F * 100F);      bid = ID.B.ShipInv_FleeHP;    break;
        case 3: v = (int)(this.barPos / (42F * 0.0625F)); bid = ID.B.ShipInv_WpStay;    break;
        case 4: v = (int)(this.barPos / (43F * 0.25F)) + 1; bid = ID.B.ShipInv_AutoCR;  break;
        default: return;
        }
        sendShipButton(bid, v);
    }

    /** toggle row i of the active AI page -> ship button payload */
    private void onAIToggle(int row)
    {
        int bid = -1;
        boolean cur = false;

        switch (this.showPageAI)
        {
        case 1:
            switch (row)
            {
            case 0: bid = ID.B.ShipInv_Melee;     cur = flag(ID.F.UseMelee);     break;
            case 1: bid = ID.B.ShipInv_AmmoLight; cur = flag(ID.F.UseAmmoLight); break;
            case 2: bid = ID.B.ShipInv_AmmoHeavy; cur = flag(ID.F.UseAmmoHeavy); break;
            case 3: bid = ID.B.ShipInv_AirLight;  cur = flag(ID.F.UseAirLight);  break;
            case 4: bid = ID.B.ShipInv_AirHeavy;  cur = flag(ID.F.UseAirHeavy);  break;
            case 5: bid = ID.B.ShipInv_AuraEffect;cur = flag(ID.F.UseRingEffect);break;
            }
            break;
        case 3:
            switch (row)
            {
            case 0: bid = ID.B.ShipInv_TarAI;      cur = flag(ID.F.PassiveAI);    break;
            case 1: bid = ID.B.ShipInv_OnSightAI;  cur = flag(ID.F.OnSightChase); break;
            case 2: bid = ID.B.ShipInv_PVPAI;      cur = flag(ID.F.PVPFirst);     break;
            case 3: bid = ID.B.ShipInv_AAAI;       cur = flag(ID.F.AntiAir);      break;
            case 4: bid = ID.B.ShipInv_ASMAI;      cur = flag(ID.F.AntiSS);       break;
            case 5: bid = ID.B.ShipInv_TIMEKEEPAI; cur = flag(ID.F.TimeKeeper);   break;
            }
            break;
        case 4:
            switch (row)
            {
            case 0: bid = ID.B.ShipInv_PickitemAI; cur = flag(ID.F.PickItem); break;
            case 1: bid = ID.B.ShipInv_AutoPump;   cur = flag(ID.F.AutoPump); break;
            }
            break;
        case 6:
            if (row == 0) { bid = ID.B.ShipInv_ShowHeld; cur = flag(ID.F.ShowHeldItem); }
            break;
        default:
            break;
        }

        if (bid >= 0) sendShipButton(bid, cur ? 0 : 1);
    }

    private boolean flag(int flagId)
    {
        return this.entity != null && this.entity.getStateFlag(flagId);
    }

    /** send a ship-GUI button to the server (legacy C2SGUIPackets ShipBtn) */
    private void sendShipButton(int buttonId, int value)
    {
        if (this.entity != null)
        {
            PacketDistributor.sendToServer(
                GuiButtonPayload.entity(GuiButtonPayload.CH_SHIP, this.entity.getId(), buttonId, value));
        }
    }


}

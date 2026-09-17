package com.lulan.shincolle.client;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.registry.ModComponents;
import com.lulan.shincolle.registry.ModItems;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderFrameEvent;
import net.neoforged.neoforge.client.event.RenderHandEvent;
import net.neoforged.neoforge.client.event.ViewportEvent;
import com.lulan.shincolle.reference.Reference;

/**
 * client-side render event hooks (legacy EventHandler client half).
 *
 * - mount camera switch: while riding a ship mount the render view entity
 *   is temporarily moved to the host ship so the camera follows the ship
 *   model, then restored to the player at frame end.
 * - pointer item first-person hand: magnifier-mode pointers render a
 *   custom arm pose.
 * - liquid fog reduction by active marriage ring.
 */
@EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT)
public final class ClientRenderHandler
{

    /** true while the camera is temporarily on the host ship */
    private static boolean viewChanged = false;


    /** switch camera to host ship before frame render (legacy onRenderTick START) */
    @SubscribeEvent
    public static void onRenderFramePre(RenderFrameEvent.Pre event)
    {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null) return;

        if (player.getVehicle() instanceof BasicEntityMount mount)
        {
            BasicEntityShip ship = mount.getHostShip();

            if (ship != null && !viewChanged)
            {
                mc.setCameraEntity(ship);
                viewChanged = true;
            }

            //copy player rotation to camera ship so view rotation works
            if (viewChanged && mc.getCameraEntity() instanceof LivingEntity cam)
            {
                cam.yBodyRot = player.yBodyRot;
                cam.setYHeadRot(player.getYHeadRot());
                cam.yBodyRotO = player.yBodyRotO;
                cam.yHeadRotO = player.yHeadRotO;
                cam.setXRot(player.getXRot());
                cam.setYRot(player.getYRot());
                cam.xRotO = player.xRotO;
                cam.yRotO = player.yRotO;
            }
        }
    }

    /** restore camera to the player after frame render (legacy onRenderTick END) */
    @SubscribeEvent
    public static void onRenderFramePost(RenderFrameEvent.Post event)
    {
        if (viewChanged)
        {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null) mc.setCameraEntity(mc.player);
            viewChanged = false;
        }
    }

    /**
     * custom first-person hand for pointer item in magnifier modes
     * (legacy RenderHelper.renderItemInFirstPerson for PointerItem meta 3+).
     */
    @SubscribeEvent
    public static void onRenderHand(RenderHandEvent event)
    {
        ItemStack stack = event.getItemStack();
        if (event.getHand() != InteractionHand.MAIN_HAND || stack.isEmpty()) return;
        if (!stack.is(ModItems.POINTER_ITEM.get())) return;

        int mode = stack.getOrDefault(ModComponents.POINTER_MODE, 0);
        if (mode <= 2) return;

        event.setCanceled(true);

        LocalPlayer player = Minecraft.getInstance().player;
        if (!(player instanceof AbstractClientPlayer cp) || cp.isInvisible()) return;

        boolean rightHand = cp.getMainArm() != HumanoidArm.LEFT;
        float f = rightHand ? 1.0F : -1.0F;
        var pose = event.getPoseStack();
        float ptick = event.getPartialTick();

        pose.pushPose();
        pose.translate(f * 0.64000005F, -0.6F, -0.71999997F);
        pose.mulPose(com.mojang.math.Axis.YP.rotationDegrees(f * 45.0F));
        pose.translate(f * -1.0F, 3.6F, 3.5F);
        pose.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(120.0F));
        pose.mulPose(com.mojang.math.Axis.XP.rotationDegrees(200.0F));
        pose.mulPose(com.mojang.math.Axis.YP.rotationDegrees(f * -135.0F));
        pose.translate(f * 5.6F, 0.0F, 0.0F);

        if (Minecraft.getInstance().options.keyUse.isDown())
        {
            switch (mode)
            {
            case 3:
                pose.translate(1.3F, 4F, 0.0F);
                pose.scale(3F, 3F, 3F);
                pose.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(
                    net.minecraft.util.Mth.cos((cp.tickCount + ptick) * 0.125F) * -20F - 60F));
            break;
            case 4:
                pose.mulPose(com.mojang.math.Axis.YP.rotationDegrees(70F));
                pose.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(-20F));
                pose.translate(-2F, 16F, 10F);
                pose.scale(12F, 12F, 12F);
                pose.mulPose(com.mojang.math.Axis.XP.rotationDegrees(
                    net.minecraft.util.Mth.cos((cp.tickCount + ptick) * 0.1F) * -15F + 20F));
            break;
            default:
                pose.translate(13.5F, 12.5F, 2.5F);
                pose.scale(9F, 9F, 9F);
                pose.mulPose(com.mojang.math.Axis.YN.rotationDegrees(
                    net.minecraft.util.Mth.cos((cp.tickCount + ptick) * 0.2F) * -15F - 20F));
            break;
            }
        }

        var dispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        PlayerRenderer renderer = (PlayerRenderer) dispatcher.getRenderer(cp);

        if (rightHand) renderer.renderRightHand(pose, event.getMultiBufferSource(),
            event.getPackedLight(), cp);
        else renderer.renderLeftHand(pose, event.getMultiBufferSource(),
            event.getPackedLight(), cp);

        pose.popPose();
    }

    /**
     * reduce liquid fog while the player's marriage ring is active
     * (legacy EventHandler.onSetLiquidFog).
     */
    @SubscribeEvent
    public static void onRenderFog(ViewportEvent.RenderFog event)
    {
        Entity entity = event.getCamera().getEntity();
        if (entity == null || ShinColleConfig.ringAbility[3] < 0) return;
        if (!EntityHelper.checkEntityIsInLiquid(entity)) return;
        if (!(entity instanceof net.minecraft.world.entity.player.Player player)) return;

        var tag = player.getData(com.lulan.shincolle.registry.ModAttachments.TEITOKU);
        if (tag == null || !tag.getBoolean("RingActive")) return;

        float fogDen = event.getFarPlaneDistance();

        //0 = always no fog
        if (ShinColleConfig.ringAbility[3] == 0)
        {
            fogDen = Math.max(fogDen, 1.0E7F);
        }
        else
        {
            int married = tag.getInt("MarriageNum");
            float keep = (float)(ShinColleConfig.ringAbility[3] - married) /
                         (float) ShinColleConfig.ringAbility[3];
            //extend far plane = thinner fog
            fogDen = fogDen / Math.max(0.0001F, keep);
        }

        event.setFarPlaneDistance(fogDen);
        event.setNearPlaneDistance(Math.min(event.getNearPlaneDistance(), 0F));
        event.setCanceled(true);
    }


    private ClientRenderHandler() {}

}

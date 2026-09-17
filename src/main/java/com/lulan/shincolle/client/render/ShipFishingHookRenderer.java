package com.lulan.shincolle.client.render;

import com.lulan.shincolle.entity.EntityShipFishingHook;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

/**
 * ship fishing hook renderer (legacy RenderShipFishing port):
 * bobbing billboard + line to the owner.
 */
public class ShipFishingHookRenderer extends EntityRenderer<EntityShipFishingHook>
{

    private static final ResourceLocation TEX = ResourceLocation.withDefaultNamespace("textures/entity/fishing_hook.png");
    private static final RenderType RENDER_TYPE = RenderType.entityCutout(TEX);


    public ShipFishingHookRenderer(EntityRendererProvider.Context ctx)
    {
        super(ctx);
        this.shadowRadius = 0F;
    }

    @Override
    public void render(EntityShipFishingHook entity, float yaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight)
    {
        //bobbing billboard
        float y2 = Mth.cos((entity.tickCount + partialTick) * 0.15F) * 0.05F - 0.25F;
        poseStack.pushPose();
        poseStack.translate(0F, y2 + 0.25F, 0F);
        poseStack.scale(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        PoseStack.Pose pose = poseStack.last();
        VertexConsumer vc = buffer.getBuffer(RENDER_TYPE);
        vertex(vc, pose, packedLight, 0F, 0F, 0, 1);
        vertex(vc, pose, packedLight, 1F, 0F, 1, 1);
        vertex(vc, pose, packedLight, 1F, 1F, 1, 0);
        vertex(vc, pose, packedLight, 0F, 1F, 0, 0);
        poseStack.popPose();

        //line to owner
        Entity owner = entity.getOwner();
        if (owner != null)
        {
            float pt = partialTick;
            Vec3 start = getOwnerHandPos(owner, pt);
            Vec3 end = new Vec3(
                Mth.lerp(pt, entity.xo, entity.getX()),
                Mth.lerp(pt, entity.yo, entity.getY()) + y2 + 0.25D,
                Mth.lerp(pt, entity.zo, entity.getZ()));

            Vec3 cam = this.entityRenderDispatcher.camera.getPosition();
            poseStack.pushPose();
            poseStack.translate(end.subtract(cam).x, end.subtract(cam).y, end.subtract(cam).z);
            VertexConsumer line = buffer.getBuffer(RenderType.lineStrip());
            PoseStack.Pose lp = poseStack.last();
            Vec3 diff = start.subtract(end);
            int segs = 16;
            for (int i = 0; i <= segs; i++)
            {
                float f = (float) i / segs;
                Vec3 p = diff.scale(f);
                //sag like a fishing line
                float sag = (float) (Math.sin(f * Math.PI) * 0.15D);
                line.addVertex(lp.pose(), (float) p.x, (float) p.y - sag, (float) p.z)
                    .setColor(0, 0, 0, 255).setNormal(lp, (float) diff.x, (float) diff.y, (float) diff.z);
            }
            poseStack.popPose();
        }

        super.render(entity, yaw, partialTick, poseStack, buffer, packedLight);
    }

    private static Vec3 getOwnerHandPos(Entity owner, float partialTick)
    {
        //approximate hand position: owner eye pos, offset toward held side
        Vec3 base = owner.getEyePosition(partialTick);
        if (owner instanceof Player player)
        {
            int side = player.getMainArm() == HumanoidArm.RIGHT ? 1 : -1;
            float yaw = Mth.lerp(partialTick, owner.yRotO, owner.getYRot()) * Mth.DEG_TO_RAD;
            base = base.add(-Mth.sin(yaw) * side * 0.35D - Mth.cos(yaw) * 0.2D,
                -0.45D,
                Mth.cos(yaw) * side * 0.35D - Mth.sin(yaw) * 0.2D);
        }
        return base;
    }

    private static void vertex(VertexConsumer vc, PoseStack.Pose pose, int light,
                               float x, float y, int u, int v)
    {
        vc.addVertex(pose, x - 0.5F, y - 0.5F, 0F)
            .setColor(-1).setUv(u, v)
            .setOverlay(OverlayTexture.NO_OVERLAY).setLight(light)
            .setNormal(pose, 0F, 1F, 0F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityShipFishingHook entity)
    {
        return TEX;
    }


}

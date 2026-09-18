package com.lulan.shincolle.client.render;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.lulan.shincolle.client.model.MiscModel;
import com.lulan.shincolle.client.model.ShipModel;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.entity.EntityAirplaneTakoyaki;
import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.registry.ModEntities;
import com.lulan.shincolle.reference.ID;

import org.joml.Vector3f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;

/**
 * ship entity renderer (Phase 7).
 * Model / texture / shadow are resolved per entity via {@link ShipRenderTable}
 * keyed by the entity's ship class id.
 * Generic bound is {@link Mob} (not {@link BasicEntityShip}) so the same
 * renderer covers both friendly ships and hostile *_mob / *_hime variants,
 * matching the legacy RenderShipEntity which extended RenderLiving<EntityLiving>.
 */
public class ShipRenderer extends MobRenderer<Mob, EntityModel<Mob>>
{

    /** baked model cache: shipClass -> model */
    private final Map<Integer, EntityModel<Mob>> models = new HashMap<>();
    private final EntityRendererProvider.Context ctx;
    private ShipRenderTable.RenderInfo currentInfo;


    @SuppressWarnings("unchecked")
    public ShipRenderer(EntityRendererProvider.Context ctx)
    {
        super(ctx, null, 0.7F);
        this.ctx = ctx;
        this.addLayer(new ShipHeldItemLayer(this, ctx.getItemInHandRenderer()));
    }

    @SuppressWarnings("unchecked")
    private EntityModel<Mob> modelFor(int shipClass)
    {
        return this.models.computeIfAbsent(shipClass, c ->
        {
            ModelPart baked = this.ctx.getModelSet().bakeLayer(ShipRenderTable.ship(c).layer);
            return (EntityModel<Mob>) ShipRenderTable.ship(c).factory.apply(baked);
        });
    }

    /** ship class id for either ship hierarchy (friendly or hostile) */
    private static int shipClassOf(Mob e)
    {
        if (e instanceof BasicEntityShip s) return s.getShipClassID();
        if (e instanceof BasicEntityShipHostile s) return s.getShipClassID();
        return 0;
    }

    @Override
    public void render(Mob entity, float yaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight)
    {
        int cls = shipClassOf(entity);
        this.currentInfo = ShipRenderTable.ship(cls);
        this.model = modelFor(cls);
        this.shadowRadius = this.currentInfo.shadow
            + ((IShipEmotion) entity).getScaleLevel() * 0.4F;

        initMiscModel(entity);

        // inventory previews keep their tuned modelPosInGUI placement; skip grounding
        if (ShipModel.inGuiPreview)
        {
            super.render(entity, yaw, partialTick, poseStack, buffer, packedLight);
            renderMiscModels(entity, partialTick, poseStack, buffer, packedLight);
            return;
        }

        // Ground the model by measuring the real lowest rendered vertex and feeding the
        // residual gap into ShipModel.GROUND_SHIFT (applied to animTrans in beginRender).
        // Vertex positions reach us in render (camera) space, so "down" is measured along
        // the world-up axis transformed into that space -- this stays correct even when
        // the camera is pitched, unlike a raw camera-space Y comparison.
        Vector3f up = poseStack.last().normal().transform(new Vector3f(0F, 1F, 0F));
        if (up.lengthSquared() > 0F) up.normalize();
        Vector3f feetPos = poseStack.last().pose().transformPosition(0F, 0F, 0F, new Vector3f());
        float feetProj = feetPos.dot(up);

        MinYTracker tracker = new MinYTracker(up);
        MultiBufferSource wrapped = type -> tracker.wrap(buffer.getBuffer(type));

        super.render(entity, yaw, partialTick, poseStack, wrapped, packedLight);

        if (tracker.minDot != Float.POSITIVE_INFINITY)
        {
            float shift = ShipModel.GROUND_SHIFT.getOrDefault(entity.getId(), 0F);
            float residual = tracker.minDot - feetProj;         // >0 floats, <0 over-corrected
            float next = Mth.clamp(shift + residual, 0F, 8F);   // push down only, sane bound
            ShipModel.GROUND_SHIFT.put(entity.getId(), next);
        }

        renderMiscModels(entity, partialTick, poseStack, buffer, packedLight);
    }

    /** records the lowest rendered vertex along the world-up axis (world height) */
    private static final class MinYTracker
    {
        final float ux, uy, uz;
        float minDot = Float.POSITIVE_INFINITY;

        MinYTracker(Vector3f up) { this.ux = up.x; this.uy = up.y; this.uz = up.z; }

        VertexConsumer wrap(VertexConsumer delegate)
        {
            return new VertexConsumer()
            {
                @Override public VertexConsumer addVertex(float x, float y, float z)
                {
                    float d = x * ux + y * uy + z * uz;
                    if (d < minDot) minDot = d;
                    return delegate.addVertex(x, y, z);
                }
                @Override public VertexConsumer setColor(int r, int g, int b, int a) { return delegate.setColor(r, g, b, a); }
                @Override public VertexConsumer setUv(float u, float v) { return delegate.setUv(u, v); }
                @Override public VertexConsumer setUv1(int u, int v) { return delegate.setUv1(u, v); }
                @Override public VertexConsumer setUv2(int u, int v) { return delegate.setUv2(u, v); }
                @Override public VertexConsumer setNormal(float x, float y, float z) { return delegate.setNormal(x, y, z); }
            };
        }
    }

    /** attach misc model list (e.g. MidwayHime takoyaki plane) once per model instance */
    private void initMiscModel(Mob entity)
    {
        if (!(this.model instanceof ShipModel<?> sm) || sm.miscModelList != null) return;

        if (shipClassOf(entity) == ID.ShipClass.MidwayHime && Minecraft.getInstance().level != null)
        {
            EntityAirplaneTakoyaki tako = new EntityAirplaneTakoyaki(
                ModEntities.AIRPLANE_TAKOYAKI.get(), Minecraft.getInstance().level);
            tako.setPosRaw(0D, 0D, 0D);
            MiscModel m1 = new MiscModel(tako,
                new com.lulan.shincolle.client.model.ModelTakoyaki<>(
                    this.ctx.getModelSet().bakeLayer(ModModelLayers.MODELTAKOYAKI)),
                ShipRenderTable.misc(ID.ShipMisc.AirplaneTako).texture);
            m1.scale = new net.minecraft.world.phys.Vec3(0.65D, 0.65D, 0.65D);
            m1.rotX = -30F;
            m1.posX = 0F;
            m1.posY = 0.34F;
            m1.posZ = -0.18F;
            sm.miscModelList = new ArrayList<>();
            sm.miscModelList.add(m1);
        }
    }

    /** render attached misc models (takoyaki etc.) */
    @SuppressWarnings("unchecked")
    private void renderMiscModels(Mob host, float partialTick, PoseStack poseStack,
                                  MultiBufferSource buffer, int packedLight)
    {
        if (!(this.model instanceof ShipModel<?> sm) || sm.miscModelList == null) return;

        for (int i = 0; i < sm.miscModelList.size(); i++)
        {
            MiscModel mm = sm.miscModelList.get(i);
            if (mm == null || mm.entity == null || mm.texture == null) continue;
            if (this.model instanceof com.lulan.shincolle.client.model.ShipModelBaseAdv<?> adv
                && !adv.shouldRenderMiscModel(i)) continue;

            poseStack.pushPose();
            poseStack.translate(mm.posX, mm.posY, mm.posZ);
            poseStack.scale((float) mm.scale.x, (float) mm.scale.y, (float) mm.scale.z);
            poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(mm.rotX));
            poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(mm.rotY));
            poseStack.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(mm.rotZ));

            EntityModel<Entity> m = (EntityModel<Entity>) mm.model;
            m.attackTime = host.getAttackAnim(partialTick);
            m.riding = host.isPassenger();
            m.young = host.isBaby();
            m.setupAnim(mm.entity,
                host.walkAnimation.position(partialTick),
                host.walkAnimation.speed(partialTick),
                host.tickCount + partialTick, 0F, 0F);
            var vc = buffer.getBuffer(RenderType.entityCutoutNoCull(mm.texture));
            m.renderToBuffer(poseStack, vc, packedLight, net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY, -1);
            poseStack.popPose();
        }
    }

    @Override
    public ResourceLocation getTextureLocation(Mob entity)
    {
        return ShipRenderTable.ship(shipClassOf(entity)).texture;
    }

    /** legacy: no body flip on death */
    @Override
    protected float getFlipDegrees(Mob entity)
    {
        return 0F;
    }

    /** scale level affects model size via animScale inside models; nothing extra here */
    @Override
    protected void scale(Mob entity, PoseStack poseStack, float partialTick)
    {
    }


}

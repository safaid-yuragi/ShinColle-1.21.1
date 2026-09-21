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
            float groundDot = tracker.groundDot();              // effective bottom (skips thin spikes)
            float residual = groundDot - feetProj;              // >0 floats, <0 over-corrected
            float next = Mth.clamp(shift + residual, 0F, 8F);   // push down only, sane bound
            ShipModel.GROUND_SHIFT.put(entity.getId(), next);
        }

        renderMiscModels(entity, partialTick, poseStack, buffer, packedLight);
    }

    /** records rendered vertices so we can find the model's effective bottom */
    private static final class MinYTracker
    {
        final Vector3f up;
        float minDot = Float.POSITIVE_INFINITY;
        final java.util.ArrayList<Vector3f> verts = new java.util.ArrayList<>();

        MinYTracker(Vector3f up) { this.up = new Vector3f(up); }

        /**
         * The model's effective ground-contact height along the world-up axis.
         * A plain minimum would grab a thin keel/leg/antenna spike and leave the
         * visible hull floating, so instead we walk up from the lowest vertex and
         * stop where the accumulated geometry first has real extent in BOTH
         * horizontal axes -- i.e. a surface/foot, not a protruding line.  A spread
         * pair of feet reads as wide immediately, so feet still contact the ground.
         */
        float groundDot()
        {
            if (verts.isEmpty()) return Float.POSITIVE_INFINITY;

            // horizontal axes perpendicular to up
            Vector3f h1 = new Vector3f(up).cross(new Vector3f(0F, 0F, 1F));
            if (h1.lengthSquared() < 1E-4F) h1 = new Vector3f(up).cross(new Vector3f(1F, 0F, 0F));
            h1.normalize();
            Vector3f h2 = new Vector3f(up).cross(h1);

            int n = verts.size();
            float[][] r = new float[n][3];              // {height, h1, h2}
            for (int i = 0; i < n; i++)
            {
                Vector3f v = verts.get(i);
                r[i][0] = v.dot(up); r[i][1] = v.dot(h1); r[i][2] = v.dot(h2);
            }
            java.util.Arrays.sort(r, java.util.Comparator.comparingDouble(a -> a[0]));

            // model's full horizontal extent, to scale the "thin" threshold
            float a1 = 1e9F, b1 = -1e9F, a2 = 1e9F, b2 = -1e9F;
            for (float[] p : r) { a1=Math.min(a1,p[1]); b1=Math.max(b1,p[1]); a2=Math.min(a2,p[2]); b2=Math.max(b2,p[2]); }
            float maxExtent = Math.max(b1 - a1, b2 - a2);

            // lowest level where the narrow-axis extent is a real surface, not a spike.
            // Capped at 0.18 so a standing model's feet (~0.2 wide) are never skipped.
            float thr = Math.max(0.12F, Math.min(0.18F, 0.10F * maxExtent));
            float c1 = 1e9F, d1 = -1e9F, c2 = 1e9F, d2 = -1e9F;
            for (float[] p : r)
            {
                c1 = Math.min(c1, p[1]); d1 = Math.max(d1, p[1]);
                c2 = Math.min(c2, p[2]); d2 = Math.max(d2, p[2]);
                if (Math.min(d1 - c1, d2 - c2) >= thr) return p[0];
            }
            return r[0][0];
        }

        VertexConsumer wrap(VertexConsumer delegate)
        {
            return new VertexConsumer()
            {
                @Override public VertexConsumer addVertex(float x, float y, float z)
                {
                    float d = x * up.x + y * up.y + z * up.z;
                    verts.add(new Vector3f(x, y, z));
                    if (d < minDot) { minDot = d; }
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

package com.lulan.shincolle.client.model;

import java.util.ArrayList;

import org.joml.Quaternionf;
import org.joml.Vector3f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import com.lulan.shincolle.entity.IShipEmotion;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;

/**
 * shared model base for all shincolle models.
 * holds common display parms and helpers used by generated model code.
 */
public abstract class ShipModel<T extends Entity> extends EntityModel<T>
{

    /** entity currently being rendered, captured in prepareMobModel */
    public Entity entity;

    /** basic parms */
    public float scale = 1F;
    public float offsetY = 0F;
    public float offsetX = 0F;
    public float offsetZ = 0F;
    public float yaw = 0F;
    public float pitch = 0F;

    /** held item rendering */
    public float[] offsetItem = new float[] {0F, 0F, 0F};
    public float[] rotateItem = new float[] {0F, 0F, 0F};
    public float[] offsetBlock = new float[] {0F, 0F, 0F};
    public float[] rotateBlock = new float[] {0F, 0F, 0F};
    public float[] offsetItem2 = new float[] {0F, 0F, 0F};
    public float[] rotateItem2 = new float[] {0F, 0F, 0F};
    public float[] offsetBlock2 = new float[] {0F, 0F, 0F};
    public ModelPart[] armMain;
    public ModelPart[] armOff;

    /** misc sub-models rendered with the main model */
    public ArrayList<MiscModel> miscModelList;
    public boolean renderTako = false;

    /** glow flag: parts rendered while this is true use fullbright lightmap */
    public boolean glowLight = false;

    /** captured setupAnim parms for use in renderToBuffer */
    public float animLimbSwing, animLimbSwingAmount, animAgeInTicks, animNetHeadYaw, animHeadPitch;

    /** accumulated animation-space transform (legacy GL calls inside pose methods) */
    public float animTransX, animTransY, animTransZ;
    public float animScaleX = 1F, animScaleY = 1F, animScaleZ = 1F;
    public Quaternionf animRot = new Quaternionf();

    /** baked model root, set by ShipRenderer for ground measurement */
    public ModelPart modelRoot;


    public ShipModel() {}

    /** called at top of generated setupAnim */
    public void captureAnimParms(T entity, float f, float f1, float f2, float f3, float f4)
    {
        this.entity = entity;
        this.animLimbSwing = f;
        this.animLimbSwingAmount = f1;
        this.animAgeInTicks = f2;
        this.animNetHeadYaw = f3;
        this.animHeadPitch = f4;
        this.animTransX = this.animTransY = this.animTransZ = 0F;
        this.animScaleX = this.animScaleY = this.animScaleZ = 1F;
        this.animRot.identity();
    }

    /** entity-foot baseline used by LivingEntityRenderer (blocks below origin) */
    private static final float GROUND_BASE = 1.501F;

    /** true while an inventory screen renders a model preview; skips grounding so
     *  the per-ship modelPosInGUI placement is not disturbed */
    public static boolean inGuiPreview = false;

    /** called at top of generated renderToBuffer: apply anim transform + locals */
    public float[] beginRender()
    {
        this.glowLight = false;
        this.groundToBaseline();
        return new float[] {this.animLimbSwing, this.animLimbSwingAmount,
                            this.animAgeInTicks, this.animNetHeadYaw, this.animHeadPitch};
    }

    /**
     * Push the model down so its lowest rendered point meets the entity's feet.
     * LivingEntityRenderer anchors the model origin 1.501 blocks above the feet;
     * a model whose scaled reach (animScale * lowest geometry) falls short of that
     * floats in mid-air.  Computed per-frame from the live pose so standing /
     * dead / sitting poses all ground correctly.  Only ever pushes DOWN, so a
     * model that already reaches the baseline is left untouched, and repeated
     * calls within a frame are self-idempotent (the gap converges to ~0).
     */
    private void groundToBaseline()
    {
        if (inGuiPreview || this.modelRoot == null || this.animScaleY == 0F) return;

        // lowest rendered point (down-positive): renderedY = animScale * (animRot * (v + animTrans)).y
        final Quaternionf rot = this.animRot;
        final float[] maxRotY = {Float.NEGATIVE_INFINITY};
        final Vector3f tv = new Vector3f();
        this.modelRoot.visit(new PoseStack(), (pose, path, index, cube) ->
        {
            for (int c = 0; c < 8; c++)
            {
                float cx = ((c & 1) == 0 ? cube.minX : cube.maxX) / 16F;
                float cy = ((c & 2) == 0 ? cube.minY : cube.maxY) / 16F;
                float cz = ((c & 4) == 0 ? cube.minZ : cube.maxZ) / 16F;
                pose.pose().transformPosition(cx, cy, cz, tv);
                tv.rotate(rot);
                if (tv.y > maxRotY[0]) maxRotY[0] = tv.y;
            }
        });
        if (maxRotY[0] == Float.NEGATIVE_INFINITY) return;

        // rotate the accumulated translate into rendered space
        float transDownY = new Vector3f(this.animTransX, this.animTransY, this.animTransZ)
            .rotate(rot).y;
        float gap = GROUND_BASE - this.animScaleY * (maxRotY[0] + transDownY);
        if (gap <= 1.0E-4F) return;

        // shift down by exactly the gap, expressed back in pre-rotation translate space
        Vector3f d = new Vector3f(0F, gap / this.animScaleY, 0F)
            .rotate(new Quaternionf(rot).conjugate());
        this.animTransX += d.x;
        this.animTransY += d.y;
        this.animTransZ += d.z;
    }

    /** capture entity for use in renderToBuffer (which has no entity parm) */
    @Override
    public void prepareMobModel(T entity, float limbSwing, float limbSwingAmount, float partialTick)
    {
        this.entity = entity;
    }

    /** render a part list, honoring glow flag */
    public void renderParts(ModelPart[] parts, PoseStack poseStack, VertexConsumer buf, int packedLight, int packedOverlay)
    {
        if (parts == null) return;

        int light = this.glowLight ? LightTexture.FULL_BRIGHT : packedLight;

        for (ModelPart part : parts)
        {
            if (part != null) part.render(poseStack, buf, light, packedOverlay);
        }
    }

    /** legacy ModelBase.setRotateAngle */
    public void setRotateAngle(ModelPart model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    /** alias used by some legacy models */
    public void setRotation(ModelPart model, float x, float y, float z)
    {
        this.setRotateAngle(model, x, y, z);
    }

    /** get arm part chain for held item rendering: [shoulder, elbow, hand] */
    public ModelPart[] getArmForSide(HumanoidArm side)
    {
        return side == HumanoidArm.RIGHT ? this.armMain : this.armOff;
    }

    public float[] getHeldItemOffset(IShipEmotion ent, HumanoidArm side, int type)
    {
        return type == 0 ? this.offsetItem : this.offsetBlock;
    }

    public float[] getHeldItemRotate(IShipEmotion ent, HumanoidArm side, int type)
    {
        return type == 0 ? this.rotateItem : this.rotateBlock;
    }

    public float getOffsetY()
    {
        return this.offsetY;
    }

    public float getScale()
    {
        return this.scale;
    }

    public boolean shouldRenderMiscModel(int miscID)
    {
        return false;
    }


}

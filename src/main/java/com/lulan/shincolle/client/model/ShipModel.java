package com.lulan.shincolle.client.model;

import java.util.ArrayList;

import org.joml.Quaternionf;

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

    /** called at top of generated renderToBuffer: apply anim transform + locals */
    public float[] beginRender()
    {
        this.glowLight = false;
        return new float[] {this.animLimbSwing, this.animLimbSwingAmount,
                            this.animAgeInTicks, this.animNetHeadYaw, this.animHeadPitch};
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

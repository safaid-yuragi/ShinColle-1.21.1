package com.lulan.shincolle.client.model;

import java.util.ArrayList;
import java.util.Random;

import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntityShipCV;
import com.lulan.shincolle.entity.BasicEntityShipHostile;
import com.lulan.shincolle.entity.BasicEntitySummon;
import com.lulan.shincolle.entity.IFloatingEntity;
import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.entity.IShipRiderType;
import com.lulan.shincolle.entity.IShipState;
import com.lulan.shincolle.entity.EntityDestroyerAkatsuki;
import com.lulan.shincolle.entity.EntityDestroyerInazuma;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Values;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.EmotionHelper;
import com.lulan.shincolle.utility.RenderHelper;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class ModelBlockDesk<T extends Entity> extends ShipModel<T>
{

	public ModelPart shape1;
	public ModelPart shape2;
	public ModelPart shape3;
	public ModelPart shape4;
	public ModelPart shape6;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("shape3", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 15.0F, 15.0F), PartPose.offset(-8.0F, 9.0F, -8.0F));
		PartDefinition partdef1 = partdefinition.addOrReplaceChild("shape6", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 1.0F, 16.0F), PartPose.offset(-8.0F, 8.0F, -8.0F));
		PartDefinition partdef2 = partdefinition.addOrReplaceChild("shape1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 14.0F, 6.0F, 1.0F), PartPose.offset(-7.0F, 9.0F, -8.0F));
		PartDefinition partdef3 = partdefinition.addOrReplaceChild("shape2", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 15.0F, 1.0F), PartPose.offset(-8.0F, 9.0F, 7.0F));
		PartDefinition partdef4 = partdefinition.addOrReplaceChild("shape4", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 15.0F, 15.0F), PartPose.offset(7.0F, 9.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public ModelBlockDesk(ModelPart root)
	{
		this.shape3 = root.getChild("shape3");
		this.shape6 = root.getChild("shape6");
		this.shape1 = root.getChild("shape1");
		this.shape2 = root.getChild("shape2");
		this.shape4 = root.getChild("shape4");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color)
	{
		Entity entity = this.entity;
		float[] _a = this.beginRender();
		float f = _a[0], f1 = _a[1], f2 = _a[2], f3 = _a[3], f4 = _a[4];
		poseStack.translate(this.animTransX, this.animTransY, this.animTransZ);
		poseStack.mulPose(this.animRot);
		poseStack.scale(this.animScaleX, this.animScaleY, this.animScaleZ);
 
        this.shape3.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
        this.shape6.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
        this.shape1.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
        this.shape2.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
        this.shape4.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    
	}

	public void renderModel(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay)
	{

    	this.shape3.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
        this.shape6.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
        this.shape1.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
        this.shape2.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
        this.shape4.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    
	}

	/** * This is a helper function from Tabula to set the rotation of model parts */ public void setRotateAngle(ModelPart modelRenderer, float x, float y, float z)
	{

        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    
	}

	@Override
	public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)
	{
		this.captureAnimParms(entity, f, f1, f2, f3, f4);
	}

}

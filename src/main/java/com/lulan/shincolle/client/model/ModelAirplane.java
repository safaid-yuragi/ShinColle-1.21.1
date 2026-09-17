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

public class ModelAirplane<T extends Entity> extends ShipModel<T>
{

	public ModelPart BodyMain;
	public ModelPart EyeL;
	public ModelPart EyeR;
	public ModelPart AirfoilL;
	public ModelPart AirfoilR;
	public ModelPart Head;
	public ModelPart BodyFront;
	public ModelPart Tail;
	public ModelPart Tongue;
	public ModelPart BombL;
	public ModelPart BombR;
	public ModelPart GunBase;
	public ModelPart Gun;
	public ModelPart GlowBodyMain;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-3.0F, -3.0F, -1.0F, 6.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -6.2F, 0.0F, 0.7853981633974483F, 0.0F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("BombR", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(-6.0F, 2.3F, -1.0F, 0.0F, 0.0F, 0.7853981633974483F));
		PartDefinition partdef3 = partdef0.addOrReplaceChild("AirfoilL", CubeListBuilder.create().addBox(-2.5F, -2.0F, -6.0F, 5.0F, 4.0F, 11.0F), PartPose.offsetAndRotation(3.5F, 0.0F, 0.0F, 0.0F, 0.5235987755982988F, 0.12217304763960307F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("AirfoilR", CubeListBuilder.create().addBox(-2.5F, -2.0F, -6.0F, 5.0F, 4.0F, 11.0F), PartPose.offsetAndRotation(-3.5F, 0.0F, 0.0F, 0.0F, -0.5235987755982988F, -0.12217304763960307F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("BombL", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(6.0F, 2.3F, -1.0F, 0.0F, 0.0F, 0.7853981633974483F));
		PartDefinition partdef6 = partdef0.addOrReplaceChild("GunBase", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 3.0F), PartPose.offset(0.0F, 4.0F, 2.5F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("Gun", CubeListBuilder.create().addBox(-0.5F, 0.0F, -8.0F, 1.0F, 1.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef8 = partdef0.addOrReplaceChild("Tail", CubeListBuilder.create().addBox(-4.0F, -2.5F, -4.0F, 8.0F, 5.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 4.3F, 0.0F, 0.7853981633974483F, 0.0F));
		PartDefinition partdef9 = partdef0.addOrReplaceChild("BodyFront", CubeListBuilder.create().addBox(-2.5F, -2.6F, -2.5F, 5.0F, 6.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -3.2F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef0.addOrReplaceChild("Tongue", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 2.3F, -3.5F, 1.6580627893946132F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("EyeL", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(3.7F, -3.2F, 2.0F, 0.0F, 0.7853981633974483F, 0.17453292519943295F));
		PartDefinition partdef13 = partdef11.addOrReplaceChild("EyeR", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-3.7F, -3.2F, 2.0F, 0.0F, -2.356194490192345F, -0.17453292519943295F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	public ModelAirplane(ModelPart root)
	{
		this.Head = root.getChild("BodyMain").getChild("Head");
		this.BodyMain = root.getChild("BodyMain");
		this.BombR = root.getChild("BodyMain").getChild("BombR");
		this.AirfoilL = root.getChild("BodyMain").getChild("AirfoilL");
		this.AirfoilR = root.getChild("BodyMain").getChild("AirfoilR");
		this.BombL = root.getChild("BodyMain").getChild("BombL");
		this.EyeL = root.getChild("GlowBodyMain").getChild("EyeL");
		this.EyeR = root.getChild("GlowBodyMain").getChild("EyeR");
		this.GunBase = root.getChild("BodyMain").getChild("GunBase");
		this.Tail = root.getChild("BodyMain").getChild("Tail");
		this.BodyFront = root.getChild("BodyMain").getChild("BodyFront");
		this.Tongue = root.getChild("BodyMain").getChild("Tongue");
		this.Gun = root.getChild("BodyMain").getChild("GunBase").getChild("Gun");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color)
	{
		Entity entity = this.entity;
		float[] _a = this.beginRender();
		float f = _a[0], f1 = _a[1], f2 = _a[2], f3 = _a[3], f4 = _a[4];
		poseStack.pushPose();
		poseStack.translate(this.animTransX, this.animTransY, this.animTransZ);
		poseStack.mulPose(this.animRot);
		poseStack.scale(this.animScaleX, this.animScaleY, this.animScaleZ);
    	
    	poseStack.scale(0.5F, 0.5F, 0.5F);
    	poseStack.translate(0F, 2.5F, 0F);
    	
    	//main body
    	this.BodyMain.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
    	
    	//light part
		glowLight = true;
    	this.GlowBodyMain.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
    	poseStack.popPose();
    
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
 
    	
    	
  
    	this.BodyMain.yRot = f3 / 57F;	//左右角度
    	this.BodyMain.xRot = f4 / 57F; 	//上下角度
    	this.GlowBodyMain.yRot = f3 / 57F;
    	this.GlowBodyMain.xRot = f4 / 57F;
    
	}

}

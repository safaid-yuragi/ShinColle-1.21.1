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

public class ModelFloatingFort<T extends Entity> extends ShipModel<T>
{

	public ModelPart BodyMain;
	public ModelPart Body1;
	public ModelPart Body2;
	public ModelPart Body3;
	public ModelPart EarL;
	public ModelPart EarR;
	public ModelPart JawMain;
	public ModelPart Jaw1;
	public ModelPart Jaw2;
	public ModelPart Jaw3;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -6.4F, -6.5F, 13.0F, 8.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.22759093446006054F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Body1", CubeListBuilder.create().addBox(-5.0F, -4.3F, -8.0F, 10.0F, 6.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("Body3", CubeListBuilder.create().addBox(-8.0F, -5.0F, -5.0F, 16.0F, 7.0F, 10.0F), PartPose.offset(0.0F, -0.5F, 0.0F));
		PartDefinition partdef3 = partdef0.addOrReplaceChild("JawMain", CubeListBuilder.create().addBox(-6.0F, -1.1F, -11.5F, 12.0F, 5.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 2.8F, 6.0F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("Jaw2", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 4.0F, 9.0F), PartPose.offset(0.0F, -1.0F, -10.0F));
		PartDefinition partdef5 = partdef3.addOrReplaceChild("Jaw3", CubeListBuilder.create().addBox(-5.0F, 4.0F, 0.0F, 10.0F, 1.0F, 9.0F), PartPose.offset(0.0F, -0.1F, -9.5F));
		PartDefinition partdef6 = partdef3.addOrReplaceChild("Jaw1", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 4.0F, 15.0F), PartPose.offset(0.0F, -1.2F, -13.0F));
		PartDefinition partdef7 = partdef0.addOrReplaceChild("Body2", CubeListBuilder.create().addBox(-5.0F, -8.5F, -4.5F, 10.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.01361356816555577F));
		PartDefinition partdef8 = partdef0.addOrReplaceChild("EarR", CubeListBuilder.create().addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(-5.0F, -5.5F, 0.7F, -0.17453292519943295F, -0.7853981633974483F, -0.08726646259971647F));
		PartDefinition partdef9 = partdef0.addOrReplaceChild("EarL", CubeListBuilder.create().mirror().addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(5.0F, -5.5F, 0.7F, -0.17453292519943295F, 0.7853981633974483F, 0.08726646259971647F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	public ModelFloatingFort(ModelPart root)
	{
		this.Jaw2 = root.getChild("BodyMain").getChild("JawMain").getChild("Jaw2");
		this.BodyMain = root.getChild("BodyMain");
		this.Body1 = root.getChild("BodyMain").getChild("Body1");
		this.Jaw3 = root.getChild("BodyMain").getChild("JawMain").getChild("Jaw3");
		this.Body3 = root.getChild("BodyMain").getChild("Body3");
		this.JawMain = root.getChild("BodyMain").getChild("JawMain");
		this.Body2 = root.getChild("BodyMain").getChild("Body2");
		this.EarR = root.getChild("BodyMain").getChild("EarR");
		this.Jaw1 = root.getChild("BodyMain").getChild("JawMain").getChild("Jaw1");
		this.EarL = root.getChild("BodyMain").getChild("EarL");
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
    	
    	poseStack.scale(0.3F, 0.3F, 0.3F);
    	poseStack.translate(0F, 4.2F, 0F);
    	
    	//main body
    	this.BodyMain.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
    	poseStack.popPose();
    
	}

	@Override
	public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)
	{
		this.captureAnimParms(entity, f, f1, f2, f3, f4);

    	
    	
  
    	this.BodyMain.yRot = f3 * 0.0174533F;	//左右角度
    	this.BodyMain.xRot = f4 * 0.0174533F; 	//上下角度
    	this.JawMain.zRot = 0F;
    	this.JawMain.xRot = Mth.cos(f2) * 0.25F + 0.375F;
    
	}

}

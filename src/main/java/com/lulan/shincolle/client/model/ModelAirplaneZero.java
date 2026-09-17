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

public class ModelAirplaneZero<T extends Entity> extends ShipModel<T>
{

	public ModelPart BodyMain;
	public ModelPart Tail01;
	public ModelPart Wing01;
	public ModelPart Wing02;
	public ModelPart BodyU;
	public ModelPart Propeller;
	public ModelPart Prop02;
	public ModelPart Tank;
	public ModelPart Tail02;
	public ModelPart Tail03;
	public ModelPart Tail04;
	public ModelPart GlowBodyMain;
	private float scale;
	private float offsetY;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-2.0F, -3.0F, -6.0F, 4.0F, 4.0F, 11.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Propeller", CubeListBuilder.create().addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F), PartPose.offset(0.0F, -1.0F, -6.5F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("Wing02", CubeListBuilder.create().addBox(-13.0F, 0.0F, 0.0F, 13.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -0.4F, -3.2F, 0.0F, 0.0F, 0.06981317007977318F));
		PartDefinition partdef3 = partdef0.addOrReplaceChild("Prop02", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -1.0F, -7.5F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("Tail01", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 4.0F), PartPose.offset(0.0F, -2.8F, 5.0F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("Tail02", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 6.0F), PartPose.offset(0.0F, 0.1F, 4.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("Tail03", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -2.2F, 4.5F, -1.0471975511965976F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef5.addOrReplaceChild("Tail04", CubeListBuilder.create().addBox(-6.5F, 0.0F, 0.0F, 13.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.2F, 2.0F));
		PartDefinition partdef8 = partdef0.addOrReplaceChild("Wing01", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 13.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -0.4F, -3.2F, 0.0F, 0.0F, -0.06981317007977318F));
		PartDefinition partdef9 = partdef0.addOrReplaceChild("BodyU", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -4.9F, -1.8F, -0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef0.addOrReplaceChild("Tank", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(0.0F, 0.5F, -3.0F));
		PartDefinition partdef11 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("BodyU", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -4.9F, -1.8F, -0.3141592653589793F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	public ModelAirplaneZero(ModelPart root)
	{
		this.BodyMain = root.getChild("BodyMain");
		this.Tail03 = root.getChild("BodyMain").getChild("Tail01").getChild("Tail02").getChild("Tail03");
		this.Propeller = root.getChild("BodyMain").getChild("Propeller");
		this.Wing02 = root.getChild("BodyMain").getChild("Wing02");
		this.Prop02 = root.getChild("BodyMain").getChild("Prop02");
		this.Tail04 = root.getChild("BodyMain").getChild("Tail01").getChild("Tail02").getChild("Tail04");
		this.Tail01 = root.getChild("BodyMain").getChild("Tail01");
		this.Wing01 = root.getChild("BodyMain").getChild("Wing01");
		this.Tail02 = root.getChild("BodyMain").getChild("Tail01").getChild("Tail02");
		this.BodyU = root.getChild("GlowBodyMain").getChild("BodyU");
		this.Tank = root.getChild("BodyMain").getChild("Tank");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
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
        	this.BodyMain.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
        	
        	
        	//light part
		glowLight = true;
        	this.GlowBodyMain.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
        	
        	poseStack.popPose();
    
	}

	@Override
	public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)
	{
		this.captureAnimParms(entity, f, f1, f2, f3, f4);

    	//FIX: head rotation bug while riding
    	if (f3 <= -180F) { f3 += 360F; }
    	else if (f3 >= 180F) { f3 -= 360F; }
    	
    	switch (((IShipEmotion)entity).getScaleLevel())
    	{
    	case 3:
    		scale = 1.6F;
        	offsetY = 0.37F;
		break;
    	case 2:
    		scale = 1.2F;
        	offsetY = 0.68F;
		break;
    	case 1:
    		scale = 0.8F;
        	offsetY = 1.32F;
		break;
    	default:
    		scale = 0.4F;
        	offsetY = 3.22F;
		break;
    	}
    	
    	if (entity.tickCount > 6)
    	{
        	
        	RenderHelper.animScale(this, scale, scale, scale);
this.animTransX += (0F); this.animTransY += (offsetY); this.animTransZ += (0F);
        	
        	//main body
	}

    	this.BodyMain.yRot = f3 / 57F;	//左右角度
    	this.BodyMain.xRot = f4 / 57F; 	//上下角度
    	this.GlowBodyMain.yRot = this.BodyMain.yRot;
    	this.GlowBodyMain.xRot = this.BodyMain.xRot;
    
	}

}

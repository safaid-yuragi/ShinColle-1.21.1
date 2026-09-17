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

public class ModelMountSuH<T extends Entity> extends ShipModel<T> implements IModelEmotion
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart Head01;
	public ModelPart Jaw;
	public ModelPart NeckFront;
	public ModelPart Body01;
	public ModelPart Head02;
	public ModelPart Head03;
	public ModelPart Head04;
	public ModelPart Head05;
	public ModelPart Head06;
	public ModelPart Head07a;
	public ModelPart HeadTooth;
	public ModelPart Eye01a;
	public ModelPart Eye01b;
	public ModelPart Eye02a;
	public ModelPart Eye02b;
	public ModelPart Eye03a;
	public ModelPart Eye03b;
	public ModelPart JawTooth;
	public ModelPart Jaw02;
	public ModelPart Body02;
	public ModelPart Body01a;
	public ModelPart Body02a;
	public ModelPart Body02b;
	public ModelPart Body03;
	public ModelPart Body03a;
	public ModelPart Body03b;
	public ModelPart Body04;
	public ModelPart Body04a;
	public ModelPart Body04b;
	public ModelPart Bridge02;
	public ModelPart Bridge01;
	public ModelPart Head07b;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ModelPart GlowJaw;
	public ModelPart GlowHead01;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, 10.0F, 8.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-7.0F, -7.5F, -14.0F, 14.0F, 15.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("Head04", CubeListBuilder.create().addBox(-9.5F, 0.0F, 0.0F, 19.0F, 8.0F, 12.0F), PartPose.offset(0.0F, -23.9F, -29.9F));
		PartDefinition partdef3 = partdef1.addOrReplaceChild("Head06", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 6.0F, 11.0F), PartPose.offset(0.0F, -12.1F, -40.8F));
		PartDefinition partdef4 = partdef1.addOrReplaceChild("Head02", CubeListBuilder.create().addBox(-9.5F, 0.0F, 0.0F, 19.0F, 10.0F, 12.0F), PartPose.offset(0.0F, -16.0F, -29.9F));
		PartDefinition partdef5 = partdef1.addOrReplaceChild("Head07a", CubeListBuilder.create().addBox(-6.0F, 0.0F, -6.0F, 12.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -23.8F, -41.7F, 0.0F, 0.7853981633974483F, 0.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("Head07b", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 10.0F, 12.0F, 10.0F), PartPose.offset(-0.7F, 5.5F, 0.7F));
		PartDefinition partdef7 = partdef1.addOrReplaceChild("Head03", CubeListBuilder.create().addBox(-9.5F, 0.0F, 0.0F, 19.0F, 8.0F, 12.0F), PartPose.offset(0.0F, -23.9F, -18.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("Bridge01", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 12.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.1F, 0.0F, 1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef1.addOrReplaceChild("Head05", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 12.0F, 12.0F), PartPose.offset(0.0F, -24.0F, -41.8F));
		PartDefinition partdef10 = partdef1.addOrReplaceChild("Jaw", CubeListBuilder.create().addBox(-7.5F, 0.0F, -16.0F, 15.0F, 7.0F, 16.0F), PartPose.offsetAndRotation(0.0F, 2.0F, -11.6F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("Jaw02", CubeListBuilder.create().addBox(-5.5F, 0.0F, -5.5F, 11.0F, 5.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 0.8F, -14.8F, -0.33161255787892263F, 0.7853981633974483F, -0.2408554367752175F));
		PartDefinition partdef12 = partdef1.addOrReplaceChild("Body01", CubeListBuilder.create().addBox(-8.5F, -12.0F, 0.0F, 17.0F, 12.0F, 12.0F), PartPose.offset(0.0F, -3.0F, -8.3F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("Body01a", CubeListBuilder.create().addBox(-7.0F, 0.0F, 0.0F, 14.0F, 9.0F, 11.0F), PartPose.offset(0.0F, -20.7F, 0.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("Bridge02", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 10.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.1F, 0.0F, 1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef12.addOrReplaceChild("Body02", CubeListBuilder.create().addBox(-7.0F, -15.0F, 0.0F, 14.0F, 15.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 6.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("Body03", CubeListBuilder.create().addBox(-8.0F, -10.0F, 0.0F, 16.0F, 10.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 8.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("Body03b", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 10.0F, 12.0F), PartPose.offset(0.0F, -19.9F, -2.0F));
		PartDefinition partdef18 = partdef16.addOrReplaceChild("Body03a", CubeListBuilder.create().addBox(-6.0F, -6.0F, 0.0F, 12.0F, 6.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 4.5F, 0.4363323129985824F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef16.addOrReplaceChild("Body04", CubeListBuilder.create().addBox(-4.5F, -8.0F, 0.0F, 9.0F, 8.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 11.0F, 0.4363323129985824F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("Body04a", CubeListBuilder.create().addBox(-2.5F, -6.0F, 0.0F, 5.0F, 6.0F, 5.0F), PartPose.offset(0.0F, -1.0F, 9.5F));
		PartDefinition partdef21 = partdef19.addOrReplaceChild("Body04b", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 9.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -15.6F, 6.0F, -0.4363323129985824F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdef15.addOrReplaceChild("Body02b", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 7.0F, 12.0F), PartPose.offset(0.0F, -21.8F, -2.0F));
		PartDefinition partdef23 = partdef15.addOrReplaceChild("Body02a", CubeListBuilder.create().addBox(-6.5F, 0.0F, 0.0F, 13.0F, 7.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -2.1F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef1.addOrReplaceChild("Head01", CubeListBuilder.create().addBox(-9.5F, -7.0F, -11.0F, 19.0F, 10.0F, 12.0F), PartPose.offset(0.0F, -9.0F, -7.0F));
		PartDefinition partdef25 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, 8.0F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("GlowJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.0F, -11.6F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("JawTooth", CubeListBuilder.create().mirror().addBox(-6.5F, 0.0F, -14.0F, 13.0F, 3.0F, 14.0F), PartPose.offsetAndRotation(0.0F, -1.7F, -2.0F, -0.08726646259971647F, -0.02234021442552742F, 0.0F));
		PartDefinition partdef29 = partdef26.addOrReplaceChild("GlowHead01", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, -7.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("HeadTooth", CubeListBuilder.create().addBox(-6.5F, 0.0F, -6.5F, 13.0F, 4.0F, 15.0F), PartPose.offsetAndRotation(0.0F, 2.5F, -15.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef29.addOrReplaceChild("Eye01a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F), PartPose.offset(9.6F, -9.0F, -15.0F));
		PartDefinition partdef32 = partdef29.addOrReplaceChild("Eye01b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F), PartPose.offset(-9.6F, -9.0F, -15.0F));
		PartDefinition partdef33 = partdef29.addOrReplaceChild("Eye02a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.1F, 0.0F, 8.0F, 8.0F), PartPose.offset(9.6F, -9.0F, -15.0F));
		PartDefinition partdef34 = partdef29.addOrReplaceChild("Eye02b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F), PartPose.offset(-9.6F, -9.0F, -15.0F));
		PartDefinition partdef35 = partdef29.addOrReplaceChild("Eye03a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F), PartPose.offset(9.6F, -9.0F, -15.0F));
		PartDefinition partdef36 = partdef29.addOrReplaceChild("Eye03b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F), PartPose.offset(-9.6F, -9.0F, -15.0F));
		PartDefinition partdef37 = partdef26.addOrReplaceChild("NeckFront", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 14.0F, 2.0F), PartPose.offset(0.0F, -8.5F, -15.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	public ModelMountSuH(ModelPart root)
	{
		this.Eye03a = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead01").getChild("Eye03a");
		this.Body04a = root.getChild("BodyMain").getChild("Neck").getChild("Body01").getChild("Body02").getChild("Body03").getChild("Body04").getChild("Body04a");
		this.Head07b = root.getChild("BodyMain").getChild("Neck").getChild("Head07a").getChild("Head07b");
		this.Body01a = root.getChild("BodyMain").getChild("Neck").getChild("Body01").getChild("Body01a");
		this.Head04 = root.getChild("BodyMain").getChild("Neck").getChild("Head04");
		this.Head06 = root.getChild("BodyMain").getChild("Neck").getChild("Head06");
		this.JawTooth = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw").getChild("JawTooth");
		this.Bridge02 = root.getChild("BodyMain").getChild("Neck").getChild("Body01").getChild("Body01a").getChild("Bridge02");
		this.HeadTooth = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead01").getChild("HeadTooth");
		this.Body03 = root.getChild("BodyMain").getChild("Neck").getChild("Body01").getChild("Body02").getChild("Body03");
		this.Eye03b = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead01").getChild("Eye03b");
		this.Body03b = root.getChild("BodyMain").getChild("Neck").getChild("Body01").getChild("Body02").getChild("Body03").getChild("Body03b");
		this.Bridge01 = root.getChild("BodyMain").getChild("Neck").getChild("Head03").getChild("Bridge01");
		this.Body03a = root.getChild("BodyMain").getChild("Neck").getChild("Body01").getChild("Body02").getChild("Body03").getChild("Body03a");
		this.Body04b = root.getChild("BodyMain").getChild("Neck").getChild("Body01").getChild("Body02").getChild("Body03").getChild("Body04").getChild("Body04b");
		this.NeckFront = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("NeckFront");
		this.Head02 = root.getChild("BodyMain").getChild("Neck").getChild("Head02");
		this.Head07a = root.getChild("BodyMain").getChild("Neck").getChild("Head07a");
		this.Eye02b = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead01").getChild("Eye02b");
		this.Head03 = root.getChild("BodyMain").getChild("Neck").getChild("Head03");
		this.Eye02a = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead01").getChild("Eye02a");
		this.Head05 = root.getChild("BodyMain").getChild("Neck").getChild("Head05");
		this.Body04 = root.getChild("BodyMain").getChild("Neck").getChild("Body01").getChild("Body02").getChild("Body03").getChild("Body04");
		this.Jaw02 = root.getChild("BodyMain").getChild("Neck").getChild("Jaw").getChild("Jaw02");
		this.Jaw = root.getChild("BodyMain").getChild("Neck").getChild("Jaw");
		this.Eye01b = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead01").getChild("Eye01b");
		this.Body01 = root.getChild("BodyMain").getChild("Neck").getChild("Body01");
		this.Body02b = root.getChild("BodyMain").getChild("Neck").getChild("Body01").getChild("Body02").getChild("Body02b");
		this.Body02 = root.getChild("BodyMain").getChild("Neck").getChild("Body01").getChild("Body02");
		this.Body02a = root.getChild("BodyMain").getChild("Neck").getChild("Body01").getChild("Body02").getChild("Body02a");
		this.BodyMain = root.getChild("BodyMain");
		this.Eye01a = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead01").getChild("Eye01a");
		this.Head01 = root.getChild("BodyMain").getChild("Neck").getChild("Head01");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowJaw = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw");
		this.GlowHead01 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead01");
	}

	/** * This is a helper function from Tabula to set the rotation of model parts */ public void setRotateAngle(ModelPart modelRenderer, float x, float y, float z)
	{

        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    
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
    	
    	
    	RenderHelper.animScale(this, 0.6F, 0.6F, 0.6F);
this.animTransX += (0F); this.animTransY += (1F); this.animTransZ += (0F);
    	
    	//main body

		  
		IShipEmotion ent = (IShipEmotion)entity;
		
		EmotionHelper.rollEmotion(this, ent);
		  
		motionHumanPos(f, f1, f2, f3, f4, ent);
		
		syncRotationGlowPart();
    
	}

	private void motionHumanPos(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{
   
  		float angleX = Mth.cos(f2 * 0.08F);
  		float angleX2 = Mth.cos(-f * 0.8F + 0.7F);
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.025F + 0.025F); this.animTransZ += (0F);
    	}

	    //idle
	  	this.Jaw.xRot = angleX * 0.075F + 0.26F;
	  	this.Body04.yRot = angleX * 0.15F;
	  	
	  	//running
	  	if (ent.getIsSprinting() || f1 > 0.9F)
	  	{
	  		this.Body03.yRot = angleX2 * 0.075F;
	  		this.Body04.yRot = angleX2 * 0.15F;
	  	}
  	
	}

	public void syncRotationGlowPart()
	{

		//sync rotate
	    this.GlowJaw.xRot = this.Jaw.xRot;
	
	}

	public void setFace(int emo)
	{

   		switch (emo)
   		{
   		case 0: // O_O
   			this.Eye01a.visible = false;
   			this.Eye01b.visible = false;
   			this.Eye02a.visible = true;
   			this.Eye02b.visible = true;
   			this.Eye03a.visible = false;
   			this.Eye03b.visible = false;
   		break;
   		case 1: // -_-
   			this.Eye01a.visible = false;
   			this.Eye01b.visible = false;
   			this.Eye02a.visible = false;
   			this.Eye02b.visible = false;
   			this.Eye03a.visible = true;
   			this.Eye03b.visible = true;
   		break;
   		default:// ><
   			this.Eye01a.visible = true;
   			this.Eye01b.visible = true;
   			this.Eye02a.visible = false;
   			this.Eye02b.visible = false;
   			this.Eye03a.visible = false;
   			this.Eye03b.visible = false;
   		break;
   		}
   	
	}

	public void showEquip(IShipEmotion ent)
	{

	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

	
	}

	public int getFieldCount()
	{

		return 0;
	
	}

	public void setField(int id, float value)
	{

	
	}

	public float getField(int id)
	{

		return 0;
	
	}

}

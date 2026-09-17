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

public class ModelDestroyerNi<T extends Entity> extends ShipModel<T> implements IModelEmotion
{

	public ModelPart Back;
	public ModelPart NeckBack;
	public ModelPart Body;
	public ModelPart TailBack;
	public ModelPart Head;
	public ModelPart NeckBody;
	public ModelPart EquipBase;
	public ModelPart ArmLeft;
	public ModelPart ArmRight;
	public ModelPart k00;
	public ModelPart ToothU;
	public ModelPart Face00;
	public ModelPart Face01;
	public ModelPart Face02;
	public ModelPart k01;
	public ModelPart k02;
	public ModelPart k03;
	public ModelPart Equip01;
	public ModelPart Equip02;
	public ModelPart Equip03;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart TailEnd1;
	public ModelPart GlowBack;
	public ModelPart GlowNeckBack;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("Back", CubeListBuilder.create().addBox(-12.0F, -12.0F, -14.0F, 24.0F, 21.0F, 26.0F), PartPose.offsetAndRotation(0.0F, -40.0F, 0.0F, 0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Body", CubeListBuilder.create().addBox(-10.0F, 0.0F, 0.0F, 20.0F, 12.0F, 24.0F), PartPose.offsetAndRotation(0.0F, 11.0F, -14.0F, 0.36425021489121656F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("NeckBack", CubeListBuilder.create().addBox(-14.0F, -10.0F, -20.0F, 28.0F, 25.0F, 26.0F), PartPose.offsetAndRotation(0.0F, -2.5F, -14.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("NeckBody", CubeListBuilder.create().addBox(-11.0F, 0.0F, -9.0F, 22.0F, 10.0F, 21.0F), PartPose.offsetAndRotation(0.0F, 13.0F, -4.0F, -0.31869712141416456F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef2.addOrReplaceChild("ArmRight", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 30.0F, 8.0F), PartPose.offsetAndRotation(-13.0F, 15.0F, -9.0F, -0.5235987755982988F, 0.6981317007977318F, 1.0471975511965976F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 30.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 28.0F, 0.0F, 0.0F, 0.0F, -1.3962634015954636F));
		PartDefinition partdef6 = partdef2.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(-20.0F, 0.0F, 0.0F, 40.0F, 13.0F, 13.0F), PartPose.offset(0.0F, 11.0F, -26.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("Equip01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 24.0F, 5.0F), PartPose.offsetAndRotation(18.0F, 13.0F, 9.0F, 1.0471975511965976F, 0.7853981633974483F, 0.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("Equip02", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 28.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 1.3089969389957472F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("Equip03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 32.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 28.0F, 0.0F, 0.0F, 0.0F, -1.0471975511965976F));
		PartDefinition partdef10 = partdef2.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-16.0F, -14.0F, -28.0F, 32.0F, 22.0F, 32.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -19.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("ToothU", CubeListBuilder.create().addBox(-11.0F, 0.0F, 0.0F, 22.0F, 9.0F, 22.0F), PartPose.offsetAndRotation(0.0F, 7.0F, -29.0F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef2.addOrReplaceChild("ArmLeft", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 30.0F, 8.0F), PartPose.offsetAndRotation(13.0F, 15.0F, -9.0F, -0.5235987755982988F, -0.6981317007977318F, -1.0471975511965976F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 30.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 28.0F, 0.0F, 0.0F, 0.0F, 1.3962634015954636F));
		PartDefinition partdef14 = partdef0.addOrReplaceChild("TailBack", CubeListBuilder.create().addBox(-10.0F, -4.0F, 0.0F, 20.0F, 17.0F, 22.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 9.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("TailEnd1", CubeListBuilder.create().addBox(-8.0F, -3.0F, 0.0F, 16.0F, 13.0F, 20.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdefinition.addOrReplaceChild("GlowBack", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -40.0F, 0.0F, 0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("GlowNeckBack", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.5F, -14.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.0F, -19.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("Face00", CubeListBuilder.create().addBox(-10.0F, 0.0F, 0.0F, 20.0F, 0.0F, 20.0F), PartPose.offset(0.0F, -14.3F, -27.0F));
		PartDefinition partdef20 = partdef18.addOrReplaceChild("Face01", CubeListBuilder.create().addBox(-10.0F, 0.0F, 0.0F, 20.0F, 0.0F, 20.0F), PartPose.offset(0.0F, -14.2F, -27.0F));
		PartDefinition partdef21 = partdef18.addOrReplaceChild("Face02", CubeListBuilder.create().addBox(-10.0F, 0.0F, 0.0F, 20.0F, 0.0F, 20.0F), PartPose.offset(0.0F, -14.1F, -27.0F));
		PartDefinition partdef22 = partdef18.addOrReplaceChild("k00", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(14.0F, -12.0F, 0.0F, -0.3490658503988659F, 0.2617993877991494F, 0.0F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("k01", CubeListBuilder.create().addBox(1.0F, -18.5F, 1.0F, 3.0F, 18.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef22.addOrReplaceChild("k02", CubeListBuilder.create().addBox(0.8F, -25.0F, -0.7F, 3.0F, 18.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef25 = partdef22.addOrReplaceChild("k03", CubeListBuilder.create().addBox(0.6F, -24.5F, -2.5F, 3.0F, 18.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.0943951023931953F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelDestroyerNi(ModelPart root)
	{
		this.Back = root.getChild("Back");
		this.Body = root.getChild("Back").getChild("Body");
		this.Face02 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("Face02");
		this.Face00 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("Face00");
		this.k01 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("k00").getChild("k01");
		this.NeckBack = root.getChild("Back").getChild("NeckBack");
		this.Equip02 = root.getChild("Back").getChild("NeckBack").getChild("EquipBase").getChild("Equip01").getChild("Equip02");
		this.k02 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("k00").getChild("k02");
		this.TailEnd1 = root.getChild("Back").getChild("TailBack").getChild("TailEnd1");
		this.ToothU = root.getChild("Back").getChild("NeckBack").getChild("Head").getChild("ToothU");
		this.ArmLeft01 = root.getChild("Back").getChild("NeckBack").getChild("ArmLeft").getChild("ArmLeft01");
		this.TailBack = root.getChild("Back").getChild("TailBack");
		this.ArmRight01 = root.getChild("Back").getChild("NeckBack").getChild("ArmRight").getChild("ArmRight01");
		this.NeckBody = root.getChild("Back").getChild("NeckBack").getChild("NeckBody");
		this.k03 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("k00").getChild("k03");
		this.Equip03 = root.getChild("Back").getChild("NeckBack").getChild("EquipBase").getChild("Equip01").getChild("Equip02").getChild("Equip03");
		this.ArmRight = root.getChild("Back").getChild("NeckBack").getChild("ArmRight");
		this.Equip01 = root.getChild("Back").getChild("NeckBack").getChild("EquipBase").getChild("Equip01");
		this.EquipBase = root.getChild("Back").getChild("NeckBack").getChild("EquipBase");
		this.k00 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("k00");
		this.Head = root.getChild("Back").getChild("NeckBack").getChild("Head");
		this.ArmLeft = root.getChild("Back").getChild("NeckBack").getChild("ArmLeft");
		this.Face01 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("Face01");
		this.GlowBack = root.getChild("GlowBack");
		this.GlowNeckBack = root.getChild("GlowBack").getChild("GlowNeckBack");
		this.GlowHead = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead");
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
    	this.Back.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
		glowLight = true;
    	this.GlowBack.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
    	poseStack.popPose();
    
	}

	@Override
	public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)
	{
		this.captureAnimParms(entity, f, f1, f2, f3, f4);
 
    	
this.animTransX += (0F); this.animTransY += (1.1F); this.animTransZ += (0F);
    	RenderHelper.animScale(this, 0.35F, 0.35F, 0.35F);
    	

    	//FIX: head rotation bug while riding
    	if (f3 <= -180F) { f3 += 360F; }
    	else if (f3 >= 180F) { f3 -= 360F; }
    	
		
		float angleX = Mth.cos(f2*0.125F);
		     
		BasicEntityShip ent = (BasicEntityShip) entity;
		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
		
		if (ent.getStateFlag(ID.F.NoFuel))
		{
			motionStopPos(f, f1, f2, f3, f4, ent);
		}
		else
		{
			//org pose
			Back.xRot = 0.7854F;	       
			ArmLeft.xRot = -0.5F;
			ArmLeft.yRot = -0.7F;
			ArmLeft.zRot = -1.2217F;
			ArmRight.xRot = -0.5F;
			ArmRight.yRot = 0.7F;
			ArmRight.zRot = 1.2217F;
			ArmLeft01.xRot = 0F;
			ArmLeft01.zRot = 1.4F;
			ArmRight01.xRot = 0F;
			ArmRight01.zRot = -1.4F;
	  		Equip01.xRot = 1F;
			
			isKisaragi(ent);   
			rollEmotion(ent);    
			motionWatch(f3, f4, angleX);	//include watch head & normal head
			motionTail(angleX);
			
			if (ent.getIsSitting())
			{
				motionSit(ent, angleX);
			}
			else
			{
				motionLeg(f, f1);
			}
		}

		setGlowRotation();
    
	}

	private void setGlowRotation()
	{

		this.GlowBack.xRot = this.Back.xRot;
		this.GlowBack.yRot = this.Back.yRot;
		this.GlowBack.zRot = this.Back.zRot;
		this.GlowNeckBack.xRot = this.NeckBack.xRot;
		this.GlowNeckBack.yRot = this.NeckBack.yRot;
		this.GlowNeckBack.zRot = this.NeckBack.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
	
	}

	private void motionStopPos(float f, float f1, float f2, float f3, float f4, BasicEntityShip ent)
	{

this.animTransX += (0F); this.animTransY += (0.75F); this.animTransZ += (0F);
    	setFace(2);
    	isKisaragi(ent);
    	
    	//org pose
  		NeckBack.xRot = 0.3F;
	    NeckBack.yRot = 0F;
	    Head.xRot = 0.3F;
	    Head.yRot = 0F;

	    Equip01.yRot = 0.5F;
		Equip02.zRot = 1F;
		Equip03.zRot = -0.8F;
		
  		Back.xRot = -0.3236F;
		ArmLeft.xRot = -1.4F;
		ArmLeft.yRot = -0.7F;
		ArmLeft.zRot = -0.2618F;
		ArmRight.xRot = -1.4F;
		ArmRight.yRot = 0.9F;
		ArmRight.zRot = 0.2618F;
		ArmLeft01.xRot = 0F;
		ArmLeft01.zRot = 1.2F;
		ArmRight01.xRot = 0F;
		ArmRight01.zRot = -0.8F;
		TailBack.xRot = -0.1F;
	    TailEnd1.xRot = 0.05F;
  		Equip01.xRot = 2F;
    
	}

	private void motionLeg(float f, float f1)
	{

    	float angle1 = Mth.cos(f * 0.6662F) * 1.1F * f1;
	    
    	ArmLeft.xRot = angle1 - 0.5F;
    	ArmRight.xRot = -angle1 - 0.5F;
    
	}

	private void motionSit(BasicEntityShip ent, float angleX)
	{

  		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.2F - 0.05F); this.animTransZ += (angleX * 0.2F);
	  		ArmLeft.zRot = -angleX * 0.6F - 1.0472F;
	  		ArmLeft01.zRot = angleX * 0.5F + 1.2F;
			ArmRight.zRot = angleX * 0.6F + 1.0472F;
			ArmRight01.zRot = -angleX * 0.5F - 1.2F;
			TailBack.xRot = angleX * 0.1F + 0.2F;
		    TailEnd1.xRot = angleX * 0.1F + 0.2F;
  		}
  		else
  		{
this.animTransX += (0F); this.animTransY += (0.75F); this.animTransZ += (0F);
	  		Back.xRot = -0.5236F;
			ArmLeft.xRot = -0.6981F;
			ArmLeft.yRot = -0.2618F;
			ArmLeft.zRot = -0.2618F;
			ArmRight.xRot = -0.6981F;
			ArmRight.yRot = 0.2618F;
			ArmRight.zRot = 0.2618F;
			ArmLeft01.xRot = -1.9199F;
			ArmLeft01.zRot = -0.6981F;
			ArmRight01.xRot = -1.9199F;
			ArmRight01.zRot = 0.6981F;
			TailBack.xRot = angleX * 0.1F + 0.2F;
		    TailEnd1.xRot = angleX * 0.1F + 0.2F;
	  		Equip01.xRot = 2F;
  		}
  	
	}

	private void motionTail(float angleX)
	{

  		TailBack.xRot = angleX * 0.2F;
	    TailEnd1.xRot = angleX * 0.2F;
	    Equip01.yRot = angleX * 0.2F + 0.5F;
		Equip02.zRot = angleX * 0.3F + 1F;
		Equip03.zRot = angleX * 0.4F - 0.8F;
  	
	}

	private void motionWatch(float f3, float f4, float angleX)
	{

  		//移動頭部 使其看人, 不看人時持續擺動頭部
  	    if (f4 != 0)
  	    {
  	    	NeckBack.xRot = f4 * 0.005F; 	//上下角度
  		    NeckBack.yRot = f3 * 0.005F;	//左右角度 角度轉成rad 即除以57.29578
  		    Head.xRot = f4 * 0.005F;
  		    Head.yRot = f3 * 0.005F;
  	    }
  	
	}

	private void isKisaragi(BasicEntityShip ent)
	{

    	this.k00.visible = !(!EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State)));
  	
	}

	private void rollEmotion(BasicEntityShip ent)
	{
   	
    	switch (ent.getStateEmotion(ID.S.Emotion))
    	{
    	case ID.Emotion.BLINK:	//blink
    		EmotionHelper.applyEmotionBlink(this, ent);
    	break;
    	case ID.Emotion.T_T:	//cry
    	case ID.Emotion.O_O:
    	case ID.Emotion.HUNGRY:
    		if (ent.getFaceTick() <= 0) setFace(2);
    	break;
    	case ID.Emotion.BORED:	//cry
    		if (ent.getFaceTick() <= 0) setFace(1);
    	break;
    	default:						//normal face
    		//reset face to 0 or blink if emotion time > 0
    		if (ent.getFaceTick() <= 0)
    		{
    			setFace(0);
    		}
    		else
    		{
    			EmotionHelper.applyEmotionBlink(this, ent);
    		}
    		//roll emotion (3 times) every 6 sec
    		//1 tick in entity = 3 tick in model class (20 vs 60 fps)
    		if (ent.tickCount % 120 == 0)
    		{  			
        		int emotionRand = ent.getRandom().nextInt(10);   		
        		if (emotionRand > 7)
        		{
        			EmotionHelper.applyEmotionBlink(this, ent);
        		} 		
        	}
    	break;
    	}	
    
	}

	public void setFace(int emo)
	{

		switch (emo)
		{
		case 0:
			Face00.visible = true;
			Face01.visible = false;
			Face02.visible = false;
		break;
		case 1:
			Face00.visible = false;
			Face01.visible = true;
			Face02.visible = false;
		break;
		case 2:
			Face00.visible = false;
			Face01.visible = false;
			Face02.visible = true;
		break;
		default:
		break;
		}
	
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

	public void showEquip(IShipEmotion ent)
	{

		// TODO Auto-generated method stub
		
	
	}

	public void syncRotationGlowPart()
	{

		// TODO Auto-generated method stub
		
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

		// TODO Auto-generated method stub
		
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

		// TODO Auto-generated method stub
		
	
	}

}

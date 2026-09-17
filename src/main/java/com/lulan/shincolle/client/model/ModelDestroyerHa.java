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

public class ModelDestroyerHa<T extends Entity> extends ShipModel<T> implements IModelEmotion
{

	public ModelPart Back;
	public ModelPart NeckBack;
	public ModelPart Body;
	public ModelPart TailBack;
	public ModelPart Head;
	public ModelPart NeckBody;
	public ModelPart HeadD01;
	public ModelPart k00;
	public ModelPart ToothU;
	public ModelPart Face00;
	public ModelPart Face01;
	public ModelPart Face02;
	public ModelPart HeadD02;
	public ModelPart ToothL;
	public ModelPart HeadD03;
	public ModelPart k01;
	public ModelPart k02;
	public ModelPart k03;
	public ModelPart LegLeftFront;
	public ModelPart LegRightFront;
	public ModelPart LegLeftEnd;
	public ModelPart LegRightEnd;
	public ModelPart TailEnd1;
	public ModelPart TailEnd2;
	public ModelPart GlowBack;
	public ModelPart GlowNeckBack;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("Back", CubeListBuilder.create().addBox(-12.0F, -12.0F, -14.0F, 24.0F, 22.0F, 28.0F), PartPose.offset(0.0F, -22.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("TailBack", CubeListBuilder.create().addBox(-10.0F, -4.0F, 0.0F, 20.0F, 17.0F, 22.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 9.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("TailEnd1", CubeListBuilder.create().addBox(-8.0F, -3.0F, 0.0F, 16.0F, 12.0F, 20.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef3 = partdef1.addOrReplaceChild("TailEnd2", CubeListBuilder.create().addBox(-7.0F, -5.0F, 0.0F, 14.0F, 10.0F, 16.0F), PartPose.offsetAndRotation(0.0F, 8.0F, 20.0F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("NeckBack", CubeListBuilder.create().addBox(-13.0F, -10.0F, -20.0F, 26.0F, 26.0F, 22.0F), PartPose.offsetAndRotation(0.0F, -2.5F, -11.0F, -0.0873F, 0.0F, 0.0F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-13.5F, -14.0F, -28.0F, 27.0F, 27.0F, 26.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -13.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("ToothU", CubeListBuilder.create().addBox(-11.0F, 0.0F, 0.0F, 22.0F, 7.0F, 22.0F), PartPose.offsetAndRotation(0.0F, 12.5F, -28.5F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef5.addOrReplaceChild("HeadD01", CubeListBuilder.create().addBox(-12.0F, 0.0F, -3.0F, 24.0F, 16.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 12.0F, -3.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("HeadD02", CubeListBuilder.create().addBox(-10.5F, 0.0F, -21.0F, 21.0F, 8.0F, 24.0F), PartPose.offsetAndRotation(0.0F, 9.5F, -1.5F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("ToothL", CubeListBuilder.create().mirror().addBox(-11.0F, 0.0F, -22.0F, 22.0F, 7.0F, 22.0F), PartPose.offsetAndRotation(0.0F, 1.0F, 0.5F, -3.089232776029963F, -3.141592653589793F, 0.0F));
		PartDefinition partdef10 = partdef8.addOrReplaceChild("HeadD03", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 10.0F, 10.0F, 18.0F), PartPose.offsetAndRotation(0.0F, 5.0F, -28.0F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef4.addOrReplaceChild("NeckBody", CubeListBuilder.create().addBox(-9.0F, 0.0F, -9.0F, 18.0F, 11.0F, 22.0F), PartPose.offset(0.0F, 15.0F, -8.0F));
		PartDefinition partdef12 = partdef0.addOrReplaceChild("Body", CubeListBuilder.create().addBox(-9.0F, 0.0F, 0.0F, 18.0F, 14.0F, 24.0F), PartPose.offsetAndRotation(0.0F, 11.0F, -18.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("LegRightFront", CubeListBuilder.create().addBox(-5.0F, -4.0F, -5.0F, 10.0F, 16.0F, 10.0F), PartPose.offsetAndRotation(-12.0F, 7.0F, 14.0F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("LegRightEnd", CubeListBuilder.create().addBox(-4.0F, -3.0F, -4.0F, 8.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef12.addOrReplaceChild("LegLeftFront", CubeListBuilder.create().addBox(-5.0F, -4.0F, -5.0F, 10.0F, 16.0F, 10.0F), PartPose.offsetAndRotation(12.0F, 7.0F, 14.0F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("LegLeftEnd", CubeListBuilder.create().addBox(-4.0F, -3.0F, -4.0F, 8.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdefinition.addOrReplaceChild("GlowBack", CubeListBuilder.create(), PartPose.offset(0.0F, -22.0F, 0.0F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("GlowNeckBack", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.5F, -11.0F, -0.0873F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.0F, -13.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("Face00", CubeListBuilder.create().addBox(-10.0F, 0.0F, 0.0F, 20.0F, 20.0F, 0.0F), PartPose.offset(0.0F, -12.0F, -28.1F));
		PartDefinition partdef21 = partdef19.addOrReplaceChild("Face01", CubeListBuilder.create().addBox(-10.0F, 0.0F, 0.0F, 20.0F, 20.0F, 0.0F), PartPose.offset(0.0F, -12.0F, -28.2F));
		PartDefinition partdef22 = partdef19.addOrReplaceChild("Face02", CubeListBuilder.create().addBox(-10.0F, 0.0F, 0.0F, 20.0F, 20.0F, 0.0F), PartPose.offset(0.0F, -12.0F, -28.3F));
		PartDefinition partdef23 = partdef19.addOrReplaceChild("k00", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(13.0F, -8.0F, -10.0F, 0.0F, 0.17453292519943295F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("k01", CubeListBuilder.create().addBox(1.0F, -18.5F, 1.0F, 3.0F, 18.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef25 = partdef23.addOrReplaceChild("k02", CubeListBuilder.create().addBox(0.8F, -25.0F, -0.7F, 3.0F, 18.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef26 = partdef23.addOrReplaceChild("k03", CubeListBuilder.create().addBox(0.6F, -24.5F, -2.5F, 3.0F, 18.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.0943951023931953F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelDestroyerHa(ModelPart root)
	{
		this.TailBack = root.getChild("Back").getChild("TailBack");
		this.ToothL = root.getChild("Back").getChild("NeckBack").getChild("Head").getChild("HeadD01").getChild("HeadD02").getChild("ToothL");
		this.k01 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("k00").getChild("k01");
		this.LegRightFront = root.getChild("Back").getChild("Body").getChild("LegRightFront");
		this.k02 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("k00").getChild("k02");
		this.NeckBack = root.getChild("Back").getChild("NeckBack");
		this.LegLeftFront = root.getChild("Back").getChild("Body").getChild("LegLeftFront");
		this.LegLeftEnd = root.getChild("Back").getChild("Body").getChild("LegLeftFront").getChild("LegLeftEnd");
		this.Back = root.getChild("Back");
		this.k03 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("k00").getChild("k03");
		this.Head = root.getChild("Back").getChild("NeckBack").getChild("Head");
		this.ToothU = root.getChild("Back").getChild("NeckBack").getChild("Head").getChild("ToothU");
		this.Body = root.getChild("Back").getChild("Body");
		this.TailEnd1 = root.getChild("Back").getChild("TailBack").getChild("TailEnd1");
		this.HeadD01 = root.getChild("Back").getChild("NeckBack").getChild("Head").getChild("HeadD01");
		this.k00 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("k00");
		this.NeckBody = root.getChild("Back").getChild("NeckBack").getChild("NeckBody");
		this.HeadD02 = root.getChild("Back").getChild("NeckBack").getChild("Head").getChild("HeadD01").getChild("HeadD02");
		this.HeadD03 = root.getChild("Back").getChild("NeckBack").getChild("Head").getChild("HeadD01").getChild("HeadD02").getChild("HeadD03");
		this.LegRightEnd = root.getChild("Back").getChild("Body").getChild("LegRightFront").getChild("LegRightEnd");
		this.TailEnd2 = root.getChild("Back").getChild("TailBack").getChild("TailEnd2");
		this.Face00 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("Face00");
		this.Face01 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("Face01");
		this.Face02 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("Face02");
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
 
    	
this.animTransX += (0F); this.animTransY += (1F); this.animTransZ += (0F);
    	RenderHelper.animScale(this, 0.45F, 0.45F, 0.45F);
    	

    	//FIX: head rotation bug while riding
    	if (f3 <= -180F) { f3 += 360F; }
    	else if (f3 >= 180F) { f3 -= 360F; }
    	
		
		float angleX = Mth.cos(f2*0.125F);
		     
		BasicEntityShip ent = (BasicEntityShip) entity;
		
  		//水上漂浮
  		if (((IFloatingEntity)ent).getEntityDepth() > 0)
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
			Back.xRot = -0.1F;
			Back.zRot = 0F;
			NeckBack.xRot = -0.15F;
			NeckBack.yRot = 0;
			Head.xRot = -0.2F;
			Head.yRot = 0;
			LegLeftFront.zRot = 0F;
			LegLeftEnd.zRot = 0F;
			LegRightFront.zRot = 0F;
			
			isKisaragi(ent);   
			rollEmotion(ent);    
			motionWatch(f3, f4, angleX);	//include watch head & normal head
			  
			if (ent.getIsSitting())
			{
				motionSit(ent, f2);
			}
			else
			{
			  	motionTail(angleX);
			  	motionLeg(ent, f, f1);
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

this.animTransX += (0F); this.animTransY += (0.5F); this.animTransZ += (0F);
    	isKisaragi(ent);
		setFace(2);
		
		//body
		Back.xRot = 0F;
  		Back.zRot = -1.66F;
  		NeckBack.xRot = 0.1745F;
		NeckBack.yRot = 0;
		Head.xRot = 0.1745F;
		Head.yRot = 0;
		HeadD01.xRot = 0.1745F;
		//tail
		TailBack.xRot = 0.4F;
	    TailBack.yRot = 0F;
	    TailEnd1.xRot = 0.4F;
	    TailEnd1.yRot = 0F;
		//leg
	    LegLeftFront.xRot = 0.35F;
	    LegLeftFront.zRot = 0.52F;
	    LegLeftEnd.xRot = 0F;
	    LegLeftEnd.zRot = 0.52F;
		LegRightFront.xRot = -0.2F;
		LegRightFront.zRot = 0.087F;
		LegRightEnd.xRot = 0.52F;
    
	}

	private void motionSit(BasicEntityShip ent, float f2)
	{

  		float angle1 = Mth.cos(f2 * 1F);
  		
  		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
  		{
			setFace(1);
this.animTransX += (0F); this.animTransY += (0.4F); this.animTransZ += (0F);
	  		Back.xRot = -0.8F;
	  		NeckBack.xRot = -0.2618F;
			Head.xRot = -0.2618F;
			HeadD01.xRot = -angle1 * 0.05F + 0.2618F;
			LegRightFront.xRot = -0.7F;
		    LegLeftFront.xRot = angle1 * 0.5F - 2.5F;
		    LegRightEnd.xRot = 0.35F;
		    LegLeftEnd.xRot = angle1 * 0.3F + 0.7F;
		    TailBack.xRot = 0.35F;
		    TailEnd1.xRot = 0.35F;
  		}
  		else
  		{
this.animTransX += (0F); this.animTransY += (0.5F); this.animTransZ += (0F);
	  		Back.xRot = 0F;
	  		Back.zRot = -1.5708F;
	  		NeckBack.xRot = 0.1745F;
			Head.xRot = 0.1745F;
			HeadD01.xRot = 0.1745F;
			LegRightFront.xRot = 0F;
		    LegLeftFront.xRot = 0.5F;
		    LegRightEnd.xRot = 1.7F;
		    LegLeftEnd.xRot = 1.5F;
		    TailBack.xRot = -0.7F;
		    TailEnd1.xRot = -0.5F;
  		}
  		
  	
	}

	private void motionTail(float angleX)
	{

  		TailBack.xRot = angleX * 0.05F + 0.1745F;
	    TailEnd1.xRot = angleX * 0.1F + 0.2618F;
  	
	}

	private void motionLeg(BasicEntityShip ent, float f, float f1)
	{

  		float angle1 = Mth.cos(f * 0.6662F) * 0.5F * f1;
  		float angle2 = Mth.sin(f * 0.6662F) * 0.5F * f1;
  		
  		LegRightFront.xRot = angle1 - 0.5F;
	    LegLeftFront.xRot = -angle1 - 0.5F;
	    LegRightEnd.xRot = angle2 + 1F;
	    LegLeftEnd.xRot = -angle2 + 1F;
	
	}

	private void motionWatch(float f3, float f4, float angleX)
	{

  		//移動頭部 使其看人, 不看人時持續擺動頭部
  	    if (f4 != 0)
  	    {
  	    	NeckBack.xRot = f4 * 0.005F; 	//上下角度
  		    NeckBack.yRot = f3 * 0.005F;	//左右角度
  		    Head.xRot = f4 * 0.005F;
  		    Head.yRot = f3 * 0.005F;
  		    HeadD01.xRot = angleX * 0.05F - 0.05F;
  		    TailBack.xRot = 0.15F;
  		    TailBack.yRot = f3 * -0.005F;	//尾巴以反方向擺動
  		    TailEnd1.xRot = 0.2F;
		    TailEnd1.yRot = f3 * -0.005F;
  	    }
  	    else
  	    {
  	    	HeadD01.xRot = angleX * 0.05F - 0.05F;
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
    	}//end switch
    
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

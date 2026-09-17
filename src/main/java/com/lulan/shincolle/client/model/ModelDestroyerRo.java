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

public class ModelDestroyerRo<T extends Entity> extends ShipModel<T> implements IModelEmotion
{

	public ModelPart Back;
	public ModelPart NeckBack;
	public ModelPart Body;
	public ModelPart TailBack;
	public ModelPart LegLeftFront;
	public ModelPart LegRightFront;
	public ModelPart BodyTurbine;
	public ModelPart Head;
	public ModelPart NeckBody;
	public ModelPart HeadD03;
	public ModelPart HeadU01;
	public ModelPart HeadD01;
	public ModelPart FaceL00;
	public ModelPart FaceL01;
	public ModelPart FaceL02;
	public ModelPart FaceR00;
	public ModelPart FaceR01;
	public ModelPart FaceR02;
	public ModelPart k00;
	public ModelPart HeadD04;
	public ModelPart UpperTooth;
	public ModelPart HeadU02;
	public ModelPart LowerTooth;
	public ModelPart k01;
	public ModelPart k02;
	public ModelPart k03;
	public ModelPart tube01;
	public ModelPart tube02;
	public ModelPart tube03;
	public ModelPart TailEnd;
	public ModelPart TailBack01;
	public ModelPart TailBack02;
	public ModelPart LegLeftEnd;
	public ModelPart LegRightEnd;
	public ModelPart GlowBack;
	public ModelPart GlowNeckBack;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("Back", CubeListBuilder.create().addBox(-12.0F, -12.0F, -14.0F, 24.0F, 22.0F, 28.0F), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("TailBack", CubeListBuilder.create().addBox(-10.0F, -8.0F, 0.0F, 20.0F, 14.0F, 22.0F), PartPose.offsetAndRotation(0.0F, -2.0F, 11.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("TailBack02", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 10.0F, 20.0F), PartPose.offsetAndRotation(-8.0F, 0.0F, 15.0F, -1.0471975511965976F, 0.0F, -0.40142572795869574F));
		PartDefinition partdef3 = partdef1.addOrReplaceChild("TailBack01", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 10.0F, 20.0F), PartPose.offsetAndRotation(8.0F, 0.0F, 15.0F, -1.0471975511965976F, 0.0F, 0.40142572795869574F));
		PartDefinition partdef4 = partdef1.addOrReplaceChild("TailEnd", CubeListBuilder.create().addBox(-8.0F, -6.5F, 0.0F, 16.0F, 10.0F, 24.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("LegRightFront", CubeListBuilder.create().addBox(-4.0F, -4.0F, -4.0F, 8.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(-7.8F, 12.0F, -3.0F, 0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("LegRightEnd", CubeListBuilder.create().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef0.addOrReplaceChild("Body", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 7.0F, 16.0F), PartPose.offsetAndRotation(0.0F, 8.0F, -10.0F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef8 = partdef0.addOrReplaceChild("LegLeftFront", CubeListBuilder.create().addBox(-4.0F, -4.0F, -4.0F, 8.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(7.8F, 12.0F, -3.0F, 0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("LegLeftEnd", CubeListBuilder.create().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef0.addOrReplaceChild("NeckBack", CubeListBuilder.create().addBox(-13.0F, -11.0F, -20.0F, 26.0F, 26.0F, 22.0F), PartPose.offsetAndRotation(0.0F, -3.0F, -12.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-15.0F, -12.0F, -16.0F, 30.0F, 27.0F, 18.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -17.5F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("HeadD04", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 12.0F, 18.0F), PartPose.offsetAndRotation(0.0F, 7.0F, -15.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef13 = partdef11.addOrReplaceChild("HeadU01", CubeListBuilder.create().addBox(-14.0F, -21.0F, -9.0F, 28.0F, 16.0F, 20.0F), PartPose.offsetAndRotation(0.0F, 7.0F, -19.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("HeadU02", CubeListBuilder.create().addBox(-14.0F, 0.0F, 0.0F, 28.0F, 15.0F, 20.0F), PartPose.offsetAndRotation(0.0F, -20.0F, -23.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef13.addOrReplaceChild("UpperTooth", CubeListBuilder.create().addBox(-12.0F, 0.0F, 0.0F, 24.0F, 10.0F, 20.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -15.0F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdef11.addOrReplaceChild("HeadD01", CubeListBuilder.create().addBox(-13.0F, 1.5F, -25.0F, 26.0F, 10.0F, 28.0F), PartPose.offsetAndRotation(0.0F, 1.0F, -10.3F, 0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("LowerTooth", CubeListBuilder.create().mirror().addBox(-12.0F, 0.0F, 0.0F, 24.0F, 10.0F, 20.0F), PartPose.offsetAndRotation(0.0F, 9.5F, -5.5F, -3.490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef10.addOrReplaceChild("HeadD03", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 12.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 10.3F, -23.0F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef10.addOrReplaceChild("NeckBody", CubeListBuilder.create().addBox(-9.0F, 0.0F, -9.0F, 18.0F, 14.0F, 18.0F), PartPose.offsetAndRotation(0.0F, 7.0F, -9.0F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("tube01", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 20.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 3.0F, -0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("tube03", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 28.0F), PartPose.offsetAndRotation(-1.0F, 1.5F, 18.0F, 1.0471975511965976F, -0.13962634015954636F, 0.0F));
		PartDefinition partdef22 = partdef20.addOrReplaceChild("tube02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 28.0F), PartPose.offsetAndRotation(1.0F, 1.5F, 18.0F, 1.0471975511965976F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef23 = partdef0.addOrReplaceChild("BodyTurbine", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 9.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 7.0F, -2.0F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdefinition.addOrReplaceChild("GlowBack", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("GlowNeckBack", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.0F, -12.0F, 0.0873F, 0.0F, 0.0F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -17.5F, 0.2618F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("FaceL00", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 16.0F), PartPose.offset(15.1F, -8.0F, -16.0F));
		PartDefinition partdef28 = partdef26.addOrReplaceChild("FaceL01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 16.0F), PartPose.offset(15.1F, -8.0F, -16.0F));
		PartDefinition partdef29 = partdef26.addOrReplaceChild("FaceL02", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 16.0F), PartPose.offset(15.1F, -8.0F, -16.0F));
		PartDefinition partdef30 = partdef26.addOrReplaceChild("FaceR00", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 16.0F), PartPose.offset(-15.1F, -8.0F, -16.0F));
		PartDefinition partdef31 = partdef26.addOrReplaceChild("FaceR01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 16.0F), PartPose.offset(-15.1F, -8.0F, -16.0F));
		PartDefinition partdef32 = partdef26.addOrReplaceChild("FaceR02", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 16.0F), PartPose.offset(-15.1F, -8.0F, -16.0F));
		PartDefinition partdef33 = partdef26.addOrReplaceChild("k00", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(12.0F, -10.0F, 0.0F, 0.0F, 0.17453292519943295F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("k01", CubeListBuilder.create().addBox(1.0F, -18.5F, 1.0F, 3.0F, 18.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef35 = partdef33.addOrReplaceChild("k02", CubeListBuilder.create().addBox(0.8F, -25.0F, -0.7F, 3.0F, 18.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef36 = partdef33.addOrReplaceChild("k03", CubeListBuilder.create().addBox(0.6F, -24.5F, -2.5F, 3.0F, 18.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.0943951023931953F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelDestroyerRo(ModelPart root)
	{
		this.LowerTooth = root.getChild("Back").getChild("NeckBack").getChild("Head").getChild("HeadD01").getChild("LowerTooth");
		this.k02 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("k00").getChild("k02");
		this.TailBack = root.getChild("Back").getChild("TailBack");
		this.LegRightEnd = root.getChild("Back").getChild("LegRightFront").getChild("LegRightEnd");
		this.TailBack02 = root.getChild("Back").getChild("TailBack").getChild("TailBack02");
		this.LegRightFront = root.getChild("Back").getChild("LegRightFront");
		this.TailBack01 = root.getChild("Back").getChild("TailBack").getChild("TailBack01");
		this.k03 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("k00").getChild("k03");
		this.Head = root.getChild("Back").getChild("NeckBack").getChild("Head");
		this.HeadD03 = root.getChild("Back").getChild("NeckBack").getChild("HeadD03");
		this.tube03 = root.getChild("Back").getChild("NeckBack").getChild("NeckBody").getChild("tube01").getChild("tube03");
		this.k00 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("k00");
		this.HeadD04 = root.getChild("Back").getChild("NeckBack").getChild("Head").getChild("HeadD04");
		this.HeadU02 = root.getChild("Back").getChild("NeckBack").getChild("Head").getChild("HeadU01").getChild("HeadU02");
		this.LegLeftEnd = root.getChild("Back").getChild("LegLeftFront").getChild("LegLeftEnd");
		this.NeckBody = root.getChild("Back").getChild("NeckBack").getChild("NeckBody");
		this.tube01 = root.getChild("Back").getChild("NeckBack").getChild("NeckBody").getChild("tube01");
		this.Back = root.getChild("Back");
		this.HeadU01 = root.getChild("Back").getChild("NeckBack").getChild("Head").getChild("HeadU01");
		this.TailEnd = root.getChild("Back").getChild("TailBack").getChild("TailEnd");
		this.Body = root.getChild("Back").getChild("Body");
		this.LegLeftFront = root.getChild("Back").getChild("LegLeftFront");
		this.HeadD01 = root.getChild("Back").getChild("NeckBack").getChild("Head").getChild("HeadD01");
		this.NeckBack = root.getChild("Back").getChild("NeckBack");
		this.k01 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("k00").getChild("k01");
		this.tube02 = root.getChild("Back").getChild("NeckBack").getChild("NeckBody").getChild("tube01").getChild("tube02");
		this.BodyTurbine = root.getChild("Back").getChild("BodyTurbine");
		this.UpperTooth = root.getChild("Back").getChild("NeckBack").getChild("Head").getChild("HeadU01").getChild("UpperTooth");
		this.FaceL00 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("FaceL00");
		this.FaceL01 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("FaceL01");
		this.FaceL02 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("FaceL02");
		this.FaceR00 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("FaceR00");
		this.FaceR01 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("FaceR01");
		this.FaceR02 = root.getChild("GlowBack").getChild("GlowNeckBack").getChild("GlowHead").getChild("FaceR02");
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
  
    	
    	RenderHelper.animScale(this, 0.45F, 0.45F, 0.45F);
this.animTransX += (0F); this.animTransY += (2.1F); this.animTransZ += (0F);
        

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
			Back.xRot = -0.2618F;
			Back.yRot = 0F;
			Back.zRot = 0F;
			NeckBack.xRot = 0.0873F;
			Head.xRot = 0.3F;
			LegRightFront.yRot = 0F;
			LegLeftFront.yRot = 0F;
			
			isKisaragi(ent);   
			rollEmotion(ent);    
			motionWatch(f3, f4, angleX);	//include watch head & normal head
			  
			if (ent.getIsSitting())
			{
				motionSit(ent, angleX);
			}
			else
			{
			  	motionLeg(ent, f, f1, angleX);
			  	motionTail(angleX);
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

this.animTransX += (0F); this.animTransY += (0.45F); this.animTransZ += (0F);
    	isKisaragi(ent);
    	setFace(1);
    	
    	//head
  		HeadD01.xRot = 0.7F;
    	NeckBack.xRot = 0F;
    	NeckBack.yRot = 0.1F;
    	Head.xRot = 0.1F;
    	Head.yRot = 0.1F;
    	//body
    	Back.xRot = 0F;
		Back.yRot = 3.1415F;
		Back.zRot = 3.1415F;
		//leg
    	LegRightFront.xRot = 1.57F;
    	LegRightFront.yRot = -0.52F;
	    LegLeftFront.xRot = 1.57F;
	    LegLeftFront.yRot = 0.52F;
	    LegRightEnd.xRot = 1F;
	    LegLeftEnd.xRot = 1F;
	    //tail
	    TailBack.xRot = 0.1F;
	    TailBack.yRot = -0.15F;
  	    TailEnd.xRot = 0.1F;
  	    TailEnd.yRot = -0.15F;
  	    tube01.xRot = -0.8F;
  	    tube01.yRot = -0.12F;
    
	}

	private void motionSit(BasicEntityShip ent, float angleX)
	{

this.animTransX += (0F); this.animTransY += (0.45F); this.animTransZ += (0F);
  		
  		if  (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
  		{
			setFace(2);
			Back.xRot = 0F;
			Back.yRot = 3.1415F;
			Back.zRot = 3.1415F;
			Head.xRot = angleX * 0.08F + 0.35F;
	    	LegRightFront.xRot = angleX * 0.3F + 0.5F;
		    LegLeftFront.xRot = -angleX * 0.3F + 0.5F;
		    LegRightEnd.xRot = angleX * 0.3F + 0.5F;
		    LegLeftEnd.xRot = -angleX * 0.3F + 0.5F;
		    TailBack.xRot = -0.3F;
		    TailBack.yRot = angleX * 0.3F;
	  	    TailEnd.xRot = -0.3F;
	  	    TailEnd.yRot = angleX * 0.5F;
	  	    tube01.xRot = -0.8F;
  		}
  		else
  		{
  			Back.xRot = -0.7F;
  			Head.xRot = angleX * 0.08F + 0.35F;
  	    	LegRightFront.xRot = -0.6981F;
  		    LegLeftFront.xRot = -0.6981F;
  		    LegRightEnd.xRot = 0.1745F;
  		    LegLeftEnd.xRot = 0.1745F;
  		    TailBack.xRot = 0.5F;
  		    TailBack.yRot = angleX * 0.3F;
  	  	    TailEnd.xRot = 0.6F;
  	  	    TailEnd.yRot = angleX * 0.5F;
  	  	    tube01.xRot = -0.6F;
  		}
  	
	}

	private void motionTail(float angleX)
	{

  		TailBack.xRot = angleX * 0.1F - 0.1F;
	    TailEnd.xRot = angleX * 0.25F - 0.1F;
  	
	}

	private void motionLeg(BasicEntityShip ent, float f, float f1, float angleX)
	{

		if (ent.isSprinting() || f1 > 0.9F)
		{
			LegRightFront.xRot = Mth.cos(f * 0.6662F) * 0.4F * f1 + 1F;
		    LegLeftFront.xRot = Mth.cos(f * 0.6662F + 3.1415927F) * 0.4F * f1 + 1F;
		    LegRightEnd.xRot = Mth.sin(f * 0.6662F) * f1 + 0.5F;
		    LegLeftEnd.xRot = Mth.sin(f * 0.6662F + 3.1415927F) * f1 + 0.5F;
		}
		else
		{
			LegRightFront.xRot = angleX * 0.3F + 0.8F;
		    LegLeftFront.xRot = -angleX * 0.3F + 0.8F;
		    LegRightEnd.xRot = angleX * 0.3F + 0.5F;
		    LegLeftEnd.xRot = -angleX * 0.3F + 0.5F;
		}  
	
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
  		    TailBack.xRot = 0.1F;
  		    TailBack.yRot = f3 * -0.005F;	//尾巴以反方向擺動
  		    TailEnd.xRot = 0.1F;
		    TailEnd.yRot = f3 * -0.005F;
		    tube01.xRot = f4 * -0.005F - 0.8727F;
		    tube01.yRot = f3 * -0.005F;
  	    }
  	    else
  	    {
  	    	Head.xRot = angleX * 0.08F + 0.3F;
  	  		HeadD01.xRot = angleX * 0.05F + 0.7F;
  	    	NeckBack.xRot = 0.0873F; 	//上下角度
  	    	NeckBack.yRot = 0;			//左右角度 角度轉成rad 即除以57.29578
  	    	Head.yRot = 0;
  	    	TailBack.yRot = 0;
  	    	TailEnd.yRot = 0;
  	    	tube01.xRot = -0.8727F;
  	    	tube01.yRot = 0;
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
			FaceL00.visible = true;
			FaceR00.visible = true;
			FaceL01.visible = false;
			FaceR01.visible = false;
			FaceL02.visible = false;
			FaceR02.visible = false;
		break;
		case 1:
			FaceL00.visible = false;
			FaceR00.visible = false;
			FaceL01.visible = true;
			FaceR01.visible = true;
			FaceL02.visible = false;
			FaceR02.visible = false;
		break;
		case 2:
			FaceL00.visible = false;
			FaceR00.visible = false;
			FaceL01.visible = false;
			FaceR01.visible = false;
			FaceL02.visible = true;
			FaceR02.visible = true;
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

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

public class ModelDestroyerI<T extends Entity> extends ShipModel<T> implements IModelEmotion
{

	//fields
	public ModelPart PBack;
	public ModelPart PNeck;
	public ModelPart PHead;
	public ModelPart[] PEyeLightL = new ModelPart[3];
	public ModelPart[] PEyeLightR = new ModelPart[3];
	public ModelPart PJawBottom;
	public ModelPart PBody;
	public ModelPart PLegLeft;
	public ModelPart PLegLeftEnd;
	public ModelPart PLegRight;
	public ModelPart PLegRightEnd;
	public ModelPart PTail;
	public ModelPart PTailLeft;
	public ModelPart PTailLeftEnd;
	public ModelPart PTailRight;
	public ModelPart PTailRightEnd;
	public ModelPart PTailEnd;
	//add Kisaragi
	public ModelPart PKisaragi00;
	public ModelPart PKisaragi01;
	public ModelPart PKisaragi02;
	public ModelPart PKisaragi03;
	//add glow model
	public ModelPart GlowPBack;
	public ModelPart GlowPNeck;
	public ModelPart GlowPHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("PBack", CubeListBuilder.create().texOffs(128, 8).addBox(-12F, -10F, -12F, 28.0F, 20.0F, 24.0F), PartPose.offsetAndRotation(-8F, -16F, 0F, 0F, 0F, -0.31F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("PNeck", CubeListBuilder.create().texOffs(128, 0).addBox(-3F, -11F, -13F, 30.0F, 26.0F, 26.0F).texOffs(128, 28).addBox(6F, 15F, -10F, 21.0F, 4.0F, 20.0F).texOffs(0, 70).addBox(-8F, 7F, -9F, 18.0F, 14.0F, 18.0F), PartPose.offsetAndRotation(15F, 0F, 0F, 0F, 0F, 0.2F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("PHead", CubeListBuilder.create().texOffs(0, 0).addBox(-3F, -12F, -16F, 32.0F, 32.0F, 32.0F).texOffs(96, 0).addBox(14.5F, 20F, -6F, 4.0F, 6.0F, 12.0F).texOffs(128, 54).addBox(0F, 20F, -10F, 18.0F, 6.0F, 4.0F).addBox(0F, 20F, 6F, 18.0F, 6.0F, 4.0F).texOffs(0, 102).addBox(-3F, 20F, -11F, 22.0F, 2.0F, 22.0F), PartPose.offsetAndRotation(26F, 0F, 0F, 0F, 0F, 0.3F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("PJawBottom", CubeListBuilder.create().texOffs(92, 64).addBox(-3F, 0F, -10F, 3.0F, 18.0F, 20.0F).texOffs(96, 19).addBox(-1F, 7.5F, 6F, 4.0F, 10.0F, 3.0F).addBox(-1F, 7.5F, -9F, 4.0F, 10.0F, 3.0F).texOffs(0, 0).addBox(-1F, 14.5F, -6F, 4.0F, 3.0F, 12.0F), PartPose.offsetAndRotation(-6F, 18F, 0F, 0F, 0F, -0.2F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("PBody", CubeListBuilder.create().texOffs(0, 64).addBox(-10F, 10F, -11F, 24.0F, 16.0F, 22.0F), PartPose.offset(0F, 0F, 0F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("PLegLeft", CubeListBuilder.create().texOffs(0, 80).addBox(-3F, -4F, -1F, 8.0F, 14.0F, 8.0F), PartPose.offset(-3F, 24F, 6F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("PLegLeftEnd", CubeListBuilder.create().texOffs(0, 90).addBox(-12F, -3F, -4F, 12.0F, 6.0F, 6.0F), PartPose.offset(1F, 8F, 4F));
		PartDefinition partdef7 = partdef4.addOrReplaceChild("PLegRight", CubeListBuilder.create().texOffs(0, 80).addBox(-3F, -4F, -5F, 8.0F, 14.0F, 8.0F), PartPose.offset(-3F, 24F, -8F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("PLegRightEnd", CubeListBuilder.create().texOffs(0, 90).addBox(-12F, -3F, -3F, 12.0F, 6.0F, 6.0F), PartPose.offset(1F, 8F, -1F));
		PartDefinition partdef9 = partdef0.addOrReplaceChild("PTail", CubeListBuilder.create().texOffs(128, 16).addBox(-22F, -6F, -10F, 26.0F, 16.0F, 20.0F).texOffs(0, 68).addBox(-8F, 2F, -8F, 18.0F, 18.0F, 14.0F), PartPose.offsetAndRotation(-12F, -2F, 0F, 0F, 0F, 0.25F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("PTailLeft", CubeListBuilder.create().texOffs(128, 28).addBox(-8F, -4F, 0F, 12.0F, 18.0F, 6.0F), PartPose.offsetAndRotation(-12F, 4F, 8F, 0.5F, 0F, 0.25F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("PTailLeftEnd", CubeListBuilder.create().texOffs(128, 36).addBox(-24F, -4F, -2F, 24.0F, 12.0F, 4.0F), PartPose.offsetAndRotation(0F, 9F, 5F, 0F, 0F, -0.4F));
		PartDefinition partdef12 = partdef9.addOrReplaceChild("PTailRight", CubeListBuilder.create().texOffs(128, 28).addBox(-8F, -4F, -6F, 12.0F, 18.0F, 6.0F), PartPose.offsetAndRotation(-12F, 4F, -8F, -0.5F, 0F, 0.25F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("PTailRightEnd", CubeListBuilder.create().texOffs(128, 36).addBox(-24F, -4F, -2F, 24.0F, 12.0F, 4.0F), PartPose.offsetAndRotation(0F, 9F, -5F, 0F, 0F, -0.4F));
		PartDefinition partdef14 = partdef9.addOrReplaceChild("PTailEnd", CubeListBuilder.create().texOffs(128, 26).addBox(-20F, -6F, -8F, 24.0F, 10.0F, 16.0F), PartPose.offsetAndRotation(-22F, 2F, 0F, 0F, 0F, 0.3F));
		PartDefinition partdef15 = partdefinition.addOrReplaceChild("GlowPBack", CubeListBuilder.create(), PartPose.offsetAndRotation(-8F, -16F, 0F, 0F, 0F, -0.31F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("GlowPNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(15F, 0F, 0F, 0F, 0F, 0.2F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("GlowPHead", CubeListBuilder.create(), PartPose.offsetAndRotation(26F, 0F, 0F, 0F, 0F, 0.3F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("PEyeLightL_0", CubeListBuilder.create().mirror().addBox(-3F, 0F, 15.1F, 24.0F, 20.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef17.addOrReplaceChild("PEyeLightR_0", CubeListBuilder.create().addBox(-3F, 0F, -16.1F, 24.0F, 20.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef17.addOrReplaceChild("PEyeLightL_1", CubeListBuilder.create().mirror().addBox(-3F, 0F, 15.1F, 24.0F, 20.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef21 = partdef17.addOrReplaceChild("PEyeLightR_1", CubeListBuilder.create().addBox(-3F, 0F, -16.1F, 24.0F, 20.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdef17.addOrReplaceChild("PEyeLightL_2", CubeListBuilder.create().mirror().addBox(-3F, 0F, 15.1F, 24.0F, 20.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef23 = partdef17.addOrReplaceChild("PEyeLightR_2", CubeListBuilder.create().addBox(-3F, 0F, -16.1F, 24.0F, 20.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef17.addOrReplaceChild("PKisaragi00", CubeListBuilder.create().texOffs(66, 102).addBox(0F, 0F, 0F, 8.0F, 8.0F, 5.0F), PartPose.offset(-7F, -9F, 14F));
		PartDefinition partdef25 = partdef17.addOrReplaceChild("PKisaragi01", CubeListBuilder.create().texOffs(114, 102).addBox(-2F, -16F, 1F, 8.0F, 20.0F, 3.0F), PartPose.offsetAndRotation(-7F, -9F, 14F, 0F, 0F, -0.524F));
		PartDefinition partdef26 = partdef17.addOrReplaceChild("PKisaragi02", CubeListBuilder.create().texOffs(92, 102).addBox(-7F, -17F, 0.8F, 8.0F, 18.0F, 3.0F), PartPose.offsetAndRotation(-7F, -9F, 14F, 0F, 0F, -1.396F));
		PartDefinition partdef27 = partdef17.addOrReplaceChild("PKisaragi03", CubeListBuilder.create().texOffs(92, 102).addBox(-9F, -18F, 0.6F, 8.0F, 18.0F, 3.0F), PartPose.offsetAndRotation(-7F, -9F, 14F, 0F, 0F, -2.094F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelDestroyerI(ModelPart root)
	{
		this.PBack = root.getChild("PBack");
		this.PNeck = root.getChild("PBack").getChild("PNeck");
		this.PHead = root.getChild("PBack").getChild("PNeck").getChild("PHead");
		this.PEyeLightL[0] = root.getChild("GlowPBack").getChild("GlowPNeck").getChild("GlowPHead").getChild("PEyeLightL_0");
		this.PEyeLightR[0] = root.getChild("GlowPBack").getChild("GlowPNeck").getChild("GlowPHead").getChild("PEyeLightR_0");
		this.PEyeLightL[1] = root.getChild("GlowPBack").getChild("GlowPNeck").getChild("GlowPHead").getChild("PEyeLightL_1");
		this.PEyeLightR[1] = root.getChild("GlowPBack").getChild("GlowPNeck").getChild("GlowPHead").getChild("PEyeLightR_1");
		this.PEyeLightL[2] = root.getChild("GlowPBack").getChild("GlowPNeck").getChild("GlowPHead").getChild("PEyeLightL_2");
		this.PEyeLightR[2] = root.getChild("GlowPBack").getChild("GlowPNeck").getChild("GlowPHead").getChild("PEyeLightR_2");
		this.PKisaragi00 = root.getChild("GlowPBack").getChild("GlowPNeck").getChild("GlowPHead").getChild("PKisaragi00");
		this.PKisaragi01 = root.getChild("GlowPBack").getChild("GlowPNeck").getChild("GlowPHead").getChild("PKisaragi01");
		this.PKisaragi02 = root.getChild("GlowPBack").getChild("GlowPNeck").getChild("GlowPHead").getChild("PKisaragi02");
		this.PKisaragi03 = root.getChild("GlowPBack").getChild("GlowPNeck").getChild("GlowPHead").getChild("PKisaragi03");
		this.PJawBottom = root.getChild("PBack").getChild("PNeck").getChild("PHead").getChild("PJawBottom");
		this.PBody = root.getChild("PBack").getChild("PBody");
		this.PLegLeft = root.getChild("PBack").getChild("PBody").getChild("PLegLeft");
		this.PLegLeftEnd = root.getChild("PBack").getChild("PBody").getChild("PLegLeft").getChild("PLegLeftEnd");
		this.PLegRight = root.getChild("PBack").getChild("PBody").getChild("PLegRight");
		this.PLegRightEnd = root.getChild("PBack").getChild("PBody").getChild("PLegRight").getChild("PLegRightEnd");
		this.PTail = root.getChild("PBack").getChild("PTail");
		this.PTailLeft = root.getChild("PBack").getChild("PTail").getChild("PTailLeft");
		this.PTailLeftEnd = root.getChild("PBack").getChild("PTail").getChild("PTailLeft").getChild("PTailLeftEnd");
		this.PTailRight = root.getChild("PBack").getChild("PTail").getChild("PTailRight");
		this.PTailRightEnd = root.getChild("PBack").getChild("PTail").getChild("PTailRight").getChild("PTailRightEnd");
		this.PTailEnd = root.getChild("PBack").getChild("PTail").getChild("PTailEnd");
		this.GlowPBack = root.getChild("GlowPBack");
		this.GlowPNeck = root.getChild("GlowPBack").getChild("GlowPNeck");
		this.GlowPHead = root.getChild("GlowPBack").getChild("GlowPNeck").getChild("GlowPHead");
		this.PEyeLightL[1].visible = false;
		this.PEyeLightR[1].visible = false;
		this.PEyeLightL[2].visible = false;
		this.PEyeLightR[2].visible = false;
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

    	poseStack.pushPose();
    	
    	poseStack.scale(0.45F, 0.4F, 0.4F);	//debug用
    	RenderHelper.rotate(poseStack, 90F, 0F, 1F, 0F);	//此模型頭部方向錯誤 因此render時調整回來
    	this.PBack.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
		glowLight = true;
    	this.GlowPBack.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
    	poseStack.popPose();
	
	}

	@Override
	public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)
	{
		this.captureAnimParms(entity, f, f1, f2, f3, f4);

    	//FIX: head rotation bug while riding
    	if (f3 <= -180F) { f3 += 360F; }
    	else if (f3 >= 180F) { f3 -= 360F; }
    	

	
	    float angleZ = Mth.cos(f2*0.125F);
	    
	    BasicEntityShip ent = (BasicEntityShip) entity;
	    
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleZ * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
	    
	    if (ent.getStateFlag(ID.F.NoFuel))
	    {
			motionStopPos(f, f1, f2, f3, f4, ent);
		}
		else
		{
			//body
			PBack.xRot = 0F;
			//leg
		    PLegLeft.xRot = 0F;
		    PLegLeft.zRot = 0F;
		    PLegRight.xRot = 0F;
		    PLegRight.zRot = 0F;
		    
			isKisaragi(ent);   
		    rollEmotion(ent);    
		    motionWatch(f3,f4,angleZ);	//include watch head & normal head
		    
		    if (ent.getIsSitting())
		    {
		    	motionSit(ent, angleZ);
		    }
		    else
		    {
		    	motionLeg(f,f1);
		    	motionTail(angleZ);
		    	
		    	//reset sit pose
		    	PBack.zRot = -0.31F;
this.animTransX += (0F); this.animTransY += (0.42F); this.animTransZ += (0F);
		    }
		}
	    
	    setGlowRotation();
	
	}

	private void setGlowRotation()
	{

		this.GlowPBack.xRot = this.PBack.xRot;
		this.GlowPBack.yRot = this.PBack.yRot;
		this.GlowPBack.zRot = this.PBack.zRot;
		this.GlowPHead.xRot = this.PHead.xRot;
		this.GlowPHead.yRot = this.PHead.yRot;
		this.GlowPHead.zRot = this.PHead.zRot;
		this.GlowPNeck.xRot = this.PNeck.xRot;
		this.GlowPNeck.yRot = this.PNeck.yRot;
		this.GlowPNeck.zRot = this.PNeck.zRot;
	
	}

	private void motionStopPos(float f, float f1, float f2, float f3, float f4, BasicEntityShip ent)
	{

this.animTransX += (0F); this.animTransY += (0.75F); this.animTransZ += (0F);
		
		isKisaragi(ent);
		setFace(2);

		//body
		PBack.xRot = 1.4835F;
		PBack.zRot = 0F;
		//head
		PNeck.yRot = 0;
	    PNeck.zRot = 0.2F;
	    PHead.yRot = 0;
	    PHead.zRot = 0.2F;
	    PTail.yRot = 0;
	    //leg
	    PLegLeft.xRot = -1.0472F;
	    PLegLeft.zRot = 0F;
	    PLegLeftEnd.zRot = -1.4F;
	    PLegRight.xRot = 0.087F;
	    PLegRight.zRot = -0.7854F;
	    PLegRightEnd.zRot = -1.4F;
	    //tail
	    PTail.zRot = 0.2F;
  	    PTailEnd.zRot = 0.3F;
  	    PJawBottom.zRot = -0.3F;
    
	}

	private void isKisaragi(BasicEntityShip ent)
	{

		boolean flag = !EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State));
		this.PKisaragi00.visible = !(flag);
		this.PKisaragi01.visible = !(flag);
		this.PKisaragi02.visible = !(flag);
		this.PKisaragi03.visible = !(flag);
  	
	}

	private void motionSit(BasicEntityShip ent, float angleZ)
	{
		
  		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
  		{
this.animTransX += (0F); this.animTransY += (0.5F); this.animTransZ += (0F);
  			
  			PBack.zRot = 0.6F;
  	  		PNeck.zRot = -0.25F;
  	  	    PHead.zRot = -0.3F;
  	    	PLegRight.zRot = -1F;
  		    PLegLeft.zRot = -1F;
  		    PLegRightEnd.zRot = -1.1F;
  		    PLegLeftEnd.zRot = -1.1F;
  		    PTail.zRot = -0.6F;
  	  	    PTailEnd.zRot = -0.6F;
  	  	    PJawBottom.zRot = -0.7F; 	  	    
  		}
  		else
  		{
this.animTransX += (0F); this.animTransY += (0.68F); this.animTransZ += (0F);
  			
  			PBack.zRot = -0.8F;
  	  		PNeck.zRot = -0.3F;
  	    	PLegRight.zRot = -0.8F;
  		    PLegLeft.zRot = -0.8F;
  		    PLegRightEnd.zRot = -1.4F;
  		    PLegLeftEnd.zRot = -1.4F;
  		    PTail.zRot = 0.4F;
  	  	    PTailEnd.zRot = angleZ * 0.2F + 0.4F;
  	  	    PJawBottom.zRot = angleZ * 0.05F -0.3F;
  	  	    PHead.zRot = angleZ * 0.02F + 0.4F;
  		}
  	
	}

	private void motionTail(float angleZ)
	{
 	
  	    PTail.zRot = angleZ * 0.2F;
  	    PTailEnd.zRot = angleZ * 0.3F;
  	    PJawBottom.zRot = angleZ * 0.2F -0.3F;
  	
	}

	private void motionLeg(float f, float f1)
	{

		//移動雙腳 此模型方向設錯 因此改成轉Z
	    PLegRight.zRot = Mth.cos(f * 0.6662F) * 1.4F * f1 - 0.6F;
	    PLegLeft.zRot = Mth.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1 - 0.6F;
	    PLegRightEnd.zRot = Mth.sin(f * 0.6662F) * f1 - 0.4F;
	    PLegLeftEnd.zRot = Mth.sin(f * 0.6662F + 3.1415927F) * f1 - 0.4F;	
	
	}

	private void motionWatch(float f3, float f4, float angleZ)
	{

		//移動頭部 使其看人, 不看人時持續擺動頭部
	    if (f4 != 0)
	    {
		    PNeck.yRot = f3 * 0.006F;		//左右角度
		    PNeck.zRot = f4 * 0.006F; 	//上下角度
		    PHead.yRot = f3 * 0.006F;
		    PHead.zRot = f4 * 0.006F;
		    PTail.yRot = f3 * -0.006F;	//尾巴以反方向擺動
	    }
	    else
	    {
	    	PNeck.yRot = 0;			//左右角度 角度轉成rad 即除以57.29578
		    PNeck.zRot = 0.2F; 		//上下角度
		    PHead.yRot = 0;
		    PHead.zRot = angleZ * 0.15F + 0.2F;
		    PTail.yRot = 0;  	
	    }	
	
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
			PEyeLightL[0].visible = true;
			PEyeLightR[0].visible = true;
			PEyeLightL[1].visible = false;
			PEyeLightR[1].visible = false;
			PEyeLightL[2].visible = false;
			PEyeLightR[2].visible = false;
		break;
		case 1:
			PEyeLightL[0].visible = false;
			PEyeLightR[0].visible = false;
			PEyeLightL[1].visible = true;
			PEyeLightR[1].visible = true;
			PEyeLightL[2].visible = false;
			PEyeLightR[2].visible = false;
		break;
		case 2:
			PEyeLightL[0].visible = false;
			PEyeLightR[0].visible = false;
			PEyeLightL[1].visible = false;
			PEyeLightR[1].visible = false;
			PEyeLightL[2].visible = true;
			PEyeLightR[2].visible = true;
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

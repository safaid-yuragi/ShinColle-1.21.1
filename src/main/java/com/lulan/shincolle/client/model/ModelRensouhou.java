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

public class ModelRensouhou<T extends Entity> extends ShipModel<T> implements IModelEmotion
{

	public ModelPart BodyMain;
	public ModelPart SwimRing;
	public ModelPart Head;
	public ModelPart ArmLeft;
	public ModelPart ArmRight;
	public ModelPart LegLeft;
	public ModelPart LegRight;
	public ModelPart Propeller;
	public ModelPart EarL;
	public ModelPart EarR;
	public ModelPart HeadBack;
	public ModelPart Radar;
	public ModelPart CannonL01;
	public ModelPart CannonR01;
	public ModelPart Face0;
	public ModelPart Face1;
	public ModelPart Face2;
	public ModelPart CannonL02;
	public ModelPart CannonR02;
	private float scale;
	private float offsetY;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-5.0F, -6.0F, -5.0F, 10.0F, 11.0F, 10.0F), PartPose.offset(0.0F, 7.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("ArmLeft", CubeListBuilder.create().addBox(-2.5F, 0.0F, -8.0F, 5.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(5.0F, -4.0F, -4.0F, 1.0471975511965976F, -0.5235987755982988F, 0.0F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("ArmRight", CubeListBuilder.create().addBox(-2.5F, 0.0F, -8.0F, 5.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(-5.0F, -4.0F, -4.0F, 1.0471975511965976F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef3 = partdef0.addOrReplaceChild("SwimRing", CubeListBuilder.create().addBox(-9.0F, 0.0F, -9.0F, 18.0F, 7.0F, 18.0F), PartPose.offset(0.0F, 5.0F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("Propeller", CubeListBuilder.create().addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 2.0F), PartPose.offset(0.0F, 4.0F, 9.0F));
		PartDefinition partdef5 = partdef3.addOrReplaceChild("LegRight", CubeListBuilder.create().addBox(-2.5F, 0.0F, -7.0F, 5.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-4.0F, 6.0F, 0.0F, 0.5235987755982988F, 0.3490658503988659F, 0.0F));
		PartDefinition partdef6 = partdef3.addOrReplaceChild("LegLeft", CubeListBuilder.create().addBox(-2.5F, 0.0F, -7.0F, 5.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(4.0F, 6.0F, 0.0F, 0.5235987755982988F, -0.3490658503988659F, 0.0F));
		PartDefinition partdef7 = partdef0.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-9.0F, -8.0F, -9.0F, 18.0F, 9.0F, 18.0F), PartPose.offset(0.0F, -7.0F, 0.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 9.0F, 0.0F), PartPose.offset(0.0F, -8.0F, -9.1F));
		PartDefinition partdef9 = partdef7.addOrReplaceChild("EarL", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 7.0F), PartPose.offset(7.0F, -11.0F, -9.0F));
		PartDefinition partdef10 = partdef7.addOrReplaceChild("CannonR01", CubeListBuilder.create().addBox(-2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-2.5F, -9.0F, -2.0F, -0.5235987755982988F, 0.03490658503988659F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("CannonR02", CubeListBuilder.create().addBox(-1.5F, -1.5F, -26.0F, 3.0F, 3.0F, 20.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef7.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 9.0F, 0.0F), PartPose.offset(0.0F, -8.0F, -9.1F));
		PartDefinition partdef13 = partdef7.addOrReplaceChild("Radar", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F), PartPose.offset(5.0F, -15.0F, -5.0F));
		PartDefinition partdef14 = partdef7.addOrReplaceChild("CannonL01", CubeListBuilder.create().addBox(-2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(2.5F, -9.0F, -2.0F, -0.5235987755982988F, -0.03490658503988659F, 0.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("CannonL02", CubeListBuilder.create().addBox(-1.5F, -1.5F, -26.0F, 3.0F, 3.0F, 20.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdef7.addOrReplaceChild("HeadBack", CubeListBuilder.create().addBox(-9.0F, 0.0F, 0.0F, 18.0F, 4.0F, 11.0F), PartPose.offset(0.0F, -12.0F, -2.0F));
		PartDefinition partdef17 = partdef7.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 9.0F, 0.0F), PartPose.offset(0.0F, -8.0F, -9.1F));
		PartDefinition partdef18 = partdef7.addOrReplaceChild("EarR", CubeListBuilder.create().mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 7.0F), PartPose.offset(-7.0F, -11.0F, -9.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	public ModelRensouhou(ModelPart root)
	{
		this.CannonL02 = root.getChild("BodyMain").getChild("Head").getChild("CannonL01").getChild("CannonL02");
		this.Propeller = root.getChild("BodyMain").getChild("SwimRing").getChild("Propeller");
		this.LegRight = root.getChild("BodyMain").getChild("SwimRing").getChild("LegRight");
		this.Face2 = root.getChild("BodyMain").getChild("Head").getChild("Face2");
		this.BodyMain = root.getChild("BodyMain");
		this.ArmLeft = root.getChild("BodyMain").getChild("ArmLeft");
		this.EarL = root.getChild("BodyMain").getChild("Head").getChild("EarL");
		this.CannonR02 = root.getChild("BodyMain").getChild("Head").getChild("CannonR01").getChild("CannonR02");
		this.LegLeft = root.getChild("BodyMain").getChild("SwimRing").getChild("LegLeft");
		this.CannonR01 = root.getChild("BodyMain").getChild("Head").getChild("CannonR01");
		this.Face1 = root.getChild("BodyMain").getChild("Head").getChild("Face1");
		this.ArmRight = root.getChild("BodyMain").getChild("ArmRight");
		this.Radar = root.getChild("BodyMain").getChild("Head").getChild("Radar");
		this.CannonL01 = root.getChild("BodyMain").getChild("Head").getChild("CannonL01");
		this.HeadBack = root.getChild("BodyMain").getChild("Head").getChild("HeadBack");
		this.Face0 = root.getChild("BodyMain").getChild("Head").getChild("Face0");
		this.SwimRing = root.getChild("BodyMain").getChild("SwimRing");
		this.EarR = root.getChild("BodyMain").getChild("Head").getChild("EarR");
		this.Head = root.getChild("BodyMain").getChild("Head");
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
    		scale = 1.08F;
        	offsetY = -0.09F;
		break;
    	case 2:
    		scale = 0.81F;
    		offsetY = 0.4F;
		break;
    	case 1:
    		scale = 0.54F;
    		offsetY = 1.32F;
		break;
    	default:
    		scale = 0.27F;
    		offsetY = 4.09F;
		break;
    	}
    	
    	
    	RenderHelper.animScale(this, scale, scale, scale);
this.animTransX += (0F); this.animTransY += (offsetY); this.animTransZ += (0F);
    	
    	//main body

		  
		IShipEmotion ent = (IShipEmotion)entity;
		
		EmotionHelper.rollEmotion(this, ent);
		  
		motionHumanPos(f, f1, f2, f3, f4, ent);
    
	}

	private void motionHumanPos(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{
   
  		float angleX = Mth.cos(f2 * 0.08F);
  		float angleRun = Mth.cos(f) * f1;
  		float addk1 = 0;
  		float addk2 = 0;
  		
  		//leg move parm
  		addk1 = Mth.cos(f * 0.7F) * f1 + 0.7F;
	  	addk2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 + 0.7F;

	    //正常站立動作
	  	//Body
	  	this.Head.yRot = f3 / 57F;
	  	this.BodyMain.xRot = 0F;
	    //arm 
	    this.ArmLeft.xRot = angleX * 0.3F + 0.9F;
		this.ArmRight.xRot = angleX * 0.3F + 0.9F;
		//cannon
		this.CannonL01.xRot = angleX * 0.05F - 0.5F;
		this.CannonR01.xRot = -angleX * 0.05F - 0.5F;
		//propeller
		this.Propeller.zRot = (f2 / 4) % 360;

	    if (f1 > 0.9F)
	    {	//奔跑動作
	    	setFace(2);
	    	//body
	    	this.BodyMain.xRot = 0.2618F;
	    	//arm
	    	this.ArmLeft.xRot = angleRun * 0.3F + 0.9F;
	    	this.ArmRight.xRot = angleRun * 0.3F + 0.9F;
	    	//cannon
			this.CannonL01.xRot = angleRun * 0.05F - 0.5F;
			this.CannonR01.xRot = -angleRun * 0.05F - 0.5F;
			//propeller
			this.Propeller.zRot = (f / 2) % 360;
  		}
	    
	    //攻擊動作    
	    if (ent.getAttackTick() > 0)
	    {
	    	setFace(2);
	    }
	    
	    //leg motion
	    this.LegLeft.xRot = addk1;
	    this.LegRight.xRot = addk2;    
  	
	}

	public void setFace(int emo)
	{

  		switch (emo)
  		{
  		case 0:
  			this.Face0.visible = true;
  			this.Face1.visible = false;
  			this.Face2.visible = false;
  		break;
  		case 1:
  		case 4:
  			this.Face0.visible = false;
  			this.Face1.visible = true;
  			this.Face2.visible = false;
  		break;
  		case 2:
  		case 3:
  			this.Face0.visible = false;
  			this.Face1.visible = false;
  			this.Face2.visible = true;
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

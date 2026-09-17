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

public class ModelRensouhouS<T extends Entity> extends ShipModel<T>
{

	public ModelPart BodyMain;
	public ModelPart HeadBase;
	public ModelPart TailJaw1;
	public ModelPart Head;
	public ModelPart TailHeadCL1;
	public ModelPart TailHeadCR1;
	public ModelPart Tooth02;
	public ModelPart Tube01;
	public ModelPart Tube02;
	public ModelPart Tube03;
	public ModelPart TailHead2;
	public ModelPart Tooth01;
	public ModelPart HeadCannon1;
	public ModelPart HeadCannon2;
	public ModelPart GlowBodyMain;
	public ModelPart GlowHeadBase;
	public ModelPart GlowHead;
	public ModelPart GlowTailJaw1;
	public ModelPart GlowTailHead2;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("HeadBase", CubeListBuilder.create().addBox(-6.0F, -8.0F, 2.0F, 12.0F, 15.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, -0.13962634015954636F, -3.141592653589793F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("TailJaw1", CubeListBuilder.create().addBox(-6.5F, 0.0F, 0.0F, 13.0F, 5.0F, 16.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, -0.3142F, 0.0F, 0.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("Tube03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 11.0F, 1.0F, 1.0F), PartPose.offset(-5.5F, 4.6F, 22.0F));
		PartDefinition partdef4 = partdef2.addOrReplaceChild("Tube01", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F), PartPose.offsetAndRotation(-4.5F, 3.0F, 13.0F, -0.17453292519943295F, -0.05235987755982988F, 0.0F));
		PartDefinition partdef5 = partdef2.addOrReplaceChild("Tube02", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 10.0F), PartPose.offsetAndRotation(4.5F, 3.0F, 13.0F, -0.17453292519943295F, 0.05235987755982988F, 0.0F));
		PartDefinition partdef6 = partdef1.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -0.2F, -3.6F, 14.0F, 8.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -8.5F, 4.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("TailHead2", CubeListBuilder.create().addBox(-7.0F, 0.0F, 0.0F, 14.0F, 8.0F, 13.0F), PartPose.offset(0.0F, -1.0F, 6.5F));
		PartDefinition partdef8 = partdef1.addOrReplaceChild("TailHeadCR1", CubeListBuilder.create().mirror().addBox(-3.0F, -3.0F, -3.0F, 3.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(-5.5F, 0.0F, 9.0F, 0.7853981633974483F, -0.13962634015954636F, 0.0F));
		PartDefinition partdef9 = partdef1.addOrReplaceChild("TailHeadCL1", CubeListBuilder.create().addBox(0.0F, -3.0F, -3.0F, 3.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(5.5F, 0.0F, 9.0F, 0.7853981633974483F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef10 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("GlowHeadBase", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, -0.13962634015954636F, -3.141592653589793F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.5F, 4.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("GlowTailHead2", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 6.5F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("HeadCannon1", CubeListBuilder.create().addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 15.0F), PartPose.offsetAndRotation(3.2F, 3.5F, 12.0F, 0.08726646259971647F, 0.08726646259971647F, 0.017627825445142728F));
		PartDefinition partdef15 = partdef13.addOrReplaceChild("HeadCannon2", CubeListBuilder.create().addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 15.0F), PartPose.offsetAndRotation(-3.2F, 3.5F, 12.0F, 0.08726646259971647F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef16 = partdef12.addOrReplaceChild("Tooth01", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 4.5F, 4.5F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef11.addOrReplaceChild("GlowTailJaw1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, -0.3142F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("Tooth02", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 5.0F, 11.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 4.0F, 0.17453292519943295F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public ModelRensouhouS(ModelPart root)
	{
		this.Tube03 = root.getChild("BodyMain").getChild("HeadBase").getChild("TailJaw1").getChild("Tube03");
		this.HeadBase = root.getChild("BodyMain").getChild("HeadBase");
		this.Tube01 = root.getChild("BodyMain").getChild("HeadBase").getChild("TailJaw1").getChild("Tube01");
		this.HeadCannon1 = root.getChild("GlowBodyMain").getChild("GlowHeadBase").getChild("GlowHead").getChild("GlowTailHead2").getChild("HeadCannon1");
		this.BodyMain = root.getChild("BodyMain");
		this.TailJaw1 = root.getChild("BodyMain").getChild("HeadBase").getChild("TailJaw1");
		this.Tooth02 = root.getChild("GlowBodyMain").getChild("GlowHeadBase").getChild("GlowTailJaw1").getChild("Tooth02");
		this.TailHead2 = root.getChild("BodyMain").getChild("HeadBase").getChild("Head").getChild("TailHead2");
		this.Tooth01 = root.getChild("GlowBodyMain").getChild("GlowHeadBase").getChild("GlowHead").getChild("Tooth01");
		this.Tube02 = root.getChild("BodyMain").getChild("HeadBase").getChild("TailJaw1").getChild("Tube02");
		this.HeadCannon2 = root.getChild("GlowBodyMain").getChild("GlowHeadBase").getChild("GlowHead").getChild("GlowTailHead2").getChild("HeadCannon2");
		this.Head = root.getChild("BodyMain").getChild("HeadBase").getChild("Head");
		this.TailHeadCR1 = root.getChild("BodyMain").getChild("HeadBase").getChild("TailHeadCR1");
		this.TailHeadCL1 = root.getChild("BodyMain").getChild("HeadBase").getChild("TailHeadCL1");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowHeadBase = root.getChild("GlowBodyMain").getChild("GlowHeadBase");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowHeadBase").getChild("GlowHead");
		this.GlowTailJaw1 = root.getChild("GlowBodyMain").getChild("GlowHeadBase").getChild("GlowTailJaw1");
		this.GlowTailHead2 = root.getChild("GlowBodyMain").getChild("GlowHeadBase").getChild("GlowHead").getChild("GlowTailHead2");
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
 
    	
    	RenderHelper.animScale(this, 0.4F, 0.4F, 0.4F);
    	
    	//main body

		  
		IShipEmotion ent = (IShipEmotion)entity;
		
this.animTransX += (0F); this.animTransY += (0.75F); this.animTransZ += (0F);
		
		float angleX = Mth.cos(f2 * 0.1F);
			
		//jaw
		this.TailJaw1.xRot = angleX * 0.05F - 0.3142F;
		//cannon
		this.HeadCannon1.xRot = angleX * 0.1F + 0.15F;
		this.HeadCannon2.xRot = -angleX * 0.1F + 0.15F;
		
		//攻擊動作    
	    if(ent.getAttackTick() > 0) {
	    	this.TailJaw1.xRot = angleX * 0.3F - 0.8F;
	    }
	    
	    this.GlowTailJaw1.xRot = this.TailJaw1.xRot;
    
	}

}

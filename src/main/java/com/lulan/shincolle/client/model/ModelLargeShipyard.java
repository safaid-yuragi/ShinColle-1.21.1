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

public class ModelLargeShipyard<T extends Entity> extends ShipModel<T>
{

	public ModelPart BodyMain;
	public ModelPart Body01;
	public ModelPart Body02;
	public ModelPart Body03;
	public ModelPart Body04;
	public ModelPart Body05;
	public ModelPart Body06;
	public ModelPart Body07;
	public ModelPart Body08;
	public ModelPart Base00;
	public ModelPart Base01;
	public ModelPart Base02;
	public ModelPart Base03;
	public ModelPart Base04;
	public ModelPart Base05;
	public ModelPart Base06;
	public ModelPart Base07;
	public ModelPart Base08;
	public ModelPart Pillar01a;
	public ModelPart Pillar01b;
	public ModelPart Pillar02a;
	public ModelPart Pillar02b;
	public ModelPart Pillar03a;
	public ModelPart Pillar03b;
	public ModelPart Pillar01a_1;
	public ModelPart Pillar01b_1;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(0F, 0.0F, 0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, 18.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Base00", CubeListBuilder.create().addBox(-24.0F, 0.0F, -24.0F, 16.0F, 6.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("Body06", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 20.0F, 6.0F, 10.0F), PartPose.offset(-10.0F, -6.0F, -23.0F));
		PartDefinition partdef3 = partdef0.addOrReplaceChild("Body07", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 12.0F, 7.0F, 14.0F), PartPose.offset(10.0F, -7.0F, -20.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("Pillar01a_1", CubeListBuilder.create().addBox(-4.0F, -10.0F, -4.0F, 9.0F, 10.0F, 9.0F), PartPose.offsetAndRotation(5.0F, 2.0F, 6.0F, -0.17453292519943295F, 0.0F, -0.17453292519943295F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("Pillar01b_1", CubeListBuilder.create().addBox(-3.0F, -8.0F, -3.0F, 6.0F, 8.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -9.0F, 0.5F, -0.17453292519943295F, 0.0F, -0.17453292519943295F));
		PartDefinition partdef6 = partdef0.addOrReplaceChild("Base06", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 7.0F, 16.0F), PartPose.offset(-24.0F, -1.0F, 8.0F));
		PartDefinition partdef7 = partdef0.addOrReplaceChild("Body03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 15.0F, 7.0F, 13.0F), PartPose.offset(-20.6F, -7.0F, 8.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("Pillar02a", CubeListBuilder.create().addBox(-5.5F, -10.0F, -4.5F, 11.0F, 10.0F, 9.0F), PartPose.offsetAndRotation(8.0F, 2.0F, 6.0F, 0.17453292519943295F, 0.0F, 0.17453292519943295F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("Pillar02b", CubeListBuilder.create().addBox(-5.5F, -6.0F, -4.0F, 8.0F, 8.0F, 7.0F), PartPose.offsetAndRotation(2.0F, -10.6F, 0.5F, 0.17453292519943295F, 0.0F, 0.17453292519943295F));
		PartDefinition partdef10 = partdef0.addOrReplaceChild("Body08", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 8.0F, 5.0F, 18.0F), PartPose.offset(15.0F, -5.0F, -10.0F));
		PartDefinition partdef11 = partdef0.addOrReplaceChild("Body02", CubeListBuilder.create().addBox(0.0F, -3.4F, 0.0F, 18.0F, 5.0F, 11.0F), PartPose.offset(-7.0F, -1.5F, 11.0F));
		PartDefinition partdef12 = partdef0.addOrReplaceChild("Base02", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 7.0F, 16.0F), PartPose.offset(8.0F, -1.0F, -24.0F));
		PartDefinition partdef13 = partdef0.addOrReplaceChild("Base01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 8.0F, 16.0F), PartPose.offset(-8.0F, -2.0F, -24.0F));
		PartDefinition partdef14 = partdef0.addOrReplaceChild("Base05", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 8.0F, 16.0F), PartPose.offset(-8.0F, -2.0F, 8.0F));
		PartDefinition partdef15 = partdef0.addOrReplaceChild("Body05", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 12.0F, 5.0F, 15.0F), PartPose.offset(-20.0F, -5.0F, -22.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("Pillar03a", CubeListBuilder.create().addBox(-4.5F, -8.0F, -5.0F, 9.0F, 9.0F, 10.0F), PartPose.offsetAndRotation(6.0F, 1.0F, 7.0F, -0.17453292519943295F, 0.0F, 0.17453292519943295F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("Pillar03b", CubeListBuilder.create().addBox(-3.0F, -6.0F, -3.0F, 6.0F, 8.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -8.5F, 0.0F, -0.17453292519943295F, 0.0F, 0.17453292519943295F));
		PartDefinition partdef18 = partdef0.addOrReplaceChild("Base03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 6.0F, 16.0F), PartPose.offset(8.0F, 0.0F, -8.0F));
		PartDefinition partdef19 = partdef0.addOrReplaceChild("Base04", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 9.0F, 16.0F), PartPose.offset(8.0F, -3.0F, 8.0F));
		PartDefinition partdef20 = partdef0.addOrReplaceChild("Body04", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 12.0F, 4.0F, 20.0F), PartPose.offset(-22.0F, -4.0F, -10.0F));
		PartDefinition partdef21 = partdef0.addOrReplaceChild("Body01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 14.0F, 6.0F, 14.0F), PartPose.offset(7.0F, -6.0F, 6.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("Pillar01a", CubeListBuilder.create().addBox(-5.0F, -10.0F, -5.0F, 10.0F, 10.0F, 10.0F), PartPose.offsetAndRotation(7.0F, 2.0F, 7.0F, 0.17453292519943295F, 0.0F, -0.17453292519943295F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("Pillar01b", CubeListBuilder.create().addBox(-3.0F, -13.3F, -3.0F, 7.0F, 8.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.17453292519943295F, 0.0F, -0.17453292519943295F));
		PartDefinition partdef24 = partdef0.addOrReplaceChild("Base07", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 8.0F, 16.0F), PartPose.offset(-24.0F, -2.0F, -8.0F));
		PartDefinition partdef25 = partdef0.addOrReplaceChild("Base08", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 5.0F, 16.0F), PartPose.offset(-8.0F, 1.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	public ModelLargeShipyard(ModelPart root)
	{
		this.Body06 = root.getChild("BodyMain").getChild("Body06");
		this.Body07 = root.getChild("BodyMain").getChild("Body07");
		this.Base06 = root.getChild("BodyMain").getChild("Base06");
		this.Body03 = root.getChild("BodyMain").getChild("Body03");
		this.Body08 = root.getChild("BodyMain").getChild("Body08");
		this.Pillar01b_1 = root.getChild("BodyMain").getChild("Body07").getChild("Pillar01a_1").getChild("Pillar01b_1");
		this.Pillar03b = root.getChild("BodyMain").getChild("Body05").getChild("Pillar03a").getChild("Pillar03b");
		this.Body02 = root.getChild("BodyMain").getChild("Body02");
		this.Pillar02a = root.getChild("BodyMain").getChild("Body03").getChild("Pillar02a");
		this.Base02 = root.getChild("BodyMain").getChild("Base02");
		this.Base01 = root.getChild("BodyMain").getChild("Base01");
		this.Base05 = root.getChild("BodyMain").getChild("Base05");
		this.Body05 = root.getChild("BodyMain").getChild("Body05");
		this.Pillar01a_1 = root.getChild("BodyMain").getChild("Body07").getChild("Pillar01a_1");
		this.Pillar02b = root.getChild("BodyMain").getChild("Body03").getChild("Pillar02a").getChild("Pillar02b");
		this.Pillar01a = root.getChild("BodyMain").getChild("Body01").getChild("Pillar01a");
		this.Base03 = root.getChild("BodyMain").getChild("Base03");
		this.Base04 = root.getChild("BodyMain").getChild("Base04");
		this.Body04 = root.getChild("BodyMain").getChild("Body04");
		this.Pillar01b = root.getChild("BodyMain").getChild("Body01").getChild("Pillar01a").getChild("Pillar01b");
		this.Body01 = root.getChild("BodyMain").getChild("Body01");
		this.Base07 = root.getChild("BodyMain").getChild("Base07");
		this.BodyMain = root.getChild("BodyMain");
		this.Base00 = root.getChild("BodyMain").getChild("Base00");
		this.Base08 = root.getChild("BodyMain").getChild("Base08");
		this.Pillar03a = root.getChild("BodyMain").getChild("Body05").getChild("Pillar03a");
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
    	
		glowLight = true;
    	this.BodyMain.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
    	poseStack.popPose();
    	
    
	}

	public void renderModel(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay)
	{

    	this.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, -1);
    
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
	}

}

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

public class ModelSmallShipyard<T extends Entity> extends ShipModel<T>
{

	//fields
	private ModelPart Shape1;
	private ModelPart Shape2;
	private ModelPart Shape3;
	private ModelPart Shape4;
	private ModelPart Shape5;
	private ModelPart Shape6;
	private ModelPart Shape7;
	private ModelPart Shape8;
	private ModelPart Shape9;
	private ModelPart Shape10;
	private ModelPart Shape11;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("Shape1", CubeListBuilder.create().mirror().addBox(0F, 0F, 0F, 16.0F, 1.0F, 16.0F), PartPose.offset(-8F, 23F, -8F));
		PartDefinition partdef1 = partdefinition.addOrReplaceChild("Shape2", CubeListBuilder.create().mirror().addBox(0F, 0F, 0F, 14.0F, 3.0F, 10.0F), PartPose.offset(-7F, 20F, -3F));
		PartDefinition partdef2 = partdefinition.addOrReplaceChild("Shape3", CubeListBuilder.create().mirror().addBox(-5F, 0F, 0F, 6.0F, 4.0F, 6.0F), PartPose.offset(-1F, 17F, -1.5F));
		PartDefinition partdef3 = partdefinition.addOrReplaceChild("Shape4", CubeListBuilder.create().mirror().addBox(0F, 0F, 0F, 4.0F, 6.0F, 4.0F), PartPose.offset(-5F, 11F, -1F));
		PartDefinition partdef4 = partdefinition.addOrReplaceChild("Shape5", CubeListBuilder.create().mirror().addBox(0F, 0F, 0F, 3.0F, 3.0F, 3.0F), PartPose.offset(-4.5F, 8F, -0.5F));
		PartDefinition partdef5 = partdefinition.addOrReplaceChild("Shape6", CubeListBuilder.create().mirror().addBox(0F, 0F, 0F, 10.0F, 3.0F, 6.0F), PartPose.offset(-3.5F, 18F, 0F));
		PartDefinition partdef6 = partdefinition.addOrReplaceChild("Shape7", CubeListBuilder.create().mirror().addBox(0F, 0F, 0F, 4.0F, 3.0F, 4.0F), PartPose.offset(2F, 15F, 1.5F));
		PartDefinition partdef7 = partdefinition.addOrReplaceChild("Shape8", CubeListBuilder.create().mirror().addBox(0F, 0F, 0F, 3.0F, 3.0F, 3.0F), PartPose.offset(2.5F, 12.5F, 2F));
		PartDefinition partdef8 = partdefinition.addOrReplaceChild("Shape9", CubeListBuilder.create().mirror().addBox(0F, 1F, 0F, 11.0F, 2.0F, 4.0F), PartPose.offset(-5F, 20F, -7F));
		PartDefinition partdef9 = partdefinition.addOrReplaceChild("Shape10", CubeListBuilder.create().mirror().addBox(-2F, 0F, 0F, 4.0F, 2.0F, 4.0F), PartPose.offset(1F, 19F, -6.5F));
		PartDefinition partdef10 = partdefinition.addOrReplaceChild("Shape11", CubeListBuilder.create().mirror().addBox(0F, 0F, 0F, 3.0F, 3.0F, 3.0F), PartPose.offset(-0.5F, 16.01333F, -6F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	public ModelSmallShipyard(ModelPart root)
	{
		this.Shape1 = root.getChild("Shape1");
		this.Shape2 = root.getChild("Shape2");
		this.Shape3 = root.getChild("Shape3");
		this.Shape4 = root.getChild("Shape4");
		this.Shape5 = root.getChild("Shape5");
		this.Shape6 = root.getChild("Shape6");
		this.Shape7 = root.getChild("Shape7");
		this.Shape8 = root.getChild("Shape8");
		this.Shape9 = root.getChild("Shape9");
		this.Shape10 = root.getChild("Shape10");
		this.Shape11 = root.getChild("Shape11");
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
		Shape1.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape2.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape3.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape4.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape5.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape6.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape7.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape8.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape9.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape10.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape11.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
	
	}

	public void renderModel(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay)
	{

		Shape1.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape2.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape3.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape4.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape5.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape6.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape7.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape8.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape9.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape10.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
		Shape11.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
	
	}

	@Override
	public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)
	{
		this.captureAnimParms(entity, f, f1, f2, f3, f4);


	
	}

}

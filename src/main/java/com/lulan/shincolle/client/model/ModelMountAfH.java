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

public class ModelMountAfH<T extends Entity> extends ShipModel<T>
{

	public ModelPart BodyMain;
	public ModelPart ChestCannon01a;
	public ModelPart ChestCannon02a;
	public ModelPart ChestCannon03a;
	public ModelPart EquipBaseL;
	public ModelPart EquipBaseR;
	public ModelPart Neck;
	public ModelPart EquipL01;
	public ModelPart EquipL02;
	public ModelPart EquipCannonPlate;
	public ModelPart EquipCannon01;
	public ModelPart EquipCannon02;
	public ModelPart EquipR01;
	public ModelPart EquipR02;
	public ModelPart EquipCannonPlate_1;
	public ModelPart EquipCannon01_1;
	public ModelPart EquipCannon02_1;
	public ModelPart Head;
	public ModelPart Jaw;
	public ModelPart HeadBack01;
	public ModelPart NeckBack;
	public ModelPart HeadBack03;
	public ModelPart NeckFront;
	public ModelPart CannonBase;
	public ModelPart HeadTooth;
	public ModelPart HeadTooth2;
	public ModelPart JawTooth;
	public ModelPart JawTooth2;
	public ModelPart Cannon01;
	public ModelPart Cannon02;
	public ModelPart Cannon03;
	public ModelPart Cannon04;
	public ModelPart Cannon05;
	public ModelPart Cannon06;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowJaw;
	public ModelPart GlowHead;
	public ModelPart GlowCannonBase;
	public ModelPart GlowCannon04;
	public ModelPart GlowEquipBaseL;
	public ModelPart GlowEquipL01;
	public ModelPart GlowEquipL02;
	public ModelPart GlowEquipBaseR;
	public ModelPart GlowEquipR01;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-9.0F, -7.0F, 10.0F, 18.0F, 12.0F, 9.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("ChestCannon01a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 5.0F, 17.0F), PartPose.offsetAndRotation(3.3F, 6.0F, -2.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("EquipBaseL", CubeListBuilder.create().addBox(-6.0F, 0.0F, -10.0F, 11.0F, 6.0F, 21.0F), PartPose.offsetAndRotation(14.5F, 2.0F, 5.0F, 0.0F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("EquipL01", CubeListBuilder.create().addBox(-6.0F, 0.0F, -7.0F, 10.0F, 9.0F, 20.0F), PartPose.offsetAndRotation(0.0F, -8.0F, 1.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("EquipL02", CubeListBuilder.create().addBox(-6.5F, 0.0F, -9.0F, 11.0F, 4.0F, 23.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("ChestCannon03a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 5.0F, 17.0F), PartPose.offsetAndRotation(-8.3F, 6.0F, -2.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-7.5F, -15.0F, -3.0F, 15.0F, 15.0F, 14.0F), PartPose.offsetAndRotation(-29.0F, 5.0F, 6.0F, 0.0F, 0.2617993877991494F, 0.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("CannonBase", CubeListBuilder.create().addBox(-4.0F, -14.0F, 0.0F, 10.0F, 14.0F, 4.0F), PartPose.offsetAndRotation(-1.0F, -16.0F, 7.0F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("Cannon01", CubeListBuilder.create().addBox(0.0F, 0.0F, -10.0F, 3.0F, 3.0F, 10.0F), PartPose.offset(2.0F, -9.0F, 0.0F));
		PartDefinition partdef9 = partdef7.addOrReplaceChild("Cannon02", CubeListBuilder.create().addBox(0.0F, 0.0F, -10.0F, 3.0F, 3.0F, 10.0F), PartPose.offset(-3.0F, -9.0F, 0.0F));
		PartDefinition partdef10 = partdef7.addOrReplaceChild("Cannon05", CubeListBuilder.create().addBox(0.0F, 0.0F, -10.0F, 2.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -14.6F, 0.5F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef7.addOrReplaceChild("Cannon04", CubeListBuilder.create().addBox(0.0F, 0.0F, -13.0F, 4.0F, 4.0F, 13.0F), PartPose.offsetAndRotation(1.0F, -13.5F, 0.0F, 0.0F, 0.0F, 0.7853981633974483F));
		PartDefinition partdef12 = partdef7.addOrReplaceChild("Cannon03", CubeListBuilder.create().addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F), PartPose.offset(-3.5F, -11.3F, 0.0F));
		PartDefinition partdef13 = partdef6.addOrReplaceChild("HeadBack03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 8.0F, 18.0F, 8.0F), PartPose.offsetAndRotation(-4.0F, -16.1F, 14.5F, 0.091106186954104F, 0.0F, 0.0F));
		PartDefinition partdef14 = partdef6.addOrReplaceChild("NeckBack", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 5.0F, 5.0F), PartPose.offset(-2.0F, -6.0F, 11.0F));
		PartDefinition partdef15 = partdef6.addOrReplaceChild("HeadBack01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 11.0F), PartPose.offsetAndRotation(-4.0F, -18.0F, 8.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdef6.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-9.5F, -7.0F, -22.0F, 19.0F, 10.0F, 24.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 7.0F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef6.addOrReplaceChild("Jaw", CubeListBuilder.create().mirror().addBox(-9.5F, 0.0F, -15.0F, 19.0F, 7.0F, 19.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 0.5F, 0.5462880558742251F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef0.addOrReplaceChild("EquipBaseR", CubeListBuilder.create().addBox(-6.0F, 0.0F, -10.0F, 11.0F, 6.0F, 21.0F), PartPose.offsetAndRotation(-13.5F, 2.0F, 5.0F, 0.0F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("EquipR01", CubeListBuilder.create().addBox(-5.0F, 0.0F, -7.0F, 10.0F, 9.0F, 20.0F), PartPose.offsetAndRotation(0.0F, -8.0F, 1.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("EquipR02", CubeListBuilder.create().addBox(-5.5F, 0.0F, -9.0F, 11.0F, 4.0F, 23.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef21 = partdef0.addOrReplaceChild("ChestCannon02a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 5.0F, 17.0F), PartPose.offsetAndRotation(-2.5F, 6.0F, -2.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(-29.0F, 5.0F, 6.0F, 0.0F, 0.2617993877991494F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("GlowJaw", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 0.5F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("JawTooth", CubeListBuilder.create().addBox(-9.0F, 0.0F, -14.0F, 18.0F, 3.0F, 14.0F), PartPose.offsetAndRotation(0.0F, -1.6F, -0.3F, -0.08726646259971647F, -0.02234021442552742F, 0.0F));
		PartDefinition partdef26 = partdef24.addOrReplaceChild("JawTooth2", CubeListBuilder.create().mirror().addBox(-8.0F, 0.0F, -13.0F, 16.0F, 3.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -2.6F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef23.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 7.0F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("HeadTooth", CubeListBuilder.create().addBox(-9.0F, 0.0F, -6.5F, 18.0F, 4.0F, 15.0F), PartPose.offsetAndRotation(0.0F, 2.0F, -15.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef29 = partdef27.addOrReplaceChild("HeadTooth2", CubeListBuilder.create().mirror().addBox(-8.0F, 0.0F, -14.0F, 16.0F, 3.0F, 14.0F), PartPose.offsetAndRotation(0.0F, 3.6F, -6.5F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdef23.addOrReplaceChild("NeckFront", CubeListBuilder.create().addBox(-6.5F, 0.0F, 0.0F, 13.0F, 14.0F, 2.0F), PartPose.offset(0.0F, -14.0F, -5.0F));
		PartDefinition partdef31 = partdef23.addOrReplaceChild("GlowCannonBase", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, -16.0F, 7.0F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("GlowCannon04", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -13.5F, 0.0F, 0.0F, 0.0F, 0.7853981633974483F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("Cannon06", CubeListBuilder.create().addBox(0.0F, 0.0F, -15.0F, 2.0F, 2.0F, 15.0F), PartPose.offset(1.0F, 1.0F, -13.0F));
		PartDefinition partdef34 = partdef22.addOrReplaceChild("GlowEquipBaseL", CubeListBuilder.create(), PartPose.offsetAndRotation(14.5F, 2.0F, 5.0F, 0.0F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("GlowEquipL01", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.0F, 1.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("GlowEquipL02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef37 = partdef35.addOrReplaceChild("EquipCannonPlate", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 6.0F, 1.0F), PartPose.offset(-2.0F, 2.0F, -8.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("EquipCannon01", CubeListBuilder.create().addBox(0.0F, 0.0F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(1.5F, 1.0F, 0.5F, -0.31869712141416456F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef39 = partdef37.addOrReplaceChild("EquipCannon02", CubeListBuilder.create().addBox(0.0F, 0.0F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(1.5F, 4.0F, 0.5F, 0.0F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef40 = partdef22.addOrReplaceChild("GlowEquipBaseR", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.5F, 2.0F, 5.0F, 0.0F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("GlowEquipR01", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.0F, 1.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("EquipCannonPlate_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 6.0F, 1.0F), PartPose.offset(-2.0F, 2.0F, -8.0F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("EquipCannon01_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(1.5F, 1.0F, 0.5F, -0.18203784098300857F, 0.136659280431156F, 0.0F));
		PartDefinition partdef44 = partdef42.addOrReplaceChild("EquipCannon02_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(1.5F, 4.0F, 0.5F, 0.18203784098300857F, 0.091106186954104F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelMountAfH(ModelPart root)
	{
		this.EquipCannon02_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseR").getChild("GlowEquipR01").getChild("EquipCannonPlate_1").getChild("EquipCannon02_1");
		this.EquipCannon02 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("EquipCannonPlate").getChild("EquipCannon02");
		this.EquipR02 = root.getChild("BodyMain").getChild("EquipBaseR").getChild("EquipR01").getChild("EquipR02");
		this.Cannon01 = root.getChild("BodyMain").getChild("Neck").getChild("CannonBase").getChild("Cannon01");
		this.HeadTooth = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadTooth");
		this.EquipL01 = root.getChild("BodyMain").getChild("EquipBaseL").getChild("EquipL01");
		this.Cannon02 = root.getChild("BodyMain").getChild("Neck").getChild("CannonBase").getChild("Cannon02");
		this.JawTooth = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw").getChild("JawTooth");
		this.Cannon05 = root.getChild("BodyMain").getChild("Neck").getChild("CannonBase").getChild("Cannon05");
		this.CannonBase = root.getChild("BodyMain").getChild("Neck").getChild("CannonBase");
		this.ChestCannon01a = root.getChild("BodyMain").getChild("ChestCannon01a");
		this.EquipBaseL = root.getChild("BodyMain").getChild("EquipBaseL");
		this.Cannon04 = root.getChild("BodyMain").getChild("Neck").getChild("CannonBase").getChild("Cannon04");
		this.Cannon03 = root.getChild("BodyMain").getChild("Neck").getChild("CannonBase").getChild("Cannon03");
		this.HeadBack03 = root.getChild("BodyMain").getChild("Neck").getChild("HeadBack03");
		this.ChestCannon03a = root.getChild("BodyMain").getChild("ChestCannon03a");
		this.NeckBack = root.getChild("BodyMain").getChild("Neck").getChild("NeckBack");
		this.Cannon06 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowCannonBase").getChild("GlowCannon04").getChild("Cannon06");
		this.HeadBack01 = root.getChild("BodyMain").getChild("Neck").getChild("HeadBack01");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.EquipBaseR = root.getChild("BodyMain").getChild("EquipBaseR");
		this.EquipCannon01_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseR").getChild("GlowEquipR01").getChild("EquipCannonPlate_1").getChild("EquipCannon01_1");
		this.HeadTooth2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadTooth2");
		this.EquipR01 = root.getChild("BodyMain").getChild("EquipBaseR").getChild("EquipR01");
		this.EquipCannonPlate_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseR").getChild("GlowEquipR01").getChild("EquipCannonPlate_1");
		this.EquipCannonPlate = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("EquipCannonPlate");
		this.Jaw = root.getChild("BodyMain").getChild("Neck").getChild("Jaw");
		this.EquipCannon01 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("EquipCannonPlate").getChild("EquipCannon01");
		this.NeckFront = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("NeckFront");
		this.EquipL02 = root.getChild("BodyMain").getChild("EquipBaseL").getChild("EquipL01").getChild("EquipL02");
		this.ChestCannon02a = root.getChild("BodyMain").getChild("ChestCannon02a");
		this.JawTooth2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw").getChild("JawTooth2");
		this.BodyMain = root.getChild("BodyMain");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowJaw = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.GlowCannonBase = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowCannonBase");
		this.GlowCannon04 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowCannonBase").getChild("GlowCannon04");
		this.GlowEquipBaseL = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL");
		this.GlowEquipL01 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01");
		this.GlowEquipL02 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowEquipL02");
		this.GlowEquipBaseR = root.getChild("GlowBodyMain").getChild("GlowEquipBaseR");
		this.GlowEquipR01 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseR").getChild("GlowEquipR01");
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
    	
    	
    	RenderHelper.animScale(this, 0.7F, 0.7F, 0.7F);
this.animTransX += (0F); this.animTransY += (1.10F); this.animTransZ += (-0.47F);
    	
    	//main body

		
		IShipEmotion ent = (IShipEmotion)entity;
		  
		motionHumanPos(f, f1, f2, f3, f4, ent);
    
	}

	private void motionHumanPos(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{
   
  		float angleX = Mth.cos(f2*0.08F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.7F;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.7F;
  		float addk1 = 0F;
  		float addk2 = 0F;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.025F + 0.025F); this.animTransZ += (0F);
    	}

	    //正常站立動作
	  	//嘴巴
	  	this.Jaw.xRot = angleX * 0.1F + 0.4F;
	  	this.GlowJaw.xRot = this.Jaw.xRot;
	    //cannon
	    this.EquipCannon01.xRot = angleX * 0.08F - 0.32F;
	    this.EquipCannon02.xRot = -angleX * 0.14F;
	    this.EquipCannon01_1.xRot = -angleX * 0.12F - 0.18F;
	    this.EquipCannon02_1.xRot = angleX * 0.08F + 0.18F;
	    
	    if (ent.getStateEmotion(ID.S.Emotion) > 0)
	    {
//	    	this.ArmRight01.xRot = -1.57F;
	    }
  	
	}

}

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

public class ModelCarrierWDemon<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart Butt;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart Cloth01;
	public ModelPart EquipBase;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart HeadS01;
	public ModelPart HeadS04;
	public ModelPart HeadS05;
	public ModelPart Ahoke;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart HairL02;
	public ModelPart HairR02;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart Hair03;
	public ModelPart HeadS02;
	public ModelPart HeadS03;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart Skirt01;
	public ModelPart LegRight02;
	public ModelPart ShoesR01;
	public ModelPart ShoesR02;
	public ModelPart ShoesR03;
	public ModelPart ShoesR04;
	public ModelPart LegLeft02;
	public ModelPart ShoesL01;
	public ModelPart ShoesL02;
	public ModelPart ShoesL03;
	public ModelPart ShoesL04;
	public ModelPart Skirt02;
	public ModelPart ArmLeft02;
	public ModelPart ArmLeft03;
	public ModelPart ArmLeft04;
	public ModelPart ArmLeft05;
	public ModelPart ArmRight02;
	public ModelPart ArmRight03;
	public ModelPart ArmRight04;
	public ModelPart ArmRight05;
	public ModelPart EquipL01;
	public ModelPart EquipR01;
	public ModelPart EquipL02;
	public ModelPart EquipL03;
	public ModelPart EquipL04;
	public ModelPart EquipL05;
	public ModelPart EquipR02;
	public ModelPart EquipR03;
	public ModelPart EquipR04;
	public ModelPart EquipR05;
	public ModelPart GlowBodyMain;
	public ModelPart GlowBodyMain2;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 6.0F, 7.0F, 0.0F), PartPose.offset(0.5F, -4.7F, -6.3F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(-7.8F, -9.3F, -0.7F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(-0.5F, 3.0F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("ArmRight03", CubeListBuilder.create().addBox(-1.5F, 0.0F, -6.5F, 7.0F, 8.0F, 7.0F), PartPose.offset(-2.0F, 10.0F, 3.0F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("ArmRight04", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 4.0F, 8.0F), PartPose.offsetAndRotation(2.0F, 8.0F, -3.0F, 0.0F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("ArmRight05", CubeListBuilder.create().addBox(-2.5F, 0.0F, -3.0F, 5.0F, 5.0F, 6.0F), PartPose.offset(0.0F, 0.5F, 0.0F));
		PartDefinition partdef7 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(7.8F, -9.3F, -0.7F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(0.5F, 3.0F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("ArmLeft03", CubeListBuilder.create().mirror().addBox(-5.5F, 0.0F, -6.5F, 7.0F, 8.0F, 7.0F), PartPose.offset(2.0F, 10.0F, 3.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("ArmLeft04", CubeListBuilder.create().mirror().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 4.0F, 8.0F), PartPose.offsetAndRotation(-2.0F, 8.0F, -3.0F, 0.0F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("ArmLeft05", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -3.0F, 5.0F, 5.0F, 6.0F), PartPose.offset(0.0F, 0.5F, 0.0F));
		PartDefinition partdef12 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 4.0F, 1.3F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offset(4.8F, 5.5F, -2.6F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 6.0F), PartPose.offset(0.0F, 14.0F, -3.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("ShoesL01", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 1.0F, 2.6F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("ShoesL02", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -4.0F, 7.0F, 4.0F, 8.0F), PartPose.offset(0.0F, 3.0F, -0.7F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("ShoesL03", CubeListBuilder.create().mirror().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 4.0F, 8.0F), PartPose.offset(0.0F, 4.0F, -0.9F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("ShoesL04", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, -0.12F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef12.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -6.0F, 17.0F, 4.0F, 9.0F), PartPose.offset(0.0F, 2.9F, 0.0F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-9.0F, 0.0F, -6.0F, 18.0F, 4.0F, 10.0F), PartPose.offset(0.0F, 2.8F, -0.5F));
		PartDefinition partdef21 = partdef12.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offset(-4.8F, 5.5F, -2.6F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 6.0F), PartPose.offset(0.0F, 14.0F, -3.0F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("ShoesR01", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 1.0F, 2.6F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("ShoesR02", CubeListBuilder.create().addBox(-3.5F, 0.0F, -4.0F, 7.0F, 4.0F, 8.0F), PartPose.offset(0.0F, 3.0F, -0.7F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("ShoesR03", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 4.0F, 8.0F), PartPose.offset(0.0F, 4.0F, -0.9F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("ShoesR04", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, -0.12F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(3.7F, -8.1F, -3.7F, -0.6981317007977318F, 0.13962634015954636F, 0.08726646259971647F));
		PartDefinition partdef28 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-3.7F, -8.1F, -3.7F, -0.6981317007977318F, -0.13962634015954636F, -0.08726646259971647F));
		PartDefinition partdef29 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-5.5F, -2.0F, -5.0F, 11.0F, 3.0F, 9.0F), PartPose.offset(0.0F, -10.3F, -0.2F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.2F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -4.0F, -11.5F, 0.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -9.0F, -5.5F, 0.0F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef33 = partdef31.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(-7.0F, 3.0F, -5.5F, -0.13962634015954636F, 0.17453292519943295F, 0.08726646259971647F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(0.2F, 7.0F, 0.0F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef35 = partdef31.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(7.0F, 3.0F, -5.5F, -0.13962634015954636F, -0.17453292519943295F, -0.08726646259971647F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef37 = partdef30.addOrReplaceChild("HeadS05", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(-8.1F, -7.5F, -6.7F, 0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef38 = partdef30.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 10.0F), PartPose.offset(0.0F, -15.0F, -3.0F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 17.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef40 = partdef39.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("Hair03", CubeListBuilder.create().addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 12.5F, -0.1F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef42 = partdef30.addOrReplaceChild("HeadS01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -14.0F, -7.4F, 0.0F, 0.0F, 0.7853981633974483F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("HeadS03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F), PartPose.offset(-2.5F, 2.9F, 0.0F));
		PartDefinition partdef44 = partdef42.addOrReplaceChild("HeadS02", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F), PartPose.offset(2.9F, -2.5F, 0.0F));
		PartDefinition partdef45 = partdef30.addOrReplaceChild("HeadS04", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(8.1F, -7.5F, -6.7F, 0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef46 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offset(0.0F, -10.3F, -0.2F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef50 = partdef48.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef51 = partdef48.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef52 = partdef48.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef53 = partdef48.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef54 = partdef48.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef55 = partdef48.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef56 = partdef48.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef57 = partdef48.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef58 = partdef48.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));
		PartDefinition partdef59 = partdefinition.addOrReplaceChild("GlowBodyMain2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef60 = partdef59.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, -23.0F, 0.0F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("EquipL01", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -3.5F, 2.0F, 2.0F, 7.0F), PartPose.offset(30.0F, 0.0F, 0.0F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("EquipL02", CubeListBuilder.create().mirror().addBox(-0.5F, 0.0F, -10.0F, 3.0F, 2.0F, 20.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("EquipL03", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -8.5F, 2.0F, 9.0F, 17.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition partdef64 = partdef63.addOrReplaceChild("EquipL04", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -6.5F, 2.0F, 9.0F, 13.0F), PartPose.offset(0.0F, 9.0F, 0.0F));
		PartDefinition partdef65 = partdef64.addOrReplaceChild("EquipL05", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -4.5F, 2.0F, 9.0F, 9.0F), PartPose.offset(0.0F, 9.0F, 0.0F));
		PartDefinition partdef66 = partdef60.addOrReplaceChild("EquipR01", CubeListBuilder.create().addBox(-2.0F, 0.0F, -3.5F, 2.0F, 2.0F, 7.0F), PartPose.offset(-30.0F, 0.0F, 0.0F));
		PartDefinition partdef67 = partdef66.addOrReplaceChild("EquipR02", CubeListBuilder.create().addBox(-2.5F, 0.0F, -10.0F, 3.0F, 2.0F, 20.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition partdef68 = partdef67.addOrReplaceChild("EquipR03", CubeListBuilder.create().addBox(-2.0F, 0.0F, -8.5F, 2.0F, 9.0F, 17.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition partdef69 = partdef68.addOrReplaceChild("EquipR04", CubeListBuilder.create().addBox(-2.0F, 0.0F, -6.5F, 2.0F, 9.0F, 13.0F), PartPose.offset(0.0F, 9.0F, 0.0F));
		PartDefinition partdef70 = partdef69.addOrReplaceChild("EquipR05", CubeListBuilder.create().addBox(-2.0F, 0.0F, -4.5F, 2.0F, 9.0F, 9.0F), PartPose.offset(0.0F, 9.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelCarrierWDemon(ModelPart root)
	{
		this.Face0 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("Face0");
		this.Face1 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("Face1");
		this.Face2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("Face2");
		this.Face3 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("Face3");
		this.Face4 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("Face4");
		this.Mouth0 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("Mouth0");
		this.Mouth1 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("Mouth1");
		this.Mouth2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("Mouth2");
		this.Flush0 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("Flush0");
		this.Flush1 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("Flush1");
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.HeadS05 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadS05");
		this.ArmLeft03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.EquipBase = root.getChild("GlowBodyMain2").getChild("EquipBase");
		this.EquipL04 = root.getChild("GlowBodyMain2").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.HairR02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.EquipL02 = root.getChild("GlowBodyMain2").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.HeadS03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadS01").getChild("HeadS03");
		this.ShoesL04 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoesL01").getChild("ShoesL02").getChild("ShoesL03").getChild("ShoesL04");
		this.HeadS02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadS01").getChild("HeadS02");
		this.ShoesR04 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoesR01").getChild("ShoesR02").getChild("ShoesR03").getChild("ShoesR04");
		this.ShoesL02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoesL01").getChild("ShoesL02");
		this.ArmLeft05 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04").getChild("ArmLeft05");
		this.EquipL01 = root.getChild("GlowBodyMain2").getChild("EquipBase").getChild("EquipL01");
		this.ArmLeft04 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.BodyMain = root.getChild("BodyMain");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.HairL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.ShoesR03 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoesR01").getChild("ShoesR02").getChild("ShoesR03");
		this.EquipL03 = root.getChild("GlowBodyMain2").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03");
		this.EquipR01 = root.getChild("GlowBodyMain2").getChild("EquipBase").getChild("EquipR01");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.EquipL05 = root.getChild("GlowBodyMain2").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipL05");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.EquipR05 = root.getChild("GlowBodyMain2").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipR05");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.HeadS01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadS01");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.EquipR03 = root.getChild("GlowBodyMain2").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.EquipR04 = root.getChild("GlowBodyMain2").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.ArmRight05 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03").getChild("ArmRight04").getChild("ArmRight05");
		this.Hair03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02").getChild("Hair03");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.ShoesL03 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoesL01").getChild("ShoesL02").getChild("ShoesL03");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.ShoesR01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoesR01");
		this.ShoesL01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoesL01");
		this.HeadS04 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadS04");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.ArmRight04 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03").getChild("ArmRight04");
		this.ArmRight03 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03");
		this.EquipR02 = root.getChild("GlowBodyMain2").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.ShoesR02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoesR01").getChild("ShoesR02");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.GlowBodyMain2 = root.getChild("GlowBodyMain2");
		this.scale = 0.47F;
		this.offsetY = 1.7F;
		this.offsetItem = new float[] {0.06F, 0.98F, -0.06F};
		this.offsetBlock = new float[] {0.06F, 0.98F, -0.06F};
		this.HeadS01.xScale = 1.0F;
		this.HeadS01.yScale = 0.7F;
		this.HeadS01.zScale = 1F;
		this.HeadS01.x = (this.HeadS01.x + (0F) * 16F) * this.HeadS01.xScale;
		this.HeadS01.y = (this.HeadS01.y + (-0.25F) * 16F) * this.HeadS01.yScale;
		this.HeadS01.z = (this.HeadS01.z + (0F) * 16F) * this.HeadS01.zScale;
		this.armMain = new ModelPart[] {this.BodyMain, this.ArmRight01, this.ArmRight02, this.ArmRight03};
		this.armOff = new ModelPart[] {this.BodyMain, this.ArmLeft01, this.ArmLeft02, this.ArmLeft03};
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
    	this.BodyMain.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
    	//light part
		glowLight = true;
    	this.GlowBodyMain.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	float light = 80F + Mth.cos(f2 * 0.075F) * 80F;
		glowLight = false;
    	this.GlowBodyMain2.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
    	//reset light
    	int j = packedLight;
        int k = j % 65536;
        int l = j / 65536;
		glowLight = false;
    	
    	poseStack.popPose();
    
	}

	public void showEquip(IShipEmotion ent)
	{

		this.EquipBase.visible = !(!EmotionHelper.checkModelState(1, ent.getStateEmotion(ID.S.State)));
	
	}

	public void syncRotationGlowPart()
	{

		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowBodyMain2.xRot = this.BodyMain.xRot;
		this.GlowBodyMain2.yRot = this.BodyMain.yRot;
		this.GlowBodyMain2.zRot = this.BodyMain.zRot;
		this.GlowNeck.xRot = this.Neck.xRot;
		this.GlowNeck.yRot = this.Neck.yRot;
		this.GlowNeck.zRot = this.Neck.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (0.48F); this.animTransZ += (0F);
  		this.setFaceHungry(ent);
  		
  	    //頭部
	  	this.Head.xRot = 0F; 	//上下角度
	  	this.Head.yRot = 0F;	//左右角度
	  	this.Head.zRot = 0F;
	    //正常站立動作
	    //胸部
  	    this.BoobL.xRot = -0.7F;
  	    this.BoobR.xRot = -0.7F;
	  	//Body
  	    this.Ahoke.yRot = 0.7F;
	  	this.BodyMain.xRot = -0.1047F;
	  	//hair
	  	this.Hair01.xRot = 0.21F;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -0.09F;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -0.14F;
	  	this.Hair03.zRot = 0F;
	  	//鬢毛調整
	    this.Hair01.zRot = 0F;
	  	this.Hair02.zRot = 0F;
	  	this.HairL01.zRot = 0.087F;
	  	this.HairL02.zRot = 0.087F;
	  	this.HairR01.zRot = 0.087F;
	  	this.HairR02.zRot = -0.052F;
		this.HairL01.xRot = -0.65F;
	  	this.HairL02.xRot = 0.17F;
	  	this.HairR01.xRot = -0.65F;
	  	this.HairR02.xRot = 0.17F;
	    //arm 
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft05.zRot = 0.2618F;
	  	this.ArmRight01.yRot = 0F;
	    this.ArmRight03.xRot = 0F;
	    this.ArmRight03.zRot = 0F;
		//leg
	    this.LegLeft01.xRot = -1.0472F;
		this.LegLeft01.yRot = 0F;
		this.ShoesL04.xRot = -0.1F;
		this.LegRight01.xRot = -1.0472F;
		this.LegRight01.yRot = 0F;
		//equip
		this.EquipBase.xRot = 0F;
		this.EquipL01.x = (30.0F) + (0F) * 16F;
		this.EquipL01.y = (0.0F) + (0F) * 16F;
		this.EquipL01.z = (0.0F) + (0F) * 16F;
		this.EquipL01.xRot = 0.2618F;
    	this.EquipL01.yRot = 0.1745F;
    	this.EquipL01.zRot = 0F;
    	this.EquipL05.zRot = 0F;
		this.EquipR01.x = (-30.0F) + (0F) * 16F;
		this.EquipR01.y = (0.0F) + (0F) * 16F;
		this.EquipR01.z = (0.0F) + (0F) * 16F;
    	this.EquipR01.xRot = 0.2618F;
    	this.EquipR01.yRot = -0.1745F;
    	this.EquipR01.zRot = 0f;
  		
    	//head
    	this.Head.xRot = 0.55F;
    	this.Head.yRot = 0F;
    	this.Head.zRot = 0F;
    	//hair 動到headX, 需重新調整hairX
    	this.Hair01.xRot = -0.1F;
    	this.Hair02.xRot = -0.2F;
    	//body
    	this.Neck.xRot = 0.3F;
    	this.Butt.xRot = -0.14F;
		this.Skirt01.xRot = -0.1745F;
		this.Skirt02.xRot = -0.2618F;
		//arm
		this.ArmLeft01.xRot = 0.4F;
		this.ArmLeft01.zRot = -0.2618F;
		this.ArmLeft03.xRot = 0F;
		this.ArmLeft03.zRot = 0F;
		this.ArmRight01.xRot = 0.4F;
		this.ArmRight01.zRot = 0.2618F;
		//leg 
		this.LegLeft01.zRot = -0.14F;
		this.LegLeft02.xRot = 1.2217F;
		this.LegLeft02.yRot = 1.2217F;
		this.LegLeft02.zRot = -1.0472F;
		this.LegLeft02.x = (0.0F) + (0.175F) * 16F;
		this.LegLeft02.y = (14.0F) + (-0.02F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0.1635F) * 16F;
		this.LegRight01.zRot = 0.14F;
		this.LegRight02.xRot = 1.2217F;
		this.LegRight02.yRot = -1.2217F;
		this.LegRight02.zRot = 1.0472F;
		this.LegRight02.x = (0.0F) + (-0.175F) * 16F;
		this.LegRight02.y = (14.0F) + (-0.05F) * 16F;
		this.LegRight02.z = (-3.0F) + (0.1635F) * 16F;
    	//equip
    	this.EquipL01.y = (0.0F) + (0.6F) * 16F;
    	this.EquipR01.y = (0.0F) + (0.6F) * 16F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F);
  		float angleX1 = Mth.cos(f2*0.08F + 0.3F + f * 0.5F);
  		float angleX2 = Mth.cos(f2*0.08F + 0.6F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.7F;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.7F;
  		float addk1 = 0F;
  		float addk2 = 0F;
  		float headX = 0F;
  		float headZ = 0F;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//leg move parm
  		addk1 = angleAdd1 * 0.6F - 0.35F;
	  	addk2 = angleAdd2 * 0.6F - 0.07F;
	  	
  	    //移動頭部使其看人
	  	this.Head.xRot = f4 * 0.014F; 	//上下角度
	  	this.Head.yRot = f3 * 0.01F;	//左右角度
	  	this.Head.zRot = 0F;
	  	headX = this.Head.xRot * -0.5F;
	    //正常站立動作
	    //胸部
  	    this.BoobL.xRot = angleX * 0.08F - 0.7F;
  	    this.BoobR.xRot = angleX * 0.08F - 0.7F;
	  	//Body
  	    this.Ahoke.yRot = angleX * 0.15F + 0.7F;
  	    this.Neck.xRot = 0.1F;
	  	this.BodyMain.xRot = -0.1047F;
	  	this.Butt.xRot = 0.3142F;
	  	this.Skirt01.xRot = -0.14F;
	  	this.Skirt02.xRot = -0.087F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.03F + 0.21F + headX;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -angleX1 * 0.04F - 0.09F + headX;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -angleX2 * 0.07F - 0.14F;
	  	this.Hair03.zRot = 0F;
	    //arm 
	  	this.ArmLeft01.xRot = 0.2618F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = -0.7F;
	    this.ArmLeft03.xRot = -0.14F;
	    this.ArmLeft03.zRot = 1.4835F;
	    this.ArmLeft05.zRot = 0.2618F;
	    this.ArmRight01.xRot = angleAdd1 * 0.375F + 0.2618F;
	  	this.ArmRight01.yRot = 0F;
	    this.ArmRight01.zRot = 0.2618F;
	    this.ArmRight03.xRot = 0F;
	    this.ArmRight03.zRot = 0F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.14F;
		this.LegLeft02.x = (0.0F) + (0) * 16F;
		this.LegLeft02.y = (14.0F) + (0) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.ShoesL04.xRot = -0.1F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.14F;
		this.LegRight02.x = (0.0F) + (0F) * 16F;
		this.LegRight02.y = (14.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		//equip
		this.EquipBase.xRot = 0F;
		this.EquipL01.x = (30.0F) + (0F) * 16F;
		this.EquipL01.y = (0.0F) + (angleX * 0.125F) * 16F;
		this.EquipL01.z = (0.0F) + (0F) * 16F;
		this.EquipL01.xRot = 0.2618F;
    	this.EquipL01.yRot = 0.1745F;
    	this.EquipL01.zRot = 0F;
    	this.EquipL05.zRot = 0F;
		this.EquipR01.x = (-30.0F) + (0F) * 16F;
		this.EquipR01.y = (0.0F) + (-angleX * 0.125F) * 16F;
		this.EquipR01.z = (0.0F) + (0F) * 16F;
    	this.EquipR01.xRot = 0.2618F;
    	this.EquipR01.yRot = -0.1745F;
    	this.EquipR01.zRot = 0f;

	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {	//奔跑動作
	    	//hair
			this.Hair01.xRot += 0.09F;
			this.Hair02.xRot += 0.43F;
			this.Hair03.xRot += 0.49F;
			//胸部
	  	    this.BoobL.xRot = angleAdd2 * 0.1F - 0.83F;
	  	    this.BoobR.xRot = angleAdd1 * 0.1F - 0.83F;
	    	//arm 
		  	this.ArmLeft01.xRot = angleAdd2 * 0.6F + 0.2618F;
		  	this.ArmLeft01.yRot = 0F;
		    this.ArmLeft01.zRot = -0.3F;
		    this.ArmLeft03.xRot = 0F;
		    this.ArmLeft03.zRot = 0F;
		    this.ArmLeft05.zRot = 0F;
		    this.ArmRight01.xRot = angleAdd1 * 0.6F + 0.2618F;
		  	this.ArmRight01.yRot = 0F;
		    this.ArmRight01.zRot = 0.3F;
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {	//潛行, 蹲下動作
this.animTransX += (0F); this.animTransY += (0.05F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 0.6283F;
		  	this.BodyMain.xRot = 0.8727F;
		  	this.Butt.xRot = -0.6283F;
			this.Skirt01.xRot = -0.1745F;
			this.Skirt02.xRot = -0.2618F;
		    //arm
		  	this.ArmLeft01.xRot = 0.2618F;
		  	this.ArmLeft01.yRot = 0F;
		    this.ArmLeft01.zRot = 0.2618F;
		  	this.ArmLeft03.xRot = 0F;
		  	this.ArmLeft03.zRot = 0F;
		  	this.ArmLeft05.zRot = 0F;
			this.ArmRight01.xRot = 0.2618F;
			this.ArmRight01.yRot = 0F;
			this.ArmRight01.zRot = -0.2618F;
			this.ArmRight05.zRot = 0F;
			//hair
			this.Hair01.xRot += 0.37F;
			this.Hair02.xRot += 0.23F;
			this.Hair03.xRot -= 0.1F;
  		}//end if sneaking
  		
	    if (ent.getIsSitting() && !ent.getIsRiding())
	    {  //騎乘動作  	
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
		    	setFace(1);
this.animTransX += (0F); this.animTransY += (0.48F); this.animTransZ += (0F);
		    	//head
		    	int nodf2 = (int)f2 % 60;
		    	this.Head.xRot = 0.3F;
		    	if (nodf2 < 30)
		    	{
		    		if (nodf2 < 6)
		    		{
		    			this.Head.xRot = nodf2 * 0.02F + 0.3F;
		    		}
		    		else if (nodf2 < 11)
		    		{
		    			this.Head.xRot = (nodf2 - 5) * 0.03F + 0.4F;
		    		}
		    		else if (nodf2 < 14)
		    		{
		    			this.Head.xRot = (nodf2 - 10) * -0.09F + 0.55F;
		    		}
		    	}
		    	this.Head.yRot = 0F;
		    	this.Head.zRot = 0F;
		    	//hair 動到headX, 需重新調整hairX
		    	headX = this.Head.xRot * -0.5F;
		    	this.Hair01.xRot = angleX * 0.012F + 0.21F + headX;
		    	this.Hair02.xRot = angleX * 0.015F - 0.09F + headX;
		    	//body
		    	this.Neck.xRot = 0.3F;
		    	this.Butt.xRot = -0.14F;
				this.Skirt01.xRot = -0.1745F;
				this.Skirt02.xRot = -0.2618F;
				//arm
				this.ArmLeft01.xRot = 0.4F;
				this.ArmLeft01.zRot = -0.2618F;
				this.ArmLeft03.xRot = 0F;
				this.ArmLeft03.zRot = 0F;
				this.ArmRight01.xRot = 0.4F;
				this.ArmRight01.zRot = 0.2618F;
				//leg
				addk1 = -1.0472F;
				addk2 = -1.0472F;
				this.LegLeft01.zRot = -0.14F;
				this.LegLeft02.xRot = 1.2217F;
				this.LegLeft02.yRot = 1.2217F;
				this.LegLeft02.zRot = -1.0472F;
				this.LegLeft02.x = (0.0F) + (0.175F) * 16F;
				this.LegLeft02.y = (14.0F) + (-0.02F) * 16F;
				this.LegLeft02.z = (-3.0F) + (0.1635F) * 16F;
				this.LegRight01.zRot = 0.14F;
				this.LegRight02.xRot = 1.2217F;
				this.LegRight02.yRot = -1.2217F;
				this.LegRight02.zRot = 1.0472F;
				this.LegRight02.x = (0.0F) + (-0.175F) * 16F;
				this.LegRight02.y = (14.0F) + (-0.05F) * 16F;
				this.LegRight02.z = (-3.0F) + (0.1635F) * 16F;
		    	//equip
		    	this.EquipL01.y = (0.0F) + (0.6F) * 16F;
		    	this.EquipR01.y = (0.0F) + (0.6F) * 16F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.4F); this.animTransZ += (0F);
		    	//body
		    	this.Neck.xRot = 0.35F;
		    	this.BodyMain.xRot = -0.6283F;
		    	this.Butt.xRot = -0.6283F;
				this.Skirt01.xRot = -0.1745F;
				this.Skirt02.xRot = -0.2618F;
				//arm
				this.ArmRight01.xRot = angleX * 0.125F + 0.5236F;
				//leg
				addk1 = -0.8727F;
				addk2 = -0.35F;
				this.LegLeft01.zRot = 0.4363F;
				this.LegLeft02.xRot = 0.7854F;
				this.LegRight01.zRot = -0.35F;
				this.LegRight02.xRot = 0.8727F;
		    	this.ShoesL04.xRot = angleX * 0.25F - 0.1F;
		    	//equip
		    	this.EquipL01.x = (30.0F) + (-1.9F) * 16F;
		    	this.EquipL01.y = (0.0F) + (0.6F) * 16F;
		    	this.EquipL01.z = (0.0F) + (0.4F) * 16F;
		    	this.EquipL01.xRot = 0F;
		    	this.EquipL01.yRot = 1.57F;
		    	this.EquipL05.zRot = -1F;
		    	this.EquipR01.x = (-30.0F) + (1.9F) * 16F;
		    	this.EquipR01.y = (0.0F) + (-1.0F) * 16F;
		    	this.EquipR01.z = (0.0F) + (-0.4F) * 16F;
		    	this.EquipR01.xRot = -1.5708F;
		    	this.EquipR01.yRot = 0.6F;
		    	this.EquipR01.zRot = -1.5708F;
	    	}
  		}//end sitting
	    
	    if (ent.getIsRiding())
	    {
	    	if (((Entity)ent).getVehicle() instanceof BasicEntityMount)
	    	{
	    		this.EquipBase.visible = true;
	    		
	    		if (ent.getIsSitting())
	    		{
	    			if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    			{
	    				setFace(1);
this.animTransX += (0F); this.animTransY += (0.48F); this.animTransZ += (0F);
				    	//head
				    	int nodf2 = (int)f2 % 60;
				    	this.Head.xRot = 0.3F;
				    	if (nodf2 < 30)
				    	{
				    		if (nodf2 < 6)
				    		{
				    			this.Head.xRot = nodf2 * 0.02F + 0.3F;
				    		}
				    		else if (nodf2 < 11)
				    		{
				    			this.Head.xRot = (nodf2 - 5) * 0.03F + 0.4F;
				    		}
				    		else if (nodf2 < 14)
				    		{
				    			this.Head.xRot = (nodf2 - 10) * -0.09F + 0.55F;
				    		}
				    	}
				    	this.Head.yRot = 0F;
				    	this.Head.zRot = 0F;
				    	//hair 動到headX, 需重新調整hairX
				    	headX = this.Head.xRot * -0.5F;
				    	this.Hair01.xRot = angleX * 0.012F + 0.21F + headX;
				    	this.Hair02.xRot = angleX * 0.015F - 0.09F + headX;
				    	//body
				    	this.Neck.xRot = 0.3F;
				    	this.Butt.xRot = -0.14F;
						this.Skirt01.xRot = -0.1745F;
						this.Skirt02.xRot = -0.2618F;
						//arm
						this.ArmLeft01.xRot = 0.4F;
						this.ArmLeft01.zRot = -0.2618F;
						this.ArmLeft03.xRot = 0F;
						this.ArmLeft03.zRot = 0F;
						this.ArmRight01.xRot = 0.4F;
						this.ArmRight01.zRot = 0.2618F;
						//leg
						addk1 = -1.0472F;
						addk2 = -1.0472F;
						this.LegLeft01.zRot = -0.14F;
						this.LegLeft02.xRot = 1.2217F;
						this.LegLeft02.yRot = 1.2217F;
						this.LegLeft02.zRot = -1.0472F;
						this.LegLeft02.x = (0.0F) + (0.175F) * 16F;
						this.LegLeft02.y = (14.0F) + (-0.02F) * 16F;
						this.LegLeft02.z = (-3.0F) + (0.1635F) * 16F;
						this.LegRight01.zRot = 0.14F;
						this.LegRight02.xRot = 1.2217F;
						this.LegRight02.yRot = -1.2217F;
						this.LegRight02.zRot = 1.0472F;
						this.LegRight02.x = (0.0F) + (-0.175F) * 16F;
						this.LegRight02.y = (14.0F) + (-0.05F) * 16F;
						this.LegRight02.z = (-3.0F) + (0.1635F) * 16F;
				    	//equip
						this.EquipBase.xRot = -0.4F;
						this.EquipL01.x = (30.0F) + (-0.3F) * 16F;
				    	this.EquipL01.y = (0.0F) + (0.6F) * 16F;
				    	this.EquipL01.z = (0.0F) + (0.6F) * 16F;
				    	this.EquipL01.yRot = 1.4F;
				    	this.EquipR01.x = (-30.0F) + (0.3F) * 16F;
				    	this.EquipR01.y = (0.0F) + (0.6F) * 16F;
				    	this.EquipR01.z = (0.0F) + (0.6F) * 16F;
				    	this.EquipR01.yRot = -1.4F;
			    	}
			    	else
			    	{
this.animTransX += (0F); this.animTransY += (0.64F); this.animTransZ += (-0.11F);
				    	//body
				    	this.Neck.xRot = 0.35F;
				    	this.BodyMain.xRot = -0.6283F;
				    	this.Butt.xRot = -0.6283F;
						this.Skirt01.xRot = -0.1745F;
						this.Skirt02.xRot = -0.2618F;
						//arm
						this.ArmRight01.xRot = angleX * 0.125F + 0.5236F;
						this.ArmRight01.zRot = 0.45F;
						this.ArmRight03.xRot = -0.5F;
						//leg
						addk1 = -0.8727F;
						addk2 = -0.35F;
						this.LegLeft01.zRot = 0.4363F;
						this.LegLeft02.xRot = 0.7854F;
						this.LegRight01.zRot = -0.35F;
						this.LegRight02.xRot = 0.8727F;
				    	this.ShoesL04.xRot = angleX * 0.25F - 0.1F;
				    	//equip
				    	this.EquipBase.xRot = 0.2F;
				    	this.EquipL01.x = (30.0F) + (-0.25F) * 16F;
				    	this.EquipL01.y = (0.0F) + (0.1F) * 16F;
				    	this.EquipL01.yRot = 1.4F;
				    	this.EquipR01.x = (-30.0F) + (0.25F) * 16F;
				    	this.EquipR01.y = (0.0F) + (0.1F) * 16F;
				    	this.EquipR01.yRot = -1.4F;
			    	}
		    	}//end if sitting
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.64F); this.animTransZ += (-0.11F);
			    	//body
			    	this.Neck.xRot = 0.35F;
			    	this.BodyMain.xRot = -0.6283F;
			    	this.Butt.xRot = -0.6283F;
					this.Skirt01.xRot = -0.1745F;
					this.Skirt02.xRot = -0.2618F;
					//arm
					this.ArmRight01.xRot = angleX * 0.125F + 0.5236F;
					this.ArmRight01.zRot = 0.45F;
					this.ArmRight03.xRot = -0.5F;
					//leg
					addk1 = -0.8727F;
					addk2 = -0.35F;
					this.LegLeft01.zRot = 0.4363F;
					this.LegLeft02.xRot = 0.7854F;
					this.LegRight01.zRot = -0.35F;
					this.LegRight02.xRot = 0.8727F;
			    	this.ShoesL04.xRot = angleX * 0.25F - 0.1F;
			    	//equip
			    	this.EquipBase.xRot = -0.9F;
			    	this.EquipL01.x = (30.0F) + (-0.25F) * 16F;
			    	this.EquipL01.y = (0.0F) + (0.1F) * 16F;
			    	this.EquipL01.z = (0.0F) + (0.45F) * 16F;
			    	this.EquipL01.yRot = 1.4F;
			    	this.EquipR01.x = (-30.0F) + (0.25F) * 16F;
			    	this.EquipR01.y = (0.0F) + (0.1F) * 16F;
			    	this.EquipR01.z = (0.0F) + (0.45F) * 16F;
			    	this.EquipR01.yRot = -1.4F;
		    	}
	    	}//end ship mount
	    	else
	    	{	//normal mount ex: cart
	    		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    		{
	    			setFace(1);
this.animTransX += (0F); this.animTransY += (0.48F); this.animTransZ += (0F);
			    	//head
			    	int nodf2 = (int)f2 % 60;
			    	this.Head.xRot = 0.2F;
			    	if (nodf2 < 30)
			    	{
			    		if (nodf2 < 6)
			    		{
			    			this.Head.xRot = nodf2 * 0.02F + 0.2F;
			    		}
			    		else if (nodf2 < 11)
			    		{
			    			this.Head.xRot = (nodf2 - 5) * 0.03F + 0.3F;
			    		}
			    		else if (nodf2 < 14)
			    		{
			    			this.Head.xRot = (nodf2 - 10) * -0.09F + 0.45F;
			    		}
			    	}
			    	this.Head.yRot = 0F;
			    	this.Head.zRot = 0F;
			    	//hair 動到headX, 需重新調整hairX
			    	headX = this.Head.xRot * -0.5F;
			    	this.Hair01.xRot = angleX * 0.012F + 0.21F + headX;
			    	this.Hair02.xRot = angleX * 0.015F - 0.09F + headX;
			    	//body
			    	this.Neck.xRot = 0.3F;
			    	this.Butt.xRot = -0.14F;
					this.Skirt01.xRot = -0.1745F;
					this.Skirt02.xRot = -0.2618F;
					//arm
					this.ArmLeft01.xRot = 0.4F;
					this.ArmLeft01.zRot = -0.2618F;
					this.ArmLeft03.xRot = 0F;
					this.ArmLeft03.zRot = 0F;
					this.ArmRight01.xRot = 0.4F;
					this.ArmRight01.zRot = 0.2618F;
					//leg
					addk1 = -1.0472F;
					addk2 = -1.0472F;
					this.LegLeft01.zRot = -0.14F;
					this.LegLeft02.xRot = 1.2217F;
					this.LegLeft02.yRot = 1.2217F;
					this.LegLeft02.zRot = -1.0472F;
					this.LegLeft02.x = (0.0F) + (0.175F) * 16F;
					this.LegLeft02.y = (14.0F) + (-0.02F) * 16F;
					this.LegLeft02.z = (-3.0F) + (0.1635F) * 16F;
					this.LegRight01.zRot = 0.14F;
					this.LegRight02.xRot = 1.2217F;
					this.LegRight02.yRot = -1.2217F;
					this.LegRight02.zRot = 1.0472F;
					this.LegRight02.x = (0.0F) + (-0.175F) * 16F;
					this.LegRight02.y = (14.0F) + (-0.05F) * 16F;
					this.LegRight02.z = (-3.0F) + (0.1635F) * 16F;
			    	//equip
			    	this.EquipL01.y = (0.0F) + (0.6F) * 16F;
			    	this.EquipR01.y = (0.0F) + (0.6F) * 16F;
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.39F); this.animTransZ += (0F);
			    	//body
			    	this.Neck.xRot = 0.35F;
			    	this.BodyMain.xRot = -0.6283F;
			    	this.Butt.xRot = -0.6283F;
					this.Skirt01.xRot = -0.1745F;
					this.Skirt02.xRot = -0.2618F;
					//arm
					this.ArmRight01.xRot = angleX * 0.125F + 0.5236F;
					//leg
					addk1 = -0.8727F;
					addk2 = -0.35F;
					this.LegLeft01.zRot = 0.4363F;
					this.LegLeft02.xRot = 0.7854F;
					this.LegRight01.zRot = -0.35F;
					this.LegRight02.xRot = 0.8727F;
			    	this.ShoesL04.xRot = angleX * 0.25F - 0.1F;
			    	//equip
			    	this.EquipL01.x = (30.0F) + (-1.9F) * 16F;
			    	this.EquipL01.y = (0.0F) + (0.6F) * 16F;
			    	this.EquipL01.z = (0.0F) + (0.4F) * 16F;
			    	this.EquipL01.xRot = 0F;
			    	this.EquipL01.yRot = 1.57F;
			    	this.EquipL05.zRot = -1F;
			    	this.EquipR01.x = (-30.0F) + (1.9F) * 16F;
			    	this.EquipR01.y = (0.0F) + (-1.0F) * 16F;
			    	this.EquipR01.z = (0.0F) + (-0.4F) * 16F;
			    	this.EquipR01.xRot = -1.5708F;
			    	this.EquipR01.yRot = 0.6F;
			    	this.EquipR01.zRot = -1.5708F;
		    	}
	    	}
	    }//end ridding
    
	    //攻擊動作    
	    if (ent.getAttackTick() > 0)
	    {
	    	if (ent.getIsRiding())
	    	{
	    		//arm
		    	this.ArmRight01.xRot = -1.1F;
		    	this.ArmRight03.xRot = 0F;
		    	//equip
		    	this.EquipBase.visible = true;
		    	this.EquipBase.xRot = -1.2F + f4 * Values.N.DIV_PI_180;
		    	this.EquipL01.xRot = -0.1F;
		    	this.EquipR01.xRot = 0.1F;
	    	}
	    	else
	    	{
	    		//arm
		    	this.ArmRight01.xRot = -1.5F;
		    	//equip
		    	this.EquipBase.visible = true;
		    	this.EquipBase.xRot = -1.6F + f4 * Values.N.DIV_PI_180;
		    	this.EquipL01.y = (0.0F) + (0F) * 16F;
		    	this.EquipR01.y = (0.0F) + (0F) * 16F;
	    	}
	    }
	    
	    //swing arm
	  	float f6 = ent.getSwingTime(f2 - (int)f2);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight01.xRot = -0.4F;
	        this.ArmRight01.yRot = 0F;
	        this.ArmRight01.zRot = -0.2F;
	        this.ArmRight01.xRot += -f8 * 80.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.yRot += -f7 * 20.0F * Values.N.DIV_PI_180 + 0.2F;
	        this.ArmRight01.zRot += -f8 * 20.0F * Values.N.DIV_PI_180;
	  	}
	    
	    //鬢毛調整
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.zRot = headZ;
	  	this.Hair02.zRot = headZ;
	  	this.HairL01.zRot = headZ - 0.087F;
	  	this.HairL02.zRot = headZ + 0.087F;
	  	this.HairR01.zRot = headZ + 0.087F;
	  	this.HairR02.zRot = headZ - 0.052F;
	    headX = this.Head.xRot * -0.5F;
		this.HairL01.xRot = angleX * 0.02F + headX - 0.14F;
	  	this.HairL02.xRot = angleX * 0.02F + headX + 0.17F;
	  	this.HairR01.xRot = angleX * 0.02F + headX - 0.14F;
	  	this.HairR02.xRot = angleX * 0.02F + headX + 0.17F;
	  	
	    //leg motion
	    this.LegLeft01.xRot = addk1;
	    this.LegRight01.xRot = addk2;
	
	}

	@Override
	public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)
	{
		this.captureAnimParms(entity, f, f1, f2, f3, f4);

    	//FIX: head rotation bug while riding
    	if (f3 <= -180F) { f3 += 360F; }
    	else if (f3 >= 180F) { f3 -= 360F; }
    	
    	
    	RenderHelper.animScale(this, this.scale, this.scale, this.scale);
this.animTransX += (0F); this.animTransY += (this.offsetY); this.animTransZ += (0F);
    	
    	//main body
		super.setupAnim(entity, f, f1, f2, f3, f4);
	}

}

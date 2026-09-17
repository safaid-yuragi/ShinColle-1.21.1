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

public class ModelMountBaH<T extends Entity> extends ShipModel<T>
{

	public ModelPart BodyMain;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart Butt;
	public ModelPart Neck;
	public ModelPart ChestCannon01a;
	public ModelPart ChestCannon02a;
	public ModelPart ChestCannon03a;
	public ModelPart ChestCannon04a;
	public ModelPart ChestCannon05a;
	public ModelPart ChestCannon06;
	public ModelPart EquipBaseL;
	public ModelPart EquipBaseR;
	public ModelPart ArmLeft02;
	public ModelPart ArmRight02;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart LegRight02;
	public ModelPart LefLeft02;
	public ModelPart Head;
	public ModelPart HeadTooth;
	public ModelPart Jaw;
	public ModelPart HeadBack01;
	public ModelPart HeadBack02;
	public ModelPart HeadBack03;
	public ModelPart JawTooth;
	public ModelPart Tongue;
	public ModelPart ChestCannon01b;
	public ModelPart ChestCannon02b;
	public ModelPart ChestCannon03b;
	public ModelPart ChestCannon04b;
	public ModelPart ChestCannon05b;
	public ModelPart EquipL01;
	public ModelPart EquipL03;
	public ModelPart EquipL02;
	public ModelPart EquipCannon01;
	public ModelPart EquipCannon02;
	public ModelPart EquipCannon03;
	public ModelPart ChestCannonL01a;
	public ModelPart ChestCannonL01b;
	public ModelPart EquipR01;
	public ModelPart EquipR03;
	public ModelPart EquipR02;
	public ModelPart EquipCannon01_1;
	public ModelPart EquipCannon02_1;
	public ModelPart EquipCannon03_1;
	public ModelPart ChestCannonR01a;
	public ModelPart ChestCannonR01b;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowEquipBaseL;
	public ModelPart GlowEquipBaseR;
	public ModelPart GlowEquipL01;
	public ModelPart GlowEquipL02;
	public ModelPart GlowEquipR01;
	public ModelPart GlowEquipR02;
	public ModelPart GlowChestCannonL01a;
	public ModelPart GlowChestCannonR01a;
	public ModelPart GlowChestCannon01a;
	public ModelPart GlowChestCannon02a;
	public ModelPart GlowChestCannon03a;
	public ModelPart GlowChestCannon04a;
	public ModelPart GlowChestCannon05a;
	public ModelPart GlowEquipL03;
	public ModelPart GlowEquipR03;
	private Random rand = new Random();

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-15.0F, -11.0F, -5.0F, 30.0F, 20.0F, 18.0F), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 1.0471975511965976F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("ChestCannon06", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(-4.0F, -1.0F, -7.0F, 0.091106186954104F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("ChestCannon01a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 7.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(6.0F, -8.0F, -7.0F, -0.136659280431156F, -0.091106186954104F, 0.0F));
		PartDefinition partdef3 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-11.0F, 0.0F, -2.5F, 22.0F, 18.0F, 14.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.5009094953223726F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-4.5F, 0.0F, -4.5F, 9.0F, 18.0F, 9.0F), PartPose.offsetAndRotation(-5.0F, 16.0F, 7.0F, -1.6755160819145563F, 0.20943951023931953F, 0.0F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 18.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 18.0F, -2.0F, 1.7453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef3.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-4.5F, 0.0F, -4.5F, 9.0F, 18.0F, 9.0F), PartPose.offsetAndRotation(5.0F, 16.0F, 7.0F, -1.6755160819145563F, -0.20943951023931953F, 0.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("LefLeft02", CubeListBuilder.create().mirror().addBox(-4.0F, 0.0F, -2.0F, 8.0F, 18.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 18.0F, -2.0F, 1.7453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef8 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-1.0F, -7.0F, -7.0F, 14.0F, 22.0F, 14.0F), PartPose.offsetAndRotation(15.0F, 1.0F, 2.0F, -0.8726646259971648F, -0.20943951023931953F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-6.5F, 0.0F, -13.0F, 13.0F, 26.0F, 13.0F), PartPose.offsetAndRotation(6.0F, 15.0F, 7.0F, -0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef0.addOrReplaceChild("ChestCannon04a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-10.0F, -1.0F, -7.0F, 0.18203784098300857F, 0.091106186954104F, 0.0F));
		PartDefinition partdef11 = partdef0.addOrReplaceChild("EquipBaseL", CubeListBuilder.create().addBox(-9.0F, -6.0F, -8.5F, 18.0F, 5.0F, 18.0F), PartPose.offsetAndRotation(20.0F, -3.0F, 2.0F, -0.7740535232594852F, 0.0F, 0.17453292519943295F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("EquipL01", CubeListBuilder.create().addBox(-7.0F, 0.0F, -7.0F, 14.0F, 4.0F, 14.0F), PartPose.offset(0.0F, -10.0F, 1.0F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("EquipL02", CubeListBuilder.create().addBox(-9.0F, -9.0F, -9.0F, 18.0F, 9.0F, 20.0F), PartPose.offsetAndRotation(0.0F, 1.8F, 0.0F, -0.2617993877991494F, -0.13962634015954636F, 0.0F));
		PartDefinition partdef14 = partdef11.addOrReplaceChild("EquipL03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 13.0F, 10.0F), PartPose.offsetAndRotation(6.0F, -6.0F, -2.0F, 0.0F, 0.0F, -0.3141592653589793F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("ChestCannonL01a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 7.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(5.5F, 2.0F, 1.0F, -0.136659280431156F, -1.4114477660878142F, 0.0F));
		PartDefinition partdef16 = partdef0.addOrReplaceChild("EquipBaseR", CubeListBuilder.create().addBox(-9.0F, -6.0F, -8.5F, 18.0F, 5.0F, 18.0F), PartPose.offsetAndRotation(-20.0F, -3.0F, 2.0F, -0.7740535232594852F, 0.0F, -0.17453292519943295F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("EquipR01", CubeListBuilder.create().addBox(-7.0F, 0.0F, -7.0F, 14.0F, 4.0F, 14.0F), PartPose.offset(0.0F, -10.0F, 1.0F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("EquipR02", CubeListBuilder.create().addBox(-9.0F, -9.0F, -9.0F, 18.0F, 9.0F, 20.0F), PartPose.offsetAndRotation(0.0F, 1.8F, 0.0F, -0.3141592653589793F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef19 = partdef16.addOrReplaceChild("EquipR03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 13.0F, 10.0F), PartPose.offsetAndRotation(-7.0F, -6.0F, 7.0F, 0.0F, -3.141592653589793F, 0.3141592653589793F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("ChestCannonR01a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 7.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(5.5F, 2.0F, 1.0F, -0.136659280431156F, -1.4114477660878142F, 0.0F));
		PartDefinition partdef21 = partdef0.addOrReplaceChild("ChestCannon03a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 12.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(-5.0F, -6.4F, -7.0F, -0.18203784098300857F, -0.02024581932313422F, 0.0F));
		PartDefinition partdef22 = partdef0.addOrReplaceChild("ChestCannon02a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 7.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(4.6F, -2.4F, -7.0F, 0.091106186954104F, -0.091106186954104F, 0.0F));
		PartDefinition partdef23 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-13.0F, -7.0F, -7.0F, 14.0F, 22.0F, 14.0F), PartPose.offsetAndRotation(-15.0F, 0.0F, 2.0F, -0.8726646259971648F, 0.20943951023931953F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(-6.5F, 0.0F, -13.0F, 13.0F, 26.0F, 13.0F), PartPose.offsetAndRotation(-6.0F, 15.0F, 7.0F, -0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef25 = partdef0.addOrReplaceChild("ChestCannon05a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-13.0F, -8.0F, -6.0F, -0.091106186954104F, 0.136659280431156F, 0.022126174344515567F));
		PartDefinition partdef26 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-9.0F, -18.0F, -6.0F, 18.0F, 18.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -8.0F, 6.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-9.5F, -9.0F, -16.0F, 19.0F, 12.0F, 19.0F), PartPose.offsetAndRotation(0.0F, -12.0F, -2.6F, -0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("HeadTooth", CubeListBuilder.create().addBox(-7.5F, 0.0F, -7.5F, 15.0F, 4.0F, 15.0F), PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef29 = partdef27.addOrReplaceChild("HeadBack01", CubeListBuilder.create().addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 12.0F), PartPose.offsetAndRotation(6.0F, -2.0F, 4.0F, 0.6829473363053812F, 0.4363323129985824F, 0.0F));
		PartDefinition partdef30 = partdef27.addOrReplaceChild("HeadBack02", CubeListBuilder.create().addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 5.0F, 0.7740535232594852F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef31 = partdef27.addOrReplaceChild("HeadBack03", CubeListBuilder.create().addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 12.0F), PartPose.offsetAndRotation(-6.0F, -3.0F, 5.0F, 0.5918411493512771F, -0.5009094953223726F, 0.0F));
		PartDefinition partdef32 = partdef27.addOrReplaceChild("Jaw", CubeListBuilder.create().addBox(-8.5F, 0.0F, -14.5F, 17.0F, 9.0F, 17.0F), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("Tongue", CubeListBuilder.create().addBox(-5.0F, 0.0F, -13.0F, 10.0F, 2.0F, 13.0F), PartPose.offset(0.0F, -3.1F, 1.0F));
		PartDefinition partdef34 = partdef32.addOrReplaceChild("JawTooth", CubeListBuilder.create().addBox(-7.5F, 0.0F, -13.0F, 15.0F, 3.0F, 15.0F), PartPose.offsetAndRotation(0.0F, -1.5F, -0.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef35 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 1.0471975511965976F, 0.0F, 0.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.0F, 6.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef37 = partdef36.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-9.5F, -9.0F, -16.0F, 19.0F, 12.0F, 19.0F), PartPose.offsetAndRotation(0.0F, -12.0F, -2.6F, -0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("HeadTooth", CubeListBuilder.create().addBox(-7.5F, 0.0F, -7.5F, 15.0F, 4.0F, 15.0F), PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef39 = partdef37.addOrReplaceChild("HeadBack01", CubeListBuilder.create().addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 12.0F), PartPose.offsetAndRotation(6.0F, -2.0F, 4.0F, 0.6829473363053812F, 0.4363323129985824F, 0.0F));
		PartDefinition partdef40 = partdef37.addOrReplaceChild("HeadBack02", CubeListBuilder.create().addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 5.0F, 0.7740535232594852F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef41 = partdef37.addOrReplaceChild("HeadBack03", CubeListBuilder.create().addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 12.0F), PartPose.offsetAndRotation(-6.0F, -3.0F, 5.0F, 0.5918411493512771F, -0.5009094953223726F, 0.0F));
		PartDefinition partdef42 = partdef37.addOrReplaceChild("Jaw", CubeListBuilder.create().addBox(-8.5F, 0.0F, -14.5F, 17.0F, 9.0F, 17.0F), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("Tongue", CubeListBuilder.create().addBox(-5.0F, 0.0F, -13.0F, 10.0F, 2.0F, 13.0F), PartPose.offset(0.0F, -3.1F, 1.0F));
		PartDefinition partdef44 = partdef42.addOrReplaceChild("JawTooth", CubeListBuilder.create().addBox(-7.5F, 0.0F, -13.0F, 15.0F, 3.0F, 15.0F), PartPose.offsetAndRotation(0.0F, -1.5F, -0.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef45 = partdef35.addOrReplaceChild("GlowEquipBaseL", CubeListBuilder.create(), PartPose.offsetAndRotation(20.0F, -3.0F, 2.0F, -0.7740535232594852F, 0.0F, 0.17453292519943295F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("GlowEquipL01", CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, 1.0F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("GlowEquipL02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 1.8F, 0.0F, -0.2617993877991494F, -0.13962634015954636F, 0.0F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("EquipCannon01", CubeListBuilder.create().addBox(0.0F, 0.0F, -16.0F, 3.0F, 3.0F, 16.0F), PartPose.offsetAndRotation(4.0F, -7.5F, -8.0F, -0.136659280431156F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef49 = partdef47.addOrReplaceChild("EquipCannon02", CubeListBuilder.create().addBox(0.0F, 0.0F, -16.0F, 3.0F, 3.0F, 16.0F), PartPose.offsetAndRotation(-1.5F, -7.5F, -8.0F, -0.4553564018453205F, 0.0F, 0.0F));
		PartDefinition partdef50 = partdef47.addOrReplaceChild("EquipCannon03", CubeListBuilder.create().addBox(0.0F, 0.0F, -16.0F, 3.0F, 3.0F, 16.0F), PartPose.offsetAndRotation(-7.0F, -7.5F, -8.0F, -0.27314402793711257F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef51 = partdef45.addOrReplaceChild("GlowEquipL03", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, -6.0F, -2.0F, 0.0F, 0.0F, -0.3141592653589793F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("GlowChestCannonL01a", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5F, 2.0F, 1.0F, -0.136659280431156F, -1.4114477660878142F, 0.0F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("ChestCannonL01b", CubeListBuilder.create().addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(2.5F, 2.5F, 1.0F, 0.136659280431156F, 0.091106186954104F, 0.0F));
		PartDefinition partdef54 = partdef35.addOrReplaceChild("GlowEquipBaseR", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.0F, -3.0F, 2.0F, -0.7740535232594852F, 0.0F, -0.17453292519943295F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("GlowEquipR01", CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, 1.0F));
		PartDefinition partdef56 = partdef55.addOrReplaceChild("GlowEquipR02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 1.8F, 0.0F, -0.3141592653589793F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef57 = partdef56.addOrReplaceChild("EquipCannon01_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -16.0F, 3.0F, 3.0F, 16.0F), PartPose.offsetAndRotation(4.0F, -7.5F, -8.0F, 0.0F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef58 = partdef56.addOrReplaceChild("EquipCannon02_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -16.0F, 3.0F, 3.0F, 16.0F), PartPose.offsetAndRotation(-1.5F, -7.5F, -8.0F, -0.18203784098300857F, 0.0F, 0.0F));
		PartDefinition partdef59 = partdef56.addOrReplaceChild("EquipCannon03_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -16.0F, 3.0F, 3.0F, 16.0F), PartPose.offsetAndRotation(-7.0F, -7.5F, -8.0F, -0.27314402793711257F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef60 = partdef54.addOrReplaceChild("GlowEquipR03", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.0F, -6.0F, 7.0F, 0.0F, -3.141592653589793F, 0.3141592653589793F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("GlowChestCannonR01a", CubeListBuilder.create(), PartPose.offsetAndRotation(5.5F, 2.0F, 1.0F, -0.136659280431156F, -1.4114477660878142F, 0.0F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("ChestCannonR01b", CubeListBuilder.create().addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(2.5F, 2.5F, 1.0F, 0.18203784098300857F, -0.18203784098300857F, 0.0F));
		PartDefinition partdef63 = partdef35.addOrReplaceChild("GlowChestCannon01a", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, -8.0F, -7.0F, -0.136659280431156F, -0.091106186954104F, 0.0F));
		PartDefinition partdef64 = partdef63.addOrReplaceChild("ChestCannon01b", CubeListBuilder.create().addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(2.5F, 3.5F, 1.0F, -0.4553564018453205F, -0.5462880558742251F, 0.0F));
		PartDefinition partdef65 = partdef35.addOrReplaceChild("GlowChestCannon02a", CubeListBuilder.create(), PartPose.offsetAndRotation(4.6F, -2.4F, -7.0F, 0.091106186954104F, -0.091106186954104F, 0.0F));
		PartDefinition partdef66 = partdef65.addOrReplaceChild("ChestCannon02b", CubeListBuilder.create().addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(2.5F, 2.5F, 1.0F, 0.045553093477052F, -0.27314402793711257F, 0.0F));
		PartDefinition partdef67 = partdef35.addOrReplaceChild("GlowChestCannon03a", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, -6.4F, -7.0F, -0.18203784098300857F, -0.02024581932313422F, 0.0F));
		PartDefinition partdef68 = partdef67.addOrReplaceChild("ChestCannon03b", CubeListBuilder.create().addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(4.5F, 2.5F, 1.5F, -0.6373942428283291F, 0.0F, 0.0F));
		PartDefinition partdef69 = partdef35.addOrReplaceChild("GlowChestCannon04a", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.0F, -1.0F, -7.0F, 0.18203784098300857F, 0.091106186954104F, 0.0F));
		PartDefinition partdef70 = partdef69.addOrReplaceChild("ChestCannon04b", CubeListBuilder.create().addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(2.5F, 2.5F, 1.0F, -0.27314402793711257F, 0.22759093446006054F, 0.0F));
		PartDefinition partdef71 = partdef35.addOrReplaceChild("GlowChestCannon05a", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.0F, -8.0F, -6.0F, -0.091106186954104F, 0.136659280431156F, 0.022126174344515567F));
		PartDefinition partdef72 = partdef71.addOrReplaceChild("ChestCannon05b", CubeListBuilder.create().addBox(0.0F, 0.0F, -9.0F, 2.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(2.5F, 2.5F, 1.0F, -0.7285004297824331F, 0.3389429407372988F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelMountBaH(ModelPart root)
	{
		this.ChestCannon06 = root.getChild("BodyMain").getChild("ChestCannon06");
		this.HeadBack01 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Head").getChild("HeadBack01");
		this.ChestCannon03b = root.getChild("GlowBodyMain").getChild("GlowChestCannon03a").getChild("ChestCannon03b");
		this.Head = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Head");
		this.EquipCannon02 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowEquipL02").getChild("EquipCannon02");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.EquipR01 = root.getChild("BodyMain").getChild("EquipBaseR").getChild("EquipR01");
		this.EquipR02 = root.getChild("BodyMain").getChild("EquipBaseR").getChild("EquipR01").getChild("EquipR02");
		this.BodyMain = root.getChild("BodyMain");
		this.EquipCannon03_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseR").getChild("GlowEquipR01").getChild("GlowEquipR02").getChild("EquipCannon03_1");
		this.ChestCannon01a = root.getChild("BodyMain").getChild("ChestCannon01a");
		this.ChestCannonR01b = root.getChild("GlowBodyMain").getChild("GlowEquipBaseR").getChild("GlowEquipR03").getChild("GlowChestCannonR01a").getChild("ChestCannonR01b");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.ChestCannon01b = root.getChild("GlowBodyMain").getChild("GlowChestCannon01a").getChild("ChestCannon01b");
		this.Jaw = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Head").getChild("Jaw");
		this.HeadBack02 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Head").getChild("HeadBack02");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.ChestCannonR01a = root.getChild("BodyMain").getChild("EquipBaseR").getChild("EquipR03").getChild("ChestCannonR01a");
		this.ChestCannon05b = root.getChild("GlowBodyMain").getChild("GlowChestCannon05a").getChild("ChestCannon05b");
		this.ChestCannon04a = root.getChild("BodyMain").getChild("ChestCannon04a");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.EquipBaseL = root.getChild("BodyMain").getChild("EquipBaseL");
		this.EquipCannon01 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowEquipL02").getChild("EquipCannon01");
		this.EquipBaseR = root.getChild("BodyMain").getChild("EquipBaseR");
		this.ChestCannonL01b = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL03").getChild("GlowChestCannonL01a").getChild("ChestCannonL01b");
		this.ChestCannon03a = root.getChild("BodyMain").getChild("ChestCannon03a");
		this.ChestCannon02a = root.getChild("BodyMain").getChild("ChestCannon02a");
		this.EquipL02 = root.getChild("BodyMain").getChild("EquipBaseL").getChild("EquipL01").getChild("EquipL02");
		this.EquipCannon01_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseR").getChild("GlowEquipR01").getChild("GlowEquipR02").getChild("EquipCannon01_1");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.EquipR03 = root.getChild("BodyMain").getChild("EquipBaseR").getChild("EquipR03");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.ChestCannon04b = root.getChild("GlowBodyMain").getChild("GlowChestCannon04a").getChild("ChestCannon04b");
		this.EquipL01 = root.getChild("BodyMain").getChild("EquipBaseL").getChild("EquipL01");
		this.HeadBack03 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Head").getChild("HeadBack03");
		this.EquipCannon03 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowEquipL02").getChild("EquipCannon03");
		this.ChestCannonL01a = root.getChild("BodyMain").getChild("EquipBaseL").getChild("EquipL03").getChild("ChestCannonL01a");
		this.HeadTooth = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Head").getChild("HeadTooth");
		this.EquipL03 = root.getChild("BodyMain").getChild("EquipBaseL").getChild("EquipL03");
		this.Tongue = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Head").getChild("Jaw").getChild("Tongue");
		this.ChestCannon05a = root.getChild("BodyMain").getChild("ChestCannon05a");
		this.ChestCannon02b = root.getChild("GlowBodyMain").getChild("GlowChestCannon02a").getChild("ChestCannon02b");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.LefLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LefLeft02");
		this.JawTooth = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Head").getChild("Jaw").getChild("JawTooth");
		this.EquipCannon02_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseR").getChild("GlowEquipR01").getChild("GlowEquipR02").getChild("EquipCannon02_1");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowEquipBaseL = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL");
		this.GlowEquipL01 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01");
		this.GlowEquipL02 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowEquipL02");
		this.GlowEquipBaseR = root.getChild("GlowBodyMain").getChild("GlowEquipBaseR");
		this.GlowEquipR01 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseR").getChild("GlowEquipR01");
		this.GlowEquipR02 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseR").getChild("GlowEquipR01").getChild("GlowEquipR02");
		this.GlowChestCannonL01a = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL03").getChild("GlowChestCannonL01a");
		this.GlowChestCannonR01a = root.getChild("GlowBodyMain").getChild("GlowEquipBaseR").getChild("GlowEquipR03").getChild("GlowChestCannonR01a");
		this.GlowChestCannon01a = root.getChild("GlowBodyMain").getChild("GlowChestCannon01a");
		this.GlowChestCannon02a = root.getChild("GlowBodyMain").getChild("GlowChestCannon02a");
		this.GlowChestCannon03a = root.getChild("GlowBodyMain").getChild("GlowChestCannon03a");
		this.GlowChestCannon04a = root.getChild("GlowBodyMain").getChild("GlowChestCannon04a");
		this.GlowChestCannon05a = root.getChild("GlowBodyMain").getChild("GlowChestCannon05a");
		this.GlowEquipL03 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL03");
		this.GlowEquipR03 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseR").getChild("GlowEquipR03");
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
    	
    	
    	RenderHelper.animScale(this, 0.8F, 0.8F, 0.8F);
    	
    	//main body

		
		IShipEmotion ent = (IShipEmotion)entity;
		  
		motionHumanPos(f, f1, f2, f3, f4, ent);
    
	}

	private void motionHumanPos(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{
   
  		float angleX = Mth.cos(f2*0.08F);
  		float angleFast = Mth.cos(f2*1F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.7F;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.7F;
  		float addk1 = 0F;
  		float addk2 = 0F;
  		
this.animTransX += (0F); this.animTransY += (0.2F); this.animTransZ += (0F);
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.025F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//leg move parm
  		addk1 = angleAdd1 - 1.6755F;
	  	addk2 = angleAdd2 - 1.6755F;

	    //正常站立動作
	  	//頭部煙囪
	  	this.HeadBack01.xRot = angleFast * 0.04F * rand.nextFloat() + 0.68F;
	  	this.HeadBack02.xRot = angleFast * 0.06F * rand.nextFloat() + 0.77F;
	  	this.HeadBack03.xRot = angleFast * 0.05F * rand.nextFloat() + 0.6F;
	  	//嘴巴
	  	this.Jaw.xRot = angleX * 0.12F + 0.83F;
	    //arm 
	  	this.ArmLeft01.xRot = angleAdd2 * 1.2F - 0.7F;
	    this.ArmRight01.xRot = angleAdd1 * 1.2F - 0.7F;
	    //cannon
	    float headX = f4 * 0.017F;
	    float headY = f3 * 0.017F;
	    this.EquipCannon01.xRot = headX * 0.85F;
	    this.EquipCannon02.xRot = headX * 0.95F;
	    this.EquipCannon03.xRot = headX * 0.75F;
	    this.EquipCannon01_1.xRot = headX * 0.95F;
	    this.EquipCannon02_1.xRot = headX * 1.1F;
	    this.EquipCannon03_1.xRot = headX * 0.85F;
	    this.EquipL02.yRot = headY;
	    this.EquipR02.yRot = headY;
	    this.GlowEquipL02.yRot = headY;
	    this.GlowEquipR02.yRot = headY;
	    
	    if (ent.getStateEmotion(ID.S.Emotion) > 0)
	    {
	    	this.ArmRight01.xRot = -1.57F;
	    }
	    
	    //leg motion
	    this.LegLeft01.xRot = addk1;
	    this.LegRight01.xRot = addk2;
  	
	}

}

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

public class ModelSSNH<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart Butt;
	public ModelPart EquipBase;
	public ModelPart Cloth01;
	public ModelPart Neck;
	public ModelPart Cloth00;
	public ModelPart RingBase;
	public ModelPart ArmLeft02;
	public ModelPart EquipTBase;
	public ModelPart EqyuipT01;
	public ModelPart EqyuipT02;
	public ModelPart EqyuipT04;
	public ModelPart EqyuipT03;
	public ModelPart EquipT03a;
	public ModelPart EqyuipT05;
	public ModelPart EquipT05a;
	public ModelPart EquipT05b;
	public ModelPart EquipT05c;
	public ModelPart EquipT05d;
	public ModelPart EquipTBase_2;
	public ModelPart EqyuipT01_2;
	public ModelPart EqyuipT02_2;
	public ModelPart EqyuipT04_2;
	public ModelPart EqyuipT03_2;
	public ModelPart EquipT03a_2;
	public ModelPart EqyuipT05_2;
	public ModelPart EquipT05a_2;
	public ModelPart EquipT05b_2;
	public ModelPart EquipT05c_2;
	public ModelPart EquipT05d_2;
	public ModelPart ArmRight02;
	public ModelPart EquipHandRing;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart LegRight02;
	public ModelPart LegLeft02;
	public ModelPart Cloth02;
	public ModelPart Cloth03;
	public ModelPart Cloth04;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Ahoke01;
	public ModelPart Ahoke01a;
	public ModelPart HairU01;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart Ahoke02;
	public ModelPart Ahoke03;
	public ModelPart Ahoke04;
	public ModelPart Ahoke05;
	public ModelPart Ahoke06;
	public ModelPart Ahoke02a;
	public ModelPart Ahoke03a;
	public ModelPart Ahoke04a;
	public ModelPart Ahoke05a;
	public ModelPart Ahoke06a;
	public ModelPart Ring01;
	public ModelPart Ring02;
	public ModelPart Ring03Base;
	public ModelPart Ring03a;
	public ModelPart Ring03b;
	public ModelPart Ring03c;
	public ModelPart Ring03d;
	public ModelPart Ring03e;
	public ModelPart Ring03f;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-5.5F, -11.0F, -3.5F, 11.0F, 9.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 6.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 9.0F, 5.0F), PartPose.offsetAndRotation(3.2F, 5.5F, 2.4F, -0.10471975511965977F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 10.0F, 5.0F), PartPose.offset(0.0F, 9.0F, -2.5F));
		PartDefinition partdef4 = partdef1.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 9.0F, 5.0F), PartPose.offsetAndRotation(-3.2F, 5.5F, 2.4F, -0.10471975511965977F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 10.0F, 5.0F), PartPose.offset(0.0F, 9.0F, -2.5F));
		PartDefinition partdef6 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-1.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(6.0F, -9.3F, -0.7F, 0.13962634015954636F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-4.0F, 0.0F, -4.0F, 4.0F, 9.0F, 4.0F), PartPose.offset(3.0F, 7.0F, 2.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("EquipTBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(-2.6F, 9.0F, -2.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("EqyuipT01", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("EqyuipT02", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offset(0.0F, 6.9F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("EqyuipT03", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offset(0.0F, 6.9F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("EquipT03a", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 6.9F, 0.0F));
		PartDefinition partdef13 = partdef9.addOrReplaceChild("EqyuipT04", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offset(0.0F, -6.9F, 0.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("EqyuipT05", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -6.9F, 0.0F, 0.0F, 0.0F, 0.02142916587671676F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("EquipT05b", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-1.9F, 1.0F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F));
		PartDefinition partdef16 = partdef14.addOrReplaceChild("EquipT05c", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(1.9F, 1.0F, 0.0F, 0.0F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef17 = partdef14.addOrReplaceChild("EquipT05a", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 2.0F), PartPose.offset(0.0F, 1.0F, 1.9F));
		PartDefinition partdef18 = partdef14.addOrReplaceChild("EquipT05d", CubeListBuilder.create().addBox(-0.5F, 0.0F, -2.0F, 1.0F, 6.0F, 2.0F), PartPose.offset(0.0F, 1.0F, -1.9F));
		PartDefinition partdef19 = partdef0.addOrReplaceChild("Cloth00", CubeListBuilder.create().addBox(-6.0F, 0.0F, -2.9F, 12.0F, 8.0F, 7.0F), PartPose.offset(0.0F, -11.3F, -1.0F));
		PartDefinition partdef20 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -10.3F, 0.2F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.5F, -1.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.6F, 0.1F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -7.0F));
		PartDefinition partdef24 = partdef21.addOrReplaceChild("Ahoke01", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, -15.0F, 0.0F, -2.007128639793479F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("Ahoke02", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, 1.0471975511965976F, -0.05235987755982988F, 0.0F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("Ahoke03", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, 0.7853981633974483F, 0.05235987755982988F, 0.0F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("Ahoke04", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.4363323129985824F, 0.05235987755982988F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("Ahoke05", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, -0.17453292519943295F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("Ahoke06", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, -0.4363323129985824F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef30 = partdef21.addOrReplaceChild("Ahoke01a", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -15.0F, -1.5F, -2.2689280275926285F, -2.6179938779914944F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("Ahoke02a", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.7853981633974483F, -0.05235987755982988F, 0.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("Ahoke03a", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 1.0471975511965976F, 0.05235987755982988F, 0.0F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("Ahoke04a", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.4886921905584123F, 0.05235987755982988F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("Ahoke05a", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, -0.2617993877991494F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("Ahoke06a", CubeListBuilder.create().mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, -0.5235987755982988F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef36 = partdef21.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef37 = partdef36.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.0F, 0.0F, -5.0F, 16.0F, 11.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 9.5F, 5.8F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef39 = partdef0.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, -5.0F, 0.0F));
		PartDefinition partdef40 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -3.3F, -4.3F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("Cloth02", CubeListBuilder.create().addBox(-7.0F, 0.0F, 0.0F, 14.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -0.3F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("Cloth03", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 2.3F, -0.2F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("Cloth04", CubeListBuilder.create().addBox(-9.0F, 0.0F, 0.0F, 18.0F, 3.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 2.0F, -0.3F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef44 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(-6.0F, -9.3F, -0.7F, 0.13962634015954636F, 0.0F, 0.6108652381980153F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0.0F, 0.0F, -4.0F, 4.0F, 9.0F, 4.0F), PartPose.offset(-3.0F, 7.0F, 2.0F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("EquipHandRing", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 2.0F, 5.0F), PartPose.offset(0.0F, 4.0F, -2.0F));
		PartDefinition partdef47 = partdef45.addOrReplaceChild("EquipTBase_2", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(2.6F, 9.0F, -2.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("EqyuipT01_2", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("EqyuipT02_2", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offset(0.0F, 6.9F, 0.0F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("EqyuipT03_2", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offset(0.0F, 6.9F, 0.0F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("EquipT03a_2", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 6.9F, 0.0F));
		PartDefinition partdef52 = partdef48.addOrReplaceChild("EqyuipT04_2", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offset(0.0F, -6.9F, 0.0F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("EqyuipT05_2", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -6.9F, 0.0F, 0.0F, 0.0F, 0.02142916587671676F));
		PartDefinition partdef54 = partdef53.addOrReplaceChild("EquipT05a_2", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 2.0F), PartPose.offset(0.0F, 1.0F, 1.9F));
		PartDefinition partdef55 = partdef53.addOrReplaceChild("EquipT05b_2", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-1.9F, 1.0F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F));
		PartDefinition partdef56 = partdef53.addOrReplaceChild("EquipT05c_2", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(1.9F, 1.0F, 0.0F, 0.0F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef57 = partdef53.addOrReplaceChild("EquipT05d_2", CubeListBuilder.create().addBox(-0.5F, 0.0F, -2.0F, 1.0F, 6.0F, 2.0F), PartPose.offset(0.0F, 1.0F, -1.9F));
		PartDefinition partdef58 = partdef0.addOrReplaceChild("RingBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, -16.0F, -0.4F));
		PartDefinition partdef59 = partdef58.addOrReplaceChild("Ring01", CubeListBuilder.create().addBox(-4.0F, 0.0F, -0.5F, 8.0F, 10.0F, 1.0F), PartPose.offsetAndRotation(4.5F, 4.3F, 0.0F, -0.8203047484373349F, 1.5009831567151235F, 0.0F));
		PartDefinition partdef60 = partdef59.addOrReplaceChild("Ring02", CubeListBuilder.create().addBox(-4.0F, -9.0F, -0.5F, 8.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(0.3F, 8.5F, 0.2F, 0.22759093446006054F, -0.03874630939427412F, -2.792526803190927F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("Ring03Base", CubeListBuilder.create().addBox(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(-2.0F, -10.0F, 1.7F, -0.6108652381980153F, 0.17453292519943295F, -0.10471975511965977F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("Ring03b", CubeListBuilder.create().addBox(0.0F, -2.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(-1.9F, 2.0F, 0.0F, 0.0F, 0.0F, -1.5707963267948966F));
		PartDefinition partdef63 = partdef61.addOrReplaceChild("Ring03c", CubeListBuilder.create().addBox(0.0F, -2.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offset(-4.0F, -8.9F, 0.0F));
		PartDefinition partdef64 = partdef61.addOrReplaceChild("Ring03a", CubeListBuilder.create().addBox(0.0F, -2.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef65 = partdef61.addOrReplaceChild("Ring03e", CubeListBuilder.create().addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, -10.8F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef66 = partdef61.addOrReplaceChild("Ring03d", CubeListBuilder.create().addBox(0.0F, -2.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(7.0F, -1.9F, 0.0F, 0.0F, 0.0F, -1.5707963267948966F));
		PartDefinition partdef67 = partdef61.addOrReplaceChild("Ring03f", CubeListBuilder.create().addBox(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(7.0F, -10.8F, 0.0F, 0.0F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef68 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef69 = partdef68.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.3F, 0.2F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef70 = partdef69.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, -1.0F));
		PartDefinition partdef71 = partdef70.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef72 = partdef70.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef73 = partdef70.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef74 = partdef70.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef75 = partdef70.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef76 = partdef70.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef77 = partdef70.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef78 = partdef70.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef79 = partdef70.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef80 = partdef70.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelSSNH(ModelPart root)
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
		this.EqyuipT02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipTBase").getChild("EqyuipT01").getChild("EqyuipT02");
		this.EqyuipT02_2 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipTBase_2").getChild("EqyuipT01_2").getChild("EqyuipT02_2");
		this.Ring03Base = root.getChild("BodyMain").getChild("RingBase").getChild("Ring01").getChild("Ring02").getChild("Ring03Base");
		this.BodyMain = root.getChild("BodyMain");
		this.EquipT03a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipTBase").getChild("EqyuipT01").getChild("EqyuipT02").getChild("EqyuipT03").getChild("EquipT03a");
		this.EquipT03a_2 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipTBase_2").getChild("EqyuipT01_2").getChild("EqyuipT02_2").getChild("EqyuipT03_2").getChild("EquipT03a_2");
		this.Cloth04 = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth02").getChild("Cloth03").getChild("Cloth04");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.EquipHandRing = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipHandRing");
		this.Ring02 = root.getChild("BodyMain").getChild("RingBase").getChild("Ring01").getChild("Ring02");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.Ring03b = root.getChild("BodyMain").getChild("RingBase").getChild("Ring01").getChild("Ring02").getChild("Ring03Base").getChild("Ring03b");
		this.Ring01 = root.getChild("BodyMain").getChild("RingBase").getChild("Ring01");
		this.Ahoke03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01").getChild("Ahoke02").getChild("Ahoke03");
		this.Ahoke06a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01a").getChild("Ahoke02a").getChild("Ahoke03a").getChild("Ahoke04a").getChild("Ahoke05a").getChild("Ahoke06a");
		this.Ahoke05a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01a").getChild("Ahoke02a").getChild("Ahoke03a").getChild("Ahoke04a").getChild("Ahoke05a");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.Ahoke04 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01").getChild("Ahoke02").getChild("Ahoke03").getChild("Ahoke04");
		this.Ahoke02a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01a").getChild("Ahoke02a");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.Ahoke03a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01a").getChild("Ahoke02a").getChild("Ahoke03a");
		this.Ring03c = root.getChild("BodyMain").getChild("RingBase").getChild("Ring01").getChild("Ring02").getChild("Ring03Base").getChild("Ring03c");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.EqyuipT05 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipTBase").getChild("EqyuipT01").getChild("EqyuipT04").getChild("EqyuipT05");
		this.EqyuipT05_2 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipTBase_2").getChild("EqyuipT01_2").getChild("EqyuipT04_2").getChild("EqyuipT05_2");
		this.Ring03a = root.getChild("BodyMain").getChild("RingBase").getChild("Ring01").getChild("Ring02").getChild("Ring03Base").getChild("Ring03a");
		this.Ring03e = root.getChild("BodyMain").getChild("RingBase").getChild("Ring01").getChild("Ring02").getChild("Ring03Base").getChild("Ring03e");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.EquipT05b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipTBase").getChild("EqyuipT01").getChild("EqyuipT04").getChild("EqyuipT05").getChild("EquipT05b");
		this.EquipT05b_2 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipTBase_2").getChild("EqyuipT01_2").getChild("EqyuipT04_2").getChild("EqyuipT05_2").getChild("EquipT05b_2");
		this.Cloth00 = root.getChild("BodyMain").getChild("Cloth00");
		this.Ahoke01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01");
		this.EqyuipT04 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipTBase").getChild("EqyuipT01").getChild("EqyuipT04");
		this.EqyuipT04_2 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipTBase_2").getChild("EqyuipT01_2").getChild("EqyuipT04_2");
		this.EquipT05c = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipTBase").getChild("EqyuipT01").getChild("EqyuipT04").getChild("EqyuipT05").getChild("EquipT05c");
		this.EquipT05c_2 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipTBase_2").getChild("EqyuipT01_2").getChild("EqyuipT04_2").getChild("EqyuipT05_2").getChild("EquipT05c_2");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.EqyuipT03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipTBase").getChild("EqyuipT01").getChild("EqyuipT02").getChild("EqyuipT03");
		this.EqyuipT03_2 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipTBase_2").getChild("EqyuipT01_2").getChild("EqyuipT02_2").getChild("EqyuipT03_2");
		this.EquipT05a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipTBase").getChild("EqyuipT01").getChild("EqyuipT04").getChild("EqyuipT05").getChild("EquipT05a");
		this.EquipT05a_2 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipTBase_2").getChild("EqyuipT01_2").getChild("EqyuipT04_2").getChild("EqyuipT05_2").getChild("EquipT05a_2");
		this.EquipBase = root.getChild("BodyMain").getChild("EquipBase");
		this.Ahoke04a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01a").getChild("Ahoke02a").getChild("Ahoke03a").getChild("Ahoke04a");
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.Ring03d = root.getChild("BodyMain").getChild("RingBase").getChild("Ring01").getChild("Ring02").getChild("Ring03Base").getChild("Ring03d");
		this.RingBase = root.getChild("BodyMain").getChild("RingBase");
		this.HairU01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairU01");
		this.Cloth03 = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth02").getChild("Cloth03");
		this.Ahoke06 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01").getChild("Ahoke02").getChild("Ahoke03").getChild("Ahoke04").getChild("Ahoke05").getChild("Ahoke06");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.Cloth02 = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth02");
		this.Ahoke01a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01a");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.EquipT05d = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipTBase").getChild("EqyuipT01").getChild("EqyuipT04").getChild("EqyuipT05").getChild("EquipT05d");
		this.EquipT05d_2 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipTBase_2").getChild("EqyuipT01_2").getChild("EqyuipT04_2").getChild("EqyuipT05_2").getChild("EquipT05d_2");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.EqyuipT01 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipTBase").getChild("EqyuipT01");
		this.EqyuipT01_2 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipTBase_2").getChild("EqyuipT01_2");
		this.Ahoke02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01").getChild("Ahoke02");
		this.Ahoke05 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01").getChild("Ahoke02").getChild("Ahoke03").getChild("Ahoke04").getChild("Ahoke05");
		this.Ring03f = root.getChild("BodyMain").getChild("RingBase").getChild("Ring01").getChild("Ring02").getChild("Ring03Base").getChild("Ring03f");
		this.EquipTBase = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipTBase");
		this.EquipTBase_2 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipTBase_2");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.scale = 0.32F;
		this.offsetY = 3.21F;
		this.offsetItem = new float[] {0.08F, 1.02F, -0.07F};
		this.offsetBlock = new float[] {0.08F, 1.02F, -0.07F};
		this.armMain = new ModelPart[] {this.BodyMain, this.ArmRight01, this.ArmRight02};
		this.armOff = new ModelPart[] {this.BodyMain, this.ArmLeft01, this.ArmLeft02};
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
    	
    	//reset light
    	int j = packedLight;
        int k = j % 65536;
        int l = j / 65536;
		glowLight = false;
    	
    	poseStack.popPose();
    
	}

	public void showEquip(IShipEmotion ent)
	{

		int state = ent.getStateEmotion(ID.S.State);
		
		boolean flag = !EmotionHelper.checkModelState(0, state);	//wrist
		this.EquipHandRing.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(1, state);	//ring
		this.RingBase.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);	//torpedo
		this.EquipTBase.visible = !(flag);
		
		//hide torpedo 2
		this.EquipTBase_2.visible = false;
	
	}

	public void syncRotationGlowPart()
	{

		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowNeck.xRot = this.Neck.xRot;
		this.GlowNeck.yRot = this.Neck.yRot;
		this.GlowNeck.zRot = this.Neck.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (0.27F); this.animTransZ += (0F);
  		this.setFaceHungry(ent);

  	    //頭部
	  	this.Head.xRot = -0.15F;
	  	this.Head.yRot = 0F;
	  	this.Head.zRot = 0F;
	  	//Body
	  	this.BodyMain.xRot = 1.6F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.21F;
    	this.Butt.y = (-2.0F) + (0F) * 16F;
    	this.Butt.z = (-4.0F) + (0F) * 16F;
    	//cloth
	  	this.Cloth03.xRot = 0.087F;
	  	this.Cloth03.y = (2.3F) + (0F) * 16F;
	  	this.Cloth03.z = (-0.2F) + (0F) * 16F;
	  	this.Cloth04.xRot = -0.052F;
	  	this.Cloth04.y = (2.0F) + (0F) * 16F;
	  	this.Cloth04.z = (-0.3F) + (0F) * 16F;
	  	//hair
	  	this.Hair01.xRot = 0.35F;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -0.2F;
	  	this.Hair02.zRot = 0F;
	    //arm 
	  	this.ArmLeft01.xRot = -3.0F;
	  	this.ArmLeft01.yRot = -0.6981F;
	    this.ArmLeft01.zRot = 0.08F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.yRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmRight01.xRot = -3.0F;
	  	this.ArmRight01.yRot = 0.6981F;
	    this.ArmRight01.zRot = -0.08F;
	    this.ArmRight02.xRot = 0F;
	    this.ArmRight02.yRot = 0F;
	    this.ArmRight02.zRot = 0F;
		//leg
    	this.LegLeft01.xRot = -0.3F;
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = -0.05F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.y = (9.0F) + (0F) * 16F;
		this.LegLeft02.z = (-2.5F) + (0F) * 16F;
		this.LegRight01.xRot = -0.3F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = 0.05F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.y = (9.0F) + (0F) * 16F;
		this.LegRight02.z = (-2.5F) + (0F) * 16F;
		//equip
		this.EquipTBase.xRot = 0.8F;
		this.EquipTBase.yRot = 0F;
		this.EquipTBase.zRot = 1.2F;
		this.EquipTBase.x = (-2.6F) + (0F) * 16F;
		this.EquipTBase.y = (9.0F) + (0F) * 16F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F);
  		float angleX1 = Mth.cos(f2*0.08F + 0.4F + f * 0.5F);
  		float angleX2 = Mth.cos(f2*0.08F + 0.8F + f * 0.5F);
  		float angleX3 = Mth.cos(f2*0.08F + 1.2F + f * 0.5F);
  		float angleX4 = Mth.cos(f2*0.08F + 1.6F + f * 0.5F);
  		float angleX5 = Mth.cos(f2*0.08F + 2.0F + f * 0.5F);
  		float angleX6 = Mth.cos(f2*0.08F + 2.4F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.5F;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.5F;
  		float addk1 = 0F;
  		float addk2 = 0F;
  		float headX = 0F;
  		float headZ = 0F;
  		int state = ent.getStateEmotion(ID.S.State);
  		boolean showTorpedo = EmotionHelper.checkModelState(2, state);
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.025F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//leg move parm
  		addk1 = angleAdd1 * 0.6F - 0.1F;
	  	addk2 = angleAdd2 * 0.6F - 0.1F;

  	    //移動頭部使其看人
	  	this.Head.xRot = f4 * 0.014F; 	//上下角度
	  	this.Head.yRot = f3 * 0.006F;	//左右角度
	  	this.Head.zRot = 0F;
	  	headX = this.Head.xRot * -0.5F;
	    //正常站立動作
	  	//Body
  	    this.Ahoke01.xRot = angleX1 * 0.07F - 2.01F;
  	    this.Ahoke01.yRot = 0.52F;
  	    this.Ahoke01.zRot = 0F;
  	    this.Ahoke02.xRot = -angleX2 * 0.09F + 1.04F;
  	    this.Ahoke03.xRot = angleX3 * 0.15F + 0.78F;
  	    this.Ahoke04.xRot = -angleX4 * 0.10F + 0.44F;
  	    this.Ahoke05.xRot = -angleX5 * 0.15F - 0.17F;
  	    this.Ahoke06.xRot = angleX6 * 0.18F - 0.31F;
  	    this.Ahoke01a.xRot = angleX1 * 0.07F - 2.27F;
  	    this.Ahoke01a.yRot = -2.62F;
  	    this.Ahoke01a.zRot = 0F;
	    this.Ahoke02a.xRot = -angleX2 * 0.09F + 0.79F;
	    this.Ahoke03a.xRot = angleX3 * 0.15F + 1.05F;
	    this.Ahoke04a.xRot = -angleX4 * 0.10F + 0.41F;
	    this.Ahoke05a.xRot = -angleX5 * 0.15F - 0.3F;
	    this.Ahoke06a.xRot = angleX6 * 0.18F - 0.25F;
	  	this.BodyMain.xRot = -0.0873F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.21F;
    	this.Butt.y = (-2.0F) + (0F) * 16F;
    	this.Butt.z = (-4.0F) + (0F) * 16F;
    	//cloth
    	this.Cloth02.xRot = 0.087F;
	  	this.Cloth02.y = (3.0F) + (0F) * 16F;
	  	this.Cloth02.z = (-0.3F) + (0F) * 16F;
	  	this.Cloth03.xRot = 0.087F;
	  	this.Cloth03.y = (2.3F) + (0F) * 16F;
	  	this.Cloth03.z = (-0.2F) + (0F) * 16F;
	  	this.Cloth04.xRot = -0.052F;
	  	this.Cloth04.y = (2.0F) + (0F) * 16F;
	  	this.Cloth04.z = (-0.3F) + (0F) * 16F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.03F + 0.26F + headX;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -angleX1 * 0.04F - 0.087F + headX;
	  	this.Hair02.zRot = 0F;
	    //arm 
	  	this.ArmLeft01.xRot = angleAdd2 * 0.8F - 0.05F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = angleX * 0.025F - 0.3F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.yRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.0F) + (0F) * 16F;
	    this.ArmRight01.xRot = angleAdd1 * 0.8F + 0.26F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -angleX * 0.025F + 0.4F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.yRot = 0F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
	    this.ArmRight02.z = (2.0F) + (0F) * 16F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = -0.035F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (0.0F) + (0F) * 16F;
		this.LegLeft02.y = (9.0F) + (0F) * 16F;
		this.LegLeft02.z = (-2.5F) + (0F) * 16F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = 0.035F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.x = (0.0F) + (0F) * 16F;
		this.LegRight02.y = (9.0F) + (0F) * 16F;
		this.LegRight02.z = (-2.5F) + (0F) * 16F;
		//equip
		this.EquipTBase.xRot = 0.15F;
		this.EquipTBase.yRot = 0F;
		this.EquipTBase.zRot = 0F;
		this.EquipTBase.x = (-2.6F) + (-0.13F) * 16F;
		this.EquipTBase.y = (9.0F) + (0F) * 16F;
		this.EquipTBase_2.xRot = 0.15F;
		this.EquipTBase_2.yRot = 0F;
		this.EquipTBase_2.zRot = 0F;
		this.EquipTBase_2.x = (2.6F) + (0F) * 16F;
		this.EquipTBase_2.y = (9.0F) + (0F) * 16F;
		
		//奔跑動作
	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {
	    	if (ent.getIsRiding())
	    	{
	    		if (f1 > 0.5F)
	    		{
	    			this.Head.xRot += 0.4F;
		    		this.Hair01.xRot += 0.1F;
				  	this.Hair02.xRot -= 0.2F;
	    		}
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (-0.06F); this.animTransZ += (0F);
	    		this.Head.xRot -= 1.3F;
	    		this.Hair01.xRot += 0.6F;
			  	this.Hair02.xRot += 0.5F;
			  	this.Ahoke01.xRot += 0.38F;
			  	this.Ahoke01.yRot = 0.7F;
			  	this.Ahoke01.zRot = 0.4F;
			  	this.Ahoke01a.yRot = -2.5F;
			  	this.Ahoke01a.zRot = -0.2F;
	    	}
	    	
		    //body
	    	this.BodyMain.xRot = 1.5F;
	    	//arm
	    	this.ArmLeft01.xRot = -2.9F;
		    this.ArmLeft01.zRot = -0.22F;
		    this.ArmRight01.xRot = -2.9F;
		    this.ArmRight01.zRot = 0.22F;
		    //leg
		    this.LegLeft01.zRot = 0.05F;
		  	this.LegRight01.zRot = -0.05F;
		  	//equip
		  	if (showTorpedo)
		  	{
		  		this.EquipTBase.xRot = 1.42F;
				this.EquipTBase.yRot = 0F;
				this.EquipTBase.zRot = -0.22F;
				this.EquipTBase.x = (-2.6F) + (0.17F) * 16F;
				this.EquipTBase.y = (9.0F) + (0.64F) * 16F;
				this.EquipTBase_2.visible = true;
				this.EquipTBase_2.xRot = 1.42F;
				this.EquipTBase_2.yRot = 0F;
				this.EquipTBase_2.zRot = 0.22F;
				this.EquipTBase_2.x = (2.6F) + (-0.17F) * 16F;
				this.EquipTBase_2.y = (9.0F) + (0.64F) * 16F;
		  	}
	    }
	    
	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    //潛行跟蹲下動作
	    if (ent.getIsSneaking())
	    {
this.animTransX += (0F); this.animTransY += (0.01F); this.animTransZ += (0F);
	    	
	    	//Body
	    	this.Head.xRot -= 0.6283F;
		  	this.BodyMain.xRot = 0.8727F;
		  	this.Cloth03.xRot = -0.34F;
		  	this.Cloth03.y = (2.3F) + (-0.2F) * 16F;
		  	this.Cloth03.z = (-0.2F) + (0.03F) * 16F;
		  	this.Cloth04.xRot = -0.27F;
		    //arm 
		  	this.ArmLeft01.xRot = -0.35F;
		    this.ArmLeft01.zRot = 0.2618F;
			this.ArmRight01.xRot = -0.35F;
			this.ArmRight01.zRot = -0.2618F;
			//leg
			addk1 -= 0.94F;
			addk2 -= 0.94F;
			this.LegLeft01.zRot = 0.2F;
			this.LegRight01.zRot = -0.2F;
			//hair
			this.Hair01.xRot = this.Hair01.xRot * 0.5F + 0.4F;
			this.Hair02.xRot = this.Hair02.xRot * 0.75F + 0.25F;
			//equip
			this.EquipTBase.xRot = 0.48F;
			this.EquipTBase.yRot = 1.55F;
			this.EquipTBase.zRot = 0F;
			this.EquipTBase.x = (-2.6F) + (0F) * 16F;
			this.EquipTBase.y = (9.0F) + (0F) * 16F;
  		}//end if sneaking
  		
	    //坐下動作
	    if (ent.getIsSitting() && !ent.getIsRiding())
	    {
	    	if (ent.getTickExisted() % 512 > 256)
	    	{
	    		this.setFaceDamaged(ent);
this.animTransX += (0F); this.animTransY += (-angleX * 0.05F - 0.1F); this.animTransZ += (0F);
			    //body
		    	this.Head.xRot *= 0.5F;
		    	this.Head.yRot *= 0.75F;
			    this.Head.xRot += 0.5F;
		    	this.BodyMain.xRot = 1.6F;
		    	this.Cloth03.xRot = -0.33F;
		    	this.Cloth03.y = (2.3F) + (-0.23F) * 16F;
		    	this.Cloth04.xRot = -0.12F;
		    	this.Cloth04.y = (2.0F) + (-0.16F) * 16F;
		    	this.Ahoke01.xRot += 0.38F;
			  	this.Ahoke01.yRot = 0.8F;
			  	this.Ahoke01.zRot = 0.4F;
			  	this.Hair01.xRot -= 0.2F;
		    	this.Hair02.xRot -= 0.25F;
		    	//arm
		    	this.ArmLeft01.xRot = -1.5F;
		    	this.ArmLeft01.zRot = -2.3F;
		    	this.ArmRight01.xRot = -1.5F;
		    	this.ArmRight01.zRot = 2.3F;
			    //leg
			    addk1 = -1.8F;
		    	addk2 = -1.8F;
			    this.LegLeft01.yRot = -0.1F - angleX * 0.02F;
			  	this.LegRight01.yRot = 0.1F + angleX * 0.02F;
	    	}
	    	else
	    	{
		    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		    	{
this.animTransX += (0F); this.animTransY += (0.26F); this.animTransZ += (0F);
			    	
			    	this.setFaceDamaged(ent);
			    	
			    	//body
			    	this.Head.xRot = 0.4F;
			    	this.Cloth03.xRot = -0.64F;
			    	this.Cloth03.y = (2.3F) + (-0.17F) * 16F;
			    	this.Cloth03.z = (-0.2F) + (0F) * 16F;
			    	this.Cloth04.xRot = 0.29F;
			    	this.Cloth04.y = (2.0F) + (-0.04F) * 16F;
			    	this.Cloth04.z = (-0.3F) + (0.02F) * 16F;
			    	this.Hair01.xRot -= 0.2F;
			    	this.Hair02.xRot -= 0.15F;
			    	this.Ahoke01.xRot -= 0.1F;
			    	//arm
			    	this.ArmLeft01.xRot = 0.4F;
			    	this.ArmLeft01.yRot = -2.96705972839036F;
			    	this.ArmLeft01.zRot = -2.62F;
			    	this.ArmLeft02.xRot = 0.0F;
			    	this.ArmLeft02.yRot = 0.0F;
			    	this.ArmLeft02.zRot = 1F;
			    	this.ArmLeft02.x = (3.0F) + (0F) * 16F;
			    	this.ArmLeft02.z = (2.0F) + (0F) * 16F;
			    	this.ArmRight01.xRot = 0.5235987755982988F;
			    	this.ArmRight01.yRot = 2.96705972839036F;
			    	this.ArmRight01.zRot = 2.62F;
			    	this.ArmRight02.xRot = 0.0F;
			    	this.ArmRight02.yRot = 0.0F;
			    	this.ArmRight02.zRot = -1F;
			    	this.ArmRight02.x = (-3.0F) + (0F) * 16F;
			    	this.ArmRight02.z = (2.0F) + (0F) * 16F;
			    	//leg
			    	addk1 = -2.41309222380736F;
			    	addk2 = -2.2689280275926285F;
			    	this.LegLeft01.yRot = 0.0F;
			    	this.LegLeft01.zRot = -0.27314402793711257F;
			    	this.LegLeft02.xRot = 1.4570008595648662F;
			    	this.LegLeft02.yRot = 0.0F;
			    	this.LegLeft02.zRot = 0.0F;
			    	this.LegRight01.yRot = 0.0F;
			    	this.LegRight01.zRot = 0.22759093446006054F;
			    	this.LegRight02.xRot = 1.0471975511965976F;
			    	this.LegRight02.yRot = 0.0F;
			    	this.LegRight02.zRot = 0.0F;
			    	//equip
			    	this.EquipTBase.visible = false;
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.24F); this.animTransZ += (0F);
	    	
			    	//body
			    	this.Head.xRot -= 0.7F;
			    	this.BodyMain.xRot = 0.35F;
			    	this.Hair01.xRot += 0.3F;
			    	this.Hair02.xRot += 0.3F;
			    	this.Cloth03.xRot = -0.32F;
			    	this.Cloth03.y = (2.3F) + (-0.05F) * 16F;
			    	this.Cloth04.xRot = -0.21F;
			    	//arm
					this.ArmLeft01.xRot = -0.5235987755982988F;
					this.ArmLeft01.yRot = 0.0F;
					this.ArmLeft01.zRot = 0.3490658503988659F;
				    this.ArmLeft02.xRot = 0F;
				    this.ArmLeft02.zRot = 0F;
				    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
				    this.ArmLeft02.z = (2.0F) + (0F) * 16F;
					this.ArmRight01.xRot = -0.5235987755982988F;
					this.ArmRight01.yRot = 0.0F;
					this.ArmRight01.zRot = -0.3490658503988659F;
					this.ArmRight02.xRot = 0F;
					this.ArmRight02.zRot = 0F;
					this.ArmRight02.x = (-3.0F) + (0F) * 16F;
					this.ArmRight02.z = (2.0F) + (0F) * 16F;
			    	//leg
			    	addk1 = -1.4486232791552935F;
			    	addk2 = -1.4486232791552935F;
					this.LegLeft01.yRot = -0.5235987755982988F;
					this.LegLeft01.zRot = -1.3962634015954636F;
					this.LegLeft02.xRot = 2.1816615649929116F;
					this.LegLeft02.yRot = 0.0F;
					this.LegLeft02.zRot = 0.0F;
					this.LegLeft02.x = (0.0F) + (0F) * 16F;
					this.LegLeft02.z = (-2.5F) + (0.37F) * 16F;
					this.LegRight01.yRot = 0.5235987755982988F;
					this.LegRight01.zRot = 1.3962634015954636F;
					this.LegRight02.xRot = 2.1816615649929116F;
					this.LegRight02.yRot = 0.0F;
					this.LegRight02.zRot = 0.0F;
					this.LegRight02.x = (0.0F) + (0F) * 16F;
					this.LegRight02.z = (-2.5F) + (0.37F) * 16F;
		    	}
	    	}
  		}//end sitting
	    
	    //騎乘專屬坐騎動作
	    if (ent.getIsRiding())
	    {
	    	//player mount
	    	if (((Entity)ent).getVehicle() instanceof Player)
	    	{
	    		//body
    			this.Head.yRot *= 0.25F;
    			
	    		if (ent.getIsSitting())
	    		{
	    			if (((Entity)ent).getVehicle().isShiftKeyDown())
	    			{
this.animTransX += (0F); this.animTransY += (0.33F); this.animTransZ += (0.27F);
	    			}
	    			else
	    			{
this.animTransX += (0F); this.animTransY += (0.24F); this.animTransZ += (0.27F);
	    			}
	    	    	
	    			//cloth
	    			this.Cloth02.xRot = -0.13F;
	    			this.Cloth02.y = (3.0F) + (-0.11F) * 16F;
	    			this.Cloth03.xRot = -0.07F;
	    			this.Cloth03.y = (2.3F) + (-0.11F) * 16F;
	    			this.Cloth04.xRot = -0.11F;
	    			this.Cloth04.y = (2.0F) + (-0.08F) * 16F;
	    			//arm
	    	    	this.ArmLeft01.xRot = -1.2F;
	    	    	this.ArmLeft01.yRot = -0.3F;
	    	    	this.ArmRight01.xRot = -1.2F;
	    	    	this.ArmRight01.yRot = 0.3F;
	    	    	//leg
	    	    	addk1 = -1.66F;
	    	    	addk2 = -1.66F;
	    	    	this.LegLeft01.yRot = -0.6F;
	    	    	this.LegRight01.yRot = 0.6F;
		    	}//end if sitting
		    	else
		    	{
		    		if (((Entity)ent).getVehicle().isShiftKeyDown())
	    			{
this.animTransX += (0F); this.animTransY += (0.16F); this.animTransZ += (0.17F);
	    			}
	    			else
	    			{
this.animTransX += (0F); this.animTransY += (0.07F); this.animTransZ += (0.17F);
	    			}
		    		
		    	    //body
		        	this.Head.xRot *= 0.5F;
		        	this.Head.yRot *= 0.75F;
		    	    this.Head.xRot -= 1.1F;
		        	this.BodyMain.xRot = 1.5F;
		    		this.Cloth02.y = (3.0F) + (-0.11F) * 16F;
		    		this.Cloth03.xRot = -0.07F;
		    		this.Cloth03.y = (2.3F) + (-0.11F) * 16F;
		    		this.Cloth04.xRot = -0.11F;
		    		this.Cloth04.y = (2.0F) + (-0.08F) * 16F;
		        	//hair
		        	this.Ahoke01.xRot += 0.38F;
		    	  	this.Ahoke01.yRot = 0.8F;
		    	  	this.Ahoke01.zRot = 0.4F;
		    	  	this.Hair01.xRot += 0.4F;
		        	this.Hair02.xRot += 0.2F;
		        	//arm
		        	this.ArmLeft01.xRot = -1.39F;
		        	this.ArmLeft01.yRot = -1.09F;
		        	this.ArmLeft02.xRot = -1.18F;
		        	this.ArmRight01.xRot = -1.39F;
		        	this.ArmRight01.yRot = 1.09F;
		        	this.ArmRight02.xRot = -1.18F;
		    	    //leg
		    	    addk1 = -1.7F;
		        	addk2 = -1.7F;
		    	    this.LegLeft01.yRot = -0.2F;
		    	  	this.LegRight01.yRot = 0.2F;
		    	  	//equip
		    	  	this.EquipTBase.xRot = 1.29F;
		    	}
	    	}
	    	//normal mount
	    	else
	    	{
	    		if (ent.getIsSitting())
	    		{
	    			if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
			    	{
	    				this.setFaceDamaged(ent);
this.animTransX += (0F); this.animTransY += (-angleX * 0.05F - 0.16F); this.animTransZ += (0F);
	    			    //body
	    		    	this.Head.xRot *= 0.5F;
	    		    	this.Head.yRot *= 0.75F;
	    			    this.Head.xRot += 0.5F;
	    		    	this.BodyMain.xRot = 1.6F;
	    		    	this.Cloth03.xRot = -0.33F;
	    		    	this.Cloth03.y = (2.3F) + (-0.23F) * 16F;
	    		    	this.Cloth04.xRot = -0.12F;
	    		    	this.Cloth04.y = (2.0F) + (-0.16F) * 16F;
	    		    	this.Ahoke01.xRot += 0.38F;
	    			  	this.Ahoke01.yRot = 0.8F;
	    			  	this.Ahoke01.zRot = 0.4F;
	    			  	this.Hair01.xRot -= 0.2F;
	    		    	this.Hair02.xRot -= 0.25F;
	    		    	//arm
	    		    	this.ArmLeft01.xRot = -1.5F;
	    		    	this.ArmLeft01.zRot = -2.3F;
	    		    	this.ArmRight01.xRot = -1.5F;
	    		    	this.ArmRight01.zRot = 2.3F;
	    			    //leg
	    			    addk1 = -1.8F;
	    		    	addk2 = -1.8F;
	    			    this.LegLeft01.yRot = -0.1F - angleX * 0.02F;
	    			  	this.LegRight01.yRot = 0.1F + angleX * 0.02F;
			    	}
			    	else
			    	{
this.animTransX += (0F); this.animTransY += (0.24F); this.animTransZ += (0F);
				    	
				    	this.setFaceDamaged(ent);
				    	
				    	//body
				    	this.Head.xRot = 0.4F;
				    	this.Cloth03.xRot = -0.64F;
				    	this.Cloth03.y = (2.3F) + (-0.17F) * 16F;
				    	this.Cloth03.z = (-0.2F) + (0F) * 16F;
				    	this.Cloth04.xRot = 0.29F;
				    	this.Cloth04.y = (2.0F) + (-0.04F) * 16F;
				    	this.Cloth04.z = (-0.3F) + (0.02F) * 16F;
				    	this.Hair01.xRot -= 0.2F;
				    	this.Hair02.xRot -= 0.15F;
				    	this.Ahoke01.xRot -= 0.1F;
				    	//arm
				    	this.ArmLeft01.xRot = 0.4F;
				    	this.ArmLeft01.yRot = -2.96705972839036F;
				    	this.ArmLeft01.zRot = -2.62F;
				    	this.ArmLeft02.xRot = 0.0F;
				    	this.ArmLeft02.yRot = 0.0F;
				    	this.ArmLeft02.zRot = 1F;
				    	this.ArmLeft02.x = (3.0F) + (0F) * 16F;
				    	this.ArmLeft02.z = (2.0F) + (0F) * 16F;
				    	this.ArmRight01.xRot = 0.5235987755982988F;
				    	this.ArmRight01.yRot = 2.96705972839036F;
				    	this.ArmRight01.zRot = 2.62F;
				    	this.ArmRight02.xRot = 0.0F;
				    	this.ArmRight02.yRot = 0.0F;
				    	this.ArmRight02.zRot = -1F;
				    	this.ArmRight02.x = (-3.0F) + (0F) * 16F;
				    	this.ArmRight02.z = (2.0F) + (0F) * 16F;
				    	//leg
				    	addk1 = -2.41309222380736F;
				    	addk2 = -2.2689280275926285F;
				    	this.LegLeft01.yRot = 0.0F;
				    	this.LegLeft01.zRot = -0.27314402793711257F;
				    	this.LegLeft02.xRot = 1.4570008595648662F;
				    	this.LegLeft02.yRot = 0.0F;
				    	this.LegLeft02.zRot = 0.0F;
				    	this.LegRight01.yRot = 0.0F;
				    	this.LegRight01.zRot = 0.22759093446006054F;
				    	this.LegRight02.xRot = 1.0471975511965976F;
				    	this.LegRight02.yRot = 0.0F;
				    	this.LegRight02.zRot = 0.0F;
			    	}
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.26F); this.animTransZ += (0F);
			    	
			    	//body
			    	this.Head.xRot -= 0.7F;
			    	this.BodyMain.xRot = 0.35F;
			    	this.Hair01.xRot += 0.3F;
			    	this.Hair02.xRot += 0.3F;
			    	this.Cloth03.xRot = -0.32F;
			    	this.Cloth03.y = (2.3F) + (-0.05F) * 16F;
			    	this.Cloth04.xRot = -0.21F;
			    	//arm
					this.ArmLeft01.xRot = -0.5235987755982988F;
					this.ArmLeft01.yRot = 0.0F;
					this.ArmLeft01.zRot = 0.3490658503988659F;
				    this.ArmLeft02.xRot = 0F;
				    this.ArmLeft02.zRot = 0F;
				    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
				    this.ArmLeft02.z = (2.0F) + (0F) * 16F;
					this.ArmRight01.xRot = -0.5235987755982988F;
					this.ArmRight01.yRot = 0.0F;
					this.ArmRight01.zRot = -0.3490658503988659F;
					this.ArmRight02.xRot = 0F;
					this.ArmRight02.zRot = 0F;
					this.ArmRight02.x = (-3.0F) + (0F) * 16F;
					this.ArmRight02.z = (2.0F) + (0F) * 16F;
			    	//leg
			    	addk1 = -1.4486232791552935F;
			    	addk2 = -1.4486232791552935F;
					this.LegLeft01.yRot = -0.5235987755982988F;
					this.LegLeft01.zRot = -1.3962634015954636F;
					this.LegLeft02.xRot = 2.1816615649929116F;
					this.LegLeft02.yRot = 0.0F;
					this.LegLeft02.zRot = 0.0F;
					this.LegLeft02.x = (0.0F) + (0F) * 16F;
					this.LegLeft02.z = (-2.5F) + (0.37F) * 16F;
					this.LegRight01.yRot = 0.5235987755982988F;
					this.LegRight01.zRot = 1.3962634015954636F;
					this.LegRight02.xRot = 2.1816615649929116F;
					this.LegRight02.yRot = 0.0F;
					this.LegRight02.zRot = 0.0F;
					this.LegRight02.x = (0.0F) + (0F) * 16F;
					this.LegRight02.z = (-2.5F) + (0.37F) * 16F;
		    	}
	    	}
	    }//end ridding
	    
	    //攻擊動作    
	    int atktime = ent.getAttackTick();
	    if (atktime > 41)
	    {
	    	this.EquipTBase.visible = true;
	    	this.EquipTBase_2.visible = true;
	    	this.EquipTBase.x = (-2.6F) + (0F) * 16F;
			this.EquipTBase.y = (9.0F) + (0F) * 16F;
	    	
	    	setFaceAttack(ent);
	    	//swing arm
		    float ft = (50 - ent.getAttackTick()) + (f2 - (int)f2);
		    ft *= 0.125F;
	  		float fa = Mth.cos(ft * ft * (float)Math.PI);
	        float fb = Mth.cos(Mth.sqrt(ft) * (float)Math.PI);
	        this.ArmLeft01.xRot += -fb * 120.0F * Values.N.DIV_PI_180 - 1.5F;
	        this.ArmLeft01.yRot += fa * 20.0F * Values.N.DIV_PI_180;
	        this.ArmLeft01.zRot += fb * 20.0F * Values.N.DIV_PI_180 + 0.26F;
	    }
	    if (atktime > 36 && atktime <  45)
	    {
	    	this.EquipTBase.visible = true;
	    	this.EquipTBase_2.visible = true;
	    	this.EquipTBase.x = (-2.6F) + (0F) * 16F;
			this.EquipTBase.y = (9.0F) + (0F) * 16F;
	    	
	    	setFaceAttack(ent);
	    	//swing arm
		    float ft = (45 - ent.getAttackTick()) + (f2 - (int)f2);
		    ft *= 0.125F;
	  		float fa = Mth.cos(ft * ft * (float)Math.PI);
	        float fb = Mth.cos(Mth.sqrt(ft) * (float)Math.PI);
	        this.ArmRight01.xRot += -fb * 120.0F * Values.N.DIV_PI_180 - 1.5F;
	        this.ArmRight01.yRot += -fa * 20.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.zRot += -fb * 20.0F * Values.N.DIV_PI_180 - 0.26F;
	    }
	    
	  	//swing arm
	  	float f6 = ent.getSwingTime(f2 % 1F);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight01.xRot = -0.3F;
			this.ArmRight01.yRot = 0F;
			this.ArmRight01.zRot = -0.1F;
	        this.ArmRight01.xRot += -f8 * 80.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.yRot += -f7 * 20.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.zRot += -f8 * 20.0F * Values.N.DIV_PI_180;
	        this.ArmRight02.xRot = 0F;
	        this.ArmRight02.zRot = 0F;
	  	}
	  	
	    //移動頭髮避免穿過身體
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.zRot = headZ;
	  	this.Hair02.zRot = headZ;
	  	
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

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

public class ModelNorthernHime<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart Butt;
	public ModelPart EquipBase;
	public ModelPart Cloth01;
	public ModelPart Neck;
	public ModelPart ArmLeft02;
	public ModelPart ArmLeft03;
	public ModelPart ArmLeft04;
	public ModelPart ArmLeft05;
	public ModelPart ArmLeft06;
	public ModelPart EquipUmbre01a;
	public ModelPart EquipUmbre01b;
	public ModelPart EquipUmbre02;
	public ModelPart EquipUmbre01c;
	public ModelPart EquipUmbre02a;
	public ModelPart EquipUmbre03a;
	public ModelPart EquipUmbre02b;
	public ModelPart EquipUmbre03b;
	public ModelPart ArmRight02;
	public ModelPart ArmRight03;
	public ModelPart ArmRight04;
	public ModelPart ArmRight05;
	public ModelPart ArmRight06;
	public ModelPart LegRight01;
	public ModelPart ArmRightItem;
	public ModelPart LegLeft01;
	public ModelPart LegRight02;
	public ModelPart ShoesR;
	public ModelPart LegLeft02;
	public ModelPart ShoesL2;
	public ModelPart ShoesL;
	public ModelPart EquipRT01;
	public ModelPart EquipLT01;
	public ModelPart EquipRT02;
	public ModelPart HeadBase;
	public ModelPart TailJaw1;
	public ModelPart TailHead1;
	public ModelPart TailHeadCL1;
	public ModelPart TailHeadCR1;
	public ModelPart EquipRoad01;
	public ModelPart TailJawT01;
	public ModelPart TailHead2;
	public ModelPart TailHeadT01;
	public ModelPart TailHeadC2;
	public ModelPart TailHeadC3;
	public ModelPart EquipRoad02;
	public ModelPart EquipRoad03;
	public ModelPart EquipLT02;
	public ModelPart EquipLT03;
	public ModelPart EquipLT04;
	public ModelPart EquipLT05;
	public ModelPart EquipLT06;
	public ModelPart EquipLHead;
	public ModelPart EquipLHead01;
	public ModelPart EquipLHead02;
	public ModelPart EquipLHead03;
	public ModelPart Cloth02;
	public ModelPart Cloth03;
	public ModelPart SantaCloth01;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart HeadHL;
	public ModelPart HeadHR;
	public ModelPart SantaHat01;
	public ModelPart Ahoke;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart HairL02;
	public ModelPart HairR02;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart HeadHL2;
	public ModelPart HeadHL3;
	public ModelPart HeadHR2;
	public ModelPart HeadHR3;
	public ModelPart SantaHat02;
	public ModelPart SantaHat03;
	public ModelPart SantaHat04;
	public ModelPart SantaHat05;
	public ModelPart HairS01a;
	public ModelPart HairS01b;
	public ModelPart HairS02a;
	public ModelPart HairS02b;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ModelPart GlowEquipBase;
	public ModelPart GlowEquipRT01;
	public ModelPart GlowEquipRT02;
	public ModelPart GlowHeadBase;
	public ModelPart GlowTailHead1;
	public ModelPart GlowTailJaw1;
	public ModelPart GlowTailHead2;
	public ModelPart GlowEquipLT01;
	public ModelPart GlowEquipLT02;
	public ModelPart GlowEquipLT03;
	public ModelPart GlowEquipLT04;
	public ModelPart GlowEquipLT05;
	public ModelPart GlowEquipLT06;
	//additional offset
	protected float[] offsetItem2 = new float[] {0.05F, 1F, -0.14F};
	protected float[] offsetBlock2 = new float[] {0.1F, 1.13F, 0.1F};
	protected float[] rotateItem2 = new float[] {-30F, 30F, -60F};

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-7.0F, 0.0F, 0.0F, 14.0F, 4.0F, 8.0F), PartPose.offset(0.0F, -5.0F, -4.4F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("Cloth02", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -0.3F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("Cloth03", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 4.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -0.2F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("SantaCloth01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 2.0F, 11.0F), PartPose.offset(0.0F, 3.0F, -0.3F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-7.0F, -2.0F, -6.0F, 14.0F, 3.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -11.3F, -0.5F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 10.0F), PartPose.offset(0.0F, -15.0F, -3.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 2.0F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.0F, 0.0F, -8.0F, 16.0F, 12.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 9.5F, 7.5F, 0.136659280431156F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef8.addOrReplaceChild("HairS01a", CubeListBuilder.create().addBox(0F, 0F, -2F, 0.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(7.5F, -1F, 3.5F, 0.087F, 0F, -0.2618F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("HairS01b", CubeListBuilder.create().addBox(0F, 0F, -2F, 0.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(0F, 7F, 0F, 0F, 0F, -0.2618F));
		PartDefinition partdef12 = partdef8.addOrReplaceChild("HairS02a", CubeListBuilder.create().addBox(0F, 0F, -2F, 0.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(-7.5F, 3F, 2.5F, 0.087F, 0F, 0.35F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("HairS02b", CubeListBuilder.create().addBox(0F, 0F, -2F, 0.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(0F, 7F, 0F, 0F, 0F, 0.35F));
		PartDefinition partdef14 = partdef6.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.2F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(-6.5F, 3.0F, -4.5F, -0.2617993877991494F, 0.17453292519943295F, 0.13962634015954636F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(0.2F, 7.5F, 0.0F, 0.2617993877991494F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef17 = partdef14.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -12.0F, -6.0F, 0.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0F, -5.0F, -5.0F, 0.35F, 2.1F, 0.0F));
		PartDefinition partdef18 = partdef14.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(6.5F, 3.0F, -4.5F, -0.2617993877991494F, -0.17453292519943295F, -0.13962634015954636F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(-0.2F, 7.5F, 0.0F, 0.2617993877991494F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef20 = partdef6.addOrReplaceChild("SantaHat01", CubeListBuilder.create().addBox(-6.5F, 0.0F, -6.5F, 13.0F, 3.0F, 13.0F), PartPose.offsetAndRotation(4.0F, -16.5F, 3.0F, -0.4363323129985824F, 0.8726646259971648F, -0.13962634015954636F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("SantaHat02", CubeListBuilder.create().addBox(-4.5F, -8.0F, -4.5F, 9.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -0.5F, -0.5235987755982988F, 0.17453292519943295F, 0.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("SantaHat03", CubeListBuilder.create().addBox(-2.5F, -6.0F, -2.5F, 6.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -5.0F, -1.0F, -0.27314402793711257F, 0.0F, -0.5009094953223726F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("SantaHat04", CubeListBuilder.create().addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.5F, -4.5F, 0.0F, -1.1383037381507017F, -0.27314402793711257F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("SantaHat05", CubeListBuilder.create().addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(2.0F, -5.8F, 2.0F, 0.6108652381980153F, 0.6981317007977318F, -0.5235987755982988F));
		PartDefinition partdef25 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 6.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(-3.2F, 5.5F, 2.4F, -0.17453292519943295F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 5.0F), PartPose.offset(0.0F, 8F, -2.5F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("ShoesR", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F), PartPose.offset(0.0F, 4.0F, 2.5F));
		PartDefinition partdef29 = partdef25.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(3.2F, 5.5F, 2.4F, -0.17453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 5.0F), PartPose.offset(0.0F, 8F, -2.5F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("ShoesL", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F), PartPose.offset(0.0F, 4.0F, 2.5F));
		PartDefinition partdef32 = partdef29.addOrReplaceChild("ShoesL2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F), PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition partdef33 = partdef0.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, -5.0F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("EquipLT01", CubeListBuilder.create().addBox(0.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(2.0F, 4.0F, 2.5F, 0.0F, -1.0471975511965976F, -0.2617993877991494F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("EquipLT02", CubeListBuilder.create().addBox(0.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F, -0.2617993877991494F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("EquipLT03", CubeListBuilder.create().addBox(0.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F, -0.2617993877991494F));
		PartDefinition partdef37 = partdef36.addOrReplaceChild("EquipLT04", CubeListBuilder.create().addBox(0.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F, -0.2617993877991494F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("EquipLT05", CubeListBuilder.create().addBox(0.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F, -0.2617993877991494F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("EquipLT06", CubeListBuilder.create().addBox(0.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F, -0.2617993877991494F));
		PartDefinition partdef40 = partdef33.addOrReplaceChild("EquipRT01", CubeListBuilder.create().addBox(-16.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 4.0F, 0.0F, 0.7853981633974483F, 0.3490658503988659F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("EquipRT02", CubeListBuilder.create().addBox(-16.0F, -2.0F, -4.0F, 16.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(-16.0F, 0.0F, 2.0F, 0.0F, -1.0471975511965976F, 0.0F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("HeadBase", CubeListBuilder.create().addBox(-6.0F, -8.0F, 2.0F, 12.0F, 15.0F, 8.0F), PartPose.offsetAndRotation(-14.0F, -3.0F, 0.0F, -0.4363323129985824F, -2.792526803190927F, -0.13962634015954636F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("TailHead1", CubeListBuilder.create().addBox(-7.0F, -0.2F, -5.6F, 14.0F, 8.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -9.5F, 4.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("TailHead2", CubeListBuilder.create().addBox(-7.0F, 0.0F, 0.0F, 14.0F, 8.0F, 11.0F), PartPose.offset(0.0F, -1.0F, 4.5F));
		PartDefinition partdef45 = partdef42.addOrReplaceChild("TailHeadCR1", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, -3.0F, 2.0F, 11.0F, 6.0F), PartPose.offsetAndRotation(-6.0F, -5.0F, 12.0F, 0.0F, -0.05235987755982988F, 0.0F));
		PartDefinition partdef46 = partdef42.addOrReplaceChild("TailJaw1", CubeListBuilder.create().addBox(-6.5F, 0.0F, 0.0F, 13.0F, 5.0F, 14.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 5.0F, -0.27314402793711257F, 0.0F, 0.0F));
		PartDefinition partdef47 = partdef42.addOrReplaceChild("TailHeadCL1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -3.0F, 2.0F, 11.0F, 6.0F), PartPose.offsetAndRotation(6.0F, -5.0F, 12.0F, 0.0F, 0.05235987755982988F, 0.0F));
		PartDefinition partdef48 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.0F, -1.0F, -2.0F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(-6.0F, -9.8F, -0.7F, 0.2617993877991494F, 0.0F, 0.5235987755982988F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(-2.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(-1.0F, 4.0F, 2.0F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("ArmRight03", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F), PartPose.offset(0.0F, 1.0F, -2.0F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("ArmRight04", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F), PartPose.offset(0.0F, 3.0F, 0.0F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("ArmRight05", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.5F, 6.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("ArmRightItem", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		PartDefinition partdef54 = partdef52.addOrReplaceChild("ArmRight06", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(2.0F, 1.0F, -1.5F, -0.08726646259971647F, -0.08726646259971647F, -0.17453292519943295F));
		PartDefinition partdef55 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-1.0F, -1.0F, -2.0F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(6.0F, -9.8F, -0.7F, -0.27314402793711257F, 0.0F, -0.5235987755982988F));
		PartDefinition partdef56 = partdef55.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-2.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(1.0F, 4.0F, 2.0F));
		PartDefinition partdef57 = partdef56.addOrReplaceChild("ArmLeft03", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F), PartPose.offset(0.0F, 1.0F, -2.0F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("ArmLeft04", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F), PartPose.offset(0.0F, 3.0F, 0.0F));
		PartDefinition partdef59 = partdef58.addOrReplaceChild("ArmLeft05", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.5F, 6.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition partdef60 = partdef59.addOrReplaceChild("ArmLeft06", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, 1.0F, -1.5F, -0.08726646259971647F, 0.08726646259971647F, 0.17453292519943295F));
		PartDefinition partdef61 = partdef59.addOrReplaceChild("EquipUmbre01a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 12.0F), PartPose.offset(-1.0F, 4.0F, -1.0F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("EquipUmbre01b", CubeListBuilder.create().addBox(-1.0F, -1.0F, -12.0F, 2.0F, 2.0F, 12.0F), PartPose.offset(0.0F, 0.0F, -6.0F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("EquipUmbre01c", CubeListBuilder.create().addBox(-1.0F, -1.0F, -12.0F, 2.0F, 2.0F, 12.0F), PartPose.offset(0.0F, 0.0F, -12.0F));
		PartDefinition partdef64 = partdef63.addOrReplaceChild("EquipUmbre03a", CubeListBuilder.create().addBox(0.0F, -7.0F, 0.0F, 13.0F, 17.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -14.4F, 0.0F, -0.2617993877991494F, 0.36425021489121656F));
		PartDefinition partdef65 = partdef64.addOrReplaceChild("EquipUmbre03b", CubeListBuilder.create().addBox(-2.0F, -6.0F, 0.0F, 5.0F, 12.0F, 11.0F), PartPose.offsetAndRotation(1.5F, 2.0F, 2.9F, -0.091106186954104F, 0.6829473363053812F, 0.136659280431156F));
		PartDefinition partdef66 = partdef63.addOrReplaceChild("EquipUmbre02a", CubeListBuilder.create().addBox(-16.0F, -9.0F, -2.0F, 20.0F, 18.0F, 3.0F), PartPose.offsetAndRotation(-3.0F, 0.0F, -12.0F, 0.0F, 0.17453292519943295F, 0.5235987755982988F));
		PartDefinition partdef67 = partdef66.addOrReplaceChild("EquipUmbre02b", CubeListBuilder.create().addBox(-11.0F, -8.0F, 0.0F, 13.0F, 16.0F, 5.0F), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, -0.05235987755982988F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef68 = partdef61.addOrReplaceChild("EquipUmbre02", CubeListBuilder.create().addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 6.0F));
		PartDefinition partdef69 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef70 = partdef69.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -11.3F, -0.5F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef71 = partdef70.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef72 = partdef71.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef73 = partdef71.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef74 = partdef71.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef75 = partdef71.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef76 = partdef71.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef77 = partdef71.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef78 = partdef71.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef79 = partdef71.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef80 = partdef71.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef81 = partdef71.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));
		PartDefinition partdef82 = partdef71.addOrReplaceChild("HeadHR", CubeListBuilder.create().mirror().addBox(-3.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-5.9F, -10.8F, 1.0F, -0.7853981633974483F, 0.17453292519943295F, 0.3141592653589793F));
		PartDefinition partdef83 = partdef82.addOrReplaceChild("HeadHR2", CubeListBuilder.create().addBox(-1.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F), PartPose.offset(-3.0F, 0.0F, 0.0F));
		PartDefinition partdef84 = partdef83.addOrReplaceChild("HeadHR3", CubeListBuilder.create().addBox(-1.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F), PartPose.offset(-1.0F, 0.0F, 0.0F));
		PartDefinition partdef85 = partdef71.addOrReplaceChild("HeadHL", CubeListBuilder.create().mirror().addBox(0.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(5.9F, -10.9F, 1.0F, -0.7853981633974483F, -0.17453292519943295F, -0.3141592653589793F));
		PartDefinition partdef86 = partdef85.addOrReplaceChild("HeadHL2", CubeListBuilder.create().addBox(0.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F), PartPose.offset(3.0F, 0.0F, 0.0F));
		PartDefinition partdef87 = partdef86.addOrReplaceChild("HeadHL3", CubeListBuilder.create().addBox(0.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F), PartPose.offset(1.0F, 0.0F, 0.0F));
		PartDefinition partdef88 = partdef69.addOrReplaceChild("GlowEquipBase", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 0.0F));
		PartDefinition partdef89 = partdef88.addOrReplaceChild("GlowEquipRT01", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 4.0F, 0.0F, 0.7853981633974483F, 0.3490658503988659F));
		PartDefinition partdef90 = partdef89.addOrReplaceChild("GlowEquipRT02", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.0F, 0.0F, 2.0F, 0.0F, -1.0471975511965976F, 0.0F));
		PartDefinition partdef91 = partdef90.addOrReplaceChild("GlowHeadBase", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.0F, -3.0F, 0.0F, -0.4363323129985824F, -2.792526803190927F, -0.13962634015954636F));
		PartDefinition partdef92 = partdef91.addOrReplaceChild("GlowTailHead1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.5F, 4.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef93 = partdef92.addOrReplaceChild("TailHeadT01", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 4.5F, 4.5F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef94 = partdef92.addOrReplaceChild("GlowTailHead2", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 4.5F));
		PartDefinition partdef95 = partdef94.addOrReplaceChild("TailHeadC2", CubeListBuilder.create().addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(3.2F, 3.2F, 10.5F, 0.08726646259971647F, 0.08726646259971647F, 0.017627825445142728F));
		PartDefinition partdef96 = partdef94.addOrReplaceChild("TailHeadC3", CubeListBuilder.create().addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(-3.2F, 3.2F, 10.5F, 0.08726646259971647F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef97 = partdef91.addOrReplaceChild("GlowTailJaw1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.0F, 5.0F, -0.27314402793711257F, 0.0F, 0.0F));
		PartDefinition partdef98 = partdef97.addOrReplaceChild("TailJawT01", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 5.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 4.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef99 = partdef91.addOrReplaceChild("EquipRoad01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(6.0F, -11.5F, -3.0F, -0.20943951023931953F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef100 = partdef99.addOrReplaceChild("EquipRoad02", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 12.0F));
		PartDefinition partdef101 = partdef100.addOrReplaceChild("EquipRoad03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 12.0F));
		PartDefinition partdef102 = partdef88.addOrReplaceChild("GlowEquipLT01", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 4.0F, 2.5F, 0.0F, -1.0471975511965976F, -0.2617993877991494F));
		PartDefinition partdef103 = partdef102.addOrReplaceChild("GlowEquipLT02", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F, -0.2617993877991494F));
		PartDefinition partdef104 = partdef103.addOrReplaceChild("GlowEquipLT03", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F, -0.2617993877991494F));
		PartDefinition partdef105 = partdef104.addOrReplaceChild("GlowEquipLT04", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F, -0.2617993877991494F));
		PartDefinition partdef106 = partdef105.addOrReplaceChild("GlowEquipLT05", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F, -0.2617993877991494F));
		PartDefinition partdef107 = partdef106.addOrReplaceChild("GlowEquipLT06", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F, -0.2617993877991494F));
		PartDefinition partdef108 = partdef107.addOrReplaceChild("EquipLHead", CubeListBuilder.create().addBox(0.0F, -3.5F, -5.0F, 10.0F, 7.0F, 9.0F), PartPose.offsetAndRotation(5.0F, 0.0F, -1.0F, 0.0F, -0.6981317007977318F, -0.17453292519943295F));
		PartDefinition partdef109 = partdef108.addOrReplaceChild("EquipLHead01", CubeListBuilder.create().addBox(-12.0F, -1.0F, 0.0F, 12.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(4.0F, 0.0F, -4.0F, 0.0F, -0.5235987755982988F, -0.3490658503988659F));
		PartDefinition partdef110 = partdef109.addOrReplaceChild("EquipLHead02", CubeListBuilder.create().addBox(-12.0F, -1.0F, 0.0F, 12.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(-11.5F, 0.0F, 0.0F, 0.0F, 0.5235987755982988F, -0.2617993877991494F));
		PartDefinition partdef111 = partdef110.addOrReplaceChild("EquipLHead03", CubeListBuilder.create().addBox(-5.0F, -1.5F, -1.0F, 6.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(-11.5F, 0.0F, 0.0F, 0.0F, 0.31869712141416456F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelNorthernHime(ModelPart root)
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
		this.EquipUmbre03b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04").getChild("ArmLeft05").getChild("EquipUmbre01a").getChild("EquipUmbre01b").getChild("EquipUmbre01c").getChild("EquipUmbre03a").getChild("EquipUmbre03b");
		this.ShoesR = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoesR");
		this.EquipLT06 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipLT01").getChild("EquipLT02").getChild("EquipLT03").getChild("EquipLT04").getChild("EquipLT05").getChild("EquipLT06");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.ShoesL = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoesL");
		this.EquipLT02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipLT01").getChild("EquipLT02");
		this.TailJawT01 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipRT01").getChild("GlowEquipRT02").getChild("GlowHeadBase").getChild("GlowTailJaw1").getChild("TailJawT01");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.EquipLT05 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipLT01").getChild("EquipLT02").getChild("EquipLT03").getChild("EquipLT04").getChild("EquipLT05");
		this.SantaCloth01 = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth02").getChild("Cloth03").getChild("SantaCloth01");
		this.ArmLeft05 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04").getChild("ArmLeft05");
		this.ArmRight06 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03").getChild("ArmRight04").getChild("ArmRight05").getChild("ArmRight06");
		this.EquipLT01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipLT01");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.HairS01a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("HairS01a");
		this.HairS01b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("HairS01a").getChild("HairS01b");
		this.HairS02a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("HairS02a");
		this.HairS02b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("HairS02a").getChild("HairS02b");
		this.EquipUmbre03a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04").getChild("ArmLeft05").getChild("EquipUmbre01a").getChild("EquipUmbre01b").getChild("EquipUmbre01c").getChild("EquipUmbre03a");
		this.EquipRoad03 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipRT01").getChild("GlowEquipRT02").getChild("GlowHeadBase").getChild("EquipRoad01").getChild("EquipRoad02").getChild("EquipRoad03");
		this.ArmLeft04 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04");
		this.EquipLHead03 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipLT01").getChild("GlowEquipLT02").getChild("GlowEquipLT03").getChild("GlowEquipLT04").getChild("GlowEquipLT05").getChild("GlowEquipLT06").getChild("EquipLHead").getChild("EquipLHead01").getChild("EquipLHead02").getChild("EquipLHead03");
		this.SantaHat02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("SantaHat01").getChild("SantaHat02");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.EquipLT03 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipLT01").getChild("EquipLT02").getChild("EquipLT03");
		this.HeadHL3 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHL").getChild("HeadHL2").getChild("HeadHL3");
		this.HairR02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.SantaHat04 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("SantaHat01").getChild("SantaHat02").getChild("SantaHat03").getChild("SantaHat04");
		this.EquipUmbre01b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04").getChild("ArmLeft05").getChild("EquipUmbre01a").getChild("EquipUmbre01b");
		this.SantaHat03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("SantaHat01").getChild("SantaHat02").getChild("SantaHat03");
		this.EquipUmbre01c = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04").getChild("ArmLeft05").getChild("EquipUmbre01a").getChild("EquipUmbre01b").getChild("EquipUmbre01c");
		this.EquipUmbre02a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04").getChild("ArmLeft05").getChild("EquipUmbre01a").getChild("EquipUmbre01b").getChild("EquipUmbre01c").getChild("EquipUmbre02a");
		this.TailHead1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipRT01").getChild("EquipRT02").getChild("HeadBase").getChild("TailHead1");
		this.HeadHR = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHR");
		this.TailHeadC2 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipRT01").getChild("GlowEquipRT02").getChild("GlowHeadBase").getChild("GlowTailHead1").getChild("GlowTailHead2").getChild("TailHeadC2");
		this.HeadHL = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHL");
		this.ArmLeft06 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04").getChild("ArmLeft05").getChild("ArmLeft06");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.HeadBase = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipRT01").getChild("EquipRT02").getChild("HeadBase");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.TailHeadCR1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipRT01").getChild("EquipRT02").getChild("HeadBase").getChild("TailHeadCR1");
		this.EquipBase = root.getChild("BodyMain").getChild("EquipBase");
		this.Cloth02 = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth02");
		this.EquipRoad01 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipRT01").getChild("GlowEquipRT02").getChild("GlowHeadBase").getChild("EquipRoad01");
		this.TailHeadC3 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipRT01").getChild("GlowEquipRT02").getChild("GlowHeadBase").getChild("GlowTailHead1").getChild("GlowTailHead2").getChild("TailHeadC3");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.EquipUmbre02b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04").getChild("ArmLeft05").getChild("EquipUmbre01a").getChild("EquipUmbre01b").getChild("EquipUmbre01c").getChild("EquipUmbre02a").getChild("EquipUmbre02b");
		this.TailHead2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipRT01").getChild("EquipRT02").getChild("HeadBase").getChild("TailHead1").getChild("TailHead2");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.TailJaw1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipRT01").getChild("EquipRT02").getChild("HeadBase").getChild("TailJaw1");
		this.TailHeadT01 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipRT01").getChild("GlowEquipRT02").getChild("GlowHeadBase").getChild("GlowTailHead1").getChild("TailHeadT01");
		this.TailHeadCL1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipRT01").getChild("EquipRT02").getChild("HeadBase").getChild("TailHeadCL1");
		this.ShoesL2 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("ShoesL2");
		this.ArmRight04 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03").getChild("ArmRight04");
		this.SantaHat05 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("SantaHat01").getChild("SantaHat02").getChild("SantaHat03").getChild("SantaHat04").getChild("SantaHat05");
		this.EquipRT01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipRT01");
		this.EquipLHead = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipLT01").getChild("GlowEquipLT02").getChild("GlowEquipLT03").getChild("GlowEquipLT04").getChild("GlowEquipLT05").getChild("GlowEquipLT06").getChild("EquipLHead");
		this.EquipLHead02 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipLT01").getChild("GlowEquipLT02").getChild("GlowEquipLT03").getChild("GlowEquipLT04").getChild("GlowEquipLT05").getChild("GlowEquipLT06").getChild("EquipLHead").getChild("EquipLHead01").getChild("EquipLHead02");
		this.EquipUmbre02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04").getChild("ArmLeft05").getChild("EquipUmbre01a").getChild("EquipUmbre02");
		this.Cloth03 = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth02").getChild("Cloth03");
		this.BodyMain = root.getChild("BodyMain");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.HeadHR2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHR").getChild("HeadHR2");
		this.ArmRight05 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03").getChild("ArmRight04").getChild("ArmRight05");
		this.EquipLT04 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipLT01").getChild("EquipLT02").getChild("EquipLT03").getChild("EquipLT04");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.EquipUmbre01a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04").getChild("ArmLeft05").getChild("EquipUmbre01a");
		this.HairL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.EquipLHead01 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipLT01").getChild("GlowEquipLT02").getChild("GlowEquipLT03").getChild("GlowEquipLT04").getChild("GlowEquipLT05").getChild("GlowEquipLT06").getChild("EquipLHead").getChild("EquipLHead01");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.HeadHR3 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHR").getChild("HeadHR2").getChild("HeadHR3");
		this.EquipRoad02 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipRT01").getChild("GlowEquipRT02").getChild("GlowHeadBase").getChild("EquipRoad01").getChild("EquipRoad02");
		this.HeadHL2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHL").getChild("HeadHL2");
		this.EquipRT02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipRT01").getChild("EquipRT02");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.SantaHat01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("SantaHat01");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.ArmLeft03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.ArmRight03 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03");
		this.ArmRightItem = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03").getChild("ArmRight04").getChild("ArmRight05").getChild("ArmRightItem");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.GlowEquipBase = root.getChild("GlowBodyMain").getChild("GlowEquipBase");
		this.GlowEquipRT01 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipRT01");
		this.GlowEquipRT02 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipRT01").getChild("GlowEquipRT02");
		this.GlowHeadBase = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipRT01").getChild("GlowEquipRT02").getChild("GlowHeadBase");
		this.GlowTailHead1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipRT01").getChild("GlowEquipRT02").getChild("GlowHeadBase").getChild("GlowTailHead1");
		this.GlowTailJaw1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipRT01").getChild("GlowEquipRT02").getChild("GlowHeadBase").getChild("GlowTailJaw1");
		this.GlowTailHead2 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipRT01").getChild("GlowEquipRT02").getChild("GlowHeadBase").getChild("GlowTailHead1").getChild("GlowTailHead2");
		this.GlowEquipLT01 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipLT01");
		this.GlowEquipLT02 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipLT01").getChild("GlowEquipLT02");
		this.GlowEquipLT03 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipLT01").getChild("GlowEquipLT02").getChild("GlowEquipLT03");
		this.GlowEquipLT04 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipLT01").getChild("GlowEquipLT02").getChild("GlowEquipLT03").getChild("GlowEquipLT04");
		this.GlowEquipLT05 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipLT01").getChild("GlowEquipLT02").getChild("GlowEquipLT03").getChild("GlowEquipLT04").getChild("GlowEquipLT05");
		this.GlowEquipLT06 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipLT01").getChild("GlowEquipLT02").getChild("GlowEquipLT03").getChild("GlowEquipLT04").getChild("GlowEquipLT05").getChild("GlowEquipLT06");
		this.scale = 0.34F;
		this.offsetY = 3.08F;
		this.offsetItem = new float[] {0.07F, 1.02F, -0.05F};
		this.offsetBlock = new float[] {0.1F, 1.03F, 0F};
		this.armMain = new ModelPart[] {this.BodyMain, this.ArmRight01, this.ArmRight02, this.ArmRight03, this.ArmRight04, this.ArmRight05};
		this.armOff = new ModelPart[] {this.BodyMain, this.ArmLeft01, this.ArmLeft02, this.ArmLeft03, this.ArmLeft04, this.ArmLeft05};
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
    	
    	poseStack.popPose();
    
	}

	public void showEquip(IShipEmotion ent)
	{

		int state = ent.getStateEmotion(ID.S.State);
		
		boolean flag = !EmotionHelper.checkModelState(0, state);	//cannon
		this.GlowEquipBase.visible = !(flag);
		this.EquipBase.visible = !(flag);
				
		flag = !EmotionHelper.checkModelState(1, state);			//hat
		this.SantaCloth01.visible = !(flag);
		this.SantaHat01.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);			//umbrella
		this.EquipUmbre01a.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(3, state);			//leg equip
		this.ShoesL.visible = !(flag);
		this.ShoesL2.visible = !(flag);
		this.ShoesR.visible = !(flag);
	
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
		this.GlowEquipBase.xRot = this.EquipBase.xRot;
		this.GlowTailJaw1.xRot = this.TailJaw1.xRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (0.24F); this.animTransZ += (0F);
    	this.setFaceHungry(ent);
    	
  	    //移動頭部使其看人
	  	this.Head.xRot = 0.5F; 	//上下角度
	  	this.Head.yRot = 0F;	//左右角度 角度轉成rad 即除以57.29578
	  	//body
	  	this.BodyMain.xRot = -0.087F;
	  	//hair
	  	this.Hair01.xRot = 0.2F;
	  	this.Hair02.xRot = -0.3F;
	  	this.HairL01.xRot = -0.26F;
	  	this.HairL02.xRot = 0.26F;
	  	this.HairR01.xRot = -0.26F;
	  	this.HairR02.xRot = 0.26F;
	    //arm 
	  	this.ArmLeft01.xRot = 0.2618F;
	  	this.ArmLeft01.yRot = 0F;
	  	this.ArmLeft01.zRot = -0.57F;
	  	this.ArmLeft02.xRot = 0F;
	  	this.ArmLeft02.y = (4.0F) + (0F) * 16F;
	  	this.ArmLeft02.z = (2.0F) + (0F) * 16F;
	  	this.ArmLeft04.yRot = 0F;
	    this.ArmRight01.xRot = 0.2618F;
	    this.ArmRight01.zRot = 0.57F;
	    this.ArmRight02.xRot = 0F;
		//leg
    	this.LegLeft01.xRot = -1.66F;
    	this.LegLeft01.yRot = -0.2618F;
    	this.LegLeft01.zRot = -0.05F;
    	this.LegLeft02.xRot = 0F;
    	this.LegRight01.xRot = -1.66F;
    	this.LegRight01.yRot = 0.2618F;
    	this.LegRight01.zRot = 0.05F;
    	this.LegRight02.xRot = 0F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
  		float addk1 = 0;
  		float addk2 = 0;
  		float headX = 0F;
  		float headZ = 0F;
  		int state = ent.getStateEmotion(ID.S.State);
  		boolean showCannon = EmotionHelper.checkModelState(0, state);
  		boolean showUmbrella = EmotionHelper.checkModelState(2, state);
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//leg move parm
  		addk1 = angleAdd1 - 0.1745F;
	  	addk2 = angleAdd2 - 0.1745F;

  	    //移動頭部使其看人
	  	this.Head.xRot = f4 * 0.014F; 	//上下角度
	  	this.Head.yRot = f3 * 0.01F;	//左右角度
	  	headX = this.Head.xRot * -0.5F;
	    //正常站立動作
	  	//body
  	    this.Ahoke.xRot = angleX * 0.25F + 0.35F;
	  	this.BodyMain.xRot = -0.087F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.02F + 0.35F + headX;
	  	this.Hair02.xRot = angleX * 0.04F + 0.14F + headX;
	  	this.HairL01.xRot = angleX * 0.02F + headX - 0.26F;
	  	this.HairL02.xRot = angleX * 0.02F + headX + 0.26F;
	  	this.HairR01.xRot = angleX * 0.02F + headX - 0.26F;
	  	this.HairR02.xRot = angleX * 0.02F + headX + 0.26F;
	    //arm 
	  	this.ArmLeft01.xRot = angleAdd2 + 0.2618F;
	  	this.ArmLeft01.yRot = 0F;
	  	this.ArmLeft01.zRot = -angleX * 0.1F - 0.5235F;
	  	this.ArmLeft02.xRot = 0F;
	  	this.ArmLeft02.y = (4.0F) + (0F) * 16F;
	  	this.ArmLeft02.z = (2.0F) + (0F) * 16F;
	  	this.ArmLeft04.yRot = 0F;
	    this.ArmRight01.xRot = angleAdd1 + 0.2618F;
	    this.ArmRight01.yRot = 0F;
	    this.ArmRight01.zRot = angleX * 0.1F + 0.5235F;
	    this.ArmRight02.xRot = 0F;
	    this.ArmRight04.yRot = 0F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = -0.05F;
		this.LegLeft02.xRot = 0F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = 0.05F;
    	this.LegRight02.xRot = 0F;
    	//equip
    	if (showCannon)
    	{
    		this.EquipBase.xRot = 0F;
    		this.TailJaw1.xRot = angleX * 0.08F - 0.15F;
    		this.TailHeadC2.xRot = angleX * 0.12F;
    		this.TailHeadC3.xRot = -angleX * 0.08F + 0.1F;
        	this.EquipLHead01.yRot = angleX * 0.1F - 0.5F;
        	this.EquipLHead01.zRot = -angleX * 0.1F - 0.1F;
        	this.EquipLHead02.yRot = angleX * 0.3F + 0.1F;
        	this.EquipLHead02.zRot = -angleX * 0.3F;
    	}
    	//umbrella
    	if (showUmbrella)
    	{
    		this.ArmLeft01.xRot = 0F;
    		this.ArmLeft01.yRot = -0.26F;
    		this.ArmLeft01.zRot = -0.52F;
    		this.ArmLeft02.y = (4.0F) + (0.25F) * 16F;
    		this.ArmLeft02.xRot = -1.57F;
    		this.ArmLeft04.yRot = -0.52F;
    		this.EquipUmbre03b.yRot = angleX * 0.3F + 0.7F;
    	}
    	
	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {	//奔跑動作
	    	setFace(3);
	    	//arm
	    	this.ArmLeft01.zRot = -1F;
	    	this.ArmRight01.xRot = -2.9F;
	    	this.ArmRight01.zRot = -0.7F;
	    	
	    	if (showUmbrella)
	    	{
	    		this.ArmLeft04.yRot = -1F;
	    	}
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    //移動頭髮避免穿過身體
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.zRot = headZ;
	  	this.Hair02.zRot = headZ;
	  	this.HairL01.zRot = headZ - 0.14F;
	  	this.HairL02.zRot = headZ + 0.087F;
	  	this.HairR01.zRot = headZ + 0.14F;
	  	this.HairR02.zRot = headZ - 0.052F;
	  	
	    if (ent.getIsSneaking())
	    {	//潛行, 蹲下動作
this.animTransX += (0F); this.animTransY += (0.02F); this.animTransZ += (0F);
	    	//body
	    	this.Head.xRot -= 0.8727F;
	    	this.BodyMain.xRot = 1.0472F;
		  	//hair
		  	this.Hair01.xRot += 0.2236F;
		  	//leg
		  	addk1 -= 1.2F;
		  	addk2 -= 1.2F;
		  	//equip
		  	this.EquipBase.xRot -= 0.8727F;
		  	
		  	if (showUmbrella)
		  	{
		  		this.ArmLeft01.yRot = -1.05F;
		  		this.ArmLeft02.xRot = -2.01F;
		  		this.ArmLeft04.yRot = -1.05F;
		  	}
  		}//end if sneaking
  		
	    if (ent.getIsSitting() && !ent.getIsRiding())
	    {	//坐下動作
this.animTransX += (0F); this.animTransY += (0.24F); this.animTransZ += (0F);
	    	
	    	//body
    		this.Head.yRot *= 0.25F;
    		
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
		    	//body
		    	this.Head.xRot -= 0.15F;
		    	this.BodyMain.xRot = -0.3142F;
		    	//arm
		    	this.ArmLeft01.xRot = -2F;
		    	this.ArmLeft01.yRot = -0.35F;
		    	this.ArmLeft01.zRot = 0.35F;
		    	this.ArmRight01.xRot = -2.9F;
		    	this.ArmRight01.yRot = 0.35F;
		    	this.ArmRight01.zRot = -0.35F;
		    	//leg
		    	addk1 = -1.4F;
		    	addk2 = -1.4F;
		    	this.LegLeft01.yRot = -0.2618F;
		    	this.LegRight01.yRot = 0.2618F;
	
	    		this.ArmLeft02.y = (4.0F) + (0F) * 16F;
	    		this.ArmLeft02.xRot = 0F;
	    		this.ArmLeft04.yRot = 0F;
	    	}
	    	else
	    	{
		    	//arm
		    	this.ArmLeft01.zRot -= 0.05F;
		    	this.ArmRight01.zRot += 0.05F;
		    	//leg
		    	addk1 = -1.66F;
		    	addk2 = -1.66F;
		    	this.LegLeft01.yRot = -0.2618F;
		    	this.LegRight01.yRot = 0.2618F;
		    	this.ArmLeft02.y = (4.0F) + (0F) * 16F;
	    	}
  		}//end if sitting
	    
	    if (ent.getIsRiding())
	    {	//騎乘動作
this.animTransX += (0F); this.animTransY += (0.24F); this.animTransZ += (0.27F);
	    	
	    	if (ent.getIsSitting())
	    	{
	    		//arm
		    	this.ArmLeft01.xRot = -0.8F;
		    	this.ArmLeft01.zRot = -0.35F;
		    	this.ArmRight01.xRot = -0.8F;
		    	this.ArmRight01.zRot = 0.35F;
		    	//leg
		    	addk1 = -1.66F;
		    	addk2 = -1.66F;
		    	this.LegLeft01.yRot = -0.5F;
		    	this.LegRight01.yRot = 0.5F;
		    	
		    	if (showUmbrella)
		    	{
		    		this.ArmLeft02.y = (4.0F) + (0F) * 16F;
		    		this.ArmLeft02.xRot = -0.8F;
		    		this.ArmLeft04.yRot = -0.4F;
		    	}
	    	}
	    	else
	    	{
	    		setFace(3);
	    		//head
	    		this.Head.xRot -= 0.25F;
	    		//arm
		    	this.ArmLeft01.xRot = -1.2F;
		    	this.ArmLeft01.yRot = -0.2F;
		    	this.ArmLeft01.zRot = -0.2F;
		    	this.ArmRight01.xRot = -2.53F;
		    	this.ArmRight01.zRot = -0.7F;
		    	//leg
		    	addk1 = -1.66F;
		    	addk2 = -1.66F;
		    	this.LegLeft01.yRot = -0.5F;
		    	this.LegRight01.yRot = 0.5F;
		    	
		    	if (showUmbrella)
		    	{
		    		this.ArmLeft02.y = (4.0F) + (0F) * 16F;
		    		this.ArmLeft02.xRot = -0.2F;
		    		this.ArmLeft04.yRot = -0.4F;
		    	}
	    	}
	    }//end if riding
	    
	    //攻擊動作
	    if (ent.getAttackTick() > 49)
	    {
	    	this.ArmRight01.xRot = -3.5F;
	    	this.ArmRight01.yRot = 0F;
	    	this.ArmRight01.zRot = -0.35F;
	    	this.ArmRight04.yRot = -1.57F;
	    }
	    else if (ent.getAttackTick() > 46)
	    {
	    	this.ArmRight01.xRot = (46F - ent.getAttackTick() + (f2 - (int)f2)) * 0.75F - 0.5F;
	    	this.ArmRight01.yRot = 0F;
	    	this.ArmRight01.zRot = -0.35F;
	    	this.ArmRight04.yRot = -1.57F;
	    }
	    else if (ent.getAttackTick() > 35)
	    {
	    	this.ArmRight01.xRot = -0.5F;
	    	this.ArmRight01.yRot = 0F;
	    	this.ArmRight01.zRot = 0.5F;
	    	this.ArmRight04.yRot = -1.57F;
	    }
	    
	    //leg motion
	    this.LegLeft01.xRot = addk1;
	    this.LegRight01.xRot = addk2;
	
	}

	public void setFaceNormal(IShipEmotion ent)
	{

		this.setFace(0);
		
		if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED && (ent.getTickExisted() & 255) > 200)
		{
			this.setMouth(0);
		}
		else
		{
			this.setMouth(3);
		}
	
	}

	public void setFaceBlink0(IShipEmotion ent)
	{

		this.setFace(0);
	
	}

	public void setFaceBlink1(IShipEmotion ent)
	{

		this.setFace(1);
	
	}

	public void setFaceCry(IShipEmotion ent)
	{

		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;
		
		if (t < 128)
		{
			this.setFace(6);
			
			if (t < 64)
			{
				this.setMouth(2);
			}
			else
			{
				this.setMouth(5);
			}
		}
		else
		{
			this.setFace(7);
			this.setMouth(5);
		}
	
	}

	public void setFaceAttack(IShipEmotion ent)
	{

		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 511;
		
		if (t < 160)
		{
			this.setFace(0);
			
			if (t < 80)
			{
				this.setMouth(4);
			}
			else
			{
				this.setMouth(3);
			}
		}
		else if (t < 320)
		{
			this.setFace(2);
			
			if (t < 220)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(3);
			}
		}
		else if (t < 410)
		{
			this.setFace(3);
			
			if (t < 360)
			{
				this.setMouth(5);
			}
			else
			{
				this.setMouth(4);
			}
		}
		else
		{
			this.setFace(5);
			
			if (t < 470)
			{
				this.setMouth(3);
			}
			else
			{
				this.setMouth(4);
			}
		}
	
	}

	public void setFaceDamaged(IShipEmotion ent)
	{

		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 511;
		
		if (t < 200)
		{
			this.setFace(6);
			
			if (t < 60)
			{
				this.setMouth(4);
			}
			else
			{
				this.setMouth(5);
			}
		}
		else if (t < 400)
		{
			this.setFace(3);
			
			if (t < 250)
			{
				this.setMouth(3);
			}
			else
			{
				this.setMouth(5);
			}
		}
		else
		{
			this.setFace(9);
			
			if (t < 450)
			{
				this.setMouth(2);
			}
			else
			{
				this.setMouth(3);
			}
		}
	
	}

	public void setFaceScorn(IShipEmotion ent)
	{

		this.setFace(2);
		this.setMouth(3);
	
	}

	public void setFaceHungry(IShipEmotion ent)
	{

		this.setFace(4);
		this.setMouth(3);
	
	}

	public void setFaceAngry(IShipEmotion ent)
	{

		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;
		
		if (t < 128)
		{
			this.setFace(1);
			
			if (t < 64)
			{
				this.setMouth(3);
			}
			else
			{
				this.setMouth(1);
			}
		}
		else
		{
			this.setFace(2);

			if (t < 170)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(3);
			}
		}
	
	}

	public void setFaceBored(IShipEmotion ent)
	{

		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 511;
		
		if (t < 170)
		{
			this.setFace(1);
			
			if (t < 80)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(3);
			}
		}
		else if (t < 340)
		{
			this.setFace(5);

			if (t < 250)
			{
				this.setMouth(4);
			}
			else
			{
				this.setMouth(3);
			}
		}
		else
		{
			this.setFace(0);

			if (t < 420)
			{
				this.setMouth(4);
			}
			else
			{
				this.setMouth(3);
			}
		}
	
	}

	public void setFaceShy(IShipEmotion ent)
	{

		this.setFlush(true);
		
		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;
		
		this.setFace(0);
		
		if (t < 150)
		{
			this.setMouth(3);
		}
		else
		{
			this.setMouth(2);
		}
	
	}

	public void setFaceHappy(IShipEmotion ent)
	{

		this.setFlush(true);
		
		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;
		
		if (t < 140)
		{
			this.setFace(3);
			
			if (t < 80)
			{
				this.setMouth(4);
			}
			else
			{
				this.setMouth(3);
			}
		}
		else
		{
			this.setFace(8);
			this.setMouth(3);
		}
	
	}

	public float[] getHeldItemOffset(IShipEmotion ent, HumanoidArm side, int type)
	{

		if (side == HumanoidArm.RIGHT && (ent.getIsSprinting() || ent.getIsRiding()))
		{
			if (ent.getIsSprinting())
			{
				this.offsetItem2[1] = 0.9F;
				this.offsetItem2[2] = -0.3F;
			}
			else if (ent.getIsRiding())
			{
				this.offsetItem2[1] = 1.1F;
				this.offsetItem2[2] = -0.2F;
			}
			
			return type == 0 ? this.offsetItem2 : this.offsetBlock2;
		}
		
    	return type == 0 ? this.offsetItem : this.offsetBlock;
    
	}

	public float[] getHeldItemRotate(IShipEmotion ent, HumanoidArm side, int type)
	{

		if (side == HumanoidArm.RIGHT && (ent.getIsSprinting() || ent.getIsRiding()))
		{
			return type == 0 ? this.rotateItem2 : this.rotateBlock;
		}
		
    	return type == 0 ? this.rotateItem : this.rotateBlock;
    
	}

	@Override
	public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)
	{
		this.captureAnimParms(entity, f, f1, f2, f3, f4);

    	//FIX: head rotation bug while riding
    	if (f3 <= -180F) { f3 += 360F; }
    	else if (f3 >= 180F) { f3 -= 360F; }
    
    	
    	RenderHelper.animScale(this, 0.36F, 0.34F, 0.36F);
this.animTransX += (0F); this.animTransY += (3.08F); this.animTransZ += (0F);
    	
    	//main body
		super.setupAnim(entity, f, f1, f2, f3, f4);
	}

}

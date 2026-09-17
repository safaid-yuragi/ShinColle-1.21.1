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

public class ModelCAHime<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart LegLeft01;
	public ModelPart LegRight01;
	public ModelPart Neck;
	public ModelPart Head;
	public ModelPart TailBase;
	public ModelPart Band01;
	public ModelPart Band02;
	public ModelPart ArmLeft02;
	public ModelPart ArmRight02;
	public ModelPart LegLeft02;
	public ModelPart LegRight02;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Ear01;
	public ModelPart Ear02;
	public ModelPart Horn01;
	public ModelPart Horn02;
	public ModelPart HatBase;
	public ModelPart Ahoke;
	public ModelPart Hair01;
	public ModelPart Hair02a;
	public ModelPart Hair02b;
	public ModelPart Hair03a;
	public ModelPart Hair03b;
	public ModelPart Horn03;
	public ModelPart HatL;
	public ModelPart HatR;
	public ModelPart HatEyeL;
	public ModelPart HatEyeR;
	public ModelPart Tail01;
	public ModelPart Tail01_1;
	public ModelPart Tail02;
	public ModelPart Tail03;
	public ModelPart Tail04;
	public ModelPart Tail05;
	public ModelPart Tail06;
	public ModelPart Tail07;
	public ModelPart Tail08;
	public ModelPart Tail09;
	public ModelPart TailHead01;
	public ModelPart TailJaw01;
	public ModelPart TailC01;
	public ModelPart TailC02;
	public ModelPart Tail02_1;
	public ModelPart Tail03_1;
	public ModelPart Tail04_1;
	public ModelPart Tail05_1;
	public ModelPart Tail06_1;
	public ModelPart Tail07_1;
	public ModelPart Tail08_1;
	public ModelPart Tail09_1;
	public ModelPart TailHead01_1;
	public ModelPart TailJaw01_1;
	public ModelPart TailC01_1;
	public ModelPart TailC02_1;
	public ModelPart GlowBodyMain;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-5.5F, -4.5F, -12.0F, 11.0F, 10.0F, 24.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-5.0F, -4.0F, -4.5F, 10.0F, 5.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -9.4F, 0.41887902047863906F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("LegRight01", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(-4.0F, 3.0F, 8.3F, -0.13962634015954636F, 0.0F, -0.17453292519943295F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("LegRight02", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 7.0F, 5.0F), PartPose.offset(0.0F, 8.0F, -2.5F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(4.0F, 3.0F, 8.3F, 0.13962634015954636F, 0.0F, 0.17453292519943295F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("LegLeft02", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 7.0F, 5.0F), PartPose.offset(0.0F, 8.0F, -2.5F));
		PartDefinition partdef6 = partdef0.addOrReplaceChild("Band02", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(-4.5F, 1.7F, -12.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(-4.0F, 3.0F, -6.0F, 0.13962634015954636F, 0.0F, -0.20943951023931953F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("ArmRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -5.0F, 5.0F, 7.0F, 5.0F), PartPose.offset(-2.5F, 8.0F, 2.5F));
		PartDefinition partdef9 = partdef0.addOrReplaceChild("TailBase", CubeListBuilder.create().addBox(-4.0F, -2.0F, 0.0F, 8.0F, 5.0F, 7.0F), PartPose.offset(0.0F, 7.0F, -2.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("Tail01", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(1.5F, 0.0F, 3.0F, 0.2617993877991494F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("Tail02", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.6108652381980153F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("Tail03", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.6108652381980153F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("Tail04", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("Tail05", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("Tail06", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("Tail07", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.17453292519943295F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("Tail08", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.08726646259971647F, 0.2617993877991494F, 0.0F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("Tail09", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, -0.08726646259971647F, 0.4363323129985824F, 0.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("TailHead01", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -1.8F, 3.5F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("TailC01", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(2.0F, 4.5F, 9.5F, -0.13962634015954636F, 0.03490658503988659F, 0.0F));
		PartDefinition partdef21 = partdef19.addOrReplaceChild("TailC02", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(-2.0F, 4.5F, 9.5F, -0.13962634015954636F, -0.03490658503988659F, 0.0F));
		PartDefinition partdef22 = partdef18.addOrReplaceChild("TailJaw01", CubeListBuilder.create().addBox(-4.5F, -4.0F, 0.0F, 9.0F, 4.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -0.7F, 3.3F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef23 = partdef9.addOrReplaceChild("Tail01_1", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(-1.5F, 0.0F, 3.0F, 0.6981317007977318F, -1.5707963267948966F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("Tail02_1", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.3490658503988659F, 0.2617993877991494F, 0.0F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("Tail03_1", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.4363323129985824F, 0.3490658503988659F, 0.0F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("Tail04_1", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.3490658503988659F, 0.4363323129985824F, 0.0F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("Tail05_1", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.5235987755982988F, 0.3490658503988659F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("Tail06_1", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.08726646259971647F, 0.2617993877991494F, 0.0F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("Tail07_1", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, -0.3490658503988659F, 0.3490658503988659F, 0.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("Tail08_1", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, -0.5235987755982988F, 0.3490658503988659F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("Tail09_1", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, -0.08726646259971647F, 0.4363323129985824F, 0.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("TailHead01_1", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -1.8F, 3.5F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("TailC02_1", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(-2.0F, 4.5F, 9.5F, -0.13962634015954636F, -0.03490658503988659F, 0.0F));
		PartDefinition partdef34 = partdef32.addOrReplaceChild("TailC01_1", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(2.0F, 4.5F, 9.5F, -0.13962634015954636F, 0.03490658503988659F, 0.0F));
		PartDefinition partdef35 = partdef31.addOrReplaceChild("TailJaw01_1", CubeListBuilder.create().addBox(-4.5F, -4.0F, 0.0F, 9.0F, 4.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -0.7F, 2.7F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef36 = partdef0.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -11.0F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -6.0F, -13.0F));
		PartDefinition partdef37 = partdef36.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 10.0F), PartPose.offset(0.0F, -11.5F, -3.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 7.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.6F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef39 = partdef37.addOrReplaceChild("Hair03a", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 12.0F, 4.0F), PartPose.offsetAndRotation(6.4F, 9.8F, 5.5F, -0.20943951023931953F, -0.13962634015954636F, 0.06981317007977318F));
		PartDefinition partdef40 = partdef37.addOrReplaceChild("Hair02b", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.3F, 3.0F, 7.0F, 5.0F), PartPose.offsetAndRotation(-6.9F, 4.7F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef41 = partdef37.addOrReplaceChild("Hair02a", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.3F, 3.0F, 7.0F, 5.0F), PartPose.offsetAndRotation(6.9F, 4.7F, 0.0F, 0.0F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef42 = partdef37.addOrReplaceChild("Hair03b", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 12.0F, 4.0F), PartPose.offsetAndRotation(-6.4F, 9.8F, 5.5F, -0.20943951023931953F, 0.13962634015954636F, -0.06981317007977318F));
		PartDefinition partdef43 = partdef36.addOrReplaceChild("Ear01", CubeListBuilder.create().addBox(-2.0F, 0.0F, -7.0F, 4.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(4.2F, -11.0F, 6.8F, -0.8377580409572781F, -0.12217304763960307F, 0.17453292519943295F));
		PartDefinition partdef44 = partdef36.addOrReplaceChild("Horn02", CubeListBuilder.create().addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(3.3F, -7.5F, -6.0F, -0.8726646259971648F, -0.4363323129985824F, 0.2617993877991494F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("Horn03", CubeListBuilder.create().addBox(-3.0F, -3.0F, -6.0F, 3.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(1.5F, 1.5F, -6.0F, -0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef46 = partdef36.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.2F, 16.0F, 17.0F, 8.0F), PartPose.offset(0.0F, -4.0F, 0.0F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, 0.0F, -12.0F, 0.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(2.0F, -4.0F, -7.6F, -0.2617993877991494F, 1.48352986419518F, -0.2617993877991494F));
		PartDefinition partdef48 = partdef36.addOrReplaceChild("HatBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, -3.1F, 5.8F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("HatL", CubeListBuilder.create().addBox(0.0F, -14.0F, -1.0F, 10.0F, 16.0F, 10.0F), PartPose.offsetAndRotation(-1.3F, 2.1F, -2.9F, 0.5235987755982988F, 0.08726646259971647F, 0.06981317007977318F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("HatEyeL", CubeListBuilder.create().addBox(0.0F, -3.0F, -3.0F, 1.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(9.6F, -6.0F, 5.3F, 0.08726646259971647F, -0.05235987755982988F, -0.05235987755982988F));
		PartDefinition partdef51 = partdef48.addOrReplaceChild("HatR", CubeListBuilder.create().mirror().addBox(-10.0F, -14.0F, -1.0F, 10.0F, 16.0F, 10.0F), PartPose.offsetAndRotation(1.3F, 2.1F, -2.9F, 0.5235987755982988F, -0.08726646259971647F, -0.06981317007977318F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("HatEyeR", CubeListBuilder.create().mirror().addBox(-1.0F, -3.0F, -3.0F, 1.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(-9.6F, -6.0F, 5.3F, 0.08726646259971647F, 0.05235987755982988F, 0.05235987755982988F));
		PartDefinition partdef53 = partdef36.addOrReplaceChild("Ear02", CubeListBuilder.create().mirror().addBox(-2.0F, 0.0F, -7.0F, 4.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(-4.2F, -11.0F, 6.8F, -0.8377580409572781F, 0.12217304763960307F, -0.17453292519943295F));
		PartDefinition partdef54 = partdef36.addOrReplaceChild("Horn01", CubeListBuilder.create().addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-3.0F, -7.5F, -6.0F, -0.8726646259971648F, 0.4363323129985824F, -0.5235987755982988F));
		PartDefinition partdef55 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(4.0F, 3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.20943951023931953F));
		PartDefinition partdef56 = partdef55.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 7.0F, 5.0F), PartPose.offset(2.5F, 8.0F, 2.5F));
		PartDefinition partdef57 = partdef0.addOrReplaceChild("Band01", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(4.5F, 1.7F, -12.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef58 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef59 = partdef58.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, -13.0F));
		PartDefinition partdef60 = partdef59.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -8.5F, -6.1F));
		PartDefinition partdef61 = partdef59.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -8.5F, -6.1F));
		PartDefinition partdef62 = partdef59.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -8.5F, -6.1F));
		PartDefinition partdef63 = partdef59.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -8.5F, -6.1F));
		PartDefinition partdef64 = partdef59.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -8.5F, -6.1F));
		PartDefinition partdef65 = partdef59.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -0.7F, -6.2F));
		PartDefinition partdef66 = partdef59.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -0.7F, -6.2F));
		PartDefinition partdef67 = partdef59.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -0.7F, -6.2F));
		PartDefinition partdef68 = partdef59.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6F, 0.7F, -6.8F));
		PartDefinition partdef69 = partdef59.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6F, 0.7F, -6.8F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelCAHime(ModelPart root)
	{
		this.Hair01 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.Hair03a = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair03a");
		this.LegLeft02 = root.getChild("BodyMain").getChild("LegLeft01").getChild("LegLeft02");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.Horn03 = root.getChild("BodyMain").getChild("Head").getChild("Horn02").getChild("Horn03");
		this.HatEyeR = root.getChild("BodyMain").getChild("Head").getChild("HatBase").getChild("HatR").getChild("HatEyeR");
		this.TailHead01_1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01_1").getChild("Tail02_1").getChild("Tail03_1").getChild("Tail04_1").getChild("Tail05_1").getChild("Tail06_1").getChild("Tail07_1").getChild("Tail08_1").getChild("Tail09_1").getChild("TailHead01_1");
		this.Tail03 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01").getChild("Tail02").getChild("Tail03");
		this.HatL = root.getChild("BodyMain").getChild("Head").getChild("HatBase").getChild("HatL");
		this.Tail05_1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01_1").getChild("Tail02_1").getChild("Tail03_1").getChild("Tail04_1").getChild("Tail05_1");
		this.Tail06 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01").getChild("Tail02").getChild("Tail03").getChild("Tail04").getChild("Tail05").getChild("Tail06");
		this.Tail09_1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01_1").getChild("Tail02_1").getChild("Tail03_1").getChild("Tail04_1").getChild("Tail05_1").getChild("Tail06_1").getChild("Tail07_1").getChild("Tail08_1").getChild("Tail09_1");
		this.Tail08_1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01_1").getChild("Tail02_1").getChild("Tail03_1").getChild("Tail04_1").getChild("Tail05_1").getChild("Tail06_1").getChild("Tail07_1").getChild("Tail08_1");
		this.LegRight01 = root.getChild("BodyMain").getChild("LegRight01");
		this.Tail02_1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01_1").getChild("Tail02_1");
		this.Hair02b = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair02b");
		this.LegLeft01 = root.getChild("BodyMain").getChild("LegLeft01");
		this.Band02 = root.getChild("BodyMain").getChild("Band02");
		this.Hair02a = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair02a");
		this.HairMain = root.getChild("BodyMain").getChild("Head").getChild("HairMain");
		this.HatEyeL = root.getChild("BodyMain").getChild("Head").getChild("HatBase").getChild("HatL").getChild("HatEyeL");
		this.Ahoke = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.Tail02 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01").getChild("Tail02");
		this.Tail05 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01").getChild("Tail02").getChild("Tail03").getChild("Tail04").getChild("Tail05");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.TailBase = root.getChild("BodyMain").getChild("TailBase");
		this.Tail07 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01").getChild("Tail02").getChild("Tail03").getChild("Tail04").getChild("Tail05").getChild("Tail06").getChild("Tail07");
		this.TailHead01 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01").getChild("Tail02").getChild("Tail03").getChild("Tail04").getChild("Tail05").getChild("Tail06").getChild("Tail07").getChild("Tail08").getChild("Tail09").getChild("TailHead01");
		this.Ear01 = root.getChild("BodyMain").getChild("Head").getChild("Ear01");
		this.Tail06_1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01_1").getChild("Tail02_1").getChild("Tail03_1").getChild("Tail04_1").getChild("Tail05_1").getChild("Tail06_1");
		this.TailJaw01 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01").getChild("Tail02").getChild("Tail03").getChild("Tail04").getChild("Tail05").getChild("Tail06").getChild("Tail07").getChild("Tail08").getChild("Tail09").getChild("TailJaw01");
		this.Hair03b = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair03b");
		this.Tail08 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01").getChild("Tail02").getChild("Tail03").getChild("Tail04").getChild("Tail05").getChild("Tail06").getChild("Tail07").getChild("Tail08");
		this.Tail07_1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01_1").getChild("Tail02_1").getChild("Tail03_1").getChild("Tail04_1").getChild("Tail05_1").getChild("Tail06_1").getChild("Tail07_1");
		this.Horn02 = root.getChild("BodyMain").getChild("Head").getChild("Horn02");
		this.BodyMain = root.getChild("BodyMain");
		this.LegRight02 = root.getChild("BodyMain").getChild("LegRight01").getChild("LegRight02");
		this.Tail09 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01").getChild("Tail02").getChild("Tail03").getChild("Tail04").getChild("Tail05").getChild("Tail06").getChild("Tail07").getChild("Tail08").getChild("Tail09");
		this.Hair = root.getChild("BodyMain").getChild("Head").getChild("Hair");
		this.TailC02_1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01_1").getChild("Tail02_1").getChild("Tail03_1").getChild("Tail04_1").getChild("Tail05_1").getChild("Tail06_1").getChild("Tail07_1").getChild("Tail08_1").getChild("Tail09_1").getChild("TailHead01_1").getChild("TailC02_1");
		this.Head = root.getChild("BodyMain").getChild("Head");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.Band01 = root.getChild("BodyMain").getChild("Band01");
		this.TailJaw01_1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01_1").getChild("Tail02_1").getChild("Tail03_1").getChild("Tail04_1").getChild("Tail05_1").getChild("Tail06_1").getChild("Tail07_1").getChild("Tail08_1").getChild("Tail09_1").getChild("TailJaw01_1");
		this.HatBase = root.getChild("BodyMain").getChild("Head").getChild("HatBase");
		this.Tail01 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01");
		this.TailC01 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01").getChild("Tail02").getChild("Tail03").getChild("Tail04").getChild("Tail05").getChild("Tail06").getChild("Tail07").getChild("Tail08").getChild("Tail09").getChild("TailHead01").getChild("TailC01");
		this.Tail04 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01").getChild("Tail02").getChild("Tail03").getChild("Tail04");
		this.Tail04_1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01_1").getChild("Tail02_1").getChild("Tail03_1").getChild("Tail04_1");
		this.Tail01_1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01_1");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.HatR = root.getChild("BodyMain").getChild("Head").getChild("HatBase").getChild("HatR");
		this.Tail03_1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01_1").getChild("Tail02_1").getChild("Tail03_1");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.Ear02 = root.getChild("BodyMain").getChild("Head").getChild("Ear02");
		this.TailC01_1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01_1").getChild("Tail02_1").getChild("Tail03_1").getChild("Tail04_1").getChild("Tail05_1").getChild("Tail06_1").getChild("Tail07_1").getChild("Tail08_1").getChild("Tail09_1").getChild("TailHead01_1").getChild("TailC01_1");
		this.TailC02 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail01").getChild("Tail02").getChild("Tail03").getChild("Tail04").getChild("Tail05").getChild("Tail06").getChild("Tail07").getChild("Tail08").getChild("Tail09").getChild("TailHead01").getChild("TailC02");
		this.Horn01 = root.getChild("BodyMain").getChild("Head").getChild("Horn01");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowHead");
		this.Face0 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Face0");
		this.Face1 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Face1");
		this.Face2 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Face2");
		this.Face3 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Face3");
		this.Face4 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Face4");
		this.Mouth0 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Mouth0");
		this.Mouth1 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Mouth1");
		this.Mouth2 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Mouth2");
		this.Flush0 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Flush0");
		this.Flush1 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Flush1");
		this.scale = 0.45F;
		this.offsetY = 2.22F;
		this.offsetItem = new float[] {0.07F, 0.99F, -0.09F};
		this.offsetBlock = new float[] {0.07F, 0.99F, -0.09F};
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
    	
    	poseStack.popPose();
    
	}

	public void showEquip(IShipEmotion ent)
	{

		int state = ent.getStateEmotion(ID.S.State);
		
		//tail state
		boolean ft1 = EmotionHelper.checkModelState(0, state);
		boolean ft2 = EmotionHelper.checkModelState(1, state);
		
		this.TailBase.visible = !(!(ft1 || ft2));
		
		//hat state
		boolean fh1 = EmotionHelper.checkModelState(2, state);
		boolean fh2 = EmotionHelper.checkModelState(3, state);
		boolean fh3 = EmotionHelper.checkModelState(4, state);
		boolean fh4 = fh1 & fh2;
		
		//hat state 2, 3, 4
		if (fh2 || fh3 || fh4)
		{
			this.HatBase.visible = true;
  			this.Hair01.visible = false;
  			this.Horn01.visible = true;
  			this.Horn02.visible = true;
  			this.Ear01.visible = true;
  			this.Ear02.visible = true;
		}
		//hat state 1
		else if (fh1)
		{
			this.HatBase.visible = true;
  			this.Hair01.visible = false;
  			this.Horn01.visible = false;
  			this.Horn02.visible = false;
  			this.Ear01.visible = false;
  			this.Ear02.visible = false;
		}
		//no hat
		else
		{
			this.HatBase.visible = false;
  			this.Hair01.visible = true;
  			this.Horn01.visible = true;
  			this.Horn02.visible = true;
  			this.Ear01.visible = true;
  			this.Ear02.visible = true;
		}
	
	}

	public void syncRotationGlowPart()
	{

		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (0.2F); this.animTransZ += (0F);
    	this.setFaceHungry(ent);

  	    //頭部
	  	this.Head.xRot = 0.7853F;
	  	this.Head.yRot = 0F;
	  	//Body
  	    this.Ahoke.xRot = -0.2618F;
	  	this.BodyMain.xRot = 0F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = -1.4835F;
	  	this.Head.y = (-6.0F) + (0F) * 16F;
	  	this.GlowHead.y = (-6.0F) + (0F) * 16F;
	  	//arm
	  	this.ArmLeft01.xRot = -0.4F;
	  	this.ArmLeft01.zRot = 0.4537F;
	  	this.ArmLeft01.z = (-6.0F) + (0F) * 16F;
	  	this.ArmLeft02.zRot = 0F;
	  	this.ArmRight01.xRot = -0.8F;
	  	this.ArmRight01.zRot = -0.05F;
	  	this.ArmRight01.z = (-6.0F) + (0F) * 16F;
	  	this.ArmRight02.zRot = 0F;
		//leg
	  	this.LegLeft01.xRot = 0.5F;
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.4537F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegRight01.xRot = 0.8F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.05F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.zRot = 0F;
		
		//equip: hat position
		int state = ent.getStateEmotion(ID.S.State);
		boolean fh1 = EmotionHelper.checkModelState(2, state);
		boolean fh2 = EmotionHelper.checkModelState(3, state);
		boolean fh3 = EmotionHelper.checkModelState(4, state);
		boolean fh4 = fh1 & fh2;
		
		//hat state 4
		if (fh4)
		{
			this.HatBase.xRot = -1.8F;//-103
  			this.HatBase.y = (-3.1F) + (0.6F) * 16F;
  			this.HatBase.z = (5.8F) + (0.07F) * 16F;
		}
		//hat state 1
		else if (fh1)
		{
			this.HatBase.xRot = 1.37F;//78
  			this.HatBase.y = (-3.1F) + (-0.45F) * 16F;
  			this.HatBase.z = (5.8F) + (-0.2F) * 16F;
		}
		//hat state 3
		else if (fh3)
		{
  			this.HatBase.xRot = -0.85F;//-48
  			this.HatBase.y = (-3.1F) + (0.33F) * 16F;
  			this.HatBase.z = (5.8F) + (0.07F) * 16F;
		}
		//no hat or hat state 2
		else
		{
			this.HatBase.xRot = 0F;
  			this.HatBase.y = (-3.1F) + (0F) * 16F;
  			this.HatBase.z = (5.8F) + (0F) * 16F;
		}
		
		//tail head
		this.TailHead01.xRot = -0.17F;
		this.TailJaw01.xRot = 0.26F;
		this.TailHead01_1.xRot = 0F;
		this.TailJaw01_1.xRot = 0.2F;
		//tail body
		this.TailBase.visible = true;
		this.Tail01.xRot = -1.4F;
		this.Tail01.yRot = 1.57F;
		this.Tail02.xRot = -0.3F;
		this.Tail02.yRot = 0.2F;
		this.Tail03.xRot = -0.3F;
		this.Tail03.yRot = 0.3F;
		this.Tail04.xRot = 0.2F;
		this.Tail04.yRot = 0.4F;
		this.Tail05.xRot = 0.1F;
		this.Tail05.yRot = 0.5F;
		this.Tail06.xRot = -0.1F;
		this.Tail06.yRot = 0.4F;
		this.Tail07.xRot = -0.1F;
		this.Tail07.yRot = 0.3F;
		this.Tail08.xRot = 0.1F;
		this.Tail08.yRot = 0.2F;
		this.Tail09.xRot = 0F;
		this.Tail09.yRot = 0.1F;
		this.Tail01_1.xRot = -1.4F;
		this.Tail01_1.yRot = -1.7F;
		this.Tail02_1.xRot = -0.2F;
		this.Tail02_1.yRot = 0.2F;
		this.Tail03_1.xRot = -0.1F;
		this.Tail03_1.yRot = 0.3F;
		this.Tail04_1.xRot = 0F;
		this.Tail04_1.yRot = 0.4F;
		this.Tail05_1.xRot = 0F;
		this.Tail05_1.yRot = 0.5F;
		this.Tail06_1.xRot = -0.1F;
		this.Tail06_1.yRot = 0.4F;
		this.Tail07_1.xRot = -0.1F;
		this.Tail07_1.yRot = 0.3F;
		this.Tail08_1.xRot = 0.2F;
		this.Tail08_1.yRot = 0.2F;
		this.Tail09_1.xRot = -0.2F;
		this.Tail09_1.yRot = 0.3F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F + f * 0.25F);
  		float angleX1 = Mth.cos(f2*0.08F + 0.3F + f * 0.5F);
  		float angleX2 = Mth.cos(f2*0.08F + 0.6F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
  		float addk1 = 0;
  		float addk2 = 0;
		int state = ent.getStateEmotion(ID.S.State);
		boolean ft1 = EmotionHelper.checkModelState(0, state);
		boolean ft2 = EmotionHelper.checkModelState(1, state);
		boolean ft3 = ft1 & ft2;
		boolean fh1 = EmotionHelper.checkModelState(2, state);
		boolean fh2 = EmotionHelper.checkModelState(3, state);
		boolean fh3 = EmotionHelper.checkModelState(4, state);
		boolean fh4 = fh1 & fh2;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
    	//leg move
  		addk1 = angleAdd1 * 0.35F - 0.14F;  //LegLeft01
	  	addk2 = angleAdd2 * 0.35F + 0.14F;  //LegRight01
	  	this.ArmRight01.xRot = addk1;
    	this.ArmLeft01.xRot = addk2;

  	    //head
	  	this.Head.xRot = f4 * 0.014F; 	//上下角度
	  	this.Head.yRot = f3 * 0.01F;	//左右角度 角度轉成rad 即除以57.29578
	  	//body
	  	this.Ahoke.xRot = angleX * 0.05F - 0.2618F;
	  	this.BodyMain.xRot = 0F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Head.y = (-6.0F) + (0F) * 16F;
	  	this.GlowHead.y = (-6.0F) + (0F) * 16F;
	  	//arm
	  	this.ArmLeft01.yRot = 0F;
	  	this.ArmLeft01.zRot = 0.21F;
	  	this.ArmLeft01.z = (-6.0F) + (0F) * 16F;
	  	this.ArmLeft02.zRot = 0F;
	  	this.ArmRight01.yRot = 0F;
	  	this.ArmRight01.zRot = -0.21F;
	  	this.ArmRight01.z = (-6.0F) + (0F) * 16F;
	  	this.ArmRight02.zRot = 0F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.1745F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.1745F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.zRot = 0F;
		
		//equip: hat position
		//hat state 4
		if (fh4)
		{
			this.HatBase.xRot = -1.8F;//-103
  			this.HatBase.y = (-3.1F) + (0.4F) * 16F;
  			this.HatBase.z = (5.8F) + (0.07F) * 16F;
		}
		//hat state 1
		else if (fh1)
		{
			this.HatBase.xRot = 1.37F;//78
  			this.HatBase.y = (-3.1F) + (-0.45F) * 16F;
  			this.HatBase.z = (5.8F) + (-0.2F) * 16F;
		}
		//hat state 3
		else if (fh3)
		{
  			this.HatBase.xRot = -0.85F;//-48
  			this.HatBase.y = (-3.1F) + (0.33F) * 16F;
  			this.HatBase.z = (5.8F) + (0.07F) * 16F;
		}
		//no hat or hat state 2
		else
		{
			this.HatBase.xRot = 0F;
  			this.HatBase.y = (-3.1F) + (0F) * 16F;
  			this.HatBase.z = (5.8F) + (0F) * 16F;
		}
		
  		//equip: tail position
  		float[] cosf2 = new float[9];
  		for (int i = 0; i < 9; i++)
  		{
  			cosf2[i] = Mth.cos(f2 * 0.1F + f * 0.25F + 0.8F * i);
  		}
  		
		//tail head
		this.TailHead01.xRot = -angleX * 0.075F - 0.1F;
		this.TailJaw01.xRot = angleX * 0.1F + 0.18F;
		this.TailHead01_1.xRot = -angleX2 * 0.12F - 0.1F;
		this.TailJaw01_1.xRot = angleX2 * 0.15F + 0.26F;
		this.TailC01.xRot = angleX1 * 0.3F - 0.2F;
		this.TailC02.xRot = angleX2 * 0.3F - 0.2F;
		this.TailC01_1.xRot = angleX1 * 0.3F - 0.2F;
		this.TailC02_1.xRot = angleX2 * 0.3F - 0.2F;
  		
		//tail body
		if (ft3)
		{
  			this.TailBase.y = (7.0F) + (-0.15F) * 16F;
  			this.TailBase.z = (-2.0F) + (0F) * 16F;
  			this.Tail01.xRot = 0.26F;
  			this.Tail01.yRot = 1.7F + cosf2[0] * 0.015F;
  			this.Tail02.xRot = 0.61F;
  			this.Tail02.yRot = -0.09F + cosf2[1] * 0.02F;
  			this.Tail03.xRot = 0.61F;
  			this.Tail03.yRot = -0.09F + cosf2[2] * 0.025F;
  			this.Tail04.xRot = 0.52F;
  			this.Tail04.yRot = 0F + cosf2[3] * 0.03F;
  			this.Tail05.xRot = 0.52F;
  			this.Tail05.yRot = 0F + cosf2[4] * 0.04F;
  			this.Tail06.xRot = 0.35F;
  			this.Tail06.yRot = 0F + cosf2[5] * 0.05F;
  			this.Tail07.xRot = 0.17F;
  			this.Tail07.yRot = 0.1F + cosf2[6] * 0.06F;
  			this.Tail08.xRot = 0.09F;
  			this.Tail08.yRot = 0.1F + cosf2[7] * 0.08F;
  			this.Tail09.xRot = -0.09F;
  			this.Tail09.yRot = 0.5F + cosf2[8] * 0.15F;
  			this.Tail01_1.xRot = 0.7F;
  			this.Tail01_1.yRot = -1.57F + cosf2[0] * 0.02F;
  			this.Tail02_1.xRot = 0.35F;
  			this.Tail02_1.yRot = 0.26F + cosf2[1] * 0.03F;
  			this.Tail03_1.xRot = 0.44F;
  			this.Tail03_1.yRot = 0.35F + cosf2[2] * 0.04F;
  			this.Tail04_1.xRot = 0.35F;
  			this.Tail04_1.yRot = 0.44F + cosf2[3] * 0.05F;
  			this.Tail05_1.xRot = 0.52F;
  			this.Tail05_1.yRot = 0.35F + cosf2[4] * 0.06F;
  			this.Tail06_1.xRot = 0.09F;
  			this.Tail06_1.yRot = 0.26F + cosf2[5] * 0.07F;
  			this.Tail07_1.xRot = -0.35F;
  			this.Tail07_1.yRot = 0.35F + cosf2[6] * 0.08F;
  			this.Tail08_1.xRot = -0.52F;
  			this.Tail08_1.yRot = 0.35F + cosf2[7] * 0.09F;
  			this.Tail09_1.xRot = -0.09F;
  			this.Tail09_1.yRot = 0.44F + cosf2[8] * 0.12F;
		}
		else if (ft1)
		{
  			this.TailBase.y = (7.0F) + (-0.15F) * 16F;
  			this.TailBase.z = (-2.0F) + (0F) * 16F;
  			this.Tail01.xRot = -0.17F + cosf2[0] * 0.03F;
  			this.Tail01.yRot = 1.3F + cosf2[0] * 0.03F;
  			this.Tail02.xRot = 0.26F + cosf2[1] * 0.03F;
  			this.Tail02.yRot = -0.52F + cosf2[1] * 0.03F;
  			this.Tail03.xRot = 0.35F + cosf2[2] * 0.03F;
  			this.Tail03.yRot = -0.52F + cosf2[2] * 0.03F;
  			this.Tail04.xRot = 0.52F + cosf2[3] * 0.03F;
  			this.Tail04.yRot = -0.44F + cosf2[3] * 0.03F;
  			this.Tail05.xRot = 0.52F + cosf2[4] * 0.04F;
  			this.Tail05.yRot = -0.17F + cosf2[4] * 0.04F;
  			this.Tail06.xRot = 0.35F + cosf2[5] * 0.05F;
  			this.Tail06.yRot = 0.35F + cosf2[5] * 0.05F;
  			this.Tail07.xRot = 0.44F + cosf2[6] * 0.06F;
  			this.Tail07.yRot = 0.17F + cosf2[6] * 0.06F;
  			this.Tail08.xRot = 0.52F + cosf2[7] * 0.08F;
  			this.Tail08.yRot = 0.17F + cosf2[7] * 0.08F;
  			this.Tail09.xRot = 0.52F + cosf2[8] * 0.15F;
  			this.Tail09.yRot = 0.17F + cosf2[8] * 0.15F;
  			this.Tail01_1.xRot = -0.17F + cosf2[0] * 0.03F;
  			this.Tail01_1.yRot = -1.3F + cosf2[0] * 0.03F;
  			this.Tail02_1.xRot = 0.26F + cosf2[1] * 0.03F;
  			this.Tail02_1.yRot = 0.52F + cosf2[1] * 0.03F;
  			this.Tail03_1.xRot = 0.35F + cosf2[2] * 0.03F;
  			this.Tail03_1.yRot = 0.52F + cosf2[2] * 0.03F;
  			this.Tail04_1.xRot = 0.52F + cosf2[3] * 0.03F;
  			this.Tail04_1.yRot = 0.44F + cosf2[3] * 0.03F;
  			this.Tail05_1.xRot = 0.52F + cosf2[4] * 0.04F;
  			this.Tail05_1.yRot = 0.17F + cosf2[4] * 0.04F;
  			this.Tail06_1.xRot = 0.35F + cosf2[5] * 0.05F;
  			this.Tail06_1.yRot = -0.35F + cosf2[5] * 0.05F;
  			this.Tail07_1.xRot = 0.44F + cosf2[6] * 0.06F;
  			this.Tail07_1.yRot = -0.17F + cosf2[6] * 0.06F;
  			this.Tail08_1.xRot = 0.52F + cosf2[7] * 0.08F;
  			this.Tail08_1.yRot = -0.17F + cosf2[7] * 0.08F;
  			this.Tail09_1.xRot = 0.52F + cosf2[8] * 0.15F;
  			this.Tail09_1.yRot = -0.17F + cosf2[8] * 0.15F;
		}
		else if (ft2)
		{
  			this.TailBase.y = (7.0F) + (-0.54F) * 16F;
  			this.TailBase.z = (-2.0F) + (0.86F) * 16F;
  			this.Tail01.xRot = -0.17F + cosf2[0] * 0.03F;
  			this.Tail01.yRot = 1.3F + cosf2[0] * 0.03F;
  			this.Tail02.xRot = 0.26F + cosf2[1] * 0.03F;
  			this.Tail02.yRot = -0.52F + cosf2[1] * 0.03F;
  			this.Tail03.xRot = 0.35F + cosf2[2] * 0.03F;
  			this.Tail03.yRot = -0.52F + cosf2[2] * 0.03F;
  			this.Tail04.xRot = 0.52F + cosf2[3] * 0.03F;
  			this.Tail04.yRot = -0.44F + cosf2[3] * 0.03F;
  			this.Tail05.xRot = 0.52F + cosf2[4] * 0.04F;
  			this.Tail05.yRot = -0.17F + cosf2[4] * 0.04F;
  			this.Tail06.xRot = 0.35F + cosf2[5] * 0.05F;
  			this.Tail06.yRot = 0.35F + cosf2[5] * 0.05F;
  			this.Tail07.xRot = 0.44F + cosf2[6] * 0.06F;
  			this.Tail07.yRot = 0.17F + cosf2[6] * 0.06F;
  			this.Tail08.xRot = 0.52F + cosf2[7] * 0.08F;
  			this.Tail08.yRot = 0.17F + cosf2[7] * 0.08F;
  			this.Tail09.xRot = 0.52F + cosf2[8] * 0.15F;
  			this.Tail09.yRot = 0.17F + cosf2[8] * 0.15F;
  			this.Tail01_1.xRot = -0.17F + cosf2[0] * 0.03F;
  			this.Tail01_1.yRot = -1.3F + cosf2[0] * 0.03F;
  			this.Tail02_1.xRot = 0.26F + cosf2[1] * 0.03F;
  			this.Tail02_1.yRot = 0.52F + cosf2[1] * 0.03F;
  			this.Tail03_1.xRot = 0.35F + cosf2[2] * 0.03F;
  			this.Tail03_1.yRot = 0.52F + cosf2[2] * 0.03F;
  			this.Tail04_1.xRot = 0.52F + cosf2[3] * 0.03F;
  			this.Tail04_1.yRot = 0.44F + cosf2[3] * 0.03F;
  			this.Tail05_1.xRot = 0.52F + cosf2[4] * 0.04F;
  			this.Tail05_1.yRot = 0.17F + cosf2[4] * 0.04F;
  			this.Tail06_1.xRot = 0.35F + cosf2[5] * 0.05F;
  			this.Tail06_1.yRot = -0.35F + cosf2[5] * 0.05F;
  			this.Tail07_1.xRot = 0.44F + cosf2[6] * 0.06F;
  			this.Tail07_1.yRot = -0.17F + cosf2[6] * 0.06F;
  			this.Tail08_1.xRot = 0.52F + cosf2[7] * 0.08F;
  			this.Tail08_1.yRot = -0.17F + cosf2[7] * 0.08F;
  			this.Tail09_1.xRot = 0.52F + cosf2[8] * 0.15F;
  			this.Tail09_1.yRot = -0.17F + cosf2[8] * 0.15F;
		}
		
		//ear
		float modf2 = f2 % 128F;
		if (modf2 < 6F)
		{
			//total 10 ticks, loop twice in 20 ticks
			if(modf2 >= 3F) modf2 -= 3F;
			float anglef2 = Mth.sin(modf2 * 1.0472F) * 0.25F;
			this.Ear01.zRot = anglef2 + 0.1745F;
			this.Ear02.zRot = -anglef2 - 0.1745F;
		}
		else
		{
			this.Ear01.zRot = 0.1745F;
			this.Ear02.zRot = -0.1745F;
		}
		
		//奔跑動作
	    if (ent.getIsSprinting() || f1 > 0.8F)
	    {
	    	//leg
	    	addk1 *= 2F;
	    	addk2 *= 2F;
	    	this.ArmRight01.xRot = addk1;
	    	this.ArmLeft01.xRot = addk2;
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    //潛行, 蹲下動作
	    if (ent.getIsSneaking())
	    {
	    	//head
	    	this.Head.y = (-6.0F) + (0.2F) * 16F;
	    	this.GlowHead.y = (-6.0F) + (0.2F) * 16F;
  		}//end if sneaking
  		
	    //坐下, 騎乘動作
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
	    		//hat state 4
	    		if (fh4)
	    		{
	    			this.HatBase.xRot = -1.8F;//-103
	      			this.HatBase.y = (-3.1F) + (0.3F) * 16F;
	      			this.HatBase.z = (5.8F) + (0.07F) * 16F;
	    		}
	    		//hat state 1
	    		else if (fh1)
	    		{
	    			this.HatBase.xRot = 1.37F;//78
	      			this.HatBase.y = (-3.1F) + (-0.45F) * 16F;
	      			this.HatBase.z = (5.8F) + (-0.2F) * 16F;
	    		}
	    		//hat state 3
	    		else if (fh3)
	    		{
	      			this.HatBase.xRot = -0.85F;//-48
	      			this.HatBase.y = (-3.1F) + (0.1F) * 16F;
	      			this.HatBase.z = (5.8F) + (0.07F) * 16F;
	    		}
	    		//no hat or hat state 2
	    		else
	    		{
	    			this.HatBase.xRot = 0F;
	      			this.HatBase.y = (-3.1F) + (0F) * 16F;
	      			this.HatBase.z = (5.8F) + (0F) * 16F;
	    		}
	      		
this.animTransX += (0F); this.animTransY += (0.21F); this.animTransZ += (0F);
		    	//body
	    		this.Head.xRot -= 0.2F;
	    		this.Head.zRot -= 0.09F;
	    		this.BodyMain.zRot = 0.09F;
		    	//arm
		    	this.ArmLeft01.xRot = -1.31F;
		    	this.ArmLeft01.yRot = 0.17F;
		    	this.ArmLeft01.zRot = 0F;
		    	this.ArmLeft01.z = (-6.0F) + (0F) * 16F;
		    	this.ArmLeft02.zRot = 0F;
		    	this.ArmRight01.xRot = -1.22F;
		    	this.ArmRight01.yRot = 1.05F;
		    	this.ArmRight01.zRot = 0F;
		    	this.ArmRight01.z = (-6.0F) + (0F) * 16F;
		    	this.ArmRight02.zRot = 0F;
		    	//leg
		    	addk1 = 1.31F;
		    	addk2 = 1.22F;
		    	this.LegLeft01.yRot = -0.7F;
		    	this.LegLeft01.zRot = 0F;
		    	this.LegRight01.yRot = -0.87F;
		    	this.LegRight01.zRot = 0F;
	    	}
	    	else if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED)
	    	{
this.animTransX += (0F); this.animTransY += (0.22F); this.animTransZ += (0F);
		    	//head
		    	this.Head.xRot = 1.5359F;
		    	this.Head.y = (-6.0F) + (0.25F) * 16F;
		    	this.GlowHead.xRot = 1.5359F;
		    	this.GlowHead.y = (-6.0F) + (0.25F) * 16F;
		    	//arm
		    	addk1 = 1.5359F;
		    	addk2 = 1.5359F;
		    	this.ArmLeft01.xRot = -1.5359F;
		    	this.ArmLeft01.zRot = 0F;
		    	this.ArmLeft01.z = (-6.0F) + (-0.18F) * 16F;
		    	this.ArmRight01.xRot = -1.5359F;
		    	this.ArmRight01.zRot = 0F;
		    	this.ArmRight01.z = (-6.0F) + (-0.18F) * 16F;
		    	
		    	//hat state 4
	    		if (fh4)
	    		{
	    			this.HatBase.xRot = -1.8F;//-103
	      			this.HatBase.y = (-3.1F) + (0.6F) * 16F;
	      			this.HatBase.z = (5.8F) + (-0.3F) * 16F;
	    		}
		    	//hat state 1
	    		else if (fh1)
	    		{
	      			this.HatBase.xRot = 1.37F;//78
	      			this.HatBase.y = (-3.1F) + (-0.45F) * 16F;
	      			this.HatBase.z = (5.8F) + (-0.2F) * 16F;
	    		}
	    		//hat state 3
	    		else if (fh3)
	    		{
	    			this.HatBase.xRot = -0.85F;//-48
	      			this.HatBase.y = (-3.1F) + (0.6F) * 16F;
	      			this.HatBase.z = (5.8F) + (0.07F) * 16F;
	    		}
	    		//no hat or hat state 2
	    		else
	    		{
	    			this.HatBase.xRot = 0F;
	      			this.HatBase.y = (-3.1F) + (0F) * 16F;
	      			this.HatBase.z = (5.8F) + (0F) * 16F;
	    		}
	    	}
	    	else
	    	{
	    		//hat state 4
	    		if (fh4)
	    		{
	    			this.HatBase.xRot = -1.8F;//-103
	      			this.HatBase.y = (-3.1F) + (0.2F) * 16F;
	      			this.HatBase.z = (5.8F) + (0.07F) * 16F;
	    		}
	    		//hat state 1
	    		else if (fh1)
	    		{
	      			this.HatBase.xRot = 1.37F;//78
	      			this.HatBase.y = (-3.1F) + (-0.45F) * 16F;
	      			this.HatBase.z = (5.8F) + (-0.2F) * 16F;
	    		}
	    		//hat state 3
	    		else if (fh3)
	    		{
	    			this.HatBase.xRot = -0.85F;//-48
	      			this.HatBase.y = (-3.1F) + (0F) * 16F;
	      			this.HatBase.z = (5.8F) + (0.07F) * 16F;
	    		}
	    		//no hat or hat state 2
	    		else
	    		{
	    			this.HatBase.xRot = 0F;
	      			this.HatBase.y = (-3.1F) + (0F) * 16F;
	      			this.HatBase.z = (5.8F) + (0F) * 16F;
	    		}

this.animTransX += (0F); this.animTransY += (0.22F); this.animTransZ += (0F);
		    	//head
		    	this.Head.xRot -= 0.5F;
		    	this.GlowHead.xRot -= 0.5F;
		    	this.Head.y = (-6.0F) + (0.25F) * 16F;
		    	this.GlowHead.y = (-6.0F) + (0.25F) * 16F;
		    	//arm
		    	addk1 = 1.5359F;
		    	addk2 = 1.5359F;
		    	this.ArmLeft01.xRot = -1.5359F;
		    	this.ArmLeft01.zRot = 0F;
		    	this.ArmLeft01.z = (-6.0F) + (-0.18F) * 16F;
		    	this.ArmLeft02.zRot = 1.1868F;
		    	this.ArmRight01.xRot = -1.5359F;
		    	this.ArmRight01.zRot = 0F;
		    	this.ArmRight01.z = (-6.0F) + (-0.18F) * 16F;
		    	this.ArmRight02.zRot = -1.1868F;
	    	}
  		}//end if sitting
	    
	    //攻擊動作    
	    if (ent.getAttackTick() > 30)
	    {
			//tail head
			this.TailHead01.xRot = -0.6F;
			this.TailJaw01.xRot = 0.5F;
			this.TailHead01_1.xRot = -0.6F;
			this.TailJaw01_1.xRot = 0.5F;
			this.TailC01.xRot = -0.1F;
			this.TailC02.xRot = -0.1F;
			this.TailC01_1.xRot = -0.1F;
			this.TailC02_1.xRot = -0.1F;
			//tail body
  			this.Tail01.xRot = 0.2F;
  			this.Tail01.yRot = 1.2F;
  			this.Tail02.xRot = 0.4F;
  			this.Tail02.yRot = -0.5F;
  			this.Tail03.xRot = 0.4F;
  			this.Tail03.yRot = -0.32F;
  			this.Tail04.xRot = 0.4F;
  			this.Tail04.yRot = 0.4F;
  			this.Tail05.xRot = 0.2F;
  			this.Tail05.yRot = 0.4F;
  			this.Tail06.xRot = 0.3F;
  			this.Tail06.yRot = 0.4F;
  			this.Tail07.xRot = 0.2F;
  			this.Tail07.yRot = 0.4F;
  			this.Tail08.xRot = 0.1F;
  			this.Tail08.yRot = 0.3F;
  			this.Tail09.xRot = 0.1F;
  			this.Tail09.yRot = 0.3F;
  			this.Tail01_1.xRot = -0.17F;
  			this.Tail01_1.yRot = -1.5F;
  			this.Tail02_1.xRot = 0.26F;
  			this.Tail02_1.yRot = 0.52F;
  			this.Tail03_1.xRot = 0.35F;
  			this.Tail03_1.yRot = 0.52F;
  			this.Tail04_1.xRot = 0.52F;
  			this.Tail04_1.yRot = 0.3F;
  			this.Tail05_1.xRot = 0.52F;
  			this.Tail05_1.yRot = 0.17F;
  			this.Tail06_1.xRot = 0.35F;
  			this.Tail06_1.yRot = -0.35F;
  			this.Tail07_1.xRot = 0.2F;
  			this.Tail07_1.yRot = -0.17F;
  			this.Tail08_1.xRot = 0.3F;
  			this.Tail08_1.yRot = -0.17F;
  			this.Tail09_1.xRot = 0.5F;
  			this.Tail09_1.yRot = -0.17F;
  			
  			float ptick = ent.getAttackTick() + (1 - f2 + (int)f2);
			if (ent.getAttackTick() > 47)
			{
				this.TailHead01.xRot = (ptick - 50) * 0.3F - 0.1F;
				this.TailJaw01.xRot = (50 - ptick) * 0.3F + 0.1F;
			}
			else if (ent.getAttackTick() > 39)
			{
				this.TailHead01.xRot = -0.7F + (47 - ptick) * 0.06F;
				this.TailJaw01.xRot = 0.7F - (47 - ptick) * 0.06F;
			}
			else
			{
				this.TailHead01.xRot = -0.25F;
				this.TailJaw01.xRot = 0.25F;
			}
			
			this.TailHead01_1.xRot = this.TailHead01.xRot;
			this.TailJaw01_1.xRot = this.TailJaw01.xRot;
	    }
	    
	    //swing arm
	  	float f6 = ent.getSwingTime(f2 - (int)f2);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight01.xRot = -0.6F - f8 * 80.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.yRot = 0F - f7 * 20.0F * Values.N.DIV_PI_180 + 0.2F;
	        this.ArmRight01.zRot = 0.2F - -f8 * 20.0F * Values.N.DIV_PI_180;
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
				this.setMouth(1);
			}
		}
		else
		{
			this.setFace(7);
			this.setMouth(2);
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
				this.setMouth(0);
			}
			else
			{
				this.setMouth(1);
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
				this.setMouth(1);
			}
		}
		else if (t < 410)
		{
			this.setFace(3);
			
			if (t < 360)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(4);
			}
		}
		else
		{
			this.setFace(8);
			
			if (t < 470)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(1);
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
				this.setMouth(2);
			}
			else
			{
				this.setMouth(1);
			}
		}
		else if (t < 400)
		{
			this.setFace(3);
			
			if (t < 250)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(3);
			}
		}
		else
		{
			this.setFace(9);
			
			if (t < 450)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(1);
			}
		}
	
	}

	public void setFaceScorn(IShipEmotion ent)
	{

		this.setFace(2);
		this.setMouth(1);
	
	}

	public void setFaceHungry(IShipEmotion ent)
	{

		this.setFace(4);	
		this.setMouth(2);
	
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
				this.setMouth(1);
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
			this.setFace(8);

			if (t < 250)
			{
				this.setMouth(0);
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
				this.setMouth(0);
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
				this.setMouth(3);
			}
			else
			{
				this.setMouth(4);
			}
		}
		else
		{
			this.setFace(8);
			this.setMouth(0);
		}
	
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

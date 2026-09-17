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

public class ModelDestroyerHibiki<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Butt;
	public ModelPart Head;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart Cloth01;
	public ModelPart EquipBase;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart Skirt01;
	public ModelPart LegRight02;
	public ModelPart LegRight03;
	public ModelPart LegLeft02;
	public ModelPart LegLeft03;
	public ModelPart Skirt02;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Ahoke;
	public ModelPart HairU01;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart HairL02;
	public ModelPart HairR02;
	public ModelPart Hair01;
	public ModelPart HatBase;
	public ModelPart Hair02f1;
	public ModelPart Hair02a1;
	public ModelPart Hair02b1;
	public ModelPart Hair02c1;
	public ModelPart Hair02d1;
	public ModelPart Hair02e1;
	public ModelPart Hair02a2;
	public ModelPart Hair02b2;
	public ModelPart Hair02c2;
	public ModelPart Hair02d2;
	public ModelPart Hair02e2;
	public ModelPart Hat01a;
	public ModelPart Hat01b;
	public ModelPart Hat01c;
	public ModelPart Hat01d;
	public ModelPart Hat02a;
	public ModelPart Hat03a;
	public ModelPart Hat03b;
	public ModelPart Hat03c;
	public ModelPart Hat03d;
	public ModelPart Hat02b;
	public ModelPart HatBase2;
	public ModelPart Hat201_01;
	public ModelPart Hat201_02;
	public ModelPart Hat201_03;
	public ModelPart Hat201_04;
	public ModelPart Hat201_05;
	public ModelPart Hat201_06;
	public ModelPart Hat201_07;
	public ModelPart Hat201_08;
	public ModelPart Hat201_09;
	public ModelPart Hat201_10;
	public ModelPart Hat201_11;
	public ModelPart Hat201_12;
	public ModelPart Hat202a;
	public ModelPart Hat202b;
	public ModelPart Hair02f2;
	public ModelPart ArmLeft02;
	public ModelPart ArmLeft03;
	public ModelPart EquipTL03;
	public ModelPart ArmRight02;
	public ModelPart ArmRight03;
	public ModelPart Cloth02;
	public ModelPart EquipMain01;
	public ModelPart EquipC01;
	public ModelPart EquipMain02;
	public ModelPart EquipMain03;
	public ModelPart EquipMain04;
	public ModelPart EquipTL02;
	public ModelPart EquipTR02;
	public ModelPart EquipHead01;
	public ModelPart EquipHead02;
	public ModelPart EquipHead03;
	public ModelPart EquipHead04;
	public ModelPart EquipHead05;
	public ModelPart EquipTL02a;
	public ModelPart EquipTL02b;
	public ModelPart EquipTL02c;
	public ModelPart EquipTL02d;
	public ModelPart EquipTL02e;
	public ModelPart EquipTL02f;
	public ModelPart EquipTR02a;
	public ModelPart EquipTR02b;
	public ModelPart EquipTR02c;
	public ModelPart EquipTR02d;
	public ModelPart EquipTR02e;
	public ModelPart EquipTR02f;
	public ModelPart EquipC02;
	public ModelPart EquipC03;
	public ModelPart EquipC04a;
	public ModelPart EquipC05a;
	public ModelPart EquipC04b;
	public ModelPart EquipC05b;
	public ModelPart GlowBodyMain;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 14.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-7.0F, 0.0F, -4.4F, 14.0F, 7.0F, 8.0F), PartPose.offset(0.0F, -11.6F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("Cloth02", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 10.0F, 0.0F), PartPose.offset(0.0F, 4.8F, -4.3F));
		PartDefinition partdef3 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.0F, 0.0F, 0.0F, 14.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -4.0F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F), PartPose.offsetAndRotation(4.4F, 5.5F, 3.2F, -0.13962634015954636F, 0.0F, 0.10471975511965977F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(-3.0F, 12.0F, -3.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("LegLeft03", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 5.0F, 7.0F), PartPose.offset(3.0F, 8.0F, 2.9F));
		PartDefinition partdef7 = partdef3.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 6.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 1.7F, -0.4F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 3.5F, -0.4F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef3.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F), PartPose.offsetAndRotation(-4.4F, 5.5F, 3.2F, -0.05235987755982988F, 0.0F, -0.10471975511965977F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(3.0F, 12.0F, -3.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("LegRight03", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 5.0F, 7.0F), PartPose.offset(-3.0F, 8.0F, 2.9F));
		PartDefinition partdef12 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-2.5F, -1.0F, -3.0F, 6.0F, 11.0F, 6.0F), PartPose.offsetAndRotation(7.3F, -9.4F, -0.7F, 0.17453292519943295F, 0.0F, -0.3141592653589793F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-6.0F, 0.0F, -6.0F, 6.0F, 8.0F, 6.0F), PartPose.offset(3.5F, 10.0F, 3.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("ArmLeft03", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(-3.0F, 6.0F, -3.0F));
		PartDefinition partdef15 = partdef13.addOrReplaceChild("EquipTL03", CubeListBuilder.create().addBox(0.0F, -12.0F, -3.5F, 1.0F, 24.0F, 7.0F), PartPose.offsetAndRotation(0.5F, 4.0F, -3.0F, -0.13962634015954636F, -0.10471975511965977F, -0.05235987755982988F));
		PartDefinition partdef16 = partdef0.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, -1.0F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("EquipMain01", CubeListBuilder.create().addBox(-5.5F, -1.0F, 0.0F, 11.0F, 9.0F, 12.0F), PartPose.offset(0.0F, -4.0F, 5.0F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("EquipMain04", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 16.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -16.5F, 9.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef17.addOrReplaceChild("EquipMain03", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 9.5F, 9.0F, 0.5009094953223726F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("EquipHead01", CubeListBuilder.create().addBox(0.0F, -1.5F, -12.0F, 2.0F, 3.0F, 18.0F), PartPose.offsetAndRotation(0.0F, 6.5F, -0.5F, 3.141592653589793F, -1.8325957145940461F, -1.5707963267948966F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("EquipHead02", CubeListBuilder.create().addBox(-1.5F, -7.0F, 0.0F, 3.0F, 14.0F, 3.0F), PartPose.offset(1.0F, 0.0F, -15.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("EquipHead04", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -4.8F, 2.5F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef23 = partdef21.addOrReplaceChild("EquipHead05", CubeListBuilder.create().addBox(-1.0F, -5.0F, 0.0F, 2.0F, 10.0F, 2.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition partdef24 = partdef21.addOrReplaceChild("EquipHead03", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 4.8F, 2.5F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef25 = partdef17.addOrReplaceChild("EquipTR02", CubeListBuilder.create().addBox(-3.0F, -4.0F, -9.0F, 3.0F, 9.0F, 12.0F), PartPose.offsetAndRotation(-5.5F, 6.0F, 4.5F, 0.13962634015954636F, 0.06981317007977318F, 0.0F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("EquipTR02f", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-1.3F, 2.3F, 2.5F));
		PartDefinition partdef27 = partdef25.addOrReplaceChild("EquipTR02a", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F), PartPose.offset(-1.3F, 0.0F, -19.8F));
		PartDefinition partdef28 = partdef25.addOrReplaceChild("EquipTR02e", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-1.3F, 0.0F, 2.2F));
		PartDefinition partdef29 = partdef25.addOrReplaceChild("EquipTR02d", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-1.3F, -2.3F, 3.0F));
		PartDefinition partdef30 = partdef25.addOrReplaceChild("EquipTR02b", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 10.0F), PartPose.offset(-1.3F, -2.3F, -18.8F));
		PartDefinition partdef31 = partdef25.addOrReplaceChild("EquipTR02c", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F), PartPose.offset(-1.3F, 2.3F, -19.5F));
		PartDefinition partdef32 = partdef17.addOrReplaceChild("EquipMain02", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 6.9F, 1.2F, 0.6283185307179586F, 0.0F, 0.0F));
		PartDefinition partdef33 = partdef17.addOrReplaceChild("EquipTL02", CubeListBuilder.create().addBox(0.0F, -4.0F, -9.0F, 3.0F, 9.0F, 12.0F), PartPose.offsetAndRotation(5.5F, 6.0F, 4.5F, 0.13962634015954636F, -0.06981317007977318F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("EquipTL02d", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(1.3F, -2.3F, 3.0F));
		PartDefinition partdef35 = partdef33.addOrReplaceChild("EquipTL02b", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 10.0F), PartPose.offset(1.3F, -2.3F, -18.8F));
		PartDefinition partdef36 = partdef33.addOrReplaceChild("EquipTL02e", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(1.3F, 0.0F, 2.2F));
		PartDefinition partdef37 = partdef33.addOrReplaceChild("EquipTL02a", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F), PartPose.offset(1.3F, 0.0F, -19.8F));
		PartDefinition partdef38 = partdef33.addOrReplaceChild("EquipTL02c", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F), PartPose.offset(1.3F, 2.3F, -19.5F));
		PartDefinition partdef39 = partdef33.addOrReplaceChild("EquipTL02f", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(1.3F, 2.3F, 2.5F));
		PartDefinition partdef40 = partdef16.addOrReplaceChild("EquipC01", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F), PartPose.offset(-7.0F, -11.0F, 9.0F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("EquipC02", CubeListBuilder.create().addBox(-3.5F, -3.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(-2.0F, 0.5F, 0.0F, -0.17453292519943295F, 0.6283185307179586F, 0.0F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("EquipC03", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 5.0F), PartPose.offset(0.0F, -5.0F, -2.0F));
		PartDefinition partdef43 = partdef41.addOrReplaceChild("EquipC05a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 6.0F), PartPose.offset(1.5F, -3.0F, 0.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("EquipC05b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -10.0F, 1.0F, 1.0F, 10.0F), PartPose.offset(0.0F, 0.0F, -6.0F));
		PartDefinition partdef45 = partdef41.addOrReplaceChild("EquipC04a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 6.0F), PartPose.offset(-1.5F, -3.0F, 0.0F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("EquipC04b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -10.0F, 1.0F, 1.0F, 10.0F), PartPose.offset(0.0F, 0.0F, -6.0F));
		PartDefinition partdef47 = partdef0.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -11.8F, -1.0F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -2.8F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("HatBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, -2.4F, 1.5F, -0.10471975511965977F, 0.7853981633974483F, 0.0F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("Hat03c", CubeListBuilder.create().addBox(0.0F, -4.0F, 0.0F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-0.5F, 2.0F, 0.0F, -0.03490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef51 = partdef49.addOrReplaceChild("Hat01a", CubeListBuilder.create().addBox(0.0F, 0.0F, -6.0F, 6.0F, 2.0F, 6.0F), PartPose.offset(-0.7F, 0.0F, 0.0F));
		PartDefinition partdef52 = partdef49.addOrReplaceChild("Hat01b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 6.0F), PartPose.offset(-0.7F, 0.0F, 0.0F));
		PartDefinition partdef53 = partdef49.addOrReplaceChild("Hat01c", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 2.0F, 6.0F), PartPose.offset(0.7F, 0.0F, 0.0F));
		PartDefinition partdef54 = partdef49.addOrReplaceChild("Hat03d", CubeListBuilder.create().addBox(-5.0F, -4.0F, 0.0F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.5F, 2.0F, 0.0F, -0.03490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef55 = partdef49.addOrReplaceChild("Hat02b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(4.8F, -1.7F, -2.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef56 = partdef49.addOrReplaceChild("Hat01d", CubeListBuilder.create().addBox(-6.0F, 0.0F, -6.0F, 6.0F, 2.0F, 6.0F), PartPose.offset(0.7F, 0.0F, 0.0F));
		PartDefinition partdef57 = partdef49.addOrReplaceChild("Hat03a", CubeListBuilder.create().mirror().addBox(0.0F, -4.0F, -5.0F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-0.3F, 2.0F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef58 = partdef49.addOrReplaceChild("Hat03b", CubeListBuilder.create().addBox(-5.0F, -4.0F, -5.0F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.3F, 2.0F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef59 = partdef49.addOrReplaceChild("Hat02a", CubeListBuilder.create().addBox(-4.5F, 0.0F, -6.0F, 9.0F, 0.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 2.0F, -6.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef60 = partdef48.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, -10.0F, 15.0F, 12.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 12.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("Hair02b1", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(-4.0F, 7.0F, -2.4F, 0.2617993877991494F, -0.17453292519943295F, 0.2617993877991494F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("Hair02b2", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -0.4363323129985824F, 0.0F, 0.0F));
		PartDefinition partdef63 = partdef60.addOrReplaceChild("Hair02a1", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 10.0F, -2.2F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef64 = partdef63.addOrReplaceChild("Hair02a2", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef65 = partdef60.addOrReplaceChild("Hair02e1", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(7.4F, -4.0F, -5.5F, 0.05235987755982988F, 0.0F, -0.6108652381980153F));
		PartDefinition partdef66 = partdef65.addOrReplaceChild("Hair02e2", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, 0.0F, 0.8726646259971648F));
		PartDefinition partdef67 = partdef60.addOrReplaceChild("Hair02d1", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(-7.4F, 0.0F, -5.5F, 0.2617993877991494F, 0.0F, 0.3490658503988659F));
		PartDefinition partdef68 = partdef67.addOrReplaceChild("Hair02d2", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, 0.0F, -0.5235987755982988F));
		PartDefinition partdef69 = partdef60.addOrReplaceChild("Hair02c1", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(4.2F, 6.0F, -2.4F, 0.17453292519943295F, 0.17453292519943295F, -0.40142572795869574F));
		PartDefinition partdef70 = partdef69.addOrReplaceChild("Hair02c2", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef71 = partdef48.addOrReplaceChild("Hair02f1", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(5.0F, 1.0F, 9.5F, 0.7853981633974483F, 0.3490658503988659F, -0.13962634015954636F));
		PartDefinition partdef72 = partdef71.addOrReplaceChild("Hair02f2", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.6283185307179586F, 0.0F, 0.0F));
		PartDefinition partdef73 = partdef47.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 12.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.3F));
		PartDefinition partdef74 = partdef73.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F), PartPose.offset(0.0F, -6.2F, -7.1F));
		PartDefinition partdef75 = partdef73.addOrReplaceChild("HairR01", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-8.0F, 2.6F, -4.7F, -0.2617993877991494F, 0.08726646259971647F, -0.08726646259971647F));
		PartDefinition partdef76 = partdef75.addOrReplaceChild("HairR02", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(0.1F, 8.5F, 0.0F, 0.20943951023931953F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef77 = partdef73.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, 0.0F, -11.0F, 0.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(-4.5F, -7.4F, -7.0F, -0.5235987755982988F, 1.2217304763960306F, 0.0F));
		PartDefinition partdef78 = partdef73.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(8.0F, 2.5F, -4.4F, -0.2617993877991494F, -0.08726646259971647F, 0.08726646259971647F));
		PartDefinition partdef79 = partdef78.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-0.1F, 8.5F, 0.0F, 0.3141592653589793F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef80 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.5F, -1.0F, -3.0F, 6.0F, 11.0F, 6.0F), PartPose.offsetAndRotation(-7.3F, -9.4F, -0.7F, 0.17453292519943295F, 0.0F, 0.3141592653589793F));
		PartDefinition partdef81 = partdef80.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0.0F, 0.0F, -6.0F, 6.0F, 8.0F, 6.0F), PartPose.offset(-3.5F, 10.0F, 3.0F));
		PartDefinition partdef82 = partdef81.addOrReplaceChild("ArmRight03", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(3.0F, 6.0F, -3.0F));
		PartDefinition partdef83 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 0.0F));
		PartDefinition partdef84 = partdef83.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -11.8F, -1.0F));
		PartDefinition partdef85 = partdef84.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef86 = partdef84.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef87 = partdef84.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef88 = partdef84.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef89 = partdef84.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef90 = partdef84.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef91 = partdef84.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef92 = partdef84.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef93 = partdef84.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6F, -3.0F, -6.8F));
		PartDefinition partdef94 = partdef84.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6F, -3.0F, -6.8F));
		PartDefinition partdef95 = partdef84.addOrReplaceChild("HatBase2", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -8F, 0.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition partdef96 = partdef95.addOrReplaceChild("Hat201_01", CubeListBuilder.create().mirror().addBox(0.0F, -9.0F, 0.0F, 9.0F, 9.0F, 1.0F), PartPose.offset(0.0F, 0.0F, -9.0F));
		PartDefinition partdef97 = partdef95.addOrReplaceChild("Hat201_02", CubeListBuilder.create().addBox(-9.0F, -9.0F, 0.0F, 9.0F, 9.0F, 1.0F), PartPose.offset(0.0F, 0.0F, -9.0F));
		PartDefinition partdef98 = partdef95.addOrReplaceChild("Hat201_03", CubeListBuilder.create().mirror().addBox(0.0F, -9.0F, 0.0F, 9.0F, 9.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 8.0F));
		PartDefinition partdef99 = partdef95.addOrReplaceChild("Hat201_04", CubeListBuilder.create().addBox(-9.0F, -9.0F, 0.0F, 9.0F, 9.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 8.0F));
		PartDefinition partdef100 = partdef95.addOrReplaceChild("Hat201_05", CubeListBuilder.create().mirror().addBox(0.0F, -9.0F, 0.0F, 9.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef101 = partdef95.addOrReplaceChild("Hat201_06", CubeListBuilder.create().addBox(0.0F, -9.0F, 0.0F, 9.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(8.0F, 0.0F, 9.0F, 0.0F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef102 = partdef95.addOrReplaceChild("Hat201_07", CubeListBuilder.create().mirror().addBox(0.0F, -9.0F, 0.0F, 9.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef103 = partdef95.addOrReplaceChild("Hat201_08", CubeListBuilder.create().addBox(0.0F, -9.0F, 0.0F, 9.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(-9.0F, 0.0F, 9.0F, 0.0F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef104 = partdef95.addOrReplaceChild("Hat201_09", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 9.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef105 = partdef95.addOrReplaceChild("Hat201_10", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(-9.0F, -9.0F, 0.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef106 = partdef95.addOrReplaceChild("Hat201_11", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 9.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -9.0F, 9.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef107 = partdef95.addOrReplaceChild("Hat201_12", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(-9.0F, -9.0F, 9.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef108 = partdef95.addOrReplaceChild("Hat202a", CubeListBuilder.create().addBox(-3F, 0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(9.5F, -2.5F, 0.0F, 0.0F, 1.57F, -0.08726646259971647F));
		PartDefinition partdef109 = partdef95.addOrReplaceChild("Hat202b", CubeListBuilder.create().addBox(-3F, 0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-9.5F, -2.5F, 0.0F, 0.0F, 1.57F, 0.08726646259971647F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelDestroyerHibiki(ModelPart root)
	{
		this.EquipTR02f = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTR02").getChild("EquipTR02f");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.EquipTR02a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTR02").getChild("EquipTR02a");
		this.EquipMain04 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain04");
		this.Cloth02 = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth02");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.EquipTL02d = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02").getChild("EquipTL02d");
		this.Hair02b1 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02b1");
		this.Hat03c = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("HatBase").getChild("Hat03c");
		this.EquipHead04 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain03").getChild("EquipHead01").getChild("EquipHead02").getChild("EquipHead04");
		this.EquipMain01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01");
		this.EquipTR02e = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTR02").getChild("EquipTR02e");
		this.EquipHead01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain03").getChild("EquipHead01");
		this.EquipTL02b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02").getChild("EquipTL02b");
		this.HairU01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairU01");
		this.Hat01a = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("HatBase").getChild("Hat01a");
		this.Hair02a1 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02a1");
		this.EquipHead05 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain03").getChild("EquipHead01").getChild("EquipHead02").getChild("EquipHead05");
		this.EquipMain03 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain03");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.EquipTR02d = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTR02").getChild("EquipTR02d");
		this.Hat01b = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("HatBase").getChild("Hat01b");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.EquipC03 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipC01").getChild("EquipC02").getChild("EquipC03");
		this.Hat01c = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("HatBase").getChild("Hat01c");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.EquipC05a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipC01").getChild("EquipC02").getChild("EquipC05a");
		this.EquipHead03 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain03").getChild("EquipHead01").getChild("EquipHead02").getChild("EquipHead03");
		this.Hair02f2 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair02f1").getChild("Hair02f2");
		this.ArmLeft03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.EquipTL02e = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02").getChild("EquipTL02e");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.Hair02b2 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02b1").getChild("Hair02b2");
		this.Hair02e1 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02e1");
		this.BodyMain = root.getChild("BodyMain");
		this.EquipC04a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipC01").getChild("EquipC02").getChild("EquipC04a");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.Hat03d = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("HatBase").getChild("Hat03d");
		this.HairR01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairR01");
		this.EquipTL02a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02").getChild("EquipTL02a");
		this.Hat02b = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("HatBase").getChild("Hat02b");
		this.EquipTR02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTR02");
		this.Ahoke = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.EquipTL03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipTL03");
		this.LegLeft03 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("LegLeft03");
		this.Hair02d2 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02d1").getChild("Hair02d2");
		this.EquipMain02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain02");
		this.HatBase = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("HatBase");
		this.Hat01d = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("HatBase").getChild("Hat01d");
		this.EquipC02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipC01").getChild("EquipC02");
		this.Hair02d1 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02d1");
		this.EquipTL02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02");
		this.Hair01 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.Hair02e2 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02e1").getChild("Hair02e2");
		this.Hat03a = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("HatBase").getChild("Hat03a");
		this.EquipC01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipC01");
		this.EquipTR02b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTR02").getChild("EquipTR02b");
		this.Hair02c1 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02c1");
		this.Hair02c2 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02c1").getChild("Hair02c2");
		this.Hat03b = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("HatBase").getChild("Hat03b");
		this.EquipTL02c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02").getChild("EquipTL02c");
		this.Hair02f1 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair02f1");
		this.HairL01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairL01");
		this.HairMain = root.getChild("BodyMain").getChild("Head").getChild("HairMain");
		this.EquipBase = root.getChild("BodyMain").getChild("EquipBase");
		this.Hair02a2 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02a1").getChild("Hair02a2");
		this.EquipTL02f = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02").getChild("EquipTL02f");
		this.HairR02 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.LegRight03 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("LegRight03");
		this.EquipHead02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain03").getChild("EquipHead01").getChild("EquipHead02");
		this.Hair = root.getChild("BodyMain").getChild("Head").getChild("Hair");
		this.Head = root.getChild("BodyMain").getChild("Head");
		this.Hat02a = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("HatBase").getChild("Hat02a");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.EquipTR02c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTR02").getChild("EquipTR02c");
		this.HairL02 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.EquipC04b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipC01").getChild("EquipC02").getChild("EquipC04a").getChild("EquipC04b");
		this.EquipC05b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipC01").getChild("EquipC02").getChild("EquipC05a").getChild("EquipC05b");
		this.ArmRight03 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03");
		this.HatBase2 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2");
		this.Hat201_01 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2").getChild("Hat201_01");
		this.Hat201_02 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2").getChild("Hat201_02");
		this.Hat201_03 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2").getChild("Hat201_03");
		this.Hat201_04 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2").getChild("Hat201_04");
		this.Hat201_05 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2").getChild("Hat201_05");
		this.Hat201_06 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2").getChild("Hat201_06");
		this.Hat201_07 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2").getChild("Hat201_07");
		this.Hat201_08 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2").getChild("Hat201_08");
		this.Hat201_09 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2").getChild("Hat201_09");
		this.Hat201_10 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2").getChild("Hat201_10");
		this.Hat201_11 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2").getChild("Hat201_11");
		this.Hat201_12 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2").getChild("Hat201_12");
		this.Hat202a = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2").getChild("Hat202a");
		this.Hat202b = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("HatBase2").getChild("Hat202b");
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
		this.offsetItem = new float[] {0.06F, 1.04F, -0.08F};
		this.offsetBlock = new float[] {0.06F, 1.04F, -0.08F};
		this.armMain = new ModelPart[] {this.BodyMain, this.ArmRight01, this.ArmRight02};
		this.armOff = new ModelPart[] {this.BodyMain, this.ArmLeft01, this.ArmLeft02};
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

	public void showEquip(IShipEmotion ent)
	{

		int state = ent.getStateEmotion(ID.S.State);
		
		boolean flag = !EmotionHelper.checkModelState(0, state);	//cannon
		this.EquipBase.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(1, state);			//armor
		this.EquipTL03.visible = !(flag);
				
		boolean fh1 = EmotionHelper.checkModelState(2, state);		//hat state 1
		boolean fh2 = EmotionHelper.checkModelState(3, state);		//hat state 2
		boolean fh3 = EmotionHelper.checkModelState(4, state);		//hat state 3
		
		//hat state 1
		if (fh1)
		{
			this.HatBase.visible = true;
  			this.Hair02f1.visible = true;
  			this.Hair01.visible = true;
  			this.HatBase2.visible = false;
		}
		//hat state 2
		else if (fh2 && fh3)
		{
			this.HatBase.visible = false;
			this.Hair01.visible = false;
  			this.Hair02f1.visible = false;
  			this.HatBase2.visible = true;
  			this.HatBase2.xRot = -1.35F;
  			this.HatBase2.y = (-8F) + (0F) * 16F;
  			this.HatBase2.z = (0.0F) + (0.1F) * 16F;
		}
		//hat state 3
		else if (fh2)
		{
			this.HatBase.visible = false;
  			this.Hair02f1.visible = false;
  			this.Hair01.visible = true;
  			this.HatBase2.visible = true;
  			this.HatBase2.xRot = -0.2618F;
  			this.HatBase2.y = (-8F) + (0F) * 16F;
  			this.HatBase2.z = (0.0F) + (0F) * 16F;
		}
		//hat state 4
		else if (fh3)
		{
			this.HatBase.visible = false;
  			this.Hair02f1.visible = false;
  			this.Hair01.visible = true;
  			this.HatBase2.visible = true;
  			this.HatBase2.xRot = -0.7F;
  			this.HatBase2.y = (-8F) + (-0.06F) * 16F;
  			this.HatBase2.z = (0.0F) + (0.06F) * 16F;
		}
		//no hat
		else
		{
			this.HatBase.visible = false;
  			this.Hair02f1.visible = true;
  			this.Hair01.visible = true;
  			this.HatBase2.visible = false;
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

this.animTransX += (0F); this.animTransY += (0.51F + 0.25F * ent.getScaleLevel()); this.animTransZ += (0F);
    	this.setFaceHungry(ent);
    	
		//body
    	this.Head.xRot = 0F;
    	this.Head.yRot = 0F;
    	this.Head.zRot = 0F;
    	this.Ahoke.yRot = 0.5236F;
    	this.BodyMain.xRot = 1.4F;
    	this.Butt.xRot = 0.21F;
    	this.Butt.y = (3.0F) + (0F) * 16F;
	  	this.Skirt01.xRot = -0.052F;
	  	this.Skirt01.y = (1.7F) + (0F) * 16F;
	  	this.Skirt02.xRot = -0.052F;
	  	this.Skirt02.y = (3.5F) + (0F) * 16F;
	  	this.Hair01.xRot = -0.07F;
    	this.Hair01.y = (9.0F) + (-0.2F) * 16F;
    	//arm
    	this.ArmLeft01.xRot = -2.8F;
    	this.ArmLeft01.yRot = 0F;
    	this.ArmLeft01.zRot = 0.7F;
    	this.ArmRight01.xRot = -2.8F;
    	this.ArmRight01.yRot = 0F;
    	this.ArmRight01.zRot = -0.7F;
    	this.ArmLeft02.zRot = 1.0F;
	    this.ArmLeft02.x = (3.5F) + (0F) * 16F;
		this.ArmRight02.zRot = -1.0F;
		this.ArmRight02.x = (-3.5F) + (0F) * 16F;
    	//leg
    	this.LegLeft01.xRot = 0.1F;
    	this.LegLeft01.yRot = 3.1415F;
    	this.LegLeft01.zRot = -0.1F;
    	this.LegRight01.xRot = 0.1F;
		this.LegRight01.yRot = 3.1415F;
    	this.LegRight01.zRot = 0.1F;
    	this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (-3.0F) + (0F) * 16F;
		this.LegLeft02.y = (12.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.x = (3.0F) + (0F) * 16F;
		this.LegRight02.y = (12.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
	
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
  		float headX = 0F;
  		float headZ = 0F;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}

    	//leg move
  		addk1 = angleAdd1 * 0.5F - 0.14F;	//LegLeft01
	  	addk2 = angleAdd2 * 0.5F - 0.0523F;	//LegRight01
    	
  	    //head
	  	this.Head.xRot = f4 * 0.014F + 0.11F;
	  	this.Head.yRot = f3 * 0.01F;
	  	//body
  	    this.Ahoke.yRot = angleX * 0.2F + 1.2F;
	  	this.BodyMain.xRot = -0.1047F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.21F;
	  	this.Butt.y = (3.0F) + (0F) * 16F;
	  	this.Skirt01.xRot = -0.052F;
	  	this.Skirt01.y = (1.7F) + (0F) * 16F;
	  	this.Skirt02.xRot = -0.052F;
	  	this.Skirt02.y = (3.5F) + (0F) * 16F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.04F + 0.26F;
    	this.Hair01.zRot = 0F;
    	this.Hair01.y = (9.0F) + (0F) * 16F;
    	this.Hair02a1.xRot = -angleX1 * 0.1F + 0.26F;
    	this.Hair02a1.zRot = 0F;
    	this.Hair02b1.xRot = -angleX1 * 0.1F + 0.26F;
    	this.Hair02b1.zRot = 0.26F;
    	this.Hair02c1.xRot = -angleX1 * 0.1F + 0.17F;
    	this.Hair02c1.zRot = -0.4F;
    	this.Hair02d1.xRot = 0.2618F;
    	this.Hair02d1.zRot = -angleX1 * 0.05F + 0.35F;
    	this.Hair02e1.xRot = 0.05F;
    	this.Hair02e1.zRot = angleX1 * 0.05F - 0.6F;
    	this.Hair02a2.xRot = -angleX2 * 0.13F - 0.26F;
    	this.Hair02b2.xRot = -angleX2 * 0.13F - 0.44F;
    	this.Hair02c2.xRot = -angleX2 * 0.13F - 0.35F;
    	this.Hair02d2.zRot = -angleX2 * 0.07F - 0.52F;
    	this.Hair02e2.zRot = angleX2 * 0.07F + 0.87F;
    	this.HairL01.xRot = angleX * 0.04F + -0.2618F;
    	this.HairL01.zRot = 0.087F;
	  	this.HairL02.xRot = -angleX1 * 0.1F + 0.3142F;
	  	this.HairL02.zRot = 0.0873F;
	  	this.HairR01.xRot = angleX * 0.04F + -0.2618F;
	  	this.HairR01.zRot = -0.0873F;
	  	this.HairR02.xRot = -angleX1 * 0.1F + 0.21F;
	  	this.HairR02.zRot = -0.0873F;
	    //arm
	  	this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.1745F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = angleX * 0.03F - 0.3F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.x = (3.5F) + (0F) * 16F;
	    this.ArmRight01.xRot = angleAdd1 * 0.25F - 0.0523F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -angleX * 0.03F + 0.3F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.x = (-3.5F) + (0F) * 16F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.1047F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (-3.0F) + (0F) * 16F;
		this.LegLeft02.y = (12.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.1047F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.x = (3.0F) + (0F) * 16F;
		this.LegRight02.y = (12.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		//equip
	  	this.EquipHead01.zRot = angleX * 0.2F -  1.5708F;
	  	this.EquipC02.yRot = 0.5F + this.Head.yRot * 0.5F;
	  	this.EquipC04a.xRot = -0.2F + this.Head.xRot;
	  	if (this.EquipC04a.xRot > 0F) this.EquipC04a.xRot = 0F;
	  	this.EquipC05a.xRot = this.EquipC04a.xRot;
	    
	    if (!EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State)))
	    {
	    	this.ArmLeft01.zRot += 0.1F;
	    	this.ArmRight01.zRot -= 0.1F;
	    }

	    if (ent.getIsSprinting() || f1 > 0.95F)
	    {	//奔跑動作
	 	    //body
	 	    this.Head.xRot -= 0.25F;
	 	    this.BodyMain.xRot = 0.1F;
	 	    this.Skirt01.xRot = -0.1F;
	 	  	this.Skirt02.xRot = -0.1885F;
	 	  	//arm
	    	this.ArmLeft01.xRot = 0.35F;
	    	this.ArmLeft01.zRot = -0.5F;
		    this.ArmRight01.xRot = 0.35F;
	    	this.ArmRight01.zRot = 0.5F;
	 	    //leg
	 	    addk1 -= 0.2F;
	 	  	addk2 -= 0.2F;
  		}
	    
	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {	//潛行, 蹲下動作
this.animTransX += (0F); this.animTransY += (0.05F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 1.0472F;
		  	this.BodyMain.xRot = 1.0472F;
		  	this.Butt.xRot = -0.4F;
		  	this.Butt.y = (3.0F) + (-0.19F) * 16F;
		  	this.Skirt01.xRot = -0.12F;
		  	this.Skirt02.xRot = -0.4F;
		  	this.Skirt02.y = (3.5F) + (-0.1F) * 16F;
		    //arm 
		    this.ArmLeft01.xRot = -0.6F;
		    this.ArmLeft01.zRot = 0.2618F;
		    this.ArmRight01.xRot = -0.6F;
		    this.ArmRight01.zRot = -0.2618F;
		    //leg
		    addk1 -= 0.55F;
		    addk2 -= 0.55F;
  		}//end if sneaking
	    
	    if (((IShipRiderType) ent).getRiderType() > 0)
	  	{
    		//Body
		  	this.Butt.xRot = -0.2F;
	    	this.Butt.y = (3.0F) + (-0.1F) * 16F;
			this.Skirt01.xRot = -0.07F;
			this.Skirt01.y = (1.7F) + (-0.1F) * 16F;
			this.Skirt02.xRot = -0.16F;
			this.Skirt02.y = (3.5F) + (-0.15F) * 16F;
			//arm 
		  	this.ArmLeft01.xRot = -0.3F;
		  	this.ArmLeft01.yRot = -0.2F;
		  	this.ArmLeft01.zRot = 0F;
		  	this.ArmLeft02.xRot = -1.2F;
		  	this.ArmRight01.xRot = -0.3F;
		  	this.ArmRight01.yRot = 0.2F;
		  	this.ArmRight01.zRot = 0F;
		  	this.ArmRight02.xRot = -1.2F;
			//leg
		  	addk1 = -0.95F;
		  	addk2 = -0.95F;
		  	this.LegLeft01.yRot = -0.5F;
			this.LegLeft01.zRot = -0.1F;
			this.LegLeft02.z = (-3.0F) + (0.0F) * 16F;
			this.LegLeft02.xRot = 0.8F;
			this.LegLeft02.zRot = 0.0175F;
			this.LegRight01.yRot = 0.5F;
			this.LegRight01.zRot = 0.1F;
			this.LegRight02.z = (-3.0F) + (0.0F) * 16F;
			this.LegRight02.xRot = 0.8F;
			this.LegRight02.zRot = -0.0175F;
			
			if (ent.getIsSitting())
	    	{
this.animTransX += (0F); this.animTransY += (0.21F); this.animTransZ += (0F);
	    		//arm
			  	this.ArmLeft01.xRot = -0.6F;
			  	this.ArmLeft01.yRot = 0F;
			  	this.ArmLeft01.zRot = 0.2F;
			  	this.ArmLeft02.xRot = 0F;
			  	this.ArmRight01.xRot = -0.6F;
			  	this.ArmRight01.yRot = 0F;
			  	this.ArmRight01.zRot = -0.2F;
			  	this.ArmRight02.xRot = 0F;
	    	}
	    	
	    	if (((IShipRiderType) ent).getRiderType() > 1)
	    	{
	    		//body
		  		this.Head.yRot *= 0.5F;
		  		this.Head.zRot = 0F;
		  		//arm 
			    this.ArmLeft01.xRot = -0.8F;
			    this.ArmLeft01.yRot = -1.5F;
			    this.ArmLeft01.zRot = 0F;
			    this.ArmLeft02.xRot = 0F;
			    this.ArmLeft02.zRot = 1.45F;
			    this.ArmRight01.xRot = -0.8F;
			    this.ArmRight01.yRot = 1.5F;
			    this.ArmRight01.zRot = 0F;
			    this.ArmRight02.xRot = 0F;
			    this.ArmRight02.zRot = -1.45F;
			    //equip
			    this.EquipBase.visible = false;
			    
			    if (ent.getIsSitting())
		    	{
			    	//Body
				  	this.Head.xRot -= 0.1F;
				  	this.BodyMain.xRot = 0F;
			    	this.Butt.xRot = -0.2F;
			    	this.Butt.y = (3.0F) + (-0.1F) * 16F;
					this.Skirt01.xRot = -0.07F;
					this.Skirt01.y = (1.7F) + (-0.05F) * 16F;
					this.Skirt02.xRot = -0.16F;
					this.Skirt02.y = (3.5F) + (-0.08F) * 16F;
				  	//leg
				  	addk1 = -0.65F;
				  	addk2 = -0.65F;
				  	this.LegLeft01.yRot = 0.2F;
					this.LegLeft01.zRot = 0F;
					this.LegLeft02.z = (-3.0F) + (0.375F) * 16F;
					this.LegLeft02.xRot = 2.45F;
					this.LegLeft02.zRot = 0.0175F;
					this.LegRight01.yRot = -0.2F;
					this.LegRight01.zRot = 0F;
					this.LegRight02.z = (-3.0F) + (0.375F) * 16F;
					this.LegRight02.xRot = 2.45F;
					this.LegRight02.zRot = -0.0175F;
		    	}
	    	}
	  	}
	    else
	    {
	    	//騎乘動作
		    if (ent.getIsSitting() || ent.getIsRiding())
		    {
		    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		    	{
this.animTransX += (0F); this.animTransY += (0.52F); this.animTransZ += (0F);
		    		setFaceBlink1(ent);
		    		//body
	    	    	this.Head.xRot = -0.9F;
	    	    	this.Head.yRot = -1.1F;
	    	    	this.Head.zRot = 0F;
	    	    	this.BodyMain.xRot = 1.4F;
	    	    	//hair
	    	    	this.Hair01.xRot -= 0.1F;
	    	    	this.Hair01.y = (9.0F) + (-0.2F) * 16F;
	    	    	//leg
	    			addk1 = -0.1F;
	    			addk2 = 0F;
	    	    	this.LegLeft01.yRot = 0F;
	    	    	this.LegLeft01.zRot = 0.2F;
	    			this.LegRight01.yRot = 0F;
	    	    	this.LegRight01.zRot = -0.2F;
	    	    	this.LegRight02.xRot = 0.3F;
			    	//arm
			    	this.ArmLeft01.xRot = -2.8F;
			    	this.ArmLeft01.yRot = 0F;
			    	this.ArmLeft01.zRot = -0.2F;
			    	this.ArmRight01.xRot = -2.8F;
			    	this.ArmRight01.yRot = 0F;
			    	this.ArmRight01.zRot = -0.7F;
			    	this.ArmLeft02.zRot = 0.5F;
				    this.ArmLeft02.x = (3.5F) + (0F) * 16F;
					this.ArmRight02.zRot = -1.0F;
					this.ArmRight02.x = (-3.5F) + (0F) * 16F;
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.3F); this.animTransZ += (0F);
			    	//Body
				  	this.Head.xRot -= 0.1F;
				  	this.BodyMain.xRot = 0F;
			    	this.Butt.xRot = -0.2F;
			    	this.Butt.y = (3.0F) + (-0.1F) * 16F;
					this.Skirt01.xRot = -0.07F;
					this.Skirt01.y = (1.7F) + (-0.05F) * 16F;
					this.Skirt02.xRot = -0.16F;
					this.Skirt02.y = (3.5F) + (-0.08F) * 16F;
					//arm 
				  	this.ArmLeft01.xRot = -0.4F;
				  	this.ArmLeft01.zRot = 0.15F;
			    	this.ArmRight01.xRot = -0.4F;
					this.ArmRight01.zRot = -0.15F;
				  	//leg
				  	addk1 = -0.65F;
				  	addk2 = -0.65F;
				  	this.LegLeft01.yRot = 0.2F;
					this.LegLeft01.zRot = 0F;
					this.LegLeft02.z = (-3.0F) + (0.375F) * 16F;
					this.LegLeft02.xRot = 2.45F;
					this.LegLeft02.zRot = 0.0175F;
					this.LegRight01.yRot = -0.2F;
					this.LegRight01.zRot = 0F;
					this.LegRight02.z = (-3.0F) + (0.375F) * 16F;
					this.LegRight02.xRot = 2.45F;
					this.LegRight02.zRot = -0.0175F;
		    	}
	  		}//end if sitting
	    }
	    
	    //攻擊動作    
	    if (ent.getAttackTick() > 30)
	    {
	    	setFaceAttack(ent);
	    	//arm
		    this.ArmLeft01.xRot = -1.55F;
	    	this.ArmLeft01.yRot = 0.3F;
	    	this.ArmLeft01.zRot = 0F;
	    	this.ArmLeft02.xRot = 0F;
	    	this.ArmLeft02.zRot = 0.7F;
	    	this.ArmRight01.xRot = -1.7F;
	    	this.ArmRight01.yRot = -0.1F;
	    	this.ArmRight01.zRot = 1.5F;
	    	this.ArmRight02.xRot = 0F;
	    	this.ArmRight02.zRot = 0F;
	    }
	    
	    //swing arm
	  	float f6 = ent.getSwingTime(f2 - (int)f2);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight01.xRot += -f8 * 80.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.yRot += -f7 * 20.0F * Values.N.DIV_PI_180 + 0.2F;
	        this.ArmRight01.zRot += -f8 * 20.0F * Values.N.DIV_PI_180;
	  	}
	  	
	  	//caress
	  	if (ent.getStateEmotion(ID.S.Emotion3) == ID.Emotion3.CARESS)
	  	{
	  		setFaceShy(ent);
	  		//body
	  		this.Head.xRot += 0.6F;
	  		//arm
		    this.ArmLeft01.xRot = -0.44F;
	    	this.ArmLeft01.yRot = 0F;
	    	this.ArmLeft01.zRot = 0.4F;
	    	this.ArmLeft02.zRot = 0F;
	    	this.ArmLeft02.x = (3.5F) + (0F) * 16F;
	    	this.ArmRight01.xRot = -0.4F;
	    	this.ArmRight01.yRot = 0F;
	    	this.ArmRight01.zRot = -0.4F;
	    	this.ArmRight02.zRot = 0F;
	    	this.ArmRight02.x = (-3.5F) + (0F) * 16F;
	  	}
	  	
	  	//鬢毛調整
	    headX = this.Head.xRot * -0.5F;
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.xRot += headX;
	    this.Hair01.zRot += headZ;
	    this.Hair02a1.xRot += headX;
	  	this.Hair02a1.zRot += headZ;
	  	this.Hair02b1.xRot += headX;
	  	this.Hair02b1.zRot += headZ;
	  	this.Hair02c1.xRot += headX;
	  	this.Hair02c1.zRot += headZ;
	  	this.Hair02d1.xRot += headX;
	  	this.Hair02d1.zRot += headZ;
	  	this.Hair02e1.xRot += headX;
	  	this.Hair02e1.zRot += headZ;
	  	this.HairL01.zRot += headZ;
	  	this.HairL02.zRot += headZ;
	  	this.HairR01.zRot += headZ;
	  	this.HairR02.zRot += headZ * 2F;
		this.HairL01.xRot += headX;
	  	this.HairL02.xRot += headX;
	  	this.HairR01.xRot += headX;
	  	this.HairR02.xRot += headX;
	    
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
    	
    	switch (((IShipEmotion)entity).getScaleLevel())
    	{
    	case 3:
    		scale = 1.6F;
        	offsetY = -0.53F;
		break;
    	case 2:
    		scale = 1.2F;
        	offsetY = -0.23F;
		break;
    	case 1:
    		scale = 0.8F;
        	offsetY = 0.41F;
		break;
    	default:
    		scale = 0.4F;
        	offsetY = 2.28F;
		break;
    	}
    	
    	
    	RenderHelper.animScale(this, scale, scale, scale);
this.animTransX += (0F); this.animTransY += (offsetY); this.animTransZ += (0F);
    	
    	//main body
		super.setupAnim(entity, f, f1, f2, f3, f4);
	}

}

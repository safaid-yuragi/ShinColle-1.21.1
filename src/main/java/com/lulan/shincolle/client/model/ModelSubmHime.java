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

public class ModelSubmHime<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart Butt;
	public ModelPart ArmRight01;
	public ModelPart ArmLeft01;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart EquipBack;
	public ModelPart Head;
	public ModelPart Collar01;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Ahoke01;
	public ModelPart Ahoke01a;
	public ModelPart HairU01;
	public ModelPart HairR01;
	public ModelPart HairL01;
	public ModelPart HairR02;
	public ModelPart HairL02;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart Hair03;
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
	public ModelPart Collar02;
	public ModelPart Collar03;
	public ModelPart Collar04;
	public ModelPart Collar05;
	public ModelPart Collar05a;
	public ModelPart Collar05b;
	public ModelPart LegLeft01;
	public ModelPart Skirt01;
	public ModelPart LegRight01;
	public ModelPart LegLeft02;
	public ModelPart Skirt02;
	public ModelPart LegRight02;
	public ModelPart ArmRight02;
	public ModelPart ArmLeft02;
	public ModelPart EquipTube00;
	public ModelPart EquipTube00_1;
	public ModelPart EquipTube01;
	public ModelPart EquipTube01a;
	public ModelPart EquipTube02;
	public ModelPart EquipTube02a;
	public ModelPart EquipTube03;
	public ModelPart EquipTube03a;
	public ModelPart EquipTube04;
	public ModelPart EquipTube04a;
	public ModelPart EquipTube05;
	public ModelPart EquipTube05a;
	public ModelPart EquipTBase;
	public ModelPart EquipT01;
	public ModelPart EquipT02;
	public ModelPart EquipT03;
	public ModelPart EquipT04;
	public ModelPart EquipT05;
	public ModelPart EquipT06;
	public ModelPart EquipT07;
	public ModelPart EquipT02a;
	public ModelPart EquipT02b;
	public ModelPart EquipT02c;
	public ModelPart EquipT02d;
	public ModelPart EquipTJaw01;
	public ModelPart EquipTJaw02;
	public ModelPart EquipTEyeA;
	public ModelPart EquipTEyeB;
	public ModelPart EquipTube01_1;
	public ModelPart EquipTube01a_1;
	public ModelPart EquipTube02_1;
	public ModelPart EquipTube02a_1;
	public ModelPart EquipTube03_1;
	public ModelPart EquipTube03a_1;
	public ModelPart EquipTube04_1;
	public ModelPart EquipTube04a_1;
	public ModelPart EquipTube05_1;
	public ModelPart EquipTube05a_1;
	public ModelPart EquipTBase_1;
	public ModelPart EquipT01_1;
	public ModelPart EquipT03_1;
	public ModelPart EquipT05_1;
	public ModelPart EquipT06_1;
	public ModelPart EquipT07_1;
	public ModelPart EquipT02_1;
	public ModelPart EquipT04_1;
	public ModelPart EquipT02a_1;
	public ModelPart EquipT02b_1;
	public ModelPart EquipT02c_1;
	public ModelPart EquipT02d_1;
	public ModelPart EquipTJaw01_1;
	public ModelPart EquipTJaw02_1;
	public ModelPart EquipTEyeA_1;
	public ModelPart EquipTEyeB_1;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ModelPart GlowEquipBase;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-3.2F, -8.5F, -3.8F, -0.8726646259971648F, 0.08726646259971647F, 0.06981317007977318F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().mirror().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.0F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("ArmRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(-3.0F, 11.0F, 2.5F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -8.5F, 17.0F, 5.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 1.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-10.5F, 0.0F, -6.5F, 21.0F, 5.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 3.5F, -2.7F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef4.addOrReplaceChild("LegRight01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.19198621771937624F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("LegRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(-3.0F, 14.0F, -3.0F));
		PartDefinition partdef9 = partdef4.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.296705972839036F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("LegLeft02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(3.0F, 14.0F, -3.0F));
		PartDefinition partdef11 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.20943951023931953F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(3.0F, 11.0F, 2.5F));
		PartDefinition partdef13 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-2.5F, -3.0F, -2.9F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -9.6F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("Collar01", CubeListBuilder.create().addBox(-6.0F, -2.0F, -4.0F, 12.0F, 3.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -1.1F, -1.2F, 0.03490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("Collar02", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -0.6F, -3.2F, -0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("Collar03", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 3.5F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("Collar04", CubeListBuilder.create().addBox(-0.5F, 0.0F, -1.0F, 1.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.4553564018453205F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("Collar05", CubeListBuilder.create().addBox(-2.5F, 0.0F, -1.0F, 5.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 4.0F, -0.2F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("Collar05a", CubeListBuilder.create().addBox(0.0F, -2.0F, -0.5F, 3.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(2.5F, 2.0F, 0.0F, 0.0F, -0.08726646259971647F, -0.3490658503988659F));
		PartDefinition partdef20 = partdef18.addOrReplaceChild("Collar05b", CubeListBuilder.create().addBox(-3.0F, -2.0F, -0.5F, 3.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(-2.5F, 2.0F, 0.0F, 0.0F, 0.08726646259971647F, 0.3490658503988659F));
		PartDefinition partdef21 = partdef13.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("Ahoke01a", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -15.0F, -1.5F, -2.2689280275926285F, -2.6179938779914944F, 0.0F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("Ahoke02a", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.7853981633974483F, -0.05235987755982988F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("Ahoke03a", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 1.0471975511965976F, 0.05235987755982988F, 0.0F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("Ahoke04a", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.4886921905584123F, 0.05235987755982988F, 0.0F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("Ahoke05a", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, -0.2617993877991494F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("Ahoke06a", CubeListBuilder.create().mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, -0.5235987755982988F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef28 = partdef21.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 17.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("Hair03", CubeListBuilder.create().addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 12.5F, -0.1F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef32 = partdef21.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.1F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(-7.0F, 3.0F, -5.5F, -0.19198621771937624F, 0.17453292519943295F, 0.08726646259971647F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(0.2F, 10.0F, 0.0F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef35 = partdef32.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(7.0F, 3.0F, -5.5F, -0.19198621771937624F, -0.17453292519943295F, -0.08726646259971647F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef37 = partdef32.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -7.0F));
		PartDefinition partdef38 = partdef21.addOrReplaceChild("Ahoke01", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, -15.0F, 0.0F, -2.007128639793479F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("Ahoke02", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, 1.0471975511965976F, -0.05235987755982988F, 0.0F));
		PartDefinition partdef40 = partdef39.addOrReplaceChild("Ahoke03", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, 0.7853981633974483F, 0.05235987755982988F, 0.0F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("Ahoke04", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.4363323129985824F, 0.05235987755982988F, 0.0F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("Ahoke05", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.9F, 0.0F, -0.17453292519943295F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("Ahoke06", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, -0.4363323129985824F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef44 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(3.2F, -8.5F, -3.7F, -0.8726646259971648F, -0.08726646259971647F, -0.06981317007977318F));
		PartDefinition partdef45 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.6F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef49 = partdef47.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef50 = partdef47.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef51 = partdef47.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef52 = partdef47.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef53 = partdef47.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef54 = partdef47.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef55 = partdef47.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef56 = partdef47.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef57 = partdef47.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));
		PartDefinition partdef58 = partdef45.addOrReplaceChild("EquipBack", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -0.7F, 4.4F, -0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef59 = partdef45.addOrReplaceChild("GlowEquipBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, 8.0F, 3.0F));
		PartDefinition partdef60 = partdef59.addOrReplaceChild("EquipTube00", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(0.5F, 3.0F, 1.4F, 0.2617993877991494F, 0.61F, 0.0F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("EquipTube01", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.5F, 0.0F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("EquipTube02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.0F, -1.0F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("EquipTube03", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.6108652381980153F, 0.0F, 0.0F));
		PartDefinition partdef64 = partdef63.addOrReplaceChild("EquipTube04", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef65 = partdef64.addOrReplaceChild("EquipTube05", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.6108652381980153F, 0.0F, 0.0F));
		PartDefinition partdef66 = partdef65.addOrReplaceChild("EquipTube05a", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef67 = partdef66.addOrReplaceChild("EquipTBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 26.0F, 1.0F, 0F, 0.61F, 0.0F));
		PartDefinition partdef68 = partdef67.addOrReplaceChild("EquipT01", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F), PartPose.offset(0.0F, -19.0F, 0.0F));
		PartDefinition partdef69 = partdef67.addOrReplaceChild("EquipT07", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 4.0F), PartPose.offset(0.0F, 24.7F, 0.0F));
		PartDefinition partdef70 = partdef67.addOrReplaceChild("EquipT02", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(0.0F, -16.0F, 0.0F));
		PartDefinition partdef71 = partdef70.addOrReplaceChild("EquipT02c", CubeListBuilder.create().addBox(0.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 5.9F, 0.0F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef72 = partdef70.addOrReplaceChild("EquipT02a", CubeListBuilder.create().addBox(0.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F), PartPose.offset(2.9F, 0.5F, 0.0F));
		PartDefinition partdef73 = partdef70.addOrReplaceChild("EquipT02d", CubeListBuilder.create().addBox(0.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.5F, -5.9F, 0.0F, -1.5707963267948966F, 0.0F));
		PartDefinition partdef74 = partdef70.addOrReplaceChild("EquipT02b", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F), PartPose.offset(-2.9F, 0.5F, 0.0F));
		PartDefinition partdef75 = partdef67.addOrReplaceChild("EquipT04", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition partdef76 = partdef75.addOrReplaceChild("EquipTEyeB", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-3.2F, 10.9F, 3.0F, -2.0943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef77 = partdef75.addOrReplaceChild("EquipTJaw01", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 6.3F, 0.5F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef78 = partdef75.addOrReplaceChild("EquipTJaw02", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -2.5F, 7.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 4.6F, 1.0F, 1.48352986419518F, 0.0F, 3.141592653589793F));
		PartDefinition partdef79 = partdef75.addOrReplaceChild("EquipTEyeA", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(3.2F, 10.9F, 3.0F, -2.0943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef80 = partdef67.addOrReplaceChild("EquipT06", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 1.0F, 5.0F), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition partdef81 = partdef67.addOrReplaceChild("EquipT03", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(0.0F, -6.0F, 0.0F));
		PartDefinition partdef82 = partdef67.addOrReplaceChild("EquipT05", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(0.0F, 14.0F, 0.0F));
		PartDefinition partdef83 = partdef64.addOrReplaceChild("EquipTube04a", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef84 = partdef63.addOrReplaceChild("EquipTube03a", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef85 = partdef62.addOrReplaceChild("EquipTube02a", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef86 = partdef61.addOrReplaceChild("EquipTube01a", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef87 = partdef59.addOrReplaceChild("EquipTube00_1", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(-0.5F, 3.0F, 1.4F, 0.2617993877991494F, -0.61F, 0.0F));
		PartDefinition partdef88 = partdef87.addOrReplaceChild("EquipTube01_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.5F, 0.0F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef89 = partdef88.addOrReplaceChild("EquipTube01a_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef90 = partdef88.addOrReplaceChild("EquipTube02_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.0F, -1.0F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef91 = partdef90.addOrReplaceChild("EquipTube03_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.6108652381980153F, 0.0F, 0.0F));
		PartDefinition partdef92 = partdef91.addOrReplaceChild("EquipTube03a_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef93 = partdef91.addOrReplaceChild("EquipTube04_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef94 = partdef93.addOrReplaceChild("EquipTube04a_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef95 = partdef93.addOrReplaceChild("EquipTube05_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.6108652381980153F, 0.0F, 0.0F));
		PartDefinition partdef96 = partdef95.addOrReplaceChild("EquipTube05a_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef97 = partdef96.addOrReplaceChild("EquipTBase_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 26.0F, 1.0F, 0F, -0.61F, 0F));
		PartDefinition partdef98 = partdef97.addOrReplaceChild("EquipT05_1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(0.0F, 14.0F, 0.0F));
		PartDefinition partdef99 = partdef97.addOrReplaceChild("EquipT04_1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition partdef100 = partdef99.addOrReplaceChild("EquipTJaw01_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 6.3F, 0.5F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef101 = partdef99.addOrReplaceChild("EquipTJaw02_1", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -2.5F, 7.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 4.6F, 1.0F, 1.48352986419518F, 0.0F, 3.141592653589793F));
		PartDefinition partdef102 = partdef99.addOrReplaceChild("EquipTEyeB_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-3.2F, 10.9F, 3.0F, -2.0943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef103 = partdef99.addOrReplaceChild("EquipTEyeA_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(3.2F, 10.9F, 3.0F, -2.0943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef104 = partdef97.addOrReplaceChild("EquipT07_1", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 4.0F), PartPose.offset(0.0F, 24.7F, 0.0F));
		PartDefinition partdef105 = partdef97.addOrReplaceChild("EquipT01_1", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F), PartPose.offset(0.0F, -19.0F, 0.0F));
		PartDefinition partdef106 = partdef97.addOrReplaceChild("EquipT02_1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(0.0F, -16.0F, 0.0F));
		PartDefinition partdef107 = partdef106.addOrReplaceChild("EquipT02a_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F), PartPose.offset(2.9F, 0.5F, 0.0F));
		PartDefinition partdef108 = partdef106.addOrReplaceChild("EquipT02b_1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F), PartPose.offset(-2.9F, 0.5F, 0.0F));
		PartDefinition partdef109 = partdef106.addOrReplaceChild("EquipT02c_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 5.9F, 0.0F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef110 = partdef106.addOrReplaceChild("EquipT02d_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -0.5F, 3.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.5F, -5.9F, 0.0F, -1.5707963267948966F, 0.0F));
		PartDefinition partdef111 = partdef97.addOrReplaceChild("EquipT03_1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(0.0F, -6.0F, 0.0F));
		PartDefinition partdef112 = partdef97.addOrReplaceChild("EquipT06_1", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 1.0F, 5.0F), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition partdef113 = partdef90.addOrReplaceChild("EquipTube02a_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelSubmHime(ModelPart root)
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
		this.EquipTJaw01_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT04_1").getChild("EquipTJaw01_1");
		this.EquipT05_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT05_1");
		this.EquipTube05a = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a");
		this.EquipTJaw02_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT04_1").getChild("EquipTJaw02_1");
		this.EquipT01 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT01");
		this.HairR02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.Ahoke06a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01a").getChild("Ahoke02a").getChild("Ahoke03a").getChild("Ahoke04a").getChild("Ahoke05a").getChild("Ahoke06a");
		this.EquipT04_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT04_1");
		this.EquipT02c = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT02").getChild("EquipT02c");
		this.EquipTEyeB_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT04_1").getChild("EquipTEyeB_1");
		this.EquipTube03a_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube03a_1");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.EquipTube02 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02");
		this.Ahoke05a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01a").getChild("Ahoke02a").getChild("Ahoke03a").getChild("Ahoke04a").getChild("Ahoke05a");
		this.Ahoke01a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01a");
		this.EquipTBase_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1");
		this.EquipT02a = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT02").getChild("EquipT02a");
		this.EquipTube00_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.EquipTube05a_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1");
		this.EquipT02a_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT02_1").getChild("EquipT02a_1");
		this.Hair03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02").getChild("Hair03");
		this.EquipT07_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT07_1");
		this.EquipT01_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT01_1");
		this.EquipTEyeB = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT04").getChild("EquipTEyeB");
		this.EquipT02b_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT02_1").getChild("EquipT02b_1");
		this.EquipT02_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT02_1");
		this.EquipTJaw01 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT04").getChild("EquipTJaw01");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.EquipT02d = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT02").getChild("EquipT02d");
		this.Ahoke04a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01a").getChild("Ahoke02a").getChild("Ahoke03a").getChild("Ahoke04a");
		this.EquipTBase = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase");
		this.Collar05 = root.getChild("BodyMain").getChild("Neck").getChild("Collar01").getChild("Collar02").getChild("Collar03").getChild("Collar04").getChild("Collar05");
		this.EquipT07 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT07");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.EquipBack = root.getChild("GlowBodyMain").getChild("EquipBack");
		this.EquipTube04a_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube04a_1");
		this.EquipT02 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT02");
		this.Collar01 = root.getChild("BodyMain").getChild("Neck").getChild("Collar01");
		this.EquipTube04 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04");
		this.EquipT03_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT03_1");
		this.EquipT02c_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT02_1").getChild("EquipT02c_1");
		this.EquipTube01a_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube01a_1");
		this.EquipTube03 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03");
		this.EquipTEyeA_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT04_1").getChild("EquipTEyeA_1");
		this.EquipT06_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT06_1");
		this.EquipTube00 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00");
		this.EquipT04 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT04");
		this.EquipTube04_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1");
		this.Collar04 = root.getChild("BodyMain").getChild("Neck").getChild("Collar01").getChild("Collar02").getChild("Collar03").getChild("Collar04");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.EquipTube01a = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube01a");
		this.Ahoke06 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01").getChild("Ahoke02").getChild("Ahoke03").getChild("Ahoke04").getChild("Ahoke05").getChild("Ahoke06");
		this.Ahoke03a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01a").getChild("Ahoke02a").getChild("Ahoke03a");
		this.EquipTube03_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1");
		this.Ahoke04 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01").getChild("Ahoke02").getChild("Ahoke03").getChild("Ahoke04");
		this.BodyMain = root.getChild("BodyMain");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.EquipTube03a = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube03a");
		this.EquipT02b = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT02").getChild("EquipT02b");
		this.EquipTJaw02 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT04").getChild("EquipTJaw02");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.HairL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.Ahoke03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01").getChild("Ahoke02").getChild("Ahoke03");
		this.Ahoke05 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01").getChild("Ahoke02").getChild("Ahoke03").getChild("Ahoke04").getChild("Ahoke05");
		this.Collar03 = root.getChild("BodyMain").getChild("Neck").getChild("Collar01").getChild("Collar02").getChild("Collar03");
		this.Collar05a = root.getChild("BodyMain").getChild("Neck").getChild("Collar01").getChild("Collar02").getChild("Collar03").getChild("Collar04").getChild("Collar05").getChild("Collar05a");
		this.EquipT06 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT06");
		this.Ahoke02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01").getChild("Ahoke02");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.EquipTube05_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1");
		this.Ahoke02a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01a").getChild("Ahoke02a");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.EquipTube01_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1");
		this.EquipTube02a = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube02a");
		this.EquipTube05 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05");
		this.EquipTEyeA = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT04").getChild("EquipTEyeA");
		this.EquipTube04a = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube04a");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.EquipT03 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT03");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.Collar02 = root.getChild("BodyMain").getChild("Neck").getChild("Collar01").getChild("Collar02");
		this.EquipTube02a_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube02a_1");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.HairU01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairU01");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.EquipT02d_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1").getChild("EquipTube03_1").getChild("EquipTube04_1").getChild("EquipTube05_1").getChild("EquipTube05a_1").getChild("EquipTBase_1").getChild("EquipT02_1").getChild("EquipT02d_1");
		this.EquipTube01 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01");
		this.Collar05b = root.getChild("BodyMain").getChild("Neck").getChild("Collar01").getChild("Collar02").getChild("Collar03").getChild("Collar04").getChild("Collar05").getChild("Collar05b");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.EquipT05 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00").getChild("EquipTube01").getChild("EquipTube02").getChild("EquipTube03").getChild("EquipTube04").getChild("EquipTube05").getChild("EquipTube05a").getChild("EquipTBase").getChild("EquipT05");
		this.EquipTube02_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipTube00_1").getChild("EquipTube01_1").getChild("EquipTube02_1");
		this.Ahoke01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.GlowEquipBase = root.getChild("GlowBodyMain").getChild("GlowEquipBase");
		this.scale = 0.48F;
		this.offsetY = 1.62F;
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
		poseStack.pushPose();
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
		
		boolean flag = !EmotionHelper.checkModelState(1, state);
		this.Collar01.visible = !(flag);
	
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

this.animTransX += (0F); this.animTransY += (0.62F); this.animTransZ += (0F);
  		this.setFaceHungry(ent);

  	    //頭部
	  	this.Head.xRot = -0.15F;
	  	this.Head.yRot = 0F;
	  	this.Head.zRot = 0F;
	    //胸部
  	    this.BoobL.xRot = -0.76F;
  	    this.BoobR.xRot = -0.76F;
	  	//Body
	  	this.BodyMain.xRot = 1.6F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 1.2F;
	  	this.Butt.y = (4.0F) + (-0.2F) * 16F;
	  	this.Butt.z = (1.3F) + (-0.14F) * 16F;
	  	this.Skirt01.xRot = -0.94F;
	  	this.Skirt01.y = (3.0F) + (0.09F) * 16F;
	  	this.Skirt01.z = (1.5F) + (-0.03F) * 16F;
	  	this.Skirt02.xRot = -0.3F;
	  	//hair
	  	this.Hair01.xRot = 0.35F;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -0.2F;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -0.35F;
	  	this.Hair03.zRot = 0F;
	  	this.HairL01.xRot = -0.14F;
	  	this.HairL02.xRot = 0.17F;
	  	this.HairR01.xRot = -0.14F;
	  	this.HairR02.xRot = 0.17F;
	    //arm 
	  	this.ArmLeft01.xRot = -2.9F;
	  	this.ArmLeft01.yRot = -0.6981F;
	    this.ArmLeft01.zRot = 0.08F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.yRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmRight01.xRot = -2.9F;
	  	this.ArmRight01.yRot = 0.6981F;
	    this.ArmRight01.zRot = -0.08F;
	    this.ArmRight02.xRot = 0F;
	    this.ArmRight02.yRot = 0F;
	    this.ArmRight02.zRot = 0F;
		//leg
    	this.LegLeft01.xRot = -1.9F;
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.05F;
		this.LegLeft02.xRot = 0.64F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.xRot = -1.9F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.05F;
		this.LegRight02.xRot = 0.64F;
		this.LegRight02.y = (14.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		//tails
		this.GlowEquipBase.visible = false;
	
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
  		float addHL1 = 0F;
  		float addHR1 = 0F;
  		float addHL2 = 0F;
  		float addHR2 = 0F;
  		int state = ent.getStateEmotion(ID.S.State);
  		boolean collar = EmotionHelper.checkModelState(1, state);
  		boolean tails = EmotionHelper.checkModelState(2, state);
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.025F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//leg move parm
  		addk1 = angleAdd1 * 0.6F - 0.3F;
	  	addk2 = angleAdd2 * 0.6F - 0.2F;

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
	  	this.BodyMain.xRot = -0.1047F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.35F;
    	this.Butt.y = (4.0F) + (0F) * 16F;
    	this.Butt.z = (1.3F) + (0F) * 16F;
    	this.BoobL.xRot = angleX * 0.06F - 0.76F;
    	this.BoobL.yRot = -0.087F;
    	this.BoobL.zRot = -0.07F;
  	    this.BoobR.xRot = angleX * 0.06F - 0.76F;
  	    this.BoobR.yRot = 0.087F;
  	    this.BoobR.zRot = 0.07F;
  	    
    	if (collar)
    	{
    		this.BoobL.x = (3.2F) + (0F) * 16F;
    		this.BoobR.x = (-3.2F) + (0F) * 16F;
    	}
    	else
    	{
    		this.BoobL.x = (3.2F) + (-0.05F) * 16F;
    		this.BoobR.x = (-3.2F) + (0.05F) * 16F;
    	}
    	
    	this.Collar01.xRot = 0.035F;
  	    this.Collar03.xRot = angleX * 0.08F + 0.26F;
  	    this.Collar04.xRot = -angleX * 0.08F + 0.45F;
    	//cloth
	  	this.Skirt01.xRot = -0.087F;
	  	this.Skirt01.y = (3.0F) + (0F) * 16F;
	  	this.Skirt01.z = (1.5F) + (0F) * 16F;
	  	this.Skirt02.xRot = -0.087F;
	  	this.Skirt02.y = (3.5F) + (0F) * 16F;
	  	this.Skirt02.z = (-2.7F) + (0F) * 16F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.03F + 0.26F + headX;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -angleX1 * 0.04F - 0.087F + headX;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -angleX2 * 0.07F - 0.052F;
	  	this.Hair03.zRot = 0F;
	    //arm 
	  	this.ArmLeft01.xRot = angleAdd2 * 0.8F - 0.05F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = angleX * 0.025F - 0.3F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.yRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    this.ArmRight01.xRot = angleAdd1 * 0.8F + 0.26F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -angleX * 0.025F + 0.3F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.yRot = 0F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
	    this.ArmRight02.z = (2.5F) + (0F) * 16F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.087F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (3.0F) + (0F) * 16F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.087F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.x = (-3.0F) + (0F) * 16F;
		this.LegRight02.y = (14.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		//tails
		if (tails)
		{
			this.EquipTBase.visible = false;
			this.EquipTBase_1.visible = false;
			this.GlowEquipBase.xRot = 0.3F;
			this.EquipTube00.xRot = 0.2618F;
			this.EquipTube00.yRot = Mth.cos(-f2 * 0.1F + 0.7F) * 0.1F + 0.61F;
			this.EquipTube00.zRot = this.EquipTube00.yRot * 0.125F;
			this.EquipTube01.xRot = 0.35F;
			this.EquipTube01.yRot = Mth.cos(-f2 * 0.1F + 1.4F) * 0.125F;
			this.EquipTube01.zRot = this.EquipTube01.yRot * 0.125F;
			this.EquipTube02.xRot = 0.5235F;
			this.EquipTube02.yRot = Mth.cos(-f2 * 0.1F + 2.1F) * 0.15F;
			this.EquipTube02.zRot = this.EquipTube02.yRot * 0.125F;
			this.EquipTube03.xRot = 0.61F;
			this.EquipTube03.yRot = Mth.cos(-f2 * 0.1F + 2.8F) * 0.175F;
			this.EquipTube03.zRot = this.EquipTube03.yRot * 0.125F;
			this.EquipTube04.xRot = 0.6981F;
			this.EquipTube04.yRot = Mth.cos(-f2 * 0.1F + 3.5F) * 0.2F;
			this.EquipTube04.zRot = this.EquipTube04.yRot * 0.125F;
			this.EquipTube05.xRot = 0.61F;
			this.EquipTube05.yRot = Mth.cos(-f2 * 0.1F + 4.2F) * 0.175F;
			this.EquipTube05.zRot = this.EquipTube05.yRot * 0.125F;
			this.EquipTube00_1.xRot = this.EquipTube00.xRot;
			this.EquipTube00_1.yRot = -this.EquipTube00.yRot;
			this.EquipTube00_1.zRot = this.EquipTube00.zRot;
			this.EquipTube01_1.xRot = this.EquipTube01.xRot;
			this.EquipTube01_1.yRot = this.EquipTube01.yRot;
			this.EquipTube01_1.zRot = this.EquipTube01.zRot;
			this.EquipTube02_1.xRot = this.EquipTube02.xRot;
			this.EquipTube02_1.yRot = this.EquipTube02.yRot;
			this.EquipTube02_1.zRot = this.EquipTube02.zRot;
			this.EquipTube03_1.xRot = this.EquipTube03.xRot;
			this.EquipTube03_1.yRot = this.EquipTube03.yRot;
			this.EquipTube03_1.zRot = this.EquipTube03.zRot;
			this.EquipTube04_1.xRot = this.EquipTube04.xRot;
			this.EquipTube04_1.yRot = this.EquipTube04.yRot;
			this.EquipTube04_1.zRot = this.EquipTube04.zRot;
			this.EquipTube05_1.xRot = this.EquipTube05.xRot;
			this.EquipTube05_1.yRot = this.EquipTube05.yRot;
			this.EquipTube05_1.zRot = this.EquipTube05.zRot;
		}
		
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
				  	this.Hair03.xRot -= 0.2F;
	    		}
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.06F); this.animTransZ += (0F);
	    		this.Head.xRot -= 1.1F;
	    		this.Hair01.xRot += 0.6F;
			  	this.Hair02.xRot += 0.5F;
			  	this.Hair03.xRot += 0.2F;
			  	this.Ahoke01.xRot += 0.38F;
			  	this.Ahoke01.yRot = 0.7F;
			  	this.Ahoke01.zRot = 0.4F;
			  	this.Ahoke01a.yRot = -2.5F;
			  	this.Ahoke01a.zRot = -0.2F;
	    	}
	    	
		    //body
	    	this.BodyMain.xRot = 1.2566F;
		  	//胸部
	  	    this.BoobL.xRot = angleAdd2 * 0.1F - 0.83F;
	  	    this.BoobL.zRot = -0.07F;
	  	    this.BoobR.xRot = angleAdd2 * 0.1F - 0.83F;
	  	    this.BoobR.zRot = 0.07F;
	  	    this.Collar03.xRot += angleAdd2 * 0.1F;
	  	    this.Collar04.xRot += angleAdd2 * 0.1F;
	    	//arm
	    	this.ArmLeft01.xRot = -2.7F;
		    this.ArmLeft01.zRot = -0.22F;
		    this.ArmRight01.xRot = -2.7F;
		    this.ArmRight01.zRot = 0.22F;
		    //leg
		    this.LegLeft01.zRot = 0.05F;
		  	this.LegRight01.zRot = -0.05F;
		  	//tails
			if (tails)
			{
				this.EquipTBase.visible = false;
				this.EquipTBase_1.visible = false;
				this.GlowEquipBase.xRot = 0.3F;
				this.EquipTube00.xRot = Mth.cos(-f2 * 0.4F + 0.7F) * 0.1F + 0.4F;
				this.EquipTube00.yRot = Mth.cos(-f2 * 0.4F + 0.7F) * 0.1F + 0.9F;
				this.EquipTube00.zRot = this.EquipTube00.yRot * 0.125F;
				this.EquipTube01.xRot = Mth.cos(-f2 * 0.4F + 1.4F) * 0.125F;
				this.EquipTube01.yRot = Mth.cos(-f2 * 0.4F + 1.4F) * 0.125F;
				this.EquipTube01.zRot = this.EquipTube01.yRot * 0.125F;
				this.EquipTube02.xRot = Mth.cos(-f2 * 0.4F + 2.1F) * 0.15F;
				this.EquipTube02.yRot = Mth.cos(-f2 * 0.4F + 2.1F) * 0.15F;
				this.EquipTube02.zRot = this.EquipTube02.yRot * 0.125F;
				this.EquipTube03.xRot = Mth.cos(-f2 * 0.4F + 2.8F) * 0.175F;
				this.EquipTube03.yRot = Mth.cos(-f2 * 0.4F + 2.8F) * 0.175F;
				this.EquipTube03.zRot = this.EquipTube03.yRot * 0.125F;
				this.EquipTube04.xRot = Mth.cos(-f2 * 0.4F + 3.5F) * 0.2F;
				this.EquipTube04.yRot = Mth.cos(-f2 * 0.4F + 3.5F) * 0.2F;
				this.EquipTube04.zRot = this.EquipTube04.yRot * 0.125F;
				this.EquipTube05.xRot = Mth.cos(-f2 * 0.4F + 4.2F) * 0.175F;
				this.EquipTube05.yRot = Mth.cos(-f2 * 0.4F + 4.2F) * 0.175F;
				this.EquipTube05.zRot = this.EquipTube05.yRot * 0.125F;
				this.EquipTube00_1.xRot = this.EquipTube00.xRot;
				this.EquipTube00_1.yRot = -this.EquipTube00.yRot;
				this.EquipTube00_1.zRot = -this.EquipTube00.zRot;
				this.EquipTube01_1.xRot = this.EquipTube01.xRot;
				this.EquipTube01_1.yRot = this.EquipTube01.yRot;
				this.EquipTube01_1.zRot = this.EquipTube01.zRot;
				this.EquipTube02_1.xRot = this.EquipTube02.xRot;
				this.EquipTube02_1.yRot = this.EquipTube02.yRot;
				this.EquipTube02_1.zRot = this.EquipTube02.zRot;
				this.EquipTube03_1.xRot = this.EquipTube03.xRot;
				this.EquipTube03_1.yRot = this.EquipTube03.yRot;
				this.EquipTube03_1.zRot = this.EquipTube03.zRot;
				this.EquipTube04_1.xRot = this.EquipTube04.xRot;
				this.EquipTube04_1.yRot = this.EquipTube04.yRot;
				this.EquipTube04_1.zRot = this.EquipTube04.zRot;
				this.EquipTube05_1.xRot = this.EquipTube05.xRot;
				this.EquipTube05_1.yRot = this.EquipTube05.yRot;
				this.EquipTube05_1.zRot = this.EquipTube05.zRot;
			}
	    }
	    
	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    //潛行跟蹲下動作
	    if (ent.getIsSneaking())
	    {
this.animTransX += (0F); this.animTransY += (0.09F); this.animTransZ += (0F);
	    	
	    	//Body
	    	this.Head.xRot -= 0.6283F;
		  	this.BodyMain.xRot = 0.8727F;
		  	this.Skirt01.xRot = -0.34F;
		  	this.Skirt01.y = (3.0F) + (-0.2F) * 16F;
		  	this.Skirt01.z = (1.5F) + (0.03F) * 16F;
		  	this.Skirt02.xRot = -0.27F;
		  	this.Collar01.xRot -= 0.35F;
		  	this.Collar03.xRot -= 0.3F;
		  	this.Collar04.xRot -= 0.35F;
			//胸部
	  	    this.BoobL.xRot -= 0.2F;
	  	    this.BoobL.zRot = -0.04F;
	  	    this.BoobR.xRot -= 0.2F;
	  	    this.BoobR.zRot = 0.04F;
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
			this.Hair03.xRot -= 0.1F;
			//tails
			this.GlowEquipBase.xRot = -0.2F;
  		}//end if sneaking
  		
	    //坐下動作
	    if (ent.getIsSitting() && !ent.getIsRiding())
	    {
	    	if (ent.getTickExisted() % 512 > 256)
	    	{
	    		this.setFaceDamaged(ent);
this.animTransX += (0F); this.animTransY += (-angleX * 0.05F + 0.1F); this.animTransZ += (0F);
			    //body
		    	this.Head.xRot *= 0.5F;
		    	this.Head.yRot *= 0.75F;
			    this.Head.xRot += 0.5F;
		    	this.BodyMain.xRot = 1.6F;
		    	this.Skirt01.xRot = -0.33F;
		    	this.Skirt01.y = (3.0F) + (-0.23F) * 16F;
		    	this.Skirt02.xRot = -0.12F;
		    	this.Skirt02.y = (3.5F) + (-0.16F) * 16F;
		    	this.Ahoke01.xRot += 0.38F;
			  	this.Ahoke01.yRot = 0.8F;
			  	this.Ahoke01.zRot = 0.4F;
			  	this.Hair01.xRot -= 0.2F;
		    	this.Hair02.xRot -= 0.25F;
		    	this.Hair03.xRot -= 0.3F;
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
this.animTransX += (0F); this.animTransY += (0.52F); this.animTransZ += (0F);
			    	
			    	this.setFaceDamaged(ent);
			    	
			    	//body
			    	this.Head.xRot = 0.4F;
			    	this.Skirt01.xRot = -0.64F;
			    	this.Skirt01.y = (3.0F) + (-0.17F) * 16F;
			    	this.Skirt01.z = (1.5F) + (0F) * 16F;
			    	this.Skirt02.xRot = 0.29F;
			    	this.Skirt02.y = (3.5F) + (-0.04F) * 16F;
			    	this.Skirt02.z = (-2.7F) + (0.02F) * 16F;
			    	this.Hair01.xRot -= 0.2F;
			    	this.Hair02.xRot -= 0.15F;
			    	this.Hair03.xRot -= 0.1F;
			    	this.Ahoke01.xRot -= 0.1F;
			    	//arm
			    	this.ArmLeft01.xRot = 0.4F;
			    	this.ArmLeft01.yRot = -2.96705972839036F;
			    	this.ArmLeft01.zRot = -2.62F;
			    	this.ArmLeft02.xRot = 0.0F;
			    	this.ArmLeft02.yRot = 0.0F;
			    	this.ArmLeft02.zRot = 1F;
			    	this.ArmLeft02.x = (3.0F) + (0F) * 16F;
			    	this.ArmLeft02.z = (2.5F) + (0F) * 16F;
			    	this.ArmRight01.xRot = 0.5235987755982988F;
			    	this.ArmRight01.yRot = 2.96705972839036F;
			    	this.ArmRight01.zRot = 2.62F;
			    	this.ArmRight02.xRot = 0.0F;
			    	this.ArmRight02.yRot = 0.0F;
			    	this.ArmRight02.zRot = -1F;
			    	this.ArmRight02.x = (-3.0F) + (0F) * 16F;
			    	this.ArmRight02.z = (2.5F) + (0F) * 16F;
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
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.495F); this.animTransZ += (0F);
	    	
			    	//body
			    	this.Head.xRot -= 0.7F;
			    	this.BodyMain.xRot = 0.35F;
			    	this.Hair01.xRot += 0.3F;
			    	this.Hair02.xRot += 0.3F;
			    	this.Hair03.xRot += 0.3F;
			    	this.Skirt01.xRot = -0.32F;
			    	this.Skirt01.y = (3.0F) + (-0.05F) * 16F;
			    	this.Skirt02.xRot = -0.21F;
			    	this.Collar01.xRot += 0.1F;
				  	this.Collar03.xRot += 0.1F;
			    	//arm
					this.ArmLeft01.xRot = -0.5235987755982988F;
					this.ArmLeft01.yRot = 0.0F;
					this.ArmLeft01.zRot = 0.3490658503988659F;
				    this.ArmLeft02.xRot = 0F;
				    this.ArmLeft02.zRot = 0F;
				    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
				    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
					this.ArmRight01.xRot = -0.5235987755982988F;
					this.ArmRight01.yRot = 0.0F;
					this.ArmRight01.zRot = -0.3490658503988659F;
					this.ArmRight02.xRot = 0F;
					this.ArmRight02.zRot = 0F;
					this.ArmRight02.x = (-3.0F) + (0F) * 16F;
					this.ArmRight02.z = (2.5F) + (0F) * 16F;
			    	//leg
			    	addk1 = -1.4486232791552935F;
			    	addk2 = -1.4486232791552935F;
					this.LegLeft01.yRot = -0.5235987755982988F;
					this.LegLeft01.zRot = -1.3962634015954636F;
					this.LegLeft02.xRot = 2.1816615649929116F;
					this.LegLeft02.yRot = 0.0F;
					this.LegLeft02.zRot = 0.0F;
					this.LegLeft02.x = (3.0F) + (0F) * 16F;
					this.LegLeft02.z = (-3.0F) + (0.37F) * 16F;
					this.LegRight01.yRot = 0.5235987755982988F;
					this.LegRight01.zRot = 1.3962634015954636F;
					this.LegRight02.xRot = 2.1816615649929116F;
					this.LegRight02.yRot = 0.0F;
					this.LegRight02.zRot = 0.0F;
					this.LegRight02.x = (-3.0F) + (0F) * 16F;
					this.LegRight02.z = (-3.0F) + (0.37F) * 16F;
		    	}
	    	}
  		}//end sitting
	    
	    //騎乘專屬坐騎動作
	    if (ent.getIsRiding())
	    {
	    	if (((Entity)ent).getVehicle() instanceof BasicEntityMount)
	    	{
	    		if (ent.getIsSitting())
	    		{
this.animTransX += (0F); this.animTransY += (0.4F); this.animTransZ += (0F);
			    	
			    	//body
			    	this.Head.xRot -= 0.7F;
			    	this.BodyMain.xRot = 0.35F;
			    	this.Hair01.xRot += 0.3F;
			    	this.Hair02.xRot += 0.3F;
			    	this.Hair03.xRot += 0.3F;
			    	this.Skirt01.xRot = -0.32F;
			    	this.Skirt01.y = (3.0F) + (-0.05F) * 16F;
			    	this.Skirt02.xRot = -0.21F;
			    	this.Collar01.xRot += 0.1F;
				  	this.Collar03.xRot += 0.1F;
			    	//arm
					this.ArmLeft01.xRot = -0.8F;
					this.ArmLeft01.yRot = 0.0F;
					this.ArmLeft01.zRot = -0.2F;
				    this.ArmLeft02.xRot = 0F;
				    this.ArmLeft02.zRot = 0F;
				    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
				    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
					this.ArmRight01.xRot = -0.8F;
					this.ArmRight01.yRot = 0.0F;
					this.ArmRight01.zRot = 0.2F;
					this.ArmRight02.xRot = 0F;
					this.ArmRight02.zRot = 0F;
					this.ArmRight02.x = (-3.0F) + (0F) * 16F;
					this.ArmRight02.z = (2.5F) + (0F) * 16F;
			    	//leg
			    	addk1 = -1.4486232791552935F;
			    	addk2 = -1.4486232791552935F;
					this.LegLeft01.yRot = -0.5235987755982988F;
					this.LegLeft01.zRot = -0.2F;
					this.LegLeft02.xRot = 0.8F;
					this.LegRight01.yRot = 0.5235987755982988F;
					this.LegRight01.zRot = 0.2F;
					this.LegRight02.xRot = 0.8F;
		    	}//end if sitting
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.22F); this.animTransZ += (0F);
				    //body
			    	this.Head.xRot *= 0.5F;
			    	this.Head.yRot *= 0.75F;
				    this.Head.xRot -= 1.0F;
			    	this.BodyMain.xRot = 1.0F;
			    	this.Skirt01.xRot = -0.33F;
			    	this.Skirt01.y = (3.0F) + (-0.23F) * 16F;
			    	this.Skirt02.xRot = -0.12F;
			    	this.Skirt02.y = (3.5F) + (-0.16F) * 16F;
			    	this.Collar01.xRot -= 0.5F;
				  	this.Collar03.xRot -= 0.5F;
				  	this.Collar04.xRot -= 0.5F;
			    	//hair
			    	this.Ahoke01.xRot += 0.38F;
				  	this.Ahoke01.yRot = 0.8F;
				  	this.Ahoke01.zRot = 0.4F;
				  	this.Hair01.xRot += 0.5F;
			    	this.Hair02.xRot += 0.65F;
			    	this.Hair03.xRot += 0.5F;
			    	addHL1 = -0.6F;
			    	addHR1 = -0.6F;
			    	addHL2 = -0.5F;
			    	addHR2 = -0.5F;
			    	//arm
			    	this.ArmLeft01.xRot = -1.4F;
			    	this.ArmLeft01.yRot = -0.0F;
			    	this.ArmRight01.xRot = -1.4F;
			    	this.ArmRight01.yRot = 0.0F;
				    //leg
				    addk1 = -1.7F;
			    	addk2 = -1.7F;
				    this.LegLeft01.yRot = -0.2F;
				  	this.LegRight01.yRot = 0.2F;
		    	}
	    	}//end ship mount
	    	//normal mount ex: cart
	    	else
	    	{
	    		if (ent.getIsSitting())
	    		{
	    			if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
			    	{
	    				this.setFaceDamaged(ent);
this.animTransX += (0F); this.animTransY += (-angleX * 0.05F + 0.1F); this.animTransZ += (0F);
	    			    //body
	    		    	this.Head.xRot *= 0.5F;
	    		    	this.Head.yRot *= 0.75F;
	    			    this.Head.xRot += 0.5F;
	    		    	this.BodyMain.xRot = 1.6F;
	    		    	this.Skirt01.xRot = -0.33F;
	    		    	this.Skirt01.y = (3.0F) + (-0.23F) * 16F;
	    		    	this.Skirt02.xRot = -0.12F;
	    		    	this.Skirt02.y = (3.5F) + (-0.16F) * 16F;
	    		    	this.Ahoke01.xRot += 0.38F;
	    			  	this.Ahoke01.yRot = 0.8F;
	    			  	this.Ahoke01.zRot = 0.4F;
	    			  	this.Hair01.xRot -= 0.2F;
	    		    	this.Hair02.xRot -= 0.25F;
	    		    	this.Hair03.xRot -= 0.3F;
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
this.animTransX += (0F); this.animTransY += (0.52F); this.animTransZ += (0F);
				    	
				    	this.setFaceDamaged(ent);
				    	
				    	//body
				    	this.Head.xRot = 0.4F;
				    	this.Skirt01.xRot = -0.64F;
				    	this.Skirt01.y = (3.0F) + (-0.17F) * 16F;
				    	this.Skirt01.z = (1.5F) + (0F) * 16F;
				    	this.Skirt02.xRot = 0.29F;
				    	this.Skirt02.y = (3.5F) + (-0.04F) * 16F;
				    	this.Skirt02.z = (-2.7F) + (0.02F) * 16F;
				    	this.Hair01.xRot -= 0.2F;
				    	this.Hair02.xRot -= 0.15F;
				    	this.Hair03.xRot -= 0.1F;
				    	this.Ahoke01.xRot -= 0.1F;
				    	//arm
				    	this.ArmLeft01.xRot = 0.4F;
				    	this.ArmLeft01.yRot = -2.96705972839036F;
				    	this.ArmLeft01.zRot = -2.62F;
				    	this.ArmLeft02.xRot = 0.0F;
				    	this.ArmLeft02.yRot = 0.0F;
				    	this.ArmLeft02.zRot = 1F;
				    	this.ArmLeft02.x = (3.0F) + (0F) * 16F;
				    	this.ArmLeft02.z = (2.5F) + (0F) * 16F;
				    	this.ArmRight01.xRot = 0.5235987755982988F;
				    	this.ArmRight01.yRot = 2.96705972839036F;
				    	this.ArmRight01.zRot = 2.62F;
				    	this.ArmRight02.xRot = 0.0F;
				    	this.ArmRight02.yRot = 0.0F;
				    	this.ArmRight02.zRot = -1F;
				    	this.ArmRight02.x = (-3.0F) + (0F) * 16F;
				    	this.ArmRight02.z = (2.5F) + (0F) * 16F;
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
this.animTransX += (0F); this.animTransY += (0.495F); this.animTransZ += (0F);
			    	
			    	//body
			    	this.Head.xRot -= 0.7F;
			    	this.BodyMain.xRot = 0.35F;
			    	this.Hair01.xRot += 0.3F;
			    	this.Hair02.xRot += 0.3F;
			    	this.Hair03.xRot += 0.3F;
			    	this.Skirt01.xRot = -0.32F;
			    	this.Skirt01.y = (3.0F) + (-0.05F) * 16F;
			    	this.Skirt02.xRot = -0.21F;
			    	this.Collar01.xRot += 0.1F;
				  	this.Collar03.xRot += 0.1F;
			    	//arm
					this.ArmLeft01.xRot = -0.5235987755982988F;
					this.ArmLeft01.yRot = 0.0F;
					this.ArmLeft01.zRot = 0.3490658503988659F;
				    this.ArmLeft02.xRot = 0F;
				    this.ArmLeft02.zRot = 0F;
				    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
				    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
					this.ArmRight01.xRot = -0.5235987755982988F;
					this.ArmRight01.yRot = 0.0F;
					this.ArmRight01.zRot = -0.3490658503988659F;
					this.ArmRight02.xRot = 0F;
					this.ArmRight02.zRot = 0F;
					this.ArmRight02.x = (-3.0F) + (0F) * 16F;
					this.ArmRight02.z = (2.5F) + (0F) * 16F;
			    	//leg
			    	addk1 = -1.4486232791552935F;
			    	addk2 = -1.4486232791552935F;
					this.LegLeft01.yRot = -0.5235987755982988F;
					this.LegLeft01.zRot = -1.3962634015954636F;
					this.LegLeft02.xRot = 2.1816615649929116F;
					this.LegLeft02.yRot = 0.0F;
					this.LegLeft02.zRot = 0.0F;
					this.LegLeft02.x = (3.0F) + (0F) * 16F;
					this.LegLeft02.z = (-3.0F) + (0.37F) * 16F;
					this.LegRight01.yRot = 0.5235987755982988F;
					this.LegRight01.zRot = 1.3962634015954636F;
					this.LegRight02.xRot = 2.1816615649929116F;
					this.LegRight02.yRot = 0.0F;
					this.LegRight02.zRot = 0.0F;
					this.LegRight02.x = (-3.0F) + (0F) * 16F;
					this.LegRight02.z = (-3.0F) + (0.37F) * 16F;
		    	}
	    	}
	    }//end ridding
    
	    //攻擊動作    
	    if (ent.getAttackTick() > 0)
	    {
	    	if (ent.getAttackTick() > 14)
	    	{
	    		if (ent.getIsRiding())
	    		{
this.animTransX += (0F); this.animTransY += (0.02F); this.animTransZ += (0F);
	    			
	    			//body
	    			this.Head.xRot *= 0.5F;
			    	this.Head.yRot *= 0.75F;
				    this.Head.xRot -= 0.5F;
			    	this.BodyMain.xRot = 1.1F;
			    	this.Collar01.xRot -= 0.2F;
			    	//hair
			    	this.Ahoke01.xRot += 0.38F;
				  	this.Ahoke01.yRot = 0.8F;
				  	this.Ahoke01.zRot = 0.4F;
				  	this.Hair01.xRot += 0.2F;
			    	this.Hair02.xRot += -0.1F;
			    	this.Hair03.xRot += -0.1F;
			    	addHL1 = -0.6F;
			    	addHR1 = -0.6F;
			    	addHL2 = -0.5F;
			    	addHR2 = -0.5F;
			    	//leg
				    addk1 = -1.8F;
			    	addk2 = -1.8F;
				    this.LegLeft01.yRot = -0.1F;
				  	this.LegRight01.yRot = 0.1F;
				  	//equip
				  	this.GlowEquipBase.xRot = 0.5F;
	    		}
	    		else
	    		{
this.animTransX += (0F); this.animTransY += (0.22F); this.animTransZ += (0F);
	    			
	    			//body
	    			this.Head.xRot *= 0.5F;
			    	this.Head.yRot *= 0.75F;
				    this.Head.xRot -= 1.6F;
			    	this.BodyMain.xRot = 1.6F;
			    	this.Collar01.xRot -= 0.5F;
				  	this.Collar03.xRot -= 0.5F;
				  	this.Collar04.xRot -= 0.5F;
				  	//hair
			    	this.Ahoke01.xRot += 0.38F;
				  	this.Ahoke01.yRot = 0.8F;
				  	this.Ahoke01.zRot = 0.4F;
				  	this.Hair01.xRot += 1.0F;
			    	this.Hair02.xRot += 0.6F;
			    	this.Hair03.xRot += 0.7F;
			    	addHL1 = -0.6F;
			    	addHR1 = -0.6F;
			    	addHL2 = -0.5F;
			    	addHR2 = -0.5F;
			    	//leg
				    addk1 = -2.2F;
			    	addk2 = -2.2F;
				    this.LegLeft01.yRot = -0.1F;
				  	this.LegRight01.yRot = 0.1F;
				  	//equip
				  	this.GlowEquipBase.xRot = 0F;
	    		}
		  		
			    //body
		    	this.Skirt01.xRot = -0.33F;
		    	this.Skirt01.y = (3.0F) + (-0.23F) * 16F;
		    	this.Skirt02.xRot = -0.12F;
		    	this.Skirt02.y = (3.5F) + (-0.16F) * 16F;
		    	//arm
		    	this.ArmLeft01.xRot = -1.6F;
		    	this.ArmLeft01.yRot = -0.2F;
		    	this.ArmRight01.xRot = -1.2F;
		    	this.ArmRight01.yRot = 1.2F;
	    	}
	    }
	    
	    //跑道顯示
    	setTorpedo(ent.getAttackTick(), tails);
	    
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
	    headX = this.Head.xRot * -0.5F;
		this.HairL01.xRot = angleX * 0.02F + headX - 0.19F + addHL1;
	  	this.HairL02.xRot = -angleX1 * 0.04F + headX + 0.17F + addHL2;
	  	this.HairR01.xRot = angleX * 0.02F + headX - 0.19F + addHR1;
	  	this.HairR02.xRot = -angleX1 * 0.04F + headX + 0.17F + addHR2;
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.zRot = headZ;
	  	this.Hair02.zRot = headZ;
	  	this.Hair03.zRot = headZ;
	  	this.HairL01.zRot = headZ - 0.087F;
	  	this.HairL02.zRot = headZ + 0.087F;
	  	this.HairR01.zRot = headZ + 0.087F;
	  	this.HairR02.zRot = headZ - 0.052F;
	  	
	    //leg motion
	    this.LegLeft01.xRot = addk1;
	    this.LegRight01.xRot = addk2;
	
	}

	private void setTorpedo(int attackTime, boolean showTails)
	{

    	if (attackTime <= 14)
    	{
    		this.GlowEquipBase.visible = !(!showTails);
    		this.EquipTBase.visible = false;
    		this.EquipTBase_1.visible = false;
    		return;
    	}
    	
    	//set rotation
    	this.EquipTube00.xRot = 0.2618F;
		this.EquipTube00.yRot = 0.61F;
		this.EquipTube00.zRot = 0F;
		this.EquipTube01.xRot = 0.35F;
		this.EquipTube01.yRot = 0F;
		this.EquipTube01.zRot = 0F;
		this.EquipTube02.xRot = 0.5235F;
		this.EquipTube02.yRot = 0F;
		this.EquipTube02.zRot = 0F;
		this.EquipTube03.xRot = 0.61F;
		this.EquipTube03.yRot = 0F;
		this.EquipTube03.zRot = 0F;
		this.EquipTube04.xRot = 0.6981F;
		this.EquipTube04.yRot = 0F;
		this.EquipTube04.zRot = 0F;
		this.EquipTube05.xRot = 0.61F;
		this.EquipTube05.yRot = 0F;
		this.EquipTube05.zRot = 0F;
		this.EquipTube00_1.xRot = 0.2618F;
		this.EquipTube00_1.yRot = -0.61F;
		this.EquipTube00_1.zRot = 0F;
		this.EquipTube01_1.xRot = 0.35F;
		this.EquipTube01_1.yRot = 0F;
		this.EquipTube01_1.zRot = 0F;
		this.EquipTube02_1.xRot = 0.5235F;
		this.EquipTube02_1.yRot = 0F;
		this.EquipTube02_1.zRot = 0F;
		this.EquipTube03_1.xRot = 0.61F;
		this.EquipTube03_1.yRot = 0F;
		this.EquipTube03_1.zRot = 0F;
		this.EquipTube04_1.xRot = 0.6981F;
		this.EquipTube04_1.yRot = 0F;
		this.EquipTube04_1.zRot = 0F;
		this.EquipTube05_1.xRot = 0.61F;
		this.EquipTube05_1.yRot = 0F;
		this.EquipTube05_1.zRot = 0F;
    	
    	//show torpedo
		this.EquipTBase.visible = true;
		this.EquipTBase_1.visible = true;
    	this.GlowEquipBase.visible = true;
    	
    	switch (attackTime)
		{
		case 50:
			this.EquipTBase.y = (26.0F) + (-2.73F) * 16F;
			this.EquipTBase_1.y = (26.0F) + (-2.73F) * 16F;
		break;
		case 49:
			this.EquipTBase.y = (26.0F) + (-2.71F) * 16F;
			this.EquipTBase_1.y = (26.0F) + (-2.71F) * 16F;
		break;
		case 48:
			this.EquipTBase.y = (26.0F) + (-2.69F) * 16F;
			this.EquipTBase_1.y = (26.0F) + (-2.69F) * 16F;
		break;
		case 47:
			this.EquipTBase.y = (26.0F) + (-2.375F) * 16F;
			this.EquipTBase_1.y = (26.0F) + (-2.375F) * 16F;
		break;
		case 46:
			this.EquipTBase.y = (26.0F) + (-2.06F) * 16F;
			this.EquipTBase_1.y = (26.0F) + (-2.06F) * 16F;
		break;
		case 45:
			this.EquipTBase.y = (26.0F) + (-1.75F) * 16F;
			this.EquipTBase_1.y = (26.0F) + (-1.75F) * 16F;
		break;
		case 44:
			this.EquipTBase.y = (26.0F) + (-1.44F) * 16F;
			this.EquipTBase_1.y = (26.0F) + (-1.44F) * 16F;
		break;
		case 43:
			this.EquipTBase.y = (26.0F) + (-1.125F) * 16F;
			this.EquipTBase_1.y = (26.0F) + (-1.125F) * 16F;
		break;
		case 42:
			this.EquipTBase.y = (26.0F) + (-0.81F) * 16F;
			this.EquipTBase_1.y = (26.0F) + (-0.81F) * 16F;
		break;
		case 41:
			this.EquipTBase.y = (26.0F) + (-0.5F) * 16F;
			this.EquipTBase_1.y = (26.0F) + (-0.5F) * 16F;
		break;
		case 40:
			this.EquipTBase.y = (26.0F) + (-0.19F) * 16F;
			this.EquipTBase_1.y = (26.0F) + (-0.19F) * 16F;
		break;
		case 39:
			this.EquipTBase.y = (26.0F) + (-0.095F) * 16F;
			this.EquipTBase_1.y = (26.0F) + (-0.095F) * 16F;
		break;
		default:
			this.EquipTBase.y = (26.0F) + (0F) * 16F;
			this.EquipTBase_1.y = (26.0F) + (0F) * 16F;
		break;
		}
    	
		switch (attackTime)
		{
		case 50:
		case 49:
			this.EquipT07.visible = true;
			this.EquipT07_1.visible = true;
			this.EquipT06.visible = false;
			this.EquipT06_1.visible = false;
			this.EquipT05.visible = false;
			this.EquipT05_1.visible = false;
			this.EquipT04.visible = false;
			this.EquipT04_1.visible = false;
			this.EquipT03.visible = false;
			this.EquipT03_1.visible = false;
			this.EquipT02.visible = false;
			this.EquipT02_1.visible = false;
			this.EquipT01.visible = false;
			this.EquipT01_1.visible = false;
		break;
		case 48:
		case 47:
			this.EquipT07.visible = true;
			this.EquipT07_1.visible = true;
			this.EquipT06.visible = true;
			this.EquipT06_1.visible = true;
			this.EquipT05.visible = false;
			this.EquipT05_1.visible = false;
			this.EquipT04.visible = false;
			this.EquipT04_1.visible = false;
			this.EquipT03.visible = false;
			this.EquipT03_1.visible = false;
			this.EquipT02.visible = false;
			this.EquipT02_1.visible = false;
			this.EquipT01.visible = false;
			this.EquipT01_1.visible = false;
		break;
		case 46:
		case 45:
			this.EquipT07.visible = true;
			this.EquipT07_1.visible = true;
			this.EquipT06.visible = true;
			this.EquipT06_1.visible = true;
			this.EquipT05.visible = true;
			this.EquipT05_1.visible = true;
			this.EquipT04.visible = false;
			this.EquipT04_1.visible = false;
			this.EquipT03.visible = false;
			this.EquipT03_1.visible = false;
			this.EquipT02.visible = false;
			this.EquipT02_1.visible = false;
			this.EquipT01.visible = false;
			this.EquipT01_1.visible = false;
		break;
		case 44:
		case 43:
			this.EquipT07.visible = true;
			this.EquipT07_1.visible = true;
			this.EquipT06.visible = true;
			this.EquipT06_1.visible = true;
			this.EquipT05.visible = true;
			this.EquipT05_1.visible = true;
			this.EquipT04.visible = true;
			this.EquipT04_1.visible = true;
			this.EquipT03.visible = false;
			this.EquipT03_1.visible = false;
			this.EquipT02.visible = false;
			this.EquipT02_1.visible = false;
			this.EquipT01.visible = false;
			this.EquipT01_1.visible = false;
		break;
		case 42:
		case 41:
			this.EquipT07.visible = true;
			this.EquipT07_1.visible = true;
			this.EquipT06.visible = true;
			this.EquipT06_1.visible = true;
			this.EquipT05.visible = true;
			this.EquipT05_1.visible = true;
			this.EquipT04.visible = true;
			this.EquipT04_1.visible = true;
			this.EquipT03.visible = true;
			this.EquipT03_1.visible = true;
			this.EquipT02.visible = false;
			this.EquipT02_1.visible = false;
			this.EquipT01.visible = false;
			this.EquipT01_1.visible = false;
		break;
		case 40:
		case 39:
			this.EquipT07.visible = true;
			this.EquipT07_1.visible = true;
			this.EquipT06.visible = true;
			this.EquipT06_1.visible = true;
			this.EquipT05.visible = true;
			this.EquipT05_1.visible = true;
			this.EquipT04.visible = true;
			this.EquipT04_1.visible = true;
			this.EquipT03.visible = true;
			this.EquipT03_1.visible = true;
			this.EquipT02.visible = true;
			this.EquipT02_1.visible = true;
			this.EquipT01.visible = false;
			this.EquipT01_1.visible = false;
		break;
		default:
			if (attackTime < 39)
			{
				this.EquipT07.visible = true;
				this.EquipT07_1.visible = true;
				this.EquipT06.visible = true;
				this.EquipT06_1.visible = true;
				this.EquipT05.visible = true;
				this.EquipT05_1.visible = true;
				this.EquipT04.visible = true;
				this.EquipT04_1.visible = true;
				this.EquipT03.visible = true;
				this.EquipT03_1.visible = true;
				this.EquipT02.visible = true;
				this.EquipT02_1.visible = true;
				this.EquipT01.visible = true;
				this.EquipT01_1.visible = true;
			}
		break;
		}
	
	}

	@Override
	public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)
	{
		this.captureAnimParms(entity, f, f1, f2, f3, f4);

    	//FIX: head rotation bug while riding
    	if (f3 <= -180F) { f3 += 360F; }
    	else if (f3 >= 180F) { f3 -= 360F; }
    	
    	
    	RenderHelper.animScale(this, 0.46F, 0.46F, 0.46F);
this.animTransX += (0F); this.animTransY += (1.77F); this.animTransZ += (0F);
    	
    	//main body
		super.setupAnim(entity, f, f1, f2, f3, f4);
	}

}

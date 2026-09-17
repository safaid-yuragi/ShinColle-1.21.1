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

public class ModelBBKongou<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart Butt;
	public ModelPart Ahoke00;
	public ModelPart ArmLeft01;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart ArmRight01;
	public ModelPart EquipBase;
	public ModelPart Cloth03a1;
	public ModelPart Cloth03a2;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Ahoke01;
	public ModelPart EquipHeadBase;
	public ModelPart HairU01;
	public ModelPart HairR01;
	public ModelPart HairL01;
	public ModelPart HairCBase;
	public ModelPart HairCBaseB;
	public ModelPart HairS01;
	public ModelPart HairS02;
	public ModelPart HairR02;
	public ModelPart HairL02;
	public ModelPart HairC01;
	public ModelPart HairC02;
	public ModelPart HairC03;
	public ModelPart HairC04;
	public ModelPart HairC05;
	public ModelPart HairC01b;
	public ModelPart HairC02b;
	public ModelPart HairC03b;
	public ModelPart HairC04b;
	public ModelPart HairC05b;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart Ahoke02;
	public ModelPart Ahoke03;
	public ModelPart Ahoke04;
	public ModelPart EquipHead01;
	public ModelPart EquipHead01a;
	public ModelPart EquipHead02;
	public ModelPart EquipHead03;
	public ModelPart EquipHead02a;
	public ModelPart EquipHead03a;
	public ModelPart LegLeft01;
	public ModelPart Skirt01;
	public ModelPart LegRight01;
	public ModelPart SkirtB01;
	public ModelPart LegLeft02;
	public ModelPart Skirt02;
	public ModelPart LegRight02;
	public ModelPart Cloth01a;
	public ModelPart Cloth02a1;
	public ModelPart Cloth02b1;
	public ModelPart Cloth02c1;
	public ModelPart Cloth02c1_1;
	public ModelPart Cloth01b;
	public ModelPart Cloth01c;
	public ModelPart Cloth01b2;
	public ModelPart Cloth01c2;
	public ModelPart Cloth02a2;
	public ModelPart Cloth02a3;
	public ModelPart Cloth02b2;
	public ModelPart Cloth02b3;
	public ModelPart Cloth02c2;
	public ModelPart Cloth02c3;
	public ModelPart Cloth02c4;
	public ModelPart Cloth02c2_1;
	public ModelPart Cloth02c3_1;
	public ModelPart Cloth02c4_1;
	public ModelPart ArmLeft02;
	public ModelPart ClothA01;
	public ModelPart ClothA02;
	public ModelPart ClothA03;
	public ModelPart ClothA04;
	public ModelPart ClothA05;
	public ModelPart Cloth03b;
	public ModelPart ClothB01;
	public ModelPart Cloth03b_1;
	public ModelPart ArmRight02;
	public ModelPart ClothA01_1;
	public ModelPart ClothA02a;
	public ModelPart ClothA03a;
	public ModelPart ClothA04a;
	public ModelPart ClothA05a;
	public ModelPart EquipB01;
	public ModelPart EquipB00a;
	public ModelPart EquipB00a_1;
	public ModelPart EquipB02;
	public ModelPart EquipB01a;
	public ModelPart EquipB01b00;
	public ModelPart EquipB04;
	public ModelPart EquipB04_1;
	public ModelPart EquipB03;
	public ModelPart EquipB02a;
	public ModelPart EquipB01c;
	public ModelPart EquipB01b01a;
	public ModelPart EquipB01b01b;
	public ModelPart EquipB01b01c;
	public ModelPart EquipB01b02;
	public ModelPart EquipB01b03;
	public ModelPart EquipB01b04;
	public ModelPart EquipB01b05;
	public ModelPart EquipB01b06;
	public ModelPart EquipB05;
	public ModelPart EquipB06a;
	public ModelPart EquipB06b;
	public ModelPart EquipB06c;
	public ModelPart EquipB06d;
	public ModelPart EquipB06e;
	public ModelPart EquipB06f;
	public ModelPart EquipCL1Base01;
	public ModelPart EquipCL1Base02;
	public ModelPart EquipCL1a1;
	public ModelPart EquipCL1a1_1;
	public ModelPart EquipCL1a2;
	public ModelPart EquipCL1a2_1;
	public ModelPart EquipB05_1;
	public ModelPart EquipB07a1;
	public ModelPart EquipB07b1;
	public ModelPart EquipB07c1;
	public ModelPart EquipB07d1;
	public ModelPart EquipCL1Base01_1;
	public ModelPart EquipCL1Base02_1;
	public ModelPart EquipCL1a1_2;
	public ModelPart EquipCL1a1_3;
	public ModelPart EquipCL1a2_2;
	public ModelPart EquipCL1a2_3;
	public ModelPart EquipB07a2;
	public ModelPart EquipB07b2;
	public ModelPart EquipB07c2;
	public ModelPart EquipB07d2;
	public ModelPart EquipB07d3;
	public ModelPart EquipB05_2;
	public ModelPart EquipB06a_1;
	public ModelPart EquipB06b_1;
	public ModelPart EquipB06c_1;
	public ModelPart EquipB06d_1;
	public ModelPart EquipB06e_1;
	public ModelPart EquipB06f_1;
	public ModelPart EquipCL1Base01_2;
	public ModelPart EquipCL1Base02_2;
	public ModelPart EquipCL1a1_4;
	public ModelPart EquipCL1a1_5;
	public ModelPart EquipCL1a2_4;
	public ModelPart EquipCL1a2_5;
	public ModelPart EquipB05_3;
	public ModelPart EquipB07a1_1;
	public ModelPart EquipB07b1_1;
	public ModelPart EquipB07c1_1;
	public ModelPart EquipB07d1_1;
	public ModelPart EquipCL1Base01_3;
	public ModelPart EquipCL1Base02_3;
	public ModelPart EquipCL1a1_6;
	public ModelPart EquipCL1a1_7;
	public ModelPart EquipCL1a2_6;
	public ModelPart EquipCL1a2_7;
	public ModelPart EquipB07a2_1;
	public ModelPart EquipB07b2_1;
	public ModelPart EquipB07c2_1;
	public ModelPart EquipB07d2_1;
	public ModelPart EquipB07d3_1;
	public ModelPart EquipB00b;
	public ModelPart EquipB00c;
	public ModelPart EquipB00d;
	public ModelPart EquipB00b_1;
	public ModelPart EquipB00c_1;
	public ModelPart EquipB00d_1;
	public ModelPart GlowBodyMain;
	public ModelPart GlowHead;
	public ModelPart GlowNeck;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(3.5F, -8.2F, -3.7F, -0.8726646259971648F, 0.08726646259971647F, 0.06981317007977318F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("Cloth03b_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(0.6F, -0.8F, -0.1F, 0.0F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef3 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, -0.08726646259971647F, 0.0F, 0.3141592653589793F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0F, 0F, -5F, 5.0F, 12.0F, 5.0F), PartPose.offset(-3F, 11.0F, 2.5F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("ClothA02a", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F), PartPose.offset(2.5F, -0.1F, -2.5F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("ClothA03a", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 6.0F), PartPose.offset(-0.1F, -0.1F, -2.2F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("ClothA04a", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 0.9F, 0.8F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("ClothA05a", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 1.9F, 0.8F));
		PartDefinition partdef9 = partdef3.addOrReplaceChild("ClothA01_1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(-0.5F, 5.1F, 0.0F));
		PartDefinition partdef10 = partdef0.addOrReplaceChild("Cloth03a1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 18.0F, 7.0F), PartPose.offset(4.1F, -11.1F, -4.1F));
		PartDefinition partdef11 = partdef0.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, 6.5F, 9.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("EquipB01", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 10.0F, 9.0F), PartPose.offset(0.0F, -2.0F, 0.0F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("EquipB01b00", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, 0.1F, 9.8F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("EquipB01b01b", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(1.0F, -7.9F, 0.0F, -0.08726646259971647F, 0.0F, -0.12217304763960307F));
		PartDefinition partdef15 = partdef13.addOrReplaceChild("EquipB01b02", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 4.0F), PartPose.offset(0.0F, -8.7F, 0.6F));
		PartDefinition partdef16 = partdef13.addOrReplaceChild("EquipB01b01a", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -7.9F, 1.2F, 0.12217304763960307F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef13.addOrReplaceChild("EquipB01b05", CubeListBuilder.create().addBox(-0.6F, 0.0F, -0.5F, 1.0F, 18.0F, 1.0F), PartPose.offset(0.0F, -33.4F, 0.3F));
		PartDefinition partdef18 = partdef13.addOrReplaceChild("EquipB01b06", CubeListBuilder.create().addBox(-5.5F, 0F, 0F, 11.0F, 1.0F, 1.0F), PartPose.offset(0.0F, -29F, -0.1F));
		PartDefinition partdef19 = partdef13.addOrReplaceChild("EquipB01b04", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F), PartPose.offset(0.0F, -15.5F, 0.5F));
		PartDefinition partdef20 = partdef13.addOrReplaceChild("EquipB01b01c", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, -7.9F, 0.0F, -0.08726646259971647F, 0.0F, 0.12217304763960307F));
		PartDefinition partdef21 = partdef13.addOrReplaceChild("EquipB01b03", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(0.0F, -14.5F, 0.5F));
		PartDefinition partdef22 = partdef12.addOrReplaceChild("EquipB01a", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F), PartPose.offset(0.0F, -3.9F, 4.8F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("EquipB01c", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(0.0F, -4.9F, 0.5F));
		PartDefinition partdef24 = partdef12.addOrReplaceChild("EquipB02", CubeListBuilder.create().mirror().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 8.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 8.9F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("EquipB02a", CubeListBuilder.create().addBox(-2.0F, 0.0F, -1.0F, 4.0F, 5.0F, 4.0F), PartPose.offset(0.0F, -4.9F, 4.6F));
		PartDefinition partdef26 = partdef24.addOrReplaceChild("EquipB03", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 4.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 4.9F));
		PartDefinition partdef27 = partdef12.addOrReplaceChild("EquipB04_1", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 5.0F, 4.0F, 12.0F), PartPose.offset(-5.0F, -2.0F, -0.5F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("EquipB06b_1", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 6.0F, 11.0F), PartPose.offset(-11.4F, 4.0F, 0.5F));
		PartDefinition partdef29 = partdef27.addOrReplaceChild("EquipB05_2", CubeListBuilder.create().addBox(-4.5F, 0.0F, -4.5F, 9.0F, 8.0F, 9.0F), PartPose.offset(-9.4F, -3.8F, 6.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("EquipCL1Base01_2", CubeListBuilder.create().addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.1F, 0.0F, 0.0F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("EquipCL1a1_4", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("EquipCL1a2_4", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef33 = partdef30.addOrReplaceChild("EquipCL1Base02_2", CubeListBuilder.create().addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef34 = partdef30.addOrReplaceChild("EquipCL1a1_5", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("EquipCL1a2_5", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef36 = partdef27.addOrReplaceChild("EquipB06e_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 11.0F), PartPose.offset(-25.1F, 4.0F, 0.5F));
		PartDefinition partdef37 = partdef27.addOrReplaceChild("EquipB06d_1", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 9.0F, 11.0F), PartPose.offset(-17.2F, 4.0F, 0.5F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("EquipB05_3", CubeListBuilder.create().addBox(-4.5F, 0.0F, -4.5F, 9.0F, 2.0F, 9.0F), PartPose.offset(-4.8F, -1.9F, 5.0F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("EquipCL1Base01_3", CubeListBuilder.create().addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F), PartPose.offset(0.0F, 0.1F, 0.0F));
		PartDefinition partdef40 = partdef39.addOrReplaceChild("EquipCL1Base02_3", CubeListBuilder.create().addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef41 = partdef39.addOrReplaceChild("EquipCL1a1_7", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("EquipCL1a2_7", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef43 = partdef39.addOrReplaceChild("EquipCL1a1_6", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("EquipCL1a2_6", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef45 = partdef37.addOrReplaceChild("EquipB07a1_1", CubeListBuilder.create().mirror().addBox(-12.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(1.2F, 8.7F, 12.0F, -0.20943951023931953F, 0.08726646259971647F, -0.12217304763960307F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("EquipB07a2_1", CubeListBuilder.create().addBox(-5.0F, -2.0F, -1.0F, 5.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.5F, 0.0F, -1.0733774899765127F, 0.0F));
		PartDefinition partdef47 = partdef37.addOrReplaceChild("EquipB07d1_1", CubeListBuilder.create().mirror().addBox(-12.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(1.0F, -1.6F, 12.4F, 0.0F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("EquipB07d3_1", CubeListBuilder.create().addBox(-2.0F, -7.0F, -0.5F, 2.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -1.7F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef49 = partdef47.addOrReplaceChild("EquipB07d2_1", CubeListBuilder.create().addBox(-6.0F, -2.0F, -1.0F, 6.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.5F, 0.0F, -1.0471975511965976F, 0.0F));
		PartDefinition partdef50 = partdef37.addOrReplaceChild("EquipB07c1_1", CubeListBuilder.create().mirror().addBox(-12.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(1.0F, 2.4F, 12.4F, 0.0F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("EquipB07c2_1", CubeListBuilder.create().addBox(-7.0F, -2.0F, -1.0F, 7.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.5F, 0.0F, -1.0471975511965976F, 0.0F));
		PartDefinition partdef52 = partdef37.addOrReplaceChild("EquipB07b1_1", CubeListBuilder.create().mirror().addBox(-12.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(1.0F, 5.6F, 12.4F, 0.0F, 0.08726646259971647F, -0.05235987755982988F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("EquipB07b2_1", CubeListBuilder.create().addBox(-6.0F, -2.0F, -1.0F, 6.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.5F, 0.0F, -1.0471975511965976F, 0.0F));
		PartDefinition partdef54 = partdef27.addOrReplaceChild("EquipB06a_1", CubeListBuilder.create().addBox(-9.0F, 0.0F, 0.0F, 9.0F, 4.0F, 11.0F), PartPose.offset(-2.5F, 3.9F, 0.5F));
		PartDefinition partdef55 = partdef27.addOrReplaceChild("EquipB06f_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 11.0F), PartPose.offset(-27.0F, 4.0F, 0.5F));
		PartDefinition partdef56 = partdef27.addOrReplaceChild("EquipB06c_1", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 8.0F, 11.0F), PartPose.offset(-14.3F, 4.0F, 0.5F));
		PartDefinition partdef57 = partdef12.addOrReplaceChild("EquipB04", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 12.0F), PartPose.offset(5.0F, -2.0F, -0.5F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("EquipB05", CubeListBuilder.create().addBox(-4.5F, 0.0F, -4.5F, 9.0F, 8.0F, 9.0F), PartPose.offset(9.4F, -3.8F, 6.0F));
		PartDefinition partdef59 = partdef58.addOrReplaceChild("EquipCL1Base01", CubeListBuilder.create().addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.1F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F));
		PartDefinition partdef60 = partdef59.addOrReplaceChild("EquipCL1Base02", CubeListBuilder.create().mirror().addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef61 = partdef59.addOrReplaceChild("EquipCL1a1_1", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("EquipCL1a2_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef63 = partdef59.addOrReplaceChild("EquipCL1a1", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef64 = partdef63.addOrReplaceChild("EquipCL1a2", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef65 = partdef57.addOrReplaceChild("EquipB06e", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 11.0F), PartPose.offset(21.1F, 4.0F, 0.5F));
		PartDefinition partdef66 = partdef57.addOrReplaceChild("EquipB06d", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 9.0F, 11.0F), PartPose.offset(17.2F, 4.0F, 0.5F));
		PartDefinition partdef67 = partdef66.addOrReplaceChild("EquipB05_1", CubeListBuilder.create().addBox(-4.5F, 0.0F, -4.5F, 9.0F, 2.0F, 9.0F), PartPose.offset(4.8F, -1.9F, 5.0F));
		PartDefinition partdef68 = partdef67.addOrReplaceChild("EquipCL1Base01_1", CubeListBuilder.create().addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F), PartPose.offset(0.0F, 0.1F, 0.0F));
		PartDefinition partdef69 = partdef68.addOrReplaceChild("EquipCL1a1_2", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef70 = partdef69.addOrReplaceChild("EquipCL1a2_2", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef71 = partdef68.addOrReplaceChild("EquipCL1Base02_1", CubeListBuilder.create().addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef72 = partdef68.addOrReplaceChild("EquipCL1a1_3", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.16984426090695579F, 0.0F, 0.0F));
		PartDefinition partdef73 = partdef72.addOrReplaceChild("EquipCL1a2_3", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef74 = partdef66.addOrReplaceChild("EquipB07c1", CubeListBuilder.create().addBox(0.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 2.4F, 12.4F, 0.0F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef75 = partdef74.addOrReplaceChild("EquipB07c2", CubeListBuilder.create().addBox(0.0F, -2.0F, -1.0F, 7.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(12.0F, 0.0F, 0.5F, 0.0F, 1.0471975511965976F, 0.0F));
		PartDefinition partdef76 = partdef66.addOrReplaceChild("EquipB07d1", CubeListBuilder.create().addBox(0.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, -1.6F, 12.4F, 0.0F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef77 = partdef76.addOrReplaceChild("EquipB07d3", CubeListBuilder.create().addBox(0.0F, -7.0F, -0.5F, 2.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -1.7F, 0.0F, 0.0F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef78 = partdef76.addOrReplaceChild("EquipB07d2", CubeListBuilder.create().addBox(0.0F, -2.0F, -1.0F, 6.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(12.0F, 0.0F, 0.5F, 0.0F, 1.0471975511965976F, 0.0F));
		PartDefinition partdef79 = partdef66.addOrReplaceChild("EquipB07b1", CubeListBuilder.create().addBox(0.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 5.6F, 12.4F, 0.0F, -0.08726646259971647F, 0.05235987755982988F));
		PartDefinition partdef80 = partdef79.addOrReplaceChild("EquipB07b2", CubeListBuilder.create().addBox(0.0F, -2.0F, -1.0F, 6.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(12.0F, 0.0F, 0.5F, 0.0F, 1.0471975511965976F, 0.0F));
		PartDefinition partdef81 = partdef66.addOrReplaceChild("EquipB07a1", CubeListBuilder.create().addBox(0.0F, -2.0F, -0.5F, 12.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-1.2F, 8.7F, 12.0F, -0.20943951023931953F, -0.08726646259971647F, 0.12217304763960307F));
		PartDefinition partdef82 = partdef81.addOrReplaceChild("EquipB07a2", CubeListBuilder.create().addBox(0.0F, -2.0F, -1.0F, 5.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(12.0F, 0.0F, 0.5F, 0.0F, 1.0733774899765127F, 0.0F));
		PartDefinition partdef83 = partdef57.addOrReplaceChild("EquipB06a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 4.0F, 11.0F), PartPose.offset(2.5F, 3.9F, 0.5F));
		PartDefinition partdef84 = partdef57.addOrReplaceChild("EquipB06b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 3.0F, 6.0F, 11.0F), PartPose.offset(11.4F, 4.0F, 0.5F));
		PartDefinition partdef85 = partdef57.addOrReplaceChild("EquipB06c", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 11.0F), PartPose.offset(14.3F, 4.0F, 0.5F));
		PartDefinition partdef86 = partdef57.addOrReplaceChild("EquipB06f", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 8.0F, 11.0F), PartPose.offset(25.0F, 4.0F, 0.5F));
		PartDefinition partdef87 = partdef11.addOrReplaceChild("EquipB00a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(2.2F, -5.5F, -1.0F, 0.0F, 0.2617993877991494F, 0.0F));
		PartDefinition partdef88 = partdef87.addOrReplaceChild("EquipB00b", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 8.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(6.0F, -0.1F, 2.0F, 0.0F, 1.3089969389957472F, 0.0F));
		PartDefinition partdef89 = partdef88.addOrReplaceChild("EquipB00c", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(5.7F, 2.0F, -0.3F, 0.0F, 0.0F, 0.6108652381980153F));
		PartDefinition partdef90 = partdef89.addOrReplaceChild("EquipB00d", CubeListBuilder.create().addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 1.1F));
		PartDefinition partdef91 = partdef11.addOrReplaceChild("EquipB00a_1", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-2.2F, -5.5F, -1.0F, 0.0F, -0.2617993877991494F, 0.0F));
		PartDefinition partdef92 = partdef91.addOrReplaceChild("EquipB00b_1", CubeListBuilder.create().addBox(-8.0F, 0.0F, -2.0F, 8.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-6.0F, -0.1F, 2.0F, 0.0F, -1.3089969389957472F, 0.0F));
		PartDefinition partdef93 = partdef92.addOrReplaceChild("EquipB00c_1", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-5.7F, 2.0F, -0.3F, 0.0F, 0.0F, -0.6108652381980153F));
		PartDefinition partdef94 = partdef93.addOrReplaceChild("EquipB00d_1", CubeListBuilder.create().addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 1.1F));
		PartDefinition partdef95 = partdef0.addOrReplaceChild("Cloth03a2", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 18.0F, 7.0F), PartPose.offset(-4.1F, -11.1F, -4.1F));
		PartDefinition partdef96 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(-3.5F, -8.2F, -3.8F, -0.8726646259971648F, -0.08726646259971647F, -0.06981317007977318F));
		PartDefinition partdef97 = partdef96.addOrReplaceChild("ClothB01", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(2.9F, 4.6F, 1.6F, 0.9599310885968813F, -0.006806784082777885F, 0.09477137838329208F));
		PartDefinition partdef98 = partdef96.addOrReplaceChild("Cloth03b", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-0.6F, -0.8F, -0.1F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef99 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef100 = partdef99.addOrReplaceChild("LegRight01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.19198621771937624F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef101 = partdef100.addOrReplaceChild("LegRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(-3.0F, 14.0F, -3.0F));
		PartDefinition partdef102 = partdef99.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.296705972839036F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef103 = partdef102.addOrReplaceChild("LegLeft02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(3.0F, 14.0F, -3.0F));
		PartDefinition partdef104 = partdef99.addOrReplaceChild("SkirtB01", CubeListBuilder.create().addBox(-8.0F, 0.0F, -4.5F, 16.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.5F, -1.9F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef105 = partdef104.addOrReplaceChild("Cloth02b1", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(-4.0F, 1.8F, -4.9F, -0.5585053606381855F, 0.0F, 0.06981317007977318F));
		PartDefinition partdef106 = partdef105.addOrReplaceChild("Cloth02b2", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.9F, 0.0F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef107 = partdef106.addOrReplaceChild("Cloth02b3", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.0F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef108 = partdef104.addOrReplaceChild("Cloth01a", CubeListBuilder.create().addBox(-1.0F, -2.5F, -1.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 2.3F, -5.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef109 = partdef108.addOrReplaceChild("Cloth01c2", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(2.0F, -0.4F, -0.7F, -0.2617993877991494F, -0.13962634015954636F, -0.17453292519943295F));
		PartDefinition partdef110 = partdef108.addOrReplaceChild("Cloth01b2", CubeListBuilder.create().addBox(0.0F, -3.0F, -1.0F, 6.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 0.3F, 0.08726646259971647F, 0.17453292519943295F, 0.3490658503988659F));
		PartDefinition partdef111 = partdef108.addOrReplaceChild("Cloth01c", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(-2.0F, -0.4F, -0.7F, -0.2617993877991494F, 0.13962634015954636F, 0.17453292519943295F));
		PartDefinition partdef112 = partdef108.addOrReplaceChild("Cloth01b", CubeListBuilder.create().addBox(-6.0F, -3.0F, -1.0F, 6.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 0.3F, 0.08726646259971647F, -0.17453292519943295F, -0.3490658503988659F));
		PartDefinition partdef113 = partdef104.addOrReplaceChild("Cloth02a1", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(4.0F, 1.8F, -4.9F, -0.5585053606381855F, 0.0F, -0.06981317007977318F));
		PartDefinition partdef114 = partdef113.addOrReplaceChild("Cloth02a2", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.9F, 0.0F, 0.17453292519943295F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef115 = partdef114.addOrReplaceChild("Cloth02a3", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.0F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef116 = partdef104.addOrReplaceChild("Cloth02c1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 0.0F), PartPose.offsetAndRotation(2.6F, 1.9F, 4.4F, 0.6283185307179586F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef117 = partdef116.addOrReplaceChild("Cloth02c2", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef118 = partdef117.addOrReplaceChild("Cloth02c3", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 6.9F, 0.0F, -0.13962634015954636F, 0.0F, 0.03490658503988659F));
		PartDefinition partdef119 = partdef118.addOrReplaceChild("Cloth02c4", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F), PartPose.offset(0.0F, 7.9F, 0.0F));
		PartDefinition partdef120 = partdef104.addOrReplaceChild("Cloth02c1_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 0.0F), PartPose.offsetAndRotation(-2.6F, 1.9F, 4.4F, 0.6283185307179586F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef121 = partdef120.addOrReplaceChild("Cloth02c2_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef122 = partdef121.addOrReplaceChild("Cloth02c3_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 6.9F, 0.0F, -0.13962634015954636F, 0.0F, -0.03490658503988659F));
		PartDefinition partdef123 = partdef122.addOrReplaceChild("Cloth02c4_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F), PartPose.offset(0.0F, 7.9F, 0.0F));
		PartDefinition partdef124 = partdef99.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -8.5F, 17.0F, 5.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 3.5F, 1.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef125 = partdef124.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-9.5F, 0.0F, -6.5F, 19.0F, 5.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 3.5F, -2.7F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef126 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.17453292519943295F, 0.0F, -0.3141592653589793F));
		PartDefinition partdef127 = partdef126.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(3.0F, 11.0F, 2.5F));
		PartDefinition partdef128 = partdef127.addOrReplaceChild("ClothA02", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F), PartPose.offset(-2.5F, -0.1F, -2.5F));
		PartDefinition partdef129 = partdef128.addOrReplaceChild("ClothA03", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 6.0F), PartPose.offset(0.1F, -0.1F, -2.2F));
		PartDefinition partdef130 = partdef129.addOrReplaceChild("ClothA04", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 0.9F, 0.8F));
		PartDefinition partdef131 = partdef130.addOrReplaceChild("ClothA05", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 1.9F, 0.8F));
		PartDefinition partdef132 = partdef126.addOrReplaceChild("ClothA01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(0.5F, 5.1F, 0.0F));
		PartDefinition partdef133 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-2.5F, -3.0F, -2.9F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -9.6F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef134 = partdef133.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef135 = partdef134.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.1F));
		PartDefinition partdef136 = partdef135.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -7.0F));
		PartDefinition partdef137 = partdef135.addOrReplaceChild("HairS01", CubeListBuilder.create().addBox(-1.5F, -3.0F, -3.0F, 3.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(-8.8F, 3.1F, 3.3F, 0.0F, 0.05235987755982988F, 0.0F));
		PartDefinition partdef138 = partdef135.addOrReplaceChild("HairCBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(6.0F, 1.0F, -1.6F, 0.0F, 0.0F, -0.3141592653589793F));
		PartDefinition partdef139 = partdef138.addOrReplaceChild("HairC01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -7.0F, 1.3962634015954636F, -0.13962634015954636F, 0.0F));
		PartDefinition partdef140 = partdef139.addOrReplaceChild("HairC02", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3439035240356336F, 0.0F, 0.0F));
		PartDefinition partdef141 = partdef140.addOrReplaceChild("HairC03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.5009094953223726F, 0.0F, -0.8726646259971648F));
		PartDefinition partdef142 = partdef141.addOrReplaceChild("HairC04", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 11.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 1.0471975511965976F, 0.0F, 0.0F));
		PartDefinition partdef143 = partdef142.addOrReplaceChild("HairC05", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 1.7453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef144 = partdef135.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(6.5F, 1.5F, -4.5F, -0.19198621771937624F, -0.17453292519943295F, -0.08726646259971647F));
		PartDefinition partdef145 = partdef144.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef146 = partdef135.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-6.5F, 1.5F, -4.5F, -0.19198621771937624F, 0.17453292519943295F, 0.08726646259971647F));
		PartDefinition partdef147 = partdef146.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(0.2F, 8.0F, 0.0F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef148 = partdef135.addOrReplaceChild("HairCBaseB", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 1.0F, -1.6F, 0.0F, 0.0F, 0.3141592653589793F));
		PartDefinition partdef149 = partdef148.addOrReplaceChild("HairC01b", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -7.0F, 1.3962634015954636F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef150 = partdef149.addOrReplaceChild("HairC02b", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 10.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3439035240356336F, 0.0F, 0.0F));
		PartDefinition partdef151 = partdef150.addOrReplaceChild("HairC03b", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.5009094953223726F, 0.0F, 0.8726646259971648F));
		PartDefinition partdef152 = partdef151.addOrReplaceChild("HairC04b", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 11.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 1.0471975511965976F, 0.0F, 0.0F));
		PartDefinition partdef153 = partdef152.addOrReplaceChild("HairC05b", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 1.7453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef154 = partdef135.addOrReplaceChild("HairS02", CubeListBuilder.create().addBox(-1.5F, -3.0F, -3.0F, 3.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(8.8F, 3.1F, 3.3F, 0.0F, -0.05235987755982988F, 0.0F));
		PartDefinition partdef155 = partdef134.addOrReplaceChild("EquipHeadBase", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 2.0F, 15.0F), PartPose.offset(0.0F, -11.8F, -7.6F));
		PartDefinition partdef156 = partdef155.addOrReplaceChild("EquipHead01a", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 8.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-7.5F, 0.2F, 7.0F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef157 = partdef156.addOrReplaceChild("EquipHead03a", CubeListBuilder.create().addBox(-7.0F, 0.0F, 0.0F, 7.0F, 2.0F, 1.0F), PartPose.offset(0.2F, 0.9F, 0.5F));
		PartDefinition partdef158 = partdef156.addOrReplaceChild("EquipHead02a", CubeListBuilder.create().addBox(-7.0F, 0.0F, 1.0F, 7.0F, 2.0F, 0.0F), PartPose.offset(-0.4F, -1.9F, 0.0F));
		PartDefinition partdef159 = partdef155.addOrReplaceChild("EquipHead01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(7.5F, 0.2F, 7.0F, 0.0F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef160 = partdef159.addOrReplaceChild("EquipHead03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 7.0F, 2.0F, 1.0F), PartPose.offset(0.2F, 0.9F, 0.5F));
		PartDefinition partdef161 = partdef159.addOrReplaceChild("EquipHead02", CubeListBuilder.create().addBox(0.0F, 0.0F, 1.0F, 7.0F, 2.0F, 0.0F), PartPose.offset(0.4F, -1.9F, 0.0F));
		PartDefinition partdef162 = partdef134.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef163 = partdef162.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 13.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef164 = partdef163.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.0F, 0.0F, -5.0F, 16.0F, 13.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 10.5F, 5.7F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef165 = partdef134.addOrReplaceChild("Ahoke00", CubeListBuilder.create().addBox(0F, -9F, 0F, 0.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(-0.6F, -13F, -4F, 0.6632F, 0.5236F, 0F));
		PartDefinition partdef166 = partdef134.addOrReplaceChild("Ahoke01", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -15.0F, -5.0F, 2.705260340591211F, -2.8797932657906435F, 0.0F));
		PartDefinition partdef167 = partdef166.addOrReplaceChild("Ahoke02", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 1.2217304763960306F, 0.0F, 0.0F));
		PartDefinition partdef168 = partdef167.addOrReplaceChild("Ahoke03", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 1.48352986419518F, 0.0F, 0.0F));
		PartDefinition partdef169 = partdef168.addOrReplaceChild("Ahoke04", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.9599310885968813F, 0.0F, 0.0F));
		PartDefinition partdef170 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0F));
		PartDefinition partdef171 = partdef170.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.6F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef172 = partdef171.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef173 = partdef172.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef174 = partdef172.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef175 = partdef172.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef176 = partdef172.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef177 = partdef172.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef178 = partdef172.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef179 = partdef172.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef180 = partdef172.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef181 = partdef172.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef182 = partdef172.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelBBKongou(ModelPart root)
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
		this.HairC02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairCBase").getChild("HairC01").getChild("HairC02");
		this.EquipB06b_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06b_1");
		this.EquipB01b00 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB01b00");
		this.EquipCL1a2_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB05_1").getChild("EquipCL1Base01_1").getChild("EquipCL1a1_3").getChild("EquipCL1a2_3");
		this.EquipB05 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB05");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.EquipCL1a2_7 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB05_3").getChild("EquipCL1Base01_3").getChild("EquipCL1a1_7").getChild("EquipCL1a2_7");
		this.EquipB07a2_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB07a1_1").getChild("EquipB07a2_1");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.ClothB01 = root.getChild("BodyMain").getChild("BoobR").getChild("ClothB01");
		this.EquipB00d_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB00a_1").getChild("EquipB00b_1").getChild("EquipB00c_1").getChild("EquipB00d_1");
		this.EquipCL1Base01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB05").getChild("EquipCL1Base01");
		this.EquipB05_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB05_2");
		this.Cloth02c4 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1").getChild("Cloth02c2").getChild("Cloth02c3").getChild("Cloth02c4");
		this.ClothA02a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ClothA02a");
		this.EquipB00b_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB00a_1").getChild("EquipB00b_1");
		this.EquipB01b01b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB01b00").getChild("EquipB01b01b");
		this.Ahoke03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01").getChild("Ahoke02").getChild("Ahoke03");
		this.Cloth02c2 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1").getChild("Cloth02c2");
		this.EquipB06e_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06e_1");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.EquipCL1Base02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB05").getChild("EquipCL1Base01").getChild("EquipCL1Base02");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.EquipB01b02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB01b00").getChild("EquipB01b02");
		this.HairC04 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairCBase").getChild("HairC01").getChild("HairC02").getChild("HairC03").getChild("HairC04");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.EquipB05_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB05_1");
		this.EquipB07c1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB07c1");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.EquipB01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01");
		this.EquipB00a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB00a");
		this.EquipB07d3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB07d1").getChild("EquipB07d3");
		this.EquipB00d = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB00a").getChild("EquipB00b").getChild("EquipB00c").getChild("EquipB00d");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.Cloth02c2_1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1_1").getChild("Cloth02c2_1");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.EquipCL1a1_4 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB05_2").getChild("EquipCL1Base01_2").getChild("EquipCL1a1_4");
		this.Cloth01c2 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a").getChild("Cloth01c2");
		this.Cloth02b1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02b1");
		this.Cloth02a2 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02a1").getChild("Cloth02a2");
		this.EquipB06e = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06e");
		this.Cloth02b2 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02b1").getChild("Cloth02b2");
		this.EquipB05_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB05_3");
		this.EquipB01b01a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB01b00").getChild("EquipB01b01a");
		this.HairU01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairU01");
		this.EquipCL1Base01_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB05_3").getChild("EquipCL1Base01_3");
		this.Cloth01b2 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a").getChild("Cloth01b2");
		this.EquipB00b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB00a").getChild("EquipB00b");
		this.EquipHead03a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01a").getChild("EquipHead03a");
		this.EquipCL1Base01_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB05_2").getChild("EquipCL1Base01_2");
		this.EquipB07d3_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB07d1_1").getChild("EquipB07d3_1");
		this.EquipCL1a2_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB05").getChild("EquipCL1Base01").getChild("EquipCL1a1_1").getChild("EquipCL1a2_1");
		this.EquipCL1Base02_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB05_3").getChild("EquipCL1Base01_3").getChild("EquipCL1Base02_3");
		this.HairC03b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairCBaseB").getChild("HairC01b").getChild("HairC02b").getChild("HairC03b");
		this.Cloth01c = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a").getChild("Cloth01c");
		this.ClothA02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ClothA02");
		this.EquipB00c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB00a").getChild("EquipB00b").getChild("EquipB00c");
		this.EquipB06d = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d");
		this.Cloth03b_1 = root.getChild("BodyMain").getChild("BoobL").getChild("Cloth03b_1");
		this.EquipB02a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB02").getChild("EquipB02a");
		this.EquipHeadBase = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase");
		this.HairS01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairS01");
		this.HairL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.EquipB07d1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB07d1");
		this.Cloth03a1 = root.getChild("BodyMain").getChild("Cloth03a1");
		this.Cloth01a = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a");
		this.EquipB00a_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB00a_1");
		this.HairCBase = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairCBase");
		this.Cloth02c4_1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1_1").getChild("Cloth02c2_1").getChild("Cloth02c3_1").getChild("Cloth02c4_1");
		this.EquipB01a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB01a");
		this.Cloth02c3_1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1_1").getChild("Cloth02c2_1").getChild("Cloth02c3_1");
		this.EquipBase = root.getChild("BodyMain").getChild("EquipBase");
		this.EquipHead01a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01a");
		this.Cloth03a2 = root.getChild("BodyMain").getChild("Cloth03a2");
		this.HairC05 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairCBase").getChild("HairC01").getChild("HairC02").getChild("HairC03").getChild("HairC04").getChild("HairC05");
		this.EquipB06d_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1");
		this.EquipCL1Base01_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB05_1").getChild("EquipCL1Base01_1");
		this.EquipHead03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01").getChild("EquipHead03");
		this.ClothA03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ClothA02").getChild("ClothA03");
		this.EquipB07a1_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB07a1_1");
		this.EquipHead02a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01a").getChild("EquipHead02a");
		this.EquipCL1a2_6 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB05_3").getChild("EquipCL1Base01_3").getChild("EquipCL1a1_6").getChild("EquipCL1a2_6");
		this.EquipB07b2_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB07b1_1").getChild("EquipB07b2_1");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.HairR02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.EquipCL1a2_4 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB05_2").getChild("EquipCL1Base01_2").getChild("EquipCL1a1_4").getChild("EquipCL1a2_4");
		this.EquipB01c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB01a").getChild("EquipB01c");
		this.EquipB07d1_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB07d1_1");
		this.EquipHead01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01");
		this.EquipCL1a1_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB05_1").getChild("EquipCL1Base01_1").getChild("EquipCL1a1_2");
		this.Cloth01b = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a").getChild("Cloth01b");
		this.EquipCL1a1_7 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB05_3").getChild("EquipCL1Base01_3").getChild("EquipCL1a1_7");
		this.HairC03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairCBase").getChild("HairC01").getChild("HairC02").getChild("HairC03");
		this.EquipCL1a2_5 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB05_2").getChild("EquipCL1Base01_2").getChild("EquipCL1a1_5").getChild("EquipCL1a2_5");
		this.EquipHead02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01").getChild("EquipHead02");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.EquipCL1Base02_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB05_2").getChild("EquipCL1Base01_2").getChild("EquipCL1Base02_2");
		this.EquipCL1a2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB05").getChild("EquipCL1Base01").getChild("EquipCL1a1").getChild("EquipCL1a2");
		this.EquipB06a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06a");
		this.ClothA05a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ClothA02a").getChild("ClothA03a").getChild("ClothA04a").getChild("ClothA05a");
		this.HairC02b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairCBaseB").getChild("HairC01b").getChild("HairC02b");
		this.Cloth02c3 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1").getChild("Cloth02c2").getChild("Cloth02c3");
		this.HairC04b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairCBaseB").getChild("HairC01b").getChild("HairC02b").getChild("HairC03b").getChild("HairC04b");
		this.EquipB00c_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB00a_1").getChild("EquipB00b_1").getChild("EquipB00c_1");
		this.EquipB07b1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB07b1");
		this.ClothA03a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ClothA02a").getChild("ClothA03a");
		this.EquipB02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB02");
		this.EquipB06b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06b");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.EquipB07c2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB07c1").getChild("EquipB07c2");
		this.EquipCL1a1_5 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB05_2").getChild("EquipCL1Base01_2").getChild("EquipCL1a1_5");
		this.EquipB07a1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB07a1");
		this.EquipCL1a1_6 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB05_3").getChild("EquipCL1Base01_3").getChild("EquipCL1a1_6");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.ClothA01_1 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ClothA01_1");
		this.EquipB04_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1");
		this.EquipB06a_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06a_1");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.EquipB04 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04");
		this.EquipB07d2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB07d1").getChild("EquipB07d2");
		this.EquipCL1Base02_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB05_1").getChild("EquipCL1Base01_1").getChild("EquipCL1Base02_1");
		this.EquipB07c1_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB07c1_1");
		this.EquipB01b05 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB01b00").getChild("EquipB01b05");
		this.EquipB01b06 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB01b00").getChild("EquipB01b06");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.HairC01b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairCBaseB").getChild("HairC01b");
		this.Ahoke04 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01").getChild("Ahoke02").getChild("Ahoke03").getChild("Ahoke04");
		this.HairC01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairCBase").getChild("HairC01");
		this.EquipB07b2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB07b1").getChild("EquipB07b2");
		this.SkirtB01 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01");
		this.EquipB07b1_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB07b1_1");
		this.Cloth03b = root.getChild("BodyMain").getChild("BoobR").getChild("Cloth03b");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.EquipCL1a2_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB05_1").getChild("EquipCL1Base01_1").getChild("EquipCL1a1_2").getChild("EquipCL1a2_2");
		this.ClothA04 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ClothA02").getChild("ClothA03").getChild("ClothA04");
		this.ClothA01 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ClothA01");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.EquipCL1a1_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB05").getChild("EquipCL1Base01").getChild("EquipCL1a1_1");
		this.EquipCL1a1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB05").getChild("EquipCL1Base01").getChild("EquipCL1a1");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.EquipB06f_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06f_1");
		this.Ahoke00 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke00");
		this.Ahoke01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01");
		this.EquipB06c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06c");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.EquipB01b04 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB01b00").getChild("EquipB01b04");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.ClothA05 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ClothA02").getChild("ClothA03").getChild("ClothA04").getChild("ClothA05");
		this.HairCBaseB = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairCBaseB");
		this.EquipB07d2_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB07d1_1").getChild("EquipB07d2_1");
		this.EquipB03 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB02").getChild("EquipB03");
		this.EquipB01b01c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB01b00").getChild("EquipB01b01c");
		this.Cloth02a1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02a1");
		this.EquipB07c2_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06d_1").getChild("EquipB07c1_1").getChild("EquipB07c2_1");
		this.Cloth02a3 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02a1").getChild("Cloth02a2").getChild("Cloth02a3");
		this.EquipCL1a1_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB05_1").getChild("EquipCL1Base01_1").getChild("EquipCL1a1_3");
		this.Cloth02c1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1");
		this.EquipB01b03 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB01b00").getChild("EquipB01b03");
		this.EquipB06c_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04_1").getChild("EquipB06c_1");
		this.BodyMain = root.getChild("BodyMain");
		this.Cloth02c1_1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1_1");
		this.Ahoke02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ahoke01").getChild("Ahoke02");
		this.Cloth02b3 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02b1").getChild("Cloth02b2").getChild("Cloth02b3");
		this.EquipB06f = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06f");
		this.HairC05b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairCBaseB").getChild("HairC01b").getChild("HairC02b").getChild("HairC03b").getChild("HairC04b").getChild("HairC05b");
		this.EquipB07a2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipB01").getChild("EquipB04").getChild("EquipB06d").getChild("EquipB07a1").getChild("EquipB07a2");
		this.ClothA04a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ClothA02a").getChild("ClothA03a").getChild("ClothA04a");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.HairS02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairS02");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.offsetItem = new float[] {0.1F, 0.86F, -0.12F};
		this.offsetBlock = new float[] {0.1F, 0.86F, -0.12F};
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
		
		boolean flag = !EmotionHelper.checkModelState(0, state);	//cannon
		this.EquipBase.visible = !(flag);
				
		flag = !EmotionHelper.checkModelState(1, state);			//head equip
		this.EquipHeadBase.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);			//hair
		this.HairS01.visible = !(flag);
		this.HairS02.visible = !(flag);
		this.HairCBase.visible = !(flag);
		this.HairCBaseB.visible = !(flag);
		
		flag = EmotionHelper.checkModelState(3, state);				//ahoke
		this.Ahoke00.visible = !(!flag);
		this.Ahoke01.visible = !(flag);
	
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

		switch (ent.getScaleLevel())
    	{
    	case 3:
this.animTransX += (0F); this.animTransY += (1.42F); this.animTransZ += (0F);
		break;
    	case 2:
this.animTransX += (0F); this.animTransY += (1.29F); this.animTransZ += (0F);
		break;
    	case 1:
this.animTransX += (0F); this.animTransY += (1.05F); this.animTransZ += (0F);
		break;
    	default:
this.animTransX += (0F); this.animTransY += (0.7F); this.animTransZ += (0F);
		break;
    	}
		
		this.setFaceHungry(ent);

		//body
    	this.Head.xRot = 0F;
    	this.Head.yRot = 0F;
    	this.Head.zRot = 0F;
    	this.BodyMain.xRot = 1.4F;
    	this.Butt.xRot = 0.21F;
    	this.Butt.y = (4.0F) + (0F) * 16F;
	  	this.Butt.z = (1.3F) + (0F) * 16F;
    	//boob
    	this.BoobL.xRot = -0.8F;
  	    this.BoobR.xRot = -0.8F;
    	this.ClothB01.xRot = 0.96F;
    	//cloth
    	this.Skirt01.xRot = -0.087F;
	  	this.Skirt02.xRot = -0.087F;
    	this.Skirt01.y = (3.5F) + (0F) * 16F;
	  	this.Skirt01.z = (1.5F) + (0F) * 16F;
    	this.SkirtB01.xRot = 0.087F;
    	this.ClothA03.yRot = 0F;
	  	this.ClothA03a.yRot = 0F;
    	this.Cloth02a1.xRot = -0.5585F;
	  	this.Cloth02b1.xRot = -0.5585F;
	  	this.Cloth02c1.xRot = 0.6283F;
		this.Cloth02c1_1.xRot = 0.6283F;
		this.Cloth02c2.xRot = -0.7854F;
		this.Cloth02c2_1.xRot = -0.7854F;
		this.Cloth02c3.xRot = -0.1396F;
		this.Cloth02c3_1.xRot = -0.1396F;
		this.Cloth02c4.xRot = 0F;
		this.Cloth02c4_1.xRot = 0F;
		this.Cloth02a2.xRot = 0.1745F;
		this.Cloth02b2.xRot = 0.1745F;
		this.Cloth02a3.xRot = 0F;
		this.Cloth02b3.xRot = 0F;
		this.ClothA03.y = (-0.1F) + (0F) * 16F;
	  	this.ClothA04.y = (0.9F) + (0F) * 16F;
	  	this.ClothA05.y = (1.9F) + (0F) * 16F;
	  	this.ClothA03.z = (-2.2F) + (0F) * 16F;
	  	this.ClothA04.z = (0.8F) + (0F) * 16F;
	  	this.ClothA05.z = (0.8F) + (0F) * 16F;
	  	this.ClothA03a.y = (-0.1F) + (0F) * 16F;
	  	this.ClothA04a.y = (0.9F) + (0F) * 16F;
	  	this.ClothA05a.y = (1.9F) + (0F) * 16F;
	  	this.ClothA03a.z = (-2.2F) + (0F) * 16F;
	  	this.ClothA04a.z = (0.8F) + (0F) * 16F;
	  	this.ClothA05a.z = (0.8F) + (0F) * 16F;
    	//hair
    	this.Ahoke00.xRot = 0.6632F;
    	this.Ahoke00.yRot = 0.523F;
    	this.Ahoke00.zRot = 0F;
	  	this.Ahoke01.xRot = 2.7F;
  	    this.Ahoke02.xRot = 1.22F;
  	    this.Ahoke03.xRot = 1.48F;
  	    this.Ahoke04.xRot = 0.96F;
    	this.Hair01.xRot = 0.1F;
    	this.Hair01.yRot = 0F;
    	this.Hair01.zRot = 0F;
    	this.Hair02.xRot = -0.3F;
    	this.Hair02.yRot = 0F;
    	this.Hair02.zRot = 0F;
    	//arm
    	this.ArmLeft01.xRot = -2.8F;
    	this.ArmLeft01.yRot = 0.1F;
    	this.ArmLeft01.zRot = 0.84F;
    	this.ArmLeft02.xRot = 0F;
    	this.ArmLeft02.zRot = 1.0F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
    	this.ArmRight01.xRot = 0F;
    	this.ArmRight01.yRot = 0F;
    	this.ArmRight01.zRot = 0.2F;
	    this.ArmRight02.xRot = 0F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.x = (-3F) + (0F) * 16F;
		this.ArmRight02.z = (2.5F) + (0F) * 16F;
    	//leg
    	this.LegLeft01.xRot = -0.12F;
    	this.LegLeft01.yRot = 0F;
    	this.LegLeft01.zRot = -0.05F;
    	this.LegLeft01.y = (5.5F) + (0F) * 16F;
		this.LegLeft01.z = (-2.6F) + (0F) * 16F;
    	this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (3.0F) + (0F) * 16F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
    	this.LegRight01.xRot = -0.12F;
		this.LegRight01.yRot = 0F;
    	this.LegRight01.zRot = 0.26F;
    	this.LegRight01.y = (5.5F) + (0F) * 16F;
		this.LegRight01.z = (-2.6F) + (0F) * 16F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = -0.4F;
		this.LegRight02.x = (-3.0F) + (0F) * 16F;
		this.LegRight02.y = (14.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		//equip
		this.EquipBase.visible = false;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2 * 0.08F + f * 0.25F);
  		float angleX1 = Mth.cos(f2 * 0.1F + 0.35F + f * 0.5F);
  		float angleX2 = Mth.cos(f2 * 0.1F + 0.70F + f * 0.5F);
  		float angleX3 = Mth.cos(f2 * 0.1F + 1.05F + f * 0.5F);
  		float angleX4 = Mth.cos(f2 * 0.1F + 1.40F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
  		float addk1 = 0;
  		float addk2 = 0;
  		float headX = 0F;
  		float headZ = 0F;
  		float addHL1 = 0F;
  		float addHR1 = 0F;
  		float addHL2 = 0F;
  		float addHR2 = 0F;
  		float t2 = ent.getTickExisted() & 511;
  		boolean spcStand = ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}

    	//leg move
  		addk1 = angleAdd1 * 0.3F - 0.28F;  //LegLeft01
	  	addk2 = angleAdd2 * 0.3F - 0.21F;  //LegRight01
    	
  	    //head
	  	this.Head.xRot = f4 * 0.014F;
	  	this.Head.yRot = f3 * 0.01F;
	  	this.Ahoke00.xRot = angleX2 * 0.05F + 0.66F;
	  	this.Ahoke00.yRot = -angleX * 0.15F + 0.53F;
	  	this.Ahoke01.xRot = -angleX1 * 0.09F + 2.7F;
  	    this.Ahoke02.xRot = angleX2 * 0.15F + 1.22F;
  	    this.Ahoke03.xRot = -angleX3 * 0.10F + 1.48F;
  	    this.Ahoke04.xRot = -angleX4 * 0.10F + 0.96F;
	    //boob
  	    this.BoobL.xRot = angleX * 0.06F - 0.8F;
  	    this.BoobR.xRot = angleX * 0.06F - 0.8F;
  	    this.ClothB01.xRot = 0.96F - angleX * 0.08F;
	  	//body
	  	this.BodyMain.xRot = -0.1047F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.35F;
	  	this.Butt.y = (4.0F) + (0F) * 16F;
	  	this.Butt.z = (1.3F) + (0F) * 16F;
	  	this.Skirt01.xRot = -0.087F;
	  	this.Skirt02.xRot = -0.087F;
	  	this.Skirt01.y = (3.5F) + (0F) * 16F;
	  	this.Skirt01.z = (1.5F) + (0F) * 16F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.03F + 0.26F + headX;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -angleX1 * 0.04F - 0.17F + headX;
	  	this.Hair02.zRot = 0F;
	  	//cloth
	  	this.ClothA03.yRot = 0F;
	  	this.ClothA03a.yRot = 0F;
	  	this.SkirtB01.xRot = 0.087F;
	  	this.Cloth02a1.xRot = -0.5585F;
	  	this.Cloth02b1.xRot = -0.5585F;
	  	this.Cloth02c1.xRot = 0.6283F;
		this.Cloth02c1_1.xRot = 0.6283F;
		this.Cloth02c2.xRot = -0.7854F;
		this.Cloth02c2_1.xRot = -0.7854F;
		this.Cloth02c3.xRot = -0.1396F + angleX1 * 0.06F;
		this.Cloth02c3_1.xRot = -0.1396F + angleX1 * 0.06F;
		this.Cloth02c4.xRot = -angleX2 * 0.06F;
		this.Cloth02c4_1.xRot = -angleX2 * 0.06F;
		this.Cloth02a2.xRot = 0.12F + angleX1 * 0.06F;
		this.Cloth02b2.xRot = 0.12F + angleX1 * 0.06F;
		this.Cloth02a3.xRot = -angleX2 * 0.06F;
		this.Cloth02b3.xRot = -angleX2 * 0.06F;
	    //arm 
	  	this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.3F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = angleX * 0.03F - 0.25F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    this.ArmRight01.xRot = angleAdd1 * 0.25F - 0.087F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -angleX * 0.03F + 0.25F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.x = (-3F) + (0F) * 16F;
		this.ArmRight02.z = (2.5F) + (0F) * 16F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.0873F;
		this.LegLeft01.y = (5.5F) + (0F) * 16F;
		this.LegLeft01.z = (-2.6F) + (0F) * 16F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (3.0F) + (0F) * 16F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.0873F;
		this.LegRight01.y = (5.5F) + (0F) * 16F;
		this.LegRight01.z = (-2.6F) + (0F) * 16F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.x = (-3.0F) + (0F) * 16F;
		this.LegRight02.y = (14.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		//equip
		this.EquipCL1a1.xRot = this.Head.xRot * 0.8F - 0.21F;
		this.EquipCL1a1_1.xRot = this.Head.xRot * 0.7F - 0.23F;
		this.EquipCL1a1_2.xRot = this.Head.xRot * 0.85F - 0.20F;
		this.EquipCL1a1_3.xRot = this.Head.xRot * 0.75F - 0.25F;
		this.EquipCL1a1_4.xRot = this.Head.xRot * 0.8F - 0.20F;
		this.EquipCL1a1_5.xRot = this.Head.xRot * 0.85F - 0.19F;
		this.EquipCL1a1_6.xRot = this.Head.xRot * 0.75F - 0.21F;
		this.EquipCL1a1_7.xRot = this.Head.xRot * 0.88F - 0.19F;
		this.EquipCL1Base01.yRot = this.Head.yRot * 0.5F - 0.9F;
		this.EquipCL1Base01_1.yRot = this.Head.yRot * 0.75F;
		this.EquipCL1Base01_2.yRot = this.Head.yRot * 0.5F + 0.9F;
		this.EquipCL1Base01_3.yRot = this.Head.yRot * 0.75F;
		
		//run
	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {
	    	spcStand = false;
	    	
	    	if (ent.getTickExisted() % 256 > 128)
	    	{
	    		this.setFace(3);
				this.setMouth(5);
	    	}
	    	//body
	    	this.BodyMain.xRot = 0.2F;
	    	this.Skirt01.xRot = -0.4F;
	    	this.Skirt02.xRot = -0.1F;
	    	this.SkirtB01.xRot = -0.13F;
	    	this.Cloth02c1.xRot = 1.17F;
	    	this.Cloth02c1_1.xRot = 1.17F;
	    	this.Cloth02c2.xRot = -0.63F;
	    	this.Cloth02c2_1.xRot = -0.63F;
	    	this.Hair01.xRot += 0.2F;
	    	this.Hair02.xRot += 0.2F;
	    	//arm
	    	this.ArmLeft01.xRot = angleAdd2 * 1.2F + 0.5F;
	  		this.ArmRight01.xRot = angleAdd1 * 1.2F + 0.5F;
		  	this.ArmLeft01.yRot = 0F;
		    this.ArmLeft02.xRot = -1F;
		    this.ArmLeft02.zRot = 0F;
		    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
		    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
		    this.ArmRight01.yRot = 0F;
			this.ArmRight02.xRot = -1F;
			this.ArmRight02.zRot = 0F;
			this.ArmRight02.x = (-3F) + (0F) * 16F;
			this.ArmRight02.z = (2.5F) + (0F) * 16F;
			//leg
			addk1 = angleAdd1 * 0.7F - 0.48F;
		  	addk2 = angleAdd2 * 0.7F - 0.41F;
			this.LegLeft01.yRot = 0F;
			this.LegLeft01.zRot = 0.0873F;
			this.LegRight01.yRot = 0F;
			this.LegRight01.zRot = -0.0873F;
  		}
	    
	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    //sneak
	    if (ent.getIsSneaking())
	    {
	    	spcStand = false;
	    	
	    	switch (ent.getScaleLevel())
	    	{
	    	case 3:
this.animTransX += (0F); this.animTransY += (0.28F); this.animTransZ += (0F);
			break;
	    	case 2:
this.animTransX += (0F); this.animTransY += (0.24F); this.animTransZ += (0F);
			break;
	    	case 1:
this.animTransX += (0F); this.animTransY += (0.2F); this.animTransZ += (0F);
			break;
	    	default:
this.animTransX += (0F); this.animTransY += (0.14F); this.animTransZ += (0F);
			break;
	    	}
	    	
	    	//Body
	    	this.Head.xRot -= 0.6283F;
		  	this.BodyMain.xRot = 0.8727F;
		  	this.Skirt01.xRot = -0.34F;
		  	this.Skirt01.y = (3.5F) + (-0.2F) * 16F;
		  	this.Skirt01.z = (1.5F) + (0.03F) * 16F;
		  	this.Skirt02.xRot = -0.27F;
		  	this.Cloth02a1.xRot = -1.23F;
		  	this.Cloth02b1.xRot = -1.23F;
		  	this.Cloth02c2.xRot -= 0.35F;
		  	this.Cloth02c2_1.xRot -= 0.35F;
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
  		}//end if sneaking
  		
	    //sit
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {
	    	spcStand = false;
	    	
	    	if (ent.getTickExisted() % 512 > 256)
	    	{
		    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		    	{
		    		switch (ent.getScaleLevel())
			    	{
			    	case 3:
this.animTransX += (0F); this.animTransY += (1.39F); this.animTransZ += (0F);
					break;
			    	case 2:
this.animTransX += (0F); this.animTransY += (1.22F); this.animTransZ += (0F);
					break;
			    	case 1:
this.animTransX += (0F); this.animTransY += (1F); this.animTransZ += (0F);
					break;
			    	default:
this.animTransX += (0F); this.animTransY += (0.69F); this.animTransZ += (0F);
					break;
			    	}
			    	
			  	    //頭部
				  	this.Head.xRot = -0.35F;
				  	this.Head.yRot = 0F;
				  	//body
			  	    this.BodyMain.xRot = -1.6F;
				    //arm 
				  	this.ArmLeft01.xRot = 3.0F;
				  	this.ArmLeft01.yRot = 0F;
			    	this.ArmLeft01.zRot = 0.7F;
					this.ArmRight01.xRot = 3.0F;
					this.ArmRight01.yRot = 0F;
			    	this.ArmRight01.zRot = -0.7F;
			    	this.ArmLeft02.xRot = 0F;
			    	this.ArmRight02.xRot = 0F;
					//leg
			    	this.LegLeft01.xRot = -0.2F;
					this.LegLeft01.yRot = 0F;
					this.LegLeft01.zRot = -0.1F;
					this.LegLeft02.xRot = 0F;
					this.LegRight01.xRot = -0.2F;
					this.LegRight01.yRot = 0F;
					this.LegRight01.zRot = 0.1F;
			    	this.LegRight02.xRot = 0F;
			    	//equip
			    	this.EquipBase.visible = false;
		    	}
		    	else
		    	{
			    	switch (ent.getScaleLevel())
			    	{
			    	case 3:
this.animTransX += (0F); this.animTransY += (1.09F); this.animTransZ += (0F);
					break;
			    	case 2:
this.animTransX += (0F); this.animTransY += (1F); this.animTransZ += (0F);
					break;
			    	case 1:
this.animTransX += (0F); this.animTransY += (0.82F); this.animTransZ += (0F);
					break;
			    	default:
this.animTransX += (0F); this.animTransY += (0.55F); this.animTransZ += (0F);
					break;
			    	}
	    	
		      		this.setFaceScorn(ent);

		    	  	//Body
		        	this.Head.xRot += 0.1F;
		    	  	this.BodyMain.xRot = -0.1F;
		    	  	this.Butt.xRot = -0.4F;
		    	  	this.Butt.z = (1.3F) + (0.19F) * 16F;
		      	    this.Skirt01.xRot = -0.35F;
				  	this.Skirt02.xRot = -0.19F;
				  	this.Cloth02a1.xRot = 0.2F;
				  	this.Cloth02b1.xRot = 0.2F;
				  	this.Cloth02c1.xRot = 1.5F;
				  	this.Cloth02c2.xRot = 0.35F;
				  	this.Cloth02c3.xRot = 0.05F;
				  	this.Cloth02c4.xRot = 0.0F;
				  	this.Cloth02c1_1.xRot = 1.5F;
				  	this.Cloth02c2_1.xRot = 0.35F;
				  	this.Cloth02c3_1.xRot = 0.05F;
				  	this.Cloth02c4_1.xRot = 0.0F;
				  	this.ClothA03.yRot = 0.2F;
				  	this.ClothA03a.yRot = -0.2F;
		    	  	//hair
		    	  	this.Hair01.xRot = 0.21F + headX;
		    	  	this.Hair02.xRot = -0.28F + headX;
		    	    //arm 
		    	  	this.ArmLeft01.xRot = -1.18F;
		    	  	this.ArmLeft01.yRot = 0.27F;
		    	    this.ArmLeft01.zRot = -0.1F;
		    	    this.ArmLeft02.zRot = 0.92F;
		    		this.ArmRight01.xRot = -1.18F;
		    		this.ArmRight01.yRot = -0.27F;
		    		this.ArmRight01.zRot = 0.1F;
		    		this.ArmRight02.zRot = -1.32F;
		    		//leg
		    		addk1 = -2.57F;
		    		addk2 = -2.57F;
		    		this.LegLeft01.y = (5.5F) + (0.25F) * 16F;
		    		this.LegLeft01.z = (-2.6F) + (-0.2F) * 16F;
		    		this.LegLeft01.yRot = 0.11F;
		    		this.LegLeft01.zRot = -0.12F;
		    		this.LegLeft02.xRot = 2.75F;
		    		this.LegLeft02.zRot = 0.02F;
		    		this.LegLeft02.z = (-3.0F) + (0.37F) * 16F;
		    		this.LegRight01.y = (5.5F) + (0.25F) * 16F;
		    		this.LegRight01.z = (-2.6F) + (-0.2F) * 16F;
		    		this.LegRight01.yRot = -0.11F;
		    		this.LegRight01.zRot = 0.12F;
		    		this.LegRight02.xRot = 2.75F;
		    		this.LegRight02.zRot = -0.02F;
		    		this.LegRight02.z = (-3.0F) + (0.37F) * 16F;
		    	}
	    	}
	    	else
	    	{
		    	switch (ent.getScaleLevel())
		    	{
		    	case 3:
this.animTransX += (0F); this.animTransY += (0.63F); this.animTransZ += (0F);
				break;
		    	case 2:
this.animTransX += (0F); this.animTransY += (0.56F); this.animTransZ += (0F);
				break;
		    	case 1:
this.animTransX += (0F); this.animTransY += (0.46F); this.animTransZ += (0F);
				break;
		    	default:
this.animTransX += (0F); this.animTransY += (0.31F); this.animTransZ += (0F);
				break;
		    	}
		    	
		    	//Body
		    	this.Head.xRot += 0.14F;
			  	this.BodyMain.xRot = -0.4363F;
			  	//cloth
			  	this.Skirt01.xRot = -0.35F;
			  	this.Skirt02.xRot = -0.19F;
			  	this.SkirtB01.xRot = -0.12F;
			  	this.Cloth02a2.xRot += 0.32F;
			  	this.Cloth02a3.xRot += 0.4F;
			  	this.Cloth02b2.xRot += 0.32F;
			  	this.Cloth02b3.xRot += 0.4F;
			  	this.Cloth02c1.xRot += 0.45F;
			  	this.Cloth02c2.xRot += 0.1F;
			  	this.Cloth02c1_1.xRot += 0.45F;
			  	this.Cloth02c2_1.xRot += 0.1F;
			  	this.ClothA03.yRot = 1.49F;
			  	this.ClothA03a.yRot = -1.33F;
			    //arm 
			  	this.ArmLeft01.xRot = -0.3142F;
			    this.ArmLeft01.zRot = 0.3490F;
			    this.ArmLeft02.zRot = 1.15F;
				this.ArmRight01.xRot = -0.4363F;
				this.ArmRight01.zRot = -0.2793F;
				this.ArmRight02.zRot = -1.4F;
				//leg
				addk1 = -1.3090F;
				addk2 = -1.7F;
				this.LegLeft01.yRot = 0.3142F;
				this.LegLeft02.xRot = 1.0472F;
				this.LegRight01.yRot = -0.35F;
				this.LegRight01.zRot = -0.2618F;
				this.LegRight02.xRot = 0.9F;
				//hair
				this.Hair01.xRot += 0.12F;
				this.Hair02.xRot += 0.15F;
	    	}
  		}//end if sitting
	    
	    //attack
	    if (ent.getAttackTick() > 20)
	    {
	    	spcStand = false;
	    	
	    	this.setFace(3);
			this.setMouth(5);
				
	    	//Body
  		  	this.BodyMain.xRot = -0.17F;
  		    //arm 
  		  	this.ArmLeft01.xRot = -1.57F;
  		  	this.ArmLeft01.yRot = -0.26F;
  		  	this.ArmLeft01.zRot = 0F;
  			this.ArmRight01.xRot = 0F;
  			this.ArmRight01.zRot = 0.87F;
  			this.ArmRight02.zRot = -1.57F;
  			//leg
  			addk1 += 0.14F;
  			addk2 += 0.07F;
  			this.LegLeft01.yRot = 0F;
  			this.LegLeft01.zRot = -0.17F;
  			this.LegRight01.yRot = 0F;
  			this.LegRight01.zRot = 0.17F;
	    }
	    
	    //special stand pose
  		if (spcStand)
  		{
  			//Body
  		  	this.BodyMain.xRot = -0.17F;
  		    //arm 
  		  	this.ArmLeft01.xRot = -1.57F;
  		  	this.ArmLeft01.yRot = -0.26F;
  		  	this.ArmLeft01.zRot = 0F;
  			this.ArmRight01.xRot = 0F;
  			this.ArmRight01.zRot = 0.87F;
  			this.ArmRight02.zRot = -1.57F;
  			//leg
  			addk1 += 0.14F;
  			addk2 += 0.07F;
  			this.LegLeft01.yRot = 0F;
  			this.LegLeft01.zRot = -0.17F;
  			this.LegRight01.yRot = 0F;
  			this.LegRight01.zRot = 0.17F;
  			
  			if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED)
  			{
  				this.setFace(3);
  				this.setMouth(5);
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
	  	
	  	//sleeves
	  	float HandL = this.BodyMain.xRot + this.ArmLeft01.xRot + this.ArmLeft02.xRot;
	  	float HandR = this.BodyMain.xRot + this.ArmRight01.xRot + this.ArmRight02.xRot;
	  	float HandLc = Mth.cos(HandL);
	  	float HandLs = Mth.sin(HandL);
	  	float HandRc = Mth.cos(HandR);
	  	float HandRs = Mth.sin(HandR);
	  	this.ClothA03.y = (-0.1F) + (HandLc * 0.1F) * 16F;
	  	this.ClothA04.y = (0.9F) + (HandLc * 0.2F) * 16F;
	  	this.ClothA05.y = (1.9F) + (HandLc * 0.25F) * 16F;
	  	this.ClothA03.z = (-2.2F) + (HandLs * -0.32F) * 16F;
	  	this.ClothA04.z = (0.8F) + (HandLs * -0.32F) * 16F;
	  	this.ClothA05.z = (0.8F) + (HandLs * -0.32F) * 16F;
	  	this.ClothA03a.y = (-0.1F) + (HandRc * 0.1F) * 16F;
	  	this.ClothA04a.y = (0.9F) + (HandRc * 0.2F) * 16F;
	  	this.ClothA05a.y = (1.9F) + (HandRc * 0.25F) * 16F;
	  	this.ClothA03a.z = (-2.2F) + (HandRs * -0.32F) * 16F;
	  	this.ClothA04a.z = (0.8F) + (HandRs * -0.32F) * 16F;
	  	this.ClothA05a.z = (0.8F) + (HandRs * -0.32F) * 16F;
	  	
	  	//移動頭髮避免穿過身體
	    headX = this.Head.xRot * -0.5F;
		this.HairL01.xRot = angleX * 0.02F + headX - 0.19F + addHL1;
	  	this.HairL02.xRot = -angleX1 * 0.04F + headX + 0.17F + addHL2;
	  	this.HairR01.xRot = angleX * 0.02F + headX - 0.19F + addHR1;
	  	this.HairR02.xRot = -angleX1 * 0.04F + headX + 0.17F + addHR2;
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.zRot = headZ;
	  	this.Hair02.zRot = headZ;
	  	this.HairL01.zRot = headZ - 0.087F;
	  	this.HairL02.zRot = headZ + 0.087F;
	  	this.HairR01.zRot = headZ + 0.087F;
	  	this.HairR02.zRot = headZ - 0.052F;
	    
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
    	
    	switch (((IShipEmotion)entity).getScaleLevel())
    	{
    	case 3:
    		scale = 1.8F;
        	offsetY = -0.69F;
		break;
    	case 2:
    		scale = 1.35F;
        	offsetY = -0.41F;
		break;
    	case 1:
    		scale = 0.9F;
        	offsetY = 0.14F;
		break;
    	default:
    		scale = 0.45F;
        	offsetY = 1.79F;
		break;
    	}
    	
    	
    	RenderHelper.animScale(this, scale, scale, scale);
this.animTransX += (0F); this.animTransY += (offsetY); this.animTransZ += (0F);
    	
    	//main body
		super.setupAnim(entity, f, f1, f2, f3, f4);
	}

}

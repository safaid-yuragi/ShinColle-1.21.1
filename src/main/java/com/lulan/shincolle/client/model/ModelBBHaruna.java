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

public class ModelBBHaruna<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart Butt;
	public ModelPart ArmLeft01;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart ArmRight01;
	public ModelPart Cloth03a1;
	public ModelPart Cloth03a2;
	public ModelPart EquipBase;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart EquipHeadBase;
	public ModelPart HairU01;
	public ModelPart HairR01;
	public ModelPart HairL01;
	public ModelPart HairCBase;
	public ModelPart HairCBaseB;
	public ModelPart Ahoke;
	public ModelPart HairR02;
	public ModelPart HairL02;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart EquipHead01;
	public ModelPart EquipHead00;
	public ModelPart EquipHead01_1;
	public ModelPart EquipHead02;
	public ModelPart EquipHead03;
	public ModelPart EquipHead02_1;
	public ModelPart EquipHead03_1;
	public ModelPart LegLeft01;
	public ModelPart Skirt01;
	public ModelPart LegRight01;
	public ModelPart SkirtB01;
	public ModelPart Cloth02a1;
	public ModelPart Cloth02b1;
	public ModelPart LegLeft02;
	public ModelPart Skirt02;
	public ModelPart LegRight02;
	public ModelPart Cloth01a;
	public ModelPart Cloth02c1;
	public ModelPart Cloth02c1_1;
	public ModelPart Cloth01b;
	public ModelPart Cloth01c;
	public ModelPart Cloth01b2;
	public ModelPart Cloth01c2;
	public ModelPart Cloth02c2;
	public ModelPart Cloth02c3;
	public ModelPart Cloth02c4;
	public ModelPart Cloth02c2_1;
	public ModelPart Cloth02c3_1;
	public ModelPart Cloth02c4_1;
	public ModelPart Cloth02a2;
	public ModelPart Cloth02a3;
	public ModelPart Cloth02b2;
	public ModelPart Cloth02b3;
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
	public ModelPart EquipD01a;
	public ModelPart EquipD02a;
	public ModelPart EquipD02b;
	public ModelPart EquipD01b;
	public ModelPart EquipD02c;
	public ModelPart EquipD02d;
	public ModelPart EquipD03a1;
	public ModelPart EquipD03b1;
	public ModelPart EquipD03c1;
	public ModelPart EquipD03d1;
	public ModelPart EquipD01aa;
	public ModelPart EquipD01ba;
	public ModelPart EquipD01bb;
	public ModelPart EquipD03a2;
	public ModelPart EquipD03aa;
	public ModelPart EquipD03ab;
	public ModelPart EquipD03a3;
	public ModelPart EquipD03a4;
	public ModelPart EquipB05;
	public ModelPart EquipCL1Base01L2;
	public ModelPart EquipCL1Base02;
	public ModelPart EquipCL1a1;
	public ModelPart EquipCL1a1_1;
	public ModelPart EquipCL1Base01a;
	public ModelPart EquipCL1a2;
	public ModelPart EquipCL1a2_1;
	public ModelPart EquipD03a2_1;
	public ModelPart EquipD03aa_1;
	public ModelPart EquipD03ab_1;
	public ModelPart EquipD03a3_1;
	public ModelPart EquipD03a4_1;
	public ModelPart EquipB05_1;
	public ModelPart EquipCL1Base01R2;
	public ModelPart EquipCL1Base02_1;
	public ModelPart EquipCL1a1_2;
	public ModelPart EquipCL1a1_3;
	public ModelPart EquipCL1Base01a_1;
	public ModelPart EquipCL1a2_2;
	public ModelPart EquipCL1a2_3;
	public ModelPart EquipD03c1a;
	public ModelPart EquipD03c1b;
	public ModelPart EquipD03c2;
	public ModelPart EquipD03c2a;
	public ModelPart EquipD03c3;
	public ModelPart EquipD03c3a;
	public ModelPart EquipB05_2;
	public ModelPart EquipCL1Base01L1;
	public ModelPart EquipCL1Base02_2;
	public ModelPart EquipCL1a1_4;
	public ModelPart EquipCL1a1_5;
	public ModelPart EquipCL1Base01a_2;
	public ModelPart EquipCL1Base01b;
	public ModelPart EquipCL1a2_4;
	public ModelPart EquipCL1a2_5;
	public ModelPart EquipD03c1a_1;
	public ModelPart EquipD03c1b_1;
	public ModelPart EquipD03c2_1;
	public ModelPart EquipD03c2a_1;
	public ModelPart EquipD03c3_1;
	public ModelPart EquipD03c3a_1;
	public ModelPart EquipB05_3;
	public ModelPart EquipCL1Base01R1;
	public ModelPart EquipCL1Base02_3;
	public ModelPart EquipCL1a1_6;
	public ModelPart EquipCL1a1_7;
	public ModelPart EquipCL1Base01a_3;
	public ModelPart EquipCL1Base01b_1;
	public ModelPart EquipCL1a2_6;
	public ModelPart EquipCL1a2_7;
	public ModelPart GlowBodyMain;
	public ModelPart GlowHead;
	public ModelPart GlowNeck;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -8.5F, 17.0F, 5.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 3.5F, 1.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-9.5F, 0.0F, -6.5F, 19.0F, 5.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 3.5F, -2.7F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef1.addOrReplaceChild("Cloth02b1", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(-4.0F, 2.3F, -6.8F, -0.4363323129985824F, 0.0F, 0.06981317007977318F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("Cloth02b2", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.9F, 0.0F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("Cloth02b3", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.0F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef7 = partdef1.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.296705972839036F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("LegLeft02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(3.0F, 14.0F, -3.0F));
		PartDefinition partdef9 = partdef1.addOrReplaceChild("SkirtB01", CubeListBuilder.create().addBox(-8.0F, 0.0F, -4.5F, 16.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.5F, -1.9F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("Cloth02c1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 0.0F), PartPose.offsetAndRotation(2.6F, 1.9F, 4.4F, 0.6283185307179586F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("Cloth02c2", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("Cloth02c3", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 6.9F, 0.0F, -0.13962634015954636F, 0.0F, 0.03490658503988659F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("Cloth02c4", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F), PartPose.offset(0.0F, 7.9F, 0.0F));
		PartDefinition partdef14 = partdef9.addOrReplaceChild("Cloth02c1_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 0.0F), PartPose.offsetAndRotation(-2.6F, 1.9F, 4.4F, 0.6283185307179586F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("Cloth02c2_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("Cloth02c3_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 6.9F, 0.0F, -0.13962634015954636F, 0.0F, -0.03490658503988659F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("Cloth02c4_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F), PartPose.offset(0.0F, 7.9F, 0.0F));
		PartDefinition partdef18 = partdef9.addOrReplaceChild("Cloth01a", CubeListBuilder.create().addBox(-1.0F, -2.5F, -1.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 2.3F, -5.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("Cloth01b2", CubeListBuilder.create().addBox(0.0F, -3.0F, -1.0F, 6.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 0.3F, 0.08726646259971647F, 0.17453292519943295F, 0.3490658503988659F));
		PartDefinition partdef20 = partdef18.addOrReplaceChild("Cloth01c", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(-2.0F, -0.4F, -0.7F, -0.2617993877991494F, 0.13962634015954636F, 0.17453292519943295F));
		PartDefinition partdef21 = partdef18.addOrReplaceChild("Cloth01c2", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(2.0F, -0.4F, -0.7F, -0.2617993877991494F, -0.13962634015954636F, -0.17453292519943295F));
		PartDefinition partdef22 = partdef18.addOrReplaceChild("Cloth01b", CubeListBuilder.create().addBox(-6.0F, -3.0F, -1.0F, 6.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 0.3F, 0.08726646259971647F, -0.17453292519943295F, -0.3490658503988659F));
		PartDefinition partdef23 = partdef1.addOrReplaceChild("Cloth02a1", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(4.0F, 2.3F, -6.8F, -0.4363323129985824F, 0.0F, -0.06981317007977318F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("Cloth02a2", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.9F, 0.0F, 0.24434609527920614F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("Cloth02a3", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.0F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef26 = partdef1.addOrReplaceChild("LegRight01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.19198621771937624F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("LegRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(-3.0F, 14.0F, -3.0F));
		PartDefinition partdef28 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.27314402793711257F, 0.0F, -0.3141592653589793F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(3.0F, 11.0F, 2.5F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("ClothA02", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F), PartPose.offset(-2.5F, -0.1F, -2.5F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("ClothA03", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 6.0F), PartPose.offset(0.1F, 1.9F, -2.2F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("ClothA04", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 0.9F, 0.8F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("ClothA05", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 1.9F, 0.8F));
		PartDefinition partdef34 = partdef28.addOrReplaceChild("ClothA01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(0.5F, 5.1F, 0.0F));
		PartDefinition partdef35 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-2.5F, -3.0F, -2.9F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -9.6F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.4F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef37 = partdef36.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.1F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("HairCBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(6.0F, 1.0F, -1.6F, 0.0F, 0.0F, -0.3141592653589793F));
		PartDefinition partdef39 = partdef37.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(6.5F, 1.5F, -4.5F, -0.19198621771937624F, -0.17453292519943295F, -0.08726646259971647F));
		PartDefinition partdef40 = partdef39.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef41 = partdef37.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -5.0F, -10.5F, 0.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(-1.0F, -8.0F, -4.5F, 0.0F, 0.7853981633974483F, 0.0F));
		PartDefinition partdef42 = partdef37.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -7.0F));
		PartDefinition partdef43 = partdef37.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-6.5F, 1.5F, -4.5F, -0.19198621771937624F, 0.17453292519943295F, 0.08726646259971647F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(0.2F, 8.0F, 0.0F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef45 = partdef37.addOrReplaceChild("HairCBaseB", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 1.0F, -1.6F, 0.0F, 0.0F, 0.3141592653589793F));
		PartDefinition partdef46 = partdef36.addOrReplaceChild("EquipHeadBase", CubeListBuilder.create().addBox(-8.0F, 0.0F, 7.0F, 16.0F, 2.0F, 8.0F), PartPose.offset(0.0F, -11.8F, -7.6F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("EquipHead00", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -4.1F, 5.0F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef48 = partdef46.addOrReplaceChild("EquipHead01", CubeListBuilder.create().addBox(0.0F, -0.7F, -0.3F, 2.0F, 3.0F, 3.0F), PartPose.offset(6.7F, 0.2F, 5.7F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("EquipHead02", CubeListBuilder.create().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F), PartPose.offset(2.4F, 0.8F, 1.2F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("EquipHead03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 3.0F, 0.0F), PartPose.offset(0.2F, -1.5F, 0.0F));
		PartDefinition partdef51 = partdef46.addOrReplaceChild("EquipHead01_1", CubeListBuilder.create().addBox(-2.0F, -0.7F, -0.3F, 2.0F, 3.0F, 3.0F), PartPose.offset(-6.7F, 0.2F, 5.7F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("EquipHead02_1", CubeListBuilder.create().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F), PartPose.offset(-2.4F, 0.8F, 1.2F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("EquipHead03_1", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 5.0F, 3.0F, 0.0F), PartPose.offset(-0.2F, -1.5F, 0.0F));
		PartDefinition partdef54 = partdef36.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 13.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef56 = partdef55.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.0F, 0.0F, -5.0F, 16.0F, 13.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 10.5F, 5.7F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef57 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(-3.5F, -8.2F, -3.8F, -0.8726646259971648F, -0.08726646259971647F, -0.06981317007977318F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("ClothB01", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(2.9F, 4.6F, 1.6F, 0.9599310885968813F, -0.006806784082777885F, 0.09477137838329208F));
		PartDefinition partdef59 = partdef57.addOrReplaceChild("Cloth03b", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-0.6F, -0.8F, -0.1F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef60 = partdef0.addOrReplaceChild("Cloth03a1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 18.0F, 7.0F), PartPose.offset(4.1F, -11.1F, -4.1F));
		PartDefinition partdef61 = partdef0.addOrReplaceChild("Cloth03a2", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 18.0F, 7.0F), PartPose.offset(-4.1F, -11.1F, -4.1F));
		PartDefinition partdef62 = partdef0.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, 7.5F, 5.5F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("EquipD01a", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 10.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, 0.06981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef64 = partdef63.addOrReplaceChild("EquipD02d", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 12.0F, 4.0F), PartPose.offset(-5.9F, 5.0F, 5.9F));
		PartDefinition partdef65 = partdef63.addOrReplaceChild("EquipD03b1", CubeListBuilder.create().addBox(0.5F, -1.0F, -2.5F, 6.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(-5.0F, 5.8F, 7.5F, 0.0F, 3.141592653589793F, -0.5235987755982988F));
		PartDefinition partdef66 = partdef65.addOrReplaceChild("EquipD03ab_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 3.0F, 1.0F), PartPose.offset(-0.5F, -1.5F, 6.4F));
		PartDefinition partdef67 = partdef65.addOrReplaceChild("EquipD03aa_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 3.0F, 1.0F), PartPose.offset(-0.5F, -1.5F, -3.4F));
		PartDefinition partdef68 = partdef65.addOrReplaceChild("EquipD03a2_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(6.4F, -1.0F, -2.5F));
		PartDefinition partdef69 = partdef68.addOrReplaceChild("EquipD03a3_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(5.9F, 0.0F, 0.0F));
		PartDefinition partdef70 = partdef69.addOrReplaceChild("EquipD03a4_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(5.9F, 0.0F, 0.0F));
		PartDefinition partdef71 = partdef70.addOrReplaceChild("EquipB05_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(1.5F, -0.4F, 4.5F, 0.0F, 3.141592653589793F, 0.0F));
		PartDefinition partdef72 = partdef71.addOrReplaceChild("EquipCL1Base01R2", CubeListBuilder.create().addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F), PartPose.offset(0.2F, 0.1F, 0.0F));
		PartDefinition partdef73 = partdef72.addOrReplaceChild("EquipCL1Base01a_1", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -5.4F, -1.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef74 = partdef72.addOrReplaceChild("EquipCL1Base02_1", CubeListBuilder.create().addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef75 = partdef72.addOrReplaceChild("EquipCL1a1_3", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.16982053621904827F, 0.0F, 0.0F));
		PartDefinition partdef76 = partdef75.addOrReplaceChild("EquipCL1a2_3", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef77 = partdef72.addOrReplaceChild("EquipCL1a1_2", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.18203784098300857F, 0.0F, 0.0F));
		PartDefinition partdef78 = partdef77.addOrReplaceChild("EquipCL1a2_2", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef79 = partdef63.addOrReplaceChild("EquipD03c1", CubeListBuilder.create().addBox(0.0F, -1.5F, 0.0F, 8.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(5.0F, 5.5F, 4.0F, 0.0F, 0.0F, -0.3490658503988659F));
		PartDefinition partdef80 = partdef79.addOrReplaceChild("EquipD03c1b", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F), PartPose.offset(7.2F, -1.0F, 1.5F));
		PartDefinition partdef81 = partdef79.addOrReplaceChild("EquipD03c1a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.2F, 0.0F));
		PartDefinition partdef82 = partdef79.addOrReplaceChild("EquipD03c2", CubeListBuilder.create().addBox(0.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(8.0F, -0.2F, 1.5F, 0.0F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef83 = partdef82.addOrReplaceChild("EquipD03c2a", CubeListBuilder.create().addBox(0.0F, -1.5F, -4.5F, 8.0F, 3.0F, 9.0F), PartPose.offset(1.5F, 0.1F, 0.0F));
		PartDefinition partdef84 = partdef82.addOrReplaceChild("EquipD03c3", CubeListBuilder.create().addBox(0.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(7.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6108652381980153F));
		PartDefinition partdef85 = partdef84.addOrReplaceChild("EquipB05_2", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F), PartPose.offset(6.3F, -2.0F, 0.0F));
		PartDefinition partdef86 = partdef85.addOrReplaceChild("EquipCL1Base01L1", CubeListBuilder.create().addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F), PartPose.offset(0.2F, 0.1F, 0.0F));
		PartDefinition partdef87 = partdef86.addOrReplaceChild("EquipCL1Base02_2", CubeListBuilder.create().addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef88 = partdef86.addOrReplaceChild("EquipCL1Base01b", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -5.6F, 2.0F));
		PartDefinition partdef89 = partdef86.addOrReplaceChild("EquipCL1a1_5", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.16982053621904827F, 0.0F, 0.0F));
		PartDefinition partdef90 = partdef89.addOrReplaceChild("EquipCL1a2_5", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef91 = partdef86.addOrReplaceChild("EquipCL1a1_4", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.18203784098300857F, 0.0F, 0.0F));
		PartDefinition partdef92 = partdef91.addOrReplaceChild("EquipCL1a2_4", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef93 = partdef86.addOrReplaceChild("EquipCL1Base01a_2", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -5.4F, -1.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef94 = partdef84.addOrReplaceChild("EquipD03c3a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 8.0F, 3.0F, 9.0F), PartPose.offset(2.3F, -1.4F, -4.5F));
		PartDefinition partdef95 = partdef63.addOrReplaceChild("EquipD02b", CubeListBuilder.create().addBox(-3.5F, 0.0F, -0.6F, 7.0F, 14.0F, 5.0F), PartPose.offset(-3.4F, 5.0F, 1.7F));
		PartDefinition partdef96 = partdef63.addOrReplaceChild("EquipD01aa", CubeListBuilder.create().addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 9.5F, -4.0F, 0.22689280275926282F, 0.0F, 0.0F));
		PartDefinition partdef97 = partdef63.addOrReplaceChild("EquipD02a", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -0.6F, 7.0F, 14.0F, 5.0F), PartPose.offset(3.4F, 5.0F, 1.7F));
		PartDefinition partdef98 = partdef63.addOrReplaceChild("EquipD01b", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 9.0F, 6.0F), PartPose.offset(0.0F, 0.4F, 5.9F));
		PartDefinition partdef99 = partdef98.addOrReplaceChild("EquipD01ba", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 1.0F, 6.0F));
		PartDefinition partdef100 = partdef98.addOrReplaceChild("EquipD01bb", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 4.9F, 6.0F));
		PartDefinition partdef101 = partdef63.addOrReplaceChild("EquipD03d1", CubeListBuilder.create().addBox(0.0F, -1.5F, 0.0F, 8.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-5.0F, 5.5F, 7.0F, 0.0F, 3.141592653589793F, 0.3490658503988659F));
		PartDefinition partdef102 = partdef101.addOrReplaceChild("EquipD03c2_1", CubeListBuilder.create().addBox(0.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(8.0F, -0.2F, 1.5F, 0.0F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef103 = partdef102.addOrReplaceChild("EquipD03c3_1", CubeListBuilder.create().addBox(0.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(7.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6108652381980153F));
		PartDefinition partdef104 = partdef103.addOrReplaceChild("EquipD03c3a_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 8.0F, 3.0F, 9.0F), PartPose.offset(2.3F, -1.4F, -4.5F));
		PartDefinition partdef105 = partdef103.addOrReplaceChild("EquipB05_3", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(6.3F, -2.0F, 0.0F, 0.0F, 3.141592653589793F, 0.0F));
		PartDefinition partdef106 = partdef105.addOrReplaceChild("EquipCL1Base01R1", CubeListBuilder.create().addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F), PartPose.offset(0.2F, 0.1F, 0.0F));
		PartDefinition partdef107 = partdef106.addOrReplaceChild("EquipCL1Base02_3", CubeListBuilder.create().addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef108 = partdef106.addOrReplaceChild("EquipCL1a1_6", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.18203784098300857F, 0.0F, 0.0F));
		PartDefinition partdef109 = partdef108.addOrReplaceChild("EquipCL1a2_6", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef110 = partdef106.addOrReplaceChild("EquipCL1Base01a_3", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -5.4F, -1.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef111 = partdef106.addOrReplaceChild("EquipCL1a1_7", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.16982053621904827F, 0.0F, 0.0F));
		PartDefinition partdef112 = partdef111.addOrReplaceChild("EquipCL1a2_7", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef113 = partdef106.addOrReplaceChild("EquipCL1Base01b_1", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -5.6F, 2.0F));
		PartDefinition partdef114 = partdef102.addOrReplaceChild("EquipD03c2a_1", CubeListBuilder.create().addBox(0.0F, -1.5F, -4.5F, 8.0F, 3.0F, 9.0F), PartPose.offset(1.5F, 0.1F, 0.0F));
		PartDefinition partdef115 = partdef101.addOrReplaceChild("EquipD03c1a_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.2F, 0.0F));
		PartDefinition partdef116 = partdef101.addOrReplaceChild("EquipD03c1b_1", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F), PartPose.offset(7.2F, -1.0F, 1.5F));
		PartDefinition partdef117 = partdef63.addOrReplaceChild("EquipD03a1", CubeListBuilder.create().addBox(0.5F, -1.0F, -2.5F, 6.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(5.0F, 5.8F, 3.5F, 0.0F, 0.0F, 0.5235987755982988F));
		PartDefinition partdef118 = partdef117.addOrReplaceChild("EquipD03a2", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(6.4F, -1.0F, -2.5F));
		PartDefinition partdef119 = partdef118.addOrReplaceChild("EquipD03a3", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(5.9F, 0.0F, 0.0F));
		PartDefinition partdef120 = partdef119.addOrReplaceChild("EquipD03a4", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(5.9F, 0.0F, 0.0F));
		PartDefinition partdef121 = partdef120.addOrReplaceChild("EquipB05", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offset(1.5F, -0.4F, 4.5F));
		PartDefinition partdef122 = partdef121.addOrReplaceChild("EquipCL1Base01L2", CubeListBuilder.create().addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F), PartPose.offset(0.2F, 0.1F, 0.0F));
		PartDefinition partdef123 = partdef122.addOrReplaceChild("EquipCL1a1", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.18203784098300857F, 0.0F, 0.0F));
		PartDefinition partdef124 = partdef123.addOrReplaceChild("EquipCL1a2", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef125 = partdef122.addOrReplaceChild("EquipCL1a1_1", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.16982053621904827F, 0.0F, 0.0F));
		PartDefinition partdef126 = partdef125.addOrReplaceChild("EquipCL1a2_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef127 = partdef122.addOrReplaceChild("EquipCL1Base01a", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -5.4F, -1.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef128 = partdef122.addOrReplaceChild("EquipCL1Base02", CubeListBuilder.create().addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef129 = partdef117.addOrReplaceChild("EquipD03ab", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 3.0F, 1.0F), PartPose.offset(-0.5F, -1.5F, 6.4F));
		PartDefinition partdef130 = partdef117.addOrReplaceChild("EquipD03aa", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 3.0F, 1.0F), PartPose.offset(-0.5F, -1.5F, -3.4F));
		PartDefinition partdef131 = partdef63.addOrReplaceChild("EquipD02c", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 6.0F, 12.0F, 4.0F), PartPose.offset(3.3F, 5.0F, 5.9F));
		PartDefinition partdef132 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(3.5F, -8.2F, -3.7F, -0.8726646259971648F, 0.08726646259971647F, 0.06981317007977318F));
		PartDefinition partdef133 = partdef132.addOrReplaceChild("Cloth03b_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(0.6F, -0.8F, -0.1F, 0.0F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef134 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, -0.08726646259971647F, 0.0F, 0.3141592653589793F));
		PartDefinition partdef135 = partdef134.addOrReplaceChild("ClothA01_1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(-0.5F, 5.1F, 0.0F));
		PartDefinition partdef136 = partdef134.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(-3.0F, 11.0F, 2.5F));
		PartDefinition partdef137 = partdef136.addOrReplaceChild("ClothA02a", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F), PartPose.offsetAndRotation(2.5F, -0.1F, -2.5F, 0.0F, 0.012808717561550659F, 0.0F));
		PartDefinition partdef138 = partdef137.addOrReplaceChild("ClothA03a", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 6.0F), PartPose.offset(-0.1F, 1.9F, -2.2F));
		PartDefinition partdef139 = partdef138.addOrReplaceChild("ClothA04a", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 0.9F, 0.8F));
		PartDefinition partdef140 = partdef139.addOrReplaceChild("ClothA05a", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 1.9F, 0.8F));
		PartDefinition partdef141 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0F));
		PartDefinition partdef142 = partdef141.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.6F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef143 = partdef142.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef144 = partdef143.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef145 = partdef143.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef146 = partdef143.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef147 = partdef143.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef148 = partdef143.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef149 = partdef143.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef150 = partdef143.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef151 = partdef143.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef152 = partdef143.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef153 = partdef143.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelBBHaruna(ModelPart root)
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
		this.EquipD02d = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD02d");
		this.EquipHead00 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead00");
		this.HairCBase = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairCBase");
		this.Cloth02c4_1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1_1").getChild("Cloth02c2_1").getChild("Cloth02c3_1").getChild("Cloth02c4_1");
		this.EquipCL1Base01a_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1").getChild("EquipCL1Base01R2").getChild("EquipCL1Base01a_1");
		this.Cloth02c4 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1").getChild("Cloth02c2").getChild("Cloth02c3").getChild("Cloth02c4");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.EquipCL1a2_7 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1").getChild("EquipCL1a1_7").getChild("EquipCL1a2_7");
		this.EquipD03c2_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1");
		this.EquipB05_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1");
		this.EquipD03ab_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03ab_1");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.Cloth01b2 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a").getChild("Cloth01b2");
		this.EquipHeadBase = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase");
		this.EquipD01a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a");
		this.ClothA01_1 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ClothA01_1");
		this.EquipCL1Base02_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1").getChild("EquipCL1Base02_3");
		this.EquipCL1a1_6 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1").getChild("EquipCL1a1_6");
		this.EquipD03b1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1");
		this.EquipD03a2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2");
		this.ClothA02a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ClothA02a");
		this.EquipD03c1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.EquipCL1a2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05").getChild("EquipCL1Base01L2").getChild("EquipCL1a1").getChild("EquipCL1a2");
		this.ClothA04a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ClothA02a").getChild("ClothA03a").getChild("ClothA04a");
		this.EquipD02b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD02b");
		this.Cloth01c = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a").getChild("Cloth01c");
		this.Cloth02c2_1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1_1").getChild("Cloth02c2_1");
		this.EquipD03aa_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03aa_1");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.EquipD03ab = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03ab");
		this.EquipD03a4_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1");
		this.EquipD03c2a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c2a");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.EquipHead02_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01_1").getChild("EquipHead02_1");
		this.EquipD01aa = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD01aa");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.Cloth02b1 = root.getChild("BodyMain").getChild("Butt").getChild("Cloth02b1");
		this.EquipD01ba = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD01b").getChild("EquipD01ba");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.EquipHead01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01");
		this.ClothB01 = root.getChild("BodyMain").getChild("BoobR").getChild("ClothB01");
		this.HairR02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.EquipHead02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01").getChild("EquipHead02");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.EquipHead03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01").getChild("EquipHead02").getChild("EquipHead03");
		this.EquipCL1Base02_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1").getChild("EquipCL1Base01R2").getChild("EquipCL1Base02_1");
		this.EquipCL1Base01a_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1").getChild("EquipCL1Base01a_3");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.Cloth02c3 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1").getChild("Cloth02c2").getChild("Cloth02c3");
		this.EquipD03c3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.EquipCL1a1_7 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1").getChild("EquipCL1a1_7");
		this.SkirtB01 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.ClothA04 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ClothA02").getChild("ClothA03").getChild("ClothA04");
		this.EquipD03a3_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1");
		this.EquipCL1Base01b_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1").getChild("EquipCL1Base01b_1");
		this.Cloth02a2 = root.getChild("BodyMain").getChild("Butt").getChild("Cloth02a1").getChild("Cloth02a2");
		this.EquipCL1Base02_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1").getChild("EquipCL1Base02_2");
		this.EquipCL1Base01L1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.EquipD02a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD02a");
		this.EquipCL1Base01L2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05").getChild("EquipCL1Base01L2");
		this.EquipD03a2_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1");
		this.Cloth02c1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1");
		this.HairU01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairU01");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.EquipCL1Base01R1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1");
		this.Cloth03a1 = root.getChild("BodyMain").getChild("Cloth03a1");
		this.EquipHead01_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01_1");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.ClothA03a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ClothA02a").getChild("ClothA03a");
		this.EquipD03c1a_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c1a_1");
		this.EquipD01b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD01b");
		this.EquipD03a4 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4");
		this.EquipCL1a1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05").getChild("EquipCL1Base01L2").getChild("EquipCL1a1");
		this.HairL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.EquipCL1a2_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1").getChild("EquipCL1Base01R2").getChild("EquipCL1a1_2").getChild("EquipCL1a2_2");
		this.Cloth02c1_1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1_1");
		this.Cloth03a2 = root.getChild("BodyMain").getChild("Cloth03a2");
		this.EquipCL1a1_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05").getChild("EquipCL1Base01L2").getChild("EquipCL1a1_1");
		this.EquipCL1a2_4 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1").getChild("EquipCL1a1_4").getChild("EquipCL1a2_4");
		this.Cloth02a3 = root.getChild("BodyMain").getChild("Butt").getChild("Cloth02a1").getChild("Cloth02a2").getChild("Cloth02a3");
		this.Cloth01c2 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a").getChild("Cloth01c2");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.EquipCL1Base01a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05").getChild("EquipCL1Base01L2").getChild("EquipCL1Base01a");
		this.Cloth03b_1 = root.getChild("BodyMain").getChild("BoobL").getChild("Cloth03b_1");
		this.EquipD03d1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1");
		this.EquipCL1a2_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1").getChild("EquipCL1Base01R2").getChild("EquipCL1a1_3").getChild("EquipCL1a2_3");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.EquipD03c3a_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipD03c3a_1");
		this.EquipBase = root.getChild("BodyMain").getChild("EquipBase");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.EquipD03a1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1");
		this.EquipB05 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05");
		this.EquipD02c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD02c");
		this.EquipHead03_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01_1").getChild("EquipHead02_1").getChild("EquipHead03_1");
		this.EquipCL1a1_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1").getChild("EquipCL1Base01R2").getChild("EquipCL1a1_3");
		this.EquipD03c1b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c1b");
		this.Cloth02a1 = root.getChild("BodyMain").getChild("Butt").getChild("Cloth02a1");
		this.EquipCL1a2_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05").getChild("EquipCL1Base01L2").getChild("EquipCL1a1_1").getChild("EquipCL1a2_1");
		this.HairCBaseB = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairCBaseB");
		this.EquipD03aa = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03aa");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.EquipD03c1b_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c1b_1");
		this.EquipCL1Base02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05").getChild("EquipCL1Base01L2").getChild("EquipCL1Base02");
		this.ClothA01 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ClothA01");
		this.EquipCL1Base01b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1").getChild("EquipCL1Base01b");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.EquipD03c1a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c1a");
		this.EquipD01bb = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD01b").getChild("EquipD01bb");
		this.ClothA05a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ClothA02a").getChild("ClothA03a").getChild("ClothA04a").getChild("ClothA05a");
		this.EquipB05_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2");
		this.EquipCL1a2_6 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1").getChild("EquipCL1a1_6").getChild("EquipCL1a2_6");
		this.EquipCL1a1_5 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1").getChild("EquipCL1a1_5");
		this.EquipB05_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3");
		this.ClothA05 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ClothA02").getChild("ClothA03").getChild("ClothA04").getChild("ClothA05");
		this.EquipD03c3_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1");
		this.Cloth02c2 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1").getChild("Cloth02c2");
		this.Cloth02c3_1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1_1").getChild("Cloth02c2_1").getChild("Cloth02c3_1");
		this.EquipCL1a1_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1").getChild("EquipCL1Base01R2").getChild("EquipCL1a1_2");
		this.ClothA02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ClothA02");
		this.EquipD03a3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3");
		this.Cloth01b = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a").getChild("Cloth01b");
		this.EquipCL1Base01R2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1").getChild("EquipCL1Base01R2");
		this.Cloth02b3 = root.getChild("BodyMain").getChild("Butt").getChild("Cloth02b1").getChild("Cloth02b2").getChild("Cloth02b3");
		this.EquipD03c3a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipD03c3a");
		this.Cloth03b = root.getChild("BodyMain").getChild("BoobR").getChild("Cloth03b");
		this.BodyMain = root.getChild("BodyMain");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.EquipCL1a2_5 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1").getChild("EquipCL1a1_5").getChild("EquipCL1a2_5");
		this.Cloth01a = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a");
		this.EquipD03c2a_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c2a_1");
		this.EquipCL1a1_4 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1").getChild("EquipCL1a1_4");
		this.Cloth02b2 = root.getChild("BodyMain").getChild("Butt").getChild("Cloth02b1").getChild("Cloth02b2");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.ClothA03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ClothA02").getChild("ClothA03");
		this.EquipD03c2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2");
		this.EquipCL1Base01a_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1").getChild("EquipCL1Base01a_2");
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
				
		flag = !EmotionHelper.checkModelState(1, state);			//head equip
		this.EquipHeadBase.visible = !(flag);
	
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
this.animTransX += (0F); this.animTransY += (1.5F); this.animTransZ += (0F);
		break;
    	case 2:
this.animTransX += (0F); this.animTransY += (1.33F); this.animTransZ += (0F);
		break;
    	case 1:
this.animTransX += (0F); this.animTransY += (1.09F); this.animTransZ += (0F);
		break;
    	default:
this.animTransX += (0F); this.animTransY += (0.72F); this.animTransZ += (0F);
		break;
    	}
		
		this.setFaceHungry(ent);

		//head
	  	this.Head.xRot = f4 * 0.014F;
	  	this.Head.yRot = f3 * 0.01F;
	  	this.Ahoke.yRot = 0.65F;
	    //boob
  	    this.BoobL.xRot = -0.8F;
  	    this.BoobR.xRot = -0.8F;
  	    this.ClothB01.xRot = 0.96F;
	  	//body
	  	this.BodyMain.xRot = -1.75F;
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
	  	this.Hair01.xRot = 0.26F;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -0.17F;
	  	this.Hair02.zRot = 0F;
	  	//cloth
	  	this.ClothA03.yRot = 0F;
	  	this.ClothA03a.yRot = 0F;
	  	this.SkirtB01.xRot = 0.087F;
	  	this.Cloth02a1.xRot = -0.33F;
	  	this.Cloth02b1.xRot = -0.33F;
	  	this.Cloth02c1.xRot = 0.6283F;
		this.Cloth02c1_1.xRot = 0.6283F;
		this.Cloth02c2.xRot = -0.7854F;
		this.Cloth02c2_1.xRot = -0.7854F;
		this.Cloth02c3.xRot = -0.1396F;
		this.Cloth02c3_1.xRot = -0.1396F;
		this.Cloth02c4.xRot = -0F;
		this.Cloth02c4_1.xRot = 0F;
		this.Cloth02a2.xRot = 0.12F;
		this.Cloth02b2.xRot = 0.12F;
		this.Cloth02a3.xRot = 0F;
		this.Cloth02b3.xRot = 0F;
		this.ClothA03.y = (1.9F) + (0F) * 16F;
	  	this.ClothA04.y = (0.9F) + (0F) * 16F;
	  	this.ClothA05.y = (1.9F) + (0F) * 16F;
	  	this.ClothA03.z = (-2.2F) + (0F) * 16F;
	  	this.ClothA04.z = (0.8F) + (0F) * 16F;
	  	this.ClothA05.z = (0.8F) + (0F) * 16F;
	  	this.ClothA03a.y = (1.9F) + (0F) * 16F;
	  	this.ClothA04a.y = (0.9F) + (0F) * 16F;
	  	this.ClothA05a.y = (1.9F) + (0F) * 16F;
	  	this.ClothA03a.z = (-2.2F) + (0F) * 16F;
	  	this.ClothA04a.z = (0.8F) + (0F) * 16F;
	  	this.ClothA05a.z = (0.8F) + (0F) * 16F;
	    //arm 
	  	this.ArmLeft01.xRot = -0.087F;
	  	this.ArmLeft01.yRot = 0.873F;
	    this.ArmLeft01.zRot = -0.17F;
	    this.ArmLeft02.xRot = -2.1F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (-0.33F) * 16F;
	    this.ArmRight01.xRot = -0.087F;
	    this.ArmRight01.yRot = -0.873F;
		this.ArmRight01.zRot = 0.17F;
		this.ArmRight02.xRot = -2.1F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
		this.ArmRight02.z = (2.5F) + (-0.33F) * 16F;
		//leg
		this.LegLeft01.xRot = -0.1F;
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.02F;
		this.LegLeft01.y = (5.5F) + (0F) * 16F;
		this.LegLeft01.z = (-2.6F) + (0F) * 16F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (3.0F) + (0F) * 16F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.xRot = -0.1F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.02F;
		this.LegRight01.y = (5.5F) + (0F) * 16F;
		this.LegRight01.z = (-2.6F) + (0F) * 16F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
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
	  	this.Ahoke.yRot = angleX * 0.15F + 0.65F;
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
		this.ClothA03.x = (0.1F) + (0F) * 16F;
		this.ClothA03a.x = (-0.1F) + (0F) * 16F;
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
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
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
		this.EquipD03c1.zRot = -0.35F + this.Head.xRot * 0.5F;
		this.EquipD03c2.zRot = -0.26F + this.Head.xRot * 0.5F;
		this.EquipD03c3.zRot = 0.61F - this.Head.xRot * 1F;
		this.EquipD03d1.zRot = -this.EquipD03c1.zRot;
		this.EquipD03c2_1.zRot = this.EquipD03c2.zRot;
		this.EquipD03c3_1.zRot = this.EquipD03c3.zRot;
		this.EquipD03a1.zRot = 0.52F + this.Head.xRot * 0.5F;
		this.EquipD03b1.zRot = -this.EquipD03a1.zRot;
		this.EquipCL1Base01L1.yRot = this.Head.yRot * 0.75F;
		this.EquipCL1Base01L2.yRot = this.Head.yRot * 0.75F;
		this.EquipCL1Base01R1.yRot = this.Head.yRot * 0.75F;
		this.EquipCL1Base01R2.yRot = this.Head.yRot * 0.75F;
		
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
	    	this.ArmLeft01.xRot = 0.2F;
		  	this.ArmLeft01.yRot = 0.5F;
		    this.ArmLeft01.zRot = 0.17F;
		    this.ArmLeft02.xRot = -1.9F;
		    this.ArmLeft02.zRot = 0F;
		    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
		    this.ArmLeft02.z = (2.5F) + (-0.33F) * 16F;
		    this.ArmRight01.xRot = 0.2F;
		    this.ArmRight01.yRot = -0.5F;
			this.ArmRight01.zRot = -0.17F;
			this.ArmRight02.xRot = -1.9F;
			this.ArmRight02.zRot = 0F;
			this.ArmRight02.x = (-3.0F) + (0F) * 16F;
			this.ArmRight02.z = (2.5F) + (-0.33F) * 16F;
			this.ClothA03.yRot = 0.4F;
			this.ClothA03.x = (0.1F) + (0F) * 16F;
		  	this.ClothA03a.yRot = -0.4F;
		  	this.ClothA03a.x = (-0.1F) + (0F) * 16F;
			//leg
			addk1 = angleAdd1 * 0.35F - 0.48F;
		  	addk2 = angleAdd2 * 0.35F - 0.41F;
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
this.animTransX += (0F); this.animTransY += (0.79F); this.animTransZ += (0F);
				break;
		    	case 2:
this.animTransX += (0F); this.animTransY += (0.7F); this.animTransZ += (0F);
				break;
		    	case 1:
this.animTransX += (0F); this.animTransY += (0.58F); this.animTransZ += (0F);
				break;
		    	default:
this.animTransX += (0F); this.animTransY += (0.39F); this.animTransZ += (0F);
				break;
		    	}
				
		    	//Body
			  	this.Head.xRot -= 0.1F;
			  	this.BodyMain.xRot = 0F;
		    	this.Butt.xRot = -0.2F;
		    	this.Butt.y = (4.0F) + (0F) * 16F;
		    	//skirt
		    	this.Skirt01.xRot = -0.15F;
		    	this.Skirt02.xRot = 0.1F;
		    	this.SkirtB01.xRot = -0.1F;
				this.Cloth02a1.xRot = -0.6F;
			  	this.Cloth02b1.xRot = -0.6F;
			  	this.Cloth02c1.xRot = 1.27F;
			  	this.Cloth02c2.xRot = -0.8F;
			  	this.Cloth02c3.xRot = 1.05F;
			  	this.Cloth02c4.xRot = 0.35F;
			  	this.Cloth02c1_1.xRot = 1.27F;
			  	this.Cloth02c2_1.xRot = -0.8F;
			  	this.Cloth02c3_1.xRot = 1.05F;
			  	this.Cloth02c4_1.xRot = 0.35F;
			  	this.ClothA03.yRot = 0.7F;
				this.ClothA03.x = (0.1F) + (-0.2F) * 16F;
			  	this.ClothA03a.yRot = -0.7F;
			  	this.ClothA03a.x = (-0.1F) + (0.2F) * 16F;
		    	//arm
			  	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
			  	{
			  		this.ArmLeft01.xRot = -0.087F;
				  	this.ArmLeft01.yRot = 0.6F;
				    this.ArmLeft01.zRot = -0.1F;
				    this.ArmLeft02.xRot = -2.1F;
				    this.ArmLeft02.zRot = 0F;
				    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
				    this.ArmLeft02.z = (2.5F) + (-0.33F) * 16F;
				    this.ArmRight01.xRot = -0.087F;
				    this.ArmRight01.yRot = -0.6F;
					this.ArmRight01.zRot = 0.1F;
					this.ArmRight02.xRot = -2.1F;
					this.ArmRight02.zRot = 0F;
					this.ArmRight02.x = (-3.0F) + (0F) * 16F;
					this.ArmRight02.z = (2.5F) + (-0.33F) * 16F;
					this.ClothA03.yRot = -0.1F;
					this.ClothA03.x = (0.1F) + (0F) * 16F;
				  	this.ClothA03a.yRot = -0.1F;
				  	this.ClothA03a.x = (-0.1F) + (0F) * 16F;
			  	}
			  	else
			  	{
			  		this.ArmLeft01.xRot = -0.45F;
				  	this.ArmLeft01.zRot = 0.32F;
			    	this.ArmRight01.xRot = -0.45F;
					this.ArmRight01.zRot = -0.32F;
			  	}
			  	//leg
			  	addk1 = -0.65F;
			  	addk2 = -0.65F;
			  	this.LegLeft01.yRot = 0.1F;
				this.LegLeft01.zRot = 0F;
				this.LegLeft02.z = (-3.0F) + (0.375F) * 16F;
				this.LegLeft02.xRot = 2.45F;
				this.LegLeft02.zRot = 0.0175F;
				this.LegRight01.yRot = -0.1F;
				this.LegRight01.zRot = 0F;
				this.LegRight02.z = (-3.0F) + (0.375F) * 16F;
				this.LegRight02.xRot = 2.45F;
				this.LegRight02.zRot = -0.0175F;
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
  		  	this.ArmLeft01.xRot = 0.2F;
		  	this.ArmLeft01.yRot = 0.5F;
		    this.ArmLeft01.zRot = 0.1F;
		    this.ArmLeft02.xRot = -1.9F;
		    this.ArmLeft02.zRot = 0F;
		    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
		    this.ArmLeft02.z = (2.5F) + (-0.33F) * 16F;
		    this.ArmRight01.xRot = 0.2F;
		    this.ArmRight01.yRot = -0.5F;
			this.ArmRight01.zRot = -0.1F;
			this.ArmRight02.xRot = -1.9F;
			this.ArmRight02.zRot = 0F;
			this.ArmRight02.x = (-3.0F) + (0F) * 16F;
			this.ArmRight02.z = (2.5F) + (-0.33F) * 16F;
			this.ClothA03.yRot = -0.1F;
			this.ClothA03.x = (0.1F) + (0F) * 16F;
		  	this.ClothA03a.yRot = -0.1F;
		  	this.ClothA03a.x = (-0.1F) + (0F) * 16F;
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
  		  	this.ArmLeft01.xRot = 0.15F;
		  	this.ArmLeft01.yRot = 0.55F;
		    this.ArmLeft01.zRot = 0.15F;
		    this.ArmLeft02.xRot = -2.2F;
		    this.ArmLeft02.zRot = 0F;
		    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
		    this.ArmLeft02.z = (2.5F) + (-0.33F) * 16F;
		    this.ArmRight01.xRot = 0.15F;
		    this.ArmRight01.yRot = -0.55F;
			this.ArmRight01.zRot = -0.15F;
			this.ArmRight02.xRot = -2.2F;
			this.ArmRight02.zRot = 0F;
			this.ArmRight02.x = (-3.0F) + (0F) * 16F;
			this.ArmRight02.z = (2.5F) + (-0.33F) * 16F;
			this.ClothA03.yRot = -0.1F;
			this.ClothA03.x = (0.1F) + (0F) * 16F;
		  	this.ClothA03a.yRot = -0.1F;
		  	this.ClothA03a.x = (-0.1F) + (0F) * 16F;
		  	//leg
  			addk1 += 0.14F;
  			addk2 += 0.07F;
  			
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
	  	this.ClothA03.y = (1.9F) + (HandLc * 0.1F) * 16F;
	  	this.ClothA04.y = (0.9F) + (HandLc * 0.2F) * 16F;
	  	this.ClothA05.y = (1.9F) + (HandLc * 0.25F) * 16F;
	  	this.ClothA03.z = (-2.2F) + (HandLs * -0.32F) * 16F;
	  	this.ClothA04.z = (0.8F) + (HandLs * -0.32F) * 16F;
	  	this.ClothA05.z = (0.8F) + (HandLs * -0.32F) * 16F;
	  	this.ClothA03a.y = (1.9F) + (HandRc * 0.1F) * 16F;
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

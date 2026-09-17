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

public class ModelBBHiei<T extends Entity> extends ShipModelBaseAdv<T>
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
	public ModelPart Ahoke;
	public ModelPart Hair01;
	public ModelPart Hair01a;
	public ModelPart Hair02a;
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
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-2.5F, -3.0F, -2.9F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -9.6F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.4F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("EquipHeadBase", CubeListBuilder.create().addBox(-8.0F, 0.0F, 7.0F, 16.0F, 2.0F, 8.0F), PartPose.offset(0.0F, -11.8F, -7.6F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("EquipHead00", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -4.1F, 5.0F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef5 = partdef3.addOrReplaceChild("EquipHead01", CubeListBuilder.create().addBox(0.0F, -0.7F, -0.3F, 2.0F, 3.0F, 3.0F), PartPose.offset(6.7F, 0.2F, 5.7F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("EquipHead02", CubeListBuilder.create().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F), PartPose.offset(2.4F, 0.8F, 1.2F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("EquipHead03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 3.0F, 0.0F), PartPose.offset(0.2F, -1.5F, 0.0F));
		PartDefinition partdef8 = partdef3.addOrReplaceChild("EquipHead01_1", CubeListBuilder.create().addBox(-2.0F, -0.7F, -0.3F, 2.0F, 3.0F, 3.0F), PartPose.offset(-6.7F, 0.2F, 5.7F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("EquipHead02_1", CubeListBuilder.create().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F), PartPose.offset(-2.4F, 0.8F, 1.2F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("EquipHead03_1", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 5.0F, 3.0F, 0.0F), PartPose.offset(-0.2F, -1.5F, 0.0F));
		PartDefinition partdef11 = partdef2.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.1F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -5.0F, -10.5F, 0.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(-1.0F, -8.0F, -4.5F, 0.0F, 0.7853981633974483F, 0.0F));
		PartDefinition partdef13 = partdef11.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -7.0F));
		PartDefinition partdef14 = partdef2.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("Hair02a", CubeListBuilder.create().mirror().addBox(-6.0F, -6.0F, 0.0F, 6.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(-2.5F, 12.0F, 4.7F, 0.12217304763960307F, 0.20943951023931953F, -0.9599310885968813F));
		PartDefinition partdef16 = partdef14.addOrReplaceChild("Hair01a", CubeListBuilder.create().addBox(0.0F, -6.0F, 0.0F, 6.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(2.5F, 12.0F, 4.7F, 0.12217304763960307F, -0.20943951023931953F, 0.9599310885968813F));
		PartDefinition partdef17 = partdef14.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 6.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 11.2F, 3.8F, 0.5061454830783556F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef0.addOrReplaceChild("Cloth03a2", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 18.0F, 7.0F), PartPose.offset(-4.1F, -11.1F, -4.1F));
		PartDefinition partdef19 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(-3.5F, -8.2F, -3.8F, -0.8726646259971648F, -0.08726646259971647F, -0.06981317007977318F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("ClothB01", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(2.9F, 4.6F, 1.6F, 0.9599310885968813F, -0.006806784082777885F, 0.09477137838329208F));
		PartDefinition partdef21 = partdef19.addOrReplaceChild("Cloth03b", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-0.6F, -0.8F, -0.1F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef22 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.27314402793711257F, 0.0F, -0.3141592653589793F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("ClothA01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(0.5F, 5.1F, 0.0F));
		PartDefinition partdef24 = partdef22.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(3.0F, 11.0F, 2.5F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("ClothA02", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F), PartPose.offset(-2.5F, -0.1F, -2.5F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("ClothA03", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 6.0F), PartPose.offset(0.1F, 1.9F, -2.2F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("ClothA04", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 0.9F, 0.8F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("ClothA05", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 1.9F, 0.8F));
		PartDefinition partdef29 = partdef0.addOrReplaceChild("Cloth03a1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 18.0F, 7.0F), PartPose.offset(4.1F, -11.1F, -4.1F));
		PartDefinition partdef30 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, -0.08726646259971647F, 0.0F, 0.3141592653589793F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(-3.0F, 11.0F, 2.5F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("ClothA02a", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F), PartPose.offsetAndRotation(2.5F, -0.1F, -2.5F, 0.0F, 0.012808717561550659F, 0.0F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("ClothA03a", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 6.0F), PartPose.offset(-0.1F, 1.9F, -2.2F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("ClothA04a", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 0.9F, 0.8F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("ClothA05a", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 1.9F, 0.8F));
		PartDefinition partdef36 = partdef30.addOrReplaceChild("ClothA01_1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(-0.5F, 5.1F, 0.0F));
		PartDefinition partdef37 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("Cloth02a1", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(4.0F, 2.3F, -6.8F, -0.4363323129985824F, 0.0F, -0.06981317007977318F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("Cloth02a2", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.9F, 0.0F, 0.24434609527920614F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef40 = partdef39.addOrReplaceChild("Cloth02a3", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.0F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef41 = partdef37.addOrReplaceChild("LegRight01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.19198621771937624F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("LegRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(-3.0F, 14.0F, -3.0F));
		PartDefinition partdef43 = partdef37.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -8.5F, 17.0F, 5.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 3.5F, 1.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-9.5F, 0.0F, -6.5F, 19.0F, 5.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 3.5F, -2.7F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef45 = partdef37.addOrReplaceChild("SkirtB01", CubeListBuilder.create().addBox(-8.0F, 0.0F, -4.5F, 16.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.5F, -1.9F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("Cloth02c1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 0.0F), PartPose.offsetAndRotation(2.6F, 1.9F, 4.4F, 0.6283185307179586F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("Cloth02c2", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("Cloth02c3", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 6.9F, 0.0F, -0.13962634015954636F, 0.0F, 0.03490658503988659F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("Cloth02c4", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F), PartPose.offset(0.0F, 7.9F, 0.0F));
		PartDefinition partdef50 = partdef45.addOrReplaceChild("Cloth02c1_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 0.0F), PartPose.offsetAndRotation(-2.6F, 1.9F, 4.4F, 0.6283185307179586F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("Cloth02c2_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("Cloth02c3_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 6.9F, 0.0F, -0.13962634015954636F, 0.0F, -0.03490658503988659F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("Cloth02c4_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F), PartPose.offset(0.0F, 7.9F, 0.0F));
		PartDefinition partdef54 = partdef45.addOrReplaceChild("Cloth01a", CubeListBuilder.create().addBox(-1.0F, -2.5F, -1.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 2.3F, -5.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("Cloth01b", CubeListBuilder.create().addBox(-6.0F, -3.0F, -1.0F, 6.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 0.3F, 0.08726646259971647F, -0.17453292519943295F, -0.3490658503988659F));
		PartDefinition partdef56 = partdef54.addOrReplaceChild("Cloth01c2", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(2.0F, -0.4F, -0.7F, -0.2617993877991494F, -0.13962634015954636F, -0.17453292519943295F));
		PartDefinition partdef57 = partdef54.addOrReplaceChild("Cloth01c", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(-2.0F, -0.4F, -0.7F, -0.2617993877991494F, 0.13962634015954636F, 0.17453292519943295F));
		PartDefinition partdef58 = partdef54.addOrReplaceChild("Cloth01b2", CubeListBuilder.create().addBox(0.0F, -3.0F, -1.0F, 6.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 0.3F, 0.08726646259971647F, 0.17453292519943295F, 0.3490658503988659F));
		PartDefinition partdef59 = partdef37.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.296705972839036F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef60 = partdef59.addOrReplaceChild("LegLeft02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(3.0F, 14.0F, -3.0F));
		PartDefinition partdef61 = partdef37.addOrReplaceChild("Cloth02b1", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(-4.0F, 2.3F, -6.8F, -0.4363323129985824F, 0.0F, 0.06981317007977318F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("Cloth02b2", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.9F, 0.0F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("Cloth02b3", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.9F, 0.0F, 0.0F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef64 = partdef0.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, 7.5F, 5.5F));
		PartDefinition partdef65 = partdef64.addOrReplaceChild("EquipD01a", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 10.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, 0.06981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef66 = partdef65.addOrReplaceChild("EquipD02d", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 12.0F, 4.0F), PartPose.offset(-5.9F, 5.0F, 5.9F));
		PartDefinition partdef67 = partdef65.addOrReplaceChild("EquipD02a", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -0.6F, 7.0F, 14.0F, 5.0F), PartPose.offset(3.4F, 5.0F, 1.7F));
		PartDefinition partdef68 = partdef65.addOrReplaceChild("EquipD03d1", CubeListBuilder.create().addBox(0.0F, -1.5F, 0.0F, 8.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-5.0F, 5.5F, 7.0F, 0.0F, 3.141592653589793F, 0.3490658503988659F));
		PartDefinition partdef69 = partdef68.addOrReplaceChild("EquipD03c2_1", CubeListBuilder.create().addBox(0.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(8.0F, -0.2F, 1.5F, 0.0F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef70 = partdef69.addOrReplaceChild("EquipD03c2a_1", CubeListBuilder.create().addBox(0.0F, -1.5F, -4.5F, 8.0F, 3.0F, 9.0F), PartPose.offset(1.5F, 0.1F, 0.0F));
		PartDefinition partdef71 = partdef69.addOrReplaceChild("EquipD03c3_1", CubeListBuilder.create().addBox(0.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(7.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6108652381980153F));
		PartDefinition partdef72 = partdef71.addOrReplaceChild("EquipB05_3", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(6.3F, -2.0F, 0.0F, 0.0F, 3.141592653589793F, 0.0F));
		PartDefinition partdef73 = partdef72.addOrReplaceChild("EquipCL1Base01R1", CubeListBuilder.create().addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F), PartPose.offset(0.2F, 0.1F, 0.0F));
		PartDefinition partdef74 = partdef73.addOrReplaceChild("EquipCL1Base01b_1", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -5.6F, 2.0F));
		PartDefinition partdef75 = partdef73.addOrReplaceChild("EquipCL1Base02_3", CubeListBuilder.create().addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef76 = partdef73.addOrReplaceChild("EquipCL1a1_6", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.18203784098300857F, 0.0F, 0.0F));
		PartDefinition partdef77 = partdef76.addOrReplaceChild("EquipCL1a2_6", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef78 = partdef73.addOrReplaceChild("EquipCL1a1_7", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.16982053621904827F, 0.0F, 0.0F));
		PartDefinition partdef79 = partdef78.addOrReplaceChild("EquipCL1a2_7", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef80 = partdef73.addOrReplaceChild("EquipCL1Base01a_3", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -5.4F, -1.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef81 = partdef71.addOrReplaceChild("EquipD03c3a_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 8.0F, 3.0F, 9.0F), PartPose.offset(2.3F, -1.4F, -4.5F));
		PartDefinition partdef82 = partdef68.addOrReplaceChild("EquipD03c1b_1", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F), PartPose.offset(7.2F, -1.0F, 1.5F));
		PartDefinition partdef83 = partdef68.addOrReplaceChild("EquipD03c1a_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.2F, 0.0F));
		PartDefinition partdef84 = partdef65.addOrReplaceChild("EquipD03b1", CubeListBuilder.create().addBox(0.5F, -1.0F, -2.5F, 6.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(-5.0F, 5.8F, 7.5F, 0.0F, 3.141592653589793F, -0.5235987755982988F));
		PartDefinition partdef85 = partdef84.addOrReplaceChild("EquipD03a2_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(6.4F, -1.0F, -2.5F));
		PartDefinition partdef86 = partdef85.addOrReplaceChild("EquipD03a3_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(5.9F, 0.0F, 0.0F));
		PartDefinition partdef87 = partdef86.addOrReplaceChild("EquipD03a4_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(5.9F, 0.0F, 0.0F));
		PartDefinition partdef88 = partdef87.addOrReplaceChild("EquipB05_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(1.5F, -0.4F, 4.5F, 0.0F, 3.141592653589793F, 0.0F));
		PartDefinition partdef89 = partdef88.addOrReplaceChild("EquipCL1Base01R2", CubeListBuilder.create().addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F), PartPose.offset(0.2F, 0.1F, 0.0F));
		PartDefinition partdef90 = partdef89.addOrReplaceChild("EquipCL1Base02_1", CubeListBuilder.create().addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef91 = partdef89.addOrReplaceChild("EquipCL1Base01a_1", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -5.4F, -1.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef92 = partdef89.addOrReplaceChild("EquipCL1a1_2", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.18203784098300857F, 0.0F, 0.0F));
		PartDefinition partdef93 = partdef92.addOrReplaceChild("EquipCL1a2_2", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef94 = partdef89.addOrReplaceChild("EquipCL1a1_3", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.16982053621904827F, 0.0F, 0.0F));
		PartDefinition partdef95 = partdef94.addOrReplaceChild("EquipCL1a2_3", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef96 = partdef84.addOrReplaceChild("EquipD03aa_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 3.0F, 1.0F), PartPose.offset(-0.5F, -1.5F, -3.4F));
		PartDefinition partdef97 = partdef84.addOrReplaceChild("EquipD03ab_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 3.0F, 1.0F), PartPose.offset(-0.5F, -1.5F, 6.4F));
		PartDefinition partdef98 = partdef65.addOrReplaceChild("EquipD03a1", CubeListBuilder.create().addBox(0.5F, -1.0F, -2.5F, 6.0F, 2.0F, 9.0F), PartPose.offsetAndRotation(5.0F, 5.8F, 3.5F, 0.0F, 0.0F, 0.5235987755982988F));
		PartDefinition partdef99 = partdef98.addOrReplaceChild("EquipD03aa", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 3.0F, 1.0F), PartPose.offset(-0.5F, -1.5F, -3.4F));
		PartDefinition partdef100 = partdef98.addOrReplaceChild("EquipD03ab", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 3.0F, 1.0F), PartPose.offset(-0.5F, -1.5F, 6.4F));
		PartDefinition partdef101 = partdef98.addOrReplaceChild("EquipD03a2", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(6.4F, -1.0F, -2.5F));
		PartDefinition partdef102 = partdef101.addOrReplaceChild("EquipD03a3", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(5.9F, 0.0F, 0.0F));
		PartDefinition partdef103 = partdef102.addOrReplaceChild("EquipD03a4", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F), PartPose.offset(5.9F, 0.0F, 0.0F));
		PartDefinition partdef104 = partdef103.addOrReplaceChild("EquipB05", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offset(1.5F, -0.4F, 4.5F));
		PartDefinition partdef105 = partdef104.addOrReplaceChild("EquipCL1Base01L2", CubeListBuilder.create().addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F), PartPose.offset(0.2F, 0.1F, 0.0F));
		PartDefinition partdef106 = partdef105.addOrReplaceChild("EquipCL1Base01a", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -5.4F, -1.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef107 = partdef105.addOrReplaceChild("EquipCL1a1_1", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.16982053621904827F, 0.0F, 0.0F));
		PartDefinition partdef108 = partdef107.addOrReplaceChild("EquipCL1a2_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef109 = partdef105.addOrReplaceChild("EquipCL1Base02", CubeListBuilder.create().addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef110 = partdef105.addOrReplaceChild("EquipCL1a1", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.18203784098300857F, 0.0F, 0.0F));
		PartDefinition partdef111 = partdef110.addOrReplaceChild("EquipCL1a2", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef112 = partdef65.addOrReplaceChild("EquipD02b", CubeListBuilder.create().addBox(-3.5F, 0.0F, -0.6F, 7.0F, 14.0F, 5.0F), PartPose.offset(-3.4F, 5.0F, 1.7F));
		PartDefinition partdef113 = partdef65.addOrReplaceChild("EquipD01b", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 9.0F, 6.0F), PartPose.offset(0.0F, 0.4F, 5.9F));
		PartDefinition partdef114 = partdef113.addOrReplaceChild("EquipD01bb", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 4.9F, 6.0F));
		PartDefinition partdef115 = partdef113.addOrReplaceChild("EquipD01ba", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 1.0F, 6.0F));
		PartDefinition partdef116 = partdef65.addOrReplaceChild("EquipD02c", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 6.0F, 12.0F, 4.0F), PartPose.offset(3.3F, 5.0F, 5.9F));
		PartDefinition partdef117 = partdef65.addOrReplaceChild("EquipD03c1", CubeListBuilder.create().addBox(0.0F, -1.5F, 0.0F, 8.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(5.0F, 5.5F, 4.0F, 0.0F, 0.0F, -0.3490658503988659F));
		PartDefinition partdef118 = partdef117.addOrReplaceChild("EquipD03c2", CubeListBuilder.create().addBox(0.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(8.0F, -0.2F, 1.5F, 0.0F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef119 = partdef118.addOrReplaceChild("EquipD03c2a", CubeListBuilder.create().addBox(0.0F, -1.5F, -4.5F, 8.0F, 3.0F, 9.0F), PartPose.offset(1.5F, 0.1F, 0.0F));
		PartDefinition partdef120 = partdef118.addOrReplaceChild("EquipD03c3", CubeListBuilder.create().addBox(0.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(7.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6108652381980153F));
		PartDefinition partdef121 = partdef120.addOrReplaceChild("EquipB05_2", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F), PartPose.offset(6.3F, -2.0F, 0.0F));
		PartDefinition partdef122 = partdef121.addOrReplaceChild("EquipCL1Base01L1", CubeListBuilder.create().addBox(-4.5F, -4.0F, -1.5F, 9.0F, 4.0F, 8.0F), PartPose.offset(0.2F, 0.1F, 0.0F));
		PartDefinition partdef123 = partdef122.addOrReplaceChild("EquipCL1a1_5", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -2.3F, -2.5F, -0.16982053621904827F, 0.0F, 0.0F));
		PartDefinition partdef124 = partdef123.addOrReplaceChild("EquipCL1a2_5", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef125 = partdef122.addOrReplaceChild("EquipCL1Base01b", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -5.6F, 2.0F));
		PartDefinition partdef126 = partdef122.addOrReplaceChild("EquipCL1Base02_2", CubeListBuilder.create().addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.3F, -2.8F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef127 = partdef122.addOrReplaceChild("EquipCL1a1_4", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -2.3F, -2.5F, -0.18203784098300857F, 0.0F, 0.0F));
		PartDefinition partdef128 = partdef127.addOrReplaceChild("EquipCL1a2_4", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef129 = partdef122.addOrReplaceChild("EquipCL1Base01a_2", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -5.4F, -1.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef130 = partdef120.addOrReplaceChild("EquipD03c3a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 8.0F, 3.0F, 9.0F), PartPose.offset(2.3F, -1.4F, -4.5F));
		PartDefinition partdef131 = partdef117.addOrReplaceChild("EquipD03c1b", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 2.0F, 2.0F, 1.0F), PartPose.offset(7.2F, -1.0F, 1.5F));
		PartDefinition partdef132 = partdef117.addOrReplaceChild("EquipD03c1a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 8.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.2F, 0.0F));
		PartDefinition partdef133 = partdef65.addOrReplaceChild("EquipD01aa", CubeListBuilder.create().addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 9.5F, -4.0F, 0.22689280275926282F, 0.0F, 0.0F));
		PartDefinition partdef134 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(3.5F, -8.2F, -3.7F, -0.8726646259971648F, 0.08726646259971647F, 0.06981317007977318F));
		PartDefinition partdef135 = partdef134.addOrReplaceChild("Cloth03b_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(0.6F, -0.8F, -0.1F, 0.0F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef136 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0F));
		PartDefinition partdef137 = partdef136.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.6F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef138 = partdef137.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef139 = partdef138.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef140 = partdef138.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef141 = partdef138.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef142 = partdef138.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef143 = partdef138.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef144 = partdef138.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef145 = partdef138.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef146 = partdef138.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef147 = partdef138.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef148 = partdef138.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelBBHiei(ModelPart root)
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
		this.Hair02a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair02a");
		this.EquipCL1Base01b_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1").getChild("EquipCL1Base01b_1");
		this.Cloth02a1 = root.getChild("BodyMain").getChild("Butt").getChild("Cloth02a1");
		this.EquipCL1Base01R2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1").getChild("EquipCL1Base01R2");
		this.ClothA01 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ClothA01");
		this.EquipCL1Base02_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1").getChild("EquipCL1Base01R2").getChild("EquipCL1Base02_1");
		this.Hair01a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01a");
		this.Cloth02a2 = root.getChild("BodyMain").getChild("Butt").getChild("Cloth02a1").getChild("Cloth02a2");
		this.EquipD02d = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD02d");
		this.EquipCL1a2_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05").getChild("EquipCL1Base01L2").getChild("EquipCL1a1_1").getChild("EquipCL1a2_1");
		this.EquipCL1Base02_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1").getChild("EquipCL1Base02_3");
		this.EquipHead02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01").getChild("EquipHead02");
		this.EquipHead02_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01_1").getChild("EquipHead02_1");
		this.EquipD02a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD02a");
		this.EquipD03d1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.EquipHead00 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead00");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.EquipD01bb = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD01b").getChild("EquipD01bb");
		this.Cloth02c1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1");
		this.ClothA05a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ClothA02a").getChild("ClothA03a").getChild("ClothA04a").getChild("ClothA05a");
		this.EquipD03b1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1");
		this.EquipHead01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01");
		this.ClothA03a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ClothA02a").getChild("ClothA03a");
		this.Cloth03a2 = root.getChild("BodyMain").getChild("Cloth03a2");
		this.EquipB05 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.ClothA04a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ClothA02a").getChild("ClothA03a").getChild("ClothA04a");
		this.EquipCL1Base01a_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1").getChild("EquipCL1Base01R2").getChild("EquipCL1Base01a_1");
		this.EquipB05_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1");
		this.EquipHeadBase = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase");
		this.ClothA02a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ClothA02a");
		this.EquipD03c2a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c2a");
		this.EquipD03c2a_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c2a_1");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.ClothA02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ClothA02");
		this.EquipCL1a1_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1").getChild("EquipCL1Base01R2").getChild("EquipCL1a1_2");
		this.EquipB05_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2");
		this.EquipCL1a2_4 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1").getChild("EquipCL1a1_4").getChild("EquipCL1a2_4");
		this.Cloth02c2 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1").getChild("Cloth02c2");
		this.EquipD03a2_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1");
		this.EquipD03a1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.EquipD01ba = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD01b").getChild("EquipD01ba");
		this.EquipCL1a2_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1").getChild("EquipCL1Base01R2").getChild("EquipCL1a1_3").getChild("EquipCL1a2_3");
		this.EquipCL1a1_6 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1").getChild("EquipCL1a1_6");
		this.Cloth02c2_1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1_1").getChild("Cloth02c2_1");
		this.EquipCL1Base01a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05").getChild("EquipCL1Base01L2").getChild("EquipCL1Base01a");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.EquipD03a4 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4");
		this.EquipHead03_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01_1").getChild("EquipHead02_1").getChild("EquipHead03_1");
		this.Cloth02c3 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1").getChild("Cloth02c2").getChild("Cloth02c3");
		this.EquipB05_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.Cloth03a1 = root.getChild("BodyMain").getChild("Cloth03a1");
		this.EquipD03c3a_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipD03c3a_1");
		this.EquipD03aa = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03aa");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.EquipCL1a1_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05").getChild("EquipCL1Base01L2").getChild("EquipCL1a1_1");
		this.Cloth02c1_1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1_1");
		this.Cloth02b2 = root.getChild("BodyMain").getChild("Butt").getChild("Cloth02b1").getChild("Cloth02b2");
		this.ClothA05 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ClothA02").getChild("ClothA03").getChild("ClothA04").getChild("ClothA05");
		this.EquipD03c2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.BodyMain = root.getChild("BodyMain");
		this.EquipD01a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.EquipHead01_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01_1");
		this.Cloth02a3 = root.getChild("BodyMain").getChild("Butt").getChild("Cloth02a1").getChild("Cloth02a2").getChild("Cloth02a3");
		this.EquipCL1a1_5 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1").getChild("EquipCL1a1_5");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.EquipCL1a1_7 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1").getChild("EquipCL1a1_7");
		this.Cloth02c4 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1").getChild("Cloth02c2").getChild("Cloth02c3").getChild("Cloth02c4");
		this.Cloth01b = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a").getChild("Cloth01b");
		this.SkirtB01 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.EquipCL1a2_7 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1").getChild("EquipCL1a1_7").getChild("EquipCL1a2_7");
		this.EquipCL1Base01R1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1");
		this.EquipBase = root.getChild("BodyMain").getChild("EquipBase");
		this.EquipD03c2_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1");
		this.EquipD02b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD02b");
		this.Cloth02b3 = root.getChild("BodyMain").getChild("Butt").getChild("Cloth02b1").getChild("Cloth02b2").getChild("Cloth02b3");
		this.EquipD03a3_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1");
		this.ClothB01 = root.getChild("BodyMain").getChild("BoobR").getChild("ClothB01");
		this.EquipD03c1b_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c1b_1");
		this.EquipCL1Base01L2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05").getChild("EquipCL1Base01L2");
		this.EquipCL1Base01L1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1");
		this.Cloth03b = root.getChild("BodyMain").getChild("BoobR").getChild("Cloth03b");
		this.ClothA04 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ClothA02").getChild("ClothA03").getChild("ClothA04");
		this.EquipCL1Base01a_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1").getChild("EquipCL1Base01a_3");
		this.EquipCL1Base01b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1").getChild("EquipCL1Base01b");
		this.EquipCL1a1_3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1").getChild("EquipCL1Base01R2").getChild("EquipCL1a1_3");
		this.EquipD03c3a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipD03c3a");
		this.EquipD03c1a_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c1a_1");
		this.Cloth02c3_1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1_1").getChild("Cloth02c2_1").getChild("Cloth02c3_1");
		this.ClothA01_1 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ClothA01_1");
		this.EquipD03c1b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c1b");
		this.Cloth01c2 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a").getChild("Cloth01c2");
		this.EquipD03c3_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1");
		this.Cloth01c = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a").getChild("Cloth01c");
		this.Cloth01a = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a");
		this.EquipCL1Base02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05").getChild("EquipCL1Base01L2").getChild("EquipCL1Base02");
		this.EquipD01b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD01b");
		this.EquipD03a3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3");
		this.Cloth03b_1 = root.getChild("BodyMain").getChild("BoobL").getChild("Cloth03b_1");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.EquipCL1a2_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1").getChild("EquipB05_1").getChild("EquipCL1Base01R2").getChild("EquipCL1a1_2").getChild("EquipCL1a2_2");
		this.EquipD02c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD02c");
		this.HairU01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairU01");
		this.Cloth02c4_1 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth02c1_1").getChild("Cloth02c2_1").getChild("Cloth02c3_1").getChild("Cloth02c4_1");
		this.Cloth01b2 = root.getChild("BodyMain").getChild("Butt").getChild("SkirtB01").getChild("Cloth01a").getChild("Cloth01b2");
		this.EquipD03c3 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3");
		this.EquipCL1Base02_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1").getChild("EquipCL1Base02_2");
		this.EquipD03ab = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03ab");
		this.EquipD03aa_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03aa_1");
		this.EquipCL1a1_4 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1").getChild("EquipCL1a1_4");
		this.EquipCL1Base01a_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1").getChild("EquipCL1Base01a_2");
		this.EquipHead03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01").getChild("EquipHead02").getChild("EquipHead03");
		this.EquipD03a2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2");
		this.Cloth02b1 = root.getChild("BodyMain").getChild("Butt").getChild("Cloth02b1");
		this.EquipD03a4_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03a2_1").getChild("EquipD03a3_1").getChild("EquipD03a4_1");
		this.EquipD03c1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1");
		this.EquipD01aa = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD01aa");
		this.EquipD03ab_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03b1").getChild("EquipD03ab_1");
		this.EquipD03c1a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c1a");
		this.EquipCL1a2_6 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03d1").getChild("EquipD03c2_1").getChild("EquipD03c3_1").getChild("EquipB05_3").getChild("EquipCL1Base01R1").getChild("EquipCL1a1_6").getChild("EquipCL1a2_6");
		this.ClothA03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ClothA02").getChild("ClothA03");
		this.EquipCL1a2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05").getChild("EquipCL1Base01L2").getChild("EquipCL1a1").getChild("EquipCL1a2");
		this.EquipCL1a1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03a1").getChild("EquipD03a2").getChild("EquipD03a3").getChild("EquipD03a4").getChild("EquipB05").getChild("EquipCL1Base01L2").getChild("EquipCL1a1");
		this.EquipCL1a2_5 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipD01a").getChild("EquipD03c1").getChild("EquipD03c2").getChild("EquipD03c3").getChild("EquipB05_2").getChild("EquipCL1Base01L1").getChild("EquipCL1a1_5").getChild("EquipCL1a2_5");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
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
this.animTransX += (0F); this.animTransY += (1.22F); this.animTransZ += (0F);
		break;
    	case 2:
this.animTransX += (0F); this.animTransY += (1.1F); this.animTransZ += (0F);
		break;
    	case 1:
this.animTransX += (0F); this.animTransY += (0.89F); this.animTransZ += (0F);
		break;
    	default:
this.animTransX += (0F); this.animTransY += (0.6F); this.animTransZ += (0F);
		break;
    	}

		this.setFaceHungry(ent);
		
		//hair
    	this.Ahoke.xRot = 0F;
    	this.Ahoke.yRot = 0.78F;
    	this.Ahoke.zRot = 0F;
		//body
		this.Head.xRot = 0.15F;
		this.Head.yRot = 0.0F;
		this.Head.zRot = 0.0F;
		this.BodyMain.xRot = 1.7453292519943295F;
		this.BodyMain.yRot = 0.0F;
		this.BodyMain.zRot = -0.5235987755982988F;
		this.Butt.xRot = -0.7853981633974483F;
		this.Butt.yRot = 0.0F;
		this.Butt.zRot = 0.0F;
		this.Butt.y = (4.0F) + (0F) * 16F;
	  	this.Butt.z = (1.3F) + (0F) * 16F;
		this.BoobL.xRot = -0.8F;
  	    this.BoobR.xRot = -0.8F;
    	this.ClothB01.xRot = 0.96F;
		//cloth
    	this.Skirt01.xRot = -0.087F;
    	this.Skirt01.y = (3.5F) + (0F) * 16F;
	  	this.Skirt01.z = (1.5F) + (0F) * 16F;
	  	this.Skirt02.xRot = -0.087F;
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
		this.ClothA03.x = (0.1F) + (0F) * 16F;
		this.ClothA03.y = (1.9F) + (0F) * 16F;
		this.ClothA03.z = (-2.2F) + (0F) * 16F;
	  	this.ClothA04.y = (0.9F) + (0F) * 16F;
	  	this.ClothA04.z = (0.8F) + (0F) * 16F;
	  	this.ClothA05.y = (1.9F) + (0F) * 16F;
	  	this.ClothA05.z = (0.8F) + (0F) * 16F;
	  	this.ClothA03a.x = (-0.1F) + (0F) * 16F;
	  	this.ClothA03a.y = (1.9F) + (0F) * 16F;
	  	this.ClothA03a.z = (-2.2F) + (0F) * 16F;
	  	this.ClothA04a.y = (0.9F) + (0F) * 16F;
	  	this.ClothA04a.z = (0.8F) + (0F) * 16F;
	  	this.ClothA05a.y = (1.9F) + (0F) * 16F;
	  	this.ClothA05a.z = (0.8F) + (0F) * 16F;
		//arm
		this.ArmLeft01.xRot = -1.3962634015954636F;
		this.ArmLeft01.yRot = -0.3490658503988659F;
		this.ArmLeft01.zRot = -0.17453292519943295F;
		this.ArmLeft02.xRot = -1.48352986419518F;
		this.ArmLeft02.yRot = 0.0F;
		this.ArmLeft02.zRot = 0.0F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (-0.2F) * 16F;
		this.ArmRight01.xRot = -1.3089969389957472F;
		this.ArmRight01.yRot = -0.8726646259971648F;
		this.ArmRight01.zRot = 0.0F;
		this.ArmRight02.xRot = 0.0F;
		this.ArmRight02.yRot = 0.0F;
		this.ArmRight02.zRot = -0.17453292519943295F;
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
		this.ArmRight02.z = (2.5F) + (0F) * 16F;
		//leg
		this.LegLeft01.xRot = -0.6981317007977318F;
		this.LegLeft01.yRot = -0.6981317007977318F;
		this.LegLeft01.zRot = -0.2617993877991494F;
		this.LegLeft01.x = (4.8F) + (0F) * 16F;
		this.LegLeft01.y = (5.5F) + (0F) * 16F;
		this.LegLeft01.z = (-2.6F) + (0F) * 16F;
		this.LegLeft02.xRot = 1.5707963267948966F;
		this.LegLeft02.yRot = 0.0F;
		this.LegLeft02.zRot = 0.0F;
		this.LegLeft02.x = (3.0F) + (0F) * 16F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.xRot = 0.0F;
		this.LegRight01.yRot = -0.7853981633974483F;
		this.LegRight01.zRot = -0.5759586531581287F;
		this.LegRight01.y = (5.5F) + (0F) * 16F;
		this.LegRight01.z = (-2.6F) + (0F) * 16F;
		this.LegRight02.xRot = 1.3089969389957472F;
		this.LegRight02.yRot = 0.0F;
		this.LegRight02.zRot = 0.0F;
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
  		float addCA031 = 0;
  		float addCA032 = 0;
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
		this.ClothA03.y = (1.9F) + (0F) * 16F;
		this.ClothA03.z = (-2.2F) + (0F) * 16F;
	  	this.ClothA04.y = (0.9F) + (0F) * 16F;
	  	this.ClothA04.z = (0.8F) + (0F) * 16F;
	  	this.ClothA05.y = (1.9F) + (0F) * 16F;
	  	this.ClothA05.z = (0.8F) + (0F) * 16F;
	  	this.ClothA03a.x = (-0.1F) + (0F) * 16F;
	  	this.ClothA03a.y = (1.9F) + (0F) * 16F;
	  	this.ClothA03a.z = (-2.2F) + (0F) * 16F;
	  	this.ClothA04a.y = (0.9F) + (0F) * 16F;
	  	this.ClothA04a.z = (0.8F) + (0F) * 16F;
	  	this.ClothA05a.y = (1.9F) + (0F) * 16F;
	  	this.ClothA05a.z = (0.8F) + (0F) * 16F;
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
			this.ArmRight02.x = (-3.0F) + (0F) * 16F;
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
this.animTransX += (0F); this.animTransY += (1.11F); this.animTransZ += (0F);
				break;
		    	case 2:
this.animTransX += (0F); this.animTransY += (0.99F); this.animTransZ += (0F);
				break;
		    	case 1:
this.animTransX += (0F); this.animTransY += (0.81F); this.animTransZ += (0F);
				break;
		    	default:
this.animTransX += (0F); this.animTransY += (0.53F); this.animTransZ += (0F);
				break;
		    	}
		    	
		    	//head
		    	this.Head.xRot -= 0.1F;
		    	//body
		    	this.BodyMain.xRot = -0.25F;
		    	this.Butt.xRot = -0.2F;
		    	this.Butt.y = (4.0F) + (-0.1F) * 16F;
				this.Skirt01.xRot = -0.07F;
				this.Skirt01.y = (3.5F) + (-0.03F) * 16F;
				this.Skirt02.xRot = -0.16F;
				this.Skirt02.y = (3.5F) + (0F) * 16F;
				this.SkirtB01.xRot = -0.1F;
				this.Cloth02a1.xRot = -0.84F;
			  	this.Cloth02b1.xRot = -0.84F;
			  	this.Cloth02c1.xRot = 1.64F;
			  	this.Cloth02c2.xRot = -0.3F;
			  	this.Cloth02c3.xRot = 0.7F;
			  	this.Cloth02c4.xRot = 0.1F;
			  	this.Cloth02c1_1.xRot = 1.64F;
			  	this.Cloth02c2_1.xRot = -0.3F;
			  	this.Cloth02c3_1.xRot = 0.7F;
			  	this.Cloth02c4_1.xRot = 0.1F;
			  	this.ClothA03.yRot = 0.7F;
				this.ClothA03.x = (0.1F) + (-0.2F) * 16F;
			  	this.ClothA03a.yRot = -0.7F;
			  	this.ClothA03a.x = (-0.1F) + (0.2F) * 16F;
			  	addCA031 = 0F;
		    	addCA032 = 0F;
				//arm 
				this.ArmLeft01.xRot = 2.5F;
			    this.ArmLeft01.zRot = 0.1F;
			    this.ArmLeft02.zRot = 1F;
			    this.ArmRight01.xRot = 2.5F;
				this.ArmRight01.zRot = -0.1F;
				this.ArmRight02.zRot = -1F;
				//leg
				addk1 = -0.9F;
				addk2 = -0.9F;
				this.LegLeft01.zRot = -0.14F;
				this.LegLeft02.xRot = 1.2217F;
				this.LegLeft02.yRot = 1.2217F;
				this.LegLeft02.zRot = -1.0472F;
				this.LegLeft02.x = (3.0F) + (0F) * 16F;
				this.LegLeft02.y = (14.0F) + (0F) * 16F;
				this.LegLeft02.z = (-3.0F) + (0F) * 16F;
				this.LegRight01.zRot = 0.14F;
				this.LegRight02.xRot = 1.2217F;
				this.LegRight02.yRot = -1.2217F;
				this.LegRight02.zRot = 1.0472F;
				this.LegRight02.x = (-3.0F) + (0F) * 16F;
				this.LegRight02.y = (14.0F) + (0F) * 16F;
				this.LegRight02.z = (-3.0F) + (0F) * 16F;
				
				//arm special
		    	float parTick = f2 - (int)f2 + (ent.getTickExisted() % 256);
		    	
		    	if (parTick < 30F)
		    	{
		    		float az = Mth.sin(parTick * 0.033F * 1.5708F);
			    	
			    	setFace(3);
		    		//arm 
				    this.ArmLeft01.zRot = 0.1F + az * 1.8F;
				    this.ArmLeft02.zRot = 1F - az * 2.88F;
				    if(this.ArmLeft02.zRot < 0F) this.ArmLeft02.zRot = 0F;
					this.ArmRight01.zRot = -this.ArmLeft01.zRot;
					this.ArmRight02.zRot = -this.ArmLeft02.zRot;
					//cloth
					this.ClothA03.yRot = 0.7F + az * -2.1F;
					this.ClothA03.x = (0.1F) + (-0.2F + az * 0.73F) * 16F;
				  	this.ClothA03a.yRot = -this.ClothA03.yRot;
				  	this.ClothA03a.x = (-0.1F) + (-((this.ClothA03.getInitialPose().x - (0.1F)) / 16F)) * 16F;
				  	addCA031 = 0F;
			    	addCA032 = 0F + az * 0.3F;
		    	}
		    	else if (parTick < 45F)
		    	{
		    		setFace(3);
		    		//arm 
				    this.ArmLeft01.zRot = 1.9F;
				    this.ArmLeft02.zRot = 0F;
					this.ArmRight01.zRot = -1.9F;
					this.ArmRight02.zRot = 0F;
					//cloth
					this.ClothA03.yRot = -1.45F;
					this.ClothA03.x = (0.1F) + (0.53F) * 16F;
				  	this.ClothA03a.yRot = 1.45F;
				  	this.ClothA03a.x = (-0.1F) + (-0.53F) * 16F;
				  	addCA031 = 0F;
			    	addCA032 = 0.3F;
		    	}
		    	else if (parTick < 53F)
		    	{
		    		float az = Mth.cos((parTick - 45F) * 0.125F * 1.5708F);
			    	
			    	//arm 
				    this.ArmLeft01.zRot = 0.1F + az * 1.8F;
				    this.ArmLeft02.zRot = 1F - az;
					this.ArmRight01.zRot = -this.ArmLeft01.zRot;
					this.ArmRight02.zRot = -this.ArmLeft02.zRot;
					//cloth
					this.ClothA03.yRot = 0.7F + az * -2F;
					this.ClothA03.x = (0.1F) + (-0.2F + az * 0.73F) * 16F;
				  	this.ClothA03a.yRot = -this.ClothA03.yRot;
				  	this.ClothA03a.x = (-0.1F) + (-((this.ClothA03.getInitialPose().x - (0.1F)) / 16F)) * 16F;
				  	addCA031 = 0F;
			    	addCA032 = 0F + az * 0.3F;
		    	}
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
  		  	this.ArmLeft01.xRot = 0.17F;
  		  	this.ArmLeft01.yRot = 0F;
  		  	this.ArmLeft01.zRot = -0.35F;
  		  	this.ArmLeft02.xRot = -1.57F;
  		  	this.ArmLeft02.yRot = 0F;
  		  	this.ArmLeft02.zRot = 0F;
  			this.ArmRight01.xRot = 0.17F;
  			this.ArmRight01.yRot = 0F;
  			this.ArmRight01.zRot = 0.35F;
  			this.ArmRight02.xRot = -1.57F;
  		  	this.ArmRight02.yRot = 0F;
  		  	this.ArmRight02.zRot = 0F;
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
  		  	this.ArmLeft01.xRot = 0.17F;
  		  	this.ArmLeft01.yRot = 0F;
  		  	this.ArmLeft01.zRot = -0.35F;
  		  	this.ArmLeft02.xRot = -1.57F;
  		  	this.ArmLeft02.yRot = 0F;
  		  	this.ArmLeft02.zRot = 0F;
  			this.ArmRight01.xRot = 0.17F;
  			this.ArmRight01.yRot = 0F;
  			this.ArmRight01.zRot = 0.35F;
  			this.ArmRight02.xRot = -1.57F;
  		  	this.ArmRight02.yRot = 0F;
  		  	this.ArmRight02.zRot = 0F;
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
	  	this.ClothA03.y = (1.9F) + (HandLc * 0.1F + addCA031) * 16F;
	  	this.ClothA04.y = (0.9F) + (HandLc * 0.2F) * 16F;
	  	this.ClothA05.y = (1.9F) + (HandLc * 0.25F) * 16F;
	  	this.ClothA03.z = (-2.2F) + (HandLs * -0.32F + addCA032) * 16F;
	  	this.ClothA04.z = (0.8F) + (HandLs * -0.32F) * 16F;
	  	this.ClothA05.z = (0.8F) + (HandLs * -0.32F) * 16F;
	  	this.ClothA03a.y = (1.9F) + (HandRc * 0.1F - addCA031) * 16F;
	  	this.ClothA04a.y = (0.9F) + (HandRc * 0.2F) * 16F;
	  	this.ClothA05a.y = (1.9F) + (HandRc * 0.25F) * 16F;
	  	this.ClothA03a.z = (-2.2F) + (HandRs * -0.32F + addCA032) * 16F;
	  	this.ClothA04a.z = (0.8F) + (HandRs * -0.32F) * 16F;
	  	this.ClothA05a.z = (0.8F) + (HandRs * -0.32F) * 16F;
	  	
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

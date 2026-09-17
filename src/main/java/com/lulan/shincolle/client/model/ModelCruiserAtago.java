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

public class ModelCruiserAtago<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart Butt;
	public ModelPart ArmRight01;
	public ModelPart ArmLeft01;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart Cloth01;
	public ModelPart EquipBase;
	public ModelPart EquipBag00;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Hat01;
	public ModelPart HairU01;
	public ModelPart Ahoke;
	public ModelPart Hair01;
	public ModelPart Hair01a1;
	public ModelPart Hair02;
	public ModelPart Hair01b1;
	public ModelPart Hair01c1;
	public ModelPart Hair01d1;
	public ModelPart Hair01b1_1;
	public ModelPart Hair01c1_1;
	public ModelPart Hair01a2;
	public ModelPart Hair01a3;
	public ModelPart Hair01b2;
	public ModelPart Hair01b3;
	public ModelPart Hair01c2;
	public ModelPart Hair01c3;
	public ModelPart Hair01d2;
	public ModelPart Hair01d3;
	public ModelPart Hair01b2_1;
	public ModelPart Hair01b3_1;
	public ModelPart Hair01c2_1;
	public ModelPart Hair01c3_1;
	public ModelPart Hat02;
	public ModelPart Hat03;
	public ModelPart LegLeft01;
	public ModelPart Skirt01;
	public ModelPart LegRight01;
	public ModelPart LegLeft02;
	public ModelPart ShoeL03;
	public ModelPart ShoeL01;
	public ModelPart ShoeL02;
	public ModelPart ShoeL04;
	public ModelPart Skirt02;
	public ModelPart Skirt03;
	public ModelPart LegRight02;
	public ModelPart ShoeL03_1;
	public ModelPart ShoeR01;
	public ModelPart ShoeR02;
	public ModelPart ShoeL04_1;
	public ModelPart ArmRight02;
	public ModelPart ArmRight02a;
	public ModelPart ArmLeft02;
	public ModelPart ArmLeft02a;
	public ModelPart Cloth01a;
	public ModelPart Cloth01b;
	public ModelPart Cloth01c;
	public ModelPart Cloth01d;
	public ModelPart Equip00;
	public ModelPart EquipCannonBase;
	public ModelPart EquipLIn01;
	public ModelPart EquipRIn01;
	public ModelPart EquipOut01;
	public ModelPart EquipOut01_1;
	public ModelPart EquipC01a;
	public ModelPart EquipLIn02;
	public ModelPart EquipLIn03;
	public ModelPart EquipLIn07;
	public ModelPart EquipLIn08;
	public ModelPart EquipLIn09;
	public ModelPart EquipLIn04;
	public ModelPart EquipLIn06a;
	public ModelPart EquipLIn05;
	public ModelPart EquipLIn06b;
	public ModelPart EquipRIn02;
	public ModelPart EquipRIn03;
	public ModelPart EquipRIn07;
	public ModelPart EquipRIn08;
	public ModelPart EquipRIn09;
	public ModelPart EquipRIn04;
	public ModelPart EquipRIn06a;
	public ModelPart EquipRIn05;
	public ModelPart EquipRIn06b;
	public ModelPart EquipOut02;
	public ModelPart EquipOut03;
	public ModelPart EquipOut04;
	public ModelPart EquipOut05;
	public ModelPart EquipOut02_1;
	public ModelPart EquipOut03_1;
	public ModelPart EquipOut04_1;
	public ModelPart EquipOut05_1;
	public ModelPart EquipC01b;
	public ModelPart EquipC01c;
	public ModelPart EquipC01e;
	public ModelPart EquipC01d;
	public ModelPart EquipC01f;
	public ModelPart EquipC01a_1;
	public ModelPart EquipC01a_2;
	public ModelPart EquipC01b_1;
	public ModelPart EquipC01c_1;
	public ModelPart EquipC01e_1;
	public ModelPart EquipC01d_1;
	public ModelPart EquipC01f_1;
	public ModelPart EquipC01b_2;
	public ModelPart EquipC01c_2;
	public ModelPart EquipC01e_2;
	public ModelPart EquipC01d_2;
	public ModelPart EquipC01f_2;
	public ModelPart EquipBag01;
	public ModelPart EquipBag02;
	public ModelPart EquipBag03;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ModelPart SkirtIn;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().mirror().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, -0.08726646259971647F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("ArmRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(-3.0F, 11.0F, 2.5F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("ArmRight02a", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(2.5F, 7.8F, -2.4F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("EquipBag00", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 14.0F, 1.0F), PartPose.offsetAndRotation(6.9F, -10.9F, -0.7F, 0.2617993877991494F, 1.3962634015954636F, 0.08726646259971647F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("EquipBag01", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.5F, 8.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-2.5F, 13.5F, 0.5F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("EquipBag02", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F), PartPose.offset(5.0F, -1.9F, -0.5F));
		PartDefinition partdef7 = partdef5.addOrReplaceChild("EquipBag03", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(3.0F, -2.9F, 0.0F));
		PartDefinition partdef8 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(3.5F, -8.5F, -3.8F, -0.8726646259971648F, -0.05235987755982988F, 0.08726646259971647F));
		PartDefinition partdef9 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("ShoeL03", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.2F, 1.0F, 3.0F, 5.0F), PartPose.offset(2.9F, 8.0F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("ShoeL04", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 3.0F, -0.7F));
		PartDefinition partdef13 = partdef10.addOrReplaceChild("LegLeft02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(3.0F, 14.0F, -3.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("ShoeL01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, 12.5F, 3.6F, -0.6981317007977318F, -0.13962634015954636F, -0.6981317007977318F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("ShoeL02", CubeListBuilder.create().addBox(0.0F, -3.0F, 0.0F, 10.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(4.0F, 3.0F, 0.1F, 0.0F, 0.0F, -0.6981317007977318F));
		PartDefinition partdef16 = partdef9.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -8.0F, 17.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 1.5F, -0.06981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-9.0F, 0.0F, -6.0F, 18.0F, 9.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 4.5F, -2.7F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("Skirt03", CubeListBuilder.create().addBox(-10.0F, 0.0F, -6.5F, 20.0F, 11.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 7.5F, 0.0F, 0.091106186954104F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef9.addOrReplaceChild("LegRight01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.08726646259971647F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("ShoeL03_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.2F, 1.0F, 3.0F, 5.0F), PartPose.offset(-3.9F, 8.0F, 0.0F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("ShoeL04_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 3.0F, -0.7F));
		PartDefinition partdef22 = partdef19.addOrReplaceChild("LegRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(-3.0F, 14.0F, -3.0F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("ShoeR01", CubeListBuilder.create().mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(2.0F, 12.5F, 3.6F, -0.6981317007977318F, 0.13962634015954636F, 0.6981317007977318F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("ShoeR02", CubeListBuilder.create().mirror().addBox(-10.0F, -3.0F, 0.0F, 10.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(-4.0F, 3.0F, 0.1F, 0.0F, 0.0F, 0.6981317007977318F));
		PartDefinition partdef25 = partdef9.addOrReplaceChild("SkirtIn", CubeListBuilder.create().addBox(-8F, 0F, -5F, 16.0F, 5.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 7.8F, -1.9F, -0.2618F, 0.0F, 0.0F));
		PartDefinition partdef26 = partdef0.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("Equip00", CubeListBuilder.create().addBox(-11.5F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 3.0F, 0.0F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("EquipOut01", CubeListBuilder.create().addBox(0.0F, 0.0F, -0.5F, 12.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(-11.2F, -1.0F, -0.2F, 0.2617993877991494F, -1.48352986419518F, 0.0F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("EquipOut02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -1.0F, 9.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(12.0F, 0.0F, 0.5F, 0.0F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("EquipOut03", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.0F, 6.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.0F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("EquipOut04", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -1.0F, 6.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("EquipOut05", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.0F, 1.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(3.5F, 2.5F, -0.5F, 0.0F, 0.0F, 0.3490658503988659F));
		PartDefinition partdef33 = partdef27.addOrReplaceChild("EquipRIn01", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.0F, 7.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, -1.0F, -0.08726646259971647F, 1.2217304763960306F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("EquipRIn02", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 8.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(7.0F, 0.0F, -1.0F, 0.0F, -1.1344640137963142F, 0.0F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("EquipRIn07", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(8.5F, -0.7F, 0.5F, 0.0F, -0.5235987755982988F, 0.0F));
		PartDefinition partdef36 = partdef34.addOrReplaceChild("EquipRIn09", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(2.9F, -3.2F, 0.5F));
		PartDefinition partdef37 = partdef34.addOrReplaceChild("EquipRIn03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, -0.8726646259971648F, 0.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("EquipRIn06a", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(4.3F, -0.5F, 1.5F, 0.0F, -0.6981317007977318F, 0.0F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("EquipRIn06b", CubeListBuilder.create().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(-0.3F, 0.0F, 0.0F));
		PartDefinition partdef40 = partdef37.addOrReplaceChild("EquipRIn04", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.0F, 2.0F, 5.0F, 1.0F), PartPose.offsetAndRotation(1.5F, 1.9F, 1.3F, 0.0F, -0.2617993877991494F, 0.0F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("EquipRIn05", CubeListBuilder.create().addBox(-2.0F, 0.0F, -1.0F, 7.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.5F, 4.7F, -0.4F, 0.0F, -0.2617993877991494F, 0.08726646259971647F));
		PartDefinition partdef42 = partdef34.addOrReplaceChild("EquipRIn08", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(5.2F, -1.9F, 1.3F));
		PartDefinition partdef43 = partdef27.addOrReplaceChild("EquipC01a", CubeListBuilder.create().addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F), PartPose.offset(-13.0F, 0.5F, 0.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("EquipC01b", CubeListBuilder.create().addBox(0.0F, -9.0F, -4.5F, 4.0F, 13.0F, 9.0F), PartPose.offsetAndRotation(-5.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("EquipC01c", CubeListBuilder.create().addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offset(2.0F, -8.0F, -2.2F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("EquipC01d", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F), PartPose.offset(0.0F, -14.9F, 0.0F));
		PartDefinition partdef47 = partdef44.addOrReplaceChild("EquipC01e", CubeListBuilder.create().addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offset(2.0F, -8.0F, 2.2F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("EquipC01f", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F), PartPose.offset(0.0F, -14.9F, 0.0F));
		PartDefinition partdef49 = partdef27.addOrReplaceChild("EquipOut01_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -0.5F, 12.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(-11.2F, -1.0F, 0.2F, -0.2617993877991494F, 1.48352986419518F, 0.0F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("EquipOut02_1", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 9.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(12.0F, 0.0F, -0.5F, 0.0F, -0.5235987755982988F, 0.0F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("EquipOut03_1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.0F, -0.6981317007977318F, 0.0F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("EquipOut04_1", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, -0.6981317007977318F, 0.0F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("EquipOut05_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.0F, 1.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(3.5F, 2.5F, 0.5F, 0.0F, 0.0F, 0.3490658503988659F));
		PartDefinition partdef54 = partdef27.addOrReplaceChild("EquipLIn01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 7.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, -1.0F, 1.0F, 0.08726646259971647F, -1.2217304763960306F, 0.0F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("EquipLIn02", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.0F, 8.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(7.0F, 0.0F, 1.0F, 0.0F, 1.1344640137963142F, 0.0F));
		PartDefinition partdef56 = partdef55.addOrReplaceChild("EquipLIn09", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(2.9F, -3.2F, -0.5F));
		PartDefinition partdef57 = partdef55.addOrReplaceChild("EquipLIn08", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(5.2F, -1.9F, -1.3F));
		PartDefinition partdef58 = partdef55.addOrReplaceChild("EquipLIn03", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.0F, 4.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, 0.8726646259971648F, 0.0F));
		PartDefinition partdef59 = partdef58.addOrReplaceChild("EquipLIn04", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 1.0F), PartPose.offsetAndRotation(1.5F, 1.9F, -1.3F, 0.0F, 0.2617993877991494F, 0.0F));
		PartDefinition partdef60 = partdef59.addOrReplaceChild("EquipLIn05", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 7.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.5F, 4.7F, 0.4F, 0.0F, 0.2617993877991494F, 0.08726646259971647F));
		PartDefinition partdef61 = partdef58.addOrReplaceChild("EquipLIn06a", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(4.3F, -0.5F, -1.5F, 0.0F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("EquipLIn06b", CubeListBuilder.create().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(-0.3F, 0.0F, 0.0F));
		PartDefinition partdef63 = partdef55.addOrReplaceChild("EquipLIn07", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(8.5F, -0.7F, -0.5F, 0.0F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef64 = partdef26.addOrReplaceChild("EquipCannonBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 5.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef65 = partdef64.addOrReplaceChild("EquipC01a_2", CubeListBuilder.create().addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F), PartPose.offset(-20.0F, 5.0F, 0.0F));
		PartDefinition partdef66 = partdef65.addOrReplaceChild("EquipC01b_2", CubeListBuilder.create().addBox(-4.0F, -9.0F, -4.5F, 4.0F, 13.0F, 9.0F), PartPose.offsetAndRotation(-1.9F, 0.0F, 0.0F, 0.0F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef67 = partdef66.addOrReplaceChild("EquipC01c_2", CubeListBuilder.create().addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offset(-2.0F, -8.0F, -2.2F));
		PartDefinition partdef68 = partdef67.addOrReplaceChild("EquipC01d_2", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F), PartPose.offset(0.0F, -14.9F, 0.0F));
		PartDefinition partdef69 = partdef66.addOrReplaceChild("EquipC01e_2", CubeListBuilder.create().addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offset(-2.0F, -8.0F, 2.2F));
		PartDefinition partdef70 = partdef69.addOrReplaceChild("EquipC01f_2", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F), PartPose.offset(0.0F, -14.9F, 0.0F));
		PartDefinition partdef71 = partdef64.addOrReplaceChild("EquipC01a_1", CubeListBuilder.create().addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F), PartPose.offset(20.0F, 5.0F, 0.0F));
		PartDefinition partdef72 = partdef71.addOrReplaceChild("EquipC01b_1", CubeListBuilder.create().addBox(0.0F, -9.0F, -4.5F, 4.0F, 13.0F, 9.0F), PartPose.offsetAndRotation(1.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef73 = partdef72.addOrReplaceChild("EquipC01c_1", CubeListBuilder.create().addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offset(2.0F, -8.0F, -2.2F));
		PartDefinition partdef74 = partdef73.addOrReplaceChild("EquipC01d_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F), PartPose.offset(0.0F, -14.9F, 0.0F));
		PartDefinition partdef75 = partdef72.addOrReplaceChild("EquipC01e_1", CubeListBuilder.create().addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offset(2.0F, -8.0F, 2.2F));
		PartDefinition partdef76 = partdef75.addOrReplaceChild("EquipC01f_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F), PartPose.offset(0.0F, -14.9F, 0.0F));
		PartDefinition partdef77 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(-3.5F, -8.5F, -3.8F, -0.8726646259971648F, 0.05235987755982988F, -0.08726646259971647F));
		PartDefinition partdef78 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-3.5F, -2.0F, -4.9F, 7.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef79 = partdef78.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef80 = partdef79.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef81 = partdef80.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-8.0F, 0.0F, -8.0F, 16.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 8.5F, 10.0F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef82 = partdef81.addOrReplaceChild("Hair01b1", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(6.5F, 1.0F, -4.5F, 0.2617993877991494F, -0.8726646259971648F, -0.6981317007977318F));
		PartDefinition partdef83 = partdef82.addOrReplaceChild("Hair01b2", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef84 = partdef83.addOrReplaceChild("Hair01b3", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 1.3089969389957472F));
		PartDefinition partdef85 = partdef81.addOrReplaceChild("Hair01c1_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(-6.5F, 1.5F, -4.0F, 0.6981317007977318F, 0.7853981633974483F, 0.9599310885968813F));
		PartDefinition partdef86 = partdef85.addOrReplaceChild("Hair01c2_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef87 = partdef86.addOrReplaceChild("Hair01c3_1", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, -1.0471975511965976F));
		PartDefinition partdef88 = partdef81.addOrReplaceChild("Hair01c1", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(6.5F, 1.0F, -4.0F, 0.6981317007977318F, -0.7853981633974483F, -0.9599310885968813F));
		PartDefinition partdef89 = partdef88.addOrReplaceChild("Hair01c2", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef90 = partdef89.addOrReplaceChild("Hair01c3", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 1.0471975511965976F));
		PartDefinition partdef91 = partdef81.addOrReplaceChild("Hair01b1_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(-6.5F, 1.0F, -4.5F, 0.2617993877991494F, 0.8726646259971648F, 0.6981317007977318F));
		PartDefinition partdef92 = partdef91.addOrReplaceChild("Hair01b2_1", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef93 = partdef92.addOrReplaceChild("Hair01b3_1", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, -1.3089969389957472F));
		PartDefinition partdef94 = partdef81.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.5F, 0.0F, -8.9F, 17.0F, 9.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef95 = partdef81.addOrReplaceChild("Hair01d1", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(-6.6F, 0.0F, -5.5F, -0.08726646259971647F, 1.0471975511965976F, 0.5235987755982988F));
		PartDefinition partdef96 = partdef95.addOrReplaceChild("Hair01d2", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.3490658503988659F));
		PartDefinition partdef97 = partdef96.addOrReplaceChild("Hair01d3", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, -1.0471975511965976F));
		PartDefinition partdef98 = partdef81.addOrReplaceChild("Hair01a1", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(6.6F, 0.0F, -5.5F, -0.08726646259971647F, -1.0471975511965976F, -0.5235987755982988F));
		PartDefinition partdef99 = partdef98.addOrReplaceChild("Hair01a2", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.3490658503988659F));
		PartDefinition partdef100 = partdef99.addOrReplaceChild("Hair01a3", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 1.0471975511965976F));
		PartDefinition partdef101 = partdef79.addOrReplaceChild("Hat01", CubeListBuilder.create().addBox(-3.5F, 0F, -3.5F, 7.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(3.8F, -14.7F, 3.8F, -0.2618F, 0F, 0.1745F));
		PartDefinition partdef102 = partdef101.addOrReplaceChild("Hat02", CubeListBuilder.create().addBox(-4F, 0F, -4F, 8.0F, 3.0F, 8.0F), PartPose.offset(0.0F, -3.0F, 0.0F));
		PartDefinition partdef103 = partdef102.addOrReplaceChild("Hat03", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(4.6F, 1.6F, 2.0F, 0.2617993877991494F, 0.13962634015954636F, -0.5235987755982988F));
		PartDefinition partdef104 = partdef79.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.1F));
		PartDefinition partdef105 = partdef104.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -6.0F, -10.5F, 0.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(-0.5F, -7.0F, -6.0F, 0.20943951023931953F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef106 = partdef104.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -7.0F));
		PartDefinition partdef107 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, -10.0F, 0.0F));
		PartDefinition partdef108 = partdef107.addOrReplaceChild("Cloth01a", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -0.5F, -5.0F, -0.8726646259971648F, 0.5235987755982988F, 0.17453292519943295F));
		PartDefinition partdef109 = partdef107.addOrReplaceChild("Cloth01b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -0.5F, -5.0F, -0.8726646259971648F, -0.5235987755982988F, -0.17453292519943295F));
		PartDefinition partdef110 = partdef107.addOrReplaceChild("Cloth01d", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.4F, -5.0F, -0.593411945678072F, -0.2617993877991494F, 0.0F));
		PartDefinition partdef111 = partdef107.addOrReplaceChild("Cloth01c", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.4F, -5.0F, -0.6108652381980153F, 0.2617993877991494F, 0.0F));
		PartDefinition partdef112 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.3490658503988659F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef113 = partdef112.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(3.0F, 11.0F, 2.5F));
		PartDefinition partdef114 = partdef113.addOrReplaceChild("ArmLeft02a", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-2.5F, 7.8F, -2.4F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef115 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef116 = partdef115.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef117 = partdef116.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef118 = partdef117.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef119 = partdef117.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef120 = partdef117.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef121 = partdef117.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef122 = partdef117.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef123 = partdef117.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef124 = partdef117.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef125 = partdef117.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef126 = partdef117.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef127 = partdef117.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelCruiserAtago(ModelPart root)
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
		this.ShoeL04_1 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("ShoeL03_1").getChild("ShoeL04_1");
		this.ShoeL04 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("ShoeL03").getChild("ShoeL04");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.Hair01b2 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01b1").getChild("Hair01b2");
		this.Cloth01a = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth01a");
		this.Equip00 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00");
		this.EquipRIn05 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipRIn01").getChild("EquipRIn02").getChild("EquipRIn03").getChild("EquipRIn04").getChild("EquipRIn05");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.EquipOut01 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipOut01");
		this.Cloth01b = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth01b");
		this.EquipRIn07 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipRIn01").getChild("EquipRIn02").getChild("EquipRIn07");
		this.EquipC01b_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipCannonBase").getChild("EquipC01a_1").getChild("EquipC01b_1");
		this.EquipLIn02 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipLIn01").getChild("EquipLIn02");
		this.EquipRIn06a = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipRIn01").getChild("EquipRIn02").getChild("EquipRIn03").getChild("EquipRIn06a");
		this.Hair01b1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01b1");
		this.EquipC01b_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipCannonBase").getChild("EquipC01a_2").getChild("EquipC01b_2");
		this.EquipC01f_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipCannonBase").getChild("EquipC01a_1").getChild("EquipC01b_1").getChild("EquipC01e_1").getChild("EquipC01f_1");
		this.EquipRIn04 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipRIn01").getChild("EquipRIn02").getChild("EquipRIn03").getChild("EquipRIn04");
		this.EquipC01d_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipCannonBase").getChild("EquipC01a_1").getChild("EquipC01b_1").getChild("EquipC01c_1").getChild("EquipC01d_1");
		this.EquipLIn06b = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipLIn01").getChild("EquipLIn02").getChild("EquipLIn03").getChild("EquipLIn06a").getChild("EquipLIn06b");
		this.Hair01a2 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01a1").getChild("Hair01a2");
		this.EquipC01f_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipCannonBase").getChild("EquipC01a_2").getChild("EquipC01b_2").getChild("EquipC01e_2").getChild("EquipC01f_2");
		this.EquipOut04 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipOut01").getChild("EquipOut02").getChild("EquipOut03").getChild("EquipOut04");
		this.ShoeL01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoeL01");
		this.EquipC01c = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipC01a").getChild("EquipC01b").getChild("EquipC01c");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.Hair01c1_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01c1_1");
		this.EquipOut05_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipOut01_1").getChild("EquipOut02_1").getChild("EquipOut03_1").getChild("EquipOut04_1").getChild("EquipOut05_1");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.EquipBag00 = root.getChild("BodyMain").getChild("EquipBag00");
		this.EquipLIn09 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipLIn01").getChild("EquipLIn02").getChild("EquipLIn09");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.Hair01c1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01c1");
		this.Hat03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat02").getChild("Hat03");
		this.EquipOut02_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipOut01_1").getChild("EquipOut02_1");
		this.EquipLIn04 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipLIn01").getChild("EquipLIn02").getChild("EquipLIn03").getChild("EquipLIn04");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.EquipC01d_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipCannonBase").getChild("EquipC01a_2").getChild("EquipC01b_2").getChild("EquipC01c_2").getChild("EquipC01d_2");
		this.EquipRIn09 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipRIn01").getChild("EquipRIn02").getChild("EquipRIn09");
		this.EquipC01f = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipC01a").getChild("EquipC01b").getChild("EquipC01e").getChild("EquipC01f");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.EquipC01d = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipC01a").getChild("EquipC01b").getChild("EquipC01c").getChild("EquipC01d");
		this.EquipLIn08 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipLIn01").getChild("EquipLIn02").getChild("EquipLIn08");
		this.EquipOut03 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipOut01").getChild("EquipOut02").getChild("EquipOut03");
		this.Hair01b3 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01b1").getChild("Hair01b2").getChild("Hair01b3");
		this.ShoeL03 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("ShoeL03");
		this.Hair01b1_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01b1_1");
		this.Hair01c3 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01c1").getChild("Hair01c2").getChild("Hair01c3");
		this.EquipRIn06b = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipRIn01").getChild("EquipRIn02").getChild("EquipRIn03").getChild("EquipRIn06a").getChild("EquipRIn06b");
		this.ShoeR01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoeR01");
		this.EquipLIn06a = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipLIn01").getChild("EquipLIn02").getChild("EquipLIn03").getChild("EquipLIn06a");
		this.EquipRIn03 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipRIn01").getChild("EquipRIn02").getChild("EquipRIn03");
		this.EquipBag02 = root.getChild("BodyMain").getChild("EquipBag00").getChild("EquipBag01").getChild("EquipBag02");
		this.Skirt03 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02").getChild("Skirt03");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.EquipLIn05 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipLIn01").getChild("EquipLIn02").getChild("EquipLIn03").getChild("EquipLIn04").getChild("EquipLIn05");
		this.BodyMain = root.getChild("BodyMain");
		this.EquipBase = root.getChild("BodyMain").getChild("EquipBase");
		this.ShoeL02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoeL01").getChild("ShoeL02");
		this.EquipC01a_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipCannonBase").getChild("EquipC01a_2");
		this.HairU01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairU01");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.Hair01b3_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01b1_1").getChild("Hair01b2_1").getChild("Hair01b3_1");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.Hair01a3 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01a1").getChild("Hair01a2").getChild("Hair01a3");
		this.EquipC01a_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipCannonBase").getChild("EquipC01a_1");
		this.EquipC01c_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipCannonBase").getChild("EquipC01a_1").getChild("EquipC01b_1").getChild("EquipC01c_1");
		this.ArmRight02a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight02a");
		this.EquipC01e_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipCannonBase").getChild("EquipC01a_1").getChild("EquipC01b_1").getChild("EquipC01e_1");
		this.Hair01d2 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01d1").getChild("Hair01d2");
		this.EquipBag03 = root.getChild("BodyMain").getChild("EquipBag00").getChild("EquipBag01").getChild("EquipBag03");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.Hat02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat02");
		this.Cloth01d = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth01d");
		this.ShoeR02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoeR01").getChild("ShoeR02");
		this.EquipRIn01 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipRIn01");
		this.EquipC01a = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipC01a");
		this.EquipC01c_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipCannonBase").getChild("EquipC01a_2").getChild("EquipC01b_2").getChild("EquipC01c_2");
		this.Hair01c2 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01c1").getChild("Hair01c2");
		this.EquipOut04_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipOut01_1").getChild("EquipOut02_1").getChild("EquipOut03_1").getChild("EquipOut04_1");
		this.EquipLIn03 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipLIn01").getChild("EquipLIn02").getChild("EquipLIn03");
		this.EquipOut05 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipOut01").getChild("EquipOut02").getChild("EquipOut03").getChild("EquipOut04").getChild("EquipOut05");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.EquipOut03_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipOut01_1").getChild("EquipOut02_1").getChild("EquipOut03_1");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.EquipC01e = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipC01a").getChild("EquipC01b").getChild("EquipC01e");
		this.Hat01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.EquipRIn08 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipRIn01").getChild("EquipRIn02").getChild("EquipRIn08");
		this.EquipC01b = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipC01a").getChild("EquipC01b");
		this.EquipBag01 = root.getChild("BodyMain").getChild("EquipBag00").getChild("EquipBag01");
		this.ArmLeft02a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft02a");
		this.EquipLIn07 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipLIn01").getChild("EquipLIn02").getChild("EquipLIn07");
		this.ShoeL03_1 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("ShoeL03_1");
		this.Hair01d1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01d1");
		this.Hair01c2_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01c1_1").getChild("Hair01c2_1");
		this.Hair01c3_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01c1_1").getChild("Hair01c2_1").getChild("Hair01c3_1");
		this.Hair01a1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01a1");
		this.EquipC01e_2 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipCannonBase").getChild("EquipC01a_2").getChild("EquipC01b_2").getChild("EquipC01e_2");
		this.EquipCannonBase = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipCannonBase");
		this.EquipOut01_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipOut01_1");
		this.EquipLIn01 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipLIn01");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.Hair01d3 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01d1").getChild("Hair01d2").getChild("Hair01d3");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.Cloth01c = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth01c");
		this.EquipRIn02 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipRIn01").getChild("EquipRIn02");
		this.Hair01b2_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair01b1_1").getChild("Hair01b2_1");
		this.EquipOut02 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip00").getChild("EquipOut01").getChild("EquipOut02");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.SkirtIn = root.getChild("BodyMain").getChild("Butt").getChild("SkirtIn");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.offsetItem = new float[] {0.06F, 1.01F, -0.06F};
		this.offsetBlock = new float[] {0.06F, 1.01F, -0.06F};
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
				
		flag = !EmotionHelper.checkModelState(1, state);	//bag
		this.EquipBag00.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);	//hat
		this.Hat01.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(3, state);	//shoes
		this.ShoeL01.visible = !(flag);
		this.ShoeR01.visible = !(flag);
		this.ShoeL03.visible = !(flag);
		this.ShoeL03_1.visible = !(flag);
	
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

this.animTransX += (0F); this.animTransY += (0.58F + 0.26F * ent.getScaleLevel()); this.animTransZ += (0F);
		this.setFaceHungry(ent);

    	//body
    	this.Head.xRot = 0.55F;
	  	this.Head.yRot = -0.2F;
    	this.BodyMain.xRot = -0.7F;
	  	this.BodyMain.yRot = -0.2618F;
	  	this.BodyMain.zRot = -0.5236F;
	  	this.Butt.xRot = -0.2618F;
	  	this.Cloth01.xRot = 0.3F;
	  	//skirt
	  	this.Skirt01.xRot = -0.2443F;
	  	this.Skirt02.xRot = -0.0873F;
	  	this.Skirt03.xRot = -0.0873F;
	  	this.SkirtIn.xRot = -0.2618F;
    	//arm
	  	this.ArmLeft01.xRot = -0.2618F;
	  	this.ArmLeft01.yRot = 0.7F;
	    this.ArmLeft01.zRot = -0.5236F;
	    this.ArmLeft02.xRot = -2.1F;
	    this.ArmLeft02.yRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.z = (2.5F) + (-0.31F) * 16F;
		this.ArmRight01.xRot = 0.7F;
		this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = 0.5236F;
		this.ArmRight02.xRot = -1.45F;
		this.ArmRight02.yRot = 0F;
		this.ArmRight02.zRot = 0F;
    	//leg
		this.LegLeft01.xRot = -0.79F;
		this.LegLeft01.yRot = 0F;
    	this.LegLeft01.zRot = -0.14F;
    	this.LegLeft02.xRot = 1.4F;
    	this.LegRight01.xRot = -0.7F;
    	this.LegRight01.yRot = -0.4363F;
    	this.LegRight01.zRot = 0F;
    	this.LegRight02.xRot = 0.7F;
    	//hair
    	this.Hair01.xRot = 0.35F;
    	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = 0.2F;
	  	this.Hair02.zRot = 0F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F + f * 0.25F);
  		float angleX1 = Mth.cos(f2*0.1F + 0.3F + f * 0.5F);
  		float angleX2 = Mth.cos(f2*0.1F + 0.6F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
  		float addk1 = 0;
  		float addk2 = 0;
  		float headX = 0F;
  		float headZ = 0F;
  		float t2 = ent.getTickExisted() & 511;
  		boolean spcStand = false;
  		
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
	  	//body
	  	this.BodyMain.xRot = -0.1047F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.35F;
	  	this.Skirt01.xRot = -0.07F;
	  	this.Skirt02.xRot = angleX1 * 0.015F - 0.087F;
	  	this.Skirt03.xRot = -angleX2 * 0.04F + 0.091F;
	  	this.SkirtIn.xRot = -0.2618F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.03F + 0.21F + headX;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -angleX1 * 0.04F + 0.26F + headX;
	  	this.Hair02.zRot = 0F;
	  	this.Hair01a3.zRot = angleX * 0.2F + 1.05F;
	  	this.Hair01b3.zRot = angleX * 0.15F + 1.31F;
	  	this.Hair01c3.zRot = angleX * 0.1F + 1.05F;
	  	this.Hair01d3.zRot = angleX * 0.2F - 1.05F;
	  	this.Hair01b3_1.zRot = angleX * 0.15F - 1.31F;
	  	this.Hair01c3_1.zRot = angleX * 0.1F - 1.05F;
	  	//cloth
	  	this.Hat03.xRot = angleX * 0.05F + 0.26F;
	  	this.Cloth01.xRot = 0F;
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
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (3.0F) + (0F) * 16F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.0873F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.x = (-3.0F) + (0F) * 16F;
		this.LegRight02.y = (14.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		//equip
		this.EquipCannonBase.yRot = this.Head.yRot * 0.35F;
		this.EquipC01b.xRot = this.Head.yRot;
		this.EquipC01b_1.xRot = this.Head.xRot + 1.2F;
		this.EquipC01b_2.xRot = this.Head.xRot + 1.2F;
		this.EquipC01c_1.zRot = -this.Head.yRot * 0.5F;
		this.EquipC01e_1.zRot = -this.Head.yRot * 0.5F;
		this.EquipC01c_2.zRot = -this.Head.yRot * 0.5F;
		this.EquipC01e_2.zRot = -this.Head.yRot * 0.5F;
		
		//special stand pos
		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		{
			spcStand = true;

			this.Head.yRot *= 0.25F;
			this.ArmLeft01.xRot = -0.3490658503988659F;
			this.ArmLeft01.yRot = 0.0F;
			this.ArmLeft01.zRot = 0.4553564018453205F;
			this.ArmLeft02.xRot = 0.0F;
			this.ArmLeft02.yRot = 0.0F;
			this.ArmLeft02.zRot = 1.0471975511965976F;
			this.ArmRight01.xRot = -0.5462880558742251F;
			this.ArmRight01.yRot = -0.2617993877991494F;
			this.ArmRight01.zRot = -0.13962634015954636F;
			this.ArmRight02.xRot = -2.530727415391778F;
			this.ArmRight02.zRot = 0.0F;
			this.ArmRight02.z = (2.5F) + (-0.32F) * 16F;
			
			if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED)
			{
				this.setFace(8);
			}
		}
		else if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED)
		{
			spcStand = true;
			this.setFaceHappy(ent);
			
			//arm
			this.ArmLeft01.xRot = -3.14F;
			this.ArmLeft01.yRot = 0.0F;
			this.ArmLeft01.zRot = 0.52F;
			this.ArmLeft02.xRot = 0F;
			this.ArmLeft02.yRot = 0F;
			this.ArmLeft02.zRot = 0F;
			this.ArmLeft02.x = (3.0F) + (0F) * 16F;
			this.ArmLeft02.z = (2.5F) + (0F) * 16F;
			this.ArmRight01.xRot = -3.14F;
			this.ArmRight01.yRot = 0.0F;
			this.ArmRight01.zRot = -0.52F;
			this.ArmRight02.xRot = 0F;
			this.ArmRight02.yRot = 0F;
			this.ArmRight02.zRot = 0F;
			this.ArmRight02.x = (-3.0F) + (0F) * 16F;
			this.ArmRight02.z = (2.5F) + (0F) * 16F;
		}

	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
			  	//arm
		  		this.ArmLeft01.xRot = -0.35F;
		  		this.ArmLeft01.yRot = -1.7F - angleAdd2 * 0.5F;
			    this.ArmLeft01.zRot = 0F;
				this.ArmLeft02.xRot = -2.4F;
				this.ArmLeft02.yRot = 0F;
				this.ArmLeft02.zRot = 0F;
				this.ArmLeft02.x = (3.0F) + (0F) * 16F;
				this.ArmLeft02.y = (11.0F) + (0F) * 16F;
				this.ArmLeft02.z = (2.5F) + (-0.315F) * 16F;
			    this.ArmRight01.xRot = -0.35F;
			    this.ArmRight01.yRot = 1.7F + angleAdd1 * 0.5F;
			    this.ArmRight01.zRot = 0F;
				this.ArmRight02.xRot = -2.4F;
				this.ArmRight02.zRot = 0F;
				this.ArmRight02.zRot = 0F;
				this.ArmRight02.x = (-3.0F) + (0F) * 16F;
				this.ArmRight02.y = (11.0F) + (0F) * 16F;
				this.ArmRight02.z = (2.5F) + (-0.315F) * 16F;
	    	}
  		}
	    
	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {
	    	//潛行, 蹲下動作
this.animTransX += (0F); this.animTransY += (0.03F + this.scale * 0.06F); this.animTransZ += (0F);
	    	
	    	//body
	    	this.Head.xRot -= 1.0472F;
		  	this.BodyMain.xRot = 1.0472F;
		  	this.Butt.xRot = -0.4F;
		  	//skirt
		  	this.Skirt01.xRot = -0.24F;
		  	this.Skirt02.xRot = -0.18F;
		  	this.Skirt03.xRot = 0.1F;
		  	//arm
	  		this.ArmLeft01.xRot = -0.6F;
	  		this.ArmLeft01.yRot = 0F;
		    this.ArmLeft01.zRot = 0.2618F;
			this.ArmLeft02.xRot = 0F;
			this.ArmLeft02.yRot = 0F;
			this.ArmLeft02.zRot = 0F;
			this.ArmLeft02.x = (3.0F) + (0F) * 16F;
			this.ArmLeft02.y = (11.0F) + (0F) * 16F;
			this.ArmLeft02.z = (2.5F) + (0F) * 16F;
		    this.ArmRight01.xRot = -0.6F;
		    this.ArmRight01.yRot = 0F;
		    this.ArmRight01.zRot = -0.2618F;
			this.ArmRight02.xRot = 0F;
			this.ArmRight02.zRot = 0F;
			this.ArmRight02.zRot = 0F;
			this.ArmRight02.x = (-3.0F) + (0F) * 16F;
			this.ArmRight02.y = (11.0F) + (0F) * 16F;
			this.ArmRight02.z = (2.5F) + (0F) * 16F;
		    //leg
		    addk1 -= 0.4F;
		    addk2 -= 0.4F;
  		}//end if sneaking
  		
	    //坐下動作
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {
	    	//if caressing
	    	if (ent.getStateEmotion(ID.S.Emotion3) == ID.Emotion3.CARESS)
	    	{
this.animTransX += (0F); this.animTransY += (0.34F); this.animTransZ += (0F);
		    	//body
		    	this.Head.xRot -= 0.91F;
		    	this.BodyMain.xRot = 0.7F;
		    	this.BodyMain.yRot = 0F;
		    	this.BodyMain.zRot = 0F;
		    	//skirt
		    	this.Skirt01.xRot = -0.24F;
		    	this.Skirt02.xRot = -0.09F;
		    	this.Skirt03.xRot = 0.21F;
		    	this.SkirtIn.xRot = -0.26F;
		    	//arm
		    	this.ArmLeft01.xRot = -0.45F;
		    	this.ArmLeft01.yRot = 0.0F;
		    	this.ArmLeft01.zRot = 0.21F;
		    	this.ArmRight01.xRot = -0.45F;
		    	this.ArmRight01.yRot = 0.0F;
		    	this.ArmRight01.zRot = -0.21F;
		    	//leg
		    	addk1 = -1.59F;
		    	addk2 = -1.59F;
		    	this.LegLeft01.yRot = 0.0F;
		    	this.LegLeft01.zRot = 0.09F;
		    	this.LegLeft02.xRot = 2.1F;
		    	this.LegLeft02.yRot = 0.0F;
		    	this.LegLeft02.zRot = 0.0F;
		    	this.LegLeft02.z = (-3.0F) + (0.37F) * 16F;
		    	this.LegRight01.yRot = 0.0F;
		    	this.LegRight01.zRot = -0.09F;
		    	this.LegRight02.xRot = 2.1F;
		    	this.LegRight02.yRot = 0F;
		    	this.LegRight02.zRot = 0F;
		    	this.LegRight02.z = (-3.0F) + (0.37F) * 16F;
	    	}
	    	else
	    	{
		    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		    	{
this.animTransX += (0F); this.animTransY += (0.58F); this.animTransZ += (0F);
			    	this.setFlush(true);
					//body
					this.Head.xRot = 0.55F;
				  	this.Head.yRot = -0.2F;
					this.BodyMain.xRot = -0.7F;
				  	this.BodyMain.yRot = -0.2618F;
				  	this.BodyMain.zRot = -0.5236F;
				  	this.Butt.xRot = -0.2618F;
				  	this.Cloth01.xRot = 0.3F;
				  	//skirt
				  	this.Skirt01.xRot = -0.2443F;
				  	this.Skirt02.xRot = -0.0873F;
				  	this.Skirt03.xRot = -0.0873F;
				  	this.SkirtIn.xRot = -0.2618F;
					//arm
				  	this.ArmLeft01.xRot = -0.2618F;
				  	this.ArmLeft01.yRot = 0.7F;
				    this.ArmLeft01.zRot = -0.5236F;
				    this.ArmLeft02.xRot = -2.1F;
				    this.ArmLeft02.yRot = 0F;
				    this.ArmLeft02.zRot = 0F;
				    this.ArmLeft02.z = (2.5F) + (-0.31F) * 16F;
					this.ArmRight01.xRot = 0.7F;
					this.ArmRight01.yRot = 0F;
					this.ArmRight01.zRot = 0.5236F;
					this.ArmRight02.xRot = -1.45F;
					this.ArmRight02.yRot = 0F;
					this.ArmRight02.zRot = 0F;
					//leg
					addk1 = -0.79F;
					addk2 = -0.7F;
					this.LegLeft01.yRot = 0F;
					this.LegLeft01.zRot = -0.14F;
					this.LegLeft02.xRot = 1.4F;
					this.LegRight01.yRot = -0.4363F;
					this.LegRight01.zRot = 0F;
					this.LegRight02.xRot = 0.7F;
					//hair
					this.Hair01.xRot = 0.35F;
					this.Hair01.zRot = 0F;
				  	this.Hair02.xRot = 0.2F;
				  	this.Hair02.zRot = 0F;
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.35F); this.animTransZ += (0F);
		
			    	//Body
				  	this.Head.xRot -= 0.1F;
				  	this.BodyMain.xRot = 0F;
			    	this.Butt.xRot = -0.2F;
			    	this.Butt.y = (4.0F) + (0F) * 16F;
			    	//skirt
			    	this.Skirt01.xRot = -0.15F;
			    	this.Skirt02.xRot = 0.25F;
			    	this.SkirtIn.xRot = -0.76F;
			    	//arm
			    	if (!spcStand)
			    	{
					  	this.ArmLeft01.xRot = -0.4F;
					  	this.ArmLeft01.zRot = 0.2618F;
				    	this.ArmRight01.xRot = -0.4F;
						this.ArmRight01.zRot = -0.2618F;
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
	    	}
  		}//end if sitting
	    
	    //攻擊動作: 設為30~50會有揮刀動作, 設為100則沒有揮刀動作
	    if (ent.getAttackTick() > 30)
	    {
			//arm
			this.ArmLeft01.xRot = -3.14F;
			this.ArmLeft01.yRot = 0.0F;
			this.ArmLeft01.zRot = 0.52F;
			this.ArmLeft02.xRot = 0F;
			this.ArmLeft02.yRot = 0F;
			this.ArmLeft02.zRot = 0F;
			this.ArmLeft02.x = (3.0F) + (0F) * 16F;
			this.ArmLeft02.z = (2.5F) + (0F) * 16F;
			this.ArmRight01.xRot = -3.14F;
			this.ArmRight01.yRot = 0.0F;
			this.ArmRight01.zRot = -0.52F;
			this.ArmRight02.xRot = 0F;
			this.ArmRight02.yRot = 0F;
			this.ArmRight02.zRot = 0F;
			this.ArmRight02.x = (-3.0F) + (0F) * 16F;
			this.ArmRight02.z = (2.5F) + (0F) * 16F;
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
	    
	    //leg motion
	    this.LegLeft01.xRot = addk1;
	    this.LegRight01.xRot = addk2;
	
	}

	public void setFaceNormal(IShipEmotion ent)
	{

		this.setFace(0);
		this.setMouth(0);
	
	}

	public void setFaceBored(IShipEmotion ent)
	{

		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 511;
		
		if (t < 170)
		{
			this.setFace(5);
			
			if (t < 80)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(2);
			}
		}
		else if (t < 340)
		{
			this.setFace(8);
			this.setMouth(0);
		}
		else
		{
			this.setFace(0);
			this.setMouth(0);
		}
	
	}

	public void setFaceShy(IShipEmotion ent)
	{

		this.setFlush(true);
		
		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 511;
		
		if (t < 180)
		{
			this.setFace(0);
			
			if (t < 80)
			{
				this.setMouth(3);
			}
			else
			{
				this.setMouth(2);
			}
		}
		else if (t < 360)
		{
			this.setFace(8);
			this.setMouth(0);
		}
		else
		{
			this.setFace(5);
			this.setMouth(2);
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
    		scale = 1.72F;
        	offsetY = -0.58F;
		break;
    	case 2:
    		scale = 1.29F;
        	offsetY = -0.27F;
		break;
    	case 1:
    		scale = 0.86F;
        	offsetY = 0.35F;
		break;
    	default:
    		scale = 0.43F;
        	offsetY = 2F;
		break;
    	}
    	
    	
    	RenderHelper.animScale(this, scale, scale, scale);
this.animTransX += (0F); this.animTransY += (offsetY); this.animTransZ += (0F);
    	
    	//main body
		super.setupAnim(entity, f, f1, f2, f3, f4);
	}

}

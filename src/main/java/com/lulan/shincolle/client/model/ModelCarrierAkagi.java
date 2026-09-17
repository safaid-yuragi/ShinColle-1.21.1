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

public class ModelCarrierAkagi<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart Butt;
	public ModelPart Head;
	public ModelPart Cloth01;
	public ModelPart Cloth02;
	public ModelPart Cloth05;
	public ModelPart Cloth06;
	public ModelPart EquipB01;
	public ModelPart EquipC01;
	public ModelPart EquipABase;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart ClothBody01;
	public ModelPart ClothBody02;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart Skirt01;
	public ModelPart Tail01;
	public ModelPart LegRight02;
	public ModelPart EquipSR01;
	public ModelPart LegLeft02;
	public ModelPart EquipSL01;
	public ModelPart Skirt02;
	public ModelPart Cloth07;
	public ModelPart Cloth08;
	public ModelPart Cloth09;
	public ModelPart EquipS01;
	public ModelPart Tail02;
	public ModelPart Tail03;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Ear01;
	public ModelPart Ear02;
	public ModelPart Ahoke;
	public ModelPart HairU01;
	public ModelPart HairR01;
	public ModelPart HairL01;
	public ModelPart HairR02;
	public ModelPart HairL02;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart Cloth03;
	public ModelPart Cloth04;
	public ModelPart EquipC02;
	public ModelPart EquipABelt01;
	public ModelPart EquipABody01;
	public ModelPart EquipABody04;
	public ModelPart EquipABody02;
	public ModelPart EquipABody03;
	public ModelPart EquipABody05;
	public ModelPart EquipAArr01a;
	public ModelPart EquipAArr02a;
	public ModelPart EquipAArr03a;
	public ModelPart EquipABody05b;
	public ModelPart EquipABody05c;
	public ModelPart EquipABelt02;
	public ModelPart EquipAArr01b;
	public ModelPart EquipAArr02b;
	public ModelPart EquipAArr03b;
	public ModelPart ArmLeft02;
	public ModelPart ClothHL01;
	public ModelPart EquipE01;
	public ModelPart EquipE02;
	public ModelPart EquipE04;
	public ModelPart EquipE03;
	public ModelPart EquipE05;
	public ModelPart EquipE06;
	public ModelPart ClothHL02;
	public ModelPart ClothHL03;
	public ModelPart ArmRight02;
	public ModelPart ClothHL01_1;
	public ModelPart EquipD01;
	public ModelPart EquipGlove;
	public ModelPart ClothHL02_1;
	public ModelPart ClothHL03_1;
	public ModelPart EquipD02;
	public ModelPart EquipD03;
	public ModelPart EquipD04;
	public ModelPart GlowBodyMain;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("ClothBody02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(-6.0F, -3.8F, -2.3F, 0.2617993877991494F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -11.8F, -1.0F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("Ear02", CubeListBuilder.create().addBox(-1.5F, 0.0F, -6.0F, 3.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(3.8F, -14.5F, 5.7F, -0.7853981633974483F, -0.2617993877991494F, 0.13962634015954636F));
		PartDefinition partdef4 = partdef2.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 12.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.2F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -4.0F, -11.5F, 0.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(-1.0F, -9.0F, -5.5F, 0.08726646259971647F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef6 = partdef4.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(-7.0F, 3.0F, -5.5F, -0.13962634015954636F, 0.17453292519943295F, 0.08726646259971647F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(0.2F, 7.0F, 0.0F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef8 = partdef4.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(7.0F, 3.0F, -5.5F, -0.13962634015954636F, -0.17453292519943295F, -0.08726646259971647F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef10 = partdef4.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 14.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -6.5F));
		PartDefinition partdef11 = partdef2.addOrReplaceChild("Ear01", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -6.0F, 3.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(-3.8F, -14.5F, 5.7F, -0.7853981633974483F, 0.2617993877991494F, -0.13962634015954636F));
		PartDefinition partdef12 = partdef2.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 14.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.5F, 1.0F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-7.0F, 0.0F, -4.5F, 14.0F, 13.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 11F, 6.2F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(2.8F, -8.5F, -3.5F, -0.6981317007977318F, -0.10471975511965977F, -0.08726646259971647F));
		PartDefinition partdef16 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F, 0.13962634015954636F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(0.0F, 14.0F, -3.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("EquipSL01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.5F, 6.0F, 4.0F, 7.0F), PartPose.offset(0.0F, 15.0F, 3.0F));
		PartDefinition partdef20 = partdef16.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.13962634015954636F, 0.0F, -0.13962634015954636F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(0.0F, 14.0F, -3.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("EquipSR01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.5F, 6.0F, 4.0F, 7.0F), PartPose.offset(0.0F, 15.0F, 3.0F));
		PartDefinition partdef23 = partdef16.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -6.3F, 17.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 2.3F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("Cloth08", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(-0.5F, 0.5F, -7.0F, -0.15707963267948966F, -0.10471975511965977F, 0.17453292519943295F));
		PartDefinition partdef25 = partdef23.addOrReplaceChild("Cloth09", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 10.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.2F, -6.8F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef26 = partdef23.addOrReplaceChild("EquipS01", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.3F, -7.3F, -0.2792526803190927F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef23.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-9.0F, 0.0F, -6.0F, 18.0F, 8.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 4.0F, -0.6F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef28 = partdef23.addOrReplaceChild("Cloth07", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(0.5F, 0.5F, -7.0F, -0.17453292519943295F, -0.13962634015954636F, -0.20943951023931953F));
		PartDefinition partdef29 = partdef16.addOrReplaceChild("Tail01", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 6.5F, 1.0F, -0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("Tail02", CubeListBuilder.create().addBox(-1.0F, -1.0F, -0.3F, 2.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 7.5F, 0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("Tail03", CubeListBuilder.create().addBox(-1.0F, -1.0F, -0.4F, 2.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 7.5F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef32 = partdef0.addOrReplaceChild("EquipABase", CubeListBuilder.create().addBox(-0.5F, -1.0F, -0.3F, 3.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, -8.0F, 3.6F, 0.0F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("EquipABelt01", CubeListBuilder.create().addBox(-12.0F, 0.0F, -0.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3490658503988659F, 0.13962634015954636F, -0.5235987755982988F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("EquipABody01", CubeListBuilder.create().addBox(-5.0F, -5.5F, -1.0F, 4.0F, 8.0F, 2.0F), PartPose.offsetAndRotation(-12.5F, -2.5F, 0.0F, 0.0F, 0.0F, -0.7853981633974483F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("EquipABody02", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F), PartPose.offset(-3.5F, -11.4F, 0.0F));
		PartDefinition partdef36 = partdef34.addOrReplaceChild("EquipABody03", CubeListBuilder.create().addBox(-3.5F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F), PartPose.offset(-3.5F, -6.5F, 0.0F));
		PartDefinition partdef37 = partdef34.addOrReplaceChild("EquipABody04", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F), PartPose.offset(-8.0F, 0.0F, 0.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("EquipAArr01a", CubeListBuilder.create().addBox(0.0F, -4.0F, 0.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(-0.5F, 0.7F, 0.0F, 0.0F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("EquipAArr01b", CubeListBuilder.create().addBox(-0.5F, -2.7F, 0.5F, 2.0F, 4.0F, 0.0F), PartPose.offset(0.0F, -2.0F, 0.0F));
		PartDefinition partdef40 = partdef37.addOrReplaceChild("EquipAArr02a", CubeListBuilder.create().addBox(0.0F, -4.0F, 0.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(-1.5F, 0.3F, -1.1F, 0.05235987755982988F, -0.31869712141416456F, -0.05235987755982988F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("EquipAArr02b", CubeListBuilder.create().addBox(-0.5F, -2.7F, 0.5F, 2.0F, 4.0F, 0.0F), PartPose.offset(0.0F, -2.0F, 0.0F));
		PartDefinition partdef42 = partdef37.addOrReplaceChild("EquipABody05", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F), PartPose.offset(0.0F, 3.0F, 0.0F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("EquipABody05b", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F), PartPose.offset(0.0F, 10.0F, 0.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("EquipABody05c", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F), PartPose.offset(0.0F, 10.0F, 0.0F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("EquipABelt02", CubeListBuilder.create().addBox(0.0F, 0.0F, -0.5F, 17.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(3.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.7740535232594852F));
		PartDefinition partdef46 = partdef37.addOrReplaceChild("EquipAArr03a", CubeListBuilder.create().addBox(0.0F, -4.0F, 0.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(-1.6F, 0.0F, 0.4F, -0.03490658503988659F, -0.2617993877991494F, 0.0F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("EquipAArr03b", CubeListBuilder.create().addBox(-0.5F, -2.7F, 0.5F, 2.0F, 4.0F, 0.0F), PartPose.offset(0.0F, -2.0F, 0.0F));
		PartDefinition partdef48 = partdef0.addOrReplaceChild("Cloth02", CubeListBuilder.create().mirror().addBox(0.0F, -3.5F, -4.6F, 1.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(5.8F, -7.9F, 0.0F, 0.08726646259971647F, -0.13962634015954636F, -0.13962634015954636F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("Cloth03", CubeListBuilder.create().addBox(0.0F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.5F, -4.6F, 0.13962634015954636F, -0.3141592653589793F, 0.13962634015954636F));
		PartDefinition partdef50 = partdef48.addOrReplaceChild("Cloth04", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-0.1F, 0.6F, -4.5F, -0.13962634015954636F, -0.3490658503988659F, -0.20943951023931953F));
		PartDefinition partdef51 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -8.7F, -0.7F, 0.0F, 0.0F, 0.3141592653589793F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("EquipD01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.5F, 8.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(0.3F, 2.0F, 0.0F, 0.0F, 3.141592653589793F, 0.0F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("EquipD02", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(5.6F, 3.0F, 0.0F, -0.03490658503988659F, 1.4660765716752369F, 3.141592653589793F));
		PartDefinition partdef54 = partdef53.addOrReplaceChild("EquipD03", CubeListBuilder.create().addBox(-5.5F, -26.0F, 0.0F, 11.0F, 26.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("EquipD04", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 11.0F, 1.0F), PartPose.offset(0.0F, -37.0F, 0.0F));
		PartDefinition partdef56 = partdef51.addOrReplaceChild("ClothHL01_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.0F, 6.0F, 5.0F, 6.0F), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef57 = partdef56.addOrReplaceChild("ClothHL02_1", CubeListBuilder.create().addBox(-4.0F, 0.0F, -3.0F, 7.0F, 5.0F, 6.0F), PartPose.offset(0.0F, 4.5F, 0.0F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("ClothHL03_1", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 8.0F, 5.0F, 7.0F), PartPose.offset(-1.0F, 4.0F, 0.0F));
		PartDefinition partdef59 = partdef51.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(-3.0F, 11.0F, 2.5F));
		PartDefinition partdef60 = partdef59.addOrReplaceChild("EquipGlove", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(2.5F, 6.3F, -2.5F));
		PartDefinition partdef61 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -12.1F, -0.6F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef62 = partdef0.addOrReplaceChild("EquipB01", CubeListBuilder.create().addBox(-7.0F, -6.0F, -6.0F, 14.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -4.2F, 0.7F, 0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef63 = partdef0.addOrReplaceChild("ClothBody01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(6.0F, -3.8F, -2.3F, 0.2617993877991494F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef64 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -8.7F, -0.7F, 0.20943951023931953F, 0.0F, -0.20943951023931953F));
		PartDefinition partdef65 = partdef64.addOrReplaceChild("ClothHL01", CubeListBuilder.create().addBox(-2.5F, 0.0F, -3.0F, 6.0F, 5.0F, 6.0F), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef66 = partdef65.addOrReplaceChild("ClothHL02", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 5.0F, 6.0F), PartPose.offset(0.0F, 4.5F, 0.0F));
		PartDefinition partdef67 = partdef66.addOrReplaceChild("ClothHL03", CubeListBuilder.create().addBox(-2.5F, 0.0F, -3.5F, 8.0F, 5.0F, 7.0F), PartPose.offset(-1.0F, 4.0F, 0.0F));
		PartDefinition partdef68 = partdef64.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(3.0F, 11.0F, 2.5F));
		PartDefinition partdef69 = partdef68.addOrReplaceChild("EquipE01", CubeListBuilder.create().addBox(-0.5F, -0.5F, -20.0F, 1.0F, 1.0F, 20.0F), PartPose.offsetAndRotation(-2.8F, 10.5F, -3.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef70 = partdef69.addOrReplaceChild("EquipE02", CubeListBuilder.create().addBox(-0.5F, -0.5F, -15.0F, 1.0F, 1.0F, 15.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -19.7F, -0.4886921905584123F, 0.0F, 0.0F));
		PartDefinition partdef71 = partdef70.addOrReplaceChild("EquipE03", CubeListBuilder.create().addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -14.7F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef72 = partdef69.addOrReplaceChild("EquipE04", CubeListBuilder.create().addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 15.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -0.2F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef73 = partdef72.addOrReplaceChild("EquipE05", CubeListBuilder.create().addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 14.7F, 0.45378560551852565F, 0.0F, 0.0F));
		PartDefinition partdef74 = partdef73.addOrReplaceChild("EquipE06", CubeListBuilder.create().addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 11.7F, -0.2792526803190927F, 0.0F, 0.0F));
		PartDefinition partdef75 = partdef0.addOrReplaceChild("Cloth06", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 12.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -11.6F, 3.2F, 0.06981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef76 = partdef0.addOrReplaceChild("EquipC01", CubeListBuilder.create().addBox(-9.0F, 0.0F, -4.0F, 18.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(-1.2F, 6.4F, -0.8F, 0.0F, 0.08726646259971647F, -0.18203784098300857F));
		PartDefinition partdef77 = partdef76.addOrReplaceChild("EquipC02", CubeListBuilder.create().addBox(-2.5F, 0.0F, -3.0F, 3.0F, 9.0F, 6.0F), PartPose.offsetAndRotation(-8.0F, -0.5F, 1.5F, 0.17453292519943295F, 0.0F, 0.3490658503988659F));
		PartDefinition partdef78 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-2.8F, -8.5F, -3.5F, -0.6981317007977318F, 0.10471975511965977F, 0.08726646259971647F));
		PartDefinition partdef79 = partdef0.addOrReplaceChild("Cloth05", CubeListBuilder.create().addBox(-1.0F, -3.5F, -4.6F, 1.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(-5.8F, -7.9F, 0.0F, 0.08726646259971647F, 0.13962634015954636F, 0.13962634015954636F));
		PartDefinition partdef80 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef81 = partdef80.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -11.8F, -1.0F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef82 = partdef81.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef83 = partdef81.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef84 = partdef81.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef85 = partdef81.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef86 = partdef81.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef87 = partdef81.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef88 = partdef81.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef89 = partdef81.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef90 = partdef81.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef91 = partdef81.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelCarrierAkagi(ModelPart root)
	{
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
		this.ClothHL01 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ClothHL01");
		this.Ear02 = root.getChild("BodyMain").getChild("Head").getChild("Ear02");
		this.ClothBody02 = root.getChild("BodyMain").getChild("ClothBody02");
		this.EquipAArr01a = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01").getChild("EquipABody01").getChild("EquipABody04").getChild("EquipAArr01a");
		this.EquipD03 = root.getChild("BodyMain").getChild("ArmRight01").getChild("EquipD01").getChild("EquipD02").getChild("EquipD03");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.Ahoke = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.Cloth08 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Cloth08");
		this.BodyMain = root.getChild("BodyMain");
		this.HairR01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairR01");
		this.EquipSR01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("EquipSR01");
		this.EquipAArr03b = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01").getChild("EquipABody01").getChild("EquipABody04").getChild("EquipAArr03a").getChild("EquipAArr03b");
		this.HairR02 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.Tail02 = root.getChild("BodyMain").getChild("Butt").getChild("Tail01").getChild("Tail02");
		this.Cloth09 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Cloth09");
		this.Head = root.getChild("BodyMain").getChild("Head");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.EquipAArr02a = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01").getChild("EquipABody01").getChild("EquipABody04").getChild("EquipAArr02a");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.EquipABody01 = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01").getChild("EquipABody01");
		this.EquipABase = root.getChild("BodyMain").getChild("EquipABase");
		this.EquipAArr01b = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01").getChild("EquipABody01").getChild("EquipABody04").getChild("EquipAArr01a").getChild("EquipAArr01b");
		this.EquipD01 = root.getChild("BodyMain").getChild("ArmRight01").getChild("EquipD01");
		this.EquipABody02 = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01").getChild("EquipABody01").getChild("EquipABody02");
		this.Cloth02 = root.getChild("BodyMain").getChild("Cloth02");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.EquipABody03 = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01").getChild("EquipABody01").getChild("EquipABody03");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.EquipE05 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipE01").getChild("EquipE04").getChild("EquipE05");
		this.ClothHL03_1 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ClothHL01_1").getChild("ClothHL02_1").getChild("ClothHL03_1");
		this.EquipS01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("EquipS01");
		this.HairL01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairL01");
		this.EquipSL01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("EquipSL01");
		this.EquipABody04 = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01").getChild("EquipABody01").getChild("EquipABody04");
		this.Hair = root.getChild("BodyMain").getChild("Head").getChild("Hair");
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.HairU01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairU01");
		this.EquipD04 = root.getChild("BodyMain").getChild("ArmRight01").getChild("EquipD01").getChild("EquipD02").getChild("EquipD03").getChild("EquipD04");
		this.HairL02 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.EquipABody05 = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01").getChild("EquipABody01").getChild("EquipABody04").getChild("EquipABody05");
		this.EquipB01 = root.getChild("BodyMain").getChild("EquipB01");
		this.EquipABody05c = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01").getChild("EquipABody01").getChild("EquipABody04").getChild("EquipABody05").getChild("EquipABody05b").getChild("EquipABody05c");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.Cloth03 = root.getChild("BodyMain").getChild("Cloth02").getChild("Cloth03");
		this.EquipGlove = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipGlove");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.ClothBody01 = root.getChild("BodyMain").getChild("ClothBody01");
		this.Hair02 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.EquipABelt02 = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01").getChild("EquipABody01").getChild("EquipABody04").getChild("EquipABody05").getChild("EquipABody05b").getChild("EquipABody05c").getChild("EquipABelt02");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.Cloth04 = root.getChild("BodyMain").getChild("Cloth02").getChild("Cloth04");
		this.ClothHL03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ClothHL01").getChild("ClothHL02").getChild("ClothHL03");
		this.EquipABelt01 = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01");
		this.EquipD02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("EquipD01").getChild("EquipD02");
		this.Cloth06 = root.getChild("BodyMain").getChild("Cloth06");
		this.EquipC02 = root.getChild("BodyMain").getChild("EquipC01").getChild("EquipC02");
		this.Hair01 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.Cloth07 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Cloth07");
		this.EquipE01 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipE01");
		this.ClothHL01_1 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ClothHL01_1");
		this.Tail01 = root.getChild("BodyMain").getChild("Butt").getChild("Tail01");
		this.ClothHL02_1 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ClothHL01_1").getChild("ClothHL02_1");
		this.EquipABody05b = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01").getChild("EquipABody01").getChild("EquipABody04").getChild("EquipABody05").getChild("EquipABody05b");
		this.EquipAArr02b = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01").getChild("EquipABody01").getChild("EquipABody04").getChild("EquipAArr02a").getChild("EquipAArr02b");
		this.EquipE02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipE01").getChild("EquipE02");
		this.Ear01 = root.getChild("BodyMain").getChild("Head").getChild("Ear01");
		this.ClothHL02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ClothHL01").getChild("ClothHL02");
		this.EquipE06 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipE01").getChild("EquipE04").getChild("EquipE05").getChild("EquipE06");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.EquipC01 = root.getChild("BodyMain").getChild("EquipC01");
		this.EquipE04 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipE01").getChild("EquipE04");
		this.Tail03 = root.getChild("BodyMain").getChild("Butt").getChild("Tail01").getChild("Tail02").getChild("Tail03");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.EquipE03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipE01").getChild("EquipE02").getChild("EquipE03");
		this.HairMain = root.getChild("BodyMain").getChild("Head").getChild("HairMain");
		this.EquipAArr03a = root.getChild("BodyMain").getChild("EquipABase").getChild("EquipABelt01").getChild("EquipABody01").getChild("EquipABody04").getChild("EquipAArr03a");
		this.Cloth05 = root.getChild("BodyMain").getChild("Cloth05");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowHead");
		this.offsetItem = new float[] {0.06F, 1F, -0.06F};
		this.offsetBlock = new float[] {0.06F, 1F, -0.06F};
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
		
		boolean flag = !EmotionHelper.checkModelState(0, state);
		this.EquipE01.visible = !(flag);    //bow
		this.EquipGlove.visible = !(flag);  //glove
				
		flag = !EmotionHelper.checkModelState(1, state);
		this.EquipABase.visible = !(flag);  //quiver
		
		flag = !EmotionHelper.checkModelState(2, state);
		this.EquipD01.visible = !(flag);    //deck
		
		flag = !EmotionHelper.checkModelState(3, state);
		this.EquipC01.visible = !(flag);    //water bag
		
		flag = !EmotionHelper.checkModelState(4, state);
		this.EquipB01.visible = !(flag);    //armor
		
		flag = !EmotionHelper.checkModelState(5, state);
		this.EquipS01.visible = !(flag);    //skirt
		
		flag = !EmotionHelper.checkModelState(6, state);
		this.Ear01.visible = !(flag);       //ear+tail
		this.Ear02.visible = !(flag);
		this.Tail01.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(7, state);
		this.EquipSL01.visible = !(flag);  //shoes
    	this.EquipSR01.visible = !(flag);
	
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

this.animTransX += (0F); this.animTransY += (0.53F + 0.25F * ent.getScaleLevel()); this.animTransZ += (0F);
		this.setFaceHungry(ent);
	  	
	  	if (((IFloatingEntity)ent).getEntityDepth() > 0)
	  	{
	  		this.EquipSL01.visible = true;
	    	this.EquipSR01.visible = true;
    	}
    	else
    	{
    		this.EquipSL01.visible = false;
        	this.EquipSR01.visible = false;
    	}
    	
	  	//Body
	  	this.Skirt01.xRot = -0.2F;
	  	this.Skirt02.xRot = -0.3F;
	    //arm 
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
	    
		int state = ent.getStateEmotion(ID.S.State);
		
	    if (EmotionHelper.checkModelState(3, state))
	    {
	    	this.ArmRight01.zRot += 0.15F;
	    }
	    
	    if (EmotionHelper.checkModelState(6, state))
	    {
	    	this.ArmLeft01.zRot -= 0.15F;
	    	
	    	//tail
	    	this.Tail01.xRot = -1.85F;
	    	this.Tail02.xRot = -0.6F;
	    	this.Tail03.xRot = -0.6F;
	    }
	    
		//leg
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.x = (0.0F) + (0F) * 16F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.x = (0.0F) + (0F) * 16F;
		this.LegRight02.y = (14.0F) + (0F) * 16F;
		
		//equip
		this.EquipE01.xRot = 0.05F;
		this.EquipE01.yRot = -0.2F;
		this.EquipE01.zRot = 0F;
		this.EquipE01.x = (-2.8F) + (0F) * 16F;
		this.EquipE02.xRot = -0.4887F;
		this.EquipE05.xRot = 0.4538F;
		this.EquipD02.xRot = 0.25F;
		this.EquipD02.yRot = 1.6755F;
		this.EquipD02.zRot = 3.1416F;
		this.EquipD02.y = (3.0F) + (0F) * 16F;
		this.EquipS01.xRot = -0.95F;
		
		//頭部
	  	this.Head.xRot = -0.2618F;
	  	this.Head.yRot = 0F;
	  	this.Head.zRot = 0F;
	    //胸部
  	    this.BoobL.xRot = -1.0F;
  	    this.BoobR.xRot = -1.0F;
	  	//Body
  	    this.Ahoke.yRot = -1.0F;
	  	this.BodyMain.xRot = 1.2217F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 1.2217F;
	  	this.Butt.xRot = -0.05F;
	  	//hair
	  	this.Hair01.xRot = 0.2F;
	  	this.Hair01.zRot = -0.36F;
	  	this.Hair02.xRot = 0.2F;
	  	this.Hair02.zRot = -0.15F;
	  	this.HairL01.zRot = 0.0873F;
	  	this.HairL02.zRot = -0.3142F;
	  	this.HairR01.zRot = -0.0873F;
	  	this.HairR02.zRot = -1.2217F;
		this.HairL01.xRot = - 0.28F;
	  	this.HairL02.xRot = 0.15F;
	  	this.HairR01.xRot = -0.35F;
	  	this.HairR02.xRot = 0.18F;
	    //arm 
	  	this.ArmLeft01.xRot = -0.35F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = -3F;
	    this.ArmLeft02.xRot = 0F;
    	this.ArmRight01.xRot = -0.35F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -0.35F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.zRot = -0.8727F;
		//leg
		this.LegLeft01.xRot = -0.14F;
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.09F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.xRot = -1.2217F;
		this.LegRight01.yRot = -0.5236F;
		this.LegRight01.zRot = 0F;
		this.LegRight02.xRot = 1.0472F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F + f * 0.25F);
  		float angleX1 = Mth.cos(f2*0.1F + 0.3F + f * 0.5F);
  		float angleX2 = Mth.cos(f2*0.1F + 0.6F + f * 0.5F);
  		float angleX3 = Mth.cos(f2*0.1F + 0.9F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
  		float addk1 = 0;
  		float addk2 = 0;
  		float headX = 0F;
  		float headZ = 0F;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}

    	//leg move
  		addk1 = angleAdd1 * 0.5F - 0.2793F;  //LegLeft01
	  	addk2 = angleAdd2 * 0.5F - 0.1396F;  //LegRight01
	  	
	  	if (((IFloatingEntity)ent).getEntityDepth() > 0)
	  	{
	  		this.EquipSL01.visible = true;
	    	this.EquipSR01.visible = true;
    	}
    	
  	    //head
	  	this.Head.xRot = f4 * 0.014F + 0.1047F;
	  	this.Head.yRot = f3 * 0.01F;
	    //boob
  	    this.BoobL.xRot = angleX * 0.06F - 0.8F;
  	    this.BoobR.xRot = angleX * 0.06F - 0.8F;
	  	//body
  	    this.Ahoke.yRot = angleX * 0.25F + 0.45F;
	  	this.BodyMain.xRot = -0.1047F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.3142F;
	  	this.Skirt01.xRot = -0.14F;
	  	this.Skirt02.xRot = -0.0873F;
	  	//cloth
	  	this.ClothHL02_1.y = (4.5F) + (0F) * 16F;
    	this.ClothHL03_1.y = (4.0F) + (0F) * 16F;
	  	//hair
    	this.Hair01.xRot = angleX * 0.04F + 0.23F;
    	this.Hair01.zRot = 0F;
    	this.Hair02.xRot = -angleX1 * 0.07F - 0.1F;
    	this.Hair02.zRot = 0F;
    	this.HairL01.xRot = -0.16F;
	  	this.HairL02.xRot = 0.1745F;
	  	this.HairR01.xRot = -0.14F;
	  	this.HairR02.xRot = 0.174F;
	  	this.HairL01.zRot = -0.0873F;
	  	this.HairL02.zRot = 0.087F;
	  	this.HairR01.zRot = 0.0873F;
	  	this.HairR02.zRot = -0.053F;
	    //arm 
	  	this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.21F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = angleX * 0.03F - 0.21F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmRight01.xRot = angleAdd1 * 0.25F + 0.05F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -angleX * 0.03F + 0.21F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
		
		int state = ent.getStateEmotion(ID.S.State);
		boolean fbag = EmotionHelper.checkModelState(3, state);
		boolean ftail = EmotionHelper.checkModelState(6, state);
	    
	    if (fbag)
	    {
	    	this.ArmRight01.zRot += 0.15F;
	    }
	    
	    if (ftail)
	    {
	    	//tail
	    	this.Tail01.xRot = angleX1 * 0.5F - 0.7F;
	    	this.Tail02.xRot = -angleX2 * 0.5F;
	    	this.Tail03.xRot = -angleX3 * 0.5F;
	    }
	    
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.1396F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (0.0F) + (0F) * 16F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.1396F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.x = (0.0F) + (0F) * 16F;
		this.LegRight02.y = (14.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		
		//equip
		this.EquipE01.xRot = 0.05F;
		this.EquipE01.yRot = 0F;
		this.EquipE01.zRot = 0F;
		this.EquipE01.x = (-2.8F) + (0F) * 16F;
		this.EquipE02.xRot = -0.4887F;
		this.EquipE05.xRot = 0.4538F;
		this.EquipD01.xRot = 0F;
		this.EquipD02.xRot = -0.05F;
		this.EquipD02.yRot = 1.6755F;
		this.EquipD02.zRot = 3.1416F;
		this.EquipD02.y = (3.0F) + (0F) * 16F;
		this.EquipS01.xRot = -0.28F;
		
		//ear
		float modf2 = f2 % 128F;
		if (modf2 < 6F)
		{
			//total 3 ticks, loop twice in 6 ticks
			if (modf2 >= 3F) modf2 -= 3F;
			float anglef2 = Mth.sin(modf2 * 1.0472F) * 0.25F;
			this.Ear01.zRot = -anglef2 - 0.14F;
			this.Ear02.zRot = anglef2 + 0.14F;
		}
		else
		{
			this.Ear01.zRot = -0.14F;
			this.Ear02.zRot = 0.14F;
		}

	    if (ent.getIsSprinting() || f1 > 0.1F)
	    {	//奔跑動作
	    	//hair
	    	this.Hair01.xRot = angleAdd1 * 0.1F + f1 * 0.4F;
	    	this.Hair02.xRot += 0.5F;
		    //arm 
		    this.ArmLeft01.zRot += f1 * -0.2F;
		    this.ArmRight01.zRot += f1 * 0.2F;
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {	//潛行, 蹲下動作
this.animTransX += (0F); this.animTransY += (0.1F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 1.0472F;
		  	this.BodyMain.xRot = 1.0472F;
		  	this.Butt.xRot = -0.8378F;
		    //arm 
		    this.ArmLeft01.xRot = -0.7F;
		    this.ArmLeft01.zRot = 0.2618F;
		    this.ArmRight01.xRot = -0.7F;
		    this.ArmRight01.zRot = -0.2618F;
		    //equip
		    this.EquipD02.xRot = 0.15F;
		    this.EquipE01.yRot = 1.3F;
		    //tail
		    this.Tail01.xRot += 1.3F;
  		}//end if sneaking
  		
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {	//騎乘動作
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
		    	setFace(1);
this.animTransX += (0F); this.animTransY += (0.43F); this.animTransZ += (0F);
		    	//head
		    	int nodf2 = (int)f2 % 60;
		    	this.Head.xRot = 0.4F;
		    	if (nodf2 < 30)
		    	{
		    		if (nodf2 < 6)
		    		{
		    			this.Head.xRot = nodf2 * 0.02F + 0.4F;
		    		}
		    		else if (nodf2 < 11)
		    		{
		    			this.Head.xRot = (nodf2 - 5) * 0.03F + 0.5F;
		    		}
		    		else if (nodf2 < 14)
		    		{
		    			this.Head.xRot = (nodf2 - 10) * -0.09F + 0.65F;
		    		}
		    	}
		    	this.Head.yRot = 0F;
		    	this.Head.zRot = 0F;
		    	//body
		    	this.Butt.xRot = -0.2F;
				this.Skirt01.xRot = -0.26F;
				this.Skirt02.xRot = -0.45F;
				//arm
				this.ArmLeft01.xRot = 0.4F;
				this.ArmLeft01.zRot = -0.2618F;
				this.ArmRight01.xRot = 0.4F;
				this.ArmRight01.zRot = 0.2618F;
				//leg
				addk1 = -0.9F;
				addk2 = -0.9F;
				this.LegLeft01.zRot = -0.14F;
				this.LegLeft02.xRot = 1.2217F;
				this.LegLeft02.yRot = 1.2217F;
				this.LegLeft02.zRot = -1.0472F;
				this.LegLeft02.x = (0.0F) + (0.17F) * 16F;
				this.LegLeft02.y = (14.0F) + (-0.03F) * 16F;
				this.LegLeft02.z = (-3.0F) + (0.2F) * 16F;
				this.LegRight01.zRot = 0.14F;
				this.LegRight02.xRot = 1.2217F;
				this.LegRight02.yRot = -1.2217F;
				this.LegRight02.zRot = 1.0472F;
				this.LegRight02.x = (0.0F) + (-0.17F) * 16F;
				this.LegRight02.y = (14.0F) + (-0.03F) * 16F;
				this.LegRight02.z = (-3.0F) + (0.2F) * 16F;
				//tail
				this.Tail01.xRot += 1.7F;
				this.Tail02.xRot += 0.15F;
				this.Tail03.xRot += 0.15F;
				this.Tail01.xRot *= 0.2F;
				this.Tail02.xRot *= 0.2F;
				this.Tail03.xRot *= 0.2F;
				//equip
				this.EquipE01.yRot = 1.7F;
				this.EquipE01.zRot = 0.15F;
				this.EquipD02.xRot = 0.2F;
				this.EquipD02.y = (3.0F) + (-0.5F) * 16F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.36F); this.animTransZ += (0F);
		    	//Body
			  	this.Head.xRot += 0.1047F;
		    	this.BodyMain.xRot = -0.1396F;
			  	this.Butt.xRot = 0.1396F;
				//arm 
			  	this.ArmLeft01.xRot = -0.4F;
			  	this.ArmLeft01.zRot = 0.2618F;
		    	this.ArmRight01.xRot = -0.4F;
				this.ArmRight01.zRot = -0.2618F;
			  	//leg
			  	addk1 = -1.0472F;
			  	addk2 = -1.0472F;
			  	this.LegLeft01.yRot = 0.0524F;
				this.LegLeft01.zRot = 0F;
				this.LegLeft02.z = (-3.0F) + (0.38F) * 16F;
				this.LegLeft02.xRot = 2.5831F;
				this.LegLeft02.zRot = 0.0175F;
				this.LegRight01.yRot = -0.0524F;
				this.LegRight01.zRot = 0F;
				this.LegRight02.z = (-3.0F) + (0.38F) * 16F;
				this.LegRight02.xRot = 2.5831F;
				this.LegRight02.zRot = -0.0175F;
				//tail
				this.Tail01.xRot += 1F;
				this.Tail02.xRot += 0.15F;
				this.Tail03.xRot += 0.15F;
				//equip
				this.EquipE01.yRot = 1.7F;
				this.EquipE01.zRot = -0.2F;
				this.EquipD02.xRot = 0.2F;
				this.EquipD02.y = (3.0F) + (-0.5F) * 16F;
	    	}
  		}//end if sitting
	    
	    //攻擊動作    
	    if (ent.getAttackTick() > 20)
	    {
	    	//set start time
	    	if(ent.getAttackTick() >= 49) ent.setAttackTick2(0);
	    	int tick = ent.getAttackTick2();
	    	float parTick = f2 - (int)f2 + tick;
	    	
	    	//head
		    this.Head.xRot = 0F;
	    	this.Head.yRot = -1.31F;
	    	//body
	    	this.BodyMain.xRot = -0.05F;
	    	this.BodyMain.yRot = 1.4F;
	    	//cloth
	    	this.ClothHL02_1.y = (4.5F) + (-0.17F) * 16F;
	    	this.ClothHL03_1.y = (4.0F) + (-0.2F) * 16F;
	    	//arm
	    	this.ArmLeft01.xRot = -1.5708F;
	    	this.ArmLeft01.yRot = -1.35F;
		  	this.ArmLeft01.zRot = 0F;
	    	this.ArmRight01.xRot = 0F;
	    	this.ArmRight01.yRot = 2.1817F;
			this.ArmRight01.zRot = 1.5708F;
			this.ArmRight02.zRot = -2.44F + 0.15F * parTick;  //-2.44~-1.57
			if(this.ArmRight02.zRot > -1.57F) this.ArmRight02.zRot = -1.57F;
			this.ArmRight02.x = (-3.0F) + (0.31F) * 16F;
			//leg
			addk1 = -0.35F;
		  	addk2 = -0.23F;
			this.LegLeft01.zRot = -0.14F;
			this.LegRight01.zRot = 0.14F;
			//equip
			this.EquipE01.visible = true;
			this.EquipD01.xRot = 1.3F;
			this.EquipD02.xRot = -1.15F;
			this.EquipD02.yRot = -2.0F;
			this.EquipD02.zRot = 1.7453F;
			this.EquipE01.xRot = 0.2618F;
			this.EquipE01.zRot = -0.23F;
			this.EquipE01.x = (-2.8F) + (-0.15F) * 16F;
		    this.EquipE02.xRot = -0.7F + 0.1F * parTick;  //-0.7~-0.49
		    if (this.EquipE02.xRot > -0.49F) this.EquipE02.xRot = -0.49F;
		    this.EquipE05.xRot = 0.7F - 0.1F * parTick;  //0.7~0.45
		    if (this.EquipE05.xRot < 0.45F) this.EquipE05.xRot = 0.45F;
		    if (tick > 5 && tick < 12)
		    {
		    	this.EquipE01.xRot -= 0.36F * Mth.sin(parTick * 0.2244F);
		    	this.EquipE01.zRot -= 5F * Mth.sin(parTick * 0.2244F);
		    }
		    if (tick >= 12)
		    {
		    	this.EquipE01.xRot = -0.1F;
		    	this.EquipE01.zRot = -3.3F;
		    }
		    
		    //save tick
		    ent.setAttackTick2(++tick);
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
	    
	    //鬢毛調整
	    headX = this.Head.xRot * -0.5F;
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.xRot += headX;
	  	this.Hair02.xRot += headX * 0.1F;
	    this.Hair01.zRot += headZ;
	  	this.Hair02.zRot += headZ * 0.7F;
	  	this.HairL01.zRot += headZ;
	  	this.HairL02.zRot += headZ * 0.8F;
	  	this.HairR01.zRot += headZ;
	  	this.HairR02.zRot += headZ * 0.8F;
		this.HairL01.xRot += angleX * 0.04F + headX;
	  	this.HairL02.xRot += angleX1 * 0.07F + headX * 0.8F;
	  	this.HairR01.xRot += angleX * 0.04F + headX;
	  	this.HairR02.xRot += angleX1 * 0.07F + headX * 0.8F;
	    
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
    		scale = 1.84F;
        	offsetY = -0.63F;
		break;
    	case 2:
    		scale = 1.38F;
        	offsetY = -0.37F;
		break;
    	case 1:
    		scale = 0.92F;
        	offsetY = 0.16F;
		break;
    	default:
    		scale = 0.46F;
        	offsetY = 1.81F;
		break;
    	}
    	
    	
    	RenderHelper.animScale(this, scale, scale, scale);
this.animTransX += (0F); this.animTransY += (offsetY); this.animTransZ += (0F);
    	
    	//main body
		super.setupAnim(entity, f, f1, f2, f3, f4);
	}

}

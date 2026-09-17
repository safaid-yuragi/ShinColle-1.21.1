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

public class ModelCarrierHime<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart Butt;
	public ModelPart ArmRight01;
	public ModelPart ArmLeft01;
	public ModelPart Cloth01;
	public ModelPart Cloth02;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Ahoke;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart HairL02;
	public ModelPart HairR02;
	public ModelPart Hair01;
	public ModelPart Hair04;
	public ModelPart Hair02;
	public ModelPart Hair03;
	public ModelPart Hair05;
	public ModelPart Hair06;
	public ModelPart Hair07;
	public ModelPart LegLeft01;
	public ModelPart Skirt01;
	public ModelPart LegRight01;
	public ModelPart LegLeft02;
	public ModelPart LegLeft01a;
	public ModelPart LegLeft01b;
	public ModelPart ShoesL01;
	public ModelPart ShoesL02;
	public ModelPart ShoesL03;
	public ModelPart ShoesL04;
	public ModelPart Skirt02;
	public ModelPart LegRight01a;
	public ModelPart LegRight01b;
	public ModelPart LegRight02;
	public ModelPart ShoesR01;
	public ModelPart ShoesR02;
	public ModelPart ShoesR03;
	public ModelPart ShoesR04;
	public ModelPart ArmRight01a;
	public ModelPart ArmRight01b;
	public ModelPart ArmRight02;
	public ModelPart EquipSR01;
	public ModelPart EquipSR02;
	public ModelPart EquipSR04;
	public ModelPart EquipSR03;
	public ModelPart EquipSR05;
	public ModelPart ArmLeft02;
	public ModelPart ArmLeft01a;
	public ModelPart ArmLeft01b;
	public ModelPart EquipSL01;
	public ModelPart EquipSL02;
	public ModelPart EquipSL04;
	public ModelPart EquipSL03;
	public ModelPart EquipSL05;
	public ModelPart GlowBodyMain;
	public ModelPart GlowBodyMain2;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ModelPart GlowArmLeft01;
	public ModelPart GlowArmLeft02;
	public ModelPart GlowArmRight01;
	public ModelPart GlowArmRight02;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("LegRight01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.17453292519943295F, 0.0F, -0.10471975511965977F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("LegRight02", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 6.0F), PartPose.offset(0.0F, 14.0F, -3.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("ShoesR01", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 3.0F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("ShoesR02", CubeListBuilder.create().mirror().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 2.5F, -0.7F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("ShoesR03", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 2.4F, -0.7F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("ShoesR04", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 2.2F, -0.3F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef8 = partdef2.addOrReplaceChild("LegRight01a", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 8.6F, -0.2F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef2.addOrReplaceChild("LegRight01b", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 11.6F, -0.1F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef1.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -6.0F, 17.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 2.9F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-9.0F, 0.0F, -6.0F, 18.0F, 4.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 2.8F, -0.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef1.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.3490658503988659F, 0.0F, 0.10471975511965977F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("LegLeft02", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 6.0F), PartPose.offset(0.0F, 14.0F, -3.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("ShoesL01", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 3.0F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("ShoesL02", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 2.5F, -0.7F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("ShoesL03", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 2.4F, -0.7F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("ShoesL04", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 2.2F, -0.3F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef12.addOrReplaceChild("LegLeft01a", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 8.6F, -0.2F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef12.addOrReplaceChild("LegLeft01b", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 11.6F, -0.1F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-7.0F, 0.0F, -4.0F, 14.0F, 5.0F, 8.0F), PartPose.offset(0.0F, -11.5F, -0.3F));
		PartDefinition partdef21 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(3.5F, -8.1F, -3.7F, -0.6981317007977318F, 0.08726646259971647F, 0.08726646259971647F));
		PartDefinition partdef22 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.3490658503988659F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("ArmLeft01b", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.5F, 9.0F, -0.1F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef22.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(3.0F, 12.0F, 2.5F));
		PartDefinition partdef25 = partdef22.addOrReplaceChild("ArmLeft01a", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.5F, 5.5F, -0.2F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef26 = partdef0.addOrReplaceChild("Cloth02", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 0.0F), PartPose.offset(0.3F, -4.5F, -6.5F));
		PartDefinition partdef27 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-3.0F, -2.0F, -3.5F, 6.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1F, -0.7F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.2F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -6.0F, -10.5F, 0.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(0.0F, -7.0F, -6.0F, 0.20943951023931953F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef31 = partdef29.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(-7.0F, 3.0F, -5.5F, -0.13962634015954636F, 0.17453292519943295F, 0.08726646259971647F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(0.2F, 7.0F, 0.0F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef33 = partdef29.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(7.0F, 3.0F, -5.5F, -0.13962634015954636F, -0.17453292519943295F, -0.08726646259971647F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef35 = partdef28.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 10.0F), PartPose.offset(0.0F, -15.0F, -3.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 17.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef37 = partdef36.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("Hair03", CubeListBuilder.create().addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 12.5F, -0.1F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef39 = partdef35.addOrReplaceChild("Hair04", CubeListBuilder.create().addBox(0.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(6.5F, 3.5F, 6.0F, 0.0F, -0.08726646259971647F, -0.08726646259971647F));
		PartDefinition partdef40 = partdef39.addOrReplaceChild("Hair05", CubeListBuilder.create().addBox(0.0F, -2.5F, -2.5F, 5.0F, 9.0F, 5.0F), PartPose.offsetAndRotation(1.5F, -1.0F, 0.0F, 0.10471975511965977F, -0.08726646259971647F, -0.17453292519943295F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("Hair06", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.5F, 4.0F, 7.0F, 5.0F), PartPose.offsetAndRotation(2.5F, 4.0F, 0.0F, 0.20943951023931953F, 0.0F, 0.13962634015954636F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("Hair07", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.2617993877991494F, 0.0F, 0.13962634015954636F));
		PartDefinition partdef43 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().mirror().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.0F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("ArmRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(-3.0F, 12.0F, 2.5F));
		PartDefinition partdef45 = partdef43.addOrReplaceChild("ArmRight01a", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-0.5F, 5.5F, -0.2F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef46 = partdef43.addOrReplaceChild("ArmRight01b", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-0.5F, 9.0F, -0.1F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef47 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-3.5F, -8.1F, -3.7F, -0.6981317007977318F, -0.08726646259971647F, -0.08726646259971647F));
		PartDefinition partdef48 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1F, -0.7F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef52 = partdef50.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef53 = partdef50.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef54 = partdef50.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef55 = partdef50.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef56 = partdef50.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef57 = partdef50.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef58 = partdef50.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef59 = partdef50.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef60 = partdef50.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));
		PartDefinition partdef61 = partdefinition.addOrReplaceChild("GlowBodyMain2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("GlowArmLeft01", CubeListBuilder.create(), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.3490658503988659F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("GlowArmLeft02", CubeListBuilder.create(), PartPose.offset(3.0F, 12.0F, 2.5F));
		PartDefinition partdef64 = partdef63.addOrReplaceChild("EquipSL01", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offsetAndRotation(-3.0F, 10.5F, -6.0F, -1.5707963267948966F, 0.0F, 1.5707963267948966F));
		PartDefinition partdef65 = partdef64.addOrReplaceChild("EquipSL02", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition partdef66 = partdef65.addOrReplaceChild("EquipSL03", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition partdef67 = partdef64.addOrReplaceChild("EquipSL04", CubeListBuilder.create().addBox(-0.5F, -9.0F, -0.5F, 1.0F, 9.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef68 = partdef67.addOrReplaceChild("EquipSL05", CubeListBuilder.create().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -9.0F, 0.0F));
		PartDefinition partdef69 = partdef61.addOrReplaceChild("GlowArmRight01", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.0F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef70 = partdef69.addOrReplaceChild("GlowArmRight02", CubeListBuilder.create(), PartPose.offset(-3.0F, 12.0F, 2.5F));
		PartDefinition partdef71 = partdef70.addOrReplaceChild("EquipSR01", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offsetAndRotation(3.0F, 10.5F, -6.0F, -1.5707963267948966F, 0.0F, 1.5707963267948966F));
		PartDefinition partdef72 = partdef71.addOrReplaceChild("EquipSR02", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition partdef73 = partdef72.addOrReplaceChild("EquipSR03", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition partdef74 = partdef71.addOrReplaceChild("EquipSR04", CubeListBuilder.create().addBox(-0.5F, -9.0F, -0.5F, 1.0F, 9.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef75 = partdef74.addOrReplaceChild("EquipSR05", CubeListBuilder.create().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -9.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelCarrierHime(ModelPart root)
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
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.ShoesL03 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoesL01").getChild("ShoesL02").getChild("ShoesL03");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.ArmLeft01b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft01b");
		this.ShoesR04 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoesR01").getChild("ShoesR02").getChild("ShoesR03").getChild("ShoesR04");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.LegLeft01a = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft01a");
		this.ShoesL04 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoesL01").getChild("ShoesL02").getChild("ShoesL03").getChild("ShoesL04");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.EquipSR03 = root.getChild("GlowBodyMain2").getChild("GlowArmRight01").getChild("GlowArmRight02").getChild("EquipSR01").getChild("EquipSR02").getChild("EquipSR03");
		this.EquipSL01 = root.getChild("GlowBodyMain2").getChild("GlowArmLeft01").getChild("GlowArmLeft02").getChild("EquipSL01");
		this.BodyMain = root.getChild("BodyMain");
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.HairR02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.ShoesL01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoesL01");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.EquipSR04 = root.getChild("GlowBodyMain2").getChild("GlowArmRight01").getChild("GlowArmRight02").getChild("EquipSR01").getChild("EquipSR04");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.Cloth02 = root.getChild("BodyMain").getChild("Cloth02");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.ShoesR01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoesR01");
		this.EquipSR01 = root.getChild("GlowBodyMain2").getChild("GlowArmRight01").getChild("GlowArmRight02").getChild("EquipSR01");
		this.Hair06 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair04").getChild("Hair05").getChild("Hair06");
		this.Hair03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02").getChild("Hair03");
		this.LegRight01a = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight01a");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.ShoesR02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoesR01").getChild("ShoesR02");
		this.EquipSL02 = root.getChild("GlowBodyMain2").getChild("GlowArmLeft01").getChild("GlowArmLeft02").getChild("EquipSL01").getChild("EquipSL02");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.EquipSR05 = root.getChild("GlowBodyMain2").getChild("GlowArmRight01").getChild("GlowArmRight02").getChild("EquipSR01").getChild("EquipSR04").getChild("EquipSR05");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.HairL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.EquipSL04 = root.getChild("GlowBodyMain2").getChild("GlowArmLeft01").getChild("GlowArmLeft02").getChild("EquipSL01").getChild("EquipSL04");
		this.Hair05 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair04").getChild("Hair05");
		this.ArmLeft01a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft01a");
		this.LegLeft01b = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft01b");
		this.ShoesR03 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoesR01").getChild("ShoesR02").getChild("ShoesR03");
		this.EquipSR02 = root.getChild("GlowBodyMain2").getChild("GlowArmRight01").getChild("GlowArmRight02").getChild("EquipSR01").getChild("EquipSR02");
		this.EquipSL05 = root.getChild("GlowBodyMain2").getChild("GlowArmLeft01").getChild("GlowArmLeft02").getChild("EquipSL01").getChild("EquipSL04").getChild("EquipSL05");
		this.EquipSL03 = root.getChild("GlowBodyMain2").getChild("GlowArmLeft01").getChild("GlowArmLeft02").getChild("EquipSL01").getChild("EquipSL02").getChild("EquipSL03");
		this.ShoesL02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoesL01").getChild("ShoesL02");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.Hair07 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair04").getChild("Hair05").getChild("Hair06").getChild("Hair07");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.Hair04 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair04");
		this.LegRight01b = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight01b");
		this.ArmRight01a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight01a");
		this.ArmRight01b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight01b");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowBodyMain2 = root.getChild("GlowBodyMain2");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.GlowArmLeft01 = root.getChild("GlowBodyMain2").getChild("GlowArmLeft01");
		this.GlowArmLeft02 = root.getChild("GlowBodyMain2").getChild("GlowArmLeft01").getChild("GlowArmLeft02");
		this.GlowArmRight01 = root.getChild("GlowBodyMain2").getChild("GlowArmRight01");
		this.GlowArmRight02 = root.getChild("GlowBodyMain2").getChild("GlowArmRight01").getChild("GlowArmRight02");
		this.scale = 0.47F;
		this.offsetY = 1.7F;
		this.offsetItem = new float[] {0.06F, 0.98F, -0.06F};
		this.offsetBlock = new float[] {0.06F, 0.98F, -0.06F};
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
    	float light = 80F + Mth.cos(f2 * 0.075F) * 80F;
		glowLight = false;
    	this.GlowBodyMain2.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
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
		boolean f1 = EmotionHelper.checkModelState(1, state);
		boolean f2 = EmotionHelper.checkModelState(2, state);
		
		if (f1 || f2)
		{
			this.GlowBodyMain2.visible = true;
			this.GlowArmLeft01.visible = !(!f1);
			this.GlowArmRight01.visible = !(!f2);
		}
		else
		{
			this.GlowBodyMain2.visible = false;
		}
	
	}

	public void syncRotationGlowPart()
	{

		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowBodyMain2.xRot = this.BodyMain.xRot;
		this.GlowBodyMain2.yRot = this.BodyMain.yRot;
		this.GlowBodyMain2.zRot = this.BodyMain.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
		this.GlowArmLeft01.xRot = this.ArmLeft01.xRot;
		this.GlowArmLeft01.yRot = this.ArmLeft01.yRot;
		this.GlowArmLeft01.zRot = this.ArmLeft01.zRot;
		this.GlowArmLeft02.xRot = this.ArmLeft02.xRot;
		this.GlowArmLeft02.yRot = this.ArmLeft02.yRot;
		this.GlowArmLeft02.zRot = this.ArmLeft02.zRot;
		this.GlowArmRight01.xRot = this.ArmRight01.xRot;
		this.GlowArmRight01.yRot = this.ArmRight01.yRot;
		this.GlowArmRight01.zRot = this.ArmRight01.zRot;
		this.GlowArmRight02.xRot = this.ArmRight02.xRot;
		this.GlowArmRight02.yRot = this.ArmRight02.yRot;
		this.GlowArmRight02.zRot = this.ArmRight02.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (0.49F); this.animTransZ += (0F);
  		this.setFaceHungry(ent);
  		
  	    //head
  		this.Head.xRot = 0.65F;
	  	this.Head.yRot = 0F;
	  	this.Head.zRot = 0F;
	  	//胸部
  	    this.BoobL.xRot = -0.75F;
  	    this.BoobR.xRot = -0.75F;
	  	//body
  	    this.Ahoke.yRot = 0.7F;
	  	this.BodyMain.xRot = -0.2F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = -0.14F;
	  	this.Skirt01.xRot = -0.1745F;
	  	this.Skirt01.y = (2.9F) + (0F) * 16F;
	  	this.Skirt02.xRot = -0.2618F;
	  	this.Skirt02.y = (2.8F) + (0F) * 16F;
	  	//hair
	  	this.Hair01.xRot = -0.1F;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -0.2F;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -0.14F;
	  	this.Hair03.zRot = 0F;
	  	this.Hair05.xRot = -0.4F;
	  	this.Hair05.zRot = 0F;
	  	this.Hair06.xRot = 0.14F;
	  	this.Hair06.zRot = 0F;
	  	this.Hair07.xRot = -0.2F;
	  	this.Hair07.zRot = 0F;
	  	this.HairL01.xRot = -0.14F;
	  	this.HairL01.zRot = 0F;
	  	this.HairL02.xRot = 0.17F;
	  	this.HairL02.zRot = 0F;
	  	this.HairR01.xRot = -0.14F;
	  	this.HairR01.zRot = 0F;
	  	this.HairR02.xRot = 0.17F;
	  	this.HairR02.zRot = 0F;
	  	//arm
	  	this.ArmLeft01.xRot = 0.2F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = -0.2618F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.y = (12.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    this.ArmRight01.xRot = 0.2F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = 0.2618F;
		this.ArmRight02.yRot = 0F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.y = (12.0F) + (0F) * 16F;
	    this.ArmRight02.z = (2.5F) + (0F) * 16F;
		//leg
		this.LegLeft01.xRot = -0.9F;
		this.LegLeft01.zRot = -0.14F;
		this.LegLeft02.xRot = 1.2217F;
		this.LegLeft02.yRot = 1.2217F;
		this.LegLeft02.zRot = -1.0472F;
		this.LegLeft02.x = (0.0F) + (0.22F) * 16F;
		this.LegLeft02.y = (14.0F) + (-0.03F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0.2F) * 16F;
		this.LegRight01.xRot = -0.9F;
		this.LegRight01.zRot = 0.14F;
		this.LegRight02.xRot = 1.2217F;
		this.LegRight02.yRot = -1.2217F;
		this.LegRight02.zRot = 1.0472F;
		this.LegRight02.x = (0.0F) + (-0.22F) * 16F;
		this.LegRight02.y = (14.0F) + (-0.03F) * 16F;
		this.LegRight02.z = (-3.0F) + (0.2F) * 16F;
		//equip
		this.GlowBodyMain2.visible = false;
	  	//鬢毛調整
	    this.Hair01.zRot = 0F;
	  	this.Hair02.zRot = 0F;
	  	this.HairL01.zRot = 0.087F;
	  	this.HairL02.zRot = 0.087F;
	  	this.HairR01.zRot = 0.087F;
	  	this.HairR02.zRot = -0.052F;
		this.HairL01.xRot = -0.65F;
	  	this.HairL02.xRot = 0.17F;
	  	this.HairR01.xRot = -0.65F;
	  	this.HairR02.xRot = 0.17F;
	
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
  		addk1 = angleAdd1 * 0.5F - 0.35F;
	  	addk2 = angleAdd2 * 0.5F - 0.1745F;
    	
  	    //head
	  	this.Head.xRot = f4 * 0.014F;
	  	this.Head.yRot = f3 * 0.01F;
	  	//胸部
  	    this.BoobL.xRot = angleX * 0.06F - 0.75F;
  	    this.BoobR.xRot = angleX * 0.06F - 0.75F;
	  	//body
  	    this.Ahoke.yRot = angleX * 0.2F + 0.7F;
	  	this.BodyMain.xRot = -0.1047F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.35F;
	  	this.Skirt01.xRot = -0.14F;
	  	this.Skirt01.y = (2.9F) + (0F) * 16F;
	  	this.Skirt02.xRot = -0.087F;
	  	this.Skirt02.y = (2.8F) + (0F) * 16F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.03F + 0.21F;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -angleX1 * 0.04F - 0.087F;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -angleX2 * 0.07F - 0.14F;
	  	this.Hair03.zRot = 0F;
	  	this.Hair05.xRot = angleX * 0.06F + 0.1F;
	  	this.Hair05.zRot = 0F;
	  	this.Hair06.xRot = -angleX1 * 0.08F + 0.14F;
	  	this.Hair06.zRot = 0F;
	  	this.Hair07.xRot = -angleX2 * 0.1F - 0.2F;
	  	this.Hair07.zRot = 0F;
	  	this.HairL01.xRot = angleX * 0.04F - 0.14F;
	  	this.HairL01.zRot = 0F;
	  	this.HairL02.xRot = -angleX1 * 0.06F + 0.17F;
	  	this.HairL02.zRot = 0F;
	  	this.HairR01.xRot = angleX * 0.04F - 0.14F;
	  	this.HairR01.zRot = 0F;
	  	this.HairR02.xRot = -angleX1 * 0.06F + 0.17F;
	  	this.HairR02.zRot = 0F;
	  	//arm
	  	this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.35F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = angleX * 0.03F - 0.26F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.y = (12.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    this.ArmRight01.xRot = angleAdd1 * 0.25F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -angleX * 0.03F + 0.26F;
		this.ArmRight02.yRot = 0F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.y = (12.0F) + (0F) * 16F;
	    this.ArmRight02.z = (2.5F) + (0F) * 16F;
		//leg
		this.LegLeft01.zRot = 0.1F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (0.0F) + (0F) * 16F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.zRot = -0.1F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.x = (0.0F) + (0F) * 16F;
		this.LegRight02.y = (14.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		//equip
		this.EquipSL01.xRot = -1.57F;
		this.EquipSL01.yRot = 0F;
		this.EquipSL01.zRot = 1.57F;
		this.EquipSL01.x = (-3.0F) + (0F) * 16F;
		this.EquipSL01.y = (10.5F) + (0F) * 16F;
		this.EquipSL01.z = (-6.0F) + (0F) * 16F;
		this.EquipSR01.xRot = -1.57F;
		this.EquipSR01.yRot = 0F;
		this.EquipSR01.zRot = 1.57F;
		this.EquipSR01.x = (3.0F) + (0F) * 16F;
		this.EquipSR01.y = (10.5F) + (0F) * 16F;
		this.EquipSR01.z = (-6.0F) + (0F) * 16F;
		
	  	//奔跑動作
	    if(ent.getIsSprinting() || f1 > 0.95F)
	    {
this.animTransX += (0F); this.animTransY += (0.05F); this.animTransZ += (0F);
	    	//body
	 	    this.Head.xRot -= 0.4F;
	 	    this.BodyMain.xRot = 0.7F;
	 	    this.Butt.xRot -= 0.7F;
	 	    this.Skirt01.xRot = -0.15F;
	 	  	this.Skirt02.xRot = -0.32F;
	 	  	//hair
	 	  	this.Hair01.xRot += 0.3F;
	 	  	//arm
	    	this.ArmLeft01.xRot = 0.4F;
	    	this.ArmLeft01.yRot = -0.5F;
	    	this.ArmLeft01.zRot = -0.7F;
		    this.ArmRight01.xRot = 0.4F;
	    	this.ArmRight01.yRot = 0.5F;
	    	this.ArmRight01.zRot = 0.7F;
  		}
	    
	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    //潛行, 蹲下動作
	    if(ent.getIsSneaking())
	    {
this.animTransX += (0F); this.animTransY += (0.05F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 1.0472F;
		  	this.BodyMain.xRot = 1.0472F;
		  	this.Butt.xRot = -0.4F;
		  	this.Skirt01.xRot = -0.12F;
		  	this.Skirt02.xRot = -0.16F;
		  	this.Skirt02.y = (2.8F) + (-0.1F) * 16F;
		  	//hair
		  	this.Hair02.xRot -= 0.3F;
		  	this.Hair03.xRot -= 0.3F;
		    //arm
		  	int state = ent.getStateEmotion(ID.S.State);
			boolean fs1 = EmotionHelper.checkModelState(1, state);
			boolean fs2 = EmotionHelper.checkModelState(2, state);

		  	if (fs1 || fs2)
		  	{
		  		this.ArmLeft01.xRot = angleAdd2 * 0.25F - 0.1F;
		    	this.ArmLeft01.yRot = -0.7F;
		    	this.ArmLeft01.zRot = -0.3F;
			    this.ArmRight01.xRot = angleAdd1 * 0.25F - 0.1F;
		    	this.ArmRight01.yRot = 0.7F;
		    	this.ArmRight01.zRot = 0.3F;
		  	}
		  	else
		  	{
		  		this.ArmLeft01.xRot = -0.6F;
			    this.ArmLeft01.zRot = 0.2618F;
			    this.ArmRight01.xRot = -0.6F;
			    this.ArmRight01.zRot = -0.2618F;
		  	}
		    //leg
		    addk1 -= 0.4F;
		    addk2 -= 0.4F;
  		}//end if sneaking
	    
	    //騎乘動作
    	if (((Entity)ent).getVehicle() instanceof BasicEntityMount)
    	{
    		if (ent.getIsSitting())
			{
    			if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		    	{
this.animTransX += (0F); this.animTransY += (0.65F); this.animTransZ += (-0.27F);
			    	//Body
			    	this.Head.xRot = -1.2217F;
			    	this.Head.yRot = 0F;
			    	this.Head.zRot = 0F;
				  	this.BodyMain.xRot = 1.2217F;
				  	//hair
				  	this.Hair02.xRot += 0.2F;
				  	this.Hair03.xRot += 0.2F;
				  	this.Hair05.xRot -= 0.6F;
				  	this.Hair06.xRot -= 0.5F;
				    //arm 
				  	this.ArmLeft01.xRot = -2F;
				  	this.ArmLeft01.yRot = -0.1F;
				  	this.ArmLeft01.zRot = -0.1F;
				    this.ArmLeft02.xRot = -2.5F;
				    this.ArmLeft02.y = (12.0F) + (0.1F) * 16F;
				    this.ArmLeft02.z = (2.5F) + (-0.3F) * 16F;
					this.ArmRight01.xRot = -2F;
					this.ArmRight01.yRot = 0.1F;
					this.ArmRight01.zRot = 0.1F;
					this.ArmRight02.xRot = -2.5F;
					this.ArmRight02.y = (12.0F) + (0.1F) * 16F;
				    this.ArmRight02.z = (2.5F) + (-0.3F) * 16F;
					//leg
					addk1 = 0F;
					addk2 = 0F;
					this.LegLeft02.xRot = angleX * 0.4F + 0.8F;
					this.LegRight02.xRot = -angleX * 0.4F + 0.8F;
					//equip
					this.GlowBodyMain2.visible = false;
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.51F); this.animTransZ += (0F);
			    	//head
			    	this.Head.yRot -= 0.4F;
			    	this.Head.zRot += 0.2F;
			    	//body
			    	this.BodyMain.xRot = -0.25F;
			    	this.Butt.xRot = -0.2F;
					this.Skirt01.xRot = -0.13F;
					this.Skirt01.y = (2.9F) + (-0.05F) * 16F;
					this.Skirt02.xRot = -0.13F;
					this.Skirt02.y = (2.8F) + (-0.05F) * 16F;
					//arm
					this.ArmLeft01.xRot = 0.35F;
					this.ArmLeft01.zRot = -0.2618F;
					this.ArmRight01.xRot = -0.4F;
					this.ArmRight01.zRot = 0.4F;
					//leg
					addk1 = -0.9F;
					addk2 = -0.9F;
					this.LegLeft01.zRot = -0.14F;
					this.LegLeft02.xRot = 1.2217F;
					this.LegLeft02.yRot = 1.2217F;
					this.LegLeft02.zRot = -1.0472F;
					this.LegLeft02.x = (0.0F) + (0.22F) * 16F;
					this.LegLeft02.y = (14.0F) + (-0.03F) * 16F;
					this.LegLeft02.z = (-3.0F) + (0.2F) * 16F;
					this.LegRight01.zRot = 0.14F;
					this.LegRight02.xRot = 1.2217F;
					this.LegRight02.yRot = -1.2217F;
					this.LegRight02.zRot = 1.0472F;
					this.LegRight02.x = (0.0F) + (-0.22F) * 16F;
					this.LegRight02.y = (14.0F) + (-0.03F) * 16F;
					this.LegRight02.z = (-3.0F) + (0.2F) * 16F;
					//equip
					this.EquipSL01.xRot -= 0.06F;
					this.EquipSL01.zRot -= 1.2F;
					this.EquipSR01.xRot -= 1.2F;
		    	}
			}
    		else
    		{
this.animTransX += (0F); this.animTransY += (0.56F); this.animTransZ += (0F);
		    	//body
		    	this.BodyMain.xRot = -0.45F;
		    	this.Butt.xRot = -0.2F;
				this.Skirt01.xRot = -0.13F;
				this.Skirt01.y = (2.9F) + (-0.05F) * 16F;
				this.Skirt02.xRot = -0.13F;
				this.Skirt02.y = (2.8F) + (-0.05F) * 16F;
				//arm
				this.ArmLeft01.xRot = 0.2F;
				this.ArmLeft01.zRot = -1.1F;
				this.ArmRight01.xRot = 0.2F;
				this.ArmRight01.zRot = 1.1F;
				//leg
				addk1 = -0.8F;
				addk2 = -1.2F;
				this.LegLeft01.zRot = -0.14F;
				this.LegLeft02.xRot = 1.2217F;
				this.LegLeft02.yRot = 1.2217F;
				this.LegLeft02.zRot = -1.0472F;
				this.LegLeft02.x = (0.0F) + (0.22F) * 16F;
				this.LegLeft02.y = (14.0F) + (-0.03F) * 16F;
				this.LegLeft02.z = (-3.0F) + (0.2F) * 16F;
				this.LegRight01.zRot = 0.14F;
				this.LegRight02.xRot = 0.9F;
				//equip
				this.EquipSL01.xRot = -1.2F;
				this.EquipSL01.yRot = 0.1F;
				this.EquipSL01.zRot = 1F;
				this.EquipSL01.x = (-3.0F) + (0.24F) * 16F;
				this.EquipSL01.y = (10.5F) + (-0.5F) * 16F;
				this.EquipSL01.z = (-6.0F) + (1F) * 16F;
				this.EquipSR01.xRot = -1.2F;
				this.EquipSR01.yRot = -0.1F;
				this.EquipSR01.zRot = -1F;
				this.EquipSR01.x = (3.0F) + (-0.24F) * 16F;
				this.EquipSR01.y = (10.5F) + (-0.5F) * 16F;
				this.EquipSR01.z = (-6.0F) + (1F) * 16F;
    		}
    	}
    	else if (ent.getIsSitting() || ent.getIsRiding())
    	{
    		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
this.animTransX += (0F); this.animTransY += (0.65F); this.animTransZ += (0F);
		    	//Body
		    	this.Head.xRot = -1.2217F;
		    	this.Head.yRot = 0F;
		    	this.Head.zRot = 0F;
			  	this.BodyMain.xRot = 1.2217F;
			  	//hair
			  	this.Hair02.xRot += 0.2F;
			  	this.Hair03.xRot += 0.2F;
			  	this.Hair05.xRot -= 0.6F;
			  	this.Hair06.xRot -= 0.5F;
			    //arm 
			  	this.ArmLeft01.xRot = -2F;
			  	this.ArmLeft01.yRot = -0.1F;
			  	this.ArmLeft01.zRot = -0.1F;
			    this.ArmLeft02.xRot = -2.5F;
			    this.ArmLeft02.y = (12.0F) + (0.1F) * 16F;
			    this.ArmLeft02.z = (2.5F) + (-0.3F) * 16F;
				this.ArmRight01.xRot = -2F;
				this.ArmRight01.yRot = 0.1F;
				this.ArmRight01.zRot = 0.1F;
				this.ArmRight02.xRot = -2.5F;
				this.ArmRight02.y = (12.0F) + (0.1F) * 16F;
			    this.ArmRight02.z = (2.5F) + (-0.3F) * 16F;
				//leg
				addk1 = 0F;
				addk2 = 0F;
				this.LegLeft02.xRot = angleX * 0.4F + 0.8F;
				this.LegRight02.xRot = -angleX * 0.4F + 0.8F;
				//equip
				this.GlowBodyMain2.visible = false;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.51F); this.animTransZ += (0F);
		    	//head
		    	this.Head.yRot -= 0.4F;
		    	this.Head.zRot += 0.2F;
		    	//body
		    	this.BodyMain.xRot = -0.25F;
		    	this.Butt.xRot = -0.2F;
				this.Skirt01.xRot = -0.13F;
				this.Skirt01.y = (2.9F) + (-0.05F) * 16F;
				this.Skirt02.xRot = -0.13F;
				this.Skirt02.y = (2.8F) + (-0.05F) * 16F;
				//arm
				this.ArmLeft01.xRot = 0.35F;
				this.ArmLeft01.zRot = -0.2618F;
				this.ArmRight01.xRot = -0.4F;
				this.ArmRight01.zRot = 0.4F;
				//leg
				addk1 = -0.9F;
				addk2 = -0.9F;
				this.LegLeft01.zRot = -0.14F;
				this.LegLeft02.xRot = 1.2217F;
				this.LegLeft02.yRot = 1.2217F;
				this.LegLeft02.zRot = -1.0472F;
				this.LegLeft02.x = (0.0F) + (0.22F) * 16F;
				this.LegLeft02.y = (14.0F) + (-0.03F) * 16F;
				this.LegLeft02.z = (-3.0F) + (0.2F) * 16F;
				this.LegRight01.zRot = 0.14F;
				this.LegRight02.xRot = 1.2217F;
				this.LegRight02.yRot = -1.2217F;
				this.LegRight02.zRot = 1.0472F;
				this.LegRight02.x = (0.0F) + (-0.22F) * 16F;
				this.LegRight02.y = (14.0F) + (-0.03F) * 16F;
				this.LegRight02.z = (-3.0F) + (0.2F) * 16F;
				//equip
				this.EquipSL01.xRot -= 0.06F;
				this.EquipSL01.zRot -= 1.2F;
				this.EquipSR01.xRot -= 1.2F;
	    	}
    	}
	    
	    if (!(((Entity)ent).getVehicle() instanceof BasicEntityMount))
    	{
	    	//攻擊動作
		    int atktime = ent.getAttackTick();
		    if (atktime > 41)
		    {
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
		  	float f6 = ent.getSwingTime(f2 - (int)f2);
		  	if (f6 != 0F)
		  	{
		  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
		        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
		        this.ArmRight01.xRot += -f8 * 95.0F * Values.N.DIV_PI_180;
		        this.ArmRight01.yRot += -f7 * 20.0F * Values.N.DIV_PI_180 + 0.2F;
		        this.ArmRight01.zRot += -f8 * 20.0F * Values.N.DIV_PI_180;
		  	}
    	}
	  	
	  	//鬢毛調整
	    headX = this.Head.xRot * -0.5F;
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.xRot += headX;
	    this.Hair01.zRot += headZ;
	    this.Hair02.xRot += headX * 0.5F;
	    this.Hair02.zRot += headZ * 0.5F;
	    this.Hair03.xRot += headX * 0.5F;
	    this.Hair03.zRot += headZ * 0.5F;
	    this.Hair05.xRot += headX;
	    this.Hair05.zRot += headZ;
	    this.Hair06.xRot += headX;
	    this.Hair06.zRot += headZ;
	  	this.HairL01.zRot += headZ;
	  	this.HairL02.zRot += headZ;
	  	this.HairR01.zRot += headZ;
	  	this.HairR02.zRot += headZ;
		this.HairL01.xRot += headX;
	  	this.HairL02.xRot += headX;
	  	this.HairR01.xRot += headX;
	  	this.HairR02.xRot += headX;
	    
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

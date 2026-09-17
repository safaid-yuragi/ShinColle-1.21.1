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

public class ModelMidwayHime<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart Butt;
	public ModelPart ArmRight01;
	public ModelPart ArmLeft01;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart EquipSR01;
	public ModelPart EquipSR01b;
	public ModelPart EquipSR01c;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart HeadHL;
	public ModelPart HeadHR;
	public ModelPart HairU01;
	public ModelPart Ahoke;
	public ModelPart HairR01;
	public ModelPart HairL01;
	public ModelPart HairR02;
	public ModelPart HairL02;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart Hair03;
	public ModelPart HeadHL2;
	public ModelPart HeadHL3;
	public ModelPart HeadHR2;
	public ModelPart HeadHR3;
	public ModelPart LegLeft01;
	public ModelPart Skirt01;
	public ModelPart LegRight01;
	public ModelPart LegLeft02;
	public ModelPart Skirt02;
	public ModelPart Skirt03;
	public ModelPart LegRight02;
	public ModelPart ArmRight02;
	public ModelPart ArmRight02a;
	public ModelPart ArmRight02b;
	public ModelPart ArmLeft02;
	public ModelPart ArmLeft02a;
	public ModelPart ArmLeft02b;
	public ModelPart Collar02;
	public ModelPart Collar03a1;
	public ModelPart Collar03a2;
	public ModelPart Collar03a3;
	public ModelPart Collar03a3_1;
	public ModelPart Collar03a4;
	public ModelPart Collar03a5;
	public ModelPart Collar03a6;
	public ModelPart Collar03a7;
	public ModelPart Collar03a8;
	public ModelPart Collar03a9;
	public ModelPart Collar03a10;
	public ModelPart Collar03a11;
	public ModelPart Collar03a12;
	public ModelPart Collar03a13;
	public ModelPart Collar03a14;
	public ModelPart Collar03a15;
	public ModelPart Collar03b1;
	public ModelPart Collar03b2;
	public ModelPart Collar03b3;
	public ModelPart Collar03b3_1;
	public ModelPart Collar03b4;
	public ModelPart Collar03b5;
	public ModelPart Collar03b6;
	public ModelPart Collar03b7;
	public ModelPart Collar03b8;
	public ModelPart Collar03b9;
	public ModelPart Collar03b10;
	public ModelPart Collar03b11;
	public ModelPart Collar03b12;
	public ModelPart Collar03b13;
	public ModelPart Collar03b14;
	public ModelPart Collar03b15;
	public ModelPart EquipSR02;
	public ModelPart EquipSR03;
	public ModelPart EquipSR04;
	public ModelPart EquipSR05;
	public ModelPart EquipSR02b;
	public ModelPart EquipSR03b;
	public ModelPart EquipSR04b;
	public ModelPart EquipSR02c;
	public ModelPart EquipSR03c;
	public ModelPart EquipSR04c;
	public ModelPart EquipSR05c;
	public ModelPart Collar01;
	public ModelPart GlowBodyMain;
	public ModelPart GlowBodyMain2;
	public ModelPart GlowBodyMain2a;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ArrayList<MiscModel> miscModelList;
	public boolean renderTako;
	public MiscModel tako1;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().mirror().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, -0.08726646259971647F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("ArmRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(-3.0F, 11.0F, 2.5F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("ArmRight02a", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(2.5F, 3.0F, -2.5F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("ArmRight02b", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offset(0.0F, 1.9F, 0.2F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(3.4F, -8.5F, -3.7F, -0.8726646259971648F, -0.08726646259971647F, -0.06981317007977318F));
		PartDefinition partdef6 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.3490658503988659F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(3.0F, 11.0F, 2.5F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("ArmLeft02a", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(-2.5F, 3.0F, -2.5F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("ArmLeft02b", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offset(0.0F, 1.9F, 0.2F));
		PartDefinition partdef10 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(-3.5F, -8.5F, -3.8F, -0.8726646259971648F, 0.08726646259971647F, 0.06981317007977318F));
		PartDefinition partdef11 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-2.5F, -3.0F, -2.9F, 5.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -0.8F, -0.7F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.1F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(7.0F, 3.0F, -5.5F, -0.19198621771937624F, -0.17453292519943295F, -0.08726646259971647F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef16 = partdef13.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -6.0F, -10.5F, 0.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(-0.5F, -7.0F, -6.0F, 0.20943951023931953F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef17 = partdef13.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -7.0F));
		PartDefinition partdef18 = partdef13.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(-7.0F, 3.0F, -5.5F, -0.19198621771937624F, 0.17453292519943295F, 0.08726646259971647F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(0.2F, 10.0F, 0.0F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef20 = partdef12.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 17.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("Hair03", CubeListBuilder.create().addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 12.5F, -0.1F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("LegRight01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.08726646259971647F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("LegRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(-3.0F, 14.0F, -3.0F));
		PartDefinition partdef27 = partdef24.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -8.5F, 17.0F, 6.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 1.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-10.5F, 0.0F, -6.5F, 21.0F, 6.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 4.5F, -2.7F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("Skirt03", CubeListBuilder.create().addBox(-13.0F, 0.0F, -7.5F, 26.0F, 6.0F, 15.0F), PartPose.offsetAndRotation(0.0F, 4.5F, 0.3F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdef24.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("LegLeft02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(3.0F, 14.0F, -3.0F));
		PartDefinition partdef32 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("Collar01", CubeListBuilder.create().addBox(-6.0F, -2.0F, -4.0F, 12.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 1.9F, -1.2F, 0.035F, 0.0F, 0.0F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("Collar02", CubeListBuilder.create().addBox(-7.0F, -1.5F, -5.7F, 14.0F, 3.0F, 11.0F), PartPose.offset(0.0F, -2.5F, -1.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("Collar03a2", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-1.3F, 0.6F, -3.5F, -1.8325957145940461F, 0.12217304763960307F, -0.03490658503988659F));
		PartDefinition partdef37 = partdef36.addOrReplaceChild("Collar03b2", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef38 = partdef35.addOrReplaceChild("Collar03a8", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(3.5F, 0.2F, 3.4F, -1.7453292519943295F, -2.6179938779914944F, 0.05235987755982988F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("Collar03b8", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.767944870877505F, 0.0F, 0.0F));
		PartDefinition partdef40 = partdef35.addOrReplaceChild("Collar03a7", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(5.4F, 0.1F, 2.7F, -1.7453292519943295F, -2.2689280275926285F, 0.0F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("Collar03b7", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8377580409572781F, 0.0F, 0.0F));
		PartDefinition partdef42 = partdef35.addOrReplaceChild("Collar03a15", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-5.0F, 0.2F, -2.1F, -1.6580627893946132F, 0.8028514559173915F, 0.08726646259971647F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("Collar03b15", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8377580409572781F, 0.0F, 0.0F));
		PartDefinition partdef44 = partdef35.addOrReplaceChild("Collar03a9", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(1.4F, 0.4F, 2.6F, -1.7453292519943295F, -3.036872898470133F, 0.05235987755982988F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("Collar03b9", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef46 = partdef35.addOrReplaceChild("Collar03a10", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(-1.4F, 0.4F, 2.6F, -1.7453292519943295F, 3.036872898470133F, -0.05235987755982988F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("Collar03b10", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef48 = partdef35.addOrReplaceChild("Collar03a12", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-5.4F, 0.1F, 2.7F, -1.7453292519943295F, 2.2689280275926285F, 0.0F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("Collar03b12", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8377580409572781F, 0.0F, 0.0F));
		PartDefinition partdef50 = partdef35.addOrReplaceChild("Collar03a11", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(-3.5F, 0.2F, 3.4F, -1.7453292519943295F, 2.6179938779914944F, -0.05235987755982988F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("Collar03b11", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.767944870877505F, 0.0F, 0.0F));
		PartDefinition partdef52 = partdef35.addOrReplaceChild("Collar03a13", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(-4.6F, 0.1F, 1.7F, -1.7453292519943295F, 1.605702911834783F, 0.0F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("Collar03b13", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.9948376736367678F, 0.0F, 0.0F));
		PartDefinition partdef54 = partdef35.addOrReplaceChild("Collar03a1", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(1.3F, 0.6F, -3.5F, -1.8325957145940461F, -0.12217304763960307F, 0.03490658503988659F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("Collar03b1", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef56 = partdef35.addOrReplaceChild("Collar03a4", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(5.0F, 0.2F, -2.1F, -1.6580627893946132F, -0.8028514559173915F, -0.08726646259971647F));
		PartDefinition partdef57 = partdef56.addOrReplaceChild("Collar03b4", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8377580409572781F, 0.0F, 0.0F));
		PartDefinition partdef58 = partdef35.addOrReplaceChild("Collar03a3", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(4.3F, 0.5F, -3.5F, -2.007128639793479F, -0.20943951023931953F, 0.06981317007977318F));
		PartDefinition partdef59 = partdef58.addOrReplaceChild("Collar03b3", CubeListBuilder.create().addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.9599310885968813F, 0.0F, 0.0F));
		PartDefinition partdef60 = partdef35.addOrReplaceChild("Collar03a14", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-4.6F, 0.1F, -1.3F, -1.7453292519943295F, 1.4311699866353502F, 0.0F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("Collar03b14", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8377580409572781F, 0.0F, 0.0F));
		PartDefinition partdef62 = partdef35.addOrReplaceChild("Collar03a3_1", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(-4.3F, 0.5F, -3.5F, -2.007128639793479F, 0.20943951023931953F, -0.06981317007977318F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("Collar03b3_1", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.9599310885968813F, 0.0F, 0.0F));
		PartDefinition partdef64 = partdef35.addOrReplaceChild("Collar03a6", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(4.6F, 0.1F, 1.7F, -1.7453292519943295F, -1.605702911834783F, 0.0F));
		PartDefinition partdef65 = partdef64.addOrReplaceChild("Collar03b6", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 1.5F, -0.9948376736367678F, 0.0F, 0.0F));
		PartDefinition partdef66 = partdef35.addOrReplaceChild("Collar03a5", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(4.6F, 0.1F, -1.3F, -1.7453292519943295F, -1.4311699866353502F, 0.0F));
		PartDefinition partdef67 = partdef66.addOrReplaceChild("Collar03b5", CubeListBuilder.create().mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.5F, -0.8377580409572781F, 0.0F, 0.0F));
		PartDefinition partdef68 = partdef33.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -0.8F, -0.7F));
		PartDefinition partdef69 = partdef68.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef70 = partdef68.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef71 = partdef68.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef72 = partdef68.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef73 = partdef68.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef74 = partdef68.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef75 = partdef68.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));
		PartDefinition partdef76 = partdef68.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef77 = partdef68.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef78 = partdef68.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef79 = partdef68.addOrReplaceChild("HeadHL", CubeListBuilder.create().mirror().addBox(0.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(6.4F, -10.6F, 0.8F, -0.7853981633974483F, -0.17453292519943295F, -0.3839724354387525F));
		PartDefinition partdef80 = partdef79.addOrReplaceChild("HeadHL2", CubeListBuilder.create().addBox(0.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F), PartPose.offset(3.0F, 0.0F, 0.0F));
		PartDefinition partdef81 = partdef80.addOrReplaceChild("HeadHL3", CubeListBuilder.create().addBox(0.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F), PartPose.offset(1.0F, 0.0F, 0.0F));
		PartDefinition partdef82 = partdef68.addOrReplaceChild("HeadHR", CubeListBuilder.create().addBox(-3.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-6.4F, -10.6F, 0.8F, -0.7853981633974483F, 0.17453292519943295F, 0.3839724354387525F));
		PartDefinition partdef83 = partdef82.addOrReplaceChild("HeadHR2", CubeListBuilder.create().addBox(-1.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F), PartPose.offset(-3.0F, 0.0F, 0.0F));
		PartDefinition partdef84 = partdef83.addOrReplaceChild("HeadHR3", CubeListBuilder.create().addBox(-1.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F), PartPose.offset(-1.0F, 0.0F, 0.0F));
		PartDefinition partdef85 = partdefinition.addOrReplaceChild("GlowBodyMain2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef86 = partdef85.addOrReplaceChild("GlowBodyMain2a", CubeListBuilder.create(), PartPose.offset(10F, -14F, -39F));
		PartDefinition partdef87 = partdef86.addOrReplaceChild("EquipSR01", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offsetAndRotation(40.0F, -11.0F, 13.0F, 0.0F, 0.5235987755982988F, 1.5707963267948966F));
		PartDefinition partdef88 = partdef87.addOrReplaceChild("EquipSR02", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition partdef89 = partdef88.addOrReplaceChild("EquipSR03", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition partdef90 = partdef89.addOrReplaceChild("EquipSR04", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition partdef91 = partdef90.addOrReplaceChild("EquipSR05", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition partdef92 = partdef86.addOrReplaceChild("EquipSR01b", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offsetAndRotation(-33.0F, -9.0F, 13.7F, -0.5918411493512771F, -0.3665191429188092F, -0.5918411493512771F));
		PartDefinition partdef93 = partdef92.addOrReplaceChild("EquipSR02b", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition partdef94 = partdef93.addOrReplaceChild("EquipSR03b", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition partdef95 = partdef94.addOrReplaceChild("EquipSR04b", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition partdef96 = partdef86.addOrReplaceChild("EquipSR01c", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offsetAndRotation(-12.0F, 30.0F, -19.0F, 0.5585053606381855F, -0.3490658503988659F, -2.530727415391778F));
		PartDefinition partdef97 = partdef96.addOrReplaceChild("EquipSR02c", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition partdef98 = partdef97.addOrReplaceChild("EquipSR03c", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition partdef99 = partdef98.addOrReplaceChild("EquipSR04c", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition partdef100 = partdef99.addOrReplaceChild("EquipSR05c", CubeListBuilder.create().addBox(-4.5F, 0.0F, -0.5F, 9.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 16.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelMidwayHime(ModelPart root)
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
		this.BodyMain = root.getChild("BodyMain");
		this.Collar03b7 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a7").getChild("Collar03b7");
		this.Collar03b2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a2").getChild("Collar03b2");
		this.EquipSR04c = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a").getChild("EquipSR01c").getChild("EquipSR02c").getChild("EquipSR03c").getChild("EquipSR04c");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.EquipSR01c = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a").getChild("EquipSR01c");
		this.HeadHL = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHL");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.Collar03b15 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a15").getChild("Collar03b15");
		this.EquipSR03 = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a").getChild("EquipSR01").getChild("EquipSR02").getChild("EquipSR03");
		this.EquipSR01 = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a").getChild("EquipSR01");
		this.Collar03a3_1 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a3_1");
		this.Collar03a6 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a6");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.ArmRight02a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight02a");
		this.Collar03a5 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a5");
		this.ArmRight02b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight02a").getChild("ArmRight02b");
		this.EquipSR02c = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a").getChild("EquipSR01c").getChild("EquipSR02c");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.Collar03b4 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a4").getChild("Collar03b4");
		this.EquipSR04 = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a").getChild("EquipSR01").getChild("EquipSR02").getChild("EquipSR03").getChild("EquipSR04");
		this.ArmLeft02a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft02a");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.Collar03a2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a2");
		this.Collar03a8 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a8");
		this.Collar01 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01");
		this.Collar03a7 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a7");
		this.Collar03a15 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a15");
		this.Collar03b11 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a11").getChild("Collar03b11");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.Collar03b10 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a10").getChild("Collar03b10");
		this.EquipSR04b = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a").getChild("EquipSR01b").getChild("EquipSR02b").getChild("EquipSR03b").getChild("EquipSR04b");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.Collar03b5 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a5").getChild("Collar03b5");
		this.Collar02 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02");
		this.Hair03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02").getChild("Hair03");
		this.ArmLeft02b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft02a").getChild("ArmLeft02b");
		this.Collar03b1 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a1").getChild("Collar03b1");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.Collar03b3_1 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a3_1").getChild("Collar03b3_1");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.Collar03a9 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a9");
		this.Collar03a10 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a10");
		this.EquipSR03b = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a").getChild("EquipSR01b").getChild("EquipSR02b").getChild("EquipSR03b");
		this.HeadHL2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHL").getChild("HeadHL2");
		this.Collar03a12 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a12");
		this.Collar03b14 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a14").getChild("Collar03b14");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.Collar03b13 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a13").getChild("Collar03b13");
		this.Collar03b8 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a8").getChild("Collar03b8");
		this.Collar03b9 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a9").getChild("Collar03b9");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.EquipSR02b = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a").getChild("EquipSR01b").getChild("EquipSR02b");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.EquipSR01b = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a").getChild("EquipSR01b");
		this.Collar03a11 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a11");
		this.Collar03a13 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a13");
		this.Collar03b12 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a12").getChild("Collar03b12");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.Collar03a1 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a1");
		this.Collar03a4 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a4");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.EquipSR03c = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a").getChild("EquipSR01c").getChild("EquipSR02c").getChild("EquipSR03c");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.Collar03a3 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a3");
		this.Collar03a14 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a14");
		this.EquipSR02 = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a").getChild("EquipSR01").getChild("EquipSR02");
		this.HairU01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairU01");
		this.HairL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.HeadHR2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHR").getChild("HeadHR2");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.EquipSR05 = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a").getChild("EquipSR01").getChild("EquipSR02").getChild("EquipSR03").getChild("EquipSR04").getChild("EquipSR05");
		this.HeadHR3 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHR").getChild("HeadHR2").getChild("HeadHR3");
		this.HeadHL3 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHL").getChild("HeadHL2").getChild("HeadHL3");
		this.EquipSR05c = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a").getChild("EquipSR01c").getChild("EquipSR02c").getChild("EquipSR03c").getChild("EquipSR04c").getChild("EquipSR05c");
		this.Collar03b6 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a6").getChild("Collar03b6");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.HeadHR = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHR");
		this.HairR02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.Collar03b3 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("Collar01").getChild("Collar02").getChild("Collar03a3").getChild("Collar03b3");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.Skirt03 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02").getChild("Skirt03");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowBodyMain2 = root.getChild("GlowBodyMain2");
		this.GlowBodyMain2a = root.getChild("GlowBodyMain2").getChild("GlowBodyMain2a");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.scale = 0.48F;
		this.offsetY = 1.62F;
		this.offsetItem = new float[] {0.08F, 1.02F, -0.07F};
		this.offsetBlock = new float[] {0.08F, 1.02F, -0.07F};
		this.renderTako = false;
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
		
		this.EquipSR01.visible = false;
		this.EquipSR01b.visible = false;
		this.EquipSR01c.visible = false;
		
		boolean flag = !EmotionHelper.checkModelState(1, state);
		this.Collar01.visible = !(flag);
		
		this.renderTako = false;
	
	}

	public void syncRotationGlowPart()
	{

		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowBodyMain2.xRot = this.BodyMain.xRot;
		this.GlowBodyMain2.yRot = this.BodyMain.yRot;
		this.GlowBodyMain2.zRot = this.BodyMain.zRot;
		this.GlowNeck.xRot = this.Neck.xRot;
		this.GlowNeck.yRot = this.Neck.yRot;
		this.GlowNeck.zRot = this.Neck.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (0.59F); this.animTransZ += (0F);
  		this.setFaceHungry(ent);
    	
		//頭部
	  	this.Head.xRot = -0.2618F;
	  	this.Head.yRot = 0F;
	  	this.Head.zRot = 0F;
	  	//Body
  	    this.Ahoke.yRot = -1.0F;
	  	this.BodyMain.xRot = 1.2217F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 1.2217F;
	  	this.Butt.xRot = -0.05F;
	  	this.Skirt01.xRot = -0.34F;
	  	this.Skirt01.y = (3.0F) + (0F) * 16F;
	  	this.Skirt01.z = (1.5F) + (0F) * 16F;
	  	this.Skirt02.xRot = -0.27F;
	  	this.Skirt02.y = (4.5F) + (0F) * 16F;
	  	this.Skirt03.xRot = -0.22F;
	  	this.Skirt03.y = (4.5F) + (0F) * 16F;
	  	this.Collar01.xRot = 0.035F;
	  	//hair
	  	this.Hair01.xRot = 0.2F;
	  	this.Hair01.zRot = -0.2F;
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
	    //胸部
  	    this.BoobL.xRot = -1.0F;
  	    this.BoobL.zRot = -0.12F;
  	    this.BoobR.xRot = -0.7F;
  	    this.BoobR.zRot = -0.12F;
	    //arm 
	  	this.ArmLeft01.xRot = -0.35F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = -3F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.y = (11.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
    	this.ArmRight01.xRot = -0.5F;
	    this.ArmRight01.yRot = 0.3F;
		this.ArmRight01.zRot = -0.5F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.zRot = -0.8727F;
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
		this.ArmRight02.y = (11.0F) + (0F) * 16F;
		this.ArmRight02.z = (2.5F) + (0F) * 16F;
		//leg
		this.LegLeft01.xRot = -0.14F;
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.09F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (3.0F) + (0F) * 16F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.xRot = -1.2217F;
		this.LegRight01.yRot = -0.5236F;
		this.LegRight01.zRot = 0F;
		this.LegRight02.xRot = 1.0472F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.x = (-3.0F) + (0F) * 16F;
		this.LegRight02.y = (14.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F);
  		float angleX1 = Mth.cos(f2*0.08F + 0.3F + f * 0.5F);
  		float angleX2 = Mth.cos(f2*0.08F + 0.6F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.5F;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.5F;
  		float addk1 = 0F;
  		float addk2 = 0F;
  		float headX = 0F;
  		float headZ = 0F;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.025F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//leg move parm
  		addk1 = angleAdd1 * 0.6F - 0.27F;
	  	addk2 = angleAdd2 * 0.6F - 0.19F;

  	    //移動頭部使其看人
	  	this.Head.xRot = f4 * 0.014F; 	//上下角度
	  	this.Head.yRot = f3 * 0.006F;	//左右角度
	  	this.Head.zRot = 0F;
	  	headX = this.Head.xRot * -0.5F;
	    //正常站立動作
	  	//Body
  	    this.Ahoke.yRot = angleX * 0.15F + 0.6F;
	  	this.BodyMain.xRot = -0.1047F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.35F;
    	this.Butt.y = (4.0F) + (0F) * 16F;
    	this.Butt.z = (1.3F) + (0F) * 16F;
    	this.BoobL.xRot = angleX * 0.08F - 0.76F;
    	this.BoobL.zRot = 0.08F;
  	    this.BoobR.xRot = angleX * 0.08F - 0.76F;
  	    this.BoobR.zRot = -0.08F;
  	    this.Collar01.xRot = 0.035F;
  	    this.Collar01.xRot += this.Head.xRot * 0.8F;
    	//cloth
	  	this.Skirt01.xRot = -0.087F;
	  	this.Skirt01.y = (3.0F) + (0F) * 16F;
	  	this.Skirt01.z = (1.5F) + (0F) * 16F;
	  	this.Skirt02.xRot = angleX1 * 0.015F - 0.087F;
	  	this.Skirt02.y = (4.5F) + (0F) * 16F;
	  	this.Skirt03.xRot = -angleX2 * 0.04F - 0.052F;
    	this.Skirt03.y = (4.5F) + (0F) * 16F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.03F + 0.26F + headX;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -angleX1 * 0.04F - 0.087F + headX;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -angleX2 * 0.07F - 0.052F;
	  	this.Hair03.zRot = 0F;
	    //arm 
	  	this.ArmLeft01.xRot = -0.26F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = 0.28F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.yRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    this.ArmRight01.xRot = -0.26F;
	  	this.ArmRight01.yRot = 0F;
	    this.ArmRight01.zRot = -0.28F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.yRot = 0F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
	    this.ArmRight02.z = (2.5F) + (0F) * 16F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.087F;
		this.LegLeft01.y = (5.5F) + (0F) * 16F;
		this.LegLeft01.z = (-2.6F) + (0F) * 16F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (3.0F) + (0F) * 16F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.087F;
		this.LegRight01.y = (5.5F) + (0F) * 16F;
		this.LegRight01.z = (-2.6F) + (0F) * 16F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.x = (-3.0F) + (0F) * 16F;
		this.LegRight02.y = (14.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		
		//奔跑動作
	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {
	    	//hair angleX * 0.03F + 0.21F + headX
	    	this.Hair01.xRot = angleAdd1 * 0.1F + f1 * 0.4F + headX;
	    	this.Hair02.xRot += 0F;
	    	this.Hair03.xRot += 0.1F;
			//胸部
	  	    this.BoobL.xRot = angleAdd2 * 0.1F - 0.83F;
	  	    this.BoobL.zRot = -0.07F;
	  	    this.BoobR.xRot = angleAdd1 * 0.1F - 0.83F;
	  	    this.BoobR.zRot = 0.07F;
	    	//arm 
		  	this.ArmLeft01.xRot = angleAdd2 * 0.8F + 0.1745F;
		  	this.ArmLeft01.yRot = 0F;
		    this.ArmLeft01.zRot = -0.35F;
		    this.ArmRight01.xRot = angleAdd1 * 0.8F + 0.1745F;
		  	this.ArmRight01.yRot = 0F;
		    this.ArmRight01.zRot = 0.35F;
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
		  	this.Skirt03.xRot = -0.22F;
		  	this.Collar01.xRot -= 0.35F;
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
  		}//end if sneaking
  		
	    //坐下動作
	    if (ent.getIsSitting() && !ent.getIsRiding())
	    {
	    	if (ent.getTickExisted() % 512 > 256)
	    	{
this.animTransX += (0F); this.animTransY += (0.51F); this.animTransZ += (0F);
		    	//body
		    	this.Head.xRot -= 0.7F;
		    	this.BodyMain.xRot = 0.35F;
		    	this.Skirt01.xRot = -0.23F;
		    	this.Skirt01.y = (3.0F) + (-0.23F) * 16F;
		    	this.Skirt02.xRot = -0.2F;
		    	this.Skirt02.y = (4.5F) + (-0.17F) * 16F;
		    	this.Skirt03.xRot = -0.2F;
		    	this.Skirt03.y = (4.5F) + (-0.15F) * 16F;
		    	this.Collar01.xRot -= 0.35F;
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
				//hair
				this.Hair01.xRot += 0.2F;
				this.Hair02.xRot += 0.5F;
				this.Hair03.xRot += 0.4F;
	    	}
	    	else
	    	{
		    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		    	{
this.animTransX += (0F); this.animTransY += (0.43F); this.animTransZ += (0F);
			    	//Body
				  	this.Head.xRot -= 0.1F;
				  	this.BodyMain.xRot = 0F;
			    	this.Butt.xRot = -0.2F;
			    	this.Butt.y = (4.0F) + (0F) * 16F;
			    	this.BoobL.xRot -= 0.1F;
			    	this.BoobL.zRot = 0.16F;
			    	this.BoobR.xRot -= 0.1F;
			    	this.BoobR.zRot = -0.16F;
			    	//skirt
			    	this.Skirt01.xRot = -0.05F;
			    	this.Skirt01.y = (3.0F) + (-0.1F) * 16F;
			    	this.Skirt02.xRot = -0.15F;
			    	this.Skirt02.y = (4.5F) + (-0.1F) * 16F;
			    	this.Skirt03.xRot = -0.1F;
			    	this.Skirt03.y = (4.5F) + (-0.1F) * 16F;
			    	//arm
				  	this.ArmLeft01.xRot = -0.6F;
				  	this.ArmLeft01.zRot = 0.1F;
				  	this.ArmLeft02.zRot = 0.39F;
			    	this.ArmRight01.xRot = -0.6F;
					this.ArmRight01.zRot = -0.1F;
					this.ArmRight02.zRot = -0.39F;
				  	//leg
				  	addk1 = -0.9F;
				  	addk2 = -0.9F;
				  	this.LegLeft01.yRot = 0.19F;
					this.LegLeft01.zRot = 0F;
					this.LegLeft02.xRot = 2.67F;
					this.LegLeft02.zRot = 0.0175F;
					this.LegLeft02.z = (-3.0F) + (0.375F) * 16F;
					this.LegRight01.yRot = -0.19F;
					this.LegRight01.zRot = 0F;
					this.LegRight02.xRot = 2.67F;
					this.LegRight02.zRot = -0.0175F;
					this.LegRight02.z = (-3.0F) + (0.375F) * 16F;
			    	//tako
			    	this.renderTako = true;
			    	tako1 = this.miscModelList.get(0);
			    	tako1.entity.tickCount = ent.getTickExisted();
			    	tako1.posY = 0.34F;
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.43F); this.animTransZ += (0F);
			    	//Body
				  	this.Head.xRot -= 0.1F;
				  	this.BodyMain.xRot = 0F;
			    	this.Butt.xRot = -0.2F;
			    	this.Butt.y = (4.0F) + (0F) * 16F;
			    	this.BoobL.xRot -= 0.1F;
			    	this.BoobL.zRot = 0.16F;
			    	this.BoobR.xRot -= 0.1F;
			    	this.BoobR.zRot = -0.16F;
			    	//skirt
			    	this.Skirt01.xRot = -0.05F;
			    	this.Skirt01.y = (3.0F) + (-0.1F) * 16F;
			    	this.Skirt02.xRot = -0.15F;
			    	this.Skirt02.y = (4.5F) + (-0.1F) * 16F;
			    	this.Skirt03.xRot = -0.1F;
			    	this.Skirt03.y = (4.5F) + (-0.1F) * 16F;
			    	//arm
				  	this.ArmLeft01.xRot = -0.46F;
				  	this.ArmLeft01.zRot = 0.35F;
			    	this.ArmRight01.xRot = -0.46F;
					this.ArmRight01.zRot = -0.35F;
				  	//leg
				  	addk1 = -0.9F;
				  	addk2 = -0.9F;
				  	this.LegLeft01.yRot = 0.19F;
					this.LegLeft01.zRot = 0F;
					this.LegLeft02.xRot = 2.67F;
					this.LegLeft02.zRot = 0.0175F;
					this.LegLeft02.z = (-3.0F) + (0.375F) * 16F;
					this.LegRight01.yRot = -0.19F;
					this.LegRight01.zRot = 0F;
					this.LegRight02.xRot = 2.67F;
					this.LegRight02.zRot = -0.0175F;
					this.LegRight02.z = (-3.0F) + (0.375F) * 16F;
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
	    			if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    			{
this.animTransX += (0F); this.animTransY += (1.43F); this.animTransZ += (0F);
	    				
				    	//Body
					  	this.Head.xRot -= 0.1F;
					  	this.BodyMain.xRot = 0F;
				    	this.Butt.xRot = -0.2F;
				    	this.Butt.y = (4.0F) + (0F) * 16F;
				    	this.BoobL.xRot -= 0.1F;
				    	this.BoobL.zRot = 0.16F;
				    	this.BoobR.xRot -= 0.1F;
				    	this.BoobR.zRot = -0.16F;
				    	//skirt
				    	this.Skirt01.xRot = -0.05F;
				    	this.Skirt01.y = (3.0F) + (-0.1F) * 16F;
				    	this.Skirt02.xRot = -0.15F;
				    	this.Skirt02.y = (4.5F) + (-0.1F) * 16F;
				    	this.Skirt03.xRot = -0.1F;
				    	this.Skirt03.y = (4.5F) + (-0.1F) * 16F;
				    	//arm
					  	this.ArmLeft01.xRot = -0.6F;
					  	this.ArmLeft01.zRot = 0.1F;
					  	this.ArmLeft02.zRot = 0.39F;
				    	this.ArmRight01.xRot = -0.6F;
						this.ArmRight01.zRot = -0.1F;
						this.ArmRight02.zRot = -0.39F;
					  	//leg
					  	addk1 = -0.9F;
					  	addk2 = -0.9F;
					  	this.LegLeft01.yRot = 0.19F;
						this.LegLeft01.zRot = 0F;
						this.LegLeft02.xRot = 2.67F;
						this.LegLeft02.zRot = 0.0175F;
						this.LegLeft02.z = (-3.0F) + (0.375F) * 16F;
						this.LegRight01.yRot = -0.19F;
						this.LegRight01.zRot = 0F;
						this.LegRight02.xRot = 2.67F;
						this.LegRight02.zRot = -0.0175F;
						this.LegRight02.z = (-3.0F) + (0.375F) * 16F;
				    	//tako
				    	this.renderTako = true;
				    	tako1 = this.miscModelList.get(0);
				    	tako1.entity.tickCount = ent.getTickExisted();
				    	tako1.posY = -1.12F;
			    	}
			    	else
			    	{
this.animTransX += (0F); this.animTransY += (1.43F); this.animTransZ += (0F);
			    		
				    	//Body
					  	this.Head.xRot -= 0.1F;
					  	this.BodyMain.xRot = 0F;
				    	this.Butt.xRot = -0.2F;
				    	this.Butt.y = (4.0F) + (0F) * 16F;
				    	this.BoobL.xRot -= 0.1F;
				    	this.BoobL.zRot = 0.16F;
				    	this.BoobR.xRot -= 0.1F;
				    	this.BoobR.zRot = -0.16F;
				    	//skirt
				    	this.Skirt01.xRot = -0.05F;
				    	this.Skirt01.y = (3.0F) + (-0.1F) * 16F;
				    	this.Skirt02.xRot = -0.15F;
				    	this.Skirt02.y = (4.5F) + (-0.1F) * 16F;
				    	this.Skirt03.xRot = -0.1F;
				    	this.Skirt03.y = (4.5F) + (-0.1F) * 16F;
				    	//arm
					  	this.ArmLeft01.xRot = -0.46F;
					  	this.ArmLeft01.zRot = 0.35F;
				    	this.ArmRight01.xRot = -0.46F;
						this.ArmRight01.zRot = -0.35F;
					  	//leg
					  	addk1 = -0.9F;
					  	addk2 = -0.9F;
					  	this.LegLeft01.yRot = 0.19F;
						this.LegLeft01.zRot = 0F;
						this.LegLeft02.xRot = 2.67F;
						this.LegLeft02.zRot = 0.0175F;
						this.LegLeft02.z = (-3.0F) + (0.375F) * 16F;
						this.LegRight01.yRot = -0.19F;
						this.LegRight01.zRot = 0F;
						this.LegRight02.xRot = 2.67F;
						this.LegRight02.zRot = -0.0175F;
						this.LegRight02.z = (-3.0F) + (0.375F) * 16F;
			    	}
		    	}//end if sitting
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.08F); this.animTransZ += (0F);
		    		
			    	//body
			    	this.Head.xRot -= 0.7F;
			    	this.BodyMain.xRot = 0.35F;
			    	this.Skirt01.xRot = -0.23F;
			    	this.Skirt01.y = (3.0F) + (-0.23F) * 16F;
			    	this.Skirt02.xRot = -0.2F;
			    	this.Skirt02.y = (4.5F) + (-0.17F) * 16F;
			    	this.Skirt03.xRot = -0.2F;
			    	this.Skirt03.y = (4.5F) + (-0.15F) * 16F;
			    	this.Collar01.xRot -= 0.35F;
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
					//hair
					if (ent.getIsSprinting() || f1 > 0.9F)
				    {
						this.Hair01.xRot += 0.5F;
						this.Hair02.xRot += 0.4F;
						this.Hair03.xRot += 0.2F;
				    }
					else
					{
						this.Hair01.xRot += 0.2F;
						this.Hair02.xRot += 0.4F;
						this.Hair03.xRot += 0.2F;
					}
		    	}
	    	}//end ship mount
	    	//normal mount ex: cart
	    	else
	    	{
	    		if (ent.getIsSitting())
	    		{
	    			if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
			    	{
this.animTransX += (0F); this.animTransY += (0.43F); this.animTransZ += (0F);
	    				
				    	//Body
					  	this.Head.xRot -= 0.1F;
					  	this.BodyMain.xRot = 0F;
				    	this.Butt.xRot = -0.2F;
				    	this.Butt.y = (4.0F) + (0F) * 16F;
				    	this.BoobL.xRot -= 0.1F;
				    	this.BoobL.zRot = 0.16F;
				    	this.BoobR.xRot -= 0.1F;
				    	this.BoobR.zRot = -0.16F;
				    	//skirt
				    	this.Skirt01.xRot = -0.05F;
				    	this.Skirt01.y = (3.0F) + (-0.1F) * 16F;
				    	this.Skirt02.xRot = -0.15F;
				    	this.Skirt02.y = (4.5F) + (-0.1F) * 16F;
				    	this.Skirt03.xRot = -0.1F;
				    	this.Skirt03.y = (4.5F) + (-0.1F) * 16F;
				    	//arm
					  	this.ArmLeft01.xRot = -0.6F;
					  	this.ArmLeft01.zRot = 0.1F;
					  	this.ArmLeft02.zRot = 0.39F;
				    	this.ArmRight01.xRot = -0.6F;
						this.ArmRight01.zRot = -0.1F;
						this.ArmRight02.zRot = -0.39F;
					  	//leg
					  	addk1 = -0.9F;
					  	addk2 = -0.9F;
					  	this.LegLeft01.yRot = 0.19F;
						this.LegLeft01.zRot = 0F;
						this.LegLeft02.xRot = 2.67F;
						this.LegLeft02.zRot = 0.0175F;
						this.LegLeft02.z = (-3.0F) + (0.375F) * 16F;
						this.LegRight01.yRot = -0.19F;
						this.LegRight01.zRot = 0F;
						this.LegRight02.xRot = 2.67F;
						this.LegRight02.zRot = -0.0175F;
						this.LegRight02.z = (-3.0F) + (0.375F) * 16F;
				    	//tako
				    	this.renderTako = true;
				    	tako1 = this.miscModelList.get(0);
				    	tako1.entity.tickCount = ent.getTickExisted();
				    	tako1.posY = 0.34F;
			    	}
			    	else
			    	{
this.animTransX += (0F); this.animTransY += (0.43F); this.animTransZ += (0F);
			    		
				    	//Body
					  	this.Head.xRot -= 0.1F;
					  	this.BodyMain.xRot = 0F;
				    	this.Butt.xRot = -0.2F;
				    	this.Butt.y = (4.0F) + (0F) * 16F;
				    	this.BoobL.xRot -= 0.1F;
				    	this.BoobL.zRot = 0.16F;
				    	this.BoobR.xRot -= 0.1F;
				    	this.BoobR.zRot = -0.16F;
				    	//skirt
				    	this.Skirt01.xRot = -0.05F;
				    	this.Skirt01.y = (3.0F) + (-0.1F) * 16F;
				    	this.Skirt02.xRot = -0.15F;
				    	this.Skirt02.y = (4.5F) + (-0.1F) * 16F;
				    	this.Skirt03.xRot = -0.1F;
				    	this.Skirt03.y = (4.5F) + (-0.1F) * 16F;
				    	//arm
					  	this.ArmLeft01.xRot = -0.46F;
					  	this.ArmLeft01.zRot = 0.35F;
				    	this.ArmRight01.xRot = -0.46F;
						this.ArmRight01.zRot = -0.35F;
					  	//leg
					  	addk1 = -0.9F;
					  	addk2 = -0.9F;
					  	this.LegLeft01.yRot = 0.19F;
						this.LegLeft01.zRot = 0F;
						this.LegLeft02.xRot = 2.67F;
						this.LegLeft02.zRot = 0.0175F;
						this.LegLeft02.z = (-3.0F) + (0.375F) * 16F;
						this.LegRight01.yRot = -0.19F;
						this.LegRight01.zRot = 0F;
						this.LegRight02.xRot = 2.67F;
						this.LegRight02.zRot = -0.0175F;
						this.LegRight02.z = (-3.0F) + (0.375F) * 16F;
			    	}
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.51F); this.animTransZ += (0F);
		    		
			    	//body
			    	this.Head.xRot -= 0.7F;
			    	this.BodyMain.xRot = 0.35F;
			    	this.Skirt01.xRot = -0.23F;
			    	this.Skirt01.y = (3.0F) + (-0.23F) * 16F;
			    	this.Skirt02.xRot = -0.2F;
			    	this.Skirt02.y = (4.5F) + (-0.17F) * 16F;
			    	this.Skirt03.xRot = -0.2F;
			    	this.Skirt03.y = (4.5F) + (-0.15F) * 16F;
			    	this.Collar01.xRot -= 0.35F;
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
					//hair
					this.Hair01.xRot += 0.2F;
					this.Hair02.xRot += 0.5F;
					this.Hair03.xRot += 0.4F;
		    	}
	    	}
	    }//end ridding
    
	    //攻擊動作    
	    if (ent.getAttackTick() > 0)
	    {
	    	if (ent.getAttackTick() > 20)
	    	{
	    		//arm
		    	this.ArmLeft01.xRot = -1.7F + this.Head.xRot * 0.75F;
		    	this.ArmLeft01.yRot = -0.2F;
		    	this.ArmLeft01.zRot = 0F;
		    	this.ArmLeft02.xRot = 0F;
		    	this.ArmLeft02.yRot = 0F;
			    this.ArmLeft02.zRot = 0F;
			    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
			    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    	}
	    	
	    	this.GlowBodyMain2a.xRot = this.ArmLeft01.xRot * -0.3F;
	    	
	    	//跑道顯示
	    	setRoad(ent.getAttackTick());
	    }
	    
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
		this.HairL01.xRot = angleX * 0.02F + headX - 0.19F;
	  	this.HairL02.xRot = -angleX1 * 0.04F + headX + 0.17F;
	  	this.HairR01.xRot = angleX * 0.02F + headX - 0.19F;
	  	this.HairR02.xRot = -angleX1 * 0.04F + headX + 0.17F;
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

	private void setRoad(int attackTime)
	{

		switch (attackTime)
		{
		case 50:
		case 26:
			this.EquipSR01.visible = true;
			this.EquipSR02.visible = false;
			this.EquipSR01b.visible = true;
			this.EquipSR02b.visible = false;
			this.EquipSR01c.visible = true;
			this.EquipSR02c.visible = false;
			this.EquipSR01.z = (13.0F) + (0.7F) * 16F;
			this.EquipSR01b.z = (13.7F) + (0.7F) * 16F;
			this.EquipSR01c.z = (-19.0F) + (0.7F) * 16F;
		break;
		case 49:
		case 27:
			this.EquipSR01.visible = true;
			this.EquipSR02.visible = true;
			this.EquipSR03.visible = false;
			this.EquipSR01b.visible = true;
			this.EquipSR02b.visible = true;
			this.EquipSR03b.visible = false;
			this.EquipSR01c.visible = true;
			this.EquipSR02c.visible = true;
			this.EquipSR03c.visible = false;
			this.EquipSR01.z = (13.0F) + (0.45F) * 16F;
			this.EquipSR01b.z = (13.7F) + (0.45F) * 16F;
			this.EquipSR01c.z = (-19.0F) + (0.45F) * 16F;
			this.EquipSR02.z = (0.0F) + (0.25F) * 16F;
			this.EquipSR02b.z = (0.0F) + (0.25F) * 16F;
			this.EquipSR02c.z = (0.0F) + (0.25F) * 16F;
		break;
		case 48:
		case 28:
			this.EquipSR01.visible = true;
			this.EquipSR02.visible = true;
			this.EquipSR03.visible = true;
			this.EquipSR04.visible = false;
			this.EquipSR01b.visible = true;
			this.EquipSR02b.visible = true;
			this.EquipSR03b.visible = true;
			this.EquipSR04b.visible = false;
			this.EquipSR01c.visible = true;
			this.EquipSR02c.visible = true;
			this.EquipSR03c.visible = true;
			this.EquipSR04c.visible = false;
			this.EquipSR01.z = (13.0F) + (0.25F) * 16F;
			this.EquipSR01b.z = (13.7F) + (0.25F) * 16F;
			this.EquipSR01c.z = (-19.0F) + (0.25F) * 16F;
			this.EquipSR02.z = (0.0F) + (0.2F) * 16F;
			this.EquipSR02b.z = (0.0F) + (0.2F) * 16F;
			this.EquipSR02c.z = (0.0F) + (0.2F) * 16F;
			this.EquipSR03.z = (0.0F) + (0.25F) * 16F;
			this.EquipSR03b.z = (0.0F) + (0.25F) * 16F;
			this.EquipSR03c.z = (0.0F) + (0.25F) * 16F;
		break;
		case 47:
		case 29:
			this.EquipSR01.visible = true;
			this.EquipSR02.visible = true;
			this.EquipSR03.visible = true;
			this.EquipSR04.visible = true;
			this.EquipSR05.visible = false;
			this.EquipSR01b.visible = true;
			this.EquipSR02b.visible = true;
			this.EquipSR03b.visible = true;
			this.EquipSR04b.visible = true;
			this.EquipSR01c.visible = true;
			this.EquipSR02c.visible = true;
			this.EquipSR03c.visible = true;
			this.EquipSR04c.visible = true;
			this.EquipSR05c.visible = false;
			this.EquipSR01.z = (13.0F) + (0.1F) * 16F;
			this.EquipSR01b.z = (13.7F) + (0.1F) * 16F;
			this.EquipSR01c.z = (-19.0F) + (0.1F) * 16F;
			this.EquipSR02.z = (0.0F) + (0.15F) * 16F;
			this.EquipSR02b.z = (0.0F) + (0.15F) * 16F;
			this.EquipSR02c.z = (0.0F) + (0.15F) * 16F;
			this.EquipSR03.z = (0.0F) + (0.2F) * 16F;
			this.EquipSR03b.z = (0.0F) + (0.2F) * 16F;
			this.EquipSR03c.z = (0.0F) + (0.2F) * 16F;
			this.EquipSR04.z = (0.0F) + (0.25F) * 16F;
			this.EquipSR04b.z = (0.0F) + (0.25F) * 16F;
			this.EquipSR04c.z = (0.0F) + (0.25F) * 16F;
		break;
		case 46:
		case 30:
			this.EquipSR01.visible = true;
			this.EquipSR02.visible = true;
			this.EquipSR03.visible = true;
			this.EquipSR04.visible = true;
			this.EquipSR05.visible = true;
			this.EquipSR01b.visible = true;
			this.EquipSR02b.visible = true;
			this.EquipSR03b.visible = true;
			this.EquipSR04b.visible = true;
			this.EquipSR01c.visible = true;
			this.EquipSR02c.visible = true;
			this.EquipSR03c.visible = true;
			this.EquipSR04c.visible = true;
			this.EquipSR05c.visible = true;
			this.EquipSR01.z = (13.0F) + (0F) * 16F;
			this.EquipSR01b.z = (13.7F) + (0F) * 16F;
			this.EquipSR01c.z = (-19.0F) + (0F) * 16F;
			this.EquipSR02.z = (0.0F) + (0.1F) * 16F;
			this.EquipSR02b.z = (0.0F) + (0.1F) * 16F;
			this.EquipSR02c.z = (0.0F) + (0.1F) * 16F;
			this.EquipSR03.z = (0.0F) + (0.15F) * 16F;
			this.EquipSR03b.z = (0.0F) + (0.15F) * 16F;
			this.EquipSR03c.z = (0.0F) + (0.15F) * 16F;
			this.EquipSR04.z = (0.0F) + (0.2F) * 16F;
			this.EquipSR04b.z = (0.0F) + (0.2F) * 16F;
			this.EquipSR04c.z = (0.0F) + (0.2F) * 16F;
			this.EquipSR05.z = (0.0F) + (0.25F) * 16F;
			this.EquipSR05c.z = (0.0F) + (0.25F) * 16F;
		break;
		case 45:
		case 31:
			this.EquipSR01.visible = true;
			this.EquipSR02.visible = true;
			this.EquipSR03.visible = true;
			this.EquipSR04.visible = true;
			this.EquipSR05.visible = true;
			this.EquipSR01b.visible = true;
			this.EquipSR02b.visible = true;
			this.EquipSR03b.visible = true;
			this.EquipSR04b.visible = true;
			this.EquipSR01c.visible = true;
			this.EquipSR02c.visible = true;
			this.EquipSR03c.visible = true;
			this.EquipSR04c.visible = true;
			this.EquipSR05c.visible = true;
			this.EquipSR01.z = (13.0F) + (0F) * 16F;
			this.EquipSR01b.z = (13.7F) + (0F) * 16F;
			this.EquipSR01c.z = (-19.0F) + (0F) * 16F;
			this.EquipSR02.z = (0.0F) + (0F) * 16F;
			this.EquipSR02b.z = (0.0F) + (0F) * 16F;
			this.EquipSR02c.z = (0.0F) + (0F) * 16F;
			this.EquipSR03.z = (0.0F) + (0.1F) * 16F;
			this.EquipSR03b.z = (0.0F) + (0.1F) * 16F;
			this.EquipSR03c.z = (0.0F) + (0.1F) * 16F;
			this.EquipSR04.z = (0.0F) + (0.15F) * 16F;
			this.EquipSR04b.z = (0.0F) + (0.15F) * 16F;
			this.EquipSR04c.z = (0.0F) + (0.15F) * 16F;
			this.EquipSR05.z = (0.0F) + (0.2F) * 16F;
			this.EquipSR05c.z = (0.0F) + (0.2F) * 16F;
		break;
		case 44:
		case 32:
			this.EquipSR01.visible = true;
			this.EquipSR02.visible = true;
			this.EquipSR03.visible = true;
			this.EquipSR04.visible = true;
			this.EquipSR05.visible = true;
			this.EquipSR01b.visible = true;
			this.EquipSR02b.visible = true;
			this.EquipSR03b.visible = true;
			this.EquipSR04b.visible = true;
			this.EquipSR01c.visible = true;
			this.EquipSR02c.visible = true;
			this.EquipSR03c.visible = true;
			this.EquipSR04c.visible = true;
			this.EquipSR05c.visible = true;
			this.EquipSR01.z = (13.0F) + (0F) * 16F;
			this.EquipSR01b.z = (13.7F) + (0F) * 16F;
			this.EquipSR01c.z = (-19.0F) + (0F) * 16F;
			this.EquipSR02.z = (0.0F) + (0F) * 16F;
			this.EquipSR02b.z = (0.0F) + (0F) * 16F;
			this.EquipSR02c.z = (0.0F) + (0F) * 16F;
			this.EquipSR03.z = (0.0F) + (0F) * 16F;
			this.EquipSR03b.z = (0.0F) + (0F) * 16F;
			this.EquipSR03c.z = (0.0F) + (0F) * 16F;
			this.EquipSR04.z = (0.0F) + (0.1F) * 16F;
			this.EquipSR04b.z = (0.0F) + (0.1F) * 16F;
			this.EquipSR04c.z = (0.0F) + (0.1F) * 16F;
			this.EquipSR05.z = (0.0F) + (0.15F) * 16F;
			this.EquipSR05c.z = (0.0F) + (0.15F) * 16F;
		break;
		case 43:
		case 33:
			this.EquipSR01.visible = true;
			this.EquipSR02.visible = true;
			this.EquipSR03.visible = true;
			this.EquipSR04.visible = true;
			this.EquipSR05.visible = true;
			this.EquipSR01b.visible = true;
			this.EquipSR02b.visible = true;
			this.EquipSR03b.visible = true;
			this.EquipSR04b.visible = true;
			this.EquipSR01c.visible = true;
			this.EquipSR02c.visible = true;
			this.EquipSR03c.visible = true;
			this.EquipSR04c.visible = true;
			this.EquipSR05c.visible = true;
			this.EquipSR01.z = (13.0F) + (0F) * 16F;
			this.EquipSR01b.z = (13.7F) + (0F) * 16F;
			this.EquipSR01c.z = (-19.0F) + (0F) * 16F;
			this.EquipSR02.z = (0.0F) + (0F) * 16F;
			this.EquipSR02b.z = (0.0F) + (0F) * 16F;
			this.EquipSR02c.z = (0.0F) + (0F) * 16F;
			this.EquipSR03.z = (0.0F) + (0F) * 16F;
			this.EquipSR03b.z = (0.0F) + (0F) * 16F;
			this.EquipSR03c.z = (0.0F) + (0F) * 16F;
			this.EquipSR04.z = (0.0F) + (0F) * 16F;
			this.EquipSR04b.z = (0.0F) + (0F) * 16F;
			this.EquipSR04c.z = (0.0F) + (0F) * 16F;
			this.EquipSR05.z = (0.0F) + (0.1F) * 16F;
			this.EquipSR05c.z = (0.0F) + (0.1F) * 16F;
		break;
		default:
			if (attackTime < 47 && attackTime > 29)
			{
				this.EquipSR01.visible = true;
				this.EquipSR02.visible = true;
				this.EquipSR03.visible = true;
				this.EquipSR04.visible = true;
				this.EquipSR05.visible = true;
				this.EquipSR01b.visible = true;
				this.EquipSR02b.visible = true;
				this.EquipSR03b.visible = true;
				this.EquipSR04b.visible = true;
				this.EquipSR01c.visible = true;
				this.EquipSR02c.visible = true;
				this.EquipSR03c.visible = true;
				this.EquipSR04c.visible = true;
				this.EquipSR05c.visible = true;
				this.EquipSR01.z = (13.0F) + (0F) * 16F;
				this.EquipSR01b.z = (13.7F) + (0F) * 16F;
				this.EquipSR01c.z = (-19.0F) + (0F) * 16F;
				this.EquipSR02.z = (0.0F) + (0F) * 16F;
				this.EquipSR02b.z = (0.0F) + (0F) * 16F;
				this.EquipSR02c.z = (0.0F) + (0F) * 16F;
				this.EquipSR03.z = (0.0F) + (0F) * 16F;
				this.EquipSR03b.z = (0.0F) + (0F) * 16F;
				this.EquipSR03c.z = (0.0F) + (0F) * 16F;
				this.EquipSR04.z = (0.0F) + (0F) * 16F;
				this.EquipSR04b.z = (0.0F) + (0F) * 16F;
				this.EquipSR04c.z = (0.0F) + (0F) * 16F;
				this.EquipSR05.z = (0.0F) + (0F) * 16F;
				this.EquipSR05c.z = (0.0F) + (0F) * 16F;
			}		
		break;
		}
	
	}

	public boolean shouldRenderMiscModel(int miscID)
	{

		return this.renderTako;
	
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

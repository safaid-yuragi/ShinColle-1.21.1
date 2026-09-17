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

public class ModelCruiserTenryuu<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart Butt;
	public ModelPart ArmRight01;
	public ModelPart ArmLeft01;
	public ModelPart Cloth01;
	public ModelPart EquipSR01;
	public ModelPart Equip00;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart EarL01;
	public ModelPart EarR01;
	public ModelPart EyeMask;
	public ModelPart HairU01;
	public ModelPart Ahoke;
	public ModelPart Hair01;
	public ModelPart EarL02;
	public ModelPart EarL03;
	public ModelPart EarL04;
	public ModelPart EarR02;
	public ModelPart EarR03;
	public ModelPart EarR04;
	public ModelPart LegLeft01;
	public ModelPart Skirt01;
	public ModelPart LegRight01;
	public ModelPart LegLeft02;
	public ModelPart ShoeL01;
	public ModelPart ShoeL00;
	public ModelPart ShoeL02;
	public ModelPart Skirt02;
	public ModelPart LegRight02;
	public ModelPart ShoeR01;
	public ModelPart ShoeR00;
	public ModelPart ShoeR02;
	public ModelPart ArmRight02;
	public ModelPart ArmRight02a;
	public ModelPart ArmLeft02;
	public ModelPart ArmLeft02a;
	public ModelPart EquipSL00;
	public ModelPart EquipSL00a;
	public ModelPart EquipSL00b;
	public ModelPart EquipSL01;
	public ModelPart EquipSL02;
	public ModelPart EquipSL02a;
	public ModelPart EquipSL03;
	public ModelPart EquipSL03a;
	public ModelPart EquipSR02;
	public ModelPart EquipSR03;
	public ModelPart Equip01a;
	public ModelPart Equip01b;
	public ModelPart Equip01c;
	public ModelPart Equip02a;
	public ModelPart Equip01d;
	public ModelPart Equip03L;
	public ModelPart Equip03R;
	public ModelPart EquipCL01;
	public ModelPart EquipCL02;
	public ModelPart EquipCL03;
	public ModelPart EquipCL04;
	public ModelPart EquipCL05;
	public ModelPart EquipCR01;
	public ModelPart EquipCR02;
	public ModelPart EquipCR03;
	public ModelPart EquipCR04;
	public ModelPart EquipCR05;
	public ModelPart Equip02b;
	public ModelPart Equip02c;
	public ModelPart Equip02d;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ModelPart GlowEquip00;
	public ModelPart GlowEquip01a;
	public ModelPart GlowEquip02a;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().mirror().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.0F, 0.0F, 0.3490658503988659F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("ArmRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(-3.0F, 11.0F, 2.5F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("ArmRight02a", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(2.5F, 1.3F, -2.4F, 0.06981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 6.0F), PartPose.offset(0.0F, -11.7F, -0.2F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.10471975511965977F, 0.0F, -0.3490658503988659F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(3.0F, 11.0F, 2.5F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("EquipSL00", CubeListBuilder.create().addBox(0.0F, -4.0F, -0.5F, 2.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, 9.3F, -3.0F, -1.5707963267948966F, -0.13962634015954636F, 1.5707963267948966F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("EquipSL00b", CubeListBuilder.create().addBox(0.0F, -2.0F, -0.5F, 3.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(-0.1F, -3.8F, 0.0F, 0.0F, 0.0F, 0.13962634015954636F));
		PartDefinition partdef9 = partdef7.addOrReplaceChild("EquipSL01", CubeListBuilder.create().addBox(-2.5F, 0.0F, -0.5F, 3.0F, 12.0F, 1.0F), PartPose.offsetAndRotation(2.1F, 4.7F, 0.0F, 0.0F, 0.0F, 0.06981317007977318F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("EquipSL02", CubeListBuilder.create().addBox(-2.5F, 0.0F, -0.5F, 3.0F, 11.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 11.9F, 0.0F, 0.0F, 0.0F, 0.10471975511965977F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("EquipSL03", CubeListBuilder.create().addBox(-2.5F, 0.0F, -0.5F, 3.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 10.9F, 0.0F, 0.0F, 0.0F, 0.13962634015954636F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("EquipSL03a", CubeListBuilder.create().addBox(-2.5F, 0.0F, -0.5F, 2.0F, 11.0F, 1.0F), PartPose.offsetAndRotation(-1.7F, -3.0F, -0.2F, 0.017453292519943295F, 0.0F, -0.15707963267948966F));
		PartDefinition partdef13 = partdef10.addOrReplaceChild("EquipSL02a", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -0.5F, 2.0F, 11.0F, 1.0F), PartPose.offsetAndRotation(-4.3F, -3.0F, 0.0F, -0.017453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef14 = partdef7.addOrReplaceChild("EquipSL00a", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.0F, 4.0F, 1.0F, 2.0F), PartPose.offset(-0.7F, 3.9F, 0.0F));
		PartDefinition partdef15 = partdef6.addOrReplaceChild("ArmLeft02a", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-2.5F, 1.3F, -2.4F, 0.06981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-2.5F, -2.0F, -3.6F, 5.0F, 2.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.1F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -7.0F));
		PartDefinition partdef20 = partdef18.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -6.0F, -10.5F, 0.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(-0.5F, -7.0F, -6.0F, 0.20943951023931953F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef21 = partdef17.addOrReplaceChild("EyeMask", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 5.0F, 1.0F), PartPose.offsetAndRotation(2.7F, -8.4F, -6.7F, 0.0F, 0.0F, 0.4363323129985824F));
		PartDefinition partdef22 = partdef17.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 11.5F, 3.3F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(3.5F, -8.1F, -3.7F, -0.6981317007977318F, 0.08726646259971647F, 0.08726646259971647F));
		PartDefinition partdef25 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("LegRight01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.20943951023931953F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("LegRight02", CubeListBuilder.create().mirror().addBox(0F, 0F, 0F, 6.0F, 15.0F, 6.0F), PartPose.offset(-3F, 14F, -3F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("ShoeR01", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offset(3F, 10.5F, 3F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("ShoeR02", CubeListBuilder.create().mirror().addBox(-0.5F, 0.0F, -10.0F, 1.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -0.3F, -2.5F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdef27.addOrReplaceChild("ShoeR00", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(3F, 4.2F, 3F, 0.0F, -3.141592653589793F, 0.0F));
		PartDefinition partdef31 = partdef25.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -6.0F, 17.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 2.9F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-9.0F, 0.0F, -6.0F, 18.0F, 4.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 2.8F, -0.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef33 = partdef25.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("LegLeft02", CubeListBuilder.create().addBox(-6F, 0F, 0F, 6.0F, 15.0F, 6.0F), PartPose.offset(3F, 14F, -3F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("ShoeL01", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(-3F, 10.5F, 3F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("ShoeL02", CubeListBuilder.create().addBox(-0.5F, 0.0F, -10.0F, 1.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -0.3F, -2.5F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef37 = partdef34.addOrReplaceChild("ShoeL00", CubeListBuilder.create().addBox(-3.6F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(-3F, 4.2F, 3F, 0.0F, -3.141592653589793F, 0.0F));
		PartDefinition partdef38 = partdef0.addOrReplaceChild("EquipSR01", CubeListBuilder.create().addBox(-1.0F, -2.0F, -1.5F, 2.0F, 12.0F, 3.0F), PartPose.offsetAndRotation(-9.0F, 5.5F, -5.0F, 1.3089969389957472F, -0.13962634015954636F, -0.13962634015954636F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("EquipSR02", CubeListBuilder.create().addBox(-1.0F, 0.0F, -3.0F, 2.0F, 12.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 1.5F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef40 = partdef39.addOrReplaceChild("EquipSR03", CubeListBuilder.create().addBox(-1.0F, 0.0F, -3.0F, 2.0F, 12.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef41 = partdef0.addOrReplaceChild("Equip00", CubeListBuilder.create().addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 5.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("Equip01a", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 5.0F), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("Equip01b", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 11.0F, 5.0F), PartPose.offset(0.0F, 7.0F, 0.0F));
		PartDefinition partdef44 = partdef42.addOrReplaceChild("Equip01c", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 5.0F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("Equip01d", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 11.0F, 5.0F), PartPose.offset(0.0F, 7.0F, 0.0F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("Equip03R", CubeListBuilder.create().mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 8.0F, 2.0F), PartPose.offset(-5.0F, 1.5F, 4.5F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("EquipCR01", CubeListBuilder.create().mirror().addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-3.5F, 3.5F, 2.0F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("EquipCR02", CubeListBuilder.create().mirror().addBox(-5.0F, -3.0F, -2.0F, 5.0F, 7.0F, 7.0F), PartPose.offset(-1.9F, 0.0F, 0.0F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("EquipCR03", CubeListBuilder.create().mirror().addBox(-5.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F), PartPose.offset(0.0F, -7.0F, -1.5F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("EquipCR04", CubeListBuilder.create().mirror().addBox(-1.5F, -5.8F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offset(-2.5F, 3.0F, 3.0F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("EquipCR05", CubeListBuilder.create().mirror().addBox(-1.0F, -13.6F, -1.0F, 2.0F, 8.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef52 = partdef45.addOrReplaceChild("Equip03L", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 8.0F, 2.0F), PartPose.offset(5.0F, 1.5F, 4.5F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("EquipCL01", CubeListBuilder.create().addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(3.5F, 3.5F, 2.0F));
		PartDefinition partdef54 = partdef53.addOrReplaceChild("EquipCL02", CubeListBuilder.create().addBox(0.0F, -3.0F, -2.0F, 5.0F, 7.0F, 7.0F), PartPose.offset(1.9F, 0.0F, 0.0F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("EquipCL03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F), PartPose.offset(0.0F, -7.0F, -1.5F));
		PartDefinition partdef56 = partdef55.addOrReplaceChild("EquipCL04", CubeListBuilder.create().addBox(-1.5F, -5.8F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offset(2.5F, 3.0F, 3.0F));
		PartDefinition partdef57 = partdef56.addOrReplaceChild("EquipCL05", CubeListBuilder.create().addBox(-1.0F, -13.6F, -1.0F, 2.0F, 8.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef58 = partdef42.addOrReplaceChild("Equip02a", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 7.0F, 4.0F), PartPose.offset(0.0F, -0.4F, 10.0F));
		PartDefinition partdef59 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-3.5F, -8.1F, -3.7F, -0.6981317007977318F, -0.08726646259971647F, -0.08726646259971647F));
		PartDefinition partdef60 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef64 = partdef62.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef65 = partdef62.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef66 = partdef62.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef67 = partdef62.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef68 = partdef62.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef69 = partdef62.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef70 = partdef62.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef71 = partdef62.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef72 = partdef62.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));
		PartDefinition partdef73 = partdef62.addOrReplaceChild("EarL01", CubeListBuilder.create().addBox(-1.0F, -2.5F, -2.5F, 2.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(9.0F, -11.0F, 4.0F, 0.08726646259971647F, -0.17453292519943295F, -0.08726646259971647F));
		PartDefinition partdef74 = partdef73.addOrReplaceChild("EarL02", CubeListBuilder.create().addBox(0.0F, -4.0F, -3.5F, 2.0F, 4.0F, 7.0F), PartPose.offset(-1.0F, -2.5F, -1.0F));
		PartDefinition partdef75 = partdef74.addOrReplaceChild("EarL03", CubeListBuilder.create().addBox(0.0F, -5.0F, 0.0F, 2.0F, 4.0F, 6.0F), PartPose.offset(0.0F, -3.0F, -3.2F));
		PartDefinition partdef76 = partdef75.addOrReplaceChild("EarL04", CubeListBuilder.create().addBox(0.0F, -4.0F, 0.0F, 2.0F, 4.0F, 5.0F), PartPose.offset(0.0F, -5.0F, 0.3F));
		PartDefinition partdef77 = partdef62.addOrReplaceChild("EarR01", CubeListBuilder.create().mirror().addBox(-1.0F, -2.5F, -2.5F, 2.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-9.0F, -11.0F, 4.0F, 0.08726646259971647F, 0.17453292519943295F, 0.08726646259971647F));
		PartDefinition partdef78 = partdef77.addOrReplaceChild("EarR02", CubeListBuilder.create().mirror().addBox(0.0F, -4.0F, -3.5F, 2.0F, 4.0F, 7.0F), PartPose.offset(-1.0F, -2.5F, -1.0F));
		PartDefinition partdef79 = partdef78.addOrReplaceChild("EarR03", CubeListBuilder.create().mirror().addBox(0.0F, -5.0F, 0.0F, 2.0F, 4.0F, 6.0F), PartPose.offset(0.0F, -3.0F, -3.2F));
		PartDefinition partdef80 = partdef79.addOrReplaceChild("EarR04", CubeListBuilder.create().mirror().addBox(0.0F, -4.0F, 0.0F, 2.0F, 4.0F, 5.0F), PartPose.offset(0.0F, -5.0F, 0.3F));
		PartDefinition partdef81 = partdef60.addOrReplaceChild("GlowEquip00", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 5.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef82 = partdef81.addOrReplaceChild("GlowEquip01a", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition partdef83 = partdef82.addOrReplaceChild("GlowEquip02a", CubeListBuilder.create(), PartPose.offset(0.0F, -0.4F, 10.0F));
		PartDefinition partdef84 = partdef83.addOrReplaceChild("Equip02b", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 4.0F));
		PartDefinition partdef85 = partdef84.addOrReplaceChild("Equip02c", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 1.0F), PartPose.offset(0.0F, 3.0F, 4.0F));
		PartDefinition partdef86 = partdef85.addOrReplaceChild("Equip02d", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelCruiserTenryuu(ModelPart root)
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
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.EquipSL02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00").getChild("EquipSL01").getChild("EquipSL02");
		this.EarR04 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("EarR01").getChild("EarR02").getChild("EarR03").getChild("EarR04");
		this.EquipSL03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00").getChild("EquipSL01").getChild("EquipSL02").getChild("EquipSL03");
		this.ArmRight02a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight02a");
		this.Equip01b = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01b");
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.HairU01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairU01");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.Equip03R = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03R");
		this.EarL04 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("EarL01").getChild("EarL02").getChild("EarL03").getChild("EarL04");
		this.EarL02 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("EarL01").getChild("EarL02");
		this.EquipSL02a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00").getChild("EquipSL01").getChild("EquipSL02").getChild("EquipSL02a");
		this.EquipSL00b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00").getChild("EquipSL00b");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.Equip02d = root.getChild("GlowBodyMain").getChild("GlowEquip00").getChild("GlowEquip01a").getChild("GlowEquip02a").getChild("Equip02b").getChild("Equip02c").getChild("Equip02d");
		this.EarL03 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("EarL01").getChild("EarL02").getChild("EarL03");
		this.EquipCR02 = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03R").getChild("EquipCR01").getChild("EquipCR02");
		this.EquipSR02 = root.getChild("BodyMain").getChild("EquipSR01").getChild("EquipSR02");
		this.Equip01d = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d");
		this.EquipCR05 = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03R").getChild("EquipCR01").getChild("EquipCR02").getChild("EquipCR03").getChild("EquipCR04").getChild("EquipCR05");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.ShoeR01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoeR01");
		this.Equip01c = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c");
		this.Equip02a = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip02a");
		this.EarR03 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("EarR01").getChild("EarR02").getChild("EarR03");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.EquipCL01 = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03L").getChild("EquipCL01");
		this.EquipCL05 = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03L").getChild("EquipCL01").getChild("EquipCL02").getChild("EquipCL03").getChild("EquipCL04").getChild("EquipCL05");
		this.EquipSR01 = root.getChild("BodyMain").getChild("EquipSR01");
		this.Equip00 = root.getChild("BodyMain").getChild("Equip00");
		this.EquipSL01 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00").getChild("EquipSL01");
		this.Equip01a = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a");
		this.ShoeR00 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoeR00");
		this.ShoeL01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoeL01");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.EquipCR03 = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03R").getChild("EquipCR01").getChild("EquipCR02").getChild("EquipCR03");
		this.EquipSL00 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00");
		this.EarL01 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("EarL01");
		this.EquipCR04 = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03R").getChild("EquipCR01").getChild("EquipCR02").getChild("EquipCR03").getChild("EquipCR04");
		this.EquipCL02 = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03L").getChild("EquipCL01").getChild("EquipCL02");
		this.Equip02b = root.getChild("GlowBodyMain").getChild("GlowEquip00").getChild("GlowEquip01a").getChild("GlowEquip02a").getChild("Equip02b");
		this.ShoeL00 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoeL00");
		this.ArmLeft02a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft02a");
		this.EquipCL03 = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03L").getChild("EquipCL01").getChild("EquipCL02").getChild("EquipCL03");
		this.EarR02 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("EarR01").getChild("EarR02");
		this.EquipSL00a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00").getChild("EquipSL00a");
		this.Equip03L = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03L");
		this.EquipCR01 = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03R").getChild("EquipCR01");
		this.EyeMask = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EyeMask");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.ShoeL02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoeL01").getChild("ShoeL02");
		this.Equip02c = root.getChild("GlowBodyMain").getChild("GlowEquip00").getChild("GlowEquip01a").getChild("GlowEquip02a").getChild("Equip02b").getChild("Equip02c");
		this.EarR01 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("EarR01");
		this.ShoeR02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoeR01").getChild("ShoeR02");
		this.EquipCL04 = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03L").getChild("EquipCL01").getChild("EquipCL02").getChild("EquipCL03").getChild("EquipCL04");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.EquipSL03a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00").getChild("EquipSL01").getChild("EquipSL02").getChild("EquipSL03").getChild("EquipSL03a");
		this.BodyMain = root.getChild("BodyMain");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.EquipSR03 = root.getChild("BodyMain").getChild("EquipSR01").getChild("EquipSR02").getChild("EquipSR03");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.GlowEquip00 = root.getChild("GlowBodyMain").getChild("GlowEquip00");
		this.GlowEquip01a = root.getChild("GlowBodyMain").getChild("GlowEquip00").getChild("GlowEquip01a");
		this.GlowEquip02a = root.getChild("GlowBodyMain").getChild("GlowEquip00").getChild("GlowEquip01a").getChild("GlowEquip02a");
		this.offsetItem = new float[] {0.06F, 1.07F, -0.06F};
		this.offsetBlock = new float[] {0.06F, 1.07F, -0.06F};
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
		this.Equip00.visible = !(flag);
		this.GlowEquip00.visible = !(flag);
				
		flag = !EmotionHelper.checkModelState(1, state);	//head
		this.EarL01.visible = !(flag);
		this.EarR01.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);	//sword
		this.EquipSL00.visible = !(flag);
		this.EquipSR01.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(3, state);	//eye mask
		this.EyeMask.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(4, state);	//shoes
		this.ShoeL02.visible = !(flag);
		this.ShoeR02.visible = !(flag);
	
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

this.animTransX += (0F); this.animTransY += (0.53F + 0.26F * ent.getScaleLevel()); this.animTransZ += (0F);
		this.setFaceHungry(ent);

		//body
		this.Ahoke.xRot = 0.20943951023931953F;
		this.Ahoke.yRot = 0.6981317007977318F;
		this.Ahoke.zRot = 0.0F;
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
	  	this.Skirt01.xRot = 0F;
	  	this.Skirt01.y = (2.9F) + (0F) * 16F;
		this.Skirt02.xRot = -0.08726646259971647F;
		this.Skirt02.yRot = 0.0F;
		this.Skirt02.zRot = 0.0F;
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
		//leg
		this.LegLeft01.xRot = -0.6981317007977318F;
		this.LegLeft01.yRot = -0.6981317007977318F;
		this.LegLeft01.zRot = -0.2617993877991494F;
		this.LegLeft02.xRot = 1.5707963267948966F;
		this.LegLeft02.yRot = 0.0F;
		this.LegLeft02.zRot = 0.0F;
		this.LegLeft02.x = (3F) + (0F) * 16F;
		this.LegLeft02.y = (14F) + (0F) * 16F;
		this.LegLeft02.z = (-3F) + (0F) * 16F;
		this.LegRight01.xRot = 0.0F;
		this.LegRight01.yRot = -0.7853981633974483F;
		this.LegRight01.zRot = -0.5759586531581287F;
		this.LegRight02.xRot = 1.3089969389957472F;
		this.LegRight02.yRot = 0.0F;
		this.LegRight02.zRot = 0.0F;
		this.LegRight02.x = (-3F) + (0F) * 16F;
		this.LegRight02.y = (14F) + (0F) * 16F;
		this.LegRight02.z = (-3F) + (0F) * 16F;
		//equip
		this.EquipSL00.visible = false;
		this.Equip00.xRot = 0.08726646259971647F;
		this.Equip00.yRot = 0.0F;
		this.Equip00.zRot = 0.0F;
		this.EquipSR01.xRot = -0.1F;
		this.EquipSR01.yRot = -0.13962634015954636F;
		this.EquipSR01.zRot = -0.13962634015954636F;
		this.EarL01.xRot = 0.6F;
		this.EarL01.yRot = -0.17453292519943295F;
		this.EarL01.zRot = -0.08726646259971647F;
		this.EarR01.xRot = 0.6F;
		this.EarR01.yRot = 0.17453292519943295F;
		this.EarR01.zRot = 0.08726646259971647F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F + f * 0.25F);
  		float angleX1 = Mth.cos(f2*0.1F + 0.3F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
  		float addk1 = 0;
  		float addk2 = 0;
  		float headX = 0F;
  		float headZ = 0F;
  		float t2 = ent.getTickExisted() & 511;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}

    	//leg move
  		addk1 = angleAdd1 * 0.5F - 0.28F;  //LegLeft01
	  	addk2 = angleAdd2 * 0.5F - 0.21F;  //LegRight01
    	
  	    //head
	  	this.Head.xRot = f4 * 0.014F;
	  	this.Head.yRot = f3 * 0.01F;
	    //boob
  	    this.BoobL.xRot = angleX * 0.06F - 0.8F;
  	    this.BoobR.xRot = angleX * 0.06F - 0.8F;
	  	//body
  	    this.Ahoke.yRot = angleX * 0.25F + 0.7F;
	  	this.BodyMain.xRot = -0.1047F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.35F;
	  	this.Skirt01.xRot = -0.14F;
	  	this.Skirt02.xRot = -0.09F;
	  	this.Skirt02.y = (2.8F) + (0F) * 16F;
	    //arm 
	  	this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.2F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = angleX * 0.03F - 0.25F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    this.ArmRight01.xRot = 0F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -angleX * 0.03F + 0.25F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.0873F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (3F) + (0F) * 16F;
		this.LegLeft02.z = (-3F) + (0F) * 16F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.0873F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.x = (-3F) + (0F) * 16F;
		this.LegRight02.y = (14F) + (0F) * 16F;
		this.LegRight02.z = (-3F) + (0F) * 16F;
		//equip
		this.EquipSL00.xRot = -1.57F;
		this.EquipSL00.yRot = -0.14F;
		this.EquipSL00.zRot = 1.57F;
		this.EquipSR01.xRot = 1.3F;
		this.EquipCL02.xRot = f4 * 0.008F + 0.7F;
		this.EquipCR02.xRot = f4 * 0.008F + 0.7F;
		this.EquipCL04.xRot = f4 * 0.008F;
		this.EquipCR04.xRot = f4 * 0.008F;
		this.EarL01.xRot = angleX * 0.1F + 0.0873F;
		this.EarR01.xRot = angleX * 0.1F + 0.0873F;
		
		float modf2 = f2 % 128F;
		if (modf2 < 6F)
		{
			//total 3 ticks, loop twice in 6 ticks
			if (modf2 >= 3F) modf2 -= 3F;
			float anglef2 = Mth.sin(modf2 * 1.0472F) * 0.08F;
			this.EarL01.zRot = -anglef2 - 0.0873F;
			this.EarR01.zRot = anglef2 + 0.0873F;
		}
		else
		{
			this.EarL01.zRot = -0.0873F;
			this.EarR01.zRot = 0.0873F;
		}
		
		//special stand pos
		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		{
			if (t2 > 180)
			{
				//arm
				this.ArmLeft01.xRot = 0.44F;
				this.ArmLeft01.yRot = -0.14F;
				this.ArmLeft01.zRot = -0.52F;
				this.ArmRight01.xRot = -0.17F;
				this.ArmRight01.yRot = 0F;
				this.ArmRight01.zRot = 0.7F;
				this.ArmRight02.zRot = -1.22F;
				//leg
		  		addk1 = angleAdd1 * 0.5F - 0.35F;  //LegLeft01
			  	addk2 = angleAdd2 * 0.5F - 0.09F;  //LegRight01
			  	
			  	if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED)
			  	{
					//arm
					this.ArmLeft01.xRot = -1.4F;
					this.ArmLeft01.yRot = -1.4F;
					this.ArmLeft01.zRot = 0.87F;
					this.ArmLeft02.xRot = -2.1F;
					this.ArmLeft02.z = (2.5F) + (-0.32F) * 16F;
					//equip
					this.EquipSL00.xRot = -1.83F;
					this.EquipSL00.yRot = 0.35F;
					this.EquipSL00.zRot = 1.57F;
			  	}
			}
			else
			{
				this.setFace(8);
				//body
				this.BodyMain.xRot = -0.44F;
				this.Head.xRot = 0.52F;
				this.Head.yRot = 0F;
				this.Head.zRot = 0F;
				//arm
				this.ArmLeft01.xRot = -1.05F;
				this.ArmLeft01.yRot = -1.05F;
				this.ArmLeft01.zRot = 1.4F;
				this.ArmLeft02.zRot = 2.1F;
				this.ArmLeft02.x = (3.0F) + (-0.32F) * 16F;
				this.ArmLeft02.z = (2.5F) + (0F) * 16F;
				this.ArmRight01.xRot = -1.57F;
				this.ArmRight01.yRot = -1.31F;
				this.ArmRight01.zRot = 1.22F;
				this.ArmRight02.xRot = -0.96F;
				//leg
		  		addk1 = angleAdd1 * 0.5F + 0.4F;	//LegLeft01
			  	addk2 = angleAdd2 * 0.5F + 0.09F;	//LegRight01
			  	this.LegLeft01.yRot = 0F;
			  	this.LegLeft01.zRot = f1 > 0.1F ? 0.05F : 0.26F;
			  	this.LegRight01.yRot = 0F;
			  	this.LegRight01.zRot = f1 > 0.1F ? -0.05F : -0.26F;
			  	//skirt
			  	this.Skirt01.xRot = 0F;
			  	this.Skirt02.xRot = 0.09F;
			  	//equip
			  	this.EquipSL00.visible = false;
			}
		}

	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {
	    	//奔跑動作
this.animTransX += (0F); this.animTransY += (this.scale * 0.1F); this.animTransZ += (0F);
	    	//body
	 	    this.Head.xRot -= 0.6F;
	 	    this.BodyMain.xRot = 0.9F;
	 	    this.Butt.xRot -= 0.7F;
	 	    this.Skirt01.xRot = -0.15F;
	 	  	this.Skirt02.xRot = -0.32F;
	 	  	//arm
	    	this.ArmLeft01.xRot = 0.7F;
	    	this.ArmLeft01.yRot = -1.1F;
	    	this.ArmLeft01.zRot = -1F;
		    this.ArmRight01.xRot = 0.7F;
	    	this.ArmRight01.yRot = 1.1F;
	    	this.ArmRight01.zRot = 1F;
		  	if (!this.EquipSR01.visible)
		  	{
		  		this.ArmRight02.zRot = 0F;
		  	}
		  	else if (t2 > 300)
		  	{
		  		this.ArmRight02.zRot = -1.1F;
		  	}
	    	//leg
	  		addk1 = angleAdd1 * 1F - 0.28F;  //LegLeft01
		  	addk2 = angleAdd2 * 1F - 0.21F;  //LegRight01
		  	//equip
		  	this.EquipSR01.xRot = 0.7F;
  		}
	    
	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {
	    	//潛行, 蹲下動作
this.animTransX += (0F); this.animTransY += (this.scale * 0.06F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 1.0472F;
		  	this.BodyMain.xRot = 1.0472F;
		  	this.Butt.xRot = -0.4F;
		  	this.Skirt01.xRot = -0.12F;
		  	this.Skirt02.xRot = -0.16F;
		  	this.Skirt02.y = (2.8F) + (-0.1F) * 16F;
		    //arm
		  	if (!this.EquipSL00.visible)
		  	{
		  		this.ArmLeft01.xRot = -0.6F;
			    this.ArmLeft01.zRot = 0.2618F;
			    this.ArmRight01.xRot = -0.6F;
			    this.ArmRight01.zRot = -0.2618F;
		  	}
		  	else
		  	{
		  		this.ArmLeft01.xRot = angleAdd2 * 0.25F - 0.1F;
		    	this.ArmLeft01.yRot = -0.7F;
		    	this.ArmLeft01.zRot = -0.3F;
			    this.ArmRight01.xRot = angleAdd1 * 0.25F - 0.1F;
		    	this.ArmRight01.yRot = 0.7F;
		    	this.ArmRight01.zRot = 0.3F;
		  	}
		    //leg
		    addk1 -= 0.4F;
		    addk2 -= 0.4F;
		    //equip
		    this.EquipSR01.xRot = 0F;
  		}//end if sneaking
  		
	    //坐下動作
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
this.animTransX += (0F); this.animTransY += (0.41F); this.animTransZ += (0F);
		    	//body
		    	this.BodyMain.xRot = 0.7F;
		    	this.Butt.xRot = -0.79F;
		    	this.Head.xRot -= 1.2F;
		    	//arm
			  	if (this.EquipSL00.visible && ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED)
			  	{
					//arm
					this.ArmLeft01.xRot = -2.44F;
					this.ArmLeft01.yRot = 1.05F;
					this.ArmLeft01.zRot = 2.44F;
					this.ArmLeft02.xRot = 0F;
					this.ArmLeft02.zRot = 1.92F;
					this.ArmLeft02.x = (3.0F) + (-0.32F) * 16F;
					this.ArmLeft02.z = (2.5F) + (0F) * 16F;
				    this.ArmRight01.xRot = -1.13F;
			    	this.ArmRight01.yRot = 0.44F;
			    	this.ArmRight01.zRot = 0.52F;
			    	this.ArmRight02.xRot = 0F;
			    	this.ArmRight02.zRot = -0.52F;
					//equip
					this.EquipSL00.xRot = -0.3F;
					this.EquipSL00.yRot = -0.22F;
					this.EquipSL00.zRot = 1.77F;
					this.EquipSR01.xRot = 0.81F;
			  	}
			  	else
			  	{
			  		this.ArmLeft01.xRot = -1.13F;
			    	this.ArmLeft01.yRot = -0.44F;
			    	this.ArmLeft01.zRot = -0.52F;
			    	this.ArmLeft02.xRot = 0F;
			    	this.ArmLeft02.zRot = 0.52F;
					this.ArmLeft02.x = (3.0F) + (0F) * 16F;
					this.ArmLeft02.z = (2.5F) + (0F) * 16F;
				    this.ArmRight01.xRot = -1.13F;
			    	this.ArmRight01.yRot = 0.44F;
			    	this.ArmRight01.zRot = 0.52F;
			    	this.ArmRight02.xRot = 0F;
			    	this.ArmRight02.zRot = -0.52F;
					//equip
					this.EquipSL00.xRot = -0.2F;
					this.EquipSL00.yRot = -0.1F;
					this.EquipSL00.zRot = 1.4F;
					this.EquipSR01.xRot = 0.81F;
			  	}
			  	
		    	//leg
		    	addk1 = -2.1F;
		    	addk2 = -2.1F;
		    	this.LegLeft01.yRot = -0.58F;
		    	this.LegLeft01.zRot = 0.05F;
		    	this.LegLeft02.xRot = 2.44F;
		    	this.LegLeft02.z = (-3F) + (0.38F) * 16F;
		    	this.LegRight01.yRot = 0.58F;
		    	this.LegRight01.zRot = -0.05F;
		    	this.LegRight02.xRot = 2.44F;
		    	this.LegRight02.z = (-3F) + (0.38F) * 16F;
			  	//skirt
			  	this.Skirt01.xRot = -0.17F;
			  	this.Skirt02.xRot = -0.26F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.46F); this.animTransZ += (0F);
		    	//body
			  	this.BodyMain.xRot = 0.08726646259971647F;
			  	this.Butt.xRot = -0.17453292519943295F;
		    	this.Head.xRot -= 0.2F;
		    	//arm
			  	this.ArmLeft01.xRot = 0.2617993877991494F;
			  	this.ArmLeft01.yRot = 0.0F;
			  	this.ArmLeft01.zRot = -0.2617993877991494F;
			  	this.ArmLeft02.xRot = 0F;
			  	this.ArmLeft02.yRot = 0F;
			  	this.ArmLeft02.zRot = 0F;
				this.ArmLeft02.x = (3.0F) + (0F) * 16F;
				this.ArmLeft02.z = (2.5F) + (0F) * 16F;
			  	this.ArmRight01.xRot = -1.1344640137963142F;
			  	this.ArmRight01.yRot = 0.0F;
			  	this.ArmRight01.zRot = 0.0F;
			  	this.ArmRight02.xRot = 0.0F;
			  	this.ArmRight02.zRot = -1.2217304763960306F;
		    	//leg
		    	addk1 = -1.45F;
		    	addk2 = -2.1F;
			  	this.LegLeft01.xRot = -1.4486232791552935F;
			  	this.LegLeft01.yRot = 0.08726646259971647F;
			  	this.LegLeft01.zRot = 0.0F;
		    	this.LegLeft02.xRot = 0F;
		    	this.LegLeft02.zRot = 0F;
		    	this.LegRight01.xRot = -2.0943951023931953F;
		    	this.LegRight01.yRot = 0.091106186954104F;
		    	this.LegRight01.zRot = 0.17453292519943295F;
		    	this.LegRight02.xRot = 1.3962634015954636F;
		    	this.LegRight02.zRot = 0.0F;
			  	//skirt
			  	this.Skirt01.xRot = -0.17F;
			  	this.Skirt02.xRot = -0.26F;
			  	//equip
			  	this.EquipSL00.xRot = -1.6755160819145563F;
			  	this.EquipSL00.yRot = 0.17453292519943295F;
			  	this.EquipSL00.zRot = 0.8726646259971648F;
			  	this.EquipSR01.xRot = 1.3089969389957472F;
			  	this.EquipSR01.yRot = -0.13962634015954636F;
			  	this.EquipSR01.zRot = -0.13962634015954636F;
	    	}
  		}//end if sitting
	    
	    //攻擊動作: 設為30~50會有揮刀動作, 設為100則沒有揮刀動作
	    if (ent.getAttackTick() > 30)
	    {
	    	//reset attack tick
	    	if (ent.getAttackTick() == 60) ent.setAttackTick(0);
this.animTransX += (0F); this.animTransY += (0.22F + ent.getScaleLevel() * 0.12F); this.animTransZ += (0F);
	    	//body
	    	this.Head.xRot = -0.4363323129985824F;
	    	this.Head.yRot = 0.0F;
	    	this.Head.zRot = 0.0F;
	    	this.BodyMain.xRot = 1.0471975511965976F;
	    	this.BodyMain.yRot = 0.2617993877991494F;
	    	this.BodyMain.zRot = 0.0F;
	    	this.Butt.xRot = -0.5235987755982988F;
	    	this.Butt.yRot = 0.0F;
	    	this.Butt.zRot = 0.0F;
	    	//arm
	    	this.ArmLeft01.xRot = -0.7853981633974483F;
	    	this.ArmLeft01.yRot = 0.2617993877991494F;
	    	this.ArmLeft01.zRot = 0.5235987755982988F;
	    	this.ArmLeft02.xRot = 0.0F;
	    	this.ArmLeft02.yRot = 0.0F;
	    	this.ArmLeft02.zRot = 0.7853981633974483F;
			this.ArmLeft02.x = (3.0F) + (0F) * 16F;
			this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    	this.ArmRight01.xRot = 0.5235987755982988F;
	    	this.ArmRight01.yRot = -0.3490658503988659F;
	    	this.ArmRight01.zRot = 0.17453292519943295F;
	    	this.ArmRight02.xRot = -1.3089969389957472F;
	    	this.ArmRight02.yRot = 0.0F;
	    	this.ArmRight02.zRot = 0.0F;
			this.ArmRight02.x = (-3.0F) + (0F) * 16F;
			this.ArmRight02.z = (2.5F) + (0F) * 16F;
	    	//leg
	    	addk1 = 0.31F;
	    	addk2 = -1.57F;
	    	this.LegLeft01.yRot = -0.17453292519943295F;
	    	this.LegLeft01.zRot = 0.08726646259971647F;
	    	this.LegLeft02.xRot = 0.13F;
	    	this.LegLeft02.yRot = 0.0F;
	    	this.LegLeft02.zRot = 0.0F;
			this.LegLeft02.x = (3F) + (0F) * 16F;
			this.LegLeft02.z = (-3F) + (0F) * 16F;
	    	this.LegRight01.yRot = 0.0F;
	    	this.LegRight01.zRot = 0.13962634015954636F;
	    	this.LegRight02.xRot = 1.2292353921796064F;
	    	this.LegRight02.yRot = 0.0F;
	    	this.LegRight02.zRot = 0.0F;
			this.LegRight02.x = (-3F) + (0F) * 16F;
			this.LegRight02.z = (-3F) + (0F) * 16F;
	    	//equip
			this.EquipSL00.visible = true;
	    	this.EquipSR01.xRot = 0.8651597102135892F;
	    	this.EquipSR01.yRot = -0.13962634015954636F;
	    	this.EquipSR01.zRot = -0.13962634015954636F;
	    	this.EquipSL00.xRot = 1.593485607070823F;
	    	this.EquipSL00.yRot = 0.18203784098300857F;
	    	this.EquipSL00.zRot = 1.5707963267948966F;
	    	
	    	//swing sword
	    	if (ent.getAttackTick() < 51)
	    	{
		    	if (ent.getAttackTick() > 45)
		    	{
			    	int tick = 4 - (ent.getAttackTick() - 46);
			    	float parTick = f2 - (int)f2 + tick;
		    		//arm
		    		this.ArmLeft01.xRot = -0.785F - 0.644F * parTick;
		    		this.ArmLeft02.zRot = 0.785F - 0.157F * parTick;
			    	//equip
			    	this.EquipSL00.yRot = 0.182F + 0.278F * parTick;
		    	}
		    	else
		    	{
		    		//arm
		    		this.ArmLeft01.xRot = -4.1F;
		    		this.ArmLeft02.zRot = 0F;
			    	//equip
			    	this.EquipSL00.yRot = 1.57F;
		    	}
	    	}
	    	
	    	//final attack
	    	if (ent.getStateEmotion(ID.S.Phase) == 3)
	    	{
	    		//body
		    	this.BodyMain.xRot = 2.1F;
		    	//arm
		    	this.ArmLeft01.xRot = -1.92F;
		    	this.ArmLeft01.yRot = 0.4F;
		    	this.ArmLeft01.zRot = 0.26F;
		    	this.ArmLeft02.zRot = 0F;
		    	this.ArmRight01.xRot = -1.92F;
		    	this.ArmRight01.yRot = -0.4F;
		    	this.ArmRight01.zRot = 0.26F;
		    	this.ArmRight02.xRot = 0F;
		    	//equip
		    	this.EquipSL00.xRot = -1.4F;
		    	this.EquipSL00.yRot = -0.14F;
		    	this.EquipSL00.zRot = 1.57F;
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
    		scale = 1.64F;
        	offsetY = -0.58F;
		break;
    	case 2:
    		scale = 1.23F;
        	offsetY = -0.27F;
		break;
    	case 1:
    		scale = 0.82F;
        	offsetY = 0.35F;
		break;
    	default:
    		scale = 0.41F;
        	offsetY = 2.17F;
		break;
    	}
    	
    	
    	RenderHelper.animScale(this, scale, scale, scale);
this.animTransX += (0F); this.animTransY += (offsetY); this.animTransZ += (0F);
    	
    	//main body
		super.setupAnim(entity, f, f1, f2, f3, f4);
	}

}

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

public class ModelDestroyerInazuma<T extends Entity> extends ShipModelBaseAdv<T>
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
	public ModelPart Hair02;
	public ModelPart ArmLeft02;
	public ModelPart ArmLeft03;
	public ModelPart ArmRight02;
	public ModelPart ArmRight03;
	public ModelPart Cloth02;
	public ModelPart EquipMain01;
	public ModelPart EquipC01;
	public ModelPart EquipMain02;
	public ModelPart EquipMain03;
	public ModelPart EquipMain04;
	public ModelPart EquipTL02;
	public ModelPart EquipTL02_1;
	public ModelPart EquipHead01;
	public ModelPart EquipHead02;
	public ModelPart EquipHead03;
	public ModelPart EquipHead04;
	public ModelPart EquipHead05;
	public ModelPart EquipTL02a;
	public ModelPart EquipTL02b;
	public ModelPart EquipTL02c;
	public ModelPart EquipTL03;
	public ModelPart EquipTL02d;
	public ModelPart EquipTL02e;
	public ModelPart EquipTL02f;
	public ModelPart EquipTL02a_1;
	public ModelPart EquipTL02b_1;
	public ModelPart EquipTL02c_1;
	public ModelPart EquipTL03_1;
	public ModelPart EquipTL02d_1;
	public ModelPart EquipTL02e_1;
	public ModelPart EquipTL02f_1;
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
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -11.8F, -1.0F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -12.5F, -2.8F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 8.7F, 6.2F, 0.136659280431156F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-3.5F, -9.0F, 0.0F, 7.0F, 14.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -5.4F, 3.5F, -0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef5 = partdef1.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 12.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.3F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -11F, -7F, 0.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(-1.0F, -6F, -6F, 1.0471975511965976F, 1.0471975511965976F, 0.0F));
		PartDefinition partdef7 = partdef5.addOrReplaceChild("HairR01", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-8.0F, 2.0F, -6.7F, -0.05235987755982988F, 0.08726646259971647F, -0.13962634015954636F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("HairR02", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(0.1F, 7.5F, 0.0F, 0.08726646259971647F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef9 = partdef5.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -7.0F));
		PartDefinition partdef10 = partdef5.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(8.0F, 2.0F, -6.7F, -0.05235987755982988F, -0.08726646259971647F, 0.13962634015954636F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-0.1F, 7.5F, 0.0F, 0.08726646259971647F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef12 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.0F, 0.0F, 0.0F, 14.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -4.0F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F), PartPose.offsetAndRotation(-4.4F, 5.5F, 3.2F, -0.06981317007977318F, 0.0F, -0.10471975511965977F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(3.0F, 12.0F, -3.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("LegRight03", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 5.0F, 7.0F), PartPose.offset(-3.0F, 8.0F, 2.9F));
		PartDefinition partdef16 = partdef12.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 6.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 1.7F, -0.4F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 3.5F, -0.4F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef12.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F), PartPose.offsetAndRotation(4.4F, 5.5F, 3.2F, -0.12217304763960307F, 0.0F, 0.10471975511965977F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(-3.0F, 12.0F, -3.0F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("LegLeft03", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 5.0F, 7.0F), PartPose.offset(3.0F, 8.0F, 2.9F));
		PartDefinition partdef21 = partdef0.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, -1.0F, 0.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("EquipC01", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F), PartPose.offset(-7.0F, -11.0F, 9.0F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("EquipC02", CubeListBuilder.create().addBox(-3.5F, -3.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(-2.0F, 0.5F, 0.0F, -0.17453292519943295F, 0.6283185307179586F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("EquipC05a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 6.0F), PartPose.offset(1.5F, -3.0F, 0.0F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("EquipC05b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -10.0F, 1.0F, 1.0F, 10.0F), PartPose.offset(0.0F, 0.0F, -6.0F));
		PartDefinition partdef26 = partdef23.addOrReplaceChild("EquipC03", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 5.0F), PartPose.offset(0.0F, -5.0F, -2.0F));
		PartDefinition partdef27 = partdef23.addOrReplaceChild("EquipC04a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -6.0F, 2.0F, 2.0F, 6.0F), PartPose.offset(-1.5F, -3.0F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("EquipC04b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -10.0F, 1.0F, 1.0F, 10.0F), PartPose.offset(0.0F, 0.0F, -6.0F));
		PartDefinition partdef29 = partdef21.addOrReplaceChild("EquipMain01", CubeListBuilder.create().addBox(-5.5F, -1.0F, 0.0F, 11.0F, 9.0F, 12.0F), PartPose.offset(0.0F, -4.0F, 5.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("EquipMain03", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 9.5F, 9.0F, 0.5009094953223726F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("EquipHead01", CubeListBuilder.create().addBox(0.0F, -1.5F, -12.0F, 2.0F, 3.0F, 18.0F), PartPose.offsetAndRotation(0.0F, 6.5F, -0.5F, 3.141592653589793F, -1.8325957145940461F, -1.5707963267948966F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("EquipHead02", CubeListBuilder.create().addBox(-1.5F, -7.0F, 0.0F, 3.0F, 14.0F, 3.0F), PartPose.offset(1.0F, 0.0F, -15.0F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("EquipHead05", CubeListBuilder.create().addBox(-1.0F, -5.0F, 0.0F, 2.0F, 10.0F, 2.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition partdef34 = partdef32.addOrReplaceChild("EquipHead04", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -4.8F, 2.5F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef35 = partdef32.addOrReplaceChild("EquipHead03", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 4.8F, 2.5F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef36 = partdef29.addOrReplaceChild("EquipMain02", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 7.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 7.7F, 0.6F, 0.6283185307179586F, 0.0F, 0.0F));
		PartDefinition partdef37 = partdef29.addOrReplaceChild("EquipTL02", CubeListBuilder.create().addBox(0.0F, -4.0F, -9.0F, 3.0F, 8.0F, 12.0F), PartPose.offsetAndRotation(5.5F, 6.0F, 4.5F, 0.13962634015954636F, -0.06981317007977318F, 0.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("EquipTL03", CubeListBuilder.create().addBox(0.0F, 0.0F, -8.0F, 1.0F, 24.0F, 7.0F), PartPose.offsetAndRotation(3.0F, -12.0F, 3.0F, 0.0F, -0.3490658503988659F, -0.08726646259971647F));
		PartDefinition partdef39 = partdef37.addOrReplaceChild("EquipTL02f", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(1.3F, 2.3F, 3.0F));
		PartDefinition partdef40 = partdef37.addOrReplaceChild("EquipTL02b", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 10.0F), PartPose.offset(1.3F, -2.3F, -18.8F));
		PartDefinition partdef41 = partdef37.addOrReplaceChild("EquipTL02a", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F), PartPose.offset(1.3F, 0.0F, -19.8F));
		PartDefinition partdef42 = partdef37.addOrReplaceChild("EquipTL02c", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 10.0F), PartPose.offset(1.3F, 2.3F, -18.8F));
		PartDefinition partdef43 = partdef37.addOrReplaceChild("EquipTL02d", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(1.3F, -2.3F, 3.0F));
		PartDefinition partdef44 = partdef37.addOrReplaceChild("EquipTL02e", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(1.3F, 0.0F, 2.5F));
		PartDefinition partdef45 = partdef29.addOrReplaceChild("EquipMain04", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 16.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -16.5F, 9.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef46 = partdef29.addOrReplaceChild("EquipTL02_1", CubeListBuilder.create().addBox(-3.0F, -4.0F, -9.0F, 3.0F, 8.0F, 12.0F), PartPose.offsetAndRotation(-5.5F, 6.0F, 4.5F, 0.13962634015954636F, 0.06981317007977318F, 0.0F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("EquipTL02b_1", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 10.0F), PartPose.offset(-1.3F, -2.3F, -18.8F));
		PartDefinition partdef48 = partdef46.addOrReplaceChild("EquipTL02d_1", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-1.3F, -2.3F, 3.0F));
		PartDefinition partdef49 = partdef46.addOrReplaceChild("EquipTL02c_1", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 10.0F), PartPose.offset(-1.3F, 2.3F, -18.8F));
		PartDefinition partdef50 = partdef46.addOrReplaceChild("EquipTL02f_1", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-1.3F, 2.3F, 3.0F));
		PartDefinition partdef51 = partdef46.addOrReplaceChild("EquipTL02a_1", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F), PartPose.offset(-1.3F, 0.0F, -19.8F));
		PartDefinition partdef52 = partdef46.addOrReplaceChild("EquipTL03_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -8.0F, 1.0F, 24.0F, 7.0F), PartPose.offsetAndRotation(-3.0F, -12.0F, 3.0F, 0.0F, 0.3490658503988659F, 0.08726646259971647F));
		PartDefinition partdef53 = partdef46.addOrReplaceChild("EquipTL02e_1", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-1.3F, 0.0F, 2.5F));
		PartDefinition partdef54 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-7.0F, 0.0F, -4.4F, 14.0F, 7.0F, 8.0F), PartPose.offset(0.0F, -11.6F, 0.0F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("Cloth02", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 10.0F, 0.0F), PartPose.offset(0.0F, 4.8F, -4.3F));
		PartDefinition partdef56 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-2.5F, -1.0F, -3.0F, 6.0F, 11.0F, 6.0F), PartPose.offsetAndRotation(7.3F, -9.4F, -0.7F, -0.2792526803190927F, 0.0F, 0.2792526803190927F));
		PartDefinition partdef57 = partdef56.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-6.0F, 0.0F, -6.0F, 6.0F, 8.0F, 6.0F), PartPose.offset(3.5F, 10.0F, 3.0F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("ArmLeft03", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(-3.0F, 6.0F, -3.0F));
		PartDefinition partdef59 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.5F, -1.0F, -3.0F, 6.0F, 11.0F, 6.0F), PartPose.offsetAndRotation(-7.3F, -9.4F, -0.7F, -0.2792526803190927F, 0.0F, -0.2792526803190927F));
		PartDefinition partdef60 = partdef59.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0.0F, 0.0F, -6.0F, 6.0F, 8.0F, 6.0F), PartPose.offset(-3.5F, 10.0F, 3.0F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("ArmRight03", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offset(3.0F, 6.0F, -3.0F));
		PartDefinition partdef62 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 0.0F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -11.8F, -1.0F));
		PartDefinition partdef64 = partdef63.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef65 = partdef63.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef66 = partdef63.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef67 = partdef63.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef68 = partdef63.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef69 = partdef63.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef70 = partdef63.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef71 = partdef63.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef72 = partdef63.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef73 = partdef63.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelDestroyerInazuma(ModelPart root)
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
		this.EquipMain03 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain03");
		this.EquipC02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipC01").getChild("EquipC02");
		this.Cloth02 = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth02");
		this.EquipMain02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain02");
		this.EquipTL02b_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02_1").getChild("EquipTL02b_1");
		this.HairMain = root.getChild("BodyMain").getChild("Head").getChild("HairMain");
		this.EquipTL03 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02").getChild("EquipTL03");
		this.EquipC05a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipC01").getChild("EquipC02").getChild("EquipC05a");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.EquipTL02f = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02").getChild("EquipTL02f");
		this.ArmRight03 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03");
		this.EquipC01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipC01");
		this.EquipTL02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02");
		this.EquipHead01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain03").getChild("EquipHead01");
		this.EquipC03 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipC01").getChild("EquipC02").getChild("EquipC03");
		this.Head = root.getChild("BodyMain").getChild("Head");
		this.LegRight03 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("LegRight03");
		this.Hair01 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.EquipHead05 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain03").getChild("EquipHead01").getChild("EquipHead02").getChild("EquipHead05");
		this.EquipMain04 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain04");
		this.LegLeft03 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("LegLeft03");
		this.HairL02 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.Ahoke = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.EquipBase = root.getChild("BodyMain").getChild("EquipBase");
		this.Hair02 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.ArmLeft03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03");
		this.HairR02 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.EquipTL02d_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02_1").getChild("EquipTL02d_1");
		this.HairR01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairR01");
		this.BodyMain = root.getChild("BodyMain");
		this.EquipTL02c_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02_1").getChild("EquipTL02c_1");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.EquipTL02b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02").getChild("EquipTL02b");
		this.EquipMain01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01");
		this.EquipTL02f_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02_1").getChild("EquipTL02f_1");
		this.EquipTL02a_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02_1").getChild("EquipTL02a_1");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.HairU01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairU01");
		this.EquipTL02a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02").getChild("EquipTL02a");
		this.EquipC04a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipC01").getChild("EquipC02").getChild("EquipC04a");
		this.EquipHead04 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain03").getChild("EquipHead01").getChild("EquipHead02").getChild("EquipHead04");
		this.EquipC04b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipC01").getChild("EquipC02").getChild("EquipC04a").getChild("EquipC04b");
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.Hair = root.getChild("BodyMain").getChild("Head").getChild("Hair");
		this.EquipC05b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipC01").getChild("EquipC02").getChild("EquipC05a").getChild("EquipC05b");
		this.EquipTL02c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02").getChild("EquipTL02c");
		this.EquipHead02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain03").getChild("EquipHead01").getChild("EquipHead02");
		this.EquipTL02d = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02").getChild("EquipTL02d");
		this.EquipTL03_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02_1").getChild("EquipTL03_1");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.EquipTL02_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02_1");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.HairL01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairL01");
		this.EquipHead03 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipMain03").getChild("EquipHead01").getChild("EquipHead02").getChild("EquipHead03");
		this.EquipTL02e_1 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02_1").getChild("EquipTL02e_1");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.EquipTL02e = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMain01").getChild("EquipTL02").getChild("EquipTL02e");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowHead");
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

this.animTransX += (0F); this.animTransY += (0.51F + 0.24F * ent.getScaleLevel()); this.animTransZ += (0F);
    	this.setFaceHungry(ent);
    	
		//body
    	this.Head.xRot = 0F;
    	this.Head.yRot = 0F;
    	this.Head.zRot = 0F;
    	this.Ahoke.yRot = 0.5236F;
    	this.BodyMain.xRot = 1.55F;
    	this.Butt.xRot = 0.21F;
    	this.Butt.y = (3.0F) + (0F) * 16F;
	  	this.Skirt01.xRot = -0.052F;
	  	this.Skirt01.y = (1.7F) + (0F) * 16F;
	  	this.Skirt02.xRot = -0.052F;
	  	this.Skirt02.y = (3.5F) + (0F) * 16F;
    	//arm
    	this.ArmLeft01.xRot = -3F;
    	this.ArmLeft01.yRot = 0F;
    	this.ArmLeft01.zRot = 0.3F;
    	this.ArmRight01.xRot = -3F;
    	this.ArmRight01.yRot = 0F;
    	this.ArmRight01.zRot = -0.3F;
    	this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.x = (3.5F) + (0F) * 16F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.x = (-3.5F) + (0F) * 16F;
    	//leg
    	this.LegLeft01.xRot = -0.2618F;
    	this.LegLeft01.yRot = 0F;
    	this.LegLeft01.zRot = 0.03F;
    	this.LegRight01.xRot = -0.2618F;
		this.LegRight01.yRot = 0F;
    	this.LegRight01.zRot = -0.03F;
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
  		addk1 = angleAdd1 * 0.5F - 0.1222F;  //LegLeft01
	  	addk2 = angleAdd2 * 0.5F - 0.0698F;  //LegRight01
    	
  	    //head
	  	this.Head.xRot = f4 * 0.014F + 0.11F;
	  	this.Head.yRot = f3 * 0.01F;
	  	//body
  	    this.Ahoke.yRot = angleX * 0.2F + 1.0472F;
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
    	this.HairL01.xRot = -0.0524F;
    	this.HairL01.zRot = 0.1396F;
	  	this.HairL02.xRot = 0.0873F;
	  	this.HairL02.zRot = 0.0873F;
	  	this.HairR01.xRot = -0.0524F;
	  	this.HairR01.zRot = -0.1396F;
	  	this.HairR02.xRot = 0.0873F;
	  	this.HairR02.zRot = -0.0873F;
	    //arm
	  	this.ArmLeft01.xRot = -0.2793F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = 0.2793F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.x = (3.5F) + (0F) * 16F;
	    this.ArmRight01.xRot = -0.2793F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -0.2793F;
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
	    	float armz = Mth.cos(f2 * 0.8F) * 0.6F;
	    	float armx = Mth.sin(f2 * 0.8F) * -0.5F;
	    	setFace(3);
	    	
	 	    //body
	 	    this.Head.xRot -= 0.25F;
	 	    this.BodyMain.xRot = 0.1F;
	 	    this.Skirt01.xRot = -0.1F;
	 	  	this.Skirt02.xRot = -0.1885F;
    		//arm
	 	    this.ArmLeft01.xRot = armx;
	 	    this.ArmLeft01.zRot = -1.9F + armz;
	 	    this.ArmRight01.xRot = -armx;
	 	    this.ArmRight01.zRot = 1.9F + armz;
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
	    
	    Entity mount = ((LivingEntity) ent).getVehicle();
	    if (ent.getRidingState() > 0)
	  	{
	    	if (ent.getRidingState() > 1)
	    	{
	    		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		  		{
		  			//body
			  		this.Head.yRot *= 0.5F;
			  		this.Head.zRot = 0F;
			  		//arm 
				    this.ArmLeft01.xRot = 0.1F;
				    this.ArmLeft01.yRot = 0F;
				    this.ArmLeft01.zRot = -0.4F;
				    this.ArmLeft02.zRot = 0.8F;
				    this.ArmRight01.xRot = 0.1F;
				    this.ArmRight01.yRot = 0F;
				    this.ArmRight01.zRot = 0.4F;
				    this.ArmRight02.zRot = -0.8F;
				    //equip
				    this.EquipBase.visible = false;
		  		}
		  		else
		  		{
		  			//body
			  		this.Head.yRot *= 0.5F;
			  		this.Head.zRot = 0F;
			  		//arm 
				    this.ArmLeft01.xRot = -0.8F;
				    this.ArmLeft01.yRot = -1.5F;
				    this.ArmLeft01.zRot = 0F;
				    this.ArmLeft02.zRot = 1.45F;
				    this.ArmRight01.xRot = -0.8F;
				    this.ArmRight01.yRot = 1.5F;
				    this.ArmRight01.zRot = 0F;
				    this.ArmRight02.zRot = -1.45F;
				    //equip
				    this.EquipBase.visible = false;
		  		}
				
				if (ent.getIsSitting() && ent.getRidingState() != 3)
		    	{
this.animTransX += (0F); this.animTransY += (0.275F); this.animTransZ += (0F);
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
	    	
	    	if (ent.getRidingState() == 1 || ent.getRidingState() == 3)
	    	{
	    		//Body
			  	this.Butt.xRot = -0.2F;
		    	this.Butt.y = (3.0F) + (-0.1F) * 16F;
				this.Skirt01.xRot = -0.07F;
				this.Skirt01.y = (1.7F) + (-0.1F) * 16F;
				this.Skirt02.xRot = -0.16F;
				this.Skirt02.y = (3.5F) + (-0.15F) * 16F;
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

	    	}
	  	}
	    else
	    {
	    	if (ent.getIsSitting() || ent.getIsRiding())
	    	{	//騎乘動作
		    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		    	{
this.animTransX += (0F); this.animTransY += (0.375F); this.animTransZ += (0F);
			    	//head
			    	this.Head.yRot -= 0.4F;
			    	this.Head.zRot += 0.2F;
			    	//body
			    	this.BodyMain.xRot = -0.25F;
			    	this.Butt.xRot = -0.2F;
			    	this.Butt.y = (3.0F) + (-0.1F) * 16F;
					this.Skirt01.xRot = -0.07F;
					this.Skirt01.y = (1.7F) + (-0.1F) * 16F;
					this.Skirt02.xRot = -0.16F;
					this.Skirt02.y = (3.5F) + (-0.15F) * 16F;
					//arm
					this.ArmLeft01.xRot = 0.35F;
					this.ArmLeft01.zRot = -0.2618F;
					this.ArmRight01.xRot = -0.4F;
					this.ArmRight01.zRot = -0.2356F;
					this.ArmRight02.zRot = -0.2356F;
					//leg
					addk1 = -0.9F;
					addk2 = -0.9F;
					this.LegLeft01.zRot = -0.14F;
					this.LegLeft02.xRot = 1.2217F;
					this.LegLeft02.yRot = 1.2217F;
					this.LegLeft02.zRot = -1.0472F;
					this.LegLeft02.x = (-3.0F) + (0.32F) * 16F;
					this.LegLeft02.y = (12.0F) + (0.05F) * 16F;
					this.LegLeft02.z = (-3.0F) + (0.35F) * 16F;
					this.LegRight01.zRot = 0.14F;
					this.LegRight02.xRot = 1.2217F;
					this.LegRight02.yRot = -1.2217F;
					this.LegRight02.zRot = 1.0472F;
					this.LegRight02.x = (3.0F) + (-0.32F) * 16F;
					this.LegRight02.y = (12.0F) + (0.05F) * 16F;
					this.LegRight02.z = (-3.0F) + (0.35F) * 16F;
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.275F); this.animTransZ += (0F);
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
				  	this.ArmLeft01.zRot = 0.2618F;
			    	this.ArmRight01.xRot = -0.4F;
					this.ArmRight01.zRot = -0.2618F;
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
	    }
	    
	    //攻擊動作    
	    if (ent.getAttackTick() > 30)
	    {
	    	setFace(3);
		    //Body
		  	this.BodyMain.xRot = 0.5F;
		  	this.Butt.xRot = -0.3F;
		  	this.Butt.y = (3.0F) + (-0.15F) * 16F;
		    //arm 
		    this.ArmLeft01.xRot = -0.8F;
		    this.ArmLeft01.yRot = 0.4712F;
		    this.ArmLeft01.zRot = -0.3142F;
		    this.ArmLeft02.xRot = -0.9425F;
		    this.ArmLeft02.zRot = 0F;
		    this.ArmRight01.xRot = -0.8F;
		    this.ArmRight01.yRot = -0.4712F;
		    this.ArmRight01.zRot = 0.3142F;
		    this.ArmRight02.xRot = -0.9425F;
		    this.ArmRight02.zRot = 0F;
		    //leg
		    addk1 -= 0.15F;
		    addk2 -= 0.15F;
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
	  	
	  	//鬢毛調整
	  	float angleX1 = Mth.cos(f2*0.08F + 0.3F + f * 0.5F);
	    headX = this.Head.xRot * -0.5F;
	    headZ = this.Head.zRot * -0.5F;
	  	this.HairL01.zRot += headZ;
	  	this.HairL02.zRot += headZ;
	  	this.HairR01.zRot += headZ;
	  	this.HairR02.zRot += headZ * 2F;
		this.HairL01.xRot += angleX * 0.04F + headX;
	  	this.HairL02.xRot += -angleX1 * 0.07F + headX;
	  	this.HairR01.xRot += angleX * 0.04F + headX;
	  	this.HairR02.xRot += -angleX1 * 0.07F + headX;
	    
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

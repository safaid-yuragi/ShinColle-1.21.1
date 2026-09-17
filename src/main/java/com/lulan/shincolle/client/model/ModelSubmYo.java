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

public class ModelSubmYo<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Butt;
	public ModelPart Head;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart BodyMain1;
	public ModelPart BodyMain2;
	public ModelPart BoobL;
	public ModelPart BoobL2;
	public ModelPart BoobR;
	public ModelPart BoobR2;
	public ModelPart Butt1;
	public ModelPart Butt2;
	public ModelPart EquipBase;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart LegRight02;
	public ModelPart LegLeft02;
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
	public ModelPart Hair03;
	public ModelPart ArmLeft02;
	public ModelPart ArmRight02;
	public ModelPart EquipBody00;
	public ModelPart EquipJaw00;
	public ModelPart EquipHeadBack00;
	public ModelPart EquipBody01;
	public ModelPart EquipBody02;
	public ModelPart EquipJaw00a;
	public ModelPart EquipT01;
	public ModelPart EquipJaw01;
	public ModelPart EquipJaw02;
	public ModelPart EquipJaw03;
	public ModelPart EquipJaw04;
	public ModelPart EquipJaw01a;
	public ModelPart EquipJaw02a;
	public ModelPart EquipJaw03a;
	public ModelPart EquipJaw04a;
	public ModelPart EquipT01a;
	public ModelPart EquipT01b;
	public ModelPart EquipT01c;
	public ModelPart EquipHeadBack00a;
	public ModelPart EquipHead00;
	public ModelPart EquipT02;
	public ModelPart EquipHead00a;
	public ModelPart EquipHead00b;
	public ModelPart EquipHead00c;
	public ModelPart Eye01;
	public ModelPart Eye02;
	public ModelPart Eye03;
	public ModelPart EquipHead01;
	public ModelPart EquipHead02;
	public ModelPart EquipHead03;
	public ModelPart EquipHead04;
	public ModelPart EquipHead01a;
	public ModelPart EquipHead02a;
	public ModelPart EquipHead03a;
	public ModelPart EquipHead04a;
	public ModelPart EquipE01a;
	public ModelPart EquipE01b;
	public ModelPart EquipE01c;
	public ModelPart EquipE01d;
	public ModelPart EquipT02a;
	public ModelPart EquipT02b;
	public ModelPart EquipT02c;
	public ModelPart EquipS02a;
	public ModelPart EquipS02b;
	public ModelPart EquipS02c;
	public ModelPart EquipS02d;
	public ModelPart EquipS01a;
	public ModelPart EquipS01b;
	public ModelPart EquipS01c;
	public ModelPart EquipS01d;
	public ModelPart EquipT03;
	public ModelPart EquipT04;
	public ModelPart EquipT03a;
	public ModelPart EquipT03b;
	public ModelPart EquipT03c;
	public ModelPart EquipT04a;
	public ModelPart EquipT04b;
	public ModelPart EquipT04c;
	public ModelPart GlowBodyMain;
	public ModelPart GlowHead;
	public ModelPart GlowEquipBase;
	public ModelPart GlowEquipBody00;
	public ModelPart GlowEquipHeadBack00;
	public ModelPart GlowEquipHeadBack00a;
	public ModelPart GlowEquipHead00;
	public ModelPart GlowEquipBody01;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -11.0F, -3.0F, 0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.7F, -0.7F, -1.2217304763960306F, 0.0F, 0.8726646259971648F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0.0F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F), PartPose.offset(-3.0F, 10.0F, 2.5F));
		PartDefinition partdef3 = partdef0.addOrReplaceChild("BodyMain2", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 15.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("BoobL2", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(2.44F, -8.6F, -3.9F, -0.6981317007977318F, -0.08726646259971647F, -0.06981317007977318F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("BoobR2", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-2.44F, -8.6F, -3.9F, -0.6981317007977318F, 0.08726646259971647F, 0.06981317007977318F));
		PartDefinition partdef6 = partdef0.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -11.8F, -0.5F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 16.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 8.0F, 1.1F, 0.5759586531581287F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("Hair03", CubeListBuilder.create().addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 12.5F, 0.0F, 1.7453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef6.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 12.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.4F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(-4.9F, 8.0F, -7.2F, 0.08726646259971647F, 0.13962634015954636F, -0.05235987755982988F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(-0.3F, 7.5F, 0.1F, 0.3141592653589793F, 0.17453292519943295F, 0.17453292519943295F));
		PartDefinition partdef14 = partdef11.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(5.7F, 7.9F, -7.5F, -0.13962634015954636F, 0.4363323129985824F, 0.13962634015954636F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(0.3F, 10.0F, 0.0F, 0.17453292519943295F, 0.08726646259971647F, -0.13962634015954636F));
		PartDefinition partdef16 = partdef11.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -5.0F, -10.5F, 0.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(-1.0F, -7.0F, -5.5F, 0.2617993877991494F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef17 = partdef11.addOrReplaceChild("HairU01", CubeListBuilder.create().mirror().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 7.0F), PartPose.offset(0.0F, -6.0F, -7.7F));
		PartDefinition partdef18 = partdef0.addOrReplaceChild("Butt1", CubeListBuilder.create().addBox(-7.5F, 0.0F, -7.0F, 15.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 2.5F, 2.8F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.5F, 2.8F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F), PartPose.offsetAndRotation(4.4F, 6.5F, -4.0F, 1.5707963267948966F, 0.0F, 0.10471975511965977F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 13.0F, 6.0F), PartPose.offset(-3.0F, 12.0F, -3.0F));
		PartDefinition partdef22 = partdef19.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F), PartPose.offsetAndRotation(-4.4F, 6.5F, -4.0F, 1.5707963267948966F, 0.0F, -0.10471975511965977F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 13.0F, 6.0F), PartPose.offset(3.0F, 12.0F, -3.0F));
		PartDefinition partdef24 = partdef0.addOrReplaceChild("BodyMain1", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 15.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef25 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(3.2F, -8.6F, -3.9F, -0.6981317007977318F, -0.08726646259971647F, -0.06981317007977318F));
		PartDefinition partdef26 = partdef0.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("EquipBody00", CubeListBuilder.create().addBox(-10.0F, -10.0F, 1.0F, 20.0F, 12.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 7.5F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("EquipBody01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 12.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -2.4F, 3.0F, 0.45378560551852565F, 0.0F, 0.0F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("EquipS02b", CubeListBuilder.create().addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(9.0F, 9.0F, 12.0F, -0.7853981633974483F, -1.7453292519943295F, 0.0F));
		PartDefinition partdef30 = partdef28.addOrReplaceChild("EquipS02a", CubeListBuilder.create().addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(9.0F, 9.0F, 4.0F, -0.7853981633974483F, -1.3962634015954636F, 0.0F));
		PartDefinition partdef31 = partdef28.addOrReplaceChild("EquipS02c", CubeListBuilder.create().addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(-9.0F, 9.0F, 12.0F, -0.7853981633974483F, 1.7453292519943295F, 0.0F));
		PartDefinition partdef32 = partdef28.addOrReplaceChild("EquipS02d", CubeListBuilder.create().addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(-9.0F, 9.0F, 4.0F, -0.7853981633974483F, 1.3962634015954636F, 0.0F));
		PartDefinition partdef33 = partdef27.addOrReplaceChild("EquipJaw00", CubeListBuilder.create().addBox(-10.0F, 0.0F, -11.0F, 20.0F, 12.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 5.0F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("EquipJaw00a", CubeListBuilder.create().addBox(-10.0F, -2.0F, -6.0F, 20.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 11.0F, -10.0F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("EquipJaw04", CubeListBuilder.create().addBox(-6.0F, -15.0F, -4.0F, 12.0F, 15.0F, 4.0F), PartPose.offsetAndRotation(-6.8F, 1.2F, -2.7F, 0.13962634015954636F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("EquipJaw04a", CubeListBuilder.create().addBox(-6.0F, -5.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -14.5F, -3.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef37 = partdef34.addOrReplaceChild("EquipJaw03", CubeListBuilder.create().addBox(-6.0F, -15.0F, -4.0F, 12.0F, 15.0F, 4.0F), PartPose.offsetAndRotation(6.8F, 1.2F, -2.7F, 0.13962634015954636F, -1.5707963267948966F, 0.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("EquipJaw03a", CubeListBuilder.create().addBox(-6.0F, -5.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -14.5F, -3.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef39 = partdef34.addOrReplaceChild("EquipJaw01", CubeListBuilder.create().addBox(-6.0F, -16.0F, -4.0F, 12.0F, 15.0F, 4.0F), PartPose.offsetAndRotation(-5.1F, 2.0F, -4.0F, 0.17453292519943295F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef40 = partdef39.addOrReplaceChild("EquipJaw01a", CubeListBuilder.create().addBox(-6.0F, -5.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -15.5F, -3.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef41 = partdef34.addOrReplaceChild("EquipJaw02", CubeListBuilder.create().addBox(-6.0F, -16.0F, -4.0F, 12.0F, 15.0F, 4.0F), PartPose.offsetAndRotation(5.1F, 2.0F, -4.0F, 0.17453292519943295F, -0.13962634015954636F, 0.0F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("EquipJaw02a", CubeListBuilder.create().addBox(-6.0F, -5.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -15.5F, -3.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef43 = partdef33.addOrReplaceChild("EquipT01", CubeListBuilder.create().addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 15.0F, -8.0F, 0.6283185307179586F, 0.0F, 0.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("EquipT01a", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.31869712141416456F, 0.0F, 0.0F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("EquipT01b", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("EquipT01c", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, -0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef47 = partdef27.addOrReplaceChild("EquipBody02", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 12.0F, 13.0F), PartPose.offset(0.0F, -12.0F, 11.0F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("EquipT03", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(7.0F, 9.5F, 8.5F, 1.3962634015954636F, 0.17453292519943295F, 0.0F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("EquipT03a", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("EquipT03b", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("EquipT03c", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, -0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef52 = partdef47.addOrReplaceChild("EquipT04", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(-7.0F, 9.5F, 8.5F, 1.3962634015954636F, -0.17453292519943295F, 0.0F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("EquipT04a", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef54 = partdef53.addOrReplaceChild("EquipT04b", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("EquipT04c", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef56 = partdef27.addOrReplaceChild("EquipHeadBack00", CubeListBuilder.create().addBox(-9.0F, -10.0F, -10.0F, 18.0F, 12.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -8.0F, 9.0F, -1.3962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef57 = partdef56.addOrReplaceChild("EquipHeadBack00a", CubeListBuilder.create().addBox(-8.0F, -11.0F, -11.0F, 16.0F, 11.0F, 13.0F), PartPose.offset(0.0F, -4.0F, -3.0F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("EquipT02", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -9.0F, -10.0F, 2.6179938779914944F, 0.0F, 0.0F));
		PartDefinition partdef59 = partdef58.addOrReplaceChild("EquipT02a", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef60 = partdef59.addOrReplaceChild("EquipT02b", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("EquipT02c", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, 0.41887902047863906F, 0.0F, 0.0F));
		PartDefinition partdef62 = partdef57.addOrReplaceChild("EquipHead00", CubeListBuilder.create().addBox(-10.0F, -12.0F, -11.0F, 20.0F, 12.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -1.0F, -10.0F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("EquipHead00b", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.5F, 3.0F, 10.0F, 7.0F), PartPose.offsetAndRotation(-10.0F, -2.0F, -2.0F, 0.20943951023931953F, -0.06981317007977318F, 0.13962634015954636F));
		PartDefinition partdef64 = partdef62.addOrReplaceChild("EquipHead00c", CubeListBuilder.create().addBox(-1.5F, 0.0F, -3.5F, 3.0F, 10.0F, 7.0F), PartPose.offsetAndRotation(10.0F, -2.0F, -2.0F, 0.20943951023931953F, 0.06981317007977318F, -0.13962634015954636F));
		PartDefinition partdef65 = partdef62.addOrReplaceChild("EquipHead00a", CubeListBuilder.create().addBox(-10.0F, -4.0F, -5.5F, 20.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -8.0F, -12.0F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef66 = partdef65.addOrReplaceChild("EquipHead01", CubeListBuilder.create().addBox(-6.0F, 0.0F, -4.0F, 12.0F, 15.0F, 4.0F), PartPose.offsetAndRotation(-5.1F, -4.0F, -4.0F, -0.17453292519943295F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef67 = partdef66.addOrReplaceChild("EquipHead01a", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 14.5F, -3.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef68 = partdef65.addOrReplaceChild("EquipHead02", CubeListBuilder.create().addBox(-6.0F, 0.0F, -4.0F, 12.0F, 15.0F, 4.0F), PartPose.offsetAndRotation(5.1F, -4.0F, -4.0F, -0.17453292519943295F, -0.13962634015954636F, 0.0F));
		PartDefinition partdef69 = partdef68.addOrReplaceChild("EquipHead02a", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 14.5F, -3.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef70 = partdef65.addOrReplaceChild("EquipHead04", CubeListBuilder.create().addBox(-6.0F, 0.0F, -4.0F, 12.0F, 15.0F, 4.0F), PartPose.offsetAndRotation(-6.8F, -4.2F, -2.6F, -0.13962634015954636F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef71 = partdef70.addOrReplaceChild("EquipHead04a", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 14.5F, -3.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef72 = partdef65.addOrReplaceChild("EquipHead03", CubeListBuilder.create().addBox(-6.0F, 0.0F, -4.0F, 12.0F, 15.0F, 4.0F), PartPose.offsetAndRotation(6.8F, -4.2F, -2.6F, -0.13962634015954636F, -1.5707963267948966F, 0.0F));
		PartDefinition partdef73 = partdef72.addOrReplaceChild("EquipHead03a", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 14.5F, -3.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef74 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.7F, -0.7F, -1.2217304763960306F, 0.0F, -0.8726646259971648F));
		PartDefinition partdef75 = partdef74.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F), PartPose.offset(3.0F, 10.0F, 2.5F));
		PartDefinition partdef76 = partdef0.addOrReplaceChild("Butt2", CubeListBuilder.create().addBox(-7.5F, 0.0F, -7.0F, 15.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 2.5F, 2.8F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef77 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-3.2F, -8.6F, -3.9F, -0.6981317007977318F, 0.08726646259971647F, 0.06981317007977318F));
		PartDefinition partdef78 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -11.0F, -3.0F, 0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef79 = partdef78.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -11.8F, -0.5F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef80 = partdef79.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef81 = partdef79.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef82 = partdef79.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef83 = partdef79.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef84 = partdef79.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef85 = partdef79.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef86 = partdef79.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef87 = partdef79.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef88 = partdef79.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef89 = partdef79.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));
		PartDefinition partdef90 = partdef78.addOrReplaceChild("GlowEquipBase", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef91 = partdef90.addOrReplaceChild("GlowEquipBody00", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.0F, 7.5F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef92 = partdef91.addOrReplaceChild("GlowEquipHeadBack00", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.0F, 9.0F, -1.3962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef93 = partdef92.addOrReplaceChild("GlowEquipHeadBack00a", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -3.0F));
		PartDefinition partdef94 = partdef93.addOrReplaceChild("GlowEquipHead00", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.0F, -10.0F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef95 = partdef94.addOrReplaceChild("Eye01", CubeListBuilder.create().addBox(-1.0F, 0.0F, -3.0F, 2.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(11.0F, -8.5F, -6.0F, 0.0F, -0.10471975511965977F, -0.17453292519943295F));
		PartDefinition partdef96 = partdef94.addOrReplaceChild("Eye02", CubeListBuilder.create().addBox(-1.0F, 0.0F, -3.0F, 2.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(-11.0F, -8.5F, -6.0F, 0.0F, 0.10471975511965977F, 0.17453292519943295F));
		PartDefinition partdef97 = partdef94.addOrReplaceChild("Eye03", CubeListBuilder.create().addBox(-1.0F, -3.5F, -3.5F, 2.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 0.8726646259971648F, 1.5707963267948966F));
		PartDefinition partdef98 = partdef97.addOrReplaceChild("EquipE01b", CubeListBuilder.create().addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(-0.3F, -5.0F, 0.0F, -2.2689280275926285F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef99 = partdef97.addOrReplaceChild("EquipE01d", CubeListBuilder.create().addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(-0.5F, 0.0F, 5.0F, 0.5235987755982988F, 0.0F, 1.5707963267948966F));
		PartDefinition partdef100 = partdef97.addOrReplaceChild("EquipE01c", CubeListBuilder.create().addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -1.0471975511965976F, 0.0F, 1.5707963267948966F));
		PartDefinition partdef101 = partdef97.addOrReplaceChild("EquipE01a", CubeListBuilder.create().addBox(-4.5F, -2.5F, -1.0F, 9.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(-0.3F, 5.0F, 0.0F, 2.2689280275926285F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef102 = partdef91.addOrReplaceChild("GlowEquipBody01", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.4F, 3.0F, 0.45378560551852565F, 0.0F, 0.0F));
		PartDefinition partdef103 = partdef102.addOrReplaceChild("EquipS01a", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(6.5F, 11.0F, 3.0F, -0.2617993877991494F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef104 = partdef102.addOrReplaceChild("EquipS01b", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-6.5F, 11.0F, 3.0F, -0.2617993877991494F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef105 = partdef102.addOrReplaceChild("EquipS01c", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(6.5F, 11.0F, 11.0F, 0.2617993877991494F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef106 = partdef102.addOrReplaceChild("EquipS01d", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-6.5F, 11.0F, 11.0F, 0.2617993877991494F, 0.0F, 0.2617993877991494F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelSubmYo(ModelPart root)
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
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.EquipT02c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipT02").getChild("EquipT02a").getChild("EquipT02b").getChild("EquipT02c");
		this.EquipS02b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipBody01").getChild("EquipS02b");
		this.EquipT03c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipBody02").getChild("EquipT03").getChild("EquipT03a").getChild("EquipT03b").getChild("EquipT03c");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.EquipE01b = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipHeadBack00").getChild("GlowEquipHeadBack00a").getChild("GlowEquipHead00").getChild("Eye03").getChild("EquipE01b");
		this.EquipE01d = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipHeadBack00").getChild("GlowEquipHeadBack00a").getChild("GlowEquipHead00").getChild("Eye03").getChild("EquipE01d");
		this.EquipJaw04 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipJaw00").getChild("EquipJaw00a").getChild("EquipJaw04");
		this.Eye01 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipHeadBack00").getChild("GlowEquipHeadBack00a").getChild("GlowEquipHead00").getChild("Eye01");
		this.EquipT02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipT02");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.EquipHead01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipHead00").getChild("EquipHead00a").getChild("EquipHead01");
		this.BodyMain2 = root.getChild("BodyMain").getChild("BodyMain2");
		this.BoobL2 = root.getChild("BodyMain").getChild("BoobL2");
		this.EquipHead04a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipHead00").getChild("EquipHead00a").getChild("EquipHead04").getChild("EquipHead04a");
		this.EquipT02b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipT02").getChild("EquipT02a").getChild("EquipT02b");
		this.BoobR2 = root.getChild("BodyMain").getChild("BoobR2");
		this.HairR02 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.EquipS01b = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipBody01").getChild("EquipS01b");
		this.EquipBody00 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00");
		this.EquipS02a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipBody01").getChild("EquipS02a");
		this.EquipT01b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipJaw00").getChild("EquipT01").getChild("EquipT01a").getChild("EquipT01b");
		this.EquipT03a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipBody02").getChild("EquipT03").getChild("EquipT03a");
		this.EquipT03 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipBody02").getChild("EquipT03");
		this.Hair03 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02").getChild("Hair03");
		this.EquipT03b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipBody02").getChild("EquipT03").getChild("EquipT03a").getChild("EquipT03b");
		this.EquipS01d = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipBody01").getChild("EquipS01d");
		this.Head = root.getChild("BodyMain").getChild("Head");
		this.HairL01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairL01");
		this.EquipT04b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipBody02").getChild("EquipT04").getChild("EquipT04a").getChild("EquipT04b");
		this.HairR01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairR01");
		this.EquipHead02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipHead00").getChild("EquipHead00a").getChild("EquipHead02");
		this.EquipS02c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipBody01").getChild("EquipS02c");
		this.HairL02 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.EquipJaw00a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipJaw00").getChild("EquipJaw00a");
		this.EquipT04a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipBody02").getChild("EquipT04").getChild("EquipT04a");
		this.Butt1 = root.getChild("BodyMain").getChild("Butt1");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.Ahoke = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.EquipHead00b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipHead00").getChild("EquipHead00b");
		this.EquipBody01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipBody01");
		this.EquipHead04 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipHead00").getChild("EquipHead00a").getChild("EquipHead04");
		this.Hair01 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.EquipE01c = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipHeadBack00").getChild("GlowEquipHeadBack00a").getChild("GlowEquipHead00").getChild("Eye03").getChild("EquipE01c");
		this.HairMain = root.getChild("BodyMain").getChild("Head").getChild("HairMain");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.EquipHead00c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipHead00").getChild("EquipHead00c");
		this.EquipHead01a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipHead00").getChild("EquipHead00a").getChild("EquipHead01").getChild("EquipHead01a");
		this.BodyMain = root.getChild("BodyMain");
		this.EquipT01c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipJaw00").getChild("EquipT01").getChild("EquipT01a").getChild("EquipT01b").getChild("EquipT01c");
		this.BodyMain1 = root.getChild("BodyMain").getChild("BodyMain1");
		this.EquipJaw02a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipJaw00").getChild("EquipJaw00a").getChild("EquipJaw02").getChild("EquipJaw02a");
		this.EquipS01c = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipBody01").getChild("EquipS01c");
		this.EquipS02d = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipBody01").getChild("EquipS02d");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.EquipHead00 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipHead00");
		this.EquipJaw03 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipJaw00").getChild("EquipJaw00a").getChild("EquipJaw03");
		this.EquipT01a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipJaw00").getChild("EquipT01").getChild("EquipT01a");
		this.EquipHead03a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipHead00").getChild("EquipHead00a").getChild("EquipHead03").getChild("EquipHead03a");
		this.EquipT01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipJaw00").getChild("EquipT01");
		this.EquipT02a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipT02").getChild("EquipT02a");
		this.EquipBase = root.getChild("BodyMain").getChild("EquipBase");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.Eye03 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipHeadBack00").getChild("GlowEquipHeadBack00a").getChild("GlowEquipHead00").getChild("Eye03");
		this.EquipS01a = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipBody01").getChild("EquipS01a");
		this.EquipJaw00 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipJaw00");
		this.EquipBody02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipBody02");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.EquipJaw01a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipJaw00").getChild("EquipJaw00a").getChild("EquipJaw01").getChild("EquipJaw01a");
		this.EquipHead00a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipHead00").getChild("EquipHead00a");
		this.EquipJaw01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipJaw00").getChild("EquipJaw00a").getChild("EquipJaw01");
		this.EquipJaw03a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipJaw00").getChild("EquipJaw00a").getChild("EquipJaw03").getChild("EquipJaw03a");
		this.Eye02 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipHeadBack00").getChild("GlowEquipHeadBack00a").getChild("GlowEquipHead00").getChild("Eye02");
		this.Butt2 = root.getChild("BodyMain").getChild("Butt2");
		this.EquipT04c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipBody02").getChild("EquipT04").getChild("EquipT04a").getChild("EquipT04b").getChild("EquipT04c");
		this.EquipHead02a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipHead00").getChild("EquipHead00a").getChild("EquipHead02").getChild("EquipHead02a");
		this.HairU01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairU01");
		this.Hair = root.getChild("BodyMain").getChild("Head").getChild("Hair");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.EquipJaw02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipJaw00").getChild("EquipJaw00a").getChild("EquipJaw02");
		this.EquipHeadBack00a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a");
		this.EquipHeadBack00 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00");
		this.EquipE01a = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipHeadBack00").getChild("GlowEquipHeadBack00a").getChild("GlowEquipHead00").getChild("Eye03").getChild("EquipE01a");
		this.Hair02 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.EquipJaw04a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipJaw00").getChild("EquipJaw00a").getChild("EquipJaw04").getChild("EquipJaw04a");
		this.EquipT04 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipBody02").getChild("EquipT04");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.EquipHead03 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBody00").getChild("EquipHeadBack00").getChild("EquipHeadBack00a").getChild("EquipHead00").getChild("EquipHead00a").getChild("EquipHead03");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowHead");
		this.GlowEquipBase = root.getChild("GlowBodyMain").getChild("GlowEquipBase");
		this.GlowEquipBody00 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00");
		this.GlowEquipHeadBack00 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipHeadBack00");
		this.GlowEquipHeadBack00a = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipHeadBack00").getChild("GlowEquipHeadBack00a");
		this.GlowEquipHead00 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipHeadBack00").getChild("GlowEquipHeadBack00a").getChild("GlowEquipHead00");
		this.GlowEquipBody01 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("GlowEquipBody00").getChild("GlowEquipBody01");
		this.scale = 0.47F;
		this.offsetY = 1.78F;
		this.offsetItem = new float[] {0.08F, 0.96F, -0.08F};
		this.offsetBlock = new float[] {0.08F, 0.96F, -0.08F};
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
		
		boolean flag = !EmotionHelper.checkModelState(0, state);	//equip
		this.EquipBase.visible = !(flag);
		this.GlowEquipBase.visible = !(flag);
		this.Hair03.visible = !(!flag);
		this.LegLeft01.visible = !(!flag);
		this.LegRight01.visible = !(!flag);
				
		flag = !EmotionHelper.checkModelState(1, state);			//cloth
		this.BodyMain1.visible = !(!flag);
		this.Butt1.visible = !(!flag);
		this.BoobL.visible = !(!flag);
		this.BoobR.visible = !(!flag);
		this.BodyMain2.visible = !(flag);
		this.Butt2.visible = !(flag);
		this.BoobL2.visible = !(flag);
		this.BoobR2.visible = !(flag);
	
	}

	public void syncRotationGlowPart()
	{

    	//outfit 2
    	this.BoobL2.xRot = this.BoobL.xRot;
    	this.BoobR2.xRot = this.BoobR.xRot;
    	this.Butt1.xRot = this.Butt.xRot;
    	this.Butt2.xRot = this.Butt.xRot;
    	
    	//頭部
		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
		this.GlowEquipHeadBack00.xRot = this.EquipHeadBack00.xRot;
		this.GlowEquipHeadBack00.yRot = this.EquipHeadBack00.yRot;
		this.GlowEquipHeadBack00.zRot = this.EquipHeadBack00.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

    	float angleX = Mth.cos(f2 * 0.08F);
this.animTransX += (0F); this.animTransY += (0.39F); this.animTransZ += (-0.1F);
    	this.setFaceHungry(ent);
    	
    	this.EquipBase.visible = true;
		this.GlowEquipBase.visible = true;
		this.Head.visible = false;
		this.GlowHead.visible = false;
		this.LegLeft01.visible = false;
		this.LegRight01.visible = false;

	  	//boob
  	    this.BoobL.xRot = -0.76F;
  	    this.BoobR.xRot = -0.76F;
  	    //body
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.21F;
	  	this.Butt.z = (2.8F) + (0F) * 16F;
	  	//hair
	  	this.Hair01.xRot = 0.209F;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -0.087F;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -0.139F;
	  	this.Hair03.zRot = 0F;
	  	this.HairL01.xRot = -0.1F;
	  	this.HairL02.xRot = 0.3142F;
	  	this.HairR01.xRot = -0.1F;
	  	this.HairR02.xRot = 0.1745F;
	  	this.HairL01.zRot = -0.0524F;
	  	this.HairL02.zRot = 0.1745F;
	  	this.HairR01.zRot = 0.1396F;
	  	this.HairR02.zRot = -0.1396F;

	  	//body
	  	this.BodyMain.xRot = 0.2F;
	  	//arm
	  	this.ArmLeft01.xRot = -0.25F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = 0.2618F;
	    this.ArmRight01.xRot = -0.25F;
	    this.ArmRight01.yRot = 0F;
	    this.ArmRight01.zRot = -0.2618F;
	    //equip
	    this.EquipHeadBack00.xRot = -0.15F;
	    this.EquipT01a.xRot = 0.5F;
	    this.EquipT01b.xRot = 0.5F;
	    this.EquipT01c.xRot = 0.5F;
	    this.EquipT02a.xRot = -0.7F;
	    this.EquipT02b.xRot = -0.5F;
	    this.EquipT02c.xRot = -0.5F;
	    this.EquipT03a.xRot = 0F;
	    this.EquipT03b.xRot = 0F;
	    this.EquipT03c.xRot = 0F;
	    this.EquipT04a.xRot = 0F;
	    this.EquipT04b.xRot = 0F;
	    this.EquipT04c.xRot = 0F;
	    this.EquipT03a.zRot = 0.5F;
	    this.EquipT03b.zRot = 0.6F;
	    this.EquipT03c.zRot = 0.7F;
	    this.EquipT04a.zRot = 0.3F;
	    this.EquipT04b.zRot = 0.3F;
	    this.EquipT04c.zRot = 0.3F;
	    this.EquipS01a.xRot = 0.2F;
	    this.EquipS01b.xRot = 0.3F;
	    this.EquipS01c.xRot = 0.2F;
	    this.EquipS01d.xRot = 0.5F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2 * 0.08F);
  		float angleX1 = Mth.cos(f2*0.1F + 0.3F + f * 0.5F);
  		float angleX2 = Mth.cos(f2*0.1F + 0.6F + f * 0.5F);
  		float angleX3 = Mth.cos(f2*0.1F + 0.9F + f * 0.5F);
  		float angleX4 = Mth.cos(f2*0.3F + 2F + f * 0.5F);
  		float angleX5 = Mth.cos(f2*0.3F + 4F + f * 0.5F);
  		float angleX6 = Mth.cos(f2*0.3F + 6F + f * 0.5F);
  		float angleX7 = Mth.sin(f2);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.7F;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.7F;
  		float addk1 = 0F;
  		float addk2 = 0F;
  		float headX = 0F;
  		float headZ = 0F;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//head
  		this.Head.visible = true;
		this.GlowHead.visible = true;
	  	this.Head.xRot = f4 * 0.014F;
	  	this.Head.yRot = f3 * 0.01F;
	  	this.Head.zRot = 0F;
	  	headX = this.Head.xRot * -0.5F;
	  	//boob
  	    this.BoobL.xRot = angleX * 0.08F - 0.76F;
  	    this.BoobR.xRot = angleX * 0.08F - 0.76F;
  	    //body
  	    this.Ahoke.yRot = angleX * 0.15F + 0.6F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.21F;
	  	this.Butt.z = (2.8F) + (0F) * 16F;
	  	//hair
	  	this.Hair01.xRot = 0.209F;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -0.087F;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -0.139F;
	  	this.Hair03.zRot = 0F;
	  	this.HairL01.xRot = -0.1F;
	  	this.HairL02.xRot = 0.3142F;
	  	this.HairR01.xRot = -0.1F;
	  	this.HairR02.xRot = 0.1745F;
	  	this.HairL01.zRot = -0.0524F;
	  	this.HairL02.zRot = 0.1745F;
	  	this.HairR01.zRot = 0.1396F;
	  	this.HairR02.zRot = -0.1396F;
  		
	  	boolean showEquip = EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State));
	  	
  		if (showEquip)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.035F + 0.1F); this.animTransZ += (-0.1F);
  			//head
  		  	this.Head.xRot -= 0.7F;
  		  	//body
  		  	this.BodyMain.xRot = 0.7F;
  		  	//arm 
  		  	this.ArmLeft01.xRot = -angleX * 0.1F - 1.0472F;
  		  	this.ArmLeft01.yRot = 0F;
  		    this.ArmLeft01.zRot = -angleX * 0.1F - 0.7F;
  		    this.ArmRight01.xRot = -angleX * 0.1F - 1.0472F;
  		  	this.ArmRight01.yRot = 0F;
  		    this.ArmRight01.zRot = angleX * 0.1F + 0.7F;
  		    //equip
  		    this.EquipHeadBack00.xRot = angleX * 0.05F - 1.7F;
  		    this.EquipT01a.xRot = angleX6 * 0.22F + 0.5F;
  		    this.EquipT01b.xRot = angleX5 * 0.44F;
  		    this.EquipT01c.xRot = angleX4 * 0.66F;
  		    this.EquipT02a.xRot = -angleX6 * 0.22F;
		    this.EquipT02b.xRot = -angleX5 * 0.44F;
		    this.EquipT02c.xRot = -angleX4 * 0.66F;
		    this.EquipT03a.xRot = 0F;
  		    this.EquipT03b.xRot = 0F;
  		    this.EquipT03c.xRot = 0F;
  		    this.EquipT04a.xRot = 0F;
		    this.EquipT04b.xRot = 0F;
		    this.EquipT04c.xRot = 0F;
		    this.EquipT03a.zRot = angleX6 * 0.25F;
  		    this.EquipT03b.zRot = angleX5 * 0.5F;
  		    this.EquipT03c.zRot = angleX4 * 0.75F;
  		    this.EquipT04a.zRot = -angleX6 * 0.25F;
		    this.EquipT04b.zRot = -angleX5 * 0.5F;
		    this.EquipT04c.zRot = -angleX4 * 0.75F;
		    this.EquipS01a.xRot = angleX7 * 0.05F * ent.getRand().nextFloat() - 0.2618F;
		    this.EquipS01b.xRot = angleX7 * 0.05F * ent.getRand().nextFloat() - 0.2618F;
		    this.EquipS01c.xRot = -angleX7 * 0.05F * ent.getRand().nextFloat() + 0.2618F;
		    this.EquipS01d.xRot = -angleX7 * 0.05F * ent.getRand().nextFloat() + 0.2618F;
  		}
  		else
  		{
  			//head
  		  	this.Head.xRot += 0.1F;
  		  	//body
  		  	this.BodyMain.xRot = -0.1047F;
  		    //arm 
  		  	this.ArmLeft01.xRot = 0.2094F;
  		  	this.ArmLeft01.yRot = 0F;
  		    this.ArmLeft01.zRot = -angleX * 0.05F - 0.3142F;
  		    this.ArmRight01.xRot = 0F;
  		  	this.ArmRight01.yRot = 0F;
  		    this.ArmRight01.zRot = angleX * 0.05F + 0.2094F;
  			//leg
  		    addk1 = angleAdd1 * 0.6F - 0.157F;
  		  	addk2 = angleAdd2 * 0.6F - 0.035F;
  		  	this.LegLeft01.yRot = 0F;
  		  	this.LegLeft01.zRot = 0.1F;
  		  	this.LegRight01.yRot = 0F;
  		  	this.LegRight01.zRot = -0.1F;
  		}

	  	//sprinting
	    if (ent.getIsSprinting() || f1 > 0.92F)
	    {	//奔跑動作
this.animTransX += (0F); this.animTransY += (0.1F); this.animTransZ += (0F);
	    	
	    	if (showEquip)
	  		{
	    		this.Head.xRot += 0.6F;
	  		}
	    	
		    //body
		    this.Head.xRot -= 1.1F;
	    	this.BodyMain.xRot = 1.1F;
	    	//胸部
	  	    this.BoobL.xRot = angleAdd1 * 0.08F - 0.7F;
	  	    this.BoobL.zRot = -0.07F;
	  	    this.BoobR.xRot = angleAdd1 * 0.08F - 0.7F;
	  	    this.BoobR.zRot = 0.07F;
	    	//arm
	    	this.ArmLeft01.xRot = -2.5133F;
		    this.ArmLeft01.zRot = -0.22F;
		    this.ArmRight01.xRot = -2.5133F;
		    this.ArmRight01.zRot = 0.22F;
		    //leg
		    this.LegLeft01.zRot = 0.05F;
		  	this.LegRight01.zRot = -0.05F;
  		}//end is sprinting
	    
	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {		//潛行, 蹲下動作
this.animTransX += (0F); this.animTransY += (0.05F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 1.0472F;
		  	this.BodyMain.xRot = 1.0472F;
		  	this.Butt.xRot = -0.8378F;
		  	//hair
		  	this.Hair01.xRot -= 0.1F;
		  	this.Hair02.xRot -= 0.2F;
		  	this.Hair03.xRot -= 0.5F;
		    //arm 
		    this.ArmLeft01.xRot = -0.7F;
		    this.ArmLeft01.zRot = 0.2618F;
		    this.ArmRight01.xRot = -0.7F;
		    this.ArmRight01.zRot = -0.2618F;
		    //leg
		    addk1 -= 0.1F;
		  	addk2 -= 0.1F;
		  	
		  	if (showEquip)
	  		{
		  		this.Head.xRot += 0.8F;
		  		this.ArmLeft01.xRot = -0.25F;
		  		this.ArmRight01.xRot = -0.25F;
		  		this.EquipHeadBack00.xRot += 0.4F;
	  		}
  		}//end if sneaking
	    
	    //sitting riding
	    if (ent.getIsSitting() && !ent.getIsRiding())
	    {
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
		    	this.setFaceDamaged(ent);
this.animTransX += (0F); this.animTransY += (-angleX * 0.05F); this.animTransZ += (0F);
			    //body
		    	this.Head.xRot *= 0.5F;
		    	this.Head.yRot *= 0.75F;
			    this.Head.xRot += 0.5F;
		    	this.BodyMain.xRot = 1.6F;
		    	//arm
		    	this.ArmLeft01.xRot = -1.6F;
		    	this.ArmLeft01.zRot = -2.3F;
		    	this.ArmRight01.xRot = -1.6F;
		    	this.ArmRight01.zRot = 2.3F;
			    //leg
			    addk1 = -1.6F;
		    	addk2 = -1.6F;
			    this.LegLeft01.yRot = -0.1F - angleX * 0.05F;
			  	this.LegRight01.yRot = 0.1F + angleX * 0.05F;
			  	
			  	if (showEquip)
		  		{
this.animTransX += (0F); this.animTransY += (0.36F); this.animTransZ += (0F);
			  		float ax = Mth.cos(f2 * 0.5F) * 0.5F;
			  		
			  		this.ArmLeft01.xRot = ax + 0.1F;
			    	this.ArmRight01.xRot = -ax + 0.1F;
			    	//equip
			    	this.EquipHeadBack00.xRot = ax * 0.1F - 0.7F;
		  		}
	    	}
	    	else
	    	{
		    	//body
		    	this.Head.xRot -= 0.7F;
		    	this.BodyMain.xRot = 0.5236F;
		    	//arm
		    	this.ArmLeft01.xRot = -0.4F;
		    	this.ArmLeft01.zRot = 0.3146F;
		    	this.ArmRight01.xRot = -0.4F;
		    	this.ArmRight01.zRot = -0.3146F;
		    	//leg
		    	addk1 = -2.18F;
		    	addk2 = -2.18F;
		    	this.LegLeft01.yRot = -0.3491F;
		    	this.LegRight01.yRot = 0.3491F;
		    	
		    	if (showEquip)
		  		{
		    		//body
		    		this.Head.xRot += 0.7F;
		    		this.BodyMain.xRot = 0.3F;
		    		//arm
			    	this.ArmLeft01.xRot = -0.27F;
			    	this.ArmLeft01.zRot = 0.3146F;
			    	this.ArmRight01.xRot = -0.27F;
			    	this.ArmRight01.zRot = -0.3146F;
			    	//equip
			    	this.EquipHeadBack00.xRot += 0.45F;
		  		}
	    		else
	    		{
this.animTransX += (0F); this.animTransY += (0.45F); this.animTransZ += (0F);
	    		}
	    	}
  		}//end sitting
	    
	    //attack
	    if (ent.getAttackTick() > 41)
	    {
	    	setFaceAttack(ent);
	    	//swing arm
		    float ft = (50 - ent.getAttackTick()) + (f2 - (int)f2);
		    ft *= 0.125F;
	  		float fa = Mth.sin(ft * ft * (float)Math.PI);
	        float fb = Mth.sin(Mth.sqrt(ft) * (float)Math.PI);
	        this.ArmLeft01.xRot += -fb * 80.0F * Values.N.DIV_PI_180 - 0.3F;
	        this.ArmLeft01.yRot += fa * 20.0F * Values.N.DIV_PI_180 - 0.4F;
	        this.ArmLeft01.zRot += fb * 20.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.xRot += -fb * 80.0F * Values.N.DIV_PI_180 - 0.3F;
	        this.ArmRight01.yRot += -fa * 20.0F * Values.N.DIV_PI_180 + 0.4F;
	        this.ArmRight01.zRot += -fb * 20.0F * Values.N.DIV_PI_180;
	    }//end attack
	    
	    //鬢毛調整
	    headX = this.Head.xRot * -0.5F;
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.xRot += angleX1 * 0.08F + headX;
	  	this.Hair02.xRot += -angleX2 * 0.08F + headX * 0.5F + 0.1F;
	  	this.Hair03.xRot += -angleX3 * 0.08F + headX * 0.5F + 0.1F;
	    this.Hair01.zRot += headZ;
	  	this.Hair02.zRot += headZ * 0.5F;
	  	this.Hair03.zRot += headZ * 0.5F;
		this.HairL01.xRot += angleX * 0.04F + headX;
	  	this.HairL02.xRot += angleX * 0.05F + headX * 0.8F;
	  	this.HairR01.xRot += angleX * 0.04F + headX;
	  	this.HairR02.xRot += angleX * 0.05F + headX * 0.8F;
	  	this.HairL01.zRot += headZ;
	  	this.HairL02.zRot += headZ;
	  	this.HairR01.zRot += headZ * 2.5F;
	  	this.HairR02.zRot += headZ * 0.8F;
	  	
	  	//swing arm
	  	float f6 = ent.getSwingTime(f2 - (int)f2);
	  	if(f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight01.xRot += -f8 * 80.0F * Values.N.DIV_PI_180 - 0.3F;
	        this.ArmRight01.yRot += -f7 * 20.0F * Values.N.DIV_PI_180 + 0.4F;
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
    	
    	
    	RenderHelper.animScale(this, this.scale, this.scale, this.scale);
this.animTransX += (0F); this.animTransY += (this.offsetY); this.animTransZ += (0F);
    	
    	//main body
		super.setupAnim(entity, f, f1, f2, f3, f4);
	}

}

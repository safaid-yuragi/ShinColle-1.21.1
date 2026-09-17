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

public class ModelBattleshipNagato<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart Butt;
	public ModelPart Cloth;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart HeadEquip;
	public ModelPart HeadEquip05;
	public ModelPart Ahoke;
	public ModelPart HairMidL01;
	public ModelPart HairMidL02;
	public ModelPart HeadEquip01;
	public ModelPart HeadEquip03;
	public ModelPart HeadEquip02;
	public ModelPart HeadEquip04;
	public ModelPart ArmLeft02;
	public ModelPart ArmRight02;
	public ModelPart LegRight;
	public ModelPart LegLeft;
	public ModelPart Skirt;
	public ModelPart ShoesR;
	public ModelPart ShoesL;
	public ModelPart SkirtEquip;
	public ModelPart EquipBase;
	public ModelPart EquipL01;
	public ModelPart EquipR01;
	public ModelPart EquipBaseM01;
	public ModelPart EquipBaseM02;
	public ModelPart EquipBaseM03;
	public ModelPart EquipL02;
	public ModelPart EquipL03;
	public ModelPart EquipR04;
	public ModelPart EquipLCBase01;
	public ModelPart EquipLC2Base01;
	public ModelPart EquipLC2Base02;
	public ModelPart EquipLC201;
	public ModelPart EquipLC203;
	public ModelPart EquipLC202;
	public ModelPart EquipLC204;
	public ModelPart EquipLCBase02;
	public ModelPart EquipLC01;
	public ModelPart EquipLC03;
	public ModelPart EquipLCRadar;
	public ModelPart EquipLC02;
	public ModelPart EquipLC04;
	public ModelPart EquipR02;
	public ModelPart EquipR03;
	public ModelPart EquipRCBase01;
	public ModelPart EquipR04_1;
	public ModelPart EquipRCBase02;
	public ModelPart EquipRC01;
	public ModelPart EquipRC03;
	public ModelPart EquipRCRadar;
	public ModelPart EquipRC02;
	public ModelPart EquipRC04;
	public ModelPart EquipRC2Base01;
	public ModelPart EquipRC2Base02;
	public ModelPart EquipRC201;
	public ModelPart EquipRC203;
	public ModelPart EquipRC202;
	public ModelPart EquipRC204;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -10.0F, -4.0F, 13.0F, 15.0F, 7.0F), PartPose.offset(0.0F, -14.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Cloth", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 2.0F, 9.0F), PartPose.offset(0.0F, -11.5F, -5.0F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-7.0F, -0.5F, -4.5F, 14.0F, 12.0F, 8.0F), PartPose.offset(0.0F, -10.0F, 0.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.0F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.2F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.0F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -3.0F, -10.0F, 0.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(-1.0F, -10.0F, -5.0F, 0.0F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef6 = partdef3.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 10.0F), PartPose.offset(0.0F, -15.0F, -3.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("HairMidL01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 13.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.5F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("HairMidL02", CubeListBuilder.create().addBox(-7.0F, 0.0F, 0.0F, 14.0F, 14.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.8F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef3.addOrReplaceChild("HeadEquip05", CubeListBuilder.create().addBox(-16.0F, 0.0F, 0.0F, 32.0F, 1.0F, 1.0F), PartPose.offset(0.0F, -11.5F, -1.0F));
		PartDefinition partdef10 = partdef3.addOrReplaceChild("HeadEquip", CubeListBuilder.create().addBox(-9.5F, 0.0F, 0.0F, 19.0F, 4.0F, 11.0F), PartPose.offsetAndRotation(0.0F, -8.0F, -1.0F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("HeadEquip03", CubeListBuilder.create().addBox(-4.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(-7.5F, 0.0F, 9.0F, 0.0F, 0.7853981633974483F, 0.17453292519943295F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("HeadEquip04", CubeListBuilder.create().addBox(-10.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-4.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef13 = partdef10.addOrReplaceChild("HeadEquip01", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(7.5F, 0.0F, 9.0F, 0.0F, -0.7853981633974483F, -0.17453292519943295F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("HeadEquip02", CubeListBuilder.create().mirror().addBox(0.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(4.0F, 1.0F, 0.0F, 0.0F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef15 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(-3.7F, -9.0F, -3.5F, -0.7853981633974483F, -0.13962634015954636F, -0.08726646259971647F));
		PartDefinition partdef16 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(3.7F, -9.0F, -3.5F, -0.7853981633974483F, 0.13962634015954636F, 0.08726646259971647F));
		PartDefinition partdef17 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(8.5F, -10.0F, 0.0F, 0F, 0.0F, -0.15707963267948966F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offset(0.0F, 10.0F, 0.0F));
		PartDefinition partdef19 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-8.5F, -10.0F, 0.0F, 0F, 0.0F, 0.15707963267948966F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offset(0.0F, 10.0F, 0.0F));
		PartDefinition partdef21 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-8.0F, 4.0F, -5.5F, 16.0F, 8.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("LegRight", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 19.0F, 6.0F), PartPose.offsetAndRotation(-4.5F, 9.5F, -3.0F, -0.2618F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("ShoesR", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 9.0F, 7.0F), PartPose.offset(0.0F, 19.0F, -0.2F));
		PartDefinition partdef24 = partdef21.addOrReplaceChild("Skirt", CubeListBuilder.create().addBox(-8.5F, 0.0F, -4.5F, 17.0F, 6.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 7.0F, -2.0F, -0.136659280431156F, 0.0F, 0.0F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("SkirtEquip", CubeListBuilder.create().addBox(-9.0F, 0.0F, -5.0F, 18.0F, 3.0F, 10.0F), PartPose.offset(0.0F, -3.0F, 0.2F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("EquipBaseM01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 12.0F, -0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef28 = partdef26.addOrReplaceChild("EquipBaseM03", CubeListBuilder.create().addBox(-3.0F, -14.0F, 0.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, -0.4363323129985824F, 0.0F, 0.0F));
		PartDefinition partdef29 = partdef26.addOrReplaceChild("EquipBaseM02", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, -1.5F, 11.0F));
		PartDefinition partdef30 = partdef26.addOrReplaceChild("EquipL01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 14.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 8.0F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("EquipL02", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 10.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(11.5F, 0.0F, 0.6F, 0.0F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("EquipL03", CubeListBuilder.create().addBox(0.0F, 0.0F, -14.0F, 6.0F, 18.0F, 14.0F), PartPose.offsetAndRotation(5.3F, 0.0F, 1.3F, 0.0F, -0.6981317007977318F, 0.0F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("EquipR04", CubeListBuilder.create().addBox(0.0F, 0.0F, -10.0F, 6.0F, 7.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 11.0F, -13.0F, 0.0F, 0.17453292519943295F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("EquipLC2Base01", CubeListBuilder.create().addBox(-4.5F, 0.0F, -10.0F, 9.0F, 10.0F, 10.0F), PartPose.offset(3.0F, -1.0F, -10.0F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("EquipLC2Base02", CubeListBuilder.create().addBox(-5.0F, -5.0F, -10.0F, 10.0F, 5.0F, 14.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("EquipLC201", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -4.0F, -8.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef37 = partdef36.addOrReplaceChild("EquipLC202", CubeListBuilder.create().addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef38 = partdef35.addOrReplaceChild("EquipLC203", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -4.0F, -8.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("EquipLC204", CubeListBuilder.create().addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef40 = partdef32.addOrReplaceChild("EquipLCBase01", CubeListBuilder.create().addBox(0.0F, -5.5F, -10.0F, 7.0F, 11.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 0.0F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("EquipLCBase02", CubeListBuilder.create().addBox(0.0F, -5.0F, -4.0F, 5.0F, 10.0F, 14.0F), PartPose.offsetAndRotation(7.0F, 0.0F, -6.5F, -0.17453292519943295F, 0.05235987755982988F, 0.0F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("EquipLC01", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(4.0F, -2.0F, -4.0F, 0.0F, -0.2617993877991494F, 0.0F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("EquipLC02", CubeListBuilder.create().addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef44 = partdef41.addOrReplaceChild("EquipLCRadar", CubeListBuilder.create().addBox(0.0F, -7.5F, 0.0F, 1.0F, 15.0F, 5.0F), PartPose.offset(5.2F, 0.0F, 5.5F));
		PartDefinition partdef45 = partdef41.addOrReplaceChild("EquipLC03", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(4.0F, 2.0F, -4.0F, 0.0F, -0.13962634015954636F, 0.0F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("EquipLC04", CubeListBuilder.create().addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef47 = partdef26.addOrReplaceChild("EquipR01", CubeListBuilder.create().addBox(-14.0F, 0.0F, 0.0F, 14.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 8.0F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("EquipR02", CubeListBuilder.create().addBox(-10.0F, 0.0F, 0.0F, 10.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-11.5F, 0.0F, 0.6F, 0.0F, -0.5235987755982988F, 0.0F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("EquipR03", CubeListBuilder.create().addBox(-6.0F, 0.0F, -14.0F, 6.0F, 18.0F, 14.0F), PartPose.offsetAndRotation(-5.3F, 0.0F, 1.3F, 0.0F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("EquipRCBase01", CubeListBuilder.create().addBox(-7.0F, -5.5F, -10.0F, 7.0F, 11.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 1.0F, -7.0F, 0.0F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("EquipRCBase02", CubeListBuilder.create().addBox(-5.0F, -5.0F, -4.0F, 5.0F, 10.0F, 14.0F), PartPose.offsetAndRotation(-7.0F, 0.0F, -6.5F, -0.17453292519943295F, -0.05235987755982988F, 0.0F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("EquipRC03", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-4.0F, 2.0F, -4.0F, 0.0F, 0.20943951023931953F, 0.0F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("EquipRC04", CubeListBuilder.create().addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef54 = partdef51.addOrReplaceChild("EquipRC01", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-4.0F, -2.0F, -4.0F, 0.0F, 0.2617993877991494F, 0.0F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("EquipRC02", CubeListBuilder.create().addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef56 = partdef51.addOrReplaceChild("EquipRCRadar", CubeListBuilder.create().addBox(-1.0F, -7.5F, 0.0F, 1.0F, 15.0F, 5.0F), PartPose.offset(-5.2F, 0.0F, 5.5F));
		PartDefinition partdef57 = partdef49.addOrReplaceChild("EquipR04_1", CubeListBuilder.create().addBox(-6.0F, 0.0F, -10.0F, 6.0F, 7.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 11.0F, -13.0F, 0.0F, -0.17453292519943295F, 0.0F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("EquipRC2Base01", CubeListBuilder.create().addBox(-4.5F, 0.0F, -10.0F, 9.0F, 10.0F, 10.0F), PartPose.offset(-3.0F, -1.0F, -10.0F));
		PartDefinition partdef59 = partdef58.addOrReplaceChild("EquipRC2Base02", CubeListBuilder.create().addBox(-5.0F, -5.0F, -10.0F, 10.0F, 5.0F, 14.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef60 = partdef59.addOrReplaceChild("EquipRC203", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -4.0F, -8.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("EquipRC204", CubeListBuilder.create().addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef62 = partdef59.addOrReplaceChild("EquipRC201", CubeListBuilder.create().addBox(-1.5F, -1.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, -4.0F, -8.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("EquipRC202", CubeListBuilder.create().addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef64 = partdef21.addOrReplaceChild("LegLeft", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 19.0F, 6.0F), PartPose.offsetAndRotation(4.5F, 9.5F, -3.0F, -0.2618F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef65 = partdef64.addOrReplaceChild("ShoesL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 9.0F, 7.0F), PartPose.offset(0.0F, 19.0F, -0.2F));
		PartDefinition partdef66 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, -14.0F, 0.0F));
		PartDefinition partdef67 = partdef66.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, 0.0F));
		PartDefinition partdef68 = partdef67.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));
		PartDefinition partdef69 = partdef68.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef70 = partdef68.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef71 = partdef68.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef72 = partdef68.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef73 = partdef68.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef74 = partdef68.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef75 = partdef68.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef76 = partdef68.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef77 = partdef68.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef78 = partdef68.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelBattleshipNagato(ModelPart root)
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
		this.LegRight = root.getChild("BodyMain").getChild("Butt").getChild("LegRight");
		this.Cloth = root.getChild("BodyMain").getChild("Cloth");
		this.EquipL02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.EquipBaseM01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipBaseM01");
		this.EquipRC03 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02").getChild("EquipRC03");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.ShoesR = root.getChild("BodyMain").getChild("Butt").getChild("LegRight").getChild("ShoesR");
		this.EquipL03 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03");
		this.EquipRCBase01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01");
		this.EquipLC04 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02").getChild("EquipLC03").getChild("EquipLC04");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.EquipRC2Base01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04_1").getChild("EquipRC2Base01");
		this.EquipRC204 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04_1").getChild("EquipRC2Base01").getChild("EquipRC2Base02").getChild("EquipRC203").getChild("EquipRC204");
		this.Skirt = root.getChild("BodyMain").getChild("Butt").getChild("Skirt");
		this.SkirtEquip = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip");
		this.HeadEquip03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadEquip").getChild("HeadEquip03");
		this.EquipRC04 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02").getChild("EquipRC03").getChild("EquipRC04");
		this.HairMidL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("HairMidL01").getChild("HairMidL02");
		this.HeadEquip04 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadEquip").getChild("HeadEquip03").getChild("HeadEquip04");
		this.EquipR02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.LegLeft = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft");
		this.ShoesL = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft").getChild("ShoesL");
		this.EquipBaseM03 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipBaseM03");
		this.EquipLC2Base01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipR04").getChild("EquipLC2Base01");
		this.EquipLC201 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipR04").getChild("EquipLC2Base01").getChild("EquipLC2Base02").getChild("EquipLC201");
		this.EquipRC02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02").getChild("EquipRC01").getChild("EquipRC02");
		this.EquipRC203 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04_1").getChild("EquipRC2Base01").getChild("EquipRC2Base02").getChild("EquipRC203");
		this.EquipR04_1 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04_1");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.EquipBaseM02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipBaseM02");
		this.EquipLC204 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipR04").getChild("EquipLC2Base01").getChild("EquipLC2Base02").getChild("EquipLC203").getChild("EquipLC204");
		this.EquipLC01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02").getChild("EquipLC01");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.HeadEquip02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadEquip").getChild("HeadEquip01").getChild("HeadEquip02");
		this.EquipR04 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipR04");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.HairMidL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("HairMidL01");
		this.EquipR03 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.HeadEquip05 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadEquip05");
		this.EquipLC202 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipR04").getChild("EquipLC2Base01").getChild("EquipLC2Base02").getChild("EquipLC201").getChild("EquipLC202");
		this.HeadEquip = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadEquip");
		this.BodyMain = root.getChild("BodyMain");
		this.EquipLC2Base02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipR04").getChild("EquipLC2Base01").getChild("EquipLC2Base02");
		this.EquipLC203 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipR04").getChild("EquipLC2Base01").getChild("EquipLC2Base02").getChild("EquipLC203");
		this.EquipLCRadar = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02").getChild("EquipLCRadar");
		this.EquipRC01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02").getChild("EquipRC01");
		this.EquipL01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01");
		this.HeadEquip01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadEquip").getChild("HeadEquip01");
		this.EquipRC2Base02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04_1").getChild("EquipRC2Base01").getChild("EquipRC2Base02");
		this.EquipLC03 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02").getChild("EquipLC03");
		this.EquipBase = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase");
		this.EquipLCBase02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02");
		this.EquipRC202 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04_1").getChild("EquipRC2Base01").getChild("EquipRC2Base02").getChild("EquipRC201").getChild("EquipRC202");
		this.EquipRCRadar = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02").getChild("EquipRCRadar");
		this.EquipRC201 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04_1").getChild("EquipRC2Base01").getChild("EquipRC2Base02").getChild("EquipRC201");
		this.EquipR01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01");
		this.EquipLCBase01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01");
		this.EquipLC02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02").getChild("EquipLC01").getChild("EquipLC02");
		this.EquipRCBase02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt").getChild("SkirtEquip").getChild("EquipBase").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.offsetItem = new float[] {0F, 0.92F, 0F};
		this.offsetBlock = new float[] {0F, 0.92F, 0F};
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
		
		boolean flag = !EmotionHelper.checkModelState(0, state);
		this.HeadEquip.visible = !(flag);
		this.HeadEquip05.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(1, state);
		this.EquipBase.visible = !(flag);
	
	}

	public void syncRotationGlowPart()
	{

		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowNeck.xRot = this.Neck.xRot;
		this.GlowNeck.yRot = this.Neck.yRot;
		this.GlowNeck.zRot = this.Neck.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (0.73F + 0.28F * ent.getScaleLevel()); this.animTransZ += (0F);
    	this.setFaceHungry(ent);
    	
    	//移動頭部使其看人
	  	this.Head.xRot = 0F;
	  	this.Head.yRot = 0F;
	    //胸部
  	    this.BoobL.xRot = -0.7854F;
  	    this.BoobR.xRot = -0.7854F;
	  	//Body
  	    this.Ahoke.yRot = 0.5236F;
	    //arm 
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmRight01.yRot = 0F;
    	//Body
	  	this.BodyMain.xRot = 1.48F;
	  	//hair
	  	this.HairMidL01.xRot = 0.2F;
	  	this.HairMidL02.xRot = -0.3F;
	    //arm 
	  	this.ArmLeft01.xRot = -2.97F;
	  	this.ArmLeft01.zRot = 0.26F;
		this.ArmRight01.xRot = -2.8F;
		this.ArmRight01.zRot = -1.3F;
		this.ArmRight02.zRot = -0.9F;
		//leg
		this.LegLeft.xRot = -0.26F;
		this.LegRight.xRot = -0.26F;
		this.LegLeft.yRot = 0F;
		this.LegRight.yRot = 0F;
		this.LegLeft.zRot = -0.14F;
		this.LegRight.zRot = 0.14F;
		//equip
		this.EquipBase.visible = false;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F);
  		float angleX1 = Mth.cos(f2*0.08F + 0.3F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
  		float addk1 = 0;
  		float addk2 = 0;
  		boolean showCannon = EmotionHelper.checkModelState(1, ent.getStateEmotion(ID.S.State));
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//leg move parm
  		addk1 = angleAdd1 - 0.2118F;
	  	addk2 = angleAdd2 - 0.1118F;

  	    //移動頭部使其看人
	  	this.Head.xRot = f4 * 0.014F + 0.1F;
	  	this.Head.yRot = f3 * 0.01F;
	    
	    //正常站立動作
	    //胸部
  	    this.BoobL.xRot = angleX * 0.06F - 0.7854F;
  	    this.BoobR.xRot = angleX * 0.06F - 0.7854F;
	  	//Body
  	    this.Ahoke.yRot = angleX * 0.25F + 0.5236F;
	  	this.BodyMain.xRot = -0.1F;
	  	//hair
	  	this.HairMidL01.xRot = angleX * 0.06F + 0.2F;
	  	this.HairMidL02.xRot = -angleX1 * 0.09F - 0.17F;
	  	this.HairMidL01.zRot = 0F;
	  	this.HairMidL02.zRot = 0F;
	    //arm 
	  	this.ArmLeft01.xRot = angleAdd2 * 0.6F + 0.15F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = angleX * 0.1F - 0.26F;
	    this.ArmRight01.xRot = angleAdd1 * 0.6F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -angleX * 0.1F + 0.26F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.yRot = 0F;
		this.ArmRight02.zRot = 0F;
		//leg
		this.LegLeft.yRot = 0F;
		this.LegLeft.zRot = 0.05F;
		this.LegRight.yRot = 0F;
		this.LegRight.zRot = -0.05F;
		//cannon
		if (showCannon)
		{
			this.EquipBase.xRot = 0.17F;
			
			if (this.Head.xRot <= 0F)
			{
				this.EquipLC201.xRot = this.Head.xRot * 0.9F;
				this.EquipLC203.xRot = this.Head.xRot * 1.2F;
				this.EquipRC201.xRot = this.Head.xRot * 1.1F;
				this.EquipRC203.xRot = this.Head.xRot * 0.85F;
			}
			
			this.EquipLCBase02.xRot = this.Head.xRot;
			this.EquipLC2Base01.xRot = 0F;
			this.EquipLC2Base02.yRot = this.Head.yRot;
			this.EquipLC01.yRot = angleX * 0.1F - 0.26F;
			this.EquipLC03.yRot = -angleX * 0.08F - 0.15F;

			
			this.EquipRCBase02.xRot = this.Head.xRot;
			this.EquipRC2Base01.xRot = 0F;
			this.EquipRC2Base02.yRot = this.Head.yRot;
			this.EquipRC01.yRot = angleX * 0.08F + 0.2F;
			this.EquipRC03.yRot = -angleX * 0.1F + 0.1F;
		}


	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {	//奔跑動作
	    	//Body
	    	this.Head.xRot -= 0.35F;
		  	this.BodyMain.xRot = 0.5236F;
		  	//hair
		  	this.HairMidL01.xRot += 0.3F;
		  	this.HairMidL02.xRot += 0.3F;
		    //arm 
		  	this.ArmLeft01.xRot = angleAdd2 * 1.4F - 0.1F;
		    this.ArmRight01.xRot = angleAdd1 * 1.4F - 0.1F;
		    this.ArmLeft01.zRot = angleX * 0.1F - 0.4F;
			this.ArmRight01.zRot = -angleX * 0.1F + 0.4F;
			//leg
			addk1 -= 0.55F;
			addk2 -= 0.55F;
			this.LegLeft.yRot = 0F;
			this.LegRight.yRot = 0F;
			this.LegLeft.zRot = 0F;
			this.LegRight.zRot = 0F;
			//cannon
			if (showCannon)
			{
				this.EquipLCBase02.xRot -= 0.45F;
//				this.EquipLC201.xRot -= 0.5F;
//				this.EquipLC203.xRot -= 0.55F;
				
				this.EquipRCBase02.xRot -= 0.5F;
//				this.EquipRC201.xRot -= 0.6F;
//				this.EquipRC203.xRot -= 0.5F;
			}
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {	//潛行, 蹲下動作
	    	//Body
	    	this.Head.xRot -= 0.35F;
		  	this.BodyMain.xRot = 0.5236F;
		    //arm 
		    this.ArmLeft01.zRot = angleX * 0.1F - 0.4F;
			this.ArmRight01.zRot = -angleX * 0.1F + 0.4F;
			//leg
			addk1 -= 0.55F;
			addk2 -= 0.55F;
			this.LegLeft.yRot = 0F;
			this.LegRight.yRot = 0F;
			this.LegLeft.zRot = 0F;
			this.LegRight.zRot = 0F;
			//cannon
			if (showCannon)
			{
				this.EquipLCBase02.xRot -= 0.45F;
//				this.EquipLC201.xRot -= 0.5F;
//				this.EquipLC203.xRot -= 0.55F;
				
				this.EquipRCBase02.xRot -= 0.5F;
//				this.EquipRC201.xRot -= 0.6F;
//				this.EquipRC203.xRot -= 0.5F;
			}
  		}//end if sneaking
  		
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {  //騎乘動作
	    	if (showCannon)
	    	{
this.animTransX += (0F); this.animTransY += (0.42F); this.animTransZ += (0F);
		    	//Body
			  	this.BodyMain.xRot = -0.09F;
			    //arm 
			  	this.ArmLeft01.xRot = 0.52F;
			  	this.ArmLeft01.zRot = -1.04F;
				this.ArmRight01.xRot = 0.52F;
				this.ArmRight01.zRot = 1.04F;
				//leg
				addk1 = -1.4F;
				addk2 = -1.4F;
				this.LegLeft.yRot = -0.14F;
				this.LegRight.yRot = 0.14F;
				this.LegLeft.zRot = 0F;
				this.LegRight.zRot = 0F;
				//cannon
				this.EquipLCBase02.xRot = 1.57F;
				this.EquipLC2Base01.xRot = 0.8F;
				this.EquipLC01.yRot = 0F;
				this.EquipLC03.yRot = 0F;
				this.EquipLC201.xRot = 0F;
				this.EquipLC203.xRot = 0F;
				
				this.EquipRCBase02.xRot = 1.57F;
				this.EquipRC2Base01.xRot = 0.8F;
				this.EquipRC01.yRot = 0F;
				this.EquipRC03.yRot = 0F;
				this.EquipRC201.xRot = 0F;
				this.EquipRC203.xRot = 0F;
			}
	    	else if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
this.animTransX += (0F); this.animTransY += (0.71F); this.animTransZ += (0F);
	    		this.setFaceHungry(ent);
		    	//Body
			  	this.BodyMain.xRot = 1.48F;
			  	//hair
			  	this.HairMidL01.xRot = 0.2F;
			  	this.HairMidL02.xRot = -0.3F;
			    //arm 
			  	this.ArmLeft01.xRot = -2.97F;
			  	this.ArmLeft01.zRot = 0.26F;
				this.ArmRight01.xRot = -2.8F;
				this.ArmRight01.zRot = -1.3F;
				this.ArmRight02.zRot = -0.9F;
				//leg
				addk1 = -0.26F;
				addk2 = -0.26F;
				this.LegLeft.yRot = 0F;
				this.LegRight.yRot = 0F;
				this.LegLeft.zRot = -0.14F;
				this.LegRight.zRot = 0.14F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.52F); this.animTransZ += (0F);
		    	//Body
			  	this.BodyMain.xRot = -0.09F;
			    //arm 
			  	this.ArmLeft01.xRot = -0.63F;
			  	this.ArmLeft01.zRot = 0.14F;
				this.ArmRight01.xRot = -0.63F;
				this.ArmRight01.zRot = -0.14F;
				//leg
				addk1 = -1.75F;
				addk2 = -1.75F;
				this.LegLeft.yRot = -0.14F;
				this.LegRight.yRot = 0.14F;
				this.LegLeft.zRot = 0F;
				this.LegRight.zRot = 0F;
	    	}
  		}//end if sitting
	    
	    //攻擊動作    
	    if (ent.getAttackTick() > 20)
	    {
	    	switch (ent.getStateEmotion(ID.S.Phase))
	    	{
	    	case 0:		//heavy atk phase 0
	    	case 2:		//heavy atk phase 2
this.animTransX += (0F); this.animTransY += (scale * 0.35F + 0F); this.animTransZ += (0F);
	    	    //Body
	    	    this.Head.xRot -= 1.22F;
	    	  	this.BodyMain.xRot = 1.75F;
	    	  	//hair
	    	  	this.HairMidL01.xRot += 0.3F;
	    	  	this.HairMidL02.xRot += 0.6F;
	    	    //arm 
	    	  	this.ArmLeft01.xRot = -1.75F;
	    	  	this.ArmLeft01.yRot = 0F;
	    	  	this.ArmLeft01.zRot = 0F;
	    		this.ArmRight01.xRot = -1.05F;
	    		this.ArmRight01.yRot = 2.62F;
	    		this.ArmRight01.zRot = 0.7F;
	    		this.ArmRight02.zRot = -0.79F;
	    		//leg
	    		addk1 = -1.75F;
	    		addk2 = -2.27F;
	    		this.LegLeft.yRot = -0.44F;
	    		this.LegRight.yRot = 0.44F;
	    		this.LegLeft.zRot = 0F;
	    		this.LegRight.zRot = 0F;
	    		//equip
	    		this.EquipBase.xRot = -1.22F;	
	    		this.EquipLCBase02.xRot -= 0.5F;
//	    		this.EquipLC201.xRot -= 0.5F;
//	    		this.EquipLC203.xRot -= 0.5F;   		
	    		this.EquipRCBase02.xRot -= 0.5F;
//	    		this.EquipRC201.xRot -= 0.5F;
//	    		this.EquipRC203.xRot -= 0.5F;
	    		break;
	    	default:	//cannon or heavy atk phase 1,3
//	    		setFace(3);
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
				addk1 += 0.2618F;
				addk2 += 0.2618F;
				this.LegLeft.yRot = 0F;
				this.LegRight.yRot = 0F;
				this.LegLeft.zRot = -0.17F;
				this.LegRight.zRot = 0.17F;
	    		break;
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
	        this.ArmRight02.xRot = 0F;
	        this.ArmRight02.yRot = 0F;
	        this.ArmRight02.zRot = 0F;
	  	}
	  	
	  	//鬢毛調整
	    float headX = this.Head.xRot * -0.5F;
	    float headZ = this.Head.zRot * -0.5F;
	    this.HairMidL01.xRot += headX;
	    this.HairMidL01.zRot += headZ;
	    this.HairMidL02.xRot += headX * 0.5F;
	    this.HairMidL02.zRot += headZ * 0.5F;

	    
	    //leg motion
	    this.LegLeft.xRot = addk1;
	    this.LegRight.xRot = addk2;
	
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
    		scale = 2F;
        	offsetY = -0.73F;
		break;
    	case 2:
    		scale = 1.5F;
        	offsetY = -0.48F;
		break;
    	case 1:
    		scale = 1F;
        	offsetY = 0.02F;
		break;
    	default:
    		scale = 0.5F;
        	offsetY = 1.51F;
		break;
    	}
    	
    	
    	RenderHelper.animScale(this, scale, scale, scale);
this.animTransX += (0F); this.animTransY += (offsetY); this.animTransZ += (0F);
    	
    	//main body
		super.setupAnim(entity, f, f1, f2, f3, f4);
	}

}

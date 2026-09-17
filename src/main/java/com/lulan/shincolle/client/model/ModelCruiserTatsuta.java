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

public class ModelCruiserTatsuta<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart Butt;
	public ModelPart ArmRight01;
	public ModelPart ArmLeft01;
	public ModelPart Cloth01;
	public ModelPart Equip00;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart CirBase;
	public ModelPart HairU01;
	public ModelPart Ahoke;
	public ModelPart Hair01;
	public ModelPart Cir00;
	public ModelPart Cir01;
	public ModelPart Cir02;
	public ModelPart Cir03;
	public ModelPart Cir04;
	public ModelPart LegLeft01;
	public ModelPart Skirt01;
	public ModelPart LegRight01;
	public ModelPart LegLeft02;
	public ModelPart Skirt02;
	public ModelPart LegRight02;
	public ModelPart ArmRight02;
	public ModelPart ArmLeft02;
	public ModelPart EquipSL00;
	public ModelPart EquipSL01;
	public ModelPart EquipSL04;
	public ModelPart EquipSL02;
	public ModelPart EquipSL03a;
	public ModelPart EquipSL03b;
	public ModelPart EquipSL03c;
	public ModelPart EquipSL05;
	public ModelPart Equip01a;
	public ModelPart Equip01b;
	public ModelPart Equip01c;
	public ModelPart Equip02a;
	public ModelPart Equip01d;
	public ModelPart Equip03L;
	public ModelPart Equip03R;
	public ModelPart EquipCL01;
	public ModelPart EquipCL02;
	public ModelPart EquipCL03a;
	public ModelPart EquipCL03b;
	public ModelPart EquipCL03c;
	public ModelPart EquipCR01;
	public ModelPart EquipCR02;
	public ModelPart EquipCR03a;
	public ModelPart EquipCR03b;
	public ModelPart EquipCR03c;
	public ModelPart Equip02b;
	public ModelPart Equip02c;
	public ModelPart Equip02d;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ModelPart GlowBodyMain2;
	public ModelPart GlowNeck2;
	public ModelPart GlowHead2;
	public ModelPart GlowEquip00;
	public ModelPart GlowEquip01a;
	public ModelPart GlowEquip02a;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().mirror().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, -0.17453292519943295F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("ArmRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(-3.0F, 11.0F, 2.5F));
		PartDefinition partdef3 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-2.1F, -8.0F, -3.6F, -0.6981317007977318F, 0.10471975511965977F, 0.13962634015954636F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(2.0F, -8.0F, -3.7F, -0.6981317007977318F, -0.09250245035569946F, -0.13962634015954636F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-2.5F, -2.0F, -3.6F, 5.0F, 2.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.7F, 0.1F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -1.0F, -5.5F, 0.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(-2.5F, -4.0F, -7.5F, 0.2617993877991494F, 1.8325957145940461F, 0.2617993877991494F));
		PartDefinition partdef9 = partdef7.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F), PartPose.offset(0.0F, -6F, -6.9F));
		PartDefinition partdef10 = partdef6.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-8.0F, 0.0F, -8.0F, 16.0F, 7.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 8.2F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.3141592653589793F, 0.0F, -0.5235987755982988F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(3.0F, 11.0F, 2.5F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("EquipSL00", CubeListBuilder.create().addBox(-0.5F, -6.0F, -0.5F, 1.0F, 12.0F, 1.0F), PartPose.offsetAndRotation(-2.5F, 10.0F, -2.0F, -1.5707963267948966F, -0.08726646259971647F, 0.5235987755982988F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("EquipSL04", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -17.9F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("EquipSL05", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -11.9F, 0.0F));
		PartDefinition partdef17 = partdef14.addOrReplaceChild("EquipSL01", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 12.0F, 1.0F), PartPose.offset(0.0F, 5.9F, 0.0F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("EquipSL02", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 12.0F, 1.0F), PartPose.offset(0.0F, 11.9F, 0.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("EquipSL03c", CubeListBuilder.create().addBox(-0.5F, -7.0F, -2.0F, 1.0F, 8.0F, 2.0F), PartPose.offsetAndRotation(-0.1F, 13.9F, 3.1F, -0.03490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef18.addOrReplaceChild("EquipSL03a", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 14.0F, 3.0F), PartPose.offset(0.0F, 11.9F, -0.4F));
		PartDefinition partdef21 = partdef18.addOrReplaceChild("EquipSL03b", CubeListBuilder.create().addBox(-0.5F, -11.0F, -1.0F, 1.0F, 11.0F, 1.0F), PartPose.offsetAndRotation(-0.1F, 25.7F, 2.1F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdef0.addOrReplaceChild("Equip00", CubeListBuilder.create().addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 5.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("Equip01a", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 5.0F), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("Equip02a", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 7.0F, 4.0F), PartPose.offset(0.0F, -0.4F, 10.0F));
		PartDefinition partdef25 = partdef23.addOrReplaceChild("Equip01b", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 11.0F, 5.0F), PartPose.offset(0.0F, 7.0F, 0.0F));
		PartDefinition partdef26 = partdef23.addOrReplaceChild("Equip01c", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 5.0F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("Equip01d", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 11.0F, 5.0F), PartPose.offset(0.0F, 7.0F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("Equip03R", CubeListBuilder.create().mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 8.0F, 2.0F), PartPose.offset(-5.0F, 1.5F, 4.5F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("EquipCR01", CubeListBuilder.create().mirror().addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(-3.5F, 3.5F, 2.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("EquipCR02", CubeListBuilder.create().mirror().addBox(-1.0F, -3.0F, -4.0F, 1.0F, 7.0F, 9.0F), PartPose.offset(-1.9F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("EquipCR03c", CubeListBuilder.create().addBox(-1.0F, -7.0F, -1.0F, 2.0F, 14.0F, 2.0F), PartPose.offsetAndRotation(-1.9F, -0.5F, 2.7F, 0.0F, -0.3490658503988659F, 0.0F));
		PartDefinition partdef32 = partdef30.addOrReplaceChild("EquipCR03b", CubeListBuilder.create().addBox(-1.0F, -7.0F, -1.0F, 2.0F, 14.0F, 2.0F), PartPose.offsetAndRotation(-1.9F, -0.5F, 0.5F, 0.0F, -0.3490658503988659F, 0.0F));
		PartDefinition partdef33 = partdef30.addOrReplaceChild("EquipCR03a", CubeListBuilder.create().addBox(-1.0F, -7.0F, -1.0F, 2.0F, 14.0F, 2.0F), PartPose.offsetAndRotation(-1.9F, -0.5F, -1.7F, 0.0F, -0.3490658503988659F, 0.0F));
		PartDefinition partdef34 = partdef27.addOrReplaceChild("Equip03L", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 8.0F, 2.0F), PartPose.offset(5.0F, 1.5F, 4.5F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("EquipCL01", CubeListBuilder.create().addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(3.5F, 3.5F, 2.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("EquipCL02", CubeListBuilder.create().addBox(0.0F, -3.0F, -4.0F, 1.0F, 7.0F, 9.0F), PartPose.offset(1.9F, 0.0F, 0.0F));
		PartDefinition partdef37 = partdef36.addOrReplaceChild("EquipCL03b", CubeListBuilder.create().addBox(-1.0F, -7.0F, -1.0F, 2.0F, 14.0F, 2.0F), PartPose.offsetAndRotation(1.9F, -0.5F, 0.5F, 0.0F, 0.3490658503988659F, 0.0F));
		PartDefinition partdef38 = partdef36.addOrReplaceChild("EquipCL03a", CubeListBuilder.create().addBox(-1.0F, -7.0F, -1.0F, 2.0F, 14.0F, 2.0F), PartPose.offsetAndRotation(1.9F, -0.5F, -1.7F, 0.0F, 0.3490658503988659F, 0.0F));
		PartDefinition partdef39 = partdef36.addOrReplaceChild("EquipCL03c", CubeListBuilder.create().addBox(-1.0F, -7.0F, -1.0F, 2.0F, 14.0F, 2.0F), PartPose.offsetAndRotation(1.9F, -0.5F, 2.7F, 0.0F, 0.3490658503988659F, 0.0F));
		PartDefinition partdef40 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("LegRight01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.08726646259971647F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("LegRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(-3.0F, 14.0F, -3.0F));
		PartDefinition partdef43 = partdef40.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -6.0F, 17.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 2.9F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-9.0F, 0.0F, -6.0F, 18.0F, 4.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 2.8F, -0.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef45 = partdef40.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("LegLeft02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(3.0F, 14.0F, -3.0F));
		PartDefinition partdef47 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -9.6F, -3.8F, -0.5759586531581287F, 0.0F, 0.0F));
		PartDefinition partdef48 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -0.7F));
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
		PartDefinition partdef61 = partdef48.addOrReplaceChild("GlowEquip00", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 5.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("GlowEquip01a", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("GlowEquip02a", CubeListBuilder.create(), PartPose.offset(0.0F, -0.4F, 10.0F));
		PartDefinition partdef64 = partdef63.addOrReplaceChild("Equip02b", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 4.0F));
		PartDefinition partdef65 = partdef64.addOrReplaceChild("Equip02c", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 8.0F, 1.0F), PartPose.offset(0.0F, 3.0F, 4.0F));
		PartDefinition partdef66 = partdef65.addOrReplaceChild("Equip02d", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -1.0F, 0.0F));
		PartDefinition partdef67 = partdefinition.addOrReplaceChild("GlowBodyMain2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef68 = partdef67.addOrReplaceChild("GlowNeck2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef69 = partdef68.addOrReplaceChild("GlowHead2", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef70 = partdef69.addOrReplaceChild("CirBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -21.0F, 4.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef71 = partdef70.addOrReplaceChild("Cir00", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef72 = partdef71.addOrReplaceChild("Cir01", CubeListBuilder.create().addBox(-6.0F, 0.0F, -0.5F, 12.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.5F, 0.0F, 3.141592653589793F, 0.0F));
		PartDefinition partdef73 = partdef71.addOrReplaceChild("Cir02", CubeListBuilder.create().addBox(-6.0F, 0.0F, -0.5F, 12.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 5.5F));
		PartDefinition partdef74 = partdef71.addOrReplaceChild("Cir03", CubeListBuilder.create().addBox(-6.0F, 0.0F, -0.5F, 12.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, 0.0F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef75 = partdef71.addOrReplaceChild("Cir04", CubeListBuilder.create().addBox(-6.0F, 0.0F, -0.5F, 12.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(-5.5F, 0.0F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelCruiserTatsuta(ModelPart root)
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
		this.EquipCL03b = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03L").getChild("EquipCL01").getChild("EquipCL02").getChild("EquipCL03b");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.Equip01a = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.EquipSL00 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.Equip02c = root.getChild("GlowBodyMain").getChild("GlowEquip00").getChild("GlowEquip01a").getChild("GlowEquip02a").getChild("Equip02b").getChild("Equip02c");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.EquipCR03c = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03R").getChild("EquipCR01").getChild("EquipCR02").getChild("EquipCR03c");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.Equip02b = root.getChild("GlowBodyMain").getChild("GlowEquip00").getChild("GlowEquip01a").getChild("GlowEquip02a").getChild("Equip02b");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.EquipCR01 = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03R").getChild("EquipCR01");
		this.Cir01 = root.getChild("GlowBodyMain2").getChild("GlowNeck2").getChild("GlowHead2").getChild("CirBase").getChild("Cir00").getChild("Cir01");
		this.Equip01d = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d");
		this.Cir02 = root.getChild("GlowBodyMain2").getChild("GlowNeck2").getChild("GlowHead2").getChild("CirBase").getChild("Cir00").getChild("Cir02");
		this.Equip03R = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03R");
		this.EquipSL02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00").getChild("EquipSL01").getChild("EquipSL02");
		this.Equip00 = root.getChild("BodyMain").getChild("Equip00");
		this.EquipSL04 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00").getChild("EquipSL04");
		this.EquipCL01 = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03L").getChild("EquipCL01");
		this.EquipCR02 = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03R").getChild("EquipCR01").getChild("EquipCR02");
		this.Equip02a = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip02a");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.EquipCR03b = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03R").getChild("EquipCR01").getChild("EquipCR02").getChild("EquipCR03b");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.Cir04 = root.getChild("GlowBodyMain2").getChild("GlowNeck2").getChild("GlowHead2").getChild("CirBase").getChild("Cir00").getChild("Cir04");
		this.EquipCL03a = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03L").getChild("EquipCL01").getChild("EquipCL02").getChild("EquipCL03a");
		this.Equip02d = root.getChild("GlowBodyMain").getChild("GlowEquip00").getChild("GlowEquip01a").getChild("GlowEquip02a").getChild("Equip02b").getChild("Equip02c").getChild("Equip02d");
		this.HairU01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairU01");
		this.EquipCL03c = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03L").getChild("EquipCL01").getChild("EquipCL02").getChild("EquipCL03c");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.CirBase = root.getChild("GlowBodyMain2").getChild("GlowNeck2").getChild("GlowHead2").getChild("CirBase");
		this.Equip03L = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03L");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.Equip01b = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01b");
		this.BodyMain = root.getChild("BodyMain");
		this.EquipSL05 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00").getChild("EquipSL04").getChild("EquipSL05");
		this.EquipCL02 = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03L").getChild("EquipCL01").getChild("EquipCL02");
		this.EquipSL03c = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00").getChild("EquipSL01").getChild("EquipSL02").getChild("EquipSL03c");
		this.EquipSL03a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00").getChild("EquipSL01").getChild("EquipSL02").getChild("EquipSL03a");
		this.Equip01c = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c");
		this.EquipSL01 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00").getChild("EquipSL01");
		this.Cir03 = root.getChild("GlowBodyMain2").getChild("GlowNeck2").getChild("GlowHead2").getChild("CirBase").getChild("Cir00").getChild("Cir03");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.Cir00 = root.getChild("GlowBodyMain2").getChild("GlowNeck2").getChild("GlowHead2").getChild("CirBase").getChild("Cir00");
		this.EquipSL03b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipSL00").getChild("EquipSL01").getChild("EquipSL02").getChild("EquipSL03b");
		this.EquipCR03a = root.getChild("BodyMain").getChild("Equip00").getChild("Equip01a").getChild("Equip01c").getChild("Equip01d").getChild("Equip03R").getChild("EquipCR01").getChild("EquipCR02").getChild("EquipCR03a");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.GlowBodyMain2 = root.getChild("GlowBodyMain2");
		this.GlowNeck2 = root.getChild("GlowBodyMain2").getChild("GlowNeck2");
		this.GlowHead2 = root.getChild("GlowBodyMain2").getChild("GlowNeck2").getChild("GlowHead2");
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
		poseStack.pushPose();
		poseStack.translate(this.animTransX, this.animTransY, this.animTransZ);
		poseStack.mulPose(this.animRot);
		poseStack.scale(this.animScaleX, this.animScaleY, this.animScaleZ);
    	this.BodyMain.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
    	//light part
		glowLight = true;
    	this.GlowBodyMain.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
    	float light = 80F + Mth.cos(f2 * 0.125F) * 120F;
		glowLight = false;
    	this.GlowBodyMain2.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
    	
    	poseStack.popPose();
    
	}

	public void showEquip(IShipEmotion ent)
	{

		int state = ent.getStateEmotion(ID.S.State);
		
		boolean flag = !EmotionHelper.checkModelState(0, state);	//cannon
		this.Equip00.visible = !(flag);
		this.GlowEquip00.visible = !(flag);
				
		flag = !EmotionHelper.checkModelState(1, state);	//head
		this.CirBase.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);	//weapon
		this.EquipSL00.visible = !(flag);
	
	}

	public void syncRotationGlowPart()
	{

		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
		this.GlowBodyMain2.xRot = this.BodyMain.xRot;
		this.GlowBodyMain2.yRot = this.BodyMain.yRot;
		this.GlowBodyMain2.zRot = this.BodyMain.zRot;
		this.GlowHead2.xRot = this.Head.xRot;
		this.GlowHead2.yRot = this.Head.yRot;
		this.GlowHead2.zRot = this.Head.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (0.51F + 0.26F * ent.getScaleLevel()); this.animTransZ += (0F);
		this.setFaceHungry(ent);

		//body
		this.Head.xRot = 0.9599310885968813F;
		this.Head.yRot = 0.0F;
		this.Head.zRot = 0.0F;
		this.Ahoke.xRot = 0.2617993877991494F;
		this.Ahoke.yRot = 1.8325957145940461F;
		this.Ahoke.zRot = 0.2617993877991494F;
		this.BodyMain.xRot = -0.2617993877991494F;
    	this.Butt.xRot = -0.2617993877991494F;
    	this.Butt.y = (4.0F) + (0F) * 16F;
    	this.Skirt01.xRot = -0.17453292519943295F;
	  	this.Skirt01.y = (2.9F) + (0F) * 16F;
	  	this.Skirt02.xRot = -0.20943951023931953F;
	  	this.Skirt02.y = (2.8F) + (0F) * 16F;
    	//arm
		this.ArmLeft01.xRot = 0.4141592653589793F;
		this.ArmLeft01.yRot = 0.0F;
		this.ArmLeft01.zRot = -0.4363323129985824F;
		this.ArmLeft02.xRot = -0.10471975511965977F;
		this.ArmLeft02.yRot = 0.0F;
		this.ArmLeft02.zRot = 0.0F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
		this.ArmRight01.xRot = 0.3617993877991494F;
		this.ArmRight01.yRot = 0.0F;
		this.ArmRight01.zRot = 0.27314402793711257F;
		this.ArmRight02.xRot = -0.27314402793711257F;
		this.ArmRight02.yRot = 0.0F;
		this.ArmRight02.zRot = 0.0F;
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
		this.ArmRight02.z = (2.5F) + (0F) * 16F;
		//equip
		this.EquipSL00.xRot = -1.68352986419518F;
		this.EquipSL00.yRot = 0F;
		this.EquipSL00.zRot = -1.1F;
		this.EquipCL02.xRot = 1.63F;
		this.EquipCR02.xRot = 1.63F;
		this.Cir00.yRot = 0F;
		this.CirBase.y = (-21.0F) + (0.26F) * 16F;
    	//leg
		this.LegLeft01.xRot = -1.7453292519943295F;
		this.LegLeft01.yRot = -0.5462880558742251F;
		this.LegLeft01.zRot = 1.48352986419518F;
		this.LegLeft02.xRot = 0.4363323129985824F;
		this.LegLeft02.yRot = 0.0F;
		this.LegLeft02.zRot = 0.0F;
		this.LegLeft02.x = (3.0F) + (0F) * 16F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.xRot = -1.5707963267948966F;
		this.LegRight01.yRot = 0.08726646259971647F;
		this.LegRight01.zRot = -0.17453292519943295F;
		this.LegRight02.xRot = 1.1344640137963142F;
		this.LegRight02.yRot = 0.0F;
		this.LegRight02.zRot = 0.0F;
		this.LegRight02.x = (-3.0F) + (0F) * 16F;
		this.LegRight02.y = (14.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
	
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
  		boolean spcStand = false;
  		
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
	  	this.Cloth01.xRot = angleX * 0.06F - 0.7F;
  	    this.BoobL.xRot = angleX * 0.06F - 0.8F;
  	    this.BoobR.xRot = angleX * 0.06F - 0.8F;
	  	//body
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
		this.Cir00.yRot = 0F;
		this.CirBase.y = (-21.0F) + (0F) * 16F;
		this.EquipSL00.xRot = -1.1F;
		this.EquipSL00.yRot = 0.4F;
		this.EquipSL00.zRot = 0F;
		this.EquipSL00.x = (-2.5F) + (0F) * 16F;
		this.EquipSL00.y = (10.0F) + (0F) * 16F;
		this.EquipSL00.z = (-2.0F) + (0F) * 16F;
		this.EquipCL02.xRot = f4 * 0.015F + 0.7F;
		this.EquipCR02.xRot = f4 * 0.015F + 0.7F;
		
		//special stand pos
		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		{
			spcStand = true;
			
			if (t2 > 320)
			{
				setFace(8);
			}
			else if (t2 > 160)
			{
				setFace(0);
			}
			else
			{
				setFace(1);
			}
			
			this.Head.yRot = 0F;
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
			//equip
			this.EquipSL00.xRot = -1.17F;
			this.EquipSL00.yRot = 1.45F;
			this.EquipSL00.zRot = 0.0F;
			
			if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED)
			{
				//arm
				this.ArmLeft01.xRot = 0.6981317007977318F;
				this.ArmLeft01.yRot = -1.0471975511965976F;
				this.ArmLeft01.zRot = -2.443460952792061F;
				this.ArmLeft02.xRot = -1.3962634015954636F;
				this.ArmLeft02.yRot = 0.0F;
				this.ArmLeft02.zRot = 0.0F;
				//equip
				this.EquipSL00.xRot = -1.5707963267948966F;
				this.EquipSL00.yRot = 0.9F;
				this.EquipSL00.zRot = 0.0F;
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
		  	this.ArmRight02.zRot = 0F;
	    	//leg
	  		addk1 = angleAdd1 * 1F - 0.28F;  //LegLeft01
		  	addk2 = angleAdd2 * 1F - 0.21F;  //LegRight01
		  	//equip
			this.EquipSL00.xRot = -1.5F;
			this.EquipSL00.yRot = 0.2F;
			this.EquipSL00.zRot = 0F;
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
		    this.Cir00.yRot = f2 * 0.025F;
  		}//end if sneaking
  		
	    //坐下動作
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
this.animTransX += (0F); this.animTransY += (0.5F); this.animTransZ += (0F);
		    	//body
		    	this.Head.xRot = 0.0F;
		    	this.Head.yRot += 1.2217304763960306F;
		    	this.Head.zRot = -0.08726646259971647F;
		    	this.BodyMain.xRot = -0.35F;
		    	this.BodyMain.yRot = -1.4486232791552935F;
		    	this.Butt.xRot = -0.3839724354387525F;
		    	this.Skirt01.xRot = -0.17453292519943295F;
				this.Skirt02.xRot = -0.2617993877991494F;
				//arm
				this.ArmLeft01.xRot = -1.22F;
				this.ArmLeft01.yRot = 0.3141592653589793F;
				this.ArmLeft01.zRot = 0.0F;
		    	this.ArmLeft02.xRot = 0.0F;
		    	this.ArmLeft02.zRot = 0.0F;
				this.ArmLeft02.x = (3.0F) + (0F) * 16F;
				this.ArmLeft02.z = (2.5F) + (0F) * 16F;
		    	this.ArmRight01.xRot = -0.17453292519943295F;
		    	this.ArmRight01.yRot = 0.0F;
		    	this.ArmRight01.zRot = 0.2617993877991494F;
		    	this.ArmRight02.xRot = 0.0F;
		    	this.ArmRight02.zRot = 0.0F;
				this.ArmRight02.x = (-3.0F) + (0F) * 16F;
				this.ArmRight02.z = (2.5F) + (0F) * 16F;
				//leg
				addk1 = -1.57F;
				addk2 = -1.4F;
		    	this.LegLeft01.zRot = 0.08726646259971647F;
		    	this.LegLeft02.xRot = 0.6108652381980153F;
		    	this.LegLeft02.yRot = 0.0F;
		    	this.LegLeft02.zRot = 0.0F;
		    	this.LegRight01.yRot = 0.0F;
		    	this.LegRight01.zRot = -0.08726646259971647F;
		    	this.LegRight02.xRot = 1.48352986419518F;
		    	this.LegRight02.yRot = 0.0F;
		    	this.LegRight02.zRot = 0.0F;
				//equip
		    	this.Cir00.yRot = f2 * 0.025F;
		    	this.EquipSL00.xRot = 1.42F;
		    	this.EquipSL00.yRot = -0.18F;
		    	this.EquipSL00.zRot = 0.0F;
		    	this.EquipSL00.y = (10.0F) + (0.15F) * 16F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.47F); this.animTransZ += (0F);
		    	//body
		    	this.BodyMain.xRot = -0.3F;
		    	this.Butt.xRot = -0.2F;
				this.Skirt01.xRot = -0.26F;
				this.Skirt02.xRot = -0.45F;
				//leg
				addk1 = -0.9F;
				addk2 = -0.9F;
				this.LegLeft01.zRot = -0.14F;
				this.LegLeft02.xRot = 1.2217F;
				this.LegLeft02.yRot = 1.2217F;
				this.LegLeft02.zRot = -1.0472F;
				this.LegLeft02.x = (3.0F) + (0F) * 16F;
				this.LegLeft02.y = (14.0F) + (-0.06F) * 16F;
				this.LegLeft02.z = (-3.0F) + (0F) * 16F;
				this.LegRight01.zRot = 0.14F;
				this.LegRight02.xRot = 1.2217F;
				this.LegRight02.yRot = -1.2217F;
				this.LegRight02.zRot = 1.0472F;
				this.LegRight02.x = (-3.0F) + (0F) * 16F;
				this.LegRight02.y = (14.0F) + (-0.06F) * 16F;
				this.LegRight02.z = (-3.0F) + (0F) * 16F;
				//equip
				this.Cir00.yRot = f2 * 0.025F;
				this.EquipSL00.xRot = -1.06F;
				this.EquipSL00.yRot = 0.02F;
				this.EquipSL00.zRot = -1.29F;
				
				if (spcStand)
				{
					//arm
					this.ArmRight01.xRot += 0.3F;
					
					if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED)
					{
						//equip
						this.EquipSL00.xRot = -1.5707963267948966F;
						this.EquipSL00.yRot = 1.2F;
						this.EquipSL00.zRot = 0.0F;
					}
					else
					{
						this.EquipSL00.visible = false;
					}
				}
				else
				{
					//arm
					this.ArmLeft01.xRot += 0.1F;
					this.ArmLeft01.yRot = 0F;
					this.ArmLeft01.zRot = -0.25F;
					this.ArmRight01.xRot += 0.3F;
					this.ArmRight01.yRot = 0F;
					this.ArmRight01.zRot = 0.25F;
				}
	    	}
  		}//end if sitting
	    
	    //攻擊動作: 設為30~50會有揮刀動作, 設為100則沒有揮刀動作
	    if (ent.getAttackTick() > 30)
	    {
	    	//reset attack tick (for particle type 12)
	    	if (ent.getAttackTick() == 60) ent.setAttackTick(0);
	    	
	    	if (ent.getStateEmotion(ID.S.Phase) != 1)
	    	{
this.animTransX += (0F); this.animTransY += (0.05F + ent.getScaleLevel() * 0.02F); this.animTransZ += (0F);
		    	//body
			    this.BodyMain.xRot = 0.17453292519943295F;
			    this.BodyMain.yRot = 0.0F;
			    this.BodyMain.zRot = 0.0F;
			    this.Butt.xRot = 0.0F;
			    this.Head.xRot = -0.1F;
			    this.Skirt01.xRot = -0.13962634015954636F;
			    this.Skirt02.xRot = -0.08726646259971647F;
		    	//arm
			    this.ArmLeft01.xRot = -1.6755160819145563F;
			    this.ArmLeft01.yRot = 0.5235987755982988F;
			    this.ArmLeft01.zRot = 0.0F;
			    this.ArmLeft02.xRot = 0.0F;
			    this.ArmLeft02.yRot = 0.0F;
			    this.ArmLeft02.zRot = 0.0F;
				this.ArmLeft02.x = (3.0F) + (0F) * 16F;
				this.ArmLeft02.z = (2.5F) + (0F) * 16F;
			    this.ArmRight01.xRot = 0.5235987755982988F;
			    this.ArmRight01.yRot = 0.0F;
			    this.ArmRight01.zRot = 0.5235987755982988F;
			    this.ArmRight02.xRot = 0.0F;
			    this.ArmRight02.yRot = 0.0F;
			    this.ArmRight02.zRot = 0.0F;
				this.ArmRight02.x = (-3.0F) + (0F) * 16F;
				this.ArmRight02.z = (2.5F) + (0F) * 16F;
		    	//leg
		    	addk1 = -0.5235987755982988F;
		    	addk2 = 0.2617993877991494F;
			    this.LegLeft01.yRot = 0.0F;
			    this.LegLeft01.zRot = 0.08726646259971647F;
			    this.LegLeft02.xRot = 0.36425021489121656F;
			    this.LegLeft02.yRot = 0.0F;
			    this.LegLeft02.zRot = 0.0F;
				this.LegLeft02.x = (3.0F) + (0F) * 16F;
				this.LegLeft02.y = (14.0F) + (0F) * 16F;
				this.LegLeft02.z = (-3.0F) + (0F) * 16F;
			    this.LegRight01.yRot = 0.0F;
			    this.LegRight01.zRot = -0.08726646259971647F;
			    this.LegRight02.xRot = 0F;
				this.LegRight02.yRot = 0F;
				this.LegRight02.zRot = 0F;
				this.LegRight02.x = (-3.0F) + (0F) * 16F;
				this.LegRight02.y = (14.0F) + (0F) * 16F;
				this.LegRight02.z = (-3.0F) + (0F) * 16F;
		    	//equip
				this.EquipSL00.visible = true;
			    this.EquipSL00.xRot = -0.136659280431156F;
			    this.EquipSL00.yRot = 1.5707963267948966F;
			    this.EquipSL00.zRot = 0.136659280431156F;
		    	//swing left hand
		    	if (ent.getAttackTick() < 51)
		    	{
			    	if (ent.getAttackTick() > 45)
			    	{
				    	int tick = 4 - (ent.getAttackTick() - 46);
				    	float parTick = f2 - (int)f2 + tick;
			    		//arm
			    		this.ArmLeft01.yRot = 0.52F - 0.524F * parTick;
			    	}
			    	else
			    	{
			    		//arm
			    		this.ArmLeft01.yRot = -2.1F;
			    	}
		    	}
	    	}
	    	else
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
			    this.ArmLeft02.xRot = 0.0F;
			    this.ArmLeft02.yRot = 0.0F;
			    this.ArmLeft02.zRot = 0.0F;
				this.ArmLeft02.x = (3.0F) + (0F) * 16F;
				this.ArmLeft02.z = (2.5F) + (0F) * 16F;
			    this.ArmRight01.xRot = 0.7F;
		    	this.ArmRight01.yRot = 1.1F;
		    	this.ArmRight01.zRot = 1F;
			  	this.ArmRight02.zRot = 0F;
			    this.ArmRight02.xRot = 0.0F;
			    this.ArmRight02.yRot = 0.0F;
			    this.ArmRight02.zRot = 0.0F;
				this.ArmRight02.x = (-3.0F) + (0F) * 16F;
				this.ArmRight02.z = (2.5F) + (0F) * 16F;
		    	//leg
		  		addk1 = angleAdd1 * 1F - 0.28F;  //LegLeft01
			  	addk2 = angleAdd2 * 1F - 0.21F;  //LegRight01
			    this.LegLeft01.yRot = 0F;
			    this.LegLeft01.zRot = 0F;
			  	this.LegLeft02.xRot = 0F;
			    this.LegLeft02.yRot = 0F;
			    this.LegLeft02.zRot = 0F;
				this.LegLeft02.x = (3.0F) + (0F) * 16F;
				this.LegLeft02.y = (14.0F) + (0F) * 16F;
				this.LegLeft02.z = (-3.0F) + (0F) * 16F;
			    this.LegRight01.yRot = 0F;
			    this.LegRight01.zRot = 0F;
			    this.LegRight02.xRot = 0F;
				this.LegRight02.yRot = 0F;
				this.LegRight02.zRot = 0F;
				this.LegRight02.x = (-3.0F) + (0F) * 16F;
				this.LegRight02.y = (14.0F) + (0F) * 16F;
				this.LegRight02.z = (-3.0F) + (0F) * 16F;
			  	//equip
				this.EquipSL00.xRot = -1.5F;
				this.EquipSL00.yRot = 0.2F;
				this.EquipSL00.zRot = 0F;
	    	}
	    	
	    	//final attack
	    	if (ent.getStateEmotion(ID.S.Phase) == 2)
	    	{
	    		//body
	    		this.Head.xRot = -0.2617993877991494F;
	    		this.BodyMain.xRot = 0F;
	    		this.BodyMain.yRot = f2 * -2F;
	    		//arm
	    		this.ArmLeft01.xRot = -1.6755160819145563F;
	    		this.ArmLeft01.yRot = -1.3962634015954636F;
	    		this.ArmLeft01.zRot = 0.0F;
	    		this.ArmRight01.xRot = 0.17453292519943295F;
	    		this.ArmRight01.yRot = 0.0F;
	    		this.ArmRight01.zRot = 1.6755160819145563F;
	    		//leg
	    		addk1 = -0.5235987755982988F;
	    		addk2 = 0.13962634015954636F;
	    		this.LegLeft01.yRot = 0.0F;
	    		this.LegLeft01.zRot = 0.08726646259971647F;
	    		this.LegLeft02.xRot = 1.0471975511965976F;
	    		this.LegLeft02.yRot = 0.0F;
	    		this.LegLeft02.zRot = 0.0F;
	    		this.LegRight01.yRot = 0.0F;
	    		this.LegRight01.zRot = -0.08726646259971647F;
	    	}
	    	else if (ent.getStateEmotion(ID.S.Phase) == 3)
	    	{
	    		//body
	    		this.Head.xRot = -0.7853981633974483F;
	    		this.BodyMain.xRot = 1.3962634015954636F;
	    		this.Butt.xRot = -0.8726646259971648F;
	    		//arm
	    		this.ArmLeft01.xRot = -2.35F;
	    		this.ArmLeft01.yRot = 0.2617993877991494F;
	    		this.ArmLeft01.zRot = 0.0F;
	    		this.ArmRight01.xRot = 0.6981317007977318F;
	    		this.ArmRight01.yRot = 0.0F;
	    		this.ArmRight01.zRot = 0.6981317007977318F;
	    		//leg
	    		addk1 = 0.2617993877991494F;
	    		addk2 = -0.5235987755982988F;
	    		this.LegLeft01.yRot = 0.0F;
	    		this.LegLeft01.zRot = 0.08726646259971647F;
	    		this.LegLeft02.xRot = 0.2617993877991494F;
	    		this.LegLeft02.yRot = 0.0F;
	    		this.LegLeft02.zRot = 0.0F;
	    		this.LegRight01.yRot = 0.0F;
	    		this.LegRight01.zRot = -0.08726646259971647F;
	    		this.LegRight02.xRot = 1.3962634015954636F;
	    		this.LegRight02.yRot = 0.0F;
	    		this.LegRight02.zRot = 0.0F;
	    		//equip
	    		this.EquipSL00.xRot = 0.0F;
	    		this.EquipSL00.yRot = 0.0F;
	    		this.EquipSL00.zRot = -0.17453292519943295F;
	    		this.EquipSL00.x = (-2.5F) + (0.32F + (50 - ent.getAttackTick()) * 0.22F) * 16F;
	    		this.EquipSL00.y = (10.0F) + (2F + (50 - ent.getAttackTick()) * 5F) * 16F;
	    		this.EquipSL00.z = (-2.0F) + (-0.08F) * 16F;
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

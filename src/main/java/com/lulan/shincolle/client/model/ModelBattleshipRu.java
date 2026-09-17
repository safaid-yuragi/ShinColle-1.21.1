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

public class ModelBattleshipRu<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart Butt;
	public ModelPart ArmRight01;
	public ModelPart ArmLeft01;
	public ModelPart EquipBase;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Ahoke;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart HairL02;
	public ModelPart HairR02;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart LegLeft01;
	public ModelPart LegRight01;
	public ModelPart LegLeft02;
	public ModelPart Shoe01;
	public ModelPart LegRight02;
	public ModelPart Shoe02;
	public ModelPart ArmRight02;
	public ModelPart EquipRBase;
	public ModelPart EquipR01;
	public ModelPart EquipRC01a;
	public ModelPart EquipRC02a;
	public ModelPart EquipRC03a;
	public ModelPart EquipRC04a;
	public ModelPart EquipR02a;
	public ModelPart EquipR03a;
	public ModelPart EquipR04a;
	public ModelPart EquipR05a;
	public ModelPart EquipR06a;
	public ModelPart EquipR07;
	public ModelPart EquipR02b;
	public ModelPart EquipR03b;
	public ModelPart EquipR04b;
	public ModelPart EquipR05b;
	public ModelPart EquipR06b;
	public ModelPart EquipR08;
	public ModelPart EquipR09;
	public ModelPart EquipR10;
	public ModelPart EquipRC01b;
	public ModelPart EquipRC01c;
	public ModelPart EquipRC02b;
	public ModelPart EquipRC03b;
	public ModelPart EquipRC03c;
	public ModelPart ArmLeft02;
	public ModelPart EquipLBase;
	public ModelPart EquipL01;
	public ModelPart EquipLC01a;
	public ModelPart EquipLC02a;
	public ModelPart EquipLC03a;
	public ModelPart EquipLC04a;
	public ModelPart EquipL02a;
	public ModelPart EquipL03a;
	public ModelPart EquipL04a;
	public ModelPart EquipL05a;
	public ModelPart EquipL06a;
	public ModelPart EquipL07;
	public ModelPart EquipL02b;
	public ModelPart EquipL03b;
	public ModelPart EquipL04b;
	public ModelPart EquipL05b;
	public ModelPart EquipL06b;
	public ModelPart EquipL08;
	public ModelPart EquipL09;
	public ModelPart EquipL10;
	public ModelPart EquipLC01b;
	public ModelPart EquipLC01c;
	public ModelPart EquipLC02b;
	public ModelPart EquipLC03b;
	public ModelPart EquipLC03c;
	public ModelPart Equip01a;
	public ModelPart Equip01b;
	public ModelPart Equip02;
	public ModelPart Equip03a;
	public ModelPart EquipCB01;
	public ModelPart Equip03b;
	public ModelPart EquipCB03;
	public ModelPart EquipCB02a;
	public ModelPart EquipCB02b;
	public ModelPart EquipCB04a;
	public ModelPart EquipCB04b;
	public ModelPart GloveR;
	public ModelPart GloveL;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ModelPart Skirt01;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-2.5F, -2.0F, -3.6F, 5.0F, 2.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 14.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-7.0F, 0.0F, -5.0F, 14.0F, 12.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 12.5F, 6.5F, -0.12217304763960307F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef2.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 15.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.1F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 5.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.7F, -6.0F, -7.5F, -0.08726646259971647F, 0.0F, 0.136659280431156F));
		PartDefinition partdef8 = partdef6.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(6.8F, 6.5F, -6.3F, -0.08726646259971647F, -0.07F, 0.05235987755982988F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.12217304763960307F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef10 = partdef6.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(-6.8F, 6.5F, -6.3F, -0.08726646259971647F, 0.07F, -0.05235987755982988F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(0.2F, 10.0F, 0.0F, 0.08726646259971647F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef12 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(3.2F, -9.0F, -3.4F, -0.6981317007977318F, 0.08726646259971647F, 0.08726646259971647F));
		PartDefinition partdef13 = partdef0.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, -9.0F, 1.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("Equip02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 5.0F), PartPose.offset(0.0F, -7.0F, 3.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("Equip03b", CubeListBuilder.create().addBox(-10.0F, 0.0F, 0.0F, 10.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(-10.0F, -2.0F, 0.5F, -0.4363323129985824F, 0.2617993877991494F, -0.7853981633974483F));
		PartDefinition partdef16 = partdef14.addOrReplaceChild("EquipCB03", CubeListBuilder.create().mirror().addBox(-10.0F, 0.0F, 0.0F, 10.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(-10.0F, -4.0F, 1.0F, -0.3490658503988659F, 0.3490658503988659F, -0.4363323129985824F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("EquipCB04b", CubeListBuilder.create().addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(-3.0F, 1.0F, 5.0F, 0.6108652381980153F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef16.addOrReplaceChild("EquipCB04a", CubeListBuilder.create().addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(-6.0F, 1.0F, 5.0F, 0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef14.addOrReplaceChild("EquipCB01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 10.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(10.0F, -4.0F, 1.0F, -0.3490658503988659F, -0.3490658503988659F, 0.4363323129985824F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("EquipCB02a", CubeListBuilder.create().mirror().addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(3.0F, 1.0F, 5.0F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef21 = partdef19.addOrReplaceChild("EquipCB02b", CubeListBuilder.create().addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(6.0F, 1.0F, 5.0F, 0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdef14.addOrReplaceChild("Equip03a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 10.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(10.0F, -2.0F, 0.5F, -0.4363323129985824F, -0.2617993877991494F, 0.7853981633974483F));
		PartDefinition partdef23 = partdef13.addOrReplaceChild("Equip01b", CubeListBuilder.create().mirror().addBox(-10.0F, 0.0F, 0.0F, 10.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(-6.0F, -3.0F, -5.5F, 0.0F, 0.17453292519943295F, 0.3490658503988659F));
		PartDefinition partdef24 = partdef13.addOrReplaceChild("Equip01a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 10.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(6.0F, -3.0F, -5.5F, 0.0F, -0.17453292519943295F, -0.3490658503988659F));
		PartDefinition partdef25 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().mirror().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9F, -0.7F, 0.0F, 0.4363323129985824F, 0.3490658503988659F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("ArmRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(-3.0F, 11.0F, 2.5F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("EquipRBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(2.0F, 12.0F, -3.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("EquipRC02a", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 11.0F, 9.0F), PartPose.offset(0.0F, 1.5F, 0.0F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("EquipRC02b", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 4.0F, 0.03490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdef27.addOrReplaceChild("EquipR04a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 14.0F, 16.0F), PartPose.offsetAndRotation(-7.5F, 1.0F, 1.2F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef27.addOrReplaceChild("EquipR03a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 9.0F), PartPose.offsetAndRotation(-7.0F, -2.4F, -3.0F, -0.22689280275926282F, -0.13962634015954636F, 0.0F));
		PartDefinition partdef32 = partdef27.addOrReplaceChild("EquipR02a", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 21.0F, 11.0F), PartPose.offsetAndRotation(-5.0F, -4.0F, -9.0F, -0.5235987755982988F, -0.17453292519943295F, 0.0F));
		PartDefinition partdef33 = partdef27.addOrReplaceChild("EquipR06a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 14.0F, 8.0F), PartPose.offsetAndRotation(-9.6F, -3.3F, 24.2F, 0.3490658503988659F, 0.6981317007977318F, 0.2617993877991494F));
		PartDefinition partdef34 = partdef27.addOrReplaceChild("EquipR04b", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 14.0F, 16.0F), PartPose.offsetAndRotation(7.5F, 1.0F, 1.2F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef35 = partdef27.addOrReplaceChild("EquipR02b", CubeListBuilder.create().mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 21.0F, 11.0F), PartPose.offsetAndRotation(5.0F, -4.0F, -9.0F, -0.5235987755982988F, 0.17453292519943295F, 0.0F));
		PartDefinition partdef36 = partdef27.addOrReplaceChild("EquipR01", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 5.0F, 1.0F), PartPose.offsetAndRotation(1.0F, -2.0F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F));
		PartDefinition partdef37 = partdef27.addOrReplaceChild("EquipR09", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 12.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -0.2F, 20.6F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef38 = partdef27.addOrReplaceChild("EquipR05a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 14.0F, 12.0F), PartPose.offsetAndRotation(-6.5F, 0.0F, 13.0F, 0.2617993877991494F, -0.2617993877991494F, 0.0F));
		PartDefinition partdef39 = partdef27.addOrReplaceChild("EquipRC01a", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 12.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 2.0F, -6.0F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef40 = partdef39.addOrReplaceChild("EquipRC01b", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(-1.8F, 11.0F, 2.0F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef41 = partdef39.addOrReplaceChild("EquipRC01c", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(1.8F, 11.0F, 2.0F, 0.03490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef42 = partdef27.addOrReplaceChild("EquipR05b", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 14.0F, 12.0F), PartPose.offsetAndRotation(6.5F, 0.0F, 13.0F, 0.2617993877991494F, 0.2617993877991494F, 0.0F));
		PartDefinition partdef43 = partdef27.addOrReplaceChild("EquipRC03a", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 11.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 1.0F, 9.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("EquipRC03b", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(-1.8F, 10.0F, 3.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef45 = partdef43.addOrReplaceChild("EquipRC03c", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(1.8F, 10.0F, 3.5F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef46 = partdef27.addOrReplaceChild("EquipR06b", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 14.0F, 8.0F), PartPose.offsetAndRotation(9.6F, -3.3F, 24.2F, 0.3490658503988659F, -0.6981317007977318F, -0.2617993877991494F));
		PartDefinition partdef47 = partdef27.addOrReplaceChild("EquipR10", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(-6.7F, 1.0F, 14.0F, 0.17453292519943295F, -0.17453292519943295F, 0.0F));
		PartDefinition partdef48 = partdef27.addOrReplaceChild("EquipR08", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 13.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -1.0F, -10.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef49 = partdef27.addOrReplaceChild("EquipR07", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 10.0F, 13.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -4.0F, 29.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef50 = partdef27.addOrReplaceChild("EquipR03b", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 17.0F, 9.0F), PartPose.offsetAndRotation(7.0F, -2.4F, -3.0F, -0.22689280275926282F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef51 = partdef27.addOrReplaceChild("EquipRC04a", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 10.0F, 13.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 12.5F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef52 = partdef26.addOrReplaceChild("GloveR", CubeListBuilder.create().addBox(2.5F, 5.5F, -2.5F, 6.0F, 7.0F, 6.0F), PartPose.offset(-3F, 0F, -3F));
		PartDefinition partdef53 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9F, -0.7F, 0.22759093446006054F, -0.4363323129985824F, -0.3490658503988659F));
		PartDefinition partdef54 = partdef53.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(3.0F, 11.0F, 2.5F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("EquipLBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(-3.0F, 12.0F, -3.0F));
		PartDefinition partdef56 = partdef55.addOrReplaceChild("EquipL04a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 14.0F, 16.0F), PartPose.offsetAndRotation(-7.5F, 1.0F, 1.2F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef57 = partdef55.addOrReplaceChild("EquipLC01a", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 12.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 2.0F, -6.0F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("EquipLC01b", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(-1.8F, 11.0F, 2.0F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef59 = partdef57.addOrReplaceChild("EquipLC01c", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(1.8F, 11.0F, 2.0F, 0.03490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef60 = partdef55.addOrReplaceChild("EquipL06b", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 14.0F, 8.0F), PartPose.offsetAndRotation(9.6F, -3.3F, 24.2F, 0.3490658503988659F, -0.6981317007977318F, -0.2617993877991494F));
		PartDefinition partdef61 = partdef55.addOrReplaceChild("EquipLC02a", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 11.0F, 9.0F), PartPose.offset(0.0F, 1.5F, 0.0F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("EquipLC02b", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 4.0F, 0.03490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef63 = partdef55.addOrReplaceChild("EquipL08", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 13.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -1.0F, -10.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef64 = partdef55.addOrReplaceChild("EquipL04b", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 14.0F, 16.0F), PartPose.offsetAndRotation(7.5F, 1.0F, 1.2F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef65 = partdef55.addOrReplaceChild("EquipL05b", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 14.0F, 12.0F), PartPose.offsetAndRotation(6.5F, 0.0F, 13.0F, 0.2617993877991494F, 0.2617993877991494F, 0.0F));
		PartDefinition partdef66 = partdef55.addOrReplaceChild("EquipLC03a", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 11.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 1.0F, 9.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef67 = partdef66.addOrReplaceChild("EquipLC03b", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(-1.8F, 10.0F, 3.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef68 = partdef66.addOrReplaceChild("EquipLC03c", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offsetAndRotation(1.8F, 10.0F, 3.5F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef69 = partdef55.addOrReplaceChild("EquipL06a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 14.0F, 8.0F), PartPose.offsetAndRotation(-9.6F, -3.3F, 24.2F, 0.3490658503988659F, 0.6981317007977318F, 0.2617993877991494F));
		PartDefinition partdef70 = partdef55.addOrReplaceChild("EquipL10", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(6.7F, 1.0F, 14.0F, 0.17453292519943295F, 0.17453292519943295F, 0.0F));
		PartDefinition partdef71 = partdef55.addOrReplaceChild("EquipL02a", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 21.0F, 11.0F), PartPose.offsetAndRotation(-5.0F, -4.0F, -9.0F, -0.5235987755982988F, -0.17453292519943295F, 0.0F));
		PartDefinition partdef72 = partdef55.addOrReplaceChild("EquipL07", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 10.0F, 13.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -4.0F, 29.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef73 = partdef55.addOrReplaceChild("EquipL09", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 12.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -0.2F, 20.6F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef74 = partdef55.addOrReplaceChild("EquipL01", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 5.0F, 1.0F), PartPose.offsetAndRotation(1.0F, -2.0F, 0.0F, 0.0F, -1.5707963267948966F, 0.0F));
		PartDefinition partdef75 = partdef55.addOrReplaceChild("EquipLC04a", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 10.0F, 13.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 12.5F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef76 = partdef55.addOrReplaceChild("EquipL05a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 14.0F, 12.0F), PartPose.offsetAndRotation(-6.5F, 0.0F, 13.0F, 0.2617993877991494F, -0.2617993877991494F, 0.0F));
		PartDefinition partdef77 = partdef55.addOrReplaceChild("EquipL03a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 17.0F, 9.0F), PartPose.offsetAndRotation(-7.0F, -2.4F, -3.0F, -0.22689280275926282F, -0.13962634015954636F, 0.0F));
		PartDefinition partdef78 = partdef55.addOrReplaceChild("EquipL02b", CubeListBuilder.create().mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 21.0F, 11.0F), PartPose.offsetAndRotation(5.0F, -4.0F, -9.0F, -0.5235987755982988F, 0.17453292519943295F, 0.0F));
		PartDefinition partdef79 = partdef55.addOrReplaceChild("EquipL03b", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 17.0F, 9.0F), PartPose.offsetAndRotation(7.0F, -2.4F, -3.0F, -0.22689280275926282F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef80 = partdef54.addOrReplaceChild("GloveL", CubeListBuilder.create().addBox(-2.5F, 5.5F, -2.5F, 6.0F, 7.0F, 6.0F), PartPose.offset(-3F, 0F, -3F));
		PartDefinition partdef81 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef82 = partdef81.addOrReplaceChild("LegRight01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.13962634015954636F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef83 = partdef82.addOrReplaceChild("LegRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(-3.0F, 14.0F, -3.0F));
		PartDefinition partdef84 = partdef83.addOrReplaceChild("Shoe02", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 6.0F, 7.0F), PartPose.offset(3.0F, 9.0F, 3.0F));
		PartDefinition partdef85 = partdef81.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -6.0F, 17.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 2.9F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef86 = partdef81.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef87 = partdef86.addOrReplaceChild("LegLeft02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(3.0F, 14.0F, -3.0F));
		PartDefinition partdef88 = partdef87.addOrReplaceChild("Shoe01", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 6.0F, 7.0F), PartPose.offset(-3.0F, 9.0F, 3.0F));
		PartDefinition partdef89 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(-3.2F, -9.0F, -3.4F, -0.6981317007977318F, -0.08726646259971647F, -0.08726646259971647F));
		PartDefinition partdef90 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef91 = partdef90.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef92 = partdef91.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef93 = partdef92.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef94 = partdef92.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef95 = partdef92.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef96 = partdef92.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef97 = partdef92.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef98 = partdef92.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef99 = partdef92.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef100 = partdef92.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef101 = partdef92.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef102 = partdef92.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelBattleshipRu(ModelPart root)
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
		this.GloveL = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("GloveL");
		this.GloveR = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("GloveR");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.BodyMain = root.getChild("BodyMain");
		this.EquipL04a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL04a");
		this.EquipRC02a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipRC02a");
		this.EquipLC01a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipLC01a");
		this.EquipL06b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL06b");
		this.Shoe02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("Shoe02");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.EquipCB02a = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip02").getChild("EquipCB01").getChild("EquipCB02a");
		this.EquipCB04b = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip02").getChild("EquipCB03").getChild("EquipCB04b");
		this.EquipLC02a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipLC02a");
		this.Shoe01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("Shoe01");
		this.EquipR04a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR04a");
		this.EquipL08 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL08");
		this.EquipRC03b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipRC03a").getChild("EquipRC03b");
		this.Equip03b = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip02").getChild("Equip03b");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.EquipCB03 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip02").getChild("EquipCB03");
		this.EquipR03a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR03a");
		this.EquipR02a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR02a");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.EquipCB01 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip02").getChild("EquipCB01");
		this.EquipR06a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR06a");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.EquipL04b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL04b");
		this.EquipL05b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL05b");
		this.EquipLC01b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipLC01a").getChild("EquipLC01b");
		this.EquipR04b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR04b");
		this.EquipLC03a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipLC03a");
		this.EquipR02b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR02b");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.EquipLC02b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipLC02a").getChild("EquipLC02b");
		this.EquipCB02b = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip02").getChild("EquipCB01").getChild("EquipCB02b");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.EquipR01 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR01");
		this.HairR02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.EquipR09 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR09");
		this.EquipL06a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL06a");
		this.EquipR05a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR05a");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.EquipRC02b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipRC02a").getChild("EquipRC02b");
		this.EquipRC01a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipRC01a");
		this.EquipR05b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR05b");
		this.EquipRC01b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipRC01a").getChild("EquipRC01b");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.EquipL10 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL10");
		this.EquipL02a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL02a");
		this.EquipRC03c = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipRC03a").getChild("EquipRC03c");
		this.EquipLC03b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipLC03a").getChild("EquipLC03b");
		this.Equip02 = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip02");
		this.EquipRC03a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipRC03a");
		this.EquipL07 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL07");
		this.EquipCB04a = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip02").getChild("EquipCB03").getChild("EquipCB04a");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.EquipLC03c = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipLC03a").getChild("EquipLC03c");
		this.EquipBase = root.getChild("BodyMain").getChild("EquipBase");
		this.HairL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.EquipR06b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR06b");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.EquipR10 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR10");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.EquipL09 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL09");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.EquipL01 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL01");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.EquipLC04a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipLC04a");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.EquipR08 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR08");
		this.EquipR07 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR07");
		this.Equip03a = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip02").getChild("Equip03a");
		this.EquipRC01c = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipRC01a").getChild("EquipRC01c");
		this.EquipL05a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL05a");
		this.EquipR03b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipR03b");
		this.EquipLBase = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase");
		this.EquipL03a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL03a");
		this.Equip01b = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip01b");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.EquipL02b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL02b");
		this.Equip01a = root.getChild("BodyMain").getChild("EquipBase").getChild("Equip01a");
		this.EquipRBase = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase");
		this.EquipLC01c = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipLC01a").getChild("EquipLC01c");
		this.EquipL03b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("EquipLBase").getChild("EquipL03b");
		this.EquipRC04a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipRBase").getChild("EquipRC04a");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.scale = 0.44F;
		this.offsetY = 1.9F;
		this.offsetItem = new float[] {0.07F, 1F, -0.07F};
		this.offsetBlock = new float[] {0.07F, 1F, -0.07F};
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
		this.EquipLBase.visible = !(flag);
		this.EquipRBase.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(1, state);
		this.EquipBase.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);
		this.GloveL.visible = !(flag);
		this.GloveR.visible = !(flag);
	
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

this.animTransX += (0F); this.animTransY += (0.66F); this.animTransZ += (0F);
		this.setFaceHungry(ent);

		//body
    	this.Head.xRot = 0F;
    	this.Head.yRot = 0F;
    	this.Head.zRot = 0F;
    	this.BodyMain.xRot = 1.4F;
    	this.Butt.xRot = 0.21F;
    	//arm
    	this.ArmLeft01.xRot = -2.9F;
    	this.ArmLeft01.yRot = 0F;
    	this.ArmLeft01.zRot = 1.2F;
    	this.ArmLeft02.xRot = 0F;
    	this.ArmLeft02.zRot = 0.6F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
    	this.ArmRight01.xRot = -2.9F;
    	this.ArmRight01.yRot = 0F;
    	this.ArmRight01.zRot = -1.2F;
	    this.ArmRight02.xRot = 0F;
		this.ArmRight02.zRot = -0.6F;
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
		this.ArmRight02.z = (2.5F) + (0F) * 16F;
    	//leg
    	this.LegLeft01.xRot = -0.05F;
    	this.LegLeft01.yRot = 0F;
    	this.LegLeft01.zRot = -0.4F;
    	this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0.8F;
		this.LegLeft02.x = (3.0F) + (0F) * 16F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
    	this.LegRight01.xRot = -0.05F;
		this.LegRight01.yRot = 0F;
    	this.LegRight01.zRot = 0.4F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = -0.8F;
		this.LegRight02.x = (-3.0F) + (0F) * 16F;
		this.LegRight02.y = (14.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		//equip
		this.EquipLBase.xRot = 0.3F;
		this.EquipLBase.yRot = 1.8F;
		this.EquipLBase.zRot = 0F;
		this.EquipRBase.xRot = 0.3F;
		this.EquipRBase.yRot = -1.8F;
		this.EquipRBase.zRot = 0F;
	
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
  		boolean spStand = false;
  		boolean showWeapon = EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State));
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}

    	//leg move
  		addk1 = angleAdd1 * 0.5F - 0.28F;  //LegLeft01
	  	addk2 = angleAdd2 * 0.5F - 0.21F;  //LegRight01
    	
  	    //head
	  	this.Head.xRot = f4 * 0.01745F;
	  	this.Head.yRot = f3 * 0.01F;
	    //boob
  	    this.BoobL.xRot = angleX * 0.06F - 0.67F;
  	    this.BoobR.xRot = angleX * 0.06F - 0.67F;
	  	//body
  	    this.Ahoke.zRot = angleX * 0.03F + 0.3F;
	  	this.BodyMain.xRot = -0.1047F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.35F;
		//hair
	  	this.Hair01.xRot = angleX * 0.03F + 0.14F + headX;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -angleX1 * 0.04F - 0.12F + headX;
	  	this.Hair02.zRot = 0F;
	    //arm
	  	if (showWeapon)
	  	{
	  		this.ArmLeft01.zRot = angleX * 0.03F - 0.3F;
	  		this.ArmRight01.zRot = -angleX * 0.03F + 0.3F;
	  	}
	  	else
	  	{
	  		this.ArmLeft01.zRot = angleX * 0.03F - 0.15F;
	  		this.ArmRight01.zRot = -angleX * 0.03F + 0.15F;
	  	}
	  	this.ArmLeft01.xRot = angleAdd2 * 0.4F + 0.1F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    this.ArmRight01.xRot = angleAdd1 * 0.4F;
	    this.ArmRight01.yRot = 0F;
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
		this.EquipLBase.xRot = 0F;
		this.EquipLBase.yRot = 0F;
		this.EquipLBase.zRot = 0F;
		this.EquipRBase.xRot = 0F;
		this.EquipRBase.yRot = 0F;
		this.EquipRBase.zRot = 0F;
		this.EquipCB02a.xRot = this.Head.xRot * 0.9F + 0.8F;
		this.EquipCB02b.xRot = this.Head.xRot * 0.8F + 0.9F;
		this.EquipCB04a.xRot = this.Head.xRot * 1.1F + 0.7F;
		this.EquipCB04b.xRot = this.Head.xRot * 0.9F + 0.8F;
		this.EquipLC01b.xRot = this.Head.xRot * 0.9F - 0.05F;
		this.EquipLC01c.xRot = this.Head.xRot * 0.8F - 0.08F;
		this.EquipLC02b.xRot = this.Head.xRot * 1.1F + 0.1F;
		this.EquipLC03b.xRot = this.Head.xRot * 0.9F + 0.05F;
		this.EquipLC03c.xRot = this.Head.xRot * 0.8F + 0.08F;
		this.EquipRC01b.xRot = this.Head.xRot * 0.9F - 0.05F;
		this.EquipRC01c.xRot = this.Head.xRot * 0.8F - 0.08F;
		this.EquipRC02b.xRot = this.Head.xRot * 1.1F + 0.1F;
		this.EquipRC03b.xRot = this.Head.xRot * 0.9F + 0.05F;
		this.EquipRC03c.xRot = this.Head.xRot * 0.8F + 0.08F;
		
		//special stand pos
		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED &&
			showWeapon && t2 > 400)
		{
			spStand = true;
			
			setFace(1);
this.animTransX += (0F); this.animTransY += (0.12F); this.animTransZ += (0F);
			//body
			this.BodyMain.xRot = 1.0471975511965976F;
			this.BodyMain.yRot = 0.0F;
			this.BodyMain.zRot = 0.0F;
			this.Head.xRot -= 0.18203784098300857F;
			//arm
			this.ArmLeft01.xRot = -1.0471975511965976F;
			this.ArmLeft01.yRot = 0.0F;
			this.ArmLeft01.zRot = -0.3490658503988659F;
			this.ArmRight01.xRot = -1.0471975511965976F;
			this.ArmRight01.yRot = 0.0F;
			this.ArmRight01.zRot = 0.3490658503988659F;
			//leg
			addk1 = -1.3962634015954636F;
			addk2 = -1.3962634015954636F;
			this.LegLeft01.yRot = 0.0F;
			this.LegLeft01.zRot = 0.08726646259971647F;
			this.LegRight01.yRot = 0.0F;
			this.LegRight01.zRot = -0.08726646259971647F;
		}

	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {
this.animTransX += (0F); this.animTransY += (-0.12F); this.animTransZ += (0F);
	    	
			//body
			this.BodyMain.xRot = -0.1F;
			this.BodyMain.yRot = 0F;
			this.BodyMain.zRot = 0F;
		    //arm
		  	if (showWeapon)
		  	{
		  		this.ArmLeft01.xRot = angleAdd2 * 0.05F + 0.5F;
		  		this.ArmRight01.xRot = angleAdd1 * 0.05F + 0.5F;
		  	}
		  	else
		  	{
		  		this.ArmLeft01.xRot = angleAdd2 * 0.9F + 0.5F;
		  		this.ArmRight01.xRot = angleAdd1 * 0.9F + 0.5F;
		  	}
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
	  		addk1 = angleAdd1 * 0.7F - 0.28F;
		  	addk2 = angleAdd2 * 0.7F - 0.21F;
			this.LegLeft01.yRot = 0F;
			this.LegLeft01.zRot = 0.0873F;
			this.LegRight01.yRot = 0F;
			this.LegRight01.zRot = -0.0873F;
			//equip
			this.EquipLBase.xRot = 0.5F;
			this.EquipLBase.yRot = 0F;
			this.EquipLBase.zRot = 0F;
			this.EquipRBase.xRot = 0.5F;
			this.EquipRBase.yRot = 0F;
			this.EquipRBase.zRot = 0F;
  		}
	    
	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {
this.animTransX += (0F); this.animTransY += (-0.12F); this.animTransZ += (0F);
	    	
this.animTransX += (0F); this.animTransY += (0.09F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 0.6283F;
		  	this.BodyMain.xRot = 0.8727F;
		    //arm
		  	if (showWeapon)
		  	{
		  		this.ArmLeft01.xRot = angleAdd2 * 0.05F + 0.5F;
		  		this.ArmLeft01.zRot = -0.25F;
		  		this.ArmLeft02.xRot = -1F;
		  		this.ArmRight01.xRot = angleAdd1 * 0.05F + 0.5F;
		  		this.ArmRight01.zRot = 0.25F;
		  		this.ArmRight02.xRot = -1F;
		  	}
		  	else
		  	{
			  	this.ArmLeft01.xRot = -0.35F;
			    this.ArmLeft01.zRot = 0.2618F;
			    this.ArmLeft02.xRot = 0F;
				this.ArmRight01.xRot = -0.35F;
				this.ArmRight01.zRot = -0.2618F;
				this.ArmRight02.xRot = 0F;
		  	}
		  	this.ArmLeft01.yRot = 0F;
		    this.ArmLeft02.zRot = 0F;
		    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
		    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
		    this.ArmRight01.yRot = 0F;
			this.ArmRight02.zRot = 0F;
			this.ArmRight02.x = (-3.0F) + (0F) * 16F;
			this.ArmRight02.z = (2.5F) + (0F) * 16F;
			//leg
			addk1 -= 1.1F;
			addk2 -= 1.1F;
			//hair
			this.Hair01.xRot += 0.37F;
			this.Hair02.xRot += 0.23F;
  		}//end if sneaking
  		
	    //坐下動作
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {
this.animTransX += (0F); this.animTransY += (-0.12F); this.animTransZ += (0F);
	    	
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
this.animTransX += (0F); this.animTransY += (0.25F); this.animTransZ += (0F);
				//body
				this.BodyMain.xRot = -0.10471975511965977F;
				this.BodyMain.yRot = -0.3490658503988659F;
				this.BodyMain.zRot = 0.0F;
				this.Head.yRot -= 0.5235987755982988F;
				//arm
				this.ArmLeft01.xRot = 0.8726646259971648F;
				this.ArmLeft01.yRot = 0.0F;
				this.ArmLeft01.zRot = -0.3490658503988659F;
				this.ArmLeft02.xRot = -0.7853981633974483F;
				this.ArmLeft02.yRot = 0.0F;
				this.ArmLeft02.zRot = 0.0F;
				this.ArmRight01.xRot = -0.4363323129985824F;
				this.ArmRight01.yRot = 0.0F;
				this.ArmRight01.zRot = 0.3490658503988659F;
				this.ArmRight02.xRot = -0.8726646259971648F;
				this.ArmRight02.yRot = 0.0F;
				this.ArmRight02.zRot = 0.0F;
				//leg
				addk1 = -1.48352986419518F;
				addk2 = -0.4363323129985824F;
				this.LegLeft01.yRot = 0.0F;
				this.LegLeft01.zRot = 0.08726646259971647F;
				this.LegLeft02.xRot = 1.3962634015954636F;
				this.LegLeft02.yRot = 0.0F;
				this.LegLeft02.zRot = 0.0F;
				this.LegRight01.yRot = 0.0F;
				this.LegRight01.zRot = -0.08726646259971647F;
				this.LegRight02.xRot = 1.48352986419518F;
				this.LegRight02.yRot = 0.0F;
				this.LegRight02.zRot = 0.0F;
	    	}
	    	else if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED &&
	    			 showWeapon)
	    	{
this.animTransX += (0F); this.animTransY += (0.52F); this.animTransZ += (0F);
		    	//body
		    	this.BodyMain.xRot = 0.7853981633974483F;
		    	this.Butt.xRot = 0.2617993877991494F;
		    	this.Head.xRot = 0.5235987755982988F;
		    	//hair
		    	this.Hair01.xRot = -0.3490658503988659F;
		    	this.Hair02.xRot = -0.12217304763960307F;
		    	//arm
		    	this.ArmLeft01.xRot = 2.6179938779914944F;
		    	this.ArmLeft01.yRot = 0.0F;
		    	this.ArmLeft01.zRot = 0.0F;
		    	this.ArmRight01.xRot = 2.6179938779914944F;
		    	this.ArmRight01.yRot = 0.0F;
		    	this.ArmRight01.zRot = 0.0F;
		    	//leg
		    	addk1 = 0.2617993877991494F;
		    	addk2 = 0.2617993877991494F;
		    	this.LegLeft01.yRot = 0.0F;
		    	this.LegLeft01.zRot = 0.08726646259971647F;
		    	this.LegLeft02.xRot = 0.2617993877991494F;
		    	this.LegLeft02.yRot = 0.0F;
		    	this.LegLeft02.zRot = 0.0F;
		    	this.LegRight01.yRot = 0.0F;
		    	this.LegRight01.zRot = -0.08726646259971647F;
		    	this.LegRight02.xRot = 0.2617993877991494F;
		    	this.LegRight02.yRot = 0.0F;
		    	this.LegRight02.zRot = 0.0F;
		    	//equip
		    	this.EquipLBase.xRot = 1.2217304763960306F;
		    	this.EquipLBase.yRot = 0.0F;
		    	this.EquipLBase.zRot = 0.0F;
		    	this.EquipRBase.xRot = 1.2217304763960306F;
		    	this.EquipRBase.yRot = 0.0F;
		    	this.EquipRBase.zRot = 0.0F;
	    	}
	    	else if (this.EquipLBase.visible)
	    	{
this.animTransX += (0F); this.animTransY += (0.2F); this.animTransZ += (0F);
		    	//body
		    	this.BodyMain.xRot = 0.18203784098300857F;
		    	this.Butt.xRot = 0.2617993877991494F;
		    	this.Head.xRot -= 0.20943951023931953F;
		    	//arm
		    	this.ArmLeft01.xRot = 0.13962634015954636F;
		    	this.ArmLeft01.yRot = 0.0F;
		    	this.ArmLeft01.zRot = -0.3490658503988659F;
		    	this.ArmRight01.xRot = -1.1838568316277536F;
		    	this.ArmRight01.yRot = 0.8F;
		    	this.ArmRight01.zRot = 0.0F;
		    	this.ArmRight02.xRot = -1.3089969389957472F;
		    	this.ArmRight02.yRot = 0.0F;
		    	this.ArmRight02.zRot = 0.0F;
		    	//leg
		    	addk1 = -1.61F;
		    	addk2 = -1.57F;
		    	this.LegLeft01.yRot = 0.0F;
		    	this.LegLeft01.zRot = 0.08726646259971647F;
		    	this.LegLeft02.xRot = 1.5F;
		    	this.LegLeft02.yRot = 0.0F;
		    	this.LegLeft02.zRot = 0.0F;
		    	this.LegRight01.yRot = 0.0F;
		    	this.LegRight01.zRot = -0.08726646259971647F;
		    	this.LegRight02.xRot = 0.6F;
		    	this.LegRight02.yRot = 0.0F;
		    	this.LegRight02.zRot = 0.0F;
		    	//equip
		    	this.EquipLBase.xRot = 0.0F;
		    	this.EquipLBase.yRot = -1.5707963267948966F;
		    	this.EquipLBase.zRot = 0.3141592653589793F;
		    	this.EquipRBase.xRot = 0.7285004297824331F;
		    	this.EquipRBase.yRot = 0.0F;
		    	this.EquipRBase.zRot = 0.0F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.35F); this.animTransZ += (0F);
		    	this.EquipLBase.visible = false;
		    	this.EquipRBase.visible = false;
		    	//body
		    	this.BodyMain.xRot = 0.27314402793711257F;
		    	this.Butt.xRot = 0.2617993877991494F;
		    	this.Head.xRot -= 0.41887902047863906F;
		    	//arm
		    	this.ArmLeft01.xRot = 0.091106186954104F;
		    	this.ArmLeft01.yRot = 0.0F;
		    	this.ArmLeft01.zRot = -0.6373942428283291F;
		    	this.ArmLeft02.xRot = 0.0F;
		    	this.ArmLeft02.yRot = 0.0F;
		    	this.ArmLeft02.zRot = 1.3658946726107624F;
		    	this.ArmRight01.xRot = -0.85F;
		    	this.ArmRight01.yRot = 0.0F;
		    	this.ArmRight01.zRot = 0.0F;
		    	this.ArmRight02.xRot = 0.0F;
		    	this.ArmRight02.yRot = 0.0F;
		    	this.ArmRight02.zRot = -0.5009094953223726F;
		    	//leg
		    	addk1 = -1.2747884856566583F;
		    	addk2 = -2.1399481958702475F;
		    	this.LegLeft01.yRot = 0.0F;
		    	this.LegLeft01.zRot = 0.08726646259971647F;
		    	this.LegLeft02.xRot = 2.321986036853256F;
		    	this.LegLeft02.yRot = 0.0F;
		    	this.LegLeft02.zRot = 0.0F;
		    	this.LegLeft02.z = (-3.0F) + (0.375F) * 16F;
		    	this.LegRight01.yRot = 0.0F;
		    	this.LegRight01.zRot = -0.08726646259971647F;
		    	this.LegRight02.xRot = 1.5707963267948966F;
		    	this.LegRight02.yRot = 0.0F;
		    	this.LegRight02.zRot = 0.0F;
	    	}
  		}//end if sitting
	    
	    //攻擊動作: 設為30~50會有揮刀動作, 設為100則沒有揮刀動作
	    if (ent.getAttackTick() > 0)
	    {
this.animTransX += (0F); this.animTransY += (-0.12F); this.animTransZ += (0F);
	    	
	    	//body
		  	this.BodyMain.xRot = -0.1047F;
		  	this.BodyMain.yRot = 0F;
		  	this.BodyMain.zRot = 0F;
		  	this.Butt.xRot = 0.35F;
	    	//arm
		  	if (showWeapon)
		  	{
		  		this.ArmLeft02.xRot = -0.8726646259971648F;
		  		this.ArmRight02.xRot = -0.8726646259971648F;
		  	}
		  	else
		  	{
		  		this.ArmLeft02.xRot = 0F;
		  		this.ArmRight02.xRot = 0F;
		  	}
	    	this.ArmLeft01.xRot = -0.5235987755982988F;
	    	this.ArmLeft01.yRot = -0.5235987755982988F;
	    	this.ArmLeft01.zRot = -0.2617993877991494F;
	    	this.ArmLeft02.yRot = 0.0F;
	    	this.ArmLeft02.zRot = 0.0F;
	    	this.ArmRight01.xRot = -0.5235987755982988F;
	    	this.ArmRight01.yRot = 0.5235987755982988F;
	    	this.ArmRight01.zRot = 0.2617993877991494F;
	    	this.ArmRight02.yRot = 0.0F;
	    	this.ArmRight02.zRot = 0.0F;
	    	//leg move
	  		addk1 = angleAdd1 * 0.5F - 0.28F;
		  	addk2 = angleAdd2 * 0.5F - 0.21F;
	    	//equip
	    	this.EquipLBase.xRot = 0.0F;
	    	this.EquipLBase.yRot = -0.2617993877991494F;
	    	this.EquipLBase.zRot = 0.3490658503988659F;
	    	this.EquipRBase.xRot = 0.0F;
	    	this.EquipRBase.yRot = 0.2617993877991494F;
	    	this.EquipRBase.zRot = -0.3490658503988659F;
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
	  	
	  	//頭毛左右彎曲調整
	    headX = this.Head.xRot * -0.5F;
	    this.Hair01.xRot += headX;
	  	this.Hair02.xRot += headX;
		this.HairL01.xRot = angleX * 0.02F + headX - 0.09F;
	  	this.HairL02.xRot = -angleX1 * 0.04F + headX + 0.12F;
	  	this.HairR01.xRot = angleX * 0.02F + headX - 0.09F;
	  	this.HairR02.xRot = -angleX1 * 0.04F + headX + 0.12F;
	  	headZ = this.Head.zRot * -0.5F;
	    this.Hair01.zRot = headZ;
	  	this.Hair02.zRot = headZ;
	  	this.HairL01.zRot = headZ + 0.05F;
	  	this.HairL02.zRot = headZ - 0.09F;
	  	this.HairR01.zRot = headZ - 0.05F;
	  	this.HairR02.zRot = headZ + 0.09F;
	    
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

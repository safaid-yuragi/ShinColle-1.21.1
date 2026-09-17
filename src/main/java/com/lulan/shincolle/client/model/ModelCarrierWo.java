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

public class ModelCarrierWo<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Butt;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart ArmLeft02;
	public ModelPart ArmRight02;
	public ModelPart Neck;
	public ModelPart Neck02;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart CloakNeck;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart LegRight02;
	public ModelPart LegLeft02;
	public ModelPart ShoesRight;
	public ModelPart ShoesLeft;
	public ModelPart Staff;
	public ModelPart StaffHead;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart Ahoke;
	public ModelPart HairL01;
	public ModelPart Hair00a;
	public ModelPart Hair00b;
	public ModelPart HairR01;
	public ModelPart HairL02;
	public ModelPart HairR02;
	public ModelPart EquipBase;
	public ModelPart Equip01;
	public ModelPart Equip02;
	public ModelPart Equip03;
	public ModelPart Equip04;
	public ModelPart EquipEye01;
	public ModelPart EquipEye02;
	public ModelPart EquipT01L;
	public ModelPart EquipT01R;
	public ModelPart Equip05;
	public ModelPart Equip06;
	public ModelPart EquipLC01;
	public ModelPart EquipRC01;
	public ModelPart EquipTB01L;
	public ModelPart EquipTB01R;
	public ModelPart EquipTooth01;
	public ModelPart EquipTooth02;
	public ModelPart EquipTooth03;
	public ModelPart EquipT02L;
	public ModelPart EquipT03L;
	public ModelPart EquipT02R;
	public ModelPart EquipT03R;
	public ModelPart EquipLC02;
	public ModelPart EquipLC03;
	public ModelPart EquipRC02;
	public ModelPart EquipRC03;
	public ModelPart EquipTB02L;
	public ModelPart EquipTB03L;
	public ModelPart EquipTB02R;
	public ModelPart EquipTB03R;
	public ModelPart Cloak01;
	public ModelPart Cloak02;
	public ModelPart Cloak03;
	public ModelPart Neck03;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ModelPart GlowEquipBase;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -12.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, -0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.0F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -13F, -0.5F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.2F, 16.0F, 14.0F, 7.0F), PartPose.offset(0.0F, -7.0F, 0.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0F, -13.5F, -12F, 0.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0F, 0F, -4.5F, 0F, 0.7F, 0F));
		PartDefinition partdef4 = partdef2.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, -2.0F, 2.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -2.0F, -0.5235987755982988F, 0.17453292519943295F, 0.3141592653589793F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("HairR02", CubeListBuilder.create().addBox(-1.0F, 0.0F, -2.2F, 2.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.3490658503988659F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef6 = partdef2.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, -2.0F, 2.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(6.0F, 0.0F, -2.0F, -0.5235987755982988F, -0.17453292519943295F, -0.3141592653589793F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("HairL02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, -2.2F, 2.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.3490658503988659F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef8 = partdef2.addOrReplaceChild("Hair00a", CubeListBuilder.create().addBox(-7.5F, -7.5F, -1.0F, 15.0F, 8.0F, 9.0F), PartPose.offset(0.0F, 0.0F, -0.5F));
		PartDefinition partdef9 = partdef2.addOrReplaceChild("Hair00b", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 10.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 0.3F, -2.5F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef1.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -10.0F, -3.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("Equip05", CubeListBuilder.create().addBox(-24.0F, -18.0F, -15.0F, 48.0F, 18.0F, 28.0F), PartPose.offsetAndRotation(0.0F, -5.0F, 2.5F, 0.03490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef10.addOrReplaceChild("Equip03", CubeListBuilder.create().addBox(-16.0F, -18.0F, -20.0F, 32.0F, 18.0F, 40.0F), PartPose.offsetAndRotation(0.0F, -5.5F, 4.0F, 0.06981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef13 = partdef10.addOrReplaceChild("EquipTooth03", CubeListBuilder.create().mirror().addBox(-14.0F, 0.0F, 0.0F, 14.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(-12.4F, -17.0F, -20.3F, 0.06981317007977318F, 0.5235987755982988F, -0.05235987755982988F));
		PartDefinition partdef14 = partdef10.addOrReplaceChild("Equip04", CubeListBuilder.create().addBox(-12.0F, -15.0F, -24.0F, 24.0F, 15.0F, 46.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 5.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef10.addOrReplaceChild("EquipLC01", CubeListBuilder.create().addBox(-3.5F, -5.5F, -7.5F, 7.0F, 11.0F, 15.0F), PartPose.offsetAndRotation(30.0F, -7.0F, 4.0F, -0.17453292519943295F, -0.2617993877991494F, 0.17453292519943295F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("EquipLC02", CubeListBuilder.create().addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F), PartPose.offsetAndRotation(-1.0F, -2.0F, -7.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef15.addOrReplaceChild("EquipLC03", CubeListBuilder.create().addBox(-1.5F, -1.5F, -16.0F, 3.0F, 3.0F, 16.0F), PartPose.offsetAndRotation(0.0F, 2.0F, -7.0F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef10.addOrReplaceChild("EquipTB01L", CubeListBuilder.create().addBox(-3.0F, -2.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offsetAndRotation(15.0F, -6.0F, 10.0F, 0.17453292519943295F, 0.0F, -0.3490658503988659F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("EquipTB02L", CubeListBuilder.create().addBox(-2.5F, -2.0F, -2.5F, 5.0F, 16.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.4363323129985824F, 0.0F, -0.3490658503988659F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("EquipTB03L", CubeListBuilder.create().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 15.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.6981317007977318F, 0.0F, 0.7853981633974483F));
		PartDefinition partdef21 = partdef10.addOrReplaceChild("Equip06", CubeListBuilder.create().addBox(-29.0F, -13.0F, -13.0F, 58.0F, 13.0F, 22.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 4.5F, 0.06981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdef10.addOrReplaceChild("Equip02", CubeListBuilder.create().addBox(-18.0F, -22.0F, -15.0F, 36.0F, 22.0F, 32.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 2.0F, 0.03490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef23 = partdef10.addOrReplaceChild("EquipT01R", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 10.0F, 8.0F), PartPose.offsetAndRotation(-17.0F, -7.0F, -8.0F, -0.2617993877991494F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("EquipT02R", CubeListBuilder.create().addBox(-3.0F, -2.0F, -3.0F, 6.0F, 22.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -0.17453292519943295F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("EquipT03R", CubeListBuilder.create().addBox(-2.5F, -2.0F, -2.5F, 5.0F, 20.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, 1.0471975511965976F, 0.0F, -0.7853981633974483F));
		PartDefinition partdef26 = partdef10.addOrReplaceChild("EquipTB01R", CubeListBuilder.create().addBox(-3.0F, -2.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offsetAndRotation(-15.0F, -6.0F, 10.0F, 0.17453292519943295F, 0.0F, 0.3490658503988659F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("EquipTB02R", CubeListBuilder.create().addBox(-2.5F, -2.0F, -2.5F, 5.0F, 16.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.4363323129985824F, 0.0F, 0.3490658503988659F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("EquipTB03R", CubeListBuilder.create().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 15.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 13.5F, 0.0F, 0.6981317007977318F, 0.0F, -0.7853981633974483F));
		PartDefinition partdef29 = partdef10.addOrReplaceChild("EquipRC01", CubeListBuilder.create().addBox(-3.5F, -5.5F, -7.5F, 7.0F, 11.0F, 15.0F), PartPose.offsetAndRotation(-30.0F, -7.0F, 4.0F, -0.17453292519943295F, 0.2617993877991494F, -0.17453292519943295F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("EquipRC02", CubeListBuilder.create().addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F), PartPose.offsetAndRotation(1.0F, -2.0F, -7.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef29.addOrReplaceChild("EquipRC03", CubeListBuilder.create().addBox(-1.5F, -1.5F, -16.0F, 3.0F, 3.0F, 16.0F), PartPose.offsetAndRotation(0.0F, 2.0F, -7.0F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef32 = partdef10.addOrReplaceChild("EquipTooth02", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 14.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(12.4F, -17.0F, -20.3F, 0.10471975511965977F, -0.5235987755982988F, 0.05235987755982988F));
		PartDefinition partdef33 = partdef10.addOrReplaceChild("EquipT01L", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 10.0F, 8.0F), PartPose.offsetAndRotation(17.0F, -7.0F, -8.0F, -0.2617993877991494F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("EquipT02L", CubeListBuilder.create().addBox(-3.0F, -2.0F, -3.0F, 6.0F, 22.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -0.17453292519943295F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("EquipT03L", CubeListBuilder.create().addBox(-2.5F, -2.0F, -2.5F, 5.0F, 20.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, 1.0471975511965976F, 0.0F, 0.7853981633974483F));
		PartDefinition partdef36 = partdef10.addOrReplaceChild("Equip01", CubeListBuilder.create().addBox(-9.0F, -28.5F, -7.0F, 18.0F, 27.0F, 22.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));
		PartDefinition partdef37 = partdef10.addOrReplaceChild("EquipTooth01", CubeListBuilder.create().addBox(-12.0F, 0.0F, 0.0F, 24.0F, 15.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -19.3F, -20.6F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef38 = partdef0.addOrReplaceChild("Neck03", CubeListBuilder.create().addBox(-2.5F, -2F, -2.5F, 5.0F, 2.0F, 5.0F), PartPose.offset(0F, -11.9F, -0F));
		PartDefinition partdef39 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -1.0F, 7.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(3.5F, -9.0F, -3.2F, -0.7853981633974483F, 0.08726646259971647F, 0.14F));
		PartDefinition partdef40 = partdef0.addOrReplaceChild("CloakNeck", CubeListBuilder.create().addBox(-10.0F, 0.0F, -6.0F, 20.0F, 7.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -12.0F, -1.5F, 0.31416F, 0.0F, 0.0F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("Cloak01", CubeListBuilder.create().addBox(-10.0F, 0.0F, 0.0F, 20.0F, 12.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 6.5F, 6.0F, 0.5F, 0.0F, 0.0F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("Cloak02", CubeListBuilder.create().addBox(-12.0F, 0.0F, 0.0F, 24.0F, 16.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.4553564018453205F, 0.0F, 0.0F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("Cloak03", CubeListBuilder.create().addBox(-15.0F, 0.0F, 0.0F, 30.0F, 15.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef44 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-5F, -1F, -2F, 5.0F, 12.0F, 5.0F), PartPose.offset(-4.7F, -9F, 0F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0F, 0F, -4F, 5.0F, 12.0F, 5.0F), PartPose.offset(-5F, 11F, 2F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("Staff", CubeListBuilder.create().addBox(0.0F, -15.0F, 0.0F, 3.0F, 28.0F, 4.0F), PartPose.offsetAndRotation(8.0F, 35.0F, 21.0F, 1.1838568316277536F, -0.18203784098300857F, -1.2292353921796064F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("StaffHead", CubeListBuilder.create().addBox(0.0F, -13.0F, 0.0F, 4.0F, 13.0F, 8.0F), PartPose.offset(-0.5F, -15.0F, -1.0F));
		PartDefinition partdef48 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-7.5F, -1.5F, -7F, 15.0F, 4.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -13F, -2F, 0.41888F, 0.0F, 0.0F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("Neck02", CubeListBuilder.create().addBox(-1.5F, 0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(0F, 2F, -5F, -0.52F, 0.0F, 0.0F));
		PartDefinition partdef50 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(0F, -1F, -2F, 5.0F, 12.0F, 5.0F), PartPose.offset(4.7F, -9F, 0F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-5F, 0F, -5F, 5.0F, 12.0F, 5.0F), PartPose.offset(5F, 11F, 3F));
		PartDefinition partdef52 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, -1.0F, 7.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(-3.5F, -9.0F, -3.2F, -0.7853981633974483F, -0.08726646259971647F, -0.14F));
		PartDefinition partdef53 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, -2.0F, -4.1F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.7F, 0.5F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef54 = partdef53.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-3F, 0F, -3F, 6.0F, 12.0F, 6.0F), PartPose.offset(4.2F, 5.0F, -1F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(-3F, 0F, 0F, 6.0F, 7.0F, 6.0F), PartPose.offset(0F, 12F, -3F));
		PartDefinition partdef56 = partdef55.addOrReplaceChild("ShoesLeft", CubeListBuilder.create().addBox(-3.5F, 4.5F, -0.5F, 7.0F, 9.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef57 = partdef53.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-3F, 0F, -3F, 6.0F, 12.0F, 6.0F), PartPose.offset(-4.2F, 5F, -1F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-3F, 0F, 0F, 6.0F, 7.0F, 6.0F), PartPose.offset(0F, 12F, -3F));
		PartDefinition partdef59 = partdef58.addOrReplaceChild("ShoesRight", CubeListBuilder.create().addBox(-3.5F, 4.5F, -0.5F, 7.0F, 9.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef60 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, -0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -13F, -0.5F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("GlowEquipBase", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.0F, -3.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("EquipEye01", CubeListBuilder.create().addBox(-7.5F, -6.0F, 0.0F, 15.0F, 6.0F, 14.0F), PartPose.offsetAndRotation(-14.5F, -21F, -8.0F, 0.13962634015954636F, 0.13962634015954636F, -0.2617993877991494F));
		PartDefinition partdef64 = partdef62.addOrReplaceChild("EquipEye02", CubeListBuilder.create().addBox(-7.5F, -6.0F, 0.0F, 15.0F, 6.0F, 14.0F), PartPose.offsetAndRotation(14.5F, -21F, -8.0F, 0.13962634015954636F, -0.13962634015954636F, 0.2617993877991494F));
		PartDefinition partdef65 = partdef61.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef66 = partdef61.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef67 = partdef61.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef68 = partdef61.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef69 = partdef61.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef70 = partdef61.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef71 = partdef61.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef72 = partdef61.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef73 = partdef61.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6F, -3.0F, -6.8F));
		PartDefinition partdef74 = partdef61.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6F, -3.0F, -6.8F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelCarrierWo(ModelPart root)
	{
		this.Head = root.getChild("BodyMain").getChild("Head");
		this.Neck03 = root.getChild("BodyMain").getChild("Neck03");
		this.EquipLC02 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipLC01").getChild("EquipLC02");
		this.EquipTB03R = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipTB01R").getChild("EquipTB02R").getChild("EquipTB03R");
		this.EquipLC03 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipLC01").getChild("EquipLC03");
		this.EquipT02L = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipT01L").getChild("EquipT02L");
		this.ShoesRight = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoesRight");
		this.Equip05 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("Equip05");
		this.EquipTB03L = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipTB01L").getChild("EquipTB02L").getChild("EquipTB03L");
		this.Equip03 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("Equip03");
		this.Hair = root.getChild("BodyMain").getChild("Head").getChild("Hair");
		this.HairR01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairR01");
		this.HairR02 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.HairL01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairL01");
		this.HairL02 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.Hair00a = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("Hair00a");
		this.Hair00b = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("Hair00b");
		this.EquipT03L = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipT01L").getChild("EquipT02L").getChild("EquipT03L");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.EquipTooth03 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipTooth03");
		this.EquipRC02 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipRC01").getChild("EquipRC02");
		this.ShoesLeft = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoesLeft");
		this.EquipBase = root.getChild("BodyMain").getChild("Head").getChild("EquipBase");
		this.Equip04 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("Equip04");
		this.EquipLC01 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipLC01");
		this.EquipTB01L = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipTB01L");
		this.EquipEye01 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("GlowEquipBase").getChild("EquipEye01");
		this.EquipEye02 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("GlowEquipBase").getChild("EquipEye02");
		this.StaffHead = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("Staff").getChild("StaffHead");
		this.Equip06 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("Equip06");
		this.EquipT02R = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipT01R").getChild("EquipT02R");
		this.Equip02 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("Equip02");
		this.EquipTB02L = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipTB01L").getChild("EquipTB02L");
		this.EquipT01R = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipT01R");
		this.EquipTB01R = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipTB01R");
		this.EquipRC01 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipRC01");
		this.EquipT03R = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipT01R").getChild("EquipT02R").getChild("EquipT03R");
		this.EquipTooth02 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipTooth02");
		this.EquipTB02R = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipTB01R").getChild("EquipTB02R");
		this.Cloak01 = root.getChild("BodyMain").getChild("CloakNeck").getChild("Cloak01");
		this.CloakNeck = root.getChild("BodyMain").getChild("CloakNeck");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.EquipT01L = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipT01L");
		this.BodyMain = root.getChild("BodyMain");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.Neck02 = root.getChild("BodyMain").getChild("Neck").getChild("Neck02");
		this.Equip01 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("Equip01");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.Staff = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("Staff");
		this.Cloak02 = root.getChild("BodyMain").getChild("CloakNeck").getChild("Cloak01").getChild("Cloak02");
		this.EquipRC03 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipRC01").getChild("EquipRC03");
		this.EquipTooth01 = root.getChild("BodyMain").getChild("Head").getChild("EquipBase").getChild("EquipTooth01");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.Cloak03 = root.getChild("BodyMain").getChild("CloakNeck").getChild("Cloak01").getChild("Cloak02").getChild("Cloak03");
		this.Ahoke = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowHead");
		this.GlowEquipBase = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("GlowEquipBase");
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
		this.scale = 0.44F;
		this.offsetY = 1.9F;
		this.offsetItem = new float[] {0.11F, 0.92F, -0.09F};
		this.offsetBlock = new float[] {0.11F, 0.92F, -0.09F};
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
		
		boolean flag = !EmotionHelper.checkModelState(0, state);	//head
		this.EquipBase.visible = !(flag);
		this.GlowEquipBase.visible = !(flag);
				
		flag = !EmotionHelper.checkModelState(1, state);	//weapon
		this.Staff.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);	//neck
		this.Neck.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(3, state);	//cloak
		this.CloakNeck.visible = !(flag);
	
	}

	public void syncRotationGlowPart()
	{

		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowEquipBase.xRot = this.EquipBase.xRot;
		this.GlowEquipBase.yRot = this.EquipBase.yRot;
		this.GlowEquipBase.zRot = this.EquipBase.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (0.41F); this.animTransZ += (0F);
  		this.setFaceHungry(ent);
  		
  		//頭部
	  	this.Head.yRot = 0F;	//左右角度 角度轉成rad 即除以57.29578
	    this.Head.xRot = 0F; 	//上下角度
	    //胸部
  	    this.BoobL.xRot = -0.63F;
  	    this.BoobR.xRot = -0.63F;
  	    //呆毛
  	    this.Ahoke.yRot = 0.5236F;
  	    //手臂晃動 
	    this.ArmRight02.yRot = 0F;
		//身體角度
		this.Butt.y = (4.7F) + (0F) * 16F;
    	//身體角度
		this.BodyMain.xRot = 0.2094F;
		this.BodyMain.yRot = 0F;
		this.BodyMain.zRot = 0F;
		this.Butt.xRot = -0.4189F;
		this.Butt.z = (0.5F) + (-0.12F) * 16F;
    	//手臂
	  	this.ArmLeft01.xRot = -1.0472F;
	    this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = 0.4189F;
	    this.ArmLeft02.xRot = -0.1396F;
	    this.ArmLeft02.yRot = 0F;
	    this.ArmLeft02.zRot = 1.2915F;
	    this.ArmRight01.xRot = -0.8727F;
		this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -0.0873F;
		this.ArmRight02.zRot = -1.1345F;
		//腿擺動
		this.LegLeft01.xRot = -2.2689F;
		this.LegLeft01.yRot = -0.2094F;
		this.LegLeft01.zRot = -0.2094F;
		this.LegLeft02.xRot = 1.7454F;
		this.LegLeft02.z = (-3F) + (0.3F) * 16F;
		this.LegRight01.xRot = -2.2689F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = 0.0873F;
		this.LegRight02.xRot = 1.5708F;
		this.LegRight02.z = (-3F) + (0.3F) * 16F;
		//披風擺動
		this.Cloak01.xRot = 0.2618F;
		this.Cloak02.xRot = -1.3963F;
		this.Cloak03.xRot = -0.9425F;
		//杖位置
		this.Staff.xRot = 1.309F;
		this.Staff.yRot = -0.5934F;
		this.Staff.zRot = -0.2094F;
		this.Staff.x = (8.0F) + (-0.3F) * 16F;
		this.Staff.y = (35.0F) + (-1.5F) * 16F;
		this.Staff.z = (21.0F) + (-1.7F) * 16F;
		//觸手晃動 (equip only)
		if (EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State)))
		{
			this.EquipLC01.xRot = this.Head.xRot;
			this.EquipRC01.xRot = this.Head.xRot;
			
			this.EquipT01L.xRot = - 0.2618F;
			this.EquipT01L.zRot = -0.2618F;
			this.EquipT02L.xRot = -0.3491F;
			this.EquipT02L.zRot = 0.2618F;
			this.EquipT03L.xRot = 1.0472F;
			this.EquipT03L.zRot = 1.0472F;
			
			this.EquipT01R.xRot = -0.2618F;
			this.EquipT01R.zRot = 0.2618F;
			this.EquipT02R.xRot = -0.3491F;
			this.EquipT02R.zRot = -0.2618F;
			this.EquipT03R.xRot = 1.0472F;
			this.EquipT03R.zRot = -1.0472F;

			this.EquipTB01L.xRot = 0.1745F;
			this.EquipTB01L.zRot = -0.3491F;
			this.EquipTB02L.xRot = -0.6981F;
			this.EquipTB02L.zRot = 0.3491F;
			this.EquipTB03L.xRot = 0.1745F;
			this.EquipTB03L.zRot = 0.2618F;
			
			this.EquipTB01R.xRot = 0.1745F;
			this.EquipTB01R.zRot = 0.3491F;
			this.EquipTB02R.xRot = -0.6981F;
			this.EquipTB02R.zRot = -0.3491F;
			this.EquipTB03R.xRot = 0.1745F;
			this.EquipTB03R.zRot = -0.2618F;
		}
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

 		float angleZ = Mth.cos(f2*0.08F);
  		float addk1 = 0;
  		float addk2 = 0;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleZ * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//leg move parm
  		addk1 = Mth.cos(f * 0.4F) * 0.5F * f1;
	  	addk2 = Mth.cos(f * 0.4F + 3.1415927F) * 0.5F * f1;

  	    //移動頭部使其看人
	  	this.Head.xRot = f4 * 0.012F; 	//上下角度
	  	this.Head.yRot = f3 * 0.01F;	//左右角度
	    //正常站立動作
	    //胸部
  	    this.BoobL.xRot = -angleZ * 0.06F - 0.63F;
  	    this.BoobR.xRot = -angleZ * 0.06F - 0.63F;
  	    //呆毛
  	    this.Ahoke.yRot = angleZ * 0.25F + 0.5236F;
  	    //手臂晃動 
	  	this.ArmLeft01.xRot = -0.3F;
  	    this.ArmRight01.xRot = -0.3F;
	    this.ArmLeft01.yRot = 0F;
		this.ArmRight01.yRot = 0F;
		this.ArmLeft01.zRot = 0.24F;
		this.ArmRight01.zRot = -0.24F;
		this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.yRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmRight02.yRot = 0F;
		this.ArmLeft02.zRot = 0F;
		this.ArmRight02.zRot = 0F;
		//身體角度
		this.BodyMain.xRot = -0.1745F;
		this.BodyMain.yRot = 0F;
		this.BodyMain.zRot = 0F;
		this.Butt.xRot = 0.5236F;
		this.Butt.y = (4.7F) + (0F) * 16F;
		this.Butt.z = (0.5F) + (0F) * 16F;
		//hair
		this.HairL01.xRot = -0.3F;
	  	this.HairL02.xRot = 0.35F;
	  	this.HairR01.xRot = -0.3F;
	  	this.HairR02.xRot = 0.35F;
	    this.HairL01.zRot = -0.314F;
	  	this.HairL02.zRot = 0.2618F;
	  	this.HairR01.zRot = 0.314F;
	  	this.HairR02.zRot = -0.2618F;
		//腿擺動
		addk1 += -0.349F;
		addk2 += -0.349F;
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.052F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.z = (-3F) + (0F) * 16F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.052F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.z = (-3F) + (0F) * 16F;
		//披風擺動
		this.Cloak01.xRot = angleZ * 0.05F + 0.2618F;
		this.Cloak02.xRot = angleZ * 0.1F + 0.1745F;
		this.Cloak03.xRot = angleZ * 0.15F + 0.2618F;
		//杖位置
		this.Staff.xRot = 0F;
		this.Staff.yRot = 0F;
		this.Staff.zRot = 1.8326F;
		this.Staff.x = (8.0F) + (-0.7F) * 16F;
		this.Staff.y = (35.0F) + (-1.7F) * 16F;
		this.Staff.z = (21.0F) + (-1.4F) * 16F;
		//觸手晃動 (equip only)
		boolean fhead = EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State));
		if (fhead)
		{
			this.EquipLC01.xRot = this.Head.xRot;
			this.EquipRC01.xRot = this.Head.xRot;
			
			this.EquipT01L.xRot = angleZ * 0.05F + -0.2618F;
			this.EquipT01L.zRot = angleZ * 0.05F + -0.2618F;
			this.EquipT02L.xRot = angleZ * 0.1F;
			this.EquipT02L.zRot = angleZ * 0.1F;
			this.EquipT03L.xRot = angleZ * 0.25F;
			this.EquipT03L.zRot = angleZ * 0.25F;
			
			this.EquipT01R.xRot = angleZ * 0.05F + -0.2618F;
			this.EquipT01R.zRot = -angleZ * 0.05F + 0.2618F;
			this.EquipT02R.xRot = angleZ * 0.1F;
			this.EquipT02R.zRot = -angleZ * 0.1F;
			this.EquipT03R.xRot = angleZ * 0.25F;
			this.EquipT03R.zRot = -angleZ * 0.25F;

			this.EquipTB01L.xRot = -angleZ * 0.05F + 0.2618F;
			this.EquipTB01L.zRot = angleZ * 0.05F + -0.2618F;
			this.EquipTB02L.xRot = -angleZ * 0.1F;
			this.EquipTB02L.zRot = angleZ * 0.1F;
			this.EquipTB03L.xRot = -angleZ * 0.25F;
			this.EquipTB03L.zRot = angleZ * 0.25F;
			
			this.EquipTB01R.xRot = -angleZ * 0.05F + 0.2618F;
			this.EquipTB01R.zRot = -angleZ * 0.05F + 0.2618F;
			this.EquipTB02R.xRot = -angleZ * 0.1F;
			this.EquipTB02R.zRot = -angleZ * 0.1F;
			this.EquipTB03R.xRot = -angleZ * 0.25F;
			this.EquipTB03R.zRot = -angleZ * 0.25F;
		}

	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {	//奔跑動作
			float angleZFast = Mth.cos(f2*0.3F);
	  	    //手臂晃動 
		  	this.ArmLeft01.xRot = -0.6981F;
	  	    this.ArmRight01.xRot = -0.6981F;
		    this.ArmLeft01.yRot = 0.4F;
			this.ArmRight01.yRot = -0.4F;
			this.ArmLeft01.zRot = 0F;
			this.ArmRight01.zRot = 0F;
			//身體角度
			this.BodyMain.xRot = -0.349F;
			//腿擺動
			addk1 = 0F;
			addk2 = 0F;
			this.LegLeft01.yRot = 0F;
			this.LegRight01.yRot = 0F;
			this.LegLeft01.zRot = 0.05236F;
			this.LegRight01.zRot = -0.05236F;
			//披風擺動
			this.Cloak01.xRot = angleZFast * 0.1F + 1.2F;
			this.Cloak02.xRot = angleZFast * 0.25F;
			this.Cloak03.xRot = angleZFast * 0.15F;
			//杖位置
			this.Staff.xRot = 1.3F;
			this.Staff.yRot = -0.1820F;
			this.Staff.zRot = -1.2292F;
			this.Staff.x = (8.0F) + (0.2F) * 16F;
			this.Staff.y = (35.0F) + (-1F) * 16F;
			this.Staff.z = (21.0F) + (-0.1F) * 16F;
			//觸手晃動 (equip only)
			if (fhead)
			{
				this.EquipT01L.xRot = angleZFast * 0.05F + 0.2618F;
				this.EquipT01L.zRot = -0.2618F;
				this.EquipT02L.xRot = angleZFast * 0.15F + 0.2618F;
				this.EquipT02L.zRot = -0.2618F;
				this.EquipT03L.xRot = angleZFast * 0.45F + 0.5236F;
				this.EquipT03L.zRot = -0.2618F;
				
				this.EquipT01R.xRot = angleZFast * 0.05F + 0.2618F;
				this.EquipT01R.zRot = 0.2618F;
				this.EquipT02R.xRot = angleZFast * 0.15F + 0.2618F;
				this.EquipT02R.zRot = 0.2618F;
				this.EquipT03R.xRot = angleZFast * 0.45F + 0.5236F;
				this.EquipT03R.zRot = 0.2618F;

				this.EquipTB01L.xRot = angleZFast * 0.05F + 0.349F;
				this.EquipTB01L.zRot = -0.349F;
				this.EquipTB02L.xRot = angleZFast * 0.15F + 0.5236F;
				this.EquipTB02L.zRot = 0.1745F;
				this.EquipTB03L.xRot = angleZFast * 0.45F + 0.5236F;
				this.EquipTB03L.zRot = 0.1745F;
				
				this.EquipTB01R.xRot = angleZFast * 0.05F + 0.349F;
				this.EquipTB01R.zRot = 0.349F;
				this.EquipTB02R.xRot = angleZFast * 0.15F + 0.5236F;
				this.EquipTB02R.zRot = -0.1745F;
				this.EquipTB03R.xRot = angleZFast * 0.45F + 0.5236F;
				this.EquipTB03R.zRot = -0.1745F;
			}
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
  		
	    if (ent.getIsSneaking())
	    {
this.animTransX += (0F); this.animTransY += (0.05F); this.animTransZ += (0F);
	    	//潛行, 蹲下動作
  			this.ArmLeft01.xRot = 0.7F;
  			this.ArmRight01.xRot = 0.7F;
  			this.BodyMain.xRot = 0.5F;
  			this.Head.xRot -= 0.5F;
  			this.Cloak01.xRot = angleZ * 0.02F + 0.34F;
  			addk1 -= 0.66F;
			addk2 -= 0.66F;
  		}
	    else
	    {
			this.Head.xRot += 0.2F;
	    }
  		
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {	//騎乘動作
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
this.animTransX += (0F); this.animTransY += (0.41F); this.animTransZ += (0F);
		    	//身體角度
				this.BodyMain.xRot = 0.2094F;
				this.BodyMain.yRot = 0F;
				this.BodyMain.zRot = 0F;
				this.Butt.xRot = -0.4189F;
				this.Butt.z = (0.5F) + (-0.12F) * 16F;
				//頭
				this.Head.yRot *= 0.5F;
		    	//手臂
			  	this.ArmLeft01.xRot = -1.0472F;
			    this.ArmLeft01.yRot = 0F;
			    this.ArmLeft01.zRot = 0.4189F;
			    this.ArmLeft02.xRot = -0.1396F;
			    this.ArmLeft02.yRot = 0F;
			    this.ArmLeft02.zRot = 1.2915F;
			    this.ArmRight01.xRot = -0.8727F;
				this.ArmRight01.yRot = 0F;
				this.ArmRight01.zRot = -0.0873F;
				this.ArmRight02.zRot = -1.1345F;
				//腿擺動
				addk1 = -2.2689F;
				addk2 = -2.2689F;
				this.LegLeft01.yRot = -0.2094F;
				this.LegLeft01.zRot = -0.2094F;
				this.LegLeft02.xRot = 1.7454F;
				this.LegLeft02.z = (-3F) + (0.3F) * 16F;
				this.LegRight01.yRot = 0F;
				this.LegRight01.zRot = 0.0873F;
				this.LegRight02.xRot = 1.5708F;
				this.LegRight02.z = (-3F) + (0.3F) * 16F;
				//披風擺動
				this.Cloak01.xRot = 0.2618F;
				this.Cloak02.xRot = -1.3963F;
				this.Cloak03.xRot = -0.9425F;
				//杖位置
				this.Staff.xRot = 1.309F;
				this.Staff.yRot = -0.5934F;
				this.Staff.zRot = -0.2094F;
				this.Staff.x = (8.0F) + (-0.3F) * 16F;
				this.Staff.y = (35.0F) + (-1.5F) * 16F;
				this.Staff.z = (21.0F) + (-1.7F) * 16F;
				//觸手晃動 (equip only)
				if (fhead)
				{
					this.EquipT01L.xRot = angleZ * 0.01F - 0.2618F;
					this.EquipT01L.zRot = -0.2618F;
					this.EquipT02L.xRot = angleZ * 0.03F - 0.3491F;
					this.EquipT02L.zRot = 0.2618F;
					this.EquipT03L.xRot = -angleZ * 0.1F + 1.0472F;
					this.EquipT03L.zRot = 1.0472F;
					
					this.EquipT01R.xRot = -angleZ * 0.01F - 0.2618F;
					this.EquipT01R.zRot = 0.2618F;
					this.EquipT02R.xRot = -angleZ * 0.03F - 0.3491F;
					this.EquipT02R.zRot = -0.2618F;
					this.EquipT03R.xRot = angleZ * 0.1F + 1.0472F;
					this.EquipT03R.zRot = -1.0472F;

					this.EquipTB01L.xRot = angleZ * 0.01F + 0.1745F;
					this.EquipTB01L.zRot = -0.3491F;
					this.EquipTB02L.xRot = angleZ * 0.03F - 0.6981F;
					this.EquipTB02L.zRot = 0.3491F;
					this.EquipTB03L.xRot = angleZ * 0.05F + 0.1745F;
					this.EquipTB03L.zRot = 0.2618F;
					
					this.EquipTB01R.xRot = -angleZ * 0.01F + 0.1745F;
					this.EquipTB01R.zRot = 0.3491F;
					this.EquipTB02R.xRot = -angleZ * 0.03F - 0.6981F;
					this.EquipTB02R.zRot = -0.3491F;
					this.EquipTB03R.xRot = -angleZ * 0.05F + 0.1745F;
					this.EquipTB03R.zRot = -0.2618F;
	  			}
	    	}
	    	else
	    	{
	    		//手臂晃動 
			  	this.ArmLeft01.xRot = 0.4F;
			    this.ArmLeft01.yRot = 0F;
			    this.ArmLeft01.zRot = -0.32F;
			    this.ArmRight01.xRot = 0.34F;
				this.ArmRight01.yRot = 0F;
				this.ArmRight01.zRot = 0.5236F;
				//身體角度
				this.BodyMain.xRot = -0.349F;
				this.BodyMain.yRot = -1.57F;
				this.BodyMain.zRot = -0.0873F;
				//脖子角度
				this.Head.xRot += -0.25F;
				this.Head.yRot += 0.4F;
				this.Head.zRot += 0F;
				//腿擺動
				addk1 = angleZ * 0.3F + -1.0472F;
				addk2 = -angleZ * 0.3F + -1.0472F;
				this.LegLeft01.yRot = 0F;
				this.LegRight01.yRot = 0F;
				this.LegLeft01.zRot = 0.05236F;
				this.LegRight01.zRot = -0.05236F;
				//披風擺動
				this.Cloak01.xRot = angleZ * 0.1F + 0.4F;
				this.Cloak02.xRot = angleZ * 0.15F;
				this.Cloak03.xRot = angleZ * 0.15F;
				//杖位置
				this.Staff.xRot = 0.2F;
				this.Staff.yRot = 0F;
				this.Staff.zRot = -2.0F;
				this.Staff.x = (8.0F) + (1.1F) * 16F;
				this.Staff.y = (35.0F) + (-1.95F) * 16F;
				this.Staff.z = (21.0F) + (-1.4F) * 16F;
				//觸手晃動 (equip only)
				if (fhead)
				{
					this.EquipT01L.xRot = -angleZ * 0.05F + 0.2618F;
					this.EquipT01L.zRot = -0.2618F;
					this.EquipT02L.xRot = -angleZ * 0.15F + 0.2618F;
					this.EquipT02L.zRot = -0.1618F;
					this.EquipT03L.xRot = -angleZ * 0.45F + 0F;
					this.EquipT03L.zRot = -0.2618F;
					
					this.EquipT01R.xRot = angleZ * 0.05F + 0.2618F;
					this.EquipT01R.zRot = 0.2618F;
					this.EquipT02R.xRot = angleZ * 0.15F + 0.2618F;
					this.EquipT02R.zRot = 0.1618F;
					this.EquipT03R.xRot = angleZ * 0.45F + 0F;
					this.EquipT03R.zRot = 0.2618F;
	
					this.EquipTB01L.xRot = angleZ * 0.05F + 0.349F;
					this.EquipTB01L.zRot = -0.349F;
					this.EquipTB02L.xRot = angleZ * 0.15F + 0.2236F;
					this.EquipTB02L.zRot = 0.1745F;
					this.EquipTB03L.xRot = angleZ * 0.45F + 0.1236F;
					this.EquipTB03L.zRot = 0.1745F;
					
					this.EquipTB01R.xRot = -angleZ * 0.05F + 0.349F;
					this.EquipTB01R.zRot = 0.349F;
					this.EquipTB02R.xRot = -angleZ * 0.15F + 0.2236F;
					this.EquipTB02R.zRot = -0.1745F;
					this.EquipTB03R.xRot = -angleZ * 0.45F + 0.1236F;
					this.EquipTB03R.zRot = -0.1745F;
	  			}
	    	}
  		}
	    
	    //鬢毛調整
	    float headX = this.Head.xRot * -0.5F;
	    float headZ = this.Head.zRot * -0.5F;
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
	    
	    //攻擊時順便將左手指向對方	    
	    if (ent.getAttackTick() > 0)
	    {
	    	this.ArmLeft01.xRot = f4 / 57.29578F - 1.5F;
	    	this.ArmRight01.zRot = 0.7F;
	    	this.ArmRight01.xRot = 0.4F;
	    	//杖位置
			this.Staff.xRot = 1.5F;
			this.Staff.yRot = 0F;
			this.Staff.zRot = -1.2F;
			this.Staff.x = (8.0F) + (-0.2F) * 16F;
			this.Staff.y = (35.0F) + (-1.2F) * 16F;
			this.Staff.z = (21.0F) + (-1.0F) * 16F;
	    }
	    
	    //swing arm
	  	float f6 = ent.getSwingTime(f2 - (int)f2);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight01.xRot = -0.2F;
	        this.ArmRight01.yRot = 0F;
	        this.ArmRight01.zRot = -0.1F;
	        this.ArmRight01.xRot += -f8 * 80.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.yRot += -f7 * 20.0F * Values.N.DIV_PI_180 + 0.2F;
	        this.ArmRight01.zRot += -f8 * 20.0F * Values.N.DIV_PI_180;
	        this.ArmRight02.xRot = 0F;
	        this.ArmRight02.yRot = 0F;
	        this.ArmRight02.zRot = 0F;
	  	}
	
	}

	public void setFaceNormal(IShipEmotion ent)
	{

		this.setFace(0);
		
		if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED && (ent.getTickExisted() & 255) > 200)
		{
			this.setMouth(0);
		}
		else
		{
			this.setMouth(3);
		}
	
	}

	public void setFaceBlink0(IShipEmotion ent)
	{

		this.setFace(0);
	
	}

	public void setFaceBlink1(IShipEmotion ent)
	{

		this.setFace(1);
	
	}

	public void setFaceCry(IShipEmotion ent)
	{

		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;
		
		if (t < 128)
		{
			this.setFace(6);
			
			if (t < 64)
			{
				this.setMouth(2);
			}
			else
			{
				this.setMouth(1);
			}
		}
		else
		{
			this.setFace(7);
			this.setMouth(2);
		}
	
	}

	public void setFaceAttack(IShipEmotion ent)
	{

		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 511;
		
		if (t < 160)
		{
			this.setFace(0);
			
			if (t < 80)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(1);
			}
		}
		else if (t < 320)
		{
			this.setFace(2);
			
			if (t < 220)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(1);
			}
		}
		else if (t < 410)
		{
			this.setFace(3);
			
			if (t < 360)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(4);
			}
		}
		else
		{
			this.setFace(8);
			
			if (t < 470)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(1);
			}
		}
	
	}

	public void setFaceDamaged(IShipEmotion ent)
	{

		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 511;
		
		if (t < 200)
		{
			this.setFace(6);
			
			if (t < 60)
			{
				this.setMouth(2);
			}
			else
			{
				this.setMouth(1);
			}
		}
		else if (t < 400)
		{
			this.setFace(3);
			
			if (t < 250)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(3);
			}
		}
		else
		{
			this.setFace(9);
			
			if (t < 450)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(1);
			}
		}
	
	}

	public void setFaceScorn(IShipEmotion ent)
	{

		this.setFace(2);
		this.setMouth(1);
	
	}

	public void setFaceHungry(IShipEmotion ent)
	{

		this.setFace(4);	
		this.setMouth(2);
	
	}

	public void setFaceAngry(IShipEmotion ent)
	{

		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;
		
		if (t < 128)
		{
			this.setFace(1);
			
			if (t < 64)
			{
				this.setMouth(3);
			}
			else
			{
				this.setMouth(1);
			}
		}
		else
		{
			this.setFace(2);

			if (t < 170)
			{
				this.setMouth(1);
			}
			else
			{
				this.setMouth(3);
			}
		}
	
	}

	public void setFaceBored(IShipEmotion ent)
	{

		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 511;
		
		if (t < 170)
		{
			this.setFace(1);
			
			if (t < 80)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(3);
			}
		}
		else if (t < 340)
		{
			this.setFace(8);

			if (t < 250)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(3);
			}
		}
		else
		{
			this.setFace(0);

			if (t < 420)
			{
				this.setMouth(0);
			}
			else
			{
				this.setMouth(3);
			}
		}
	
	}

	public void setFaceShy(IShipEmotion ent)
	{

		this.setFlush(true);
		
		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;
		
		this.setFace(0);
		
		if (t < 150)
		{
			this.setMouth(3);
		}
		else
		{
			this.setMouth(2);
		}
	
	}

	public void setFaceHappy(IShipEmotion ent)
	{

		this.setFlush(true);
		
		int t = (ent.getTickExisted() + (ent.getStateMinor(ID.M.ShipUID) << 7)) & 255;
		
		if (t < 140)
		{
			this.setFace(3);
			
			if (t < 80)
			{
				this.setMouth(3);
			}
			else
			{
				this.setMouth(4);
			}
		}
		else
		{
			this.setFace(8);
			this.setMouth(0);
		}
	
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

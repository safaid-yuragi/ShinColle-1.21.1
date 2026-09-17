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

public class ModelAirfieldHime<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart Butt;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart HeadHL;
	public ModelPart HeadHR;
	public ModelPart Ahoke;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart HairL02;
	public ModelPart HairR02;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart Hair03;
	public ModelPart HeadHL2;
	public ModelPart HeadHL3;
	public ModelPart HeadHR2;
	public ModelPart HeadHR3;
	public ModelPart ArmLeft02;
	public ModelPart EquipHand01;
	public ModelPart ArmRight02;
	public ModelPart EquipHand02;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart LegRight02;
	public ModelPart ShoesR;
	public ModelPart LegLeft02;
	public ModelPart ShoesL;
	public ModelPart EquipRdL01;
	public ModelPart EquipRdR01;
	public ModelPart EquipRdL02;
	public ModelPart EquipRdL03;
	public ModelPart EquipRdL04;
	public ModelPart EquipRdL05;
	public ModelPart EquipRdL06;
	public ModelPart EquipRdR02;
	public ModelPart EquipRdR03;
	public ModelPart EquipRdR04;
	public ModelPart EquipRdR05;
	public ModelPart EquipRdR06;
	public ModelPart GlowEquipBase;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-3.7F, -8.6F, -3.5F, -0.6981317007977318F, -0.13962634015954636F, -0.08726646259971647F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(3.7F, -8.6F, -3.5F, -0.6981317007977318F, 0.13962634015954636F, 0.08726646259971647F));
		PartDefinition partdef3 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 4.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.7F, 9.5F, -2.6F, 0.0F, 0.0F, 0.14F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 7.0F, 6.0F), PartPose.offset(0.0F, 14.0F, -3.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("ShoesL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 8.0F, 7.0F), PartPose.offset(0.0F, 7.0F, 3.0F));
		PartDefinition partdef7 = partdef3.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.7F, 9.5F, -2.6F, -0.10471975511965977F, 0.0F, -0.14F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 7.0F, 6.0F), PartPose.offset(0.0F, 14.0F, -3.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("ShoesR", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 8.0F, 7.0F), PartPose.offset(0.0F, 7.0F, 3.0F));
		PartDefinition partdef10 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 13.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.20943951023931953F, 0.0F, 0.20943951023931953F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0.0F, 0.0F, -5.0F, 5.0F, 13.0F, 5.0F), PartPose.offset(-3.0F, 12.0F, 2.5F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("EquipHand02", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offset(2.5F, -0.5F, -2.5F));
		PartDefinition partdef13 = partdef10.addOrReplaceChild("EquipHand01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 5.0F, 6.0F), PartPose.offset(-0.5F, 7.5F, 0.0F));
		PartDefinition partdef14 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-5.5F, -2.0F, -5.0F, 11.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -10.3F, -0.5F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 10.0F), PartPose.offset(0.0F, -15.0F, -3.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 17.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("Hair03", CubeListBuilder.create().addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 12.5F, -0.1F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef15.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.2F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.0F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -4.0F, -11.5F, 0.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -10.5F, -5.0F, 0.0F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef22 = partdef20.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(-6.5F, 3.0F, -3.0F, -0.2617993877991494F, 0.17453292519943295F, 0.13962634015954636F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(0.2F, 10.0F, 0.0F, 0.2617993877991494F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef24 = partdef20.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(6.5F, 3.0F, -3.0F, -0.2617993877991494F, -0.17453292519943295F, -0.13962634015954636F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef26 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 13.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.20943951023931953F, 0.0F, -0.20943951023931953F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 13.0F, 5.0F), PartPose.offset(3.0F, 12.0F, 2.5F));
		PartDefinition partdef28 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.3F, -0.5F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef32 = partdef30.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef33 = partdef30.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef34 = partdef30.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef35 = partdef30.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef36 = partdef30.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef37 = partdef30.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef38 = partdef30.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef39 = partdef30.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef40 = partdef30.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));
		PartDefinition partdef41 = partdef30.addOrReplaceChild("HeadHL", CubeListBuilder.create().mirror().addBox(0.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(6.4F, -10.6F, 0.8F, -0.7853981633974483F, -0.17453292519943295F, -0.3141592653589793F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("HeadHL2", CubeListBuilder.create().addBox(0.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F), PartPose.offset(3.0F, 0.0F, 0.0F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("HeadHL3", CubeListBuilder.create().addBox(0.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F), PartPose.offset(1.0F, 0.0F, 0.0F));
		PartDefinition partdef44 = partdef30.addOrReplaceChild("HeadHR", CubeListBuilder.create().mirror().addBox(-3.0F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-6.4F, -10.6F, 0.8F, -0.7853981633974483F, 0.17453292519943295F, 0.3141592653589793F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("HeadHR2", CubeListBuilder.create().addBox(-1.0F, -2.0F, -2.0F, 1.0F, 4.0F, 4.0F), PartPose.offset(-3.0F, 0.0F, 0.0F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("HeadHR3", CubeListBuilder.create().addBox(-1.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F), PartPose.offset(-1.0F, 0.0F, 0.0F));
		PartDefinition partdef47 = partdef28.addOrReplaceChild("GlowEquipBase", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("EquipRdL01", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(5.0F, 0.0F, 6.0F, 1.4F, -0.3490658503988659F, -0.3490658503988659F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("EquipRdL02", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("EquipRdL03", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.4363F, 0.0F, 0.0F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("EquipRdL04", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("EquipRdL05", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("EquipRdL06", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition partdef54 = partdef47.addOrReplaceChild("EquipRdR01", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(-5.0F, 0.0F, 6.0F, 1.4F, 0.3490658503988659F, 0.3490658503988659F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("EquipRdR02", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef56 = partdef55.addOrReplaceChild("EquipRdR03", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.4363F, 0.0F, 0.0F));
		PartDefinition partdef57 = partdef56.addOrReplaceChild("EquipRdR04", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("EquipRdR05", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.2618F, 0.0F, 0.0F));
		PartDefinition partdef59 = partdef58.addOrReplaceChild("EquipRdR06", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelAirfieldHime(ModelPart root)
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
		this.HairR02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.BodyMain = root.getChild("BodyMain");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.HeadHR3 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHR").getChild("HeadHR2").getChild("HeadHR3");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.EquipHand02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipHand02");
		this.HairL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.HeadHR = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHR");
		this.ShoesR = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoesR");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.HeadHL2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHL").getChild("HeadHL2");
		this.HeadHR2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHR").getChild("HeadHR2");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.HeadHL3 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHL").getChild("HeadHL2").getChild("HeadHL3");
		this.ShoesL = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoesL");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.HeadHL = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadHL");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.EquipRdL01 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipRdL01");
		this.EquipRdR01 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipRdR01");
		this.EquipRdL02 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipRdL01").getChild("EquipRdL02");
		this.EquipRdR02 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipRdR01").getChild("EquipRdR02");
		this.EquipRdL03 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipRdL01").getChild("EquipRdL02").getChild("EquipRdL03");
		this.EquipRdR03 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipRdR01").getChild("EquipRdR02").getChild("EquipRdR03");
		this.EquipRdL04 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipRdL01").getChild("EquipRdL02").getChild("EquipRdL03").getChild("EquipRdL04");
		this.EquipRdR04 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipRdR01").getChild("EquipRdR02").getChild("EquipRdR03").getChild("EquipRdR04");
		this.EquipRdL05 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipRdL01").getChild("EquipRdL02").getChild("EquipRdL03").getChild("EquipRdL04").getChild("EquipRdL05");
		this.EquipRdR05 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipRdR01").getChild("EquipRdR02").getChild("EquipRdR03").getChild("EquipRdR04").getChild("EquipRdR05");
		this.EquipRdL06 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipRdL01").getChild("EquipRdL02").getChild("EquipRdL03").getChild("EquipRdL04").getChild("EquipRdL05").getChild("EquipRdL06");
		this.EquipRdR06 = root.getChild("GlowBodyMain").getChild("GlowEquipBase").getChild("EquipRdR01").getChild("EquipRdR02").getChild("EquipRdR03").getChild("EquipRdR04").getChild("EquipRdR05").getChild("EquipRdR06");
		this.EquipHand01 = root.getChild("BodyMain").getChild("ArmRight01").getChild("EquipHand01");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.Hair03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02").getChild("Hair03");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.GlowEquipBase = root.getChild("GlowBodyMain").getChild("GlowEquipBase");
		this.scale = 0.47F;
		this.offsetY = 1.75F;
		this.offsetItem = new float[] {0.08F, 1.02F, -0.07F};
		this.offsetBlock = new float[] {0.08F, 1.02F, -0.07F};
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
		
		boolean flag = !EmotionHelper.checkModelState(1, state);
		this.EquipHand01.visible = !(flag);
		this.EquipHand02.visible = !(flag);
	
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

    	float addk1 = 0F;
  		float addk2 = 0F;
  		float headX = 0F;
  		float headZ = 0F;
  		
this.animTransX += (0F); this.animTransY += (0.55F); this.animTransZ += (0F);
  		this.setFaceHungry(ent);
  		
  		//移動頭部使其看人
  		this.Head.xRot = 0F;	//左右角度
	  	this.Head.yRot = 0F;
	  	this.Head.zRot = 0F;
	  	headX = this.Head.xRot * -0.5F;
	    //正常站立動作
	    //胸部
  	    this.BoobL.xRot = -0.7F;
  	    this.BoobR.xRot = -0.7F;
	  	//Body
  	    this.Ahoke.yRot = 0.5236F;
	  	this.BodyMain.zRot = 0F;
	  	//hair
	  	this.Hair01.xRot = 0.26F + headX;
	  	this.Hair02.xRot = -0.08F + headX;
	  	this.Hair03.xRot = -0.14F;
	    //arm 
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft02.xRot = 0F;
		this.ArmRight02.xRot = 0F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegRight01.yRot = 0F;
		//equip
		this.EquipRdL01.visible = false;
		this.EquipRdR01.visible = false;
		
    	//Body
    	this.Head.xRot += 0.14F;
	  	this.BodyMain.xRot = 0.4F;
	  	this.Butt.xRot = -0.4F;
	  	this.Butt.z = (0.0F) + (0.19F) * 16F;
	  	this.BoobL.xRot -= 0.2F;
	  	this.BoobR.xRot -= 0.2F;
	    //arm 
	  	this.ArmLeft01.xRot = -1.3F;
	    this.ArmLeft01.zRot = -0.1F;
	    this.ArmLeft02.zRot = 1.15F;
		this.ArmRight01.xRot = -1.3F;
		this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = 0.1F;
		this.ArmRight02.zRot = -1.4F;
		//leg
		addk1 = -2.1232F;
		addk2 = -2.0708F;
		this.LegLeft01.zRot = -0.2F;
		this.LegLeft02.xRot = 1.34F;
		this.LegRight01.zRot = 0.2F;
		this.LegRight02.xRot = 1.13F;
		//hair
		this.Hair01.xRot -= 0.2F;
		this.Hair02.xRot -= 0.2F;
		this.Hair03.xRot -= 0.1F;
		
		//移動頭髮避免穿過身體
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.zRot = headZ;
	  	this.Hair02.zRot = headZ;
	  	this.HairL01.zRot = headZ - 0.0F;
	  	this.HairL02.zRot = headZ + 0.087F;
	  	this.HairR01.zRot = headZ + 0.0F;
	  	this.HairR02.zRot = headZ - 0.052F;
	  	
	    headX = this.Head.xRot * -0.5F;
	    this.HairL01.xRot = headX - 0.5F;
	  	this.HairL02.xRot = headX - 0.1F;
	  	this.HairR01.xRot = headX - 0.5F;
	  	this.HairR02.xRot = headX - 0.1F;
	  	
	    //leg motion
	    this.LegLeft01.xRot = addk1;
	    this.LegRight01.xRot = addk2;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F);
  		float angleX1 = Mth.cos(f2*0.08F + 0.3F + f * 0.5F);
  		float angleX2 = Mth.cos(f2*0.08F + 0.6F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.7F;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.7F;
  		float addk1 = 0F;
  		float addk2 = 0F;
  		float headX = 0F;
  		float headZ = 0F;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//leg move parm
  		addk1 = angleAdd1;
	  	addk2 = angleAdd2 - 0.2F;

  	    //移動頭部使其看人
	  	this.Head.xRot = f4 * 0.014F; 	//上下角度
	  	this.Head.yRot = f3 * 0.01F;	//左右角度
	  	this.Head.zRot = 0F;
	  	headX = this.Head.xRot * -0.5F;
	    //正常站立動作
	    //胸部
  	    this.BoobL.xRot = angleX * 0.06F - 0.7F;
  	    this.BoobR.xRot = angleX * 0.06F - 0.7F;
	  	//Body
  	    this.Ahoke.yRot = angleX * 0.25F + 0.5236F;
	  	this.BodyMain.xRot = -0.1745F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.3142F;
	  	this.Butt.z = (0.0F) + (0F) * 16F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.03F + 0.26F + headX;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -angleX1 * 0.04F - 0.08F + headX;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -angleX2 * 0.07F - 0.14F;
	  	this.Hair03.zRot = 0F;
	    //arm 
	  	this.ArmLeft01.xRot = angleAdd2 * 0.8F + 0.2F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = angleX * 0.08F - 0.2F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmRight01.xRot = angleAdd1 * 0.8F + 0.2F;
		this.ArmRight01.zRot = -angleX * 0.08F + 0.2F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.zRot = 0F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.14F;
		this.LegLeft02.xRot = 0F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.14F;
		this.LegRight02.xRot = 0F;
		//equip
		this.EquipRdL01.visible = false;
		this.EquipRdR01.visible = false;

	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {	//奔跑動作
	    	//沒有特殊跑步動作
  		}
	    
	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    //移動頭髮避免穿過身體
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.zRot = headZ;
	  	this.Hair02.zRot = headZ;
	  	this.HairL01.zRot = headZ - 0.14F;
	  	this.HairL02.zRot = headZ + 0.087F;
	  	this.HairR01.zRot = headZ + 0.14F;
	  	this.HairR02.zRot = headZ - 0.052F;
	    
	    if (ent.getIsSneaking())
	    {	//潛行, 蹲下動作
this.animTransX += (0F); this.animTransY += (0.07F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 0.6283F;
		  	this.BodyMain.xRot = 0.8727F;
		    //arm 
		  	this.ArmLeft01.xRot = -0.35F;
		    this.ArmLeft01.zRot = 0.2618F;
			this.ArmRight01.xRot = -0.35F;
			this.ArmRight01.zRot = -0.2618F;
			//leg
			addk1 -= 1.1F;
			addk2 -= 1.1F;
			//hair
			this.Hair01.xRot += 0.37F;
			this.Hair02.xRot += 0.23F;
			this.Hair03.xRot -= 0.1F;
  		}//end if sneaking
  		
	    if (ent.getIsSitting() && !ent.getIsRiding())
	    {	//騎乘動作  	
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
this.animTransX += (0F); this.animTransY += (0.27F); this.animTransZ += (0F);
		    	//Body
		    	this.Head.xRot += 0.14F;
			  	this.BodyMain.xRot = -0.4363F;
			  	this.BoobL.xRot -= 0.25F;
			  	this.BoobR.xRot -= 0.25F;
			    //arm 
			  	this.ArmLeft01.xRot = -0.3142F;
			    this.ArmLeft01.zRot = 0.3490F;
			    this.ArmLeft02.zRot = 1.15F;
				this.ArmRight01.xRot = -0.4363F;
				this.ArmRight01.zRot = -0.2793F;
				this.ArmRight02.zRot = -1.4F;
				//leg
				addk1 = -1.3090F;
				addk2 = -1.7F;
				this.LegLeft01.yRot = 0.3142F;
				this.LegLeft02.xRot = 1.0472F;
				this.LegRight01.yRot = -0.35F;
				this.LegRight01.zRot = -0.2618F;
				this.LegRight02.xRot = 0.9F;
				//hair
				this.Hair01.xRot += 0.12F;
				this.Hair02.xRot += 0.15F;
				this.Hair03.xRot += 0.25F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.37F); this.animTransZ += (0F);
		    	//Body
		    	this.Head.xRot += 0.14F;
			  	this.BodyMain.xRot = -0.5236F;
			  	this.BoobL.xRot -= 0.2F;
			  	this.BoobR.xRot -= 0.2F;
			    //arm 
			  	this.ArmLeft01.xRot = -0.4363F;
			    this.ArmLeft01.zRot = 0.3142F;
				this.ArmRight01.xRot = -0.4363F;
				this.ArmRight01.zRot = -0.3142F;
				//leg
				addk1 = -1.6232F;
				addk2 = -1.5708F;
				this.LegLeft01.zRot = -0.3142F;
				this.LegLeft02.xRot = 1.34F;
				this.LegRight01.zRot = 0.35F;
				this.LegRight02.xRot = 1.13F;
				//hair
				this.Hair01.xRot += 0.09F;
				this.Hair02.xRot += 0.43F;
				this.Hair03.xRot += 0.49F;
	    	}
  		}//end sitting
	    
	    if (ent.getIsRiding())
	    {
	    	if (((Entity)ent).getVehicle() instanceof BasicEntityMount)
	    	{
	    		if (ent.getIsSitting())
	    		{
this.animTransX += (0F); this.animTransY += (0.22F); this.animTransZ += (0.2F);
	    			
	    			if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    			{
				    	//Body
				    	this.Head.xRot -= 0.3F;
					  	this.BodyMain.xRot = -0.4363F;
					  	this.BoobL.xRot -= 0.25F;
					  	this.BoobR.xRot -= 0.25F;
					    //arm
					  	this.ArmLeft01.xRot = -0.3142F;
					    this.ArmLeft01.zRot = 0.3490F;
					    this.ArmLeft02.zRot = 1.15F;
						this.ArmRight01.xRot = -0.4363F;
						this.ArmRight01.zRot = -0.2793F;
						this.ArmRight02.zRot = -1.4F;
						//leg
						addk1 = -1.3090F;
						addk2 = -1.7F;
						this.LegLeft01.yRot = 0.3142F;
						this.LegLeft02.xRot = 1.0472F;
						this.LegRight01.yRot = -0.35F;
						this.LegRight01.zRot = -0.2618F;
						this.LegRight02.xRot = 0.9F;
						//hair
						this.Hair01.xRot += 0.12F;
						this.Hair02.xRot += 0.15F;
						this.Hair03.xRot += 0.25F;
			    	}
			    	else
			    	{
				    	//Body
					  	this.BodyMain.xRot = -0.5236F;
					  	this.BoobL.xRot -= 0.2F;
					  	this.BoobR.xRot -= 0.2F;
					    //arm 
					  	this.ArmLeft01.xRot = -0.4363F;
					    this.ArmLeft01.zRot = 0.3142F;
						this.ArmRight01.xRot = -0.4363F;
						this.ArmRight01.zRot = -0.3142F;
						//leg
						addk1 = -1.6232F;
						addk2 = -1.5708F;
						this.LegLeft01.zRot = -0.3142F;
						this.LegLeft02.xRot = 1.34F;
						this.LegRight01.zRot = 0.35F;
						this.LegRight02.xRot = 1.13F;
						//hair
						this.Hair01.xRot += 0.09F;
						this.Hair02.xRot += 0.43F;
						this.Hair03.xRot += 0.49F;
			    	}
		    	}//end if sitting
		    	else
		    	{
		    		//body
		    		this.Head.xRot -= 0.1F;
				    //arm 
				  	this.ArmLeft01.xRot = 0.5F;
				    this.ArmLeft01.zRot = -1.2F;
					this.ArmRight01.xRot = 0.5F;
					this.ArmRight01.zRot = 1.2F;
					//leg
					addk1 = -0.2618F;
					addk2 = -0.35F;
					this.LegRight02.xRot = 0.8727F;
					//hair
					this.Hair01.xRot += 0.45F;
					this.Hair02.xRot += 0.43F;
					this.Hair03.xRot += 0.49F;
		    	}
	    	}//end ship mount
	    	else
	    	{	//normal mount ex: cart
	    		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    		{
this.animTransX += (0F); this.animTransY += (0.27F); this.animTransZ += (0F);
			    	//Body
			    	this.Head.xRot += 0.14F;
				  	this.BodyMain.xRot = -0.4363F;
				  	this.BoobL.xRot -= 0.25F;
				  	this.BoobR.xRot -= 0.25F;
				    //arm 
				  	this.ArmLeft01.xRot = -0.3142F;
				    this.ArmLeft01.zRot = 0.3490F;
				    this.ArmLeft02.zRot = 1.15F;
					this.ArmRight01.xRot = -0.4363F;
					this.ArmRight01.zRot = -0.2793F;
					this.ArmRight02.zRot = -1.4F;
					//leg
					addk1 = -1.3090F;
					addk2 = -1.7F;
					this.LegLeft01.yRot = 0.3142F;
					this.LegLeft02.xRot = 1.0472F;
					this.LegRight01.yRot = -0.35F;
					this.LegRight01.zRot = -0.2618F;
					this.LegRight02.xRot = 0.9F;
					//hair
					this.Hair01.xRot += 0.12F;
					this.Hair02.xRot += 0.15F;
					this.Hair03.xRot += 0.25F;
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.37F); this.animTransZ += (0F);
			    	//Body
			    	this.Head.xRot += 0.14F;
				  	this.BodyMain.xRot = -0.5236F;
				  	this.BoobL.xRot -= 0.2F;
				  	this.BoobR.xRot -= 0.2F;
				    //arm 
				  	this.ArmLeft01.xRot = -0.4363F;
				    this.ArmLeft01.zRot = 0.3142F;
					this.ArmRight01.xRot = -0.4363F;
					this.ArmRight01.zRot = -0.3142F;
					//leg
					addk1 = -1.6232F;
					addk2 = -1.5708F;
					this.LegLeft01.zRot = -0.3142F;
					this.LegLeft02.xRot = 1.34F;
					this.LegRight01.zRot = 0.35F;
					this.LegRight02.xRot = 1.13F;
					//hair
					this.Hair01.xRot += 0.09F;
					this.Hair02.xRot += 0.43F;
					this.Hair03.xRot += 0.49F;
		    	}
	    	}
	    }//end ridding
    
	    //攻擊動作    
	    if (ent.getAttackTick() > 0)
	    {
	    	if (ent.getAttackTick() > 25)
	    	{
		    	//jojo攻擊動作
		    	if (EmotionHelper.checkModelState(2, ent.getStateEmotion(ID.S.State)))
		    	{
this.animTransX += (0F); this.animTransY += (0.15F); this.animTransZ += (0F);
			    	//Body
			    	this.Head.yRot *= 0.8F;
			    	this.Head.xRot = 0.4538F;
				  	this.BodyMain.xRot = -1.0472F;
				  	this.BodyMain.zRot = -0.2094F;
				    //arm 
				  	this.ArmLeft01.xRot = -0.35F;
				    this.ArmLeft01.zRot = -0.35F;
				    this.ArmLeft02.xRot = -0.5F;
					this.ArmRight01.xRot = 1.2F;
					this.ArmRight01.zRot = 0.5236F;
					this.ArmRight02.xRot = -0.35F;
					//leg
					addk1 = 0.5236F;
					addk2 = 0.1745F;
					this.LegLeft01.zRot = 0.2618F;
					this.LegLeft02.xRot = 0.5236F;
					this.LegRight01.zRot = 0.1745F;
					this.LegRight02.xRot = 0.5236F;
					//hair
					this.Hair01.xRot += 0.09F;
					this.Hair02.xRot += 0.43F;
					this.Hair03.xRot += 0.49F;
		    	}
		    	else if (EmotionHelper.checkModelState(3, ent.getStateEmotion(ID.S.State)))
		    	{
		    		//Body
			    	this.Head.yRot *= 0.8F;
			    	this.Head.xRot = 0.2094F;
			    	this.Head.zRot = -0.2618F;
				  	this.BodyMain.xRot = -0.35F;
				  	this.BodyMain.zRot = 0.1745F;
				    //arm 
				  	this.ArmLeft01.xRot = -1.2217F;
				  	this.ArmLeft01.yRot = 0.5236F;
				    this.ArmLeft01.zRot = -0.35F;
				    this.ArmLeft02.xRot = -1.3963F;
					this.ArmRight01.xRot = 0.7854F;
					this.ArmRight01.zRot = 0.5236F;
					this.ArmRight02.xRot = -0.5236F;
					//leg
					addk1 = -0.2618F;
					addk2 = 0.3142F;
					this.LegLeft01.zRot = -0.4363F;
					this.LegLeft02.xRot = 0.2618F;
					this.LegRight01.zRot = 0.0873F;
					//hair
					this.Hair01.xRot += 0.09F;
					this.Hair02.xRot += 0.43F;
					this.Hair03.xRot += 0.49F;
		    	}
		    	else
		    	{
		    		//arm
			    	this.ArmLeft01.xRot = -1.3F;
			    	this.ArmLeft01.yRot = -0.7F;
			    	this.ArmLeft01.zRot = 0F;
		    	}
	    	}
	    	//跑道顯示
	    	setRoad(ent.getAttackTick());
	    }
	    
	    //鬢毛調整
	    headX = this.Head.xRot * -0.5F;
	    this.HairL01.xRot = angleX * 0.03F + headX - 0.26F;
	  	this.HairL02.xRot = -angleX1 * 0.04F + headX + 0.26F;
	  	this.HairR01.xRot = angleX * 0.03F + headX - 0.26F;
	  	this.HairR02.xRot = -angleX1 * 0.04F + headX + 0.26F;
	  	
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
			this.EquipRdL01.visible = true;
			this.EquipRdR01.visible = true;
			this.EquipRdL02.visible = false;
			this.EquipRdR02.visible = false;
		break;
		case 49:
		case 27:
			this.EquipRdL01.visible = true;
			this.EquipRdR01.visible = true;
			this.EquipRdL02.visible = true;
			this.EquipRdR02.visible = true;
			this.EquipRdL03.visible = false;
			this.EquipRdR03.visible = false;
		break;
		case 48:
		case 28:
			this.EquipRdL01.visible = true;
			this.EquipRdR01.visible = true;
			this.EquipRdL02.visible = true;
			this.EquipRdR02.visible = true;
			this.EquipRdL03.visible = true;
			this.EquipRdR03.visible = true;
			this.EquipRdL04.visible = false;
			this.EquipRdR04.visible = false;
		break;
		case 47:
		case 29:
			this.EquipRdL01.visible = true;
			this.EquipRdR01.visible = true;
			this.EquipRdL02.visible = true;
			this.EquipRdR02.visible = true;
			this.EquipRdL03.visible = true;
			this.EquipRdR03.visible = true;
			this.EquipRdL04.visible = true;
			this.EquipRdR04.visible = true;
			this.EquipRdL05.visible = false;
			this.EquipRdR05.visible = false;
		break;
		case 46:
		case 30:
			this.EquipRdL01.visible = true;
			this.EquipRdR01.visible = true;
			this.EquipRdL02.visible = true;
			this.EquipRdR02.visible = true;
			this.EquipRdL03.visible = true;
			this.EquipRdR03.visible = true;
			this.EquipRdL04.visible = true;
			this.EquipRdR04.visible = true;
			this.EquipRdL05.visible = true;
			this.EquipRdR05.visible = true;
			this.EquipRdL06.visible = false;
			this.EquipRdR06.visible = false;
		break;
		default:
			if (attackTime < 46 && attackTime > 30)
			{
				this.EquipRdL01.visible = true;
				this.EquipRdR01.visible = true;
				this.EquipRdL02.visible = true;
				this.EquipRdR02.visible = true;
				this.EquipRdL03.visible = true;
				this.EquipRdR03.visible = true;
				this.EquipRdL04.visible = true;
				this.EquipRdR04.visible = true;
				this.EquipRdL05.visible = true;
				this.EquipRdR05.visible = true;
				this.EquipRdL06.visible = true;
				this.EquipRdR06.visible = true;
			}		
		break;
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

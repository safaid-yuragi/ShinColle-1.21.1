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

public class ModelHarbourHime<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart ArmLeft01;
	public ModelPart Butt;
	public ModelPart ArmRight01;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart HeadH;
	public ModelPart Ahoke;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart HairL02;
	public ModelPart HairR02;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart Hair03;
	public ModelPart HeadH2;
	public ModelPart HeadH3;
	public ModelPart ArmLeft02;
	public ModelPart ArmLeft03;
	public ModelPart ArmLeft04;
	public ModelPart ArmLeft05;
	public ModelPart ArmLeft06;
	public ModelPart ArmLeft07;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart Skirt;
	public ModelPart LegRight02;
	public ModelPart ShoesR;
	public ModelPart LegLeft02;
	public ModelPart ShoesL;
	public ModelPart ArmRight02;
	public ModelPart ArmRight03;
	public ModelPart ArmRight04;
	public ModelPart ArmRight05;
	public ModelPart ArmRight06;
	public ModelPart ArmRight07;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, -0.2617993877991494F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.5F, 6.0F, 10.0F, 7.0F), PartPose.offset(0.5F, 4.0F, 0.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("ArmLeft03", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.5F, 8.0F, 5.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, 0.3490658503988659F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("ArmLeft04", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.5F, 10.0F, 6.0F, 11.0F), PartPose.offset(0.0F, 5.0F, 0.0F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("ArmLeft05", CubeListBuilder.create().addBox(-5.5F, -0.2F, -6.5F, 11.0F, 4.0F, 13.0F), PartPose.offset(0.0F, 6.0F, 0.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("ArmLeft06", CubeListBuilder.create().addBox(0.0F, 0.0F, -4.2F, 5.0F, 9.0F, 9.0F), PartPose.offsetAndRotation(-2.0F, 1.0F, 0.5F, 0.08726646259971647F, 0.13962634015954636F, 0.2617993877991494F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("ArmLeft07", CubeListBuilder.create().addBox(0.0F, 0.0F, -3.0F, 4.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, -2.0F, -0.2617993877991494F, 0.0F, 0.17453292519943295F));
		PartDefinition partdef8 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().mirror().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, -0.2617993877991494F, -0.6981317007977318F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("ArmRight02", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.5F, 6.0F, 10.0F, 7.0F), PartPose.offset(-0.5F, 4.0F, 0.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("ArmRight03", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.5F, 8.0F, 5.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, -0.3490658503988659F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("ArmRight04", CubeListBuilder.create().mirror().addBox(-5.0F, 0.0F, -5.5F, 10.0F, 6.0F, 11.0F), PartPose.offset(0.0F, 5.0F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("ArmRight05", CubeListBuilder.create().mirror().addBox(-5.5F, -0.2F, -6.5F, 11.0F, 4.0F, 13.0F), PartPose.offset(0.0F, 6.0F, 0.0F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("ArmRight06", CubeListBuilder.create().mirror().addBox(-4.0F, 0.0F, -4.2F, 5.0F, 9.0F, 9.0F), PartPose.offsetAndRotation(1.0F, 1.0F, 0.5F, 0.08726646259971647F, -0.13962634015954636F, -0.2617993877991494F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("ArmRight07", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 4.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(1.0F, 0.0F, -2.0F, -0.2617993877991494F, 0.0F, -0.17453292519943295F));
		PartDefinition partdef15 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(-3.9F, -8.1F, -4.0F, -0.8726646259971648F, 0.08726646259971647F, -0.08726646259971647F));
		PartDefinition partdef16 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 4.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-5.2F, 9.5F, -2.6F, -0.20943951023931953F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 14.0F, -3.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("ShoesR", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 14.0F, 7.0F), PartPose.offset(0.0F, 1.0F, 3.0F));
		PartDefinition partdef20 = partdef16.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(5.2F, 9.5F, -2.6F, -0.20943951023931953F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 14.0F, -3.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("ShoesL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 14.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.03647738136668149F));
		PartDefinition partdef23 = partdef16.addOrReplaceChild("Skirt", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 6.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 6.9F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(3.9F, -8.1F, -4.0F, -0.8726646259971648F, -0.08726646259971647F, 0.08726646259971647F));
		PartDefinition partdef25 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-5.5F, -2.0F, -5.0F, 11.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -10.3F, -0.2F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.2F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(7F, 3.0F, -5.5F, -0.14F, -0.1745F, -0.0873F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-0.1F, 10.0F, 0.1F, 0.1745F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef30 = partdef27.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(-7F, 3.0F, -5.5F, -0.14F, 0.1745F, 0.0873F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(0.1F, 10.0F, 0.1F, 0.1745F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef32 = partdef27.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -4.0F, -11.5F, 0.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -9.0F, -5.5F, -0.17453292519943295F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef33 = partdef26.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 10.0F), PartPose.offset(0.0F, -15.0F, -3.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 17.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("Hair03", CubeListBuilder.create().addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 12.5F, -0.1F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef37 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.3F, -0.2F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef40 = partdef39.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef41 = partdef39.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef42 = partdef39.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef43 = partdef39.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef44 = partdef39.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef45 = partdef39.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef46 = partdef39.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef47 = partdef39.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef48 = partdef39.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef49 = partdef39.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));
		PartDefinition partdef50 = partdef39.addOrReplaceChild("HeadH", CubeListBuilder.create().mirror().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -10.0F, -6.5F, -0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("HeadH2", CubeListBuilder.create().addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -0.2F, -3.7F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("HeadH3", CubeListBuilder.create().addBox(-1.0F, -1.2F, -3.0F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -3.8F, -0.13962634015954636F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelHarbourHime(ModelPart root)
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
		this.ArmRight05 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03").getChild("ArmRight04").getChild("ArmRight05");
		this.HairL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.ArmLeft04 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.ArmRight03 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.HeadH = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadH");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.HeadH3 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadH").getChild("HeadH2").getChild("HeadH3");
		this.Skirt = root.getChild("BodyMain").getChild("Butt").getChild("Skirt");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.ArmRight04 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03").getChild("ArmRight04");
		this.BodyMain = root.getChild("BodyMain");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.Hair03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02").getChild("Hair03");
		this.HairR02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.ArmLeft06 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04").getChild("ArmLeft05").getChild("ArmLeft06");
		this.ArmRight06 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03").getChild("ArmRight04").getChild("ArmRight05").getChild("ArmRight06");
		this.ShoesL = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoesL");
		this.ArmLeft03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03");
		this.ArmLeft07 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04").getChild("ArmLeft05").getChild("ArmLeft06").getChild("ArmLeft07");
		this.ArmRight07 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03").getChild("ArmRight04").getChild("ArmRight05").getChild("ArmRight06").getChild("ArmRight07");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.ShoesR = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoesR");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.HeadH2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadH").getChild("HeadH2");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.ArmLeft05 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03").getChild("ArmLeft04").getChild("ArmLeft05");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.scale = 0.53F;
		this.offsetY = 1.35F;
		this.offsetItem = new float[] {0F, 0.74F, -0.07F};
		this.offsetBlock = new float[] {0F, 0.74F, -0.07F};
		this.armMain = new ModelPart[] {this.BodyMain, this.ArmRight01, this.ArmRight02, this.ArmRight03, this.ArmRight04, this.ArmRight05, this.ArmRight06};
		this.armOff = new ModelPart[] {this.BodyMain, this.ArmLeft01, this.ArmLeft02, this.ArmLeft03, this.ArmLeft04, this.ArmLeft05, this.ArmLeft06};
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

this.animTransX += (0F); this.animTransY += (0.74F); this.animTransZ += (0F);
    	this.setFaceHungry(ent);

  	    //頭部
	  	this.Head.xRot = -0.35F;
	  	this.Head.yRot = 0F;
	  	this.Head.zRot = 0F;
	    //胸部
  	    this.BoobL.xRot = -0.76F;
  	    this.BoobR.xRot = -0.76F;
	  	//Body
  	    this.Ahoke.yRot = 0.6F;
	  	this.BodyMain.xRot = 1.4835F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 1.0472F;
	  	this.Butt.z = (0.0F) + (-0.05F) * 16F;
	  	this.Skirt.y = (6.9F) + (-0.1F) * 16F;
	  	//hair
	  	this.Hair01.xRot = 0.35F;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = 0.2F;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -0.3F;
	  	this.Hair03.zRot = 0F;
	  	this.HairL01.xRot = -0.14F;
	  	this.HairL02.xRot = 0.17F;
	  	this.HairR01.xRot = -0.14F;
	  	this.HairR02.xRot = 0.17F;
	    //arm 
	  	this.ArmLeft01.xRot = -2.967F;
	  	this.ArmLeft01.yRot = -0.6981F;
	    this.ArmLeft01.zRot = 0.08F;
	    this.ArmLeft03.xRot = 0F;
	    this.ArmLeft03.yRot = 0.35F;
	    this.ArmLeft03.zRot = 0F;
	    this.ArmLeft06.xRot = 0.0873F;
	  	this.ArmLeft06.yRot = 0.14F;
	    this.ArmLeft06.zRot = 0.26F;
	    this.ArmLeft07.xRot = -0.2618F;
	    this.ArmRight01.xRot = -2.967F;
	  	this.ArmRight01.yRot = 0.6981F;
	    this.ArmRight01.zRot = -0.08F;
	    this.ArmRight03.xRot = 0F;
	    this.ArmRight03.yRot = -0.35F;
	    this.ArmRight03.zRot = 0F;
	    this.ArmRight06.zRot = -0.26F;
	    this.ArmRight07.xRot = -0.2618F;
		//leg
	    this.LegLeft02.z = (-3.0F) + (0F) * 16F;
    	this.LegRight02.z = (-3.0F) + (0F) * 16F;
    	this.LegLeft01.xRot = -1.7F;
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.05F;
		this.LegLeft02.xRot = 0.7F;
		this.LegRight01.xRot = -1.7F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.05F;
		this.LegRight02.xRot = 0.7F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

    	//apply leg motion while riding
    	if (((Entity)ent).getVehicle() instanceof BasicEntityMount)
    	{
    		BasicEntityMount mount = (BasicEntityMount) ((Entity)ent).getVehicle();
            f1 = mount.walkAnimation.speed(f2 - (int)f2);
            f = mount.walkAnimation.position(f2 - (int)f2);

            if (f1 > 1F) f1 = 1F;
    	}
    	
  		float angleX = Mth.cos(f2 * 0.08F);
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
  		addk1 = angleAdd1 * 0.6F - 0.21F;
	  	addk2 = angleAdd2 * 0.6F - 0.21F;

  	    //移動頭部使其看人
	  	this.Head.xRot = f4 * 0.014F; 	//上下角度
	  	this.Head.yRot = f3 * 0.01F;	//左右角度 角度轉成rad 即除以57.29578
	  	this.Head.zRot = 0F;
	  	headX = this.Head.xRot * -0.5F;
	    //正常站立動作
	    //胸部
  	    this.BoobL.xRot = angleX * 0.08F - 0.76F;
  	    this.BoobR.xRot = angleX * 0.08F - 0.76F;
	  	//Body
  	    this.Ahoke.yRot = angleX * 0.15F + 0.6F;
	  	this.BodyMain.xRot = -0.1047F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.3142F;
	  	this.Butt.z = (0.0F) + (0F) * 16F;
	  	this.Skirt.y = (6.9F) + (0F) * 16F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.03F + 0.21F + headX;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -angleX1 * 0.04F - 0.08F + headX;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -angleX2 * 0.07F - 0.14F;
	  	this.Hair03.zRot = 0F;
	    //arm 
	  	this.ArmLeft01.xRot = -0.2618F;
	  	this.ArmLeft01.yRot = 0.7F;
	    this.ArmLeft01.zRot = 0F;
	    this.ArmLeft03.xRot = 0F;
	    this.ArmLeft03.yRot = 0.35F;
	    this.ArmLeft03.zRot = 0F;
	    this.ArmLeft06.xRot = 0.0873F;
	  	this.ArmLeft06.yRot = 0.14F;
	    this.ArmLeft06.zRot = angleX * 0.1F + 0.26F;
	    this.ArmLeft07.xRot = -0.2618F;
	    this.ArmRight01.xRot = -0.2618F;
	  	this.ArmRight01.yRot = -0.7F;
	    this.ArmRight01.zRot = 0F;
	    this.ArmRight03.xRot = 0F;
	    this.ArmRight03.yRot = -0.35F;
	    this.ArmRight03.zRot = 0F;
	    this.ArmRight06.zRot = -angleX * 0.1F - 0.26F;
	    this.ArmRight07.xRot = -0.2618F;
		//leg
	    this.LegLeft02.z = (-3.0F) + (0F) * 16F;
    	this.LegRight02.z = (-3.0F) + (0F) * 16F;
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.05F;
		this.LegLeft02.xRot = 0F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.05F;
		this.LegRight02.xRot = 0F;

	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {	//奔跑動作
	    	//hair
			this.Hair01.xRot += 0.09F;
			this.Hair02.xRot += 0.43F;
			this.Hair03.xRot += 0.49F;
			//胸部
	  	    this.BoobL.xRot = angleAdd2 * 0.1F - 0.83F;
	  	    this.BoobR.xRot = angleAdd1 * 0.1F - 0.83F;
	    	//arm 
		  	this.ArmLeft01.xRot = angleAdd2 * 0.8F + 0.1745F;
		  	this.ArmLeft01.yRot = 0F;
		    this.ArmLeft01.zRot = -0.35F;
		    this.ArmLeft03.yRot = 0F;
		    this.ArmRight01.xRot = angleAdd1 * 0.8F + 0.1745F;
		  	this.ArmRight01.yRot = 0F;
		    this.ArmRight01.zRot = 0.35F;
		    this.ArmRight03.yRot = 0F;
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
this.animTransX += (0F); this.animTransY += (0.1F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 0.6283F;
		  	this.BodyMain.xRot = 0.8727F;
		    //arm
		  	this.ArmLeft01.xRot = -0.61F;
		  	this.ArmLeft01.yRot = 0.35F;
		    this.ArmLeft01.zRot = -0.14F;
		  	this.ArmLeft03.yRot = 0.7F;
		  	this.ArmLeft06.zRot = -0.35F;
			this.ArmRight01.xRot = -0.61F;
			this.ArmRight01.yRot = -0.35F;
			this.ArmRight01.zRot = 0.14F;
			this.ArmRight03.yRot = -0.7F;
			this.ArmRight06.zRot = 0.35F;
			//leg
			addk1 -= 1.0F;
			addk2 -= 1.0F;
			//hair
			this.Hair01.xRot += 0.37F;
			this.Hair02.xRot += 0.23F;
			this.Hair03.xRot -= 0.1F;
  		}//end if sneaking
  		
	    if (ent.getIsSitting() && !ent.getIsRiding())
	    {	//騎乘動作  	
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
		    	setFace(2);
this.animTransX += (0F); this.animTransY += (0.57F); this.animTransZ += (0F);
		    	//body
		    	this.Head.xRot = this.Head.xRot * 0.5F + 0.55F;
			  	this.Head.yRot = this.Head.yRot * 0.5F - 0.2F;
		    	this.BodyMain.xRot = -0.61F;
			  	this.BodyMain.yRot = -0.2618F;
			  	this.BodyMain.zRot = -0.5236F;
		    	//arm
			  	this.ArmLeft01.xRot = 1.3F;
			  	this.ArmLeft01.yRot = 0.7F;
			    this.ArmLeft01.zRot = -0.1745F;
			    this.ArmLeft03.xRot = -2.53F;
			  	this.ArmLeft03.yRot = -0.7F;
			  	this.ArmLeft06.xRot = -0.5236F;
			  	this.ArmLeft06.yRot = -0.5236F;
			  	this.ArmLeft06.zRot = 0.7F;
				this.ArmRight01.xRot = 0.7F;
				this.ArmRight01.yRot = 0F;
				this.ArmRight01.zRot = 0.5236F;
				this.ArmRight03.xRot = -1.57F;
				this.ArmRight03.yRot = 0.14F;
				this.ArmRight03.zRot = 1.7453F;
				this.ArmRight06.zRot = -0.5236F;
		    	//leg
		    	addk1 = -1.05F;
		    	addk2 = -1.31F;
		    	this.LegLeft01.zRot = -0.5236F;
		    	this.LegLeft02.xRot = 1.05F;
		    	this.LegRight01.yRot = -0.4363F;
		    	this.LegRight02.xRot = 0.7F;
		    	//hair
		    	this.Hair01.xRot -= 0.12F;
		    	this.Hair01.zRot = -0.09F;
			  	this.Hair02.xRot -= 0.18F;
			  	this.Hair02.zRot = -0.26F;
			  	this.Hair03.xRot -= 0.21F;
			  	this.Hair03.zRot = -0.35F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.4F); this.animTransZ += (0F);
	    		//head
	    		this.Head.xRot -= 0.25F;
		    	//arm
			  	this.ArmLeft01.xRot = -0.44F;
			  	this.ArmLeft01.yRot = 0.44F;
			    this.ArmLeft01.zRot = 0F;
			  	this.ArmLeft03.yRot = 0.87F;
			  	this.ArmLeft06.zRot = 0.1F;
				this.ArmRight01.xRot = -0.44F;
				this.ArmRight01.yRot = -0.44F;
				this.ArmRight01.zRot = 0F;
				this.ArmRight03.yRot = -0.87F;
				this.ArmRight06.zRot = -0.1F;
		    	//leg
		    	addk1 = -1.2217F;
		    	addk2 = -1.2217F;
		    	this.LegLeft02.z = (-3.0F) + (0.37F) * 16F;
		    	this.LegRight02.z = (-3.0F) + (0.37F) * 16F;
		    	this.LegLeft01.yRot = 0.14F;
		    	this.LegRight01.yRot = -0.14F;
		    	this.LegLeft02.xRot = 2.53F;
		    	this.LegRight02.xRot = 2.53F;
	    	}
  		}//end sitting
	    
	    if (ent.getIsRiding())
	    {
	    	if (((Entity)ent).getVehicle() instanceof BasicEntityMount)
	    	{
	    		if (ent.getIsSitting())
	    		{
	    			if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    			{
		    			setFace(2);
this.animTransX += (0F); this.animTransY += (0.57F); this.animTransZ += (0F);
		    			//body
				    	this.Head.xRot = this.Head.xRot * 0.5F + 0.55F;
					  	this.Head.yRot = this.Head.yRot * 0.5F - 0.2F;
				    	this.BodyMain.xRot = -0.61F;
					  	this.BodyMain.yRot = -0.2618F;
					  	this.BodyMain.zRot = -0.5236F;
				    	//arm
					  	this.ArmLeft01.xRot = 1.3F;
					  	this.ArmLeft01.yRot = 0.7F;
					    this.ArmLeft01.zRot = -0.1745F;
					    this.ArmLeft03.xRot = -2.53F;
					  	this.ArmLeft03.yRot = -0.7F;
					  	this.ArmLeft06.xRot = -0.5236F;
					  	this.ArmLeft06.yRot = -0.5236F;
					  	this.ArmLeft06.zRot = 0.7F;
						this.ArmRight01.xRot = 0.7F;
						this.ArmRight01.yRot = 0F;
						this.ArmRight01.zRot = 0.5236F;
						this.ArmRight03.xRot = -1.57F;
						this.ArmRight03.yRot = 0.14F;
						this.ArmRight03.zRot = 1.7453F;
						this.ArmRight06.zRot = -0.5236F;
				    	//leg
				    	addk1 = -1.05F;
				    	addk2 = -1.31F;
				    	this.LegLeft01.zRot = -0.5236F;
				    	this.LegLeft02.xRot = 1.05F;
				    	this.LegRight01.yRot = -0.4363F;
				    	this.LegRight02.xRot = 0.7F;
				    	//hair
				    	this.Hair01.xRot -= 0.12F;
				    	this.Hair01.zRot = -0.09F;
					  	this.Hair02.xRot -= 0.18F;
					  	this.Hair02.zRot = -0.26F;
					  	this.Hair03.xRot -= 0.21F;
					  	this.Hair03.zRot = -0.35F;
			    	}
			    	else
			    	{
this.animTransX += (0F); this.animTransY += (0.41F); this.animTransZ += (0F);
			    		//body
				    	this.Head.xRot -= 0.35F;
				    	//hair
				    	this.Hair01.xRot += 0.35F;
					    //arm 
					  	this.ArmLeft01.xRot = 0.2F;
					  	this.ArmLeft01.yRot = 0F;
					    this.ArmLeft01.zRot = -1.1F;
					    this.ArmLeft03.yRot = 0F;
					    this.ArmLeft03.zRot = -0.4F;
						this.ArmRight01.xRot = 0.2F;
						this.ArmRight01.yRot = 0F;
						this.ArmRight01.zRot = 1.1F;
						this.ArmRight03.zRot = 0.4F;
						//leg
				    	addk1 = -1.2217F;
				    	addk2 = -1.2217F;
				    	this.LegLeft02.z = (-3.0F) + (0.37F) * 16F;
				    	this.LegRight02.z = (-3.0F) + (0.37F) * 16F;
				    	this.LegLeft01.yRot = 0.14F;
				    	this.LegRight01.yRot = -0.14F;
				    	this.LegLeft02.xRot = 2.53F;
				    	this.LegRight02.xRot = 2.53F;
			    	}
		    	}//end if sitting
		    	else
		    	{
			    	//hair
			    	this.Hair01.xRot += 0.35F;
		    		//arm 
				  	this.ArmLeft01.xRot = 0.5F;
				  	this.ArmLeft01.yRot = 0F;
				    this.ArmLeft01.zRot = -0.7F;
				    this.ArmLeft03.xRot = -0.5F;
				    this.ArmLeft03.yRot = 0F;
				    this.ArmLeft03.zRot = -0.4F;
				    this.ArmLeft06.zRot = 0.4F;
				    this.ArmLeft07.xRot = -1.2F;
					this.ArmRight01.xRot = 0.5F;
					this.ArmRight01.yRot = 0F;
					this.ArmRight01.zRot = 0.7F;
					this.ArmRight03.xRot = -0.5F;
					this.ArmRight03.yRot = 0F;
					this.ArmRight03.zRot = 0.4F;
					this.ArmRight06.zRot = -0.4F;
					this.ArmRight07.xRot = -1.2F;
		    	}
	    	}//end ship mount
	    	else
	    	{	//normal mount ex: cart
	    		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    		{
	    			setFace(2);
this.animTransX += (0F); this.animTransY += (0.37F); this.animTransZ += (0F);
			    	//body
			    	this.Head.xRot = this.Head.xRot * 0.5F + 0.55F;
				  	this.Head.yRot = this.Head.yRot * 0.5F - 0.2F;
			    	this.BodyMain.xRot = -0.61F;
				  	this.BodyMain.yRot = -0.2618F;
				  	this.BodyMain.zRot = -0.5236F;
			    	//arm
				  	this.ArmLeft01.xRot = 1.3F;
				  	this.ArmLeft01.yRot = 0.7F;
				    this.ArmLeft01.zRot = -0.1745F;
				    this.ArmLeft03.xRot = -2.53F;
				  	this.ArmLeft03.yRot = -0.7F;
				  	this.ArmLeft06.xRot = -0.5236F;
				  	this.ArmLeft06.yRot = -0.5236F;
				  	this.ArmLeft06.zRot = 0.7F;
					this.ArmRight01.xRot = 0.7F;
					this.ArmRight01.yRot = 0F;
					this.ArmRight01.zRot = 0.5236F;
					this.ArmRight03.xRot = -1.57F;
					this.ArmRight03.yRot = 0.14F;
					this.ArmRight03.zRot = 1.7453F;
					this.ArmRight06.zRot = -0.5236F;
			    	//leg
			    	addk1 = -1.05F;
			    	addk2 = -1.31F;
			    	this.LegLeft01.zRot = -0.5236F;
			    	this.LegLeft02.xRot = 1.05F;
			    	this.LegRight01.yRot = -0.4363F;
			    	this.LegRight02.xRot = 0.7F;
			    	//hair
			    	this.Hair01.xRot -= 0.12F;
			    	this.Hair01.zRot = -0.09F;
				  	this.Hair02.xRot -= 0.18F;
				  	this.Hair02.zRot = -0.26F;
				  	this.Hair03.xRot -= 0.21F;
				  	this.Hair03.zRot = -0.35F;
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.5F); this.animTransZ += (0F);
			    	//arm
				  	this.ArmLeft01.xRot = -0.44F;
				  	this.ArmLeft01.yRot = 0.44F;
				    this.ArmLeft01.zRot = 0F;
				  	this.ArmLeft03.yRot = 0.87F;
				  	this.ArmLeft06.zRot = 0.1F;
					this.ArmRight01.xRot = -0.44F;
					this.ArmRight01.yRot = -0.44F;
					this.ArmRight01.zRot = 0F;
					this.ArmRight03.yRot = -0.87F;
					this.ArmRight06.zRot = -0.1F;
			    	//leg
			    	addk1 = -1.2217F;
			    	addk2 = -1.2217F;
			    	this.LegLeft02.z = (-3.0F) + (0.37F) * 16F;
			    	this.LegRight02.z = (-3.0F) + (0.37F) * 16F;
			    	this.LegLeft01.yRot = 0.14F;
			    	this.LegRight01.yRot = -0.14F;
			    	this.LegLeft02.xRot = 2.53F;
			    	this.LegRight02.xRot = 2.53F;
		    	}
	    	}
	    }//end ridding
    
	    //攻擊動作    
	    if (ent.getAttackTick() > 0)
	    {
	    	if (ent.getAttackTick() > 25) setFace(3);
	    	//arm
	    	this.ArmLeft01.xRot = -1.4F;
	    	this.ArmLeft01.yRot = -0.14F;
	    	this.ArmLeft01.zRot = 0F;
	    	this.ArmLeft06.zRot = -0.96F;
	    	this.ArmRight01.xRot = -1.4F;
	    	this.ArmRight01.yRot = 0.14F;
	    	this.ArmRight01.zRot = 0F;
	    	this.ArmRight06.zRot = 0.96F;
	    }
	  	
	  	//swing arm
	  	float f6 = ent.getSwingTime(f2 - (int)f2);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight01.xRot += -f8 * 80.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.yRot += -f7 * 20.0F * Values.N.DIV_PI_180 + 1.0F;
	        this.ArmRight01.zRot += -f8 * 20.0F * Values.N.DIV_PI_180;
	  	}
	  	
	  	//caress
	  	if (ent.getStateEmotion(ID.S.Emotion3) == ID.Emotion3.CARESS)
	  	{
	  		//body
	  		this.Head.xRot += 0.2F;
	  	}
	  	
	  	//鬢毛調整
	    headX = this.Head.xRot * -0.5F;
		this.HairL01.xRot = angleX * 0.02F + headX - 0.14F;
	  	this.HairL02.xRot = -angleX1 * 0.04F + headX + 0.17F;
	  	this.HairR01.xRot = angleX * 0.02F + headX - 0.14F;
	  	this.HairR02.xRot = -angleX1 * 0.04F + headX + 0.17F;
	  	
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

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

public class ModelHeavyCruiserNe<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart LegLeft01;
	public ModelPart LegRight01;
	public ModelPart Neck;
	public ModelPart Head;
	public ModelPart Cloth01;
	public ModelPart TailBase;
	public ModelPart ArmLeft02;
	public ModelPart ArmRight02;
	public ModelPart LegLeft02;
	public ModelPart LegRight02;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Ear01;
	public ModelPart Ear02;
	public ModelPart Ahoke;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart Hair03;
	public ModelPart TailL01;
	public ModelPart TailR01;
	public ModelPart TailL02;
	public ModelPart TailL03;
	public ModelPart TailL04;
	public ModelPart TailL05;
	public ModelPart TailL06;
	public ModelPart TailLHead01;
	public ModelPart TailLHead02;
	public ModelPart TailLC01;
	public ModelPart TailLC02;
	public ModelPart TailLC03;
	public ModelPart TailR02;
	public ModelPart TailR03;
	public ModelPart TailR04;
	public ModelPart TailR05;
	public ModelPart TailR06;
	public ModelPart TailRHead01;
	public ModelPart TailRHead02;
	public ModelPart TailRC01;
	public ModelPart TailRC02;
	public ModelPart TailRC03;
	public ModelPart GlowBodyMain;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-5.5F, -4.5F, -12.0F, 11.0F, 10.0F, 24.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(4.0F, 3.0F, 8.3F, 0.13962634015954636F, 0.0F, 0.17453292519943295F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("LegLeft02", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0F, 5.0F, 7.0F, 5.0F), PartPose.offset(0.0F, 8.0F, -2.5F));
		PartDefinition partdef3 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-5.0F, -2.0F, -4.5F, 10.0F, 5.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -4.0F, -9.4F, 0.41887902047863906F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(4.0F, 3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.20943951023931953F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().addBox(-5F, 0.0F, -5F, 5.0F, 7.0F, 5.0F), PartPose.offset(2.5F, 8.0F, 2.5F));
		PartDefinition partdef6 = partdef0.addOrReplaceChild("TailBase", CubeListBuilder.create().addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -0.5F, 9.0F, 0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("TailL01", CubeListBuilder.create().addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 7.0F), PartPose.offsetAndRotation(1.5F, 0.0F, 6.0F, 0.2617993877991494F, 0.41887902047863906F, 0.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("TailL02", CubeListBuilder.create().addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.2617993877991494F, 0.3141592653589793F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("TailL03", CubeListBuilder.create().addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.2617993877991494F, 0.24434609527920614F, 0.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("TailL04", CubeListBuilder.create().addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.2617993877991494F, 0.20943951023931953F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("TailL05", CubeListBuilder.create().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.2617993877991494F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("TailL06", CubeListBuilder.create().addBox(-4.5F, -3.5F, 0.0F, 9.0F, 7.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.2617993877991494F, 0.06981317007977318F, 0.0F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("TailLHead01", CubeListBuilder.create().addBox(-5.5F, -2.0F, 0.0F, 11.0F, 6.0F, 15.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -2.5F, -0.12217304763960307F, 0.0F, 0.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("TailLC01", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 2.2F, 13.5F, -0.18203784098300857F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef13.addOrReplaceChild("TailLC02", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(-3.0F, 2.0F, 13.5F, -0.091106186954104F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef16 = partdef13.addOrReplaceChild("TailLC03", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(3.0F, 2.0F, 13.5F, -0.136659280431156F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef17 = partdef12.addOrReplaceChild("TailLHead02", CubeListBuilder.create().addBox(-5.0F, -4.0F, 0.0F, 10.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 1.5F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef6.addOrReplaceChild("TailR01", CubeListBuilder.create().mirror().addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 7.0F), PartPose.offsetAndRotation(-1.5F, 0.0F, 6.0F, 0.2617993877991494F, -0.06981317007977318F, 0.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("TailR02", CubeListBuilder.create().mirror().addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("TailR03", CubeListBuilder.create().mirror().addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.3141592653589793F, 0.06981317007977318F, 0.0F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("TailR04", CubeListBuilder.create().mirror().addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.41887902047863906F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("TailR05", CubeListBuilder.create().mirror().addBox(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.5235987755982988F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("TailR06", CubeListBuilder.create().mirror().addBox(-4.5F, -3.5F, 0.0F, 9.0F, 7.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 5.5F, 0.2617993877991494F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("TailRHead01", CubeListBuilder.create().mirror().addBox(-5.5F, -2.0F, 0.0F, 11.0F, 6.0F, 15.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -2.5F, -0.12217304763960307F, 0.0F, 0.0F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("TailRC02", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(-3.0F, 2.0F, 13.5F, -0.091106186954104F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef26 = partdef24.addOrReplaceChild("TailRC01", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 2.2F, 13.5F, -0.18203784098300857F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef24.addOrReplaceChild("TailRC03", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(3.0F, 2.0F, 13.5F, -0.136659280431156F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef28 = partdef23.addOrReplaceChild("TailRHead02", CubeListBuilder.create().mirror().addBox(-5.0F, -4.0F, 0.0F, 10.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 1.5F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef29 = partdef0.addOrReplaceChild("LegRight01", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(-4.0F, 3.0F, 8.3F, -0.13962634015954636F, 0.0F, -0.17453292519943295F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("LegRight02", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, 0F, 5.0F, 7.0F, 5.0F), PartPose.offset(0.0F, 8.0F, -2.5F));
		PartDefinition partdef31 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(-4.0F, 3.0F, -6.0F, 0.13962634015954636F, 0.0F, -0.20943951023931953F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("ArmRight02", CubeListBuilder.create().mirror().addBox(0F, 0.0F, -5F, 5.0F, 7.0F, 5.0F), PartPose.offset(-2.5F, 8.0F, 2.5F));
		PartDefinition partdef33 = partdef0.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -11.0F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -6.0F, -13.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.2F, 16.0F, 17.0F, 8.0F), PartPose.offset(0.0F, -4.0F, 0.0F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -4.0F, -11.5F, 0.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -8.5F, -5.0F, 0.0F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef36 = partdef33.addOrReplaceChild("Ear02", CubeListBuilder.create().mirror().addBox(-2.0F, 0.0F, -7.0F, 4.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(-4.2F, -11.0F, 6.8F, -0.8378F, 0.1222F, -0.1745F));
		PartDefinition partdef37 = partdef33.addOrReplaceChild("Ear01", CubeListBuilder.create().addBox(-2.0F, 0.0F, -7.0F, 4.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(4.2F, -11.0F, 6.8F, -0.8378F, -0.1222F, 0.1745F));
		PartDefinition partdef38 = partdef33.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 12.0F, 10.0F), PartPose.offset(0.0F, -11.5F, -3.0F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-2.0F, 0.0F, -3.5F, 3.0F, 10.0F, 7.0F), PartPose.offsetAndRotation(-6.3F, 4.7F, 2.0F, 0.20943951023931953F, 0.0F, 0.17453292519943295F));
		PartDefinition partdef40 = partdef39.addOrReplaceChild("Hair03", CubeListBuilder.create().addBox(-2.0F, 0.0F, -3.0F, 3.0F, 12.0F, 6.0F), PartPose.offsetAndRotation(0.2F, 7.5F, -0.3F, -0.2617993877991494F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef41 = partdef38.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 7.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.6F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef42 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 9.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.0F, -13.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef43 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, -13.0F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -8.5F, -6.1F));
		PartDefinition partdef46 = partdef44.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -8.5F, -6.1F));
		PartDefinition partdef47 = partdef44.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -8.5F, -6.1F));
		PartDefinition partdef48 = partdef44.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -8.5F, -6.1F));
		PartDefinition partdef49 = partdef44.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -8.5F, -6.1F));
		PartDefinition partdef50 = partdef44.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -0.7F, -6.2F));
		PartDefinition partdef51 = partdef44.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -0.7F, -6.2F));
		PartDefinition partdef52 = partdef44.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -0.7F, -6.2F));
		PartDefinition partdef53 = partdef44.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6F, 0.7F, -6.8F));
		PartDefinition partdef54 = partdef44.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6F, 0.7F, -6.8F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelHeavyCruiserNe(ModelPart root)
	{
		this.TailRC02 = root.getChild("BodyMain").getChild("TailBase").getChild("TailR01").getChild("TailR02").getChild("TailR03").getChild("TailR04").getChild("TailR05").getChild("TailR06").getChild("TailRHead01").getChild("TailRC02");
		this.Hair = root.getChild("BodyMain").getChild("Head").getChild("Hair");
		this.TailLC01 = root.getChild("BodyMain").getChild("TailBase").getChild("TailL01").getChild("TailL02").getChild("TailL03").getChild("TailL04").getChild("TailL05").getChild("TailL06").getChild("TailLHead01").getChild("TailLC01");
		this.Hair02 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair02");
		this.TailRC01 = root.getChild("BodyMain").getChild("TailBase").getChild("TailR01").getChild("TailR02").getChild("TailR03").getChild("TailR04").getChild("TailR05").getChild("TailR06").getChild("TailRHead01").getChild("TailRC01");
		this.LegLeft01 = root.getChild("BodyMain").getChild("LegLeft01");
		this.LegLeft02 = root.getChild("BodyMain").getChild("LegLeft01").getChild("LegLeft02");
		this.Ahoke = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.BodyMain = root.getChild("BodyMain");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.TailBase = root.getChild("BodyMain").getChild("TailBase");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.Ear02 = root.getChild("BodyMain").getChild("Head").getChild("Ear02");
		this.TailRC03 = root.getChild("BodyMain").getChild("TailBase").getChild("TailR01").getChild("TailR02").getChild("TailR03").getChild("TailR04").getChild("TailR05").getChild("TailR06").getChild("TailRHead01").getChild("TailRC03");
		this.Hair03 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair02").getChild("Hair03");
		this.LegRight01 = root.getChild("BodyMain").getChild("LegRight01");
		this.Ear01 = root.getChild("BodyMain").getChild("Head").getChild("Ear01");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.TailL04 = root.getChild("BodyMain").getChild("TailBase").getChild("TailL01").getChild("TailL02").getChild("TailL03").getChild("TailL04");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.TailRHead01 = root.getChild("BodyMain").getChild("TailBase").getChild("TailR01").getChild("TailR02").getChild("TailR03").getChild("TailR04").getChild("TailR05").getChild("TailR06").getChild("TailRHead01");
		this.TailL05 = root.getChild("BodyMain").getChild("TailBase").getChild("TailL01").getChild("TailL02").getChild("TailL03").getChild("TailL04").getChild("TailL05");
		this.TailL06 = root.getChild("BodyMain").getChild("TailBase").getChild("TailL01").getChild("TailL02").getChild("TailL03").getChild("TailL04").getChild("TailL05").getChild("TailL06");
		this.TailL03 = root.getChild("BodyMain").getChild("TailBase").getChild("TailL01").getChild("TailL02").getChild("TailL03");
		this.TailLC02 = root.getChild("BodyMain").getChild("TailBase").getChild("TailL01").getChild("TailL02").getChild("TailL03").getChild("TailL04").getChild("TailL05").getChild("TailL06").getChild("TailLHead01").getChild("TailLC02");
		this.TailR04 = root.getChild("BodyMain").getChild("TailBase").getChild("TailR01").getChild("TailR02").getChild("TailR03").getChild("TailR04");
		this.LegRight02 = root.getChild("BodyMain").getChild("LegRight01").getChild("LegRight02");
		this.Hair01 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.TailLHead01 = root.getChild("BodyMain").getChild("TailBase").getChild("TailL01").getChild("TailL02").getChild("TailL03").getChild("TailL04").getChild("TailL05").getChild("TailL06").getChild("TailLHead01");
		this.TailR06 = root.getChild("BodyMain").getChild("TailBase").getChild("TailR01").getChild("TailR02").getChild("TailR03").getChild("TailR04").getChild("TailR05").getChild("TailR06");
		this.TailL01 = root.getChild("BodyMain").getChild("TailBase").getChild("TailL01");
		this.TailLHead02 = root.getChild("BodyMain").getChild("TailBase").getChild("TailL01").getChild("TailL02").getChild("TailL03").getChild("TailL04").getChild("TailL05").getChild("TailL06").getChild("TailLHead02");
		this.TailR03 = root.getChild("BodyMain").getChild("TailBase").getChild("TailR01").getChild("TailR02").getChild("TailR03");
		this.Head = root.getChild("BodyMain").getChild("Head");
		this.TailRHead02 = root.getChild("BodyMain").getChild("TailBase").getChild("TailR01").getChild("TailR02").getChild("TailR03").getChild("TailR04").getChild("TailR05").getChild("TailR06").getChild("TailRHead02");
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.HairMain = root.getChild("BodyMain").getChild("Head").getChild("HairMain");
		this.TailR01 = root.getChild("BodyMain").getChild("TailBase").getChild("TailR01");
		this.TailR02 = root.getChild("BodyMain").getChild("TailBase").getChild("TailR01").getChild("TailR02");
		this.TailL02 = root.getChild("BodyMain").getChild("TailBase").getChild("TailL01").getChild("TailL02");
		this.TailLC03 = root.getChild("BodyMain").getChild("TailBase").getChild("TailL01").getChild("TailL02").getChild("TailL03").getChild("TailL04").getChild("TailL05").getChild("TailL06").getChild("TailLHead01").getChild("TailLC03");
		this.TailR05 = root.getChild("BodyMain").getChild("TailBase").getChild("TailR01").getChild("TailR02").getChild("TailR03").getChild("TailR04").getChild("TailR05");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowHead");
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
		this.scale = 0.4F;
		this.offsetY = 2.63F;
		this.offsetItem = new float[] {0.07F, 0.99F, -0.09F};
		this.offsetBlock = new float[] {0.07F, 0.99F, -0.09F};
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

this.animTransX += (0F); this.animTransY += (0.2F); this.animTransZ += (0F);
    	this.setFaceHungry(ent);

  	    //頭部
	  	this.Head.xRot = 0.7853F;
	  	this.Head.yRot = 0F;
	  	//Body
  	    this.Ahoke.yRot = 0.45F;
	  	this.BodyMain.xRot = 0F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = -1.4835F;
	  	this.Head.y = (-6.0F) + (0F) * 16F;
	  	this.GlowHead.y = (-6.0F) + (0F) * 16F;
	  	//hair
	  	this.Hair02.xRot = 0.21F;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -0.2618F;
	  	this.Hair03.zRot = 0F;
	  	//arm
	  	this.ArmLeft01.xRot = 0.1745F;
	  	this.ArmLeft01.zRot = 0.4537F;
	  	this.ArmLeft01.z = (-6.0F) + (0F) * 16F;
	  	this.ArmLeft02.zRot = 0F;
	  	this.ArmRight01.xRot = -0.1745F;
	  	this.ArmRight01.zRot = -0.05F;
	  	this.ArmRight01.z = (-6.0F) + (0F) * 16F;
	  	this.ArmRight02.zRot = 0F;
		//leg
	  	this.LegLeft01.xRot = -0.1745F;
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.4537F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegRight01.xRot = 0.1745F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.05F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.zRot = 0F;
	  	//tail
		this.TailBase.xRot = 0.8F;
	  	this.TailL01.xRot = 0.2618F;
		this.TailL01.yRot = -0.2F;
		this.TailL01.zRot = this.TailL01.yRot * 0.25F;
		this.TailL02.xRot = 0.2618F;
		this.TailL02.yRot = -0.3F;
		this.TailL02.zRot = this.TailL02.yRot * 0.25F;
		this.TailL03.xRot = 0.2618F;
		this.TailL03.yRot = -0.2F;
		this.TailL03.zRot = this.TailL03.yRot * 0.25F;
		this.TailL04.xRot = 0.35F;
		this.TailL04.yRot = 0.2F;
		this.TailL04.zRot = this.TailL04.yRot * 0.25F;
		this.TailL05.xRot = 0.4F;
		this.TailL05.yRot = 0.2F;
		this.TailL05.zRot = this.TailL05.yRot * 0.25F;
		this.TailL06.xRot = 0.45F;
		this.TailL06.yRot = 0.1F;
		this.TailL06.zRot = this.TailL06.yRot * 0.25F;
		this.TailR01.xRot = 0.6F;
		this.TailR01.yRot = 0.2617F;
		this.TailR01.zRot = this.TailR01.yRot * 0.25F;
		this.TailR02.xRot = 0.6F;
		this.TailR02.yRot = -0.2F;
		this.TailR02.zRot = this.TailR02.yRot * 0.25F;
		this.TailR03.xRot = 0.5F;
		this.TailR03.yRot = -0.1F;
		this.TailR03.zRot = this.TailR03.yRot * 0.25F;
		this.TailR04.xRot = 0.3F;
		this.TailR04.yRot = -0.1F;
		this.TailR04.zRot = this.TailR04.yRot * 0.25F;
		this.TailR05.xRot = 0.1F;
		this.TailR05.yRot = 0.1F;
		this.TailR05.zRot = this.TailR05.yRot * 0.25F;
		this.TailR06.xRot = -0.1F;
		this.TailR06.yRot = 0.1F;
		this.TailR06.zRot = this.TailR06.yRot * 0.25F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F + f * 0.25F);
  		float angleX1 = Mth.cos(f2*0.08F + 0.3F + f * 0.5F);
  		float angleX2 = Mth.cos(f2*0.08F + 0.6F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
  		float addk1 = 0;
  		float addk2 = 0;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
    	//leg move
  		addk1 = angleAdd1 * 0.5F - 0.14F;  //LegLeft01
	  	addk2 = angleAdd2 * 0.5F + 0.14F;  //LegRight01
	  	this.ArmRight01.xRot = addk1;
    	this.ArmLeft01.xRot = addk2;

  	    //head
	  	this.Head.xRot = f4 * 0.014F; 	//上下角度
	  	this.Head.yRot = f3 * 0.01F;	//左右角度 角度轉成rad 即除以57.29578
	  	//body
  	    this.Ahoke.yRot = angleX * 0.25F + 0.45F;
	  	this.BodyMain.xRot = 0F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Head.y = (-6.0F) + (0F) * 16F;
	  	this.GlowHead.y = (-6.0F) + (0F) * 16F;
	  	//hair
	  	this.Hair02.xRot = angleX1 * 0.04F + 0.21F;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = angleX2 * 0.07F - 0.2618F;
	  	this.Hair03.zRot = 0F;
	  	//arm
	  	this.ArmLeft01.zRot = 0.21F;
	  	this.ArmLeft01.z = (-6.0F) + (0F) * 16F;
	  	this.ArmLeft02.zRot = 0F;
	  	this.ArmRight01.zRot = -0.21F;
	  	this.ArmRight01.z = (-6.0F) + (0F) * 16F;
	  	this.ArmRight02.zRot = 0F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.1745F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.1745F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.zRot = 0F;
	  	//tail
		this.TailBase.xRot = 0.8F;
	  	this.TailL01.xRot = 0.2618F;
		this.TailL01.yRot = Mth.cos(-f2 * 0.1F + 0.7F) * 0.2F + 0.5F;
		this.TailL01.zRot = this.TailL01.yRot * 0.25F;
		this.TailL02.xRot = 0.2618F;
		this.TailL02.yRot = Mth.cos(-f2 * 0.1F + 1.4F) * 0.25F;
		this.TailL02.zRot = this.TailL02.yRot * 0.25F;
		this.TailL03.xRot = 0.2618F;
		this.TailL03.yRot = Mth.cos(-f2 * 0.1F + 2.1F) * 0.3F;
		this.TailL03.zRot = this.TailL03.yRot * 0.25F;
		this.TailL04.xRot = 0.35F;
		this.TailL04.yRot = Mth.cos(-f2 * 0.1F + 2.8F) * 0.35F;
		this.TailL04.zRot = this.TailL04.yRot * 0.25F;
		this.TailL05.xRot = 0.4F;
		this.TailL05.yRot = Mth.cos(-f2 * 0.1F + 3.5F) * 0.4F;
		this.TailL05.zRot = this.TailL05.yRot * 0.25F;
		this.TailL06.xRot = 0.45F;
		this.TailL06.yRot = Mth.cos(-f2 * 0.1F + 4.2F) * 0.35F;
		this.TailL06.zRot = this.TailL06.yRot * 0.25F;
		this.TailR01.xRot = 0.2618F;
		this.TailR01.yRot = Mth.cos(-f2 * 0.1F + 0.7F) * 0.2F - 0.5F;
		this.TailR01.zRot = this.TailR01.yRot * 0.25F;
		this.TailR02.xRot = 0.2618F;
		this.TailR02.yRot = Mth.cos(-f2 * 0.1F + 1.4F) * 0.25F;
		this.TailR02.zRot = this.TailR02.yRot * 0.25F;
		this.TailR03.xRot = 0.2618F;
		this.TailR03.yRot = Mth.cos(-f2 * 0.1F + 2.1F) * 0.3F;
		this.TailR03.zRot = this.TailR03.yRot * 0.25F;
		this.TailR04.xRot = 0.35F;
		this.TailR04.yRot = Mth.cos(-f2 * 0.1F + 2.8F) * 0.35F;
		this.TailR04.zRot = this.TailR04.yRot * 0.25F;
		this.TailR05.xRot = 0.4F;
		this.TailR05.yRot = Mth.cos(-f2 * 0.1F + 3.5F) * 0.4F;
		this.TailR05.zRot = this.TailR05.yRot * 0.25F;
		this.TailR06.xRot = 0.45F;
		this.TailR06.yRot = Mth.cos(-f2 * 0.1F + 4.2F) * 0.45F;
		this.TailR06.zRot = this.TailR06.yRot * 0.25F;
		
		//ear
		float modf2 = f2 % 128F;
		if (modf2 < 6F)
		{
			//total 10 ticks, loop twice in 20 ticks
			if(modf2 >= 3F) modf2 -= 3F;
			float anglef2 = Mth.sin(modf2 * 1.0472F) * 0.25F;
			this.Ear01.zRot = anglef2 + 0.1745F;
			this.Ear02.zRot = -anglef2 - 0.1745F;
		}
		else
		{
			this.Ear01.zRot = 0.1745F;
			this.Ear02.zRot = -0.1745F;
		}

	    if (ent.getIsSprinting() || f1 > 0.8F)
	    {	//奔跑動作
	    	//leg
	    	addk1 *= 2F;
	    	addk2 *= 2F;
	    	this.ArmRight01.xRot = addk1;
	    	this.ArmLeft01.xRot = addk2;
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {		//潛行, 蹲下動作
	    	//head
	    	this.Head.y = (-6.0F) + (0.2F) * 16F;
	    	this.GlowHead.y = (-6.0F) + (0.2F) * 16F;
  		}//end if sneaking
  		
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {
	    	//騎乘動作
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
this.animTransX += (0F); this.animTransY += (0.22F); this.animTransZ += (0F);
		    	//head
		    	this.Head.xRot = 1.5359F;
		    	this.Head.y = (-6.0F) + (0.25F) * 16F;
		    	this.GlowHead.xRot = 1.5359F;
		    	this.GlowHead.y = (-6.0F) + (0.25F) * 16F;
		    	//arm
		    	addk1 = 1.5359F;
		    	addk2 = 1.5359F;
		    	this.ArmLeft01.xRot = -1.5359F;
		    	this.ArmLeft01.zRot = 0F;
		    	this.ArmLeft01.z = (-6.0F) + (-0.18F) * 16F;
		    	this.ArmRight01.xRot = -1.5359F;
		    	this.ArmRight01.zRot = 0F;
		    	this.ArmRight01.z = (-6.0F) + (-0.18F) * 16F;
		    	//tail
		    	this.TailBase.xRot = 0.0873F;
			  	this.TailL01.xRot = 0.02618F;
			  	this.TailL01.yRot *= 0.5F;
				this.TailL02.xRot = -0.02618F;
				this.TailL02.yRot *= 0.5F;
				this.TailL03.xRot = -0.02618F;
				this.TailL03.yRot *= 0.5F;
				this.TailL04.xRot = -0.035F;
				this.TailL04.yRot *= 0.5F;
				this.TailL05.xRot = -0.04F;
				this.TailL05.yRot *= 0.5F;
				this.TailL06.xRot = -0.045F;
				this.TailL06.yRot *= 0.5F;
				this.TailR01.xRot = -0.02618F;
				this.TailR01.yRot *= 0.5F;
				this.TailR02.xRot = -0.02618F;
				this.TailR02.yRot *= 0.5F;
				this.TailR03.xRot = -0.02618F;
				this.TailR03.yRot *= 0.5F;
				this.TailR04.xRot = -0.035F;
				this.TailR04.yRot *= 0.5F;
				this.TailR05.xRot = -0.04F;
				this.TailR05.yRot *= 0.5F;
				this.TailR06.xRot = -0.045F;
				this.TailR06.yRot *= 0.5F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.22F); this.animTransZ += (0F);
		    	//head
		    	this.Head.xRot -= 0.5F;
		    	this.GlowHead.xRot -= 0.5F;
		    	this.Head.y = (-6.0F) + (0.25F) * 16F;
		    	this.GlowHead.y = (-6.0F) + (0.25F) * 16F;
		    	//arm
		    	addk1 = 1.5359F;
		    	addk2 = 1.5359F;
		    	this.ArmLeft01.xRot = -1.5359F;
		    	this.ArmLeft01.zRot = 0F;
		    	this.ArmLeft01.z = (-6.0F) + (-0.18F) * 16F;
		    	this.ArmLeft02.zRot = 1.1868F;
		    	this.ArmRight01.xRot = -1.5359F;
		    	this.ArmRight01.zRot = 0F;
		    	this.ArmRight01.z = (-6.0F) + (-0.18F) * 16F;
		    	this.ArmRight02.zRot = -1.1868F;
	    	}
  		}//end if sitting
	    
	    //攻擊動作    
	    if (ent.getAttackTick() > 20)
	    {
	    	//tail
		  	this.TailL01.xRot = 0.2618F;
		  	this.TailL01.yRot = 0.2618F;
		  	this.TailL01.zRot = 0F;
		  	this.TailL02.xRot = 0.35F;
		  	this.TailL02.yRot = 0.1748F;
		  	this.TailL02.zRot = 0F;
		  	this.TailL03.xRot = 0.4363F;
		  	this.TailL03.yRot = 0.14F;
		  	this.TailL03.zRot = 0F;
		  	this.TailL04.xRot = 0.5236F;
		  	this.TailL04.yRot = 0.14F;
		  	this.TailL04.zRot = 0F;
		  	this.TailL05.xRot = 0.6109F;
		  	this.TailL05.yRot = 0.1745F;
		  	this.TailL05.zRot = 0F;
		  	this.TailL06.xRot = 0.35F;
		  	this.TailL06.yRot = 0F;
		  	this.TailL06.zRot = 0F;
		  	this.TailR01.xRot = 0.2618F;
		  	this.TailR01.yRot = -0.2618F;
		  	this.TailR01.zRot = 0F;
		  	this.TailR02.xRot = 0.35F;
		  	this.TailR02.yRot = -0.1748F;
		  	this.TailR02.zRot = 0F;
		  	this.TailR03.xRot = 0.35F;
		  	this.TailR03.yRot = -0.14F;
		  	this.TailR03.zRot = 0F;
		  	this.TailR04.xRot = 0.4363F;
		  	this.TailR04.yRot = -0.14F;
		  	this.TailR04.zRot = 0F;
		  	this.TailR05.xRot = 0.4363F;
		  	this.TailR05.yRot = -0.14F;
		  	this.TailR05.zRot = 0F;
		  	this.TailR06.xRot = 0.35F;
		  	this.TailR06.yRot = 0F;
		  	this.TailR06.zRot = 0F;
	    }
	    
	    //swing arm
	  	float f6 = ent.getSwingTime(f2 - (int)f2);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight01.xRot = -0.6F - f8 * 80.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.yRot = 0F - f7 * 20.0F * Values.N.DIV_PI_180 + 0.2F;
	        this.ArmRight01.zRot = 0.2F - -f8 * 20.0F * Values.N.DIV_PI_180;
	  	}
	    
	    //鬢毛調整
	    float headZ = this.Head.zRot * -0.5F;
	    float headX = this.Head.xRot * -0.5F - 0.05F;
	  	this.Hair02.xRot += headX * 0.5F;
	  	this.Hair03.xRot += headX * 0.2F;
	  	this.Hair02.zRot += headZ * 0.8F;
	  	this.Hair03.zRot += headZ * 0.4F;
	    
	    //leg motion
	    this.LegLeft01.xRot = addk1;
	    this.LegRight01.xRot = addk2;
	
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

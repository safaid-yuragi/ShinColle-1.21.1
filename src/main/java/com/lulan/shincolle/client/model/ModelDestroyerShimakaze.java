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

public class ModelDestroyerShimakaze<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart NeckCloth;
	public ModelPart ArmLeft;
	public ModelPart ArmRight;
	public ModelPart Butt;
	public ModelPart EquipBase;
	public ModelPart Head;
	public ModelPart NeckTie;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Ahoke;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart HairL02;
	public ModelPart HairAnchor;
	public ModelPart HairR02;
	public ModelPart HairMidL01;
	public ModelPart HairMidR01;
	public ModelPart EarBase;
	public ModelPart HairMidL02;
	public ModelPart HairMidR02;
	public ModelPart EarL01;
	public ModelPart EarL02;
	public ModelPart EarR01;
	public ModelPart EarR02;
	public ModelPart LegRight;
	public ModelPart LegLeft;
	public ModelPart Skirt;
	public ModelPart ShoesR;
	public ModelPart ShoesL;
	public ModelPart EquipHead;
	public ModelPart EquipT01;
	public ModelPart EquipT02;
	public ModelPart EquipT03;
	public ModelPart EquipT04;
	public ModelPart EquipT05;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeckCloth;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-7.0F, -11.0F, -4.0F, 14.0F, 17.0F, 7.0F), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("NeckCloth", CubeListBuilder.create().addBox(-7.5F, -1.5F, -4.5F, 15.0F, 12.0F, 8.0F), PartPose.offset(0.0F, -10.0F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 10.0F), PartPose.offset(0.0F, -15.0F, -3.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("HairMidR01", CubeListBuilder.create().mirror().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 13.0F, 8.0F), PartPose.offsetAndRotation(-2.5F, 9.0F, 2.5F, 0.13962634015954636F, -0.08726646259971647F, 0.2617993877991494F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("HairMidR02", CubeListBuilder.create().mirror().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 14.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 3.0F, 0.13962634015954636F, 0.0F, 0.13962634015954636F));
		PartDefinition partdef6 = partdef3.addOrReplaceChild("HairMidL01", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 13.0F, 8.0F), PartPose.offsetAndRotation(2.5F, 9.0F, 2.5F, 0.13962634015954636F, 0.08726646259971647F, -0.2617993877991494F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("HairMidL02", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 14.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 3.0F, 0.13962634015954636F, 0.0F, -0.13962634015954636F));
		PartDefinition partdef8 = partdef3.addOrReplaceChild("EarBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 3.0F, 4.0F), PartPose.offset(-2.0F, -2.0F, 2.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("EarL01", CubeListBuilder.create().addBox(-1.5F, -10.0F, -1.0F, 3.0F, 10.0F, 2.0F), PartPose.offset(4.0F, 2.5F, 2.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("EarL02", CubeListBuilder.create().addBox(-2.0F, -13.0F, -1.0F, 4.0F, 13.0F, 2.0F), PartPose.offset(0.0F, -9.0F, 0.0F));
		PartDefinition partdef11 = partdef8.addOrReplaceChild("EarR01", CubeListBuilder.create().addBox(-1.5F, -10.0F, -1.0F, 3.0F, 10.0F, 2.0F), PartPose.offset(0.0F, 2.5F, 2.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("EarR02", CubeListBuilder.create().addBox(-2.0F, -13.0F, -1.0F, 4.0F, 13.0F, 2.0F), PartPose.offset(0.0F, -9.0F, 0.0F));
		PartDefinition partdef13 = partdef2.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -7.5F, -8.0F, 16.0F, 12.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("HairR01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(-5.5F, 0.0F, -3.0F, -0.2617993877991494F, 0.17453292519943295F, 0.2617993877991494F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("HairR02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(0.2F, 8.5F, 0.5F, 0.17453292519943295F, 0.0F, -0.17453292519943295F));
		PartDefinition partdef16 = partdef13.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, 0.0F, -12.0F, 0.0F, 13.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -14.0F, -4.0F, 0.0F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef17 = partdef13.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(5.5F, 0.0F, -3.0F, -0.2617993877991494F, -0.17453292519943295F, -0.2617993877991494F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-0.2F, 8.5F, 0.5F, 0.2617993877991494F, 0.0F, 0.17453292519943295F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("HairAnchor", CubeListBuilder.create().addBox(-1.5F, 0.0F, 0.0F, 2.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(0.2F, 8.0F, -1.0F, 0.08726646259971647F, 0.0F, 0.136659280431156F));
		PartDefinition partdef20 = partdef1.addOrReplaceChild("NeckTie", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 2.5F, -4.7F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef21 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-8.0F, 4.0F, -5.4F, 16.0F, 8.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("LegRight", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 19.0F, 6.0F), PartPose.offsetAndRotation(-4.5F, 9.5F, -3.0F, -0.2617993877991494F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("ShoesR", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 19.0F, -0.2F));
		PartDefinition partdef24 = partdef21.addOrReplaceChild("LegLeft", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 19.0F, 6.0F), PartPose.offsetAndRotation(4.5F, 9.5F, -3.0F, -0.2617993877991494F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("ShoesL", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 19.0F, -0.2F));
		PartDefinition partdef26 = partdef21.addOrReplaceChild("Skirt", CubeListBuilder.create().addBox(-8.5F, 0.0F, -6.0F, 17.0F, 6.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef0.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(-7.0F, 0.0F, -3.7F, 14.0F, 8.0F, 12.0F), PartPose.offsetAndRotation(2.0F, -5.0F, 7.0F, 0.13962634015954636F, 0.0F, 0.5235987755982988F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("EquipT05", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 3.0F, 31.0F, 3.0F), PartPose.offset(-8.1F, -8.0F, 1.0F));
		PartDefinition partdef29 = partdef27.addOrReplaceChild("EquipT01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 3.0F, 31.0F, 3.0F), PartPose.offset(5.1F, -8.0F, 1.0F));
		PartDefinition partdef30 = partdef27.addOrReplaceChild("EquipT04", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 3.0F, 31.0F, 3.0F), PartPose.offset(-4.8F, -8.0F, 1.0F));
		PartDefinition partdef31 = partdef27.addOrReplaceChild("EquipT03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 3.0F, 31.0F, 3.0F), PartPose.offset(-1.5F, -8.0F, 1.0F));
		PartDefinition partdef32 = partdef27.addOrReplaceChild("EquipHead", CubeListBuilder.create().addBox(-9.0F, 0.0F, 0.0F, 18.0F, 17.0F, 7.0F), PartPose.offset(0.0F, -3.0F, -0.3F));
		PartDefinition partdef33 = partdef27.addOrReplaceChild("EquipT02", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 3.0F, 31.0F, 3.0F), PartPose.offset(1.8F, -8.0F, 1.0F));
		PartDefinition partdef34 = partdef0.addOrReplaceChild("ArmRight", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 22.0F, 5.0F), PartPose.offsetAndRotation(-7.0F, -10.5F, 0.0F, 0.0F, 0.0F, 0.4363323129985824F));
		PartDefinition partdef35 = partdef0.addOrReplaceChild("ArmLeft", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 22.0F, 5.0F), PartPose.offsetAndRotation(7.0F, -10.5F, 0.0F, 0.0F, 0.0F, -0.3490658503988659F));
		PartDefinition partdef36 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition partdef37 = partdef36.addOrReplaceChild("GlowNeckCloth", CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, 0.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef40 = partdef38.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef41 = partdef38.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef42 = partdef38.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef43 = partdef38.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef44 = partdef38.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef45 = partdef38.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef46 = partdef38.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef47 = partdef38.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef48 = partdef38.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelDestroyerShimakaze(ModelPart root)
	{
		this.Face0 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Face0");
		this.Face1 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Face1");
		this.Face2 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Face2");
		this.Face3 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Face3");
		this.Face4 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Face4");
		this.Mouth0 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Mouth0");
		this.Mouth1 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Mouth1");
		this.Mouth2 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Mouth2");
		this.Flush0 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Flush0");
		this.Flush1 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Flush1");
		this.Head = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head");
		this.HairMain = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("HairMain");
		this.Hair = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("Hair");
		this.HairMidR01 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("HairMain").getChild("HairMidR01");
		this.HairMidL02 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("HairMain").getChild("HairMidL01").getChild("HairMidL02");
		this.HairMidL01 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("HairMain").getChild("HairMidL01");
		this.HairMidR02 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("HairMain").getChild("HairMidR01").getChild("HairMidR02");
		this.Skirt = root.getChild("BodyMain").getChild("Butt").getChild("Skirt");
		this.HairL02 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.EarBase = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("HairMain").getChild("EarBase");
		this.EquipT05 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipT05");
		this.HairR01 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("Hair").getChild("HairR01");
		this.EquipT01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipT01");
		this.EarR01 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("HairMain").getChild("EarBase").getChild("EarR01");
		this.EarR02 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("HairMain").getChild("EarBase").getChild("EarR01").getChild("EarR02");
		this.EarL01 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("HairMain").getChild("EarBase").getChild("EarL01");
		this.EarL02 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("HairMain").getChild("EarBase").getChild("EarL01").getChild("EarL02");
		this.NeckCloth = root.getChild("BodyMain").getChild("NeckCloth");
		this.Ahoke = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.ShoesR = root.getChild("BodyMain").getChild("Butt").getChild("LegRight").getChild("ShoesR");
		this.HairL01 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("Hair").getChild("HairL01");
		this.ShoesL = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft").getChild("ShoesL");
		this.EquipT04 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipT04");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.EquipT03 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipT03");
		this.EquipBase = root.getChild("BodyMain").getChild("EquipBase");
		this.EquipHead = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipHead");
		this.LegRight = root.getChild("BodyMain").getChild("Butt").getChild("LegRight");
		this.HairAnchor = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02").getChild("HairAnchor");
		this.EquipT02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipT02");
		this.LegLeft = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft");
		this.BodyMain = root.getChild("BodyMain");
		this.NeckTie = root.getChild("BodyMain").getChild("NeckCloth").getChild("NeckTie");
		this.ArmRight = root.getChild("BodyMain").getChild("ArmRight");
		this.ArmLeft = root.getChild("BodyMain").getChild("ArmLeft");
		this.HairR02 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeckCloth = root.getChild("GlowBodyMain").getChild("GlowNeckCloth");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead");
		this.offsetItem = new float[] {-0.16F, 1.24F, -0.03F};
		this.offsetBlock = new float[] {-0.16F, 1.24F, -0.03F};
		this.armMain = new ModelPart[] {this.BodyMain, this.ArmRight};
		this.armOff = new ModelPart[] {this.BodyMain, this.ArmLeft};
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
		
		boolean flag = !EmotionHelper.checkModelState(1, state);	//cannon
		this.EquipBase.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);			//hair
		this.HairAnchor.visible = !(flag);
				
		boolean fh1 = EmotionHelper.checkModelState(3, state);		//ear state 1
		boolean fh2 = EmotionHelper.checkModelState(4, state);		//ear state 2
		boolean fh3 = EmotionHelper.checkModelState(5, state);		//ear state 3
		
		if (fh1 || fh2 || fh3)
		{
			this.EarBase.visible = true;
		}
		else
		{
			this.EarBase.visible = false;
		}
	
	}

	public void syncRotationGlowPart()
	{

		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowNeckCloth.xRot = this.NeckCloth.xRot;
		this.GlowNeckCloth.yRot = this.NeckCloth.yRot;
		this.GlowNeckCloth.zRot = this.NeckCloth.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (0.55F + 0.26F * ent.getScaleLevel()); this.animTransZ += (0F);
    	this.setFaceHungry(ent);
    	
  	    //ear
  	    this.EarL01.xRot = 1F;
  	    this.EarL01.yRot = -0.4F;
  	    this.EarL01.zRot = 0F;
	    this.EarR01.xRot = 1F;
	    this.EarR01.yRot = 1.0472F;
	    this.EarR01.zRot = 0F;
  	    this.EarL02.xRot = -0.8F;
  	    this.EarL02.yRot = 0F;
  	    this.EarL02.zRot = 0F;
  	    this.EarR02.xRot = -0.2F;
  	    this.EarR02.yRot = -0.2F;
  	    this.EarR02.zRot = 0F;
		//equip
		this.EquipBase.zRot = 0.52F;
		//body
    	this.Head.xRot = 0F;
    	this.Head.yRot = 0F;
    	this.Head.zRot = 0F;
    	this.Ahoke.yRot = 0.5236F;
	  	this.BodyMain.yRot = 0F;
    	this.BodyMain.xRot = 1.4835F;
    	this.HairMidL01.xRot = -0.05F;
    	this.HairMidR01.xRot = -0.05F;
    	this.HairMidL02.xRot = -0.1F;
    	this.HairMidR02.xRot = -0.1F;
    	//arm
    	this.ArmLeft.xRot = -0.12F;
    	this.ArmLeft.zRot = -0.2F;
    	this.ArmRight.xRot = -0.12F;
    	this.ArmRight.zRot = 0.2F;
    	//leg
    	this.LegLeft.xRot = -0.2618F;
    	this.LegRight.xRot = -0.2618F;
    	this.LegLeft.yRot = 0F;
		this.LegRight.yRot = 0F;
    	this.LegLeft.zRot = 0.03F;
    	this.LegRight.zRot = -0.03F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F);
  		float angleX1 = Mth.cos(f2*0.08F + 0.3F + f * 0.5F);
  		float angleRun = Mth.cos(f * 1.5F) * f1;
  		float addk1 = 0;
  		float addk2 = 0;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//leg move parm
  		addk1 = Mth.cos(f * 0.7F) * f1 - 0.21F;
	  	addk2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 - 0.11F;

  	    //移動頭部使其看人
	  	this.Head.xRot = f4 * 0.014F + 0.1F;
	  	this.Head.yRot = f3 * 0.01F;
  	    //ear
	  	int state = ent.getStateEmotion(ID.S.State);
		boolean fh1 = EmotionHelper.checkModelState(3, state);
		boolean fh2 = EmotionHelper.checkModelState(4, state);
		boolean fh3 = EmotionHelper.checkModelState(5, state);
		boolean fh4 = fh1 && fh2;
		boolean fh5 = fh1 && fh3;
		boolean fh6 = fh2 && fh3;
		boolean fh7 = fh1 && fh2 && fh3;
	  	
		if (fh7)
		{
			this.EarL01.xRot = angleX * 0.075F + 0.6F;
	  	    this.EarL01.yRot = -0.5F;
	  	    this.EarL01.zRot = 0F;
		    this.EarR01.xRot = angleX * 0.075F + 1.1F;
		    this.EarR01.yRot = 0.5F;
		    this.EarR01.zRot = 0F;
	  	    this.EarL02.xRot = angleX1 * 0.1F + 0.7F;
	  	    this.EarL02.yRot = 0.1F;
	  	    this.EarL02.zRot = 0F;
	  	    this.EarR02.xRot = angleX1 * 0.1F + 1.0F;
	  	    this.EarR02.yRot = -0.1F;
	  	    this.EarR02.zRot = 0F;
		}
		else if (fh6)
		{
			this.EarL01.xRot = angleX * 0.075F + 1.1F;
	  	    this.EarL01.yRot = -0.5F;
	  	    this.EarL01.zRot = 0F;
		    this.EarR01.xRot = angleX * 0.075F + 1.1F;
		    this.EarR01.yRot = 0.5F;
		    this.EarR01.zRot = 0F;
	  	    this.EarL02.xRot = angleX1 * 0.1F + 1.0F;
	  	    this.EarL02.yRot = 0.1F;
	  	    this.EarL02.zRot = 0F;
	  	    this.EarR02.xRot = angleX1 * 0.1F + 1.0F;
	  	    this.EarR02.yRot = -0.1F;
	  	    this.EarR02.zRot = 0F;
		}
		else if (fh5)
		{
			this.EarL01.xRot = angleX * 0.075F - 1.1F;
	    	this.EarL01.yRot = 0.5F;
	    	this.EarL01.zRot = 0F;
	    	this.EarR01.xRot = angleX1 * 0.075F - 1.1F;
	    	this.EarR01.yRot = -0.5F;
	    	this.EarR01.zRot = 0F;
	    	this.EarL02.xRot = angleX * 0.075F - 0.8F;
	    	this.EarL02.yRot = 0F;
	    	this.EarL02.zRot = -0.5F;
	    	this.EarR02.xRot = angleX1 * 0.075F - 0.8F;
	    	this.EarR02.yRot = 0F;
	    	this.EarR02.zRot = 0.5F;
		}
		else if (fh4)
		{
			this.EarL01.xRot = angleX * 0.075F + 0.6F;
	  	    this.EarL01.yRot = -0.5F;
	  	    this.EarL01.zRot = 0F;
		    this.EarR01.xRot = angleX * 0.075F + 0.6F;
		    this.EarR01.yRot = 0.5F;
		    this.EarR01.zRot = 0F;
	  	    this.EarL02.xRot = angleX1 * 0.1F + 0.7F;
	  	    this.EarL02.yRot = 0.1F;
	  	    this.EarL02.zRot = 0F;
	  	    this.EarR02.xRot = angleX1 * 0.1F + 0.7F;
	  	    this.EarR02.yRot = -0.1F;
	  	    this.EarR02.zRot = 0F;
		}
		else if (fh3)
		{
			this.EarL01.xRot = angleX * 0.075F + 0.3F;
	  	    this.EarL01.yRot = -0.8F;
	  	    this.EarL01.zRot = 0F;
		    this.EarR01.xRot = angleX * 0.075F + 0.9F;
		    this.EarR01.yRot = 0.6F;
		    this.EarR01.zRot = 0F;
	  	    this.EarL02.xRot = angleX1 * 0.1F + 0.6F;
	  	    this.EarL02.yRot = 0.1F;
	  	    this.EarL02.zRot = 0F;
	  	    this.EarR02.xRot = angleX1 * 0.1F + 1F;
	  	    this.EarR02.yRot = -0.1F;
	  	    this.EarR02.zRot = 0F;
		}
		else if (fh2)
		{
			this.EarL01.xRot = angleX * 0.075F + 0.2F;
	  	    this.EarL01.yRot = -0.4F;
	  	    this.EarL01.zRot = 0.4F;
		    this.EarR01.xRot = angleX * 0.075F + 0.2F;
		    this.EarR01.yRot = 0.4F;
		    this.EarR01.zRot = -0.4F;
	  	    this.EarL02.xRot = angleX1 * 0.1F + 0.2F;
	  	    this.EarL02.yRot = 0F;
	  	    this.EarL02.zRot = -0.3F;
	  	    this.EarR02.xRot = angleX1 * 0.1F + 0.2F;
	  	    this.EarR02.yRot = 0F;
	  	    this.EarR02.zRot = 0.3F;
		}
		else if (fh1)
		{
			this.EarL01.xRot = angleX * 0.075F + -0.1F;
	  	    this.EarL01.yRot = 0.2F;
	  	    this.EarL01.zRot = 0.4F;
		    this.EarR01.xRot = angleX * 0.075F + 0F;
		    this.EarR01.yRot = 0.2F;
		    this.EarR01.zRot = -0.55F;
	  	    this.EarL02.xRot = angleX1 * 0.1F + 0.4F;
	  	    this.EarL02.yRot = 0F;
	  	    this.EarL02.zRot = -0.1F;
	  	    this.EarR02.xRot = angleX1 * 0.1F + 0.9F;
	  	    this.EarR02.yRot = 0.5F;
	  	    this.EarR02.zRot = 0F;
		}

  	    //hair
  	    this.HairMidL01.xRot = angleX * 0.07F + 0.14F;
  	    this.HairMidL02.xRot = -angleX1 * 0.2F + 0.14F;
  	    this.HairMidR01.xRot = this.HairMidL01.xRot;
  	    this.HairMidR02.xRot = this.HairMidL02.xRot;
  	    this.HairMidL01.zRot = -0.2618F;
	    this.HairMidL02.zRot = -0.14F;
	    this.HairMidR01.zRot = 0.2618F;
	    this.HairMidR02.zRot = 0.14F;
  	    this.HairL01.xRot = angleX * 0.06F - 0.2618F;
	    this.HairL02.xRot = -angleX1 * 0.1F + 0.2618F;
	    this.HairR01.xRot = angleX * 0.06F - 0.2618F;
	    this.HairR02.xRot = -angleX1 * 0.1F + 0.2618F;
	    this.HairL01.zRot = -0.2618F;
	    this.HairL02.zRot = 0.1745F;
	    this.HairR01.zRot = 0.2618F;
	    this.HairR02.zRot = -0.1745F;
	  	//Body
  	    this.Ahoke.yRot = angleX * 0.25F + 0.5236F;
	  	this.BodyMain.xRot = -0.1F;
	  	this.BodyMain.yRot = 0F;
	    //arm 
	  	this.ArmLeft.xRot = 0.15F;
	    this.ArmLeft.zRot = angleX * 0.1F - 0.5236F;
	    this.ArmRight.xRot = 0F;
	    this.ArmRight.yRot = 0F;
		this.ArmRight.zRot = -angleX * 0.1F + 0.5236F;
		//leg
		this.LegLeft.yRot = 0F;
		this.LegLeft.zRot = 0.05F;
		this.LegRight.yRot = 0F;
		this.LegRight.zRot = -0.05F;
		//equip
		this.EquipBase.zRot = 0.52F;

	    if (ent.getIsSprinting() || f1 > 0.6F)
	    {	//奔跑動作
	    	setFace(3);
	    	//body
	    	this.Head.xRot -= 0.2618F;
	    	this.BodyMain.xRot = 0.2618F;
	    	this.HairMidL01.xRot += 0.5F;
	    	this.HairMidR01.xRot += 0.5F;
	    	this.HairMidL02.xRot += 0.5F;
	    	this.HairMidR02.xRot += 0.5F;
	    	//arm
	    	this.ArmLeft.xRot = 0.7F;
	    	this.ArmLeft.zRot = -1.0472F;
	    	this.ArmRight.xRot = 0.7F;
	    	this.ArmRight.zRot = 1.0472F;
	    	//leg
	    	addk1 = Mth.cos(f * 2F) * f1 * 1.5F - 0.5F;
		  	addk2 = Mth.cos(f * 2F + 3.1415927F) * f1 * 1.5F - 0.5F;
	    	this.LegLeft.yRot = 0F;
	    	this.LegLeft.zRot = 0.05F;
	    	this.LegRight.yRot = 0F;
	    	this.LegRight.zRot = -0.05F;
	    	//ear
	    	this.EarL01.xRot = -angleRun * 0.08F - 0.8727F;
	    	this.EarL01.yRot = 0.5F;
	    	this.EarL01.zRot = 0F;
	    	this.EarR01.xRot = angleRun * 0.08F - 0.8727F;
	    	this.EarR01.yRot = -0.5F;
	    	this.EarR01.zRot = 0F;
	    	this.EarL02.xRot = -angleRun * 0.1F - 0.5F;
	    	this.EarL02.yRot = 0F;
	    	this.EarL02.zRot = -0.5F;
	    	this.EarR02.xRot = angleRun * 0.1F - 0.5F;
	    	this.EarR02.yRot = 0F;
	    	this.EarR02.zRot = 0.5F;
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {	//潛行, 蹲下動作
	    	//body
	    	this.Head.xRot -= 0.7854F;
	    	this.BodyMain.xRot = 0.7854F;
	    	//arm
	    	this.ArmLeft.zRot = -0.5F;
	    	this.ArmRight.zRot = 0.5F;
	    	//leg
	    	addk1 -= 0.8F;
	    	addk2 -= 0.8F;
  		}//end if sneaking
  		
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {	
	    	//騎乘動作
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{	
this.animTransX += (0F); this.animTransY += (0.575F); this.animTransZ += (0F);
		    	//body
		    	this.Head.xRot = -1.48F;
		    	this.Head.yRot = 0F;
		    	this.Head.zRot = 0F;
		    	this.BodyMain.xRot = 1.4835F;
		    	//arm
		    	this.ArmLeft.xRot = -3.0543F;
		    	this.ArmLeft.zRot = -0.7F;
		    	this.ArmRight.xRot = -2.8F;
		    	this.ArmRight.zRot = 0.35F;
		    	//leg
		    	addk1 = 0F;
		    	addk2 = -0.2618F;
		    	this.LegLeft.zRot = 0.1745F;
		    	this.LegRight.zRot = -0.35F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.45F); this.animTransZ += (0F);
		    	//body
		    	this.Head.xRot -= 0.7F;
		    	this.BodyMain.xRot = 0.5236F;
		    	//hair
		    	this.HairL01.xRot -= 0.2F;
		    	this.HairL02.xRot -= 0.2F;
		    	this.HairR01.xRot -= 0.2F;
		    	this.HairR02.xRot -= 0.2F;
		    	//arm
		    	this.ArmLeft.xRot = -0.5236F;
		    	this.ArmLeft.zRot = 0.3146F;
		    	this.ArmRight.xRot = -0.5236F;
		    	this.ArmRight.zRot = -0.3146F;
		    	//leg
		    	addk1 = -2.2689F;
		    	addk2 = -2.2689F;
		    	this.LegLeft.yRot = -0.3491F;
		    	this.LegRight.yRot = 0.3491F;
	    	}
  		}//end if sitting
	    
	    //攻擊動作    
	    if (ent.getAttackTick() > 20)
	    {
this.animTransX += (0F); this.animTransY += (0.14F + ent.getScaleLevel() * 0.07F); this.animTransZ += (0F);
	    	//body
	    	this.Head.xRot = -0.8727F;
	    	this.Head.yRot = 1.0472F;
	    	this.Head.zRot = -0.7F;
	    	this.BodyMain.xRot = 1.3F;
	    	this.BodyMain.yRot = -1.57F;
	    	//arm
	    	this.ArmLeft.xRot = 0F;
	    	this.ArmLeft.zRot = -0.5F;
	    	this.ArmRight.xRot = 0F;
	    	this.ArmRight.zRot = 1.57F;
	    	//leg
	    	addk1 = -1.75F;
	    	addk2 = -1.92F;
	    	//equip
	    	this.EquipBase.zRot = 1.57F;
	    }
	    
	    //swing arm
	  	float f6 = ent.getSwingTime(f2 - (int)f2);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight.xRot = -0.4F;
	        this.ArmRight.yRot = 0F;
	        this.ArmRight.zRot = -0.2F;
	        this.ArmRight.xRot += -f8 * 80.0F * Values.N.DIV_PI_180;
	        this.ArmRight.yRot += -f7 * 20.0F * Values.N.DIV_PI_180 + 0.2F;
	        this.ArmRight.zRot += -f8 * 20.0F * Values.N.DIV_PI_180;
	  	}
	  	
	  	//鬢毛調整
	    float headX = this.Head.xRot * -0.5F;
	    float headZ = this.Head.zRot * -0.5F;
	    this.HairMidL01.xRot += headX;
	    this.HairMidL01.zRot += headZ;
	    this.HairMidL02.xRot += headX * 0.5F;
	    this.HairMidL02.zRot += headZ * 0.5F;
	    this.HairMidR01.xRot += headX;
	    this.HairMidR01.zRot += headZ;
	    this.HairMidR02.xRot += headX * 0.5F;
	    this.HairMidR02.zRot += headZ * 0.5F;
	  	this.HairL01.zRot += headZ;
	  	this.HairL02.zRot += headZ;
	  	this.HairR01.zRot += headZ;
	  	this.HairR02.zRot += headZ;
		this.HairL01.xRot += headX;
	  	this.HairL02.xRot += headX;
	  	this.HairR01.xRot += headX;
	  	this.HairR02.xRot += headX;
	    
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

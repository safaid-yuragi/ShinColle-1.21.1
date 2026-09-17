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

public class ModelSubmU511<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart Butt;
	public ModelPart Cloth01;
	public ModelPart EquipBase;
	public ModelPart Head;
	public ModelPart Pipe;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Hat01;
	public ModelPart Ahoke;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart HairL02;
	public ModelPart HairR02;
	public ModelPart Hair01;
	public ModelPart Hat02;
	public ModelPart Ear1;
	public ModelPart Ear2;
	public ModelPart ArmLeft02;
	public ModelPart ArmLeft03;
	public ModelPart ArmRight02;
	public ModelPart ArmRight03;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart Skirt;
	public ModelPart LegRight02;
	public ModelPart LegLeft02;
	public ModelPart EquipMid;
	public ModelPart EquipL;
	public ModelPart EquipR;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 21.0F, 7.0F), PartPose.offset(0.0F, -13.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-7.0F, 0.0F, -4.5F, 14.0F, 11.0F, 8.0F), PartPose.offset(0.0F, -11.5F, 0.0F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-4.5F, -2.0F, -6.0F, 9.0F, 4.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("Hat01", CubeListBuilder.create().addBox(-3.0F, -6.0F, 0.5F, 6.0F, 6.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -15.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("Hat02", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.5F, 16.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 8.4F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("Ear2", CubeListBuilder.create().addBox(0.0F, 0.0F, -4.0F, 0.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(-8.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef7 = partdef5.addOrReplaceChild("Ear1", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -4.0F, 0.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(8.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef8 = partdef3.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -6.8F, 16.0F, 17.0F, 8.0F), PartPose.offset(0.0F, -7.5F, -0.5F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("HairL01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(6.5F, 0.0F, -4.0F, -0.17453292519943295F, -0.17453292519943295F, -0.13962634015954636F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.17453292519943295F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef11 = partdef8.addOrReplaceChild("HairR01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-6.5F, 0.0F, -4.0F, -0.17453292519943295F, 0.17453292519943295F, 0.13962634015954636F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(0.2F, 6.0F, 0.0F, -0.17453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef13 = partdef8.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -4.0F, -11.0F, 0.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -8.0F, -5.0F, 0.0F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef14 = partdef3.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 10.0F), PartPose.offset(0.0F, -15.0F, -3.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 18.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.1F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdef2.addOrReplaceChild("Pipe", CubeListBuilder.create().addBox(0.0F, -26.0F, 0.0F, 1.0F, 25.0F, 1.0F), PartPose.offsetAndRotation(7.0F, -1.0F, -3.5F, -0.08726646259971647F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef17 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-8.0F, 5.0F, -5.0F, 16.0F, 9.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("Skirt", CubeListBuilder.create().addBox(-8.0F, 0.0F, -4.5F, 16.0F, 9.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 5.0F, -2.0F, 0.3490658503988659F, -3.141592653589793F, 0.0F));
		PartDefinition partdef19 = partdef17.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F), PartPose.offsetAndRotation(-3.8F, 9.5F, -2.7F, -0.2618F, 0.0F, -0.03490658503988659F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 14.0F, 6.0F), PartPose.offset(0.0F, 13.0F, -3.0F));
		PartDefinition partdef21 = partdef17.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F), PartPose.offsetAndRotation(3.8F, 9.5F, -2.7F, -0.2618F, 0.0F, 0.03490658503988659F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("LegLeft02", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 14.0F, 6.0F), PartPose.offset(0.0F, 13.0F, -3.0F));
		PartDefinition partdef23 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-4.5F, -1.0F, -3.5F, 7.0F, 8.0F, 7.0F), PartPose.offsetAndRotation(-7.2F, -9F, -0.7F, 0.0F, 0.0F, 0.10471975511965977F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(-2.5F, 0.0F, -3.0F, 5.0F, 3.0F, 5.0F), PartPose.offset(-0.8F, 7F, 0.5F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("ArmRight03", CubeListBuilder.create().addBox(-2.5F, 0.0F, -4.0F, 5.0F, 11.0F, 5.0F), PartPose.offset(0.0F, 3.0F, 1.0F));
		PartDefinition partdef26 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-2.5F, -1.0F, -3.5F, 7.0F, 8.0F, 7.0F), PartPose.offsetAndRotation(7.2F, -9F, -0.7F, 0.0F, 0.0F, -0.10471975511965977F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -3.0F, 5.0F, 3.0F, 5.0F), PartPose.offset(0.8F, 7F, 0.5F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("ArmLeft03", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -4.0F, 5.0F, 11.0F, 5.0F), PartPose.offset(0.0F, 3.0F, 1.0F));
		PartDefinition partdef29 = partdef0.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(-3.0F, 0.0F, 1.0F, 6.0F, 16.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 8.0F, 3.0F, 0.4363323129985824F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("EquipMid", CubeListBuilder.create().addBox(-13.0F, 0.0F, 0.0F, 26.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -5.0F, 2.0F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("EquipL", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -20.0F, 5.0F, 13.0F, 20.0F), PartPose.offsetAndRotation(11.5F, 0.0F, 4.0F, -0.3141592653589793F, -0.17453292519943295F, 0.0F));
		PartDefinition partdef32 = partdef30.addOrReplaceChild("EquipR", CubeListBuilder.create().addBox(-5.0F, 0.0F, -20.0F, 5.0F, 13.0F, 20.0F), PartPose.offsetAndRotation(-11.5F, 0.0F, 4.0F, -0.3141592653589793F, 0.17453292519943295F, 0.0F));
		PartDefinition partdef33 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef37 = partdef35.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef38 = partdef35.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef39 = partdef35.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef40 = partdef35.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef41 = partdef35.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef42 = partdef35.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef43 = partdef35.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef44 = partdef35.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef45 = partdef35.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelSubmU511(ModelPart root)
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
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.HairL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.Hat01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01");
		this.EquipL = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMid").getChild("EquipL");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.ArmRight03 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight03");
		this.BodyMain = root.getChild("BodyMain");
		this.HairR02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.Skirt = root.getChild("BodyMain").getChild("Butt").getChild("Skirt");
		this.EquipR = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMid").getChild("EquipR");
		this.ArmLeft03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft03");
		this.EquipMid = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipMid");
		this.Ear2 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat02").getChild("Ear2");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.Hat02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat02");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.Pipe = root.getChild("BodyMain").getChild("Neck").getChild("Pipe");
		this.Ear1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat02").getChild("Ear1");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.EquipBase = root.getChild("BodyMain").getChild("EquipBase");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.offsetItem = new float[] {0F, 1.1F, -0.05F};
		this.offsetBlock = new float[] {0F, 1.1F, -0.05F};
		this.armMain = new ModelPart[] {this.BodyMain, this.ArmRight01, this.ArmRight02, this.ArmRight03};
		this.armOff = new ModelPart[] {this.BodyMain, this.ArmLeft01, this.ArmLeft02, this.ArmLeft03};
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
				
		flag = !EmotionHelper.checkModelState(1, state);	//hat
		this.Hat01.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);	//tube
		this.Pipe.visible = !(flag);
	
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

this.animTransX += (0F); this.animTransY += (0.41F + 0.19F * ent.getScaleLevel()); this.animTransZ += (0F);
    	this.setFaceHungry(ent);
    	
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.035F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.035F;
		this.LegLeft01.xRot = -2.8F;
    	this.LegLeft02.xRot = 1.4F;
    	this.LegRight01.xRot = -2.8F;
    	this.LegRight02.xRot = 1.4F;
		//equip
	  	this.Pipe.xRot = -0.0873F;
    	//body
	  	this.Ahoke.yRot = 0.5236F;
    	this.Head.xRot = 0.2618F;
    	this.Head.yRot = 0F;
    	this.BodyMain.xRot = 0.35F;
    	//arm
    	this.ArmLeft01.xRot = -0.7F;
    	this.ArmLeft01.yRot = 0F;
    	this.ArmLeft01.zRot = -0.12F;
    	this.ArmRight01.xRot = -0.96F;
    	this.ArmRight01.yRot = -0.35F;
    	this.ArmRight01.zRot = 0.12F;
    	this.ArmRight03.zRot = -1.57F;
    	this.ArmRight03.x = (0.0F) + (-0.153F) * 16F;
    	this.ArmRight03.y = (3.0F) + (0.1F) * 16F;
    	//hair
    	this.Hair01.xRot = 0.05F;
	  	this.Ear1.zRot = -0.2618F;
	  	this.Ear2.zRot = 0.2618F;
	  	//skirt
	  	this.Skirt.xRot = 2.618F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.5F;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.5F;
  		float addk1 = 0;
  		float addk2 = 0;
  		
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
	  	//Body
  	    this.Ahoke.yRot = angleX * 0.25F + 0.5236F;
	  	this.BodyMain.xRot = -0.1F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.06F + 0.3F;
	    this.Hair01.zRot = 0F;
		this.HairL01.xRot = -0.17F;
	  	this.HairL02.xRot = 0.17F;
	  	this.HairR01.xRot = -0.17F;
	  	this.HairR02.xRot = 0.17F;
	  	this.HairL01.zRot = -0.14F;
	  	this.HairL02.zRot = 0.08F;
	  	this.HairR01.zRot = 0.14F;
	  	this.HairR02.zRot = -0.05F;
	  	this.Ear1.zRot = angleX * 0.1F - 0.2618F;
	  	this.Ear2.zRot = angleX * 0.1F + 0.2618F;
	    //arm 
	  	this.ArmLeft01.xRot = angleAdd2 * 0.5F + 0.15F;
	  	this.ArmLeft01.yRot = 0F;
	  	this.ArmLeft01.zRot = -angleX * 0.06F - 0.16F;
	    this.ArmRight01.xRot = angleAdd1 * 0.5F;
	    this.ArmRight01.yRot = 0F;
    	this.ArmRight01.zRot = angleX * 0.06F + 0.16F;
    	this.ArmRight03.zRot = 0F;
    	this.ArmRight03.x = (0.0F) + (0F) * 16F;
    	this.ArmRight03.y = (3.0F) + (0F) * 16F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.035F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.035F;
		this.LegLeft02.xRot = 0F;
    	this.LegRight02.xRot = 0F;
		//equip
	  	this.Pipe.xRot = -0.0873F;
	  	//skirt
	  	this.Skirt.xRot = 0.35F;

	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {	//奔跑動作
	    	//無特殊奔跑動作
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {	//潛行, 蹲下動作
this.animTransX += (0F); this.animTransY += (0.1F); this.animTransZ += (0F);
	    	//body
	    	this.Head.xRot -= 0.8727F;
	    	this.BodyMain.xRot = 1.0472F;
		  	//hair
		  	this.Hair01.xRot += 0.2236F;
		  	//leg
		  	addk1 -= 1.2F;
		  	addk2 -= 1.2F;
		  	//equip
		  	this.Pipe.xRot = -0.7854F;
		  	//skirt
		  	this.Skirt.xRot = 0.8727F;
  		}//end if sneaking
  		
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {  //騎乘動作
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
this.animTransX += (0F); this.animTransY += (0.41F); this.animTransZ += (0F);
		    	//body
		    	this.Head.xRot += 0.2618F;
		    	this.BodyMain.xRot = 0.35F;
		    	//hair
		    	this.HairL01.xRot -= 0.2F;
		    	this.HairR01.xRot -= 0.2F;
		    	this.HairL02.xRot -= 0.2F;
		    	this.HairR02.xRot -= 0.2F;
		    	//arm
		    	this.ArmLeft01.xRot = -angleX * 0.2F - 0.7F;
		    	this.ArmRight01.xRot = -0.96F;
		    	this.ArmRight01.yRot = -0.35F;
		    	this.ArmRight03.zRot = -1.57F;
		    	this.ArmRight03.x = (0.0F) + (-0.153F) * 16F;
		    	this.ArmRight03.y = (3.0F) + (0.1F) * 16F;
		    	//hair
		    	this.Hair01.xRot -= 0.25F;
		    	//leg
		    	addk1 = -2.8F;
		    	addk2 = -2.8F;
		    	this.LegLeft02.xRot = 1.4F;
		    	this.LegRight02.xRot = 1.4F;
			  	//skirt
			  	this.Skirt.xRot = 2.618F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.4F); this.animTransZ += (0F);
		    	//body
		    	this.Head.xRot -= 0.7F;
		    	this.BodyMain.xRot = 0.5236F;
		    	//hair
		    	this.HairL01.xRot -= 0.3F;
		    	this.HairR01.xRot -= 0.3F;
		    	this.HairL02.xRot -= 0.3F;
		    	this.HairR02.xRot -= 0.3F;
		    	//arm
		    	this.ArmLeft01.xRot = -0.5236F;
		    	this.ArmLeft01.zRot = 0.3146F;
		    	this.ArmRight01.xRot = -0.5236F;
		    	this.ArmRight01.zRot = -0.3146F;
		    	//leg
		    	addk1 = -2.2689F;
		    	addk2 = -2.2689F;
		    	this.LegLeft01.yRot = -0.3491F;
		    	this.LegRight01.yRot = 0.3491F;
		    	//equip
			  	this.Pipe.xRot = -0.7854F;
			  	//skirt
			  	this.Skirt.xRot = 0.8727F;
	    	}
  		}//end if sitting
	    
	    //attack
	    if (ent.getAttackTick() > 43)
	    {
	    	//swing arm
		    float ft = (50 - ent.getAttackTick()) + (f2 - (int)f2);
		    ft *= 0.08F;
	  		float fa = Mth.cos(ft * ft * (float)Math.PI);
	        float fb = Mth.cos(Mth.sqrt(ft) * (float)Math.PI);
	        this.ArmLeft01.xRot += -fb * 80.0F * Values.N.DIV_PI_180 - 0.9F;
	        this.ArmLeft01.yRot += fa * 20.0F * Values.N.DIV_PI_180 - 0.3F;
	        this.ArmLeft01.zRot += fb * 10.0F * Values.N.DIV_PI_180;
	    }//end attack
	    
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
	  	
	  	//鬢毛調整
	    float headX = this.Head.xRot * -0.5F;
	    float headZ = this.Head.zRot * -0.5F;
	    this.Hair01.xRot += headX;
	    this.Hair01.zRot += headZ;
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

    	switch (((IShipEmotion)entity).getScaleLevel())
    	{
    	case 3:
    		scale = 1.44F;
        	offsetY = -0.45F;
		break;
    	case 2:
    		scale = 1.08F;
        	offsetY = -0.06F;
		break;
    	case 1:
    		scale = 0.72F;
        	offsetY = 0.66F;
		break;
    	default:
    		scale = 0.36F;
        	offsetY = 2.86F;
		break;
    	}
    	
    	
    	RenderHelper.animScale(this, scale, scale * 0.95F, scale);
this.animTransX += (0F); this.animTransY += (offsetY); this.animTransZ += (0F);
    	
    	//main body
		super.setupAnim(entity, f, f1, f2, f3, f4);
	}

}

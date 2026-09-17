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

public class ModelHeavyCruiserRi<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Butt;
	public ModelPart ArmLeft;
	public ModelPart ArmRight;
	public ModelPart Neck;
	public ModelPart EquipBase;
	public ModelPart LegRight;
	public ModelPart LegLeft;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart EquipLeftBase;
	public ModelPart EquipLeftTube1;
	public ModelPart EquipLeftBase2;
	public ModelPart EquipLeftBase3;
	public ModelPart EquipLeftBase4;
	public ModelPart EquipLeftTube2;
	public ModelPart EquipLeftTube3;
	public ModelPart EquipLeftTooth;
	public ModelPart EquipRightBase;
	public ModelPart EquipRightTube1;
	public ModelPart EquipRightBase1;
	public ModelPart EquipRightBase2;
	public ModelPart EquipRightBase3;
	public ModelPart EquipRightBase4;
	public ModelPart EquipRightTube2;
	public ModelPart EquipRightTube3;
	public ModelPart EquipRightTooth1;
	public ModelPart EquipRightTooth2;
	public ModelPart Head;
	public ModelPart Cloak;
	public ModelPart Hair;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ModelPart GlowArmLeft;
	public ModelPart GlowEquipLeftBase;
	public ModelPart GlowEquipLeftBase3;
	public ModelPart GlowArmRight;
	public ModelPart GlowEquipRightBase;
	public ModelPart GlowEquipRightBase2;
	public ModelPart GlowEquipRightBase3;
	public ModelPart ShoesRight;
	public ModelPart ShoesLeft;
	public ModelPart HeadTail0;
	public ModelPart HeadTail1;
	public ModelPart HeadTail2;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -10.0F, -4.0F, 13.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -14.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -1.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(3.3F, -8.5F, -2.5F, -0.7853981633974483F, 0.087F, 0.087F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("ArmRight", CubeListBuilder.create().addBox(-5F, 0.0F, -2.5F, 5.0F, 25.0F, 5.0F), PartPose.offsetAndRotation(-6F, -9.5F, 0.0F, 0.2F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("EquipRightBase", CubeListBuilder.create().addBox(-7.5F, 0.0F, -4.5F, 13.0F, 14.0F, 9.0F), PartPose.offsetAndRotation(-6.0F, 16.0F, 0.0F, 0.0F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("EquipRightBase1", CubeListBuilder.create().addBox(0.0F, -20.0F, 0.0F, 4.0F, 21.0F, 11.0F), PartPose.offsetAndRotation(-5.0F, 0.0F, -5.5F, 0.0F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef5 = partdef3.addOrReplaceChild("EquipRightBase4", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 25.0F, 15.0F), PartPose.offsetAndRotation(-5.0F, 0.0F, -7.5F, 0.0F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef6 = partdef3.addOrReplaceChild("EquipRightBase3", CubeListBuilder.create().addBox(0.0F, 0.0F, -3.5F, 3.0F, 8.0F, 7.0F), PartPose.offsetAndRotation(1.0F, 14.0F, 0.0F, 0.0F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef7 = partdef3.addOrReplaceChild("EquipRightBase2", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 10.0F, 10.0F), PartPose.offsetAndRotation(-4.2F, 13.0F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef8 = partdef3.addOrReplaceChild("EquipRightTube1", CubeListBuilder.create().addBox(-1.5F, -16.0F, -1.5F, 3.0F, 16.0F, 3.0F), PartPose.offsetAndRotation(1.0F, 8.0F, 3.0F, -1.0471975511965976F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("EquipRightTube2", CubeListBuilder.create().addBox(-1.5F, -13.0F, -1.5F, 3.0F, 14.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, 0.7853981633974483F, -0.17453292519943295F, 0.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("EquipRightTube3", CubeListBuilder.create().addBox(-3.5F, -23.5F, -1.4F, 3.0F, 25.0F, 3.0F), PartPose.offsetAndRotation(2.0F, -12.0F, 0.0F, 1.3962634015954636F, -0.3490658503988659F, 0.0F));
		PartDefinition partdef11 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-5.5F, 0F, -5.6F, 11.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(0F, -13F, 1F, 0.1F, 0F, 0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, 0.5F, 0.0F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.2F, 16.0F, 16.0F, 16.0F), PartPose.offset(0.0F, -7.0F, 0.0F));
		PartDefinition partdef14 = partdef12.addOrReplaceChild("HeadTail0", CubeListBuilder.create().addBox(-4.5F, 0.0F, -3.0F, 9.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 8.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("HeadTail1", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.0F, 7.0F, 16.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.09F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("HeadTail2", CubeListBuilder.create().addBox(-4F, 0.0F, -2.5F, 8.0F, 18.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 14.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef11.addOrReplaceChild("Cloak", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 16.0F, 0.0F), PartPose.offsetAndRotation(0F, 1F, 4F, 1.3089969389957472F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-8.0F, 0.0F, -4.1F, 16.0F, 8.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("LegRight", CubeListBuilder.create().addBox(-3F, 0F, -3F, 6.0F, 17.0F, 6.0F), PartPose.offsetAndRotation(-4.7F, 7.5F, -1F, -0.2F, 0.0F, -0.087F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("ShoesRight", CubeListBuilder.create().addBox(-3.5F, 17.0F, -3.5F, 7.0F, 9.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef21 = partdef18.addOrReplaceChild("LegLeft", CubeListBuilder.create().addBox(-3F, 0F, -3F, 6.0F, 17.0F, 6.0F), PartPose.offsetAndRotation(4.7F, 7.5F, -1F, -0.087F, 0.0F, 0.087F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("ShoesLeft", CubeListBuilder.create().mirror().addBox(-3.5F, 17.0F, -3.5F, 7.0F, 9.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef23 = partdef0.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 10.0F, 7.0F, 4.0F), PartPose.offset(0.0F, -11.0F, 4.0F));
		PartDefinition partdef24 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, -1.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-3.3F, -8.5F, -2.5F, -0.7853981633974483F, -0.087F, -0.087F));
		PartDefinition partdef25 = partdef0.addOrReplaceChild("ArmLeft", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -2.5F, 5.0F, 25.0F, 5.0F), PartPose.offsetAndRotation(6.0F, -9.5F, 0.0F, -0.087F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("EquipLeftBase", CubeListBuilder.create().addBox(-6.0F, 0.0F, -7.0F, 10.0F, 14.0F, 14.0F), PartPose.offsetAndRotation(7.0F, 16.0F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("EquipLeftBase2", CubeListBuilder.create().addBox(-3.0F, -7.0F, -5.0F, 8.0F, 7.0F, 10.0F), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.025481807079117208F));
		PartDefinition partdef28 = partdef26.addOrReplaceChild("EquipLeftBase4", CubeListBuilder.create().addBox(-6.5F, 0.0F, 0.0F, 11.0F, 16.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 6.5F, 2.5F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef29 = partdef26.addOrReplaceChild("EquipLeftBase3", CubeListBuilder.create().addBox(-7.5F, 5.0F, -10.0F, 13.0F, 19.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdef26.addOrReplaceChild("EquipLeftTube1", CubeListBuilder.create().addBox(-1.5F, -16.0F, -1.5F, 3.0F, 16.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, 8.0F, 3.0F, -0.6981317007977318F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("EquipLeftTube2", CubeListBuilder.create().addBox(-1.5F, -12.0F, -1.5F, 3.0F, 12.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, 0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("EquipLeftTube3", CubeListBuilder.create().addBox(-1.5F, -20.0F, -1.5F, 3.0F, 20.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 1.4486232791552935F, 0.7853981633974483F, 0.2617993877991494F));
		PartDefinition partdef33 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, -14.0F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offset(0F, -13F, 1F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0F, 0.5F, 0F));
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
		PartDefinition partdef46 = partdef33.addOrReplaceChild("GlowArmLeft", CubeListBuilder.create(), PartPose.offsetAndRotation(7F, -10F, 0F, 0.0F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("GlowEquipLeftBase", CubeListBuilder.create(), PartPose.offsetAndRotation(7F, 16F, 0F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("GlowEquipLeftBase3", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("EquipLeftTooth", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 9.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 14.0F, -1.2F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef50 = partdef33.addOrReplaceChild("GlowArmRight", CubeListBuilder.create(), PartPose.offsetAndRotation(-7F, -10F, 0F, 0.0F, 0.0F, 0.2617993877991494F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("GlowEquipRightBase", CubeListBuilder.create(), PartPose.offsetAndRotation(-6F, 16F, 0F, 0.0F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("GlowEquipRightBase2", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.2F, 13F, 0F, 0.0F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("EquipRightTooth1", CubeListBuilder.create().addBox(0.0F, 0.0F, -4.0F, 2.0F, 5.0F, 8.0F), PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition partdef54 = partdef51.addOrReplaceChild("GlowEquipRightBase3", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 14.0F, 0.0F, 0.0F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("EquipRightTooth2", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.5F, 2.0F, 5.0F, 5.0F), PartPose.offset(-1.6F, 2.3F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelHeavyCruiserRi(ModelPart root)
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
		this.EquipRightTube2 = root.getChild("BodyMain").getChild("ArmRight").getChild("EquipRightBase").getChild("EquipRightTube1").getChild("EquipRightTube2");
		this.EquipRightTooth2 = root.getChild("GlowBodyMain").getChild("GlowArmRight").getChild("GlowEquipRightBase").getChild("GlowEquipRightBase3").getChild("EquipRightTooth2");
		this.LegRight = root.getChild("BodyMain").getChild("Butt").getChild("LegRight");
		this.EquipRightTooth1 = root.getChild("GlowBodyMain").getChild("GlowArmRight").getChild("GlowEquipRightBase").getChild("GlowEquipRightBase2").getChild("EquipRightTooth1");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.EquipLeftBase2 = root.getChild("BodyMain").getChild("ArmLeft").getChild("EquipLeftBase").getChild("EquipLeftBase2");
		this.EquipRightBase1 = root.getChild("BodyMain").getChild("ArmRight").getChild("EquipRightBase").getChild("EquipRightBase1");
		this.EquipRightTube3 = root.getChild("BodyMain").getChild("ArmRight").getChild("EquipRightBase").getChild("EquipRightTube1").getChild("EquipRightTube2").getChild("EquipRightTube3");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.EquipLeftTube2 = root.getChild("BodyMain").getChild("ArmLeft").getChild("EquipLeftBase").getChild("EquipLeftTube1").getChild("EquipLeftTube2");
		this.EquipLeftBase4 = root.getChild("BodyMain").getChild("ArmLeft").getChild("EquipLeftBase").getChild("EquipLeftBase4");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.LegLeft = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft");
		this.EquipLeftBase3 = root.getChild("BodyMain").getChild("ArmLeft").getChild("EquipLeftBase").getChild("EquipLeftBase3");
		this.EquipRightBase4 = root.getChild("BodyMain").getChild("ArmRight").getChild("EquipRightBase").getChild("EquipRightBase4");
		this.ArmRight = root.getChild("BodyMain").getChild("ArmRight");
		this.ArmLeft = root.getChild("BodyMain").getChild("ArmLeft");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.ShoesRight = root.getChild("BodyMain").getChild("Butt").getChild("LegRight").getChild("ShoesRight");
		this.ShoesLeft = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft").getChild("ShoesLeft");
		this.EquipRightBase3 = root.getChild("BodyMain").getChild("ArmRight").getChild("EquipRightBase").getChild("EquipRightBase3");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.EquipBase = root.getChild("BodyMain").getChild("EquipBase");
		this.EquipLeftTube1 = root.getChild("BodyMain").getChild("ArmLeft").getChild("EquipLeftBase").getChild("EquipLeftTube1");
		this.EquipLeftTooth = root.getChild("GlowBodyMain").getChild("GlowArmLeft").getChild("GlowEquipLeftBase").getChild("GlowEquipLeftBase3").getChild("EquipLeftTooth");
		this.BodyMain = root.getChild("BodyMain");
		this.EquipLeftBase = root.getChild("BodyMain").getChild("ArmLeft").getChild("EquipLeftBase");
		this.EquipRightBase = root.getChild("BodyMain").getChild("ArmRight").getChild("EquipRightBase");
		this.EquipRightBase2 = root.getChild("BodyMain").getChild("ArmRight").getChild("EquipRightBase").getChild("EquipRightBase2");
		this.EquipRightTube1 = root.getChild("BodyMain").getChild("ArmRight").getChild("EquipRightBase").getChild("EquipRightTube1");
		this.Cloak = root.getChild("BodyMain").getChild("Neck").getChild("Cloak");
		this.EquipLeftTube3 = root.getChild("BodyMain").getChild("ArmLeft").getChild("EquipLeftBase").getChild("EquipLeftTube1").getChild("EquipLeftTube2").getChild("EquipLeftTube3");
		this.HeadTail0 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadTail0");
		this.HeadTail1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadTail0").getChild("HeadTail1");
		this.HeadTail2 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadTail0").getChild("HeadTail1").getChild("HeadTail2");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.GlowArmLeft = root.getChild("GlowBodyMain").getChild("GlowArmLeft");
		this.GlowEquipLeftBase = root.getChild("GlowBodyMain").getChild("GlowArmLeft").getChild("GlowEquipLeftBase");
		this.GlowEquipLeftBase3 = root.getChild("GlowBodyMain").getChild("GlowArmLeft").getChild("GlowEquipLeftBase").getChild("GlowEquipLeftBase3");
		this.GlowArmRight = root.getChild("GlowBodyMain").getChild("GlowArmRight");
		this.GlowEquipRightBase = root.getChild("GlowBodyMain").getChild("GlowArmRight").getChild("GlowEquipRightBase");
		this.GlowEquipRightBase2 = root.getChild("GlowBodyMain").getChild("GlowArmRight").getChild("GlowEquipRightBase").getChild("GlowEquipRightBase2");
		this.GlowEquipRightBase3 = root.getChild("GlowBodyMain").getChild("GlowArmRight").getChild("GlowEquipRightBase").getChild("GlowEquipRightBase3");
		this.scale = 0.41F;
		this.offsetY = 2.15F;
		this.offsetItem = new float[] {-0.14F, 1.29F, 0F};
		this.offsetBlock = new float[] {-0.14F, 1.29F, 0F};
		this.armMain = new ModelPart[] {this.BodyMain, this.ArmRight};
		this.armOff = new ModelPart[] {this.BodyMain, this.ArmLeft};
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
		boolean fc1 = EmotionHelper.checkModelState(0, state);	//left cannon
		boolean fc2 = EmotionHelper.checkModelState(1, state);	//right cannon
		
		if (fc1)
		{
    		this.EquipBase.visible = true;
			this.EquipLeftBase.visible = true;
			this.GlowEquipLeftBase.visible = true;
		}
		
		if (fc2)
		{
    		this.EquipBase.visible = true;
			this.EquipRightBase.visible = true;
			this.GlowEquipRightBase.visible = true;
		}
		
		if (!fc1 && !fc2)
		{
    		this.EquipBase.visible = false;
			this.EquipLeftBase.visible = false;
			this.EquipRightBase.visible = false;
			this.GlowEquipLeftBase.visible = false;
			this.GlowEquipRightBase.visible = false;
		}

		boolean flag = !EmotionHelper.checkModelState(2, state);	//cloak
		this.Cloak.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(3, state);			//hair
		this.HeadTail0.visible = !(flag);
	
	}

	public void syncRotationGlowPart()
	{

		this.GlowArmLeft.xRot = this.ArmLeft.xRot;
		this.GlowArmLeft.yRot = this.ArmLeft.yRot;
		this.GlowArmLeft.zRot = this.ArmLeft.zRot;
		this.GlowArmRight.xRot = this.ArmRight.xRot;
		this.GlowArmRight.yRot = this.ArmRight.yRot;
		this.GlowArmRight.zRot = this.ArmRight.zRot;
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

this.animTransX += (0F); this.animTransY += (0.46F); this.animTransZ += (0F);
    	this.setFaceHungry(ent);

  	    //移動頭部 使其看人, 不看人時持續擺動頭部
	    this.Head.xRot = 0.2F;
	    this.Head.yRot = 0F;
	    this.Head.zRot = 0F;
	    //正常站立動作
	    this.Cloak.xRot = -0.2F;	    
  	    this.BoobL.xRot = -0.73F;
  	    this.BoobR.xRot = -0.73F;
  	    //body
  	    this.BodyMain.xRot = 0.3F;
		//hair
		this.HeadTail0.xRot = -0.05F;
		this.HeadTail1.xRot = -0.05F;
		//arm
		this.ArmLeft.xRot = -0.6F;
		this.ArmRight.xRot = -0.6F;
		this.ArmLeft.zRot = 0.5F;
		this.ArmRight.zRot = -0.5F;
		//leg
		this.LegLeft.xRot = -2F;
		this.LegLeft.yRot = 0.15F;
		this.LegLeft.zRot = 1.2F;
		this.LegRight.xRot = -2F;
		this.LegRight.yRot = -0.15F;
		this.LegRight.zRot = -1.2F;
	
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
  		addk1 = Mth.cos(f * 0.6662F) * 1.4F * f1 - 0.087F;
	  	addk2 = Mth.cos(f * 0.6662F + 3.1415927F) * 1.4F * f1 - 0.2F;

  	    //移動頭部 使其看人, 不看人時持續擺動頭部
	    this.Head.yRot = f3 * 0.01F;	//左右角度
	    this.Head.xRot = f4 * 0.008F; 	//上下角度
	    
	    //正常站立動作
	    this.Cloak.xRot = angleZ * 0.2F + 1F;	    
  	    this.BoobL.xRot = -angleZ * 0.06F - 0.73F;
  	    this.BoobR.xRot = -angleZ * 0.06F - 0.73F;
  	    //body
  	    this.BodyMain.xRot = -0.15F;
  	    //arm
	  	this.ArmLeft.zRot = angleZ * -0.06F - 0.25F;
	    this.ArmLeft.xRot = 0.2F;
		this.ArmRight.xRot = 0.2F;
		this.ArmRight.yRot = 0F;
		this.ArmRight.zRot = angleZ * 0.06F + 0.25F;
		//leg
		this.LegLeft.zRot = 0.087F;
		this.LegRight.zRot = -0.087F;
		this.LegLeft.yRot = 0F;
		this.LegRight.yRot = 0F;
		//hair
		this.HeadTail0.xRot = angleZ * 0.05F + 0.26F;
		this.HeadTail1.xRot = angleZ * 0.1F + 0.09F;
	    
	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {	//奔跑動作
  			this.ArmLeft.xRot = 1F;
  			this.ArmRight.xRot = 1F;
  			this.BodyMain.xRot = 0.5F;
  			this.HeadTail0.xRot = angleZ * 0.05F + 0.8F;
  			addk1 -= 0.4F;
			addk2 -= 0.4F;
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
  		
	    if (ent.getIsSneaking())
	    {
this.animTransX += (0F); this.animTransY += (0.05F); this.animTransZ += (0F);
	    	//潛行動作
  			this.ArmLeft.xRot = 0.7F;
  			this.ArmRight.xRot = 0.7F;
  			this.BodyMain.xRot = 0.5F;
  			addk1 -= 0.6F;
			addk2 -= 0.6F;
  		}
  		
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {  //騎乘動作 			
  			if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
  			{
this.animTransX += (0F); this.animTransY += (0.44F); this.animTransZ += (0F);
				this.ArmLeft.xRot = 0.6F;
	  			this.ArmRight.xRot = 0.6F;
	  			this.ArmLeft.zRot = -0.6F;
	  			this.ArmRight.zRot = 0.6F;
				this.BodyMain.xRot = -0.6F;
				this.Head.xRot -= 0.2F;
				addk1 = -1.58F;
				addk2 = -1.58F;		
				this.LegLeft.zRot = 1.2F;
				this.LegRight.zRot = -1.2F;
				this.LegLeft.yRot = -0.75F;
				this.LegRight.yRot = 0.75F;
				this.HeadTail0.xRot += 0.7F;
  			}
  			else
  			{
this.animTransX += (0F); this.animTransY += (0.45F); this.animTransZ += (0F);
  				this.ArmLeft.xRot = -0.6F;
  	  			this.ArmLeft.zRot = 0.3F;
  	  			this.ArmRight.xRot = -0.6F;
  	  			this.ArmRight.zRot = -0.3F;
  				this.BodyMain.xRot = 0.3F;
  				this.Head.xRot -= 0.35F;
  				addk1 = -2F;
  				addk2 = -2F;
  				this.LegLeft.yRot = 0.15F;
  				this.LegRight.yRot = -0.15F;
  				this.LegLeft.zRot = 1.2F;
  				this.LegRight.zRot = -1.2F; 				
  			}			
  		}
	    
	    //leg motion
	    this.LegLeft.xRot = addk1;
	    this.LegRight.xRot = addk2;
	    
	    //攻擊時順便將左手指向對方	    
	    if (ent.getAttackTick() > 15)
	    {
	    	this.ArmLeft.xRot = f4 / 57.29578F - 1.5F;
	    	this.ArmRight.zRot = 0.7F; 
	    	this.ArmRight.xRot = 0.4F; 
	    }
	    
	    //swing arm
	  	float f6 = ent.getSwingTime(f2 - (int)f2);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight.xRot = -0.5F;
	        this.ArmRight.yRot = 0F;
	        this.ArmRight.zRot = 0.2F;
	        this.ArmRight.xRot += -f8 * 80.0F * Values.N.DIV_PI_180;
	        this.ArmRight.yRot += -f7 * 20.0F * Values.N.DIV_PI_180 + 0.2F;
	        this.ArmRight.zRot += -f8 * 20.0F * Values.N.DIV_PI_180;
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

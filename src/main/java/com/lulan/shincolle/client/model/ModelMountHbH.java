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

public class ModelMountHbH<T extends Entity> extends ShipModel<T>
{

	public ModelPart BodyMain;
	public ModelPart EquipBaseR;
	public ModelPart Back01;
	public ModelPart Back02;
	public ModelPart EquipBaseL;
	public ModelPart EquipR01;
	public ModelPart Back01b;
	public ModelPart Back02b;
	public ModelPart Back02c;
	public ModelPart Back02d;
	public ModelPart Back02e;
	public ModelPart Neck;
	public ModelPart Head;
	public ModelPart Jaw;
	public ModelPart HeadTooth;
	public ModelPart Road01;
	public ModelPart Road02;
	public ModelPart Road03;
	public ModelPart Road04;
	public ModelPart Road05;
	public ModelPart JawTooth;
	public ModelPart EquipL01;
	public ModelPart EquipCannonPlate;
	public ModelPart CanonBase;
	public ModelPart EquipCannon01;
	public ModelPart Neck_1;
	public ModelPart Head_1;
	public ModelPart Jaw_1;
	public ModelPart Road01u;
	public ModelPart Road01v;
	public ModelPart HeadTooth_1;
	public ModelPart JawTooth_1;
	public ModelPart Road02u;
	public ModelPart Road03u;
	public ModelPart Road02v;
	public ModelPart Road03v;
	public ModelPart GlowBodyMain;
	public ModelPart GlowEquipBaseL;
	public ModelPart GlowEquipL01;
	public ModelPart GlowEquipCannonPlate;
	public ModelPart GlowBack02;
	public ModelPart GlowBack02b;
	public ModelPart GlowBack02c;
	public ModelPart GlowBack02d;
	public ModelPart GlowBack02e;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ModelPart GlowJaw;
	public ModelPart GlowCanonBase;
	public ModelPart GlowNeck_1;
	public ModelPart GlowHead_1;
	public ModelPart GlowJaw_1;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-9.0F, -2.0F, 14.0F, 18.0F, 10.0F, 9.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Back01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 13.0F, 10.0F, 13.0F), PartPose.offsetAndRotation(1.0F, -7.0F, 19.0F, 0.0F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("Back01b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 13.0F, 10.0F, 13.0F), PartPose.offset(0.0F, -10.0F, 0.0F));
		PartDefinition partdef3 = partdef0.addOrReplaceChild("EquipBaseL", CubeListBuilder.create().addBox(-6.0F, -4.0F, -7.0F, 11.0F, 11.0F, 21.0F), PartPose.offsetAndRotation(14.5F, 2.0F, 5.0F, 0.0F, -0.05235987755982988F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("EquipL01", CubeListBuilder.create().addBox(-6.0F, 0.0F, -7.0F, 10.0F, 4.0F, 20.0F), PartPose.offset(0.5F, -8.0F, 1.0F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("CanonBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 7.0F, 9.0F, 7.0F), PartPose.offset(-3.5F, -9.0F, 3.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("Neck_1", CubeListBuilder.create().addBox(-4.0F, -6.0F, -0.5F, 8.0F, 8.0F, 9.0F), PartPose.offsetAndRotation(3.5F, -1.0F, 3.0F, -0.2617993877991494F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("Jaw_1", CubeListBuilder.create().mirror().addBox(-5.0F, -1.0F, -15.0F, 10.0F, 4.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -5.0F, 3.0F, 0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef8 = partdef6.addOrReplaceChild("Head_1", CubeListBuilder.create().addBox(-5.0F, -4.0F, -17.0F, 10.0F, 4.0F, 17.0F), PartPose.offsetAndRotation(0.1F, -2.5F, 3.0F, -0.36425021489121656F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef4.addOrReplaceChild("EquipCannonPlate", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 3.0F, 1.0F), PartPose.offset(-3.0F, 1.8F, -7.5F));
		PartDefinition partdef10 = partdef0.addOrReplaceChild("Back02", CubeListBuilder.create().addBox(-14.0F, 0.0F, 0.0F, 13.0F, 10.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 19.0F, 0.0F, -0.13962634015954636F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("Back02b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 13.0F, 10.0F, 13.0F), PartPose.offset(-14.0F, -10.0F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("Back02c", CubeListBuilder.create().addBox(-4.0F, -4.0F, -9.0F, 8.0F, 8.0F, 9.0F), PartPose.offsetAndRotation(3.5F, 2.0F, 8.0F, -0.44F, 1.22F, 0.0F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("Back02d", CubeListBuilder.create().addBox(-4.0F, -4.0F, -9.0F, 8.0F, 8.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.5235987755982988F, -0.6981317007977318F, -0.2617993877991494F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("Back02e", CubeListBuilder.create().addBox(-4.0F, -4.0F, -9.0F, 8.0F, 8.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.3490658503988659F, -0.3490658503988659F, 0.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -10.0F, -0.17453292519943295F, 0.08726646259971647F, -0.08726646259971647F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-5.0F, -4.0F, -17.0F, 10.0F, 4.0F, 17.0F), PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef15.addOrReplaceChild("Jaw", CubeListBuilder.create().mirror().addBox(-5.0F, -1.0F, -15.0F, 10.0F, 4.0F, 14.0F), PartPose.offsetAndRotation(0.0F, -0.8F, -3.0F, 0.6283185307179586F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef0.addOrReplaceChild("EquipBaseR", CubeListBuilder.create().addBox(-6.0F, -4.0F, -7.0F, 11.0F, 11.0F, 21.0F), PartPose.offsetAndRotation(-13.5F, 2.0F, 5.0F, 0.0F, 0.05235987755982988F, 0.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("EquipR01", CubeListBuilder.create().addBox(-5.0F, 0.0F, -7.0F, 10.0F, 4.0F, 20.0F), PartPose.offset(-0.5F, -8.0F, 1.0F));
		PartDefinition partdef20 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("GlowEquipBaseL", CubeListBuilder.create(), PartPose.offsetAndRotation(14.5F, 2.0F, 5.0F, 0.0F, -0.05235987755982988F, 0.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("GlowEquipL01", CubeListBuilder.create(), PartPose.offset(0.5F, -8.0F, 1.0F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("GlowEquipCannonPlate", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 3.0F, 1.0F), PartPose.offset(-3.0F, 1.8F, -7.5F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("EquipCannon01", CubeListBuilder.create().addBox(0.0F, 0.0F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(1.5F, 1.0F, 0.5F, -0.31869712141416456F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef25 = partdef22.addOrReplaceChild("GlowCanonBase", CubeListBuilder.create(), PartPose.offset(-3.5F, -9.0F, 3.0F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("GlowNeck_1", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5F, -1.0F, 3.0F, -0.2617993877991494F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("GlowHead_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1F, -2.5F, 3.0F, -0.36425021489121656F, 0.0F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("HeadTooth_1", CubeListBuilder.create().addBox(-4.5F, 0.0F, -6.5F, 9.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -8.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef29 = partdef26.addOrReplaceChild("GlowJaw_1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -5.0F, 3.0F, 0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("JawTooth_1", CubeListBuilder.create().addBox(-4.5F, 0.0F, -14.0F, 9.0F, 3.0F, 12.0F), PartPose.offsetAndRotation(0.1F, -0.6F, -0.3F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef26.addOrReplaceChild("Road01u", CubeListBuilder.create().addBox(-4.5F, 0.0F, -12.0F, 9.0F, 1.0F, 12.0F), PartPose.offset(0.0F, -4.7F, -3.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("Road02u", CubeListBuilder.create().addBox(-4.5F, 0.0F, -12.0F, 9.0F, 1.0F, 12.0F), PartPose.offset(0.0F, 0.0F, -12.0F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("Road03u", CubeListBuilder.create().addBox(-4.5F, 0.0F, -12.0F, 9.0F, 1.0F, 12.0F), PartPose.offset(0.0F, 0.0F, -12.0F));
		PartDefinition partdef34 = partdef26.addOrReplaceChild("Road01v", CubeListBuilder.create().addBox(-4.5F, 0.0F, -12.0F, 9.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 3.2F, -2.4F, -0.0349F, 0.0F, -3.141592653589793F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("Road02v", CubeListBuilder.create().addBox(-4.5F, 0.0F, -12.0F, 9.0F, 1.0F, 12.0F), PartPose.offset(0.0F, 0.0F, -12.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("Road03v", CubeListBuilder.create().addBox(-4.5F, 0.0F, -12.0F, 9.0F, 1.0F, 12.0F), PartPose.offset(0.0F, 0.0F, -12.0F));
		PartDefinition partdef37 = partdef20.addOrReplaceChild("GlowBack02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0F, 19.0F, 0.0F, -0.13962634015954636F, 0.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("GlowBack02b", CubeListBuilder.create(), PartPose.offset(-14.0F, -10.0F, 0.0F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("GlowBack02c", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5F, 2.0F, 8.0F, -0.44F, 1.22F, 0.0F));
		PartDefinition partdef40 = partdef39.addOrReplaceChild("GlowBack02d", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.5235987755982988F, -0.6981317007977318F, -0.2617993877991494F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("GlowBack02e", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.3490658503988659F, -0.3490658503988659F, 0.0F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -10.0F, -0.17453292519943295F, 0.08726646259971647F, -0.08726646259971647F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("HeadTooth", CubeListBuilder.create().addBox(-4.5F, 0.0F, -6.5F, 9.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -8.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef45 = partdef43.addOrReplaceChild("Road01", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 1.0F, 14.0F), PartPose.offset(0.0F, -5.0F, -23.0F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("Road02", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 1.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 14.0F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("Road03", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 1.0F, 14.0F), PartPose.offsetAndRotation(0.4F, 0.1F, 12.0F, 0.08726646259971647F, -0.36425021489121656F, -0.017453292519943295F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("Road04", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 10.0F, 1.0F, 14.0F), PartPose.offsetAndRotation(-2.6F, 0.1F, 10.0F, 0.03839724354387525F, 0.8651597102135892F, 0.013962634015954637F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("Road05", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 1.0F, 14.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 14.0F, -0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef50 = partdef42.addOrReplaceChild("GlowJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.8F, -3.0F, 0.6283185307179586F, 0.0F, 0.0F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("JawTooth", CubeListBuilder.create().addBox(-4.5F, 0.0F, -14.0F, 9.0F, 3.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -1.6F, -0.3F, -0.17453292519943295F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	public ModelMountHbH(ModelPart root)
	{
		this.Neck = root.getChild("BodyMain").getChild("Back02").getChild("Back02b").getChild("Back02c").getChild("Back02d").getChild("Back02e").getChild("Neck");
		this.Back02e = root.getChild("BodyMain").getChild("Back02").getChild("Back02b").getChild("Back02c").getChild("Back02d").getChild("Back02e");
		this.JawTooth_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowCanonBase").getChild("GlowNeck_1").getChild("GlowJaw_1").getChild("JawTooth_1");
		this.Jaw_1 = root.getChild("BodyMain").getChild("EquipBaseL").getChild("EquipL01").getChild("CanonBase").getChild("Neck_1").getChild("Jaw_1");
		this.Back01 = root.getChild("BodyMain").getChild("Back01");
		this.CanonBase = root.getChild("BodyMain").getChild("EquipBaseL").getChild("EquipL01").getChild("CanonBase");
		this.Road03v = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowCanonBase").getChild("GlowNeck_1").getChild("Road01v").getChild("Road02v").getChild("Road03v");
		this.Road03 = root.getChild("GlowBodyMain").getChild("GlowBack02").getChild("GlowBack02b").getChild("GlowBack02c").getChild("GlowBack02d").getChild("GlowBack02e").getChild("GlowNeck").getChild("GlowHead").getChild("Road01").getChild("Road02").getChild("Road03");
		this.HeadTooth = root.getChild("GlowBodyMain").getChild("GlowBack02").getChild("GlowBack02b").getChild("GlowBack02c").getChild("GlowBack02d").getChild("GlowBack02e").getChild("GlowNeck").getChild("GlowHead").getChild("HeadTooth");
		this.Road02u = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowCanonBase").getChild("GlowNeck_1").getChild("Road01u").getChild("Road02u");
		this.Back01b = root.getChild("BodyMain").getChild("Back01").getChild("Back01b");
		this.Back02b = root.getChild("BodyMain").getChild("Back02").getChild("Back02b");
		this.Neck_1 = root.getChild("BodyMain").getChild("EquipBaseL").getChild("EquipL01").getChild("CanonBase").getChild("Neck_1");
		this.Head_1 = root.getChild("BodyMain").getChild("EquipBaseL").getChild("EquipL01").getChild("CanonBase").getChild("Neck_1").getChild("Head_1");
		this.EquipBaseL = root.getChild("BodyMain").getChild("EquipBaseL");
		this.Road01u = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowCanonBase").getChild("GlowNeck_1").getChild("Road01u");
		this.EquipCannon01 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowEquipCannonPlate").getChild("EquipCannon01");
		this.Road01v = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowCanonBase").getChild("GlowNeck_1").getChild("Road01v");
		this.EquipCannonPlate = root.getChild("BodyMain").getChild("EquipBaseL").getChild("EquipL01").getChild("EquipCannonPlate");
		this.EquipL01 = root.getChild("BodyMain").getChild("EquipBaseL").getChild("EquipL01");
		this.Back02 = root.getChild("BodyMain").getChild("Back02");
		this.Road02 = root.getChild("GlowBodyMain").getChild("GlowBack02").getChild("GlowBack02b").getChild("GlowBack02c").getChild("GlowBack02d").getChild("GlowBack02e").getChild("GlowNeck").getChild("GlowHead").getChild("Road01").getChild("Road02");
		this.EquipBaseR = root.getChild("BodyMain").getChild("EquipBaseR");
		this.EquipR01 = root.getChild("BodyMain").getChild("EquipBaseR").getChild("EquipR01");
		this.Road05 = root.getChild("GlowBodyMain").getChild("GlowBack02").getChild("GlowBack02b").getChild("GlowBack02c").getChild("GlowBack02d").getChild("GlowBack02e").getChild("GlowNeck").getChild("GlowHead").getChild("Road01").getChild("Road02").getChild("Road03").getChild("Road04").getChild("Road05");
		this.Road01 = root.getChild("GlowBodyMain").getChild("GlowBack02").getChild("GlowBack02b").getChild("GlowBack02c").getChild("GlowBack02d").getChild("GlowBack02e").getChild("GlowNeck").getChild("GlowHead").getChild("Road01");
		this.Back02d = root.getChild("BodyMain").getChild("Back02").getChild("Back02b").getChild("Back02c").getChild("Back02d");
		this.Back02c = root.getChild("BodyMain").getChild("Back02").getChild("Back02b").getChild("Back02c");
		this.Road02v = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowCanonBase").getChild("GlowNeck_1").getChild("Road01v").getChild("Road02v");
		this.BodyMain = root.getChild("BodyMain");
		this.JawTooth = root.getChild("GlowBodyMain").getChild("GlowBack02").getChild("GlowBack02b").getChild("GlowBack02c").getChild("GlowBack02d").getChild("GlowBack02e").getChild("GlowNeck").getChild("GlowJaw").getChild("JawTooth");
		this.Head = root.getChild("BodyMain").getChild("Back02").getChild("Back02b").getChild("Back02c").getChild("Back02d").getChild("Back02e").getChild("Neck").getChild("Head");
		this.HeadTooth_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowCanonBase").getChild("GlowNeck_1").getChild("GlowHead_1").getChild("HeadTooth_1");
		this.Jaw = root.getChild("BodyMain").getChild("Back02").getChild("Back02b").getChild("Back02c").getChild("Back02d").getChild("Back02e").getChild("Neck").getChild("Jaw");
		this.Road04 = root.getChild("GlowBodyMain").getChild("GlowBack02").getChild("GlowBack02b").getChild("GlowBack02c").getChild("GlowBack02d").getChild("GlowBack02e").getChild("GlowNeck").getChild("GlowHead").getChild("Road01").getChild("Road02").getChild("Road03").getChild("Road04");
		this.Road03u = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowCanonBase").getChild("GlowNeck_1").getChild("Road01u").getChild("Road02u").getChild("Road03u");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowEquipBaseL = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL");
		this.GlowEquipL01 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01");
		this.GlowEquipCannonPlate = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowEquipCannonPlate");
		this.GlowBack02 = root.getChild("GlowBodyMain").getChild("GlowBack02");
		this.GlowBack02b = root.getChild("GlowBodyMain").getChild("GlowBack02").getChild("GlowBack02b");
		this.GlowBack02c = root.getChild("GlowBodyMain").getChild("GlowBack02").getChild("GlowBack02b").getChild("GlowBack02c");
		this.GlowBack02d = root.getChild("GlowBodyMain").getChild("GlowBack02").getChild("GlowBack02b").getChild("GlowBack02c").getChild("GlowBack02d");
		this.GlowBack02e = root.getChild("GlowBodyMain").getChild("GlowBack02").getChild("GlowBack02b").getChild("GlowBack02c").getChild("GlowBack02d").getChild("GlowBack02e");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowBack02").getChild("GlowBack02b").getChild("GlowBack02c").getChild("GlowBack02d").getChild("GlowBack02e").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowBack02").getChild("GlowBack02b").getChild("GlowBack02c").getChild("GlowBack02d").getChild("GlowBack02e").getChild("GlowNeck").getChild("GlowHead");
		this.GlowJaw = root.getChild("GlowBodyMain").getChild("GlowBack02").getChild("GlowBack02b").getChild("GlowBack02c").getChild("GlowBack02d").getChild("GlowBack02e").getChild("GlowNeck").getChild("GlowJaw");
		this.GlowCanonBase = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowCanonBase");
		this.GlowNeck_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowCanonBase").getChild("GlowNeck_1");
		this.GlowHead_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowCanonBase").getChild("GlowNeck_1").getChild("GlowHead_1");
		this.GlowJaw_1 = root.getChild("GlowBodyMain").getChild("GlowEquipBaseL").getChild("GlowEquipL01").getChild("GlowCanonBase").getChild("GlowNeck_1").getChild("GlowJaw_1");
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

	@Override
	public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)
	{
		this.captureAnimParms(entity, f, f1, f2, f3, f4);

    	//FIX: head rotation bug while riding
    	if (f3 <= -180F) { f3 += 360F; }
    	else if (f3 >= 180F) { f3 -= 360F; }
    	
    	
    	RenderHelper.animScale(this, 0.8F, 0.8F, 0.8F);
this.animTransX += (0F); this.animTransY += (1.05F); this.animTransZ += (0F);
    	
    	//main body

		
		IShipEmotion ent = (IShipEmotion)entity;
		  
		motionHumanPos(f, f1, f2, f3, f4, ent);
    
	}

	private void motionHumanPos(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{
   
  		float angleX = Mth.cos(f2*0.08F);
  		
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.025F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		if (ent.getIsSitting())
  		{
this.animTransX += (0F); this.animTransY += (0.12F); this.animTransZ += (0F);
    	}
  		
	    //正常站立動作
	  	//嘴巴
	  	this.Jaw.xRot = angleX * 0.1F + 0.7F;
	  	this.GlowJaw.xRot = this.Jaw.xRot;
	    //cannon
	    this.EquipCannon01.xRot = angleX * 0.08F - 0.32F;
	    
//	    if (ent.getStateEmotion(ID.S.Emotion) > 0)
//	    {
//	    	this.ArmRight01.xRot = -1.57F;
//	    }
  	
	}

}

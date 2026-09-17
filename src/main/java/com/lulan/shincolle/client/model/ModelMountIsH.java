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

public class ModelMountIsH<T extends Entity> extends ShipModel<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart Cannon01a;
	public ModelPart Cannon01b;
	public ModelPart Body01;
	public ModelPart Body04;
	public ModelPart Body05;
	public ModelPart LegFL01;
	public ModelPart LegFR01;
	public ModelPart Head;
	public ModelPart Jaw;
	public ModelPart NeckFront;
	public ModelPart HeadTooth;
	public ModelPart HeadCannon;
	public ModelPart TopCannonBase;
	public ModelPart TopCannon01a;
	public ModelPart TopCannon01b;
	public ModelPart TopCannonBase02;
	public ModelPart TopCannon02a;
	public ModelPart TopCannon03a;
	public ModelPart TopCannon04a;
	public ModelPart TopCannon02b;
	public ModelPart TopCannon03b;
	public ModelPart TopCannon04b;
	public ModelPart JawTooth;
	public ModelPart Tongue01;
	public ModelPart Tongue02;
	public ModelPart Tongue03;
	public ModelPart Cannon02a;
	public ModelPart Cannon03a;
	public ModelPart Cannon02b;
	public ModelPart Cannon03b;
	public ModelPart Body02;
	public ModelPart Body03;
	public ModelPart LegBR01;
	public ModelPart LegBL01;
	public ModelPart LegBR02;
	public ModelPart LegBR03;
	public ModelPart LegFR02;
	public ModelPart LegFR03;
	public ModelPart LegFL02;
	public ModelPart LegFL03;
	public ModelPart LegBL02;
	public ModelPart LegBL03;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ModelPart GlowJaw;
	public ModelPart GlowTopCannonBase;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, -8F, 5F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Body04", CubeListBuilder.create().addBox(-7.5F, -6.0F, 0.0F, 15.0F, 15.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 3.0F, -3.0F, -0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("Body01", CubeListBuilder.create().addBox(-8.5F, -12.0F, -6.0F, 17.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -1.0F, -0.5F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("Body02", CubeListBuilder.create().addBox(-8.0F, -12.0F, -6.0F, 16.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 7.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("Body03", CubeListBuilder.create().addBox(-7.5F, -12.0F, -6.0F, 15.0F, 12.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 10.0F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("LegFL01", CubeListBuilder.create().addBox(0.0F, -4.5F, -9.0F, 3.0F, 9.0F, 12.0F), PartPose.offsetAndRotation(9.0F, 13.0F, -19.0F, 0.8726646259971648F, -0.13962634015954636F, 0.05235987755982988F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("LegFL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(1.6F, -2.0F, -8.5F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("LegFL03", CubeListBuilder.create().addBox(-0.5F, -6.0F, 0.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 10.2F, 1.0F, -1.0471975511965976F, 0.0F, 0.0F));
		PartDefinition partdef8 = partdef0.addOrReplaceChild("LegFR01", CubeListBuilder.create().mirror().addBox(-3.0F, -4.5F, -9.0F, 3.0F, 9.0F, 12.0F), PartPose.offsetAndRotation(-9.0F, 13.0F, -19.0F, 0.8726646259971648F, 0.13962634015954636F, -0.05235987755982988F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("LegBL02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(-1.6F, -2.0F, -8.5F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("LegBL03", CubeListBuilder.create().mirror().addBox(-0.5F, -6.0F, 0.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 10.2F, 1.0F, -1.0471975511965976F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef0.addOrReplaceChild("Body05", CubeListBuilder.create().addBox(-6.5F, -6.0F, 0.0F, 13.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 9.4F, 4.5F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("LegBR01", CubeListBuilder.create().addBox(0.0F, -4.5F, -9.0F, 3.0F, 9.0F, 12.0F), PartPose.offsetAndRotation(-6.0F, 4.0F, 5.0F, 1.0471975511965976F, 3.001966313430247F, -0.05235987755982988F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("LegBR02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(1.6F, -2.0F, -8.5F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("LegBR03", CubeListBuilder.create().addBox(-0.5F, -6.0F, 0.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 10.2F, 1.0F, -1.0471975511965976F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef11.addOrReplaceChild("LegBL01", CubeListBuilder.create().mirror().addBox(-3.0F, -4.5F, -9.0F, 3.0F, 9.0F, 12.0F), PartPose.offsetAndRotation(6.0F, 4.0F, 5.0F, 1.0471975511965976F, -3.001966313430247F, 0.05235987755982988F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("LegFR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(-1.6F, -2.0F, -8.5F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("LegFR03", CubeListBuilder.create().mirror().addBox(-0.5F, -6.0F, 0.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 10.2F, 1.0F, -1.0471975511965976F, 0.0F, 0.0F));
		PartDefinition partdef18 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-7.5F, -7.5F, -14.0F, 15.0F, 15.0F, 14.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.18203784098300857F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("Jaw", CubeListBuilder.create().addBox(-9.5F, 0.0F, -15.0F, 19.0F, 7.0F, 19.0F), PartPose.offsetAndRotation(0.0F, 4.0F, -11.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef18.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-9.5F, -7.0F, -22.0F, 19.0F, 10.0F, 24.0F), PartPose.offsetAndRotation(0.0F, -9.0F, -4.0F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("TopCannonBase", CubeListBuilder.create().addBox(-7.5F, -8.0F, -8.0F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -5.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("TopCannonBase02", CubeListBuilder.create().addBox(-5.0F, -6.0F, 0.0F, 10.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -0.5F, -0.7F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef23 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, -8F, 5F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.18203784098300857F, 0.0F, 0.0F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.0F, -4.0F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("HeadTooth", CubeListBuilder.create().addBox(-9.0F, 0.0F, -6.5F, 18.0F, 4.0F, 15.0F), PartPose.offsetAndRotation(0.0F, 2.5F, -15.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef25.addOrReplaceChild("HeadCannon", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 16.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -2.9F, -21.0F, -1.6580627893946132F, 0.0F, 0.0F));
		PartDefinition partdef28 = partdef25.addOrReplaceChild("GlowTopCannonBase", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -6.0F, -5.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("TopCannon01a", CubeListBuilder.create().addBox(-1.5F, -1.5F, -6.0F, 3.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(3.2F, -4.0F, -6.7F, -0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("TopCannon02a", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 7.0F), PartPose.offset(0.0F, 0.8F, -7.0F));
		PartDefinition partdef31 = partdef29.addOrReplaceChild("TopCannon03a", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.9F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("TopCannon04a", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition partdef33 = partdef28.addOrReplaceChild("TopCannon01b", CubeListBuilder.create().addBox(-1.5F, -1.5F, -6.0F, 3.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-3.2F, -4.0F, -6.7F, -0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("TopCannon02b", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 7.0F), PartPose.offset(0.0F, 0.8F, -7.0F));
		PartDefinition partdef35 = partdef33.addOrReplaceChild("TopCannon03b", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 18.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -5.9F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("TopCannon04b", CubeListBuilder.create().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition partdef37 = partdef24.addOrReplaceChild("GlowJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, -11.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("JawTooth", CubeListBuilder.create().addBox(-9.0F, 0.0F, -14.0F, 18.0F, 3.0F, 14.0F), PartPose.offsetAndRotation(0.0F, -1.7F, -0.3F, -0.08726646259971647F, -0.02234021442552742F, 0.0F));
		PartDefinition partdef39 = partdef37.addOrReplaceChild("Tongue01", CubeListBuilder.create().mirror().addBox(-7.0F, 0.0F, -10.0F, 14.0F, 4.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.3839724354387525F, 0.3490658503988659F, -0.05235987755982988F));
		PartDefinition partdef40 = partdef39.addOrReplaceChild("Tongue02", CubeListBuilder.create().addBox(-6.0F, -0.7F, -7.0F, 12.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 1.0F, -10.0F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("Tongue03", CubeListBuilder.create().addBox(-5.0F, -0.3F, -6.0F, 10.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -0.2F, -6.7F, 0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef42 = partdef24.addOrReplaceChild("NeckFront", CubeListBuilder.create().addBox(-6.5F, 0.0F, 0.0F, 13.0F, 14.0F, 2.0F), PartPose.offset(0.0F, -8.5F, -16.0F));
		PartDefinition partdef43 = partdef23.addOrReplaceChild("Cannon01a", CubeListBuilder.create().addBox(0.0F, -2.5F, -2.5F, 7.0F, 5.0F, 5.0F), PartPose.offset(7.0F, 2.0F, -10.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("Cannon02a", CubeListBuilder.create().addBox(0.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(3.0F, -0.5F, 2.0F, 0.20943951023931953F, -0.17453292519943295F, 0.0F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("Cannon03a", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(4.0F, 0.0F, -7.0F, -1.7453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef46 = partdef23.addOrReplaceChild("Cannon01b", CubeListBuilder.create().addBox(-7.0F, -2.5F, -2.5F, 7.0F, 5.0F, 5.0F), PartPose.offset(-7.0F, 2.0F, -10.0F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("Cannon02b", CubeListBuilder.create().mirror().addBox(-8.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(-3.0F, -0.5F, 2.0F, 0.20943951023931953F, 0.17453292519943295F, 0.0F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("Cannon03b", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(-4.0F, 0.0F, -7.0F, -1.7453292519943295F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	public ModelMountIsH(ModelPart root)
	{
		this.LegBR01 = root.getChild("BodyMain").getChild("Body05").getChild("LegBR01");
		this.Cannon01b = root.getChild("GlowBodyMain").getChild("Cannon01b");
		this.NeckFront = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("NeckFront");
		this.LegFL02 = root.getChild("BodyMain").getChild("LegFL01").getChild("LegFL02");
		this.Jaw = root.getChild("BodyMain").getChild("Neck").getChild("Jaw");
		this.TopCannon01a = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowTopCannonBase").getChild("TopCannon01a");
		this.TopCannon03b = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowTopCannonBase").getChild("TopCannon01b").getChild("TopCannon03b");
		this.HeadTooth = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadTooth");
		this.TopCannon02b = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowTopCannonBase").getChild("TopCannon01b").getChild("TopCannon02b");
		this.TopCannon03a = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowTopCannonBase").getChild("TopCannon01a").getChild("TopCannon03a");
		this.LegBL03 = root.getChild("BodyMain").getChild("LegFR01").getChild("LegBL02").getChild("LegBL03");
		this.Cannon03a = root.getChild("GlowBodyMain").getChild("Cannon01a").getChild("Cannon02a").getChild("Cannon03a");
		this.TopCannon04b = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowTopCannonBase").getChild("TopCannon01b").getChild("TopCannon03b").getChild("TopCannon04b");
		this.BodyMain = root.getChild("BodyMain");
		this.Body04 = root.getChild("BodyMain").getChild("Body04");
		this.LegBL01 = root.getChild("BodyMain").getChild("Body05").getChild("LegBL01");
		this.TopCannon02a = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowTopCannonBase").getChild("TopCannon01a").getChild("TopCannon02a");
		this.LegBR02 = root.getChild("BodyMain").getChild("Body05").getChild("LegBR01").getChild("LegBR02");
		this.LegBL02 = root.getChild("BodyMain").getChild("LegFR01").getChild("LegBL02");
		this.LegFR02 = root.getChild("BodyMain").getChild("Body05").getChild("LegBL01").getChild("LegFR02");
		this.HeadCannon = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("HeadCannon");
		this.TopCannonBase02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("TopCannonBase").getChild("TopCannonBase02");
		this.JawTooth = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw").getChild("JawTooth");
		this.LegFL03 = root.getChild("BodyMain").getChild("LegFL01").getChild("LegFL02").getChild("LegFL03");
		this.Body01 = root.getChild("BodyMain").getChild("Body01");
		this.Cannon02b = root.getChild("GlowBodyMain").getChild("Cannon01b").getChild("Cannon02b");
		this.Cannon03b = root.getChild("GlowBodyMain").getChild("Cannon01b").getChild("Cannon02b").getChild("Cannon03b");
		this.LegFL01 = root.getChild("BodyMain").getChild("LegFL01");
		this.LegFR01 = root.getChild("BodyMain").getChild("LegFR01");
		this.LegFR03 = root.getChild("BodyMain").getChild("Body05").getChild("LegBL01").getChild("LegFR02").getChild("LegFR03");
		this.Body03 = root.getChild("BodyMain").getChild("Body01").getChild("Body02").getChild("Body03");
		this.Cannon02a = root.getChild("GlowBodyMain").getChild("Cannon01a").getChild("Cannon02a");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.TopCannon01b = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowTopCannonBase").getChild("TopCannon01b");
		this.TopCannonBase = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("TopCannonBase");
		this.Body05 = root.getChild("BodyMain").getChild("Body05");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.Cannon01a = root.getChild("GlowBodyMain").getChild("Cannon01a");
		this.Body02 = root.getChild("BodyMain").getChild("Body01").getChild("Body02");
		this.Tongue03 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw").getChild("Tongue01").getChild("Tongue02").getChild("Tongue03");
		this.TopCannon04a = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowTopCannonBase").getChild("TopCannon01a").getChild("TopCannon03a").getChild("TopCannon04a");
		this.Tongue01 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw").getChild("Tongue01");
		this.Tongue02 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw").getChild("Tongue01").getChild("Tongue02");
		this.LegBR03 = root.getChild("BodyMain").getChild("Body05").getChild("LegBR01").getChild("LegBR02").getChild("LegBR03");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.GlowJaw = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw");
		this.GlowTopCannonBase = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowTopCannonBase");
	}

	/** * This is a helper function from Tabula to set the rotation of model parts */ public void setRotateAngle(ModelPart modelRenderer, float x, float y, float z)
	{

        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    
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

	@Override
	public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)
	{
		this.captureAnimParms(entity, f, f1, f2, f3, f4);

    	//FIX: head rotation bug while riding
    	if (f3 <= -180F) { f3 += 360F; }
    	else if (f3 >= 180F) { f3 -= 360F; }
    	
    	
    	RenderHelper.animScale(this, 0.7F, 0.7F, 0.7F);
this.animTransX += (0F); this.animTransY += (0.7F); this.animTransZ += (0F);
    	
    	//main body

		
		IShipEmotion ent = (IShipEmotion)entity;
		  
		motionHumanPos(f, f1, f2, f3, f4, ent);
    
	}

	private void motionHumanPos(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{
   
  		float angleX = Mth.cos(f2 * 0.08F);
  		float angleX2 = Mth.cos(f2 * 0.5F + 0.3F);
  		float angleX3 = Mth.cos(f2 * 0.5F + 0.6F);
  		float angleX4 = Mth.cos(f2 * 0.5F + 0.9F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.7F;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.7F;
  		float addk1 = angleAdd1 * 0.5F;
  		float addk2 = angleAdd2 * 0.5F;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.025F + 0.025F); this.animTransZ += (0F);
    	}

  		//leg
  		this.LegFL01.xRot = addk1 + 1.04F;
  		this.LegFR01.xRot = addk2 + 1.04F;
  		this.LegBL01.xRot = addk1 + 1.04F;
  		this.LegBR01.xRot = addk2 + 1.04F;
	    //idle
	  	this.Jaw.xRot = angleX * 0.075F + 0.26F;
	  	this.Tongue01.xRot = angleX2 * 0.05F - 0.38F;
	  	this.Tongue02.xRot = -angleX3 * 0.08F + 0.52F;
	  	this.Tongue03.xRot = -angleX4 * 0.05F + 0.69F;
	    //cannon
	    this.HeadCannon.xRot = f4 * 0.01F - 1.68F;
	    this.Cannon03a.xRot = f4 * 0.01F - 1.74F;
	    this.Cannon03b.xRot = f4 * 0.01F - 1.7F;
	    this.TopCannon01a.xRot = f4 * 0.01F - 0.2F;
	    this.TopCannon01b.xRot = f4 * 0.01F - 0.2F;
	    this.TopCannonBase.yRot = f3 * 0.01F;
	    
	    //rider 2 on
	    if (ent.getStateEmotion(ID.S.Emotion) > 0)
	    {
	    	this.Jaw.xRot = 0.7F;
	    }
	    
	    //sync rotate
	    this.GlowJaw.xRot = this.Jaw.xRot;
	    this.GlowTopCannonBase.yRot = this.TopCannonBase.yRot;
  	
	}

}

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

public class ModelBattleshipRe<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Cloth;
	public ModelPart Neck;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart ArmLeft02;
	public ModelPart ArmRight02;
	public ModelPart BagMain;
	public ModelPart TailBase;
	public ModelPart Butt;
	public ModelPart Cloth2;
	public ModelPart Head;
	public ModelPart Ear01;
	public ModelPart Ear02;
	public ModelPart Hair;
	public ModelPart Hair01;
	public ModelPart HairU01;
	public ModelPart Cap;
	public ModelPart Cap2;
	public ModelPart Ahoke;
	public ModelPart BoobM;
	public ModelPart PalmLeft;
	public ModelPart PalmRight;
	public ModelPart BagMain2;
	public ModelPart BagStrap1;
	public ModelPart BagStrap2;
	public ModelPart Tail1;
	public ModelPart TailBack0;
	public ModelPart Tail2;
	public ModelPart TailBack1;
	public ModelPart Tail3;
	public ModelPart TailBack2;
	public ModelPart Tail4;
	public ModelPart TailBack3;
	public ModelPart Tail5;
	public ModelPart TailBack4;
	public ModelPart Tail6;
	public ModelPart TailBack5;
	public ModelPart TailHeadBase;
	public ModelPart TailBack6;
	public ModelPart TailJaw1;
	public ModelPart TailHead1;
	public ModelPart TailHeadCL1;
	public ModelPart TailHeadCR1;
	public ModelPart TailJawT01;
	public ModelPart TailJaw2;
	public ModelPart TailJaw3;
	public ModelPart TailHead2;
	public ModelPart TailHeadT01;
	public ModelPart TailHeadC1;
	public ModelPart TailHead3;
	public ModelPart TailHeadC2;
	public ModelPart TailHeadC3;
	public ModelPart TailHeadC4;
	public ModelPart TailHeadCL2;
	public ModelPart TailHeadCL3;
	public ModelPart TailHeadCR2;
	public ModelPart TailHeadCR3;
	public ModelPart LegRight;
	public ModelPart LegLeft;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ModelPart GlowTailBase;
	public ModelPart GlowTail1;
	public ModelPart GlowTail2;
	public ModelPart GlowTail3;
	public ModelPart GlowTail4;
	public ModelPart GlowTail5;
	public ModelPart GlowTail6;
	public ModelPart GlowTailHeadBase;
	public ModelPart GlowTailHead1;
	public ModelPart GlowTailJaw1;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-7.0F, -9.0F, -4.0F, 14.0F, 15.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offsetAndRotation(4.5F, -8.5F, -0.5F, 0.2617993877991494F, 0.0F, -0.4363323129985824F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-6F, 0.0F, -6F, 6.0F, 7.0F, 6.0F), PartPose.offset(6F, 10F, 3F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("PalmLeft", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F), PartPose.offset(-3F, 7F, -3F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(3.5F, -9.5F, -3.0F, -0.7853981633974483F, -0.12217304763960307F, -0.08726646259971647F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("BagMain", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 14.0F, 12.0F, 7.0F), PartPose.offsetAndRotation(3.0F, -13.0F, 6.5F, -0.2617993877991494F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("BagStrap2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -15.0F, 3.0F, 10.0F, 15.0F), PartPose.offsetAndRotation(-5.0F, 1.0F, 2.0F, 0.3490658503988659F, 0.3490658503988659F, 0.13962634015954636F));
		PartDefinition partdef7 = partdef5.addOrReplaceChild("BagStrap1", CubeListBuilder.create().addBox(0.0F, 0.0F, -11.0F, 3.0F, 10.0F, 11.0F), PartPose.offsetAndRotation(3.5F, 1.0F, 0.5F, 0.2617993877991494F, -0.13962634015954636F, -0.17453292519943295F));
		PartDefinition partdef8 = partdef5.addOrReplaceChild("BagMain2", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 8.0F), PartPose.offsetAndRotation(-0.5F, 11.0F, -0.5F, 0.6981317007977318F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef9 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-6.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offsetAndRotation(-4.5F, -8.5F, -0.5F, 0.2617993877991494F, 0.0F, 0.4363323129985824F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0F, 0F, -6F, 6.0F, 7.0F, 6.0F), PartPose.offset(-6F, 10F, 3F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("PalmRight", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(3F, 7F, -3F, 0.0F, 0.02530727415391778F, 0.0F));
		PartDefinition partdef12 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(-3.5F, -9.5F, -3.0F, -0.7853981633974483F, 0.12217304763960307F, 0.08726646259971647F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("BoobM", CubeListBuilder.create().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(4.2F, 4.5F, 0.3F, 0.7853981633974483F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef14 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-8.0F, 4.0F, -5.0F, 16.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("LegLeft", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 22.0F, 7.0F), PartPose.offsetAndRotation(4.5F, 11.0F, -2.0F, -0.22689280275926282F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef16 = partdef14.addOrReplaceChild("LegRight", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 22.0F, 7.0F), PartPose.offsetAndRotation(-4.5F, 11.0F, -2.0F, -0.22689280275926282F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef17 = partdef0.addOrReplaceChild("Cloth", CubeListBuilder.create().addBox(-8.0F, 0.0F, -4.5F, 16.0F, 14.0F, 9.0F), PartPose.offset(0.0F, -8.5F, 0.0F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("Cloth2", CubeListBuilder.create().addBox(-8.5F, 0.0F, -5.0F, 17.0F, 12.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-7.5F, -1.5F, -7.0F, 15.0F, 5.0F, 11.0F), PartPose.offsetAndRotation(0.0F, -11.5F, 0.5F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("Cap", CubeListBuilder.create().addBox(-8.0F, -17.0F, -2.0F, 16.0F, 17.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 0.6F, 2.0F, 0.2F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdef20.addOrReplaceChild("Ear01", CubeListBuilder.create().mirror().addBox(-1.5F, 0F, -6F, 3.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(-3.5F, -14.5F, 5.7F, -0.6981F, 0.2618F, -0.1396F));
		PartDefinition partdef23 = partdef20.addOrReplaceChild("Ear02", CubeListBuilder.create().addBox(-1.5F, 0F, -6F, 3.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(3.5F, -14.5F, 5.7F, -0.6981F, -0.2618F, 0.1396F));
		PartDefinition partdef24 = partdef20.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-7.5F, -8.0F, -8.0F, 15.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.3F, 0.0F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0F, -6F, -11F, 0.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(0F, -7F, -4F, -0.1742F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef26 = partdef20.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7F, 0F, -12F, 14.0F, 9.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -9.5F, 9.5F, 0.1257F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef20.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8F, -14.7F, 0F, 16.0F, 15.0F, 6.0F), PartPose.offset(0F, -0.2F, -7.2F));
		PartDefinition partdef28 = partdef19.addOrReplaceChild("Cap2", CubeListBuilder.create().addBox(-8F, -15F, 0F, 16.0F, 15.0F, 8.0F), PartPose.offsetAndRotation(0F, -2F, -3F, -1.4F, 0.0F, 0.0F));
		PartDefinition partdef29 = partdef0.addOrReplaceChild("TailBase", CubeListBuilder.create().addBox(-6.0F, -6.0F, 0.0F, 12.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 7.5F, 0.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("Tail1", CubeListBuilder.create().addBox(-6.0F, -6.0F, 0.0F, 12.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("Tail2", CubeListBuilder.create().addBox(-6.0F, -6.0F, 0.0F, 12.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("Tail3", CubeListBuilder.create().addBox(-6.0F, -6.0F, 0.0F, 12.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("Tail4", CubeListBuilder.create().addBox(-6.0F, -6.0F, 0.0F, 12.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("Tail5", CubeListBuilder.create().addBox(-6.0F, -6.0F, 0.0F, 12.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("Tail6", CubeListBuilder.create().addBox(-5.5F, -6.5F, 0.0F, 11.0F, 13.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("TailHeadBase", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 9.0F));
		PartDefinition partdef37 = partdef36.addOrReplaceChild("TailHeadCL1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 6.0F, 7.0F), PartPose.offsetAndRotation(6.0F, -6.0F, 5.0F, 0.08726646259971647F, 0.17453292519943295F, 0.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("TailHeadCL2", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(2.0F, 0.5F, 7.0F, 0.08726646259971647F, 0.17453292519943295F, 0.0F));
		PartDefinition partdef39 = partdef37.addOrReplaceChild("TailHeadCL3", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(2.0F, 3.5F, 7.0F, -0.05235987755982988F, 0.17453292519943295F, 0.0F));
		PartDefinition partdef40 = partdef36.addOrReplaceChild("TailHeadCR1", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 5.0F, 6.0F, 7.0F), PartPose.offsetAndRotation(-6.0F, -6.0F, 5.0F, 0.08726646259971647F, -0.17453292519943295F, 0.0F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("TailHeadCR2", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(-2.0F, 0.5F, 7.0F, 0.08726646259971647F, -0.17453292519943295F, 0.0F));
		PartDefinition partdef42 = partdef40.addOrReplaceChild("TailHeadCR3", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(-2.0F, 3.5F, 7.0F, -0.05235987755982988F, -0.17453292519943295F, 0.0F));
		PartDefinition partdef43 = partdef36.addOrReplaceChild("TailHead1", CubeListBuilder.create().addBox(-5.5F, 0.0F, -0.5F, 11.0F, 8.0F, 17.0F), PartPose.offsetAndRotation(0.0F, -8.5F, 4.0F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("TailHeadC1", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 5.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -3.5F, 0.0F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("TailHeadC2", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 1.0F, 8.5F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef46 = partdef44.addOrReplaceChild("TailHeadC3", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(-2.8F, 1.0F, 8.5F, 0.13962634015954636F, -0.05235987755982988F, 0.0F));
		PartDefinition partdef47 = partdef44.addOrReplaceChild("TailHeadC4", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(2.8F, 1.0F, 8.5F, 0.13962634015954636F, 0.05235987755982988F, 0.0F));
		PartDefinition partdef48 = partdef43.addOrReplaceChild("TailHead3", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 14.5F, 0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef49 = partdef43.addOrReplaceChild("TailHead2", CubeListBuilder.create().addBox(-9.0F, 0.0F, 0.0F, 18.0F, 8.0F, 19.0F), PartPose.offsetAndRotation(0.0F, -1.5F, 4.5F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef50 = partdef36.addOrReplaceChild("TailJaw1", CubeListBuilder.create().addBox(-6.5F, 0.0F, 0.0F, 13.0F, 5.0F, 16.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 5.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("TailJaw2", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 10.0F, 5.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 8.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef52 = partdef50.addOrReplaceChild("TailJaw3", CubeListBuilder.create().addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 15.5F, -0.10035643198967394F, 0.0F, 0.0F));
		PartDefinition partdef53 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 0.0F));
		PartDefinition partdef54 = partdef53.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offset(0.0F, -11.5F, 0.5F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -0.5F, 0.0F));
		PartDefinition partdef56 = partdef55.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef57 = partdef55.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef58 = partdef55.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef59 = partdef55.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef60 = partdef55.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef61 = partdef55.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef62 = partdef55.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef63 = partdef55.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef64 = partdef55.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef65 = partdef55.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));
		PartDefinition partdef66 = partdef53.addOrReplaceChild("GlowTailBase", CubeListBuilder.create(), PartPose.offset(0.0F, 7.5F, 0.0F));
		PartDefinition partdef67 = partdef66.addOrReplaceChild("GlowTail1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 9.0F));
		PartDefinition partdef68 = partdef67.addOrReplaceChild("GlowTail2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 9.0F));
		PartDefinition partdef69 = partdef68.addOrReplaceChild("GlowTail3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 9.0F));
		PartDefinition partdef70 = partdef69.addOrReplaceChild("GlowTail4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 9.0F));
		PartDefinition partdef71 = partdef70.addOrReplaceChild("GlowTail5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 9.0F));
		PartDefinition partdef72 = partdef71.addOrReplaceChild("GlowTail6", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 9.0F));
		PartDefinition partdef73 = partdef72.addOrReplaceChild("TailBack6", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -7.5F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef74 = partdef72.addOrReplaceChild("GlowTailHeadBase", CubeListBuilder.create().addBox(-5.0F, -7.0F, 0.0F, 10.0F, 14.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 9.0F));
		PartDefinition partdef75 = partdef74.addOrReplaceChild("GlowTailHead1", CubeListBuilder.create(), PartPose.offset(0.0F, -8.5F, 4.0F));
		PartDefinition partdef76 = partdef75.addOrReplaceChild("TailHeadT01", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 4.5F, 4.5F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef77 = partdef74.addOrReplaceChild("GlowTailJaw1", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 5.0F));
		PartDefinition partdef78 = partdef77.addOrReplaceChild("TailJawT01", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 5.0F, 11.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 4.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef79 = partdef71.addOrReplaceChild("TailBack5", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef80 = partdef70.addOrReplaceChild("TailBack4", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef81 = partdef69.addOrReplaceChild("TailBack3", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef82 = partdef68.addOrReplaceChild("TailBack2", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef83 = partdef67.addOrReplaceChild("TailBack1", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef84 = partdef66.addOrReplaceChild("TailBack0", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.17453292519943295F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelBattleshipRe(ModelPart root)
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
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.TailHeadC1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailHead1").getChild("TailHeadC1");
		this.Cloth2 = root.getChild("BodyMain").getChild("Cloth").getChild("Cloth2");
		this.TailHead1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailHead1");
		this.Tail5 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.PalmLeft = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("PalmLeft");
		this.TailHeadCR2 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailHeadCR1").getChild("TailHeadCR2");
		this.TailHeadC2 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailHead1").getChild("TailHeadC1").getChild("TailHeadC2");
		this.TailHeadCR3 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailHeadCR1").getChild("TailHeadCR3");
		this.Tail6 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6");
		this.TailHeadCL1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailHeadCL1");
		this.BagMain = root.getChild("BodyMain").getChild("BagMain");
		this.BagStrap1 = root.getChild("BodyMain").getChild("BagMain").getChild("BagStrap1");
		this.BagStrap2 = root.getChild("BodyMain").getChild("BagMain").getChild("BagStrap2");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.Cap = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Cap");
		this.Cap2 = root.getChild("BodyMain").getChild("Neck").getChild("Cap2");
		this.TailHead3 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailHead1").getChild("TailHead3");
		this.TailHead2 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailHead1").getChild("TailHead2");
		this.TailHeadCL2 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailHeadCL1").getChild("TailHeadCL2");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.TailBack4 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2").getChild("GlowTail3").getChild("GlowTail4").getChild("TailBack4");
		this.TailJaw2 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailJaw1").getChild("TailJaw2");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.TailHeadT01 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2").getChild("GlowTail3").getChild("GlowTail4").getChild("GlowTail5").getChild("GlowTail6").getChild("GlowTailHeadBase").getChild("GlowTailHead1").getChild("TailHeadT01");
		this.Tail3 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.TailBack2 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2").getChild("TailBack2");
		this.LegLeft = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft");
		this.BodyMain = root.getChild("BodyMain");
		this.TailJaw3 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailJaw1").getChild("TailJaw3");
		this.TailBase = root.getChild("BodyMain").getChild("TailBase");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.TailBack5 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2").getChild("GlowTail3").getChild("GlowTail4").getChild("GlowTail5").getChild("TailBack5");
		this.LegRight = root.getChild("BodyMain").getChild("Butt").getChild("LegRight");
		this.TailBack0 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("TailBack0");
		this.Cloth = root.getChild("BodyMain").getChild("Cloth");
		this.TailHeadC3 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailHead1").getChild("TailHeadC1").getChild("TailHeadC3");
		this.Tail1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1");
		this.TailHeadBase = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair01");
		this.HairU01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairU01");
		this.TailJaw1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailJaw1");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.TailHeadCR1 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailHeadCR1");
		this.TailBack1 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("TailBack1");
		this.TailHeadC4 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailHead1").getChild("TailHeadC1").getChild("TailHeadC4");
		this.PalmRight = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("PalmRight");
		this.Tail2 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2");
		this.TailJawT01 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2").getChild("GlowTail3").getChild("GlowTail4").getChild("GlowTail5").getChild("GlowTail6").getChild("GlowTailHeadBase").getChild("GlowTailJaw1").getChild("TailJawT01");
		this.Tail4 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4");
		this.TailHeadCL3 = root.getChild("BodyMain").getChild("TailBase").getChild("Tail1").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Tail5").getChild("Tail6").getChild("TailHeadBase").getChild("TailHeadCL1").getChild("TailHeadCL3");
		this.BoobM = root.getChild("BodyMain").getChild("BoobR").getChild("BoobM");
		this.TailBack6 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2").getChild("GlowTail3").getChild("GlowTail4").getChild("GlowTail5").getChild("GlowTail6").getChild("TailBack6");
		this.TailBack3 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2").getChild("GlowTail3").getChild("TailBack3");
		this.BagMain2 = root.getChild("BodyMain").getChild("BagMain").getChild("BagMain2");
		this.Ear01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ear01");
		this.Ear02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Ear02");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.GlowTailBase = root.getChild("GlowBodyMain").getChild("GlowTailBase");
		this.GlowTail1 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1");
		this.GlowTail2 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2");
		this.GlowTail3 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2").getChild("GlowTail3");
		this.GlowTail4 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2").getChild("GlowTail3").getChild("GlowTail4");
		this.GlowTail5 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2").getChild("GlowTail3").getChild("GlowTail4").getChild("GlowTail5");
		this.GlowTail6 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2").getChild("GlowTail3").getChild("GlowTail4").getChild("GlowTail5").getChild("GlowTail6");
		this.GlowTailHeadBase = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2").getChild("GlowTail3").getChild("GlowTail4").getChild("GlowTail5").getChild("GlowTail6").getChild("GlowTailHeadBase");
		this.GlowTailHead1 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2").getChild("GlowTail3").getChild("GlowTail4").getChild("GlowTail5").getChild("GlowTail6").getChild("GlowTailHeadBase").getChild("GlowTailHead1");
		this.GlowTailJaw1 = root.getChild("GlowBodyMain").getChild("GlowTailBase").getChild("GlowTail1").getChild("GlowTail2").getChild("GlowTail3").getChild("GlowTail4").getChild("GlowTail5").getChild("GlowTail6").getChild("GlowTailHeadBase").getChild("GlowTailJaw1");
		this.scale = 0.4F;
		this.offsetY = 0F;
		this.offsetItem = new float[] {0.04F, 0.42F, -0.04F};
		this.offsetBlock = new float[] {0.04F, 0.42F, -0.04F};
		armMain = new ModelPart[] {this.BodyMain, this.ArmRight01, this.ArmRight02};
		armOff = new ModelPart[] {this.BodyMain, this.ArmLeft01, this.ArmLeft02};
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
		
		boolean flag = !EmotionHelper.checkModelState(0, state);	//hat
		this.Hair01.visible = !(flag);
		this.HairU01.visible = !(flag);
		this.Ear01.visible = !(flag);
		this.Ear02.visible = !(flag);
		this.Cap.visible = !(!flag);
		this.Cap2.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(1, state);	//bag
		this.BagMain.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);	//ear
		this.Ear01.visible = !(flag);
		this.Ear02.visible = !(flag);
	
	}

	public void syncRotationGlowPart()
	{

    	//頭部
		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowNeck.xRot = this.Neck.xRot;
		this.GlowNeck.yRot = this.Neck.yRot;
		this.GlowNeck.zRot = this.Neck.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
		//尾巴
		this.GlowTailBase.xRot = this.TailBase.xRot;
		this.GlowTailBase.yRot = this.TailBase.yRot;
		this.GlowTailBase.zRot = this.TailBase.zRot;
		this.GlowTail1.xRot = this.Tail1.xRot;
		this.GlowTail1.yRot = this.Tail1.yRot;
		this.GlowTail1.zRot = this.Tail1.zRot;
		this.GlowTail2.xRot = this.Tail2.xRot;
		this.GlowTail2.yRot = this.Tail2.yRot;
		this.GlowTail2.zRot = this.Tail2.zRot;
		this.GlowTail3.xRot = this.Tail3.xRot;
		this.GlowTail3.yRot = this.Tail3.yRot;
		this.GlowTail3.zRot = this.Tail3.zRot;
		this.GlowTail4.xRot = this.Tail4.xRot;
		this.GlowTail4.yRot = this.Tail4.yRot;
		this.GlowTail4.zRot = this.Tail4.zRot;
		this.GlowTail5.xRot = this.Tail5.xRot;
		this.GlowTail5.yRot = this.Tail5.yRot;
		this.GlowTail5.zRot = this.Tail5.zRot;
		this.GlowTail6.xRot = this.Tail6.xRot;
		this.GlowTail6.yRot = this.Tail6.yRot;
		this.GlowTail6.zRot = this.Tail6.zRot;
		//尾巴牙齒
		this.GlowTailHeadBase.xRot = this.TailHeadBase.xRot;
		this.GlowTailHeadBase.yRot = this.TailHeadBase.yRot;
		this.GlowTailHeadBase.zRot = this.TailHeadBase.zRot;
		this.GlowTailHead1.xRot = this.TailHead1.xRot;
		this.GlowTailHead1.yRot = this.TailHead1.yRot;
		this.GlowTailHead1.zRot = this.TailHead1.zRot;
		this.GlowTailJaw1.xRot = this.TailJaw1.xRot;
		this.GlowTailJaw1.yRot = this.TailJaw1.yRot;
		this.GlowTailJaw1.zRot = this.TailJaw1.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (1.13F); this.animTransZ += (0F);
    	this.setFaceHungry(ent);
    
    	//頭部
	  	this.Head.xRot = 0F;
	  	this.Head.yRot = 0F;
	    //胸部
  	    this.BoobL.xRot = -0.73F;
  	    this.BoobR.xRot = -0.73F;
	  	//Body
  	    this.Ahoke.yRot = 0.5236F;
	  	this.Head.xRot -= 0.5236F;
	  	this.BodyMain.yRot = 0F;
    	this.BodyMain.xRot = 1.5708F;
    	this.Cloth2.xRot = -0.0524F;
  	    //arm 
	  	this.ArmLeft01.xRot = -2.9671F;
	    this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = 0.0349F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmRight01.xRot = -2.9671F;
		this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -0.0349F;
		this.ArmRight02.zRot = 0F;
		//bag
		this.BagStrap1.xRot = 0.2618F;
		this.BagStrap1.yRot = -0.1396F;
		this.BagStrap1.zRot = -0.1745F;
		this.BagStrap2.xRot = 0.3491F;
		this.BagStrap2.yRot = 0.3491F;
		//leg
		this.LegLeft.xRot = -0.3491F;
		this.LegRight.xRot = -0.3491F;
		this.LegLeft.yRot = 0F;
		this.LegRight.yRot = 0F;
		//tail
		this.TailBase.xRot = -0.4F;
		this.TailBase.yRot = -0.8F;//Mth.cos(-f2 * 0.1F) * 0.1F;
		this.TailBase.zRot = 0F;//Mth.cos(-f2 * 0.1F) * 0.05F;
		this.Tail1.xRot = -0.3F;
		this.Tail1.yRot = -0.35F;//Mth.cos(-f2 * 0.1F + 0.7F) * 0.2F;
		this.Tail1.zRot = 0F;//-Mth.cos(-f2 * 0.1F + 0.7F) * 0.05F;
		this.Tail2.xRot = -0.35F;
		this.Tail2.yRot = -0.3F;//Mth.cos(-f2 * 0.1F + 1.4F) * 0.3F;
		this.Tail2.zRot = 0F;//-Mth.cos(-f2 * 0.1F + 1.4F) * 0.05F;
		this.Tail3.xRot = -0.4F;
		this.Tail3.yRot = -0.2F;//Mth.cos(-f2 * 0.1F + 2.1F) * 0.4F;
		this.Tail3.zRot = 0F;//-Mth.cos(-f2 * 0.1F + 2.1F) * 0.05F;
		this.Tail4.xRot = -0.25F;
		this.Tail4.yRot = 0.2F;//Mth.cos(-f2 * 0.1F + 2.8F) * 0.5F;
		this.Tail4.zRot = 0F;//Mth.cos(-f2 * 0.1F + 2.8F) * 0.025F;
		this.Tail5.xRot = 0.25F;
		this.Tail5.yRot = 0.2F;//Mth.cos(-f2 * 0.1F + 3.5F) * 0.55F;
		this.Tail5.zRot = 0F;//Mth.cos(-f2 * 0.1F + 3.5F) * 0.05F;
		this.Tail6.xRot = 0.35F;
		this.Tail6.yRot = 0.2F;//Mth.cos(-f2 * 0.1F + 4.2F) * 0.6F;
		this.Tail6.zRot = 0F;//Mth.cos(-f2 * 0.1F + 4.2F) * 0.05F;
		this.TailHeadBase.xRot = 0.4F;
		this.TailHeadBase.yRot = 0F;//Mth.cos(-f2 * 0.1F + 4.9F) * 0.65F;
		this.TailHeadBase.zRot = 0F;//Mth.cos(-f2 * 0.1F + 4.9F) * 0.025F;
		this.TailHead1.xRot = 0.2618F;
		this.TailJaw1.xRot = -0.7F;
		this.Hair01.visible = false;
		this.Ear01.visible = false;
		this.Ear02.visible = false;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

 		float angleX = Mth.cos(f2*0.08F);
  		float addk1 = 0;
  		float addk2 = 0;
  		
this.animTransX += (0F); this.animTransY += (0.63F); this.animTransZ += (0F);
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//leg move parm
  		addk1 = Mth.cos(f * 0.7F) * f1;
	  	addk2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;

  	    //頭部
	  	this.Head.xRot = f4 * 0.014F;
	  	this.Head.yRot = f3 * 0.01F;
	    //胸部
  	    this.BoobL.xRot = -angleX * 0.06F - 0.73F;
  	    this.BoobR.xRot = -angleX * 0.06F - 0.73F;
	  	//Body
  	    this.Ahoke.yRot = angleX * 0.25F + 0.5236F;
	  	this.Head.xRot -= 0.5236F;
	  	this.Cap2.xRot = -1.4F;
	  	this.BodyMain.xRot = 0.0873F;
	  	this.BodyMain.yRot = 0F;
	  	this.Cloth2.xRot = -0.0524F;
	    //arm 
	  	this.ArmLeft01.xRot = 0.2618F;
	    this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = angleX * 0.1F - 0.5236F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmRight01.xRot = 0.2618F;
		this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -angleX * 0.1F + 0.5236F;
		this.ArmRight02.zRot = 0F;
		//bag
		this.BagStrap1.xRot = 0.2618F;
		this.BagStrap1.yRot = -0.1396F;
		this.BagStrap1.zRot = -0.1745F;
		this.BagStrap2.xRot = 0.3491F;
		this.BagStrap2.yRot = 0.3491F;
		//leg
		addk1 -= 0.2618F;
		addk2 -= 0.2618F;
		this.LegLeft.yRot = 0F;
		this.LegRight.yRot = 0F;
		//tail
		this.TailBase.xRot = -0.5236F;
		this.TailBase.yRot = Mth.cos(-f2 * 0.1F) * 0.1F;
		this.TailBase.zRot = 0F;//Mth.cos(-f2 * 0.1F) * 0.1F;
		this.Tail1.xRot = 0.5236F;
		this.Tail1.yRot = Mth.cos(-f2 * 0.1F + 0.7F) * 0.1F;
		this.Tail1.zRot = 0F;//-Mth.cos(-f2 * 0.1F + 0.7F) * 0.1F;
		this.Tail2.xRot = 0.5236F;
		this.Tail2.yRot = Mth.cos(-f2 * 0.1F + 1.4F) * 0.15F;
		this.Tail2.zRot = 0F;//-Mth.cos(-f2 * 0.1F + 1.4F) * 0.1F;
		this.Tail3.xRot = 0.5236F;
		this.Tail3.yRot = Mth.cos(-f2 * 0.1F + 2.1F) * 0.2F;
		this.Tail3.zRot = 0F;//-Mth.cos(-f2 * 0.1F + 2.1F) * 0.1F;
		this.Tail4.xRot = 0.5236F;
		this.Tail4.yRot = Mth.cos(-f2 * 0.1F + 2.8F) * 0.25F;
		this.Tail4.zRot = 0F;//-Mth.cos(-f2 * 0.1F + 2.8F) * 0.1F;
		this.Tail5.xRot = -0.5236F;
		this.Tail5.yRot = Mth.cos(-f2 * 0.1F + 3.5F) * 0.3F;
		this.Tail5.zRot = 0F;//Mth.cos(-f2 * 0.1F + 3.5F) * 0.1F;
		this.Tail6.xRot = -0.5236F;
		this.Tail6.yRot = Mth.cos(-f2 * 0.1F + 4.2F) * 0.35F;
		this.Tail6.zRot = 0F;//Mth.cos(-f2 * 0.1F + 4.2F) * 0.1F;
		this.TailHeadBase.xRot = -0.5236F;
		this.TailHeadBase.yRot = Mth.cos(-f2 * 0.1F + 4.9F) * 0.4F;
		this.TailHeadBase.zRot = 0F;//Mth.cos(-f2 * 0.1F + 4.9F) * 0.1F;
		this.TailHead1.xRot = 0.1745F;
		this.TailJaw1.xRot = angleX * 0.1F - 0.15F;
		
		//ear
		float modf2 = f2 % 128F;
		if (modf2 < 6F)
		{
			//total 3 ticks, loop twice in 6 ticks
			if(modf2 >= 3F) modf2 -= 3F;
			float anglef2 = Mth.sin(modf2 * 1.0472F) * 0.25F;
			this.Ear01.zRot = -anglef2 - 0.14F;
			this.Ear02.zRot = anglef2 + 0.14F;
		}
		else
		{
			this.Ear01.zRot = -0.14F;
			this.Ear02.zRot = 0.14F;
		}

	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {
	    	//奔跑動作
	    	this.setFaceHappy(ent);
	    	float t2 = ent.getTickExisted() & 1023;
			//change run type base on tickExisted
			if (t2 > 700)
			{	//run type 1
				//高度
this.animTransX += (0F); this.animTransY += (0.05F); this.animTransZ += (0F);
		  	    //手臂晃動
			  	this.ArmLeft01.xRot = Mth.cos(f * 0.8F) * 0.1F -2.0944F;
			    this.ArmLeft01.yRot = -0.5236F;
			    this.ArmLeft01.zRot = 0F;
			    this.ArmRight01.xRot = -Mth.cos(f * 0.8F) * 0.1F -2.0944F;
				this.ArmRight01.yRot = 0.5236F;
				this.ArmRight01.zRot = 0F;
				//頭部角度
				this.Head.xRot *= 0.75F;
				this.Head.xRot -= 0.5236F;
				this.Cap2.xRot = -1.74F;
				//身體角度
				this.BodyMain.xRot = 0.5236F;
				this.BodyMain.yRot = 3.1416F;
				this.Cloth2.xRot = -0.7854F;
				//腿擺動
				addk1 = addk1 * 0.1F - 1.2708F;
				addk2 = addk2 * 0.1F - 1.2708F;
				this.LegLeft.yRot = -0.2618F;
				this.LegRight.yRot = 0.2618F;
				//bag
				this.BagStrap1.xRot = 0.0872F;
				this.BagStrap1.yRot = 0F;
				this.BagStrap1.zRot = -0.1745F;
				this.BagStrap2.xRot = 0.0872F;
				this.BagStrap2.yRot = 0.3491F;
				//tail
				//X旋轉過, 要繼續轉Y時, 就要補上Z修正
				//X越大, Z修正要越大, 且跟X角度反號, 具體角度需自行觀察
				this.TailBase.xRot = -1.3F;
				this.TailBase.yRot = -Mth.cos(f * 0.25F - 5.0F) * 0.2F * f1;
				this.TailBase.zRot = Mth.cos(f * 0.25F - 5.0F) * 0.4F * f1;
				this.Tail1.xRot = 0.2618F;
				this.Tail1.yRot = -Mth.cos(f * 0.25F - 4.2F) * 0.3F * f1;
				this.Tail1.zRot = -Mth.cos(f * 0.25F - 4.2F) * 0.1F * f1;
				this.Tail2.xRot = 0.2618F;
				this.Tail2.yRot = -Mth.cos(f * 0.25F - 3.5F) * 0.4F * f1;
				this.Tail2.zRot = -Mth.cos(f * 0.25F - 3.5F) * 0.1F * f1;
				this.Tail3.xRot = 0.1745F;
				this.Tail3.yRot = -Mth.cos(f * 0.25F - 2.8F) * 0.5F * f1;
				this.Tail3.zRot = 0F;//Mth.cos(f * 0.3F - 2.8F) * 0.05F * f1;
				this.Tail4.xRot = 0.1745F;
				this.Tail4.yRot = -Mth.cos(f * 0.25F - 2.1F) * 0.5F * f1;
				this.Tail4.zRot = 0F;//Mth.cos(f * 0.3F - 2.1F) * 0.05F * f1;
				this.Tail5.xRot = 0.0873F;
				this.Tail5.yRot = -Mth.cos(f * 0.25F - 1.4F) * 0.4F * f1;
				this.Tail5.zRot = 0F;//Mth.cos(f * 0.3F - 1.4F) * 0.02F * f1;
				this.Tail6.xRot = 0.0873F;
				this.Tail6.yRot = -Mth.cos(f * 0.25F - 0.7F) * 0.3F * f1;
				this.Tail6.zRot = 0F;//Mth.cos(f * 0.3F - 0.7F) * 0.02F * f1;
				this.TailHeadBase.xRot = -0.0873F;
				this.TailHeadBase.yRot = -Mth.cos(f * 0.25F) * 0.2F * f1;
				this.TailHeadBase.zRot = 0F;//Mth.cos(f * 0.3F) * 0.02F * f1;
				this.TailHead1.xRot = 0.3F;
				this.TailJaw1.xRot = angleX * 0.2F - 0.3F;
			}
			else if (t2 > 400)
			{	//run type 2
				//高度
this.animTransX += (0F); this.animTransY += (0.05F); this.animTransZ += (0F);
		  	    //手臂晃動 
			  	this.ArmLeft01.xRot = -1.0472F;
			    this.ArmLeft01.yRot = 0.2618F;
			    this.ArmLeft01.zRot = 0F;
			    this.ArmRight01.xRot = -2.7925F;
				this.ArmRight01.yRot = 0F;
				this.ArmRight01.zRot = f3 / -57F;
				//頭部角度
				this.Head.xRot *= 0.75F;
				this.Head.xRot -= 1.2217F;
				this.Cap2.xRot = -1.74F;
				//身體角度
				this.BodyMain.xRot = 1.2217F;
				this.Cloth2.xRot = -0.3491F;
				//腿擺動
				addk1 = -1.0472F;
				addk2 =-1.0472F;
				this.LegLeft.yRot = -0.3491F;
				this.LegRight.yRot = 0.3491F;
				//bag
				this.BagStrap1.xRot = 0.2618F;
				this.BagStrap1.yRot = 0F;
				this.BagStrap1.zRot = 0F;
				this.BagStrap2.xRot = 0.3491F;
				this.BagStrap2.yRot = 0.3491F;
				//tail
				this.TailBase.xRot = 1.0472F;
				this.TailBase.yRot = 0F;
				this.TailBase.zRot = 3.1415F;
				this.Tail1.xRot = 0.7854F;
				this.Tail1.yRot = 0F;
				this.Tail1.zRot = 0F;
				this.Tail2.xRot = 0.7854F;
				this.Tail2.yRot = 0F;
				this.Tail2.zRot = 0F;
				this.Tail3.xRot = 0.7854F;
				this.Tail3.yRot = 0F;
				this.Tail3.zRot = 0F;
				this.Tail4.xRot = 0.7854F;
				this.Tail4.yRot = 0F;
				this.Tail4.zRot = 0F;
				this.Tail5.xRot = 0.5236F;
				this.Tail5.yRot = 0F;
				this.Tail5.zRot = 0F;
				this.Tail6.xRot = -0.2618F;
				this.Tail6.yRot = 0F;
				this.Tail6.zRot = 0F;
				this.TailHeadBase.xRot = 0F;
				this.TailHeadBase.yRot = 0F;
				this.TailHeadBase.zRot = 0F;
				this.TailHead1.xRot = 0.1745F;
				this.TailJaw1.xRot = angleX * 0.15F - 0.3F;
			}
			else
			{	//run type 3
				//高度
this.animTransX += (0F); this.animTransY += (0.1F); this.animTransZ += (0F);
		  	    //手臂晃動 
			  	this.ArmLeft01.xRot = Mth.cos(f * 0.8F) * 0.1F + 0.6981F;
			    this.ArmLeft01.yRot = 0F;
			    this.ArmLeft01.zRot = -0.6981F;
			    this.ArmRight01.xRot = Mth.cos(f * 0.8F) * 0.1F + 0.6981F;
				this.ArmRight01.yRot = 0F;
				this.ArmRight01.zRot = 0.6981F;
				//頭部角度
				this.Head.xRot *= 0.75F;
				this.Head.xRot -= 1.0472F;
				this.Cap2.xRot = -1.74F;
				//身體角度
				this.BodyMain.xRot = 0.8727F;
				this.Cloth2.xRot = -0.5236F;
				//腿擺動
				addk1 -= 0.5F;
				addk2 -= 0.5F;
				this.LegLeft.yRot = 0F;
				this.LegRight.yRot = 0F;
				//bag
				this.BagStrap1.xRot = 0.15F;
				this.BagStrap1.yRot = -1.0472F;
				this.BagStrap1.zRot = 0F;
				this.BagStrap2.xRot = 0.3491F;
				this.BagStrap2.yRot = 1.0472F;
				//tail
				this.TailBase.xRot = -0.7F;
				this.TailBase.yRot = -Mth.cos(-f * 0.3F) * 0.2F * f1;
				this.TailBase.zRot = Mth.cos(-f * 0.3F) * 0.3F * f1;
				this.Tail1.xRot = 0.2618F;
				this.Tail1.yRot = -Mth.cos(-f * 0.3F + 0.7F) * 0.2F * f1;
				this.Tail1.zRot = -Mth.cos(-f * 0.3F + 0.7F) * 0.1F * f1;
				this.Tail2.xRot = 0.2618F;
				this.Tail2.yRot = -Mth.cos(-f * 0.3F + 1.4F) * 0.3F * f1;
				this.Tail2.zRot = -Mth.cos(-f * 0.3F + 1.4F) * 0.1F * f1;
				this.Tail3.xRot = -0.2618F;
				this.Tail3.yRot = -Mth.cos(-f * 0.3F + 2.2F) * 0.3F * f1;
				this.Tail3.zRot = Mth.cos(-f * 0.3F + 2.2F) * 0.1F * f1;
				this.Tail4.xRot = -0.2618F;
				this.Tail4.yRot = -Mth.cos(-f * 0.3F + 2.8F) * 0.4F * f1;
				this.Tail4.zRot = Mth.cos(-f * 0.3F + 2.8F) * 0.1F * f1;
				this.Tail5.xRot = -0.2618F;
				this.Tail5.yRot = -Mth.cos(-f * 0.3F + 3.5F) * 0.4F * f1;
				this.Tail5.zRot = Mth.cos(-f * 0.3F + 3.5F) * 0.1F * f1;
				this.Tail6.xRot = -0.2618F;
				this.Tail6.yRot = -Mth.cos(-f * 0.3F + 4.2F) * 0.5F * f1;
				this.Tail6.zRot = Mth.cos(-f * 0.3F + 4.2F) * 0.1F * f1;
				this.TailHeadBase.xRot = 0.2618F;
				this.TailHeadBase.yRot = -Mth.cos(-f * 0.3F + 4.9F) * 0.6F * f1;
				this.TailHeadBase.zRot = -Mth.cos(-f * 0.3F + 4.9F) * 0.1F * f1;
				this.TailHead1.xRot = 0.1745F;
				this.TailJaw1.xRot = angleX * 0.15F - 0.3F;
			}		
  		}
	    
	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
  		
	    if (ent.getIsSneaking())
	    {	//潛行, 蹲下動作
  			//高度
this.animTransX += (0F); this.animTransY += (0.1F); this.animTransZ += (0F);
	  	    //手臂晃動 
		  	this.ArmLeft01.xRot = 0.5236F;
		    this.ArmLeft01.yRot = 0F;
		    this.ArmLeft01.zRot = -0.5236F;
		    this.ArmRight01.xRot = 0.5236F;
			this.ArmRight01.yRot = 0F;
			this.ArmRight01.zRot = 0.5236F;
			//頭部角度
			this.Head.xRot = -1.2217F;
			//身體角度
			this.BodyMain.xRot = 1.0472F;
			this.Cloth2.xRot = -0.5236F;
			//腿擺動
			addk1 = addk1 - 0.95F;
			addk2 = addk2 - 0.95F;
			this.LegLeft.yRot = 0F;
			this.LegRight.yRot = 0F;
			//bag
			this.BagStrap1.xRot = 0.15F;
			this.BagStrap1.yRot = -1.0472F;
			this.BagStrap1.zRot = 0F;
			this.BagStrap2.xRot = 0.3491F;
			this.BagStrap2.yRot = 1.0472F;
			//tail
			this.TailBase.xRot = 0.7F;
			this.TailBase.yRot = 0F;
			this.TailBase.zRot = 3.1416F;
			this.Tail1.xRot = -0.2618F;
			this.Tail1.yRot = 0F;
			this.Tail1.zRot = 0F;
			this.Tail2.xRot = -0.5236F;
			this.Tail2.yRot = 0F;
			this.Tail2.zRot = 0F;
			this.Tail3.xRot = -0.2618F;
			this.Tail3.yRot = 0F;
			this.Tail3.zRot = 0F;
			this.Tail4.xRot = -0.2618F;
			this.Tail4.yRot = 0F;
			this.Tail4.zRot = 0F;
			this.Tail5.xRot = -0.5236F;
			this.Tail5.yRot = 0F;
			this.Tail5.zRot = 0F;
			this.Tail6.xRot = -0.5236F;
			this.Tail6.yRot = 0F;
			this.Tail6.zRot = 0F;
			this.TailHeadBase.xRot = -0.2618F;
			this.TailHeadBase.yRot = 0F;
			this.TailHeadBase.zRot = 0F;
			this.TailHead1.xRot = 0.1745F;
			this.TailJaw1.xRot = -0.2F;
  		}//end if sneaking
  		
	    //騎乘動作
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {
	    	this.Cap2.visible = false;
	    	
	    	if ((ent.getTickExisted() & 1023) > 512)
	    	{
	    		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		    	{
this.animTransX += (0F); this.animTransY += (0.13F); this.animTransZ += (0F);
			    	//Body
					this.Head.xRot += 0.3F;
			    	this.BodyMain.xRot = -0.3F;
			    	this.Cloth2.xRot = -0.3F;
			  	    //arm 
					this.ArmLeft01.xRot = 2.3F;
				    this.ArmLeft01.yRot = 0F;
				    this.ArmLeft01.zRot = 0.2F;
				    this.ArmLeft02.zRot = 1F;
				    this.ArmRight01.xRot = 2.3F;
					this.ArmRight01.yRot = 0F;
					this.ArmRight01.zRot = -0.2F;
					this.ArmRight02.zRot = -1F;
					
					//arm special
			    	float parTick = f2 - (int)f2 + (ent.getTickExisted() & 255);
			    	
			    	if (parTick < 30F)
			    	{
			    		float az = Mth.sin(parTick * 0.033F * 1.5708F) * 1.6F;
				    	float az1 = az * 1.6F;
				    	
				    	this.setFaceHappy(ent);
			    		//arm 
					    this.ArmLeft01.zRot = 0.2F + az;
					    this.ArmLeft02.zRot = 1F - az1;
					    if(this.ArmLeft02.zRot < 0F) this.ArmLeft02.zRot = 0F;
						this.ArmRight01.zRot = -0.2F - az;
						this.ArmRight02.zRot = -1F + az1;
						if(this.ArmRight02.zRot > 0F) this.ArmRight02.zRot = 0F;
			    	}
			    	else if (parTick < 45F)
			    	{
			    		this.setFaceHappy(ent);
			    		//arm 
					    this.ArmLeft01.zRot = 1.8F;
					    this.ArmLeft02.zRot = 0F;
						this.ArmRight01.zRot = -1.8F;
						this.ArmRight02.zRot = 0F;
			    	}
			    	else if (parTick < 53F)
			    	{
			    		float az = Mth.cos((parTick - 45F) * 0.125F * 1.5708F);
				    	float az1 = az * 1.6F;
				    	
				    	//arm 
					    this.ArmLeft01.zRot = 0.2F + az1;
					    this.ArmLeft02.zRot = 1F - az;
						this.ArmRight01.zRot = -0.2F - az1;
						this.ArmRight02.zRot = -1F + az;
			    	}
			    	
					//bag
					this.BagStrap1.xRot = 0.6F;
					this.BagStrap1.yRot = 0F;
					this.BagStrap1.zRot = 0F;
					this.BagStrap2.xRot = 1.0472F;
					this.BagStrap2.yRot = 1.3963F;
					//leg
					addk1 = angleX*0.1F -0.9F;
					addk2 = -angleX*0.1F -0.9F;
					this.LegLeft.yRot = -0.2F;
					this.LegRight.yRot = 0.2F;
					//tail
					this.TailBase.xRot = -1.0F;
					this.TailBase.yRot = 0.2618F;
					this.TailBase.zRot = 0F;
					this.Tail1.xRot = 0.6981F;
					this.Tail1.yRot = 0.0872F;
					this.Tail1.zRot = 0F;
					this.Tail2.xRot = 0.5236F;
					this.Tail2.yRot = 0.0872F;
					this.Tail2.zRot = 0.1745F;
					this.Tail3.xRot = 0F;
					this.Tail3.yRot = 0.6981F;
					this.Tail3.zRot = 0F;
					this.Tail4.xRot = 0F;
					this.Tail4.yRot = 0.6981F;
					this.Tail4.zRot = 0F;
					this.Tail5.xRot = 0F;
					this.Tail5.yRot = 0.5236F;
					this.Tail5.zRot = 0F;
					this.Tail6.xRot = 0F;
					this.Tail6.yRot = 0.5236F;
					this.Tail6.zRot = 0F;
					this.TailHeadBase.xRot = 0.2618F;
					this.TailHeadBase.yRot = 0.5236F;
					this.TailHeadBase.zRot = 0F;
					this.TailHead1.xRot = 0.2618F;
					this.TailJaw1.xRot = angleX * 0.1F - 0.2618F;
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.51F); this.animTransZ += (0F);
			    	//Body
		    		this.Head.xRot *= 0.8F;
			    	this.Head.xRot -= 1.8F;
			    	this.Head.yRot *= 0.5F;
			    	this.BodyMain.xRot = 1.5708F;
			    	this.Cloth2.xRot = -0.0524F;
			  	    //arm 
				  	this.ArmLeft01.xRot = -2.9671F;
				    this.ArmLeft01.yRot = 0F;
				    this.ArmLeft01.zRot = 0.0349F;
				    this.ArmLeft02.zRot = 1.3962F;
				    this.ArmRight01.xRot = -2.9671F;
					this.ArmRight01.yRot = 0F;
					this.ArmRight01.zRot = -0.0349F;
					this.ArmRight02.zRot = -1.3962F;
					//bag
					this.BagStrap1.xRot = 0.2618F;
					this.BagStrap1.yRot = -0.1396F;
					this.BagStrap1.zRot = -0.1745F;
					this.BagStrap2.xRot = 0.3491F;
					this.BagStrap2.yRot = 0.3491F;
					//leg
					addk1 = -0.3491F;
					addk2 = -0.3491F;
					this.LegLeft.yRot = 0F;
					this.LegRight.yRot = 0F;
					//tail
					this.TailBase.xRot = -0.7F;
					this.TailBase.yRot = Mth.cos(-f2 * 0.1F) * 0.1F;
					this.TailBase.zRot = Mth.cos(-f2 * 0.1F) * 0.05F;
					this.Tail1.xRot = 0.35F;
					this.Tail1.yRot = Mth.cos(-f2 * 0.1F + 0.7F) * 0.2F;
					this.Tail1.zRot = -Mth.cos(-f2 * 0.1F + 0.7F) * 0.05F;
					this.Tail2.xRot = 0.35F;
					this.Tail2.yRot = Mth.cos(-f2 * 0.1F + 1.4F) * 0.3F;
					this.Tail2.zRot = -Mth.cos(-f2 * 0.1F + 1.4F) * 0.05F;
					this.Tail3.xRot = 0.35F;
					this.Tail3.yRot = Mth.cos(-f2 * 0.1F + 2.1F) * 0.4F;
					this.Tail3.zRot = -Mth.cos(-f2 * 0.1F + 2.1F) * 0.05F;
					this.Tail4.xRot = -0.2618F;
					this.Tail4.yRot = Mth.cos(-f2 * 0.1F + 2.8F) * 0.5F;
					this.Tail4.zRot = Mth.cos(-f2 * 0.1F + 2.8F) * 0.025F;
					this.Tail5.xRot = -0.35F;
					this.Tail5.yRot = Mth.cos(-f2 * 0.1F + 3.5F) * 0.55F;
					this.Tail5.zRot = Mth.cos(-f2 * 0.1F + 3.5F) * 0.05F;
					this.Tail6.xRot = -0.35F;
					this.Tail6.yRot = Mth.cos(-f2 * 0.1F + 4.2F) * 0.6F;
					this.Tail6.zRot = Mth.cos(-f2 * 0.1F + 4.2F) * 0.05F;
					this.TailHeadBase.xRot = -0.15F;
					this.TailHeadBase.yRot = Mth.cos(-f2 * 0.1F + 4.9F) * 0.65F;
					this.TailHeadBase.zRot = Mth.cos(-f2 * 0.1F + 4.9F) * 0.025F;
					this.TailHead1.xRot = 0.2618F;
					this.TailJaw1.xRot = angleX * 0.1F - 0.15F;
		    	}
	    	}
	    	else
	    	{
	    		this.setFace(1);
		    	//高度
this.animTransX += (0F); this.animTransY += (0.17F); this.animTransZ += (0F);
		  	    //手臂晃動 
			  	this.ArmLeft01.xRot = -1.7F;
			    this.ArmLeft01.yRot = -0.1F;
			    this.ArmLeft01.zRot = 0F;
			    this.ArmRight01.xRot = -1.8F;
				this.ArmRight01.yRot = 0.1F;
				this.ArmRight01.zRot = 0F;
				//頭部角度
				this.Head.xRot = -1.5F;
				this.Head.yRot = 0F;
				this.Head.zRot = 0.7F;
				this.Cap2.xRot = -1.74F;
				//身體角度
				this.BodyMain.xRot = 1.8F;
				this.Cloth2.xRot = -0.3491F;
				//腿擺動
				addk1 = -1.8F;
				addk2 =-1.8F;
				this.LegLeft.yRot = -0.23F;
				this.LegRight.yRot = 0.23F;
				//bag
				this.BagStrap1.xRot = 0.2618F;
				this.BagStrap1.yRot = 0F;
				this.BagStrap1.zRot = 0F;
				this.BagStrap2.xRot = 0.3491F;
				this.BagStrap2.yRot = 0.3491F;
				//tail
				this.TailBase.xRot = 1.6F;
				this.TailBase.yRot = 0F;
				this.TailBase.zRot = 3.1415F;
				this.Tail1.xRot = 0.8F;
				this.Tail1.yRot = 0F;
				this.Tail1.zRot = 0F;
				this.Tail2.xRot = 0.8F;
				this.Tail2.yRot = 0F;
				this.Tail2.zRot = 0F;
				this.Tail3.xRot = 0.9F;
				this.Tail3.yRot = 0F;
				this.Tail3.zRot = 0F;
				this.Tail4.xRot = 0.9F;
				this.Tail4.yRot = 0F;
				this.Tail4.zRot = 0F;
				this.Tail5.xRot = 0.4F;
				this.Tail5.yRot = 0F;
				this.Tail5.zRot = 0F;
				this.Tail6.xRot = -0.4F;
				this.Tail6.yRot = 0F;
				this.Tail6.zRot = 0F;
				this.TailHeadBase.xRot = -0.3F;
				this.TailHeadBase.yRot = 0F;
				this.TailHeadBase.zRot = 0.8F;
				this.TailHead1.xRot = 0.1745F;
				this.TailJaw1.xRot = -0.5F;
	    	}
  		}//end if sitting
	    
	    //攻擊動作    
	    if (ent.getAttackTick() > 0)
	    {
	    	//高度
this.animTransX += (0F); this.animTransY += (0.13F); this.animTransZ += (0F);
	  	    //手臂晃動 
		  	this.ArmLeft01.xRot = 0.5236F;
		    this.ArmLeft01.yRot = 0F;
		    this.ArmLeft01.zRot = -0.5236F;
		    this.ArmRight01.xRot = -2.7925F;
			this.ArmRight01.yRot = 0F;
			this.ArmRight01.zRot = -0.2618F;
			//頭部角度
			this.Head.xRot = -1.2217F;
			this.Head.yRot = 0F;
			//身體角度
			this.BodyMain.xRot = 1.0472F;
			this.Cloth2.xRot = -0.5236F;
			//腿擺動
			addk1 = addk1 - 1.48F;
			addk2 = addk2 - 0.26F;
			this.LegLeft.yRot = 0F;
			this.LegRight.yRot = 0F;
			//bag
			this.BagStrap1.xRot = 0.15F;
			this.BagStrap1.yRot = -1.0472F;
			this.BagStrap1.zRot = 0F;
			this.BagStrap2.xRot = 0.3491F;
			this.BagStrap2.yRot = 0.3491F;
			//tail
			this.TailBase.xRot = 0.6F;
			this.TailBase.yRot = 0F;
			this.TailBase.zRot = 3.1416F;
			this.Tail1.xRot = -0.2618F;
			this.Tail1.yRot = 0F;
			this.Tail1.zRot = 0F;
			this.Tail2.xRot = -0.5236F;
			this.Tail2.yRot = 0F;
			this.Tail2.zRot = 0F;
			this.Tail3.xRot = -0.2618F;
			this.Tail3.yRot = 0F;
			this.Tail3.zRot = 0F;
			this.Tail4.xRot = -0.2618F;
			this.Tail4.yRot = 0F;
			this.Tail4.zRot = 0F;
			this.Tail5.xRot = -0.5236F;
			this.Tail5.yRot = 0F;
			this.Tail5.zRot = 0F;
			this.Tail6.xRot = -0.5236F;
			this.Tail6.yRot = 0F;
			this.Tail6.zRot = 0F;
			this.TailHeadBase.xRot = -0.2618F;
			this.TailHeadBase.yRot = 0F;
			this.TailHeadBase.zRot = 0F;
			
			if (ent.getAttackTick() > 47)
			{
				this.TailHead1.xRot = (50 - ent.getAttackTick()) * 0.15F + 0.4F;
				this.TailJaw1.xRot = (ent.getAttackTick() - 50) * 0.15F - 0.4F;
			}
			else if (ent.getAttackTick() > 39)
			{
				this.TailHead1.xRot = 0.76F - (46 - ent.getAttackTick()) * 0.06F;
				this.TailJaw1.xRot = -0.76F + (46 - ent.getAttackTick()) * 0.06F;
			}
			else
			{
				this.TailHead1.xRot = 0.4F;
				this.TailJaw1.xRot = -0.4F;
			}
	    }
	    
	    //swing arm
	  	float f6 = ent.getSwingTime(f2 - (int)f2);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight01.xRot = -0.6F;
	        this.ArmRight01.yRot = 0F;
	        this.ArmRight01.zRot = 0.2F;
	        this.ArmRight01.xRot += -f8 * 80.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.yRot += -f7 * 20.0F * Values.N.DIV_PI_180 + 0.2F;
	        this.ArmRight01.zRot += -f8 * 20.0F * Values.N.DIV_PI_180;
	  	}
	    
	    //leg motion
	    this.LegLeft.xRot = addk1;
	    this.LegRight.xRot = addk2;
	
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
				this.setMouth(5);
			}
		}
		else
		{
			this.setFace(7);

			if (t < 190)
			{
				this.setMouth(2);
			}
			else
			{
				this.setMouth(5);
			}
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
				this.setMouth(4);
			}
		}
		else if (t < 320)
		{
			this.setFace(2);
			
			if (t < 220)
			{
				this.setMouth(3);
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
				this.setMouth(5);
			}
			else
			{
				this.setMouth(4);
			}
		}
		else
		{
			this.setFace(5);
			
			if (t < 470)
			{
				this.setMouth(4);
			}
			else
			{
				this.setMouth(5);
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
				this.setMouth(4);
			}
			else
			{
				this.setMouth(5);
			}
		}
		else if (t < 400)
		{
			this.setFace(3);
			
			if (t < 250)
			{
				this.setMouth(4);
			}
			else
			{
				this.setMouth(5);
			}
		}
		else
		{
			this.setFace(9);
			
			if (t < 450)
			{
				this.setMouth(4);
			}
			else
			{
				this.setMouth(5);
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
		this.setMouth(5);
	
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
				this.setMouth(4);
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
				this.setMouth(4);
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
				this.setMouth(4);
			}
		}
		else
		{
			this.setFace(0);

			if (t < 420)
			{
				this.setMouth(3);
			}
			else
			{
				this.setMouth(4);
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
			this.setMouth(2);
		}
		else
		{
			this.setMouth(4);
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
				this.setMouth(4);
			}
			else
			{
				this.setMouth(5);
			}
		}
		else
		{
			this.setFace(8);
			this.setMouth(4);
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

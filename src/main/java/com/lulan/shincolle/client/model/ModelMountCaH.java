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

public class ModelMountCaH<T extends Entity> extends ShipModel<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart Seat01;
	public ModelPart Back01;
	public ModelPart Back02;
	public ModelPart Back03;
	public ModelPart Back04;
	public ModelPart WingL02;
	public ModelPart WingR02;
	public ModelPart CannonL01;
	public ModelPart CannonR01;
	public ModelPart Tube01a;
	public ModelPart Tube02a;
	public ModelPart Cannon01a;
	public ModelPart Cannon01a_1;
	public ModelPart Cannon01a_2;
	public ModelPart Cannon01a_3;
	public ModelPart Cannon01a_4;
	public ModelPart Cannon01a_5;
	public ModelPart Cannon01a_6;
	public ModelPart Cannon01a_7;
	public ModelPart Tube01a_1;
	public ModelPart Tube01a_2;
	public ModelPart Head01;
	public ModelPart Jaw01;
	public ModelPart Head02;
	public ModelPart HeadTooth01;
	public ModelPart HeadTooth02;
	public ModelPart Jaw02;
	public ModelPart JawTooth01;
	public ModelPart JawTooth02;
	public ModelPart CannonL02;
	public ModelPart CannonR02;
	public ModelPart Tube01b;
	public ModelPart Tube02b;
	public ModelPart Cannon01b;
	public ModelPart Cannon01c;
	public ModelPart Cannon01b_1;
	public ModelPart Cannon01c_1;
	public ModelPart Cannon01b_2;
	public ModelPart Cannon01c_2;
	public ModelPart Cannon01b_3;
	public ModelPart Cannon01c_3;
	public ModelPart Cannon01b_4;
	public ModelPart Cannon01c_4;
	public ModelPart Cannon01b_5;
	public ModelPart Cannon01c_5;
	public ModelPart Cannon01b_6;
	public ModelPart Cannon01c_6;
	public ModelPart Cannon01b_7;
	public ModelPart Cannon01c_7;
	public ModelPart Tube01b_1;
	public ModelPart Tube01b_2;
	public ModelPart GlowBodyMain;
	public ModelPart GlowBodyMain2;
	public ModelPart GlowNeck;
	public ModelPart GlowJaw01;
	public ModelPart GlowHead01;
	public ModelPart GlowCannonL01;
	public ModelPart GlowCannonR01;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, 0.0F, 0.0F, 13.0F, 12.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 8.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Back02", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 10.0F, 14.0F, 4.0F), PartPose.offset(0.0F, -7.0F, 6.0F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("Cannon01a_7", CubeListBuilder.create().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-12.5F, 7.5F, 5.0F, -0.17453292519943295F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("Cannon01b_7", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 0.0F, -1.8F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("Cannon01c_7", CubeListBuilder.create().addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 0.0F, -4.0F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("Seat01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -10.5F, 0.3F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef0.addOrReplaceChild("Cannon01a", CubeListBuilder.create().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(8.0F, 12.0F, 4.0F, 0.20943951023931953F, -0.2617993877991494F, 0.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("Cannon01b", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 0.0F, -1.8F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("Cannon01c", CubeListBuilder.create().addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 0.0F, -4.0F));
		PartDefinition partdef9 = partdef0.addOrReplaceChild("Tube02a", CubeListBuilder.create().addBox(-1.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(-3.0F, 2.0F, 9.0F, -0.7853981633974483F, -0.13962634015954636F, -0.2617993877991494F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("Tube02b", CubeListBuilder.create().addBox(-1.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 1.3962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef0.addOrReplaceChild("Cannon01a_6", CubeListBuilder.create().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-9.0F, 8.0F, 4.0F, -0.13962634015954636F, 0.2617993877991494F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("Cannon01b_6", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 0.0F, -1.8F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("Cannon01c_6", CubeListBuilder.create().addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 0.0F, -4.0F));
		PartDefinition partdef14 = partdef0.addOrReplaceChild("CannonR01", CubeListBuilder.create().addBox(-3.5F, -5.0F, -8.0F, 7.0F, 5.0F, 8.0F), PartPose.offsetAndRotation(-4.0F, -6.0F, 9.0F, -0.6981317007977318F, 0.10471975511965977F, 0.0F));
		PartDefinition partdef15 = partdef0.addOrReplaceChild("Cannon01a_1", CubeListBuilder.create().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(12.0F, 11.0F, 5.0F, 0.13962634015954636F, -0.41887902047863906F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("Cannon01b_1", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 0.0F, -1.8F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("Cannon01c_1", CubeListBuilder.create().addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 0.0F, -4.0F));
		PartDefinition partdef18 = partdef0.addOrReplaceChild("Cannon01a_5", CubeListBuilder.create().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-12.0F, 11.0F, 5.0F, 0.20943951023931953F, 0.3141592653589793F, 0.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("Cannon01b_5", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 0.0F, -1.8F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("Cannon01c_5", CubeListBuilder.create().addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 0.0F, -4.0F));
		PartDefinition partdef21 = partdef0.addOrReplaceChild("CannonL01", CubeListBuilder.create().addBox(-3.5F, -5.0F, -8.0F, 7.0F, 5.0F, 8.0F), PartPose.offsetAndRotation(4.0F, -6.0F, 9.0F, -0.6981317007977318F, -0.10471975511965977F, 0.0F));
		PartDefinition partdef22 = partdef0.addOrReplaceChild("Cannon01a_4", CubeListBuilder.create().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-8.0F, 12.0F, 4.0F, 0.20943951023931953F, 0.20943951023931953F, 0.0F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("Cannon01b_4", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 0.0F, -1.8F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("Cannon01c_4", CubeListBuilder.create().addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 0.0F, -4.0F));
		PartDefinition partdef25 = partdef0.addOrReplaceChild("Tube01a_1", CubeListBuilder.create().addBox(0.0F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(11.0F, 8.0F, 7.0F, -0.6981317007977318F, 0.0F, -0.3490658503988659F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("Tube01b_1", CubeListBuilder.create().addBox(0.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 1.0F, 1.3962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 12.0F, 5.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("Head01", CubeListBuilder.create().addBox(-7.0F, -6.0F, -15.0F, 14.0F, 6.0F, 13.0F), PartPose.offset(0.0F, 5.8F, 5.0F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("Head02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 10.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -5.9F, -15.0F, 0.0F, 0.7853981633974483F, 0.0F));
		PartDefinition partdef30 = partdef27.addOrReplaceChild("Jaw01", CubeListBuilder.create().mirror().addBox(-7.0F, 0.0F, -15.0F, 14.0F, 6.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 6.0F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("Jaw02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 10.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -0.1F, -15.0F, 0.0F, 0.7853981633974483F, 0.0F));
		PartDefinition partdef32 = partdef0.addOrReplaceChild("Cannon01a_3", CubeListBuilder.create().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(12.5F, 7.5F, 5.0F, -0.05235987755982988F, -0.5235987755982988F, 0.0F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("Cannon01b_3", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 0.0F, -1.8F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("Cannon01c_3", CubeListBuilder.create().addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 0.0F, -4.0F));
		PartDefinition partdef35 = partdef0.addOrReplaceChild("Back01", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 9.0F, 5.0F), PartPose.offset(0.0F, -9.0F, 1.0F));
		PartDefinition partdef36 = partdef0.addOrReplaceChild("Back04", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 7.0F, 6.0F));
		PartDefinition partdef37 = partdef0.addOrReplaceChild("Cannon01a_2", CubeListBuilder.create().addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(9.0F, 8.0F, 4.0F, -0.13962634015954636F, -0.3141592653589793F, 0.0F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("Cannon01b_2", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 0.0F, -1.8F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("Cannon01c_2", CubeListBuilder.create().addBox(-0.5F, -0.5F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 0.0F, -4.0F));
		PartDefinition partdef40 = partdef0.addOrReplaceChild("Tube01a_2", CubeListBuilder.create().addBox(0.0F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(-12.0F, 8.0F, 6.7F, -0.6981317007977318F, 0.0F, 0.3490658503988659F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("Tube01b_2", CubeListBuilder.create().addBox(0.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 1.0F, 1.3962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef42 = partdef0.addOrReplaceChild("Back03", CubeListBuilder.create().addBox(-9.0F, 0.0F, 0.0F, 18.0F, 14.0F, 7.0F), PartPose.offset(0.0F, -5.0F, 0.0F));
		PartDefinition partdef43 = partdef0.addOrReplaceChild("Tube01a", CubeListBuilder.create().addBox(0.0F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(2.0F, 1.0F, 9.0F, -0.7853981633974483F, 0.8726646259971648F, 0.2617993877991494F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("Tube01b", CubeListBuilder.create().addBox(0.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 1.0F, 1.3962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef45 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 8.0F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("GlowJaw01", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 7.0F, 6.0F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("JawTooth01", CubeListBuilder.create().addBox(-6.5F, 0.0F, -14.0F, 13.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -0.8F, -0.8F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("JawTooth02", CubeListBuilder.create().addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -13.9F, -0.07504915783575616F, 0.7853981633974483F, -0.05235987755982988F));
		PartDefinition partdef50 = partdef46.addOrReplaceChild("GlowHead01", CubeListBuilder.create(), PartPose.offset(0.0F, 5.8F, 5.0F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("HeadTooth01", CubeListBuilder.create().addBox(-6.5F, 0.0F, -6.5F, 13.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 1.9F, -7.5F, -0.13962634015954636F, 0.0F, 3.141592653589793F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("HeadTooth02", CubeListBuilder.create().addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -6.4F, -0.07504915783575616F, 0.7853981633974483F, -0.05235987755982988F));
		PartDefinition partdef53 = partdef45.addOrReplaceChild("GlowCannonL01", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, -6.0F, 9.0F, -0.6981317007977318F, -0.10471975511965977F, 0.0F));
		PartDefinition partdef54 = partdef53.addOrReplaceChild("CannonL02", CubeListBuilder.create().addBox(-1.0F, -1.0F, -12.0F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -3.2F, -7.5F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef55 = partdef45.addOrReplaceChild("GlowCannonR01", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, -6.0F, 9.0F, -0.6981317007977318F, 0.10471975511965977F, 0.0F));
		PartDefinition partdef56 = partdef55.addOrReplaceChild("CannonR02", CubeListBuilder.create().addBox(-1.0F, -1.0F, -12.0F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -3.2F, -7.5F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef57 = partdefinition.addOrReplaceChild("GlowBodyMain2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 8.0F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("WingL02", CubeListBuilder.create().addBox(0.0F, -3.0F, -14.0F, 4.0F, 6.0F, 17.0F), PartPose.offsetAndRotation(6.0F, -2.0F, 6.0F, 0.0F, -0.10471975511965977F, 0.0F));
		PartDefinition partdef59 = partdef57.addOrReplaceChild("WingR02", CubeListBuilder.create().mirror().addBox(-4.0F, -3.0F, -14.0F, 4.0F, 6.0F, 17.0F), PartPose.offsetAndRotation(-6.0F, -2.0F, 6.0F, 0.0F, 0.10471975511965977F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	public ModelMountCaH(ModelPart root)
	{
		this.CannonR02 = root.getChild("GlowBodyMain").getChild("GlowCannonR01").getChild("CannonR02");
		this.BodyMain = root.getChild("BodyMain");
		this.Back02 = root.getChild("BodyMain").getChild("Back02");
		this.Cannon01a_7 = root.getChild("BodyMain").getChild("Cannon01a_7");
		this.Cannon01c = root.getChild("BodyMain").getChild("Cannon01a").getChild("Cannon01b").getChild("Cannon01c");
		this.WingL02 = root.getChild("GlowBodyMain2").getChild("WingL02");
		this.Cannon01b_3 = root.getChild("BodyMain").getChild("Cannon01a_3").getChild("Cannon01b_3");
		this.Seat01 = root.getChild("BodyMain").getChild("Seat01");
		this.HeadTooth02 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead01").getChild("HeadTooth01").getChild("HeadTooth02");
		this.Cannon01a = root.getChild("BodyMain").getChild("Cannon01a");
		this.Cannon01b_1 = root.getChild("BodyMain").getChild("Cannon01a_1").getChild("Cannon01b_1");
		this.Cannon01c_2 = root.getChild("BodyMain").getChild("Cannon01a_2").getChild("Cannon01b_2").getChild("Cannon01c_2");
		this.Tube02a = root.getChild("BodyMain").getChild("Tube02a");
		this.Cannon01a_6 = root.getChild("BodyMain").getChild("Cannon01a_6");
		this.Jaw02 = root.getChild("BodyMain").getChild("Neck").getChild("Jaw01").getChild("Jaw02");
		this.CannonR01 = root.getChild("BodyMain").getChild("CannonR01");
		this.Cannon01b_6 = root.getChild("BodyMain").getChild("Cannon01a_6").getChild("Cannon01b_6");
		this.Cannon01a_1 = root.getChild("BodyMain").getChild("Cannon01a_1");
		this.Cannon01c_5 = root.getChild("BodyMain").getChild("Cannon01a_5").getChild("Cannon01b_5").getChild("Cannon01c_5");
		this.Head01 = root.getChild("BodyMain").getChild("Neck").getChild("Head01");
		this.Cannon01a_5 = root.getChild("BodyMain").getChild("Cannon01a_5");
		this.Cannon01c_7 = root.getChild("BodyMain").getChild("Cannon01a_7").getChild("Cannon01b_7").getChild("Cannon01c_7");
		this.Tube01b_2 = root.getChild("BodyMain").getChild("Tube01a_2").getChild("Tube01b_2");
		this.CannonL01 = root.getChild("BodyMain").getChild("CannonL01");
		this.Cannon01a_4 = root.getChild("BodyMain").getChild("Cannon01a_4");
		this.Tube01a_1 = root.getChild("BodyMain").getChild("Tube01a_1");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.Cannon01b_2 = root.getChild("BodyMain").getChild("Cannon01a_2").getChild("Cannon01b_2");
		this.Head02 = root.getChild("BodyMain").getChild("Neck").getChild("Head01").getChild("Head02");
		this.Tube01b = root.getChild("BodyMain").getChild("Tube01a").getChild("Tube01b");
		this.Cannon01c_1 = root.getChild("BodyMain").getChild("Cannon01a_1").getChild("Cannon01b_1").getChild("Cannon01c_1");
		this.HeadTooth01 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead01").getChild("HeadTooth01");
		this.Cannon01b_5 = root.getChild("BodyMain").getChild("Cannon01a_5").getChild("Cannon01b_5");
		this.Cannon01a_3 = root.getChild("BodyMain").getChild("Cannon01a_3");
		this.Back01 = root.getChild("BodyMain").getChild("Back01");
		this.Back04 = root.getChild("BodyMain").getChild("Back04");
		this.Cannon01b_4 = root.getChild("BodyMain").getChild("Cannon01a_4").getChild("Cannon01b_4");
		this.Tube02b = root.getChild("BodyMain").getChild("Tube02a").getChild("Tube02b");
		this.Cannon01c_3 = root.getChild("BodyMain").getChild("Cannon01a_3").getChild("Cannon01b_3").getChild("Cannon01c_3");
		this.Cannon01b_7 = root.getChild("BodyMain").getChild("Cannon01a_7").getChild("Cannon01b_7");
		this.Cannon01a_2 = root.getChild("BodyMain").getChild("Cannon01a_2");
		this.WingR02 = root.getChild("GlowBodyMain2").getChild("WingR02");
		this.Cannon01b = root.getChild("BodyMain").getChild("Cannon01a").getChild("Cannon01b");
		this.Tube01a_2 = root.getChild("BodyMain").getChild("Tube01a_2");
		this.Tube01b_1 = root.getChild("BodyMain").getChild("Tube01a_1").getChild("Tube01b_1");
		this.JawTooth02 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw01").getChild("JawTooth01").getChild("JawTooth02");
		this.CannonL02 = root.getChild("GlowBodyMain").getChild("GlowCannonL01").getChild("CannonL02");
		this.Jaw01 = root.getChild("BodyMain").getChild("Neck").getChild("Jaw01");
		this.Cannon01c_6 = root.getChild("BodyMain").getChild("Cannon01a_6").getChild("Cannon01b_6").getChild("Cannon01c_6");
		this.JawTooth01 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw01").getChild("JawTooth01");
		this.Back03 = root.getChild("BodyMain").getChild("Back03");
		this.Tube01a = root.getChild("BodyMain").getChild("Tube01a");
		this.Cannon01c_4 = root.getChild("BodyMain").getChild("Cannon01a_4").getChild("Cannon01b_4").getChild("Cannon01c_4");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowJaw01 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw01");
		this.GlowHead01 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead01");
		this.GlowCannonL01 = root.getChild("GlowBodyMain").getChild("GlowCannonL01");
		this.GlowCannonR01 = root.getChild("GlowBodyMain").getChild("GlowCannonR01");
		this.GlowBodyMain2 = root.getChild("GlowBodyMain2");
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
		poseStack.pushPose();
		poseStack.translate(this.animTransX, this.animTransY, this.animTransZ);
		poseStack.mulPose(this.animRot);
		poseStack.scale(this.animScaleX, this.animScaleY, this.animScaleZ);
    	this.BodyMain.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
    	//light part
    	
		glowLight = true;
    	this.GlowBodyMain.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
    	float light = 80F + Mth.cos(f2 * 0.075F) * 80F;
		glowLight = false;
    	this.GlowBodyMain2.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);
    	
    	poseStack.popPose();
    
	}

	@Override
	public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)
	{
		this.captureAnimParms(entity, f, f1, f2, f3, f4);

    	//FIX: head rotation bug while riding
    	if (f3 <= -180F) { f3 += 360F; }
    	else if (f3 >= 180F) { f3 -= 360F; }
    	
    	
    	RenderHelper.animScale(this, 1.1F, 1.1F, 1.1F);
this.animTransX += (0F); this.animTransY += (0.12F); this.animTransZ += (-0.1F);
    	
    	//main body

		
		IShipEmotion ent = (IShipEmotion)entity;
		  
		motionHumanPos(f, f1, f2, f3, f4, ent);
    
	}

	private void motionHumanPos(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{
   
  		float angleX = Mth.cos(f2*0.08F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.7F;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.7F;
  		float addk1 = 0F;
  		float addk2 = 0F;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.025F + 0.025F); this.animTransZ += (0F);
    	}
  		
	    //正常站立動作
	  	//嘴巴
	  	this.Jaw01.xRot = angleX * 0.025F + 0.32F;
	    //cannon
	  	this.CannonL02.xRot = angleX * 0.05F - 0.3F;
	  	this.CannonR02.xRot = -angleX * 0.05F;
	    
    	//seat2 有載人動作
	    if (ent.getStateEmotion(ID.S.Emotion) > 0)
	    {
	    	this.Jaw01.xRot = 0.7F;
	    }
	    
	    //發光支架
	    this.GlowJaw01.xRot = this.Jaw01.xRot;
  	
	}

}

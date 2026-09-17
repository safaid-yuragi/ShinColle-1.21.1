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

public class ModelDestroyerHime<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart Butt;
	public ModelPart ArmRight01;
	public ModelPart ArmLeft01;
	public ModelPart Cloth01;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Hair02;
	public ModelPart Hat01;
	public ModelPart HairU01;
	public ModelPart Ahoke;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart Hair01;
	public ModelPart Hair03;
	public ModelPart Hair04;
	public ModelPart Hair05;
	public ModelPart Hair06;
	public ModelPart Hat02a;
	public ModelPart Hat03;
	public ModelPart Hat04a;
	public ModelPart Hat05a;
	public ModelPart Hat06a;
	public ModelPart Hat06b;
	public ModelPart Hat02b;
	public ModelPart Hat04b;
	public ModelPart Hat04c;
	public ModelPart Hat05b;
	public ModelPart LegLeft01;
	public ModelPart LegRight01;
	public ModelPart EquipLegL;
	public ModelPart EquipLegR;
	public ModelPart EquipBaseL;
	public ModelPart EquipBaseR;
	public ModelPart BeltBase;
	public ModelPart LegLeft02;
	public ModelPart LegRight02;
	public ModelPart EquipLHead;
	public ModelPart EquipLJaw;
	public ModelPart EquipLB;
	public ModelPart EquipLT01;
	public ModelPart EquipLTU;
	public ModelPart EquipHeadC01;
	public ModelPart EquipHeadC02;
	public ModelPart EquipLTD;
	public ModelPart EquipLT02a;
	public ModelPart EquipLT02b;
	public ModelPart EquipLT02c;
	public ModelPart EquipLT02d;
	public ModelPart EquipRHead;
	public ModelPart EquipLJaw_1;
	public ModelPart EquipLB_1;
	public ModelPart EquipLT01_1;
	public ModelPart EquipLTU_1;
	public ModelPart EquipHeadC01_1;
	public ModelPart EquipHeadC02_1;
	public ModelPart EquipLTD_1;
	public ModelPart EquipLT02a_1;
	public ModelPart EquipLT02b_1;
	public ModelPart EquipLT02c_1;
	public ModelPart EquipLT02d_1;
	public ModelPart Belt01;
	public ModelPart Belt02;
	public ModelPart Belt03;
	public ModelPart Belt04;
	public ModelPart Belt05;
	public ModelPart Belt06;
	public ModelPart Belt07;
	public ModelPart ArmRight02;
	public ModelPart ArmRight02a;
	public ModelPart ArmLeft02;
	public ModelPart ArmLeft02a;
	public ModelPart Cannon01;
	public ModelPart Cannon02;
	public ModelPart Cannon03;
	public ModelPart Cannon04;
	public ModelPart Cannon05;
	public ModelPart Cloth02;
	public ModelPart Skirt01;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().mirror().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.2617993877991494F, 0.0F, 0.7853981633974483F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("ArmRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(-3.0F, 11.0F, 2.5F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("ArmRight02a", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(2.5F, 6.5F, -2.4F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("EquipLegL", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 9.0F, 7.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef6 = partdef4.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -6.0F, 17.0F, 7.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 2.5F, -0.5F, -0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef4.addOrReplaceChild("EquipLegR", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 9.0F, 7.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.20943951023931953F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef8 = partdef4.addOrReplaceChild("BeltBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("Belt05", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.0F, 9.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 4.0F, 0.0F, 0.10471975511965977F, 0.0F));
		PartDefinition partdef10 = partdef8.addOrReplaceChild("Belt01", CubeListBuilder.create().addBox(-9.0F, 0.0F, 0.0F, 9.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -1.0F, -8.0F, 0.0F, 0.10471975511965977F, 0.0F));
		PartDefinition partdef11 = partdef8.addOrReplaceChild("Belt02", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -1.0F, -8.0F, 0.0F, -0.10471975511965977F, 0.0F));
		PartDefinition partdef12 = partdef8.addOrReplaceChild("Belt06", CubeListBuilder.create().addBox(-9.0F, 0.0F, -1.0F, 9.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 4.0F, 0.0F, -0.10471975511965977F, 0.0F));
		PartDefinition partdef13 = partdef8.addOrReplaceChild("Belt03", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 9.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-8.9F, -1.0F, 2.8F, 0.0F, 1.5707963267948966F, 0.0F));
		PartDefinition partdef14 = partdef8.addOrReplaceChild("Belt07", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(8.8F, -2.1F, -4.0F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef8.addOrReplaceChild("Belt04", CubeListBuilder.create().addBox(-9.0F, 0.0F, 0.0F, 9.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(8.9F, -1.0F, 2.8F, 0.0F, -1.5707963267948966F, 0.0F));
		PartDefinition partdef16 = partdef4.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("LegLeft02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(3.0F, 14.0F, -3.0F));
		PartDefinition partdef18 = partdef4.addOrReplaceChild("LegRight01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.20943951023931953F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("LegRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(-3.0F, 14.0F, -3.0F));
		PartDefinition partdef20 = partdef4.addOrReplaceChild("EquipBaseL", CubeListBuilder.create().addBox(0.0F, -3.0F, -3.0F, 16.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(7.0F, 10.0F, -3.0F, 0.05235987755982988F, -0.13962634015954636F, 0.13962634015954636F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("EquipLHead", CubeListBuilder.create().addBox(-5.5F, -6.0F, -10.0F, 11.0F, 6.0F, 14.0F), PartPose.offsetAndRotation(9.0F, -2.0F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("EquipLTU", CubeListBuilder.create().addBox(-4.5F, 0.0F, -9.0F, 9.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -1.1F, -0.7F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef23 = partdef21.addOrReplaceChild("EquipHeadC01", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -8.7F, -7.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("EquipHeadC02", CubeListBuilder.create().addBox(-0.5F, -0.6F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 1.5F, 0.5F));
		PartDefinition partdef25 = partdef20.addOrReplaceChild("EquipLT01", CubeListBuilder.create().addBox(0.0F, -5.0F, -6.0F, 4.0F, 11.0F, 10.0F), PartPose.offsetAndRotation(15.0F, 0.0F, 0.0F, 0.0F, -0.13962634015954636F, 0.0F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("EquipLT02b", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(2.0F, -0.3F, -5.8F));
		PartDefinition partdef27 = partdef25.addOrReplaceChild("EquipLT02d", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(2.0F, 4.3F, -5.8F));
		PartDefinition partdef28 = partdef25.addOrReplaceChild("EquipLT02c", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(2.0F, 2.0F, -5.8F));
		PartDefinition partdef29 = partdef25.addOrReplaceChild("EquipLT02a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(2.0F, -2.6F, -5.8F));
		PartDefinition partdef30 = partdef20.addOrReplaceChild("EquipLJaw", CubeListBuilder.create().addBox(-4.0F, 4.0F, -9.0F, 8.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(9.0F, 0.0F, -1.2F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("EquipLTD", CubeListBuilder.create().mirror().addBox(-4.5F, 0.0F, -9.0F, 9.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 0.2F, 0.08726646259971647F, 0.0F, 3.141592653589793F));
		PartDefinition partdef32 = partdef20.addOrReplaceChild("EquipLB", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 10.0F, 10.0F, 8.0F), PartPose.offsetAndRotation(9.0F, -3.5F, -5.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef33 = partdef4.addOrReplaceChild("EquipBaseR", CubeListBuilder.create().addBox(-16.0F, -3.0F, -3.0F, 16.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(-7.0F, 10.0F, -3.0F, 0.05235987755982988F, 0.13962634015954636F, -0.13962634015954636F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("EquipRHead", CubeListBuilder.create().addBox(-5.5F, -6.0F, -10.0F, 11.0F, 6.0F, 14.0F), PartPose.offsetAndRotation(-9.0F, -2.0F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("EquipLTU_1", CubeListBuilder.create().addBox(-4.5F, 0.0F, -9.0F, 9.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -1.1F, -0.7F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef36 = partdef34.addOrReplaceChild("EquipHeadC01_1", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -8.7F, -7.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef37 = partdef36.addOrReplaceChild("EquipHeadC02_1", CubeListBuilder.create().addBox(-0.5F, -0.6F, -7.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 1.5F, 0.5F));
		PartDefinition partdef38 = partdef33.addOrReplaceChild("EquipLT01_1", CubeListBuilder.create().addBox(-4.0F, -5.0F, -6.0F, 4.0F, 11.0F, 10.0F), PartPose.offsetAndRotation(-15.0F, 0.0F, 0.0F, 0.0F, 0.13962634015954636F, 0.0F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("EquipLT02a_1", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(-2.0F, -2.6F, -5.8F));
		PartDefinition partdef40 = partdef38.addOrReplaceChild("EquipLT02b_1", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(-2.0F, -0.3F, -5.8F));
		PartDefinition partdef41 = partdef38.addOrReplaceChild("EquipLT02d_1", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(-2.0F, 4.3F, -5.8F));
		PartDefinition partdef42 = partdef38.addOrReplaceChild("EquipLT02c_1", CubeListBuilder.create().addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(-2.0F, 2.0F, -5.8F));
		PartDefinition partdef43 = partdef33.addOrReplaceChild("EquipLJaw_1", CubeListBuilder.create().addBox(-4.0F, 4.0F, -9.0F, 8.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(-9.0F, 0.0F, -1.2F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("EquipLTD_1", CubeListBuilder.create().addBox(-4.5F, 0.0F, -9.0F, 9.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 0.2F, 0.08726646259971647F, 0.0F, 3.141592653589793F));
		PartDefinition partdef45 = partdef33.addOrReplaceChild("EquipLB_1", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 10.0F, 10.0F, 8.0F), PartPose.offsetAndRotation(-9.0F, -3.5F, -5.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef46 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-7.0F, 0.0F, -4.4F, 14.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -11.3F, 0.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("Cloth02", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 8.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 5.4F, -4.3F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef48 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-3.5F, -2.0F, -4.9F, 7.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef49 = partdef48.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.1F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-0.5F, 0.0F, -1.5F, 1.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-7.8F, 6.5F, -4.4F, -0.08726646259971647F, -0.08726646259971647F, -0.08726646259971647F));
		PartDefinition partdef52 = partdef50.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-0.5F, 0.0F, -1.5F, 1.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(7.8F, 7.0F, -4.4F, -0.13962634015954636F, 0.08726646259971647F, 0.08726646259971647F));
		PartDefinition partdef53 = partdef50.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -6.0F, -10.5F, 0.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(-0.5F, -7.0F, -6.0F, 0.20943951023931953F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef54 = partdef50.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -7.0F));
		PartDefinition partdef55 = partdef49.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(0.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(6.5F, -10.0F, 3.5F, 0.0F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef56 = partdef55.addOrReplaceChild("Hair03", CubeListBuilder.create().addBox(0.0F, -3.0F, -2.0F, 4.0F, 11.0F, 4.0F), PartPose.offsetAndRotation(1.7F, 0.0F, 0.0F, -0.08726646259971647F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef57 = partdef56.addOrReplaceChild("Hair04", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F), PartPose.offsetAndRotation(2.0F, 6.5F, 0.0F, 0.2617993877991494F, 0.0F, -0.22759093446006054F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("Hair05", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.5235987755982988F, 0.0F, 0.3490658503988659F));
		PartDefinition partdef59 = partdef58.addOrReplaceChild("Hair06", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.2617993877991494F, 0.0F, 0.5235987755982988F));
		PartDefinition partdef60 = partdef49.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, -7.0F, 15.0F, 5.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 9.9F, 10.0F, 0.15707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef62 = partdef49.addOrReplaceChild("Hat01", CubeListBuilder.create().addBox(-6.0F, -6.0F, -6.0F, 12.0F, 6.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -11.0F, 1.0F, -0.4363323129985824F, 0.0F, 0.0F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("Hat04a", CubeListBuilder.create().addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -7.4F, -5.5F, 0.2617993877991494F, 0.2617993877991494F, -0.17453292519943295F));
		PartDefinition partdef64 = partdef63.addOrReplaceChild("Hat04b", CubeListBuilder.create().addBox(-2.5F, -5.0F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -6.8F, -0.4F, -0.5235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef65 = partdef64.addOrReplaceChild("Hat04c", CubeListBuilder.create().addBox(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -3.9F, 0.0F, -0.6108652381980153F, 0.0F, 0.0F));
		PartDefinition partdef66 = partdef62.addOrReplaceChild("Hat05a", CubeListBuilder.create().addBox(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(2.0F, -10.0F, 6.0F, -0.08726646259971647F, 0.5235987755982988F, 0.17453292519943295F));
		PartDefinition partdef67 = partdef66.addOrReplaceChild("Hat05b", CubeListBuilder.create().addBox(-1.5F, -4.0F, -1.5F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -4.1F, 0.3F, 0.6108652381980153F, 0.0F, 0.0F));
		PartDefinition partdef68 = partdef62.addOrReplaceChild("Hat03", CubeListBuilder.create().addBox(-8.5F, -6.0F, 0.0F, 17.0F, 7.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -5.4F, 0.0F, -0.27314402793711257F, 0.0F, 0.0F));
		PartDefinition partdef69 = partdef62.addOrReplaceChild("Hat02b", CubeListBuilder.create().addBox(0.0F, -6.0F, -7.0F, 10.0F, 7.0F, 13.0F), PartPose.offsetAndRotation(-0.7F, -5.0F, -2.9F, 0.17453292519943295F, -0.05235987755982988F, 0.05235987755982988F));
		PartDefinition partdef70 = partdef62.addOrReplaceChild("Hat06b", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 0.0F, 12.0F, 4.0F), PartPose.offsetAndRotation(8.5F, -6.4F, 2.5F, 1.0471975511965976F, 0.08726646259971647F, -0.4363323129985824F));
		PartDefinition partdef71 = partdef62.addOrReplaceChild("Hat02a", CubeListBuilder.create().addBox(-10.0F, -6.0F, -7.0F, 10.0F, 7.0F, 13.0F), PartPose.offsetAndRotation(0.7F, -5.0F, -3.0F, 0.17453292519943295F, 0.05235987755982988F, -0.05235987755982988F));
		PartDefinition partdef72 = partdef62.addOrReplaceChild("Hat06a", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 12.0F, 4.0F), PartPose.offsetAndRotation(8.5F, -6.0F, 2.0F, 0.6981317007977318F, 0.2617993877991494F, -0.6981317007977318F));
		PartDefinition partdef73 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.2617993877991494F, 0.0F, -0.7853981633974483F));
		PartDefinition partdef74 = partdef73.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(3.0F, 11.0F, 2.5F));
		PartDefinition partdef75 = partdef74.addOrReplaceChild("ArmLeft02a", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(-2.5F, 6.5F, -2.4F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef76 = partdef74.addOrReplaceChild("Cannon01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F), PartPose.offset(-2.5F, 3.0F, -2.5F));
		PartDefinition partdef77 = partdef76.addOrReplaceChild("Cannon03", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 2.3F, 0.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef78 = partdef76.addOrReplaceChild("Cannon04", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F), PartPose.offset(-1.0F, 10.0F, 0.0F));
		PartDefinition partdef79 = partdef76.addOrReplaceChild("Cannon02", CubeListBuilder.create().addBox(-4.0F, 0.0F, -6.0F, 8.0F, 13.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef80 = partdef76.addOrReplaceChild("Cannon05", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F), PartPose.offset(1.0F, 10.0F, 0.0F));
		PartDefinition partdef81 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef82 = partdef81.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef83 = partdef82.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef84 = partdef83.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef85 = partdef83.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef86 = partdef83.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef87 = partdef83.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef88 = partdef83.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef89 = partdef83.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef90 = partdef83.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef91 = partdef83.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef92 = partdef83.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef93 = partdef83.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelDestroyerHime(ModelPart root)
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
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.EquipRHead = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseR").getChild("EquipRHead");
		this.Belt05 = root.getChild("BodyMain").getChild("Butt").getChild("BeltBase").getChild("Belt05");
		this.Cloth02 = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth02");
		this.EquipLT02b = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseL").getChild("EquipLT01").getChild("EquipLT02b");
		this.EquipLT01_1 = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseR").getChild("EquipLT01_1");
		this.EquipLegL = root.getChild("BodyMain").getChild("Butt").getChild("EquipLegL");
		this.EquipLT02a_1 = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseR").getChild("EquipLT01_1").getChild("EquipLT02a_1");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.Hat04a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat04a");
		this.EquipLHead = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseL").getChild("EquipLHead");
		this.EquipLT01 = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseL").getChild("EquipLT01");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.EquipLT02d = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseL").getChild("EquipLT01").getChild("EquipLT02d");
		this.ArmLeft02a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("ArmLeft02a");
		this.Hair05 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair02").getChild("Hair03").getChild("Hair04").getChild("Hair05");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.Hat04b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat04a").getChild("Hat04b");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.EquipLTD = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseL").getChild("EquipLJaw").getChild("EquipLTD");
		this.EquipLT02b_1 = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseR").getChild("EquipLT01_1").getChild("EquipLT02b_1");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.EquipLegR = root.getChild("BodyMain").getChild("Butt").getChild("EquipLegR");
		this.EquipLJaw_1 = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseR").getChild("EquipLJaw_1");
		this.EquipLT02c = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseL").getChild("EquipLT01").getChild("EquipLT02c");
		this.EquipLT02d_1 = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseR").getChild("EquipLT01_1").getChild("EquipLT02d_1");
		this.Hair04 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair02").getChild("Hair03").getChild("Hair04");
		this.Belt01 = root.getChild("BodyMain").getChild("Butt").getChild("BeltBase").getChild("Belt01");
		this.Cannon01 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("Cannon01");
		this.EquipLJaw = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseL").getChild("EquipLJaw");
		this.Cannon03 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("Cannon01").getChild("Cannon03");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.Cannon04 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("Cannon01").getChild("Cannon04");
		this.BeltBase = root.getChild("BodyMain").getChild("Butt").getChild("BeltBase");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.Hat05a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat05a");
		this.ArmRight02a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("ArmRight02a");
		this.Belt02 = root.getChild("BodyMain").getChild("Butt").getChild("BeltBase").getChild("Belt02");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.Hat03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat03");
		this.Hat02b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat02b");
		this.Hat06b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat06b");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.EquipHeadC02 = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseL").getChild("EquipLHead").getChild("EquipHeadC01").getChild("EquipHeadC02");
		this.Cannon02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("Cannon01").getChild("Cannon02");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.EquipHeadC02_1 = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseR").getChild("EquipRHead").getChild("EquipHeadC01_1").getChild("EquipHeadC02_1");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.Belt06 = root.getChild("BodyMain").getChild("Butt").getChild("BeltBase").getChild("Belt06");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair02");
		this.BodyMain = root.getChild("BodyMain");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.EquipLT02a = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseL").getChild("EquipLT01").getChild("EquipLT02a");
		this.Hat04c = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat04a").getChild("Hat04b").getChild("Hat04c");
		this.Belt03 = root.getChild("BodyMain").getChild("Butt").getChild("BeltBase").getChild("Belt03");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.Hair06 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair02").getChild("Hair03").getChild("Hair04").getChild("Hair05").getChild("Hair06");
		this.EquipLTU_1 = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseR").getChild("EquipRHead").getChild("EquipLTU_1");
		this.Hat02a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat02a");
		this.HairU01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairU01");
		this.EquipBaseL = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseL");
		this.Cannon05 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("Cannon01").getChild("Cannon05");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.EquipBaseR = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseR");
		this.EquipLTU = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseL").getChild("EquipLHead").getChild("EquipLTU");
		this.Belt07 = root.getChild("BodyMain").getChild("Butt").getChild("BeltBase").getChild("Belt07");
		this.Hair03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair02").getChild("Hair03");
		this.Belt04 = root.getChild("BodyMain").getChild("Butt").getChild("BeltBase").getChild("Belt04");
		this.EquipLB = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseL").getChild("EquipLB");
		this.EquipLT02c_1 = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseR").getChild("EquipLT01_1").getChild("EquipLT02c_1");
		this.Hat06a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat06a");
		this.Hat01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01");
		this.Hat05b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hat01").getChild("Hat05a").getChild("Hat05b");
		this.EquipLTD_1 = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseR").getChild("EquipLJaw_1").getChild("EquipLTD_1");
		this.EquipHeadC01 = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseL").getChild("EquipLHead").getChild("EquipHeadC01");
		this.EquipHeadC01_1 = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseR").getChild("EquipRHead").getChild("EquipHeadC01_1");
		this.EquipLB_1 = root.getChild("BodyMain").getChild("Butt").getChild("EquipBaseR").getChild("EquipLB_1");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.scale = 0.38F;
		this.offsetY = 2.47F;
		this.offsetItem = new float[] {0.02F, 1.07F, -0.11F};
		this.offsetBlock = new float[] {0.02F, 1.07F, -0.11F};
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
		
		boolean flag = !EmotionHelper.checkModelState(0, state);	//cannon
		this.EquipBaseL.visible = !(flag);
		this.EquipBaseR.visible = !(flag);
				
		flag = !EmotionHelper.checkModelState(1, state);	//hat
		this.Hat01.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);	//weapon
		this.Cannon01.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(3, state);	//belt
		this.BeltBase.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(4, state);	//leg
		this.LegLeft01.visible = !(flag);
		this.LegRight01.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(5, state);	//wristband
		this.ArmLeft02a.visible = !(flag);
		this.ArmRight02a.visible = !(flag);
	
	}

	public void syncRotationGlowPart()
	{

		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
		this.EquipLegL.xRot = this.LegLeft01.xRot;
		this.EquipLegL.yRot = this.LegLeft01.yRot;
		this.EquipLegL.zRot = this.LegLeft01.zRot;
		this.EquipLegR.xRot = this.LegRight01.xRot;
		this.EquipLegR.yRot = this.LegRight01.yRot;
		this.EquipLegR.zRot = this.LegRight01.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (0.59F); this.animTransZ += (0F);
		this.setFaceHungry(ent);
    	
		//body
    	this.Head.xRot = 0F;
    	this.Head.yRot = 0F;
    	this.Head.zRot = 0F;
    	this.Ahoke.yRot = 0.7F;
    	this.BodyMain.xRot = 1.45F;
    	this.Butt.xRot = 0.21F;
    	this.Butt.y = (4.0F) + (0F) * 16F;
    	this.BeltBase.xRot = 0.09F;
	  	this.Skirt01.xRot = -0.21F;
	  	this.Skirt01.y = (2.5F) + (0F) * 16F;
	  	//hair
		//hair
		this.Hair03.xRot = 0F;
		this.Hair04.xRot = 0F;
		this.Hair05.xRot = 0F;
		this.Hair06.xRot = 0F;
		this.Hair03.zRot = 0.1F;
		this.Hair04.zRot = 0.2F;
		this.Hair05.zRot = 0.3F;
		this.Hair06.zRot = 0.4F;
    	//arm
    	this.ArmLeft01.xRot = -2.8F;
    	this.ArmLeft01.yRot = 0F;
    	this.ArmLeft01.zRot = 0.7F;
    	this.ArmLeft02.xRot = 0F;
    	this.ArmLeft02.yRot = 0F;
    	this.ArmLeft02.zRot = 1F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
    	this.ArmRight01.xRot = -2.8F;
    	this.ArmRight01.yRot = 0F;
    	this.ArmRight01.zRot = -0.7F;
    	this.ArmRight02.xRot = 0F;
    	this.ArmRight02.yRot = 0F;
		this.ArmRight02.zRot = -1.0F;
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
		this.ArmRight02.z = (2.5F) + (0F) * 16F;
    	//leg
    	this.LegLeft01.xRot = 0.1F;
    	this.LegLeft01.yRot = 3.1415F;
    	this.LegLeft01.zRot = -0.1F;
    	this.LegLeft01.y = (5.5F) + (0F) * 16F;
    	this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (3.0F) + (0F) * 16F;
		this.LegLeft02.y = (14.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
    	this.LegRight01.xRot = 0.1F;
		this.LegRight01.yRot = 3.1415F;
    	this.LegRight01.zRot = 0.1F;
    	this.LegRight01.y = (5.5F) + (0F) * 16F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.x = (-3.0F) + (0F) * 16F;
		this.LegRight02.y = (14.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		//equip
    	this.EquipBaseL.y = (10.0F) + (0F) * 16F;
    	this.EquipBaseR.y = (10.0F) + (0F) * 16F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

 		float angleX = Mth.cos(f2*0.08F + f * 0.25F);
  		float angleX1 = Mth.cos(f2*0.08F + 0.3F + f * 0.5F);
  		float angleX2 = Mth.cos(f2*0.08F + 0.6F + f * 0.5F);
  		float angleX3 = Mth.cos(f2*0.08F + 0.9F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
  		float addk1 = 0;
  		float addk2 = 0;
  		float headX = 0F;
  		float headZ = 0F;
  		float t2 = ent.getTickExisted() & 511;
		int state = ent.getStateEmotion(ID.S.State);
		boolean showCannon = EmotionHelper.checkModelState(0, state);
		boolean showLeg = EmotionHelper.checkModelState(4, state);
  		
  		//水上漂浮
  		if (!ent.getIsSitting() && !showLeg)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.015F + 0.025F); this.animTransZ += (0F);
  		}
  		else if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}

    	//leg move
  		addk1 = angleAdd1 * 0.5F - 0.28F;  //LegLeft01
	  	addk2 = angleAdd2 * 0.5F - 0.21F;  //LegRight01
    	
  	    //head
	  	this.Head.xRot = f4 * 0.01745F;
	  	this.Head.yRot = f3 * 0.01F;
	  	//body
  	    this.Ahoke.yRot = angleX * 0.05F + 0.7F;
	  	this.BodyMain.xRot = -0.1047F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.35F;
	  	this.BeltBase.xRot = 0.09F;
    	this.Skirt01.xRot = -0.21F;
    	this.Skirt01.y = (2.5F) + (0F) * 16F;
	  	//hat
	  	this.Hat06a.xRot = -angleX * 0.1F + 0.7F;
	  	this.Hat06b.xRot = -angleX3 * 0.1F + 1.04F;
		//hair
	  	this.Hair03.xRot = angleX * 0.05F - 0.09F + headX;
	  	this.Hair03.zRot = -0.09F;
	  	this.Hair04.xRot = -angleX1 * 0.06F + 0.26F + headX;
	  	this.Hair04.zRot = -0.22F;
	  	this.Hair05.xRot = -angleX2 * 0.07F + 0.52F + headX;
	  	this.Hair05.zRot = 0.35F;
	  	this.Hair06.xRot = -angleX3 * 0.12F - 0.15F + headX;
	  	this.Hair06.zRot = 0.52F;
	    //arm
	  	//equip on
	  	if (showCannon)
	  	{
	  		this.ArmLeft01.zRot = -0.78F;
	  		this.ArmRight01.zRot = 0.78F;
	  	}
	  	//equip off
	  	else
	  	{
	  		this.ArmLeft01.zRot = angleX * 0.03F - 0.3F;
	  		this.ArmRight01.zRot = -angleX * 0.03F + 0.3F;
	  	}
	  	this.ArmLeft01.xRot = angleAdd2 * 0.4F + 0.26F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    this.ArmRight01.xRot = angleAdd1 * 0.4F + 0.26F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
		this.ArmRight02.z = (2.5F) + (0F) * 16F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.0873F;
		this.LegLeft01.y = (5.5F) + (0F) * 16F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.yRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.x = (3.0F) + (0F) * 16F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.0873F;
		this.LegRight01.y = (5.5F) + (0F) * 16F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.yRot = 0F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.x = (-3.0F) + (0F) * 16F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		//equip
		this.EquipBaseL.xRot = 0.05F;
		this.EquipBaseR.xRot = 0.05F;
    	this.EquipBaseL.y = (10.0F) + (0F) * 16F;
    	this.EquipBaseR.y = (10.0F) + (0F) * 16F;
		this.EquipHeadC02.xRot = this.Head.xRot * 0.5F - 0.04F;
		this.EquipHeadC02_1.xRot = this.Head.xRot * 0.5F - 0.12F;
		this.EquipLT01.xRot = this.Head.xRot * 0.8F - 0.2F;
		this.EquipLT01_1.xRot = this.Head.xRot * 0.8F - 0.2F;
		this.EquipLJaw.xRot = angleX * 0.15F + 0.15F;
		this.EquipLJaw_1.xRot = angleX3 * 0.15F + 0.15F;
		
//		//special stand pos
//		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
//		{
//			spStand = true;
//		}

	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {
//	    	if (spStand)
	    	
			//body
	    	this.Head.xRot -= 0.5F;
	    	this.BodyMain.xRot = 0.5F;
	    	//arm
	    	this.ArmLeft01.xRot = angleAdd2 * 0.1F + 0.55F;
	    	this.ArmLeft01.yRot = 0F;
	    	this.ArmLeft01.zRot = -0.5F;
	    	this.ArmRight01.xRot = angleAdd1 * 0.1F + 0.55F;
	    	this.ArmRight01.yRot = 0F;
			this.ArmRight01.zRot = 0.5F;
			//hair
			this.Hair05.xRot -= 0.2F;
			//leg
			addk1 = angleAdd1 * 0.8F - 0.75F;
			addk2 = angleAdd2 * 0.8F - 0.75F;
			this.LegLeft01.yRot = 0F;
			this.LegLeft01.zRot = 0.0873F;
			this.LegLeft02.xRot = 0F;
			this.LegLeft02.yRot = 0F;
			this.LegLeft02.zRot = 0F;
			this.LegLeft02.x = (3.0F) + (0F) * 16F;
			this.LegLeft02.z = (-3.0F) + (0F) * 16F;
			this.LegRight01.yRot = 0F;
			this.LegRight01.zRot = -0.0873F;
			this.LegRight02.xRot = 0F;
			this.LegRight02.yRot = 0F;
			this.LegRight02.zRot = 0F;
			this.LegRight02.x = (-3.0F) + (0F) * 16F;
			this.LegRight02.z = (-3.0F) + (0F) * 16F;
	    	
			//equip on
			if (!showLeg)
			{
				addk1 = angleAdd1 * 0.05F;
				addk2 = angleAdd2 * 0.05F;
			}
  		}
	    
	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {
this.animTransX += (0F); this.animTransY += (0.07F); this.animTransZ += (0F);
	    	
	    	//Body
	    	this.Head.xRot -= 0.6283F;
		  	this.BodyMain.xRot = 0.8727F;
		    //arm
		  	this.ArmLeft01.xRot = -0.35F;
		  	this.ArmLeft01.yRot = 0F;
		    this.ArmLeft01.zRot = 0.2618F;
		    this.ArmLeft02.xRot = 0F;
		    this.ArmLeft02.zRot = 0F;
		    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
		    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
			this.ArmRight01.xRot = -0.35F;
			this.ArmRight01.yRot = 0F;
			this.ArmRight01.zRot = -0.2618F;
			this.ArmRight02.xRot = 0F;
			this.ArmRight02.zRot = 0F;
			this.ArmRight02.x = (-3.0F) + (0F) * 16F;
			this.ArmRight02.z = (2.5F) + (0F) * 16F;
			//leg
			addk1 -= 1F;
			addk2 -= 1F;
			//hair
			this.Hair03.xRot -= 0.6F;
			this.Hair04.xRot -= 0.6F;
			this.Hair05.xRot -= 0.6F;
			this.Hair06.xRot -= 0.6F;
  		}//end if sneaking
  		
	    //坐下動作
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
	    		if (ent.getStateEmotion(ID.S.Emotion4) == ID.Emotion.BORED)
	    		{
this.animTransX += (0F); this.animTransY += (0.46F); this.animTransZ += (0F);
	    	    	
	    	    	this.setFaceDamaged(ent);
	    	    	
	    	    	//body
	    	    	this.Head.xRot = 0.4F;
	    	    	this.BeltBase.xRot = -0.9F;
	    	    	this.Skirt01.xRot = -0.14F;
	    	    	this.Skirt01.y = (2.5F) + (-0.12F) * 16F;
	    	    	//arm
	    	    	this.ArmLeft01.xRot = 0.4F;
	    	    	this.ArmLeft01.yRot = -2.96705972839036F;
	    	    	this.ArmLeft01.zRot = -2.62F;
	    	    	this.ArmLeft02.xRot = 0.0F;
	    	    	this.ArmLeft02.yRot = 0.0F;
	    	    	this.ArmLeft02.zRot = 1F;
	    	    	this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    	    	this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    	    	this.ArmRight01.xRot = 0.5235987755982988F;
	    	    	this.ArmRight01.yRot = 2.96705972839036F;
	    	    	this.ArmRight01.zRot = 2.62F;
	    	    	this.ArmRight02.xRot = 0.0F;
	    	    	this.ArmRight02.yRot = 0.0F;
	    	    	this.ArmRight02.zRot = -1F;
	    	    	this.ArmRight02.x = (-3.0F) + (0F) * 16F;
	    	    	this.ArmRight02.z = (2.5F) + (0F) * 16F;
	    	    	//leg
	    	    	addk1 = -2.41309222380736F;
	    	    	addk2 = -2.2689280275926285F;
	    	    	this.LegLeft01.yRot = 0.0F;
	    	    	this.LegLeft01.zRot = -0.27314402793711257F;
	    	    	this.LegLeft02.xRot = 1.4570008595648662F;
	    	    	this.LegLeft02.yRot = 0.0F;
	    	    	this.LegLeft02.zRot = 0.0F;
	    	    	this.LegRight01.yRot = 0.0F;
	    	    	this.LegRight01.zRot = 0.22759093446006054F;
	    	    	this.LegRight02.xRot = 1.0471975511965976F;
	    	    	this.LegRight02.yRot = 0.0F;
	    	    	this.LegRight02.zRot = 0.0F;
	    	    	//equip
	    			this.EquipBaseL.xRot = -0.6F;
	    			this.EquipBaseR.xRot = -0.6F;
	    	    	this.EquipBaseL.y = (10.0F) + (-0.62F) * 16F;
	    	    	this.EquipBaseR.y = (10.0F) + (-0.62F) * 16F;
	    		}
	    		else
	    		{
this.animTransX += (0F); this.animTransY += (0.43F); this.animTransZ += (0F);
	    	    	//body
	    	    	this.Head.xRot -= 0.7F;
	    	    	this.BodyMain.xRot = 0.35F;
	    	    	this.BeltBase.xRot = -0.5F;
	    	    	this.Skirt01.xRot = -0.14F;
	    	    	this.Skirt01.y = (2.5F) + (-0.12F) * 16F;
	    	    	//arm
	    			this.ArmLeft01.xRot = -0.5235987755982988F;
	    			this.ArmLeft01.yRot = 0.0F;
	    			this.ArmLeft01.zRot = 0.3490658503988659F;
	    		    this.ArmLeft02.xRot = 0F;
	    		    this.ArmLeft02.zRot = 0F;
	    		    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    		    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    			this.ArmRight01.xRot = -0.5235987755982988F;
	    			this.ArmRight01.yRot = 0.0F;
	    			this.ArmRight01.zRot = -0.3490658503988659F;
	    			this.ArmRight02.xRot = 0F;
	    			this.ArmRight02.zRot = 0F;
	    			this.ArmRight02.x = (-3.0F) + (0F) * 16F;
	    			this.ArmRight02.z = (2.5F) + (0F) * 16F;
	    	    	//leg
	    	    	addk1 = -1.4486232791552935F;
	    	    	addk2 = -1.4486232791552935F;
	    			this.LegLeft01.yRot = -0.5235987755982988F;
	    			this.LegLeft01.zRot = -1.3962634015954636F;
	    			this.LegLeft02.xRot = 2.1816615649929116F;
	    			this.LegLeft02.yRot = 0.0F;
	    			this.LegLeft02.zRot = 0.0F;
	    			this.LegLeft02.x = (3.0F) + (0F) * 16F;
	    			this.LegLeft02.z = (-3.0F) + (0.37F) * 16F;
	    			this.LegRight01.yRot = 0.5235987755982988F;
	    			this.LegRight01.zRot = 1.3962634015954636F;
	    			this.LegRight02.xRot = 2.1816615649929116F;
	    			this.LegRight02.yRot = 0.0F;
	    			this.LegRight02.zRot = 0.0F;
	    			this.LegRight02.x = (-3.0F) + (0F) * 16F;
	    			this.LegRight02.z = (-3.0F) + (0.37F) * 16F;
	    			//equip
	    			this.EquipBaseL.xRot = -0.9F;
	    			this.EquipBaseR.xRot = -0.9F;
	    	    	this.EquipBaseL.y = (10.0F) + (-0.4F) * 16F;
	    	    	this.EquipBaseR.y = (10.0F) + (-0.4F) * 16F;
	    			//hair
	    			this.Hair03.xRot -= 0.1F;
	    			this.Hair04.xRot -= 0.3F;
	    			this.Hair05.xRot -= 0.5F;
	    			this.Hair06.xRot -= 0.6F;
	    		}
	    	}
	    	else
	    	{
	    		//no equip
	    		if (!this.EquipBaseL.visible)
	    		{
this.animTransX += (0F); this.animTransY += (0.44F); this.animTransZ += (0F);
	    	    	//body
	    	    	this.Head.xRot -= 0.7F;
	    	    	this.BodyMain.xRot = 0.5236F;
	    	    	this.BeltBase.xRot = -0.9F;
	    	    	this.Skirt01.xRot = -0.14F;
	    	    	this.Skirt01.y = (2.5F) + (-0.12F) * 16F;
	    	    	//arm
	    	    	this.ArmLeft01.xRot = -0.5236F;
	    		  	this.ArmLeft01.yRot = 0F;
	    		  	this.ArmLeft01.zRot = 0.3146F;
	    		    this.ArmLeft02.xRot = 0F;
	    		    this.ArmLeft02.zRot = 0F;
	    		    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    		    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    		    this.ArmRight01.xRot = -0.5236F;
	    			this.ArmRight01.yRot = 0F;
	    			this.ArmRight01.zRot = -0.3146F;
	    			this.ArmRight02.xRot = 0F;
	    			this.ArmRight02.zRot = 0F;
	    			this.ArmRight02.x = (-3.0F) + (0F) * 16F;
	    			this.ArmRight02.z = (2.5F) + (0F) * 16F;
	    	    	//leg
	    	    	addk1 = -2.2689F;
	    	    	addk2 = -2.2689F;
	    	    	this.LegLeft01.yRot = -0.3491F;
	    			this.LegLeft01.zRot = 0.0873F;
	    			this.LegLeft02.xRot = 0F;
	    			this.LegLeft02.yRot = 0F;
	    			this.LegLeft02.zRot = 0F;
	    			this.LegLeft02.x = (3.0F) + (0F) * 16F;
	    			this.LegLeft02.z = (-3.0F) + (0F) * 16F;
	    			this.LegRight01.yRot = 0.3491F;
	    			this.LegRight01.zRot = -0.0873F;
	    			this.LegRight02.xRot = 0F;
	    			this.LegRight02.yRot = 0F;
	    			this.LegRight02.zRot = 0F;
	    			this.LegRight02.x = (-3.0F) + (0F) * 16F;
	    			this.LegRight02.z = (-3.0F) + (0F) * 16F;
	    			//hair
	    			this.Hair03.xRot -= 0.1F;
	    			this.Hair04.xRot -= 0.3F;
	    			this.Hair05.xRot -= 0.5F;
	    			this.Hair06.xRot -= 0.6F;
	    		}
	    		else
	    		{
this.animTransX += (0F); this.animTransY += (0.41F); this.animTransZ += (0F);
			    	//body
			    	this.Head.xRot -= 0.7F;
			    	this.BodyMain.xRot = 0.5236F;
			    	//arm
			    	this.ArmLeft01.xRot = -0.5236F;
				  	this.ArmLeft01.yRot = 0F;
				  	this.ArmLeft01.zRot = 0.3146F;
				    this.ArmLeft02.xRot = 0F;
				    this.ArmLeft02.zRot = 0F;
				    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
				    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
				    this.ArmRight01.xRot = -0.5236F;
					this.ArmRight01.yRot = 0F;
					this.ArmRight01.zRot = -0.3146F;
					this.ArmRight02.xRot = 0F;
					this.ArmRight02.zRot = 0F;
					this.ArmRight02.x = (-3.0F) + (0F) * 16F;
					this.ArmRight02.z = (2.5F) + (0F) * 16F;
			    	//leg
			    	addk1 = -2.23F;
			    	addk2 = -2.23F;
			    	this.LegLeft01.yRot = -0.3491F;
					this.LegLeft01.zRot = 0.0873F;
					this.LegLeft02.xRot = 0F;
					this.LegLeft02.yRot = 0F;
					this.LegLeft02.zRot = 0F;
					this.LegLeft02.x = (3.0F) + (0F) * 16F;
					this.LegLeft02.z = (-3.0F) + (0F) * 16F;
					this.LegRight01.yRot = 0.3491F;
					this.LegRight01.zRot = -0.0873F;
					this.LegRight02.xRot = 0F;
					this.LegRight02.yRot = 0F;
					this.LegRight02.zRot = 0F;
					this.LegRight02.x = (-3.0F) + (0F) * 16F;
					this.LegRight02.z = (-3.0F) + (0F) * 16F;
					//equip
					this.EquipBaseL.xRot = -1.34F;
					this.EquipBaseR.xRot = -1.34F;
					//hair
					this.Hair03.xRot -= 0.1F;
					this.Hair04.xRot -= 0.3F;
					this.Hair05.xRot -= 0.5F;
					this.Hair06.xRot -= 0.6F;
	    		}
	    	}
  		}//end if sitting
	    
	    //攻擊動作: 設為30~50會有揮刀動作, 設為100則沒有揮刀動作
	    if (ent.getAttackTick() > 0)
	    {
	    	//arm
	    	this.ArmLeft01.xRot = -1.4F + this.Head.xRot * 0.75F;
		  	this.ArmLeft01.yRot = 0.17F;
		  	this.ArmLeft01.zRot = 0.26F;
		    this.ArmLeft02.xRot = 0F;
		    this.ArmLeft02.zRot = 0F;
		    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
		    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
		    this.ArmRight01.xRot = -1.22F + this.Head.xRot * 0.75F;
			this.ArmRight01.yRot = 0F;
			this.ArmRight01.zRot = -0.52F;
			this.ArmRight02.xRot = 0F;
			this.ArmRight02.zRot = -0.78F;
			this.ArmRight02.x = (-3.0F) + (0F) * 16F;
			this.ArmRight02.z = (2.5F) + (0F) * 16F;
	    }
	    
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
	  	
	  	//頭毛左右彎曲調整
	    headX = this.Head.xRot * -0.5F;
	    this.Hair03.xRot += headX;
	  	this.Hair04.xRot += headX;
	  	this.Hair05.xRot += headX;
	  	this.Hair06.xRot += headX;
		this.HairL01.xRot = angleX * 0.02F + headX + 0.14F;
	  	this.HairR01.xRot = angleX * 0.02F + headX - 0.09F;
	  	headZ = this.Head.zRot * -0.5F;
	    this.Hair03.zRot = headZ;
	  	this.Hair04.zRot = headZ;
	    this.Hair05.zRot = headZ;
	  	this.Hair06.zRot = headZ;
	  	this.HairL01.zRot = headZ - 0.09F;
	  	this.HairR01.zRot = headZ - 0.09F;
	    
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

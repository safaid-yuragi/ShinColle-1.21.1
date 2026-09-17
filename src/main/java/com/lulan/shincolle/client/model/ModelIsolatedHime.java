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

public class ModelIsolatedHime<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart Butt;
	public ModelPart ArmRight01;
	public ModelPart ArmLeft01;
	public ModelPart Cloth02a;
	public ModelPart Head;
	public ModelPart Cloth01a;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Hair01;
	public ModelPart HatBase;
	public ModelPart HairU01;
	public ModelPart Ahoke;
	public ModelPart Hair02;
	public ModelPart Hair03;
	public ModelPart Hat01;
	public ModelPart Hat03;
	public ModelPart Hat05;
	public ModelPart HeadH1;
	public ModelPart HeadH2;
	public ModelPart HeadH3;
	public ModelPart HeadH4;
	public ModelPart HeadH5;
	public ModelPart HeadH6;
	public ModelPart Hat02a;
	public ModelPart Hat02b;
	public ModelPart Hat02c;
	public ModelPart Hat02d;
	public ModelPart Hat02e;
	public ModelPart Hat02f;
	public ModelPart Hat02g;
	public ModelPart Hat02h;
	public ModelPart Hat02i;
	public ModelPart Hat02j;
	public ModelPart Hat04a;
	public ModelPart Hat04b;
	public ModelPart Hat04c;
	public ModelPart Hat04d;
	public ModelPart Hat04e;
	public ModelPart Hat04f;
	public ModelPart Hat04g;
	public ModelPart Hat04h;
	public ModelPart Hat06a;
	public ModelPart Hat02b_1;
	public ModelPart Hat02d_1;
	public ModelPart Hat02e_1;
	public ModelPart Hat02f_1;
	public ModelPart Hat02g_1;
	public ModelPart Hat02h_1;
	public ModelPart Hat02i_1;
	public ModelPart Cloth01b;
	public ModelPart Cloth01c;
	public ModelPart Cloth01b2;
	public ModelPart Cloth01c2;
	public ModelPart Skirt01;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart Skirt02;
	public ModelPart Skirt03;
	public ModelPart LegRight02a;
	public ModelPart LegArmor02a;
	public ModelPart LegRight02b;
	public ModelPart LegArmor02b;
	public ModelPart LegArmor02c;
	public ModelPart LegLeft02a;
	public ModelPart LegArmor01a;
	public ModelPart LegLeft02b;
	public ModelPart LegArmor01b;
	public ModelPart LegArmor01c;
	public ModelPart ArmRight02;
	public ModelPart Cloth02c;
	public ModelPart Cloth03a;
	public ModelPart ArmLeft02;
	public ModelPart Cloth02b;
	public ModelPart Cloth03b;
	public ModelPart EquipRdL01;
	public ModelPart EquipRdL02;
	public ModelPart EquipRdL03;
	public ModelPart EquipRdL04;
	public ModelPart EquipRdL05;
	public ModelPart EquipRdL06;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	public ModelPart GlowHatBase;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 15.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, -0.05235987755982988F, 0.0F, -0.2792526803190927F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("Cloth02b", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.5F, 6.0F, 6.0F, 7.0F), PartPose.offsetAndRotation(0.9F, -1.5F, 0.0F, 0.0F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef3 = partdef1.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(3.0F, 11.0F, 2.5F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("Cloth03b", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F), PartPose.offset(-2.5F, 3.5F, -2.5F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-2.5F, -2.0F, -3.0F, 5.0F, 2.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef8 = partdef6.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, -4.0F, 15.0F, 17.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -6.0F, 2.0F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.0F, 0.0F, -6.0F, 16.0F, 16.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 13.5F, 2.5F, 0.12217304763960307F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("Hair03", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.5F, 15.0F, 15.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 12.5F, -0.1F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef6.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 16.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.1F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -6.0F, -10.5F, 0.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(-0.5F, -7.0F, -6.0F, 0.5235987755982988F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef13 = partdef11.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -7.0F));
		PartDefinition partdef14 = partdef6.addOrReplaceChild("HatBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -14.6F, -2.0F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("Hat03", CubeListBuilder.create().addBox(-8.5F, 0.0F, -0.5F, 17.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(10.0F, 5.5F, 1.3F, 0.0F, -0.05235987755982988F, 1.5707963267948966F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("Hat04f", CubeListBuilder.create().addBox(-2.0F, -3.0F, 0.0F, 4.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-4.3F, -1.0F, 2.5F, 0.0F, -0.03490658503988659F, 2.96705972839036F));
		PartDefinition partdef17 = partdef15.addOrReplaceChild("Hat04g", CubeListBuilder.create().addBox(-2.0F, -3.0F, 0.0F, 4.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(3.5F, -0.6F, 2.2F, -0.05235987755982988F, -0.03490658503988659F, -3.07177948351002F));
		PartDefinition partdef18 = partdef15.addOrReplaceChild("Hat04e", CubeListBuilder.create().addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(-0.2F, 1.1F, 2.8F, 0.13962634015954636F, 0.0F, 0.03490658503988659F));
		PartDefinition partdef19 = partdef15.addOrReplaceChild("Hat04d", CubeListBuilder.create().addBox(-2.0F, -3.0F, -10.0F, 4.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(-4.9F, -1.5F, -0.2F, 0.017453292519943295F, 0.017453292519943295F, 2.792526803190927F));
		PartDefinition partdef20 = partdef15.addOrReplaceChild("Hat04a", CubeListBuilder.create().addBox(-2.0F, -3.0F, -10.0F, 4.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(-0.5F, 0.5F, -0.5F, -0.08726646259971647F, -0.03490658503988659F, -0.06981317007977318F));
		PartDefinition partdef21 = partdef15.addOrReplaceChild("Hat04h", CubeListBuilder.create().addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(6.9F, 1.2F, 2.4F, 0.05235987755982988F, 0.06981317007977318F, 0.296705972839036F));
		PartDefinition partdef22 = partdef15.addOrReplaceChild("Hat04b", CubeListBuilder.create().addBox(-2.0F, -3.0F, -10.0F, 4.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(3.2F, -2.0F, -0.2F, -0.05235987755982988F, 0.08726646259971647F, -3.07177948351002F));
		PartDefinition partdef23 = partdef15.addOrReplaceChild("Hat04c", CubeListBuilder.create().addBox(-2.0F, -3.0F, -10.0F, 4.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(6.4F, 1.0F, -0.1F, 0.06981317007977318F, -0.13962634015954636F, 0.2617993877991494F));
		PartDefinition partdef24 = partdef14.addOrReplaceChild("Hat01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -0.5F, 17.0F, 4.0F, 3.0F), PartPose.offset(0.0F, -3.6F, 1.0F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("Hat02d", CubeListBuilder.create().addBox(-2.0F, -3.0F, -10.0F, 4.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(-4.2F, -0.7F, -0.6F, -0.05235987755982988F, -0.017453292519943295F, 2.96705972839036F));
		PartDefinition partdef26 = partdef24.addOrReplaceChild("Hat02a", CubeListBuilder.create().addBox(-2.0F, -3.0F, -10.0F, 4.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 1.5F, -0.7F, -0.06981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef24.addOrReplaceChild("Hat02b", CubeListBuilder.create().addBox(-2.0F, -3.0F, -10.0F, 4.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(4.2F, -0.7F, -0.6F, -0.05235987755982988F, 0.017453292519943295F, -2.96705972839036F));
		PartDefinition partdef28 = partdef24.addOrReplaceChild("Hat02g", CubeListBuilder.create().addBox(-2.0F, -3.0F, 0.0F, 4.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-3.8F, -0.5F, 2.3F, 0.05235987755982988F, 0.05235987755982988F, 3.1066860685499065F));
		PartDefinition partdef29 = partdef24.addOrReplaceChild("Hat02h", CubeListBuilder.create().addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(-7.2F, 2.4F, 2.6F, 0.08726646259971647F, -0.05235987755982988F, -0.5235987755982988F));
		PartDefinition partdef30 = partdef24.addOrReplaceChild("Hat02e", CubeListBuilder.create().addBox(-2.0F, -3.0F, -10.0F, 4.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(-7.6F, 2.0F, -0.6F, 0.05235987755982988F, 0.03490658503988659F, -0.5759586531581287F));
		PartDefinition partdef31 = partdef24.addOrReplaceChild("Hat02c", CubeListBuilder.create().addBox(-2.0F, -3.0F, -10.0F, 4.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(7.6F, 2.0F, -0.6F, 0.05235987755982988F, -0.03490658503988659F, 0.5759586531581287F));
		PartDefinition partdef32 = partdef24.addOrReplaceChild("Hat02i", CubeListBuilder.create().addBox(-2.0F, -3.0F, 0.0F, 4.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(3.8F, -0.5F, 2.3F, 0.05235987755982988F, -0.05235987755982988F, -3.1066860685499065F));
		PartDefinition partdef33 = partdef24.addOrReplaceChild("Hat02f", CubeListBuilder.create().addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 1.7F, 2.6F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef34 = partdef24.addOrReplaceChild("Hat02j", CubeListBuilder.create().addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(7.2F, 2.4F, 2.6F, 0.08726646259971647F, 0.05235987755982988F, 0.5235987755982988F));
		PartDefinition partdef35 = partdef14.addOrReplaceChild("Hat05", CubeListBuilder.create().addBox(-8.5F, 0.0F, -0.5F, 17.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-10.0F, 5.5F, 1.3F, 0.0F, 0.05235987755982988F, -1.5707963267948966F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("Hat02b_1", CubeListBuilder.create().addBox(-2.0F, -3.0F, -10.0F, 4.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(4.9F, -1.5F, -0.2F, 0.017453292519943295F, -0.017453292519943295F, -2.792526803190927F));
		PartDefinition partdef37 = partdef35.addOrReplaceChild("Hat02e_1", CubeListBuilder.create().addBox(-2.0F, -3.0F, -10.0F, 4.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(-6.4F, 1.0F, -0.1F, -0.06981317007977318F, 0.13962634015954636F, -0.2617993877991494F));
		PartDefinition partdef38 = partdef35.addOrReplaceChild("Hat06a", CubeListBuilder.create().addBox(-2.0F, -3.0F, -10.0F, 4.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(0.5F, 0.5F, -0.5F, -0.08726646259971647F, 0.03490658503988659F, 0.06981317007977318F));
		PartDefinition partdef39 = partdef35.addOrReplaceChild("Hat02g_1", CubeListBuilder.create().addBox(-2.0F, -3.0F, 0.0F, 4.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-3.5F, -0.6F, 2.2F, -0.05235987755982988F, 0.03490658503988659F, 3.07177948351002F));
		PartDefinition partdef40 = partdef35.addOrReplaceChild("Hat02i_1", CubeListBuilder.create().addBox(-2.0F, -3.0F, 0.0F, 4.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(4.3F, -1.0F, 2.5F, 0.0F, 0.03490658503988659F, -2.96705972839036F));
		PartDefinition partdef41 = partdef35.addOrReplaceChild("Hat02h_1", CubeListBuilder.create().addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(-6.9F, 1.2F, 2.4F, 0.05235987755982988F, -0.06981317007977318F, -0.296705972839036F));
		PartDefinition partdef42 = partdef35.addOrReplaceChild("Hat02f_1", CubeListBuilder.create().addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.2F, 1.1F, 2.8F, 0.13962634015954636F, 0.0F, 0.03490658503988659F));
		PartDefinition partdef43 = partdef35.addOrReplaceChild("Hat02d_1", CubeListBuilder.create().addBox(-2.0F, -3.0F, -10.0F, 4.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(-3.2F, -2.0F, -0.2F, -0.05235987755982988F, -0.08726646259971647F, 3.07177948351002F));
		PartDefinition partdef44 = partdef5.addOrReplaceChild("Cloth01a", CubeListBuilder.create().addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -7.9F, 0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("Cloth01b2", CubeListBuilder.create().addBox(0.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(0.5F, 0.3F, 0.3F, 0.08726646259971647F, 0.17453292519943295F, -0.1488765851951163F));
		PartDefinition partdef46 = partdef44.addOrReplaceChild("Cloth01c", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(-2.0F, 1.6F, -0.7F, -0.7853981633974483F, 0.13962634015954636F, 0.17453292519943295F));
		PartDefinition partdef47 = partdef44.addOrReplaceChild("Cloth01b", CubeListBuilder.create().addBox(-6.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-0.5F, 0.3F, 0.3F, 0.08726646259971647F, -0.17453292519943295F, 0.13962634015954636F));
		PartDefinition partdef48 = partdef44.addOrReplaceChild("Cloth01c2", CubeListBuilder.create().mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(2.0F, 1.6F, -0.7F, -0.7330382858376184F, -0.13962634015954636F, -0.17453292519943295F));
		PartDefinition partdef49 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().mirror().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.2617993877991494F, 0.0F, 0.2792526803190927F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("Cloth02c", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.5F, 6.0F, 6.0F, 7.0F), PartPose.offsetAndRotation(-0.9F, -1.5F, 0.0F, 0.0F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef51 = partdef49.addOrReplaceChild("ArmRight02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -5.0F, 5.0F, 12.0F, 5.0F), PartPose.offset(-3.0F, 11.0F, 2.5F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("Cloth03a", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F), PartPose.offset(2.5F, 3.5F, -2.5F));
		PartDefinition partdef53 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 1.3F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef54 = partdef53.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.15707963267948966F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef55 = partdef54.addOrReplaceChild("LegLeft02a", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(3.0F, 14.0F, -3.0F));
		PartDefinition partdef56 = partdef54.addOrReplaceChild("LegArmor01a", CubeListBuilder.create().addBox(-3.5F, -4.0F, 0.0F, 7.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 13.0F, -5.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef57 = partdef56.addOrReplaceChild("LegArmor01b", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6108652381980153F, 0.0F, 0.0F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("LegArmor01c", CubeListBuilder.create().addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 0.2F, 0.6108652381980153F, 0.0F, 0.0F));
		PartDefinition partdef59 = partdef54.addOrReplaceChild("LegLeft02b", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(3.0F, 14.0F, -3.0F));
		PartDefinition partdef60 = partdef53.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-9.0F, 0.0F, -6.2F, 18.0F, 4.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-10.5F, 0.0F, -6.0F, 21.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 2.7F, -1.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("Skirt03", CubeListBuilder.create().addBox(-11.5F, 0.0F, -6.5F, 23.0F, 4.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef63 = partdef53.addOrReplaceChild("LegRight01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.296705972839036F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef64 = partdef63.addOrReplaceChild("LegRight02b", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(-3.0F, 14.0F, -3.0F));
		PartDefinition partdef65 = partdef63.addOrReplaceChild("LegRight02a", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(-3.0F, 14.0F, -3.0F));
		PartDefinition partdef66 = partdef63.addOrReplaceChild("LegArmor02a", CubeListBuilder.create().addBox(-3.5F, -4.0F, 0.0F, 7.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 13.0F, -5.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef67 = partdef66.addOrReplaceChild("LegArmor02b", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6108652381980153F, 0.0F, 0.0F));
		PartDefinition partdef68 = partdef67.addOrReplaceChild("LegArmor02c", CubeListBuilder.create().addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 2.0F, 0.2F, 0.6108652381980153F, 0.0F, 0.0F));
		PartDefinition partdef69 = partdef0.addOrReplaceChild("Cloth02a", CubeListBuilder.create().addBox(-7.0F, 0.0F, -4.0F, 14.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -11.5F, -0.6F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef70 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef71 = partdef70.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.3F, 0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef72 = partdef71.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -0.7F));
		PartDefinition partdef73 = partdef72.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef74 = partdef72.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef75 = partdef72.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef76 = partdef72.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef77 = partdef72.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef78 = partdef72.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef79 = partdef72.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef80 = partdef72.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef81 = partdef72.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef82 = partdef72.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));
		PartDefinition partdef83 = partdef72.addOrReplaceChild("GlowHatBase", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -14.6F, -2.0F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef84 = partdef83.addOrReplaceChild("HeadH1", CubeListBuilder.create().mirror().addBox(-2.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(-8.5F, -2.0F, 2.0F, 0.17453292519943295F, 0.0F, 0.4363323129985824F));
		PartDefinition partdef85 = partdef84.addOrReplaceChild("HeadH2", CubeListBuilder.create().addBox(-1.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(-1.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.12217304763960307F));
		PartDefinition partdef86 = partdef85.addOrReplaceChild("HeadH3", CubeListBuilder.create().addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.08726646259971647F, 0.17453292519943295F));
		PartDefinition partdef87 = partdef83.addOrReplaceChild("HeadH4", CubeListBuilder.create().mirror().addBox(0.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(8.5F, -2.0F, 2.0F, 0.17453292519943295F, 0.0F, -0.4363323129985824F));
		PartDefinition partdef88 = partdef87.addOrReplaceChild("HeadH5", CubeListBuilder.create().addBox(0.0F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(1.8F, 0.0F, 0.0F, 0.0F, 0.0F, -0.12217304763960307F));
		PartDefinition partdef89 = partdef88.addOrReplaceChild("HeadH6", CubeListBuilder.create().addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.7F, 0.0F, 0.0F, 0.0F, 0.08726646259971647F, -0.17453292519943295F));
		PartDefinition partdef90 = partdef70.addOrReplaceChild("EquipRdL01", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(4.0F, -6.0F, 5.0F, 1.5707963267948966F, -0.17453292519943295F, -0.7853981633974483F));
		PartDefinition partdef91 = partdef90.addOrReplaceChild("EquipRdL02", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.4363323129985824F, 0.0F, 0.0F));
		PartDefinition partdef92 = partdef91.addOrReplaceChild("EquipRdL03", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef93 = partdef92.addOrReplaceChild("EquipRdL04", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef94 = partdef93.addOrReplaceChild("EquipRdL05", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef95 = partdef94.addOrReplaceChild("EquipRdL06", CubeListBuilder.create().addBox(-3.5F, 0.0F, -12.0F, 7.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -11.0F, -0.17453292519943295F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelIsolatedHime(ModelPart root)
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
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.LegArmor01a = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegArmor01a");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.Hat02i = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat01").getChild("Hat02i");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.HeadH1 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowHatBase").getChild("HeadH1");
		this.HeadH2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowHatBase").getChild("HeadH1").getChild("HeadH2");
		this.Hat04b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat03").getChild("Hat04b");
		this.Cloth01c2 = root.getChild("BodyMain").getChild("Neck").getChild("Cloth01a").getChild("Cloth01c2");
		this.Hat02h_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat05").getChild("Hat02h_1");
		this.Cloth03a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("Cloth03a");
		this.Hat04h = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat03").getChild("Hat04h");
		this.LegArmor02b = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegArmor02a").getChild("LegArmor02b");
		this.Hat02b_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat05").getChild("Hat02b_1");
		this.HeadH6 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowHatBase").getChild("HeadH4").getChild("HeadH5").getChild("HeadH6");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.HeadH4 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowHatBase").getChild("HeadH4");
		this.Hat02b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat01").getChild("Hat02b");
		this.Cloth01c = root.getChild("BodyMain").getChild("Neck").getChild("Cloth01a").getChild("Cloth01c");
		this.Hat01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat01");
		this.Cloth03b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02").getChild("Cloth03b");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.Hat02f = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat01").getChild("Hat02f");
		this.Hat02e = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat01").getChild("Hat02e");
		this.Hat06a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat05").getChild("Hat06a");
		this.LegRight02b = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02b");
		this.Cloth02c = root.getChild("BodyMain").getChild("ArmRight01").getChild("Cloth02c");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.LegRight02a = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02a");
		this.LegArmor02c = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegArmor02a").getChild("LegArmor02b").getChild("LegArmor02c");
		this.Hat04d = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat03").getChild("Hat04d");
		this.LegArmor01b = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegArmor01a").getChild("LegArmor01b");
		this.Hat02g = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat01").getChild("Hat02g");
		this.Cloth01b2 = root.getChild("BodyMain").getChild("Neck").getChild("Cloth01a").getChild("Cloth01b2");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair01");
		this.Hat02a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat01").getChild("Hat02a");
		this.Hat02i_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat05").getChild("Hat02i_1");
		this.LegArmor01c = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegArmor01a").getChild("LegArmor01b").getChild("LegArmor01c");
		this.Hat04a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat03").getChild("Hat04a");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.Hat04c = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat03").getChild("Hat04c");
		this.Cloth01b = root.getChild("BodyMain").getChild("Neck").getChild("Cloth01a").getChild("Cloth01b");
		this.Cloth02a = root.getChild("BodyMain").getChild("Cloth02a");
		this.Hair03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair01").getChild("Hair02").getChild("Hair03");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair01").getChild("Hair02");
		this.Cloth02b = root.getChild("BodyMain").getChild("ArmLeft01").getChild("Cloth02b");
		this.Cloth01a = root.getChild("BodyMain").getChild("Neck").getChild("Cloth01a");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.Hat04e = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat03").getChild("Hat04e");
		this.LegLeft02b = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02b");
		this.Hat02j = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat01").getChild("Hat02j");
		this.Hat02d = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat01").getChild("Hat02d");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.BodyMain = root.getChild("BodyMain");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.Hat03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat03");
		this.Hat02c = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat01").getChild("Hat02c");
		this.LegArmor02a = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegArmor02a");
		this.HairU01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairU01");
		this.Hat02f_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat05").getChild("Hat02f_1");
		this.HeadH5 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowHatBase").getChild("HeadH4").getChild("HeadH5");
		this.Hat02e_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat05").getChild("Hat02e_1");
		this.HatBase = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase");
		this.Hat05 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat05");
		this.Hat04f = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat03").getChild("Hat04f");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.LegLeft02a = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02a");
		this.Hat02h = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat01").getChild("Hat02h");
		this.Hat02g_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat05").getChild("Hat02g_1");
		this.Hat02d_1 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat05").getChild("Hat02d_1");
		this.Skirt03 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02").getChild("Skirt03");
		this.HeadH3 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowHatBase").getChild("HeadH1").getChild("HeadH2").getChild("HeadH3");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.Hat04g = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HatBase").getChild("Hat03").getChild("Hat04g");
		this.EquipRdL01 = root.getChild("GlowBodyMain").getChild("EquipRdL01");
		this.EquipRdL02 = root.getChild("GlowBodyMain").getChild("EquipRdL01").getChild("EquipRdL02");
		this.EquipRdL03 = root.getChild("GlowBodyMain").getChild("EquipRdL01").getChild("EquipRdL02").getChild("EquipRdL03");
		this.EquipRdL04 = root.getChild("GlowBodyMain").getChild("EquipRdL01").getChild("EquipRdL02").getChild("EquipRdL03").getChild("EquipRdL04");
		this.EquipRdL05 = root.getChild("GlowBodyMain").getChild("EquipRdL01").getChild("EquipRdL02").getChild("EquipRdL03").getChild("EquipRdL04").getChild("EquipRdL05");
		this.EquipRdL06 = root.getChild("GlowBodyMain").getChild("EquipRdL01").getChild("EquipRdL02").getChild("EquipRdL03").getChild("EquipRdL04").getChild("EquipRdL05").getChild("EquipRdL06");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.GlowHatBase = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("GlowHatBase");
		this.scale = 0.38F;
		this.offsetY = 2.59F;
		this.offsetItem = new float[] {0.08F, 1.02F, -0.07F};
		this.offsetBlock = new float[] {0.08F, 1.02F, -0.07F};
		this.armMain = new ModelPart[] {this.BodyMain, this.ArmRight01, this.ArmRight02};
		this.armOff = new ModelPart[] {this.BodyMain, this.ArmLeft01, this.ArmLeft02};
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
		
		boolean flag = !EmotionHelper.checkModelState(1, state);	//hat
		this.HatBase.visible = !(flag);
		this.GlowHatBase.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);	//horn
		this.HeadH1.visible = !(flag);
		this.HeadH4.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(3, state);	//bowtie
		this.Cloth01a.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(4, state);	//shawl
		this.Cloth02a.visible = !(flag);
		this.Cloth02b.visible = !(flag);
		this.Cloth02c.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(5, state);	//shawl
		this.Cloth03a.visible = !(flag);
		this.Cloth03b.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(6, state);	//leg
		this.LegLeft02b.visible = !(flag);
		this.LegRight02b.visible = !(flag);
		this.LegLeft02a.visible = !(!flag);
		this.LegRight02a.visible = !(!flag);
		
		flag = !EmotionHelper.checkModelState(7, state);	//leg armor
		this.LegArmor01a.visible = !(flag);
		this.LegArmor02a.visible = !(flag);
	
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
		
		this.LegLeft02b.xRot = this.LegLeft02a.xRot;
		this.LegLeft02b.yRot = this.LegLeft02a.yRot;
		this.LegLeft02b.zRot = this.LegLeft02a.zRot;
		this.LegLeft02b.x = (3.0F) + (((this.LegLeft02a.getInitialPose().x - (3.0F)) / 16F)) * 16F;
		this.LegLeft02b.y = (14.0F) + (((this.LegLeft02a.getInitialPose().y - (14.0F)) / 16F)) * 16F;
		this.LegLeft02b.z = (-3.0F) + (((this.LegLeft02a.getInitialPose().z - (-3.0F)) / 16F)) * 16F;
		this.LegRight02b.xRot = this.LegRight02a.xRot;
		this.LegRight02b.yRot = this.LegRight02a.yRot;
		this.LegRight02b.zRot = this.LegRight02a.zRot;
		this.LegRight02b.x = (-3.0F) + (((this.LegRight02a.getInitialPose().x - (-3.0F)) / 16F)) * 16F;
		this.LegRight02b.y = (14.0F) + (((this.LegRight02a.getInitialPose().y - (14.0F)) / 16F)) * 16F;
		this.LegRight02b.z = (-3.0F) + (((this.LegRight02a.getInitialPose().z - (-3.0F)) / 16F)) * 16F;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (0.43F); this.animTransZ += (0F);
  		this.setFaceHungry(ent);

	  	//Body
    	this.Head.xRot = 0.5F;
    	this.Head.yRot = 0F;
    	this.Head.zRot = 0F;
  	    this.Ahoke.yRot = 0.45F;
	  	this.BodyMain.xRot = 0.5F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
    	this.Butt.xRot = -0.85F;
    	this.Butt.y = (2.0F) + (0F) * 16F;
    	this.Butt.z = (1.3F) + (0F) * 16F;
    	//cloth
	  	this.Skirt01.xRot = -0.087F;
	  	this.Skirt02.xRot = -0.087F;
	  	this.Skirt03.xRot = -0.052F;
	  	this.Cloth01a.y = (0.0F) + (0.092F) * 16F;
	  	this.Cloth01a.z = (-7.9F) + (0.1F) * 16F;
    	this.Cloth01c.xRot = -0.79F;
    	this.Cloth01c2.xRot = -0.73F;
    	//hair
    	this.Hair01.xRot = -0.12F;
    	this.Hair01.yRot = 0F;
    	this.Hair01.zRot = 0F;
    	this.Hair02.xRot = -0.33F;
    	this.Hair02.yRot = 0F;
    	this.Hair02.zRot = 0F;
    	this.Hair03.xRot = -0.38F;
    	this.Hair03.yRot = 0F;
    	this.Hair03.zRot = 0F;
	    //arm 
		this.ArmLeft01.xRot = -1.1F;
		this.ArmLeft01.yRot = 0.39F;
		this.ArmLeft01.zRot = -0.05F;
		this.ArmLeft02.xRot = -1.46F;
		this.ArmLeft02.zRot = 0F;
		this.ArmLeft02.x = (3.0F) + (0F) * 16F;
		this.ArmLeft02.z = (2.5F) + (0F) * 16F;
		this.ArmRight01.xRot = -1.1F;
	    this.ArmRight01.yRot = -0.39F;
		this.ArmRight01.zRot = 0.05F;
		this.ArmRight02.xRot = -1.46F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
		this.ArmRight02.z = (2.5F) + (0F) * 16F;
		//leg
	    this.LegLeft01.xRot = -1.96F;
		this.LegLeft01.yRot = -0.6F;
		this.LegLeft01.zRot = 1.56F;
		this.LegLeft01.y = (5.5F) + (0F) * 16F;
		this.LegLeft01.z = (-2.6F) + (0F) * 16F;
		this.LegLeft02a.xRot = 2.1F;
		this.LegLeft02a.yRot = 0F;
		this.LegLeft02a.zRot = 0F;
		this.LegLeft02a.x = (3.0F) + (0F) * 16F;
		this.LegLeft02a.y = (14.0F) + (0F) * 16F;
		this.LegLeft02a.z = (-3.0F) + (0.37F) * 16F;
		this.LegRight01.xRot = -0.96F;
		this.LegRight01.yRot = 0.36F;
		this.LegRight01.zRot = 0.14F;
		this.LegRight01.y = (5.5F) + (0F) * 16F;
		this.LegRight01.z = (-2.6F) + (0F) * 16F;
		this.LegRight02a.xRot = 1.2217F;
		this.LegRight02a.yRot = -1.2217F;
		this.LegRight02a.zRot = 1.0472F;
		this.LegRight02a.x = (-3.0F) + (0F) * 16F;
		this.LegRight02a.y = (14.0F) + (-0.06F) * 16F;
		this.LegRight02a.z = (-3.0F) + (0F) * 16F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F);
  		float angleX1 = Mth.cos(f2*0.08F + 0.3F + f * 0.5F);
  		float angleX2 = Mth.cos(f2*0.08F + 0.6F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.5F;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.5F;
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
  		addk1 = angleAdd1 - 0.157F;
	  	addk2 = angleAdd2 - 0.296F;

  	    //移動頭部使其看人
	  	this.Head.xRot = f4 * 0.014F; 	//上下角度
	  	this.Head.yRot = f3 * 0.01F;	//左右角度
	  	this.Head.zRot = 0F;
	  	headX = this.Head.xRot * -0.5F;
	    //正常站立動作
	  	//Body
  	    this.Ahoke.yRot = angleX * 0.25F + 0.5236F;
	  	this.BodyMain.xRot = -0.1047F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.35F;
    	this.Butt.y = (2.0F) + (0F) * 16F;
    	this.Butt.z = (1.3F) + (0F) * 16F;
    	//cloth
	  	this.Skirt01.xRot = -0.087F;
	  	this.Skirt02.xRot = -0.087F;
	  	this.Skirt03.xRot = -0.052F;
	  	this.Cloth01a.xRot = angleX * 0.08F + 0.79F;
	  	this.Cloth01a.y = (0.0F) + (0.092F) * 16F;
	  	this.Cloth01a.z = (-7.9F) + (0.1F) * 16F;
    	this.Cloth01c.xRot = -angleX * 0.12F - 0.9F;
    	this.Cloth01c2.xRot = -angleX * 0.12F - 0.85F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.03F + 0.21F + headX;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -angleX1 * 0.04F + 0.12F + headX;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -angleX2 * 0.07F - 0.26F;
	  	this.Hair03.zRot = 0F;
	    //arm 
	  	this.ArmLeft01.xRot = angleAdd2 * 0.8F - 0.05F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = angleX * 0.025F - 0.3F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.yRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    this.ArmRight01.xRot = angleAdd1 * 0.8F + 0.26F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -angleX * 0.025F + 0.3F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.yRot = 0F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.x = (-3.0F) + (0F) * 16F;
	    this.ArmRight02.z = (2.5F) + (0F) * 16F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.087F;
		this.LegLeft01.y = (5.5F) + (0F) * 16F;
		this.LegLeft01.z = (-2.6F) + (0F) * 16F;
		this.LegLeft02a.xRot = 0F;
		this.LegLeft02a.yRot = 0F;
		this.LegLeft02a.zRot = 0F;
		this.LegLeft02a.x = (3.0F) + (0F) * 16F;
		this.LegLeft02a.y = (14.0F) + (0F) * 16F;
		this.LegLeft02a.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.087F;
		this.LegRight01.y = (5.5F) + (0F) * 16F;
		this.LegRight01.z = (-2.6F) + (0F) * 16F;
		this.LegRight02a.xRot = 0F;
		this.LegRight02a.yRot = 0F;
		this.LegRight02a.zRot = 0F;
		this.LegRight02a.x = (-3.0F) + (0F) * 16F;
		this.LegRight02a.y = (14.0F) + (0F) * 16F;
		this.LegRight02a.z = (-3.0F) + (0F) * 16F;
		//equip
		this.EquipRdL01.visible = false;
		
		//奔跑動作
	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {
	    	//hair angleX * 0.03F + 0.21F + headX
	    	this.Hair01.xRot = angleAdd1 * 0.1F + f1 * 0.4F + headX;
	    	this.Hair02.xRot += 0F;
	    	this.Hair03.xRot += 0.1F;
		    //arm 
		    this.ArmLeft01.zRot += f1 * -0.2F;
		    this.ArmRight01.zRot += f1 * 0.2F;
  		}
	    
	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    //潛行跟蹲下動作
	    if (ent.getIsSneaking())
	    {
this.animTransX += (0F); this.animTransY += (0.06F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 0.6283F;
		  	this.BodyMain.xRot = 0.8727F;
		  	this.Skirt01.xRot = -0.35F;
		  	this.Skirt02.xRot = -0.19F;
		  	this.Skirt03.xRot = -0.24F;
		    //arm 
		  	this.ArmLeft01.xRot = -0.35F;
		    this.ArmLeft01.zRot = 0.2618F;
			this.ArmRight01.xRot = -0.35F;
			this.ArmRight01.zRot = -0.2618F;
			//leg
			addk1 -= 1.02F;
			addk2 -= 1.02F;
			//hair
			this.Hair01.xRot += 0.37F;
			this.Hair02.xRot += 0.23F;
			this.Hair03.xRot -= 0.1F;
  		}//end if sneaking
  		
	    //坐下動作
	    if (ent.getIsSitting() && !ent.getIsRiding())
	    {
	    	if (ent.getTickExisted() % 512 > 256)
	    	{
this.animTransX += (0F); this.animTransY += (0.48F); this.animTransZ += (0F);
	      		this.setFaceScorn(ent);

	    	  	//Body
	        	this.Head.xRot += 0.1F;
	    	  	this.BodyMain.xRot = -0.1F;
	    	  	this.Butt.xRot = -0.4F;
	    	  	this.Butt.z = (1.3F) + (0.19F) * 16F;
	      	    this.Ahoke.yRot = 0.5236F;
	      	    this.Skirt01.xRot = -0.35F;
			  	this.Skirt02.xRot = -0.19F;
			  	this.Skirt03.xRot = -0.24F;
	    	  	//hair
	    	  	this.Hair01.xRot = 0.21F + headX;
	    	  	this.Hair02.xRot = -0.28F + headX;
	    	  	this.Hair03.xRot = -0.24F;
	    	    //arm 
	    	  	this.ArmLeft01.xRot = -1.18F;
	    	  	this.ArmLeft01.yRot = 0.27F;
	    	    this.ArmLeft01.zRot = -0.1F;
	    	    this.ArmLeft02.zRot = 0.92F;
	    		this.ArmRight01.xRot = -1.18F;
	    		this.ArmRight01.yRot = -0.27F;
	    		this.ArmRight01.zRot = 0.1F;
	    		this.ArmRight02.zRot = -1.32F;
	    		//leg
	    		addk1 = -2.57F;
	    		addk2 = -2.57F;
	    		this.LegLeft01.y = (5.5F) + (0.25F) * 16F;
	    		this.LegLeft01.z = (-2.6F) + (-0.2F) * 16F;
	    		this.LegLeft01.yRot = 0.11F;
	    		this.LegLeft01.zRot = -0.12F;
	    		this.LegLeft02a.xRot = 2.75F;
	    		this.LegLeft02a.zRot = 0.02F;
	    		this.LegLeft02a.z = (-3.0F) + (0.37F) * 16F;
	    		this.LegRight01.y = (5.5F) + (0.25F) * 16F;
	    		this.LegRight01.z = (-2.6F) + (-0.2F) * 16F;
	    		this.LegRight01.yRot = -0.11F;
	    		this.LegRight01.zRot = 0.12F;
	    		this.LegRight02a.xRot = 2.75F;
	    		this.LegRight02a.zRot = -0.02F;
	    		this.LegRight02a.z = (-3.0F) + (0.37F) * 16F;
	    	}
	    	else
	    	{
		    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		    	{
this.animTransX += (0F); this.animTransY += (0.27F); this.animTransZ += (0F);
			    	//Body
			    	this.Head.xRot += 0.14F;
				  	this.BodyMain.xRot = -0.4363F;
				  	this.Skirt01.xRot = -0.35F;
				  	this.Skirt02.xRot = -0.19F;
				  	this.Skirt03.xRot = -0.24F;
				    //arm 
				  	this.ArmLeft01.xRot = -0.3142F;
				    this.ArmLeft01.zRot = 0.3490F;
				    this.ArmLeft02.zRot = 1.15F;
					this.ArmRight01.xRot = -0.4363F;
					this.ArmRight01.zRot = -0.2793F;
					this.ArmRight02.zRot = -1.4F;
					//leg
					addk1 = -1.3090F;
					addk2 = -1.7F;
					this.LegLeft01.yRot = 0.3142F;
					this.LegLeft02a.xRot = 1.0472F;
					this.LegRight01.yRot = -0.35F;
					this.LegRight01.zRot = -0.2618F;
					this.LegRight02a.xRot = 0.9F;
					//hair
					this.Hair01.xRot += 0.12F;
					this.Hair02.xRot += 0.15F;
					this.Hair03.xRot += 0.25F;
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.37F); this.animTransZ += (0F);
			    	//Body
			    	this.Head.xRot += 0.14F;
				  	this.BodyMain.xRot = -0.5236F;
				  	this.Skirt01.xRot = -0.35F;
				  	this.Skirt02.xRot = -0.19F;
				  	this.Skirt03.xRot = -0.24F;
				    //arm 
				  	this.ArmLeft01.xRot = -0.4363F;
				    this.ArmLeft01.zRot = 0.3142F;
					this.ArmRight01.xRot = -0.4363F;
					this.ArmRight01.zRot = -0.3142F;
					//leg
					addk1 = -1.6232F;
					addk2 = -1.5708F;
					this.LegLeft01.zRot = -0.3142F;
					this.LegLeft02a.xRot = 1.34F;
					this.LegRight01.zRot = 0.35F;
					this.LegRight02a.xRot = 1.13F;
					//hair
					this.Hair01.xRot += 0.09F;
					this.Hair02.xRot += 0.43F;
					this.Hair03.xRot += 0.49F;
		    	}
	    	}
  		}//end sitting
	    
	    //騎乘專屬坐騎動作
	    if (ent.getIsRiding())
	    {
	    	if (((Entity)ent).getVehicle() instanceof BasicEntityMount)
	    	{
	    		if (ent.getIsSitting())
	    		{
	    			RenderHelper.animRotate(this, -40F, 0F, 1F, 0F);
	    			
	    			if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    			{
this.animTransX += (0F); this.animTransY += (0.02F); this.animTransZ += (0F);
			      		this.setFaceScorn(ent);

			    	  	//Body
			        	this.Head.xRot += 0.1F;
			    	  	this.BodyMain.xRot = -0.1F;
			    	  	this.Butt.xRot = -0.4F;
			    	  	this.Butt.z = (1.3F) + (0.19F) * 16F;
			      	    this.Ahoke.yRot = 0.5236F;
			      	    this.Skirt01.xRot = -0.35F;
					  	this.Skirt02.xRot = -0.19F;
					  	this.Skirt03.xRot = -0.24F;
			    	  	//hair
			    	  	this.Hair01.xRot = 0.21F + headX;
			    	  	this.Hair02.xRot = -0.28F + headX;
			    	  	this.Hair03.xRot = -0.24F;
			    	    //arm 
			    	  	this.ArmLeft01.xRot = -1.18F;
			    	  	this.ArmLeft01.yRot = 0.27F;
			    	    this.ArmLeft01.zRot = -0.1F;
			    	    this.ArmLeft02.zRot = 0.92F;
			    		this.ArmRight01.xRot = -1.18F;
			    		this.ArmRight01.yRot = -0.27F;
			    		this.ArmRight01.zRot = 0.1F;
			    		this.ArmRight02.zRot = -1.32F;
			    		//leg
			    		addk1 = -2.57F;
			    		addk2 = -2.57F;
			    		this.LegLeft01.y = (5.5F) + (0.25F) * 16F;
			    		this.LegLeft01.z = (-2.6F) + (-0.2F) * 16F;
			    		this.LegLeft01.yRot = 0.11F;
			    		this.LegLeft01.zRot = -0.12F;
			    		this.LegLeft02a.xRot = 2.75F;
			    		this.LegLeft02a.zRot = 0.02F;
			    		this.LegLeft02a.z = (-3.0F) + (0.37F) * 16F;
			    		this.LegRight01.y = (5.5F) + (0.25F) * 16F;
			    		this.LegRight01.z = (-2.6F) + (-0.2F) * 16F;
			    		this.LegRight01.yRot = -0.11F;
			    		this.LegRight01.zRot = 0.12F;
			    		this.LegRight02a.xRot = 2.75F;
			    		this.LegRight02a.zRot = -0.02F;
			    		this.LegRight02a.z = (-3.0F) + (0.37F) * 16F;
			    	}
			    	else
			    	{
				    	if (ent.getTickExisted() % 512 >  256)
				    	{
this.animTransX += (0F); this.animTransY += (0F); this.animTransZ += (0F);
					    	//Body
					    	this.Head.xRot += 0.14F;
						  	this.BodyMain.xRot = -0.4363F;
						  	this.Skirt01.xRot = -0.35F;
						  	this.Skirt02.xRot = -0.19F;
						  	this.Skirt03.xRot = -0.24F;
						    //arm 
						  	this.ArmLeft01.xRot = -0.3142F;
						    this.ArmLeft01.zRot = 0.3490F;
						    this.ArmLeft02.zRot = 1.15F;
							this.ArmRight01.xRot = -0.4363F;
							this.ArmRight01.zRot = -0.2793F;
							this.ArmRight02.zRot = -1.4F;
							//leg
							addk1 = -1.3090F;
							addk2 = -1.7F;
							this.LegLeft01.yRot = 0.3142F;
							this.LegLeft02a.xRot = 1.0472F;
							this.LegRight01.yRot = -0.35F;
							this.LegRight01.zRot = -0.2618F;
							this.LegRight02a.xRot = 0.9F;
							//hair
							this.Hair01.xRot += 0.12F;
							this.Hair02.xRot += 0.15F;
							this.Hair03.xRot += 0.25F;
				    	}
				    	else
				    	{
this.animTransX += (0F); this.animTransY += (0.03F); this.animTransZ += (0F);
					    	//Body
					    	this.Head.xRot += 0.14F;
						  	this.BodyMain.xRot = -0.5236F;
						  	this.Skirt01.xRot = -0.35F;
						  	this.Skirt02.xRot = -0.19F;
						  	this.Skirt03.xRot = -0.24F;
						    //arm 
						  	this.ArmLeft01.xRot = -0.4363F;
						    this.ArmLeft01.zRot = 0.3142F;
							this.ArmRight01.xRot = -0.4363F;
							this.ArmRight01.zRot = -0.3142F;
							//leg
							addk1 = -1.6232F;
							addk2 = -1.5708F;
							this.LegLeft01.zRot = -0.3142F;
							this.LegLeft02a.xRot = 1.34F;
							this.LegRight01.zRot = 0.35F;
							this.LegRight02a.xRot = 1.13F;
							//hair
							this.Hair01.xRot += 0.09F;
							this.Hair02.xRot += 0.43F;
							this.Hair03.xRot += 0.49F;
				    	}
			    	}
		    	}//end if sitting
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.03F); this.animTransZ += (0F);
			    	//body
			    	this.Head.xRot -= 0.7F;
			    	this.BodyMain.xRot = 0.35F;
			    	//hair
					this.Hair01.xRot += 0.5F;
					this.Hair02.xRot += 0.15F;
					this.Hair03.xRot += 0F;
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
					this.LegLeft02a.xRot = 2.1816615649929116F;
					this.LegLeft02a.yRot = 0.0F;
					this.LegLeft02a.zRot = 0.0F;
					this.LegLeft02a.x = (3.0F) + (0F) * 16F;
					this.LegLeft02a.z = (-3.0F) + (0.37F) * 16F;
					this.LegRight01.yRot = 0.5235987755982988F;
					this.LegRight01.zRot = 1.3962634015954636F;
					this.LegRight02a.xRot = 2.1816615649929116F;
					this.LegRight02a.yRot = 0.0F;
					this.LegRight02a.zRot = 0.0F;
					this.LegRight02a.x = (-3.0F) + (0F) * 16F;
					this.LegRight02a.z = (-3.0F) + (0.37F) * 16F;
		    	}
	    	}//end ship mount
	    	//normal mount ex: cart
	    	else
	    	{
		    	if (ent.getTickExisted() % 512 > 256)
		    	{
this.animTransX += (0F); this.animTransY += (0.48F); this.animTransZ += (0F);
		      		this.setFaceScorn(ent);

		    	  	//Body
		        	this.Head.xRot += 0.1F;
		    	  	this.BodyMain.xRot = -0.1F;
		    	  	this.Butt.xRot = -0.4F;
		    	  	this.Butt.z = (1.3F) + (0.19F) * 16F;
		      	    this.Ahoke.yRot = 0.5236F;
		      	    this.Skirt01.xRot = -0.35F;
				  	this.Skirt02.xRot = -0.19F;
				  	this.Skirt03.xRot = -0.24F;
		    	  	//hair
		    	  	this.Hair01.xRot = 0.21F + headX;
		    	  	this.Hair02.xRot = -0.28F + headX;
		    	  	this.Hair03.xRot = -0.24F;
		    	    //arm 
		    	  	this.ArmLeft01.xRot = -1.18F;
		    	  	this.ArmLeft01.yRot = 0.27F;
		    	    this.ArmLeft01.zRot = -0.1F;
		    	    this.ArmLeft02.zRot = 0.92F;
		    		this.ArmRight01.xRot = -1.18F;
		    		this.ArmRight01.yRot = -0.27F;
		    		this.ArmRight01.zRot = 0.1F;
		    		this.ArmRight02.zRot = -1.32F;
		    		//leg
		    		addk1 = -2.57F;
		    		addk2 = -2.57F;
		    		this.LegLeft01.y = (5.5F) + (0.25F) * 16F;
		    		this.LegLeft01.z = (-2.6F) + (-0.2F) * 16F;
		    		this.LegLeft01.yRot = 0.11F;
		    		this.LegLeft01.zRot = -0.12F;
		    		this.LegLeft02a.xRot = 2.75F;
		    		this.LegLeft02a.zRot = 0.02F;
		    		this.LegLeft02a.z = (-3.0F) + (0.37F) * 16F;
		    		this.LegRight01.y = (5.5F) + (0.25F) * 16F;
		    		this.LegRight01.z = (-2.6F) + (-0.2F) * 16F;
		    		this.LegRight01.yRot = -0.11F;
		    		this.LegRight01.zRot = 0.12F;
		    		this.LegRight02a.xRot = 2.75F;
		    		this.LegRight02a.zRot = -0.02F;
		    		this.LegRight02a.z = (-3.0F) + (0.37F) * 16F;
		    	}
		    	else
		    	{
			    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
			    	{
this.animTransX += (0F); this.animTransY += (0.27F); this.animTransZ += (0F);
				    	//Body
				    	this.Head.xRot += 0.14F;
					  	this.BodyMain.xRot = -0.4363F;
					  	this.Skirt01.xRot = -0.35F;
					  	this.Skirt02.xRot = -0.19F;
					  	this.Skirt03.xRot = -0.24F;
					    //arm 
					  	this.ArmLeft01.xRot = -0.3142F;
					    this.ArmLeft01.zRot = 0.3490F;
					    this.ArmLeft02.zRot = 1.15F;
						this.ArmRight01.xRot = -0.4363F;
						this.ArmRight01.zRot = -0.2793F;
						this.ArmRight02.zRot = -1.4F;
						//leg
						addk1 = -1.3090F;
						addk2 = -1.7F;
						this.LegLeft01.yRot = 0.3142F;
						this.LegLeft02a.xRot = 1.0472F;
						this.LegRight01.yRot = -0.35F;
						this.LegRight01.zRot = -0.2618F;
						this.LegRight02a.xRot = 0.9F;
						//hair
						this.Hair01.xRot += 0.12F;
						this.Hair02.xRot += 0.15F;
						this.Hair03.xRot += 0.25F;
			    	}
			    	else
			    	{
this.animTransX += (0F); this.animTransY += (0.37F); this.animTransZ += (0F);
				    	//Body
				    	this.Head.xRot += 0.14F;
					  	this.BodyMain.xRot = -0.5236F;
					  	this.Skirt01.xRot = -0.35F;
					  	this.Skirt02.xRot = -0.19F;
					  	this.Skirt03.xRot = -0.24F;
					    //arm 
					  	this.ArmLeft01.xRot = -0.4363F;
					    this.ArmLeft01.zRot = 0.3142F;
						this.ArmRight01.xRot = -0.4363F;
						this.ArmRight01.zRot = -0.3142F;
						//leg
						addk1 = -1.6232F;
						addk2 = -1.5708F;
						this.LegLeft01.zRot = -0.3142F;
						this.LegLeft02a.xRot = 1.34F;
						this.LegRight01.zRot = 0.35F;
						this.LegRight02a.xRot = 1.13F;
						//hair
						this.Hair01.xRot += 0.09F;
						this.Hair02.xRot += 0.43F;
						this.Hair03.xRot += 0.49F;
			    	}
		    	}
	    	}
	    }//end ridding
    
	    //攻擊動作    
	    if (ent.getAttackTick() > 0)
	    {
	    	if (ent.getAttackTick() > 25)
	    	{
	    		//arm
		    	this.ArmLeft01.xRot = -1.3F + this.Head.xRot * 0.75F;
		    	this.ArmLeft01.yRot = -0.2F;
		    	this.ArmLeft01.zRot = 0F;
		    	this.ArmLeft02.xRot = 0F;
		    	this.ArmLeft02.yRot = 0F;
			    this.ArmLeft02.zRot = 0F;
			    this.ArmLeft02.x = (3.0F) + (0F) * 16F;
			    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    	}
	    	
	    	//跑道顯示
	    	setRoad(ent.getAttackTick());
	    }
	    
	    //移動頭髮避免穿過身體
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.zRot = headZ;
	  	this.Hair02.zRot = headZ;
	  	this.Hair03.zRot = headZ;
	    
	  	//swing arm
	  	float f6 = ent.getSwingTime(f2 % 1F);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight01.xRot = -0.3F;
			this.ArmRight01.yRot = 0F;
			this.ArmRight01.zRot = -0.1F;
	        this.ArmRight01.xRot += -f8 * 80.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.yRot += -f7 * 20.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.zRot += -f8 * 20.0F * Values.N.DIV_PI_180;
	        this.ArmRight02.xRot = 0F;
	        this.ArmRight02.zRot = 0F;
	  	}
	  	
	    //leg motion
	    this.LegLeft01.xRot = addk1;
	    this.LegRight01.xRot = addk2;
	
	}

	private void setRoad(int attackTime)
	{

		switch (attackTime)
		{
		case 50:
		case 26:
			this.EquipRdL01.visible = true;
			this.EquipRdL02.visible = false;
		break;
		case 49:
		case 27:
			this.EquipRdL01.visible = true;
			this.EquipRdL02.visible = true;
			this.EquipRdL03.visible = false;
		break;
		case 48:
		case 28:
			this.EquipRdL01.visible = true;
			this.EquipRdL02.visible = true;
			this.EquipRdL03.visible = true;
			this.EquipRdL04.visible = false;
		break;
		case 47:
		case 29:
			this.EquipRdL01.visible = true;
			this.EquipRdL02.visible = true;
			this.EquipRdL03.visible = true;
			this.EquipRdL04.visible = true;
			this.EquipRdL05.visible = false;
		break;
		case 46:
		case 30:
			this.EquipRdL01.visible = true;
			this.EquipRdL02.visible = true;
			this.EquipRdL03.visible = true;
			this.EquipRdL04.visible = true;
			this.EquipRdL05.visible = true;
			this.EquipRdL06.visible = false;
		break;
		default:
			if (attackTime < 46 && attackTime > 30)
			{
				this.EquipRdL01.visible = true;
				this.EquipRdL02.visible = true;
				this.EquipRdL03.visible = true;
				this.EquipRdL04.visible = true;
				this.EquipRdL05.visible = true;
				this.EquipRdL06.visible = true;
			}		
		break;
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

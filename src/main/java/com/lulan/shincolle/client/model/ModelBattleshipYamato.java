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

public class ModelBattleshipYamato<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart Butt;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart Cloth01;
	public ModelPart EquipBaseBelt;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart EquipHeadBase;
	public ModelPart Ahoke;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart HairU01;
	public ModelPart HairL02;
	public ModelPart HairL03;
	public ModelPart HairR02;
	public ModelPart HairR03;
	public ModelPart HairBase;
	public ModelPart Hair00;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart Hair03;
	public ModelPart Hair04;
	public ModelPart HeadEquip01a;
	public ModelPart HeadEquip02a;
	public ModelPart HeadEquip01b;
	public ModelPart HeadEquip01c;
	public ModelPart HeadEquip01d;
	public ModelPart HeadEquip01b2;
	public ModelPart HeadEquip02b;
	public ModelPart HeadEquip02c;
	public ModelPart HeadEquip02d;
	public ModelPart HeadEquip02b2;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart Skirt01;
	public ModelPart AnchorL;
	public ModelPart AnchorR;
	public ModelPart LegRight02;
	public ModelPart EquipLegR01;
	public ModelPart ShoesR01;
	public ModelPart EquipLegR02a;
	public ModelPart EquipLegR02b;
	public ModelPart EquipLegR02c;
	public ModelPart LegLeft02;
	public ModelPart EquipLegL01;
	public ModelPart ShoesL01;
	public ModelPart EquipLegL02a;
	public ModelPart EquipLegL02b;
	public ModelPart EquipLegL02c;
	public ModelPart Skirt02;
	public ModelPart ArmLeft01a;
	public ModelPart ArmLeft02;
	public ModelPart ArmRight02;
	public ModelPart EquipU01;
	public ModelPart EquipU01a;
	public ModelPart EquipU01b;
	public ModelPart EquipU02;
	public ModelPart EquipU03a;
	public ModelPart EquipU04a;
	public ModelPart EquipU05a;
	public ModelPart EquipU06;
	public ModelPart EquipU09a;
	public ModelPart EquipU09b;
	public ModelPart EquipU09c;
	public ModelPart EquipU03b;
	public ModelPart EquipU03c;
	public ModelPart EquipU03d;
	public ModelPart EquipU04b;
	public ModelPart EquipU04c;
	public ModelPart EquipU04d;
	public ModelPart EquipU05b;
	public ModelPart EquipU05c;
	public ModelPart EquipU05d;
	public ModelPart EquipU07;
	public ModelPart EquipU08;
	public ModelPart Cloth02a;
	public ModelPart Cloth02b;
	public ModelPart EquipRotateBase;
	public ModelPart EquipBaseBelt2;
	public ModelPart EquipBaseM01a;
	public ModelPart EquipBaseM01b;
	public ModelPart EquipL01;
	public ModelPart EquipR01;
	public ModelPart EquipBaseM02;
	public ModelPart EquipL02;
	public ModelPart EquipL03;
	public ModelPart EquipL04;
	public ModelPart EquipLCBase01;
	public ModelPart EquipL05;
	public ModelPart EquipLC2Base01;
	public ModelPart EquipLC3Base01;
	public ModelPart EquipLC2Base02;
	public ModelPart EquipLC201a;
	public ModelPart EquipLC202a;
	public ModelPart EquipLC203a;
	public ModelPart EquipLC2Radar01;
	public ModelPart EquipLC2Radar02;
	public ModelPart EquipLC201b;
	public ModelPart EquipLC202b;
	public ModelPart EquipLC203b;
	public ModelPart EquipLC3Base02;
	public ModelPart EquipLC301a;
	public ModelPart EquipLC302a;
	public ModelPart EquipLC303a;
	public ModelPart EquipLC3Radar01;
	public ModelPart EquipLC3Radar02;
	public ModelPart EquipLC301b;
	public ModelPart EquipLC302b;
	public ModelPart EquipLC303b;
	public ModelPart EquipLCBase02;
	public ModelPart EquipLC01a;
	public ModelPart EquipLC02a;
	public ModelPart EquipLC03a;
	public ModelPart EquipLCRadar01;
	public ModelPart EquipLCRadar02;
	public ModelPart EquipLC01b;
	public ModelPart EquipLC02b;
	public ModelPart EquipLC03b;
	public ModelPart EquipR02;
	public ModelPart EquipMCBase01a;
	public ModelPart EquipMCBase01b;
	public ModelPart EquipR03;
	public ModelPart EquipRCBase01;
	public ModelPart EquipR04;
	public ModelPart EquipRCBase02;
	public ModelPart EquipRC01a;
	public ModelPart EquipRC02a;
	public ModelPart EquipRC03a;
	public ModelPart EquipRCRadar01;
	public ModelPart EquipRCRadar02;
	public ModelPart EquipRC01b;
	public ModelPart EquipRC02b;
	public ModelPart EquipRC03b;
	public ModelPart EquipR05;
	public ModelPart EquipRC2Base01;
	public ModelPart EquipRC3Base01;
	public ModelPart EquipRC2Base02;
	public ModelPart EquipRC201a;
	public ModelPart EquipRC202a;
	public ModelPart EquipRC203a;
	public ModelPart EquipRC2Radar01;
	public ModelPart EquipRC2Radar02;
	public ModelPart EquipRC201b;
	public ModelPart EquipRC202b;
	public ModelPart EquipRC203b;
	public ModelPart EquipRC3Base02;
	public ModelPart EquipRC301a;
	public ModelPart EquipRC302a;
	public ModelPart EquipRC303a;
	public ModelPart EquipRC3Radar01;
	public ModelPart EquipRC3Radar02;
	public ModelPart EquipRC301b;
	public ModelPart EquipRC302b;
	public ModelPart EquipRC303b;
	public ModelPart EquipLCBase01_1;
	public ModelPart EquipLCBase02_1;
	public ModelPart EquipLC01a_1;
	public ModelPart EquipLC02a_1;
	public ModelPart EquipLC03a_1;
	public ModelPart EquipMCRadar01;
	public ModelPart EquipMCRadar02;
	public ModelPart EquipLC01b_1;
	public ModelPart EquipLC02b_1;
	public ModelPart EquipLC03b_1;
	public ModelPart EquipBaseM03;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(3.7F, -8.5F, -3.5F, -0.6981317007977318F, 0.13962634015954636F, 0.08726646259971647F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 14.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.7F, -0.7F, 0.20943951023931953F, 0.0F, -0.2617993877991494F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 14.0F, 5.0F), PartPose.offset(3.0F, 13.0F, 2.5F));
		PartDefinition partdef4 = partdef2.addOrReplaceChild("ArmLeft01a", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 6.0F), PartPose.offset(0.5F, 5.5F, 0.0F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-3.7F, -8.5F, -3.5F, -0.6981317007977318F, -0.13962634015954636F, -0.08726646259971647F));
		PartDefinition partdef6 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-6.0F, 0.0F, -4.0F, 12.0F, 4.0F, 8.0F), PartPose.offset(0.0F, -11.3F, -0.3F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("Cloth02a", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 4.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 3.2F, -4.0F, -0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("Cloth02b", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.9424777960769379F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef0.addOrReplaceChild("EquipBaseBelt", CubeListBuilder.create().addBox(-8.0F, 0.7F, -2.0F, 16.0F, 4.0F, 14.0F), PartPose.offsetAndRotation(0.0F, 2.0F, -2.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("EquipRotateBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 10.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("EquipBaseM01a", CubeListBuilder.create().addBox(2.5F, 0.0F, -1.0F, 5.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef10.addOrReplaceChild("EquipBaseM01b", CubeListBuilder.create().addBox(-7.5F, 0.0F, -1.0F, 5.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("EquipR01", CubeListBuilder.create().addBox(-16.0F, 0.0F, 0.0F, 16.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 5.5F, 3.0F, -0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("EquipMCBase01b", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(-8.0F, 8.0F, 0.0F, 1.0471975511965976F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef13.addOrReplaceChild("EquipR02", CubeListBuilder.create().addBox(-13.0F, 0.0F, 0.0F, 13.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(-13.5F, -0.5F, 0.6F, 0.0F, -0.5235987755982988F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("EquipR03", CubeListBuilder.create().addBox(-6.0F, 0.0F, -14.0F, 6.0F, 22.0F, 17.0F), PartPose.offsetAndRotation(-10.5F, -2.5F, -1.0F, 0.0F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("EquipRCBase01", CubeListBuilder.create().addBox(-8.5F, -5.0F, -7.0F, 16.0F, 9.0F, 14.0F), PartPose.offset(-3.0F, 3.0F, -5.5F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("EquipRCBase02", CubeListBuilder.create().addBox(-8.5F, -8.0F, -7.0F, 17.0F, 8.0F, 21.0F), PartPose.offsetAndRotation(-0.5F, -4.5F, -2.0F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("EquipRCRadar02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F), PartPose.offset(-13.3F, -7.0F, 5.0F));
		PartDefinition partdef20 = partdef18.addOrReplaceChild("EquipRCRadar01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F), PartPose.offset(8.3F, -7.0F, 5.0F));
		PartDefinition partdef21 = partdef18.addOrReplaceChild("EquipRC02a", CubeListBuilder.create().addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -4.5F, -6.0F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("EquipRC02b", CubeListBuilder.create().addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef23 = partdef18.addOrReplaceChild("EquipRC03a", CubeListBuilder.create().addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(5.0F, -4.5F, -6.0F, -0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("EquipRC03b", CubeListBuilder.create().addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef25 = partdef18.addOrReplaceChild("EquipRC01a", CubeListBuilder.create().addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-5.0F, -4.5F, -6.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("EquipRC01b", CubeListBuilder.create().addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef27 = partdef16.addOrReplaceChild("EquipR04", CubeListBuilder.create().addBox(-6.0F, 0.0F, -13.0F, 6.0F, 11.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 11.0F, -12.7F, 0.0F, -0.20943951023931953F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("EquipRC3Base01", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-7.0F, 5.0F, -12.0F, 0.0F, 0.0F, -1.5707963267948966F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("EquipRC3Base02", CubeListBuilder.create().addBox(-4.5F, -5.0F, -5.5F, 9.0F, 5.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 4.0F, -0.05235987755982988F, -0.18203784098300857F, 0.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("EquipRC302a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("EquipRC302b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition partdef32 = partdef29.addOrReplaceChild("EquipRC3Radar02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(-6.4F, -4.0F, -1.0F));
		PartDefinition partdef33 = partdef29.addOrReplaceChild("EquipRC303a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(2.6F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("EquipRC303b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition partdef35 = partdef29.addOrReplaceChild("EquipRC3Radar01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(4.4F, -4.0F, -1.0F));
		PartDefinition partdef36 = partdef29.addOrReplaceChild("EquipRC301a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-2.6F, -3.0F, -6.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef37 = partdef36.addOrReplaceChild("EquipRC301b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition partdef38 = partdef27.addOrReplaceChild("EquipRC2Base01", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 7.0F), PartPose.offset(-2.5F, -4.0F, -10.5F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("EquipRC2Base02", CubeListBuilder.create().addBox(-4.5F, -5.0F, -5.5F, 9.0F, 5.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 4.0F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef40 = partdef39.addOrReplaceChild("EquipRC2Radar02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(-6.4F, -4.0F, -1.0F));
		PartDefinition partdef41 = partdef39.addOrReplaceChild("EquipRC2Radar01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(4.4F, -4.0F, -1.0F));
		PartDefinition partdef42 = partdef39.addOrReplaceChild("EquipRC203a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(2.6F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("EquipRC203b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition partdef44 = partdef39.addOrReplaceChild("EquipRC202a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("EquipRC202b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition partdef46 = partdef39.addOrReplaceChild("EquipRC201a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-2.6F, -3.0F, -6.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef47 = partdef46.addOrReplaceChild("EquipRC201b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition partdef48 = partdef27.addOrReplaceChild("EquipR05", CubeListBuilder.create().addBox(0.0F, 0.0F, -10.0F, 5.0F, 13.0F, 10.0F), PartPose.offsetAndRotation(-6.0F, -2.5F, -13.0F, 0.0F, -0.7853981633974483F, 0.0F));
		PartDefinition partdef49 = partdef13.addOrReplaceChild("EquipMCBase01a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 4.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(8.0F, 8.0F, 0.0F, 1.0471975511965976F, 0.0F, 0.0F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("EquipLCBase01_1", CubeListBuilder.create().addBox(-8.0F, -5.0F, -7.0F, 16.0F, 8.0F, 14.0F), PartPose.offsetAndRotation(-8.0F, 7.0F, 3.0F, -2.5953045977155678F, 0.0F, 0.0F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("EquipLCBase02_1", CubeListBuilder.create().addBox(-8.5F, -8.0F, -10.0F, 17.0F, 8.0F, 21.0F), PartPose.offsetAndRotation(0.5F, -4.5F, 0.0F, -0.05235987755982988F, 3.141592653589793F, 0.0F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("EquipMCRadar02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F), PartPose.offset(-13.3F, -7.0F, 2.0F));
		PartDefinition partdef53 = partdef51.addOrReplaceChild("EquipLC02a_1", CubeListBuilder.create().addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -4.5F, -9.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef54 = partdef53.addOrReplaceChild("EquipLC02b_1", CubeListBuilder.create().addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef55 = partdef51.addOrReplaceChild("EquipLC01a_1", CubeListBuilder.create().addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-5.0F, -4.5F, -9.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef56 = partdef55.addOrReplaceChild("EquipLC01b_1", CubeListBuilder.create().addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef57 = partdef51.addOrReplaceChild("EquipLC03a_1", CubeListBuilder.create().addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(5.0F, -4.5F, -9.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("EquipLC03b_1", CubeListBuilder.create().addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef59 = partdef51.addOrReplaceChild("EquipMCRadar01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F), PartPose.offset(8.3F, -7.0F, 2.0F));
		PartDefinition partdef60 = partdef12.addOrReplaceChild("EquipL01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 5.5F, 3.0F, -0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("EquipL02", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 13.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(13.5F, -0.5F, 0.6F, 0.0F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef62 = partdef61.addOrReplaceChild("EquipL03", CubeListBuilder.create().addBox(0.0F, 0.0F, -14.0F, 6.0F, 22.0F, 17.0F), PartPose.offsetAndRotation(10.5F, -2.5F, -1.0F, 0.0F, -0.6981317007977318F, 0.0F));
		PartDefinition partdef63 = partdef62.addOrReplaceChild("EquipLCBase01", CubeListBuilder.create().addBox(-7.5F, -5.0F, -7.0F, 16.0F, 9.0F, 14.0F), PartPose.offset(3.0F, 3.0F, -5.5F));
		PartDefinition partdef64 = partdef63.addOrReplaceChild("EquipLCBase02", CubeListBuilder.create().addBox(-8.5F, -8.0F, -7.0F, 17.0F, 8.0F, 21.0F), PartPose.offsetAndRotation(0.5F, -4.5F, -2.0F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef65 = partdef64.addOrReplaceChild("EquipLC02a", CubeListBuilder.create().addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -4.5F, -6.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef66 = partdef65.addOrReplaceChild("EquipLC02b", CubeListBuilder.create().addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef67 = partdef64.addOrReplaceChild("EquipLCRadar02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F), PartPose.offset(-13.3F, -7.0F, 5.0F));
		PartDefinition partdef68 = partdef64.addOrReplaceChild("EquipLCRadar01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 5.0F, 4.0F, 6.0F), PartPose.offset(8.3F, -7.0F, 5.0F));
		PartDefinition partdef69 = partdef64.addOrReplaceChild("EquipLC03a", CubeListBuilder.create().addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(5.0F, -4.5F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef70 = partdef69.addOrReplaceChild("EquipLC03b", CubeListBuilder.create().addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef71 = partdef64.addOrReplaceChild("EquipLC01a", CubeListBuilder.create().addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-5.0F, -4.5F, -6.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef72 = partdef71.addOrReplaceChild("EquipLC01b", CubeListBuilder.create().addBox(-1.5F, -1.5F, -17.0F, 3.0F, 3.0F, 17.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef73 = partdef62.addOrReplaceChild("EquipL04", CubeListBuilder.create().addBox(0.0F, 0.0F, -13.0F, 6.0F, 11.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 11.0F, -12.7F, 0.0F, 0.20943951023931953F, 0.0F));
		PartDefinition partdef74 = partdef73.addOrReplaceChild("EquipLC2Base01", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 7.0F), PartPose.offset(2.5F, -4.0F, -10.5F));
		PartDefinition partdef75 = partdef74.addOrReplaceChild("EquipLC2Base02", CubeListBuilder.create().addBox(-4.5F, -5.0F, -5.5F, 9.0F, 5.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 4.0F, -0.05235987755982988F, -0.27314402793711257F, 0.0F));
		PartDefinition partdef76 = partdef75.addOrReplaceChild("EquipLC203a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(2.6F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef77 = partdef76.addOrReplaceChild("EquipLC203b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition partdef78 = partdef75.addOrReplaceChild("EquipLC2Radar02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(-6.4F, -4.0F, -1.0F));
		PartDefinition partdef79 = partdef75.addOrReplaceChild("EquipLC2Radar01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(4.4F, -4.0F, -1.0F));
		PartDefinition partdef80 = partdef75.addOrReplaceChild("EquipLC201a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-2.6F, -3.0F, -6.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef81 = partdef80.addOrReplaceChild("EquipLC201b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition partdef82 = partdef75.addOrReplaceChild("EquipLC202a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef83 = partdef82.addOrReplaceChild("EquipLC202b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition partdef84 = partdef73.addOrReplaceChild("EquipLC3Base01", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 8.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(7.0F, 5.0F, -12.0F, 0.0F, 0.0F, 1.5707963267948966F));
		PartDefinition partdef85 = partdef84.addOrReplaceChild("EquipLC3Base02", CubeListBuilder.create().addBox(-4.5F, -5.0F, -5.5F, 9.0F, 5.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 4.0F, 0.05235987755982988F, 0.136659280431156F, 0.0F));
		PartDefinition partdef86 = partdef85.addOrReplaceChild("EquipLC3Radar02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(-6.4F, -4.0F, -1.0F));
		PartDefinition partdef87 = partdef85.addOrReplaceChild("EquipLC3Radar01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F), PartPose.offset(4.4F, -4.0F, -1.0F));
		PartDefinition partdef88 = partdef85.addOrReplaceChild("EquipLC303a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(2.6F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef89 = partdef88.addOrReplaceChild("EquipLC303b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition partdef90 = partdef85.addOrReplaceChild("EquipLC302a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -3.0F, -6.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef91 = partdef90.addOrReplaceChild("EquipLC302b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition partdef92 = partdef85.addOrReplaceChild("EquipLC301a", CubeListBuilder.create().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-2.6F, -3.0F, -6.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef93 = partdef92.addOrReplaceChild("EquipLC301b", CubeListBuilder.create().addBox(-0.5F, -0.5F, -9.0F, 1.0F, 1.0F, 9.0F), PartPose.offset(0.0F, 0.0F, -2.0F));
		PartDefinition partdef94 = partdef73.addOrReplaceChild("EquipL05", CubeListBuilder.create().addBox(-5.0F, 0.0F, -10.0F, 5.0F, 13.0F, 10.0F), PartPose.offsetAndRotation(6.0F, -2.5F, -13.0F, 0.0F, 0.7853981633974483F, 0.0F));
		PartDefinition partdef95 = partdef12.addOrReplaceChild("EquipBaseM02", CubeListBuilder.create().addBox(-9.0F, 0.0F, 0.0F, 18.0F, 10.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -1.3F, 7.7F, -0.5918411493512771F, 0.0F, 0.0F));
		PartDefinition partdef96 = partdef95.addOrReplaceChild("EquipBaseM03", CubeListBuilder.create().addBox(-3.5F, -15.0F, 0.0F, 7.0F, 15.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 6.0F, -2.5F, -0.6981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef97 = partdef9.addOrReplaceChild("EquipBaseBelt2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -4.0F, 14.0F, 6.0F, 8.0F), PartPose.offset(0.0F, -8.7F, 2.5F));
		PartDefinition partdef98 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 14.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.7F, -0.7F, 0.2617993877991494F, 0.0F, 0.20943951023931953F));
		PartDefinition partdef99 = partdef98.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0.0F, 0.0F, -5.0F, 5.0F, 14.0F, 5.0F), PartPose.offsetAndRotation(-3.0F, 13.0F, 2.5F, -1.48352986419518F, 0.0F, 0.0F));
		PartDefinition partdef100 = partdef99.addOrReplaceChild("EquipU01", CubeListBuilder.create().addBox(0.0F, -4.0F, 0.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(1.5F, 13.0F, -5F, -1.7453F, 2.4086F, -1.9199F));
		PartDefinition partdef101 = partdef100.addOrReplaceChild("EquipU01a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition partdef102 = partdef100.addOrReplaceChild("EquipU02", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(0.5F, -15.0F, 0.5F));
		PartDefinition partdef103 = partdef102.addOrReplaceChild("EquipU09a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 10.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-5.0F, -23.0F, 6.0F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef104 = partdef102.addOrReplaceChild("EquipU06", CubeListBuilder.create().addBox(-8.0F, 0.0F, -8.0F, 16.0F, 1.0F, 16.0F), PartPose.offsetAndRotation(0.0F, -31.1F, 5.5F, -0.13788101090755206F, 0.7853981633974483F, -0.09599310885968812F));
		PartDefinition partdef105 = partdef104.addOrReplaceChild("EquipU07", CubeListBuilder.create().addBox(0.0F, -1.0F, 0.0F, 9.0F, 1.0F, 9.0F), PartPose.offset(-4.5F, 0.0F, -4.5F));
		PartDefinition partdef106 = partdef105.addOrReplaceChild("EquipU08", CubeListBuilder.create().addBox(0.0F, -2.0F, 0.0F, 4.0F, 1.0F, 4.0F), PartPose.offset(2.5F, 0.0F, 2.5F));
		PartDefinition partdef107 = partdef102.addOrReplaceChild("EquipU09b", CubeListBuilder.create().addBox(-0.4F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F), PartPose.offsetAndRotation(0.0F, -24.0F, -3.0F, 0.0F, 0.5061454830783556F, 0.2617993877991494F));
		PartDefinition partdef108 = partdef102.addOrReplaceChild("EquipU04a", CubeListBuilder.create().addBox(-0.5F, -8.0F, -0.5F, 1.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(0.2F, 0.1F, 0.3F, -0.2617993877991494F, 0.0F, 0.20943951023931953F));
		PartDefinition partdef109 = partdef108.addOrReplaceChild("EquipU04b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(-0.5F, -16.0F, -0.5F));
		PartDefinition partdef110 = partdef109.addOrReplaceChild("EquipU04c", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(0.0F, -8.0F, 0.0F));
		PartDefinition partdef111 = partdef110.addOrReplaceChild("EquipU04d", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(0.0F, -8.0F, 0.0F));
		PartDefinition partdef112 = partdef102.addOrReplaceChild("EquipU03a", CubeListBuilder.create().addBox(-0.5F, -8.0F, -0.5F, 1.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.1F, -0.3F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef113 = partdef112.addOrReplaceChild("EquipU03b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(-0.5F, -16.0F, -0.5F));
		PartDefinition partdef114 = partdef113.addOrReplaceChild("EquipU03c", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(0.0F, -8.0F, 0.0F));
		PartDefinition partdef115 = partdef114.addOrReplaceChild("EquipU03d", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(0.0F, -8.0F, 0.0F));
		PartDefinition partdef116 = partdef102.addOrReplaceChild("EquipU05a", CubeListBuilder.create().addBox(-0.5F, -8.0F, -0.5F, 1.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(-0.2F, 0.1F, 0.3F, -0.2617993877991494F, 0.0F, -0.20943951023931953F));
		PartDefinition partdef117 = partdef116.addOrReplaceChild("EquipU05b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(-0.5F, -16.0F, -0.5F));
		PartDefinition partdef118 = partdef117.addOrReplaceChild("EquipU05c", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(0.0F, -8.0F, 0.0F));
		PartDefinition partdef119 = partdef118.addOrReplaceChild("EquipU05d", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(0.0F, -8.0F, 0.0F));
		PartDefinition partdef120 = partdef102.addOrReplaceChild("EquipU09c", CubeListBuilder.create().addBox(-0.6F, 0.0F, 0.0F, 1.0F, 1.0F, 11.0F), PartPose.offsetAndRotation(0.0F, -24.0F, -3.0F, 0.0F, -0.5061454830783556F, -0.2617993877991494F));
		PartDefinition partdef121 = partdef100.addOrReplaceChild("EquipU01b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offset(0.0F, 3.0F, 0.0F));
		PartDefinition partdef122 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-4.5F, -2.0F, -5.0F, 9.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -10.7F, -0.2F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef123 = partdef122.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef124 = partdef123.addOrReplaceChild("EquipHeadBase", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 4.0F, 9.0F), PartPose.offset(0.0F, -9.5F, 0.0F));
		PartDefinition partdef125 = partdef124.addOrReplaceChild("HeadEquip02a", CubeListBuilder.create().addBox(-2.0F, 0.0F, -2.0F, 2.0F, 3.0F, 4.0F), PartPose.offset(-8.0F, 0.2F, 5.0F));
		PartDefinition partdef126 = partdef125.addOrReplaceChild("HeadEquip02d", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 2.0F), PartPose.offset(-3.5F, 0.2F, -1.0F));
		PartDefinition partdef127 = partdef125.addOrReplaceChild("HeadEquip02b", CubeListBuilder.create().addBox(-4.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F), PartPose.offset(-2.0F, 1.5F, 0.5F));
		PartDefinition partdef128 = partdef127.addOrReplaceChild("HeadEquip02b2", CubeListBuilder.create().addBox(-1.5F, -1.5F, 0.0F, 3.0F, 2.0F, 3.0F), PartPose.offset(-4.0F, 0.0F, -2.0F));
		PartDefinition partdef129 = partdef125.addOrReplaceChild("HeadEquip02c", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 7.0F, 4.0F, 0.0F), PartPose.offset(-7.0F, -3.5F, 0.5F));
		PartDefinition partdef130 = partdef124.addOrReplaceChild("HeadEquip01a", CubeListBuilder.create().addBox(0.0F, 0.0F, -2.0F, 2.0F, 3.0F, 4.0F), PartPose.offset(8.0F, 0.2F, 5.0F));
		PartDefinition partdef131 = partdef130.addOrReplaceChild("HeadEquip01d", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 2.0F), PartPose.offset(3.5F, 0.2F, -1.0F));
		PartDefinition partdef132 = partdef130.addOrReplaceChild("HeadEquip01c", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 7.0F, 4.0F, 0.0F), PartPose.offset(0.0F, -3.5F, 0.5F));
		PartDefinition partdef133 = partdef130.addOrReplaceChild("HeadEquip01b", CubeListBuilder.create().mirror().addBox(0.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F), PartPose.offset(2.0F, 1.5F, 0.5F));
		PartDefinition partdef134 = partdef133.addOrReplaceChild("HeadEquip01b2", CubeListBuilder.create().addBox(-1.5F, -1.5F, 0.0F, 3.0F, 2.0F, 3.0F), PartPose.offset(4.0F, 0.0F, -2.0F));
		PartDefinition partdef135 = partdef123.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 12.0F, 8.0F), PartPose.offset(0.0F, -7.2F, 0.0F));
		PartDefinition partdef136 = partdef135.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-7.0F, 1.0F, -3.0F, -0.40142572795869574F, 0.17453292519943295F, -0.08726646259971647F));
		PartDefinition partdef137 = partdef136.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F), PartPose.offsetAndRotation(0.2F, 8.0F, 0.3F, 0.296705972839036F, 0.0F, 0.3141592653589793F));
		PartDefinition partdef138 = partdef137.addOrReplaceChild("HairR03", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F), PartPose.offsetAndRotation(0.1F, 9.0F, 0.1F, 0.13962634015954636F, 0.0F, -0.22689280275926282F));
		PartDefinition partdef139 = partdef135.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 6.0F), PartPose.offset(0.0F, -8.8F, -5.7F));
		PartDefinition partdef140 = partdef135.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(7.0F, 1.0F, -3.0F, -0.3665191429188092F, -0.17453292519943295F, 0.08726646259971647F));
		PartDefinition partdef141 = partdef140.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F), PartPose.offsetAndRotation(-0.2F, 8.0F, 0.3F, 0.22689280275926282F, 0.0F, -0.3141592653589793F));
		PartDefinition partdef142 = partdef141.addOrReplaceChild("HairL03", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 10.0F, 2.0F), PartPose.offsetAndRotation(-0.1F, 9.0F, 0.1F, 0.17453292519943295F, 0.0F, 0.22689280275926282F));
		PartDefinition partdef143 = partdef135.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -4.0F, -11.5F, 0.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -9.0F, -5.5F, 0.17453292519943295F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef144 = partdef123.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef145 = partdef144.addOrReplaceChild("HairBase", CubeListBuilder.create().addBox(-5.0F, 0.0F, -0.7F, 10.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -0.5F, 5.5F, 0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef146 = partdef145.addOrReplaceChild("Hair00", CubeListBuilder.create().addBox(-3.5F, 0.0F, -4.0F, 7.0F, 7.0F, 6.0F), PartPose.offset(0.0F, 0.2F, 2.5F));
		PartDefinition partdef147 = partdef146.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-4.0F, -1.0F, -0.2F, 8.0F, 20.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.7F, 1.3F, -0.7285004297824331F, 0.0F, -0.36425021489121656F));
		PartDefinition partdef148 = partdef147.addOrReplaceChild("Hair02", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 18.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 16.5F, 5.0F, -0.3490658503988659F, 0.0F, -0.27314402793711257F));
		PartDefinition partdef149 = partdef148.addOrReplaceChild("Hair03", CubeListBuilder.create().addBox(-3.5F, 0.0F, -4.0F, 7.0F, 16.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 15.0F, 1F, 0.2617993877991494F, 0.0F, 0.36425021489121656F));
		PartDefinition partdef150 = partdef149.addOrReplaceChild("Hair04", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.2F, 6.0F, 15.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, -0.3490658503988659F, 0.0F, 0.27314402793711257F));
		PartDefinition partdef151 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 1.3F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef152 = partdef151.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.8F, 5.5F, -2.6F, -0.2792526803190927F, 0.0F, 0.13962634015954636F));
		PartDefinition partdef153 = partdef152.addOrReplaceChild("EquipLegL01", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 2.0F, 7.0F), PartPose.offset(0.0F, 9.0F, 0.0F));
		PartDefinition partdef154 = partdef153.addOrReplaceChild("EquipLegL02c", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(3.2F, -0.7F, -2.5F, 0.0F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef155 = partdef153.addOrReplaceChild("EquipLegL02a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(3.4F, -0.9F, -0.9F, 0.0F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef156 = partdef153.addOrReplaceChild("EquipLegL02b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(3.2F, -0.7F, 0.7F, 0.0F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef157 = partdef152.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(0.0F, 14.0F, -3.0F));
		PartDefinition partdef158 = partdef157.addOrReplaceChild("ShoesL01", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -0.5F, 7.0F, 2.0F, 7.0F), PartPose.offset(0.0F, 7.0F, 0.0F));
		PartDefinition partdef159 = partdef151.addOrReplaceChild("Skirt01", CubeListBuilder.create().addBox(-8.5F, 0.0F, -6.0F, 17.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 2.3F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef160 = partdef159.addOrReplaceChild("Skirt02", CubeListBuilder.create().addBox(-9.0F, 0.0F, -6.0F, 18.0F, 4.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 2.9F, -0.4F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef161 = partdef151.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.8F, 5.5F, -2.6F, -0.13962634015954636F, 0.0F, -0.13962634015954636F));
		PartDefinition partdef162 = partdef161.addOrReplaceChild("EquipLegR01", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 2.0F, 7.0F), PartPose.offset(0.0F, 9.0F, 0.0F));
		PartDefinition partdef163 = partdef162.addOrReplaceChild("EquipLegR02a", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-3.2F, -0.7F, -2.5F, 0.0F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef164 = partdef162.addOrReplaceChild("EquipLegR02c", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-3.2F, -0.7F, 0.7F, 0.0F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef165 = partdef162.addOrReplaceChild("EquipLegR02b", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-3.4F, -0.8F, -0.9F, 0.0F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef166 = partdef161.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(0.0F, 14.0F, -3.0F));
		PartDefinition partdef167 = partdef166.addOrReplaceChild("ShoesR01", CubeListBuilder.create().addBox(-3.5F, 0.0F, -0.5F, 7.0F, 2.0F, 7.0F), PartPose.offset(0.0F, 7.0F, 0.0F));
		PartDefinition partdef168 = partdef151.addOrReplaceChild("AnchorL", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -3.0F, 1.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(7.7F, 2.0F, -2.0F, 0.0F, 0.0F, -0.3490658503988659F));
		PartDefinition partdef169 = partdef151.addOrReplaceChild("AnchorR", CubeListBuilder.create().addBox(-1.0F, 0.0F, -3.0F, 1.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(-7.7F, 2.0F, -2.0F, 0.0F, 0.0F, 0.3490658503988659F));
		PartDefinition partdef170 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, -15.0F, 0.0F));
		PartDefinition partdef171 = partdef170.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offset(0.0F, -10.7F, -0.2F));
		PartDefinition partdef172 = partdef171.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));
		PartDefinition partdef173 = partdef172.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef174 = partdef172.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef175 = partdef172.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef176 = partdef172.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef177 = partdef172.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef178 = partdef172.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef179 = partdef172.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef180 = partdef172.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef181 = partdef172.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef182 = partdef172.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelBattleshipYamato(ModelPart root)
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
		this.EquipLC2Base01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC2Base01");
		this.EquipLC02a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02").getChild("EquipLC02a");
		this.EquipRC3Base01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC3Base01");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.Cloth02a = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth02a");
		this.EquipRC2Radar02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC2Base01").getChild("EquipRC2Base02").getChild("EquipRC2Radar02");
		this.EquipRCRadar02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02").getChild("EquipRCRadar02");
		this.Skirt01 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01");
		this.EquipLegR01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("EquipLegR01");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.EquipRotateBase = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.HeadEquip01d = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("HeadEquip01a").getChild("HeadEquip01d");
		this.EquipLC3Radar02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC3Base01").getChild("EquipLC3Base02").getChild("EquipLC3Radar02");
		this.EquipRC302a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC3Base01").getChild("EquipRC3Base02").getChild("EquipRC302a");
		this.EquipLC302b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC3Base01").getChild("EquipLC3Base02").getChild("EquipLC302a").getChild("EquipLC302b");
		this.EquipRC3Radar02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC3Base01").getChild("EquipRC3Base02").getChild("EquipRC3Radar02");
		this.EquipU03d = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU03a").getChild("EquipU03b").getChild("EquipU03c").getChild("EquipU03d");
		this.EquipRCBase02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02");
		this.EquipRC2Radar01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC2Base01").getChild("EquipRC2Base02").getChild("EquipRC2Radar01");
		this.EquipLCRadar02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02").getChild("EquipLCRadar02");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.EquipU01a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU01a");
		this.EquipLCBase01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01");
		this.EquipLCRadar01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02").getChild("EquipLCRadar01");
		this.EquipR01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01");
		this.EquipLC3Base02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC3Base01").getChild("EquipLC3Base02");
		this.EquipU09a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU09a");
		this.EquipLegR02a = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("EquipLegR01").getChild("EquipLegR02a");
		this.EquipRC01b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02").getChild("EquipRC01a").getChild("EquipRC01b");
		this.EquipRC03b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02").getChild("EquipRC03a").getChild("EquipRC03b");
		this.EquipLegL01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("EquipLegL01");
		this.EquipRC3Base02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC3Base01").getChild("EquipRC3Base02");
		this.EquipU02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02");
		this.EquipBaseBelt2 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipBaseBelt2");
		this.EquipBaseM01a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01a");
		this.EquipRC303b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC3Base01").getChild("EquipRC3Base02").getChild("EquipRC303a").getChild("EquipRC303b");
		this.HairL03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02").getChild("HairL03");
		this.EquipMCBase01b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipMCBase01b");
		this.EquipLegL02c = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("EquipLegL01").getChild("EquipLegL02c");
		this.EquipU04b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU04a").getChild("EquipU04b");
		this.HeadEquip02d = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("HeadEquip02a").getChild("HeadEquip02d");
		this.ShoesR01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02").getChild("ShoesR01");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("HairBase").getChild("Hair00").getChild("Hair01");
		this.EquipLC3Radar01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC3Base01").getChild("EquipLC3Base02").getChild("EquipLC3Radar01");
		this.EquipU06 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU06");
		this.EquipRC201b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC2Base01").getChild("EquipRC2Base02").getChild("EquipRC201a").getChild("EquipRC201b");
		this.EquipU05b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU05a").getChild("EquipU05b");
		this.EquipRC203a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC2Base01").getChild("EquipRC2Base02").getChild("EquipRC203a");
		this.EquipLCBase01_1 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipMCBase01a").getChild("EquipLCBase01_1");
		this.EquipLC3Base01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC3Base01");
		this.EquipLC303a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC3Base01").getChild("EquipLC3Base02").getChild("EquipLC303a");
		this.EquipU09b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU09b");
		this.EquipLC203a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC2Base01").getChild("EquipLC2Base02").getChild("EquipLC203a");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.HeadEquip02a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("HeadEquip02a");
		this.HeadEquip01c = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("HeadEquip01a").getChild("HeadEquip01c");
		this.EquipL05 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipL05");
		this.EquipLC2Radar02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC2Base01").getChild("EquipLC2Base02").getChild("EquipLC2Radar02");
		this.EquipMCRadar02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipMCBase01a").getChild("EquipLCBase01_1").getChild("EquipLCBase02_1").getChild("EquipMCRadar02");
		this.EquipLC2Radar01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC2Base01").getChild("EquipLC2Base02").getChild("EquipLC2Radar01");
		this.EquipLC02b_1 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipMCBase01a").getChild("EquipLCBase01_1").getChild("EquipLCBase02_1").getChild("EquipLC02a_1").getChild("EquipLC02b_1");
		this.HairR02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.EquipU04a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU04a");
		this.EquipLegL02a = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("EquipLegL01").getChild("EquipLegL02a");
		this.EquipR03 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03");
		this.EquipU03a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU03a");
		this.BodyMain = root.getChild("BodyMain");
		this.EquipRCRadar01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02").getChild("EquipRCRadar01");
		this.EquipLC02b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02").getChild("EquipLC02a").getChild("EquipLC02b");
		this.Hair04 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("HairBase").getChild("Hair00").getChild("Hair01").getChild("Hair02").getChild("Hair03").getChild("Hair04");
		this.EquipLegR02c = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("EquipLegR01").getChild("EquipLegR02c");
		this.EquipLCBase02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02");
		this.EquipL02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02");
		this.EquipLC201b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC2Base01").getChild("EquipLC2Base02").getChild("EquipLC201a").getChild("EquipLC201b");
		this.EquipRC202a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC2Base01").getChild("EquipRC2Base02").getChild("EquipRC202a");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.EquipRC202b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC2Base01").getChild("EquipRC2Base02").getChild("EquipRC202a").getChild("EquipRC202b");
		this.EquipU04d = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU04a").getChild("EquipU04b").getChild("EquipU04c").getChild("EquipU04d");
		this.EquipRC203b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC2Base01").getChild("EquipRC2Base02").getChild("EquipRC203a").getChild("EquipRC203b");
		this.HeadEquip01a = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("HeadEquip01a");
		this.Skirt02 = root.getChild("BodyMain").getChild("Butt").getChild("Skirt01").getChild("Skirt02");
		this.EquipU07 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU06").getChild("EquipU07");
		this.EquipLC01b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02").getChild("EquipLC01a").getChild("EquipLC01b");
		this.EquipRC02a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02").getChild("EquipRC02a");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.EquipRC03a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02").getChild("EquipRC03a");
		this.EquipU05a = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU05a");
		this.EquipBaseM01b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.EquipLC2Base02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC2Base01").getChild("EquipLC2Base02");
		this.EquipLC03b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02").getChild("EquipLC03a").getChild("EquipLC03b");
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.EquipBaseBelt = root.getChild("BodyMain").getChild("EquipBaseBelt");
		this.EquipU05c = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU05a").getChild("EquipU05b").getChild("EquipU05c");
		this.EquipLC02a_1 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipMCBase01a").getChild("EquipLCBase01_1").getChild("EquipLCBase02_1").getChild("EquipLC02a_1");
		this.HeadEquip02b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("HeadEquip02a").getChild("HeadEquip02b");
		this.EquipR02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02");
		this.EquipRCBase01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01");
		this.EquipR04 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04");
		this.EquipRC2Base01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC2Base01");
		this.EquipU05d = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU05a").getChild("EquipU05b").getChild("EquipU05c").getChild("EquipU05d");
		this.EquipLC03a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02").getChild("EquipLC03a");
		this.Hair03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("HairBase").getChild("Hair00").getChild("Hair01").getChild("Hair02").getChild("Hair03");
		this.HeadEquip02b2 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("HeadEquip02a").getChild("HeadEquip02b").getChild("HeadEquip02b2");
		this.EquipU01 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01");
		this.EquipLC302a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC3Base01").getChild("EquipLC3Base02").getChild("EquipLC302a");
		this.EquipLegR02b = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("EquipLegR01").getChild("EquipLegR02b");
		this.EquipHeadBase = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.EquipRC303a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC3Base01").getChild("EquipRC3Base02").getChild("EquipRC303a");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.ShoesL01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02").getChild("ShoesL01");
		this.HairBase = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("HairBase");
		this.EquipLC203b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC2Base01").getChild("EquipLC2Base02").getChild("EquipLC203a").getChild("EquipLC203b");
		this.EquipU09c = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU09c");
		this.EquipRC02b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02").getChild("EquipRC02a").getChild("EquipRC02b");
		this.AnchorL = root.getChild("BodyMain").getChild("Butt").getChild("AnchorL");
		this.EquipRC3Radar01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC3Base01").getChild("EquipRC3Base02").getChild("EquipRC3Radar01");
		this.EquipU03b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU03a").getChild("EquipU03b");
		this.EquipL04 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04");
		this.HeadEquip01b2 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("HeadEquip01a").getChild("HeadEquip01b").getChild("HeadEquip01b2");
		this.EquipU04c = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU04a").getChild("EquipU04b").getChild("EquipU04c");
		this.AnchorR = root.getChild("BodyMain").getChild("Butt").getChild("AnchorR");
		this.EquipLegL02b = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("EquipLegL01").getChild("EquipLegL02b");
		this.ArmLeft01a = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft01a");
		this.Hair00 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("HairBase").getChild("Hair00");
		this.EquipRC302b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC3Base01").getChild("EquipRC3Base02").getChild("EquipRC302a").getChild("EquipRC302b");
		this.HeadEquip01b = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("HeadEquip01a").getChild("HeadEquip01b");
		this.EquipLC01a_1 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipMCBase01a").getChild("EquipLCBase01_1").getChild("EquipLCBase02_1").getChild("EquipLC01a_1");
		this.EquipLC301b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC3Base01").getChild("EquipLC3Base02").getChild("EquipLC301a").getChild("EquipLC301b");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.EquipLC201a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC2Base01").getChild("EquipLC2Base02").getChild("EquipLC201a");
		this.EquipLC03b_1 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipMCBase01a").getChild("EquipLCBase01_1").getChild("EquipLCBase02_1").getChild("EquipLC03a_1").getChild("EquipLC03b_1");
		this.HairL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.EquipL01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.HeadEquip02c = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("EquipHeadBase").getChild("HeadEquip02a").getChild("HeadEquip02c");
		this.EquipRC01a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipRCBase01").getChild("EquipRCBase02").getChild("EquipRC01a");
		this.EquipRC201a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC2Base01").getChild("EquipRC2Base02").getChild("EquipRC201a");
		this.EquipMCBase01a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipMCBase01a");
		this.EquipLC03a_1 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipMCBase01a").getChild("EquipLCBase01_1").getChild("EquipLCBase02_1").getChild("EquipLC03a_1");
		this.EquipLC202b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC2Base01").getChild("EquipLC2Base02").getChild("EquipLC202a").getChild("EquipLC202b");
		this.EquipRC301b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC3Base01").getChild("EquipRC3Base02").getChild("EquipRC301a").getChild("EquipRC301b");
		this.EquipL03 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03");
		this.EquipBaseM03 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipBaseM02").getChild("EquipBaseM03");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.EquipU03c = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU03a").getChild("EquipU03b").getChild("EquipU03c");
		this.HairU01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairU01");
		this.EquipLC01b_1 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipMCBase01a").getChild("EquipLCBase01_1").getChild("EquipLCBase02_1").getChild("EquipLC01a_1").getChild("EquipLC01b_1");
		this.EquipMCRadar01 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipMCBase01a").getChild("EquipLCBase01_1").getChild("EquipLCBase02_1").getChild("EquipMCRadar01");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("HairBase").getChild("Hair00").getChild("Hair01").getChild("Hair02");
		this.EquipLC01a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipLCBase01").getChild("EquipLCBase02").getChild("EquipLC01a");
		this.EquipRC301a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC3Base01").getChild("EquipRC3Base02").getChild("EquipRC301a");
		this.EquipU08 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU02").getChild("EquipU06").getChild("EquipU07").getChild("EquipU08");
		this.EquipLC202a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC2Base01").getChild("EquipLC2Base02").getChild("EquipLC202a");
		this.EquipRC2Base02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipRC2Base01").getChild("EquipRC2Base02");
		this.Cloth02b = root.getChild("BodyMain").getChild("Cloth01").getChild("Cloth02a").getChild("Cloth02b");
		this.EquipLC303b = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC3Base01").getChild("EquipLC3Base02").getChild("EquipLC303a").getChild("EquipLC303b");
		this.EquipU01b = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02").getChild("EquipU01").getChild("EquipU01b");
		this.EquipLCBase02_1 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipMCBase01a").getChild("EquipLCBase01_1").getChild("EquipLCBase02_1");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.EquipLC301a = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipL01").getChild("EquipL02").getChild("EquipL03").getChild("EquipL04").getChild("EquipLC3Base01").getChild("EquipLC3Base02").getChild("EquipLC301a");
		this.EquipBaseM02 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipBaseM02");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.HairR03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02").getChild("HairR03");
		this.EquipR05 = root.getChild("BodyMain").getChild("EquipBaseBelt").getChild("EquipRotateBase").getChild("EquipBaseM01b").getChild("EquipR01").getChild("EquipR02").getChild("EquipR03").getChild("EquipR04").getChild("EquipR05");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.offsetItem = new float[] {0.07F, 1.04F, -0.03F};
		this.offsetBlock = new float[] {0.07F, 1.04F, -0.03F};
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
		
		boolean flag = !EmotionHelper.checkModelState(0, state);
		this.EquipBaseBelt.visible = !(flag);
				
		flag = !EmotionHelper.checkModelState(1, state);
		this.EquipHeadBase.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);
		this.EquipU01.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(3, state);
		this.EquipLegR01.visible = !(flag);
		this.EquipLegL01.visible = !(flag);
	
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

this.animTransX += (0F); this.animTransY += (0.58F + 0.22F * ent.getScaleLevel()); this.animTransZ += (0F);
    	this.setFaceHungry(ent);
    
    	//頭部
	  	this.Head.xRot = -0.2618F;
	  	this.Head.yRot = 0F;
	  	this.Head.zRot = 0F;
	    //胸部
  	    this.BoobL.xRot = -1.0F;
  	    this.BoobR.xRot = -1.0F;
  	    this.Cloth02a.xRot = -1.0F;
	  	//Body
  	    this.Ahoke.yRot = -1.0F;
	  	this.BodyMain.xRot = 1.2217F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 1.2217F;
	  	this.Butt.xRot = -0.05F;
	  	//hair
	  	this.Hair01.xRot = -0.72F;
	  	this.Hair01.zRot = -0.36F;
	  	this.Hair02.xRot = -0.35F;
	  	this.Hair02.zRot = -0.15F;
	  	this.Hair03.xRot = 0.26F;
	  	this.Hair03.zRot = 0.36F;
	  	this.Hair04.xRot = -0.35F;
	  	this.Hair04.zRot = 0.1F;
	  	this.HairL01.zRot = 0.0873F;
	  	this.HairL02.zRot = -0.3142F;
	  	this.HairL03.zRot = 0.18F;
	  	this.HairR01.zRot = -0.0873F;
	  	this.HairR02.zRot = -1.2217F;
	  	this.HairR03.zRot = -0.15F;
		this.HairL01.xRot = - 0.28F;
	  	this.HairL02.xRot = 0.15F;
	  	this.HairL03.xRot = 0.05F;
	  	this.HairR01.xRot = -0.35F;
	  	this.HairR02.xRot = 0.18F;
	  	this.HairR03.xRot = 0.02F;
	    //arm 
	  	this.ArmLeft01.xRot = -0.35F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = -3F;
	    this.ArmLeft02.xRot = 0F;
    	this.ArmRight01.xRot = -0.35F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -0.35F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.zRot = -0.8727F;
		//leg
		this.LegLeft01.xRot = -0.14F;
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.09F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.xRot = -1.2217F;
		this.LegRight01.yRot = -0.5236F;
		this.LegRight01.zRot = 0F;
		this.LegRight02.xRot = 1.0472F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		this.AnchorL.xRot = -0.2F;
		this.AnchorR.xRot = -0.2F;
		this.AnchorR.zRot = 0.35F;
		//equip
		this.EquipU01.visible = false;
		this.EquipBaseBelt.visible = false;
	
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
  		boolean showCannon = EmotionHelper.checkModelState(0, ent.getStateEmotion(ID.S.State));
  		boolean showUmbrella = EmotionHelper.checkModelState(2, ent.getStateEmotion(ID.S.State));
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
    	//leg move
  		addk1 = angleAdd1 * 0.5F - 0.2793F;  //LegLeft01
	  	addk2 = angleAdd2 * 0.5F - 0.1396F;  //LegRight01
	  	
  	    //移動頭部使其看人
	  	this.Head.xRot = f4 * 0.014F - 0.1047F; 	//上下角度
	  	this.Head.yRot = f3 * 0.01F;				//左右角度
	    
	    //正常站立動作
	    //胸部
  	    this.BoobL.xRot = angleX * 0.06F - 0.75F;
  	    this.BoobR.xRot = angleX * 0.06F - 0.75F;
  	    this.Cloth02a.xRot = angleX * 0.06F - 0.7F;
	  	//Body
  	    this.Ahoke.yRot = angleX * 0.25F + 0.45F;
	  	this.BodyMain.xRot = -0.1047F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.3142F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.03F - 0.7F;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -angleX1 * 0.04F - 0.11F;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -angleX2 * 0.07F - 0.05F;
	  	this.Hair03.zRot = 0F;
	  	this.Hair04.xRot = -angleX3 * 0.10F - 0.02F;
	  	this.Hair04.zRot = 0F;
	  	this.HairL01.zRot = 0.0873F;
	  	this.HairL02.zRot = -0.3142F;
	  	this.HairL03.zRot = 0.18F;
	  	this.HairR01.zRot = -0.0873F;
	  	this.HairR02.zRot = 0.25F;
	  	this.HairR03.zRot = -0.15F;
		this.HairL01.xRot = - 0.28F;
	  	this.HairL02.xRot = 0.15F;
	  	this.HairL03.xRot = 0.05F;
	  	this.HairR01.xRot = -0.35F;
	  	this.HairR02.xRot = 0.18F;
	  	this.HairR03.xRot = 0.02F;
	    //arm 
	  	this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.18F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = angleX * 0.03F - 0.26F;
	    this.ArmLeft02.xRot = 0F;
	    //equipU
	    this.EquipU01.yRot = 2.4F;
	    
	    if (showUmbrella)
	    {
	    	this.ArmRight01.xRot = -f1 * 0.4F + 0.1745F;
		    this.ArmRight01.yRot = 0F;
			this.ArmRight01.zRot = 0.1571F;
			this.ArmRight02.xRot = -1.4835F;
			this.ArmRight02.zRot = 0F;
	    }
	    else
	    {
	    	this.ArmRight01.xRot = angleAdd1 * 0.25F + 0.18F;
		    this.ArmRight01.yRot = 0F;
			this.ArmRight01.zRot = -angleX * 0.03F + 0.26F;
			this.ArmRight02.xRot = 0F;
			this.ArmRight02.zRot = 0F;
	    }
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.1396F;
		this.LegLeft02.xRot = 0F;
		this.LegLeft02.zRot = 0F;
		this.LegLeft02.z = (-3.0F) + (0F) * 16F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.1396F;
		this.LegRight02.xRot = 0F;
		this.LegRight02.zRot = 0F;
		this.LegRight02.z = (-3.0F) + (0F) * 16F;
		this.AnchorL.xRot = f1 * 0.5F - 0.2F;
		this.AnchorR.xRot = f1 * 0.5F - 0.2F;
		this.AnchorR.zRot = 0.35F;
		//cannon
		if (showCannon)
		{
			this.EquipRotateBase.xRot = 0F;
			this.EquipLCBase02_1.yRot = 3.1415F;
			
			if (this.Head.xRot <= 0F)
			{
				this.EquipLC01a.xRot = this.Head.xRot * 0.7F;
				this.EquipLC02a.xRot = this.Head.xRot;
				this.EquipLC03a.xRot = this.Head.xRot * 0.8F;
				this.EquipLC201a.xRot = this.Head.xRot * 1.2F;
				this.EquipLC202a.xRot = this.Head.xRot;
				this.EquipLC203a.xRot = this.Head.xRot * 0.9F;
				
				this.EquipRC01a.xRot = this.Head.xRot * 0.9F;
				this.EquipRC02a.xRot = this.Head.xRot;
				this.EquipRC03a.xRot = this.Head.xRot * 0.75F;
				this.EquipRC201a.xRot = this.Head.xRot * 0.85F;
				this.EquipRC202a.xRot = this.Head.xRot * 1.1F;
				this.EquipRC203a.xRot = this.Head.xRot;
			}
			
			this.EquipLCBase02.yRot = this.Head.yRot * 1.3F;
			this.EquipLC2Base02.yRot = this.Head.yRot * 1.45F;
			this.EquipLC3Base02.yRot = -this.Head.xRot;
			
			this.EquipRCBase02.yRot = this.Head.yRot * 1.3F;
			this.EquipRC2Base02.yRot = this.Head.yRot * 1.45F;
			this.EquipRC3Base02.yRot = this.Head.xRot;
			
			//hair in equip mode
			this.Hair01.xRot = -0.7F;
		  	this.Hair01.zRot = -0.35F;
		  	this.Hair02.xRot = -0.35F;
		  	this.Hair02.zRot = -0.3142F;
		  	this.Hair03.xRot = 0.2618F;
		  	this.Hair03.zRot = 0.4363F;
		  	this.Hair04.xRot = -0.3491F;
		  	this.Hair04.zRot = 0.2618F;
		}


	    if (ent.getIsSprinting() || f1 > 0.1F)
	    {	//奔跑動作
	    	//hair
	    	this.Hair01.xRot += f1 * 0.25F;
		    //arm 
		    this.ArmLeft01.zRot += f1 * -0.25F;
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {	//潛行, 蹲下動作
this.animTransX += (0F); this.animTransY += (0.07F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 1.0472F;
		  	this.BodyMain.xRot = 1.0472F;
		  	this.Butt.xRot = -0.8378F;
		    //arm 
		    this.ArmLeft01.xRot = -0.7F;
		    this.ArmLeft01.zRot = 0.2618F;
			if (showUmbrella)
			{
				this.ArmRight01.xRot -= 1.0472F;
		    }
		    else
		    {
		    	this.ArmRight01.xRot = -0.7F;
			    this.ArmRight01.yRot = 0F;
				this.ArmRight01.zRot = -0.2618F;
				this.ArmRight02.xRot = 0F;
		    }
			//hair
			this.Hair01.xRot = -1.2109F;
			this.Hair01.zRot = -0.4363F;
			this.Hair02.xRot = -0.5236F;
			this.Hair02.zRot = -0.3491F;
			this.Hair03.xRot = 0F;
			this.Hair03.zRot = 0.4363F;
			this.Hair04.xRot = -0.3491F;
			this.Hair04.zRot = 0.2618F;
			//cannon
			if (showCannon)
			{
				this.EquipRotateBase.xRot -= 1.0472F;
			}
  		}//end if sneaking
  		
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {
	    	//騎乘動作
	    	if (showCannon)
	    	{
this.animTransX += (0F); this.animTransY += (0.4F); this.animTransZ += (0F);
		    	//Body
			  	this.Head.xRot -= 0.2F;
		    	this.BodyMain.xRot = -0.1396F;
			  	this.Butt.xRot = 0.1396F;
				//arm 
			  	this.ArmLeft01.xRot = -0.2094F;
			  	this.ArmLeft01.zRot = 0.2618F;
			  	if (showUmbrella)
			  	{
			    	this.ArmRight01.xRot = 0.1745F;
				    this.ArmRight01.yRot = 0F;
					this.ArmRight01.zRot = 0.1571F;
					this.ArmRight02.xRot = -1.4835F;
			    }
			    else
			    {
			    	this.ArmRight01.xRot = -0.2094F;
				    this.ArmRight01.yRot = 0F;
					this.ArmRight01.zRot = -0.2618F;
					this.ArmRight02.xRot = 0F;
			    }
			  	//leg
			  	addk1 = -1.0472F;
			  	addk2 = -1.0472F;
			  	this.LegLeft01.yRot = 0.0524F;
				this.LegLeft01.zRot = 0F;
				this.LegLeft02.z = (-3.0F) + (0.38F) * 16F;
				this.LegLeft02.xRot = 2.5831F;
				this.LegLeft02.zRot = 0.0175F;
				this.LegRight01.yRot = -0.0524F;
				this.LegRight01.zRot = 0F;
				this.LegRight02.z = (-3.0F) + (0.38F) * 16F;
				this.LegRight02.xRot = 2.5831F;
				this.LegRight02.zRot = -0.0175F;
				this.EquipLCBase02_1.yRot = 0F;
			}
	    	else if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
this.animTransX += (0F); this.animTransY += (0.5F); this.animTransZ += (0F);
		    	//Body
			  	this.Head.xRot -= 0.21F;
			  	this.Head.yRot -= 0.4363F;
		    	this.BodyMain.xRot = 0.2618F;
		    	this.BodyMain.yRot = 0.35F;
		    	this.BodyMain.zRot = 0.4363F;
		    	//hair
				this.Hair01.xRot = -0.95F;
				this.Hair01.zRot = -0.2618F;
				this.Hair02.xRot = -0.3491F;
				this.Hair02.zRot = -0.3491F;
				this.Hair03.xRot = -0.3491F;
				this.Hair03.zRot = -0.3491F;
				this.Hair04.xRot = -0.4363F;
				this.Hair04.zRot = -0.4363F;
				//arm 
			  	this.ArmLeft01.xRot = -0.35F;
			  	this.ArmLeft01.yRot = -0.5236F;
			  	this.ArmLeft01.zRot = -0.2618F;
			  	this.ArmLeft02.xRot = -0.5236F;
			  	if (showUmbrella)
			  	{
			    	this.ArmRight01.xRot = 0F;
				    this.ArmRight01.yRot = 0F;
					this.ArmRight01.zRot = -0.0524F;
					this.ArmRight02.xRot = -1.0472F;
			    }
			    else
			    {
			    	this.ArmRight01.xRot = 0.0873F;
				    this.ArmRight01.yRot = 0F;
					this.ArmRight01.zRot = 0.0873F;
					this.ArmRight02.xRot = -0.5236F;
			    }
			  	//leg
			  	addk1 = -0.0873F;
			  	addk2 = -0.4363F;
			  	this.LegLeft01.yRot = 0F;
				this.LegLeft01.zRot = 1.0472F;
				this.LegLeft02.xRot = 0.4363F;
				this.LegRight01.yRot = 0F;
				this.LegRight01.zRot = 0.9250F;
				this.LegRight02.xRot = 0.5236F;
				//equipU
			    this.EquipU01.yRot = 2.15F;
			    this.EquipU01.zRot = -1.85F;
			    this.AnchorR.zRot = 0.7F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.54F); this.animTransZ += (0F);
		    	//Body
			  	this.Head.xRot += 0.1047F;
		    	this.BodyMain.xRot = -0.1396F;
			  	this.Butt.xRot = 0.1396F;
			  	//hair
				this.Hair01.xRot = -0.6108F;
				this.Hair01.zRot = -0.2618F;
				this.Hair02.xRot = -0.4363F;
				this.Hair02.zRot = 0.4363F;
				this.Hair03.xRot = -0.3491F;
				this.Hair03.zRot = 0.4363F;
				this.Hair04.xRot = -0.5236F;
				this.Hair04.zRot = 0.5236F;
				//arm 
			  	this.ArmLeft01.xRot = -0.2094F;
			  	this.ArmLeft01.zRot = 0.2618F;
			  	if (showUmbrella)
			  	{
			    	this.ArmRight01.xRot = 0.1745F;
				    this.ArmRight01.yRot = 0F;
					this.ArmRight01.zRot = 0.1571F;
					this.ArmRight02.xRot = -1.4835F;
			    }
			    else
			    {
			    	this.ArmRight01.xRot = -0.2094F;
				    this.ArmRight01.yRot = 0F;
					this.ArmRight01.zRot = -0.2618F;
					this.ArmRight02.xRot = 0F;
			    }
			  	//leg
			  	addk1 = -1.4835F;
			  	addk2 = -1.4835F;
			  	this.LegLeft01.yRot = 0.0524F;
				this.LegLeft01.zRot = -1.4835F;
				this.LegLeft02.z = (-3.0F) + (0.38F) * 16F;
				this.LegLeft02.xRot = 2.1F;
				this.LegLeft02.zRot = 0.0175F;
				this.LegRight01.yRot = -0.0524F;
				this.LegRight01.zRot = 1.4835F;
				this.LegRight02.z = (-3.0F) + (0.38F) * 16F;
				this.LegRight02.xRot = 1.9199F;
				this.LegRight02.zRot = -0.0175F;
	    	}
  		}//end if sitting
	    
	    //攻擊動作    
	    if (ent.getAttackTick() > 0)
	    {
	    	this.ArmLeft01.xRot = -1.5708F;
		    this.ArmLeft01.yRot = -0.2F + this.Head.yRot;
		  	this.ArmLeft01.zRot = 0F;
	    }
	    
	    //swing arm
	  	float f6 = ent.getSwingTime(f2 - (int)f2);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight01.xRot = -0.2F;
	        this.ArmRight01.yRot = 0F;
	        this.ArmRight01.zRot = -0.1F;
	        this.ArmRight01.xRot += -f8 * 80.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.yRot += -f7 * 20.0F * Values.N.DIV_PI_180 + 0.2F;
	        this.ArmRight01.zRot += -f8 * 20.0F * Values.N.DIV_PI_180;
	        this.ArmRight02.xRot = 0F;
	        this.ArmRight02.yRot = 0F;
	        this.ArmRight02.zRot = 0F;
	  	}
	    
	    //鬢毛調整
	    float headZ = this.Head.zRot * -0.5F;
	    float headX = this.Head.xRot * -0.5F - 0.05F;
	    this.Hair01.xRot += headX;
	  	this.Hair02.xRot += headX * 0.5F;
	  	this.Hair03.xRot += headX * 0.2F;
	  	this.Hair04.xRot += headX * 0.2F;
	    this.Hair01.zRot += angleAdd1 * 0.04F + headZ * 1.0F;
	  	this.Hair02.zRot += angleAdd2 * 0.06F + headZ * 0.8F;
	  	this.Hair03.zRot += angleAdd2 * 0.08F + headZ * 0.4F;
	  	this.Hair04.zRot += angleAdd2 * 0.10F + headZ * 0.4F;
	  	this.HairL01.zRot += headZ;
	  	this.HairL02.zRot += headZ * 0.8F;
	  	this.HairL03.zRot += headZ * 0.4F;
	  	this.HairR01.zRot += headZ;
	  	this.HairR02.zRot += headZ * 0.8F;
	  	this.HairR03.zRot += headZ * 0.4F;
		this.HairL01.xRot += angleX * 0.04F + headX;
	  	this.HairL02.xRot += angleX1 * 0.05F + headX * 0.8F;
	  	this.HairL03.xRot += angleX2 * 0.07F + headX * 0.4F;
	  	this.HairR01.xRot += angleX * 0.04F + headX;
	  	this.HairR02.xRot += angleX1 * 0.05F + headX * 0.8F;
	  	this.HairR03.xRot += angleX2 * 0.07F + headX * 0.4F;
	    
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
    	
    	switch (((IShipEmotion)entity).getScaleLevel())
    	{
    	case 3:
    		scale = 2F;
        	offsetY = -0.73F;
		break;
    	case 2:
    		scale = 1.5F;
        	offsetY = -0.48F;
		break;
    	case 1:
    		scale = 1F;
        	offsetY = 0.02F;
		break;
    	default:
    		scale = 0.5F;
        	offsetY = 1.53F;
		break;
    	}
    	
    	
    	RenderHelper.animScale(this, scale, scale, scale);
this.animTransX += (0F); this.animTransY += (offsetY); this.animTransZ += (0F);
    	
    	//main body
		super.setupAnim(entity, f, f1, f2, f3, f4);
	}

}

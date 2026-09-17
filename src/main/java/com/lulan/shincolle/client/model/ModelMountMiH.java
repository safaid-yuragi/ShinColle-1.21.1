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

public class ModelMountMiH<T extends Entity> extends ShipModel<T>
{

	public ModelPart BodyMain;
	public ModelPart UpperMain;
	public ModelPart LowerMain;
	public ModelPart LegArmorBase;
	public ModelPart Back;
	public ModelPart Head;
	public ModelPart Back_1;
	public ModelPart EquipHeadBack1;
	public ModelPart EquipHeadBack1b;
	public ModelPart EquipHead01;
	public ModelPart EquipHead01c;
	public ModelPart EquipHeadBack2;
	public ModelPart EquipHead03;
	public ModelPart EquipHeadBack3;
	public ModelPart EquipHeadBack3b;
	public ModelPart EquipHeadBack2b;
	public ModelPart EquipHead03_1;
	public ModelPart EquipHead03_2;
	public ModelPart EquipHead03_3;
	public ModelPart EquipHeadBack3c;
	public ModelPart EquipHeadBack3d;
	public ModelPart EquipHeadBack3e;
	public ModelPart EquipHeadBack3f;
	public ModelPart EquipHeadBack3g;
	public ModelPart EquipHeadBack3h;
	public ModelPart EquipHead03a;
	public ModelPart EquipHead01_1;
	public ModelPart EquipHead02;
	public ModelPart EquipHead00;
	public ModelPart EquipHead01a;
	public ModelPart EquipHead02a;
	public ModelPart EquipHead00a;
	public ModelPart EquipHead03a_1;
	public ModelPart EquipHead03a_2;
	public ModelPart EquipHead03a_3;
	public ModelPart EquipHead01a_1;
	public ModelPart EquipHead01b;
	public ModelPart EquipHead01d;
	public ModelPart Back_2;
	public ModelPart TopCannonBase;
	public ModelPart TopCannonBase_1;
	public ModelPart TongueBase1;
	public ModelPart Head_1;
	public ModelPart Back_3;
	public ModelPart EquipHeadBack1_1;
	public ModelPart EquipHeadBack1b_1;
	public ModelPart EquipHead01_2;
	public ModelPart EquipHead01c_1;
	public ModelPart EquipHeadBack2_1;
	public ModelPart EquipHead03_4;
	public ModelPart EquipHeadBack3_1;
	public ModelPart EquipHeadBack3b_1;
	public ModelPart EquipHeadBack2b_1;
	public ModelPart EquipHead03_5;
	public ModelPart EquipHead03_6;
	public ModelPart EquipHead03_7;
	public ModelPart EquipHeadBack3c_1;
	public ModelPart EquipHeadBack3d_1;
	public ModelPart EquipHeadBack3e_1;
	public ModelPart EquipHeadBack3f_1;
	public ModelPart EquipHeadBack3g_1;
	public ModelPart EquipHeadBack3h_1;
	public ModelPart EquipHead03a_4;
	public ModelPart EquipHead01_3;
	public ModelPart EquipHead02_1;
	public ModelPart EquipHead00_1;
	public ModelPart EquipHead01a_2;
	public ModelPart EquipHead02a_1;
	public ModelPart EquipHead00a_1;
	public ModelPart EquipHead03a_5;
	public ModelPart EquipHead03a_6;
	public ModelPart EquipHead03a_7;
	public ModelPart EquipHead01a_3;
	public ModelPart EquipHead01b_1;
	public ModelPart EquipHead01d_1;
	public ModelPart TopCannon01b;
	public ModelPart TopCannon01b_1;
	public ModelPart TopCannon01b_2;
	public ModelPart TopCannonUnder;
	public ModelPart TopCannon02b;
	public ModelPart TopCannon03b;
	public ModelPart TopCannon04b;
	public ModelPart TopCannon02b_1;
	public ModelPart TopCannon03b_1;
	public ModelPart TopCannon04b_1;
	public ModelPart TopCannon02b_2;
	public ModelPart TopCannon03b_2;
	public ModelPart TopCannon04b_2;
	public ModelPart TopCannon01b_3;
	public ModelPart TopCannon01b_4;
	public ModelPart TopCannon01b_5;
	public ModelPart TopCannonUnder_1;
	public ModelPart TopCannon02b_3;
	public ModelPart TopCannon03b_3;
	public ModelPart TopCannon04b_3;
	public ModelPart TopCannon02b_4;
	public ModelPart TopCannon03b_4;
	public ModelPart TopCannon04b_4;
	public ModelPart TopCannon02b_5;
	public ModelPart TopCannon03b_5;
	public ModelPart TopCannon04b_5;
	public ModelPart Tongue01;
	public ModelPart Tongue01a;
	public ModelPart TongueBase2;
	public ModelPart Tongue02;
	public ModelPart Tongue02a;
	public ModelPart TongueBase3;
	public ModelPart Tongue03;
	public ModelPart Tongue03a;
	public ModelPart LegArmorA1;
	public ModelPart LegArmorA2;
	public ModelPart LegArmorA3;
	public ModelPart LegArmorA4;
	public ModelPart LegArmorB1;
	public ModelPart LegArmorB2;
	public ModelPart LegArmorB3;
	public ModelPart LegArmorB4;
	public ModelPart GlowBodyMain;
	public ModelPart GlowLowerMain;
	public ModelPart GlowTopCannonBase;
	public ModelPart GlowTopCannonBase_1;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("UpperMain", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 9.5F, 14.0F, -0.4363323129985824F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("Back", CubeListBuilder.create().mirror().addBox(-10.0F, -14.0F, 9.5F, 10.0F, 6.0F, 3.0F), PartPose.offset(0.0F, 9.0F, -10.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("Back_1", CubeListBuilder.create().addBox(0.0F, -5.0F, 0.0F, 10.0F, 6.0F, 3.0F), PartPose.offset(0.0F, -9.0F, 9.5F));
		PartDefinition partdef4 = partdef3.addOrReplaceChild("EquipHead01b", CubeListBuilder.create().addBox(-6.5F, 0.0F, 0.0F, 13.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(13.6F, -5.0F, -3.5F, 0.0F, 0.6108652381980153F, 0.0F));
		PartDefinition partdef5 = partdef3.addOrReplaceChild("EquipHead01d", CubeListBuilder.create().addBox(-6.5F, 0.0F, 0.0F, 13.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-13.6F, -5.0F, -3.5F, 0.0F, -0.6108652381980153F, 0.0F));
		PartDefinition partdef6 = partdef2.addOrReplaceChild("Head", CubeListBuilder.create().mirror().addBox(-9.0F, -8.0F, -5.0F, 9.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -12.0F, 14.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("EquipHead01", CubeListBuilder.create().addBox(0.0F, -8.0F, -5.0F, 9.0F, 6.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("EquipHead01a_1", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(14.0F, -8.1F, -6.1F, -0.20943951023931953F, -2.530727415391778F, 0.05235987755982988F));
		PartDefinition partdef9 = partdef6.addOrReplaceChild("EquipHeadBack1", CubeListBuilder.create().mirror().addBox(-9.0F, -9.5F, -9.2F, 9.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -10.1F, -0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("EquipHeadBack2", CubeListBuilder.create().mirror().addBox(-10.0F, -12.0F, -11.0F, 10.0F, 2.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 0.5F, -2.2F, 0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("EquipHead03_1", CubeListBuilder.create().addBox(-6.0F, 1.0F, -4.0F, 10.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(13.3F, -8.2F, -1.4F, -0.17453292519943295F, -1.5707963267948966F, -0.17453292519943295F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("EquipHead03a_1", CubeListBuilder.create().mirror().addBox(-6.0F, 0.0F, 0.0F, 10.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(-0.1F, 10.5F, -3.7F, 0.24434609527920614F, 0.0F, 0.0F));
		PartDefinition partdef13 = partdef10.addOrReplaceChild("EquipHeadBack3g", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 8.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(-10.0F, -12.5F, -10.0F, 0.0F, 0.0F, -0.5759586531581287F));
		PartDefinition partdef14 = partdef10.addOrReplaceChild("EquipHeadBack3b", CubeListBuilder.create().addBox(0.0F, -4.0F, -5.5F, 10.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -7.0F, -13.0F, 0.4363323129985824F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef10.addOrReplaceChild("EquipHead03", CubeListBuilder.create().mirror().addBox(-6.0F, 1.0F, -4.0F, 12.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(11.2F, -7.9F, -10.6F, -0.3839724354387525F, -1.2217304763960306F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("EquipHead03a", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.1F, 10.5F, -3.7F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef10.addOrReplaceChild("EquipHeadBack3h", CubeListBuilder.create().addBox(-9.0F, 0.0F, 0.0F, 9.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(-10.0F, -12.0F, 3.5F, -1.0122909661567112F, -0.24434609527920614F, -0.5235987755982988F));
		PartDefinition partdef18 = partdef10.addOrReplaceChild("EquipHeadBack2b", CubeListBuilder.create().addBox(0.0F, -12.0F, -11.0F, 10.0F, 2.0F, 13.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef19 = partdef10.addOrReplaceChild("EquipHeadBack3", CubeListBuilder.create().mirror().addBox(-10.0F, -4.0F, -5.5F, 10.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -7.0F, -13.0F, 0.4363323129985824F, 0.0F, 0.0F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("EquipHead02", CubeListBuilder.create().addBox(-6.0F, 0.0F, -4.0F, 12.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(8.0F, -1.0F, -2.0F, -0.8726646259971648F, -0.4363323129985824F, 0.22689280275926282F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("EquipHead02a", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 9.5F, -3.6F, 0.296705972839036F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdef19.addOrReplaceChild("EquipHead01_1", CubeListBuilder.create().addBox(-6.0F, 0.0F, -4.0F, 12.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(-8.0F, -1.0F, -2.0F, -0.8726646259971648F, 0.4363323129985824F, -0.22689280275926282F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("EquipHead01a", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 9.5F, -3.6F, 0.296705972839036F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef19.addOrReplaceChild("EquipHead00", CubeListBuilder.create().mirror().addBox(-6.0F, 0.0F, -4.0F, 12.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, -0.8028514559173915F, 0.0F, 0.0F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("EquipHead00a", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 9.5F, -3.6F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef26 = partdef10.addOrReplaceChild("EquipHeadBack3e", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 9.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(10.0F, -12.0F, 3.5F, -1.0122909661567112F, 0.24434609527920614F, 0.5235987755982988F));
		PartDefinition partdef27 = partdef10.addOrReplaceChild("EquipHeadBack3f", CubeListBuilder.create().addBox(-3.0F, -2.0F, -4.0F, 6.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(-11.2F, -8.0F, -12.4F, 0.3490658503988659F, 0.0F, -0.5235987755982988F));
		PartDefinition partdef28 = partdef10.addOrReplaceChild("EquipHead03_3", CubeListBuilder.create().mirror().addBox(-4.0F, 1.0F, -4.0F, 10.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(-13.3F, -8.2F, -1.4F, -0.17453292519943295F, 1.5707963267948966F, 0.17453292519943295F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("EquipHead03a_3", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 10.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.1F, 10.5F, -3.7F, 0.24434609527920614F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdef10.addOrReplaceChild("EquipHeadBack3c", CubeListBuilder.create().mirror().addBox(-3.0F, -2.0F, -4.0F, 6.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(11.2F, -8.0F, -12.4F, 0.3490658503988659F, 0.0F, 0.5235987755982988F));
		PartDefinition partdef31 = partdef10.addOrReplaceChild("EquipHeadBack3d", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(10.0F, -12.5F, -10.0F, 0.0F, 0.0F, 0.5759586531581287F));
		PartDefinition partdef32 = partdef10.addOrReplaceChild("EquipHead03_2", CubeListBuilder.create().addBox(-6.0F, 1.0F, -4.0F, 12.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(-11.2F, -7.9F, -10.6F, -0.3839724354387525F, 1.2217304763960306F, 0.0F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("EquipHead03a_2", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.1F, 10.5F, -3.7F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef34 = partdef6.addOrReplaceChild("EquipHeadBack1b", CubeListBuilder.create().addBox(-8.0F, -9.5F, -9.4F, 9.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(7.8F, -2.0F, -10.1F, -0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef35 = partdef6.addOrReplaceChild("EquipHead01c", CubeListBuilder.create().mirror().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-14.0F, -8.1F, -6.1F, -0.20943951023931953F, 2.530727415391778F, 0.05235987755982988F));
		PartDefinition partdef36 = partdef0.addOrReplaceChild("LowerMain", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 8.0F, 14.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef37 = partdef36.addOrReplaceChild("Back_2", CubeListBuilder.create().mirror().addBox(-10.0F, -17.0F, 9.5F, 10.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -11.0F, -11.0F, 0.0F, 0.0F, 3.141592653589793F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("Head_1", CubeListBuilder.create().addBox(-9.0F, -8.0F, -5.0F, 9.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -12.0F, 14.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("EquipHead01c_1", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-11.8F, -8.1F, -8.9F, 0.20943951023931953F, -0.6108652381980153F, 0.05235987755982988F));
		PartDefinition partdef40 = partdef38.addOrReplaceChild("EquipHeadBack1_1", CubeListBuilder.create().mirror().addBox(-9.0F, -10.5F, -9.2F, 9.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -10.1F, -0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("EquipHeadBack2_1", CubeListBuilder.create().mirror().addBox(-10.0F, -12.0F, -11.0F, 10.0F, 2.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 0.5F, -2.2F, 0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("EquipHeadBack3_1", CubeListBuilder.create().mirror().addBox(-10.0F, -4.0F, -5.5F, 10.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -7.0F, -13.0F, 0.4363323129985824F, 0.0F, 0.0F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("EquipHead02_1", CubeListBuilder.create().addBox(-6.0F, 0.0F, -4.0F, 12.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(8.0F, -1.0F, -2.0F, -0.8726646259971648F, -0.4363323129985824F, 0.22689280275926282F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("EquipHead02a_1", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 5.5F, -3.6F, 0.296705972839036F, 0.0F, 0.0F));
		PartDefinition partdef45 = partdef42.addOrReplaceChild("EquipHead00_1", CubeListBuilder.create().mirror().addBox(-6.0F, 0.0F, -4.0F, 12.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -4.0F, -0.8028514559173915F, 0.0F, 0.0F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("EquipHead00a_1", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 5.5F, -3.6F, 0.19198621771937624F, 0.0F, 0.0F));
		PartDefinition partdef47 = partdef42.addOrReplaceChild("EquipHead01_3", CubeListBuilder.create().mirror().addBox(-6.0F, 0.0F, -4.0F, 12.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-8.0F, -1.0F, -2.0F, -0.8726646259971648F, 0.4363323129985824F, -0.22689280275926282F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("EquipHead01a_2", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 5.5F, -3.6F, 0.296705972839036F, 0.0F, 0.0F));
		PartDefinition partdef49 = partdef41.addOrReplaceChild("EquipHeadBack3g_1", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 8.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(-10.0F, -12.5F, -10.0F, 0.0F, 0.0F, -0.5759586531581287F));
		PartDefinition partdef50 = partdef41.addOrReplaceChild("EquipHeadBack3e_1", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 9.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(10.0F, -12.0F, 3.5F, -1.0122909661567112F, 0.24434609527920614F, 0.5235987755982988F));
		PartDefinition partdef51 = partdef41.addOrReplaceChild("EquipHead03_6", CubeListBuilder.create().addBox(-6.0F, 1.0F, -4.0F, 12.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-11.2F, -7.9F, -10.6F, -0.3839724354387525F, 1.2217304763960306F, 0.0F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("EquipHead03a_6", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 11.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 6.2F, -3.7F, 0.20943951023931953F, 0.0F, 0.017453292519943295F));
		PartDefinition partdef53 = partdef41.addOrReplaceChild("EquipHead03_7", CubeListBuilder.create().mirror().addBox(-4.0F, 1.0F, -4.0F, 10.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-13.3F, -8.2F, -1.4F, -0.17453292519943295F, 1.5707963267948966F, 0.17453292519943295F));
		PartDefinition partdef54 = partdef53.addOrReplaceChild("EquipHead03a_7", CubeListBuilder.create().addBox(-4.0F, 0.0F, 0.0F, 10.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(0.1F, 6.5F, -3.7F, 0.24434609527920614F, 0.0F, 0.0F));
		PartDefinition partdef55 = partdef41.addOrReplaceChild("EquipHead03_5", CubeListBuilder.create().addBox(-6.0F, 1.0F, -4.0F, 10.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(13.3F, -8.2F, -1.4F, -0.17453292519943295F, -1.5707963267948966F, -0.17453292519943295F));
		PartDefinition partdef56 = partdef55.addOrReplaceChild("EquipHead03a_5", CubeListBuilder.create().mirror().addBox(-6.0F, 0.0F, 0.0F, 10.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(-0.1F, 6.5F, -3.7F, 0.24434609527920614F, 0.0F, 0.0F));
		PartDefinition partdef57 = partdef41.addOrReplaceChild("EquipHeadBack3d_1", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 8.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(10.0F, -12.5F, -10.0F, 0.0F, 0.0F, 0.5759586531581287F));
		PartDefinition partdef58 = partdef41.addOrReplaceChild("EquipHead03_4", CubeListBuilder.create().mirror().addBox(-6.0F, 1.0F, -4.0F, 12.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(11.2F, -7.9F, -10.6F, -0.3839724354387525F, -1.2217304763960306F, 0.0F));
		PartDefinition partdef59 = partdef58.addOrReplaceChild("EquipHead03a_4", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 11.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(1.0F, 6.3F, -3.7F, 0.20943951023931953F, 0.0F, -0.017453292519943295F));
		PartDefinition partdef60 = partdef41.addOrReplaceChild("EquipHeadBack2b_1", CubeListBuilder.create().addBox(0.0F, -12.0F, -11.0F, 10.0F, 2.0F, 13.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef61 = partdef41.addOrReplaceChild("EquipHeadBack3c_1", CubeListBuilder.create().mirror().addBox(-3.0F, -2.0F, -4.0F, 6.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(11.2F, -8.0F, -12.4F, 0.3490658503988659F, 0.0F, 0.5235987755982988F));
		PartDefinition partdef62 = partdef41.addOrReplaceChild("EquipHeadBack3f_1", CubeListBuilder.create().addBox(-3.0F, -2.0F, -4.0F, 6.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(-11.2F, -8.0F, -12.4F, 0.3490658503988659F, 0.0F, -0.5235987755982988F));
		PartDefinition partdef63 = partdef41.addOrReplaceChild("EquipHeadBack3h_1", CubeListBuilder.create().addBox(-9.0F, 0.0F, 0.0F, 9.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(-10.0F, -12.0F, 3.5F, -1.0122909661567112F, -0.24434609527920614F, -0.5235987755982988F));
		PartDefinition partdef64 = partdef41.addOrReplaceChild("EquipHeadBack3b_1", CubeListBuilder.create().addBox(0.0F, -4.0F, -5.5F, 10.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -7.0F, -13.0F, 0.4363323129985824F, 0.0F, 0.0F));
		PartDefinition partdef65 = partdef38.addOrReplaceChild("EquipHead01_2", CubeListBuilder.create().addBox(0.0F, -8.0F, -5.0F, 9.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef66 = partdef65.addOrReplaceChild("EquipHead01a_3", CubeListBuilder.create().mirror().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(11.7F, -8.1F, -8.9F, 0.20943951023931953F, 0.6108652381980153F, -0.05235987755982988F));
		PartDefinition partdef67 = partdef38.addOrReplaceChild("EquipHeadBack1b_1", CubeListBuilder.create().addBox(-8.0F, -10.5F, -9.4F, 9.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(7.8F, -2.0F, -10.1F, -0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef68 = partdef37.addOrReplaceChild("Back_3", CubeListBuilder.create().addBox(0.0F, -5.0F, 0.0F, 10.0F, 7.0F, 4.0F), PartPose.offset(0.0F, -12.0F, 9.5F));
		PartDefinition partdef69 = partdef68.addOrReplaceChild("EquipHead01b_1", CubeListBuilder.create().mirror().addBox(-6.5F, 0.0F, 0.0F, 13.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(12.7F, -5.0F, -3.3F, 0.0F, 0.6108652381980153F, 0.0F));
		PartDefinition partdef70 = partdef68.addOrReplaceChild("EquipHead01d_1", CubeListBuilder.create().addBox(-6.5F, 0.0F, 0.0F, 13.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-12.7F, -5.0F, -3.3F, 0.0F, -0.6981317007977318F, 0.0F));
		PartDefinition partdef71 = partdef36.addOrReplaceChild("TopCannonBase", CubeListBuilder.create().addBox(-5.0F, -6.0F, -3.0F, 10.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(13.0F, 1.0F, -15.0F, -0.13962634015954636F, -0.17453292519943295F, 0.08726646259971647F));
		PartDefinition partdef72 = partdef71.addOrReplaceChild("TopCannonUnder", CubeListBuilder.create().addBox(-2.0F, 0.0F, -4.0F, 4.0F, 3.0F, 5.0F), PartPose.offset(0.0F, -1.0F, 2.0F));
		PartDefinition partdef73 = partdef36.addOrReplaceChild("TopCannonBase_1", CubeListBuilder.create().addBox(-5.0F, -6.0F, -3.0F, 10.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(-13.0F, 1.0F, -15.0F, -0.13962634015954636F, 0.2617993877991494F, -0.08726646259971647F));
		PartDefinition partdef74 = partdef73.addOrReplaceChild("TopCannonUnder_1", CubeListBuilder.create().addBox(-2.0F, 0.0F, -4.0F, 4.0F, 3.0F, 5.0F), PartPose.offset(0.0F, -1.0F, 2.0F));
		PartDefinition partdef75 = partdef0.addOrReplaceChild("LegArmorBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, 20.0F, 6.0F));
		PartDefinition partdef76 = partdef75.addOrReplaceChild("LegArmorA4", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 8.0F, 11.0F, 1.3962634015954636F, -0.6829473363053812F, -0.3141592653589793F));
		PartDefinition partdef77 = partdef76.addOrReplaceChild("LegArmorB4", CubeListBuilder.create().mirror().addBox(-4.5F, -4.5F, -1.0F, 9.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(-8.0F, 3.0F, 0.0F, 0.5235987755982988F, 0.7853981633974483F, -0.2792526803190927F));
		PartDefinition partdef78 = partdef75.addOrReplaceChild("LegArmorA1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 6.0F, -6.0F, -1.2217304763960306F, 0.3490658503988659F, 0.3141592653589793F));
		PartDefinition partdef79 = partdef78.addOrReplaceChild("LegArmorB1", CubeListBuilder.create().addBox(-4.5F, -4.5F, -1.0F, 9.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(20.0F, -4.5F, 0.0F, -0.13962634015954636F, 0.6108652381980153F, -0.13962634015954636F));
		PartDefinition partdef80 = partdef75.addOrReplaceChild("LegArmorA2", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 6.0F, -10.0F, -1.2217304763960306F, 0.0F, -0.3141592653589793F));
		PartDefinition partdef81 = partdef80.addOrReplaceChild("LegArmorB2", CubeListBuilder.create().mirror().addBox(-4.5F, -4.5F, -1.0F, 9.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(-18.0F, -4.5F, 0.0F, -0.13962634015954636F, -0.6981317007977318F, 0.13962634015954636F));
		PartDefinition partdef82 = partdef75.addOrReplaceChild("LegArmorA3", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(3.0F, 6.0F, 10.0F, -1.2217304763960306F, 0.0F, 0.3141592653589793F));
		PartDefinition partdef83 = partdef82.addOrReplaceChild("LegArmorB3", CubeListBuilder.create().addBox(-4.5F, -4.5F, -1.0F, 9.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, -0.05235987755982988F, 0.5235987755982988F, -0.2792526803190927F));
		PartDefinition partdef84 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef85 = partdef84.addOrReplaceChild("GlowLowerMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 14.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef86 = partdef85.addOrReplaceChild("TongueBase1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 3.5F, -17.0F, -0.6108652381980153F, 0.2617993877991494F, -0.05235987755982988F));
		PartDefinition partdef87 = partdef86.addOrReplaceChild("Tongue01a", CubeListBuilder.create().addBox(-10.0F, -2.0F, -10.0F, 10.0F, 4.0F, 10.0F), PartPose.offsetAndRotation(0.3F, 0.0F, 0.0F, 0.0F, 0.0F, -0.10471975511965977F));
		PartDefinition partdef88 = partdef86.addOrReplaceChild("Tongue01", CubeListBuilder.create().addBox(0.0F, -2.0F, -10.0F, 10.0F, 4.0F, 10.0F), PartPose.offsetAndRotation(-0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.10471975511965977F));
		PartDefinition partdef89 = partdef86.addOrReplaceChild("TongueBase2", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.5F, -9.0F, 0.6108652381980153F, 0.0F, 0.0F));
		PartDefinition partdef90 = partdef89.addOrReplaceChild("TongueBase3", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.2F, -6.5F, 0.6108652381980153F, 0.0F, 0.0F));
		PartDefinition partdef91 = partdef90.addOrReplaceChild("Tongue03", CubeListBuilder.create().addBox(0.0F, -2.0F, -8.0F, 8.0F, 3.0F, 8.0F), PartPose.offsetAndRotation(-0.3F, 0.2F, 0.0F, 0.0F, 0.05235987755982988F, 0.13962634015954636F));
		PartDefinition partdef92 = partdef90.addOrReplaceChild("Tongue03a", CubeListBuilder.create().addBox(-8.0F, -2.0F, -8.0F, 8.0F, 3.0F, 8.0F), PartPose.offsetAndRotation(0.3F, 0.0F, 0.0F, 0.0F, -0.05235987755982988F, -0.13962634015954636F));
		PartDefinition partdef93 = partdef89.addOrReplaceChild("Tongue02a", CubeListBuilder.create().addBox(-9.0F, -2.0F, -8.0F, 9.0F, 4.0F, 8.0F), PartPose.offsetAndRotation(0.3F, 0.0F, 0.0F, 0.0F, 0.0F, -0.10471975511965977F));
		PartDefinition partdef94 = partdef89.addOrReplaceChild("Tongue02", CubeListBuilder.create().addBox(0.0F, -2.0F, -8.0F, 9.0F, 4.0F, 8.0F), PartPose.offsetAndRotation(-0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.10471975511965977F));
		PartDefinition partdef95 = partdef85.addOrReplaceChild("GlowTopCannonBase", CubeListBuilder.create(), PartPose.offsetAndRotation(13.0F, 1.0F, -15.0F, -0.13962634015954636F, -0.17453292519943295F, 0.08726646259971647F));
		PartDefinition partdef96 = partdef95.addOrReplaceChild("TopCannon01b_2", CubeListBuilder.create().addBox(-1.0F, -1.2F, -4.0F, 2.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(3.0F, -3.5F, -2.0F, -0.31869712141416456F, 0.0F, 0.0F));
		PartDefinition partdef97 = partdef96.addOrReplaceChild("TopCannon02b_2", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 0.2F, -7.0F));
		PartDefinition partdef98 = partdef96.addOrReplaceChild("TopCannon03b_2", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -0.3F, -3.9F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef99 = partdef98.addOrReplaceChild("TopCannon04b_2", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition partdef100 = partdef95.addOrReplaceChild("TopCannon01b", CubeListBuilder.create().addBox(-1.0F, -1.2F, -4.0F, 2.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(-3.0F, -3.5F, -2.0F, -0.31869712141416456F, 0.0F, 0.0F));
		PartDefinition partdef101 = partdef100.addOrReplaceChild("TopCannon02b", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 0.2F, -7.0F));
		PartDefinition partdef102 = partdef100.addOrReplaceChild("TopCannon03b", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -0.3F, -3.9F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef103 = partdef102.addOrReplaceChild("TopCannon04b", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition partdef104 = partdef95.addOrReplaceChild("TopCannon01b_1", CubeListBuilder.create().addBox(-1.0F, -1.2F, -4.0F, 2.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -3.5F, -2.0F, -0.31869712141416456F, 0.0F, 0.0F));
		PartDefinition partdef105 = partdef104.addOrReplaceChild("TopCannon03b_1", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -0.3F, -3.9F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef106 = partdef105.addOrReplaceChild("TopCannon04b_1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition partdef107 = partdef104.addOrReplaceChild("TopCannon02b_1", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 0.2F, -7.0F));
		PartDefinition partdef108 = partdef85.addOrReplaceChild("GlowTopCannonBase_1", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.0F, 1.0F, -15.0F, -0.13962634015954636F, 0.2617993877991494F, -0.08726646259971647F));
		PartDefinition partdef109 = partdef108.addOrReplaceChild("TopCannon01b_4", CubeListBuilder.create().addBox(-1.0F, -1.2F, -4.0F, 2.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -3.5F, -2.0F, -0.31869712141416456F, 0.0F, 0.0F));
		PartDefinition partdef110 = partdef109.addOrReplaceChild("TopCannon03b_4", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -0.3F, -3.9F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef111 = partdef110.addOrReplaceChild("TopCannon04b_4", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition partdef112 = partdef109.addOrReplaceChild("TopCannon02b_4", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 0.2F, -7.0F));
		PartDefinition partdef113 = partdef108.addOrReplaceChild("TopCannon01b_3", CubeListBuilder.create().addBox(-1.0F, -1.2F, -4.0F, 2.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(-3.0F, -3.5F, -2.0F, -0.31869712141416456F, 0.0F, 0.0F));
		PartDefinition partdef114 = partdef113.addOrReplaceChild("TopCannon03b_3", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -0.3F, -3.9F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef115 = partdef114.addOrReplaceChild("TopCannon04b_3", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition partdef116 = partdef113.addOrReplaceChild("TopCannon02b_3", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 0.2F, -7.0F));
		PartDefinition partdef117 = partdef108.addOrReplaceChild("TopCannon01b_5", CubeListBuilder.create().addBox(-1.0F, -1.2F, -4.0F, 2.0F, 3.0F, 4.0F), PartPose.offsetAndRotation(3.0F, -3.5F, -2.0F, -0.31869712141416456F, 0.0F, 0.0F));
		PartDefinition partdef118 = partdef117.addOrReplaceChild("TopCannon02b_5", CubeListBuilder.create().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 7.0F), PartPose.offset(0.0F, 0.2F, -7.0F));
		PartDefinition partdef119 = partdef117.addOrReplaceChild("TopCannon03b_5", CubeListBuilder.create().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 10.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -0.3F, -3.9F, -1.5707963267948966F, 0.0F, 0.0F));
		PartDefinition partdef120 = partdef119.addOrReplaceChild("TopCannon04b_5", CubeListBuilder.create().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public ModelMountMiH(ModelPart root)
	{
		this.EquipHead03a_3 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHead03_3").getChild("EquipHead03a_3");
		this.EquipHeadBack3_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack3_1");
		this.EquipHeadBack3g_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack3g_1");
		this.TopCannon04b_5 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase_1").getChild("TopCannon01b_5").getChild("TopCannon03b_5").getChild("TopCannon04b_5");
		this.EquipHead03_1 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHead03_1");
		this.EquipHead01 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHead01");
		this.EquipHeadBack2_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1");
		this.EquipHead01c_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHead01c_1");
		this.TopCannon03b_3 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase_1").getChild("TopCannon01b_3").getChild("TopCannon03b_3");
		this.EquipHead03a_5 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHead03_5").getChild("EquipHead03a_5");
		this.TopCannon02b_3 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase_1").getChild("TopCannon01b_3").getChild("TopCannon02b_3");
		this.UpperMain = root.getChild("BodyMain").getChild("UpperMain");
		this.EquipHead02_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack3_1").getChild("EquipHead02_1");
		this.LowerMain = root.getChild("BodyMain").getChild("LowerMain");
		this.TongueBase3 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("TongueBase1").getChild("TongueBase2").getChild("TongueBase3");
		this.TopCannon03b_1 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase").getChild("TopCannon01b_1").getChild("TopCannon03b_1");
		this.EquipHeadBack1 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1");
		this.LegArmorBase = root.getChild("BodyMain").getChild("LegArmorBase");
		this.Tongue02a = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("TongueBase1").getChild("TongueBase2").getChild("Tongue02a");
		this.EquipHeadBack3g = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack3g");
		this.TopCannon02b_5 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase_1").getChild("TopCannon01b_5").getChild("TopCannon02b_5");
		this.EquipHeadBack3b = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack3b");
		this.EquipHead02 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack3").getChild("EquipHead02");
		this.TopCannon03b_5 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase_1").getChild("TopCannon01b_5").getChild("TopCannon03b_5");
		this.LegArmorB1 = root.getChild("BodyMain").getChild("LegArmorBase").getChild("LegArmorA1").getChild("LegArmorB1");
		this.EquipHead03a_4 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHead03_4").getChild("EquipHead03a_4");
		this.EquipHead01b = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Back_1").getChild("EquipHead01b");
		this.EquipHeadBack3e_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack3e_1");
		this.Head_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1");
		this.TopCannon01b_1 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase").getChild("TopCannon01b_1");
		this.EquipHead01d = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Back_1").getChild("EquipHead01d");
		this.EquipHead03a_1 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHead03_1").getChild("EquipHead03a_1");
		this.EquipHead01a_2 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack3_1").getChild("EquipHead01_3").getChild("EquipHead01a_2");
		this.EquipHead01_1 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack3").getChild("EquipHead01_1");
		this.TopCannon02b_2 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase").getChild("TopCannon01b_2").getChild("TopCannon02b_2");
		this.TopCannonBase = root.getChild("BodyMain").getChild("LowerMain").getChild("TopCannonBase");
		this.LegArmorB4 = root.getChild("BodyMain").getChild("LegArmorBase").getChild("LegArmorA4").getChild("LegArmorB4");
		this.EquipHead03_6 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHead03_6");
		this.EquipHead03_7 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHead03_7");
		this.EquipHead01a_3 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHead01_2").getChild("EquipHead01a_3");
		this.Back_1 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Back_1");
		this.EquipHead03 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHead03");
		this.EquipHead01b_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Back_3").getChild("EquipHead01b_1");
		this.Tongue01a = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("TongueBase1").getChild("Tongue01a");
		this.TopCannon04b_3 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase_1").getChild("TopCannon01b_3").getChild("TopCannon03b_3").getChild("TopCannon04b_3");
		this.EquipHeadBack1b = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1b");
		this.Tongue01 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("TongueBase1").getChild("Tongue01");
		this.TopCannon01b = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase").getChild("TopCannon01b");
		this.LegArmorA4 = root.getChild("BodyMain").getChild("LegArmorBase").getChild("LegArmorA4");
		this.EquipHead03_5 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHead03_5");
		this.EquipHeadBack3h = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack3h");
		this.TopCannon04b = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase").getChild("TopCannon01b").getChild("TopCannon03b").getChild("TopCannon04b");
		this.Head = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head");
		this.EquipHead03a_7 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHead03_7").getChild("EquipHead03a_7");
		this.EquipHeadBack2b = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack2b");
		this.EquipHeadBack3d_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack3d_1");
		this.TongueBase2 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("TongueBase1").getChild("TongueBase2");
		this.TopCannonBase_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("TopCannonBase_1");
		this.LegArmorA1 = root.getChild("BodyMain").getChild("LegArmorBase").getChild("LegArmorA1");
		this.EquipHead03_4 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHead03_4");
		this.EquipHeadBack2b_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack2b_1");
		this.EquipHeadBack3 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack3");
		this.Back_3 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Back_3");
		this.EquipHeadBack2 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2");
		this.LegArmorB2 = root.getChild("BodyMain").getChild("LegArmorBase").getChild("LegArmorA2").getChild("LegArmorB2");
		this.EquipHead02a = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack3").getChild("EquipHead02").getChild("EquipHead02a");
		this.EquipHeadBack1_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1");
		this.Back = root.getChild("BodyMain").getChild("UpperMain").getChild("Back");
		this.EquipHeadBack3e = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack3e");
		this.EquipHead00 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack3").getChild("EquipHead00");
		this.TopCannon01b_3 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase_1").getChild("TopCannon01b_3");
		this.EquipHeadBack3f = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack3f");
		this.EquipHead03a_2 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHead03_2").getChild("EquipHead03a_2");
		this.EquipHead01d_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Back_3").getChild("EquipHead01d_1");
		this.EquipHead02a_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack3_1").getChild("EquipHead02_1").getChild("EquipHead02a_1");
		this.TopCannon02b_1 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase").getChild("TopCannon01b_1").getChild("TopCannon02b_1");
		this.TopCannon04b_1 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase").getChild("TopCannon01b_1").getChild("TopCannon03b_1").getChild("TopCannon04b_1");
		this.TopCannonUnder = root.getChild("BodyMain").getChild("LowerMain").getChild("TopCannonBase").getChild("TopCannonUnder");
		this.TopCannon01b_4 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase_1").getChild("TopCannon01b_4");
		this.EquipHead03_3 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHead03_3");
		this.EquipHead00a = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack3").getChild("EquipHead00").getChild("EquipHead00a");
		this.LegArmorA2 = root.getChild("BodyMain").getChild("LegArmorBase").getChild("LegArmorA2");
		this.TopCannon03b_4 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase_1").getChild("TopCannon01b_4").getChild("TopCannon03b_4");
		this.EquipHead03a = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHead03").getChild("EquipHead03a");
		this.Tongue03 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("TongueBase1").getChild("TongueBase2").getChild("TongueBase3").getChild("Tongue03");
		this.BodyMain = root.getChild("BodyMain");
		this.TongueBase1 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("TongueBase1");
		this.LegArmorB3 = root.getChild("BodyMain").getChild("LegArmorBase").getChild("LegArmorA3").getChild("LegArmorB3");
		this.TopCannon04b_4 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase_1").getChild("TopCannon01b_4").getChild("TopCannon03b_4").getChild("TopCannon04b_4");
		this.TopCannon01b_2 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase").getChild("TopCannon01b_2");
		this.TopCannon02b = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase").getChild("TopCannon01b").getChild("TopCannon02b");
		this.EquipHeadBack3c = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack3c");
		this.TopCannon04b_2 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase").getChild("TopCannon01b_2").getChild("TopCannon03b_2").getChild("TopCannon04b_2");
		this.Back_2 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2");
		this.TopCannon02b_4 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase_1").getChild("TopCannon01b_4").getChild("TopCannon02b_4");
		this.EquipHead00_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack3_1").getChild("EquipHead00_1");
		this.EquipHead01_2 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHead01_2");
		this.EquipHead03a_6 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHead03_6").getChild("EquipHead03a_6");
		this.EquipHead01a_1 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHead01").getChild("EquipHead01a_1");
		this.EquipHeadBack3c_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack3c_1");
		this.LegArmorA3 = root.getChild("BodyMain").getChild("LegArmorBase").getChild("LegArmorA3");
		this.EquipHead00a_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack3_1").getChild("EquipHead00_1").getChild("EquipHead00a_1");
		this.TopCannon01b_5 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase_1").getChild("TopCannon01b_5");
		this.EquipHeadBack3f_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack3f_1");
		this.EquipHead01a = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack3").getChild("EquipHead01_1").getChild("EquipHead01a");
		this.EquipHead01_3 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack3_1").getChild("EquipHead01_3");
		this.Tongue02 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("TongueBase1").getChild("TongueBase2").getChild("Tongue02");
		this.EquipHead01c = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHead01c");
		this.EquipHeadBack3d = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHeadBack3d");
		this.Tongue03a = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("TongueBase1").getChild("TongueBase2").getChild("TongueBase3").getChild("Tongue03a");
		this.TopCannon03b = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase").getChild("TopCannon01b").getChild("TopCannon03b");
		this.TopCannonUnder_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("TopCannonBase_1").getChild("TopCannonUnder_1");
		this.EquipHeadBack1b_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1b_1");
		this.TopCannon03b_2 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase").getChild("TopCannon01b_2").getChild("TopCannon03b_2");
		this.EquipHeadBack3h_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack3h_1");
		this.EquipHead03_2 = root.getChild("BodyMain").getChild("UpperMain").getChild("Back").getChild("Head").getChild("EquipHeadBack1").getChild("EquipHeadBack2").getChild("EquipHead03_2");
		this.EquipHeadBack3b_1 = root.getChild("BodyMain").getChild("LowerMain").getChild("Back_2").getChild("Head_1").getChild("EquipHeadBack1_1").getChild("EquipHeadBack2_1").getChild("EquipHeadBack3b_1");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowLowerMain = root.getChild("GlowBodyMain").getChild("GlowLowerMain");
		this.GlowTopCannonBase = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase");
		this.GlowTopCannonBase_1 = root.getChild("GlowBodyMain").getChild("GlowLowerMain").getChild("GlowTopCannonBase_1");
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
    	
    	poseStack.popPose();
    
	}

	@Override
	public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4)
	{
		this.captureAnimParms(entity, f, f1, f2, f3, f4);

    	//FIX: head rotation bug while riding
    	if (f3 <= -180F) { f3 += 360F; }
    	else if (f3 >= 180F) { f3 -= 360F; }
    	
    	
    	RenderHelper.animScale(this, 0.97F , 0.97F, 0.97F);
this.animTransX += (0F); this.animTransY += (0.08F); this.animTransZ += (0F);
    	
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
this.animTransX += (0F); this.animTransY += (angleX * 0.015F + 0.025F); this.animTransZ += (0F);
    	}

  		//body
  		this.UpperMain.xRot = -0.46F;
  		//leg
  		this.LegArmorA1.yRot = addk1 + 0.35F;
  		this.LegArmorA2.yRot = addk1 + 0F;
  		this.LegArmorA3.yRot = addk2 + 0F;
  		this.LegArmorA4.yRot = addk2 - 0.68F;
  		this.LegArmorA1.y = (6.0F) + (angleX * 0.1F + angleAdd1 * 0.3F) * 16F;
  		this.LegArmorA2.y = (6.0F) + (-angleX * 0.1F + angleAdd1 * 0.3F) * 16F;
  		this.LegArmorA3.y = (6.0F) + (-angleX * 0.1F + angleAdd2 * 0.2F) * 16F;
  		this.LegArmorA4.y = (8.0F) + (angleX * 0.1F + angleAdd2 * 0.2F) * 16F;
	    //idle
	  	this.TongueBase1.xRot = angleX2 * 0.05F - 0.61F;
	  	this.TongueBase2.xRot = -angleX3 * 0.08F + 0.61F;
	  	this.TongueBase3.xRot = -angleX4 * 0.05F + 0.61F;
	    //cannon
	  	this.TopCannonBase.yRot = f3 * 0.008F;
	  	this.TopCannonBase_1.yRot = f3 * 0.008F;
	    this.TopCannon01b.xRot = f4 * 0.014F - 0.3F;
	    this.TopCannon01b_1.xRot = f4 * 0.014F - 0.25F;
	    this.TopCannon01b_2.xRot = f4 * 0.014F - 0.35F;
	    this.TopCannon01b_3.xRot = f4 * 0.014F - 0.15F;
	    this.TopCannon01b_4.xRot = f4 * 0.014F - 0.2F;
	    this.TopCannon01b_5.xRot = f4 * 0.014F - 0.1F;
	    
	    //sitting
	    if (ent.getIsSitting())
	    {
	    	this.TongueBase1.xRot = angleX2 * 0.025F - 0.41F;
		  	this.TongueBase2.xRot = -angleX3 * 0.04F + 0.41F;
		  	this.TongueBase3.xRot = -angleX4 * 0.025F + 0.71F;
	    	this.UpperMain.xRot = -0.15F;
	    }
	    
	    //sync rotate
	    this.GlowBodyMain.xRot = this.BodyMain.xRot;
	    this.GlowTopCannonBase.yRot = this.TopCannonBase.yRot;
	    this.GlowTopCannonBase_1.yRot = this.TopCannonBase_1.yRot;
  	
	}

}

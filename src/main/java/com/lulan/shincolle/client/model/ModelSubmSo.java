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

public class ModelSubmSo<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Butt;
	public ModelPart Head;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart BodyMain1;
	public ModelPart BodyMain2;
	public ModelPart BoobL;
	public ModelPart BoobL2;
	public ModelPart BoobR;
	public ModelPart BoobR2;
	public ModelPart Butt1;
	public ModelPart Butt2;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart LegRight02;
	public ModelPart LegLeft02;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart EquipHeadBase;
	public ModelPart Ahoke;
	public ModelPart HairU01;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart HairL02;
	public ModelPart HairR02;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart Hair03;
	public ModelPart EquipHead01;
	public ModelPart EquipHead02;
	public ModelPart EquipHead03;
	public ModelPart EquipHead04;
	public ModelPart EquipHead05;
	public ModelPart EquipC01;
	public ModelPart EquipC02;
	public ModelPart ArmLeft02;
	public ModelPart EquipT01a;
	public ModelPart EquipT01b;
	public ModelPart ArmRight02;
	public ModelPart GlowBodyMain;
	public ModelPart GlowHead;
	public ModelPart GlowArmLeft01;
	public ModelPart GlowArmLeft02;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -11.0F, -3.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.5F, 2.8F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F), PartPose.offsetAndRotation(-4.4F, 6.5F, -4.0F, -0.03490658503988659F, 0.0F, -0.10471975511965977F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 13.0F, 6.0F), PartPose.offset(3.0F, 12.0F, -3.0F));
		PartDefinition partdef4 = partdef1.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F), PartPose.offsetAndRotation(4.4F, 6.5F, -4.0F, -0.15707963267948966F, 0.0F, 0.10471975511965977F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 13.0F, 6.0F), PartPose.offset(-3.0F, 12.0F, -3.0F));
		PartDefinition partdef6 = partdef0.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -11.8F, -0.5F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 16.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 8.0F, 1.1F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.0F, 0.0F, -5.0F, 16.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 13.5F, 5.5F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("Hair03", CubeListBuilder.create().addBox(-8.0F, 0.0F, -4.5F, 16.0F, 15.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 12.5F, 0.0F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef6.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 12.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.4F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 5.0F), PartPose.offsetAndRotation(3.0F, 7.0F, -6.9F, -0.36425021489121656F, 0.9105382707654417F, -0.4553564018453205F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 2.5F, 2.0F, 0.17453292519943295F, -0.5235987755982988F, 0.17453292519943295F));
		PartDefinition partdef14 = partdef11.addOrReplaceChild("HairR01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(-5.5F, 8F, -7.0F, -0.13962634015954636F, -0.4363323129985824F, -0.08726646259971647F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(0.3F, 10.0F, 0.0F, 0.17453292519943295F, -0.08726646259971647F, 0.13962634015954636F));
		PartDefinition partdef16 = partdef11.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -5.0F, -10.5F, 0.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(-1.0F, -7.0F, -5.5F, 0.2617993877991494F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef17 = partdef11.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 15.0F, 7.0F), PartPose.offset(0.0F, -6.0F, -7.7F));
		PartDefinition partdef18 = partdef0.addOrReplaceChild("BoobL2", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(2.44F, -8.6F, -3.9F, -0.6981317007977318F, -0.08726646259971647F, -0.06981317007977318F));
		PartDefinition partdef19 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.7F, -0.7F, 0.20943951023931953F, 0.0F, -0.3141592653589793F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F), PartPose.offset(3.0F, 10.0F, 2.5F));
		PartDefinition partdef21 = partdef0.addOrReplaceChild("BodyMain1", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 15.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef22 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-3.2F, -8.6F, -3.9F, -0.6981317007977318F, 0.08726646259971647F, 0.06981317007977318F));
		PartDefinition partdef23 = partdef0.addOrReplaceChild("Butt1", CubeListBuilder.create().addBox(-7.5F, 0.0F, -7.0F, 15.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 2.5F, 2.8F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.7F, -0.7F, 0.0F, 0.0F, 0.20943951023931953F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0.0F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F), PartPose.offset(-3.0F, 10.0F, 2.5F));
		PartDefinition partdef26 = partdef0.addOrReplaceChild("BoobR2", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-2.44F, -8.6F, -3.9F, -0.6981317007977318F, 0.08726646259971647F, 0.06981317007977318F));
		PartDefinition partdef27 = partdef0.addOrReplaceChild("BodyMain2", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 15.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef28 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(3.2F, -8.6F, -3.9F, -0.6981317007977318F, -0.08726646259971647F, -0.06981317007977318F));
		PartDefinition partdef29 = partdef0.addOrReplaceChild("Butt2", CubeListBuilder.create().addBox(-7.5F, 0.0F, -7.0F, 15.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 2.5F, 2.8F, 0.20943951023931953F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -11.0F, -3.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef31 = partdef30.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -11.8F, -0.5F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef33 = partdef31.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef34 = partdef31.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef35 = partdef31.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef36 = partdef31.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef37 = partdef31.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef38 = partdef31.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef39 = partdef31.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef40 = partdef31.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef41 = partdef31.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));
		PartDefinition partdef42 = partdef31.addOrReplaceChild("EquipHeadBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, -14.8F, 2.0F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("EquipC01", CubeListBuilder.create().addBox(-4.5F, -8.0F, -6.5F, 9.0F, 7.0F, 11.0F), PartPose.offsetAndRotation(-3.0F, -2.0F, 5.0F, -0.4363323129985824F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef44 = partdef43.addOrReplaceChild("EquipC02", CubeListBuilder.create().addBox(-1.0F, -1.0F, -15.0F, 2.0F, 2.0F, 15.0F), PartPose.offsetAndRotation(-1.0F, -6.5F, -5.0F, -0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef45 = partdef42.addOrReplaceChild("EquipHead04", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 9.0F, 16.0F), PartPose.offsetAndRotation(0.0F, -8.5F, -4.0F, -0.5918411493512771F, -0.7155849933176751F, 0.40980330836826856F));
		PartDefinition partdef46 = partdef42.addOrReplaceChild("EquipHead02", CubeListBuilder.create().mirror().addBox(-12.0F, 0.0F, 0.0F, 12.0F, 7.0F, 16.0F), PartPose.offsetAndRotation(-5.0F, -2.4F, -12.0F, 0.17453292519943295F, 0.17453292519943295F, -0.13962634015954636F));
		PartDefinition partdef47 = partdef42.addOrReplaceChild("EquipHead01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 12.0F, 7.0F, 16.0F), PartPose.offsetAndRotation(5.0F, -2.4F, -12.0F, 0.17453292519943295F, -0.17453292519943295F, 0.13962634015954636F));
		PartDefinition partdef48 = partdef42.addOrReplaceChild("EquipHead05", CubeListBuilder.create().addBox(-5.5F, 0.0F, 0.0F, 11.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -1.0F, -11.4F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef49 = partdef42.addOrReplaceChild("EquipHead03", CubeListBuilder.create().addBox(-6.5F, 0.0F, -6.5F, 13.0F, 7.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -8.8F, -9.5F, -0.41887902047863906F, 2.408554367752175F, -0.28797932657906433F));
		PartDefinition partdef50 = partdef30.addOrReplaceChild("GlowArmLeft01", CubeListBuilder.create(), PartPose.offsetAndRotation(7.8F, -9.7F, -0.7F, 0.20943951023931953F, 0.0F, -0.3141592653589793F));
		PartDefinition partdef51 = partdef50.addOrReplaceChild("GlowArmLeft02", CubeListBuilder.create(), PartPose.offset(3.0F, 10.0F, 2.5F));
		PartDefinition partdef52 = partdef51.addOrReplaceChild("EquipT01a", CubeListBuilder.create().addBox(-2.0F, -3.0F, -5.0F, 4.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(-6.5F, 6.5F, -1.0F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef53 = partdef52.addOrReplaceChild("EquipT01b", CubeListBuilder.create().addBox(-2.5F, -3.5F, 0.0F, 5.0F, 7.0F, 8.0F), PartPose.offset(0.0F, 0.0F, -12.9F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelSubmSo(ModelPart root)
	{
		this.Face0 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Face0");
		this.Face1 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Face1");
		this.Face2 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Face2");
		this.Face3 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Face3");
		this.Face4 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Face4");
		this.Mouth0 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Mouth0");
		this.Mouth1 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Mouth1");
		this.Mouth2 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Mouth2");
		this.Flush0 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Flush0");
		this.Flush1 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("Flush1");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.Head = root.getChild("BodyMain").getChild("Head");
		this.HairMain = root.getChild("BodyMain").getChild("Head").getChild("HairMain");
		this.Hair03 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02").getChild("Hair03");
		this.BoobL2 = root.getChild("BodyMain").getChild("BoobL2");
		this.EquipHeadBase = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("EquipHeadBase");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.BodyMain1 = root.getChild("BodyMain").getChild("BodyMain1");
		this.EquipC02 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("EquipHeadBase").getChild("EquipC01").getChild("EquipC02");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.EquipC01 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("EquipHeadBase").getChild("EquipC01");
		this.HairL01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairL01");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.EquipT01a = root.getChild("GlowBodyMain").getChild("GlowArmLeft01").getChild("GlowArmLeft02").getChild("EquipT01a");
		this.HairR01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairR01");
		this.EquipHead04 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("EquipHeadBase").getChild("EquipHead04");
		this.Butt1 = root.getChild("BodyMain").getChild("Butt1");
		this.EquipHead02 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("EquipHeadBase").getChild("EquipHead02");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.BoobR2 = root.getChild("BodyMain").getChild("BoobR2");
		this.EquipHead01 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("EquipHeadBase").getChild("EquipHead01");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.BodyMain2 = root.getChild("BodyMain").getChild("BodyMain2");
		this.Hair02 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.EquipT01b = root.getChild("GlowBodyMain").getChild("GlowArmLeft01").getChild("GlowArmLeft02").getChild("EquipT01a").getChild("EquipT01b");
		this.Hair = root.getChild("BodyMain").getChild("Head").getChild("Hair");
		this.HairL02 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.HairR02 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.Ahoke = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.Butt2 = root.getChild("BodyMain").getChild("Butt2");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.EquipHead05 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("EquipHeadBase").getChild("EquipHead05");
		this.BodyMain = root.getChild("BodyMain");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.EquipHead03 = root.getChild("GlowBodyMain").getChild("GlowHead").getChild("EquipHeadBase").getChild("EquipHead03");
		this.Hair01 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.HairU01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairU01");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowHead");
		this.GlowArmLeft01 = root.getChild("GlowBodyMain").getChild("GlowArmLeft01");
		this.GlowArmLeft02 = root.getChild("GlowBodyMain").getChild("GlowArmLeft01").getChild("GlowArmLeft02");
		this.scale = 0.47F;
		this.offsetY = 1.78F;
		this.offsetItem = new float[] {0.08F, 0.96F, -0.08F};
		this.offsetBlock = new float[] {0.08F, 0.96F, -0.08F};
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
		
		boolean flag = !EmotionHelper.checkModelState(0, state);//head
		this.EquipHeadBase.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(1, state);	//head cannon
		this.EquipC01.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);	//cloth
		this.BodyMain1.visible = !(!flag);
		this.Butt1.visible = !(!flag);
		this.BoobL.visible = !(!flag);
		this.BoobR.visible = !(!flag);
		this.BodyMain2.visible = !(flag);
		this.Butt2.visible = !(flag);
		this.BoobL2.visible = !(flag);
		this.BoobR2.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(3, state);	//weapon
		this.EquipT01a.visible = !(flag);
	
	}

	public void syncRotationGlowPart()
	{

    	//outfit 2
    	this.BoobL2.xRot = this.BoobL.xRot;
    	this.BoobR2.xRot = this.BoobR.xRot;
    	this.Butt1.xRot = this.Butt.xRot;
    	this.Butt2.xRot = this.Butt.xRot;
    	
    	//頭部
		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
		this.GlowArmLeft01.xRot = this.ArmLeft01.xRot;
		this.GlowArmLeft01.yRot = this.ArmLeft01.yRot;
		this.GlowArmLeft01.zRot = this.ArmLeft01.zRot;
		this.GlowArmLeft02.xRot = this.ArmLeft02.xRot;
		this.GlowArmLeft02.yRot = this.ArmLeft02.yRot;
		this.GlowArmLeft02.zRot = this.ArmLeft02.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

    	float angleX = Mth.cos(f2 * 0.08F);
    	this.setFaceHungry(ent);
    	
this.animTransX += (0F); this.animTransY += (angleX * 0.1F); this.animTransZ += (0F);
	    //body
	    this.Head.xRot = 0.5F;
	    this.Head.yRot = 0F;
    	this.BodyMain.xRot = 1.6F;
    	//hair
    	this.Hair01.xRot = 0.1F;
    	this.Hair02.xRot = -0.5F;
    	this.Hair03.xRot = -0.5F;
    	//arm
    	this.ArmLeft01.xRot = -1.6F;
	    this.ArmLeft01.yRot = -0.15F - angleX * 0.05F;
	    this.ArmRight01.xRot = -1.6F;
	    this.ArmRight01.yRot = 0.15F + angleX * 0.05F;
	    //leg
	    this.LegLeft01.xRot = -1.6F;
	    this.LegRight01.xRot = -1.6F;
	    this.LegLeft01.yRot = -0.1F - angleX * 0.05F;
	  	this.LegRight01.yRot = 0.1F + angleX * 0.05F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

 		float angleX = Mth.cos(f2 * 0.08F);
  		float angleX1 = Mth.cos(f2*0.1F + 0.3F + f * 0.5F);
  		float angleX2 = Mth.cos(f2*0.1F + 0.6F + f * 0.5F);
  		float angleX3 = Mth.cos(f2*0.1F + 0.9F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.7F;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.7F;
  		float addk1 = 0F;
  		float addk2 = 0F;
  		float headX = 0F;
  		float headZ = 0F;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
  	    //head
	  	this.Head.xRot = f4 * 0.014F + 0.1047F;
	  	this.Head.yRot = f3 * 0.01F;
	  	this.Head.zRot = 0F;
	  	headX = this.Head.xRot * -0.5F;
	    //boob
  	    this.BoobL.xRot = angleX * 0.08F - 0.76F;
  	    this.BoobR.xRot = angleX * 0.08F - 0.76F;
	  	//body
  	    this.Ahoke.yRot = angleX * 0.15F + 0.6F;
	  	this.BodyMain.xRot = -0.1047F;
	  	this.BodyMain.yRot = 0F;
	  	this.BodyMain.zRot = 0F;
	  	this.Butt.xRot = 0.21F;
	  	this.Butt.z = (2.8F) + (0F) * 16F;
	  	//hair
	  	this.Hair01.xRot = 0.209F;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.xRot = -0.087F;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.xRot = -0.139F;
	  	this.Hair03.zRot = 0F;
	  	this.HairL01.xRot = -0.3643F;
	  	this.HairL02.xRot = 0.1745F;
	  	this.HairR01.xRot = -0.1396F;
	  	this.HairR02.xRot = 0.1745F;
	  	this.HairL01.zRot = -0.4554F;
	  	this.HairL02.zRot = 0.1745F;
	  	this.HairR01.zRot = 0.06F;
	  	this.HairR02.zRot = -0.0596F;
	    //arm 
	  	this.ArmLeft01.xRot = 0.2094F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = -angleX * 0.05F - 0.3142F;
	    this.ArmRight01.xRot = 0F;
	  	this.ArmRight01.yRot = 0F;
	    this.ArmRight01.zRot = angleX * 0.05F + 0.2094F;
		//leg
	    addk1 = angleAdd1 * 0.6F - 0.157F;
	  	addk2 = angleAdd2 * 0.6F - 0.035F;
	  	this.LegLeft01.yRot = 0F;
	  	this.LegLeft01.zRot = 0.1F;
	  	this.LegRight01.yRot = 0F;
	  	this.LegRight01.zRot = -0.1F;
	  	//equip
	  	this.EquipT01a.xRot = 0.14F;
	  	this.EquipT01a.zRot = 0F;
	  	this.EquipT01a.x = (-6.5F) + (0F) * 16F;
        this.EquipT01a.y = (6.5F) + (0F) * 16F;
        this.EquipT01a.z = (-1.0F) + (0F) * 16F;
        this.EquipC01.yRot = this.Head.yRot + 0.5F;
        this.EquipC02.xRot = this.Head.xRot;

	  	//sprinting
	    if (ent.getIsSprinting() || f1 > 0.92F)
	    {	//奔跑動作
this.animTransX += (0F); this.animTransY += (0.05F); this.animTransZ += (0F);
		    //body
		    this.Head.xRot -= 1.1F;
	    	this.BodyMain.xRot = 1.2566F;
	    	//胸部
	  	    this.BoobL.xRot = angleAdd1 * 0.08F - 0.7F;
	  	    this.BoobL.zRot = -0.07F;
	  	    this.BoobR.xRot = angleAdd1 * 0.08F - 0.7F;
	  	    this.BoobR.zRot = 0.07F;
	    	//arm
	    	this.ArmLeft01.xRot = -2.5133F;
		    this.ArmLeft01.zRot = -0.22F;
		    this.ArmRight01.xRot = -2.5133F;
		    this.ArmRight01.zRot = 0.22F;
		    //leg
		    this.LegLeft01.zRot = 0.05F;
		  	this.LegRight01.zRot = -0.05F;
		  	//equip
		  	this.EquipT01a.xRot = 1.2566F;
		  	this.EquipT01a.zRot = -0.1885F;
		  	this.EquipT01a.x = (-6.5F) + (-0.08F) * 16F;
  		}//end is sprinting
	    
	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {	//潛行, 蹲下動作
this.animTransX += (0F); this.animTransY += (0.05F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 1.0472F;
		  	this.BodyMain.xRot = 1.0472F;
		  	this.Butt.xRot = -0.8378F;
		  	//hair
		  	this.Hair01.xRot -= 0.1F;
		  	this.Hair02.xRot -= 0.2F;
		  	this.Hair03.xRot -= 0.5F;
		  	this.HairR01.zRot -= 0.5F;
		  	this.HairR02.zRot -= 0.2F;
		    //arm 
		    this.ArmLeft01.xRot = -0.7F;
		    this.ArmLeft01.zRot = 0.2618F;
		    this.ArmRight01.xRot = -0.7F;
		    this.ArmRight01.zRot = -0.2618F;
		    //leg
		    addk1 -= 0.1F;
		  	addk2 -= 0.1F;
  		}//end if sneaking
	    
	    //sitting riding
	    if (ent.getIsSitting() && !ent.getIsRiding())
	    {	//騎乘動作  	
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
	    		//潛水深度
this.animTransX += (0F); this.animTransY += (angleX * 0.05F); this.animTransZ += (0F);
			    //body
		    	this.Head.xRot *= 0.5F;
		    	this.Head.yRot *= 0.75F;
			    this.Head.xRot += 0.5F;
		    	this.BodyMain.xRot = 1.6F;
		    	//arm
		    	this.ArmLeft01.xRot = -1.6F;
			    this.ArmLeft01.yRot = -0.15F - angleX * 0.05F;
			    this.ArmRight01.xRot = -1.6F;
			    this.ArmRight01.yRot = 0.15F + angleX * 0.05F;
			    //leg
			    addk1 = -1.6F;
		    	addk2 = -1.6F;
			    this.LegLeft01.yRot = -0.1F - angleX * 0.05F;
			  	this.LegRight01.yRot = 0.1F + angleX * 0.05F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.45F); this.animTransZ += (0F);
		    	//body
		    	this.Head.xRot -= 0.7F;
		    	this.BodyMain.xRot = 0.5236F;
		    	//arm
		    	this.ArmLeft01.xRot = -0.4F;
		    	this.ArmLeft01.zRot = 0.3146F;
		    	this.ArmRight01.xRot = -0.4F;
		    	this.ArmRight01.zRot = -0.3146F;
		    	//leg
		    	addk1 = -2.18F;
		    	addk2 = -2.18F;
		    	this.LegLeft01.yRot = -0.3491F;
		    	this.LegRight01.yRot = 0.3491F;
	    	}
  		}//end sitting
	    
	    //attack
	    if (ent.getAttackTick() > 41)
	    {
	    	setFaceAttack(ent);
	    	//swing arm
		    float ft = (50 - ent.getAttackTick()) + (f2 - (int)f2);
		    ft *= 0.125F;
	  		float fa = Mth.cos(ft * ft * (float)Math.PI);
	        float fb = Mth.cos(Mth.sqrt(ft) * (float)Math.PI);
	        this.ArmLeft01.xRot += -fb * 80.0F * Values.N.DIV_PI_180 - 1.6F;
	        this.ArmLeft01.yRot += fa * 20.0F * Values.N.DIV_PI_180;
	        this.ArmLeft01.zRot += fb * 20.0F * Values.N.DIV_PI_180 + 0.4F;
	        //equip
	        this.EquipT01a.x = (-6.5F) + (0.2F) * 16F;
	        this.EquipT01a.y = (6.5F) + (0.2F) * 16F;
	        this.EquipT01a.z = (-1.0F) + (-0.5F) * 16F;
	    }//end attack
	    
	    //鬢毛調整
	    headX = this.Head.xRot * -0.5F;
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.xRot += angleX1 * 0.08F + headX;
	  	this.Hair02.xRot += -angleX2 * 0.08F + headX * 0.5F + 0.1F;
	  	this.Hair03.xRot += -angleX3 * 0.08F + headX * 0.5F + 0.1F;
	    this.Hair01.zRot += headZ;
	  	this.Hair02.zRot += headZ * 0.5F;
	  	this.Hair03.zRot += headZ * 0.5F;
		this.HairL01.xRot += angleX * 0.04F + headX;
	  	this.HairL02.xRot += angleX * 0.05F + headX * 0.8F;
	  	this.HairR01.xRot += angleX * 0.04F + headX;
	  	this.HairR02.xRot += angleX * 0.05F + headX * 0.8F;
	  	this.HairL01.zRot += headZ;
	  	this.HairL02.zRot += headZ;
	  	this.HairR01.zRot += headZ * 2.5F;
	  	this.HairR02.zRot += headZ * 0.8F;
	  	
	  	//swing arm
	  	float f6 = ent.getSwingTime(f2 - (int)f2);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight01.xRot += -f8 * 80.0F * Values.N.DIV_PI_180 - 0.3F;
	        this.ArmRight01.yRot += -f7 * 20.0F * Values.N.DIV_PI_180 + 0.4F;
	        this.ArmRight01.zRot += -f8 * 20.0F * Values.N.DIV_PI_180;
	  	}
	  	
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

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

public class ModelSubmRo500<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart Butt;
	public ModelPart Cloth01;
	public ModelPart EquipBase1;
	public ModelPart EquipBase2;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart FlowerBase;
	public ModelPart Ahoke;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart HairL02;
	public ModelPart HairR02;
	public ModelPart Hair01;
	public ModelPart Flower1;
	public ModelPart Flower2;
	public ModelPart Flower3;
	public ModelPart Flower4;
	public ModelPart ArmLeft02;
	public ModelPart ArmRight02;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart LegRight02;
	public ModelPart LegLeft02;
	public ModelPart Equip101;
	public ModelPart Equip102;
	public ModelPart Equip103;
	public ModelPart Equip104;
	public ModelPart Equip201;
	public ModelPart Equip202;
	public ModelPart Equip203;
	public ModelPart Equip204;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;
	protected float[] offsetItem2 = new float[] {-0.03F, 0.93F, 0.1F};

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -13.5F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("EquipBase1", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, 7.0F, 18.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("Equip101", CubeListBuilder.create().addBox(-15.0F, -2.5F, -2.5F, 36.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(0.0F, -6.0F, -9.5F, 0.5235987755982988F, 0.05235987755982988F, 0.13962634015954636F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("Equip103", CubeListBuilder.create().addBox(0.0F, -1.0F, -3.0F, 7.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(-22.0F, 0.0F, 0.0F, 0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef2.addOrReplaceChild("Equip104", CubeListBuilder.create().addBox(0.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F), PartPose.offset(21.0F, 0.0F, 0.0F));
		PartDefinition partdef5 = partdef2.addOrReplaceChild("Equip102", CubeListBuilder.create().addBox(0.0F, -3.0F, -1.0F, 7.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-22.0F, 0.0F, 0.0F, 0.7853981633974483F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 4.8F, -5.6F, 15.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("LegLeft01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F), PartPose.offsetAndRotation(4.2F, 11.0F, -2.2F, -0.12217304763960307F, 0.0F, -0.03490658503988659F));
		PartDefinition partdef8 = partdef7.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 14.0F, 6.0F), PartPose.offset(0.0F, 13.0F, -3.0F));
		PartDefinition partdef9 = partdef6.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 13.0F, 6.0F), PartPose.offsetAndRotation(-4.2F, 11.0F, -2.2F, -0.12217304763960307F, 0.0F, 0.03490658503988659F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 14.0F, 6.0F), PartPose.offset(0.0F, 13.0F, -3.0F));
		PartDefinition partdef11 = partdef0.addOrReplaceChild("EquipBase2", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 8.0F, -2.0F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("Equip204", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 24.0F, 6.0F, 6.0F), PartPose.offset(-9.0F, 0.0F, -14.0F));
		PartDefinition partdef13 = partdef11.addOrReplaceChild("Equip203", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 24.0F), PartPose.offsetAndRotation(9.0F, 6.0F, 16.0F, -3.141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef14 = partdef11.addOrReplaceChild("Equip202", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 24.0F, 6.0F, 6.0F), PartPose.offset(-15.0F, 0.0F, 10.0F));
		PartDefinition partdef15 = partdef11.addOrReplaceChild("Equip201", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 6.0F, 24.0F), PartPose.offset(-15.0F, 0.0F, -14.0F));
		PartDefinition partdef16 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-3.0F, -2.0F, -3.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -6.8F, 16.0F, 17.0F, 8.0F), PartPose.offset(0.0F, -7.5F, -0.5F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("HairR01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-6.5F, 0.0F, -4.0F, -0.17453292519943295F, 0.17453292519943295F, 0.13962634015954636F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("HairR02", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(0.2F, 6.0F, 0.0F, -0.17453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef21 = partdef18.addOrReplaceChild("HairL01", CubeListBuilder.create().mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(6.5F, 0.0F, -4.0F, -0.17453292519943295F, -0.17453292519943295F, -0.13962634015954636F));
		PartDefinition partdef22 = partdef21.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.17453292519943295F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef23 = partdef18.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -5.0F, -12.0F, 0.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -8.5F, -5.0F, 0.0F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef24 = partdef17.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 10.0F), PartPose.offset(0.0F, -15.0F, -3.0F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 18.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.1F, 0.3490658503988659F, 0.0F, 0.0F));
		PartDefinition partdef26 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-4.5F, -0.5F, -2.5F, 5.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(-6.0F, -9.0F, -0.5F, 0.15707963267948966F, 0.0F, 0.3839724354387525F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(-2.5F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F), PartPose.offset(-2.0F, 10.5F, 2.5F));
		PartDefinition partdef28 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-7.0F, 0.0F, -4.5F, 14.0F, 10.0F, 8.0F), PartPose.offset(0.0F, -11.3F, 0.0F));
		PartDefinition partdef29 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-0.5F, -0.5F, -2.5F, 5.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(6.0F, -9.0F, -0.5F, 0.15707963267948966F, 0.0F, -0.3839724354387525F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F), PartPose.offset(2.0F, 10.5F, 2.5F));
		PartDefinition partdef31 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -13.5F, 0.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef35 = partdef33.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef36 = partdef33.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef37 = partdef33.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef38 = partdef33.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef39 = partdef33.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef40 = partdef33.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef41 = partdef33.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef42 = partdef33.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef43 = partdef33.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));
		PartDefinition partdef44 = partdef33.addOrReplaceChild("FlowerBase", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(8.8F, -12.0F, -4.0F, -0.6981317007977318F, 0.08726646259971647F, -0.08726646259971647F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("Flower1", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.3089969389957472F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef46 = partdef44.addOrReplaceChild("Flower2", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.530727415391778F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef47 = partdef44.addOrReplaceChild("Flower3", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.6179938779914944F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef48 = partdef44.addOrReplaceChild("Flower4", CubeListBuilder.create().addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2217304763960306F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelSubmRo500(ModelPart root)
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
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.EquipBase1 = root.getChild("BodyMain").getChild("EquipBase1");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.Equip103 = root.getChild("BodyMain").getChild("EquipBase1").getChild("Equip101").getChild("Equip103");
		this.Equip204 = root.getChild("BodyMain").getChild("EquipBase2").getChild("Equip204");
		this.EquipBase2 = root.getChild("BodyMain").getChild("EquipBase2");
		this.Equip203 = root.getChild("BodyMain").getChild("EquipBase2").getChild("Equip203");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.BodyMain = root.getChild("BodyMain");
		this.Equip202 = root.getChild("BodyMain").getChild("EquipBase2").getChild("Equip202");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.Equip101 = root.getChild("BodyMain").getChild("EquipBase1").getChild("Equip101");
		this.Equip104 = root.getChild("BodyMain").getChild("EquipBase1").getChild("Equip101").getChild("Equip104");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.Flower1 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("FlowerBase").getChild("Flower1");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.Flower2 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("FlowerBase").getChild("Flower2");
		this.Flower3 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("FlowerBase").getChild("Flower3");
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.Equip201 = root.getChild("BodyMain").getChild("EquipBase2").getChild("Equip201");
		this.FlowerBase = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("FlowerBase");
		this.HairL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.HairR02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.Flower4 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead").getChild("FlowerBase").getChild("Flower4");
		this.Equip102 = root.getChild("BodyMain").getChild("EquipBase1").getChild("Equip101").getChild("Equip102");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.offsetItem = new float[] {-0.01F, 1.1F, -0.05F};
		this.offsetBlock = new float[] {-0.01F, 1.1F, -0.05F};
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
		
		boolean flag = !EmotionHelper.checkModelState(0, state);	//equip1
		this.EquipBase1.visible = !(flag);
				
		flag = !EmotionHelper.checkModelState(1, state);			//equip2
		this.EquipBase2.visible = !(flag);
		
		flag = !EmotionHelper.checkModelState(2, state);			//flower
		this.FlowerBase.visible = !(flag);
	
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

this.animTransX += (0F); this.animTransY += (0.55F + 0.29F * ent.getScaleLevel()); this.animTransZ += (0F);
    	this.setFaceHungry(ent);
    	
  	    //頭部
	  	this.Head.xRot = -0.35F;
	  	this.Head.yRot = 0F;
	  	//body
  	    this.Ahoke.yRot = 0.5236F;
  	    this.BodyMain.xRot = -1.6F;
	  	//hair
	  	this.Hair01.xRot = 0.3F;
	    //arm 
	  	this.ArmLeft01.xRot = 3.1F;
	  	this.ArmLeft01.yRot = 0F;
    	this.ArmLeft01.zRot = 0.7F;
		this.ArmRight01.xRot = 3.1F;
		this.ArmRight01.yRot = 0F;
    	this.ArmRight01.zRot = -0.7F;
    	this.ArmLeft02.xRot = 0F;
    	this.ArmRight02.xRot = 0F;
		//leg
    	this.LegLeft01.xRot = -0.2F;
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = -0.1F;
		this.LegRight01.xRot = -0.2F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = 0.1F;
		this.LegLeft02.xRot = 0F;
    	this.LegRight02.xRot = 0F;
    	//equip
    	this.EquipBase1.z = (18.0F) + (0F) * 16F;
    	this.EquipBase2.y = (8.0F) + (0F) * 16F;
    	this.EquipBase2.xRot = 0.3142F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F);
  		float angleX2 = Mth.cos(f2*0.25F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
  		float addk1 = 0;
  		float addk2 = 0;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//leg move parm
  		addk1 = angleAdd1 - 0.122F;
	  	addk2 = angleAdd2 - 0.122F;

  	    //移動頭部使其看人
	  	this.Head.xRot = f4 * 0.014F;
	  	this.Head.yRot = f3 * 0.01F;
	    
	    //正常站立動作
	  	//body
  	    this.Ahoke.yRot = angleX * 0.25F + 0.5236F;
	  	this.BodyMain.xRot = -0.1F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.06F + 0.3F;
	    this.Hair01.zRot = 0F;
		this.HairL01.xRot = -0.17F;
	  	this.HairL02.xRot = 0.17F;
	  	this.HairR01.xRot = -0.17F;
	  	this.HairR02.xRot = 0.17F;
	  	this.HairL01.zRot = -0.14F;
	  	this.HairL02.zRot = 0.08F;
	  	this.HairR01.zRot = 0.14F;
	  	this.HairR02.zRot = -0.05F;
	    //arm
		boolean flag = !EmotionHelper.checkModelState(1, ent.getStateEmotion(ID.S.State));
	  	this.ArmLeft01.xRot = 0.157F;
	  	this.ArmLeft01.yRot = 0F;
	  	this.ArmLeft01.zRot = -0.384F;
	  	if (flag) this.ArmLeft01.zRot += -angleX * 0.06F;
	    this.ArmRight01.xRot = 0.157F;
	    this.ArmRight01.yRot = 0F;
	    this.ArmRight01.zRot = 0.384F;
	    if (flag) this.ArmRight01.zRot += angleX * 0.06F;
    	this.ArmLeft02.xRot = 0F;
    	this.ArmRight02.xRot = 0F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = -0.035F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = 0.035F;
		this.LegLeft02.xRot = 0F;
    	this.LegRight02.xRot = 0F;
    	//equip
    	this.EquipBase1.z = (18.0F) + (0F) * 16F;
    	this.EquipBase2.y = (8.0F) + (0F) * 16F;
    	this.EquipBase2.xRot = 0.3142F;

	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {	//奔跑動作
	    	setFace(3);
	    	//Body
			this.BodyMain.xRot = 0.1745F;
			this.Head.xRot -= 0.35F;
			//leg move parm
	  		addk1 -= 0.25F;
		  	addk2 -= 0.25F;
		  	
	    	//change run type base on tickExisted
			if (ent.getTickExisted() % 256 > 128)
			{	//run type 1
				//arm 
				this.ArmLeft01.xRot = 2.6F;
		    	this.ArmLeft01.zRot = 0.7F;
				this.ArmRight01.xRot = 2.6F;
		    	this.ArmRight01.zRot = -0.7F;
			}
			else
			{	
			  	//arm 
			    this.ArmRight01.xRot = -2.8F;
		    	this.ArmRight01.zRot = -0.7F;
			}	
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {	//潛行, 蹲下動作
this.animTransX += (0F); this.animTransY += (0.1F); this.animTransZ += (0F);
	    	//body
	    	this.Head.xRot -= 0.8727F;
	    	this.BodyMain.xRot = 1.0472F;
		  	//hair
		  	this.Hair01.xRot += 0.2236F;
		  	//leg
		  	addk1 -= 1.2F;
		  	addk2 -= 1.2F;
  		}//end if sneaking
  		
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {  //騎乘動作
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
	    		if (((IFloatingEntity)ent).getEntityDepth() > 0)
	    		{
this.animTransX += (0F); this.animTransY += (-0.21F); this.animTransZ += (0F);
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.43F); this.animTransZ += (0F);
		    	}
		    	//body
		    	this.Head.xRot += 0.35F;
		    	this.BodyMain.xRot = -0.7F;
		    	//arm
		    	this.ArmLeft01.xRot = 0.5236F;
		    	this.ArmLeft01.zRot = -0.5236F;
		    	this.ArmLeft02.xRot = -1.0472F;
		    	this.ArmRight01.xRot = 0.7F;
		    	this.ArmRight01.zRot = 0.5236F;
		    	this.ArmRight02.xRot = -1.0472F;
		    	//leg
		    	addk1 = -1.9F;
		    	addk2 = -1.9F;
		    	this.LegLeft02.xRot = angleX2 * 0.4F + 0.8F;
		    	this.LegRight02.xRot = -angleX2 * 0.4F + 0.8F;
		    	//equip
		    	this.EquipBase1.z = (18.0F) + (-0.9F) * 16F;
		    	this.EquipBase2.visible = true;
		    	this.EquipBase2.xRot = 0.7F;
	    	}
	    	else
	    	{
	    		if(((IFloatingEntity)ent).getEntityDepth() > 0)
	    		{
this.animTransX += (0F); this.animTransY += (-0.22F); this.animTransZ += (0F);
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.41F); this.animTransZ += (0F);
		    	}	
		    	//body
		    	this.Head.xRot += 0.2F;
		    	this.BodyMain.xRot = -0.7F;
		    	//arm
		    	this.ArmLeft01.xRot = 0.95F;
		    	this.ArmLeft01.zRot = -0.3146F;
		    	this.ArmRight01.xRot = 0.95F;
		    	this.ArmRight01.zRot = 0.3146F;
		    	//leg
		    	addk1 = -1.1F;
		    	addk2 = -1.1F;
		    	this.LegLeft01.yRot = -0.3491F;
		    	this.LegRight01.yRot = 0.3491F;
		    	//equip
		    	this.EquipBase1.z = (18.0F) + (-0.15F) * 16F;
		    	this.EquipBase2.y = (8.0F) + (-0.15F) * 16F;
	    	}    	
  		}//end if sitting
	    
	    //攻擊動作
	    if (ent.getAttackTick() > 41)
	    {
	    	setFace(3);
	    	//swing arm
		    float ft = (50 - ent.getAttackTick()) + (f2 - (int)f2);
		    ft *= 0.125F;
	  		float fa = Mth.sin(ft * ft * (float)Math.PI);
	        float fb = Mth.sin(Mth.sqrt(ft) * (float)Math.PI);
	        this.ArmLeft01.xRot += -fb * 180.0F * Values.N.DIV_PI_180 + 0.1F;
	        this.ArmLeft01.yRot += fa * 20.0F * Values.N.DIV_PI_180 - 0.6F;
	        this.ArmLeft01.zRot += fb * 20.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.xRot += -fb * 180.0F * Values.N.DIV_PI_180 + 0.1F;
	        this.ArmRight01.yRot += -fa * 20.0F * Values.N.DIV_PI_180 + 0.6F;
	        this.ArmRight01.zRot += -fb * 20.0F * Values.N.DIV_PI_180;
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
	    
	    //leg motion
	    this.LegLeft01.xRot = addk1;
	    this.LegRight01.xRot = addk2;
	
	}

	public float[] getHeldItemOffset(IShipEmotion ent, HumanoidArm side, int type)
	{

		if (ent.getIsSprinting())
		{
			return this.offsetItem2;
		}
		
    	return this.offsetItem;
    
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
    		scale = 1.44F;
        	offsetY = -0.45F;
		break;
    	case 2:
    		scale = 1.08F;
        	offsetY = -0.06F;
		break;
    	case 1:
    		scale = 0.72F;
        	offsetY = 0.66F;
		break;
    	default:
    		scale = 0.36F;
        	offsetY = 2.86F;
		break;
    	}
    	
    	
    	RenderHelper.animScale(this, scale, scale * 0.95F, scale);
this.animTransX += (0F); this.animTransY += (offsetY); this.animTransZ += (0F);
    	
    	//main body
		super.setupAnim(entity, f, f1, f2, f3, f4);
	}

}

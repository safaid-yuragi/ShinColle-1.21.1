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

public class ModelBattleshipHime<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart Butt;
	public ModelPart Cloth01;
	public ModelPart Head;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart HeadHL;
	public ModelPart HeadHR;
	public ModelPart Ahoke;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart HairL02;
	public ModelPart HairL03;
	public ModelPart HairR02;
	public ModelPart HairR03;
	public ModelPart Hair01;
	public ModelPart Hair02;
	public ModelPart Hair03;
	public ModelPart ArmLeft02;
	public ModelPart ArmRight02;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart LegRight02;
	public ModelPart ClothR02;
	public ModelPart ClothR03;
	public ModelPart LegLeft02;
	public ModelPart ClothL02;
	public ModelPart ClothL03;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeck;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-3.7F, -9.0F, -3.5F, -0.6981317007977318F, -0.13962634015954636F, -0.08726646259971647F));
		PartDefinition partdef2 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.3F, -0.7F, 0.0F, 0.0F, -0.20943951023931953F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-5F, 0F, -5F, 5.0F, 13.0F, 5.0F), PartPose.offset(3F, 11.0F, 2.5F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(3.7F, -9.0F, -3.5F, -0.6981317007977318F, 0.13962634015954636F, 0.08726646259971647F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 4.0F, -5.5F, 15.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(4.5F, 9.5F, -2.7F, -0.20943951023931953F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("ClothL02", CubeListBuilder.create().addBox(-4.4F, 0.0F, -3.7F, 8.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef8 = partdef6.addOrReplaceChild("ClothL03", CubeListBuilder.create().addBox(-4.5F, 0.0F, -3.8F, 9.0F, 5.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 1.5F, 0.1F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef6.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(0.0F, 14.0F, -3.0F));
		PartDefinition partdef10 = partdef5.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(-4.5F, 9.5F, -2.7F, -0.20943951023931953F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("ClothR02", CubeListBuilder.create().addBox(-3.6F, 0.0F, -3.7F, 8.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef10.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 15.0F, 6.0F), PartPose.offset(0.0F, 14.0F, -3.0F));
		PartDefinition partdef13 = partdef10.addOrReplaceChild("ClothR03", CubeListBuilder.create().addBox(-4.5F, 0.0F, -3.8F, 9.0F, 5.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 1.5F, 0.1F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef14 = partdef0.addOrReplaceChild("Cloth01", CubeListBuilder.create().addBox(-7.0F, 0.0F, -4.5F, 14.0F, 5.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-4.5F, -2.0F, -4.0F, 9.0F, 1.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -10.0F, -0.5F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.2F, 16.0F, 17.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.0F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("HairR01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(-6.5F, 0.0F, -5.0F, -0.13962634015954636F, 0.17453292519943295F, 0.13962634015954636F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("HairR02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 3.0F), PartPose.offsetAndRotation(0.2F, 10.0F, 0.0F, 0.08726646259971647F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("HairR03", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 0.13962634015954636F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef21 = partdef17.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(-2.0F, 0.0F, 0.0F, 10.0F, 12.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -5.3F, -7.2F, -0.05235987755982988F, 0.0F, -0.03490658503988659F));
		PartDefinition partdef22 = partdef17.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(6.5F, 0.0F, -5.0F, -0.13962634015954636F, -0.17453292519943295F, -0.13962634015954636F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 12.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.05235987755982988F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("HairL03", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 0.13962634015954636F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef25 = partdef16.addOrReplaceChild("HeadHL", CubeListBuilder.create().mirror().addBox(-1.0F, -9.0F, -1.0F, 2.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(3.5F, -7.5F, -3.3F, 0.6981317007977318F, 0.0F, 0.13962634015954636F));
		PartDefinition partdef26 = partdef16.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 10.0F), PartPose.offset(0.0F, -15.0F, -3.0F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 17.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.0F, 0.17453292519943295F, 0.0F, 0.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("Hair02", CubeListBuilder.create().addBox(-8.0F, 0.0F, -5.0F, 16.0F, 15.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 5.7F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("Hair03", CubeListBuilder.create().addBox(-8.0F, 0.0F, -5.5F, 16.0F, 13.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 0.2F, -0.08970992355250852F, 0.0F, 0.016231562043547264F));
		PartDefinition partdef30 = partdef16.addOrReplaceChild("HeadHR", CubeListBuilder.create().addBox(-1.0F, -9.0F, -1.0F, 2.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(-3.5F, -7.5F, -3.3F, 0.6981317007977318F, 0.0F, -0.13962634015954636F));
		PartDefinition partdef31 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 12.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.3F, -0.7F, 0.10471975511965977F, 0.0F, 0.20943951023931953F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0F, 0F, -5F, 5.0F, 13.0F, 5.0F), PartPose.offset(-3F, 11.0F, 2.5F));
		PartDefinition partdef33 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, -0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef34 = partdef33.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.0F, -0.5F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef37 = partdef35.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef38 = partdef35.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef39 = partdef35.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef40 = partdef35.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef41 = partdef35.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef42 = partdef35.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef43 = partdef35.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef44 = partdef35.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef45 = partdef35.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelBattleshipHime(ModelPart root)
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
		this.HairL02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.HairR02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.ClothR02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("ClothR02");
		this.ClothL02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("ClothL02");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.Hair02 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02");
		this.Hair = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair");
		this.HeadHL = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadHL");
		this.BodyMain = root.getChild("BodyMain");
		this.Hair03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01").getChild("Hair02").getChild("Hair03");
		this.Head = root.getChild("BodyMain").getChild("Neck").getChild("Head");
		this.ClothL03 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("ClothL03");
		this.Hair01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.HairR01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.HairMain = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HairMain");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.HairL03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02").getChild("HairL03");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.HairR03 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02").getChild("HairR03");
		this.Cloth01 = root.getChild("BodyMain").getChild("Cloth01");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.Ahoke = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.ClothR03 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("ClothR03");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.HeadHR = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("HeadHR");
		this.HairL01 = root.getChild("BodyMain").getChild("Neck").getChild("Head").getChild("Hair").getChild("HairL01");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead");
		this.scale = 0.5F;
		this.offsetY = 0F;
		this.offsetItem = new float[] {0.08F, 0.43F, -0.08F};
		this.offsetBlock = new float[] {0.08F, 0.43F, -0.08F};
		armMain = new ModelPart[] {this.BodyMain, this.ArmRight01, this.ArmRight02};
		armOff = new ModelPart[] {this.BodyMain, this.ArmLeft01, this.ArmLeft02};
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

	public void showEquip(IShipEmotion ent)
	{

	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

    	float addk1 = 0F;
  		float addk2 = 0F;
  		float headX = 0F;
  		float headZ = 0F;
  		
this.animTransX += (0F); this.animTransY += (1.05F); this.animTransZ += (0F);
  		this.setFaceHungry(ent);
  		
  		//移動頭部使其看人
	  	this.Head.xRot = 0F; 	//上下角度
	  	this.Head.yRot = 0F;	//左右角度 角度轉成rad 即除以57.29578
	  	this.Head.zRot = 0F;
	    //正常站立動作
	    //胸部
  	    this.BoobL.xRot = -0.7F;
  	    this.BoobR.xRot = -0.7F;
	  	//Body
	  	this.BodyMain.zRot = 0F;
	  	//hair
	  	this.Hair01.xRot = 0.26F;
	  	this.Hair02.xRot = -0.08F;
	  	this.Hair03.xRot = -0.14F;
	    //arm 
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.x = (3F) + (0F) * 16F;
	    this.ArmLeft02.y = (11.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.x = (-3F) + (0F) * 16F;
		this.ArmRight02.y = (11.0F) + (0F) * 16F;
	    this.ArmRight02.z = (2.5F) + (0F) * 16F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegRight01.yRot = 0F;
		
    	//Body
    	this.Head.xRot += 0.14F;
	  	this.BodyMain.xRot = 0.4F;
	  	this.Butt.xRot = -0.4F;
	  	this.Butt.z = (0.0F) + (0.19F) * 16F;
	  	this.BoobL.xRot -= 0.2F;
	  	this.BoobR.xRot -= 0.2F;
	    //arm 
	  	this.ArmLeft01.xRot = -1.3F;
	    this.ArmLeft01.zRot = -0.1F;
	    this.ArmLeft02.zRot = 1.15F;
		this.ArmRight01.xRot = -1.3F;
		this.ArmRight01.zRot = 0.1F;
		this.ArmRight02.zRot = -1.4F;
		//leg
		addk1 = -2.1232F;
		addk2 = -2.0708F;
		this.LegLeft01.zRot = -0.2F;
		this.LegLeft02.xRot = 1.34F;
		this.LegRight01.zRot = 0.2F;
		this.LegRight02.xRot = 1.13F;
		//hair
		this.Hair01.xRot -= 0.2F;
		this.Hair02.xRot -= 0.2F;
		this.Hair03.xRot -= 0.1F;
		
		//移動頭髮避免穿過身體
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.zRot = headZ;
	  	this.Hair02.zRot = headZ;
	  	this.HairL01.zRot = headZ - 0.0F;
	  	this.HairL02.zRot = headZ + 0.087F;
	  	this.HairR01.zRot = headZ + 0.0F;
	  	this.HairR02.zRot = headZ - 0.052F;
	  	
	    headX = this.Head.xRot * -0.5F;
	    this.HairL01.xRot = headX - 0.1F;
	  	this.HairL02.xRot = headX - 0.3F;
	  	this.HairL03.xRot = headX - 0.0F;
	  	this.HairR01.xRot = headX - 0.1F;
	  	this.HairR02.xRot = headX - 0.3F;
	  	this.HairR03.xRot = headX - 0.0F;
	  	
	    //leg motion
	    this.LegLeft01.xRot = addk1;
	    this.LegRight01.xRot = addk2;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F);
  		float angleX1 = Mth.cos(f2*0.08F + 0.3F + f * 0.5F);
  		float angleX2 = Mth.cos(f2*0.08F + 0.6F + f * 0.5F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1 * 0.7F;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.7F;
  		float addk1 = 0F;
  		float addk2 = 0F;
  		float headX = 0F;
  		float headZ = 0F;
  		
this.animTransX += (0F); this.animTransY += (0.5F); this.animTransZ += (0F);
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D || ent.getShipDepth(1) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//leg move parm
  		addk1 = angleAdd1 - 0.122F;
	  	addk2 = angleAdd2 - 0.174F;

  	    //移動頭部使其看人
	  	this.Head.xRot = f4 * 0.014F + 0.05F; 	//上下角度
	  	this.Head.yRot = f3 * 0.01F;
	    //正常站立動作
	    //胸部
  	    this.BoobL.xRot = angleX * 0.06F - 0.7F;
  	    this.BoobR.xRot = angleX * 0.06F - 0.7F;
	  	//Body
  	    this.Ahoke.zRot = angleX * 0.02F - 0.02F;
  	    this.BodyMain.xRot = -0.1F;
	  	this.Butt.xRot = 0.2618F;
	  	this.Butt.z = (0.0F) + (0F) * 16F;
	  	//hair
	  	this.Hair01.xRot = angleX * 0.03F + 0.15F;
	  	this.Hair02.xRot = -angleX1 * 0.04F - 0.05F;
	  	this.Hair03.xRot = -angleX2 * 0.07F - 0.08F;
	  	this.Hair01.zRot = 0F;
	  	this.Hair02.zRot = 0F;
	  	this.Hair03.zRot = 0F;
	  	this.HairL01.xRot = angleX * 0.02F - 0.14F;
	  	this.HairL02.xRot = -angleX1 * 0.04F + 0.08F;
	  	this.HairL03.xRot = -angleX2 * 0.07F + 0.1F;
	  	this.HairR01.xRot = angleX * 0.02F - 0.14F;
	  	this.HairR02.xRot = -angleX1 * 0.04F + 0.08F;
	  	this.HairR03.xRot = -angleX2 * 0.07F + 0.1F;
	  	this.HairL01.zRot = -0.14F;
	  	this.HairL02.zRot = 0.087F;
	  	this.HairL03.zRot = 0.087F;
	  	this.HairR01.zRot = 0.14F;
	  	this.HairR02.zRot = -0.06F;
	  	this.HairR03.zRot = -0.06F;
	    //arm 
	  	this.ArmLeft01.xRot = angleAdd2 * 0.8F;
	    this.ArmLeft01.zRot = angleX * 0.08F - 0.2F;
	    this.ArmLeft02.xRot = 0F;
	    this.ArmLeft02.zRot = 0F;
	    this.ArmLeft02.x = (3F) + (0F) * 16F;
	    this.ArmLeft02.y = (11.0F) + (0F) * 16F;
	    this.ArmLeft02.z = (2.5F) + (0F) * 16F;
	    this.ArmRight01.xRot = angleAdd1 * 0.8F + 0.1745F;
		this.ArmRight01.zRot = -angleX * 0.08F + 0.2F;
		this.ArmRight02.xRot = 0F;
		this.ArmRight02.yRot = 0F;
		this.ArmRight02.zRot = 0F;
		this.ArmRight02.x = (-3F) + (0F) * 16F;
	    this.ArmRight02.y = (11.0F) + (0F) * 16F;
	    this.ArmRight02.z = (2.5F) + (0F) * 16F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.087F;
		this.LegLeft02.xRot = 0F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.087F;
		this.LegRight02.xRot = 0F;

		//奔跑動作
	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {
	    	//沒有特殊跑步動作
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    //潛行, 蹲下動作
	    if (ent.getIsSneaking())
	    {
this.animTransX += (0F); this.animTransY += (0.08F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 0.6283F;
		  	this.BodyMain.xRot = 0.8727F;
		    //arm 
		  	this.ArmLeft01.xRot = -0.35F;
		    this.ArmLeft01.zRot = 0.2618F;
			this.ArmRight01.xRot = -0.35F;
			this.ArmRight01.zRot = -0.2618F;
			//leg
			addk1 -= 0.88F;
			addk2 -= 0.88F;
			//hair
			this.Hair01.xRot += 0.37F;
			this.Hair02.xRot += 0.23F;
			this.Hair03.xRot -= 0.1F;
  		}//end if sneaking
  		
	    //騎乘動作 
	    if (ent.getIsSitting() && !ent.getIsRiding())
	    {
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
this.animTransX += (0F); this.animTransY += (0.65F); this.animTransZ += (0F);
		    	//Body
		    	this.Head.xRot = -1.2217F;
		    	this.Head.yRot = this.Head.yRot * 0.5F;
			  	this.BodyMain.xRot = 1.2217F;
			    //arm 
			  	this.ArmLeft01.xRot = -1.9199F;
			  	this.ArmLeft01.zRot = -0.1745F;
			    this.ArmLeft02.xRot = -2.31F;
			    this.ArmLeft02.y = (11.0F) + (0.22F) * 16F;
			    this.ArmLeft02.z = (2.5F) + (-0.21F) * 16F;
				this.ArmRight01.xRot = -1.9199F;
				this.ArmRight01.zRot = 0.1745F;
				this.ArmRight02.xRot = -2.31F;
				this.ArmRight02.y = (11.0F) + (0.22F) * 16F;
			    this.ArmRight02.z = (2.5F) + (-0.21F) * 16F;
				//leg
				addk1 = 0F;
				addk2 = 0F;
				this.LegLeft02.xRot = angleX * 0.4F + 1F;
				this.LegRight02.xRot = -angleX * 0.4F + 1F;
				//hair
				this.Hair01.xRot += 0.1F;
				this.Hair02.xRot += 0.05F;
				this.HairL01.xRot -= 0.3F;
				this.HairR01.xRot -= 0.3F;
				this.HairL02.xRot += 0.3F;
				this.HairR02.xRot += 0.3F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.33F); this.animTransZ += (0F);
		    	//Body
		    	this.Head.xRot += 0.14F;
			  	this.BodyMain.xRot = -0.4363F;
			  	this.BoobL.xRot -= 0.25F;
			  	this.BoobR.xRot -= 0.25F;
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
				this.LegLeft02.xRot = 1.0472F;
				this.LegRight01.yRot = -0.35F;
				this.LegRight01.zRot = -0.2618F;
				this.LegRight02.xRot = 0.9F;
				//hair
				this.Hair01.xRot += 0.12F;
				this.Hair02.xRot += 0.15F;
				this.Hair03.xRot += 0.25F;
	    	}
  		}//end sitting
	    
	    if (ent.getIsRiding())
	    {
	    	if (((Entity) ent).getVehicle() instanceof BasicEntityMount)
	    	{
	    		if (ent.getIsSitting())
	    		{
		    		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		    		{
this.animTransX += (0F); this.animTransY += (0.68F); this.animTransZ += (-0.05F);
				    	//Body
				    	this.Head.xRot = -1.2217F;
				    	this.Head.yRot = this.Head.yRot / 2F;
					  	this.BodyMain.xRot = 1.2217F;
					  	//arm 
					  	this.ArmLeft01.xRot = -1.9199F;
					  	this.ArmLeft01.zRot = -0.1745F;
					    this.ArmLeft02.xRot = -2.31F;
					    this.ArmLeft02.y = (11.0F) + (0.22F) * 16F;
					    this.ArmLeft02.z = (2.5F) + (-0.21F) * 16F;
						this.ArmRight01.xRot = -1.9199F;
						this.ArmRight01.zRot = 0.1745F;
						this.ArmRight02.xRot = -2.31F;
						this.ArmRight02.y = (11.0F) + (0.22F) * 16F;
					    this.ArmRight02.z = (2.5F) + (-0.21F) * 16F;
					    //leg
						addk1 = 0F;
						addk2 = 0F;
						this.LegLeft02.xRot = angleX * 0.4F + 1F;
						this.LegRight02.xRot = -angleX * 0.4F + 1F;
						//hair
						this.Hair01.xRot += 0.1F;
						this.Hair02.xRot += 0.05F;
						this.HairL01.xRot -= 0.3F;
						this.HairR01.xRot -= 0.3F;
						this.HairL02.xRot += 0.3F;
						this.HairR02.xRot += 0.3F;
			    	}
			    	else
			    	{
this.animTransX += (0F); this.animTransY += (0.51F); this.animTransZ += (-0.05F);
			    		//Body
				    	this.Head.xRot += 0.14F;
					  	this.BodyMain.xRot = -0.4363F;
					  	this.BoobL.xRot -= 0.25F;
					  	this.BoobR.xRot -= 0.25F;
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
						this.LegLeft02.xRot = 1.0472F;
						this.LegRight01.yRot = -0.35F;
						this.LegRight01.zRot = -0.2618F;
						this.LegRight02.xRot = 0.9F;
						//hair
						this.Hair01.xRot += 0.12F;
						this.Hair02.xRot += 0.15F;
						this.Hair03.xRot += 0.25F;
			    	}
		    	}//end if sitting
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.17F); this.animTransZ += (0F);
			    	//Body
			    	this.Head.xRot += 0.1745F;
				  	this.BodyMain.xRot = -0.35F;
				    //arm
				  	this.ArmLeft01.xRot = -0.2F;
				    this.ArmLeft01.zRot = 0.3490F;
				    this.ArmLeft02.zRot = 1.15F;
					this.ArmRight01.xRot = -0.3F;
					this.ArmRight01.zRot = -0.2793F;
					this.ArmRight02.zRot = -1.4F;
					//leg
					addk1 = 0.1745F;
					addk2 = -0.8727F;
					this.LegLeft01.zRot = -0.1F;
					this.LegRight01.zRot = 0.1F;
					this.LegRight02.xRot = 1.0472F;
					//hair
					this.Hair01.xRot += 0.12F;
					this.Hair02.xRot += 0.22F;
					this.Hair03.xRot += 0.25F;    		
		    	}
	    	}//end ship mount
	    	else
	    	{	//normal mount ex: cart
	    		if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    		{
this.animTransX += (0F); this.animTransY += (1.3F); this.animTransZ += (0F);
			    	//Body
			    	this.Head.xRot = -1.2217F;
			    	this.Head.yRot = this.Head.yRot / 2F;
				  	this.BodyMain.xRot = 1.2217F;
				  	//arm 
				  	this.ArmLeft01.xRot = -1.9199F;
				  	this.ArmLeft01.zRot = -0.1745F;
				    this.ArmLeft02.xRot = -2.31F;
				    this.ArmLeft02.y = (11.0F) + (0.22F) * 16F;
				    this.ArmLeft02.z = (2.5F) + (-0.21F) * 16F;
					this.ArmRight01.xRot = -1.9199F;
					this.ArmRight01.zRot = 0.1745F;
					this.ArmRight02.xRot = -2.31F;
					this.ArmRight02.y = (11.0F) + (0.22F) * 16F;
				    this.ArmRight02.z = (2.5F) + (-0.21F) * 16F;
				    //leg
					addk1 = 0F;
					addk2 = 0F;
					this.LegLeft02.xRot = angleX * 0.4F + 1F;
					this.LegRight02.xRot = -angleX * 0.4F + 1F;
					//hair
					this.Hair01.xRot += 0.1F;
					this.Hair02.xRot += 0.05F;
					this.HairL01.xRot -= 0.3F;
					this.HairR01.xRot -= 0.3F;
					this.HairL02.xRot += 0.3F;
					this.HairR02.xRot += 0.3F;
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.8F); this.animTransZ += (0F);
			    	//Body
			    	this.Head.xRot += 0.14F;
				  	this.BodyMain.xRot = -0.4363F;
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
					this.LegLeft02.xRot = 1.0472F;
					this.LegRight01.yRot = -0.35F;
					this.LegRight01.zRot = -0.2618F;
					this.LegRight02.xRot = 0.9F;
					//hair
					this.Hair01.xRot += 0.12F;
					this.Hair02.xRot += 0.15F;
					this.Hair03.xRot += 0.25F;
		    	}
	    	}
	    }//end ridding
    
	    //攻擊動作    
	    if (ent.getAttackTick() > 20)
	    {
	    	//arm
		  	this.ArmLeft01.xRot = -1.6F;
		  	this.ArmLeft01.yRot = 0F;
		    this.ArmLeft01.zRot = 0.21F;
		    this.ArmLeft02.xRot = 0F;
		    this.ArmLeft02.zRot = 0F;
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
	        this.ArmRight02.xRot = 0F;
	        this.ArmRight02.yRot = 0F;
	        this.ArmRight02.zRot = 0F;
	  	}
	  	
	  	//鬢毛調整
	    headX = this.Head.xRot * -0.5F;
	    headZ = this.Head.zRot * -0.5F;
	    this.Hair01.xRot += headX;
	    this.Hair01.zRot += headZ;
	    this.Hair02.xRot += headX * 0.5F;
	    this.Hair02.zRot += headZ * 0.5F;
	    this.Hair03.xRot += headX * 0.5F;
	    this.Hair03.zRot += headZ * 0.5F;
		this.HairL01.xRot += headX;
	  	this.HairL02.xRot += headX * 0.5F;
	  	this.HairL03.xRot += headX * 0.5F;
	  	this.HairR01.xRot += headX;
	  	this.HairR02.xRot += headX * 0.5F;
	  	this.HairR03.xRot += headX * 0.5F;
	  	this.HairL01.zRot += headZ;
	  	this.HairL02.zRot += headZ * 0.5F;
	  	this.HairL03.zRot += headZ * 0.5F;
	  	this.HairR01.zRot += headZ;
	  	this.HairR02.zRot += headZ * 0.5F;
	  	this.HairR03.zRot += headZ * 0.5F;
	    
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

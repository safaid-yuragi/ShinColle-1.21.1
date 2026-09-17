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

public class ModelBattleshipTa<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart NeckCloth;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart Butt;
	public ModelPart EquipLeft;
	public ModelPart EquipRight;
	public ModelPart Cloak01;
	public ModelPart Head;
	public ModelPart NeckTie;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart Ahoke;
	public ModelPart HairL01;
	public ModelPart HairR01;
	public ModelPart HairL02;
	public ModelPart HairR02;
	public ModelPart HairMidL01;
	public ModelPart HairMidL02;
	public ModelPart ArmLeft02;
	public ModelPart ArmRight02;
	public ModelPart LegRight;
	public ModelPart LegLeft;
	public ModelPart ShoesR;
	public ModelPart ShoesL;
	public ModelPart Cloak02;
	public ModelPart Cloak03;
	public ModelPart Cloak04;
	public ModelPart Cloak05;
	public ModelPart GlowBodyMain;
	public ModelPart GlowNeckCloth;
	public ModelPart GlowHead;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 17.0F, 7.0F), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F), PartPose.offsetAndRotation(-7.0F, -10.5F, 0.0F, 0.0F, 0.0F, 0.15707963267948966F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 13.0F, 5.0F), PartPose.offset(0.0F, 9.0F, 0.0F));
		PartDefinition partdef3 = partdef0.addOrReplaceChild("EquipLeft", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 14.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(9.0F, -13.0F, -6.0F, 0.0F, -0.13962634015954636F, 0.2617993877991494F));
		PartDefinition partdef4 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(-3.8F, -9.0F, -3.5F, -0.7853981633974483F, -0.17453292519943295F, -0.08726646259971647F));
		PartDefinition partdef5 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-8.0F, 4.0F, -5.5F, 16.0F, 8.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef5.addOrReplaceChild("LegRight", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F), PartPose.offsetAndRotation(-4.5F, 9.5F, -3.0F, -0.2617993877991494F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("ShoesR", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 19.0F, 7.0F), PartPose.offset(0.0F, 7.0F, -0.2F));
		PartDefinition partdef8 = partdef5.addOrReplaceChild("LegLeft", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F), PartPose.offsetAndRotation(4.5F, 9.5F, -3.0F, -0.2617993877991494F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("ShoesL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 19.0F, 7.0F), PartPose.offset(0.0F, 7.0F, -0.2F));
		PartDefinition partdef10 = partdef0.addOrReplaceChild("NeckCloth", CubeListBuilder.create().addBox(-7.5F, -1.5F, -4.5F, 15.0F, 12.0F, 8.0F), PartPose.offset(0.0F, -10.0F, 0.0F));
		PartDefinition partdef11 = partdef10.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offset(0.0F, -1.5F, 0.0F));
		PartDefinition partdef12 = partdef11.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 10.0F), PartPose.offset(0.0F, -15.0F, -3.0F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("HairMidL01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 13.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.5F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef14 = partdef13.addOrReplaceChild("HairMidL02", CubeListBuilder.create().addBox(-7.0F, 0.0F, 0.0F, 14.0F, 14.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 1.8F, -0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef11.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.2F, 16.0F, 17.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.0F));
		PartDefinition partdef16 = partdef15.addOrReplaceChild("HairL01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(6.5F, 0.0F, -6.0F, -0.17453292519943295F, -0.17453292519943295F, -0.05235987755982988F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("HairL02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 9F, 0.0F, 0.2617993877991494F, 0.0F, 0.05235987755982988F));
		PartDefinition partdef18 = partdef15.addOrReplaceChild("HairR01", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-6.5F, 0.0F, -6.0F, -0.13962634015954636F, 0.17453292519943295F, 0.08726646259971647F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("HairR02", CubeListBuilder.create().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(0.2F, 7F, 0.5F, 0.17453292519943295F, 0.0F, -0.05235987755982988F));
		PartDefinition partdef20 = partdef15.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(-4.5F, 0.0F, 0.0F, 10.0F, 10.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -7.3F, -7.5F, -0.136659280431156F, -0.22759093446006054F, 0.0F));
		PartDefinition partdef21 = partdef10.addOrReplaceChild("NeckTie", CubeListBuilder.create().addBox(-3.0F, 0.0F, 0.0F, 6.0F, 7.0F, 0.0F), PartPose.offsetAndRotation(0.5F, 1.3F, -5.2F, -0.7F, 0.13962634015954636F, 0.13962634015954636F));
		PartDefinition partdef22 = partdef0.addOrReplaceChild("Cloak01", CubeListBuilder.create().addBox(-11.5F, 0.0F, 0.0F, 23.0F, 5.0F, 10.0F), PartPose.offset(0.0F, -10.0F, -4.4F));
		PartDefinition partdef23 = partdef22.addOrReplaceChild("Cloak02", CubeListBuilder.create().addBox(-12.0F, 0.0F, 0.0F, 24.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 0.3F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("Cloak03", CubeListBuilder.create().addBox(-12.5F, 0.0F, 0.0F, 25.0F, 7.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 0.3F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("Cloak04", CubeListBuilder.create().addBox(-13.5F, 0.0F, 0.0F, 27.0F, 8.0F, 11.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef26 = partdef25.addOrReplaceChild("Cloak05", CubeListBuilder.create().addBox(-14.5F, 0.0F, 0.0F, 29.0F, 9.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef27 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F), PartPose.offsetAndRotation(7.0F, -10.5F, 0.0F, 0.0F, 0.0F, -0.15707963267948966F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 13.0F, 5.0F), PartPose.offset(0.0F, 9.0F, 0.0F));
		PartDefinition partdef29 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3.5F, 0.0F, 0.0F, 7.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(3.8F, -9.0F, -3.5F, -0.7853981633974483F, 0.17453292519943295F, 0.08726646259971647F));
		PartDefinition partdef30 = partdef0.addOrReplaceChild("EquipRight", CubeListBuilder.create().addBox(-12.0F, 0.0F, 0.0F, 12.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(-9.0F, -12.0F, -2.0F, 0.0F, 0.13962634015954636F, -0.17453292519943295F));
		PartDefinition partdef31 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("GlowNeckCloth", CubeListBuilder.create(), PartPose.offset(0.0F, -10.0F, 0.0F));
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

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	public ModelBattleshipTa(ModelPart root)
	{
		this.Face0 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Face0");
		this.Face1 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Face1");
		this.Face2 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Face2");
		this.Face3 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Face3");
		this.Face4 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Face4");
		this.Mouth0 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Mouth0");
		this.Mouth1 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Mouth1");
		this.Mouth2 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Mouth2");
		this.Flush0 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Flush0");
		this.Flush1 = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead").getChild("Flush1");
		this.HairL01 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("Hair").getChild("HairL01");
		this.HairR02 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("Hair").getChild("HairR01").getChild("HairR02");
		this.BodyMain = root.getChild("BodyMain");
		this.HairMidL01 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("HairMain").getChild("HairMidL01");
		this.Head = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head");
		this.HairL02 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("Hair").getChild("HairL01").getChild("HairL02");
		this.HairMain = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("HairMain");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.LegRight = root.getChild("BodyMain").getChild("Butt").getChild("LegRight");
		this.EquipLeft = root.getChild("BodyMain").getChild("EquipLeft");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.ShoesR = root.getChild("BodyMain").getChild("Butt").getChild("LegRight").getChild("ShoesR");
		this.HairR01 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("Hair").getChild("HairR01");
		this.NeckCloth = root.getChild("BodyMain").getChild("NeckCloth");
		this.Cloak01 = root.getChild("BodyMain").getChild("Cloak01");
		this.LegLeft = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft");
		this.Cloak02 = root.getChild("BodyMain").getChild("Cloak01").getChild("Cloak02");
		this.ShoesL = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft").getChild("ShoesL");
		this.Cloak05 = root.getChild("BodyMain").getChild("Cloak01").getChild("Cloak02").getChild("Cloak03").getChild("Cloak04").getChild("Cloak05");
		this.NeckTie = root.getChild("BodyMain").getChild("NeckCloth").getChild("NeckTie");
		this.Cloak03 = root.getChild("BodyMain").getChild("Cloak01").getChild("Cloak02").getChild("Cloak03");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.HairMidL02 = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("HairMain").getChild("HairMidL01").getChild("HairMidL02");
		this.Hair = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("Hair");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.Ahoke = root.getChild("BodyMain").getChild("NeckCloth").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.Cloak04 = root.getChild("BodyMain").getChild("Cloak01").getChild("Cloak02").getChild("Cloak03").getChild("Cloak04");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.EquipRight = root.getChild("BodyMain").getChild("EquipRight");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeckCloth = root.getChild("GlowBodyMain").getChild("GlowNeckCloth");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowNeckCloth").getChild("GlowHead");
		this.scale = 0.46F;
		this.offsetY = 1.78F;
		this.offsetItem = new float[] {-0.04F, 0.98F, 0.07F};
		this.offsetBlock = new float[] {-0.04F, 0.98F, 0.07F};
		this.rotateItem = new float[] {0F, 0F, -180F};
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
		
		boolean flag = !EmotionHelper.checkModelState(1, state);
		this.Cloak01.visible = !(flag);
				
		flag = !EmotionHelper.checkModelState(2, state);
		this.EquipLeft.visible = !(flag);
		this.EquipRight.visible = !(flag);
	
	}

	public void syncRotationGlowPart()
	{

		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowNeckCloth.xRot = this.NeckCloth.xRot;
		this.GlowNeckCloth.yRot = this.NeckCloth.yRot;
		this.GlowNeckCloth.zRot = this.NeckCloth.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (0.62F); this.animTransZ += (0F);
    	this.setFaceHungry(ent);
    
    	//頭部
	  	this.Head.xRot = 0F;
	  	this.Head.yRot = 0F;
	    //胸部
  	    this.BoobL.xRot = -0.7854F;
  	    this.BoobR.xRot = -0.7854F;
  	    this.NeckTie.xRot = -0.7F;
	  	//Body
  	    this.Ahoke.zRot = -0.06F;
	    //arm 
	  	this.ArmLeft01.yRot = 0F;
		//cloak
		this.EquipLeft.xRot = 0F;
		this.EquipRight.xRot = 0F;
  	    //hair
	  	this.Head.xRot = 0.2F;
  	    this.HairMidL01.xRot = 0.05F;
  	    this.HairMidL02.xRot = -0.3F;
	  	//Body
	  	this.BodyMain.xRot = 1.4F;
	    //arm 
	  	this.ArmLeft01.xRot = -2.8F;
	    this.ArmLeft01.zRot = 0.8727F;
	    this.ArmRight01.xRot = -2.8F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -0.35F;
		//leg
		this.LegLeft.xRot = -0.087F;
	  	this.LegRight.xRot = -0.087F;
		this.LegLeft.zRot = -0.2618F;
		this.LegRight.zRot = 0.4F;
		//cloak
		this.Cloak01.xRot = 0F;
		this.Cloak02.xRot = 0F;
		this.Cloak03.xRot = 0F;
		this.Cloak04.xRot = 0F;
		this.Cloak05.xRot = 0F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F);
  		float angleX1 = Mth.cos(f2*0.08F + 0.3F + f * 0.5F);
  		float angleRun = Mth.cos(f * 0.7F) * f1 * 0.6F;
  		float angleRun2 = Mth.cos(f * 0.7F + 3.1415927F) * f1 * 0.6F;
  		float addk1 = 0;
  		float addk2 = 0;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}
  		
  		//leg move parm
  		addk1 = angleRun - 0.35F;
	  	addk2 = angleRun2  - 0.087F;

  	    //移動頭部使其看人
	  	this.Head.xRot = f4 * 0.014F; 	//上下角度
	  	this.Head.yRot = f3 * 0.01F;	//左右角度
	    
	    //正常站立動作
	    //胸部
  	    this.BoobL.xRot = -angleX * 0.06F - 0.7854F;
  	    this.BoobR.xRot = -angleX * 0.06F - 0.7854F;
  	    this.NeckTie.xRot = -angleX * 0.1F - 0.7F;
  	    //hair
  	    this.HairMidL01.xRot = angleX * 0.06F + 0.2618F;
  	    this.HairMidL02.xRot = -angleX1 * 0.08F - 0.087F;
  	    this.HairL01.xRot = angleX * 0.06F - 0.13F;
	    this.HairL02.xRot = -angleX1 * 0.08F + 0.21F;
	    this.HairR01.xRot = angleX * 0.06F - 0.13F;
	    this.HairR02.xRot = -angleX1 * 0.08F + 0.21F;
	    this.HairMidL01.zRot = 0F;
  	    this.HairMidL02.zRot = 0F;
  	    this.HairL01.zRot = -0.05F;
	    this.HairL02.zRot = 0.05F;
	    this.HairR01.zRot = 0.087F;
	    this.HairR02.zRot = -0.05F;
	  	//Body
  	    this.Ahoke.zRot = angleX * 0.1F - 0.06F;
	  	this.BodyMain.xRot = 0F;
	    //arm 
	  	this.ArmLeft01.xRot = 0.35F;
	  	this.ArmLeft01.yRot = 0F;
	    this.ArmLeft01.zRot = 0.2618F;
	    this.ArmRight01.xRot = 0.35F;
		this.ArmRight01.zRot = -0.2618F;
		//leg
		this.LegLeft.zRot = 0.14F;
		this.LegRight.zRot = -0.14F;
		//cloak
		this.EquipLeft.xRot = 0F;
		this.EquipRight.xRot = 0F;
		this.Cloak01.xRot = 0F;
		this.Cloak02.xRot = angleX * 0.05F + 0.15F;
		this.Cloak03.xRot = angleX * 0.05F + 0.18F;
		this.Cloak04.xRot = angleX * 0.05F + 0.15F;
		this.Cloak05.xRot = 0.2F;

		//奔跑動作
	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {
	    	//leg move parm
		  	addk2 -= 0.35F;
	  	    //hair
	  	    this.HairMidL01.xRot += angleRun * 0.1F + 0.2F;
	  	    this.HairMidL02.xRot += angleRun2 * 0.1F + 0.2F;
		  	//Body
		  	this.BodyMain.xRot = 0.087F;
		  	this.BodyMain.yRot = 0F;
		    //arm 
		  	this.ArmLeft01.xRot = angleRun2;
		    this.ArmLeft01.zRot = -0.1745F;
		    this.ArmRight01.xRot = angleRun;
			this.ArmRight01.zRot = 0.1745F;
			//leg
			this.LegLeft.zRot = 0.05F;
			this.LegRight.zRot = -0.05F;
			//cloak
			this.Cloak02.xRot = angleRun * 0.05F + 0.3F;
			this.Cloak03.xRot = angleRun * 0.05F + 0.3F;
			this.Cloak04.xRot = angleRun * 0.05F + 0.35F;
			this.Cloak05.xRot = angleRun * 0.05F + 0.4F;
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {	//潛行, 蹲下動作
this.animTransX += (0F); this.animTransY += (0.05F); this.animTransZ += (0F);
	    	//leg move parm
	    	addk1 -= 0.52F;
		  	addk2 -= 1F;
		  	//Body
		  	this.BodyMain.xRot = 0.7F;
		    //arm 
		  	this.ArmLeft01.xRot = -0.35F;
		    this.ArmLeft01.zRot = 0.26F;
		    this.ArmRight01.xRot = -0.35F;
			this.ArmRight01.zRot = -0.26F;
			//cloak
			this.Cloak02.xRot = angleX * 0.05F + 0.15F;
			this.Cloak03.xRot = angleX * 0.05F + 0.15F;
			this.Cloak04.xRot = angleX * 0.05F + 0.2F;
			this.Cloak05.xRot = angleX * 0.05F + 0.2F;
  		}//end if sneaking
  		
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {  //騎乘動作
	    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
	    	{
this.animTransX += (0F); this.animTransY += (0.65F); this.animTransZ += (0F);
		    	//leg move parm
		    	addk1 = -0.087F;
			  	addk2 = 0.174F;
		  	    //hair
			  	this.Head.xRot -= 1.4F;
			  	this.Head.yRot *= 0.5F;
			  	//Body
			  	this.BodyMain.xRot = 1.4F;
			    //arm 
			  	this.ArmLeft01.xRot = -2.8F;
			    this.ArmLeft01.zRot = -0.8727F;
			    this.ArmRight01.xRot = -2.6F;
				this.ArmRight01.zRot = 0.35F;
				//leg
				this.LegLeft.zRot = 0.2618F;
				this.LegRight.zRot = -0.2618F;
				//cloak
				this.Cloak01.xRot = 0F;
				this.Cloak02.xRot = angleX * 0.01F + 0.15F;
				this.Cloak03.xRot = angleX * 0.01F + 0.18F;
				this.Cloak04.xRot = 0F;
				this.Cloak05.xRot = 0F;
	    	}
	    	else
	    	{
this.animTransX += (0F); this.animTransY += (0.51F); this.animTransZ += (0F);
		    	//leg move parm
		    	addk1 = -1.0472F;
			  	addk2 = -1.3F;
		  	    //hair
			  	this.Head.xRot += 0.35F;
		  	    this.HairMidL01.xRot += 0.2F;
		  	    this.HairMidL02.xRot += 0.2F;
			  	//Body
			  	this.BodyMain.xRot = -0.7F;
			    //arm 
			  	this.ArmLeft01.xRot = 1.0472F;
			    this.ArmLeft01.zRot = -0.2618F;
			    this.ArmRight01.xRot = 1.0472F;
				this.ArmRight01.zRot = 0.2618F;
				//leg
				this.LegLeft.zRot = 0.6F;
				this.LegRight.zRot = -0.6F;
				//cloak
				this.EquipLeft.xRot = 0.7F;
				this.EquipRight.xRot = 0.7F;
				this.Cloak01.xRot = 0.7F;
				this.Cloak02.xRot = angleX * 0.03F + 0.15F;
				this.Cloak03.xRot = angleX * 0.03F + 0.15F;
				this.Cloak04.xRot = angleX * 0.03F + 0.5F;
				this.Cloak05.xRot = angleX * 0.03F + 0.2F;
	    	}
  		}//end if sitting
	    
	    //攻擊動作    
	    if (ent.getAttackTick() > 0)
	    {
	    	//arm
	    	this.ArmLeft01.xRot = -1.3F;
	    	this.ArmLeft01.yRot = -0.7F;
	    	this.ArmLeft01.zRot = 0F;
	    	this.ArmRight01.xRot = 0.17F;
	    	this.ArmRight01.zRot = 0.17F;
	    	this.EquipLeft.xRot = 0.2618F;
	    }
	    
	    //swing arm
	  	float f6 = ent.getSwingTime(f2 - (int)f2);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight01.xRot = 0.35F;
	        this.ArmRight01.yRot = 0F;
	        this.ArmRight01.zRot = -0.26F;
	        this.ArmRight01.xRot += -f8 * 120.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.yRot += -f7 * 20.0F * Values.N.DIV_PI_180 + 0.5F;
	        this.ArmRight01.zRot += -f8 * 20.0F * Values.N.DIV_PI_180;
	  	}
	  	
	  	//鬢毛調整
	    float headX = this.Head.xRot * -0.5F;
	    float headZ = this.Head.zRot * -0.5F;
	    this.HairMidL01.xRot += headX;
	    this.HairMidL01.zRot += headZ;
	    this.HairMidL02.xRot += headX * 0.5F;
	    this.HairMidL02.zRot += headZ * 0.5F;
	  	this.HairL01.zRot += headZ;
	  	this.HairL02.zRot += headZ;
	  	this.HairR01.zRot += headZ;
	  	this.HairR02.zRot += headZ;
		this.HairL01.xRot += headX;
	  	this.HairL02.xRot += headX;
	  	this.HairR01.xRot += headX;
	  	this.HairR02.xRot += headX;
	    
	    //leg motion
	    this.LegLeft.xRot = addk1;
	    this.LegRight.xRot = addk2;
	
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

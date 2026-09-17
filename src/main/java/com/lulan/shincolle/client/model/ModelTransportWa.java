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

public class ModelTransportWa<T extends Entity> extends ShipModelBaseAdv<T>
{

	public ModelPart BodyMain;
	public ModelPart BoobR;
	public ModelPart BoobL;
	public ModelPart Butt;
	public ModelPart Head;
	public ModelPart ArmLeft01;
	public ModelPart ArmRight01;
	public ModelPart Cloth03;
	public ModelPart EquipBase;
	public ModelPart Cloth01b;
	public ModelPart Cloth01a;
	public ModelPart Cloth2b;
	public ModelPart Cloth2a;
	public ModelPart LegRight01;
	public ModelPart LegLeft01;
	public ModelPart LegRight02;
	public ModelPart LegLeft02;
	public ModelPart ClothLeg;
	public ModelPart Hair;
	public ModelPart HairMain;
	public ModelPart EquipHeadBase;
	public ModelPart Ahoke;
	public ModelPart HairU01;
	public ModelPart Hair01;
	public ModelPart ClothHead;
	public ModelPart EquipHead01;
	public ModelPart EquipHead02;
	public ModelPart EquipHead03;
	public ModelPart EquipHead04;
	public ModelPart EquipHead05;
	public ModelPart EquipHead06;
	public ModelPart ArmLeft02;
	public ModelPart ArmRight02;
	public ModelPart Cloth04;
	public ModelPart Cloth00a;
	public ModelPart Cloth00b;
	public ModelPart Cloth00c;
	public ModelPart Cloth00d;
	public ModelPart EquipBack01a;
	public ModelPart EquipBack01b;
	public ModelPart EquipBack01c;
	public ModelPart EquipBack01d;
	public ModelPart EquipBack01e;
	public ModelPart EquipBack01f;
	public ModelPart EquipBack01g;
	public ModelPart EquipBack01h;
	public ModelPart EquipBack01i;
	public ModelPart EquipBack01j;
	public ModelPart EquipBack01k;
	public ModelPart EquipBack01l;
	public ModelPart EquipBack01m;
	public ModelPart EquipBack01n;
	public ModelPart EquipBack01o;
	public ModelPart EquipBack01p;
	public ModelPart EquipBack01q;
	public ModelPart EquipBack01r;
	public ModelPart EquipTubeR01;
	public ModelPart EquipTubeL01;
	public ModelPart EquipBack01s;
	public ModelPart EquipBack01t;
	public ModelPart EquipBack01u;
	public ModelPart EquipBack01v;
	public ModelPart EquipBack01w;
	public ModelPart EquipBack01x;
	public ModelPart EquipBack01y;
	public ModelPart EquipBack01z;
	public ModelPart EquipBack01za;
	public ModelPart EquipBack01zb;
	public ModelPart EquipBack01zc;
	public ModelPart EquipBack01zd;
	public ModelPart EquipTubeR02;
	public ModelPart EquipTubeR03;
	public ModelPart EquipTubeL02;
	public ModelPart EquipTubeL03;
	public ModelPart GlowBodyMain;
	public ModelPart GlowBodyMain2;
	public ModelPart GlowHead;
	public ModelPart GlowEquipBase;
	public ModelPart GlowEquipTubeL01;
	public ModelPart GlowEquipTubeL02;
	public ModelPart GlowEquipTubeR01;
	public ModelPart GlowEquipTubeR02;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, -11.0F, -4.0F, 13.0F, 16.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -11.0F, -3.0F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Head", CubeListBuilder.create().addBox(-7.0F, -14.5F, -6.5F, 14.0F, 14.0F, 13.0F), PartPose.offsetAndRotation(0.0F, -11.8F, -1.0F, 0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("EquipHeadBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offset(0.0F, -13.8F, 0.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("EquipHead03", CubeListBuilder.create().addBox(-8.0F, 0.0F, -9.0F, 16.0F, 10.0F, 16.0F), PartPose.offsetAndRotation(0.0F, -4.3F, -7.0F, 0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef4 = partdef2.addOrReplaceChild("EquipHead04", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 9.0F, 16.0F), PartPose.offsetAndRotation(0.0F, -5.2F, -2.8F, -0.5009094953223726F, -0.7213445798492564F, 0.34487706019407954F));
		PartDefinition partdef5 = partdef2.addOrReplaceChild("EquipHead05", CubeListBuilder.create().addBox(-7.0F, 0.0F, 0.0F, 14.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 7.3F, -12.0F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef6 = partdef2.addOrReplaceChild("EquipHead06", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef7 = partdef2.addOrReplaceChild("EquipHead02", CubeListBuilder.create().addBox(-15.0F, 0.0F, 0.0F, 15.0F, 9.0F, 16.0F), PartPose.offsetAndRotation(-4.0F, -3.0F, -12.0F, 0.0F, 0.3490658503988659F, -0.20943951023931953F));
		PartDefinition partdef8 = partdef2.addOrReplaceChild("EquipHead01", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 15.0F, 9.0F, 16.0F), PartPose.offsetAndRotation(4.0F, -3.0F, -12.0F, 0.0F, -0.3490658503988659F, 0.20943951023931953F));
		PartDefinition partdef9 = partdef1.addOrReplaceChild("HairMain", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 10.0F), PartPose.offset(0.0F, -14.8F, -3.0F));
		PartDefinition partdef10 = partdef9.addOrReplaceChild("Hair01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 9.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 7.2F, 1.1F, 0.08726646259971647F, 0.0F, 0.0F));
		PartDefinition partdef11 = partdef9.addOrReplaceChild("ClothHead", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 10.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -1.1F, 1.5F, -0.06981317007977318F, 0.0F, 0.0F));
		PartDefinition partdef12 = partdef1.addOrReplaceChild("Hair", CubeListBuilder.create().addBox(-8.0F, -8.0F, -7.4F, 16.0F, 12.0F, 8.0F), PartPose.offset(0.0F, -7.5F, 0.4F));
		PartDefinition partdef13 = partdef12.addOrReplaceChild("HairU01", CubeListBuilder.create().addBox(-8.5F, 0.0F, 0.0F, 17.0F, 14.0F, 7.0F), PartPose.offset(0.0F, -6.0F, -6.5F));
		PartDefinition partdef14 = partdef12.addOrReplaceChild("Ahoke", CubeListBuilder.create().addBox(0.0F, -12.0F, -6.5F, 0.0F, 12.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -7.0F, -4.5F, 1.2F, 0.6981317007977318F, 0.0F));
		PartDefinition partdef15 = partdef0.addOrReplaceChild("Cloth01b", CubeListBuilder.create().mirror().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 14.0F, 8.0F), PartPose.offsetAndRotation(-5.6F, -11.6F, -0.6F, 0.03490658503988659F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef16 = partdef0.addOrReplaceChild("Butt", CubeListBuilder.create().addBox(-7.5F, 0.0F, -5.7F, 15.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 1.3F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef17 = partdef16.addOrReplaceChild("LegLeft01", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F), PartPose.offsetAndRotation(4.4F, 5.5F, -2.6F, -0.24434609527920614F, 0.0F, 0.10471975511965977F));
		PartDefinition partdef18 = partdef17.addOrReplaceChild("LegLeft02", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 13.0F, 6.0F), PartPose.offset(-3.0F, 12.0F, -3.0F));
		PartDefinition partdef19 = partdef17.addOrReplaceChild("ClothLeg", CubeListBuilder.create().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 4.0F, 7.0F), PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition partdef20 = partdef16.addOrReplaceChild("LegRight01", CubeListBuilder.create().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F), PartPose.offsetAndRotation(-4.4F, 5.5F, -2.6F, -0.13962634015954636F, 0.0F, -0.10471975511965977F));
		PartDefinition partdef21 = partdef20.addOrReplaceChild("LegRight02", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 6.0F, 13.0F, 6.0F), PartPose.offset(3.0F, 12.0F, -3.0F));
		PartDefinition partdef22 = partdef0.addOrReplaceChild("Cloth01a", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 14.0F, 8.0F), PartPose.offsetAndRotation(5.6F, -11.6F, -0.6F, 0.03490658503988659F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef23 = partdef0.addOrReplaceChild("EquipBase", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -4.5F, 7.5F, 0.05235987755982988F, 0.0F, 0.0F));
		PartDefinition partdef24 = partdef23.addOrReplaceChild("EquipBack01t", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 6.0F), PartPose.offset(0.0F, -10.0F, 32.0F));
		PartDefinition partdef25 = partdef23.addOrReplaceChild("EquipBack01m", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F), PartPose.offset(16.0F, -10.0F, 16.0F));
		PartDefinition partdef26 = partdef23.addOrReplaceChild("EquipBack01v", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 6.0F), PartPose.offset(-10.0F, 0.0F, 32.0F));
		PartDefinition partdef27 = partdef23.addOrReplaceChild("EquipBack01j", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F), PartPose.offset(-16.0F, -16.0F, 16.0F));
		PartDefinition partdef28 = partdef23.addOrReplaceChild("EquipBack01q", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F), PartPose.offset(-22.0F, 0.0F, 16.0F));
		PartDefinition partdef29 = partdef23.addOrReplaceChild("EquipBack01x", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F), PartPose.offset(0.0F, -22.0F, 16.0F));
		PartDefinition partdef30 = partdef23.addOrReplaceChild("EquipBack01zb", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F), PartPose.offset(-10.0F, 16.0F, 6.0F));
		PartDefinition partdef31 = partdef23.addOrReplaceChild("EquipBack01n", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F), PartPose.offset(16.0F, 0.0F, 16.0F));
		PartDefinition partdef32 = partdef23.addOrReplaceChild("EquipBack01a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F), PartPose.offset(0.0F, -16.0F, 0.0F));
		PartDefinition partdef33 = partdef23.addOrReplaceChild("EquipBack01p", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F), PartPose.offset(-22.0F, -10.0F, 6.0F));
		PartDefinition partdef34 = partdef23.addOrReplaceChild("EquipBack01i", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F), PartPose.offset(-16.0F, 0.0F, 16.0F));
		PartDefinition partdef35 = partdef23.addOrReplaceChild("EquipBack01d", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F), PartPose.offset(-16.0F, 0.0F, 0.0F));
		PartDefinition partdef36 = partdef23.addOrReplaceChild("EquipBack01w", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F), PartPose.offset(0.0F, -22.0F, 6.0F));
		PartDefinition partdef37 = partdef23.addOrReplaceChild("EquipBack01o", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F), PartPose.offset(-22.0F, 0.0F, 6.0F));
		PartDefinition partdef38 = partdef23.addOrReplaceChild("EquipTubeR01", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(-18.0F, 3.0F, 28.0F, -0.3490658503988659F, 0.13962634015954636F, 0.13962634015954636F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("EquipTubeR02", CubeListBuilder.create().addBox(-4.5F, 0.0F, -8.5F, 9.0F, 16.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 16.0F, 4.0F, -0.9560913642424937F, 0.0F, 0.0F));
		PartDefinition partdef40 = partdef23.addOrReplaceChild("EquipBack01g", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 16.0F));
		PartDefinition partdef41 = partdef23.addOrReplaceChild("EquipTubeL01", CubeListBuilder.create().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(18.0F, 3.0F, 28.0F, -0.3490658503988659F, -0.13962634015954636F, -0.13962634015954636F));
		PartDefinition partdef42 = partdef41.addOrReplaceChild("EquipTubeL02", CubeListBuilder.create().addBox(-4.5F, 0.0F, -8.5F, 9.0F, 16.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 16.0F, 4.0F, -0.9560913642424937F, 0.0F, 0.0F));
		PartDefinition partdef43 = partdef23.addOrReplaceChild("EquipBack01zc", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F), PartPose.offset(-10.0F, 16.0F, 16.0F));
		PartDefinition partdef44 = partdef23.addOrReplaceChild("EquipBack01b", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F), PartPose.offset(-16.0F, -16.0F, 0.0F));
		PartDefinition partdef45 = partdef23.addOrReplaceChild("EquipBack01e", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 16.0F, 4.0F), PartPose.offset(-10.0F, -6.0F, -4.0F));
		PartDefinition partdef46 = partdef23.addOrReplaceChild("EquipBack01h", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F), PartPose.offset(0.0F, -16.0F, 16.0F));
		PartDefinition partdef47 = partdef23.addOrReplaceChild("EquipBack01s", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 32.0F));
		PartDefinition partdef48 = partdef23.addOrReplaceChild("EquipBack01r", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F), PartPose.offset(-22.0F, -10.0F, 16.0F));
		PartDefinition partdef49 = partdef23.addOrReplaceChild("EquipBack01f", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 10.0F, 16.0F, 4.0F), PartPose.offset(0.0F, -6.0F, -4.0F));
		PartDefinition partdef50 = partdef23.addOrReplaceChild("EquipBack01k", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F), PartPose.offset(16.0F, 0.0F, 6.0F));
		PartDefinition partdef51 = partdef23.addOrReplaceChild("EquipBack01l", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, 0.0F, 6.0F, 10.0F, 10.0F), PartPose.offset(16.0F, -10.0F, 6.0F));
		PartDefinition partdef52 = partdef23.addOrReplaceChild("EquipBack01za", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F), PartPose.offset(0.0F, 16.0F, 6.0F));
		PartDefinition partdef53 = partdef23.addOrReplaceChild("EquipBack01z", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F), PartPose.offset(-10.0F, -22.0F, 6.0F));
		PartDefinition partdef54 = partdef23.addOrReplaceChild("EquipBack01zd", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F), PartPose.offset(0.0F, 16.0F, 16.0F));
		PartDefinition partdef55 = partdef23.addOrReplaceChild("EquipBack01u", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 10.0F, 10.0F, 6.0F), PartPose.offset(-10.0F, -10.0F, 32.0F));
		PartDefinition partdef56 = partdef23.addOrReplaceChild("EquipBack01y", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 10.0F, 6.0F, 10.0F), PartPose.offset(-10.0F, -22.0F, 16.0F));
		PartDefinition partdef57 = partdef23.addOrReplaceChild("EquipBack01c", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition partdef58 = partdef0.addOrReplaceChild("ArmLeft01", CubeListBuilder.create().mirror().addBox(-2.0F, -1.0F, -2.5F, 5.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(7.8F, -9.7F, -0.7F, 0.0F, 0.0F, -0.20943951023931953F));
		PartDefinition partdef59 = partdef58.addOrReplaceChild("ArmLeft02", CubeListBuilder.create().mirror().addBox(-5.0F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F), PartPose.offset(3.0F, 10.0F, 2.5F));
		PartDefinition partdef60 = partdef0.addOrReplaceChild("Cloth03", CubeListBuilder.create().addBox(-7.0F, 0.0F, -4.7F, 14.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.2F, 1.3F, -0.5F, 0.17453292519943295F, 0.0F, 0.08726646259971647F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("Cloth00b", CubeListBuilder.create().addBox(-7.0F, -2.0F, 0.0F, 7.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 3.3F, -0.20943951023931953F, 0.2617993877991494F, 0.17453292519943295F));
		PartDefinition partdef62 = partdef60.addOrReplaceChild("Cloth04", CubeListBuilder.create().addBox(-6.5F, 0.0F, 0.0F, 13.0F, 11.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 2.5F, -4.7F, -0.20943951023931953F, 0.0F, -0.08726646259971647F));
		PartDefinition partdef63 = partdef60.addOrReplaceChild("Cloth00d", CubeListBuilder.create().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 12.0F, 0.0F), PartPose.offsetAndRotation(-0.8F, 1.0F, 4.5F, 0.3490658503988659F, -0.13962634015954636F, 0.3141592653589793F));
		PartDefinition partdef64 = partdef60.addOrReplaceChild("Cloth00a", CubeListBuilder.create().mirror().addBox(0.0F, -2.0F, 0.0F, 7.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.5F, 0.5F, 3.5F, -0.091106186954104F, -0.2617993877991494F, -0.17453292519943295F));
		PartDefinition partdef65 = partdef60.addOrReplaceChild("Cloth00c", CubeListBuilder.create().mirror().addBox(-2.5F, 0.0F, 0.0F, 5.0F, 12.0F, 0.0F), PartPose.offsetAndRotation(1.3F, 1.0F, 4.5F, 0.3141592653589793F, 0.13962634015954636F, -0.3490658503988659F));
		PartDefinition partdef66 = partdef0.addOrReplaceChild("BoobL", CubeListBuilder.create().mirror().addBox(-3F, 0F, 0F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(4.1F, -8.5F, -3.7F, -0.6981317007977318F, 0.0785F, 0.0785F));
		PartDefinition partdef67 = partdef66.addOrReplaceChild("Cloth2a", CubeListBuilder.create().addBox(0F, 0F, 0F, 5.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(-1.2F, -0.5F, -0.7F, 0F, -0.0785F, -0.0785F));
		PartDefinition partdef68 = partdef0.addOrReplaceChild("ArmRight01", CubeListBuilder.create().addBox(-3.0F, -1.0F, -2.5F, 5.0F, 11.0F, 5.0F), PartPose.offsetAndRotation(-7.8F, -9.7F, -0.7F, 0.20943951023931953F, 0.0F, 0.20943951023931953F));
		PartDefinition partdef69 = partdef68.addOrReplaceChild("ArmRight02", CubeListBuilder.create().addBox(0.0F, 0.0F, -5.0F, 5.0F, 11.0F, 5.0F), PartPose.offset(-3.0F, 10.0F, 2.5F));
		PartDefinition partdef70 = partdef0.addOrReplaceChild("BoobR", CubeListBuilder.create().addBox(-3F, 0F, 0F, 6.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-4.1F, -8.5F, -3.7F, -0.6981317007977318F, -0.0785F, -0.0785F));
		PartDefinition partdef71 = partdef70.addOrReplaceChild("Cloth2b", CubeListBuilder.create().mirror().addBox(-5F, 0F, 0F, 5.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(1.2F, -0.5F, -0.7F, 0F, 0.0785F, 0.0785F));
		PartDefinition partdef72 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, -3.0F));
		PartDefinition partdef73 = partdef72.addOrReplaceChild("GlowHead", CubeListBuilder.create(), PartPose.offset(0.0F, -11.8F, -1.0F));
		PartDefinition partdef74 = partdef73.addOrReplaceChild("Face0", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef75 = partdef73.addOrReplaceChild("Face1", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef76 = partdef73.addOrReplaceChild("Face2", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef77 = partdef73.addOrReplaceChild("Face3", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef78 = partdef73.addOrReplaceChild("Face4", CubeListBuilder.create().addBox(-7.0F, 0.0F, -0.5F, 14.0F, 12.0F, 1.0F), PartPose.offset(0.0F, -12.2F, -6.1F));
		PartDefinition partdef79 = partdef73.addOrReplaceChild("Mouth0", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef80 = partdef73.addOrReplaceChild("Mouth1", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef81 = partdef73.addOrReplaceChild("Mouth2", CubeListBuilder.create().addBox(-3.0F, 0.0F, -0.5F, 6.0F, 4.0F, 1.0F), PartPose.offset(0.0F, -4.2F, -6.2F));
		PartDefinition partdef82 = partdef73.addOrReplaceChild("Flush0", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(-6.0F, -3.0F, -6.9F));
		PartDefinition partdef83 = partdef73.addOrReplaceChild("Flush1", CubeListBuilder.create().addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 0.0F), PartPose.offset(6.0F, -3.0F, -6.9F));
		PartDefinition partdef84 = partdefinition.addOrReplaceChild("GlowBodyMain2", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, -3.0F));
		PartDefinition partdef85 = partdef84.addOrReplaceChild("GlowEquipBase", CubeListBuilder.create(), PartPose.offset(0.0F, -4.5F, 7.5F));
		PartDefinition partdef86 = partdef85.addOrReplaceChild("GlowEquipTubeL01", CubeListBuilder.create(), PartPose.offset(18.0F, 3.0F, 28.0F));
		PartDefinition partdef87 = partdef86.addOrReplaceChild("GlowEquipTubeL02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 16.0F, 4.0F, -0.9560913642424937F, 0.0F, 0.0F));
		PartDefinition partdef88 = partdef87.addOrReplaceChild("EquipTubeL03", CubeListBuilder.create().addBox(-4.5F, 0.0F, -4.5F, 9.0F, 3.0F, 9.0F), PartPose.offset(0.0F, 16.1F, -4.0F));
		PartDefinition partdef89 = partdef85.addOrReplaceChild("GlowEquipTubeR01", CubeListBuilder.create(), PartPose.offset(-18.0F, 3.0F, 28.0F));
		PartDefinition partdef90 = partdef89.addOrReplaceChild("GlowEquipTubeR02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 16.0F, 4.0F, -0.9560913642424937F, 0.0F, 0.0F));
		PartDefinition partdef91 = partdef90.addOrReplaceChild("EquipTubeR03", CubeListBuilder.create().addBox(-4.5F, 0.0F, -4.5F, 9.0F, 3.0F, 9.0F), PartPose.offset(0.0F, 16.1F, -4.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public ModelTransportWa(ModelPart root)
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
		this.Cloth00b = root.getChild("BodyMain").getChild("Cloth03").getChild("Cloth00b");
		this.EquipBack01t = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01t");
		this.EquipBack01m = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01m");
		this.EquipHeadBase = root.getChild("BodyMain").getChild("Head").getChild("EquipHeadBase");
		this.EquipBack01v = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01v");
		this.Head = root.getChild("BodyMain").getChild("Head");
		this.HairU01 = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("HairU01");
		this.BodyMain = root.getChild("BodyMain");
		this.Cloth01b = root.getChild("BodyMain").getChild("Cloth01b");
		this.EquipBack01j = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01j");
		this.EquipBack01q = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01q");
		this.EquipBack01x = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01x");
		this.EquipBack01zb = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01zb");
		this.LegRight02 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01").getChild("LegRight02");
		this.EquipBack01n = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01n");
		this.EquipBack01a = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01a");
		this.EquipBack01p = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01p");
		this.EquipBack01i = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01i");
		this.EquipBack01d = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01d");
		this.EquipBack01w = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01w");
		this.Hair01 = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("Hair01");
		this.ArmLeft02 = root.getChild("BodyMain").getChild("ArmLeft01").getChild("ArmLeft02");
		this.EquipBack01o = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01o");
		this.EquipHead03 = root.getChild("BodyMain").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead03");
		this.EquipTubeL02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipTubeL01").getChild("EquipTubeL02");
		this.Butt = root.getChild("BodyMain").getChild("Butt");
		this.LegLeft01 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01");
		this.Cloth01a = root.getChild("BodyMain").getChild("Cloth01a");
		this.Cloth04 = root.getChild("BodyMain").getChild("Cloth03").getChild("Cloth04");
		this.EquipTubeR01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipTubeR01");
		this.LegRight01 = root.getChild("BodyMain").getChild("Butt").getChild("LegRight01");
		this.EquipBack01g = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01g");
		this.EquipHead04 = root.getChild("BodyMain").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead04");
		this.EquipTubeL01 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipTubeL01");
		this.EquipBase = root.getChild("BodyMain").getChild("EquipBase");
		this.EquipBack01zc = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01zc");
		this.Cloth00d = root.getChild("BodyMain").getChild("Cloth03").getChild("Cloth00d");
		this.LegLeft02 = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("LegLeft02");
		this.EquipBack01b = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01b");
		this.EquipTubeL03 = root.getChild("GlowBodyMain2").getChild("GlowEquipBase").getChild("GlowEquipTubeL01").getChild("GlowEquipTubeL02").getChild("EquipTubeL03");
		this.EquipBack01e = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01e");
		this.EquipTubeR03 = root.getChild("GlowBodyMain2").getChild("GlowEquipBase").getChild("GlowEquipTubeR01").getChild("GlowEquipTubeR02").getChild("EquipTubeR03");
		this.EquipBack01h = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01h");
		this.EquipBack01s = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01s");
		this.ArmLeft01 = root.getChild("BodyMain").getChild("ArmLeft01");
		this.Cloth03 = root.getChild("BodyMain").getChild("Cloth03");
		this.Cloth00a = root.getChild("BodyMain").getChild("Cloth03").getChild("Cloth00a");
		this.EquipBack01r = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01r");
		this.EquipHead05 = root.getChild("BodyMain").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead05");
		this.ClothHead = root.getChild("BodyMain").getChild("Head").getChild("HairMain").getChild("ClothHead");
		this.EquipHead06 = root.getChild("BodyMain").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead06");
		this.EquipBack01f = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01f");
		this.ClothLeg = root.getChild("BodyMain").getChild("Butt").getChild("LegLeft01").getChild("ClothLeg");
		this.EquipBack01k = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01k");
		this.Ahoke = root.getChild("BodyMain").getChild("Head").getChild("Hair").getChild("Ahoke");
		this.EquipBack01l = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01l");
		this.EquipHead02 = root.getChild("BodyMain").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead02");
		this.ArmRight01 = root.getChild("BodyMain").getChild("ArmRight01");
		this.EquipBack01za = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01za");
		this.HairMain = root.getChild("BodyMain").getChild("Head").getChild("HairMain");
		this.ArmRight02 = root.getChild("BodyMain").getChild("ArmRight01").getChild("ArmRight02");
		this.EquipTubeR02 = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipTubeR01").getChild("EquipTubeR02");
		this.BoobR = root.getChild("BodyMain").getChild("BoobR");
		this.BoobL = root.getChild("BodyMain").getChild("BoobL");
		this.Cloth2a = root.getChild("BodyMain").getChild("BoobL").getChild("Cloth2a");
		this.Cloth2b = root.getChild("BodyMain").getChild("BoobR").getChild("Cloth2b");
		this.Cloth00c = root.getChild("BodyMain").getChild("Cloth03").getChild("Cloth00c");
		this.Hair = root.getChild("BodyMain").getChild("Head").getChild("Hair");
		this.EquipHead01 = root.getChild("BodyMain").getChild("Head").getChild("EquipHeadBase").getChild("EquipHead01");
		this.EquipBack01z = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01z");
		this.EquipBack01zd = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01zd");
		this.EquipBack01u = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01u");
		this.EquipBack01y = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01y");
		this.EquipBack01c = root.getChild("BodyMain").getChild("EquipBase").getChild("EquipBack01c");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowBodyMain2 = root.getChild("GlowBodyMain2");
		this.GlowHead = root.getChild("GlowBodyMain").getChild("GlowHead");
		this.GlowEquipBase = root.getChild("GlowBodyMain2").getChild("GlowEquipBase");
		this.GlowEquipTubeL01 = root.getChild("GlowBodyMain2").getChild("GlowEquipBase").getChild("GlowEquipTubeL01");
		this.GlowEquipTubeL02 = root.getChild("GlowBodyMain2").getChild("GlowEquipBase").getChild("GlowEquipTubeL01").getChild("GlowEquipTubeL02");
		this.GlowEquipTubeR01 = root.getChild("GlowBodyMain2").getChild("GlowEquipBase").getChild("GlowEquipTubeR01");
		this.GlowEquipTubeR02 = root.getChild("GlowBodyMain2").getChild("GlowEquipBase").getChild("GlowEquipTubeR01").getChild("GlowEquipTubeR02");
		this.scale = 0.4F;
		this.offsetY = 2.35F;
		this.offsetItem = new float[] {0.06F, 1.05F, -0.06F};
		this.offsetBlock = new float[] {0.06F, 1.05F, -0.06F};
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
    	this.GlowBodyMain.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);		//face with cull
    	this.GlowBodyMain2.render(poseStack, vertexConsumer, glowLight ? LightTexture.FULL_BRIGHT : packedLight, packedOverlay);		//glow equip without cull
    	
    	poseStack.popPose();
    
	}

	public void showEquip(IShipEmotion ent)
	{

		int state = ent.getStateEmotion(ID.S.State);
		
		boolean flag = !EmotionHelper.checkModelState(0, state);	//equip
		this.EquipBase.visible = !(flag);
		this.GlowEquipBase.visible = !(flag);
				
		flag = !EmotionHelper.checkModelState(1, state);	//leg
		
		if (flag)
		{
			this.EquipBase.visible = true;
			this.GlowEquipBase.visible = true;
			this.LegLeft01.visible = false;
			this.LegRight01.visible = false;
		}
		else
		{
			this.LegLeft01.visible = true;
			this.LegRight01.visible = true;
		}
		
		flag = !EmotionHelper.checkModelState(2, state);	//hat
		this.EquipHeadBase.visible = !(flag);
		this.Ahoke.visible = !(!flag);
	
	}

	public void syncRotationGlowPart()
	{

		this.GlowBodyMain.xRot = this.BodyMain.xRot;
		this.GlowBodyMain.yRot = this.BodyMain.yRot;
		this.GlowBodyMain.zRot = this.BodyMain.zRot;
		this.GlowBodyMain2.xRot = this.BodyMain.xRot;
		this.GlowBodyMain2.yRot = this.BodyMain.yRot;
		this.GlowBodyMain2.zRot = this.BodyMain.zRot;
		this.GlowHead.xRot = this.Head.xRot;
		this.GlowHead.yRot = this.Head.yRot;
		this.GlowHead.zRot = this.Head.zRot;
		this.GlowEquipBase.xRot = this.EquipBase.xRot;
		this.GlowEquipBase.yRot = this.EquipBase.yRot;
		this.GlowEquipBase.zRot = this.EquipBase.zRot;
		this.GlowEquipBase.y = (-4.5F) + (((this.EquipBase.getInitialPose().y - (-4.5F)) / 16F)) * 16F;
		this.GlowEquipBase.z = (7.5F) + (((this.EquipBase.getInitialPose().z - (7.5F)) / 16F)) * 16F;
		this.GlowEquipTubeL01.xRot = this.EquipTubeL01.xRot;
		this.GlowEquipTubeL01.yRot = this.EquipTubeL01.yRot;
		this.GlowEquipTubeL01.zRot = this.EquipTubeL01.zRot;
		this.GlowEquipTubeR01.xRot = this.EquipTubeR01.xRot;
		this.GlowEquipTubeR01.yRot = this.EquipTubeR01.yRot;
		this.GlowEquipTubeR01.zRot = this.EquipTubeR01.zRot;
	
	}

	public void applyDeadPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

this.animTransX += (0F); this.animTransY += (0.12F); this.animTransZ += (0F);
		this.setFaceHungry(ent);
    	
  	    //頭部
	  	this.Head.xRot = 0.3F;
	  	this.Head.yRot = 0F;
	    //胸部
  	    this.BoobL.xRot = -0.75F;
  	    this.BoobR.xRot = -0.75F;
	  	//Body
  	    this.Ahoke.yRot = 0.7F;
	  	this.BodyMain.xRot = 2.8F;
	  	this.Cloth03.xRot = 0.17F;
	  	this.Cloth04.xRot = -0.8F;
	  	this.Butt.xRot = -1.1F;
	  	this.Butt.z = (1.3F) + (0.1F) * 16F;
	    //arm 
	  	this.ArmLeft01.xRot = -0.35F;
	    this.ArmLeft01.zRot = -2.6F;
	    this.ArmRight01.xRot = -0.35F;
		this.ArmRight01.zRot = 2.6F;
		//leg
		this.LegLeft01.xRot = -0.24F;
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.1047F;
		this.LegRight01.xRot = -0.14F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.1047F;
	    //equip
		this.EquipBase.visible = true;
		this.EquipBase.y = (-4.5F) + (0.45F) * 16F;
		this.EquipBase.z = (7.5F) + (-0.85F) * 16F;
		this.EquipBase.xRot = -3.1F;
	    this.EquipTubeL01.xRot = -0.3F;
	  	this.EquipTubeR01.xRot = -0.3F;
	
	}

	public void applyNormalPose(float f, float f1, float f2, float f3, float f4, IShipEmotion ent)
	{

  		float angleX = Mth.cos(f2*0.08F + f * 0.25F);
  		float angleAdd1 = Mth.cos(f * 0.7F) * f1;
  		float angleAdd2 = Mth.cos(f * 0.7F + 3.1415927F) * f1;
  		float addk1 = 0;
  		float addk2 = 0;
  		
  		//水上漂浮
  		if (ent.getShipDepth(0) > 0D)
  		{
this.animTransX += (0F); this.animTransY += (angleX * 0.05F + 0.025F); this.animTransZ += (0F);
    	}

    	//leg move
  		addk1 = angleAdd1 * 0.5F - 0.24F;  //LegLeft01
	  	addk2 = angleAdd2 * 0.5F - 0.14F;  //LegRight01
    	
  	    //頭部
	  	this.Head.xRot = f4 * 0.014F + 0.1047F;
	  	this.Head.yRot = f3 * 0.01F;
	    //胸部
  	    this.BoobL.xRot = angleX * 0.05F - 0.75F;
  	    this.BoobR.xRot = angleX * 0.05F - 0.75F;
	  	//Body
  	    this.Ahoke.yRot = angleX * 0.25F + 0.7F;
	  	this.BodyMain.xRot = -0.1047F;
	  	this.Butt.xRot = 0.3142F;
	  	this.Butt.y = (3.0F) + (0F) * 16F;
	  	this.Butt.z = (1.3F) + (0F) * 16F;
	  	this.Cloth03.xRot = 0.1745F;
	  	this.Cloth04.xRot = angleX * 0.05F - 0.15F;
	    //arm 
	  	this.ArmLeft01.xRot = angleAdd2 * 0.25F + 0.21F;
	    this.ArmLeft01.zRot = angleX * 0.03F - 0.21F;
	    this.ArmRight01.xRot = angleAdd1 * 0.25F + 0.05F;
	    this.ArmRight01.yRot = 0F;
		this.ArmRight01.zRot = -angleX * 0.03F + 0.21F;
		//leg
		this.LegLeft01.yRot = 0F;
		this.LegLeft01.zRot = 0.1047F;
		this.LegRight01.yRot = 0F;
		this.LegRight01.zRot = -0.1047F;
	    //equip
	    this.EquipBase.xRot = 0.05236F;
	    this.EquipBase.y = (-4.5F) + (0F) * 16F;
		this.EquipBase.z = (7.5F) + (0F) * 16F;
	    this.EquipTubeL01.xRot = angleX * 0.08F - 0.35F;
	  	this.EquipTubeR01.xRot = -angleX * 0.08F - 0.35F;
	    
	  	boolean hideLeg = !EmotionHelper.checkModelState(1, ent.getStateEmotion(ID.S.State));
	  	
	    //fly mode
	    if (hideLeg)
	    {
	    	//body
	    	this.Cloth04.xRot += 0.23F;
		  	this.Butt.xRot = 0.7F;
		  	this.Butt.y = (3.0F) + (-0.1F) * 16F;
		  	this.Butt.z = (1.3F) + (-0.05F) * 16F;
		  	//arm
		  	this.ArmLeft01.xRot += 0.2F;
		  	this.ArmLeft01.zRot -= 0.3F;
		  	this.ArmRight01.xRot += 0.2F;
		  	this.ArmRight01.zRot += 0.3F;
		  	//equip
		  	this.EquipBase.xRot = -0.4F;
		  	this.EquipTubeL01.xRot += 0.35F;
		  	this.EquipTubeR01.xRot += 0.35F;
	    }

	    if (ent.getIsSprinting() || f1 > 0.9F)
	    {	//奔跑動作
	    	//head
	    	this.Head.xRot -= 0.2 ;
	    	//body
	    	this.BodyMain.xRot = 0.35F;
	    	this.Cloth04.xRot -= 0.4F;
	    	//arm
	    	this.ArmLeft01.zRot -= 0.2F + f1 * 0.25F;
	    	this.ArmRight01.zRot += 0.2F + f1 * 0.25F;
	    	//leg
	    	addk1 -= 0.45F;
	    	addk2 -= 0.45F;
  		}

	    //head tilt angle
	    this.Head.zRot = EmotionHelper.getHeadTiltAngle(ent, f2);
	    
	    if (ent.getIsSneaking())
	    {
	    	//潛行, 蹲下動作
this.animTransX += (0F); this.animTransY += (0.05F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 1.0472F;
		  	this.BodyMain.xRot = 1.0472F;
		  	if (hideLeg)
		  	{
		  		this.Butt.xRot = 0.8F;
		  	}
		  	else
		  	{
		  		this.Butt.xRot = -0.8378F;
		  	}
		  	this.Cloth03.xRot -= 0.7F;
		  	this.Cloth04.xRot -= 0.45F;
		    //arm 
		    this.ArmLeft01.xRot = -0.7F;
		    this.ArmLeft01.zRot = 0.2618F;
		    this.ArmRight01.xRot = -0.7F;
		    this.ArmRight01.zRot = -0.2618F;
  		}//end if sneaking
  		
	    if (ent.getIsSitting() || ent.getIsRiding())
	    {  //騎乘動作
	    	float ax = Mth.cos(f2 * 0.5F) * 0.5F;
	    	
	    	//fly mode
		    if (hideLeg)
		    {
		    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		    	{
this.animTransX += (0F); this.animTransY += (0.54F); this.animTransZ += (0F);
			    	setFace(3);
			    	
				  	//body
			    	this.Head.xRot = -0.9F;
			    	this.Head.yRot = 0F;
			    	this.Head.zRot = 0F;
			    	this.Ahoke.yRot = 0.5236F;
			    	this.BodyMain.xRot = 1.4835F;
			    	//arm
			    	this.ArmLeft01.xRot = ax + 0.25F;
			    	this.ArmLeft01.zRot = -2.3F;
			    	this.ArmRight01.xRot = -ax + 0.25F;
			    	this.ArmRight01.zRot = 2.3F;
			    	//leg
			    	this.LegLeft01.yRot = 0F;
			    	this.LegLeft01.zRot = 0.03F;
			    	this.LegRight01.yRot = 0F;
			    	this.LegRight01.zRot = -0.03F;
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (-0.17F); this.animTransZ += (0F);
			    	setFace(1);
			    	
				  	//body
			    	this.Head.xRot = -0.7F;
			    	this.Head.yRot = 0F;
			    	this.Head.zRot = 0F;
			    	this.Ahoke.yRot = 0.5236F;
			    	this.BodyMain.xRot = -1.7453F;
			    	this.Cloth04.xRot = 0.4F;
			    	//arm
			    	this.ArmLeft01.xRot = 0.85F;
			    	this.ArmLeft01.zRot = -2.3F;
			    	this.ArmRight01.xRot = 0.85F;
			    	this.ArmRight01.zRot = 2.3F;
			    	//leg
			    	this.LegLeft01.yRot = 0F;
			    	this.LegLeft01.zRot = 0.03F;
			    	this.LegRight01.yRot = 0F;
			    	this.LegRight01.zRot = -0.03F;
			    	//equip
				  	this.EquipTubeL01.xRot = 1.3F;
				  	this.EquipTubeR01.xRot = 1.3F;
		    	}
		    }
		    else
		    {
		    	if (ent.getStateEmotion(ID.S.Emotion) == ID.Emotion.BORED)
		    	{
this.animTransX += (0F); this.animTransY += (0.53F); this.animTransZ += (0F);
			    	setFace(3);
			    	
				  	//body
			    	this.Head.xRot = -0.7F;
			    	this.Head.yRot = 0F;
			    	this.Head.zRot = 0F;
			    	this.Ahoke.yRot = 0.5236F;
			    	this.BodyMain.xRot = 1.4835F;
			    	//arm
			    	this.ArmLeft01.xRot = ax + 0.25F;
			    	this.ArmLeft01.zRot = -2.3F;
			    	this.ArmRight01.xRot = -ax + 0.25F;
			    	this.ArmRight01.zRot = 2.3F;
			    	//leg
			    	addk1 = -ax + 0.2F;
			    	addk2 = ax + 0.2F;
			    	this.LegLeft01.yRot = 0F;
			    	this.LegLeft01.zRot = 0.03F;
			    	this.LegRight01.yRot = 0F;
			    	this.LegRight01.zRot = -0.03F;
		    	}
		    	else
		    	{
this.animTransX += (0F); this.animTransY += (0.42F); this.animTransZ += (0F);
			    	//body
			    	this.Head.xRot -= 0.7F;
			    	this.BodyMain.xRot = 0.5236F;
			    	//arm
			    	this.ArmLeft01.xRot = -0.5236F;
			    	this.ArmLeft01.zRot = 0.3146F;
			    	this.ArmRight01.xRot = -0.5236F;
			    	this.ArmRight01.zRot = -0.3146F;
			    	//leg
			    	addk1 = -2.2689F;
			    	addk2 = -2.2689F;
			    	this.LegLeft01.yRot = -0.3491F;
			    	this.LegRight01.yRot = 0.3491F;
			    	//equip
				  	this.EquipBase.xRot = -0.4F;
				  	this.EquipTubeL01.xRot = 0.9F;
				  	this.EquipTubeR01.xRot = 0.9F;
		    	}
		    }
  		}//end if sitting
	    
	    //攻擊動作    
	    if (ent.getAttackTick() > 40)
	    {
this.animTransX += (0F); this.animTransY += (0.08F); this.animTransZ += (0F);
	    	//Body
	    	this.Head.xRot -= 1.0472F;
		  	this.BodyMain.xRot = 1.7F;
		  	this.Butt.xRot = -0.8378F;
		  	this.Cloth03.xRot -= 0.7F;
		  	this.Cloth04.xRot -= 1.1F;
		    //arm 
		    this.ArmLeft01.xRot = -0.9F;
		    this.ArmLeft01.zRot = 0.2618F;
		    this.ArmRight01.xRot = -1.9F;
		    this.ArmRight01.zRot = -0.2618F;
		    //equip
		    this.EquipBase.xRot = -1.4F;
		    //leg
		    addk1 -= 0.7F;
		    addk2 -= 0.7F;
	    }
	    
	    //swing arm
	  	float f6 = ent.getSwingTime(f2 % 1F);
	  	if (f6 != 0F)
	  	{
	  		float f7 = Mth.sin(f6 * f6 * (float)Math.PI);
	        float f8 = Mth.sin(Mth.sqrt(f6) * (float)Math.PI);
	        this.ArmRight01.xRot += -f8 * 80.0F * Values.N.DIV_PI_180;
	        this.ArmRight01.yRot += -f7 * 20.0F * Values.N.DIV_PI_180 + 0.2F;
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

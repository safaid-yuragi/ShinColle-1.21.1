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

public class ModelMountCaWD<T extends Entity> extends ShipModel<T>
{

	public ModelPart BodyMain;
	public ModelPart Neck;
	public ModelPart WingL01a;
	public ModelPart WingR01a;
	public ModelPart Seat01;
	public ModelPart Back01;
	public ModelPart Back02;
	public ModelPart WingL03;
	public ModelPart WingR03;
	public ModelPart WingL04;
	public ModelPart WingR04;
	public ModelPart Back03;
	public ModelPart Back04;
	public ModelPart WingL02;
	public ModelPart WingR02;
	public ModelPart CannonL01;
	public ModelPart CannonR01;
	public ModelPart Tube01a;
	public ModelPart Tube02a;
	public ModelPart CannonM01;
	public ModelPart Head01;
	public ModelPart Jaw01;
	public ModelPart Head02;
	public ModelPart HeadTooth01;
	public ModelPart HeadTooth02;
	public ModelPart Jaw02;
	public ModelPart JawTooth01;
	public ModelPart JawTooth02;
	public ModelPart WingL01b;
	public ModelPart WingL01c;
	public ModelPart WingL01Fire;
	public ModelPart WingR01b;
	public ModelPart WingR01c;
	public ModelPart WingR01Fire;
	public ModelPart Seat02;
	public ModelPart Seat03;
	public ModelPart CannonL02;
	public ModelPart CannonR02;
	public ModelPart Tube01b;
	public ModelPart Tube02b;
	public ModelPart CannonM02;
	public ModelPart CannonM04;
	public ModelPart CannonM03;
	public ModelPart CannonM05;
	public ModelPart GlowBodyMain;
	public ModelPart GlowBodyMain2;
	public ModelPart GlowNeck;
	public ModelPart GlowJaw01;
	public ModelPart GlowHead01;
	public ModelPart GlowWingL01a;
	public ModelPart GlowWingL01a2;
	public ModelPart GlowWingL01b;
	public ModelPart GlowWingR01a;
	public ModelPart GlowWingR01a2;
	public ModelPart GlowWingR01b;
	public ModelPart GlowCannonL01;
	public ModelPart GlowCannonR01;
	public ModelPart GlowCannonM01;
	public ModelPart GlowCannonM02;
	public ModelPart GlowCannonM04;

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition partdef0 = partdefinition.addOrReplaceChild("BodyMain", CubeListBuilder.create().addBox(-6.5F, 0.0F, 0.0F, 13.0F, 12.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 8.0F));
		PartDefinition partdef1 = partdef0.addOrReplaceChild("Neck", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 12.0F, 5.0F), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef2 = partdef1.addOrReplaceChild("Head01", CubeListBuilder.create().addBox(-7.0F, -6.0F, -15.0F, 14.0F, 6.0F, 13.0F), PartPose.offset(0.0F, 5.8F, 5.0F));
		PartDefinition partdef3 = partdef2.addOrReplaceChild("Head02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 10.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -5.9F, -15.0F, 0.0F, 0.7853981633974483F, 0.0F));
		PartDefinition partdef4 = partdef1.addOrReplaceChild("Jaw01", CubeListBuilder.create().mirror().addBox(-7.0F, 0.0F, -15.0F, 14.0F, 6.0F, 13.0F), PartPose.offsetAndRotation(0.0F, 7.0F, 6.0F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef5 = partdef4.addOrReplaceChild("Jaw02", CubeListBuilder.create().addBox(-5.0F, 0.0F, -5.0F, 10.0F, 6.0F, 10.0F), PartPose.offsetAndRotation(0.0F, -0.1F, -15.0F, 0.0F, 0.7853981633974483F, 0.0F));
		PartDefinition partdef6 = partdef0.addOrReplaceChild("Tube01a", CubeListBuilder.create().addBox(0.0F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(4.0F, 1.0F, 9.0F, -0.7853981633974483F, 0.8726646259971648F, 0.2617993877991494F));
		PartDefinition partdef7 = partdef6.addOrReplaceChild("Tube01b", CubeListBuilder.create().addBox(0.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 1.0F, 1.3962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef8 = partdef0.addOrReplaceChild("Seat01", CubeListBuilder.create().addBox(-7.5F, 0.0F, 0.0F, 15.0F, 11.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -10.5F, 0.3F, -0.10471975511965977F, 0.0F, 0.0F));
		PartDefinition partdef9 = partdef8.addOrReplaceChild("Seat03", CubeListBuilder.create().addBox(-2.0F, 0.0F, -9.0F, 2.0F, 10.0F, 9.0F), PartPose.offsetAndRotation(-6.2F, 1.0F, 0.5F, 0.10471975511965977F, 0.10471975511965977F, -0.10471975511965977F));
		PartDefinition partdef10 = partdef8.addOrReplaceChild("Seat02", CubeListBuilder.create().addBox(0.0F, 0.0F, -9.0F, 2.0F, 10.0F, 9.0F), PartPose.offsetAndRotation(6.2F, 1.0F, 0.5F, 0.10471975511965977F, -0.10471975511965977F, 0.10471975511965977F));
		PartDefinition partdef11 = partdef0.addOrReplaceChild("WingR01a", CubeListBuilder.create().addBox(-7.0F, 0.0F, 0.0F, 7.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-6.0F, 13.5F, -4.0F, 0.0F, 0.3490658503988659F, -0.5235987755982988F));
		PartDefinition partdef12 = partdef0.addOrReplaceChild("Back01", CubeListBuilder.create().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 9.0F, 5.0F), PartPose.offset(0.0F, -9.0F, 1.0F));
		PartDefinition partdef13 = partdef0.addOrReplaceChild("Back03", CubeListBuilder.create().addBox(-9.0F, 0.0F, 0.0F, 18.0F, 14.0F, 7.0F), PartPose.offset(0.0F, -5.0F, 0.0F));
		PartDefinition partdef14 = partdef0.addOrReplaceChild("CannonM01", CubeListBuilder.create().addBox(-3.0F, -3.0F, -4.0F, 6.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -8.5F, 7.0F, -0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef15 = partdef14.addOrReplaceChild("CannonM02", CubeListBuilder.create().addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 2.0F), PartPose.offset(1.3F, -1.7F, -3.5F));
		PartDefinition partdef16 = partdef14.addOrReplaceChild("CannonM04", CubeListBuilder.create().addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 2.0F), PartPose.offset(-1.3F, -1.7F, -3.5F));
		PartDefinition partdef17 = partdef0.addOrReplaceChild("CannonR01", CubeListBuilder.create().addBox(-3.5F, -5.0F, -8.0F, 7.0F, 5.0F, 8.0F), PartPose.offsetAndRotation(-8.0F, -6.0F, 9.0F, -0.5235987755982988F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef18 = partdef0.addOrReplaceChild("WingL01a", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 7.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(6.0F, 13.5F, -4.0F, 0.0F, -0.3490658503988659F, 0.5235987755982988F));
		PartDefinition partdef19 = partdef18.addOrReplaceChild("WingL01b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 3.0F, 5.0F, 8.0F), PartPose.offsetAndRotation(6.5F, -1.5F, -4.0F, -0.08726646259971647F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef20 = partdef19.addOrReplaceChild("WingL01c", CubeListBuilder.create().addBox(-3.0F, 0.0F, -6.0F, 3.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef21 = partdef0.addOrReplaceChild("Back02", CubeListBuilder.create().addBox(-5.0F, 0.0F, 0.0F, 10.0F, 14.0F, 4.0F), PartPose.offset(0.0F, -7.0F, 6.0F));
		PartDefinition partdef22 = partdef0.addOrReplaceChild("Back04", CubeListBuilder.create().addBox(-8.0F, 0.0F, 0.0F, 16.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 7.0F, 6.0F));
		PartDefinition partdef23 = partdef0.addOrReplaceChild("CannonL01", CubeListBuilder.create().addBox(-3.5F, -5.0F, -8.0F, 7.0F, 5.0F, 8.0F), PartPose.offsetAndRotation(8.0F, -6.0F, 9.0F, -0.5235987755982988F, -0.5235987755982988F, 0.0F));
		PartDefinition partdef24 = partdef0.addOrReplaceChild("Tube02a", CubeListBuilder.create().addBox(-1.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(-5.0F, 2.0F, 9.0F, -0.7853981633974483F, -0.13962634015954636F, -0.2617993877991494F));
		PartDefinition partdef25 = partdef24.addOrReplaceChild("Tube02b", CubeListBuilder.create().addBox(-1.0F, -7.0F, -1.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 1.3962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef26 = partdefinition.addOrReplaceChild("GlowBodyMain", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 8.0F));
		PartDefinition partdef27 = partdef26.addOrReplaceChild("GlowNeck", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -5.0F));
		PartDefinition partdef28 = partdef27.addOrReplaceChild("GlowJaw01", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 7.0F, 6.0F, 0.3141592653589793F, 0.0F, 0.0F));
		PartDefinition partdef29 = partdef28.addOrReplaceChild("JawTooth01", CubeListBuilder.create().addBox(-6.5F, 0.0F, -14.0F, 13.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -0.8F, -0.8F, -0.13962634015954636F, 0.0F, 0.0F));
		PartDefinition partdef30 = partdef29.addOrReplaceChild("JawTooth02", CubeListBuilder.create().addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -13.9F, -0.07504915783575616F, 0.7853981633974483F, -0.05235987755982988F));
		PartDefinition partdef31 = partdef27.addOrReplaceChild("GlowHead01", CubeListBuilder.create(), PartPose.offset(0.0F, 5.8F, 5.0F));
		PartDefinition partdef32 = partdef31.addOrReplaceChild("HeadTooth01", CubeListBuilder.create().addBox(-6.5F, 0.0F, -6.5F, 13.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 1.9F, -7.5F, -0.13962634015954636F, 0.0F, 3.141592653589793F));
		PartDefinition partdef33 = partdef32.addOrReplaceChild("HeadTooth02", CubeListBuilder.create().addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -6.4F, -0.07504915783575616F, 0.7853981633974483F, -0.05235987755982988F));
		PartDefinition partdef34 = partdef26.addOrReplaceChild("GlowWingL01a", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 13.5F, -4.0F, 0.0F, -0.3490658503988659F, 0.5235987755982988F));
		PartDefinition partdef35 = partdef34.addOrReplaceChild("GlowWingL01b", CubeListBuilder.create(), PartPose.offsetAndRotation(6.5F, -1.5F, -4.0F, -0.08726646259971647F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef36 = partdef35.addOrReplaceChild("WingL01Fire", CubeListBuilder.create().addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 4.0F), PartPose.offset(1.5F, 2.5F, 8.1F));
		PartDefinition partdef37 = partdef26.addOrReplaceChild("GlowWingR01a", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, 13.5F, -4.0F, 0.0F, 0.3490658503988659F, -0.5235987755982988F));
		PartDefinition partdef38 = partdef37.addOrReplaceChild("GlowWingR01b", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.5F, -1.5F, -4.0F, -0.08726646259971647F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef39 = partdef38.addOrReplaceChild("WingR01Fire", CubeListBuilder.create().addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 4.0F), PartPose.offset(-1.5F, 2.5F, 8.1F));
		PartDefinition partdef40 = partdef26.addOrReplaceChild("GlowCannonL01", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, -6.0F, 9.0F, -0.5235987755982988F, -0.5235987755982988F, 0.0F));
		PartDefinition partdef41 = partdef40.addOrReplaceChild("CannonL02", CubeListBuilder.create().addBox(-1.0F, -1.0F, -12.0F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -3.2F, -7.5F, -0.2617993877991494F, 0.0F, 0.0F));
		PartDefinition partdef42 = partdef26.addOrReplaceChild("GlowCannonR01", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.0F, -6.0F, 9.0F, -0.5235987755982988F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef43 = partdef42.addOrReplaceChild("CannonR02", CubeListBuilder.create().addBox(-1.0F, -1.0F, -12.0F, 2.0F, 2.0F, 12.0F), PartPose.offset(0.0F, -3.2F, -7.5F));
		PartDefinition partdef44 = partdef26.addOrReplaceChild("GlowCannonM01", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.5F, 7.0F, -0.8726646259971648F, 0.0F, 0.0F));
		PartDefinition partdef45 = partdef44.addOrReplaceChild("GlowCannonM02", CubeListBuilder.create(), PartPose.offset(1.3F, -1.7F, -3.5F));
		PartDefinition partdef46 = partdef45.addOrReplaceChild("CannonM03", CubeListBuilder.create().addBox(0.0F, 0.0F, -6.0F, 1.0F, 1.0F, 6.0F), PartPose.offset(-0.5F, -0.7F, -2.0F));
		PartDefinition partdef47 = partdef44.addOrReplaceChild("GlowCannonM04", CubeListBuilder.create(), PartPose.offset(-1.3F, -1.7F, -3.5F));
		PartDefinition partdef48 = partdef47.addOrReplaceChild("CannonM05", CubeListBuilder.create().addBox(0.0F, 0.0F, -6.0F, 1.0F, 1.0F, 6.0F), PartPose.offset(-0.5F, -0.7F, -2.0F));
		PartDefinition partdef49 = partdefinition.addOrReplaceChild("GlowBodyMain2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 8.0F));
		PartDefinition partdef50 = partdef49.addOrReplaceChild("WingL02", CubeListBuilder.create().addBox(0.0F, -3.0F, -14.0F, 4.0F, 6.0F, 17.0F), PartPose.offsetAndRotation(6.0F, -5.0F, 6.0F, 0.0F, -0.17453292519943295F, 0.0F));
		PartDefinition partdef51 = partdef49.addOrReplaceChild("WingR02", CubeListBuilder.create().mirror().addBox(-4.0F, -3.0F, -14.0F, 4.0F, 6.0F, 17.0F), PartPose.offsetAndRotation(-6.0F, -5.0F, 6.0F, 0.0F, 0.17453292519943295F, 0.0F));
		PartDefinition partdef52 = partdef49.addOrReplaceChild("WingL03", CubeListBuilder.create().addBox(0.0F, 0.0F, -20.0F, 2.0F, 4.0F, 20.0F), PartPose.offsetAndRotation(7.5F, -0.5F, 11.0F, 0.20943951023931953F, -0.2617993877991494F, 0.0F));
		PartDefinition partdef53 = partdef49.addOrReplaceChild("WingR03", CubeListBuilder.create().mirror().addBox(-2.0F, 0.0F, -20.0F, 2.0F, 4.0F, 20.0F), PartPose.offsetAndRotation(-7.5F, -0.5F, 11.0F, 0.20943951023931953F, 0.2617993877991494F, 0.0F));
		PartDefinition partdef54 = partdef49.addOrReplaceChild("WingL04", CubeListBuilder.create().addBox(0.0F, 0.0F, -10.0F, 2.0F, 5.0F, 12.0F), PartPose.offsetAndRotation(8.0F, 6.0F, 9.0F, 0.20943951023931953F, -0.3490658503988659F, 0.17453292519943295F));
		PartDefinition partdef55 = partdef49.addOrReplaceChild("WingR04", CubeListBuilder.create().mirror().addBox(-2.0F, 0.0F, -10.0F, 2.0F, 5.0F, 12.0F), PartPose.offsetAndRotation(-8.0F, 6.0F, 9.0F, 0.20943951023931953F, 0.3490658503988659F, -0.17453292519943295F));
		PartDefinition partdef56 = partdef49.addOrReplaceChild("GlowWingL01a2", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 13.5F, -4.0F, 0.0F, -0.3490658503988659F, 0.5235987755982988F));
		PartDefinition partdef57 = partdef56.addOrReplaceChild("WingL01b", CubeListBuilder.create().addBox(0.0F, 0.0F, 0.0F, 3.0F, 5.0F, 8.0F), PartPose.offsetAndRotation(6.5F, -1.5F, -4.0F, -0.08726646259971647F, -0.08726646259971647F, 0.0F));
		PartDefinition partdef58 = partdef57.addOrReplaceChild("WingL01c", CubeListBuilder.create().addBox(-3.0F, 0.0F, -6.0F, 3.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 0.5235987755982988F, 0.0F));
		PartDefinition partdef59 = partdef49.addOrReplaceChild("GlowWingR01a2", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, 13.5F, -4.0F, 0.0F, 0.3490658503988659F, -0.5235987755982988F));
		PartDefinition partdef60 = partdef59.addOrReplaceChild("WingR01b", CubeListBuilder.create().mirror().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 5.0F, 8.0F), PartPose.offsetAndRotation(-6.5F, -1.5F, -4.0F, -0.08726646259971647F, 0.08726646259971647F, 0.0F));
		PartDefinition partdef61 = partdef60.addOrReplaceChild("WingR01c", CubeListBuilder.create().mirror().addBox(0.0F, 0.0F, -6.0F, 3.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, 0.0F, -0.5235987755982988F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	public ModelMountCaWD(ModelPart root)
	{
		this.BodyMain = root.getChild("BodyMain");
		this.Neck = root.getChild("BodyMain").getChild("Neck");
		this.WingL03 = root.getChild("GlowBodyMain2").getChild("WingL03");
		this.Tube01a = root.getChild("BodyMain").getChild("Tube01a");
		this.WingR04 = root.getChild("GlowBodyMain2").getChild("WingR04");
		this.Head02 = root.getChild("BodyMain").getChild("Neck").getChild("Head01").getChild("Head02");
		this.WingR03 = root.getChild("GlowBodyMain2").getChild("WingR03");
		this.Seat03 = root.getChild("BodyMain").getChild("Seat01").getChild("Seat03");
		this.Seat01 = root.getChild("BodyMain").getChild("Seat01");
		this.Tube02b = root.getChild("BodyMain").getChild("Tube02a").getChild("Tube02b");
		this.WingR01a = root.getChild("BodyMain").getChild("WingR01a");
		this.Back01 = root.getChild("BodyMain").getChild("Back01");
		this.JawTooth02 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw01").getChild("JawTooth01").getChild("JawTooth02");
		this.HeadTooth01 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead01").getChild("HeadTooth01");
		this.WingL01c = root.getChild("GlowBodyMain2").getChild("GlowWingL01a2").getChild("WingL01b").getChild("WingL01c");
		this.Back03 = root.getChild("BodyMain").getChild("Back03");
		this.CannonM02 = root.getChild("BodyMain").getChild("CannonM01").getChild("CannonM02");
		this.Head01 = root.getChild("BodyMain").getChild("Neck").getChild("Head01");
		this.HeadTooth02 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead01").getChild("HeadTooth01").getChild("HeadTooth02");
		this.CannonM01 = root.getChild("BodyMain").getChild("CannonM01");
		this.CannonM04 = root.getChild("BodyMain").getChild("CannonM01").getChild("CannonM04");
		this.WingR02 = root.getChild("GlowBodyMain2").getChild("WingR02");
		this.WingL01b = root.getChild("GlowBodyMain2").getChild("GlowWingL01a2").getChild("WingL01b");
		this.CannonM03 = root.getChild("GlowBodyMain").getChild("GlowCannonM01").getChild("GlowCannonM02").getChild("CannonM03");
		this.WingR01Fire = root.getChild("GlowBodyMain").getChild("GlowWingR01a").getChild("GlowWingR01b").getChild("WingR01Fire");
		this.Jaw02 = root.getChild("BodyMain").getChild("Neck").getChild("Jaw01").getChild("Jaw02");
		this.WingL01Fire = root.getChild("GlowBodyMain").getChild("GlowWingL01a").getChild("GlowWingL01b").getChild("WingL01Fire");
		this.CannonL02 = root.getChild("GlowBodyMain").getChild("GlowCannonL01").getChild("CannonL02");
		this.WingL04 = root.getChild("GlowBodyMain2").getChild("WingL04");
		this.CannonR01 = root.getChild("BodyMain").getChild("CannonR01");
		this.WingL01a = root.getChild("BodyMain").getChild("WingL01a");
		this.WingL02 = root.getChild("GlowBodyMain2").getChild("WingL02");
		this.Jaw01 = root.getChild("BodyMain").getChild("Neck").getChild("Jaw01");
		this.Seat02 = root.getChild("BodyMain").getChild("Seat01").getChild("Seat02");
		this.WingR01c = root.getChild("GlowBodyMain2").getChild("GlowWingR01a2").getChild("WingR01b").getChild("WingR01c");
		this.Tube01b = root.getChild("BodyMain").getChild("Tube01a").getChild("Tube01b");
		this.Back02 = root.getChild("BodyMain").getChild("Back02");
		this.Back04 = root.getChild("BodyMain").getChild("Back04");
		this.CannonL01 = root.getChild("BodyMain").getChild("CannonL01");
		this.CannonR02 = root.getChild("GlowBodyMain").getChild("GlowCannonR01").getChild("CannonR02");
		this.CannonM05 = root.getChild("GlowBodyMain").getChild("GlowCannonM01").getChild("GlowCannonM04").getChild("CannonM05");
		this.JawTooth01 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw01").getChild("JawTooth01");
		this.Tube02a = root.getChild("BodyMain").getChild("Tube02a");
		this.WingR01b = root.getChild("GlowBodyMain2").getChild("GlowWingR01a2").getChild("WingR01b");
		this.GlowBodyMain = root.getChild("GlowBodyMain");
		this.GlowNeck = root.getChild("GlowBodyMain").getChild("GlowNeck");
		this.GlowJaw01 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowJaw01");
		this.GlowHead01 = root.getChild("GlowBodyMain").getChild("GlowNeck").getChild("GlowHead01");
		this.GlowWingL01a = root.getChild("GlowBodyMain").getChild("GlowWingL01a");
		this.GlowWingL01b = root.getChild("GlowBodyMain").getChild("GlowWingL01a").getChild("GlowWingL01b");
		this.GlowWingR01a = root.getChild("GlowBodyMain").getChild("GlowWingR01a");
		this.GlowWingR01b = root.getChild("GlowBodyMain").getChild("GlowWingR01a").getChild("GlowWingR01b");
		this.GlowCannonL01 = root.getChild("GlowBodyMain").getChild("GlowCannonL01");
		this.GlowCannonR01 = root.getChild("GlowBodyMain").getChild("GlowCannonR01");
		this.GlowCannonM01 = root.getChild("GlowBodyMain").getChild("GlowCannonM01");
		this.GlowCannonM02 = root.getChild("GlowBodyMain").getChild("GlowCannonM01").getChild("GlowCannonM02");
		this.GlowCannonM04 = root.getChild("GlowBodyMain").getChild("GlowCannonM01").getChild("GlowCannonM04");
		this.GlowBodyMain2 = root.getChild("GlowBodyMain2");
		this.GlowWingL01a2 = root.getChild("GlowBodyMain2").getChild("GlowWingL01a2");
		this.GlowWingR01a2 = root.getChild("GlowBodyMain2").getChild("GlowWingR01a2");
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
	  	this.CannonM03.xRot = -angleX * 0.05F;
	  	this.CannonM05.xRot = angleX * 0.05F;
	    
    	//seat2 有載人動作
	    if (ent.getStateEmotion(ID.S.Emotion) > 0)
	    {
	    	this.Jaw01.xRot = 0.7F;
	    }
	    
	    //移動時顯示推進器火焰
	    if (f1 > 0.2F)
	    {
	    	this.WingL01Fire.visible = true;
	    	this.WingR01Fire.visible = true;
	    }
	    else
	    {
	    	this.WingL01Fire.visible = false;
	    	this.WingR01Fire.visible = false;
	    }
	    
	    //發光支架
	    this.GlowJaw01.xRot = this.Jaw01.xRot;
  	
	}

}

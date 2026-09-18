package com.lulan.shincolle.client.render;

import com.lulan.shincolle.client.model.ShipModel;
import com.lulan.shincolle.client.model.ShipModelBaseAdv;
import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.ID;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

/**
 * held item layer for ships (legacy LayerShipHeldItem port).
 * Walks the model's arm bone chain and applies per-model item offsets.
 */
public class ShipHeldItemLayer extends RenderLayer<Mob, EntityModel<Mob>>
{

    private final ItemInHandRenderer itemInHandRenderer;


    public ShipHeldItemLayer(RenderLayerParent<Mob, EntityModel<Mob>> renderer,
                             ItemInHandRenderer itemInHandRenderer)
    {
        super(renderer);
        this.itemInHandRenderer = itemInHandRenderer;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight,
                       Mob entity, float limbSwing, float limbSwingAmount,
                       float partialTick, float ageInTicks, float netHeadYaw, float headPitch)
    {
        if (!(entity instanceof IShipEmotion emo) || !emo.getStateFlag(ID.F.ShowHeldItem)) return;

        if (!(this.getParentModel() instanceof ShipModel<?> mainModel)) return;

        ItemStack stackMain = entity.getMainHandItem();
        ItemStack stackOff = entity.getOffhandItem();

        if (!stackMain.isEmpty())
        {
            renderHeldItem(entity, stackMain, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND,
                HumanoidArm.RIGHT, poseStack, buffer, packedLight, mainModel);
        }

        if (!stackOff.isEmpty())
        {
            renderHeldItem(entity, stackOff, ItemDisplayContext.THIRD_PERSON_LEFT_HAND,
                HumanoidArm.LEFT, poseStack, buffer, packedLight, mainModel);
        }
    }

    private void renderHeldItem(Mob entity, ItemStack stack, ItemDisplayContext type,
                                HumanoidArm handSide, PoseStack poseStack, MultiBufferSource buffer,
                                int packedLight, ShipModel<?> mainModel)
    {
        boolean isBlock = stack.getItem() instanceof net.minecraft.world.item.BlockItem;
        ModelPart[] hand = mainModel.getArmForSide(handSide);
        if (hand == null) return;

        float[] itemOffset = mainModel.getHeldItemOffset((IShipEmotion) entity, handSide, isBlock ? 1 : 0);
        float[] itemRotate = mainModel.getHeldItemRotate((IShipEmotion) entity, handSide, isBlock ? 1 : 0);
        float modelScale = mainModel.getScale();
        boolean flag = handSide == HumanoidArm.LEFT;

        poseStack.pushPose();
        if (entity.isShiftKeyDown())
        {
            poseStack.translate(0.0F, 0.2F, 0.0F);
        }

        poseStack.translate((itemOffset[0] + (float) ShinColleConfig.scaleHeldItem[1]) * (flag ? -1F : 1F),
                            itemOffset[1] + (float) ShinColleConfig.scaleHeldItem[2],
                            itemOffset[2] + (float) ShinColleConfig.scaleHeldItem[3]);

        //apply every bone in the arm chain so the item follows the hand
        for (ModelPart part : hand)
        {
            if (part != null) part.translateAndRotate(poseStack);
        }

        float s = modelScale;
        poseStack.scale(s, s, s);
        poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(-90F + itemRotate[0]));
        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(180F + itemRotate[1]));
        poseStack.mulPose(com.mojang.math.Axis.ZP.rotationDegrees(itemRotate[2]));
        poseStack.translate((float) (flag ? -1 : 1) / 16F, 0.125F, -0.625F);

        double scale = ShinColleConfig.scaleHeldItem[0];
        if (stack.getItem() instanceof net.minecraft.world.item.TieredItem
            || stack.getItem() instanceof net.minecraft.world.item.ProjectileWeaponItem
            || stack.getItem() instanceof net.minecraft.world.item.TridentItem)
        {
            poseStack.scale((float) (scale * 0.5D), (float) scale, (float) scale);
        }
        else if (isBlock)
        {
            poseStack.scale((float) (scale * 0.75D), (float) (scale * 0.75D), (float) (scale * 0.75D));
        }
        else
        {
            poseStack.scale((float) scale, (float) scale, (float) scale);
        }

        this.itemInHandRenderer.renderItem(entity, stack, type, flag, poseStack, buffer, packedLight);
        poseStack.popPose();
    }


}

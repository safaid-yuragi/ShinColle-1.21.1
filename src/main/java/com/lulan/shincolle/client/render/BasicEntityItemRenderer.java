package com.lulan.shincolle.client.render;

import com.lulan.shincolle.client.model.ModelBasicEntityItem;
import com.lulan.shincolle.item.BasicEntityItem;
import com.lulan.shincolle.reference.Reference;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

/**
 * custom item entity renderer (legacy RenderBasicEntityItem).
 */
public class BasicEntityItemRenderer extends EntityRenderer<BasicEntityItem>
{

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
        Reference.MOD_ID, Reference.TEXTURES_ENTITY + "modelbasicentityitem.png");

    private final ModelBasicEntityItem<BasicEntityItem> model;


    @SuppressWarnings("unchecked")
    public BasicEntityItemRenderer(EntityRendererProvider.Context ctx)
    {
        super(ctx);
        this.shadowRadius = 0F;
        this.model = new ModelBasicEntityItem<>(ctx.getModelSet().bakeLayer(ModModelLayers.MODELBASICENTITYITEM));
    }

    @Override
    public void render(BasicEntityItem entity, float yaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight)
    {
        poseStack.pushPose();
        poseStack.translate(0F, 0.1F, 0F);
        this.model.setupAnim(entity, entity.tickCount + partialTick, 0F, 0F, 0F, 0F);
        this.model.renderToBuffer(poseStack,
            buffer.getBuffer(RenderType.entityCutoutNoCull(getTextureLocation(entity))),
            packedLight, OverlayTexture.NO_OVERLAY, -1);
        poseStack.popPose();
        super.render(entity, yaw, partialTick, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(BasicEntityItem entity)
    {
        return TEX;
    }


}

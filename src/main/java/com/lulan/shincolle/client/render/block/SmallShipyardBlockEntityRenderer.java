package com.lulan.shincolle.client.render.block;

import com.lulan.shincolle.block.BasicBlockFacingContainer;
import com.lulan.shincolle.block.BlockSmallShipyard;
import com.lulan.shincolle.blockentity.TileEntitySmallShipyard;
import com.lulan.shincolle.client.model.ModelSmallShipyard;
import com.lulan.shincolle.client.render.ModModelLayers;
import com.lulan.shincolle.reference.Reference;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * port of legacy RenderSmallShipyard (TESR for TileEntitySmallShipyard).
 */
public class SmallShipyardBlockEntityRenderer implements BlockEntityRenderer<TileEntitySmallShipyard>
{

    private static final ResourceLocation TEXTURE_ON =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/blocks/blocksmallshipyardon.png");
    private static final ResourceLocation TEXTURE_OFF =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/blocks/blocksmallshipyardoff.png");

    private final ModelSmallShipyard<Entity> model;


    public SmallShipyardBlockEntityRenderer(BlockEntityRendererProvider.Context context)
    {
        this.model = new ModelSmallShipyard<>(context.bakeLayer(ModModelLayers.MODELSMALLSHIPYARD));
    }

    @Override
    public void render(TileEntitySmallShipyard tile, float partick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        BlockState state = tile.getBlockState();
        float angle = state.hasProperty(BasicBlockFacingContainer.FACING)
                    ? state.getValue(BasicBlockFacingContainer.FACING).toYRot() : 0F;
        boolean active = state.hasProperty(BlockSmallShipyard.ACTIVE) && state.getValue(BlockSmallShipyard.ACTIVE);
        renderShipyard(this.model, angle, active, poseStack, buffer, light, overlay);
    }

    /** render shipyard model in block space [0,1]^3; shared by item renderer */
    public static void renderShipyard(ModelSmallShipyard<?> model, float angle, boolean active, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        VertexConsumer vb = buffer.getBuffer(RenderType.entityCutout(active ? TEXTURE_ON : TEXTURE_OFF));

        poseStack.pushPose();
        poseStack.translate(0.5F, 1.5F, 0.5F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180F));
        poseStack.mulPose(Axis.YP.rotationDegrees(angle));
        model.renderModel(poseStack, vb, light, overlay);
        poseStack.popPose();
    }


}

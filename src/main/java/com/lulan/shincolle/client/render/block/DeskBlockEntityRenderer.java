package com.lulan.shincolle.client.render.block;

import com.lulan.shincolle.block.BasicBlockFacingContainer;
import com.lulan.shincolle.blockentity.TileEntityDesk;
import com.lulan.shincolle.client.model.ModelBlockDesk;
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

/**
 * port of legacy RenderDesk (TESR for TileEntityDesk).
 */
public class DeskBlockEntityRenderer implements BlockEntityRenderer<TileEntityDesk>
{

    private static final ResourceLocation TEXTURE =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/blocks/blockdesk.png");

    private final ModelBlockDesk<Entity> model;


    public DeskBlockEntityRenderer(BlockEntityRendererProvider.Context context)
    {
        this.model = new ModelBlockDesk<>(context.bakeLayer(ModModelLayers.MODELBLOCKDESK));
    }

    @Override
    public void render(TileEntityDesk tile, float partick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        float angle = tile.getBlockState().hasProperty(BasicBlockFacingContainer.FACING)
                    ? tile.getBlockState().getValue(BasicBlockFacingContainer.FACING).toYRot() : 0F;
        renderDesk(this.model, angle, poseStack, buffer, light, overlay);
    }

    /** render desk model in block space [0,1]^3; shared by item renderer */
    public static void renderDesk(ModelBlockDesk<?> model, float angle, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        VertexConsumer vb = buffer.getBuffer(RenderType.entityCutout(TEXTURE));

        poseStack.pushPose();
        poseStack.translate(0.5F, 1.5F, 0.5F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180F));
        poseStack.mulPose(Axis.YP.rotationDegrees(angle));
        model.renderModel(poseStack, vb, light, overlay);
        poseStack.popPose();
    }


}

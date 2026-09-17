package com.lulan.shincolle.client.render.block;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.lulan.shincolle.block.BasicBlockMulti;
import com.lulan.shincolle.blockentity.TileMultiGrudgeHeavy;
import com.lulan.shincolle.client.model.ModelLargeShipyard;
import com.lulan.shincolle.client.model.ModelVortex;
import com.lulan.shincolle.client.render.ModModelLayers;
import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.Reference;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;

/**
 * port of legacy RenderLargeShipyard (TESR for TileMultiGrudgeHeavy).
 */
public class LargeShipyardBlockEntityRenderer implements BlockEntityRenderer<TileMultiGrudgeHeavy>
{

    private static final ResourceLocation TEXTURE_BASE =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/blocks/blocklargeshipyard.png");
    private static final ResourceLocation VORTEX_OFF =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/blocks/modelvortex.png");
    private static final ResourceLocation VORTEX_ON =
        ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, "textures/blocks/modelvortexon.png");

    /** vortex render type without depth write (legacy GlStateManager.depthMask(false)) */
    private static final Map<ResourceLocation, RenderType> VORTEX_NODEPTH = new ConcurrentHashMap<>();

    private final ModelLargeShipyard<Entity> modelBase;
    private final ModelVortex<Entity> modelVortex;


    public LargeShipyardBlockEntityRenderer(BlockEntityRendererProvider.Context context)
    {
        this.modelBase = new ModelLargeShipyard<>(context.bakeLayer(ModModelLayers.MODELLARGESHIPYARD));
        this.modelVortex = new ModelVortex<>(context.bakeLayer(ModModelLayers.MODELVORTEX));
    }

    private static RenderType vortexType(ResourceLocation tex)
    {
        if (ShinColleConfig.vortexDepth) return RenderType.entityTranslucent(tex);
        return VORTEX_NODEPTH.computeIfAbsent(tex, t -> RenderType.create(
            Reference.MOD_ID + ":vortex",
            DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, true,
            RenderType.CompositeState.builder()
                .setShaderState(RenderStateShard.RENDERTYPE_ENTITY_TRANSLUCENT_SHADER)
                .setTextureState(new RenderStateShard.TextureStateShard(t, false, false))
                .setTransparencyState(RenderStateShard.TRANSLUCENT_TRANSPARENCY)
                .setCullState(RenderStateShard.NO_CULL)
                .setLightmapState(RenderStateShard.LIGHTMAP)
                .setOverlayState(RenderStateShard.OVERLAY)
                .setWriteMaskState(RenderStateShard.COLOR_WRITE)
                .createCompositeState(true)));
    }

    @Override
    public void render(TileMultiGrudgeHeavy tile, float partick, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        BlockState state = tile.getBlockState();
        int mbs = state.hasProperty(BasicBlockMulti.MBS) ? state.getValue(BasicBlockMulti.MBS) : 0;
        if (mbs <= 0) return;

        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        //vortex aims toward the player
        BlockPos pos = tile.getBlockPos();
        double distX = pos.getX() + 0.5D - player.getX();
        double distY = pos.getY() - 0.75D - player.getY();
        double distZ = pos.getZ() + 0.5D - player.getZ();
        float f1 = Mth.sqrt((float) (distX * distX + distZ * distZ));
        float pitch = (float) Math.atan2(f1, distY);
        float yaw = (float) Math.atan2(distX, distZ);
        float angle = (-player.tickCount - partick) % 360F;
        if (mbs > 1)
        {
            angle *= 5;
        }
        pitch += Math.PI * 0.5F;

        //base frame
        VertexConsumer vb = buffer.getBuffer(RenderType.entityCutout(TEXTURE_BASE));
        poseStack.pushPose();
        poseStack.translate(0.5F, -0.2F, 0.5F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180F));
        poseStack.scale(1F, 1.2F, 1F);
        this.modelBase.renderModel(poseStack, vb, light, overlay);
        poseStack.popPose();

        //vortex
        vb = buffer.getBuffer(vortexType(mbs > 1 ? VORTEX_ON : VORTEX_OFF));
        poseStack.pushPose();
        poseStack.translate(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(Axis.YP.rotation(yaw));
        poseStack.mulPose(Axis.XP.rotation(pitch));
        poseStack.mulPose(Axis.ZP.rotationDegrees(angle));
        this.modelVortex.renderModel(poseStack, vb, light, overlay);
        poseStack.popPose();
    }


}

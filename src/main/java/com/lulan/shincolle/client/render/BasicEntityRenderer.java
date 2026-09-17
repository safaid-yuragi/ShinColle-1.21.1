package com.lulan.shincolle.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;

/**
 * placeholder renderer for all mod entities (until Phase 7 models).
 * Draws a simple wireframe box of the entity's bounding box so the
 * entity is visible and the dispatcher never sees a null renderer.
 */
public class BasicEntityRenderer<T extends Entity> extends EntityRenderer<T>
{

    private static final ResourceLocation DUMMY_TEXTURE =
        ResourceLocation.withDefaultNamespace("textures/misc/unknown_pack.png");


    public BasicEntityRenderer(EntityRendererProvider.Context context)
    {
        super(context);
        this.shadowRadius = 0.4F;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity)
    {
        return DUMMY_TEXTURE;
    }

    @Override
    public void render(T entity, float entityYaw, float partialTick,
                       PoseStack poseStack, MultiBufferSource buffer, int packedLight)
    {
        var dims = entity.getDimensions(entity.getPose());
        float w = dims.width() * 0.5F;
        float h = dims.height();
        AABB box = new AABB(-w, 0.0, -w, w, h, w);

        VertexConsumer vc = buffer.getBuffer(RenderType.lines());
        LevelRenderer.renderLineBox(poseStack, vc, box, 0.3F, 0.7F, 0.9F, 1.0F);

        super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);
    }


}

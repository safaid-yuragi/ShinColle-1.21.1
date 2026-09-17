package com.lulan.shincolle.client.render;

import com.lulan.shincolle.entity.BasicEntityMount;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

/**
 * mount entity renderer (ship equipment mounts).
 */
public class MountRenderer extends MobRenderer<BasicEntityMount, EntityModel<BasicEntityMount>>
{

    private final ShipRenderTable.RenderInfo info;


    @SuppressWarnings("unchecked")
    public MountRenderer(EntityRendererProvider.Context ctx, int shipMiscId)
    {
        super(ctx, null, 1.5F);
        this.info = ShipRenderTable.misc(shipMiscId);
        this.model = (EntityModel<BasicEntityMount>) this.info.factory.apply(
            ctx.getModelSet().bakeLayer(this.info.layer));
        this.shadowRadius = this.info.shadow;
    }

    @Override
    public ResourceLocation getTextureLocation(BasicEntityMount entity)
    {
        return this.info.texture;
    }

    @Override
    protected float getFlipDegrees(BasicEntityMount entity)
    {
        return 0F;
    }


}

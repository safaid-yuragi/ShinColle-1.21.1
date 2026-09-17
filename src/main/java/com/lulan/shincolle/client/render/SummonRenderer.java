package com.lulan.shincolle.client.render;

import com.lulan.shincolle.entity.BasicEntitySummon;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

/**
 * summon entity renderer (rensouhou, airplanes, floating fort).
 * Render data is fixed per entity type and passed in at registration.
 */
public class SummonRenderer extends MobRenderer<BasicEntitySummon, EntityModel<BasicEntitySummon>>
{

    private final ShipRenderTable.RenderInfo info;


    @SuppressWarnings("unchecked")
    public SummonRenderer(EntityRendererProvider.Context ctx, int shipMiscId)
    {
        super(ctx, null, 0.7F);
        this.info = ShipRenderTable.misc(shipMiscId);
        this.model = (EntityModel<BasicEntitySummon>) this.info.factory.apply(
            ctx.getModelSet().bakeLayer(this.info.layer));
        this.shadowRadius = this.info.shadow;
    }

    @Override
    public ResourceLocation getTextureLocation(BasicEntitySummon entity)
    {
        return this.info.texture;
    }

    @Override
    protected float getFlipDegrees(BasicEntitySummon entity)
    {
        return 0F;
    }


}

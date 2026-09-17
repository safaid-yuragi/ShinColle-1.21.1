package com.lulan.shincolle.client.render;

import com.lulan.shincolle.entity.EntityAbyssMissile;
import com.lulan.shincolle.reference.ID;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;

/**
 * abyssal missile renderer.
 */
public class AbyssMissileRenderer extends net.minecraft.client.renderer.entity.LivingEntityRenderer<EntityAbyssMissile, EntityModel<EntityAbyssMissile>>
{

    private final ShipRenderTable.RenderInfo info;


    @SuppressWarnings("unchecked")
    public AbyssMissileRenderer(EntityRendererProvider.Context ctx)
    {
        super(ctx, null, 0.5F);
        this.info = ShipRenderTable.misc(ID.ShipMisc.AbyssalMissile);
        this.model = (EntityModel<EntityAbyssMissile>) this.info.factory.apply(
            ctx.getModelSet().bakeLayer(this.info.layer));
        this.shadowRadius = this.info.shadow;
    }

    @Override
    public ResourceLocation getTextureLocation(EntityAbyssMissile entity)
    {
        return this.info.texture;
    }


}

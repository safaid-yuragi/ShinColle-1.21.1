package com.lulan.shincolle.client.render;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

/**
 * renderer for entities with no visible model (beam / static projectiles).
 * Legacy ShipMisc.Invisible equivalent.
 */
public class InvisibleEntityRenderer<T extends Entity> extends EntityRenderer<T>
{

    public InvisibleEntityRenderer(EntityRendererProvider.Context ctx)
    {
        super(ctx);
        this.shadowRadius = 0F;
    }

    @Override
    public ResourceLocation getTextureLocation(T entity)
    {
        return TextureAtlas.LOCATION_BLOCKS;
    }


}

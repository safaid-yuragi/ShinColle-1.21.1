package com.lulan.shincolle.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

/**
 * misc model data rendered together with a host entity (e.g. takoyaki on MidwayHime)
 */
public class MiscModel
{

    public EntityModel<Entity> model;
    public ResourceLocation texture;
    public Entity entity;
    public Vec3 scale;
    public float rotX;
    public float rotY;
    public float rotZ;
    public float posX;
    public float posY;
    public float posZ;

    @SuppressWarnings("unchecked")
    public MiscModel(Entity entity, EntityModel<?> model, ResourceLocation texture)
    {
        this.entity = entity;
        this.model = (EntityModel<Entity>) model;
        this.texture = texture;
        this.scale = new Vec3(1D, 1D, 1D);
        this.rotX = 0F;
        this.rotY = 0F;
        this.rotZ = 0F;
    }


}

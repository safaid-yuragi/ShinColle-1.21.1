package com.lulan.shincolle.entity;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * static/slow projectile (legacy EntityProjectileStatic extends Entity):
 * torpedoes, floating forts etc. Moves slowly, hits on contact.
 */
public class EntityProjectileStatic extends Entity
{

    @Nullable
    private Entity owner;
    private int ownerId = -1;
    private int lifeTime = 0;
    private float atkDamage = 10F;


    public EntityProjectileStatic(EntityType<?> type, Level level)
    {
        super(type, level);
        this.noPhysics = true;
    }

    public void init(Entity owner, float damage)
    {
        this.owner = owner;
        if (owner != null) this.ownerId = owner.getId();
        this.atkDamage = damage;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {}

    @Override
    public void tick()
    {
        super.tick();

        if (++this.lifeTime > 400)
        {
            this.discard();
            return;
        }

        this.move(net.minecraft.world.entity.MoverType.SELF, this.getDeltaMovement());

        if (!this.level().isClientSide)
        {
            for (Entity e : this.level().getEntities(this, this.getBoundingBox().inflate(0.5D)))
            {
                if (e != this.owner && e.isAlive() && e.isPickable())
                {
                    e.hurt(this.damageSources().thrown(this, this.owner), this.atkDamage);
                    this.discard();
                    return;
                }
            }
        }
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag)
    {
        this.ownerId = tag.getInt("OwnerID");
        this.atkDamage = tag.getFloat("AtkDmg");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag)
    {
        tag.putInt("OwnerID", this.ownerId);
        tag.putFloat("AtkDmg", this.atkDamage);
    }


}

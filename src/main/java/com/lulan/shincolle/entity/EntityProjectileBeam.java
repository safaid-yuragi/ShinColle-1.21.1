package com.lulan.shincolle.entity;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * beam projectile (legacy EntityProjectileBeam extends Entity).
 * Straight-line damage beam; Phase 3 port keeps motion + impact only.
 */
public class EntityProjectileBeam extends Entity
{

    @Nullable
    private Entity owner;
    private int ownerId = -1;
    private int lifeTime = 0;
    private float atkDamage = 10F;


    public EntityProjectileBeam(EntityType<?> type, Level level)
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

        if (++this.lifeTime > 100)
        {
            this.discard();
            return;
        }

        this.setDeltaMovement(this.getLookAngle().scale(2.5D));
        this.hasImpulse = true;
        this.move(net.minecraft.world.entity.MoverType.SELF, this.getDeltaMovement());

        if (!this.level().isClientSide)
        {
            for (Entity e : this.level().getEntities(this, this.getBoundingBox().inflate(1D)))
            {
                if (e != this.owner && e.isAlive() && e.isPickable())
                {
                    e.hurt(this.damageSources().indirectMagic(this, this.owner), this.atkDamage);
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

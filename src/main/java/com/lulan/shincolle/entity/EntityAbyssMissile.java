package com.lulan.shincolle.entity;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * homing missile entity (legacy EntityAbyssMissile extends EntityLiving).
 * Minimal Phase 3 port: moves forward, hits on collision, dies on
 * impact or timeout. Homing logic is Phase 4.
 */
public class EntityAbyssMissile extends LivingEntity
{

    @Nullable
    private Entity owner;
    private int ownerId = -1;
    private int lifeTime = 0;
    private float atkDamage = 10F;


    public EntityAbyssMissile(EntityType<? extends EntityAbyssMissile> type, Level level)
    {
        super(type, level);
        this.setNoGravity(true);
    }

    public EntityAbyssMissile(EntityType<? extends EntityAbyssMissile> type, Level level,
                              Entity owner, float damage)
    {
        this(type, level);
        this.owner = owner;
        if (owner != null) this.ownerId = owner.getId();
        this.atkDamage = damage;
    }

    public static AttributeSupplier.Builder createAttributes()
    {
        return LivingEntity.createLivingAttributes()
            .add(Attributes.MAX_HEALTH, 4D)
            .add(Attributes.MOVEMENT_SPEED, 0D)
            .add(Attributes.KNOCKBACK_RESISTANCE, 1D);
    }

    @Override
    public boolean isNoGravity()
    {
        return true;
    }

    @Override
    public boolean isPickable()
    {
        return true;
    }

    @Override
    public void tick()
    {
        super.tick();

        if (++this.lifeTime > 200)
        {
            this.discard();
            return;
        }

        //straight flight until homing AI lands in Phase 4
        this.setDeltaMovement(this.getLookAngle().scale(0.8D));
        this.hasImpulse = true;

        //impact check
        if (!this.level().isClientSide)
        {
            for (Entity e : this.level().getEntities(this, this.getBoundingBox().inflate(0.5D)))
            {
                if (e != this.owner && e.isAlive() && e.isPickable())
                {
                    e.hurt(this.damageSources().explosion(this, this.owner), this.atkDamage);
                    this.discard();
                    return;
                }
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag)
    {
        super.addAdditionalSaveData(tag);
        tag.putInt("OwnerID", this.ownerId);
        tag.putFloat("AtkDmg", this.atkDamage);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag)
    {
        super.readAdditionalSaveData(tag);
        this.ownerId = tag.getInt("OwnerID");
        this.atkDamage = tag.getFloat("AtkDmg");
    }

    @Override
    public Iterable<ItemStack> getArmorSlots()
    {
        return java.util.Collections.emptyList();
    }

    @Override
    public ItemStack getItemBySlot(net.minecraft.world.entity.EquipmentSlot slot)
    {
        return ItemStack.EMPTY;
    }

    @Override
    public void setItemSlot(net.minecraft.world.entity.EquipmentSlot slot, ItemStack stack) {}

    @Override
    public net.minecraft.world.entity.HumanoidArm getMainArm()
    {
        return net.minecraft.world.entity.HumanoidArm.RIGHT;
    }


}

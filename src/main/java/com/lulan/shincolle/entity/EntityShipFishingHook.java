package com.lulan.shincolle.entity;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * ship fishing hook (legacy EntityShipFishingHook extends Entity).
 * Phase 3 port: bobs on water, returns to owner ship on despawn.
 * Fishing loot logic is Phase 4.
 */
public class EntityShipFishingHook extends Entity
{

    @Nullable
    private Entity owner;
    private int ownerId = -1;
    private int lifeTime = 0;


    public EntityShipFishingHook(EntityType<?> type, Level level)
    {
        super(type, level);
    }

    public void init(Entity owner)
    {
        this.owner = owner;
        if (owner != null) this.ownerId = owner.getId();
    }

    @Nullable
    public Entity getOwner()
    {
        if (this.owner == null && this.ownerId >= 0 && this.level() != null)
        {
            this.owner = this.level().getEntity(this.ownerId);
        }
        return this.owner;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {}

    @Override
    public void tick()
    {
        super.tick();

        if (++this.lifeTime > 1200)
        {
            this.discard();
            return;
        }

        //bob on water surface
        double y = this.getY();
        this.setDeltaMovement(0D, this.isInWater() ? 0.02D : -0.03D, 0D);
        this.move(net.minecraft.world.entity.MoverType.SELF, this.getDeltaMovement());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag)
    {
        this.ownerId = tag.getInt("OwnerID");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag)
    {
        tag.putInt("OwnerID", this.ownerId);
    }


}

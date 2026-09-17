package com.lulan.shincolle.entity;

import java.util.UUID;

import javax.annotation.Nullable;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.dataclass.Attrs;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.level.Level;

/**
 * summon/minion base (legacy BasicEntitySummon extends EntityCreature).
 *
 * Summons are temporary entities spawned by ships (rensouhou, planes,
 * mounts). They keep a host reference (entity id + uuid) and die with
 * their host.
 */
abstract public class BasicEntitySummon extends PathfinderMob implements IShipState
{

    protected static final EntityDataAccessor<Integer> DATA_FLAGS =
        SynchedEntityData.defineId(BasicEntitySummon.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<CompoundTag> DATA_STATE =
        SynchedEntityData.defineId(BasicEntitySummon.class, EntityDataSerializers.COMPOUND_TAG);

    protected final boolean[] StateFlag = new boolean[ID.F.LENGTH];
    protected final int[] StateMinor = new int[ID.M.LENGTH];
    protected final int[] StateTimer = new int[ID.T.LENGTH];
    protected final int[] StateEmotion = new int[ID.S.LENGTH];

    public Attrs shipAttrs;

    /** host ship entity, resolved lazily on server */
    @Nullable
    protected Entity host;
    protected int hostEntityId = -1;
    @Nullable
    protected UUID hostUUID = null;

    protected int scaleLevel = 0;
    protected boolean initScale = false;
    protected float[] scaleWidth = new float[] {0.4F, 0.4F, 0.4F, 0.4F};
    protected float[] scaleHeight = new float[] {1F, 1F, 1F, 1F};

    /** summon ammo pools */
    protected int numAmmoLight = 6;
    protected int numAmmoHeavy = 0;

    private boolean stateDirty = false;

    /** model render rotation (Phase 7) */
    public float[] rotateAngle = new float[] {0F, 0F, 0F};


    public BasicEntitySummon(EntityType<? extends BasicEntitySummon> type, Level level)
    {
        super(type, level);
        this.shipAttrs = new Attrs();
        this.setStepHeight(1F);
        this.StateFlag[ID.F.CanDrop] = true;
    }

    /* ==================== entity data ==================== */

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder)
    {
        super.defineSynchedData(builder);
        builder.define(DATA_FLAGS, 0);
        builder.define(DATA_STATE, new CompoundTag());
    }

    @Override
    public void markStateDirty()
    {
        this.stateDirty = true;
    }

    protected void syncStateIfDirty()
    {
        if (this.stateDirty && !this.level().isClientSide)
        {
            this.stateDirty = false;
            int bits = 0;
            for (int i = 0; i < StateFlag.length && i < 31; i++)
            {
                if (StateFlag[i]) bits |= (1 << i);
            }
            this.entityData.set(DATA_FLAGS, bits);
            this.entityData.set(DATA_STATE, packStateTag());
        }
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key)
    {
        super.onSyncedDataUpdated(key);

        if (this.level().isClientSide)
        {
            if (DATA_FLAGS.equals(key))
            {
                int bits = this.entityData.get(DATA_FLAGS);
                for (int i = 0; i < StateFlag.length && i < 31; i++)
                {
                    StateFlag[i] = (bits & (1 << i)) != 0;
                }
            }
            else if (DATA_STATE.equals(key))
            {
                unpackStateTag(this.entityData.get(DATA_STATE));
            }
        }
    }

    /* ==================== IShipState ==================== */

    @Override
    public boolean[] stateFlags() { return this.StateFlag; }

    @Override
    public int[] stateMinor() { return this.StateMinor; }

    @Override
    public int[] stateTimer() { return this.StateTimer; }

    @Override
    public int[] stateEmotion() { return this.StateEmotion; }

    /* ==================== host ==================== */

    @Nullable
    public Entity getHost()
    {
        return this.host;
    }

    public void setHost(@Nullable Entity host)
    {
        this.host = host;
        if (host != null)
        {
            this.hostEntityId = host.getId();
            this.hostUUID = host.getUUID();
        }
    }

    public int getScaleLevel()
    {
        return this.scaleLevel;
    }

    public void setScaleLevel(int level)
    {
        this.scaleLevel = level;
        this.initScale = true;
        this.setStepHeight(1F + level);
    }

    /** init after spawn; host entity + attrs + scale (server side) */
    public void initSummon(@Nullable Entity host, int scaleLevel)
    {
        this.setHost(host);
        this.setScaleLevel(scaleLevel);
    }

    /* ==================== attrs ==================== */

    public static AttributeSupplier.Builder createAttributes()
    {
        return PathfinderMob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 4D)
            .add(Attributes.MOVEMENT_SPEED, 0.3D)
            .add(Attributes.FOLLOW_RANGE, 64D)
            .add(Attributes.KNOCKBACK_RESISTANCE, 0D)
            .add(Attributes.STEP_HEIGHT, 0.6D);
    }

    /** 1.12 setMaxUpStep -> step height attribute */
    protected void setStepHeight(float height)
    {
        var attr = this.getAttribute(Attributes.STEP_HEIGHT);
        if (attr != null) attr.setBaseValue(height);
    }

    /** per-scale dims; called by subclass ctors */
    protected void setScaleDims(float w0, float h0, float w1, float h1, float w2, float h2, float w3, float h3)
    {
        this.scaleWidth = new float[] {w0, w1, w2, w3};
        this.scaleHeight = new float[] {h0, h1, h2, h3};
    }

    @Override
    protected net.minecraft.world.entity.EntityDimensions getDefaultDimensions(net.minecraft.world.entity.Pose pose)
    {
        int lv = Math.min(Math.max(this.scaleLevel, 0), 3);
        return net.minecraft.world.entity.EntityDimensions.scalable(this.scaleWidth[lv], this.scaleHeight[lv]);
    }

    /* ==================== lifecycle ==================== */

    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(0, new FloatGoal(this));
    }

    @Override
    public void tick()
    {
        super.tick();

        for (int i = 0; i < StateTimer.length; i++)
        {
            if (StateTimer[i] > 0) StateTimer[i]--;
        }

        if (!this.level().isClientSide)
        {
            //re-resolve host
            if (this.host == null && this.hostUUID != null && this.level() instanceof ServerLevel sl)
            {
                this.host = sl.getEntity(this.hostUUID);
            }

            //die with host
            if (this.hostUUID != null && this.tickCount > 100 && this.host == null)
            {
                this.discard();
                return;
            }
        }

        syncStateIfDirty();
    }

    @Override
    public boolean canDrownInFluidType(net.neoforged.neoforge.fluids.FluidType type)
    {
    	return false;
    }

    @Override
    public boolean removeWhenFarAway(double dist)
    {
        return this.host == null;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source)
    {
        return this.StateTimer[ID.T.ImmuneTime] > 0 || super.isInvulnerableTo(source);
    }

    /* ==================== NBT ==================== */

    @Override
    public void addAdditionalSaveData(CompoundTag tag)
    {
        super.addAdditionalSaveData(tag);
        writeStateToNBT(tag);
        tag.putInt("HostEID", this.hostEntityId);
        if (this.hostUUID != null) tag.putUUID("HostUUID", this.hostUUID);
        tag.putByte("ScaleLV", (byte) this.scaleLevel);
        tag.putInt("AmmoLight", this.numAmmoLight);
        tag.putInt("AmmoHeavy", this.numAmmoHeavy);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag)
    {
        super.readAdditionalSaveData(tag);
        readStateFromNBT(tag);
        this.hostEntityId = tag.getInt("HostEID");
        if (tag.hasUUID("HostUUID")) this.hostUUID = tag.getUUID("HostUUID");
        this.scaleLevel = tag.getByte("ScaleLV");
        this.numAmmoLight = tag.getInt("AmmoLight");
        this.numAmmoHeavy = tag.getInt("AmmoHeavy");
    }

    /* ==================== misc ==================== */

    @Override
    protected float getSoundVolume()
    {
        return ShinColleConfig.volumeShip;
    }

    @Override
    public SoundSource getSoundSource()
    {
        return SoundSource.NEUTRAL;
    }


}

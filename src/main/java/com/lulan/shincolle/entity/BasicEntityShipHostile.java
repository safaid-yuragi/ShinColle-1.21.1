package com.lulan.shincolle.entity;

import javax.annotation.Nullable;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.dataclass.Attrs;
import com.lulan.shincolle.registry.ModItems;
import com.lulan.shincolle.registry.ModSounds;
import com.lulan.shincolle.utility.BuffHelper;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

/**
 * hostile ship base (legacy BasicEntityShipHostile extends EntityMob).
 *
 * Mob variants of player ships spawn naturally with a scale level
 * (0:small mob, 1:large mob, 2:boss small, 3:boss large) that drives
 * size, attrs and egg drop chance.
 */
abstract public class BasicEntityShipHostile extends Monster implements IShipEmotion
{

    protected static final EntityDataAccessor<Integer> DATA_FLAGS =
        SynchedEntityData.defineId(BasicEntityShipHostile.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<CompoundTag> DATA_STATE =
        SynchedEntityData.defineId(BasicEntityShipHostile.class, EntityDataSerializers.COMPOUND_TAG);
    protected static final EntityDataAccessor<Byte> DATA_SCALE =
        SynchedEntityData.defineId(BasicEntityShipHostile.class, EntityDataSerializers.BYTE);

    protected final boolean[] StateFlag = new boolean[ID.F.LENGTH];
    protected final int[] StateMinor = new int[ID.M.LENGTH];
    protected final int[] StateTimer = new int[ID.T.LENGTH];
    protected final int[] StateEmotion = new int[ID.S.LENGTH];

    public Attrs shipAttrs;

    /** 0:mob small 1:mob large 2:boss small 3:boss large */
    protected int scaleLevel = 0;
    protected boolean initScale = false;

    /** entity dims per scale level, set by subclass */
    protected float[] scaleWidth = new float[] {0.6F, 1.2F, 1.8F, 2.4F};
    protected float[] scaleHeight = new float[] {1.8F, 3.6F, 5.4F, 7.2F};

    @Nullable
    protected final ServerBossEvent bossInfo = new ServerBossEvent(
        this.getDisplayName(), BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.NOTCHED_10);

    private boolean stateDirty = false;

    /** model render rotation (Phase 7) */
    public float[] rotateAngle = new float[] {0F, 0F, 0F};


    public BasicEntityShipHostile(EntityType<? extends BasicEntityShipHostile> type, Level level)
    {
        super(type, level);
        this.shipAttrs = new Attrs(0);
        this.setStepHeight(1F);
        this.StateFlag[ID.F.CanDrop] = true;
        this.StateFlag[ID.F.AtkType_Light] = true;
        this.StateFlag[ID.F.AtkType_Heavy] = true;
        this.StateFlag[ID.F.AtkType_AirLight] = true;
        this.StateFlag[ID.F.AtkType_AirHeavy] = true;
    }

    /* ==================== entity data ==================== */

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder)
    {
        super.defineSynchedData(builder);
        builder.define(DATA_FLAGS, 0);
        builder.define(DATA_STATE, new CompoundTag());
        builder.define(DATA_SCALE, (byte) 0);
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
            else if (DATA_SCALE.equals(key))
            {
                this.scaleLevel = this.entityData.get(DATA_SCALE);
                this.refreshDimensions();
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

    /* ==================== scale / attrs ==================== */

    public static AttributeSupplier.Builder createAttributes()
    {
        return Monster.createMonsterAttributes()
            .add(Attributes.MAX_HEALTH, 40D)
            .add(Attributes.MOVEMENT_SPEED, 0.25D)
            .add(Attributes.ATTACK_DAMAGE, 4D)
            .add(Attributes.FOLLOW_RANGE, 64D)
            .add(Attributes.KNOCKBACK_RESISTANCE, 0D)
            .add(Attributes.STEP_HEIGHT, 0.6D)
            .add(Attributes.ARMOR, 0D);
    }

    /** 1.12 setMaxUpStep -> step height attribute */
    protected void setStepHeight(float height)
    {
        var attr = this.getAttribute(Attributes.STEP_HEIGHT);
        if (attr != null) attr.setBaseValue(height);
    }

    public int getScaleLevel()
    {
        return this.scaleLevel;
    }

    public int getShipClassID()
    {
        return this.getStateMinor(ID.M.ShipClass);
    }

    /** attr class for raw calc; same as ship class by default */
    public int getAttrClass()
    {
        return this.getShipClassID();
    }

    /** set scale level, rescale size and attrs (server side) */
    public void setScaleLevel(int level)
    {
        this.scaleLevel = level;
        this.entityData.set(DATA_SCALE, (byte) level);
        this.initScale = true;
        this.setStepHeight(1F + level);

        setAttrsWithScaleLevel();
        this.refreshDimensions();

        if (level > 1 && !this.level().isClientSide)
        {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    /* ==================== IShipEmotion ==================== */

    @Override
    public int getTickExisted()
    {
        return this.tickCount;
    }

    @Override
    public RandomSource getRand()
    {
        return this.random;
    }

    @Override
    public boolean getIsRiding()
    {
        return false;
    }

    @Override
    public boolean getIsSitting()
    {
        return false;
    }

    @Override
    public boolean getIsSneaking()
    {
        return false;
    }

    @Override
    public boolean getIsLeashed()
    {
        return this.isLeashed();
    }

    @Override
    public void setEntitySit(boolean sit) {}

    @Override
    public double getShipDepth(int type)
    {
        return 0D;
    }

    @Override
    public float getModelRotate(int index)
    {
        return this.rotateAngle[index < 0 ? 0 : (index > 2 ? 2 : index)];
    }

    @Override
    public void setModelRotate(int index, float value)
    {
        this.rotateAngle[index < 0 ? 0 : (index > 2 ? 2 : index)] = value;
    }

    /** recalc attrs for current scale level */
    protected void setAttrsWithScaleLevel()
    {
        BuffHelper.updateAttrsRawHostile(this.shipAttrs, this.scaleLevel, this.getAttrClass());
        this.shipAttrs.checkAttrsLimit();
        this.shipAttrs.copyRaw2Buffed();

        var hp = this.getAttribute(Attributes.MAX_HEALTH);
        if (hp != null)
        {
            hp.setBaseValue(this.shipAttrs.getAttrsRaw(ID.Attrs.HP));
            this.setHealth(this.getMaxHealth());
        }
        var mov = this.getAttribute(Attributes.MOVEMENT_SPEED);
        if (mov != null) mov.setBaseValue(this.shipAttrs.getAttrsRaw(ID.Attrs.MOV));
        var kb = this.getAttribute(Attributes.KNOCKBACK_RESISTANCE);
        if (kb != null) kb.setBaseValue(this.shipAttrs.getAttrsRaw(ID.Attrs.KB));
    }

    /** subclass provides per-scale dims via {@link #scaleWidth}/{@link #scaleHeight} */
    protected void setScaleDims(float w0, float h0, float w1, float h1, float w2, float h2, float w3, float h3)
    {
        this.scaleWidth = new float[] {w0, w1, w2, w3};
        this.scaleHeight = new float[] {h0, h1, h2, h3};
    }

    @Override
    protected EntityDimensions getDefaultDimensions(Pose pose)
    {
        int lv = Math.min(Math.max(this.scaleLevel, 0), 3);
        return EntityDimensions.scalable(this.scaleWidth[lv], this.scaleHeight[lv]);
    }

    /* ==================== lifecycle ==================== */

    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8F, 0.1F));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        if (ShinColleConfig.mobAttackPlayer)
        {
            this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
        }
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
            //boss bar tracking
            if (this.scaleLevel > 1)
            {
                this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
            }

            //minion/boss despawn
            if (ShinColleConfig.despawnMinion > -1 && this.scaleLevel <= 1
                && this.tickCount > ShinColleConfig.despawnMinion && this.getTarget() == null)
            {
                this.discard();
                return;
            }
            if (ShinColleConfig.despawnBoss > -1 && this.scaleLevel > 1
                && this.tickCount > ShinColleConfig.despawnBoss && this.getTarget() == null)
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
        return this.scaleLevel <= 1;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source)
    {
        return this.StateTimer[ID.T.ImmuneTime] > 0 || super.isInvulnerableTo(source);
    }

    public boolean isShipBurning()
    {
        return this.getStateEmotion(ID.S.HPState) == ID.HPState.HEAVY;
    }

    /* ==================== damage / death ==================== */

    @Override
    public boolean hurt(DamageSource source, float amount)
    {
        boolean hit = super.hurt(source, amount);
        if (hit && !this.level().isClientSide)
        {
            this.setStateTimer(ID.T.LastCombat, 100);
        }
        return hit;
    }

    /** egg drop chance by scale: 20% / 33% / 90% / 100% */
    @Override
    protected void dropAllDeathLoot(ServerLevel level, DamageSource source)
    {
        super.dropAllDeathLoot(level, source);

        if (!this.getStateFlag(ID.F.CanDrop)) return;

        int roll = this.random.nextInt(100);
        int chance = switch (this.scaleLevel)
        {
            case 0 -> 20;
            case 1 -> 33;
            case 2 -> 90;
            default -> 100;
        };

        if (roll < chance)
        {
            ItemStack egg = new ItemStack(ModItems.SHIP_SPAWN_EGG.get());
            egg.set(com.lulan.shincolle.registry.ModComponents.SHIP_CLASS.get(), this.getShipClassID());
            CompoundTag save = new CompoundTag();
            writeShipData(save);
            egg.set(com.lulan.shincolle.registry.ModComponents.SHIP_DATA.get(),
                    net.minecraft.world.item.component.CustomData.of(save));
            this.spawnAtLocation(egg);
        }
    }

    /* ==================== NBT ==================== */

    public void writeShipData(CompoundTag tag)
    {
        writeStateToNBT(tag);
    }

    public void readShipData(CompoundTag tag)
    {
        readStateFromNBT(tag);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag)
    {
        super.addAdditionalSaveData(tag);
        writeShipData(tag);
        tag.putByte("ScaleLV", (byte) this.scaleLevel);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag)
    {
        super.readAdditionalSaveData(tag);
        readShipData(tag);
        int scale = tag.getByte("ScaleLV");
        if (scale != this.scaleLevel)
        {
            this.setScaleLevel(scale);
        }
    }

    /* ==================== boss bar ==================== */

    @Override
    public void startSeenByPlayer(ServerPlayer player)
    {
        super.startSeenByPlayer(player);
        if (this.scaleLevel > 1) this.bossInfo.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player)
    {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    /* ==================== misc ==================== */

    @Override
    public boolean shouldShowName()
    {
        return this.hasCustomName();
    }

    @Override
    protected float getSoundVolume()
    {
        return ShinColleConfig.volumeShip;
    }

    @Override
    protected void playStepSound(net.minecraft.core.BlockPos pos,
                               net.minecraft.world.level.block.state.BlockState state)
    {
        //no footstep
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound()
    {
        return ModSounds.SHIP_IDLE.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return ModSounds.SHIP_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound()
    {
        return ModSounds.SHIP_DEATH.get();
    }

    @Override
    public SoundSource getSoundSource()
    {
        return SoundSource.HOSTILE;
    }


}

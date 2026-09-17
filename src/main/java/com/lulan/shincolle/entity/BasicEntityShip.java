package com.lulan.shincolle.entity;

import java.util.UUID;

import javax.annotation.Nullable;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.dataclass.AttrsAdv;
import com.lulan.shincolle.registry.ModItems;
import com.lulan.shincolle.registry.ModSounds;
import com.lulan.shincolle.utility.BuffHelper;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.ItemStackHandler;

/**
 * ship entity base class (player-owned ships).
 *
 * Phase 3 scope: state arrays + sync, attrs, inventory, owner/team,
 * NBT save/load, sit/follow, interact basics, death -> spawn egg drop.
 * Combat, AI goals, emotion visuals and GUI are wired in Phase 4+.
 */
abstract public class BasicEntityShip extends TamableAnimal implements IShipState
{

    /** packed flag bitmask + full state tag for client sync */
    protected static final EntityDataAccessor<Integer> DATA_FLAGS =
        SynchedEntityData.defineId(BasicEntityShip.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<CompoundTag> DATA_STATE =
        SynchedEntityData.defineId(BasicEntityShip.class, EntityDataSerializers.COMPOUND_TAG);

    //legacy state arrays, indexed by ID.F / ID.M / ID.T / ID.S
    protected final boolean[] StateFlag = new boolean[ID.F.LENGTH];
    protected final int[] StateMinor = new int[ID.M.LENGTH];
    protected final int[] StateTimer = new int[ID.T.LENGTH];
    protected final int[] StateEmotion = new int[ID.S.LENGTH];

    /** ship attrs (base + equip + potion + formation + morale) */
    public AttrsAdv shipAttrs;

    /** ship inventory: 6 pages x 9 slots (legacy CapaInventory) */
    protected final ItemStackHandler shipInventory = new ItemStackHandler(54)
    {
        @Override
        protected void onContentsChanged(int slot)
        {
            BasicEntityShip.this.markStateDirty();
        }
    };

    /** model display data: {rotX, rotY, scale, ...} used by GUI preview */
    public float[] modelPosInGUI = new float[] {0F, 0F, 0F, 50F};

    /** true while state must be pushed to DATA_STATE */
    private boolean stateDirty = false;

    /** ship unique id (persisted, used by team/formation cache) */
    protected int shipUID = -1;

    //ammo/grudge consumption rates per tick, set by ship class
    protected int grudgeConsumeIdle = 5;
    protected int ammoConsumption = 1;
    protected int foodSaturationMax = 60;

    /** GUI/rendering: rotates with body for models (Phase 7) */
    public float[] rotateAngle = new float[3];


    public BasicEntityShip(EntityType<? extends BasicEntityShip> type, Level level)
    {
        super(type, level);

        //legacy default flags
        this.StateFlag[ID.F.CanFollow] = true;
        this.StateFlag[ID.F.UseMelee] = true;
        this.StateFlag[ID.F.UseAmmoLight] = true;
        this.StateFlag[ID.F.UseAmmoHeavy] = true;
        this.StateFlag[ID.F.UseAirLight] = true;
        this.StateFlag[ID.F.UseAirHeavy] = true;
        this.StateFlag[ID.F.CanPickItem] = false;

        this.StateMinor[ID.M.ShipLevel] = 1;
        this.StateMinor[ID.M.FleeHP] = 20;
        this.StateMinor[ID.M.FollowMin] = 4;
        this.StateMinor[ID.M.FollowMax] = 16;
        this.StateMinor[ID.M.ShipUID] = -1;
        this.StateMinor[ID.M.PlayerUID] = -1;
        this.StateMinor[ID.M.PlayerEID] = -1;
        this.StateMinor[ID.M.GuardID] = -1;
        this.StateMinor[ID.M.GuardDim] = 0;

        this.shipAttrs = new AttrsAdv(this.getShipClassID());

        this.setStepHeight(1F);
    }

    /** server-side init on first spawn: uid + attrs + resource defaults */
    public void initShip()
    {
        if (this.level().isClientSide) return;
        if (!(this.level() instanceof ServerLevel sl)) return;

        if (this.shipUID <= 0)
        {
            this.setShipUID(com.lulan.shincolle.data.ShipUidData.get(sl).nextUID());
        }

        this.setStateFlag(ID.F.CanDrop, true);
        this.updateShipAttrs();
        this.setHealth(this.getMaxHealth());
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

    /** flush dirty state into synched data (server side, called from tick) */
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

    /* ==================== attrs / levels ==================== */

    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
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

    public int getShipClassID()
    {
        return this.getStateMinor(ID.M.ShipClass);
    }

    public byte getShipType()
    {
        return (byte) this.getStateMinor(ID.M.ShipType);
    }

    public int getShipLevel()
    {
        return this.getStateMinor(ID.M.ShipLevel);
    }

    public void setShipLevel(int level, boolean heal)
    {
        int cap = this.getStateFlag(ID.F.IsMarried) ? 150 : 100;
        if (level > cap) level = cap;
        if (level < 1) level = 1;

        this.setStateMinor(ID.M.ShipLevel, level);
        this.shipAttrs.setAttrsBonus(ID.AttrsBase.HP, (byte) (level / 10));
        updateShipAttrs();
    }

    public int getMorale()
    {
        return this.getStateMinor(ID.M.Morale);
    }

    public void setMorale(int value)
    {
        this.setStateMinor(ID.M.Morale, value);
    }

    public int getShipUID()
    {
        return this.shipUID;
    }

    public void setShipUID(int uid)
    {
        this.shipUID = uid;
        this.setStateMinor(ID.M.ShipUID, uid);
    }

    public int getPlayerUID()
    {
        return this.getStateMinor(ID.M.PlayerUID);
    }

    public void setPlayerUID(int uid)
    {
        this.setStateMinor(ID.M.PlayerUID, uid);
    }

    public ItemStackHandler getShipInventory()
    {
        return this.shipInventory;
    }

    public AttrsAdv getAttrs()
    {
        return this.shipAttrs;
    }

    /** recompute buffed attrs and apply to MC attributes */
    public void updateShipAttrs()
    {
        BuffHelper.updateAttrsRaw(this.shipAttrs, this.getShipClassID(), this.getShipLevel());
        BuffHelper.updateBuffMorale(this.shipAttrs, this.getMorale());
        BuffHelper.applyBuffOnAttrs(this.shipAttrs);
        this.shipAttrs.checkAttrsLimit();
        applyAttrsToAttributes();
    }

    /** push shipAttrs onto vanilla attribute instances */
    protected void applyAttrsToAttributes()
    {
        float hp = this.shipAttrs.getAttrsBuffed(ID.Attrs.HP);
        if (hp < 1F) hp = 1F;

        var attr = this.getAttribute(Attributes.MAX_HEALTH);
        if (attr != null)
        {
            double old = attr.getBaseValue();
            attr.setBaseValue(hp);
            if (hp > old) this.setHealth(this.getHealth() + (float) (hp - old));
        }

        var spd = this.getAttribute(Attributes.MOVEMENT_SPEED);
        if (spd != null) spd.setBaseValue(Math.max(0.05D, this.shipAttrs.getAttrsBuffed(ID.Attrs.MOV)));

        var atk = this.getAttribute(Attributes.ATTACK_DAMAGE);
        if (atk != null) atk.setBaseValue(Math.max(0D, this.shipAttrs.getAttrsBuffed(ID.Attrs.ATK_L)));
    }

    public void setGrudgeConsumeIdle(int value) { this.grudgeConsumeIdle = value; }
    public int getGrudgeConsumeIdle() { return this.grudgeConsumeIdle; }

    public void setAmmoConsumption(int value) { this.ammoConsumption = value; }
    public int getAmmoConsumption() { return this.ammoConsumption; }

    public void setFoodSaturationMax(int value) { this.foodSaturationMax = value; }
    public int getFoodSaturationMax() { return this.foodSaturationMax; }

    public int getFoodSaturation()
    {
        return this.getStateMinor(ID.M.Food);
    }

    public void setFoodSaturation(int value)
    {
        this.setStateMinor(ID.M.Food, Math.min(value, this.foodSaturationMax));
    }

    /** equip layout: 1:cannon+misc 2:cannon+airplane+misc 3:airplane+misc */
    public int getEquipType()
    {
        return 1;
    }

    /** can launch carrier aircraft, CV subclasses override */
    public boolean canSummonMounts()
    {
        return false;
    }

    /* ==================== lifecycle ==================== */

    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(8, new com.lulan.shincolle.ai.ShipFollowOwnerGoal(this));
    }

    @Override
    public void tick()
    {
        super.tick();

        //countdown timers
        for (int i = 0; i < StateTimer.length; i++)
        {
            if (StateTimer[i] > 0)
            {
                StateTimer[i]--;
            }
        }

        //push dirty state to clients
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
        return false;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source)
    {
        return this.StateTimer[ID.T.ImmuneTime] > 0 || super.isInvulnerableTo(source);
    }

    /** burning visual when heavily damaged (legacy isBurning) */
    public boolean isShipBurning()
    {
        return this.getStateEmotion(ID.S.HPState) == ID.HPState.HEAVY;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob partner)
    {
        return null;
    }

    @Override
    public boolean isFood(ItemStack stack)
    {
        return false;
    }

    /* ==================== interact ==================== */

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand)
    {
        if (hand == InteractionHand.OFF_HAND || !this.isAlive()) return InteractionResult.FAIL;

        ItemStack stack = player.getItemInHand(hand);

        if (!this.level().isClientSide)
        {
            if (!stack.isEmpty())
            {
                //name tag, owner only
                if (stack.is(Items.NAME_TAG) && this.isOwnedBy(player))
                {
                    if (stack.has(DataComponents.CUSTOM_NAME))
                    {
                        this.setCustomName(stack.get(DataComponents.CUSTOM_NAME));
                        return InteractionResult.SUCCESS;
                    }
                }
                //training book: +5~10 level
                else if (stack.is(ModItems.TRAINING_BOOK))
                {
                    if (this.getShipLevel() < 150)
                    {
                        int lv = this.getShipLevel() + 5 + this.random.nextInt(6);
                        this.setShipLevel(lv, true);
                        this.level().playSound(null, this.blockPosition(), ModSounds.SHIP_LEVEL.get(),
                            SoundSource.NEUTRAL, 0.75F, 1F);
                        this.level().playSound(null, this.blockPosition(), SoundEvents.PLAYER_LEVELUP,
                            SoundSource.NEUTRAL, 0.75F, 1F);
                        stack.shrink(1);
                    }
                    return InteractionResult.SUCCESS;
                }
                //lead: clear path
                else if (stack.is(Items.LEAD))
                {
                    this.getNavigation().stop();
                    return InteractionResult.SUCCESS;
                }
                //feed grudge / ammo
                else if (this.tryFeed(stack, player))
                {
                    return InteractionResult.SUCCESS;
                }
            }

            //owner right click
            if (this.isOwnedBy(player))
            {
                if (player.isShiftKeyDown())
                {
                    //open GUI (Phase 6); fall through to sit toggle for now
                    return InteractionResult.SUCCESS;
                }

                this.setOrderedToSit(!this.isOrderedToSit());
                return InteractionResult.SUCCESS;
            }
        }
        else
        {
            if (this.isOwnedBy(player)) return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    /** feed ship: grudge/ammo items refill NumGrudge/NumAmmo */
    protected boolean tryFeed(ItemStack stack, Player player)
    {
        if (stack.is(ModItems.GRUDGE) || stack.is(ModItems.GRUDGE_1))
        {
            this.setStateMinor(ID.M.NumGrudge, this.getStateMinor(ID.M.NumGrudge) + 9);
            this.level().playSound(null, this.blockPosition(), ModSounds.SHIP_FEED.get(),
                SoundSource.NEUTRAL, 0.75F, 1F);
            stack.shrink(1);
            return true;
        }

        if (stack.is(ModItems.AMMO))
        {
            this.setStateMinor(ID.M.NumAmmoLight, this.getStateMinor(ID.M.NumAmmoLight) + 9);
            this.level().playSound(null, this.blockPosition(), ModSounds.SHIP_FEED.get(),
                SoundSource.NEUTRAL, 0.75F, 1F);
            stack.shrink(1);
            return true;
        }

        return false;
    }

    /** tame ship to player (spawn egg / owner paper) */
    public void tameTo(Player player)
    {
        this.tame(player);
        this.setPlayerUID(player.getId());
        this.setStateMinor(ID.M.PlayerEID, player.getId());
    }

    @Override
    public boolean canBeLeashed()
    {
        return true;
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

    /** legacy behaviour: on death the ship collapses into a spawn egg
     *  carrying its saved data (Phase 3-6). */
    @Override
    protected void dropAllDeathLoot(ServerLevel level, DamageSource source)
    {
        super.dropAllDeathLoot(level, source);

        if (!this.getStateFlag(ID.F.CanDrop)) return;

        ItemStack egg = new ItemStack(ModItems.SHIP_SPAWN_EGG.get());
        egg.set(com.lulan.shincolle.registry.ModComponents.SHIP_CLASS.get(), this.getShipClassID());

        CompoundTag save = new CompoundTag();
        this.writeShipData(save);
        egg.set(com.lulan.shincolle.registry.ModComponents.SHIP_DATA.get(),
                net.minecraft.world.item.component.CustomData.of(save));

        this.spawnAtLocation(egg);
    }

    /* ==================== NBT ==================== */

    /** full ship state for the spawn egg / persistence */
    public void writeShipData(CompoundTag tag)
    {
        writeStateToNBT(tag);

        //inventory
        ListTag items = new ListTag();
        for (int i = 0; i < this.shipInventory.getSlots(); i++)
        {
            ItemStack stack = this.shipInventory.getStackInSlot(i);
            if (!stack.isEmpty())
            {
                CompoundTag it = new CompoundTag();
                it.putByte("Slot", (byte) i);
                it.put("Stack", stack.save(this.registryAccess()));
                items.add(it);
            }
        }
        tag.put("ShipInventory", items);

        //attrs (float[] stored as int bits; 1.21 CompoundTag has no float array)
        CompoundTag attrs = new CompoundTag();
        float[] rawArr = this.shipAttrs.getAttrsRaw();
        int[] rawBits = new int[rawArr.length];
        for (int i = 0; i < rawArr.length; i++) rawBits[i] = Float.floatToIntBits(rawArr[i]);
        attrs.putIntArray("AttrsRaw", rawBits);
        attrs.putByteArray("AttrsBonus", this.shipAttrs.getAttrsBonus());
        tag.put("Attrs", attrs);

        tag.putInt("GrudgeConsumeIdle", this.grudgeConsumeIdle);
        tag.putInt("AmmoConsumption", this.ammoConsumption);
        tag.putInt("FoodSaturationMax", this.foodSaturationMax);
    }

    public void readShipData(CompoundTag tag)
    {
        readStateFromNBT(tag);

        //inventory
        ListTag items = tag.getList("ShipInventory", Tag.TAG_COMPOUND);
        for (int i = 0; i < items.size(); i++)
        {
            CompoundTag it = items.getCompound(i);
            int slot = it.getByte("Slot") & 255;
            if (slot < this.shipInventory.getSlots())
            {
                ItemStack.parse(this.registryAccess(), it.getCompound("Stack"))
                         .ifPresent(s -> this.shipInventory.setStackInSlot(slot, s));
            }
        }

        if (tag.contains("Attrs", Tag.TAG_COMPOUND))
        {
            CompoundTag attrs = tag.getCompound("Attrs");
            int[] rawBits = attrs.getIntArray("AttrsRaw");
            float[] raw = new float[rawBits.length];
            for (int i = 0; i < rawBits.length; i++) raw[i] = Float.intBitsToFloat(rawBits[i]);
            if (raw.length == this.shipAttrs.getAttrsRaw().length)
            {
                this.shipAttrs.setAttrsRaw(raw);
            }
            byte[] bonus = attrs.getByteArray("AttrsBonus");
            if (bonus.length == this.shipAttrs.getAttrsBonus().length)
            {
                this.shipAttrs.setAttrsBonus(bonus);
            }
        }

        this.grudgeConsumeIdle = tag.getInt("GrudgeConsumeIdle");
        this.ammoConsumption = tag.getInt("AmmoConsumption");
        this.foodSaturationMax = tag.getInt("FoodSaturationMax");
        if (this.foodSaturationMax <= 0) this.foodSaturationMax = 60;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag)
    {
        super.addAdditionalSaveData(tag);
        writeShipData(tag);
        tag.putInt("ShipUID", this.shipUID);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag)
    {
        super.readAdditionalSaveData(tag);
        readShipData(tag);
        this.shipUID = tag.getInt("ShipUID");
        this.updateShipAttrs();
    }

    /* ==================== misc ==================== */

    @Override
    public boolean shouldShowName()
    {
        return this.hasCustomName();
    }

    /** get sound volume (ConfigHandler.volumeShip) */
    @Override
    protected float getSoundVolume()
    {
        return ShinColleConfig.volumeShip;
    }

    @Override
    protected void playStepSound(net.minecraft.core.BlockPos pos, net.minecraft.world.level.block.state.BlockState state)
    {
        //ships have no footstep sound
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
        return SoundSource.NEUTRAL;
    }


}

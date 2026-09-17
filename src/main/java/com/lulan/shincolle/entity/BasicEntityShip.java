package com.lulan.shincolle.entity;

import java.util.UUID;

import javax.annotation.Nullable;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.ai.path.ShipMoveControl;
import com.lulan.shincolle.ai.path.ShipPathNavigation;
import com.lulan.shincolle.reference.dataclass.Attrs;
import com.lulan.shincolle.reference.dataclass.AttrsAdv;
import com.lulan.shincolle.reference.dataclass.MissileData;
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
import net.minecraft.world.entity.Entity;
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
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.ItemStackHandler;
import java.util.HashMap;
import java.util.Random;

/**
 * ship entity base class (player-owned ships).
 *
 * Phase 3 scope: state arrays + sync, attrs, inventory, owner/team,
 * NBT save/load, sit/follow, interact basics, death -> spawn egg drop.
 * Combat, AI goals, emotion visuals and GUI are wired in Phase 4+.
 */
abstract public class BasicEntityShip extends TamableAnimal implements IShipGuardian, IShipCannonAttack, IFloatingEntity
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

    /** ship path navigation (created in createNavigation) */
    protected ShipPathNavigation shipNavigate;

    /** attack target / revenge target (server side entity refs) */
    @Nullable
    protected Entity entityTarget;
    @Nullable
    protected Entity revengeTarget;
    protected int revengeTime = 0;

    /** guarded entity ref + last waypoint */
    @Nullable
    protected Entity guardedEntity;
    protected net.minecraft.core.BlockPos lastWaypoint = net.minecraft.core.BlockPos.ZERO;

    /** liquid depth for floating AI */
    protected double entityDepth = 0D;
    protected double entityFloatingDepth = 0D;

    /** buffs on self: potion id -> level; effects on hit: potion id -> {amp, ticks, chance%} */
    protected HashMap<Integer, Integer> buffMap = new HashMap<>();
    protected HashMap<Integer, int[]> attackEffectMap = new HashMap<>();

    /** missile params per attack type: 0 melee 1 light 2 heavy 3 air light 4 air heavy */
    protected MissileData[] missileData = new MissileData[5];

    /** fishing hook entity for fishing task */
    @Nullable
    public EntityShipFishingHook fishHook;

    /** model scale level (morph display) */
    protected int scaleLevel = 0;


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

        for (int i = 0; i < 5; i++) this.missileData[i] = new MissileData();

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
    protected PathNavigation createNavigation(Level level)
    {
        this.shipNavigate = new ShipPathNavigation(this, level);
        this.moveControl = new ShipMoveControl(this, 30F, false);
        return this.shipNavigate;
    }

    @Override
    protected void registerGoals()
    {
        //legacy AIHandler priorities
        this.goalSelector.addGoal(1, new com.lulan.shincolle.ai.ShipSitGoal(this));
        this.goalSelector.addGoal(2, new com.lulan.shincolle.ai.ShipFleeGoal(this));
        this.goalSelector.addGoal(3, new com.lulan.shincolle.ai.ShipGuardingGoal(this));
        this.goalSelector.addGoal(4, new com.lulan.shincolle.ai.ShipFollowOwnerGoal(this));
        this.goalSelector.addGoal(5, new com.lulan.shincolle.ai.ShipOpenDoorGoal(this, true));
        this.goalSelector.addGoal(11, new com.lulan.shincolle.ai.ShipPickItemGoal(this, 6F));
        this.goalSelector.addGoal(12, new com.lulan.shincolle.ai.ShipRangeAttackGoal(this));
        this.goalSelector.addGoal(13, new com.lulan.shincolle.ai.ShipSkillAttackGoal(this));
        this.goalSelector.addGoal(15, new com.lulan.shincolle.ai.ShipAttackOnCollideGoal(this, 1D));
        this.goalSelector.addGoal(23, new com.lulan.shincolle.ai.ShipFloatingGoal(this));
        this.goalSelector.addGoal(24, new com.lulan.shincolle.ai.ShipWanderGoal(this, 10, 5, 0.8D));
        this.goalSelector.addGoal(25, new com.lulan.shincolle.ai.ShipWatchClosestGoal(this, Player.class, 4F, 0.06F));
        this.goalSelector.addGoal(26, new com.lulan.shincolle.ai.ShipLookIdleGoal(this));

        this.targetSelector.addGoal(1, new com.lulan.shincolle.ai.ShipRevengeTargetGoal(this));
        this.targetSelector.addGoal(5, new com.lulan.shincolle.ai.ShipRangeTargetGoal(this));
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

        if (!this.level().isClientSide)
        {
            //liquid depth for floating AI
            this.entityDepth = com.lulan.shincolle.utility.EntityHelper.getEntityDepth(this);

            //target cleanup (dead / friendly / stale revenge)
            com.lulan.shincolle.utility.TargetHelper.updateTarget(this);

            //idle grudge consume + task update every 8 ticks
            if ((this.tickCount & 7) == 0)
            {
                decrGrudgeNum(this.grudgeConsumeIdle);
                com.lulan.shincolle.utility.TaskHelper.onUpdateTask(this);
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

    /* ==================== IShipNavigator ==================== */

    @Override
    public ShipPathNavigation getShipNavigate()
    {
        return this.shipNavigate;
    }

    /* ==================== IShipOwner ==================== */

    @Nullable
    @Override
    public Entity getHostEntity()
    {
        //ship's host = owner player
        return this.getOwner();
    }

    /* ==================== IShipEmotion ==================== */

    @Override
    public int getTickExisted()
    {
        return this.tickCount;
    }

    @Override
    public net.minecraft.util.RandomSource getRand()
    {
        return this.random;
    }

    @Override
    public boolean getIsRiding()
    {
        return this.isPassenger();
    }

    @Override
    public boolean getIsSitting()
    {
        return this.isOrderedToSit();
    }

    @Override
    public boolean getIsSneaking()
    {
        return this.isShiftKeyDown();
    }

    @Override
    public boolean getIsLeashed()
    {
        return this.isLeashed();
    }

    @Override
    public void setEntitySit(boolean sit)
    {
        this.setOrderedToSit(sit);
    }

    @Override
    public double getShipDepth(int type)
    {
        return this.entityDepth;
    }

    @Override
    public int getScaleLevel()
    {
        return this.scaleLevel;
    }

    @Override
    public void setScaleLevel(int level)
    {
        this.scaleLevel = level;
    }

    @Override
    public float getModelRotate(int index)
    {
        return this.rotateAngle[index];
    }

    @Override
    public void setModelRotate(int index, float value)
    {
        this.rotateAngle[index] = value;
    }

    /* ==================== IFloatingEntity ==================== */

    @Override
    public double getEntityDepth()
    {
        return this.entityDepth;
    }

    @Override
    public void setEntityDepth(double depth)
    {
        this.entityDepth = depth;
    }

    @Override
    public double getEntityFloatingDepth()
    {
        return this.entityFloatingDepth;
    }

    @Override
    public void setEntityFloatingDepth(double depth)
    {
        this.entityFloatingDepth = depth;
    }

    /* ==================== IShipAttackBase ==================== */

    @Nullable
    @Override
    public Entity getEntityTarget()
    {
        return this.entityTarget;
    }

    @Override
    public void setEntityTarget(@Nullable Entity target)
    {
        this.entityTarget = target;
    }

    @Nullable
    @Override
    public Entity getEntityRevengeTarget()
    {
        return this.revengeTarget;
    }

    @Override
    public void setEntityRevengeTarget(@Nullable Entity target)
    {
        this.revengeTarget = target;
        this.revengeTime = this.tickCount;
    }

    @Override
    public int getEntityRevengeTime()
    {
        return this.revengeTime;
    }

    /** mark revenge at current tick (legacy no-arg setter) */
    @Override
    public void setEntityRevengeTime()
    {
        this.revengeTime = this.tickCount;
    }

    @Override
    public int getDamageType()
    {
        return this.getStateMinor(ID.M.DamageType);
    }

    /** attack type flag, id = ID.F.AtkType_* */
    @Override
    public boolean getAttackType(int id)
    {
        return this.getStateFlag(id);
    }

    @Override
    public int getAmmoLight()
    {
        return this.getStateMinor(ID.M.NumAmmoLight);
    }

    @Override
    public int getAmmoHeavy()
    {
        return this.getStateMinor(ID.M.NumAmmoHeavy);
    }

    @Override
    public void setAmmoLight(int num)
    {
        this.setStateMinor(ID.M.NumAmmoLight, Math.max(0, num));
    }

    @Override
    public void setAmmoHeavy(int num)
    {
        this.setStateMinor(ID.M.NumAmmoHeavy, Math.max(0, num));
    }

    @Override
    public boolean hasAmmoLight()
    {
        return this.getStateMinor(ID.M.NumAmmoLight) > 0;
    }

    @Override
    public boolean hasAmmoHeavy()
    {
        return this.getStateMinor(ID.M.NumAmmoHeavy) > 0;
    }

    @Override
    public int getLevel()
    {
        return this.getStateMinor(ID.M.ShipLevel);
    }

    /** skill attack update; subclasses with skills override */
    @Override
    public boolean updateSkillAttack(Entity target)
    {
        return false;
    }

    @Override
    public HashMap<Integer, Integer> getBuffMap()
    {
        return this.buffMap;
    }

    @Override
    public void setBuffMap(HashMap<Integer, Integer> map)
    {
        this.buffMap = map;
    }

    @Override
    public HashMap<Integer, int[]> getAttackEffectMap()
    {
        return this.attackEffectMap;
    }

    @Override
    public void setAttackEffectMap(HashMap<Integer, int[]> map)
    {
        this.attackEffectMap = map;
    }

    @Override
    public MissileData getMissileData(int type)
    {
        return this.missileData[type];
    }

    @Override
    public void setMissileData(int type, MissileData data)
    {
        this.missileData[type] = data;
    }

    /* ==================== IShipGuardian ==================== */

    @Nullable
    @Override
    public Entity getGuardedEntity()
    {
        //resolve by entity id
        if (this.guardedEntity == null && this.getStateMinor(ID.M.GuardID) > 0)
        {
            Entity e = this.level().getEntity(this.getStateMinor(ID.M.GuardID));
            if (e != null && e.isAlive()) this.guardedEntity = e;
        }

        return this.guardedEntity;
    }

    @Override
    public void setGuardedEntity(@Nullable Entity entity)
    {
        if (entity != null && entity.isAlive())
        {
            this.guardedEntity = entity;
            this.setStateMinor(ID.M.GuardID, entity.getId());
        }
        else
        {
            this.guardedEntity = null;
            this.setStateMinor(ID.M.GuardID, -1);
        }
    }

    /** index 0:x 1:y 2:z 3:dim 4:type */
    @Override
    public int getGuardedPos(int index)
    {
        return switch (index)
        {
            case 0 -> this.getStateMinor(ID.M.GuardX);
            case 1 -> this.getStateMinor(ID.M.GuardY);
            case 2 -> this.getStateMinor(ID.M.GuardZ);
            case 3 -> this.getStateMinor(ID.M.GuardDim);
            case 4 -> this.getStateMinor(ID.M.GuardType);
            default -> -1;
        };
    }

    @Override
    public void setGuardedPos(int x, int y, int z, int dim, int type)
    {
        this.setStateMinor(ID.M.GuardX, x);
        this.setStateMinor(ID.M.GuardY, y);
        this.setStateMinor(ID.M.GuardZ, z);
        this.setStateMinor(ID.M.GuardDim, dim);
        this.setStateMinor(ID.M.GuardType, type);
    }

    @Override
    public net.minecraft.core.BlockPos getLastWaypoint()
    {
        return this.lastWaypoint;
    }

    @Override
    public void setLastWaypoint(net.minecraft.core.BlockPos pos)
    {
        this.lastWaypoint = pos;
    }

    @Override
    public int getWpStayTime()
    {
        return this.getStateTimer(ID.T.WpStayTime);
    }

    @Override
    public int getWpStayTimeMax()
    {
        return wpStayTime2Ticks(this.getStateMinor(ID.M.WpStay));
    }

    @Override
    public void setWpStayTime(int time)
    {
        this.setStateTimer(ID.T.WpStayTime, time);
    }

    /** convert waypoint stay setting to ticks (legacy GuardHandler) */
    public static int wpStayTime2Ticks(int wpstay)
    {
        if (wpstay >= 1 && wpstay <= 5) return wpstay * 100;
        if (wpstay >= 6 && wpstay <= 10) return (wpstay - 5) * 1200;
        if (wpstay >= 11 && wpstay <= 16) return (wpstay - 10) * 12000;
        return 0;
    }

    /* ==================== IShipCannonAttack ==================== */

    @Override
    public boolean useAmmoLight()
    {
        return this.getStateFlag(ID.F.UseAmmoLight);
    }

    @Override
    public boolean useAmmoHeavy()
    {
        return this.getStateFlag(ID.F.UseAmmoHeavy);
    }

    /**
     * consume ammo from state; 0:light 1:heavy. Auto-consumes ammo
     * items from inventory when empty (legacy decrAmmoNum).
     */
    public boolean decrAmmoNum(int type, int amount)
    {
        int cur = (type == 0) ? this.getStateMinor(ID.M.NumAmmoLight)
                            : this.getStateMinor(ID.M.NumAmmoHeavy);

        if (cur < amount)
        {
            //try consume ammo item from inventory
            int rest = amount - cur;
            int got = consumeAmmoItem(type, rest);
            cur += got;

            if (cur < amount) return false;
        }

        if (type == 0)
        {
            this.setStateMinor(ID.M.NumAmmoLight, cur - amount);
        }
        else
        {
            this.setStateMinor(ID.M.NumAmmoHeavy, cur - amount);
        }

        return true;
    }

    /** pull ammo items out of the ship inventory, returns units gained */
    protected int consumeAmmoItem(int type, int need)
    {
        int got = 0;

        for (int i = 0; i < this.shipInventory.getSlots() && got < need; i++)
        {
            ItemStack s = this.shipInventory.getStackInSlot(i);

            if (s.isEmpty()) continue;

            //light ammo item (meta0) = 1 unit; heavy uses heavy ammo item
            boolean lightItem = s.is(ModItems.AMMO.get()) || s.is(ModItems.AMMO_1.get());
            boolean heavyItem = s.is(ModItems.AMMO_2.get()) || s.is(ModItems.AMMO_3.get());

            if ((type == 0 && lightItem) || (type == 1 && heavyItem))
            {
                got += s.getCount();
                this.shipInventory.setStackInSlot(i, ItemStack.EMPTY);
            }
        }

        return got;
    }

    /** consume grudge; auto-eats grudge items when empty (legacy decrGrudge) */
    public void decrGrudgeNum(int value)
    {
        float modGrudge = this.shipAttrs.getAttrsBuffed(ID.Attrs.GRUDGE);

        if (value > 0)
        {
            int level = BuffHelper.getPotionLevel(this.buffMap, 17);
            value = (int) (value * (1F + level * 2F));
        }
        else if (value < 0)
        {
            value = (int) (value * modGrudge);
        }

        if (!this.getStateFlag(ID.F.NoFuel))
        {
            this.addGrudge(-value);
        }

        //auto eat one grudge item when empty
        if (this.getStateMinor(ID.M.NumGrudge) <= 0)
        {
            int got = consumeGrudgeItem();
            int add = 0;

            if (got == 0) add = (int) (ShinColleConfig.baseGrudge * modGrudge);
            else if (got == 1) add = (int) (ShinColleConfig.baseGrudge * 9 * modGrudge);

            this.addGrudge(add);
        }

        this.setStateFlag(ID.F.NoFuel, this.getStateMinor(ID.M.NumGrudge) <= 0);
    }

    /** find + consume one grudge item; 0:item 1:block -1:none */
    protected int consumeGrudgeItem()
    {
        for (int i = 0; i < this.shipInventory.getSlots(); i++)
        {
            ItemStack s = this.shipInventory.getStackInSlot(i);

            if (s.isEmpty()) continue;

            if (s.is(com.lulan.shincolle.registry.ModBlocks.ITEM_GRUDGE.get()))
            {
                s.shrink(1);
                return 1;
            }
            if (s.is(ModItems.GRUDGE.get()) || s.is(ModItems.GRUDGE_1.get()))
            {
                s.shrink(1);
                return 0;
            }
        }

        return -1;
    }

    public void addGrudge(int value)
    {
        if (value > 0 && ShinColleConfig.easyMode) value *= 10;
        this.setStateMinor(ID.M.NumGrudge, Math.max(0, this.getStateMinor(ID.M.NumGrudge) + value));
    }

    public void addAmmoLight(int value)
    {
        if (value > 0 && ShinColleConfig.easyMode) value *= 10;
        this.setStateMinor(ID.M.NumAmmoLight, Math.max(0, this.getStateMinor(ID.M.NumAmmoLight) + value));
    }

    public void addAmmoHeavy(int value)
    {
        if (value > 0 && ShinColleConfig.easyMode) value *= 10;
        this.setStateMinor(ID.M.NumAmmoHeavy, Math.max(0, this.getStateMinor(ID.M.NumAmmoHeavy) + value));
    }

    public void addMorale(int value)
    {
        int n = this.getMorale() + value;
        if (n < 0) n = 0;
        else if (n > 16000) n = 16000;
        this.setMorale(n);
    }

    /** morale decrease by attack type 0:melee 1:light 2:heavy 3:airL 4:airH */
    public void decrMorale(int type)
    {
        switch (type)
        {
        case 0 -> addMorale(-2);
        case 1 -> addMorale(-4);
        case 2 -> addMorale(-6);
        case 3 -> addMorale(-6);
        case 4 -> addMorale(-8);
        default -> {}
        }
    }

    /** combat start marker (legacy records current tick + immunity window) */
    protected int lastCombatTick = 0;

    public void setCombatTick(int tick)
    {
        this.lastCombatTick = tick;
        this.setStateTimer(ID.T.LastCombat, 100);
    }

    public int getLastCombatTick()
    {
        return this.lastCombatTick;
    }

    /* ==================== attack ==================== */

    /** base attack damage for type 0:melee 1:light 2:heavy 3:airL 4:airH */
    public float getAttackBaseDamage(int type, @Nullable Entity target)
    {
        float dmg = switch (type)
        {
            case 1 -> this.shipAttrs.getAttrsBuffed(ID.Attrs.ATK_L);
            case 2 -> this.shipAttrs.getAttrsBuffed(ID.Attrs.ATK_H);
            case 3 -> this.shipAttrs.getAttrsBuffed(ID.Attrs.ATK_AL);
            case 4 -> this.shipAttrs.getAttrsBuffed(ID.Attrs.ATK_AH);
            default -> this.shipAttrs.getAttrsBuffed(ID.Attrs.ATK_L) * 0.125F;
        };

        if (target != null)
        {
            dmg = com.lulan.shincolle.utility.CombatHelper.modDamageByAttrs(this, target, dmg);
        }

        return dmg;
    }

    /** melee attack (legacy attackEntityAsMob) */
    @Override
    public boolean doHurtTarget(Entity target)
    {
        float atk = getAttackBaseDamage(0, target);

        this.addShipExp(ShinColleConfig.expGain[0]);
        decrMorale(0);
        setCombatTick(this.tickCount);

        boolean isTargetHurt = target.hurt(this.damageSources().mobAttack(this), atk);

        if (isTargetHurt)
        {
            if (!com.lulan.shincolle.utility.TeamHelper.checkSameOwner(this, target))
            {
                BuffHelper.applyBuffOnTarget(target, this.attackEffectMap);
            }
        }

        return isTargetHurt;
    }

    /** light cannon attack (legacy attackEntityWithAmmo) */
    @Override
    public boolean attackEntityWithAmmo(Entity target)
    {
        if (!decrAmmoNum(0, this.getAmmoConsumption())) return false;

        this.addShipExp(ShinColleConfig.expGain[1]);
        decrGrudgeNum(ShinColleConfig.consumeGrudgeAction[ID.ShipConsume.LAtk]);
        decrMorale(1);
        setCombatTick(this.tickCount);

        float atk = getAttackBaseDamage(1, target);
        var distVec = com.lulan.shincolle.utility.CalcHelper.getDistanceFromA2B(this, target);

        applySoundAtAttacker(1, target);
        applyParticleAtAttacker(1, target, distVec.d);

        atk = com.lulan.shincolle.utility.CombatHelper.applyCombatRateToDamage(
            this, target, true, (float) distVec.d, atk);
        atk = com.lulan.shincolle.utility.CombatHelper.applyDamageReduceOnPlayer(target, atk);
        if (!com.lulan.shincolle.utility.TeamHelper.doFriendlyFire(this, target)) atk = 0F;

        boolean isTargetHurt = target.hurt(this.damageSources().mobProjectile(this, null), atk);

        if (isTargetHurt)
        {
            if (!com.lulan.shincolle.utility.TeamHelper.checkSameOwner(this, target))
            {
                BuffHelper.applyBuffOnTarget(target, this.attackEffectMap);
            }
            applySoundAtTarget(1, target);
            applyParticleAtTarget(1, target, distVec.d);
            applyEmotesReaction(3);
            if (ShinColleConfig.canFlare) flareTarget(target);
        }

        return isTargetHurt;
    }

    /** heavy cannon attack: missile bombard (legacy attackEntityWithHeavyAmmo) */
    @Override
    public boolean attackEntityWithHeavyAmmo(Entity target)
    {
        if (!decrAmmoNum(1, this.getAmmoConsumption())) return false;

        this.addShipExp(ShinColleConfig.expGain[2]);
        decrGrudgeNum(ShinColleConfig.consumeGrudgeAction[ID.ShipConsume.HAtk]);
        decrMorale(2);
        setCombatTick(this.tickCount);

        var distVec = com.lulan.shincolle.utility.CalcHelper.getDistanceFromA2B(this, target);

        applySoundAtAttacker(2, target);
        applyParticleAtAttacker(2, target, distVec.d);

        float tarX = (float) target.getX();
        float tarY = (float) target.getY();
        float tarZ = (float) target.getZ();

        //miss: scatter target pos
        if (this.random.nextFloat() <= com.lulan.shincolle.utility.CombatHelper.calcMissRate(
                this, (float) distVec.d))
        {
            tarX = tarX - 5F + this.random.nextFloat() * 10F;
            tarY = tarY + this.random.nextFloat() * 5F;
            tarZ = tarZ - 5F + this.random.nextFloat() * 10F;
            com.lulan.shincolle.utility.ParticleHelper.spawnAttackTextParticle(this, 0);
        }

        float atk = getAttackBaseDamage(2, target);
        summonMissile(2, atk, tarX, tarY, tarZ, target.getBbHeight());

        applySoundAtTarget(2, target);
        applyParticleAtTarget(2, target, distVec.d);
        applyEmotesReaction(3);

        if (ShinColleConfig.canFlare) flareTarget(target.blockPosition());

        return true;
    }

    /** heavy cannon attack on a block position (player skill ground target) */
    public boolean attackEntityWithHeavyAmmo(net.minecraft.core.BlockPos pos)
    {
        if (!decrAmmoNum(1, this.getAmmoConsumption())) return false;

        this.addShipExp(ShinColleConfig.expGain[2]);
        decrGrudgeNum(ShinColleConfig.consumeGrudgeAction[ID.ShipConsume.HAtk]);
        decrMorale(2);
        setCombatTick(this.tickCount);

        applySoundAtAttacker(2, null);

        float atk = getAttackBaseDamage(2, null);
        summonMissile(2, atk, pos.getX() + 0.5F, pos.getY(), pos.getZ() + 0.5F, 1F);

        applyEmotesReaction(3);
        if (ShinColleConfig.canFlare) flareTarget(pos);

        return true;
    }

    /** spawn attack missile; attackType 0:melee 1:light 2:heavy */
    public void summonMissile(int attackType, float atk, float tarX, float tarY, float tarZ,
            float targetHeight)
    {
        float launchPos = (float) this.getY() + this.getBbHeight() * 0.5F;
        int moveType = com.lulan.shincolle.utility.CombatHelper.calcMissileMoveType(this, tarY, attackType);
        if (moveType == 0) launchPos = (float) this.getY() + this.getBbHeight() * 0.3F;

        MissileData md = this.getMissileData(attackType);
        float[] data = new float[] {atk, 0.15F, launchPos, tarX, tarY + targetHeight * 0.1F, tarZ,
            140, 0.25F, md.vel0, md.accY1, md.accY2};
        EntityAbyssMissile missile = new EntityAbyssMissile(
            com.lulan.shincolle.registry.ModEntities.ABYSS_MISSILE.get(), this.level(),
            this, md.type, moveType, data);
        this.level().addFreshEntity(missile);
    }

    /** attack side effects: sound at attacker (Phase 5 packets for custom) */
    public void applySoundAtAttacker(int type, @Nullable Entity target)
    {
        SoundEvent se = switch (type)
        {
            case 1 -> ModSounds.SHIP_FIRELIGHT.get();
            case 2 -> ModSounds.SHIP_FIREHEAVY.get();
            case 3, 4 -> ModSounds.SHIP_AIRCRAFT.get();
            default -> null;
        };

        if (se != null)
        {
            this.level().playSound(null, this.blockPosition(), se, this.getSoundSource(),
                ShinColleConfig.volumeShip, 1F);
        }
    }

    /** attack side effects: sound at target */
    public void applySoundAtTarget(int type, @Nullable Entity target)
    {
        if (type == 2 && target != null)
        {
            this.level().playSound(null, target.blockPosition(), ModSounds.SHIP_EXPLODE.get(),
                this.getSoundSource(), ShinColleConfig.volumeShip, 1F);
        }
    }

    /** attack particles at attacker (legacy type ids, Phase 5 custom packet) */
    public void applyParticleAtAttacker(int type, @Nullable Entity target, double dist)
    {
        if (type == 0)
        {
            com.lulan.shincolle.utility.ParticleHelper.spawnAttackParticle(this,
                this.getX(), this.getY() + this.getBbHeight() * 0.5D, this.getZ(), 0.3D, 0);
        }
        else
        {
            com.lulan.shincolle.utility.ParticleHelper.spawnAttackParticle(this,
                this.getX(), this.getY() + this.getBbHeight() * 0.6D, this.getZ(), 0.5D, type);
        }
    }

    public void applyParticleAtTarget(int type, @Nullable Entity target, double dist)
    {
        if (target != null)
        {
            com.lulan.shincolle.utility.ParticleHelper.spawnAttackParticle(target,
                target.getX(), target.getY() + target.getBbHeight() * 0.5D,
                target.getZ(), 0.5D, type);
        }
    }

    /** emote reaction (0:sweat 1:heart 3:haha etc.) -> emotion face state */
    public void applyEmotesReaction(int type)
    {
        if (this.getStateTimer(ID.T.EmoteDelay) <= 0)
        {
            this.setStateEmotion(ID.S.Emotion3, type, true);
            this.setStateTimer(ID.T.EmoteDelay, 40);
        }
    }

    /** emote particle at face (legacy applyParticleEmotion) */
    public void applyParticleEmotion(int type)
    {
        this.setStateEmotion(ID.S.Emotion, type, true);

        //server: spawn emotion icon particle for nearby players
        if (this.level() instanceof ServerLevel)
        {
            float h = this.getIsSitting() ? this.getBbHeight() * 0.4F : this.getBbHeight() * 0.45F;
            com.lulan.shincolle.reference.dataclass.ParticleData data =
                new com.lulan.shincolle.reference.dataclass.ParticleData(
                    com.lulan.shincolle.reference.Enums.ParType.EMOTION_ENTITY);
            data.setFloatData((float) this.getX());
            data.setFloatData((float) this.getY());
            data.setFloatData((float) this.getZ());
            data.setFloatData(h);
            data.setIntData(this.getId());   //host entity ID
            data.setIntData(0);              //host type
            data.setIntData(type);           //emotion type
            com.lulan.shincolle.network.ModNetwork.sendParticleData(this, data);
        }
    }

    /** flare effect on target pos (reveal submarine) */
    public void flareTarget(Entity target)
    {
        if (target != null && this.getStateMinor(ID.M.LevelFlare) > 0)
        {
            flareTarget(target.blockPosition());
        }
    }

    public void flareTarget(net.minecraft.core.BlockPos target)
    {
        if (this.getStateMinor(ID.M.LevelFlare) > 0 && this.level() instanceof ServerLevel sl)
        {
            sl.sendParticles(net.minecraft.core.particles.ParticleTypes.FLAME,
                target.getX() + 0.5D, target.getY() + 1D, target.getZ() + 0.5D,
                20, 0.5D, 1D, 0.5D, 0.01D);
        }
    }

    /* ==================== items / exp ==================== */

    /** inventory mainhand slot (legacy slot 22) */
    public ItemStack getHeldItemMainhand()
    {
        return this.shipInventory.getStackInSlot(22);
    }

    /** inventory offhand slot (legacy slot 23) */
    public ItemStack getHeldItemOffhand()
    {
        return this.shipInventory.getStackInSlot(23);
    }

    public static int calcExpNext(int level)
    {
        int exp = (level + 1) * ShinColleConfig.expMod;
        return Math.max(exp, 1);
    }

    /** add ship exp + level ups (server side) */
    public void addShipExp(int exp)
    {
        int capLevel = this.getStateFlag(ID.F.IsMarried) ? ShinColleConfig.maxLevel
                                                       : ShinColleConfig.midLimitLevel;
        int curLevel = this.getStateMinor(ID.M.ShipLevel);

        if (curLevel >= capLevel) return;

        exp = (int) (exp * this.shipAttrs.getAttrsBuffed(ID.Attrs.XP));

        int curExp = this.getStateMinor(ID.M.ExpCurrent) + exp;
        int nextExp = this.getStateMinor(ID.M.ExpNext);
        if (nextExp <= 0) nextExp = calcExpNext(curLevel);

        while (curExp >= nextExp && curLevel < capLevel)
        {
            this.level().playSound(null, this.blockPosition(), SoundEvents.PLAYER_LEVELUP,
                this.getSoundSource(), 0.7F, 1F);

            if (this.random.nextInt(4) == 0)
            {
                this.playSound(ModSounds.SHIP_LEVEL.get(), ShinColleConfig.volumeShip, 1F);
            }

            curLevel++;
            curExp -= nextExp;
            nextExp = calcExpNext(curLevel);
        }

        this.setStateMinor(ID.M.ExpCurrent, curExp);
        this.setStateMinor(ID.M.ExpNext, nextExp);

        if (curLevel != this.getStateMinor(ID.M.ShipLevel))
        {
            this.setShipLevel(curLevel, true);
            this.updateShipAttrs();
            this.setHealth(this.getMaxHealth());
        }
    }

    /** add kills count */
    public void addKills(int value)
    {
        this.setStateMinor(ID.M.Kills, this.getStateMinor(ID.M.Kills) + value);
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

    /** per-class voice line; type: 0 idle 1 hurt 2 dead 3 marry 4 knockback
     *  5 timekeep 6 pickitem 7 feed 8 equip. Subclasses may override. */
    @Nullable
    public SoundEvent getCustomSound(int type)
    {
        return switch (type)
        {
            case 1 -> ModSounds.SHIP_HURT.get();
            case 2 -> ModSounds.SHIP_DEATH.get();
            case 6, 7 -> ModSounds.SHIP_FEED.get();
            default -> ModSounds.SHIP_IDLE.get();
        };
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

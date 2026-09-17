package com.lulan.shincolle.entity;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.dataclass.Attrs;
import com.lulan.shincolle.registry.ModSounds;
import com.lulan.shincolle.utility.BuffHelper;
import com.lulan.shincolle.utility.CalcHelper;
import com.lulan.shincolle.utility.CombatHelper;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.TargetHelper;
import com.lulan.shincolle.utility.TeamHelper;
import com.lulan.shincolle.utility.BlockHelper;
import com.lulan.shincolle.utility.ParticleHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

/**
 * homing missile entity (legacy EntityAbyssMissile).
 *
 * move type:
 *   0: direct without gravity
 *   1: parabola (computed velY/accY from addHeight)
 *   2: sim-torpedo (drops until liquid, then accelerates)
 *   3: direct with gravity
 *   4: custom xyz velocity
 *
 * data:
 *   0:atk 1:knockback 2:launchPosY 3:tarX 4:tarY 5:tarZ 6:life
 *   7:addHeight 8:vel0 9:accY1 10:accY2
 *   11:posX 12:posY 13:posZ (optional spawn pos)
 *   14:invisible ticks (optional)
 */
public class EntityAbyssMissile extends LivingEntity implements IShipOwner, IShipFlyable
{

    @Nullable
    protected IShipAttackBase host;
    @Nullable
    protected Entity hostEntity;
    protected int playerUID = -1;
    protected Attrs attrs;
    protected int type = 0;
    public int moveType = 0;
    protected float[] data;
    public int life = 140;
    @Nullable
    public HashMap<Integer, int[]> effectMap;
    public boolean startMove = false;
    public int startMoveDelay = 0;

    //move params
    public double vel0;
    public double accY1;
    public double accY2;
    public double t0;
    public double t1;
    public double velX;
    public double velY;
    public double velZ;

    public int invisibleTicks = 0;


    public EntityAbyssMissile(EntityType<? extends EntityAbyssMissile> type, Level level)
    {
        super(type, level);
        this.setNoGravity(true);
        this.data = new float[11];
        this.attrs = new Attrs();
    }

    /** full missile spawn ctor */
    public EntityAbyssMissile(EntityType<? extends EntityAbyssMissile> etype, Level level,
            IShipAttackBase host, int type, int moveType, float[] data)
    {
        this(etype, level);

        this.host = host;
        this.hostEntity = (Entity) host;
        this.effectMap = host.getAttackEffectMap();
        this.playerUID = host.getPlayerUID();
        this.type = type;
        this.moveType = moveType;
        this.data = data;
        this.life = (int) data[6];

        //attack attrs
        this.attrs.copyRaw2Buffed();
        this.attrs.setAttrsBuffed(ID.Attrs.ATK_L, data[0]);
        this.attrs.setAttrsBuffed(ID.Attrs.ATK_H, data[0]);
        this.attrs.setAttrsBuffed(ID.Attrs.ATK_AL, data[0]);
        this.attrs.setAttrsBuffed(ID.Attrs.ATK_AH, data[0]);
        this.attrs.setAttrsBuffed(ID.Attrs.DODGE, 0.5F);
        this.attrs.setAttrsBuffed(ID.Attrs.KB, data[1]);

        if (data.length > 14)
        {
            this.invisibleTicks = (int) data[14];
        }

        //spawn pos
        double px, py, pz;
        if (data.length > 13)
        {
            data[2] = data[12];
            px = data[11];
            py = data[12];
            pz = data[13];
        }
        else
        {
            px = this.hostEntity.getX();
            py = data[2];
            pz = this.hostEntity.getZ();
        }

        this.setPos(px, py, pz);
        this.setDeltaMovement(Vec3.ZERO);

        this.vel0 = data[8];
        this.accY1 = data[9];
        this.accY2 = data[10];

        //target vector
        Vec3 dist = new Vec3(data[3] - px, data[4] - py, data[5] - pz);
        double distLen = dist.length();
        Vec3 unit = distLen > 1E-4D ? dist.normalize() : Vec3.ZERO;

        //too close: direct shot
        if (distLen < 4D)
        {
            this.moveType = 0;
        }

        switch (this.moveType)
        {
        case 0:  //direct without gravity
            this.velX = unit.x * this.vel0;
            this.velY = unit.y * this.vel0;
            this.velZ = unit.z * this.vel0;
            this.accY1 = 0D;
            this.accY2 = 0D;
        break;
        case 1:  //parabola
        {
            if (data[7] <= 0F)
            {
                this.moveType = 0;
                this.velX = unit.x * this.vel0;
                this.velY = unit.y * this.vel0;
                this.velZ = unit.z * this.vel0;
                this.accY1 = 0D;
                this.accY2 = 0D;
                break;
            }

            double dx = data[3] - px;
            double dz = data[5] - pz;
            double dxz = Math.sqrt(dx * dx + dz * dz);

            if (dxz <= 4D)
            {
                this.velX = unit.x * this.vel0;
                this.velY = unit.y * this.vel0;
                this.velZ = unit.z * this.vel0;
                this.accY1 = 0D;
                this.accY2 = 0D;
                break;
            }

            dx /= dxz;
            dz /= dxz;
            double t = dxz / this.vel0;
            double addHeight = distLen * data[7];
            double dy = Math.abs(py - data[4]);
            double hy = Mth.sqrt((float) (addHeight / (addHeight + dy)));

            this.velX = dx * this.vel0;
            this.velZ = dz * this.vel0;

            if (py - data[4] < 1D)
            {
                //target above host
                this.t0 = Math.floor(t / (1 + hy));
                this.t1 = Math.floor(t * hy / (1 + hy));
                this.velY = 2D * (addHeight + dy) / this.t0;
                this.accY1 = -this.velY / this.t0;
                this.accY2 = -2D * addHeight / (this.t1 * this.t1);
            }
            else
            {
                //target below host
                this.t0 = Math.floor(t * hy / (1 + hy));
                this.t1 = Math.floor(t / (1 + hy));
                this.accY1 = -2D * addHeight / (this.t0 * this.t0);
                this.velY = -this.accY1 * this.t0;
                this.accY2 = -2D * (addHeight + dy) / (this.t1 * this.t1);
            }

            //too steep: fall back to direct
            if (Math.abs(this.accY1) > 0.15D || Math.abs(this.accY2) > 0.15D)
            {
                this.moveType = 0;
                this.velX = unit.x * this.vel0;
                this.velY = unit.y * this.vel0;
                this.velZ = unit.z * this.vel0;
                this.accY1 = 0D;
                this.accY2 = 0D;
            }
        }
        break;
        case 2:  //sim-torpedo
            this.velX = unit.x * 0.6D;
            this.velY = 0.1D;
            this.velZ = unit.z * 0.6D;
            this.accY1 = -0.035D;
        break;
        case 3:  //direct with gravity
            this.velX = unit.x * this.vel0;
            this.velY = unit.y * this.vel0;
            this.velZ = unit.z * this.vel0;
            this.accY1 = -0.035D;
            this.accY2 = -0.035D;
        break;
        case 4:  //custom xyz velocity
            this.velX = data[3];
            this.velY = data[4];
            this.velZ = data[5];
        break;
        default:
        break;
        }
    }

    /** simple ctor for direct shots */
    public EntityAbyssMissile(EntityType<? extends EntityAbyssMissile> type, Level level,
                              Entity owner, float damage)
    {
        this(type, level);
        this.hostEntity = owner;
        if (owner != null) this.playerUID = TeamHelper.getPlayerUID(owner);
        this.attrs.copyRaw2Buffed();
        this.attrs.setAttrsBuffed(ID.Attrs.ATK_L, damage);
        this.attrs.setAttrsBuffed(ID.Attrs.ATK_H, damage);
    }

    public static AttributeSupplier.Builder createAttributes()
    {
        return LivingEntity.createLivingAttributes()
            .add(Attributes.MAX_HEALTH, 4D)
            .add(Attributes.MOVEMENT_SPEED, 0D)
            .add(Attributes.KNOCKBACK_RESISTANCE, 1D);
    }

    /* ==================== IShipOwner ==================== */

    @Override
    public int getPlayerUID()
    {
        return this.playerUID;
    }

    @Override
    public void setPlayerUID(int uid)
    {
        this.playerUID = uid;
    }

    @Nullable
    @Override
    public Entity getHostEntity()
    {
        return this.hostEntity;
    }

    public Attrs getAttrs()
    {
        return this.attrs;
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

    /* ==================== tick ==================== */

    @Override
    public void tick()
    {
        super.tick();

        //update position
        this.setDeltaMovement(this.velX, this.velY, this.velZ);
        this.move(net.minecraft.world.entity.MoverType.SELF, this.getDeltaMovement());
        this.hasImpulse = true;

        //calc new velocity
        this.handleMissileMovement();

        if (this.invisibleTicks > 0) this.invisibleTicks--;

        //face motion direction (both sides so render is smooth)
        float f1 = Mth.sqrt((float) (this.velX * this.velX + this.velZ * this.velZ));
        this.setXRot((float) Mth.atan2(this.velY, f1));
        this.setYRot((float) Mth.atan2(this.velX, this.velZ) * Mth.RAD_TO_DEG);

        if (!this.level().isClientSide)
        {
            //no host data: discard silently
            if (this.hostEntity == null && this.host == null)
            {
                this.discard();
                return;
            }

            if (this.tickCount > this.life)
            {
                this.onImpact(null);
                return;
            }

            //cluster main missile spawns sub missiles
            if (this.type == 3 && this.tickCount > 6 && this.tickCount < 41 &&
                (this.tickCount & 7) == 0)
            {
                Vec3 mot = this.getDeltaMovement();
                float[] subdata = new float[] {this.data[0] * 0.5F, this.data[1],
                    (float) this.getY() - 0.75F, (float) mot.x, (float) mot.y, (float) mot.z,
                    140, 0F, 0.5F, -0.06F, -0.06F,
                    (float) this.getX(), (float) (this.getY() - 0.65D - Math.abs(mot.y)),
                    (float) this.getZ(), 4};
                EntityAbyssMissile subm = new EntityAbyssMissile(
                    com.lulan.shincolle.registry.ModEntities.ABYSS_MISSILE.get(),
                    this.level(), this.host, 4, 4, subdata);
                this.level().addFreshEntity(subm);
            }

            //impact checks after grace period
            if (this.tickCount > 5)
            {
                //1: inside solid block
                if (this.level().getBlockState(this.blockPosition()).isSolidRender(
                        this.level(), this.blockPosition()))
                {
                    this.onImpact(null);
                    return;
                }

                //2: ray trace over this tick's travel
                Vec3 start = this.position();
                Vec3 end = start.add(this.velX, this.velY, this.velZ);
                BlockHitResult ray = this.level().clip(new ClipContext(start, end,
                    ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));

                if (ray.getType() == HitResult.Type.BLOCK)
                {
                    this.onImpact(null);
                    return;
                }

                //3: expanded AABB entity hit
                List<Entity> hitList = this.level().getEntities(this,
                    this.getBoundingBox().inflate(1D, 1.5D, 1D));

                for (Entity ent : hitList)
                {
                    if (ent != this && ent != this.hostEntity && ent.isPickable() &&
                        !TeamHelper.checkSameOwner(this.hostEntity, ent))
                    {
                        this.onImpact(ent);
                        return;
                    }
                }
            }
        }
        else
        {
            //client: smoke trail
            if (this.type != 2 && this.invisibleTicks <= 0 &&
                ((this.moveType == 2 && this.startMove) ||
                 (this.moveType != 2 && this.tickCount > 2)))
            {
                Vec3 mot = this.getDeltaMovement();
                for (int j = 0; j < 4; j++)
                {
                    this.level().addParticle(net.minecraft.core.particles.ParticleTypes.LARGE_SMOKE,
                        this.getX() + mot.x * (2D - 1.5D * j),
                        this.getY() + mot.y * (2D - 1.5D * j) + 0.5D,
                        this.getZ() + mot.z * (2D - 1.5D * j),
                        -mot.x * 0.1D, -mot.y * 0.1D, -mot.z * 0.1D);
                }
            }
        }
    }

    /** velocity update per tick */
    protected void handleMissileMovement()
    {
        if (this.type == 4)
        {
            //cluster sub missile: drag + gravity
            this.velX *= 0.95D;
            this.velY += this.accY1;
            this.velZ *= 0.95D;
            return;
        }

        switch (this.moveType)
        {
        case 1:  //parabola
            this.velY += (this.tickCount <= this.t0) ? this.accY1 : this.accY2;
        break;
        case 2:  //sim-torpedo
            if (this.startMove)
            {
                if (this.startMoveDelay >= 0)
                {
                    this.startMoveDelay--;

                    if (this.startMoveDelay < 0)
                    {
                        Vec3 dist = new Vec3(this.data[3] - this.getX(),
                            this.data[4] - this.getY(), this.data[5] - this.getZ());
                        Vec3 unit = dist.length() > 1E-4D ? dist.normalize() : Vec3.ZERO;

                        this.velX = unit.x * this.vel0 * 0.25D;
                        this.velY = unit.y * this.vel0 * 0.25D;
                        this.velZ = unit.z * this.vel0 * 0.25D;

                        if (this.velY > 0.003D) this.velY = 0.003D;
                    }
                }
                else if (this.velX * this.velX + this.velY * this.velY +
                         this.velZ * this.velZ < 2D)
                {
                    this.velX *= this.accY2;
                    this.velY *= this.accY2;
                    this.velZ *= this.accY2;
                }
            }
            else
            {
                this.velX *= 0.85D;
                this.velY += this.accY1;
                this.velZ *= 0.85D;

                //entered liquid: start engine
                if (!this.level().isClientSide &&
                    BlockHelper.checkBlockIsLiquid(this.level().getBlockState(this.blockPosition())))
                {
                    this.startMove = true;
                    this.startMoveDelay = 3;
                }
            }
        break;
        default:
        break;
        }
    }

    /** explode on impact */
    protected void onImpact(@Nullable Entity target)
    {
        this.playSound(ModSounds.SHIP_EXPLODE.get(), ShinColleConfig.volumeShip * 1.5F,
            0.7F / (this.random.nextFloat() * 0.4F + 0.8F));

        if (this.hostEntity == null && this.host == null)
        {
            this.discard();
            return;
        }

        if (!this.level().isClientSide)
        {
            float baseAtk = this.attrs.getAttackDamage();

            //special missile action (black hole etc.)
            if (this.host != null)
            {
                CombatHelper.specialAttackEffect(this.host, this.type,
                    new float[] {(float) this.getX(), (float) this.getY(), (float) this.getZ()});
            }

            //AoE damage
            AABB box = this.getBoundingBox().inflate(3.5D, 3.5D, 3.5D);
            DamageSource src = this.damageSources().explosion(this, this.hostEntity);

            for (Entity ent : this.level().getEntities(this, box))
            {
                float missileAtk = baseAtk;

                if (!ent.isPickable() || ent == this || ent == this.hostEntity ||
                    TargetHelper.isEntityInvulnerable(ent))
                {
                    continue;
                }

                if (TeamHelper.checkSameOwner(this.hostEntity, ent))
                {
                    continue;
                }

                if (this.host != null)
                {
                    missileAtk = CombatHelper.applyCombatRateToDamage(this.host, ent,
                        false, 1F, missileAtk);
                    missileAtk = CombatHelper.applyDamageReduceOnPlayer(ent, missileAtk);
                    if (!TeamHelper.doFriendlyFire(this.host, ent)) missileAtk = 0F;
                }

                if (ent.hurt(src, missileAtk) && this.effectMap != null)
                {
                    if (this.hostEntity == null || !TeamHelper.checkSameOwner(this.hostEntity, ent))
                    {
                        BuffHelper.applyBuffOnTarget(ent, this.effectMap);
                    }
                }
            }

            ParticleHelper.spawnAttackParticle(this, this.getX(), this.getY(), this.getZ(), 1D, 2);
            this.discard();
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag)
    {
        super.addAdditionalSaveData(tag);
        tag.putInt("PlayerUID", this.playerUID);
        tag.putInt("MissileType", this.type);
        tag.putInt("MoveType", this.moveType);
        tag.putInt("Life", this.life);
        tag.putDouble("Vel0", this.vel0);
        tag.putDouble("VelX", this.velX);
        tag.putDouble("VelY", this.velY);
        tag.putDouble("VelZ", this.velZ);
        tag.putDouble("AccY1", this.accY1);
        tag.putDouble("AccY2", this.accY2);
        if (this.data != null)
        {
            tag.putInt("DataLen", this.data.length);
            for (int i = 0; i < this.data.length; i++) tag.putFloat("Data" + i, this.data[i]);
        }
        if (this.hostEntity != null) tag.putInt("HostEID", this.hostEntity.getId());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag)
    {
        super.readAdditionalSaveData(tag);
        this.playerUID = tag.getInt("PlayerUID");
        this.type = tag.getInt("MissileType");
        this.moveType = tag.getInt("MoveType");
        this.life = tag.getInt("Life");
        this.vel0 = tag.getDouble("Vel0");
        this.velX = tag.getDouble("VelX");
        this.velY = tag.getDouble("VelY");
        this.velZ = tag.getDouble("VelZ");
        this.accY1 = tag.getDouble("AccY1");
        this.accY2 = tag.getDouble("AccY2");
        int len = tag.getInt("DataLen");
        if (len > 0)
        {
            this.data = new float[len];
            for (int i = 0; i < len; i++) this.data[i] = tag.getFloat("Data" + i);
        }
        //hostEntity re-resolved lazily; host interface stays null after reload
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

    @Override
    public SoundSource getSoundSource()
    {
        return SoundSource.NEUTRAL;
    }


}

package com.lulan.shincolle.ai;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nullable;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipEmotion;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.TargetHelper;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;

/**
 * pick item goal (legacy EntityAIShipPickItem).
 * Works for BasicEntityShip directly or via a BasicEntityMount host.
 */
public class ShipPickItemGoal extends Goal
{

    protected final TargetHelper.Sorter targetSorter;
    private final IShipEmotion host;
    private final BasicEntityShip hostShip;
    private final BasicEntityMount hostMount;
    private final LivingEntity hostLiving;
    @Nullable
    private Entity entItem;
    private int pickDelay;
    private int pickDelayMax = 10;
    private float pickRange;
    private final float pickRangeBase;


    public ShipPickItemGoal(IShipEmotion entity, float pickRangeBase)
    {
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));

        this.host = entity;
        this.hostLiving = (LivingEntity) entity;
        this.pickRangeBase = pickRangeBase;

        if (entity instanceof BasicEntityShip ship)
        {
            this.hostShip = ship;
            this.hostMount = null;
            this.targetSorter = new TargetHelper.Sorter(ship);
        }
        else if (entity instanceof BasicEntityMount mount)
        {
            this.hostMount = mount;
            this.hostShip = mount.getHostEntity() instanceof BasicEntityShip s ? s : null;
            this.targetSorter = new TargetHelper.Sorter(mount);
        }
        else
        {
            this.hostShip = null;
            this.hostMount = null;
            this.targetSorter = new TargetHelper.Sorter((Entity) entity);
        }
    }

    @Override
    public boolean canUse()
    {
        if (this.hostShip != null)
        {
            if (this.hostShip.fishHook != null) return false;

            boolean riding = this.hostMount != null ?
                this.hostMount.isPassenger() : this.hostShip.isPassenger();

            if (riding || this.hostShip.isOrderedToSit() ||
                !this.hostShip.getStateFlag(ID.F.PickItem) ||
                this.hostShip.getStateMinor(ID.M.CraneState) > 0 ||
                this.hostShip.getStateFlag(ID.F.NoFuel))
            {
                return false;
            }

            return hasEmptySlot(this.hostShip);
        }

        return false;
    }

    @Override
    public void tick()
    {
        if (this.hostShip == null) return;

        this.pickDelay--;

        if (this.hostShip.tickCount % 16 == 0)
        {
            updateShipParms();

            this.entItem = getNearbyEntityItem();

            if (this.entItem != null && this.entItem.isAlive())
            {
                if (this.hostMount != null)
                {
                    this.hostMount.getShipNavigate().tryMoveToEntityLiving(this.entItem, 1D);
                }
                else
                {
                    this.hostShip.getShipNavigate().tryMoveToEntityLiving(this.entItem, 1D);
                }
            }
        }

        //pick up nearby item
        if (this.pickDelay <= 0 && this.entItem != null)
        {
            this.pickDelay = this.pickDelayMax;

            Entity mover = this.hostMount != null ? this.hostMount : this.hostShip;

            if (mover.distanceToSqr(this.entItem) < 9D &&
                this.entItem instanceof ItemEntity entitem)
            {
                ItemStack itemstack = entitem.getItem();
                int count = itemstack.getCount();

                if (!entitem.hasPickUpDelay() &&
                    addItemStackToInventory(this.hostShip, itemstack))
                {
                    this.hostShip.level().playSound(null,
                        this.hostShip.getX(), this.hostShip.getY(), this.hostShip.getZ(),
                        SoundEvents.ITEM_PICKUP, this.hostShip.getSoundSource(),
                        ShinColleConfig.volumeShip,
                        ((this.hostShip.getRandom().nextFloat() -
                          this.hostShip.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);

                    //entity sound (pick item, type 6)
                    if (this.hostShip.getStateTimer(ID.T.SoundTime) <= 0 &&
                        this.hostShip.getRandom().nextInt(2) == 0)
                    {
                        this.hostShip.setStateTimer(ID.T.SoundTime,
                            40 + this.hostShip.getRandom().nextInt(10));
                        var se = this.hostShip.getCustomSound(6);
                        if (se != null)
                        {
                            this.hostShip.playSound(se, ShinColleConfig.volumeShip, 1F);
                        }
                    }

                    this.hostShip.take(entitem, count);

                    this.hostShip.applyParticleAtAttacker(0, null, 0D);

                    this.hostShip.addShipExp(ShinColleConfig.expGain[6]);

                    if (itemstack.getCount() <= 0)
                    {
                        entitem.discard();
                        this.entItem = null;
                    }
                }

                this.hostShip.getShipNavigate().clearPathEntity();
                if (this.hostMount != null)
                {
                    this.hostMount.getShipNavigate().clearPathEntity();
                }
            }
        }
    }

    /** first empty slot >= 0 check (legacy getFirstSlotEmpty) */
    private static boolean hasEmptySlot(BasicEntityShip ship)
    {
        var inv = ship.getShipInventory();
        for (int i = 0; i < inv.getSlots(); i++)
        {
            if (inv.getStackInSlot(i).isEmpty()) return true;
        }
        return false;
    }

    /** merge itemstack into ship inventory, mutates input stack */
    private static boolean addItemStackToInventory(BasicEntityShip ship, ItemStack stack)
    {
        var inv = ship.getShipInventory();
        for (int i = 0; i < inv.getSlots() && !stack.isEmpty(); i++)
        {
            stack = inv.insertItem(i, stack, false);
        }
        return stack.isEmpty() || stack.getCount() < 64;
    }

    @Nullable
    private ItemEntity getNearbyEntityItem()
    {
        List<ItemEntity> list = this.hostShip.level().getEntitiesOfClass(
            ItemEntity.class,
            this.hostShip.getBoundingBox().inflate(
                this.pickRange, this.pickRange * 0.5F + 1F, this.pickRange));

        if (!list.isEmpty())
        {
            Collections.sort(list, this.targetSorter);
            return list.get(0);
        }

        return null;
    }

    private void updateShipParms()
    {
        if (this.hostShip == null) return;

        float speed = this.hostShip.getAttrs().getAttackSpeed();
        if (speed < 1F) speed = 1F;

        this.pickDelayMax = (int) (10F / speed);

        float tempran = this.pickRangeBase + this.hostShip.getStateMinor(ID.M.FollowMax);
        this.pickRange = this.pickRangeBase + this.hostShip.getAttrs().getAttackRange() * 0.5F;
        this.pickRange = Math.min(tempran, this.pickRange);
    }


}

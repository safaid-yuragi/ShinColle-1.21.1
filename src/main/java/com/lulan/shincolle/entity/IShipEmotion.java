package com.lulan.shincolle.entity;

import com.lulan.shincolle.reference.ID;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

/**
 * ship emotion/state accessors used by AI and rendering.
 */
public interface IShipEmotion extends IShipState
{

    int getTickExisted();

    RandomSource getRand();

    boolean getIsRiding();

    boolean getIsSitting();

    boolean getIsSneaking();

    boolean getIsLeashed();

    /** set sit state (TamableAnimal#setOrderedToSit on ships) */
    void setEntitySit(boolean sit);

    /** ship liquid depth, type 0:self 1:riding entity */
    double getShipDepth(int type);

    int getScaleLevel();

    void setScaleLevel(int level);

    /** model display rotation, index 0..2 (client) */
    float getModelRotate(int index);

    void setModelRotate(int index, float value);

    /** CLIENT: face emotion start tick */
    default int getFaceTick()
    {
        return getStateTimer(ID.T.FaceTime);
    }

    default void setFaceTick(int value)
    {
        setStateTimer(ID.T.FaceTime, value);
    }

    /** CLIENT: head tilt start tick */
    default int getHeadTiltTick()
    {
        return getStateTimer(ID.T.HeadTilt);
    }

    default void setHeadTiltTick(int value)
    {
        setStateTimer(ID.T.HeadTilt, value);
    }

    /** CLIENT: attack animation timer */
    default int getAttackTick()
    {
        return getStateTimer(ID.T.AttackTime);
    }

    default void setAttackTick(int value)
    {
        setStateTimer(ID.T.AttackTime, value);
    }

    /** CLIENT: second attack animation timer */
    default int getAttackTick2()
    {
        return getStateTimer(ID.T.AttackTime2);
    }

    default void setAttackTick2(int value)
    {
        setStateTimer(ID.T.AttackTime2, value);
    }

    /** death time, LivingEntity#deathTime */
    default int getDeathTick()
    {
        return this instanceof LivingEntity le ? le.deathTime : 0;
    }

    default void setDeathTick(int value)
    {
        if (this instanceof LivingEntity le) le.deathTime = value;
    }

    /** arm swing progress for held item rendering */
    default float getSwingTime(float partialTick)
    {
        return this instanceof LivingEntity le ? le.getAttackAnim(partialTick) : 0F;
    }

    default boolean getIsSprinting()
    {
        return this instanceof Entity e && e.isSprinting();
    }

    /** riding pose state for model display: 0:none 1:sit 2:stand on mounts */
    default int getRidingState()
    {
        return 0;
    }

    default void setRidingState(int state) {}


}

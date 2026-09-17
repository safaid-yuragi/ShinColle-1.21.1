package com.lulan.shincolle.entity;

import net.minecraft.util.RandomSource;

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


}

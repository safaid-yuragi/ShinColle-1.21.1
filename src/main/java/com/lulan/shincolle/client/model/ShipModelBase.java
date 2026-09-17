package com.lulan.shincolle.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;

/**
 * model base for basic emotion
 */
abstract public class ShipModelBase<T extends Entity> extends ShipModel<T> implements IModelEmotion
{


    public ShipModelBase() {}

    /** get hand model for held item rendering */
    public ModelPart[] getArmForSide(HumanoidArm side)
    {
        return side == HumanoidArm.RIGHT ? this.armMain : this.armOff;
    }


}

package com.lulan.shincolle.item;

import com.lulan.shincolle.reference.ID;

/**
 * ship equipment base (legacy BasicEquip).
 *
 * Each legacy meta variant is now a separate item instance carrying
 * {@code equipType} ({@link ID.EquipType}) and {@code subId}
 * (legacy meta value). EquipID = equipType + subId * 100, used by
 * {@link com.lulan.shincolle.reference.Values#EquipAttrsMain}.
 */
public class BasicEquip extends BasicItem
{

    protected final int equipType;
    protected final int subId;


    public BasicEquip(Properties props, int equipType, int subId)
    {
        super(props);
        this.equipType = equipType;
        this.subId = subId;
    }

    public int getEquipTypeID()
    {
        return this.equipType;
    }

    public int getEquipSubID()
    {
        return this.subId;
    }

    public int getEquipID()
    {
        return this.equipType + this.subId * 100;
    }


}

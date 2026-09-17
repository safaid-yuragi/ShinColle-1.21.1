package com.lulan.shincolle.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * custom item entity (legacy BasicEntityItem): never burns, never
 * despawns by age limit is left to default; used for ship drops.
 */
public class BasicEntityItem extends ItemEntity
{


    public BasicEntityItem(EntityType<? extends ItemEntity> type, Level level)
    {
        super(type, level);
    }

    public BasicEntityItem(Level level, double x, double y, double z, ItemStack stack)
    {
        super(level, x, y, z, stack);
    }

    @Override
    public boolean fireImmune()
    {
        return true;
    }


}

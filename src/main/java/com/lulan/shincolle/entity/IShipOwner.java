package com.lulan.shincolle.entity;

import javax.annotation.Nullable;

import net.minecraft.world.entity.Entity;

/**
 * entity owned by a player or hosted by another entity.
 */
public interface IShipOwner
{

    int getPlayerUID();

    void setPlayerUID(int uid);

    /** owning/host entity (ship for summons, player for ships) */
    @Nullable
    Entity getHostEntity();


}

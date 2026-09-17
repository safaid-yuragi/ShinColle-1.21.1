package com.lulan.shincolle.blockentity;

import com.lulan.shincolle.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

/**
 * port of legacy TileEntityCrane. Full machine logic is ported in Phase 5.
 */
public class TileEntityCrane extends BasicBlockEntity
{


    /** ship entity held by the crane arm (cleared on power off) */
    private net.minecraft.world.entity.Entity ship;


    public TileEntityCrane(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TILEENTITYCRANE.get(), pos, state, 18);
        this.fields = new int[14];
    }

    public net.minecraft.world.entity.Entity getShip()
    {
        return this.ship;
    }

    public void setShip(net.minecraft.world.entity.Entity ship)
    {
        this.ship = ship;
    }


    @Override
    public net.minecraft.world.inventory.AbstractContainerMenu createMenu(
        int containerId, net.minecraft.world.entity.player.Inventory inv,
        net.minecraft.world.entity.player.Player player)
    {
        return new com.lulan.shincolle.menu.CraneMenu(containerId, inv, this);
    }


}

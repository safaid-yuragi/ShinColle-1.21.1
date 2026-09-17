package com.lulan.shincolle.blockentity;

import com.lulan.shincolle.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

/**
 * port of legacy TileEntityDesk. Full machine logic is ported in Phase 5.
 */
public class TileEntityDesk extends BasicBlockEntity
{


    public TileEntityDesk(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TILEENTITYDESK.get(), pos, state, 9);
        this.fields = new int[4];
    }


    @Override
    public net.minecraft.world.inventory.AbstractContainerMenu createMenu(
        int containerId, net.minecraft.world.entity.player.Inventory inv,
        net.minecraft.world.entity.player.Player player)
    {
        return new com.lulan.shincolle.menu.DeskMenu(containerId, inv, this, 0);
    }


}

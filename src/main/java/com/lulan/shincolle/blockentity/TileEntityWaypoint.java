package com.lulan.shincolle.blockentity;

import com.lulan.shincolle.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

/**
 * port of legacy TileEntityWaypoint. Full machine logic is ported in Phase 5.
 */
public class TileEntityWaypoint extends BasicBlockEntity
{

    /** paired container for task automation (legacy chestPos) */
    private BlockPos chestPos = BlockPos.ZERO;


    public TileEntityWaypoint(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TILEENTITYWAYPOINT.get(), pos, state, 1);
    }

    /** paired chest pos, y<=0 = none */
    public BlockPos getPairedChest()
    {
        return this.chestPos;
    }

    public void setPairedChest(BlockPos pos)
    {
        this.chestPos = pos != null ? pos : BlockPos.ZERO;
        this.setChanged();
    }

    @Override
    protected void saveAdditional(net.minecraft.nbt.CompoundTag tag,
            net.minecraft.core.HolderLookup.Provider registries)
    {
        super.saveAdditional(tag, registries);
        tag.putIntArray("chestPos", new int[] {this.chestPos.getX(), this.chestPos.getY(), this.chestPos.getZ()});
    }

    @Override
    protected void loadAdditional(net.minecraft.nbt.CompoundTag tag,
            net.minecraft.core.HolderLookup.Provider registries)
    {
        super.loadAdditional(tag, registries);
        int[] pos = tag.getIntArray("chestPos");
        this.chestPos = (pos != null && pos.length == 3) ? new BlockPos(pos[0], pos[1], pos[2]) : BlockPos.ZERO;
    }


}

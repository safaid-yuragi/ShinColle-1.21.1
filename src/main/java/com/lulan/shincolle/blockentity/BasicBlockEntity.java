package com.lulan.shincolle.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

/**
 * block entity base (legacy TileEntity + ITickable).
 * Optionally owns an inventory (slot count via ctor).
 */
abstract public class BasicBlockEntity extends BlockEntity
{

    @javax.annotation.Nullable
    protected ItemStackHandler itemHandler = null;


    public BasicBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int invSize)
    {
        super(type, pos, state);
        if (invSize > 0)
        {
            this.itemHandler = new ItemStackHandler(invSize)
            {
                @Override
                protected void onContentsChanged(int slot)
                {
                    BasicBlockEntity.this.setChanged();
                }
            };
        }
    }

    public boolean hasInventory()
    {
        return this.itemHandler != null;
    }

    @javax.annotation.Nullable
    public ItemStackHandler getItemHandler()
    {
        return this.itemHandler;
    }

    /** inventory contents as a Container view for {@code Containers.dropContents} */
    public Container getItemHandlerContents()
    {
        if (this.itemHandler == null) return new SimpleContainer(0);
        SimpleContainer c = new SimpleContainer(this.itemHandler.getSlots());
        for (int i = 0; i < this.itemHandler.getSlots(); i++)
        {
            c.setItem(i, this.itemHandler.getStackInSlot(i));
        }
        return c;
    }

    /** per-tick hook, called by the block's ticker */
    public void tick() {}

    /* ==================== NBT ==================== */

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.saveAdditional(tag, registries);
        if (this.itemHandler != null)
        {
            tag.put("Inventory", this.itemHandler.serializeNBT(registries));
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.loadAdditional(tag, registries);
        if (this.itemHandler != null && tag.contains("Inventory"))
        {
            this.itemHandler.deserializeNBT(registries, tag.getCompound("Inventory"));
        }
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries)
    {
        CompoundTag tag = super.getUpdateTag(registries);
        saveAdditional(tag, registries);
        return tag;
    }

    @javax.annotation.Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }


}

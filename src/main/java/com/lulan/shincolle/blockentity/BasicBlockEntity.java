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
    implements net.minecraft.world.MenuProvider,
        com.lulan.shincolle.entity.IShipOwner
{

    @javax.annotation.Nullable
    protected ItemStackHandler itemHandler = null;

    /** owner player UID (legacy IShipOwner on tiles), -1 = none */
    protected int playerUID = -1;

    /** generic int fields synced to the GUI via ContainerData (legacy getField/setField) */
    protected int[] fields = new int[0];

    /** field change flag: set by setField, polled by sendFieldChanges */
    protected boolean fieldDirty = false;


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

    /* ==================== GUI ==================== */

    @Override
    public net.minecraft.network.chat.Component getDisplayName()
    {
        return net.minecraft.network.chat.Component.translatable(
            "tile.shincolle." + this.getType().toString());
    }

    @javax.annotation.Nullable
    @Override
    public net.minecraft.world.inventory.AbstractContainerMenu createMenu(
        int containerId, net.minecraft.world.entity.player.Inventory inv,
        net.minecraft.world.entity.player.Player player)
    {
        return null;
    }

    /** container may interact with this block entity (legacy isUsableByPlayer) */
    public boolean stillValid(net.minecraft.world.entity.player.Player player)
    {
        if (this.level == null ||
            this.level.getBlockEntity(this.worldPosition) != this) return false;
        return player.distanceToSqr(this.worldPosition.getX() + 0.5D,
            this.worldPosition.getY() + 0.5D,
            this.worldPosition.getZ() + 0.5D) <= 64D;
    }

    /** sync block entity data to nearby clients (legacy sendSyncPacket) */
    public void sendSyncPacket()
    {
        if (this.level != null && !this.level.isClientSide())
        {
            this.setChanged();
            this.level.sendBlockUpdated(this.worldPosition,
                this.getBlockState(), this.getBlockState(), 3);
        }
    }

    /* ==================== OWNER ==================== */

    @Override
    public int getPlayerUID()
    {
        return this.playerUID;
    }

    @Override
    public void setPlayerUID(int uid)
    {
        this.playerUID = uid;
    }

    @javax.annotation.Nullable
    @Override
    public net.minecraft.world.entity.Entity getHostEntity()
    {
        return null;
    }

    /* ==================== FIELDS (legacy getField/setField) ==================== */

    public int getField(int id)
    {
        return (id >= 0 && id < this.fields.length) ? this.fields[id] : 0;
    }

    public void setField(int id, int value)
    {
        if (id >= 0 && id < this.fields.length)
        {
            this.fields[id] = value;
            this.fieldDirty = true;
        }
    }

    public int getFieldCount()
    {
        return this.fields.length;
    }

    /**
     * whether a stack may be placed into slot by the GUI/hopper.
     * default denies insertion; concrete tiles override.
     */
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        return false;
    }

    /** ContainerData view of {@link #fields} for menu addDataSlots */
    public net.minecraft.world.inventory.ContainerData getFieldData()
    {
        return new net.minecraft.world.inventory.ContainerData()
        {
            @Override
            public int get(int index)
            {
                return BasicBlockEntity.this.getField(index);
            }

            @Override
            public void set(int index, int value)
            {
                BasicBlockEntity.this.setField(index, value);
            }

            @Override
            public int getCount()
            {
                return BasicBlockEntity.this.getFieldCount();
            }
        };
    }

    /* ==================== NBT ==================== */

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.saveAdditional(tag, registries);
        if (this.itemHandler != null)
        {
            tag.put("Inventory", this.itemHandler.serializeNBT(registries));
        }
        tag.putIntArray("Fields", this.fields);
        tag.putInt("PlayerUID", this.playerUID);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.loadAdditional(tag, registries);
        if (this.itemHandler != null && tag.contains("Inventory"))
        {
            this.itemHandler.deserializeNBT(registries, tag.getCompound("Inventory"));
        }
        int[] f = tag.getIntArray("Fields");
        if (f.length > 0)
        {
            if (f.length == this.fields.length) this.fields = f;
            else System.arraycopy(f, 0, this.fields, 0,
                Math.min(f.length, this.fields.length));
        }
        this.playerUID = tag.getInt("PlayerUID");
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

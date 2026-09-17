package com.lulan.shincolle.blockentity;

import com.lulan.shincolle.block.BasicBlockMulti;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/**
 * BASIC MULTI BLOCK BLOCK ENTITY (legacy BasicTileMulti).
 *
 * multi-block structure (MBS) type:
 * 0: none
 * 1: large shipyard
 */
abstract public class BasicMultiBlockEntity extends BasicBlockEntity
{

    protected BasicMultiBlockEntity masterTile = null;
    protected boolean hasMaster, isMaster;      //master flag
    protected int structType;                   //MBS info
    private BlockPos masterPos = BlockPos.ZERO; //master pos


    public BasicMultiBlockEntity(BlockEntityType<?> type, BlockPos pos,
            BlockState state, int invSize)
    {
        super(type, pos, state, invSize);
    }

    /* ==================== NBT ==================== */

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.saveAdditional(tag, registries);
        tag.putInt("masterX", this.masterPos.getX());
        tag.putInt("masterY", this.masterPos.getY());
        tag.putInt("masterZ", this.masterPos.getZ());
        tag.putInt("structType", this.structType);
        tag.putBoolean("hasMaster", this.hasMaster);
        tag.putBoolean("isMaster", this.isMaster);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.loadAdditional(tag, registries);
        this.masterPos = new BlockPos(tag.getInt("masterX"),
            tag.getInt("masterY"), tag.getInt("masterZ"));
        this.structType = tag.getInt("structType");
        this.hasMaster = tag.getBoolean("hasMaster");
        this.isMaster = tag.getBoolean("isMaster");
    }

    /* ==================== GETTER ==================== */

    public int getStructType()
    {
        return this.structType;
    }

    @javax.annotation.Nullable
    public BasicMultiBlockEntity getMaster()
    {
        if (this.masterTile != null && !this.masterTile.isRemoved())
        {
            return this.masterTile;
        }
        else
        {
            //check master again
            if (this.hasMaster && this.level != null)
            {
                BlockEntity tile = this.level.getBlockEntity(this.masterPos);

                if (tile instanceof BasicMultiBlockEntity multi)
                {
                    this.setMaster(multi);
                    return this.masterTile;
                }
            }
        }

        return null;
    }

    public boolean hasMaster()
    {
        return this.hasMaster;
    }

    public boolean isMaster()
    {
        return this.isMaster;
    }

    public BlockPos getMasterPos()
    {
        return this.masterPos;
    }

    /* ==================== SETTER ==================== */

    /** set multi-block structure type, NOT blockstate!! */
    public void setStructType(int type)
    {
        //set type
        this.structType = type;

        //set blockstate
        //type: 0:NO mbs, 1:mbs INACTIVE, 2:mbs ACTIVE
        if (this.level != null)
        {
            BasicBlockMulti.updateBlockState(type == 0 ? 0 : 1,
                this.level, this.getBlockPos());
        }
    }

    /** set master tile, separate from setHasMaster */
    public void setMaster(@javax.annotation.Nullable BasicMultiBlockEntity master)
    {
        if (master != null && !master.isRemoved())
        {
            this.masterTile = master;
            this.setMasterCoords(master.getBlockPos());
        }
        else
        {
            this.masterTile = null;
        }
    }

    /** set master flag, separate from setMaster due to tile loading order problem */
    public void setHasMaster(boolean par1)
    {
        this.hasMaster = par1;
    }

    public void setIsMaster(boolean par1)
    {
        this.isMaster = par1;
    }

    public void setMasterCoords(BlockPos pos)
    {
        this.masterPos = pos;
    }


}

package com.lulan.shincolle.block;

import javax.annotation.Nullable;

import com.lulan.shincolle.blockentity.BasicMultiBlockEntity;
import com.lulan.shincolle.blockentity.TileMultiGrudgeHeavy;
import com.lulan.shincolle.utility.LogHelper;
import com.lulan.shincolle.utility.MultiBlockHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

/**
 * multi-block part base (legacy BasicBlockMulti, PropertyInteger MBS 0..2).
 * MBS = 0 master block; 1/2 = slave parts placed by the master.
 */
abstract public class BasicBlockMulti extends BasicBlockContainer
{

    /** multi block structure state: 0:NO multi-structure, 1:mbs INACTIVE, 2:mbs ACTIVE */
    public static final IntegerProperty MBS = IntegerProperty.create("mbs", 0, 2);


    public BasicBlockMulti(Properties props)
    {
        super(props);
        this.registerDefaultState(this.defaultBlockState().setValue(MBS, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(MBS);
    }

    //update multi-block structure state (legacy updateBlockState)
    public static void updateBlockState(int mbState, Level level, BlockPos pos)
    {
        BlockState state = level.getBlockState(pos);

        if (state.getBlock() instanceof BasicBlockMulti)
        {
            level.setBlock(pos, state.setValue(MBS, mbState), 2);
        }
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state,
            @Nullable LivingEntity placer, ItemStack stack)
    {
        level.setBlock(pos, state.setValue(MBS, 0), 2);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos,
            BlockState newState, boolean movedByPiston)
    {
        //structure broken: reset all member tiles
        if (!state.is(newState.getBlock()) && !level.isClientSide())
        {
            BlockEntity tile = level.getBlockEntity(pos);

            if (tile instanceof BasicMultiBlockEntity multi && multi.hasMaster())
            {
                BlockPos mp = multi.getMasterPos();
                MultiBlockHelper.resetStructure(level,
                    mp.getX(), mp.getY(), mp.getZ());
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    /** right click without item: form structure or open GUI (legacy onBlockActivated) */
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level,
            BlockPos pos, Player player, BlockHitResult hitResult)
    {
        if (level.isClientSide())
        {
            return InteractionResult.SUCCESS;
        }
        else if (!player.isSecondaryUseActive())
        {
            BlockEntity te = level.getBlockEntity(pos);

            if (te instanceof BasicMultiBlockEntity tile)
            {
                //MBS formed: open GUI on master
                if (tile.hasMaster())
                {
                    if (tile.getStructType() == 1)  //large shipyard
                    {
                        BlockEntity master = level.getBlockEntity(tile.getMasterPos());

                        if (master instanceof TileMultiGrudgeHeavy)
                        {
                            LogHelper.debug("DEBUG : open multi block GUI");
                            player.openMenu((TileMultiGrudgeHeavy) master,
                                tile.getMasterPos());
                            return InteractionResult.CONSUME;
                        }
                    }
                }
                //MBS not formed: check if structure can form
                else
                {
                    //MBS 1: heavy grudge -> large shipyard
                    if (tile instanceof TileMultiGrudgeHeavy)
                    {
                        int type = MultiBlockHelper.checkMultiBlockForm(level,
                            pos.getX(), pos.getY(), pos.getZ());

                        if (type > 0)
                        {
                            MultiBlockHelper.setupStructure(level,
                                pos.getX(), pos.getY(), pos.getZ(), type);
                            LogHelper.debug("DEBUG: multi block form: type " + type);
                            return InteractionResult.CONSUME;
                        }
                    }
                }
            }
        }

        return InteractionResult.PASS;
    }


}

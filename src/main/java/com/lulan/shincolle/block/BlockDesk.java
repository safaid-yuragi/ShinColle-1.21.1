package com.lulan.shincolle.block;

import javax.annotation.Nullable;

import com.lulan.shincolle.blockentity.TileEntityDesk;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;

/**
 * port of legacy BlockDesk. Right-click opens the desk menu (page 0, radar).
 * The open buffer carries [hasPos][BlockPos][page] to match DeskMenu.
 */
public class BlockDesk extends BasicBlockFacingContainer
{


    public BlockDesk()
    {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(1F, 60F).sound(SoundType.METAL));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new TileEntityDesk(pos, state);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level,
            BlockPos pos, Player player, BlockHitResult hitResult)
    {
        if (!level.isClientSide() && !player.isSecondaryUseActive())
        {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof TileEntityDesk tile)
            {
                player.openMenu(tile, buf ->
                {
                    buf.writeBoolean(true);
                    buf.writeBlockPos(pos);
                    buf.writeByte(0);   //page 0 = radar
                });
                return InteractionResult.CONSUME;
            }
        }
        return level.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.PASS;
    }


}

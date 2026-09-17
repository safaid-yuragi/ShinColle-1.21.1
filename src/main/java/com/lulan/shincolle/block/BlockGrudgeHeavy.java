package com.lulan.shincolle.block;

import javax.annotation.Nullable;

import com.lulan.shincolle.blockentity.TileMultiGrudgeHeavy;
import com.lulan.shincolle.registry.ModBlocks;
import com.lulan.shincolle.registry.ModComponents;
import com.lulan.shincolle.utility.TeamHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

/**
 * port of legacy BlockGrudgeHeavy (large shipyard core).
 * Carries mats/fuel data on its item form when broken.
 */
public class BlockGrudgeHeavy extends BasicBlockMulti
{


    public BlockGrudgeHeavy()
    {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.WATER)
            .strength(3F, 600F).sound(SoundType.SAND).lightLevel(s -> 15));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new TileMultiGrudgeHeavy(pos, state);
    }

    //save mats/fuel from item nbt to tile on placed
    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state,
            @Nullable LivingEntity placer, ItemStack stack)
    {
        super.setPlacedBy(level, pos, state, placer, stack);

        BlockEntity tile = level.getBlockEntity(pos);

        if (tile instanceof TileMultiGrudgeHeavy tile2)
        {
            //set tile ownership
            if (placer instanceof Player player)
            {
                tile2.setPlayerUID(TeamHelper.getPlayerUID(player));
            }

            //restore mats to matStock
            CustomData data = stack.get(ModComponents.SHIP_DATA.get());
            if (data == null)
            {
                data = stack.get(DataComponents.BLOCK_ENTITY_DATA);
            }
            if (data != null)
            {
                CompoundTag nbt = data.copyTag();
                int[] mats = nbt.getIntArray("mats");
                int fuel = nbt.getInt("fuel");

                if (mats.length >= 4)
                {
                    tile2.setMatStock(0, mats[0]);
                    tile2.setMatStock(1, mats[1]);
                    tile2.setMatStock(2, mats[2]);
                    tile2.setMatStock(3, mats[3]);
                }
                tile2.setPowerRemained(fuel);
            }
        }
    }

    //drop block item with mats/fuel nbt + inventory contents
    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos,
            BlockState newState, boolean movedByPiston)
    {
        if (!state.is(newState.getBlock()) && !level.isClientSide())
        {
            BlockEntity getTile = level.getBlockEntity(pos);

            if (getTile instanceof TileMultiGrudgeHeavy tile)
            {
                //save matBuild + matStock to item
                float ranf1 = level.random.nextFloat() * 0.5F + 0.2F;
                float ranf2 = level.random.nextFloat() * 0.5F + 0.2F;
                float ranf3 = level.random.nextFloat() * 0.5F + 0.2F;
                ItemStack drop = new ItemStack(ModBlocks.ITEM_GRUDGE_HEAVY.get());
                CompoundTag nbt = new CompoundTag();

                int[] mats = new int[4];
                mats[0] = tile.getMatBuild(0) + tile.getMatStock(0);
                mats[1] = tile.getMatBuild(1) + tile.getMatStock(1);
                mats[2] = tile.getMatBuild(2) + tile.getMatStock(2);
                mats[3] = tile.getMatBuild(3) + tile.getMatStock(3);

                nbt.putIntArray("mats", mats);
                nbt.putInt("fuel", tile.getPowerRemained());
                drop.set(ModComponents.SHIP_DATA.get(), CustomData.of(nbt));

                ItemEntity item = new ItemEntity(level,
                    pos.getX() + ranf1, pos.getY() + ranf2, pos.getZ() + ranf3,
                    drop);
                level.addFreshEntity(item);
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    //random portal sound
    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos,
            RandomSource rand)
    {
        if (rand.nextInt(50) == 0)
        {
            level.playLocalSound(pos.getX() + 0.5D, pos.getY() + 0.5D,
                pos.getZ() + 0.5D, SoundEvents.PORTAL_AMBIENT,
                SoundSource.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }
    }

    /** master tile reference for renderer */
    @Nullable
    public static TileMultiGrudgeHeavy getMasterTile(Level level, BlockPos pos)
    {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof TileMultiGrudgeHeavy t) return t.getMasterShipyard();
        if (be instanceof com.lulan.shincolle.blockentity.BasicMultiBlockEntity m &&
            m.getMaster() instanceof TileMultiGrudgeHeavy t) return t;
        return null;
    }


}

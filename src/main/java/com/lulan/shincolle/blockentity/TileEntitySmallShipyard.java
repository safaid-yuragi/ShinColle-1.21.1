package com.lulan.shincolle.blockentity;

import com.lulan.shincolle.registry.ModBlockEntities;
import com.lulan.shincolle.registry.ModItems;
import com.lulan.shincolle.utility.TileEntityHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

/**
 * port of legacy TileEntitySmallShipyard. Full machine logic is ported in Phase 5.
 *
 * slots: 0:grudge 1:abyssium 2:ammo 3:polymetal 4:fuel 5:output
 */
public class TileEntitySmallShipyard extends BasicBlockEntity
{

    /** field ids for GUI sync */
    public static final int FIELD_POWER = 0;   // remained power (fuel)
    public static final int FIELD_BUILDTYPE = 1;
    public static final int FIELD_MATSTOCK0 = 2; // matStock[0..3]
    public static final int FIELD_INVMODE = 6;
    public static final int FIELD_COUNT = 7;


    public TileEntitySmallShipyard(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.TILEENTITYSMALLSHIPYARD.get(), pos, state, 6);
        this.fields = new int[FIELD_COUNT];
    }


    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        if (stack.isEmpty()) return false;
        var item = stack.getItem();

        switch (slot)
        {
        case 0:  //grudge
            return item == ModItems.GRUDGE.get();
        case 1:  //abyssium
            return item == ModItems.ABYSS_METAL.get();
        case 2:  //ammo
            return item == ModItems.AMMO.get();
        case 3:  //polymetal
            return item == ModItems.ABYSS_METAL_1.get();
        case 4:  //fuel
            return TileEntityHelper.getItemFuelValue(stack) > 0 ||
                   item == ModItems.INSTANT_CON_MAT.get();
        case 5:  //output: no manual insert
        default:
            return false;
        }
    }


    @Override
    public net.minecraft.world.inventory.AbstractContainerMenu createMenu(
        int containerId, net.minecraft.world.entity.player.Inventory inv,
        net.minecraft.world.entity.player.Player player)
    {
        return new com.lulan.shincolle.menu.SmallShipyardMenu(containerId, inv, this);
    }


}

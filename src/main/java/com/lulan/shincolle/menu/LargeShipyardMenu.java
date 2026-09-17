package com.lulan.shincolle.menu;

import com.lulan.shincolle.blockentity.BasicBlockEntity;
import com.lulan.shincolle.registry.ModMenus;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.items.IItemHandler;

/**
 * port of legacy ContainerLargeShipyard (TileMultiGrudgeHeavy).
 * slot 0 output + slots 1~9 materials/fuel + player inv; 7 synced fields.
 */
public class LargeShipyardMenu extends BasicTileMenu
{

    public LargeShipyardMenu(int containerId, Inventory invPlayer, BasicBlockEntity tile)
    {
        super(ModMenus.LARGE_SHIPYARD.get(), containerId, tile);

        if (tile != null)
        {
            IItemHandler inv = tile.getItemHandler();
            this.addTileSlot(inv, 0, 168, 51);          //output
            for (int i = 1; i < 10; i++)
            {
                this.addTileSlot(inv, i, 7 + i * 18, 116);
            }
        }

        this.addPlayerSlots(invPlayer, 25, 141);
    }

    public LargeShipyardMenu(int containerId, Inventory invPlayer, FriendlyByteBuf buf)
    {
        this(containerId, invPlayer, resolveTile(invPlayer, buf));
    }

}

package com.lulan.shincolle.menu;

import com.lulan.shincolle.blockentity.BasicBlockEntity;
import com.lulan.shincolle.registry.ModMenus;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.items.IItemHandler;

/**
 * port of legacy ContainerSmallShipyard.
 * slots: 0 grudge,1 abyssium,2 ammo,3 poly,4 fuel,5 output + player inv.
 */
public class SmallShipyardMenu extends BasicTileMenu
{

    public SmallShipyardMenu(int containerId, Inventory invPlayer, BasicBlockEntity tile)
    {
        super(ModMenus.SMALL_SHIPYARD.get(), containerId, tile);

        if (tile != null)
        {
            IItemHandler inv = tile.getItemHandler();
            this.addTileSlot(inv, 0, 33, 29);   //grudge
            this.addTileSlot(inv, 1, 53, 29);   //abyssium
            this.addTileSlot(inv, 2, 73, 29);   //ammo
            this.addTileSlot(inv, 3, 93, 29);   //polymetal
            this.addTileSlot(inv, 4, 8, 53);    //fuel
            this.addTileSlot(inv, 5, 134, 44);  //output
        }

        this.addPlayerSlots(invPlayer, 8, 87);
    }

    public SmallShipyardMenu(int containerId, Inventory invPlayer, FriendlyByteBuf buf)
    {
        this(containerId, invPlayer, resolveTile(invPlayer, buf));
    }

}

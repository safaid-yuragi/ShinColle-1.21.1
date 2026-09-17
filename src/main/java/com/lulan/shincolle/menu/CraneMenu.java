package com.lulan.shincolle.menu;

import com.lulan.shincolle.blockentity.BasicBlockEntity;
import com.lulan.shincolle.registry.ModMenus;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.items.IItemHandler;

/**
 * port of legacy ContainerCrane. 18 storage slots (2 rows) + player inv;
 * 14 synced fields for crane mode/target config.
 */
public class CraneMenu extends BasicTileMenu
{

    public CraneMenu(int containerId, Inventory invPlayer, BasicBlockEntity tile)
    {
        super(ModMenus.CRANE.get(), containerId, tile);

        if (tile != null)
        {
            IItemHandler inv = tile.getItemHandler();
            for (int i = 0; i < 9; i++)
            {
                this.addTileSlot(inv, i, 8 + i * 18, 65);
                this.addTileSlot(inv, i + 9, 8 + i * 18, 96);
            }
        }

        this.addPlayerSlots(invPlayer, 8, 119);
    }

    public CraneMenu(int containerId, Inventory invPlayer, FriendlyByteBuf buf)
    {
        this(containerId, invPlayer, resolveTile(invPlayer, buf));
    }

}

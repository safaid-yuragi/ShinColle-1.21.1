package com.lulan.shincolle.menu;

import com.lulan.shincolle.blockentity.BasicBlockEntity;
import com.lulan.shincolle.registry.ModMenus;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.items.IItemHandler;

/** port of legacy ContainerVolCore. 9 fuel slots + player inv; field0 = power/active. */
public class VolCoreMenu extends BasicTileMenu
{

    public VolCoreMenu(int containerId, Inventory invPlayer, BasicBlockEntity tile)
    {
        super(ModMenus.VOLCORE.get(), containerId, tile);

        if (tile != null)
        {
            IItemHandler inv = tile.getItemHandler();

            //3x3 fuel grid
            for (int i = 0; i < 9; i++)
            {
                this.addTileSlot(inv, i, 62 + (i % 3) * 18, 19 + (i / 3) * 18);
            }
        }

        this.addPlayerSlots(invPlayer, 8, 84);
    }

    public VolCoreMenu(int containerId, Inventory invPlayer, FriendlyByteBuf buf)
    {
        this(containerId, invPlayer, resolveTile(invPlayer, buf));
    }

}

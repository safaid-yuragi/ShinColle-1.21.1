package com.lulan.shincolle.menu;

import com.lulan.shincolle.blockentity.BasicBlockEntity;
import com.lulan.shincolle.registry.ModMenus;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;

/**
 * port of legacy ContainerDesk. No item slots — the desk GUI is a radar/book
 * UI driven purely by synced fields + custom payloads. Opens two ways:
 * via the desk block (pos) or via the book/radar item (no tile, page index).
 */
public class DeskMenu extends BasicTileMenu
{

    /** which desk sub-page to show (0 radar,1 book,2 team,3 target …) */
    private final int page;


    public DeskMenu(int containerId, Inventory invPlayer, BasicBlockEntity tile, int page)
    {
        super(ModMenus.DESK.get(), containerId, tile);
        this.page = page;
        this.addPlayerSlots(invPlayer, 8, 140);
    }

    /** buffer: [hasPos][BlockPos?][page] */
    public DeskMenu(int containerId, Inventory invPlayer, FriendlyByteBuf buf)
    {
        this(containerId, invPlayer,
            buf.readBoolean() ? resolveTileAt(invPlayer, buf) : null,
            buf.readByte());
    }

    private static BasicBlockEntity resolveTileAt(Inventory invPlayer, FriendlyByteBuf buf)
    {
        net.minecraft.core.BlockPos pos = buf.readBlockPos();
        var be = invPlayer.player.level().getBlockEntity(pos);
        return (be instanceof BasicBlockEntity b) ? b : null;
    }

    public int getPage()
    {
        return this.page;
    }


}

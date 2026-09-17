package com.lulan.shincolle.item;

import com.lulan.shincolle.menu.DeskMenu;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * desk sub-item (book/radar). Right-click opens the desk GUI at a page
 * standalone (legacy ID.Gui.ADMIRALDESK, x = page).
 */
public class DeskItem extends BasicItem
{

    /** desk GUI page index (0 radar … 1 radar-item, 2 book, 3 team, 4 target) */
    private final int page;


    public DeskItem(Properties props, int page)
    {
        super(props);
        this.page = page;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide())
        {
            player.openMenu(new SimpleMenuProvider(
                (id, inv, p) -> new DeskMenu(id, inv, null, this.page),
                Component.translatable("gui.shincolle.desk")),
                buf ->
                {
                    buf.writeBoolean(false);   //no tile
                    buf.writeByte(this.page);
                });
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }


}

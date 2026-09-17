package com.lulan.shincolle.item;

import com.lulan.shincolle.menu.RecipePaperMenu;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * recipe paper item. Right-click opens the pattern-editing GUI
 * (legacy ID.Gui.RECIPE).
 */
public class RecipePaperItem extends BasicItem
{


    public RecipePaperItem(Properties props)
    {
        super(props);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide())
        {
            player.openMenu(new SimpleMenuProvider(
                (id, inv, p) -> new RecipePaperMenu(id, inv, stack),
                Component.translatable("gui.shincolle.recipepaper")),
                buf -> {});
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }


}

package com.lulan.shincolle.item;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

/**
 * item base (legacy BasicItem). Tooltip text keys:
 * {@code tooltip.shincolle.<registry_name>}.
 */
public class BasicItem extends Item
{


    public BasicItem(Properties props)
    {
        super(props);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context,
                                List<Component> tooltip, TooltipFlag flag)
    {
        super.appendHoverText(stack, context, tooltip, flag);
        tooltip.add(Component.translatable(this.getDescriptionId(stack) + ".tip")
            .withStyle(net.minecraft.ChatFormatting.GRAY));
    }


}

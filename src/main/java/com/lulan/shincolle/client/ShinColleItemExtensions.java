package com.lulan.shincolle.client;

import com.lulan.shincolle.client.render.item.ShinColleBEWLR;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

/**
 * custom item rendering hook: desk / small shipyard block items use the
 * block-entity models instead of baked models (legacy TEISR hook).
 */
public class ShinColleItemExtensions implements IClientItemExtensions
{

    private BlockEntityWithoutLevelRenderer renderer;


    @Override
    public BlockEntityWithoutLevelRenderer getCustomRenderer()
    {
        if (this.renderer == null) this.renderer = new ShinColleBEWLR();
        return this.renderer;
    }


}

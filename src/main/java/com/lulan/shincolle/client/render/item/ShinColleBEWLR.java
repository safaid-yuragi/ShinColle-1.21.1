package com.lulan.shincolle.client.render.item;

import com.lulan.shincolle.client.model.ModelBlockDesk;
import com.lulan.shincolle.client.model.ModelSmallShipyard;
import com.lulan.shincolle.client.render.ModModelLayers;
import com.lulan.shincolle.client.render.block.DeskBlockEntityRenderer;
import com.lulan.shincolle.client.render.block.SmallShipyardBlockEntityRenderer;
import com.lulan.shincolle.registry.ModBlocks;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

/**
 * item renderer for block items whose in-world form is a custom block entity
 * model (legacy RenderTileEntityItem / TileEntityItemStackRenderer).
 */
public class ShinColleBEWLR extends BlockEntityWithoutLevelRenderer
{

    private final ModelBlockDesk<Entity> deskModel;
    private final ModelSmallShipyard<Entity> shipyardModel;


    public ShinColleBEWLR()
    {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        EntityModelSet set = Minecraft.getInstance().getEntityModels();
        this.deskModel = new ModelBlockDesk<>(set.bakeLayer(ModModelLayers.MODELBLOCKDESK));
        this.shipyardModel = new ModelSmallShipyard<>(set.bakeLayer(ModModelLayers.MODELSMALLSHIPYARD));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext context, PoseStack poseStack, MultiBufferSource buffer, int light, int overlay)
    {
        if (stack.is(ModBlocks.ITEM_DESK.get()))
        {
            DeskBlockEntityRenderer.renderDesk(this.deskModel, 0F, poseStack, buffer, light, overlay);
        }
        else if (stack.is(ModBlocks.ITEM_SMALL_SHIPYARD.get()))
        {
            //item form shows the active (lit) texture, same as legacy meta = -1
            SmallShipyardBlockEntityRenderer.renderShipyard(this.shipyardModel, 0F, true, poseStack, buffer, light, overlay);
        }
    }


}

package com.lulan.shincolle.client;

import org.lwjgl.glfw.GLFW;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.BasicEntitySummon;
import com.lulan.shincolle.network.payload.PointerItemPayload;
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.registry.ModComponents;
import com.lulan.shincolle.registry.ModItems;
import com.lulan.shincolle.utility.EntityHelper;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;

/**
 * client input hooks (legacy EventHandler.onKeyInput).
 *
 * - pointer item: sprint + hotbar 1-9 sets the player's pointer team id;
 *   player-list key toggles pointer mode (normal <-> caress/magnifier).
 * - OP tool debug keys: numpad 1 marks the looked-at entity class as
 *   unattackable, numpad 2 prints the list (debugMode only).
 */
@EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT)
public final class ClientInputHandler
{

    /** debug: mark looked-at entity class unattackable */
    public static final KeyMapping KEY_DEBUG_UNATK = new KeyMapping(
        "key.shincolle.debug_unattackable", GLFW.GLFW_KEY_KP_1,
        "key.categories.shincolle");

    /** debug: show unattackable class list */
    public static final KeyMapping KEY_DEBUG_UNATK_LIST = new KeyMapping(
        "key.shincolle.debug_unattackable_list", GLFW.GLFW_KEY_KP_2,
        "key.categories.shincolle");

    private static int debugCooldown = 0;


    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event)
    {
        if (debugCooldown > 0) debugCooldown--;

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null || mc.level == null) return;

        handlePointerKeys(mc, player);
        handleOPToolKeys(mc, player);
    }

    /** pointer item keys (legacy EntityHelper.handlePointerKeyInput) */
    private static void handlePointerKeys(Minecraft mc, Player player)
    {
        ItemStack pointer = EntityHelper.getPointerInUse(player);
        if (pointer == null || pointer.isEmpty()) return;

        var options = mc.options;

        //sprint held + hotbar N pressed -> set pointer team id
        if (options.keySprint.isDown())
        {
            for (int i = 0; i < options.keyHotbarSlots.length; i++)
            {
                if (options.keyHotbarSlots[i].consumeClick())
                {
                    LogHelper.debug("DEBUG: key input: pointer set team: " + i);
                    PacketDistributor.sendToServer(
                        PointerItemPayload.setTeam(i, player.getInventory().selected));
                    break;
                }
            }
        }
        //player-list key toggles pointer mode (main hand only, no offhand)
        else if (player.getMainHandItem().is(ModItems.POINTER_ITEM.get()) &&
                 options.keyPlayerList.consumeClick())
        {
            int mode = pointer.getOrDefault(ModComponents.POINTER_MODE, 0);

            switch (mode)
            {
            case 1:
            case 2:
                mode += 3;
            break;
            case 3:
            case 4:
            case 5:
                mode -= 3;
            break;
            default:
                mode = 3;
            break;
            }

            pointer.set(ModComponents.POINTER_MODE.get(), mode);
            PacketDistributor.sendToServer(PointerItemPayload.syncMode(mode));
        }
    }

    /** OP tool debug keys (legacy TargetHelper.handleOPToolKeyInput) */
    private static void handleOPToolKeys(Minecraft mc, Player player)
    {
        if (debugCooldown > 0 || !ShinColleConfig.debugMode) return;
        if (!player.getMainHandItem().is(ModItems.OP_TOOL.get())) return;

        //numpad 1: mark looked-at entity class unattackable
        if (KEY_DEBUG_UNATK.isDown())
        {
            debugCooldown = 5;
            Entity hit = raytraceEntity(player, 32D);

            if (hit != null &&
                !(hit instanceof BasicEntityShip) &&
                !(hit instanceof BasicEntityMount) &&
                !(hit instanceof BasicEntitySummon))
            {
                String tarName = hit.getClass().getSimpleName();
                LogHelper.debug("DEBUG: target wrench get class: " + tarName);
                PacketDistributor.sendToServer(
                    PointerItemPayload.setUnatkClass(tarName));
            }
        }
        //numpad 2: show unattackable class list
        else if (KEY_DEBUG_UNATK_LIST.isDown())
        {
            debugCooldown = 20;
            PacketDistributor.sendToServer(PointerItemPayload.showUnatkClass());
        }
    }

    /** entity under the crosshair (client-side raytrace for the OP tool) */
    private static Entity raytraceEntity(Player player, double range)
    {
        Vec3 eye = player.getEyePosition(1F);
        Vec3 look = player.getViewVector(1F);
        Vec3 end = eye.add(look.scale(range));

        AABB box = player.getBoundingBox()
            .expandTowards(look.scale(range)).inflate(1D);
        EntityHitResult hit = ProjectileUtil.getEntityHitResult(
            player.level(), player, eye, end, box,
            e -> e.isAlive() && e.isPickable() && e != player);

        return hit != null ? hit.getEntity() : null;
    }


    private ClientInputHandler() {}

}

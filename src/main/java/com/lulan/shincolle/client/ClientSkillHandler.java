package com.lulan.shincolle.client;

import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.network.payload.PlayerSkillPayload;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;

/**
 * client skill-key watcher (legacy ShipSkillHandler client half).
 *
 * While riding a ship mount, hotbar keys 1-4 trigger the ship's
 * light/heavy/air attacks at the entity or block under the crosshair.
 */
@EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT)
public final class ClientSkillHandler
{

    /** local cooldown so we don't spam packets every tick */
    private static int keyCD = 0;
    private static boolean lastJumpSent = false;


    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event)
    {
        if (keyCD > 0) keyCD--;

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null || mc.level == null) return;

        //only while riding our mounts (ship-carry uses the same keys later)
        BasicEntityMount mount = player.getVehicle() instanceof BasicEntityMount m ? m : null;
        if (mount == null) return;

        //jump key isn't covered by vanilla vehicle input sync
        boolean jump = mc.options.keyJump.isDown();
        if (jump != lastJumpSent)
        {
            lastJumpSent = jump;
            PacketDistributor.sendToServer(
                new com.lulan.shincolle.network.payload.MountMovePayload(jump));
        }

        if (keyCD > 0) return;

        BasicEntityShip ship = mount.getHostShip();
        if (ship == null || ship.getAttrs() == null) return;

        int skill = -1;
        var keys = mc.options.keyHotbarSlots;
        if (keys[0].isDown()) skill = 0;
        else if (keys[1].isDown()) skill = 1;
        else if (keys[2].isDown()) skill = 2;
        else if (keys[3].isDown()) skill = 3;
        if (skill < 0) return;

        keyCD = 4;

        double range = ship.getAttrs().getAttackRange();

        //entity under crosshair first, then block
        Entity target = raytraceEntity(player, range, mount, ship);
        if (target != null)
        {
            PacketDistributor.sendToServer(PlayerSkillPayload.entity(skill, target.getId()));
            return;
        }

        BlockPos pos = raytraceBlock(player, range);
        if (pos != null)
        {
            PacketDistributor.sendToServer(PlayerSkillPayload.block(skill, pos));
        }
    }

    /** entity under the crosshair within range, excluding self/mount/ship */
    private static Entity raytraceEntity(Player player, double range,
            Entity... exclude)
    {
        Vec3 eye = player.getEyePosition(1F);
        Vec3 look = player.getViewVector(1F);
        Vec3 end = eye.add(look.scale(range));

        AABB box = player.getBoundingBox().expandTowards(look.scale(range)).inflate(1D);
        EntityHitResult hit = ProjectileUtil.getEntityHitResult(
            player.level(), player, eye, end, box,
            e ->
            {
                for (Entity ex : exclude) if (e == ex) return false;
                return e.isAlive() && e.isPickable();
            });

        return hit != null ? hit.getEntity() : null;
    }

    /** block under the crosshair within range */
    private static BlockPos raytraceBlock(Player player, double range)
    {
        Vec3 eye = player.getEyePosition(1F);
        Vec3 end = eye.add(player.getViewVector(1F).scale(range));

        BlockHitResult hit = player.level().clip(new ClipContext(eye, end,
            ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));

        return hit.getType() == HitResult.Type.BLOCK ? hit.getBlockPos() : null;
    }


    private ClientSkillHandler() {}

}

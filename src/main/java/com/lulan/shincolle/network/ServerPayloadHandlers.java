package com.lulan.shincolle.network;

import com.lulan.shincolle.blockentity.TileEntityWaypoint;
import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipGuardian;
import com.lulan.shincolle.entity.IShipState;
import com.lulan.shincolle.network.payload.MountMovePayload;
import com.lulan.shincolle.network.payload.PairingPayload;
import com.lulan.shincolle.network.payload.PlayerSkillPayload;
import com.lulan.shincolle.network.payload.RidingRequestPayload;
import com.lulan.shincolle.network.payload.ShipActionPayload;
import com.lulan.shincolle.playerskill.ShipSkillHandler;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.LogHelper;
import com.lulan.shincolle.utility.TeamHelper;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/**
 * server-side C2S payload handlers.
 */
public final class ServerPayloadHandlers
{


    /** player skill key (mount riding / ship carrying) */
    public static void handlePlayerSkill(PlayerSkillPayload payload, IPayloadContext context)
    {
        context.enqueueWork(() ->
        {
            if (context.player() instanceof ServerPlayer player)
            {
                ShipSkillHandler.handlePlayerSkill(player, payload.skill(),
                    payload.targetId(), payload.pos());
            }
        });
    }

    /** waypoint <-> chest pairing */
    public static void handlePairing(PairingPayload payload, IPayloadContext context)
    {
        context.enqueueWork(() ->
        {
            if (!(context.player() instanceof ServerPlayer player)) return;

            var level = player.level();
            var pos = payload.waypoint();

            //must be close to the waypoint
            if (pos.distSqr(player.blockPosition()) > 64D) return;

            if (level.getBlockEntity(pos) instanceof TileEntityWaypoint waypoint)
            {
                var chest = payload.chest();

                if (chest.getY() < 0)
                {
                    waypoint.setPairedChest(null);
                }
                else if (level.getBlockEntity(chest) instanceof Container)
                {
                    waypoint.setPairedChest(chest);
                }

                LogHelper.debug("DEBUG: waypoint paired: " + pos + " -> " + chest);
            }
        });
    }

    /** mount/dismount request on an own mount */
    public static void handleRiding(RidingRequestPayload payload, IPayloadContext context)
    {
        context.enqueueWork(() ->
        {
            if (!(context.player() instanceof ServerPlayer player)) return;

            if (payload.dismount())
            {
                if (player.getVehicle() instanceof BasicEntityMount mount &&
                    TeamHelper.checkSameOwner(player, mount))
                {
                    player.stopRiding();
                }
                return;
            }

            Entity target = player.level().getEntity(payload.mountId());
            if (target instanceof BasicEntityMount mount &&
                mount.isAlive() && !mount.isVehicle() &&
                TeamHelper.checkSameOwner(player, mount) &&
                player.distanceToSqr(mount) < 36D)
            {
                player.startRiding(mount);
            }
        });
    }

    /** rider jump state for mounts */
    public static void handleMountMove(MountMovePayload payload, IPayloadContext context)
    {
        context.enqueueWork(() ->
        {
            if (context.player() instanceof ServerPlayer player &&
                player.getVehicle() instanceof BasicEntityMount mount)
            {
                mount.setRiderJump(payload.jumping());
            }
        });
    }

    /**
     * generic ship GUI button action (Phase 6 wires the full set).
     * action ids: 0 toggle sit, 1 toggle follow, 2 clear guard,
     * 3 set AI flag (value = ID.F index toggled).
     */
    public static void handleShipAction(ShipActionPayload payload, IPayloadContext context)
    {
        context.enqueueWork(() ->
        {
            if (!(context.player() instanceof ServerPlayer player)) return;

            Entity target = player.level().getEntity(payload.entityId());
            if (!(target instanceof IShipState state)) return;
            if (!TeamHelper.checkSameOwner(player, target)) return;

            switch (payload.action())
            {
            case 0 ->
            {
                if (target instanceof com.lulan.shincolle.entity.IShipEmotion emo)
                {
                    emo.setEntitySit(!emo.getIsSitting());
                }
            }
            case 1 -> state.setStateFlag(ID.F.CanFollow,
                !state.getStateFlag(ID.F.CanFollow));
            case 2 ->
            {
                if (target instanceof IShipGuardian guardian)
                {
                    guardian.setGuardedEntity(null);
                    guardian.setGuardedPos(0, 0, 0, 0, 0);
                }
            }
            case 3 ->
            {
                int flag = payload.value();
                if (flag >= 0 && flag < ID.F.LENGTH)
                {
                    state.setStateFlag(flag, !state.getStateFlag(flag));
                }
            }
            default -> {}
            }
        });
    }


    private ServerPayloadHandlers() {}

}

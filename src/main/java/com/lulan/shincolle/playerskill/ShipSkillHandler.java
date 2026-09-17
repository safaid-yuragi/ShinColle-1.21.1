package com.lulan.shincolle.playerskill;

import javax.annotation.Nullable;

import com.lulan.shincolle.entity.BasicEntityMount;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.IShipAircraftAttack;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.CombatHelper;
import com.lulan.shincolle.utility.TeamHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

/**
 * player-driven ship skill handler (legacy ShipSkillHandler server half).
 *
 * The client sends PlayerSkillPayload (skill index + target) while riding
 * a mount or carrying a ship; this class validates ownership, cooldown,
 * range and friendly-fire, then calls the matching attack method.
 */
public class ShipSkillHandler
{


    /**
     * handle a skill request from a player.
     * skill: 0 light / 1 heavy / 2 air light / 3 air heavy.
     * targetId >= 0 -> entity target, else pos is the block target.
     */
    public static void handlePlayerSkill(ServerPlayer player, int skill,
            int targetId, BlockPos pos)
    {
        BasicEntityShip ship = null;

        //player riding a mount -> mount's host ship
        if (player.getVehicle() instanceof BasicEntityMount mount)
        {
            Entity host = mount.getHostEntity();
            if (host instanceof BasicEntityShip s) ship = s;
        }
        //ship riding the player
        else if (!player.getPassengers().isEmpty() &&
                 player.getPassengers().get(0) instanceof BasicEntityShip s)
        {
            ship = s;
        }

        if (ship == null) return;

        castPlayerSkill(ship, player, skill, targetId, pos);
    }

    /**
     * validate and cast the skill (legacy castPlayerSkill).
     */
    public static void castPlayerSkill(BasicEntityShip ship, Player player,
            int skill, int targetId, BlockPos pos)
    {
        if (!TeamHelper.checkSameOwner(player, ship)) return;

        int cdTimer = switch (skill)
        {
            case 0 ->
            {
                if (!ship.getStateFlag(ID.F.AtkType_Light)) yield -1;
                yield ID.T.MountSkillCD1;
            }
            case 1 ->
            {
                if (!ship.getStateFlag(ID.F.AtkType_Heavy)) yield -1;
                yield ID.T.MountSkillCD2;
            }
            case 2 ->
            {
                if (!ship.getStateFlag(ID.F.AtkType_AirLight)) yield -1;
                yield ID.T.MountSkillCD3;
            }
            case 3 ->
            {
                if (!ship.getStateFlag(ID.F.AtkType_AirHeavy)) yield -1;
                yield ID.T.MountSkillCD4;
            }
            default -> -1;
        };

        if (cdTimer < 0 || ship.getStateTimer(cdTimer) > 0) return;

        //resolve target: entity by id, or block pos
        Entity target = null;
        BlockPos targetPos = null;
        float rangeSq = ship.getAttrs().getAttackRange() * ship.getAttrs().getAttackRange();

        if (targetId >= 0)
        {
            target = player.level().getEntity(targetId);
            if (target != null && ship.distanceToSqr(target) > rangeSq) target = null;
        }
        else if (pos.getY() >= 0)
        {
            targetPos = pos;
            if (ship.distanceToSqr(pos.getX(), pos.getY(), pos.getZ()) > rangeSq)
            {
                targetPos = null;
            }
        }

        //reject friendly targets
        if (target != null && TeamHelper.checkSameOwner(ship, target)) return;

        switch (skill)
        {
        case 0:  //light attack
            if (target != null)
            {
                ship.attackEntityWithAmmo(target);
                ship.setStateTimer(cdTimer,
                    CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 1));
            }
        break;
        case 1:  //heavy attack
            boolean fired = false;
            if (target != null) fired = ship.attackEntityWithHeavyAmmo(target);
            else if (targetPos != null)
            {
                fired = ship.attackEntityWithHeavyAmmo(targetPos);
            }
            if (fired)
            {
                ship.setStateTimer(cdTimer,
                    CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 2));
            }
        break;
        case 2:  //light air attack
            if (ship instanceof IShipAircraftAttack cv && target != null)
            {
                cv.attackEntityWithAircraft(target);
                ship.setStateTimer(ID.T.MountSkillCD3,
                    CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 3));
                ship.setStateTimer(ID.T.MountSkillCD4,
                    CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 3));
            }
        break;
        case 3:  //heavy air attack
            if (ship instanceof IShipAircraftAttack cv && target != null)
            {
                cv.attackEntityWithHeavyAircraft(target);
                ship.setStateTimer(ID.T.MountSkillCD3,
                    CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 4));
                ship.setStateTimer(ID.T.MountSkillCD4,
                    CombatHelper.getAttackDelay(ship.getAttrs().getAttackSpeed(), 4));
            }
        break;
        }
    }


}

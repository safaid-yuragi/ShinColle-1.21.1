package com.lulan.shincolle.utility;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.data.PlayerUidData;
import com.lulan.shincolle.entity.IShipOwner;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.player.Player;

/**
 * team / owner relation checks (legacy TeamHelper, simplified).
 *
 * uid convention: player-owned entities > 0, hostile ships = -100,
 * ownerless entities = -1. Team ally/ban lists are Phase 6+ GUI data;
 * until then same-owner is the only ally relation.
 */
public class TeamHelper
{


    /** get owner player uid for any entity */
    public static int getPlayerUID(Entity ent)
    {
        if (ent instanceof Player player)
        {
            if (player.level() instanceof ServerLevel sl)
            {
                return PlayerUidData.get(sl).getUID(player.getUUID());
            }
            //client: uuid hash, only used for display
            return -1;
        }

        if (ent instanceof IShipOwner ship)
        {
            return ship.getPlayerUID();
        }

        if (ent instanceof OwnableEntity ownable)
        {
            Entity owner = ownable.getOwner();
            if (owner != null) return getPlayerUID(owner);
        }

        return -1;
    }

    /** target entity is host's ally */
    public static boolean checkIsAlly(Entity host, Entity target)
    {
        if (host == null || target == null) return false;

        int hostID = getPlayerUID(host);
        int tarID = getPlayerUID(target);

        return checkIsAlly(hostID, tarID);
    }

    public static boolean checkIsAlly(int hostPID, int tarPID)
    {
        //mob vs mob
        if (hostPID < -1 && tarPID < -1) return true;

        //player vs mob
        if ((hostPID < -1 && tarPID > 0) || (hostPID > 0 && tarPID < -1)) return false;

        //player vs player: same owner only (team ally list is Phase 6+)
        if (hostPID > 0 && tarPID > 0) return hostPID == tarPID;

        return false;
    }

    /** target entity is host's enemy (banned team) */
    public static boolean checkIsBanned(Entity host, Entity target)
    {
        if (host == null || target == null) return false;

        return checkIsBanned(getPlayerUID(host), getPlayerUID(target));
    }

    public static boolean checkIsBanned(int hostPID, int tarPID)
    {
        //mob vs mob
        if (hostPID < -1 && tarPID < -1) return false;

        //player vs mob
        if ((hostPID < -1 && tarPID > 0) || (hostPID > 0 && tarPID < -1)) return true;

        //player vs player: team ban list is Phase 6+ data
        return false;
    }

    /** friendly fire rule: false = attack does no damage (legacy doFriendlyFire) */
    public static boolean doFriendlyFire(IShipOwner attacker, Entity target)
    {
        if (attacker != null && target != null)
        {
            int ida = attacker.getPlayerUID();
            int idb = getPlayerUID(target);

            if (ShinColleConfig.friendlyFire)
            {
                //same owner never damages
                if ((ida > 0 || ida < -1) && ida == idb) return false;
            }
            else
            {
                //hostile vs hostile ship = no damage
                if (ida < -1 && idb < -1 && ida == idb) return false;

                //ships can NOT hurt players
                if (ida >= -1 && target instanceof Player) return false;

                //no damage to allies
                if (checkIsAlly(ida, idb)) return false;
            }
        }

        return true;
    }

    /** both entities belong to the same owner */
    public static boolean checkSameOwner(Entity enta, Entity entb)
    {
        int ida = getPlayerUID(enta);
        int idb = getPlayerUID(entb);

        //ida, idb != 0(other entity) or -1(ownerless ship)
        if ((ida > 0 || ida < -1) && (idb > 0 || idb < -1))
        {
            return ida == idb;
        }

        return false;
    }


}

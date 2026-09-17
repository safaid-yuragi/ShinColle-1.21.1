package com.lulan.shincolle.utility;

import com.lulan.shincolle.entity.IShipAttackBase;
import com.lulan.shincolle.reference.ID;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

/**
 * formation helpers (legacy FormationHelper, simplified).
 *
 * Formation slot tables live in Values.FormationData; until the team
 * formation GUI (Phase 6) provides per-ship slots, ships take an index
 * derived from their entity id within the owner's formation.
 */
public class FormationHelper
{


    /**
     * formation guarding position around guarded entity.
     * host: ship with FormatType > 0; guarded: entity being guarded;
     * oldX/oldZ: previous anchor pos for stability.
     */
    public static double[] getFormationGuardingPos(IShipAttackBase host, Entity guarded,
            double oldX, double oldZ)
    {
        int formatType = host.getStateMinor(ID.M.FormatType);
        int slot = Math.floorMod(((Entity) host).getId(), 6);

        //formation slot tables: legacy packs x/z offsets per type+slot;
        //simple ring fallback preserves spacing behavior
        double angle = Math.PI * 2D * slot / 6D;
        double radius = 4D;

        if (formatType == 1)
        {
            //wedge: ships behind the guarded entity
            angle = Math.PI + (slot - 2.5D) * 0.5D;
            radius = 4D + (slot % 3) * 2D;
        }
        else if (formatType == 2)
        {
            //line abreast
            angle = Math.PI / 2D * (slot % 2 == 0 ? 1 : -1);
            radius = 3D + (slot / 2) * 2D;
        }

        return new double[] {
            guarded.getX() + Math.cos(angle) * radius,
            guarded.getY(),
            guarded.getZ() + Math.sin(angle) * radius};
    }

    /** formation movement speed modifier (slowest member speed) */
    public static float getFormationMOV(IShipAttackBase host)
    {
        float mov = host.getAttrs().getAttrsBuffed(ID.Attrs.MOV);
        return Math.max(0.05F, mov * 0.9F);
    }


}

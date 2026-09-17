package com.lulan.shincolle.utility;

import javax.annotation.Nullable;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import com.lulan.shincolle.network.ModNetwork;
import com.lulan.shincolle.reference.Enums.ParType;
import com.lulan.shincolle.reference.dataclass.Dist4d;
import com.lulan.shincolle.reference.dataclass.ParticleData;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

/**
 * particle spawn helper (legacy ParticleHelper subset).
 *
 * Custom ShinColle particles (emotions, attack text, beams) are client-side
 * renders driven by the S2C particle payload - that payload lands in Phase 5,
 * so the type-specific spawns currently degrade to vanilla particles.
 */
public class ParticleHelper
{


    /**
     * attack text popup (miss/cri/dhit/thit/dodge), type 0..4.
     * Custom text particles are Phase 5 client payload work; emits a
     * vanilla marker so the feedback is still visible.
     */
    public static void spawnAttackTextParticle(Entity host, int type)
    {
        if (!(host.level() instanceof ServerLevel sl)) return;

        ParType pt = switch (type)
        {
            case 1 -> ParType.TEXT_CRI;       //critical
            case 2 -> ParType.TEXT_DOUBLEHIT; //double hit
            case 3 -> ParType.TEXT_TRIPLEHIT; //triple hit
            case 4 -> ParType.TEXT_DODGE;     //dodge
            default -> ParType.TEXT_MISS;     //miss
        };

        ParticleData data = new ParticleData(pt);
        data.setFloatData((float) host.getX());
        data.setFloatData((float) host.getY());
        data.setFloatData((float) host.getZ());
        data.setFloatData(host.getBbHeight() * 1.1F);
        ModNetwork.sendParticleData(host, data);
    }

    /**
     * generic attack particle burst at position.
     * par1: host, pos xyz, scale, type (legacy particle type id).
     */
    public static void spawnAttackParticle(Entity host, double x, double y, double z,
            double scale, int type)
    {
        if (!(host.level() instanceof ServerLevel sl)) return;

        //custom particle types handled by the ParticleData payload path
        ParticleData data = null;

        switch (type)
        {
        case 1:  //light cannon: muzzle smoke at attacker
        {
            data = new ParticleData(ParType.SMOKE_L);
            data.setFloatData((float) x);            //posX
            data.setFloatData((float) y);            //posY
            data.setFloatData((float) z);            //posZ
            data.setFloatData((float) (scale));      //width
            data.setFloatData((float) (scale));      //depth
        }
        break;
        case 2:  //heavy / melee impact: explosion at target
        {
            data = new ParticleData(ParType.EXPLOSION_LARGE);
            data.setFloatData((float) x);
            data.setFloatData((float) y);
            data.setFloatData((float) z);
        }
        break;
        case 3:  //aircraft fire: explosion + lava bits
        {
            data = new ParticleData(ParType.EXPLOSION_LARGE_LAVA);
            data.setFloatData((float) x);
            data.setFloatData((float) y);
            data.setFloatData((float) z);
        }
        break;
        default:
        break;
        }

        if (data != null)
        {
            ModNetwork.sendParticleData(sl, x, y, z, data);
            return;
        }

        ParticleOptions p = switch (type)
        {
            case 4 -> ParticleTypes.SOUL_FIRE_FLAME;
            case 5 -> ParticleTypes.PORTAL;
            case 25 -> ParticleTypes.HAPPY_VILLAGER; //waypoint marker
            default -> ParticleTypes.POOF;
        };

        int count = Math.max(1, (int) (scale * 4D));
        sl.sendParticles(p, x, y, z, count, 0.1D * scale, 0.1D * scale, 0.1D * scale, 0.02D);
    }

    /**
     * emotion icon over an entity (legacy S2CSpawnParticle type 36:
     * EMOTION_ENTITY ParticleData with floats={x,y,z,height},
     * ints={entityId, hostType, emotes}, bools={isMorph}).
     */
    public static void spawnEmotionParticle(Entity host, float height,
            int emotes)
    {
        if (!(host.level() instanceof ServerLevel sl)) return;

        ParticleData data = new ParticleData(ParType.EMOTION_ENTITY);
        data.setBooleanData(false);
        data.setFloatData((float) host.getX());
        data.setFloatData((float) host.getY());
        data.setFloatData((float) host.getZ());
        data.setFloatData(height);
        data.setIntData(host.getId());
        data.setIntData(0);        //host type
        data.setIntData(emotes);   //emotion type

        ModNetwork.sendParticleData(sl, host.getX(), host.getY(),
            host.getZ(), data);
    }

    /**
     * rising bubbles at a position (legacy spawnAttackParticleAt type 37:
     * volcano core bubbles).
     */
    public static void spawnBubbleAt(ServerLevel level, double x, double y,
            double z, double mx, double my, double mz)
    {
        level.sendParticles(ParticleTypes.BUBBLE_COLUMN_UP, x, y, z, 1,
            mx, my, mz, 0.02D);
    }

    /** particle burst on entity (muzzle flash equivalent) */
    public static void spawnAttackParticleAtEntity(Entity target, double scale,
            double ox, double oy, int type)
    {
        spawnAttackParticle(target, target.getX() + ox, target.getY() + oy,
            target.getZ(), scale, type);
    }

    /** particle trail from host to target (cannon fire) */
    public static void spawnAttackParticleAtEntity(Entity host, Entity target,
            double scale, double oy, double unused, int type, boolean alongPath)
    {
        if (!(host.level() instanceof ServerLevel sl)) return;

        Vec3 from = new Vec3(host.getX(), host.getY() + host.getBbHeight() * 0.5D, host.getZ());
        Vec3 to = new Vec3(target.getX(), target.getY() + target.getBbHeight() * 0.5D, target.getZ());
        int steps = 6;

        for (int i = 0; i <= steps; i++)
        {
            Vec3 p = from.lerp(to, (double) i / steps);
            sl.sendParticles(ParticleTypes.CRIT, p.x, p.y, p.z, 1, 0D, 0D, 0D, 0D);
        }
    }

    /** waypoint/formation marker for the owning player */
    public static void spawnWaypointMarker(ServerLevel level, double x, double y, double z)
    {
        level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y + 0.5D, z, 4, 0.3D, 0.5D, 0.3D, 0D);
    }



    public static ParticleData getParticleData(ParType type, boolean atHost, Entity host, Entity target, Dist4d distance, boolean[] parb, int[] pari, float[] parf, String[] pars)
    {
        ParticleData pdata = new ParticleData(type);
        Vec3 posHost = host != null ? host.position() : Vec3.ZERO;
        Vec3 posTarget = target != null ? target.position() : Vec3.ZERO;
        
        try
        {
            
        switch (type)
        {
        case ARROW_BLOCK:
        {
            //add float
            pdata.setFloatData(parf[0]);      //posX
            pdata.setFloatData(parf[1]);      //posY
            pdata.setFloatData(parf[2]);      //posZ
            pdata.setFloatData(parf[3]);      //scale TODO
            //add int
            pdata.setIntData(pari[0]);  //arrow type
        }
        break;
        case ARROW_ENTITY:
        case TYPE91APFIST_CHI:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(1F);               //scale TODO
            //add int
            pdata.setIntData(ent.getId());  //host entity id
            pdata.setIntData(pari[0]);            //type
        }
        break;
        case BEAM_IN:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(ent.getBbHeight() * 1.2F);   //scale TODO
            pdata.setFloatData(ent.getBbHeight() * 0.75F);  //radius
            pdata.setFloatData(0.8F);                //beam speed
            pdata.setFloatData(0.03F);               //beam thick
            pdata.setFloatData(parf[0]);             //R
            pdata.setFloatData(parf[1]);             //G
            pdata.setFloatData(parf[2]);             //B
            pdata.setFloatData(parf[3]);             //A
            pdata.setFloatData(ent.getBbHeight() * 0.4F);   //height
            //add int
            pdata.setIntData(ent.getId());  //host entity id
        }
        break;
        case BEAM_IN_SIMPLE:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(parf[0]);  //life TODO
            pdata.setFloatData(parf[1]);  //scale TODO
            //add int
            pdata.setIntData(ent.getId());  //host entity id
        }
        break;
        case BEAM_OUT:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(ent.getBbHeight() * 1.2F);  //scale TODO
            pdata.setFloatData(0.85F);    //fade speed
            pdata.setFloatData(0.08F);    //beam speed
            pdata.setFloatData(8F);       //space
            pdata.setFloatData(parf[0]);  //R
            pdata.setFloatData(parf[1]);  //G
            pdata.setFloatData(parf[2]);  //B
            pdata.setFloatData(parf[3]);  //A
            pdata.setFloatData(0.7F);     //height
            //add int
            pdata.setIntData(ent.getId());  //host entity id
        }
        break;
        case CUBE_VIBRATE:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(parf[0]);  //scale TODO
            //add int
            pdata.setIntData(ent.getId());  //host entity id
        }
        break;
        case BUBBLE:
        case EXPLOSION_LARGE:
        case EXPLOSION_HUGE_LAVA:
        case EXPLOSION_LARGE_LAVA:
        case FLAME:
        case HEARTS:
        {
            if (atHost)
            {
                //add float
                pdata.setFloatData((float) posHost.x);  //posX
                pdata.setFloatData((float) posHost.y);  //posY
                pdata.setFloatData((float) posHost.z);  //posZ
            }
            else
            {
                //add float
                pdata.setFloatData((float) target.getX());  //posX
                pdata.setFloatData((float) target.getY());  //posY
                pdata.setFloatData((float) target.getZ());  //posZ
            }
        }
        break;
        case TEXT_MISS:
        case TEXT_CRI:
        case TEXT_DOUBLEHIT:
        case TEXT_TRIPLEHIT:
        case TEXT_DODGE:
        {
            //add float
            pdata.setFloatData((float) posHost.x);   //posX
            pdata.setFloatData((float) posHost.y);   //posY
            pdata.setFloatData((float) posHost.z);   //posZ
            pdata.setFloatData(parf[0]);             //offsetY
        }
        break;
        /** f0:posX, f1:posY, f2:posZ, f3:width range, f4:motionY */
        case SMOKE_S:
        case SMOKE_M:
        case SMOKE_XL:
        /** f0:posX, f1:posY, f2:posZ, f3:motionY, f4:scale */
        case SMOKE_CHIMNEY_CUSTOM:
        /**f0:posX, f1:posY, f2:posZ, f3:aura width, f4:offsetY */
        case TYPE91APFIST_SHOCKWAVE_IN:
        case TYPE91APFIST_SHOCKWAVE_OUT:
        {
            //add float
            pdata.setFloatData((float) posHost.x);  //posX
            pdata.setFloatData((float) posHost.y);  //posY
            pdata.setFloatData((float) posHost.z);  //posZ
            pdata.setFloatData(parf[0]);            //f3
            pdata.setFloatData(parf[1]);            //f4
        }
        break;
        case SMOKE_L:
        case SNOWHIT:
        case SNOWSPRAY:
        {
            //add float
            pdata.setFloatData((float) posHost.x);   //posX
            pdata.setFloatData((float) posHost.y);   //posY
            pdata.setFloatData((float) posHost.z);   //posZ
            pdata.setFloatData((float) distance.x);  //vecX
            pdata.setFloatData((float) distance.z);  //vecZ
        }
        break;
        case CRANING:
        {
            //add float
            pdata.setFloatData((float) posHost.x);  //posX
            pdata.setFloatData((float) posHost.y);  //posY
            pdata.setFloatData((float) posHost.z);  //posZ
            pdata.setFloatData(parf[0]);            //max length
            pdata.setFloatData(parf[1]);            //scale
            //add int
            pdata.setIntData(pari[0]);        //type
        }
        break;
        /** f0:posX, f1:posY, f2:posZ, f3:motionX, f4:motionY, f5:motionZ */
        case DRIPWATER:
        case DRIPLAVA:
        case HIGHSPEED_THICKYELLOW:
        case HIGHSPEED_THICKPINK:
        case HIGHSPEED_AURABLUR:
        case SMOKE_CHIMNEY_S:
        case SMOKE_CHIMNEY_L:
        case SPRAY_WHITE:
        case SPRAY_WHITE_TRANSPARENT:
        case SPRAY_CYAN:
        case SPRAY_CYAN_LIGHT:
        case SPRAY_CYAN_LIGHT_TRANSPARENT:
        case SPRAY_CYAN_TRANSPARENT:
        case SPRAY_GREEN:
        case SPRAY_RED:
        case SPRAY_RED_TRANSPARENT:
        case SPRAY_YELLOW:
        case SPRAY_ORANGE:
        case SPRAY_NEXT_WAYPOINT:
        case SPRAY_PAIRED_CHEST:
        case SPRAY_TRIPLE:
        /** f0:posX, f1:posY, f2:posZ, f3:offsetX, f4:offsetZ, f5:width between 2 smoke */
        case SMOKE_DOUBLE_S:
        case SMOKE_DOUBLE_L:
        {
            //add float
            pdata.setFloatData((float) posHost.x);  //posX
            pdata.setFloatData((float) posHost.y);  //posY
            pdata.setFloatData((float) posHost.z);  //posZ
            pdata.setFloatData(parf[0]);            //motionX
            pdata.setFloatData(parf[1]);            //motionY
            pdata.setFloatData(parf[2]);            //motionZ
        }
        break;
        case DEBUG_PLANE:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(parf[0]);  //param 0
            pdata.setFloatData(parf[1]);  //param 1
            pdata.setFloatData(parf[2]);  //param 2
            //add int
            pdata.setIntData(ent.getId());  //host entity id
            pdata.setIntData(pari[0]);
        }
        break;
        case EYE_FIRE:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(parf[0]);  //height
            pdata.setFloatData(parf[1]);  //eyeX
            pdata.setFloatData(parf[2]);  //eyeZ
            pdata.setFloatData(parf[3]);  //R
            pdata.setFloatData(parf[4]);  //G
            pdata.setFloatData(parf[5]);  //B
            pdata.setFloatData(parf[6]);  //A
            //add int
            pdata.setIntData(ent.getId());  //host entity id
        }
        break;
        case EMOTION_BLOCK:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(parf[0]);  //posX
            pdata.setFloatData(parf[1]);  //posY
            pdata.setFloatData(parf[2]);  //posZ
            pdata.setFloatData(parf[3]);  //height
            //add int
            pdata.setIntData(pari[0]);  //host type
            pdata.setIntData(pari[1]);  //emotion type
        }
        break;
        case EMOTION_ENTITY:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(parf[0]);  //posX
            pdata.setFloatData(parf[1]);  //posY
            pdata.setFloatData(parf[2]);  //posZ
            pdata.setFloatData(parf[3]);  //height
            //add int
            pdata.setIntData(ent.getId());  //host entity ID
            pdata.setIntData(pari[0]);      //host type
            pdata.setIntData(pari[1]);      //emotion type
        }
        break;
        case GRADIENT_DOUBLE_OUT:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(ent.getBbHeight());  //scale
            pdata.setFloatData(parf[0]);     //R
            pdata.setFloatData(parf[1]);     //G
            pdata.setFloatData(parf[2]);     //B
            pdata.setFloatData(parf[3]);     //A
            //add int
            pdata.setIntData(ent.getId());  //host entity ID
        }
        break;
        case LASER_RE:
        {
            //add float
            pdata.setFloatData((float) posHost.x);    //posX
            pdata.setFloatData((float) posHost.y);    //posY
            pdata.setFloatData((float) posHost.z);    //posZ
            pdata.setFloatData((float) posTarget.x);  //tarX
            pdata.setFloatData((float) posTarget.y);  //tarY
            pdata.setFloatData((float) posTarget.z);  //tarZ
        }
        break;
        case LASER_DOUBLE:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(parf[0]);     //width between 2 laser TODO
            pdata.setFloatData(parf[1]);     //offsetY
            pdata.setFloatData(0.05F);     //scale
            //add int
            pdata.setIntData(ent.getId());     //host entity ID
            pdata.setIntData(target.getId());  //target entity ID
        }
        break;
        case LASER_YAMATO:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData((float) distance.x);  //vecX
            pdata.setFloatData((float) distance.y);  //vecY
            pdata.setFloatData((float) distance.z);  //vecZ
            pdata.setFloatData(parf[0]);             //scaleHead
            pdata.setFloatData(parf[1]);             //scaleBeam
            //add int
            pdata.setIntData(ent.getId());     //host entity ID
            pdata.setIntData(target.getId());  //target entity ID
        }
        break;
        case LIGHTNING_ENTITY:
        case LIGHTNING_SPHERE:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(parf[0]);  //scale TODO
            //add int
            pdata.setIntData(ent.getId());  //host entity ID
            pdata.setIntData(pari[0]);      //LIGHTNING_ENTITY:type, LIGHTNING_SPHERE:life
        }
        break;
        case LIGHTNING_STICKY:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(parf[3]);  //scale TODO
            //add int
            pdata.setIntData(ent.getId());  //host entity ID
            pdata.setIntData(pari[0]);      //life
            pdata.setIntData(pari[1]);      //type
            pdata.setIntData(pari[2]);      //amount
        }
        break;
        case LINE_GUARD_BLOCK:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(parf[0]);  //tarX
            pdata.setFloatData(parf[1]);  //tarY
            pdata.setFloatData(parf[2]);  //tarZ
            //add int
            pdata.setIntData(ent.getId());  //host entity ID
        }
        break;
        case LINE_GUARD_ENTITY:
        case LINE_GUARD_SUPPLY:
        case LINE_GUARD_POS:
        {
            Entity ent = host;
            
            //add int
            pdata.setIntData(ent.getId());     //host entity ID
            pdata.setIntData(target.getId());  //target entity ID
        }
        break;
        case LINE_CUSTOM:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(parf[0]);  //offsetY
            pdata.setFloatData(parf[1]);  //scaleOUT
            pdata.setFloatData(parf[2]);  //scaleIN
            //add int
            pdata.setIntData(ent.getId());     //host entity ID
            pdata.setIntData(target.getId());  //target entity ID
        }
        break;
        case SMOKE_DOUBLE_L_CUSTOM:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(parf[0]);  //width between 2 smoke
            pdata.setFloatData(parf[1]);  //offsetZ
            pdata.setFloatData(parf[2]);  //offsetY
            pdata.setFloatData(0.25F);    //smoke speed TODO
            //add int
            pdata.setIntData(ent.getId());     //host entity ID
        }
        break;
        case SMOKE_DOUBLE_L_2JOINTS:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(parf[0]);  //width between 2 smoke
            pdata.setFloatData(parf[1]);  //offsetZ
            pdata.setFloatData(parf[2]);  //offsetY
            pdata.setFloatData(1.5F);    //joint2 offsetZ TODO
            //add int
            pdata.setIntData(ent.getId());     //host entity ID
        }
        break;
        case SPRAY_MISSILE:
        {
            Entity ent = host;
            
            //add float
            for (int i = 1; i < pars.length; i++)
            {
                pdata.setFloatData(parf[i]);      //custom data
            }
            //add int
            pdata.setIntData(ent.getId());  //host entity ID
            pdata.setIntData(pari[0]);      //type
        }
        break;
        case SPARKLE:
        {
            Entity ent = host;
            
            //add float
            switch ((int) parf[0])
            {
            case 0:  //fluid fill
                pdata.setFloatData(0.025F);  //scale
                pdata.setFloatData(ent.getBbWidth() * 1.5F);  //radius
                pdata.setFloatData(parf[0]);  //R
                pdata.setFloatData(parf[1]);  //G
                pdata.setFloatData(parf[2]);  //B
                pdata.setFloatData(parf[3]);  //A
                pdata.setFloatData(ent.getBbHeight() * 0.4F);  //height
            break;
            case 2:  //healing
                pdata.setFloatData(0.075F);  //scale
                pdata.setFloatData(ent.getBbWidth() * 1.5F);  //radius
                pdata.setFloatData(parf[0]);  //R
                pdata.setFloatData(parf[1]);  //G
                pdata.setFloatData(parf[2]);  //B
                pdata.setFloatData(parf[3]);  //A
                pdata.setFloatData(ent.getBbHeight() * 1F);  //height
            break;
            case 3:  //craning
                pdata.setFloatData(0.05F);  //scale
                pdata.setFloatData(ent.getBbWidth() * 1F);  //radius
                pdata.setFloatData(parf[0]);  //R
                pdata.setFloatData(parf[1]);  //G
                pdata.setFloatData(parf[2]);  //B
                pdata.setFloatData(parf[3]);  //A
                pdata.setFloatData(ent.getBbHeight() * 1F);  //height
            break;
            case 8:  //goddess
                pdata.setFloatData(0.1F);  //scale
                pdata.setFloatData(ent.getBbWidth() * 2F);  //radius
                pdata.setFloatData(parf[0]);  //R
                pdata.setFloatData(parf[1]);  //G
                pdata.setFloatData(parf[2]);  //B
                pdata.setFloatData(parf[3]);  //A
                pdata.setFloatData(ent.getBbHeight() * 0.4F);  //height
            break;
            default: return null;
            }
            
            //add int
            pdata.setIntData(ent.getId());  //host entity ID
            pdata.setIntData(pari[0]);      //type
        }
        break;
        case SWEEP_VERTICAL:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(ent.getBbHeight());         //scale1
            pdata.setFloatData(ent.getBbHeight() * 5.6F);  //scale2
            pdata.setFloatData(ent.getBbHeight() * 2F);    //scale3
            pdata.setFloatData(0.95F);              //fade
            pdata.setFloatData(4F);                 //life
            pdata.setFloatData(parf[0]);            //R
            pdata.setFloatData(parf[1]);            //G
            pdata.setFloatData(parf[2]);            //B
            pdata.setFloatData(parf[3]);            //A
            //add int
            pdata.setIntData(ent.getId());  //host entity ID
        }
        break;
        case SWEEP_HORIZONTAL:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(ent.getBbHeight() * 0.1F);  //scale1
            pdata.setFloatData(ent.getBbHeight() * 5.6F);  //scale2
            pdata.setFloatData(ent.getBbHeight() * 6F);    //scale3
            pdata.setFloatData(0.95F);              //fade
            pdata.setFloatData(4F);                 //life
            pdata.setFloatData(parf[0]);            //R
            pdata.setFloatData(parf[1]);            //G
            pdata.setFloatData(parf[2]);            //B
            pdata.setFloatData(parf[3]);            //A
            //add int
            pdata.setIntData(ent.getId());  //host entity ID
        }
        break;
        case TEXT_BLOCK:
        case TEXT_ENTITY:
        {
            Entity ent = host;
            
            //add float
            pdata.setFloatData(parf[0]);  //posX
            pdata.setFloatData(parf[1]);  //posY
            pdata.setFloatData(parf[2]);  //posZ
            pdata.setFloatData(parf[3]);  //scale
            //add int
            if (type == ParType.TEXT_BLOCK)
            {
                pdata.setIntData(-1);  //NO_USE
            }
            else
            {
                pdata.setIntData(ent.getId());  //host entity ID
            }
            
            pdata.setIntData(pari[0]);  //type
            pdata.setIntData(pari[0]);  //textH
            pdata.setIntData(pari[0]);  //textW
        }
        break;
        case TYPE91APFIST_ATTACK:
        {
            //add float
            pdata.setFloatData((float) posHost.x);      //posX
            pdata.setFloatData((float) posHost.y);      //posY
            pdata.setFloatData((float) posHost.z);      //posZ
            pdata.setFloatData((float) posTarget.x);    //tarX
            pdata.setFloatData((float) posTarget.y);    //tarY
            pdata.setFloatData((float) posTarget.z);    //tarZ
            pdata.setFloatData(target.getBbHeight() * 1.15F);  //text offsetY
        }
        break;
        default:
            pdata = null;
        break;
        }
        
        }
        catch (Exception e)
        {
            LogHelper.info("EXCEPTION: server get particle data fail: "+e);
            e.printStackTrace();
            return null;
        }
        
        return pdata;
    }


}

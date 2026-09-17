package com.lulan.shincolle.registry;

import java.util.HashMap;
import java.util.Map;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.Enums.SoundType;
import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * sound event registration hub (Phase 2-6).
 *
 * 53 fixed events + per-ship-class custom voices driven by
 * {@code sounds.cfg} rates ({@link ShinColleConfig#configSound}).
 */
public final class ModSounds
{

    public static final DeferredRegister<SoundEvent> SOUNDS =
        DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Reference.MOD_ID);

    /** fixed events */
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_IDLE = reg("ship-idle");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_HURT = reg("ship-hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_DEATH = reg("ship-death");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_FIRELIGHT = reg("ship-firelight");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_EXPLODE = reg("ship-explode");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_FIREHEAVY = reg("ship-fireheavy");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_HIT = reg("ship-hit");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_AIRCRAFT = reg("ship-aircraft");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_MACHINEGUN = reg("ship-machinegun");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_LASER = reg("ship-laser");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_MARRY = reg("ship-marry");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_KAITAI = reg("ship-kaitai");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_AP_P1 = reg("ship-ap_phase1");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_AP_P2 = reg("ship-ap_phase2");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_AP_ATTACK = reg("ship-ap_attack");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_WAKA_ATTACK = reg("ship-waka_attack");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_WAKA_HURT = reg("ship-waka_hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_WAKA_IDLE = reg("ship-waka_idle");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_WAKA_DEATH = reg("ship-waka_death");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_GARURU = reg("ship-garuru");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_YAMATO_READY = reg("ship-yamato_ready");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_YAMATO_SHOT = reg("ship-yamato_shot");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_KNOCKBACK = reg("ship-knockback");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_ITEM = reg("ship-item");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_LEVEL = reg("ship-levelup");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_FEED = reg("ship-feed");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_BELL = reg("ship-bell");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_JET = reg("ship-jet");
    public static final DeferredHolder<SoundEvent, SoundEvent> SHIP_HITMETAL = reg("ship-hitmetal");

    /** time keeper hourly chime */
    public static final DeferredHolder<SoundEvent, SoundEvent>[] SHIP_TIME = regTimes();

    /** custom ship voices (key: shipClassID * 100 + soundType.ordinal()) */
    private static final Map<Integer, SoundEvent> CUSTOM_SOUND = new HashMap<>();


    private static DeferredHolder<SoundEvent, SoundEvent> reg(String name)
    {
        return SOUNDS.register(name, () ->
            SoundEvent.createVariableRangeEvent(
                ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name)));
    }

    @SuppressWarnings("unchecked")
    private static DeferredHolder<SoundEvent, SoundEvent>[] regTimes()
    {
        DeferredHolder<SoundEvent, SoundEvent>[] arr = new DeferredHolder[24];
        for (int i = 0; i < 24; i++)
        {
            arr[i] = reg("ship-time" + i);
        }
        return arr;
    }

    /** custom voice lookup: ship-<type>-<shipID>; returns null if rate is 0 */
    public static SoundEvent getCustomSound(int shipID, SoundType type)
    {
        return CUSTOM_SOUND.get(shipID * 100 + type.ordinal());
    }

    /** called from common setup after custom configs are loaded */
    public static void initCustomSounds()
    {
        CUSTOM_SOUND.clear();

        if (ShinColleConfig.configSound == null || ShinColleConfig.configSound.SOUNDRATE == null)
        {
            return;
        }

        ShinColleConfig.configSound.SOUNDRATE.forEach((shipID, rateMap) ->
        {
            if (rateMap == null) return;
            rateMap.forEach((soundType, rate) ->
            {
                if (rate > 0F)
                {
                    String name = "ship-" + typeName(soundType) + "-" + shipID;
                    CUSTOM_SOUND.put(shipID * 100 + soundType.ordinal(),
                        SoundEvent.createVariableRangeEvent(
                            ResourceLocation.fromNamespaceAndPath(Reference.MOD_ID, name)));
                }
            });
        });
    }

    private static String typeName(SoundType type)
    {
        return switch (type)
        {
            case IDLE -> "idle";
            case HIT -> "hit";
            case HURT -> "hurt";
            case DEAD -> "death";
            case MARRY -> "marry";
            case KNOCKBACK -> "knockback";
            case PICKITEM -> "item";
            case FEED -> "feed";
            default ->
            {
                //TIMEKEEP00..23 -> time0..23
                String n = type.name();
                if (n.startsWith("TIMEKEEP")) yield "time" + n.substring(8).replaceFirst("^0", "");
                yield n.toLowerCase();
            }
        };
    }


    private ModSounds() {}

}

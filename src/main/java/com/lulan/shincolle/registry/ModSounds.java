package com.lulan.shincolle.registry;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * sound event registration hub.
 * (entries are added in Phase 2; custom per-ship rates are resolved
 *  dynamically at playback via ConfigSound.SOUNDRATE)
 */
public final class ModSounds
{

    public static final DeferredRegister<SoundEvent> SOUNDS =
        DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Reference.MOD_ID);


    private ModSounds() {}

}

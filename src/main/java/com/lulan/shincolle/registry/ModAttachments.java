package com.lulan.shincolle.registry;

import com.lulan.shincolle.reference.Reference;

import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/**
 * data attachment registration hub.
 * (teitoku/player data etc. are added in Phase 3)
 */
public final class ModAttachments
{

    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS =
        DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, Reference.MOD_ID);


    private ModAttachments() {}

}

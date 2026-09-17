package com.lulan.shincolle.registry;

import com.lulan.shincolle.reference.Reference;

import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
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

    /**
     * teitoku (player) persistent data: pointer team id, ring state,
     * marriage count etc. (legacy CapaTeitoku subset)
     */
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<CompoundTag>> TEITOKU =
        ATTACHMENTS.register("teitoku", () -> AttachmentType
            .builder(() -> new CompoundTag())
            .serialize(CompoundTag.CODEC)
            .copyOnDeath()
            .build());


    private ModAttachments() {}

}

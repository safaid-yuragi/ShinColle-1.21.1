package com.lulan.shincolle.registry;

import com.lulan.shincolle.reference.Reference;

import com.lulan.shincolle.item.MorphEquipHandler;

import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.attachment.IAttachmentSerializer;
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

    /**
     * morph-equipment inventory (legacy CapaTeitoku equip slots): 6 BasicEquip
     * slots held while the player is morphed into a ship.
     */
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<MorphEquipHandler>> MORPH_EQUIP =
        ATTACHMENTS.register("morph_equip", () -> AttachmentType
            .builder(() -> new MorphEquipHandler())
            .serialize(new IAttachmentSerializer<CompoundTag, MorphEquipHandler>()
            {
                @Override
                public CompoundTag write(MorphEquipHandler att,
                        net.minecraft.core.HolderLookup.Provider provider)
                {
                    return att.serializeNBT(provider);
                }

                @Override
                public MorphEquipHandler read(net.neoforged.neoforge.attachment.IAttachmentHolder holder,
                        CompoundTag tag, net.minecraft.core.HolderLookup.Provider provider)
                {
                    MorphEquipHandler h = new MorphEquipHandler();
                    h.deserializeNBT(provider, tag);
                    return h;
                }
            })
            .copyOnDeath()
            .build());


    private ModAttachments() {}

}

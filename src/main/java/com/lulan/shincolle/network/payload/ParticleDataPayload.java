package com.lulan.shincolle.network.payload;

import java.util.ArrayList;

import com.lulan.shincolle.reference.Enums.ParType;
import com.lulan.shincolle.reference.dataclass.ParticleData;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import static com.lulan.shincolle.reference.Reference.MOD_ID;

/**
 * S2C: legacy ParticleData packet (S2CSpawnParticle equivalent).
 * Carries ParType ordinal + int/float/string/boolean parameter lists.
 */
public record ParticleDataPayload(int parType, ArrayList<Integer> intData,
        ArrayList<Float> floatData, ArrayList<String> stringData,
        ArrayList<Boolean> booleanData) implements CustomPacketPayload
{

    public static final Type<ParticleDataPayload> TYPE =
        new Type<>(ResourceLocation.fromNamespaceAndPath(MOD_ID, "particle_data"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ParticleDataPayload> STREAM_CODEC =
        StreamCodec.of(ParticleDataPayload::encode, ParticleDataPayload::decode);


    public ParticleDataPayload(ParticleData data)
    {
        this(data.getType().ordinal(),
             data.getIntData(), data.getFloatData(),
             data.getStringData(), data.getBooleanData());
    }

    /** rebuild the ParticleData on the receiving side */
    public ParticleData toData()
    {
        ParticleData data = new ParticleData(ParType.values()[this.parType]);
        data.setIntData(this.intData);
        data.setFloatData(this.floatData);
        data.setStringData(this.stringData);
        data.setBooleanData(this.booleanData);
        return data;
    }

    private static void encode(RegistryFriendlyByteBuf buf, ParticleDataPayload p)
    {
        buf.writeInt(p.parType);
        writeInts(buf, p.intData);
        writeFloats(buf, p.floatData);
        writeStrings(buf, p.stringData);
        writeBooleans(buf, p.booleanData);
    }

    private static ParticleDataPayload decode(RegistryFriendlyByteBuf buf)
    {
        return new ParticleDataPayload(buf.readInt(),
            readInts(buf), readFloats(buf), readStrings(buf), readBooleans(buf));
    }

    private static void writeInts(RegistryFriendlyByteBuf buf, ArrayList<Integer> list)
    {
        buf.writeInt(list == null ? 0 : list.size());
        if (list != null) for (int v : list) buf.writeInt(v);
    }

    private static ArrayList<Integer> readInts(RegistryFriendlyByteBuf buf)
    {
        int n = buf.readInt();
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) list.add(buf.readInt());
        return list;
    }

    private static void writeFloats(RegistryFriendlyByteBuf buf, ArrayList<Float> list)
    {
        buf.writeInt(list == null ? 0 : list.size());
        if (list != null) for (float v : list) buf.writeFloat(v);
    }

    private static ArrayList<Float> readFloats(RegistryFriendlyByteBuf buf)
    {
        int n = buf.readInt();
        ArrayList<Float> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) list.add(buf.readFloat());
        return list;
    }

    private static void writeStrings(RegistryFriendlyByteBuf buf, ArrayList<String> list)
    {
        buf.writeInt(list == null ? 0 : list.size());
        if (list != null) for (String v : list) buf.writeUtf(v);
    }

    private static ArrayList<String> readStrings(RegistryFriendlyByteBuf buf)
    {
        int n = buf.readInt();
        ArrayList<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) list.add(buf.readUtf());
        return list;
    }

    private static void writeBooleans(RegistryFriendlyByteBuf buf, ArrayList<Boolean> list)
    {
        buf.writeInt(list == null ? 0 : list.size());
        if (list != null) for (boolean v : list) buf.writeBoolean(v);
    }

    private static ArrayList<Boolean> readBooleans(RegistryFriendlyByteBuf buf)
    {
        int n = buf.readInt();
        ArrayList<Boolean> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) list.add(buf.readBoolean());
        return list;
    }

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }


}

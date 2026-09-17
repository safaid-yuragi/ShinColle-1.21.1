package com.lulan.shincolle.reference;

import net.minecraft.resources.ResourceLocation;

/** static string and path */
public class Reference
{

    //path, modid
    public static final String MOD_ID = "shincolle";
    public static final String MOD_NAME = "Shinkeiseikan Collection";
    public static final String MOD_VERSION = "1.21.1-1.0";

    //texture paths (assets/shincolle/textures/...)
    public static final String TEXTURES_BLOCK = "textures/block/";
    public static final String TEXTURES_ENTITY = "textures/entity/";
    public static final String TEXTURES_GUI = "textures/gui/";
    public static final String TEXTURES_ITEM = "textures/item/";
    public static final String TEXTURES_PARTICLE = "textures/particle/";

    /** ResourceLocation of this mod: shincolle:path */
    public static ResourceLocation modLoc(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }


}

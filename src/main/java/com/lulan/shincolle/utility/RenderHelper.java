package com.lulan.shincolle.utility;

import org.joml.Quaternionf;
import org.joml.Vector3f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.util.Mth;

/**
 * render helpers for model code converted from fixed-function GL calls.
 */
public class RenderHelper
{


    /** legacy GlStateManager.rotate(deg, x, y, z) */
    public static void rotate(PoseStack poseStack, float deg, float x, float y, float z)
    {
        Vector3f axis = new Vector3f(x, y, z);
        if (axis.lengthSquared() > 0F)
        {
            axis.normalize();
            poseStack.mulPose(new Quaternionf().rotateAxis(deg * Mth.DEG_TO_RAD, axis));
        }
    }

    /**
     * accumulate an animation rotation on the model; applied by renderToBuffer
     * where legacy code called GlStateManager.rotate inside pose methods.
     */
    public static void animRotate(com.lulan.shincolle.client.model.ShipModel<?> model, float deg, float x, float y, float z)
    {
        Vector3f axis = new Vector3f(x, y, z);
        if (axis.lengthSquared() > 0F)
        {
            axis.normalize();
            model.animRot.mul(new Quaternionf().rotateAxis(deg * Mth.DEG_TO_RAD, axis));
        }
    }

    /**
     * accumulate an animation scale on the model; applied by renderToBuffer
     * where legacy code called GlStateManager.scale inside pose methods.
     */
    public static void animScale(com.lulan.shincolle.client.model.ShipModel<?> model, float x, float y, float z)
    {
        model.animScaleX *= x;
        model.animScaleY *= y;
        model.animScaleZ *= z;
    }

    /** legacy drawTexturedModalRect for screens: blit at z=0 */
    // GUI helpers are implemented alongside the screens


}

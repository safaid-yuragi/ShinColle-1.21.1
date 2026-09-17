package com.lulan.shincolle.reference;

/**
 * static value table
 *
 * NOTE (port to 1.21.1): most data tables of the 1.12.2 version reference
 * ModBlocks / ModItems / ItemStack and are moved in Phase 2. This class
 * currently holds only the pure-math constants.
 */
public class Values
{

    /** math constants */
    public static final class N
    {
        public static final float DIV_180_PI = 57.295779513F;  // 180 / PI
        public static final float DIV_PI_180 = 0.0174532925F;  // PI / 180

        public static final int[] Pow2 = new int[] {1, 2, 4, 8, 16,  //2^0~24
                32, 64, 128, 256, 512,
                1024, 2048, 4096, 8192, 16384,
                32768, 65536, 131072, 262144, 524288,
                1048576, 2097152, 4194304, 8388608, 16777216};
    }


}

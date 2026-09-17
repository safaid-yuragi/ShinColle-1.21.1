package com.lulan.shincolle.utility;

import java.util.ArrayList;
import java.util.List;

import com.lulan.shincolle.blockentity.BasicMultiBlockEntity;
import com.lulan.shincolle.registry.ModBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/** multi-block structure checker (legacy MulitBlockHelper) */
public class MultiBlockHelper
{

    /**pattern array [type][x][y][z]
     * type:  0:large shipyard  1:large workshop
     * value: -1:other  0:water,air  1:polymetal  2:grudge
     *
     * TYPE 0001 - Large Shipyard:  o:polymetal block  g:heavy grudge block
     *      1.ooo   2.o o   4.
     *        ooo               g
     *        ooo     o o
     */
    private static final byte[][][][] PATTERN =
    {
        //type 0001:
        {      //y = 0       y = 1       y = 2
            {  { 1, 1, 1}, { 1,-1, 1}, {-1,-1,-1}  },   //x = 0
            {  { 1, 1, 1}, {-1,-1,-1}, {-1, 2,-1}  },   //x = 1
            {  { 1, 1, 1}, { 1,-1, 1}, {-1,-1,-1}  }    //x = 2
        }
    };


    private MultiBlockHelper() {}

    /** CHECK MULTI BLOCK FORM
     * called when RIGHT CLICK heavy grudge block
     * (heavy grudge block is always at TOP-MIDDLE, so check X+-1 Y-2 Z+-1)
     */
    public static int checkMultiBlockForm(Level level, int xCoord, int yCoord, int zCoord)
    {
        BlockState state;
        BlockPos pos;
        Block block;
        int blockType;
        /** bitwise pattern match
         *  ex: type = 3 (int) = 0011 (bit) = match pattern 0,1
         *      type = 2 (int) = 0010 (bit) = match pattern 1
         *      type = 13(int) = 1101 (bit) = match pattern 0,2,3
         */
        int patternTemp;
        int patternMatch = 1;  //init match pattern = 0001 (bit)

        //no check under y = 3
        if (yCoord < 3) return -1;

        //scan a 3x3x3 area
        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                for (int z = 0; z < 3; z++)
                {
                    pos = new BlockPos(xCoord - 1 + x, yCoord - 2 + y, zCoord - 1 + z);

                    //1. get block
                    state = level.getBlockState(pos);
                    block = state.getBlock();

                    blockType = -1;
                    if (block == ModBlocks.BLOCK_POLYMETAL.get()) blockType = 1;
                    if (block == ModBlocks.BLOCK_GRUDGE_HEAVY.get()) blockType = 2;

                    //2. match pattern
                    patternTemp = 0;
                    for (int t = 0; t < PATTERN.length; t++)
                    {
                        if (blockType == PATTERN[t][x][y][z])
                        {
                            patternTemp += (int) Math.pow(2, t);    //match pattern t
                        }
                    }
                    patternMatch = (patternMatch & patternTemp);

                    LogHelper.debug("DEBUG: multi block check: pos " + pos +
                        " block " + block + " type " + blockType +
                        " match " + patternMatch);
                    if (patternMatch == 0) return -1;

                    //3. check master block, no-master only
                    if (blockType > 0)
                    {
                        BlockEntity t = level.getBlockEntity(pos);
                        if (t instanceof BasicMultiBlockEntity multi && multi.hasMaster())
                        {
                            return -1;
                        }
                    }

                }//end z for
            }//end y for
        }//end x for

        LogHelper.debug("DEBUG: check structure: type " + patternMatch);
        return patternMatch;
    }

    /** setup multi block struct
     *
     *  input: level, masterX, masterY, masterZ, structure type
     *
     *  type: 0:no MBS, 1:large shipyard, 2:-
     */
    public static void setupStructure(Level level, int xCoord, int yCoord,
            int zCoord, int type)
    {
        List<BasicMultiBlockEntity> tiles = new ArrayList<>();
        BlockPos masterPos = new BlockPos(xCoord, yCoord, zCoord);
        BasicMultiBlockEntity masterTile = null;
        LogHelper.debug("DEBUG: setup structure type: " + type);

        //get all tile and master tile
        for (int x = xCoord - 1; x < xCoord + 2; x++)
        {
            for (int y = yCoord - 2; y < yCoord + 1; y++)
            {
                for (int z = zCoord - 1; z < zCoord + 2; z++)
                {
                    BlockPos pos = new BlockPos(x, y, z);
                    BlockEntity tile = level.getBlockEntity(pos);

                    // Check if block is master or servant
                    boolean mflag = (x == xCoord && y == yCoord && z == zCoord);

                    if (tile instanceof BasicMultiBlockEntity tile2)
                    {
                        tiles.add(tile2);
                        tile2.setIsMaster(mflag);
                        tile2.setHasMaster(true);
                        tile2.setStructType(type);
                        tile2.setMasterCoords(masterPos);
                        tile2.setChanged();

                        if (mflag) masterTile = tile2;
                    }
                }//end z loop
            }//end y loop
        }//end x loop

        //set master value
        for (BasicMultiBlockEntity te : tiles)
        {
            te.setMaster(masterTile);
        }
    }

    //reset(remove) tile multi
    private static void resetTileMulti(BasicMultiBlockEntity parTile)
    {
        parTile.setMasterCoords(BlockPos.ZERO);
        parTile.setMaster(null);
        parTile.setHasMaster(false);
        parTile.setIsMaster(false);
        parTile.setStructType(0);
        parTile.setChanged();
    }

    //Reset tile multi, called from master block if struct broken
    public static void resetStructure(Level level, int xCoord, int yCoord, int zCoord)
    {
        LogHelper.debug("DEBUG: reset struct: client? " + level.isClientSide() +
            " " + xCoord + " " + yCoord + " " + zCoord);

        for (int x = xCoord - 1; x < xCoord + 2; x++)
        {
            for (int y = yCoord - 2; y < yCoord + 1; y++)
            {
                for (int z = zCoord - 1; z < zCoord + 2; z++)
                {
                    BlockEntity tile = level.getBlockEntity(new BlockPos(x, y, z));

                    if (tile instanceof BasicMultiBlockEntity multi)
                    {
                        resetTileMulti(multi);
                    }
                }
            }
        }
    }


}

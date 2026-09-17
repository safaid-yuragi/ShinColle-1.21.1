package com.lulan.shincolle.ai;

import java.util.ArrayList;

import com.lulan.shincolle.entity.IShipNavigator;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.material.MapColor;

/**
 * open door goal (legacy EntityAIShipOpenDoor).
 * Finds wooden doors / fence gates on the path or around the entity,
 * opens them, and optionally closes them after passing.
 */
public class ShipOpenDoorGoal extends Goal
{

    private final Entity host;
    private final IShipNavigator host2;
    private ArrayList<BlockPos> doors = new ArrayList<>();
    private BlockPos pathPoint = BlockPos.ZERO;
    private boolean hasPassed;
    private float vecX;
    private float vecZ;
    private final boolean closeDoor;
    private int delay;
    private final float dist;


    public ShipOpenDoorGoal(IShipNavigator host, boolean closeDoor)
    {
        this.host = (Entity) host;
        this.host2 = host;
        this.closeDoor = closeDoor;
        this.dist = (this.host.getBbWidth() + 1F) * (this.host.getBbWidth() + 1F);
    }

    @Override
    public boolean canUse()
    {
        Path path = this.host2.getShipNavigate().getPath();

        if (!this.host.horizontalCollision)
        {
            return false;
        }
        else if (path != null && !path.isDone())
        {
            this.doors.clear();
            BlockPos pos = null;

            //check the next 2 path nodes for doors
            for (int i = 0; i < Math.min(path.getNextNodeIndex() + 2, path.getNodeCount()); ++i)
            {
                Node node = path.getNode(i);
                pos = new BlockPos(node.x, node.y, node.z);

                if (this.host.distanceToSqr(
                        pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D) <= this.dist)
                {
                    checkDoors(pos, this.host, this.doors);
                    this.pathPoint = pos;
                }
            }

            //check the entity's own position too
            pos = this.host.blockPosition();
            checkDoors(pos, this.host, this.doors);
            this.pathPoint = pos;

            return !this.doors.isEmpty();
        }

        return false;
    }

    @Override
    public boolean canContinueToUse()
    {
        return this.closeDoor && this.delay > 0 && !this.hasPassed;
    }

    @Override
    public void start()
    {
        this.delay = 30;
        this.hasPassed = false;

        this.setDoorOpen(true);

        if (!this.pathPoint.equals(BlockPos.ZERO))
        {
            this.vecX = (float) this.pathPoint.getX() + 0.5F - (float) this.host.getX();
            this.vecZ = (float) this.pathPoint.getZ() + 0.5F - (float) this.host.getZ();
        }
    }

    @Override
    public void stop()
    {
        if (this.closeDoor && !this.doors.isEmpty()) this.setDoorOpen(false);

        this.doors = new ArrayList<>();
    }

    @Override
    public void tick()
    {
        --this.delay;

        if (this.delay <= 0)
        {
            float vx = (float) this.pathPoint.getX() + 0.5F - (float) this.host.getX();
            float vz = (float) this.pathPoint.getZ() + 0.5F - (float) this.host.getZ();
            float v = this.vecX * vx + this.vecZ * vz;

            //dot product < 0 = passed through the door
            if (v < 0F)
            {
                this.hasPassed = true;
            }
        }
    }

    //add door or gate blocks to list
    private static void checkDoors(BlockPos pos, Entity host, ArrayList<BlockPos> list)
    {
        int range = Mth.floor(host.getBbWidth() + 1F);
        int minY = pos.getY();
        int maxY = pos.getY() + Mth.floor(host.getBbHeight() + 1F);

        for (int ix = pos.getX() - range; ix <= pos.getX() + range; ix++)
        {
            for (int iz = pos.getZ() - range; iz <= pos.getZ() + range; iz++)
            {
                for (int iy = minY; iy <= maxY; iy++)
                {
                    BlockPos pos2 = new BlockPos(ix, iy, iz);
                    BlockState state = host.level().getBlockState(pos2);

                    if (state.getBlock() instanceof FenceGateBlock ||
                        (iy != minY && state.getBlock() instanceof DoorBlock door &&
                         door.type().canOpenByHand()))
                    {
                        list.add(pos2);
                    }
                }
            }
        }
    }

    //true = open, false = close
    private void setDoorOpen(boolean open)
    {
        for (BlockPos pos : this.doors)
        {
            BlockState state = this.host.level().getBlockState(pos);

            if (state.getBlock() instanceof DoorBlock door)
            {
                door.setOpen(this.host, this.host.level(), state, pos, open);
            }
            else if (state.getBlock() instanceof FenceGateBlock)
            {
                toggleGate(pos, this.host, state, open);
            }
        }
    }

    private static void toggleGate(BlockPos pos, Entity host, BlockState state, boolean openGate)
    {
        if (!(state.getBlock() instanceof FenceGateBlock)) return;

        if (state.getValue(FenceGateBlock.OPEN))
        {
            if (!openGate)
            {
                host.level().setBlock(pos, state.setValue(FenceGateBlock.OPEN, false), 10);
                host.level().levelEvent(null, 1014, pos, 0);
            }
        }
        else
        {
            if (openGate)
            {
                Direction facing = Direction.fromYRot(host.getYRot());

                if (state.getValue(FenceGateBlock.FACING) == facing.getOpposite())
                {
                    state = state.setValue(FenceGateBlock.FACING, facing);
                }

                host.level().setBlock(pos, state.setValue(FenceGateBlock.OPEN, true), 10);
                host.level().levelEvent(null, 1008, pos, 0);
            }
        }
    }


}

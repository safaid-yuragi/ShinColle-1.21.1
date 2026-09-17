package com.lulan.shincolle.utility;

import com.lulan.shincolle.blockentity.BasicBlockEntity;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.minecraft.world.level.material.Fluids;

/**
 * tile entity fuel / fluid helpers (legacy TileEntityHelper).
 *
 * Modern mappings:
 *   TileEntityFurnace.getItemBurnTime -> ItemStack#getBurnTime(SMELTING)
 *   IFluidContainerItem / FLUID_HANDLER_CAPABILITY -> Capabilities.FluidHandler.ITEM
 *   lava fuel: 1000 mB lava = 20000 fuel value
 */
public class TileEntityHelper
{

    /** fuel value of a lava bucket-worth (1000 mB) */
    public static final int LAVA_FUEL_VALUE = 20000;


    private TileEntityHelper() {}

    /** furnace-style power API implemented by machine tiles */
    public interface ITileFurnace
    {
        int getPowerRemained();
        void setPowerRemained(int value);
        int getPowerMax();
        float getFuelMagni();
    }

    /** liquid-fuel tank API (legacy ITileLiquidFurnace) */
    public interface ITileLiquidFurnace extends ITileFurnace
    {
        int getFluidFuelAmount();
        int consumeFluidFuel(int amount);
    }

    /** consume fuel item for the tile, return true = fuel added */
    public static boolean decrItemFuel(BasicBlockEntity tile, int fuelSlot)
    {
        if (!(tile instanceof ITileFurnace furnace)) return false;
        if (tile.getItemHandler() == null) return false;

        //check power storage first
        if (furnace.getPowerRemained() >= furnace.getPowerMax()) return false;

        ItemStack stack = tile.getItemHandler().getStackInSlot(fuelSlot);
        if (stack.isEmpty()) return false;

        //get normal fuel value
        int fuelx = stack.getBurnTime(RecipeType.SMELTING);
        fuelx *= furnace.getFuelMagni();

        //check power storage and add disposable fuel
        if (fuelx > 0 && fuelx + furnace.getPowerRemained() < furnace.getPowerMax())
        {
            ItemStack container = stack.getCraftingRemainingItem();

            //if item has container, ignore stacks > 1
            if (!container.isEmpty() && stack.getCount() > 1) return false;

            stack.shrink(1);
            furnace.setPowerRemained(furnace.getPowerRemained() + fuelx);

            if (stack.isEmpty()) stack = container;

            tile.getItemHandler().setStackInSlot(fuelSlot, stack);
            return true;
        }

        //add disposable fuel failed, try fluid container (lava)
        IFluidHandlerItem fluidHandler =
            stack.getCapability(Capabilities.FluidHandler.ITEM);
        if (fluidHandler != null)
        {
            //stack size must be 1
            if (stack.getCount() > 1) return false;

            FluidStack drained = fluidHandler.drain(
                new FluidStack(Fluids.LAVA, 1000),
                IFluidHandler.FluidAction.SIMULATE);
            if (!checkLiquidIsLava1000(drained)) return false;

            fuelx = (int) (LAVA_FUEL_VALUE * furnace.getFuelMagni());

            if (fuelx + furnace.getPowerRemained() < furnace.getPowerMax())
            {
                //drain lava
                fluidHandler.drain(new FluidStack(Fluids.LAVA, 1000),
                    IFluidHandler.FluidAction.EXECUTE);
                furnace.setPowerRemained(furnace.getPowerRemained() + fuelx);
                tile.getItemHandler().setStackInSlot(fuelSlot,
                    fluidHandler.getContainer());
                return true;
            }
        }

        return false;
    }

    /** consume tanked lava for the tile, return true = fuel added */
    public static boolean decrLiquidFuel(ITileLiquidFurnace tile)
    {
        //lava to fuel: 40 mB lava = 800 fuel value
        if (tile.getPowerMax() - tile.getPowerRemained() >= 800 &&
            tile.getFluidFuelAmount() >= 40)
        {
            int amount = tile.consumeFluidFuel(40) * 20;
            amount = (int) (amount * tile.getFuelMagni());
            tile.setPowerRemained(tile.getPowerRemained() + amount);
            return true;
        }

        return false;
    }

    /**
     * item burn-time or lava-container fuel value, used for fuel
     * item validity checks only (legacy getItemFuelValue).
     */
    public static int getItemFuelValue(ItemStack fuel)
    {
        if (fuel.isEmpty()) return 0;

        int fuelx = fuel.getBurnTime(RecipeType.SMELTING);
        if (fuelx > 0) return fuelx;

        //lava container
        if (fuel.getCount() > 1) return 0;
        IFluidHandlerItem fluidHandler =
            fuel.getCapability(Capabilities.FluidHandler.ITEM);
        if (fluidHandler != null)
        {
            FluidStack drained = fluidHandler.drain(
                new FluidStack(Fluids.LAVA, 1000),
                IFluidHandler.FluidAction.SIMULATE);
            if (checkLiquidIsLava1000(drained)) return LAVA_FUEL_VALUE;
        }

        return 0;
    }

    /** stack is a lava container holding at least 1000 mB */
    public static boolean checkLiquidIsLava1000(FluidStack fluid)
    {
        return fluid != null && !fluid.isEmpty() &&
               fluid.is(Fluids.LAVA) && fluid.getAmount() >= 1000;
    }

    /** stack is a fluid container of any kind */
    public static boolean isFluidContainer(ItemStack stack)
    {
        return !stack.isEmpty() &&
               stack.getCapability(Capabilities.FluidHandler.ITEM) != null;
    }


}

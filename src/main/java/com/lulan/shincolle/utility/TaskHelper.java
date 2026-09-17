package com.lulan.shincolle.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import com.lulan.shincolle.blockentity.TileEntityWaypoint;
import com.lulan.shincolle.config.ConfigMining;
import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.entity.EntityShipFishingHook;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.registry.ModBlocks;
import com.lulan.shincolle.registry.ModItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.ItemStackHandler;

/**
 * task helper (legacy TaskHelper).
 *
 * Ship tasks: 1 cooking, 2 fishing, 3 mining, 4 crafting.
 * Auto-pump runs when StateFlag[ID.F.AutoPump] is set.
 */
public class TaskHelper
{

    /** inventory slots that hold ship equipment/held items, not materials */
    private static final int[] EXCEPT_SLOTS = new int[] {22, 23};


    /** per-8-tick task dispatch (called from ship tick) */
    public static void onUpdateTask(BasicEntityShip host)
    {
        if (host.getStateFlag(ID.F.NoFuel) || !host.isAlive()) return;

        switch (host.getStateMinor(ID.M.Task))
        {
        case 1:
            if (ShinColleConfig.enableTask[0]) onUpdateCooking(host);
        break;
        case 2:
            if (ShinColleConfig.enableTask[1]) onUpdateFishing(host);
        break;
        case 3:
            if (ShinColleConfig.enableTask[2]) onUpdateMining(host);
        break;
        case 4:
            if (ShinColleConfig.enableTask[3]) onUpdateCrafting(host);
        break;
        }

        if (host.getStateFlag(ID.F.AutoPump)) onUpdatePumping(host);
    }

    /* ==================== cooking ==================== */

    /**
     * cooking task: ship guards a waypoint paired with a furnace-like
     * container; moves smeltable input + fuel in, takes output out.
     */
    public static void onUpdateCooking(BasicEntityShip host)
    {
        if (host == null) return;

        ItemStack mainstack = host.getHeldItemMainhand();
        ItemStack offstack = host.getHeldItemOffhand();
        if (mainstack.isEmpty()) return;

        //guard pos must be a waypoint with a paired chest
        BlockEntity te = getGuardedWaypoint(host);
        if (te == null) return;

        BlockPos chestPos = ((TileEntityWaypoint) te).getPairedChest();
        if (chestPos.getY() <= 0) return;

        BlockEntity chestTE = host.level().getBlockEntity(chestPos);
        if (!(chestTE instanceof Container chest)) return;

        //too far: walk back to the waypoint
        if (host.distanceToSqr(chestPos.getX(), chestPos.getY(), chestPos.getZ()) > 25D)
        {
            host.getShipNavigate().tryMoveToXYZ(
                host.getGuardedPos(0), host.getGuardedPos(1), host.getGuardedPos(2), 1D);
            return;
        }

        //need a smelting recipe for the held template item
        ItemStack resultStack = getSmeltResult(host, mainstack);
        if (resultStack.isEmpty()) return;

        var inv = host.getShipInventory();
        boolean moved = false;

        //find matching raw input inside ship inventory
        int targetID = findMatching(inv, mainstack, EXCEPT_SLOTS);
        if (targetID >= 0)
        {
            ItemStack in = inv.getStackInSlot(targetID);
            //insert into chest (first open slot)
            ItemStack rest = insertIntoContainer(chest, in);
            inv.setStackInSlot(targetID, rest);
            moved = !ItemStack.matches(in, rest);
        }

        //move fuel (offhand template match)
        if (!offstack.isEmpty())
        {
            int fuelID = findMatching(inv, offstack, EXCEPT_SLOTS);
            if (fuelID >= 0)
            {
                ItemStack fuel = inv.getStackInSlot(fuelID);
                ItemStack rest = insertIntoContainer(chest, fuel);
                inv.setStackInSlot(fuelID, rest);
                moved = moved || !ItemStack.matches(fuel, rest);
            }
        }

        //take cooked results out of the chest
        for (int i = 0; i < chest.getContainerSize(); i++)
        {
            ItemStack out = chest.getItem(i);

            if (!out.isEmpty() && ItemStack.isSameItemSameComponents(out, resultStack))
            {
                ItemStack rest = insertIntoShipInventory(inv, out.copy());
                chest.setItem(i, rest);

                if (rest.getCount() < out.getCount())
                {
                    moved = true;
                    host.addShipExp(ShinColleConfig.expGainTask[0]);
                    host.decrGrudgeNum(ShinColleConfig.consumeGrudgeTask[0]);
                    host.addMorale(100);

                    //level-scaled failure: occasionally produce charcoal instead
                    float failChance = (float) (ShinColleConfig.maxLevel - host.getLevel())
                        / (float) ShinColleConfig.maxLevel * 0.2F + 0.05F;

                    if (host.getRandom().nextFloat() < failChance)
                    {
                        ItemStack coal = new ItemStack(Items.CHARCOAL, 1);
                        ItemEntity drop = new ItemEntity(host.level(),
                            chestPos.getX() + 0.5D, chestPos.getY() + 1D, chestPos.getZ() + 0.5D, coal);
                        drop.setDeltaMovement(host.getRandom().nextGaussian() * 0.05D,
                            host.getRandom().nextGaussian() * 0.05D + 0.2D,
                            host.getRandom().nextGaussian() * 0.05D);
                        host.level().addFreshEntity(drop);
                        host.applyEmotesReaction(6);
                    }
                    else if (host.getRandom().nextInt(7) == 0)
                    {
                        host.applyParticleEmotion(
                            new int[] {0, 1, 7, 16, 30}[host.getRandom().nextInt(5)]);
                    }
                }
            }
        }

        if (moved)
        {
            host.swing(net.minecraft.world.InteractionHand.MAIN_HAND);
        }
    }

    @Nullable
    private static ItemStack getSmeltResult(BasicEntityShip host, ItemStack input)
    {
        var rm = host.level().getRecipeManager();
        var holder = rm.getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(input),
            host.level());

        if (holder.isPresent())
        {
            return holder.get().value().assemble(new SingleRecipeInput(input),
                host.level().registryAccess());
        }

        return ItemStack.EMPTY;
    }

    /* ==================== fishing ==================== */

    /**
     * fishing task: ship casts a fishing hook toward water; every
     * tickFishing interval the hook returns a fishing-loot-table item.
     */
    public static void onUpdateFishing(BasicEntityShip host)
    {
        if (host == null || !(host.level() instanceof ServerLevel sl)) return;

        //need rod in mainhand
        if (!host.getHeldItemMainhand().is(Items.FISHING_ROD)) return;

        //cast hook if none exists
        if (host.fishHook == null || !host.fishHook.isAlive())
        {
            EntityShipFishingHook hook = new EntityShipFishingHook(
                com.lulan.shincolle.registry.ModEntities.SHIP_FISHING_HOOK.get(), sl);
            hook.setPos(host.getX(), host.getY() + host.getBbHeight(), host.getZ());
            hook.init(host);
            sl.addFreshEntity(hook);
            host.fishHook = hook;
            return;
        }

        //roll loot on interval
        int interval = ShinColleConfig.tickFishing[0] +
            host.getRandom().nextInt(Math.max(1, ShinColleConfig.tickFishing[1] -
                ShinColleConfig.tickFishing[0]));

        if (host.tickCount % interval != 0) return;

        List<ItemStack> loots = generateFishingResult(host);

        for (ItemStack s : loots)
        {
            insertIntoShipInventory(host.getShipInventory(), s);
        }

        if (!loots.isEmpty())
        {
            host.addShipExp(ShinColleConfig.expGainTask[1]);
            host.decrGrudgeNum(ShinColleConfig.consumeGrudgeTask[1]);
            host.addMorale(50);
            host.swing(net.minecraft.world.InteractionHand.MAIN_HAND);
        }
    }

    /** fishing loot via vanilla fishing loot table */
    public static List<ItemStack> generateFishingResult(BasicEntityShip host)
    {
        List<ItemStack> result = new ArrayList<>();

        if (!(host.level() instanceof ServerLevel sl)) return result;

        LootTable table = sl.getServer().reloadableRegistries()
            .getLootTable(BuiltInLootTables.FISHING);

        Vec3 pos = host.position();
        LootParams params = new LootParams.Builder(sl)
            .withParameter(LootContextParams.ORIGIN, pos)
            .withParameter(LootContextParams.TOOL, host.getHeldItemMainhand())
            .withParameter(LootContextParams.THIS_ENTITY, host)
            .create(LootContextParamSets.FISHING);

        table.getRandomItems(params, result::add);
        return result;
    }

    /* ==================== mining ==================== */

    /**
     * mining task: ship wanders near guard point and produces loot from
     * the ConfigMining loot table on an interval.
     */
    public static void onUpdateMining(BasicEntityShip host)
    {
        if (host == null) return;

        ItemStack pickaxe = host.getHeldItemMainhand();
        if (!isToolEffective(pickaxe, 0, 0)) return;

        //random walk near guard position
        if (host.getShipNavigate().noPath() && host.getRandom().nextInt(300) == 0)
        {
            double gx = host.getGuardedPos(0);
            double gy = host.getGuardedPos(1);
            double gz = host.getGuardedPos(2);
            host.getShipNavigate().tryMoveToXYZ(
                gx + host.getRandom().nextInt(9) - 4,
                gy + host.getRandom().nextInt(3) - 1,
                gz + host.getRandom().nextInt(9) - 4, 0.6D);
        }

        int interval = ShinColleConfig.tickMining[0] +
            host.getRandom().nextInt(Math.max(1, ShinColleConfig.tickMining[1] -
                ShinColleConfig.tickMining[0]));

        if (host.tickCount % interval != 0) return;

        generateMiningResult(host);
        host.swing(net.minecraft.world.InteractionHand.MAIN_HAND);
    }

    /** produce a mining loot item into the ship inventory */
    public static void generateMiningResult(BasicEntityShip ship)
    {
        ItemStack pickaxe = ship.getHeldItemMainhand();
        if (pickaxe.isEmpty()) return;

        int dimId = ship.level().dimension().location().hashCode();
        int biomeId = ship.level().getBiome(ship.blockPosition()).unwrapKey()
            .map(k -> k.location().hashCode())
            .orElse(ConfigMining.GeneralBiomeID);
        int toolLv = getToolLevel(pickaxe);

        List<ConfigMining.ItemEntry> list = getMiningLootList(
            dimId, biomeId, ship.getLevel(), (int) ship.getY(), toolLv);

        if (list == null || list.isEmpty()) return;

        //cumulative weights
        List<Integer> weights = new ArrayList<>();
        weights.add(list.get(0).weight);
        for (int i = 1; i < list.size(); i++)
        {
            weights.add(weights.get(i - 1) + list.get(i).weight);
        }

        int roll = ship.getRandom().nextInt(weights.get(weights.size() - 1));
        int result = 0;
        for (int i = 0; i < weights.size(); i++)
        {
            if (roll <= weights.get(i))
            {
                result = i;
                break;
            }
        }

        ConfigMining.ItemEntry ie = list.get(result);
        Item item = BuiltInRegistries.ITEM.get(ResourceLocation.parse(ie.itemName));
        if (item == Items.AIR) return;

        int stacksize = ie.min;
        if (ie.max > ie.min)
        {
            stacksize = ie.min + ship.getRandom().nextInt(ie.max - ie.min + 1);
        }

        if (ie.enchant > 0F)
        {
            int fortlv = pickaxe.getEnchantments().getLevel(
                ship.registryAccess().lookupOrThrow(
                    net.minecraft.core.registries.Registries.ENCHANTMENT)
                    .getOrThrow(Enchantments.FORTUNE));
            int lucklv = BuffHelper.getPotionLevel(ship.getBuffMap(), 26);
            stacksize = (int) (stacksize * (1 + (fortlv + lucklv) * ie.enchant));
        }

        insertIntoShipInventory(ship.getShipInventory(), new ItemStack(item, stacksize));
        ship.addShipExp(ShinColleConfig.expGainTask[2]);
        ship.decrGrudgeNum(ShinColleConfig.consumeGrudgeTask[2]);
    }

    /** filter loot entries by world/biome/level/y/tool level */
    @Nullable
    public static List<ConfigMining.ItemEntry> getMiningLootList(
            int worldid, int biomeid, int lvShip, int lvHeight, int lvTool)
    {
        if (ConfigMining.MININGMAP == null) return null;

        var wmap = ConfigMining.MININGMAP.get(worldid);
        if (wmap == null) wmap = ConfigMining.MININGMAP.get(ConfigMining.GeneralWorldID);
        if (wmap == null) return null;

        var list = wmap.get(biomeid);
        if (list == null) list = wmap.get(ConfigMining.GeneralBiomeID);
        if (list == null) return null;

        List<ConfigMining.ItemEntry> out = new ArrayList<>();
        for (ConfigMining.ItemEntry e : list)
        {
            if (lvShip >= e.lvShip && lvHeight <= e.lvHeight && lvTool >= e.lvTool)
            {
                out.add(e);
            }
        }
        return out;
    }

    /**
     * tool effectiveness check (legacy isToolEffective):
     * targetType 0 pickaxe 1 shovel 2 axe.
     */
    public static boolean isToolEffective(ItemStack stack, int targetType, int targetLevel)
    {
        if (stack.isEmpty()) return false;

        var tag = switch (targetType)
        {
            case 1 -> net.minecraft.tags.ItemTags.SHOVELS;
            case 2 -> net.minecraft.tags.ItemTags.AXES;
            default -> net.minecraft.tags.ItemTags.PICKAXES;
        };

        return stack.is(tag) && getToolLevel(stack) >= targetLevel;
    }

    /** approximate harvest tier: Tiers ordinal of the held tool */
    public static int getToolLevel(ItemStack stack)
    {
        if (stack.getItem() instanceof net.minecraft.world.item.TieredItem ti)
        {
            var tier = ti.getTier();
            if (tier == net.minecraft.world.item.Tiers.NETHERITE) return 4;
            if (tier == net.minecraft.world.item.Tiers.DIAMOND) return 3;
            if (tier == net.minecraft.world.item.Tiers.IRON) return 2;
            if (tier == net.minecraft.world.item.Tiers.STONE) return 1;
            return 0;
        }
        return 0;
    }

    /* ==================== crafting ==================== */

    /**
     * crafting task: recipe paper in mainhand defines a 3x3 recipe;
     * ship consumes matching materials from its inventory and produces
     * the result (into paired chest if present, else own inventory).
     */
    public static void onUpdateCrafting(BasicEntityShip host)
    {
        if (host == null) return;

        ItemStack paper = host.getHeldItemMainhand();
        if (paper.isEmpty() || !paper.is(ModItems.RECIPE_PAPER.get())) return;

        BlockEntity te = getGuardedWaypoint(host);
        if (te == null) return;

        //paired chest for output (optional)
        BlockPos chestPos = ((TileEntityWaypoint) te).getPairedChest();
        Container chest = null;
        if (chestPos.getY() > 0 &&
            host.level().getBlockEntity(chestPos) instanceof Container c)
        {
            chest = c;
        }

        if (host.distanceToSqr(te.getBlockPos().getX(), te.getBlockPos().getY(),
                te.getBlockPos().getZ()) > 25D)
        {
            host.getShipNavigate().tryMoveToXYZ(
                host.getGuardedPos(0), host.getGuardedPos(1), host.getGuardedPos(2), 1D);
            return;
        }

        //recipe grid from paper's custom data "Recipe" list (9 slots)
        var custom = paper.get(net.minecraft.core.component.DataComponents.CUSTOM_DATA);
        if (custom == null) return;

        var tagList = custom.copyTag().getList("Recipe", net.minecraft.nbt.Tag.TAG_COMPOUND);
        if (tagList.isEmpty()) return;

        ItemStack[] grid = new ItemStack[9];
        java.util.Arrays.fill(grid, ItemStack.EMPTY);

        for (int i = 0; i < tagList.size(); i++)
        {
            var it = tagList.getCompound(i);
            int slot = it.getInt("Slot");
            if (slot >= 0 && slot < 9)
            {
                ItemStack.parse(host.registryAccess(), it).ifPresent(s -> grid[slot] = s);
            }
        }

        //find matching crafting recipe
        CraftingInput input = CraftingInput.of(3, 3, java.util.Arrays.asList(grid));
        var recipe = host.level().getRecipeManager()
            .getRecipeFor(RecipeType.CRAFTING, input, host.level());
        if (recipe.isEmpty()) return;

        ItemStack result = recipe.get().value().assemble(input, host.level().registryAccess());
        if (result.isEmpty()) return;

        //consume materials from ship inventory
        var inv = host.getShipInventory();
        for (ItemStack need : grid)
        {
            if (need.isEmpty()) continue;

            int idx = findMatching(inv, need, EXCEPT_SLOTS);
            if (idx < 0) return;  //missing material, abort craft

            inv.extractItem(idx, 1, false);
        }

        //put result into chest or ship inventory
        if (chest != null)
        {
            result = insertIntoContainer(chest, result);
        }
        if (!result.isEmpty())
        {
            insertIntoShipInventory(inv, result);
        }

        host.addShipExp(ShinColleConfig.expGainTask[3]);
        host.decrGrudgeNum(ShinColleConfig.consumeGrudgeTask[3]);
        host.addMorale(20);
        host.swing(net.minecraft.world.InteractionHand.MAIN_HAND);
    }

    /* ==================== pumping ==================== */

    /**
     * pump liquid under the ship into buckets (legacy onUpdatePumping).
     * Non-transport ships need a drum equip in the inventory.
     */
    public static void onUpdatePumping(BasicEntityShip ship)
    {
        int delay = 63;
        int level = ship.getLevel();

        if (level >= 145) delay = 3;
        else if (level >= 115) delay = 7;
        else if (level >= 75) delay = 15;
        else if (level >= 30) delay = 31;

        if ((ship.tickCount & delay) != 0) return;

        var inv = ship.getShipInventory();

        //non-transport ships need a drum equip
        if (ship.getShipType() != ID.ShipIconType.TRANSPORT ||
            !ship.getStateFlag(ID.F.IsMarried))
        {
            if (!hasAnyItem(inv, ModItems.EQUIP_DRUM.get(),
                    ModItems.EQUIP_DRUM_1.get(), ModItems.EQUIP_DRUM_2.get())) return;
        }

        //find a source block under the ship (3x3, feet level)
        BlockPos pos = findNearbyLiquidSource(ship);
        if (pos == null) return;

        var fs = ship.level().getFluidState(pos);
        boolean isWater = fs.getType() == Fluids.WATER;
        boolean isLava = fs.getType() == Fluids.LAVA;
        if (!isWater && !isLava) return;

        //fill an empty bucket in the inventory
        int bucketSlot = findItem(inv, Items.BUCKET, null);
        if (bucketSlot < 0) return;

        //infinite-liquid check: don't drain oceans
        int checkDepth = ShinColleConfig.infLiquid[isWater ? 0 : 1];
        if (countSameFluidNearby(ship, pos, fs.getType(), 3, checkDepth))
        {
            return;
        }

        inv.extractItem(bucketSlot, 1, false);
        insertIntoShipInventory(inv,
            new ItemStack(isWater ? Items.WATER_BUCKET : Items.LAVA_BUCKET, 1));

        ship.level().setBlock(pos, Blocks.AIR.defaultBlockState(), 11);

        if (ship.getRandom().nextInt(3) == 0)
        {
            ship.level().playSound(null, pos, SoundEvents.BUCKET_FILL,
                SoundSource.NEUTRAL, 0.5F,
                ship.getRandom().nextFloat() * 0.4F + 0.8F);
        }
    }

    /* ==================== inventory helpers ==================== */

    /** find a stack matching the template item inside the ship inventory */
    private static int findMatching(ItemStackHandler inv, ItemStack template, int[] except)
    {
        outer:
        for (int i = 0; i < inv.getSlots(); i++)
        {
            for (int ex : except) if (i == ex) continue outer;

            ItemStack s = inv.getStackInSlot(i);
            if (!s.isEmpty() && ItemStack.isSameItem(s, template)) return i;
        }
        return -1;
    }

    private static int findItem(ItemStackHandler inv, Item item, @Nullable int[] except)
    {
        for (int i = 0; i < inv.getSlots(); i++)
        {
            if (except != null)
            {
                boolean skip = false;
                for (int ex : except) if (i == ex) skip = true;
                if (skip) continue;
            }
            if (inv.getStackInSlot(i).is(item)) return i;
        }
        return -1;
    }

    private static boolean hasAnyItem(ItemStackHandler inv, Item... items)
    {
        for (int i = 0; i < inv.getSlots(); i++)
        {
            for (Item it : items)
            {
                if (inv.getStackInSlot(i).is(it)) return true;
            }
        }
        return false;
    }

    /** insert into ship inventory, returns leftover */
    private static ItemStack insertIntoShipInventory(ItemStackHandler inv, ItemStack stack)
    {
        for (int i = 0; i < inv.getSlots() && !stack.isEmpty(); i++)
        {
            stack = inv.insertItem(i, stack, false);
        }
        return stack;
    }

    /** insert into a vanilla Container, returns leftover */
    private static ItemStack insertIntoContainer(Container chest, ItemStack stack)
    {
        for (int i = 0; i < chest.getContainerSize() && !stack.isEmpty(); i++)
        {
            ItemStack cur = chest.getItem(i);
            if (cur.isEmpty())
            {
                chest.setItem(i, stack.copy());
                return ItemStack.EMPTY;
            }
            else if (ItemStack.isSameItemSameComponents(cur, stack) &&
                     cur.getCount() < Math.min(cur.getMaxStackSize(), chest.getMaxStackSize()))
            {
                int move = Math.min(stack.getCount(), cur.getMaxStackSize() - cur.getCount());
                cur.grow(move);
                stack.shrink(move);
                chest.setItem(i, cur);
            }
        }
        return stack;
    }

    /* ==================== waypoint / fluid helpers ==================== */

    /** guarded pos must point to a waypoint block entity */
    @Nullable
    private static BlockEntity getGuardedWaypoint(BasicEntityShip host)
    {
        if (host.getGuardedPos(1) <= 0) return null;

        BlockPos pos = new BlockPos(
            host.getGuardedPos(0), host.getGuardedPos(1), host.getGuardedPos(2));
        BlockEntity te = host.level().getBlockEntity(pos);

        return te instanceof TileEntityWaypoint ? te : null;
    }

    /** find a source fluid block in a 3x3 area at the ship's feet */
    @Nullable
    private static BlockPos findNearbyLiquidSource(BasicEntityShip ship)
    {
        BlockPos feet = ship.blockPosition();

        for (int ix = -1; ix <= 1; ix++)
        {
            for (int iz = -1; iz <= 1; iz++)
            {
                BlockPos pos = feet.offset(ix, 0, iz);
                var fs = ship.level().getFluidState(pos);
                if (fs.isSource() && (fs.getType() == Fluids.WATER ||
                                      fs.getType() == Fluids.LAVA))
                {
                    return pos;
                }
            }
        }
        return null;
    }

    /** true if the same fluid keeps flowing deeper than maxDepth nearby */
    private static boolean countSameFluidNearby(BasicEntityShip ship, BlockPos pos,
            net.minecraft.world.level.material.Fluid fluid, int range, int maxDepth)
    {
        int count = 0;

        for (int iy = 0; iy >= -maxDepth; iy--)
        {
            for (int ix = -range; ix <= range; ix++)
            {
                for (int iz = -range; iz <= range; iz++)
                {
                    var fs = ship.level().getFluidState(pos.offset(ix, iy, iz));
                    if (fs.getType() == fluid)
                    {
                        count++;
                        if (count > 60) return true;
                    }
                }
            }
        }
        return false;
    }


}

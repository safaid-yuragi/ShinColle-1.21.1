package com.lulan.shincolle.loot;

import com.lulan.shincolle.registry.ModLootModifiers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

/**
 * chest loot injection (legacy worldgen/ChestLootTable.java).
 *
 * Appends the rolls of an extra {@link LootPool} to a chest loot table when
 * the conditions match (target the table with {@code neoforge:loot_table_id}).
 * The pool is a full vanilla loot pool (rolls / bonus_rolls / entries with
 * weight, random_chance conditions and set_count / set_components functions),
 * so all tuning lives in data/shincolle/loot_modifiers/*.json.
 *
 * JSON:
 * <pre>
 * {
 *   "type": "shincolle:chest_loot",
 *   "conditions": [
 *     { "condition": "neoforge:loot_table_id",
 *       "loot_table_id": "minecraft:chests/simple_dungeon" }
 *   ],
 *   "pool": { "rolls": { "min": 1, "max": 4 }, "bonus_rolls": 1, "entries": [...] }
 * }
 * </pre>
 */
public class ChestLootModifier extends LootModifier
{

    public static final MapCodec<ChestLootModifier> CODEC = RecordCodecBuilder.mapCodec(
        inst -> inst.group(
            IGlobalLootModifier.LOOT_CONDITIONS_CODEC.fieldOf("conditions")
                .forGetter(glm -> glm.conditions),
            LootPool.CODEC.fieldOf("pool").forGetter(glm -> glm.pool))
        .apply(inst, ChestLootModifier::new));

    private final LootPool pool;


    public ChestLootModifier(LootItemCondition[] conditions, LootPool pool)
    {
        super(conditions);
        this.pool = pool;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot,
            LootContext context)
    {
        this.pool.addRandomItems(
            LootTable.createStackSplitter(context.getLevel(), generatedLoot::add),
            context);
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec()
    {
        return ModLootModifiers.CHEST_LOOT.get();
    }


}

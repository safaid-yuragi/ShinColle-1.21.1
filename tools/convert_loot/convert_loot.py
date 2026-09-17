#!/usr/bin/env python3
"""Convert legacy chest-loot config (config/ConfigLoot.java defaults) to
NeoForge global loot modifier JSONs for 1.21.1.

Generates:
  data/shincolle/loot_modifiers/<table>.json   one per target chest table
      {"type": "shincolle:chest_loot", "conditions": [neoforge:loot_table_id],
       "pool": {rolls, bonus_rolls, entries}}
  data/neoforge/loot_modifiers/global_loot_modifiers.json

Legacy semantics (worldgen/ChestLootTable.java):
  each target table gets one extra pool: rolls = uniform(1, N/2+1),
  bonus_rolls = 1, each entry has weight, random_chance(chance%),
  set_count(uniform min..max). meta>0 selects the item variant, meta==-1
  means "any variant of the family" -> minecraft:tag entry with expand:true.

Usage:
  python3 tools/convert_loot/convert_loot.py [--dest DIR]
"""

import json
import sys
import pathlib
import argparse

# ---------------------------------------------------------------------------
# legacy ConfigLoot.getDefaultContent()
# (chest_id, item, meta, weight, chance%, min, max)
# ---------------------------------------------------------------------------
LOOTMAP = {
    0: [("shincolle:Grudge", 0, 1, 100, 10, 15),
        ("shincolle:ShipSpawnEgg", 2, 2, 100, 1, 1),
        ("shincolle:Ammo", 0, 1, 100, 5, 8)],

    1: [("shincolle:Grudge", 0, 1, 100, 5, 8),
        ("shincolle:ShipSpawnEgg", 0, 1, 100, 1, 1),
        ("shincolle:Ammo", 0, 1, 100, 2, 3),
        ("shincolle:InstantConMat", 0, 1, 100, 3, 5)],

    2: [("shincolle:MarriageRing", 0, 4, 70, 1, 1),
        ("shincolle:TrainingBook", 0, 4, 80, 1, 3),
        ("shincolle:ShipSpawnEgg", 0, 3, 100, 1, 1),
        ("shincolle:ShipSpawnEgg", 1, 3, 100, 1, 1),
        ("shincolle:ShipSpawnEgg", 17, 1, 80, 1, 1),
        ("shincolle:ShipSpawnEgg", 48, 1, 80, 1, 1)],

    3: [("shincolle:InstantConMat", 0, 20, 100, 10, 20),
        ("shincolle:BlockAbyssium", 0, 10, 100, 5, 10),
        ("shincolle:BlockPolymetal", 0, 10, 100, 5, 10),
        ("shincolle:ShipSpawnEgg", 0, 5, 100, 1, 1)],

    4: [("shincolle:TrainingBook", 0, 6, 80, 1, 3),
        ("shincolle:MarriageRing", 0, 6, 70, 1, 1),
        ("shincolle:ShipSpawnEgg", 0, 3, 100, 1, 1),
        ("shincolle:ShipSpawnEgg", 1, 3, 100, 1, 1),
        ("shincolle:EquipCannon", -1, 8, 100, 1, 1),
        ("shincolle:EquipAirplane", -1, 8, 100, 1, 1),
        ("shincolle:Torpedo", -1, 8, 100, 1, 1)],

    5: [("shincolle:TrainingBook", 0, 6, 80, 1, 3),
        ("shincolle:MarriageRing", 0, 6, 70, 1, 1),
        ("shincolle:ShipSpawnEgg", 0, 3, 100, 1, 1),
        ("shincolle:ShipSpawnEgg", 1, 3, 100, 1, 1),
        ("shincolle:EquipCannon", -1, 8, 100, 1, 1),
        ("shincolle:EquipAirplane", -1, 8, 100, 1, 1),
        ("shincolle:Torpedo", -1, 8, 100, 1, 1)],

    6: [("shincolle:MarriageRing", 0, 4, 70, 1, 1),
        ("shincolle:ShipSpawnEgg", 1, 2, 100, 1, 1),
        ("shincolle:ShipSpawnEgg", 17, 1, 80, 1, 1),
        ("shincolle:ShipSpawnEgg", 48, 1, 80, 1, 1)],

    7: [("shincolle:TrainingBook", 0, 4, 80, 1, 3),
        ("shincolle:InstantConMat", 0, 4, 100, 10, 12),
        ("shincolle:MarriageRing", 0, 4, 70, 1, 1),
        ("shincolle:BlockAbyssium", 0, 4, 100, 5, 15),
        ("shincolle:BlockPolymetal", 0, 4, 100, 5, 15)],

    8: [("shincolle:TrainingBook", 0, 6, 80, 1, 3),
        ("shincolle:MarriageRing", 0, 6, 70, 1, 1),
        ("shincolle:ShipSpawnEgg", 0, 3, 100, 1, 1),
        ("shincolle:ShipSpawnEgg", 1, 3, 100, 1, 1),
        ("shincolle:EquipCannon", -1, 8, 100, 1, 1),
        ("shincolle:EquipAirplane", -1, 8, 100, 1, 1),
        ("shincolle:Torpedo", -1, 8, 100, 1, 1)],

    9: [("shincolle:TrainingBook", 0, 6, 80, 1, 3),
        ("shincolle:MarriageRing", 0, 6, 70, 1, 1),
        ("shincolle:ShipSpawnEgg", 0, 3, 100, 1, 1),
        ("shincolle:ShipSpawnEgg", 1, 3, 100, 1, 1),
        ("shincolle:EquipCannon", -1, 8, 100, 1, 1),
        ("shincolle:EquipAirplane", -1, 8, 100, 1, 1),
        ("shincolle:Torpedo", -1, 8, 100, 1, 1)],
}

# chest_id -> 1.21.1 loot table path(s)  (LootTableList.* -> BuiltInLootTables)
CHEST_TABLES = {
    0: ["spawn_bonus_chest"],
    1: ["igloo_chest"],
    2: ["simple_dungeon"],
    3: ["village/village_weaponsmith"],   # legacy CHESTS_VILLAGE_BLACKSMITH
    4: ["abandoned_mineshaft"],
    5: ["desert_pyramid"],
    6: ["jungle_temple"],
    7: ["nether_bridge"],
    8: ["stronghold_library", "stronghold_crossing", "stronghold_corridor"],
    9: ["end_city_treasure"],
}

# ---------------------------------------------------------------------------
# old "shincolle:Item" -> new item id (meta 0 -> base name)
# ---------------------------------------------------------------------------
ITEM_MAP = {
    "shincolle:Grudge":       "shincolle:grudge",
    "shincolle:Ammo":         "shincolle:ammo",
    "shincolle:InstantConMat": "shincolle:instant_con_mat",
    "shincolle:MarriageRing": "shincolle:marriage_ring",
    "shincolle:TrainingBook": "shincolle:training_book",
    "shincolle:BlockAbyssium":  "shincolle:abyssium_block",
    "shincolle:BlockPolymetal": "shincolle:polymetal_block",
}

# meta==-1 (random variant) -> item tag expanded by the loot entry
RANDOM_META_TAG = {
    "shincolle:EquipCannon":   "shincolle:equips/cannon",
    "shincolle:EquipAirplane": "shincolle:equips/airplane",
    "shincolle:Torpedo":       "shincolle:equips/torpedo",
}


def uniform(minv, maxv):
    return {"type": "minecraft:uniform", "min": minv, "max": maxv}


def make_entry(item, meta, weight, chance, minc, maxc):
    if meta == -1:
        #random variant of the family -> expand tag, one entry per member
        entry = {"type": "minecraft:tag",
                 "name": RANDOM_META_TAG[item], "expand": True}
    else:
        entry = {"type": "minecraft:item", "name": None}
        if item == "shincolle:ShipSpawnEgg":
            entry["name"] = "shincolle:ship_spawn_egg"
            if meta != 0:
                #egg meta is stored in the shincolle:ship_class component
                entry.setdefault("functions", []).append({
                    "function": "minecraft:set_components",
                    "components": {"shincolle:ship_class": meta}})
        else:
            name = ITEM_MAP[item]
            if meta > 0:
                name += f"_{meta}"
            entry["name"] = name

    entry["weight"] = weight
    if chance < 100:
        entry.setdefault("conditions", []).append(
            {"condition": "minecraft:random_chance", "chance": chance / 100.0})
    if not (minc == 1 and maxc == 1):
        entry.setdefault("functions", []).append(
            {"function": "minecraft:set_count", "count": uniform(minc, maxc)})
    return entry


def make_modifier(table_path, entries):
    n = len(entries)
    return {
        "type": "shincolle:chest_loot",
        "conditions": [{
            "condition": "neoforge:loot_table_id",
            "loot_table_id": f"minecraft:chests/{table_path}",
        }],
        "pool": {
            "rolls": uniform(1, n // 2 + 1),
            "bonus_rolls": 1,
            "entries": entries,
        },
    }


def main() -> int:
    root = pathlib.Path(__file__).resolve().parents[2]
    ap = argparse.ArgumentParser(description=__doc__,
                                 formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--dest", default=root / "src/main/resources/data",
                    type=pathlib.Path)
    args = ap.parse_args()

    mod_dir = args.dest / "shincolle" / "loot_modifiers"
    glm_dir = args.dest / "neoforge" / "loot_modifiers"
    mod_dir.mkdir(parents=True, exist_ok=True)
    glm_dir.mkdir(parents=True, exist_ok=True)

    names = []
    for chest_id, tables in CHEST_TABLES.items():
        entries = [make_entry(*e) for e in LOOTMAP[chest_id]]
        for table in tables:
            data = make_modifier(table, entries)
            fname = table.rsplit("/", 1)[-1] + ".json"
            (mod_dir / fname).write_text(
                json.dumps(data, indent=2, ensure_ascii=False) + "\n")
            names.append(f"shincolle:{fname[:-5]}")
            print(f"wrote {mod_dir / fname}")

    glm = {"replace": False, "entries": names, "remove": []}
    out = glm_dir / "global_loot_modifiers.json"
    out.write_text(json.dumps(glm, indent=2) + "\n")
    print(f"wrote {out} ({len(names)} entries)")
    return 0


if __name__ == "__main__":
    sys.exit(main())

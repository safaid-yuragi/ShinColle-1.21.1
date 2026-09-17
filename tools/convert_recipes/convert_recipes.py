#!/usr/bin/env python3
"""Convert 1.12.2 Forge ore-dict recipes to 1.21.1 (NeoForge) recipe JSON.

Reads  <src>  (default: src/main/resources/assets/shincolle/recipes)
Writes <dest> (default: src/main/resources/data/shincolle/recipe)

Conversion rules (TO_1.21.1_NF.md appendix B-12):
  "type": "forge:ore_shaped"    -> "minecraft:crafting_shaped"
  "type": "forge:ore_shapeless"-> "minecraft:crafting_shapeless"
  {"type":"forge:ore_dict","ore":"X"} -> {"tag":"c:<mapped>"}
  {"item":"shincolle:Foo","data":N}   -> {"item":"shincolle:<new_id>"}  (meta flattened)
  "result":{"item":"X","data":N,"count":C} -> "result":{"id":"...","count":C}
  "group" preserved.

Foreign-mod ores (bronze/lead/silver/steel/tin/uranium ingots) map to `c:`
convention tags that ShinColle does not populate; recipes that REQUIRE them get
a neoforge:conditions "not tag_empty" guard so they only load when another mod
provides the material.

Usage:
  python3 tools/convert_recipes/convert_recipes.py [--src DIR] [--dest DIR]
"""

import json
import sys
import pathlib
import argparse

# ---------------------------------------------------------------------------
# ore dictionary name -> ingredient mapping
# ---------------------------------------------------------------------------
# NeoForge-provided c: tags (verified against neoforge-21.1.250 data/c/tags/item)
ORE_TO_TAG = {
    "blockDiamond": ("tag", "c:storage_blocks/diamond"),
    "cropWheat":    ("tag", "c:crops/wheat"),
    "dyeBlue":      ("tag", "c:dyes/blue"),
    "gemDiamond":   ("tag", "c:gems/diamond"),
    "gemLapis":     ("tag", "c:gems/lapis"),
    "gunpowder":    ("tag", "c:gunpowders"),
    "ingotCopper":  ("tag", "c:ingots/copper"),
    "ingotGold":    ("tag", "c:ingots/gold"),
    "ingotIron":    ("tag", "c:ingots/iron"),
    "netherStar":   ("tag", "c:nether_stars"),
    "obsidian":     ("tag", "c:obsidians"),
    "stickWood":    ("tag", "c:rods/wooden"),
    # convention tags populated by other mods, not by NeoForge or ShinColle
    "ingotBronze":  ("tag", "c:ingots/bronze"),
    "ingotLead":    ("tag", "c:ingots/lead"),
    "ingotSilver":  ("tag", "c:ingots/silver"),
    "ingotSteel":   ("tag", "c:ingots/steel"),
    "ingotTin":     ("tag", "c:ingots/tin"),
    "ingotUranium": ("tag", "c:ingots/uranium"),
    "foodFlour":    ("tag", "c:flours/wheat"),       # e.g. Create wheat flour
    "cookedRice":   ("tag", "c:foods/cooked_rice"),  # e.g. Farmer's Delight
    # ore names that only ever meant one vanilla item -> direct item ref
    "paper":        ("item", "minecraft:paper"),
}

# ore tags that no loaded content provides (foreign mod materials).
# If one appears as a standalone ingredient, gate the whole recipe on the
# tag being non-empty so the recipe only loads with the providing mod.
FOREIGN_ORES = {
    "ingotBronze", "ingotLead", "ingotSilver", "ingotSteel",
    "ingotTin", "ingotUranium", "foodFlour", "cookedRice",
}

# ---------------------------------------------------------------------------
# old "shincolle:Item" + meta -> new item id (ModItems / ModBlocks, 1.21.1)
# meta 0 -> <family>, meta N -> <family>_<N>
# ---------------------------------------------------------------------------
META_ITEM = {
    "AbyssMetal":   "abyss_metal",     # 1 = Polymetallic Nodules
    "AbyssNugget":  "abyss_nugget",
    "Ammo":         "ammo",
    "CombatRation": "combat_ration",
    "Grudge":       "grudge",          # 1 = Sublimation Grudge
    "ShipTank":     "ship_tank",
}

SINGLE_ITEM = {
    "BucketRepair":   "bucket_repair",
    "DeskItemBook":   "desk_item_book",
    "DeskItemRadar":  "desk_item_radar",
    "InstantConMat":  "instant_con_mat",
    "KaitaiHammer":   "kaitai_hammer",
    "MarriageRing":   "marriage_ring",
    "ModernKit":      "modern_kit",
    "OwnerPaper":     "owner_paper",
    "OPTool":         "op_tool",
    "PointerItem":    "pointer_item",
    "RecipePaper":    "recipe_paper",
    "RepairGoddess":  "repair_goddess",
    "TargetWrench":   "target_wrench",
    "TrainingBook":   "training_book",
    "ToyAirplane":    "toy_airplane",
}

BLOCKS = {
    "BlockAbyssium":          "abyssium_block",
    "BlockCrane":             "crane_block",
    "BlockDesk":              "desk_block",
    "BlockFrame":             "frame_block",
    "BlockGrudge":            "grudge_block",
    "BlockGrudgeXP":          "grudge_xp_block",
    "BlockGrudgeHeavy":       "grudge_heavy_block",
    "BlockGrudgeHeavyDeco":   "grudge_heavy_deco_block",
    "BlockPolymetal":         "polymetal_block",
    "BlockPolymetalGravel":   "polymetal_gravel",
    "BlockPolymetalOre":      "polymetal_ore",
    "BlockSmallShipyard":     "small_shipyard",
    "BlockVolBlock":          "vol_block",
    "BlockVolCore":           "vol_core",
    "BlockWaypoint":          "waypoint",
    "BlockLightAir":          "light_air",
    "BlockLightLiquid":       "light_liquid",
}

# vanilla ids renamed between 1.12.2 and 1.21.1
VANILLA_RENAME = {
    "minecraft:clownfish": "minecraft:tropical_fish",
}


def map_shincolle_item(name: str, meta: int) -> str:
    """old registry name + meta -> new 'shincolle:' item id"""
    if name in META_ITEM:
        return f"shincolle:{META_ITEM[name]}" + ("" if meta == 0 else f"_{meta}")
    if name in SINGLE_ITEM:
        return f"shincolle:{SINGLE_ITEM[name]}"
    if name in BLOCKS:
        return f"shincolle:{BLOCKS[name]}"
    raise ValueError(f"unknown shincolle item {name} meta {meta}")


def convert_ingredient(obj, foreign: set):
    """one ingredient entry (dict) -> 1.21 ingredient object"""
    if obj.get("type") == "forge:ore_dict":
        kind, value = ORE_TO_TAG[obj["ore"]]
        if obj["ore"] in FOREIGN_ORES:
            foreign.add(value)
        return {kind: value}

    if "item" in obj:
        item = obj["item"]
        meta = obj.get("data", 0)
        if item.startswith("shincolle:"):
            base = item.split(":", 1)[1]
            if base == "ShipSpawnEgg":
                # meta -> shincolle:ship_class component on the single egg item
                return {
                    "type": "neoforge:components",
                    "items": "shincolle:ship_spawn_egg",
                    "components": {"shincolle:ship_class": meta},
                }
            return {"item": map_shincolle_item(base, meta)}
        return {"item": VANILLA_RENAME.get(item, item)}

    raise ValueError(f"unsupported ingredient entry: {obj}")


def convert_ingredient_value(v, foreign: set):
    """key value / shapeless element: object or list of objects.

    Foreign tags inside a multi-entry list are merely alternatives (the list
    stays non-empty via vanilla entries), so they don't gate the recipe;
    only standalone foreign ingredients are collected for the
    neoforge:conditions "not tag_empty" guard."""
    if isinstance(v, list):
        return [convert_ingredient(o, set()) for o in v]
    return convert_ingredient(v, foreign)


def convert_result(r: dict) -> dict:
    item = r["item"]
    meta = r.get("data", 0)
    count = r.get("count", 1)
    if item.startswith("shincolle:"):
        base = item.split(":", 1)[1]
        if base == "ShipSpawnEgg":
            out = {"id": "shincolle:ship_spawn_egg",
                   "components": {"shincolle:ship_class": meta}}
        else:
            out = {"id": map_shincolle_item(base, meta)}
    else:
        out = {"id": VANILLA_RENAME.get(item, item)}
    out["count"] = count
    return out


def convert(data: dict, fname: str) -> dict:
    rtype = data["type"]
    if rtype == "forge:ore_shaped":
        out = {"type": "minecraft:crafting_shaped"}
    elif rtype == "forge:ore_shapeless":
        out = {"type": "minecraft:crafting_shapeless"}
    else:
        raise ValueError(f"{fname}: unsupported recipe type {rtype}")

    foreign: set = set()

    if "group" in data:
        out["group"] = data["group"]

    if rtype == "forge:ore_shaped":
        out["pattern"] = data["pattern"]
        out["key"] = {k: convert_ingredient_value(v, foreign)
                      for k, v in data["key"].items()}
    else:
        out["ingredients"] = [convert_ingredient_value(v, foreign)
                              for v in data["ingredients"]]

    out["result"] = convert_result(data["result"])

    # gate on foreign-material tags being populated
    if foreign:
        out["neoforge:conditions"] = [
            {"type": "neoforge:not",
             "value": {"type": "neoforge:tag_empty", "tag": tag}}
            for tag in sorted(foreign)
        ]

    return out


def main() -> int:
    root = pathlib.Path(__file__).resolve().parents[2]
    ap = argparse.ArgumentParser(description=__doc__,
                                 formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--src", default=root / "src/main/resources/assets/shincolle/recipes",
                    type=pathlib.Path)
    ap.add_argument("--dest", default=root / "src/main/resources/data/shincolle/recipe",
                    type=pathlib.Path)
    args = ap.parse_args()

    files = sorted(args.src.glob("*.json"))
    if not files:
        print(f"no recipes found in {args.src}", file=sys.stderr)
        return 1
    args.dest.mkdir(parents=True, exist_ok=True)

    errors = 0
    for f in files:
        try:
            converted = convert(json.loads(f.read_text()), f.name)
        except Exception as e:
            print(f"ERROR {f.name}: {e}", file=sys.stderr)
            errors += 1
            continue
        out = args.dest / f.name.lower()
        out.write_text(json.dumps(converted, indent=2, ensure_ascii=False) + "\n")
        print(f"{f.name} -> {out.name}")

    print(f"{len(files) - errors}/{len(files)} recipes converted")
    return 1 if errors else 0


if __name__ == "__main__":
    sys.exit(main())

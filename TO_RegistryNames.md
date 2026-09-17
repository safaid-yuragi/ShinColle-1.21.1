# Registry 命名変換表 (1.12.2 → 1.21.1)

全ての registry path は `shincolle:` 名前空間の `[a-z0-9_.-]`。

## ブロック (17)

| 旧名 | 新名 | BlockEntity |
|---|---|---|
| BlockAbyssium | `abyssium` | - |
| BlockCrane | `crane` | crane |
| BlockDesk | `desk` | desk |
| BlockFrame | `frame` | - |
| BlockGrudge | `grudge` | - |
| BlockGrudgeXP | `grudge_xp` | - |
| BlockGrudgeHeavy | `grudge_heavy` | grudge_heavy (multiblock) |
| BlockGrudgeHeavyDeco | `grudge_heavy_deco` | - |
| BlockLightAir | `light_air` | light_air |
| BlockLightLiquid | `light_liquid` | - |
| BlockPolymetal | `polymetal` | polymetal (multiblock) |
| BlockPolymetalGravel | `polymetal_gravel` | - |
| BlockPolymetalOre | `polymetal_ore` | - |
| BlockSmallShipyard | `small_shipyard` | small_shipyard |
| BlockVolBlock | `vol_block` | - |
| BlockVolCore | `vol_core` | vol_core |
| BlockWaypoint | `waypoint` | waypoint |

BlockLargeShipyard は未登録 (GrudgeHeavy が large shipyard 兼用)。

## アイテム (メタ → 個別アイテム)

旧 `Item@meta` は `<name>` (meta 0) / `<name>_<meta>` (meta 1+) に分割。

| 旧クラス | 新名 |
|---|---|
| ShipSpawnEgg | `ship_spawn_egg` (ship_class DataComponent) |
| AbyssMetal | `abyss_metal`, `abyss_metal_1` (Polymetallic Nodules) |
| AbyssNugget | `abyss_nugget`, `abyss_nugget_1` |
| Ammo | `ammo`, `ammo_1`, `ammo_2`, `ammo_3` |
| Grudge | `grudge`, `grudge_1` (Sublimation Grudge) |
| CombatRation | `combat_ration` .. `combat_ration_5` |
| ShipTank | `ship_tank` .. `ship_tank_3` |
| EquipAirplane | `equip_airplane` .. `equip_airplane_21` |
| EquipAmmo | `equip_ammo` .. `equip_ammo_8` |
| EquipArmor | `equip_armor` .. `equip_armor_6` |
| EquipCannon | `equip_cannon` .. `equip_cannon_15` |
| EquipCatapult | `equip_catapult` .. `equip_catapult_3` |
| EquipCompass | `equip_compass` |
| EquipDrum | `equip_drum` .. `equip_drum_2` |
| EquipFlare | `equip_flare` |
| EquipMachinegun | `equip_machinegun` .. `equip_machinegun_6` |
| EquipRadar | `equip_radar` .. `equip_radar_8` |
| EquipSearchlight | `equip_searchlight` |
| EquipTorpedo | `equip_torpedo` .. `equip_torpedo_6` |
| EquipTurbine | `equip_turbine` .. `equip_turbine_4` |
| BucketRepair | `bucket_repair` |
| DeskItemBook | `desk_item_book` |
| DeskItemRadar | `desk_item_radar` |
| InstantConMat | `instant_con_mat` |
| KaitaiHammer | `kaitai_hammer` |
| MarriageRing | `marriage_ring` |
| ModernKit | `modern_kit` |
| OwnerPaper | `owner_paper` |
| OPTool | `op_tool` |
| PointerItem | `pointer_item` |
| RecipePaper | `recipe_paper` |
| RepairGoddess | `repair_goddess` |
| TargetWrench | `target_wrench` |
| ToyAirplane | `toy_airplane` |
| TrainingBook | `training_book` |

## エンティティ

`ShipClassRegistry` に集約: `ID.ShipClass` 数値 ↔ snake_case 名。
Mob 亜種は `<base>_mob` (classId + 2000)。mounts/projectiles/summons は
`MISC_NAME_MAP` (mount_airfield, abyss_missile, rensouhou, ...)。

## サウンド

旧名は既に小文字 (`ship-idle` 等)。そのまま使用。カスタム艦音声
(`ship-<type>-<id>`) は再生時に `SoundEvent.createVariableRangeEvent` で動的解決。

## パーティクル

`S2CSpawnParticle` の旧 particle ID → `particle<N>` は廃止し、用途名で登録
(Phase 7 で provider 実装): 下記 `ModParticles` 参照。

# ShinColle 1.21.1 / NeoForge 移植実装手順書

- 対象リポジトリ: `/home/safaid_yuragi/develop/ShinColle-1.21.1`（現ブランチ `mc-1.12.2`）
- 対象 MOD: Shinkeiseikan Collection (modid: `shincolle`, 作者 PinkaLulan, MIT License)
- ゴール: MC 1.12.2 / Forge 14.23.2.2615 の実装を MC 1.21.1 / NeoForge 21.1.x に移植する
- この文書の用途: 移植作業のタスク分解と実装手順の基準。以後この文書に沿って書き換えていく

> コード例は NeoForge 21.1.x（MC 1.21.1）の API に基づく。マイナーバージョンで細部が変わる可能性があるため、実装時は IDE の補完と NeoForge 公式 Javadoc で必ず確認する。
> 作業時間の見積りはこの文書には書かない（相対的な作業量の大小のみ記載）。

---

## 0. 前提ツールチェーン（確定版）

| 項目 | 1.12.2（現状） | 1.21.1（移植先） |
|---|---|---|
| Minecraft | 1.12.2 | 1.21.1 |
| Mod Loader | Forge 14.23.2.2615 | NeoForge 21.1.250 以降（21.1.x の最新） |
| ビルドプラグイン | ForgeGradle 2.3-SNAPSHOT | ModDevGradle `net.neoforged.moddev` 2.0.147 |
| Gradle | 2.14（wrapper 同梱） | 8.10 以降（wrapper を差し替え） |
| Java | 8 | 21（toolchain で指定） |
| マッピング | MCP `snapshot_20171003` | Mojang official + Parchment `1.21.1 / 2024.11.17` |
| MOD メタデータ | `src/main/resources/mcmod.info` | `src/main/resources/META-INF/neoforge.mods.toml` + `pack.mcmeta` |
| リソース | `assets/shincolle/...` のみ | `assets/shincolle/...`（表示）+ `data/shincolle/...`（レシピ/ルート/ワールド生成/タグ） |

---

## 1. 現状分析

### 1.1 規模

- Java: **483 ファイル / 約 163,000 行**
- リソース: **566 ファイル**（`.ogg` 174、レシピ JSON 83、item モデル 73、block モデル 12、blockstate 17、lang 4、GUI テクスチャ多数）
- パッケージ別:

| パッケージ | ファイル数 | 行数 | 内容 |
|---|---:|---:|---|
| client/ | 130 | 73,346 | 描画・GUI・モデル・パーティクル（最大） |
| entity/ | 109 | 27,072 | 船 64・マウント 8・召喚 10・投射物 4・アイテム 1 |
| utility/ | 25 | 17,095 | NBT/パケット/座標/計算ヘルパー |
| handler/ | 42 | 6,874 | 状態・AI・攻撃・音・パケット・GUI 仲介 |
| item/ | 42 | 6,450 | 35 アイテム |
| ai/ | 23 | 4,932 | EntityAIBase 派生 17 + 独自パスファインダ |
| tileentity/ | 15 | 4,720 | 8 ブロックエンティティ |
| reference/ | 11 | 3,849 | ID 定数・列挙・データクラス |
| network/ | 6 | 3,538 | SimpleNetworkWrapper パケット 6 種 |
| block/ | 28 | 2,711 | 17 ブロック |
| capability/ | 8 | 2,425 | 提督（プレイヤー）データ + インベントリ拡張 |
| crafting/ | 6 | 2,113 | レシピ計算 + Java レシピ 1 |
| proxy/ | 4 | 1,398 | Common/Client/Server プロキシ |
| init/ | 8 | 1,262 | 登録ハブ |
| config/ | 6 | 863 | 独自 INI 3 種 + ConfigGui |
| playerskill/ | 1 | 643 | 騎乗/モーフ船のスキル |
| worldgen/ | 3 | 400 | 鉱石・砂利生成 + チェストルート注入 |
| その他 | 6 | ~600 | command 9 / server 3 / team 1 / creativetab 1 / intermod 1 ほか |

### 1.2 登録コンテンツ（移植カタログ）

| 種別 | 数 | 登録元 | 備考 |
|---|---:|---|---|
| ブロック | 17 | `init/ModBlocks.java` | BE 持ち 7 種（Crane/Desk/SmallShipyard/VolCore/Waypoint/GrudgeHeavy/Polymetal）、LightAir/LightLiquid は BlockAir/BlockStaticLiquid 派生 |
| アイテム | 35 | `init/ModItems.java` | Equip 系 13、SpawnEgg、素材 4、道具 16、おもちゃ 1 |
| アイテムブロック | 17 | 同上 | `BasicItemBlock` / `ItemBlockResourceBlock` / `ItemBlockWaypoint` / `ItemBlockGrudgeHeavy` |
| ブロックエンティティ | 8 | `ModBlocks` | `GameRegistry.registerTileEntity` |
| エンティティ | 87 | `init/ModEntity.java` | **現在 `ModEntity.init()` はどこからも呼ばれていない（実質未登録）** |
| サウンド | 53 固定 + 動的 | `init/ModSounds.java` | 動的は `ConfigSound.SOUNDRATE` から生成 |
| パーティクル | 20（登録なし） | `S2CSpawnParticle` パケット駆動 | 1.21 では ParticleType 登録が必要 |
| GUI | 10 画面 / コンテナ | `handler/GuiHandler.java`（`IGuiHandler`） | GUI ID は `reference/ID.Gui` (0〜9) |
| モデル（Java） | 68 | `client/model/` | 全て `ModelBase`/`ModelRenderer`。`.obj` は不使用 |
| レシピ | 83 JSON + 1 Java | `assets/shincolle/recipes/` + `ModRecipes` | 全て `forge:ore_shaped` 形式、39 ファイルが `forge:ore_dict` 使用 |
| ワールド生成 | 鉱石・砂利 | `worldgen/ShinColleWorldGen.java` | `IWorldGenerator`。海洋バイオーム判定に `BiomeDictionary` |
| Java レシピ | 1 | `RecipeEnchantShell`（ポーション弾生成・動的レシピ） | `IForgeRegistryEntry.Impl<IRecipe>` |
| コマンド | 9 | `handler/CommandHandler` | `CommandBase` 派生 |

### 1.3 依存・連携 MOD

| 連携 | 実装 | 1.21.1 での扱い（推奨） |
|---|---|---|
| **Metamorph**（変身 MOD） | `intermod/MetamorphHelper.java`、`EventHandler` の MorphEvent、`IShipMorph`、Morph GUI、morph アイテム 3 種 | **削除**（1.21.1 に Metamorph は存在しない）。関連コード・GUI・アイテム・パケットを全削除 |
| Baubles（指輪スロット） | `MarriageRing implements IBauble`、`InventoryHelper` の Baubles 分岐 | **Curios** へ置換（任意・後回し可）。無ければインベントリ内所持判定にフォールバック |
| IC2 | `CommonProxy.checkModLoaded()` のフラグのみ | 削除（または任意連携として後回し） |
| Optifine | フラグのみ | 削除 |
| Gendustry（ビー） | ルートの `intermod/gendustry/*.cfg`（jar 同梱物、コード無し） | 移植対象外（そのまま放置 or 削除） |
| `debugMod/metamorph-1.1.4-1.12.1.jar` | build.gradle の依存 | 削除 |

**OreDictionary（`init/ModOres.java` ほか 6 ファイル）→ アイテムタグ（`c:` 優先）へ全面置換。**

### 1.4 既知の破損箇所（重要：ベースライン問題）

現在の `mc-1.12.2` ブランチの先頭は **1.12.2 でもコンパイルが通らない**（未完成リファクタの途中）。

- `StateFlag` / `StateMinor` / `StateTimer` / `StateEmotion` は **宣言が存在しないのに 90 ファイルから参照**されている（`entity/BasicEntityShip.java:1043` などで `this.StateFlag[...]` を直接使用）。
- `BasicEntityShip.attackEntityAsMob`（:1322）と `attackEntityFrom`（:1329）は `//TODO AttackHandler` のスタブで戻り値なし。
- 新しいハンドラ層（`handler/AIHandler.java` `handler/AttackHandler.java` `handler/StateHandler.java` など）が未完成で、`this.world` 等の未定義参照を含む。
- 直近コミット: `a576df7 Rewrite attack methods...`（この作業の途中）。**攻撃リファクタ着手前の動作版は `f2f300a`（マージコミット）付近**。

→ **移植を始める前に「ベースライン方針」を確定すること（Phase 0 の最重要タスク）。**

### 1.5 レガシー API の使用量（機械的置換の規模感）

| API | 参照ファイル数 | 置換先 |
|---|---:|---|
| `GlStateManager` | 105 | `PoseStack` / `MultiBufferSource` / `RenderType` |
| `EntityPlayer` | 119 | `Player` / `ServerPlayer` |
| `ItemStack`（NBT 含む） | 108 | `ItemStack` + `DataComponents` |
| `MathHelper` | 95 | `Mth` |
| `ModelBase`（Techne 系モデル） | 75 | `ModelPart` / `LayerDefinition` |
| `EntityLivingBase` | 64 | `LivingEntity` |
| `Capability` 系 | 51 | `Capabilities` + `AttachmentType` |
| `NBTTagCompound` 系 | 49 | `CompoundTag` |
| `net.minecraftforge.*` | 163 | `net.neoforged.*` |
| `IBlockState` | 31 | `BlockState` |
| `EnumFacing` | 30 | `Direction` |
| `IInventory` | 26 | `IItemHandler` / `Container` |
| `FML` | 19 | NeoForge イベント |
| `getTagCompound` | 18 | `DataComponents` / `CustomData` |
| `EntityAIBase` | 15 | `Goal` |
| `SharedMonsterAttributes` | 14 | `Attributes` |
| `GameRegistry` | 3 | `DeferredRegister` |
| `SimpleNetworkWrapper` | 1（CommonProxy に集約） | `RegisterPayloadHandlersEvent` |
| `IWorldGenerator` / `LootTableList` / `OreDictionary` / `WorldSavedData` | 各 1〜6 | BiomeModifier / LootModifier / タグ / `SavedData` |

※ `ObfuscationReflectionHelper`・`@ObjectHolder`・Mixin・Coremod・ASM は **不使用**（移植の追い風）。

---

## 2. 移植方針

### 2.1 戦略の選択肢と推奨

| 案 | 内容 | 評価 |
|---|---|---|
| A. 直接移植 | 1.12.2 → 1.21.1 へ一気に書換 | **推奨**。描画/モデル/AI/ネットワークの主要 API は 1.13〜1.21 で何度も変わっており、中間バージョンを挟んでも作り直しになる。二度手間を避ける |
| B. 段階移植 | 1.16.5 → 1.18.2 → 1.21.1 | 不採用。中間版でも `ModelBase` 廃止・Goal 化・パケット刷新は発生し、作業量がほぼ倍増する |
| C. 再構築 | 設計とデータのみ引き継ぎ新規 MOD として書く | 部分的に採用。**描画層・AI 層・ネットワーク層は実質 C**（下記原則） |

### 2.2 基本原則

1. **残すもの**: ゲームデザイン、数値テーブル（`Values` / `Attrs` / `ID` の ID 体系）、アセット（テクスチャ/サウンド）、レシピ内容、モデルの形状データ、言語テキスト。
2. **書き直すもの**: 登録、データ保存/同期、AI、パス探索、描画、GUI、レシピ型。これらは「移行」ではなく 1.21.1 API での**再実装**とする。
3. **命名を正規化する**: 1.21 の `ResourceLocation` は `[a-z0-9_.-]` のみ。`ShinColle:Grudge` のような大文字名は不可。
   - 例: `Grudge` → `shincolle:grudge`、`AbyssMetal` → `shincolle:abyss_metal`、`ShipSpawnEgg` → `shincolle:ship_spawn_egg`
   - これに伴い **lang キー・モデル/blockstate ファイル名・レシピ JSON も全て新名に合わせる**（対応表を Phase 1 で作る）。
4. **旧ワールドデータの互換は目標にしない**（NBT キーが全滅するため）。移行は「新規ワールド前提」と明記する。設定ファイル（INI 3 種）はパーサごと流用可能。
5. **ハンドラ層の設計意図（entity/handler 分離）は引き継ぐ**が、実装は 1.21 API で書き直す。

### 2.3 移植対象外（削るもの）

- Metamorph 連携一式: `intermod/MetamorphHelper.java`、`IShipMorph`、`GuiMorphInventory`/`ContainerMorphInventory`、`ModernKit`/`TrainingBook`/`MarriageRing` のモーフ処理、MorphEvent ハンドラ、`ID.Gui.MORPHINVENTORY`、関連パケット PID
- IC2 / Optifine フラグ、gendustry 同梱 cfg
- `ConfigGui` / `ConfigGuiFactory`（NeoForge は Config 画面を自動生成する）
- `@SideOnly` 前提のプロキシ分岐（`@EventBusSubscriber(Dist.CLIENT)` とイベントクラス分離に置換）

### 2.4 パッケージ再編案

```
com.lulan.shincolle
├── ShinColle.java                … @Mod エントリ（IEventBus/ModContainer 注入）
├── registry/                     … 旧 init/ + 新規登録（DeferredRegister 群）
│   ├── ModBlocks / ModItems / ModBlockEntities / ModEntities / ModSounds
│   ├── ModParticles / ModComponents / ModTabs / ModMenus / ModDamageTypes
│   ├── ModAttachments / ModCapabilities / ModRecipeTypes
├── config/                       … ShinColleConfig(ModConfigSpec) + ShipSoundConfig/LootConfig/MiningConfig(INI 流用)
├── entity/                       … 既存構成を維持（base/ sub はそのまま）
│   └── ai/                       … 旧 com.lulan.shincolle.ai（Goal 化）
├── client/                       … 既存構成を維持
│   ├── model/                    … LayerDefinition 化したモデル
│   ├── render/                   … EntityRenderer / BlockEntityRenderer / layers
│   ├── gui/                      … AbstractContainerScreen 化
│   └── particle/                 … Particle / SingleQuadParticle 化
├── network/                      … CustomPacketPayload 群（旧 6 クラスを機能単位に分割）
├── capability/                   … Attachment 化した提督データ + インベントリ拡張
└── ...
```

---

## 3. 1.12.2 → 1.21.1 API 対応表

### 3.1 起動・ライフサイクル・イベント

| 1.12.2 | 1.21.1 NeoForge |
|---|---|
| `@Mod(modid=…, guiFactory=…)` + `@Mod.Instance` + `@SidedProxy` | `@Mod(MOD_ID)` クラス + コンストラクタ注入 `(IEventBus modBus, ModContainer container)` |
| `preInit(FMLPreInitializationEvent)` | `FMLCommonSetupEvent`（mod バス）/ コンストラクタ内で登録 |
| `init(FMLInitializationEvent)` | `FMLCommonSetupEvent` / `RegisterPayloadHandlersEvent` など個別イベント |
| `postInit(FMLPostInitializationEvent)` | `FMLLoadCompleteEvent` |
| `onServerStarting(FMLServerStartingEvent)` | `RegisterCommandsEvent`（ゲームバス） |
| `MinecraftForge.EVENT_BUS.register(...)` | `@EventBusSubscriber`（既定=ゲームバス）または `NeoForge.EVENT_BUS.register` |
| `@SideOnly(Side.CLIENT)` | `@OnlyIn(Dist.CLIENT)` / `@EventBusSubscriber(value = Dist.CLIENT, …)` / クラス分離 |
| `FMLCommonHandler.instance().getMinecraftServerInstance()` | `ServerLifecycleHooks.getCurrentServer()` / `event.getServer()` |
| `@Mod.EventHandler` | 各イベントの `@SubscribeEvent` |

主なイベント改名（`handler/EventHandler.java` の 1,380 行が対象）:

| 旧イベント | 新イベント |
|---|---|
| `RegistryEvent.Register<T>` | `DeferredRegister` + `RegisterEvent`（必要な場合のみ） |
| `LivingDropsEvent` | `LivingDropsEvent`（`event.getDrops()` は `List<ItemEntity>` のまま、`LootContext` 取得方法が変化） |
| `LivingHurtEvent` / `LivingAttackEvent` | `LivingIncomingDamageEvent`（NeoForge） |
| `PlayerEvent.Clone` | `PlayerEvent.Clone`（`isWasDeath` など） |
| `PlayerEvent.SaveToFile` | `PlayerEvent.SaveData` |
| `TickEvent.PlayerTickEvent` | `PlayerTickEvent.Post` |
| `TickEvent.ServerTickEvent` | `ServerTickEvent.Post` |
| `TickEvent.RenderTickEvent` | `RenderFrameEvent`（クライアント） |
| `WorldEvent.Load/Unload` | `LevelEvent.Load/Unload` |
| `EntityEvent.EnteringChunk` | `EntityEvent.EnteringChunk`（継続） |
| `RenderGameOverlayEvent.Pre` | `CustomizeGuiOverlayEvent` / `RegisterGuiLayersEvent`（HUD レイヤ描画） |
| `EntityViewRenderEvent.FogDensity` | `ViewportEvent.RenderFog` + `ComputeFogColor` |
| `RenderSpecificHandEvent` | `RenderHandEvent` |
| `InputEvent` | `InputEvent` / `ClientTickEvent.Post` + `KeyMapping` |
| `ConfigChangedEvent.OnConfigChangedEvent` | `ModConfigEvent.Reloading` / `ModConfigEvent.Loading` |
| `LootTableLoadEvent` | `LootTableLoadEvent`（NeoForge）/ `LootModifier` |
| `AnvilUpdateEvent` | `AnvilUpdateEvent`（継続） |
| `ForgeChunkManager.setForcedChunkLoadingCallback` | `TicketController` + `RegisterTicketControllersEvent`（NeoForge 1.21.1 のチケット API） |

### 3.2 登録

| 1.12.2 | 1.21.1 |
|---|---|
| `RegistryEvent.Register<Block/Item/SoundEvent>` | `DeferredRegister.Blocks` / `DeferredRegister.Items` / `DeferredRegister<SoundEvent>` |
| `GameRegistry.registerTileEntity(cls, name)` | `DeferredRegister<BlockEntityType<?>>` + `EntityBlock#newBlockEntity` |
| `EntityRegistry.registerModEntity(...)` | `DeferredRegister<EntityType<?>>` + `EntityType.Builder.of(...).sized().clientTrackingRange().updateInterval().build(name)` |
| `EntityRegistry.addSpawn(...)` | `SpawnPlacements.register(...)` + BiomeModifier `neoforge:add_spawns` |
| `new CreativeTabs("shincolle")` | `DeferredRegister<CreativeModeTab>` + `CreativeModeTab.builder()` |
| `GameRegistry.registerWorldGenerator` | `data/shincolle/neoforge/biome_modifier/*.json` + configured/placed feature JSON |
| `RegistryEvent.Register<IRecipe>` + `IForgeRegistryEntry.Impl` | `RecipeType` / `RecipeSerializer` の DeferredRegister + `Codec`/`MapCodec` |
| `OreDictionary.registerOre` | アイテムタグ `data/shincolle/tags/item/*.json`（`c:` 共通タグ優先） |
| パーティクル（未登録） | `DeferredRegister<ParticleType<?>>` + `SimpleParticleType` |

### 3.3 データ・NBT・同期

| 1.12.2 | 1.21.1 |
|---|---|
| `NBTTagCompound` / `NBTTagList` / `NBTBase` | `CompoundTag` / `ListTag` / `Tag`（取得は `getInt` 等、生成は `putInt` 等） |
| `ItemStack#getTagCompound/setTagCompound` | `DataComponents`（バニラ）+ `CustomData` / 独自 `DataComponentType` |
| 独自メタ（`setItemDamage/getMetadata`） | 別アイテム or 独自 DataComponent（1.21 にメタデータは無い） |
| ポーション NBT | `DataComponents.POTION_CONTENTS`（`PotionContents`） |
| `EntityDataManager` + `DataParameter`（この MOD は未使用・独自 EnumMap+パケット） | `SynchedEntityData` + `EntityDataAccessor<T>`（採用推奨。§6 D1 参照） |
| `TileEntity#writeToNBT/readFromNBT` | `saveAdditional(CompoundTag, HolderLookup.Provider)` / `loadAdditional(...)`（`ValueInput/ValueOutput` + Codec も可） |
| `TileEntity#getUpdatePacket/getUpdateTag` | 同名メソッドが `BlockEntity` に存在（`ClientboundBlockEntityDataPacket.create(this)`） |
| `markDirty()` | `setChanged()` |
| `WorldSavedData` + `MapStorage` | `SavedData` + `ServerLevel#getDataStorage()` / `SavedData.Factory` |
| `ItemStack.getTagCompound` でのカスタム弾データ | 独自 DataComponent（`AmmoType`/`PotionList` 等） |
| `InventoryCrafting` の偽装 | `CraftingInput` / `RecipeInput`（1.21 の入力レコード） |

### 3.4 エンティティ・AI・戦闘

| 1.12.2 | 1.21.1 |
|---|---|
| `EntityTameable` / `EntityCreature` / `EntityMob` / `EntityLiving` / `EntityLivingBase` | `TamableAnimal` / `PathfinderMob` / `Monster` / `LivingEntity` |
| `applyEntityAttributes()` / `SharedMonsterAttributes` / `IAttribute` | `createAttributes()` 静的メソッド + `EntityAttributeCreationEvent` + `Attributes.*` |
| `EntityAttributeModifier` | `AttributeModifier(ResourceLocation, double, Operation)` |
| `RangedAttribute` 独自登録（`generic.maxHealth` 差替え） | 廃止。`Attributes.MAX_HEALTH` をそのまま使う |
| `EntityAIBase` / `EntityAITasks#addTask` / `setMutexBits` | `Goal` / `GoalSelector#addGoal` / `EnumSet<Goal.Flag>` |
| `shouldExecute` / `shouldContinueExecuting` / `startExecuting` / `updateTask` / `resetTask` | `canUse` / `canContinueToUse` / `start` / `tick` / `stop` |
| `EntityAITarget` | `TargetGoal` |
| `PathNavigate` / `PathNavigateGround` 派生 | `PathNavigation` / `GroundPathNavigation` / `FlyingPathNavigation` / `AmphibiousPathNavigation` |
| 独自 `ShipPath`/`ShipPathPoint`/`ShipPathHeap`/`ShipPathFinder` | `Path` / `Node` / `BinaryHeap` / `PathFinder` + 独自 `NodeEvaluator` |
| `EntityMoveHelper`（独自 `ShipMoveHelper`） | `MoveControl` 派生 |
| `RandomPositionGenerator` | `net.minecraft.world.entity.ai.util.RandomPos` |
| `getLookHelper/getJumpHelper/getNavigator/getEntitySenses` | `getLookControl/getJumpControl/getNavigation/getSensing` |
| `attackEntityAsMob` / `attackEntityFrom` | `doHurtTarget(Entity)` / `hurt(DamageSource, float)` |
| `DamageSource` 定数（`DamageSource.magic` 等） | `damageSources()`（`DamageSources.mobAttack(this)` 等）。独自ダメージ型は `data/shincolle/damage_type/*.json` |
| `applyPlayerInteraction(...EnumHand) → EnumActionResult` | `mobInteract(Player, InteractionHand) → InteractionResult` |
| 複数部位エンティティ（`EntityDragonPart` 相当） | `EnderDragonPart` 相当はバニラ非公開。**自前の `EntityPart` 実装が必要**（使用箇所を Phase 3 で洗い出す） |
| `getMountedYOffset` / `dismountEntity` | `getPassengerAttachmentPoint(...)` / `positionRider(...)` / `Entity#stopRiding` |
| `posX/posY/posZ/motionX/…` | `getX()/getY()/getZ()` / `position()` / `getDeltaMovement()` / `setDeltaMovement()` |
| `world` / `worldObj` | `level()` |
| `setDead()` / `isDead` | `discard()` / `isRemoved()` |
| `getEntityBoundingBox()` / `AxisAlignedBB` | `getBoundingBox()` / `AABB` |
| `world.getEntitiesWithinAABB(...)` | `level.getEntitiesOfClass(Class, AABB, Predicate)` |
| `world.spawnEntity(e)` | `level.addFreshEntity(e)` |
| `EnumParticleTypes` + `spawnParticle(...)` | `ParticleTypes` / 独自 `ParticleType` + `ServerLevel#sendParticles(...)` |
| `EntityXPOrb` | `ExperienceOrb` |
| `getRNG()` | `getRandom()`（`RandomSource`） |
| `isRiding()` / `getRidingEntity()` | `isPassenger()` / `getVehicle()` |
| `EntityPlayerMP` | `ServerPlayer` |

### 3.5 ネットワーク

| 1.12.2 | 1.21.1 |
|---|---|
| `SimpleNetworkWrapper` + `IMessage`/`IMessageHandler` | `CustomPacketPayload`（record）+ `StreamCodec` |
| `NetworkRegistry.newSimpleChannel`（4 チャンネル） | `RegisterPayloadHandlersEvent` の `PayloadRegistrar`（バージョン文字列 1 本に集約） |
| `channel.sendTo(msg, player)` | `PacketDistributor.sendToPlayer(player, payload)` |
| `channel.sendToAllAround(msg, TargetPoint)` | `PacketDistributor.sendToPlayersNear(level, exclude, x, y, z, radius, payload)` |
| `MessageContext.getServerHandler().player` / `Minecraft.addScheduledTask` | `IPayloadContext.player()` / `context.enqueueWork(...)` |
| `ByteBuf` 手書き read/write | `ByteBufCodecs.*` + `StreamCodec.composite(...)` |
| 数値 PID（`ID.Packets`）と 1 クラス内 PID 分岐（700 行超） | **ペイロード型ごとに 1 クラス**へ分割（20〜40 個程度） |

### 3.6 GUI・コンテナ

| 1.12.2 | 1.21.1 |
|---|---|
| `IGuiHandler` + `NetworkRegistry.registerGuiHandler` | `MenuType<T>` + `MenuProvider` + `player.openMenu(provider, buf -> …)` |
| `FMLNetworkHandler.openGui` / `player.openGui` | 同上（サーバ側で `openMenu`） |
| `Container` + `IContainerListener`/`sendProgressBarUpdate` | `AbstractContainerMenu` + `ContainerData`（`addDataSlots`） |
| `GuiContainer` + `drawGuiContainerBackgroundLayer` | `AbstractContainerScreen<T>` + `renderBg(GuiGraphics, float, int, int)` |
| `drawTexturedModalRect` | `GuiGraphics#blit(...)` |
| `fontRendererObj` | `this.font` / `graphics.drawString(font, …)` |
| `renderToolTip` / `drawHoveringText` | `graphics.renderTooltip(font, …)` / `renderComponentTooltip` |
| `GuiButton` / `GuiTextField` | `Button` / `EditBox`（`Widget` 体系） |
| `mouseClicked(int,int,int)` / `keyTyped(char,int)` | `mouseClicked(double,double,int)` / `keyPressed(int,int,int)` |
| `RenderManager.doRenderEntity`（GUI 内モデル表示） | `EntityRenderDispatcher` / `InventoryScreen.renderEntityInInventoryFollowsMouse(...)` |
| `GuiConfig` / `IModGuiFactory` | 不要（NeoForge の Config 画面） |

### 3.7 描画・モデル・パーティクル

| 1.12.2 | 1.21.1 |
|---|---|
| `ModelBase` / `ModelRenderer`（68 ファイル） | `ModelPart` + `LayerDefinition` + `MeshDefinition`/`PartDefinition`/`CubeListBuilder` |
| `ModelRenderer#addBox/rotateAngleX/setRotationPoint` | `CubeListBuilder#texOffs().addBox()` / `PartPose.offsetAndRotation()` |
| `setRotationAngles(...)` | `setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)` |
| `RenderLivingBase` / `Render<T>` + `doRender` | `EntityRenderer<T>` + `render(T, float, PoseStack, MultiBufferSource, int light)` + `getTextureLocation(T)` |
| `IRenderFactory` + `RenderingRegistry.registerEntityRenderingHandler` | `EntityRenderersEvent.RegisterRenderers`（`context` から `bakeLayer`） |
| `LayerRenderer<T>` | `RenderLayer<T, M>` + `addLayer` |
| `TileEntitySpecialRenderer` | `BlockEntityRenderer<T>` + `BlockEntityRendererProvider<T>` |
| `TileEntityItemStackRenderer.instance`（グローバル差替え） | `IClientItemExtensions#getCustomRenderer` + `BlockEntityWithoutLevelRenderer` |
| `GlStateManager` / `OpenGlHelper` / `GL11` | `PoseStack` / `MultiBufferSource` / `VertexConsumer` / `RenderType` / `com.mojang.blaze3d` |
| `Tessellator` / `VertexBuffer`（即時モード） | `VertexConsumer` への直接書き込み（`RenderType` は描画タイプ指定のみ） |
| `getBlockLayer()`（`BlockRenderLayer`） | `ItemBlockRenderTypes.setRenderLayer(block, RenderType.…)`（クライアントセットアップ） |
| `EnumBlockRenderType` | `RenderShape` |
| `Particle#renderParticle(VertexBuffer, …)` / `getFXLayer()=3` | `Particle#render(VertexConsumer, Camera, float)` / `SingleQuadParticle` 派生 + `getRenderType()` |
| `Minecraft.getMinecraft().effectRenderer.addEffect` | `Minecraft.getInstance().particleEngine` / `ClientLevel#addParticle` |
| `RenderManager` | `EntityRenderDispatcher` |
| `RenderGameOverlayEvent`（HUD） | `RegisterGuiLayersEvent` + `LayeredDraw.Layer` |
| `Minecraft.getMinecraft().gameSettings.keyBind*` | `Minecraft.getInstance().options.key*` |
| `org.lwjgl.input.Keyboard/Mouse`（LWJGL2 ポーリング） | `KeyMapping` + `InputEvent`/`ClientTickEvent`（GLFW） |
| `ScaledResolution` | `GuiGraphics` の論理解像度（`guiWidth/guiHeight`） |

### 3.8 その他

| 1.12.2 | 1.21.1 |
|---|---|
| `CommandBase` + `ICommandSender` + `event.registerServerCommand` | `Command`（Brigadier）+ `CommandSourceStack` + `RegisterCommandsEvent` |
| `ITextComponent` / `StringTextComponent` / `TextComponentTranslation` | `Component.literal` / `Component.translatable` |
| `I18n.format` | `Component.translatable` |
| `EnumFacing` / `EnumHand` | `Direction` / `InteractionHand` |
| `IBlockState` / `Material` | `BlockState` / `BlockBehaviour.Properties` |
| `MathHelper` | `Mth` |
| `Vec3d` / `BlockPos` | `Vec3` / `BlockPos`（同名） |
| `ItemSword/ItemTool/ItemArmor`（この MOD は未使用） | 参考: `Item.Properties#sword/tool` + `ToolMaterial`/`ArmorMaterial`（今回は不要） |
| `FMLLog` / log4j 直呼び | `org.slf4j.Logger` |
| `ForgeEventFactory.getExperienceDrop` | `LivingExperienceDropEvent` など NeoForge イベント |
| `BiomeDictionary` | バイオームタグ（`#c:is_ocean`, `#minecraft:is_ocean` 等） |
| `EntityRegistry.addSpawn` + `EnumCreatureType` | `SpawnPlacements` + `MobCategory` + BiomeModifier |

---

## 4. フェーズ計画（実装手順）

依存関係の目安:

```
Phase 0 ─ Phase 1 ─┬─ Phase 2 ─ Phase 3 ─┬─ Phase 4 ──┐
                   │                     ├─ Phase 5 ──┼─ Phase 7 ─ Phase 9
                   └─ Phase 8 ───────────┴─ Phase 6 ──┘
```
- Phase 8（データ/リソース）は Phase 1 完了後いつでも並行可。
- Phase 7（描画）は Phase 2 + Phase 5 の完了後。モデル変換だけ先に進めても良い。

---

### Phase 0: 準備とベースライン確定

**目的**: 1.21.1 のビルドが通って起動できる空 MOD を用意し、移植の基準点を決める。

**手順**:
- [ ] **0-1. ベースライン判断**（最重要）
  - 推奨: 現在の tip（`a576df7`）はコンパイル不能なため、**参照実装は攻撃リファクタ前の `f2f300a` のコード**とする。ただし新ハンドラ層（`handler/` の State/Attack/AI/Move/Packet/Sound/Particle ハンドラ）の**設計方針は引き継ぐ**（1.21 でも役に立つ分離だから）。
  - 作業ツリーの 1.12.2 コードを修正する投資はしない（1.21 で全て書き直すため）。
- [ ] **0-2. ブランチ作成**: `mc-1.12.2` を保持したまま `mc-1.21.1-neoforge` を作成。
- [ ] **0-3. ビルド環境差し替え**: `build.gradle` / `gradle.properties` / `settings.gradle` / `gradle/wrapper/*` を ModDevGradle 構成へ（付録 A 参照）。`debugMod/metamorph*.jar` 依存と ForgeGradle 記述を削除。
- [ ] **0-4. メタデータ追加**: `src/main/resources/META-INF/neoforge.mods.toml`、`src/main/resources/pack.mcmeta`。`mcmod.info` は削除。
- [ ] **0-5. 一時的なディレクトリ退避**: 旧 `src/main/java/...` を丸ごと残しつつ、`@Mod` クラスだけ新規に書き直して `runClient` / `runServer` が起動することを確認。
- [ ] **0-6. IDE 設定**: IntelliJ の Gradle JVM 21、パッケージ構造置換（`net.minecraftforge.*` → `net.neoforged.*`）のための構造検索プリセット作成。

**完了条件**: 空 MOD がクライアント/サーバで起動し、ログに modid `shincolle` が表示される。

---

### Phase 1: 基盤（エントリポイント・ID・設定・ユーティリティ）

**目的**: 全フェーズが乗る土台を作る。

**手順**:
- [ ] **1-1. メインクラス**: `ShinColle.java` を NeoForge 形式へ（付録 B-1）。`@Mod(MOD_ID)` + コンストラクタで DeferredRegister を登録し、`FMLCommonSetupEvent` で共通初期化。
- [ ] **1-2. プロキシ解体**: `IProxy`/`ClientProxy`/`ServerProxy` を廃止。
  - クライアント専用処理 → `client/ClientSetup.java`（`@EventBusSubscriber(Dist.CLIENT)`）等へ
  - サーバグローバル状態（`ServerProxy` の `ShinWorldData`/キャッシュ）→ `SavedData`（Phase 3）へ
- [ ] **1-3. 定数整理**: `reference/Reference.java` のリソースパス定数を整理（`= ResourceLocation.fromNamespaceAndPath("shincolle", "…")`）。`ID.java` は「数値 ID テーブル」として維持しつつ、以下を新設:
  - `ShipClassRegistry`: 旧 `ID.ShipClass`（short 0〜84）↔ `EntityType` ↔ 登録名（snake_case）の対応表
  - `registryNameOf(Class)` ヘルパー（旧 `ID.NameMap` の置換）
- [ ] **1-4. ロギング**: `LogHelper` → `org.slf4j.LoggerFactory.getLogger()` に置換（`ConfigHandler.debugMode` 連動は維持）。
- [ ] **1-5. Config 移植**:
  - `handler/ConfigHandler` の 91 項目 → `config/ShinColleConfig.java`（`ModConfigSpec`、`Type.COMMON` + `Type.CLIENT` 分割）。定義例は付録 B-9。
  - 独自 INI 3 種（`ConfigSound` / `ConfigLoot` / `ConfigMining`）は `BasicShipConfig` のパーサごと流用し、出力先を `config/shincolle/` に変更。
  - `ConfigGui`/`ConfigGuiFactory`/`ConfigChangedEvent` を削除。
- [ ] **1-6. テキストユーティリティ**: `CommandHelper` 等の `TextComponent*` → `Component` へ。
- [ ] **1-7. 汎用ユーティリティの下地**: `NBTHelper`（`CompoundTag` 化）、`CalcHelper`（`Mth` 化）、`LogHelper` など、依存の少ないものから片付ける。

**完了条件**: 登録以外の共通クラスがコンパイルでき、`runClient` 起動。`config/shincolle-common.toml` が生成される。

---

### Phase 2: 登録層（ブロック・アイテム・ブロックエンティティ・エンティティ型・サウンド・パーティクル）

**目的**: 全コンテンツを 1.21 のレジストリに正しく載せ、クリエイティブタブに並べる。

**手順**:
- [ ] **2-1. 命名変換表の作成**: 17 ブロック + 35 アイテム + 87 エンティティの「旧名 → 新 registry 名（snake_case）」対応表を `TO_RegistryNames.md` 等に書き出す（lang・モデル・レシピ・コマンド引数すべてが依存するため最初に確定）。
- [ ] **2-2. ブロック**: `BasicBlock` 系 7 基底を `BlockBehaviour.Properties` ベースへ。
  - `Material` → `Properties.of().mapColor(...)`、`setHardness/setResistance` → `destroyTime/explosionResistance`、`setSoundType` → `sound(...)`、`setLightLevel` → `lightLevel(state -> …)`、`setHarvestLevel` → `#minecraft:mineable/*` タグ
  - `BasicBlockMulti` の `PropertyInteger MBS` → `BlockStateProperties` か独自 `IntegerProperty`（1.21 は独自 `BlockStateProperty` 可）
  - `onBlockActivated` → `useItemOn` / `useWithoutItem`、`onBlockPlacedBy` → `setPlacedBy`、`breakBlock` → `onRemove` + `affectNeighborsAfterRemoval`
  - `getBlockLayer()` → クライアント側 `ItemBlockRenderTypes.setRenderLayer`
  - `BlockLightAir`/`BlockLightLiquid` は `lightLevel` + `EntityBlock` で再設計（旧 `BlockAir`/`BlockStaticLiquid` 継承は不可）
- [ ] **2-3. ブロックエンティティ 8 種**: `TileEntity` → `BlockEntity`、`ITileEntityProvider` → `EntityBlock`、`ITickable.update()` → `tick()`、`markDirty` → `setChanged`、`GameRegistry.registerTileEntity` → `DeferredRegister<BlockEntityType<?>>`。付録 B-7。
- [ ] **2-4. アイテム 35 種**: `Item.Properties` へ。メタデータ（`getMetadata`）は以下の方針で置換:
  - 見た目が変わるもの（`Ammo`, `Grudge`, `ShipTank`, `ShipSpawnEgg`）→ **別アイテム or 独自 DataComponent**
  - 耐久（`KaitaiHammer`）→ `DataComponents.DAMAGE` + `Properties.durability()`
  - ツールチップ → `appendHoverText(ItemStack, TooltipContext, TooltipDisplay, Consumer<Component>, TooltipFlag)`
  - 名前 → `getDescriptionId()` オーバーライド（`item.shincolle.<name>`）
  - クリエイティブタブ → `displayItems` ジェネレータ
- [ ] **2-5. クリエイティブタブ**: `CreativeModeTab` 1 個（`DeferredRegister<CreativeModeTab>`）。
- [ ] **2-6. サウンド**: `DeferredRegister<SoundEvent>` + `SoundEvent.createVariableRangeEvent(ResourceLocation)`。動的カスタムサウンド（`ConfigSound`）は「登録は固定分のみ、再生時に動的解決」の現行方式を維持。
- [ ] **2-7. パーティクル**: `DeferredRegister<ParticleType<?>>` に `SimpleParticleType` を 20 種登録。Provider 登録は Phase 7。
- [ ] **2-8. エンティティ型 87 種**: `EntityType.Builder.of(ShipCtor::new, MobCategory.…)` + `sized(w,h)` + `clientTrackingRange(10)` + `updateInterval(3)`。旧 tracking range 64 / freq 1 は 1.12 基準なので `clientTrackingRange(10)` 前後へ再調整（要検証）。登録名と数値 ID の対応は `ShipClassRegistry` に集約。
- [ ] **2-9. 属性**: `EntityAttributeCreationEvent` で 87 種分を登録（付録 B-5）。
- [ ] **2-10. スポーンエッグ**: バニラ `SpawnEggItem` はデータドリブンになり、多数の船種別エッグには不向き。**旧 `ShipSpawnEgg`（NBT で船種を持ち、右クリックでスポーン）をそのまま独自アイテムとして移植**する方針が最小コスト。見た目は `DataComponents` で分岐。
- [ ] **2-11. 自然スポーン**: `SpawnPlacements.register` + BiomeModifier JSON（`neoforge:add_spawns`）。旧コードはコメントアウト状態のため新規実装。
- [ ] **2-12. OreDictionary 置換**: `ModOres` をアイテムタグ（`data/shincolle/tags/item/*.json`）に書き換え。`c:ingots/copper` 等の共通タグを優先。`InventoryHelper` の `OreDictionary.getOreIDs()` 比較 → `ItemStack.is(TagKey)`。

**完了条件**: 起動して全ブロック/アイテムが表示され、配置/設置できる。エンティティは `/summon shincolle:<name>` で出現する（AI は未実装でよい）。

---

### Phase 3: エンティティ基盤と永続データ

**目的**: 船・マウント・召喚獣・投射物のデータ層を 1.21 で作り直す。

**手順**:
- [ ] **3-1. 状態管理（最重要設計）**: `handler/StateHandler` / `ShipStateHandler` を 1.21 で実装。
  - 推奨: **頻繁に同期するスカラー/フラグ（HP・Emotion・各種 Flag・Timer 等）は `SynchedEntityData` に載せる**（dirty tracking・パケット設計が不要になる）。巨大なリスト（編成 `BasicEntityShip[9][6]`、所持艦リスト、アイテム一覧）は従来どおり専用 S2C パケットで送る。
  - 90 ファイルが `getStateFlag(ID.F.xxx)` / `setStateMinor(...)` 形式の**アクセサ経由**で参照しているため、`StateHandler` の実装だけ差し替えれば呼び出し側は触らずに済む（この設計を活かす）。
  - `ID.F` / `ID.Attrs` / `ID.Emotion` のインデックスは**現行の数値体系を維持**し、`EntityDataAccessor` は数値インデックスから引くテーブルを用意。
- [ ] **3-2. セーブデータ**: `CapaShipSavedValues`（`"ShipExtProps"` 以下 `Minor/Display/Point/ShipFlags/Timer`）→ `ShipSaveData`（`CompoundTag`）へ移植。キー名は新設計でよい（旧ワールド互換は取らない）。
- [ ] **3-3. 基底クラス改修**（4 系統）:
  - `BasicEntityShip extends TamableAnimal`（`createAttributes` / `mobInteract` / `doHurtTarget` / `hurt` / `readAdditionalSaveData` / `addAdditionalSaveData`）
  - `BasicEntityShipHostile extends Monster`
  - `BasicEntitySummon extends PathfinderMob`
  - `BasicEntityMount extends BasicEntitySummon`
  - `BasicEntityShipCV` / `BasicEntityShipHostileCV` / `BasicEntityMountLarge` / `BasicEntityAirplane`
- [ ] **3-4. オーナー/チーム**: `TamableAnimal` の `getOwnerUUID()/setOwnerUUID()` を基準に統一。`TeamData` / `TeamHelper` / `FormationHelper` はエンティティ参照を UUID 参照へ寄せる（サーバ再起動後も解決できるように）。
- [ ] **3-5. インベントリ**: `CapaInventory(Extend)`（`ItemStackHandler` 派生）を NeoForge 版 `ItemStackHandler` に更新。`ShipInventoryHandler` のページングは維持。`getCapability` オーバーライド → `ICapabilityProvider` 実装 + `RegisterCapabilitiesEvent`（`Capabilities.ItemHandler.ENTITY` 等）。
- [ ] **3-6. 死亡・ドロップ**: 現行は「死亡アニメ後にスポーンエッグへ全 NBT を保存してドロップ」。1.21 では `dropCustomDeathLoot` / `LootTable` + スポーンエッグ化処理を併用。経験値は `LivingExperienceDropEvent`。
- [ ] **3-7. 騎乗**: `getPassengerAttachmentPoint` / `positionRider` / `getControllingPassenger` へ。複数シート（`mounts` 8 種）と、騎乗時のカメラ切替（Phase 7）。
- [ ] **3-8. リーシュ・ドア・水泳**: `isLeashed()` 等の API 名はほぼ維持。`canDespawn` は `Monster` 側の規定に合わせ再実装。
- [ ] **3-9. 投射物 4 種**: `EntityAbyssMissile` / `EntityProjectileBeam` / `EntityProjectileStatic` / `EntityShipFishingHook` を `Entity` + `Projectile` 相当へ。`EntityThrowable` は 1.21 で `ThrowableProjectile`。
- [ ] **3-10. 完了条件**: 船がスポーン・オーナー追従・騎乗・インベントリ操作・死亡ドロップまで動く。

---

### Phase 4: AI・移動・戦闘

**目的**: Goal 体系と 1.21 のパスファインダで船の頭脳を作り直す。

**手順**:
- [ ] **4-1. Goal 化（17 クラス）**: `EntityAIBase` → `Goal`。`setMutexBits` の数値 → `Goal.Flag` のマッピングは下表。

| mutex ビット（1.12） | Goal.Flag（1.21） |
|---|---|
| 1 | `MOVE` |
| 2 | `LOOK` |
| 4 | `JUMP` |
| 8 | `TARGET` |

  - 一覧: `EntityAIShipRangeAttack`(MOVE) / `…CarrierAttack`(MOVE) / `…AircraftAttack`(MOVE) / `…AttackOnCollide`(MOVE) / `…RangeTarget`(TARGET) / `…RevengeTarget`(TARGET) / `…Guarding`(MOVE) / `…FollowOwner`(MOVE) / `…Flee`(MOVE) / `…Floating`(JUMP) / `…Sit`(MOVE) / `…Wander`(MOVE) / `…OpenDoor`(なし) / `…PickItem`(MOVE) / `…LookIdle`(なし) / `…WatchClosest`(LookAtPlayerGoal へ置換) / `…SkillAttack`(なし)
- [ ] **4-2. タスク登録**: `AIHandler.setShipAI()` を `goalSelector.addGoal(prio, goal)` / `targetSelector.addGoal(prio, goal)` に。優先度の数値は現行値を流用（1〜26）。
- [ ] **4-3. パス探索の再構築（ai/path 6 ファイルは破棄）**:
  - `ShipPathNavigate` → `AmphibiousPathNavigation`（水上/陸上）または `FlyingPathNavigation`（飛行）派生の `ShipPathNavigation` に統合
  - `ShipPathFinder.getPathType` の OPEN/FLUID/BLOCKED/OPENABLE/FENCE 判定 → 独自 `NodeEvaluator`（`AmphibiousNodeEvaluator` 派生）の `getNeighbors` / `getPathType` で実装。`Material` 判定は `BlockState#isPathfindable` / `BlockTags` に置換
  - `ShipPath`/`ShipPathPoint`/`ShipPathHeap` → バニラ `Path`/`Node`/`BinaryHeap` を使用（独自実装は削除）
  - `ShipMoveHelper` → `MoveControl` 派生（`setWantedPosition` / `tick`）。上下移動（飛行・潜水・浮上）は `MoveControl` 内で `setDeltaMovement` を調整
- [ ] **4-4. ターゲット選択**: `TargetHelper` の `Selector`/`Sorter` を `getEntitiesOfClass` + `Predicate<LivingEntity>` に。`getEntitySenses().canSee` → `getSensing().hasLineOfSight`。
- [ ] **4-5. 攻撃系の完成**: `handler/AttackHandler` を完成させる（実装は未完成なので再設計を含む）。
  - 4 系統（主砲軽/主砲重/航空機/雷撃）の `AttackData` を `record` + `Codec` で定義
  - ダメージ: `damageSources().mobAttack(this)` 等。独自ダメージ種別（`ID.ShipDmgType`）は `data/shincolle/damage_type/*.json` + `DamageType` 参照に置換
  - 弾薬消費・士気・攻撃間隔（`CombatHelper.getAttackDelay`）のロジックは数値を維持
  - 既存サブクラスのオーバーライド（`EntitySubmYo` 等の雷撃、`EntityBattleshipYMT` 等の重砲）を移植
- [ ] **4-6. 視覚効果**: `ParticleHelper` の `EnumParticleTypes` → `ParticleTypes` + `ServerLevel.sendParticles`。音は `level.playSound(null, x,y,z, event, SoundSource.…)`。
- [ ] **4-7. タスク系（料理/採掘/釣り）**: `TaskHelper` の `FurnaceRecipes`/`CraftingManager`/`LootTableList` → 1.21 の `RecipeManager`（`level.getRecipeManager()`）、ルートテーブル API（`level.getServer().reloadableRegistries().getLootTable(...)`）。
- [ ] **4-8. プレイヤースキル**: `playerskill/ShipSkillHandler` を KeyMapping + 新パケットへ（Phase 5 と連携）。
- [ ] **4-9. 完了条件**: 敵味方判定・追従・ガード・攻撃・弾薬消費・タスクが動作する。

---

### Phase 5: ネットワーク

**目的**: 4 チャンネル 6 パケット（3,538 行）をペイロード体系へ全面刷新。

**手順**:
- [ ] **5-1. パケット分割設計**: 旧 PID 分岐を型ごとに分割する。

| 旧クラス | 旧 PID 例 | 新ペイロード（分割案） |
|---|---|---|
| `S2CEntitySync` | SyncShip_All/Update/Riders/Buffmap, SyncEntity_PosRot/Motion/Host/CustomData, SyncProjectile, SyncSystem_Config | `ShipSyncPayload`, `ShipRidersPayload`, `EntityPosRotPayload`, `EntityMotionPayload`, `ProjectileSyncPayload`, `SystemConfigPayload` など |
| `S2CGUIPackets` | TileSmallSY, SyncPlayerProp*, SyncGUI_ShipInv, チーム/編成 | `TileSyncPayload`, `PlayerPropSyncPayload`, `ShipInvSyncPayload`, `TeamSyncPayload`, `FormationSyncPayload` |
| `C2SGUIPackets` | ShipBtn, AddTeam, SetFormation, Desk_* | `ShipButtonPayload`, `TeamActionPayload`, `FormationActionPayload`, `DeskActionPayload` |
| `C2SInputPackets` | MountMove, MountGUI, Request_Riding, Waypoint/Chest 連携, Fluid, BuffMap | `MountInputPayload`, `OpenShipGuiPayload`, `RidingRequestPayload`, `PairingPayload`, `FluidPlacePayload` |
| `S2CReactPackets` | コマンド応答、フレア | `CommandReactPayload`, `FlarePayload` |
| `S2CSpawnParticle` | パーティクル | `SpawnParticlePayload`（20 種のパーティクル ID は `ParticleType` のレジストリ名で送る） |

- [ ] **5-2. 共通コーデック整備**: `PacketHelper`（2,013 行）の `ByteBuf` 手書きを `StreamCodec` 群に置換。
  - `StreamCodec<RegistryFriendlyByteBuf, ItemStack>`: `ItemStack.STREAM_CODEC`（1.21 で標準提供）
  - `CompoundTag`: `ByteBufCodecs.COMPOUND_TAG`
  - 配列/リスト: `ByteBufCodecs.collection(...)` / `list(...)` / `varInt` 等
- [ ] **5-3. 登録**: `RegisterPayloadHandlersEvent` で `registrar("1").playToServer(...)` / `playToClient(...)`。バージョン不一致時は接続拒否されるため、変更時は文字列を上げる運用。
- [ ] **5-4. 送信側**: `PacketDistributor.sendToPlayer` / `sendToPlayersNear` / `sendToAllPlayers`。`TargetPoint` は廃止。
- [ ] **5-5. 受信側**: `IPayloadContext#enqueueWork` でメインスレッド処理。サーバ側は `context.player()` を `ServerPlayer` にキャスト。
- [ ] **5-6. 大量同期の見直し**: 毎 tick 送っている同期は `SynchedEntityData` へ移せないか再検討（Phase 3 と連動）。

**完了条件**: 騎乗操縦・GUI 同期・チーム操作・パーティクル再生がマルチプレイで動作する。

---

### Phase 6: メニュー・GUI・コンテナ

**目的**: 10 画面 + コンテナ + スロットを 1.21 の Menu 体系で再実装。

**手順**:
- [ ] **6-1. MenuType 登録**: 10 種（SHIPINVENTORY 0 〜 MORPHINVENTORY 9 のうち **MORPH は削除** → 9 種）。`new MenuType<>(ContainerX::new, FeatureFlags.VANILLA_SET)`、追加データ（BlockPos 等）は `IMenuTypeExtension.create((id, inv, buf) -> …)`。
- [ ] **6-2. MenuProvider 化**: 旧 `IGuiHandler.getServerGuiElement/getClientGuiElement` を `MenuProvider#createMenu` + `getDisplayName` に変換。開く側は `player.openMenu(provider, buf -> buf.writeBlockPos(pos))`。`ID.Gui` の数値は `MenuType` の登録に置き換え（数値は不要）。
- [ ] **6-3. Container → AbstractContainerMenu**: `ContainerShipInventory` / `ContainerDesk` / `ContainerCrane` / `ContainerVolCore` / `ContainerSmallShipyard` / `ContainerLargeShipyard` / `ContainerFormation` / `ContainerRecipePaper`（+ 削除対象の Morph）。
  - `sendSlotContents`/`sendProgressBarUpdate` → `ContainerData`（`addDataSlots(data)`）と `slot.setChanged()` の自動同期
- [ ] **6-4. スロット**: `SlotCrane`（`SlotItemHandler` 派生）はほぼ流用可。`SlotExtend`/`SlotShipEquip` の `Slot` 派生は 1.21 でも `Slot` ベースで移植。`ContainerShipInventory` が参照している **`SlotShipInventory` が存在しない（欠落）** ので、移植前に `SlotShipEquip` との関係を整理して解消する。
- [ ] **6-5. Screen 再実装**: `AbstractContainerScreen<T>` + `GuiGraphics`。
  - `drawGuiContainerBackgroundLayer` → `renderBg`
  - `drawTexturedModalRect` → `graphics.blit(TEXTURE, x, y, u, v, w, h)`
  - `fontRendererObj` → `this.font`、`renderToolTip` → `graphics.renderTooltip`
  - `mouseClicked(int,int,int)`/`keyTyped(char,int)` → 新シグネチャ
  - `GuiDesk`（約 2,440 行）と `GuiShipInventory`（約 1,242 行）が最大の工数。**タブ構造を保ったまま 1 画面ずつ移す**
- [ ] **6-6. GUI 内モデルプレビュー**: `drawEntityModel`/`drawShipModel`/`drawTargetModel` → `EntityRenderDispatcher` を `PoseStack` + `MultiBufferSource` で呼ぶヘルパーに置換（バニラの `InventoryScreen.renderEntityInInventoryFollowsMouse` を参考にする）。
- [ ] **6-7. 入力ウィジェット**: `GuiButton` → `Button`（`Button.builder(...)`）、`GuiTextField` → `EditBox`。
- [ ] **6-8. 図鑑（GuiBook 静的ヘルパー）**: `Values.BookList` のデータは維持し、描画のみ `GuiGraphics` 化。
- [ ] **6-9. `DeskItemBook`/`DeskItemRadar`/`RecipePaper`**: `onItemRightClick` → `use` + `player.openMenu`。

**完了条件**: 全 GUI が開き、スロット操作・ボタン・タブ・スクロール・数値同期が動く。

---

### Phase 7: クライアント描画

**目的**: 68 モデル + 95 レンダラ + 20 パーティクル + HUD/カメラを 1.21 の描画パイプラインへ。

**手順**:
- [ ] **7-1. モデル基盤の新設**: `ShipModelBase`（`IModelEmotion` 実装）→ `ShipModel<T extends Entity> extends EntityModel<T>`。
  - `ModelRenderer` → `ModelPart`、`addBox` → `CubeListBuilder.texOffs(u,v).addBox(x,y,z,dx,dy,dz)`
  - `rotateAngleX/Y/Z` + `rotationPoint` → `PartPose.offsetAndRotation(x,y,z, rx,ry,rz)`
  - 可視制御 `isHidden` → `part.visible`、`childModels` → 子 `ModelPart`
  - `ShipModelRenderer.tweakModel`（GL トランスフォーム）→ `PoseStack` 操作関数へ
  - 感情表現（`IModelEmotionAdv` の顔/口/頬）は `ModelPart` の visible + テクスチャオフセット切替で表現
  - レイヤ定義の登録: `EntityRenderersEvent.RegisterLayerDefinitions` で `LayerDefinition.create(mesh, texW, texH)` を `ModelLayerLocation` に紐付け
- [ ] **7-2. 68 モデルの機械変換**（最大の作業量）:
  - 手順: (a) 代表 2〜3 体（`ModelDestroyerI`, `ModelBattleshipYMT`, `ModelCarrierAkagi`）を手作業で `MeshDefinition` 化しテンプレートを確立 → (b) Tabula/Blockbench 形式の `new ModelRenderer(this, u, v)` + `addBox` パターンを正規表現/自作スクリプトで一括変換 → (c) 全モデルを目視確認
  - 変換スクリプトは `tools/convert_models/` に置き、再実行可能にする（手直しの再現性のため）
  - `setTextureOffset(String,int,int)`/`addBox(String,...)` の名前付きパーツ（`"primary"` 等）は `PartDefinition#addOrReplaceChild(name, …)` に直接対応
- [ ] **7-3. エンティティレンダラ**: `RenderBasic`/`RenderShipEntity`/`RenderMountsEntity`/`RenderSummonEntity`/`RenderMiscEntity`/`RenderShipFishing`/`RenderBasicEntityItem` → `EntityRenderer<T>`。
  - `RenderBasic.setBrightness`（`GlStateManager.glTexEnvi` によるテクスチャ環境色合成）は **1.21 に直接の等価物がない**。`VertexConsumer#setColor` と `LightTexture`/`OverlayTexture` の使い分けに置換し、被弾時の赤点滅は「色乗算」で表現する
  - テクスチャ 70 種の `switch(textuerID)` は `ID.ShipClass` → テクスチャパス解決表に置換（`EntityType` から引く）
  - `LayerShipHeldItem` → `RenderLayer<T, ShipModel<T>>`。手持ち描画は `ItemInHandRenderer`/`ItemRenderer.renderStatic` を利用
  - リーシュ描画は `EntityRenderer#renderLeash` の新シグネチャへ
- [ ] **7-4. ブロックエンティティレンダラ 3 種**: `RenderDesk`/`RenderSmallShipyard`/`RenderLargeShipyard` → `BlockEntityRenderer<T>` + `BlockEntityRendererProvider<T>`。`RenderShape.ENTITYBLOCK_ANIMATED` 相当は `RenderShape.INVISIBLE` + BER。
- [ ] **7-5. アイテムレンダラ**: `RenderTileEntityItem`（グローバル差替え）→ `IClientItemExtensions#getCustomRenderer` で対象ブロックアイテムのみ `BlockEntityWithoutLevelRenderer` を返す。
- [ ] **7-6. パーティクル 20 種**: `Particle`/`TextureSheetParticle`/`SingleQuadParticle` 派生へ（`render(VertexConsumer, Camera, float)` + `getRenderType()`）。Provider を `RegisterParticleProvidersEvent` で登録。`GL11`/`Tessellator` の直接利用は全面削除。
- [ ] **7-7. HUD・オーバーレイ**: `RenderHelper.drawPlayerSkillIcon` → `RegisterGuiLayersEvent`（`registerAboveAll`）の `LayeredDraw.Layer`。座標は `GuiGraphics` の `guiWidth/guiHeight`。
- [ ] **7-8. カメラ・手・霧**:
  - 乗船時の視点切替（`EventHandler.onRenderTick`）→ `RenderFrameEvent`/`ViewportEvent.ComputeCameraAngles` で `Minecraft#setCameraEntity`
  - 一人称手（`PointerItem`）→ `RenderHandEvent`（キャンセルして自前描画）
  - 液体霧 → `ViewportEvent.RenderFog`
- [ ] **7-9. キー入力**: `Keyboard`/`Mouse`（LWJGL2）ポーリング → `KeyMapping`（`RegisterKeyMappingsEvent`）+ `ClientTickEvent.Post`。デバッグ用のハードコードキーは開発用キーとして `KeyMapping` 化するか削除。
- [ ] **7-10. レンダータイプ**: `ItemBlockRenderTypes.setRenderLayer` で `BlockGrudge`（translucent）/`BlockFrame`（cutout）を設定。`FMLClientSetupEvent` で実行。

**完了条件**: 船上モデル・装備・ブロック・GUI 内プレビュー・パーティクル・HUD がすべて正常描画。クリーム色の矩形（テクスチャ欠落）が残らないこと。

---

### Phase 8: データパック・リソース

**目的**: 83 レシピ・タグ・ルート・ワールド生成・言語・モデル JSON を 1.21 形式へ。

**手順**:
- [ ] **8-1. ディレクトリ移設**: `assets/shincolle/recipes/` → `data/shincolle/recipe/`。
- [ ] **8-2. レシピ変換スクリプト**: 83 ファイルを一括変換（付録 B-12 の変換規則）。
  - `"type": "forge:ore_shaped"` → `"minecraft:crafting_shaped"`（shapeless も同様）
  - `{"type":"forge:ore_dict","ore":"X"}` → `{"tag": "c:…"}`（対応表を 8-3 で作る）
  - `"item": "shincolle:Ammo", "data": 3` → 新アイテム ID（メタ廃止）
  - `"result": {"item": "…", "count": n}` → `"result": {"id": "…", "count": n}`
  - `group` は 1.21 も有効（任意）
- [ ] **8-3. タグ定義**: `data/shincolle/tags/item/*.json` を新設し、`ModOres` の 13 エントリに対応する共通タグ（`c:ingots/abyssium` など）と、レシピ入力用タグ（`c:gunpowder`, `c:ingots/copper`, `c:gems/diamond`, `c:dusts/manganese` …）を定義。NeoForge が提供する `c:` タグと重複しないよう確認。
- [ ] **8-4. Java レシピ**: `RecipeEnchantShell` → `RecipeType`/`RecipeSerializer` + `MapCodec`。動的レシピなので `SpecialRecipe` 相当（`crafting_special_*`）として実装し、`RecipeManager` から取得できるようにする。
- [ ] **8-5. ルートテーブル**: チェスト注入（`worldgen/ChestLootTable`）は NeoForge の **LootModifier**（`data/shincolle/loot_modifiers/*.json` + `global_loot_modifiers.json` + `LootModifier` 実装 + `MapCodec`）へ。または同内容をデータパックのルートテーブルで表現。旧 `LootTableList.CHESTS_*` の 10 種マッチは 1.21 の `BuiltInLootTables` 定数に置換。
- [ ] **8-6. ワールド生成**:
  - `data/shincolle/worldgen/configured_feature/polymetal_ore.json`（`minecraft:ore` + `OreConfiguration` 相当の JSON、y 3〜50、size 4〜8）
  - `data/shincolle/worldgen/placed_feature/polymetal_ore.json`（count は config 値を参照できないため、**JSON をデータ生成 or ビルド時テンプレート展開**で config 連動を実現する。難しければ「config は生成頻度ではなく feature 有無の切替」に役割変更）
  - `data/shincolle/neoforge/biome_modifier/*.json`（`neoforge:add_features`、biomes は `#minecraft:is_ocean` 等のタグ）
  - 砂利生成（`WorldGenPolyGravel`）は `ConfiguredFeature` では表現しにくいため、**Feature を Java で登録**（`Feature` + `FeatureType` の DeferredRegister）して JSON から参照する方式にする
- [ ] **8-7. 言語ファイル**: `.lang` 4 ファイル → `assets/shincolle/lang/<locale>.json`。キー体系を再設計（`item.shincolle.ship_spawn_egg` 等）。図鑑テキスト（`Values.BookList`）はコード側文字列も同時に修正。
- [ ] **8-8. モデル/blockstate JSON**:
  - blockstate 17 ファイルの `forge_marker` 形式 → 標準 `variants`/`multipart` 形式へ書き換え（NeoForge 1.21 の標準形式。互換は当てにしない）
  - `models/block` 12・`models/item` 73 の親モデル名確認（`item/generated`, `item/handheld` は有効）
  - テクスチャパス整理: `textures/blocks` → `textures/block`、`textures/items` → `textures/item`、`textures/particles` → `textures/particle`（コード側の `Reference` 定数も同時修正）
- [ ] **8-9. sounds.json**: 形式は 1.12 とほぼ同じ。`subtitle` の追加推奨、パス確認。
- [ ] **8-10. パックメタ**: `pack.mcmeta`（`pack_format: 34`）、MOD アイコン、`neoforge.mods.toml` の説明・作者・URL を整備。

**完了条件**: クラフトレシピが GUI で表示され、生成物が正しい。鉱石が指定バイオームで生成される。言語が 4 ロケールで表示される。

---

### Phase 9: 統合検証

**手順**:
- [ ] **9-1. 起動テスト**: クライアント/専用サーバの両方で起動 → ワールド作成 → 再ログイン（セーブデータ読み書き）。
- [ ] **9-2. 機能回帰マトリクス**（各 1 行 = 1 テスト）:
  - 艦の召喚（スポーンエッグ）/ オーナー登録 / 追従 / 待機 / 遠征（ガード）/ 攻撃 4 系統 / 弾薬消費
  - 騎乗と操縦（マウント 8 種）/ 複数シート / 視点切替 / スキルキー
  - 小型/大型建造ドック（マルチブロック形成・建造）/ ボルケーノコア（燃料）/ クレーン / ウェイポイント / 机（レーダー・図鑑・チーム）
  - 装備（13 種）/ 改修 / 婚姻 / 解体 / 修復
  - チーム/編成の保存とログイン後復元
  - パーティクル・サウンド（艦隊ボイス含む）
- [ ] **9-3. 性能**: 船を 50〜100 体召喚し、AI/パス/パケット負荷を profiler で確認。旧 `clientTrackingRange(10)` と同期頻度を調整。
- [ ] **9-4. 配布ビルド**: `./gradlew build` で jar 生成、`neoforge.mods.toml` の依存（`neoforge` バージョン範囲）を確認。
- [ ] **9-5. ドキュメント**: README に「1.12.2 ワールドからの移行は非対応」を明記。

---

## 5. リスクと対策

| # | リスク | 影響 | 対策 |
|---|---|---|---|
| R1 | **68 モデルの ModelPart 化**（推定 3〜4 万行相当） | 最大の工数。ここが律速 | 7-1/7-2 のとおり基盤＋変換スクリプトを先に作る。代表モデルでテンプレ確定後に一括変換 |
| R2 | **GuiDesk（2,440 行）+ GuiShipInventory（1,242 行）** | GUI 再実装が重い | タブ単位で分割移植。まず枠とスロット、次にボタン、最後に特殊描画（レーダー/モデルプレビュー） |
| R3 | **未完成ハンドラ層（コンパイル不能）** | ベースラインが壊れている | Phase 0-1 で方針確定。参照は `f2f300a` を使う |
| R4 | **独自状態同期の再設計** | 90 ファイルが依存 | `StateHandler` のアクセサ API を維持し、内部実装のみ `SynchedEntityData` へ（呼び出し側は触らない） |
| R5 | **`CapaTeitoku`（1,600 行）の Attachment 化** | 提督データ（チーム・所持艦・編成）が全部載っている | `AttachmentType` + `Codec`（または `CompoundTag` シリアライザ）で実装。ログイン時復元と `copyOnDeath` を設定 |
| R6 | **メタデータ多用アイテムの再設計** | ShipSpawnEgg(60 種)・Ammo・Grudge・ShipTank | 「見えるものは別アイテム、内部状態は DataComponent」。SpawnEgg は単一アイテム + `DataComponent` 継続が最小差分 |
| R7 | **パスファインダ（水・陸・空）の再実装** | 船の移動品質に直結 | 独自 A* をそのまま移植せず、`AmphibiousPathNavigation` + 独自 `NodeEvaluator` に置き換え。閾値（`getPathSearchRange` 等）は旧値を踏襲 |
| R8 | **`RenderBasic.setBrightness` の等価物が無い** | 被弾時の見た目 | `VertexConsumer` の色乗算 + `OverlayTexture` で代替。完全一致は諦め、視認性の調整で対応 |
| R9 | **データ互換（旧ワールド）** | 移行不可 | 非目標と明記。NBT キー・メタ・レシピを新体系に自由に変更 |
| R10 | **依存 MOD** | Metamorph は移植不可 | 削除。Curios は後回し可（無くても壊れない実装にする） |
| R11 | **1.21 の破壊的変更の細部**（`ResourceLocation` 生成、`damage_type` JSON、`TooltipDisplay`、`pack_format` 等） | 単純な置換漏れ | Phase 1 で一括置換表（付録 C）を作り、ビルドエラー駆動で潰す |

---

## 6. 未決事項（Decision Log）

| # | 決定事項 | 現時点の推奨 | 決定時期 |
|---|---|---|---|
| D1 | 状態同期は `SynchedEntityData` へ全面移行するか、独自パケットを維持するか | **スカラー/フラグは SynchedEntityData、リスト系は専用パケット** | Phase 3 開始前 |
| D2 | 旧ワールドデータの移行対応をするか | **しない**（新規ワールド前提） | Phase 0 |
| D3 | メタデータ → 別アイテム or DataComponent の境界 | クラフト素材/燃料は別アイテム、状態は Component | Phase 2 開始前 |
| D4 | モデル変換の自動化方式 | 自作スクリプト + 手直し | Phase 7 開始前 |
| D5 | 旧ハンドラ層（handler/）を設計ごと引き継ぐか、基底クラス内に戻すか | **設計は引き継ぐ**（1.21 の SyncData と相性が良い） | Phase 0 |
| D6 | 連携 MOD（Curios / JEI / IC2） | Curios のみ任意検討、JEI は後に検討、IC2 は削除 | Phase 2 |
| D7 | 1.21.1 を最終ターゲットにするか（1.21.4+ への更新予定があるか） | 1.21.1 固定で進め、データドリブン部分は流用可能な形にする | Phase 0 |
| D8 | スポーンエッグの方式 | 独自 `ShipSpawnEgg` を維持（バニラ `SpawnEggItem` は 60 種に不向き） | Phase 2 |
| D9 | マルチブロック（大型建造ドック）の実装方式 | 旧 `BasicTileMulti` の master/servant 方式をそのまま移植 | Phase 2 |

---

## 7. 付録 A: ビルドファイル構成（雛形）

### A-1. `gradle.properties`

```properties
org.gradle.jvmargs=-Xmx2G
org.gradle.daemon=true
org.gradle.parallel=true
org.gradle.caching=true

minecraft_version=1.21.1
minecraft_version_range=[1.21.1]
neo_version=21.1.250
loader_version_range=[1,)

parchment_minecraft_version=1.21.1
parchment_mappings_version=2024.11.17

mod_id=shincolle
mod_name=Shinkeiseikan Collection
mod_license=MIT
mod_version=1.21.1-1.0
mod_group_id=com.lulan.shincolle
```

### A-2. `build.gradle`（要点）

```groovy
plugins {
    id 'java-library'
    id 'net.neoforged.moddev' version '2.0.147'
}

version = mod_version
group = mod_group_id
base { archivesName = mod_id }

java.toolchain.languageVersion = JavaLanguageVersion.of(21)

neoForge {
    version = project.neo_version
    parchment {
        mappingsVersion = project.parchment_mappings_version
        minecraftVersion = project.parchment_minecraft_version
    }
    runs {
        client { client() }
        server { server(); programArgument '--nogui' }
        data {
            data()
            programArguments.addAll '--mod', project.mod_id, '--all',
                '--output', file('src/generated/resources/').getAbsolutePath(),
                '--existing', file('src/main/resources/').getAbsolutePath()
        }
        configureEach {
            systemProperty 'forge.logging.markers', 'REGISTRIES'
        }
    }
    mods {
        "${mod_id}" { sourceSet(sourceSets.main) }
    }
}

sourceSets.main.resources { srcDir 'src/generated/resources' }

tasks.withType(JavaCompile).configureEach { options.encoding = 'UTF-8' }
```

> データ生成（`data` ラン）を用意しておくと、タグ・レシピ・ルートテーブルのメンテが楽になる。ただし本移植では既存 JSON の変換を優先し、データ生成は補助に留める（全 83 レシピをコードで書き直す必要はない）。

### A-3. `src/main/resources/META-INF/neoforge.mods.toml`

```toml
modLoader = "javafml"
loaderVersion = "${loader_version_range}"
license = "MIT"

[[mods]]
modId = "shincolle"
version = "${mod_version}"
displayName = "Shinkeiseikan Collection"
description = '''Collect cute SeiKan mobs!'''
authors = "PinkaLulan"
logoFile = "shincolle.png"

[[dependencies.shincolle]]
modId = "neoforge"
type = "required"
versionRange = "[21.1.0,)"
ordering = "NONE"
side = "BOTH"

[[dependencies.shincolle]]
modId = "minecraft"
type = "required"
versionRange = "[1.21.1]"
ordering = "NONE"
side = "BOTH"
```

### A-4. `pack.mcmeta`

```json
{
  "pack": {
    "description": "ShinColle resources",
    "pack_format": 34
  }
}
```

---

## 8. 付録 B: 変換レシピ（Before → After）

### B-1. メインクラス

```java
// Before (1.12.2)
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION,
     guiFactory = Reference.GUI_FACTORY)
public class ShinColle {
    @Mod.Instance(Reference.MOD_ID) public static ShinColle instance;
    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;
    @Mod.EventHandler public void preInit(FMLPreInitializationEvent event) { ... }
}
```

```java
// After (1.21.1 NeoForge)
@Mod(ShinColle.MOD_ID)
public class ShinColle {
    public static final String MOD_ID = "shincolle";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public ShinColle(IEventBus modBus, ModContainer container) {
        ModBlocks.BLOCKS.register(modBus);
        ModBlocks.ITEMS.register(modBus);
        ModBlocks.BLOCK_ENTITIES.register(modBus);
        ModEntities.ENTITY_TYPES.register(modBus);
        ModSounds.SOUNDS.register(modBus);
        ModParticles.PARTICLE_TYPES.register(modBus);
        ModMenus.MENUS.register(modBus);
        ModAttachments.ATTACHMENTS.register(modBus);
        ModTabs.TABS.register(modBus);
        ModComponents.COMPONENTS.register(modBus);

        container.registerConfig(ModConfig.Type.COMMON, ShinColleConfig.COMMON_SPEC);
        container.registerConfig(ModConfig.Type.CLIENT, ShinColleConfig.CLIENT_SPEC);

        modBus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModCapabilities.register();     // 必要なら
            ShipClassRegistry.bootstrap();  // ID.ShipClass ↔ EntityType 対応表
        });
    }
}
```

### B-2. 登録（DeferredRegister）

```java
public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ShinColle.MOD_ID);

    public static final DeferredItem<Item> GRUDGE =
        ITEMS.registerSimpleItem("grudge", new Item.Properties());

    public static final DeferredItem<Item> ABYSS_METAL =
        ITEMS.registerItem("abyss_metal", p -> new AbyssMetalItem(p.stacksTo(64)));
}
```

```java
public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ShinColle.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ShinColle.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ShinColle.MOD_ID);

    public static final DeferredBlock<Block> ABYSSIUM_BLOCK = BLOCKS.register("abyssium_block",
        () -> new BasicBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.METAL).strength(3.0F).requiresCorrectToolForDrops()));

    public static final DeferredItem<BlockItem> ABYSSIUM_BLOCK_ITEM =
        ITEMS.registerSimpleBlockItem("abyssium_block", ABYSSIUM_BLOCK);
}
```

> `DeferredRegister.Items#registerSimpleBlockItem` 等の補助 API はバージョンによりオーバーロードが異なる。`ITEMS.register("abyssium_block", () -> new BlockItem(ABYSSIUM_BLOCK.get(), new Item.Properties()))` でも等価。

### B-3. エンティティ型・属性・スポーン配置

```java
public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
    DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, ShinColle.MOD_ID);

public static final DeferredHolder<EntityType<?>, EntityType<EntityDestroyerI>> DESTROYER_I =
    ENTITY_TYPES.register("destroyer_i", () ->
        EntityType.Builder.of(EntityDestroyerI::new, MobCategory.CREATURE)
            .sized(0.9F, 1.7F)
            .clientTrackingRange(10)
            .updateInterval(3)
            .build("destroyer_i"));

// 属性は専用イベントで（mod バス）
@EventBusSubscriber(modid = ShinColle.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEntityAttributes {
    @SubscribeEvent
    public static void onAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(ModEntities.DESTROYER_I.get(), BasicEntityShip.createShipAttributes().build());
    }
}

// 自然スポーン
SpawnPlacements.register(ModEntities.SUBM_U511.get(),
    SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
    (type, level, reason, pos, random) -> WaterAnimal.checkSurfaceWaterAnimalSpawnRules(type, level, reason, pos, random));
```

### B-4. Goal（AI）

```java
// Before: EntityAIBase
public class EntityAIShipRangeAttack extends EntityAIBase {
    public EntityAIShipRangeAttack(EntityLiving host) { this.setMutexBits(1); }
    @Override public boolean shouldExecute() { ... }
    @Override public void updateTask() { ... }
}
```

```java
// After: Goal
public class ShipRangeAttackGoal extends Goal {
    private final BasicEntityShip ship;
    public ShipRangeAttackGoal(BasicEntityShip ship) {
        this.ship = ship;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }
    @Override public boolean canUse() { ... }
    @Override public void tick() { ... }
    @Override public void stop() { ... }
}
// 登録
this.goalSelector.addGoal(11, new ShipRangeAttackGoal(this));
this.targetSelector.addGoal(1, new ShipRevengeTargetGoal(this));
```

### B-5. パケット

```java
public record ShipSyncPayload(int entityId, byte flag, int value) implements CustomPacketPayload {
    public static final Type<ShipSyncPayload> TYPE =
        new Type<>(ResourceLocation.fromNamespaceAndPath(ShinColle.MOD_ID, "ship_sync"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ShipSyncPayload> STREAM_CODEC =
        StreamCodec.composite(
            ByteBufCodecs.VAR_INT, ShipSyncPayload::entityId,
            ByteBufCodecs.BYTE,    ShipSyncPayload::flag,
            ByteBufCodecs.VAR_INT, ShipSyncPayload::value,
            ShipSyncPayload::new);

    @Override public Type<? extends CustomPacketPayload> type() { return TYPE; }

    public static void handle(ShipSyncPayload payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().level().getEntity(payload.entityId()) instanceof BasicEntityShip ship) {
                ship.applyClientSync(payload.flag(), payload.value());
            }
        });
    }
}

// 登録（mod バス）
@SubscribeEvent
public static void register(RegisterPayloadHandlersEvent event) {
    PayloadRegistrar registrar = event.registrar("1");
    registrar.playToClient(ShipSyncPayload.TYPE, ShipSyncPayload.STREAM_CODEC, ShipSyncPayload::handle);
    registrar.playToServer(MountInputPayload.TYPE, MountInputPayload.STREAM_CODEC, MountInputPayload::handle);
}

// 送信
PacketDistributor.sendToPlayer(serverPlayer, new ShipSyncPayload(...));
PacketDistributor.sendToPlayersNear(serverLevel, null, x, y, z, 64.0, new SpawnParticlePayload(...));
```

### B-6. メニューとスクリーン

```java
public static final DeferredRegister<MenuType<?>> MENUS =
    DeferredRegister.create(BuiltInRegistries.MENU, ShinColle.MOD_ID);

public static final DeferredHolder<MenuType<?>, MenuType<ContainerDesk>> DESK_MENU =
    MENUS.register("desk", () -> IMenuTypeExtension.create(
        (windowId, inv, buf) -> new ContainerDesk(windowId, inv, buf.readBlockPos())));

// 開く側（サーバ）
player.openMenu(new SimpleMenuProvider(
    (windowId, inv, p) -> new ContainerDesk(windowId, inv, pos), Component.translatable("gui.shincolle.desk")),
    buf -> buf.writeBlockPos(pos));

// スクリーン
public class GuiDesk extends AbstractContainerScreen<ContainerDesk> {
    @Override protected void renderBg(GuiGraphics g, float partialTick, int mouseX, int mouseY) {
        g.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }
    @Override public void render(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        super.render(g, mouseX, mouseY, partialTick);
        g.drawString(this.font, Component.translatable("gui.shincolle.radar"), 8, 6, 0x404040, false);
    }
}
```

### B-7. ブロックエンティティ

```java
public class TileEntityDesk extends BasicTileEntity {
    public TileEntityDesk(BlockPos pos, BlockState state) { super(ModBlocks.DESK_BE.get(), pos, state); }

    @Override protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("Zoom", this.zoom);
    }
    @Override protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.zoom = tag.getInt("Zoom");
    }
    @Override public CompoundTag getUpdateTag(HolderLookup.Provider registries) { return this.saveWithoutMetadata(registries); }
    @Override public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    // EntityBlock 側
    // @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) { return new TileEntityDesk(pos, state); }
    // @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level l, BlockState s, BlockEntityType<T> t) { ... }
}
```

### B-8. モデル（ModelBase → LayerDefinition / ModelPart）

```java
// Before (Tabula 形式)
ModelRenderer body = new ModelRenderer(this, 0, 0);
body.addBox(-4F, -4F, -4F, 8, 8, 8);
body.setRotationPoint(0F, 16F, 0F);
body.rotateAngleX = 0.2F;
```

```java
// After
public static final ModelLayerLocation SHIP_LAYER =
    new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ShinColle.MOD_ID, "destroyer_i"), "main");

public static LayerDefinition createBodyLayer() {
    MeshDefinition mesh = new MeshDefinition();
    PartDefinition root = mesh.getRoot();
    root.addOrReplaceChild("body",
        CubeListBuilder.create().texOffs(0, 0).addBox(-4F, -4F, -4F, 8, 8, 8),
        PartPose.offsetAndRotation(0F, 16F, 0F, 0.2F, 0F, 0F));
    return LayerDefinition.create(mesh, 64, 64);
}

public class ShipModelDestroyerI extends ShipModel<EntityDestroyerI> {
    public ShipModelDestroyerI(ModelPart root) { super(root); }
    @Override public void setupAnim(EntityDestroyerI entity, float limbSwing, float limbSwingAmount,
                                    float ageInTicks, float netHeadYaw, float headPitch) { ... }
    @Override public void renderToBuffer(PoseStack pose, VertexConsumer vc, int light, int overlay, int color) {
        this.root().render(pose, vc, light, overlay, color);
    }
}

// レイヤ登録（mod バス）
@SubscribeEvent
public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
    event.registerLayerDefinition(SHIP_LAYER, ShipModelDestroyerI::createBodyLayer);
}
```

### B-9. Config

```java
public final class ShinColleConfig {
    public static final ModConfigSpec COMMON_SPEC;
    public static final ModConfigSpec.BooleanValue DEBUG_MODE;
    public static final ModConfigSpec.IntValue POLY_ORE_RATE;

    static {
        ModConfigSpec.Builder b = new ModConfigSpec.Builder();
        b.comment("General").push("general");
        DEBUG_MODE = b.comment("debug logs").define("debug_mode", false);
        b.pop();
        b.comment("World Gen").push("world_gen");
        POLY_ORE_RATE = b.comment("ore attempts per chunk").defineInRange("poly_ore_rate", 4, 0, 100);
        b.pop();
        COMMON_SPEC = b.build();
    }
}
```

### B-10. 提督データ（Capability → Data Attachment）

```java
public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS =
    DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, ShinColle.MOD_ID);

public static final Supplier<AttachmentType<CapaTeitoku>> TEITOKU =
    ATTACHMENTS.register("teitoku", () -> AttachmentType.builder(CapaTeitoku::new)
        .serialize(CapaTeitoku.CODEC)   // Codec を書けない場合は .serialize(NBT ops) で CompoundTag シリアライザを用意
        .copyOnDeath()
        .build());

// 取得/設定
CapaTeitoku capa = player.getData(ModAttachments.TEITOKU);
```

### B-11. コマンド

```java
@EventBusSubscriber(modid = ShinColle.MOD_ID)   // ゲームバス
public final class ModCommands {
    @SubscribeEvent
    public static void register(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> d = event.getDispatcher();
        d.register(Commands.literal("shipinfo")
            .requires(src -> src.hasPermission(2))
            .then(Commands.argument("target", EntityArgument.entity())
                .executes(ctx -> ShipCmdShipInfo.run(ctx.getSource(), EntityArgument.getEntity(ctx, "target")))));
    }
}
```

### B-12. レシピ JSON 変換

```json
// Before (1.12.2 Forge)
{
  "type": "forge:ore_shaped",
  "group": "supplies",
  "pattern": ["iii", "iai", "ibi"],
  "key": {
    "i": { "type": "forge:ore_dict", "ore": "ingotCopper" },
    "a": { "item": "shincolle:Grudge" },
    "b": { "type": "forge:ore_dict", "ore": "gunpowder" }
  },
  "result": { "item": "shincolle:Ammo", "data": 0, "count": 8 }
}
```

```json
// After (1.21.1) — data/shincolle/recipe/ammo_light_8a.json
{
  "type": "minecraft:crafting_shaped",
  "group": "supplies",
  "pattern": ["iii", "iai", "ibi"],
  "key": {
    "i": { "tag": "c:ingots/copper" },
    "a": { "item": "shincolle:grudge" },
    "b": { "tag": "c:gunpowder" }
  },
  "result": { "id": "shincolle:ammo_light", "count": 8 }
}
```

---

## 9. 付録 C: 機械的置換リスト（ビルドエラー駆動で潰す）

```text
net.minecraftforge.fml.common.Mod              -> net.neoforged.fml.common.Mod
net.minecraftforge.fml.common.event.FML*       -> net.neoforged.fml.event.lifecycle.FML*
net.minecraftforge.fml.relauncher.SideOnly     -> net.neoforged.api.distmarker.OnlyIn
net.minecraftforge.fml.common.network.*        -> net.neoforged.neoforge.network.*
net.minecraftforge.event.*                     -> net.neoforged.neoforge.event.*
net.minecraftforge.common.config.Configuration -> net.neoforged.neoforge.common.ModConfigSpec
net.minecraftforge.fml.client.registry.RenderingRegistry -> （削除：EntityRenderersEvent）
net.minecraftforge.items.ItemStackHandler      -> net.neoforged.neoforge.items.ItemStackHandler
net.minecraftforge.fluids.*                    -> net.neoforged.neoforge.fluids.*

net.minecraft.entity.EntityLivingBase          -> net.minecraft.world.entity.LivingEntity
net.minecraft.entity.EntityLiving              -> net.minecraft.world.entity.LivingEntity
net.minecraft.entity.EntityCreature             -> net.minecraft.world.entity.PathfinderMob
net.minecraft.entity.monster.EntityMob         -> net.minecraft.world.entity.monster.Monster
net.minecraft.entity.passive.EntityTameable    -> net.minecraft.world.entity.TamableAnimal
net.minecraft.entity.player.EntityPlayer       -> net.minecraft.world.entity.player.Player
net.minecraft.entity.player.EntityPlayerMP     -> net.minecraft.server.level.ServerPlayer
net.minecraft.entity.item.EntityItem           -> net.minecraft.world.entity.item.ItemEntity
net.minecraft.entity.item.EntityXPOrb           -> net.minecraft.world.entity.ExperienceOrb
net.minecraft.entity.Entity                    -> net.minecraft.world.entity.Entity
net.minecraft.world.World                      -> net.minecraft.world.level.Level
net.minecraft.world.WorldServer                -> net.minecraft.server.level.ServerLevel
net.minecraft.block.state.IBlockState           -> net.minecraft.world.level.block.state.BlockState
net.minecraft.block.Block                      -> net.minecraft.world.level.block.Block
net.minecraft.item.ItemStack                   -> net.minecraft.world.item.ItemStack (同名)
net.minecraft.nbt.NBTTagCompound               -> net.minecraft.nbt.CompoundTag
net.minecraft.nbt.NBTTagList                   -> net.minecraft.nbt.ListTag
net.minecraft.util.EnumFacing / EnumHand       -> net.minecraft.core.Direction / InteractionHand
net.minecraft.util.math.BlockPos               -> net.minecraft.core.BlockPos (同名)
net.minecraft.util.math.Vec3d                  -> net.minecraft.world.phys.Vec3
net.minecraft.util.math.AxisAlignedBB          -> net.minecraft.world.phys.AABB
net.minecraft.util.math.MathHelper             -> net.minecraft.util.Mth
net.minecraft.util.text.*                      -> net.minecraft.network.chat.Component
net.minecraft.util.ResourceLocation            -> 同名（生成は ResourceLocation.fromNamespaceAndPath）
net.minecraft.client.gui.inventory.GuiContainer-> net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
net.minecraft.inventory.Container              -> net.minecraft.world.inventory.AbstractContainerMenu
net.minecraft.client.renderer.GlStateManager   -> com.mojang.blaze3d.systems.RenderSystem / PoseStack
net.minecraft.client.renderer.Tessellator       -> （削除：VertexConsumer）
net.minecraft.client.model.ModelBase           -> net.minecraft.client.model.geom.ModelPart
net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer -> net.minecraft.client.renderer.blockentity.BlockEntityRenderer
net.minecraft.client.particle.Particle         -> net.minecraft.client.particle.Particle（シグネチャ変更）
net.minecraft.tileentity.TileEntity            -> net.minecraft.world.level.block.entity.BlockEntity
net.minecraft.entity.ai.EntityAIBase           -> net.minecraft.world.entity.ai.goal.Goal
```

**フィールド/メソッドの一括置換（正規表現）**:

```text
\bthis\.world\b                 -> this.level()
\bthis\.posX\b                  -> this.getX()
\bthis\.motionX\b               -> this.getDeltaMovement().x
\bthis\.setDead\(\)             -> this.discard()
\bthis\.isDead\b                -> this.isRemoved()
\bthis\.getEntityBoundingBox\(\) -> this.getBoundingBox()
\bworld\.getEntitiesWithinAABB\( -> level.getEntitiesOfClass(
\bworld\.spawnEntity\(          -> level.addFreshEntity(
\bentity\.world\b               -> entity.level()
\bI18n\.format\(                -> Component.translatable(
\bnew ResourceLocation\(        -> ResourceLocation.fromNamespaceAndPath(
```

> 置換は必ずコンパイルエラーと突き合わせながら段階的に行う。一括で全適用しない（`world` のような一般名は誤爆する）。

---

## 10. 付録 D: パッケージ対応表（移植マップ）

| 旧（1.12.2） | 新（1.21.1） | 主な作業 |
|---|---|---|
| `ShinColle.java` | `ShinColle.java` | 全面書換 |
| `proxy/*` | `client/ClientSetup`, `common/CommonSetup`, `server/*` | プロキシ廃止・イベント分離 |
| `init/*` | `registry/*` | DeferredRegister 化 |
| `reference/*` | `reference/*` + `registry/ShipClassRegistry` | ID 維持、名前対応表追加 |
| `config/*` | `config/*` | ModConfigSpec + INI 流用 |
| `handler/EventHandler` | `event/*`（StatHandler, CombatHandler, PlayerHandler, ClientEventHandler, …） | 1,380 行を機能別に分割 |
| `handler/GuiHandler` | 削除（MenuType/MenuProvider） | — |
| `handler/StateHandler` | `entity/state/*` | SynchedEntityData 実装 |
| `handler/AttackHandler` | `entity/combat/*` | 完成させる |
| `handler/AIHandler` | `entity/ai/*` | Goal 登録 |
| `handler/PacketHandler` | `network/*` | Payload 化 |
| `handler/{Sound,Particle,Render}Handler` | `entity/effect/*`, `client/render/*` | — |
| `network/*` (6) | `network/*`（20〜40 payload） | 分割設計 |
| `capability/CapaTeitoku` | `capability/TeitokuData` + Attachment | Codec 実装 |
| `capability/CapaInventory*` | 同名（ItemStackHandler 更新） | — |
| `entity/*` | `entity/*` | 基底 4 系統の API 更新 |
| `ai/*`, `ai/path/*` | `entity/ai/*`（+ バニラ Path 使用） | 独自パス削除 |
| `client/model/*` (68) | `client/model/*`（LayerDefinition） | スクリプト変換 |
| `client/render/*` | `client/render/*` | EntityRenderer 化 |
| `client/gui/*` | `client/gui/*` | AbstractContainerScreen 化 |
| `client/particle/*` (20) | `client/particle/*` | Particle API 更新 |
| `item/*`, `block/*` | `item/*`, `block/*` | Properties/Component 化 |
| `tileentity/*` | `block/entity/*` | BlockEntity 化 |
| `crafting/*` | `crafting/*` | RecipeType/Serializer |
| `worldgen/*` | `worldgen/*` + `data/shincolle/worldgen` | Feature 化 |
| `command/*` | `command/*` | Brigadier 化 |
| `server/*` | `server/*` | SavedData 化 |
| `playerskill/*` | `playerskill/*` | KeyMapping + Payload |
| `intermod/MetamorphHelper` | **削除** | — |

---

## 11. 付録 E: フェーズ別チェックリスト（要約）

- [ ] Phase 0: 空 MOD 起動（client/server）／ベースライン確定／ブランチ作成
- [ ] Phase 1: メインクラス・Config・定数・ログ
- [ ] Phase 2: 17 ブロック／8 BE／35 アイテム／87 エンティティ型／53 サウンド／20 パーティクル／タブ／タグ
- [ ] Phase 3: 状態同期／セーブデータ／基底 4 系統／チーム／インベントリ／死亡ドロップ／騎乗
- [ ] Phase 4: Goal 17 種／パス探索／ターゲット／攻撃 4 系統／タスク
- [ ] Phase 5: ペイロード分割／コーデック／送受信
- [ ] Phase 6: MenuType 9 種／9 画面／スロット／モデルプレビュー
- [ ] Phase 7: 68 モデル／95 レンダラ／3 BER／20 パーティクル／HUD／カメラ／キー
- [ ] Phase 8: 83 レシピ／タグ／ルート／ワールド生成／lang 4 言語／blockstate・モデル JSON
- [ ] Phase 9: 回帰テスト／性能／配布ビルド／README

---

## 12. 参考資料

- NeoForge 公式ドキュメント: https://docs.neoforged.net/
  - ModDevGradle: https://docs.neoforged.net/toolchain/docs/plugins/mdg/
  - Blockstates/Models: https://docs.neoforged.net/docs/blocks/states/ , https://docs.neoforged.net/docs/resources/client/models/
- MDK テンプレート（1.21.1 / ModDevGradle）: https://github.com/NeoForgeMDKs/MDK-1.21.1-ModDevGradle
- ModDevGradle プラグイン: https://plugins.gradle.org/plugin/net.neoforged.moddev
- Parchment マッピング: https://parchmentmc.org/docs/getting-started
- NeoForge バージョン一覧: https://projects.neoforged.net/neoforged/neoforge
- 元リポジトリ: https://github.com/PinkaLulan/ShinColle

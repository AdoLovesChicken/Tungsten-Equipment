package west.tungsten_mod;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import west.tungsten_mod.item.ModItems;

public class ModLootTables {

    // Stronghold
    private static final Identifier STRONGHOLD_CORRIDOR =
            Identifier.ofVanilla("chests/stronghold_corridor");
    private static final Identifier STRONGHOLD_CROSSING =
            Identifier.ofVanilla("chests/stronghold_crossing");
    private static final Identifier STRONGHOLD_LIBRARY =
            Identifier.ofVanilla("chests/stronghold_library");

    // Ancient City
    private static final Identifier ANCIENT_CITY =
            Identifier.ofVanilla("chests/ancient_city");

    // Temples
    private static final Identifier DESERT_TEMPLE =
            Identifier.ofVanilla("chests/desert_pyramid");
    private static final Identifier JUNGLE_TEMPLE =
            Identifier.ofVanilla("chests/jungle_temple");

    // Dungeon
    private static final Identifier SIMPLE_DUNGEON =
            Identifier.ofVanilla("chests/simple_dungeon");

    // Mineshaft
    private static final Identifier MINESHAFT =
            Identifier.ofVanilla("chests/abandoned_mineshaft");

    // Pillager Outpost
    private static final Identifier PILLAGER_OUTPOST =
            Identifier.ofVanilla("chests/pillager_outpost");

    // Underwater Ruins
    private static final Identifier UNDERWATER_RUIN_SMALL =
            Identifier.ofVanilla("chests/underwater_ruin_small");
    private static final Identifier UNDERWATER_RUIN_BIG =
            Identifier.ofVanilla("chests/underwater_ruin_big");

    // Shipwrecks
    private static final Identifier SHIPWRECK_TREASURE =
            Identifier.ofVanilla("chests/shipwreck_treasure");

    // Buried treasure
    private static final Identifier BURIED_TREASURE =
            Identifier.ofVanilla("chests/buried_treasure");

    // Igloo
    private static final Identifier IGLOO =
            Identifier.ofVanilla("chests/igloo_chest");


    public static void register() {
        LootTableEvents.MODIFY.register((id, tableBuilder, source, registries) -> {
            if (!source.isBuiltin()) return;

            // -------------------------------
            // EXISTING UPGRADE TEMPLATE LOOT
            // -------------------------------

            // Dungeon – 5%
            if (id.getValue().equals(SIMPLE_DUNGEON)) {
                tableBuilder.pool(
                        LootPool.builder()
                                .conditionally(RandomChanceLootCondition.builder(0.05f))
                                .with(ItemEntry.builder(ModItems.TUNGSTEN_UPGRADE_TEMPLATE))
                );
            }

            // Stronghold crossing + library – 10%
            if (id.getValue().equals(STRONGHOLD_CROSSING) || id.getValue().equals(STRONGHOLD_LIBRARY)) {
                tableBuilder.pool(
                        LootPool.builder()
                                .conditionally(RandomChanceLootCondition.builder(0.10f))
                                .with(ItemEntry.builder(ModItems.TUNGSTEN_UPGRADE_TEMPLATE))
                );
            }

            // Stronghold corridor – 15%
            else if (id.getValue().equals(STRONGHOLD_CORRIDOR)) {
                tableBuilder.pool(
                        LootPool.builder()
                                .conditionally(RandomChanceLootCondition.builder(0.15f))
                                .with(ItemEntry.builder(ModItems.TUNGSTEN_UPGRADE_TEMPLATE))
                );
            }

            // Ancient City – 20%
            else if (id.getValue().equals(ANCIENT_CITY)) {
                tableBuilder.pool(
                        LootPool.builder()
                                .conditionally(RandomChanceLootCondition.builder(0.20f))
                                .with(ItemEntry.builder(ModItems.TUNGSTEN_UPGRADE_TEMPLATE))
                );
            }

            // Desert & Jungle Temples – 20%
            else if (id.getValue().equals(DESERT_TEMPLE) || id.getValue().equals(JUNGLE_TEMPLE)) {
                tableBuilder.pool(
                        LootPool.builder()
                                .conditionally(RandomChanceLootCondition.builder(0.20f))
                                .with(ItemEntry.builder(ModItems.TUNGSTEN_UPGRADE_TEMPLATE))
                );
            }


            // -------------------------------
            // NEW: TUNGSTEN SCRAP LOOT (12%)
            // -------------------------------

            float SCRAP_CHANCE = 0.12f;

            if (id.getValue().equals(MINESHAFT)
                    || id.getValue().equals(PILLAGER_OUTPOST)
                    || id.getValue().equals(UNDERWATER_RUIN_SMALL)
                    || id.getValue().equals(UNDERWATER_RUIN_BIG)
                    || id.getValue().equals(SHIPWRECK_TREASURE)
                    || id.getValue().equals(BURIED_TREASURE)) {

                tableBuilder.pool(
                        LootPool.builder()
                                .conditionally(RandomChanceLootCondition.builder(SCRAP_CHANCE))
                                .with(ItemEntry.builder(ModItems.TUNGSTEN_SCRAP))
                );
            }
        });
    }
}
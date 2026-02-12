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

    // Trial Chambers – Ominous Vault ONLY
    private static final Identifier OMINOUS_VAULT =
            Identifier.ofVanilla("chests/trial_chambers/ominous_vault");

    // Dungeon (mob spawner room)
    private static final Identifier SIMPLE_DUNGEON =
            Identifier.ofVanilla("chests/simple_dungeon");

    public static void register() {
        LootTableEvents.MODIFY.register((id, tableBuilder, source, registries) -> {
            if (!source.isBuiltin()) return;

                // Dungeon – 5%
            else if (id.getValue().equals(SIMPLE_DUNGEON)) {
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
        });
    }
}

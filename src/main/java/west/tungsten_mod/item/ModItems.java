package west.tungsten_mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import west.tungsten_mod.TungstenMod;

public class ModItems {
    public static final Item TUNGSTEN_INGOT = registerItem("tungsten_ingot", new Item(new Item.Settings().fireproof()));
    public static final Item TUNGSTEN_SCRAP = registerItem("tungsten_scrap", new Item(new Item.Settings().fireproof()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TungstenMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TungstenMod.LOGGER.info("Registering Mod Items for " + TungstenMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(TUNGSTEN_INGOT);
            entries.add(TUNGSTEN_SCRAP);
        });
    }
}
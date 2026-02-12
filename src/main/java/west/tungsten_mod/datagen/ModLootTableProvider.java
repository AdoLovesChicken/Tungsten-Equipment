package west.tungsten_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;
import west.tungsten_mod.block.ModBlocks;
import west.tungsten_mod.item.ModItems;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(
            FabricDataOutput dataOutput,
            CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup
    ) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.TUNGSTEN_BLOCK);

        addDrop(ModBlocks.TUNGSTEN_CLUMP,
                block -> applyExplosionDecay(block,
                        LootTable.builder().pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1))
                                        .with(
                                                ItemEntry.builder(ModItems.TUNGSTEN_POWDER)
                                                        .apply(SetCountLootFunction.builder(
                                                                UniformLootNumberProvider.create(1.0F, 2.0F)
                                                        ))
                                        )
                        )
                )
        );
    }

}
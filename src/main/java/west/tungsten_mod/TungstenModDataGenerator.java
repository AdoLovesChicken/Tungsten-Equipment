package west.tungsten_mod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import west.tungsten_mod.datagen.ModBlockTagProvider;
import west.tungsten_mod.datagen.ModLootTableProvider;
import west.tungsten_mod.datagen.ModModelProvider;
import west.tungsten_mod.datagen.ModRecipeProvider;

public class TungstenModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}

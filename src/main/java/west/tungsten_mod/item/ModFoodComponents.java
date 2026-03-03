package west.tungsten_mod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent TUNGSTEN_SLOP = new FoodComponent.Builder()
            .nutrition(-4)
            .saturationModifier(0.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 3000, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2000, 0), 1.0F)
            .alwaysEdible()
            .build();
    public static final FoodComponent TUNGSTEN_JERKY = new FoodComponent.Builder()
            .nutrition(1)
            .saturationModifier(0.8F)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1000, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 1000, 0), 1.0F)
            .build();
}
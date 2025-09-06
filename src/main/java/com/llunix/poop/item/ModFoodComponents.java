package com.llunix.poop.item;

import com.llunix.poop.Poop;
import com.llunix.poop.effect.DiarrheaEffect;
import com.llunix.poop.effect.ModEffects;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;

public class ModFoodComponents {
    public static final FoodComponent POOP = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(ModEffects.DIARRHEA, 2000), 1.00f).build();
}

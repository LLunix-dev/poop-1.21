package com.llunix.poop.effect;

import com.llunix.poop.Poop;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> DIARRHEA = registerStatusEffect("diarrhea", new DiarrheaEffect(StatusEffectCategory.HARMFUL,
            0x654321));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Poop.MOD_ID, name), statusEffect);
    }
    public static void registerEffects() {
        Poop.LOGGER.info("Registering Mod Effects for " + Poop.MOD_ID);
    }
}

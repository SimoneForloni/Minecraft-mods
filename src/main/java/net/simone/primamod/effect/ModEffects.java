package net.simone.primamod.effect;

import net.simone.primamod.effect.effects.*;
import net.simone.primamod.PrimaMod;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    // Registra tutti gli effetti del mod
    public static final RegistryEntry.Reference<StatusEffect> TATER_EFFECT = registerEffect("tater_effect", 
        new TaterEffect(StatusEffectCategory.BENEFICIAL, 0xe9b8b3));
    
    public static final RegistryEntry.Reference<StatusEffect> SPEED_BOOST = registerEffect("speed_boost", 
        new SpeedBoostEffect(StatusEffectCategory.BENEFICIAL, 0x00FFFF));

    private static RegistryEntry.Reference<StatusEffect> registerEffect(String name, StatusEffect effect) {
        return Registry.registerReference(
            Registries.STATUS_EFFECT,
            Identifier.of(PrimaMod.MOD_ID, name),
            effect
        );
    }
    
    public static void initialize() {

    }
}
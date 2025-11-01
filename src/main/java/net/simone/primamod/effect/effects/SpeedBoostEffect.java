package net.simone.primamod.effect.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.simone.primamod.init.PrimaMod;
import net.minecraft.entity.attribute.EntityAttributes; 
import net.minecraft.entity.attribute.EntityAttributeModifier; 

public class SpeedBoostEffect extends StatusEffect {

    public SpeedBoostEffect(StatusEffectCategory category, int color) {
        super(category, color);
        this.addAttributeModifier(
            EntityAttributes.MOVEMENT_SPEED,
            Identifier.of(PrimaMod.MOD_ID, "speed_boost_effect"), 
            0.20,
            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL 
        );
    }
}
package net.simone.primamod.effect.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class TaterEffect extends StatusEffect {

    public TaterEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if(entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).addExperience(1 << amplifier);
        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }
}
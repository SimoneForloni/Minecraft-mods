package net.simone.primamod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.simone.primamod.PrimaMod;

public class ModEffects extends StatusEffect {
	public static final StatusEffect TATER_EFFECT = new ModEffects(StatusEffectCategory.BENEFICIAL, 0xe9b8b3);

	
	private ModEffects(StatusEffectCategory category, int color) {
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

	public static void initialize(){
		Registry.registerReference(
			Registries.STATUS_EFFECT,
			Identifier.of(PrimaMod.MOD_ID, "tater_effect"),
			new ModEffects(StatusEffectCategory.BENEFICIAL, 0xe9b8b3)
	);
	}
}
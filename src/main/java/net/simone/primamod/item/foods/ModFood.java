package net.simone.primamod.item.foods;

import net.minecraft.component.type.FoodComponent;

public class ModFood {
	public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder()
		.nutrition(3)
		.saturationModifier(0.25f)
		.build();
}
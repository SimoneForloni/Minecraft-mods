package net.simone.primamod.item;

import net.minecraft.item.Item;
import net.simone.primamod.item.tools.ChiselItem;

public class ModTools {
	public static final Item CHISEL = ModItems.register("chisel", ChiselItem::new, new Item.Settings().maxDamage(32));
}

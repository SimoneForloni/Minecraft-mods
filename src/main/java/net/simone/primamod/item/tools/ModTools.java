package net.simone.primamod.item.tools;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.simone.primamod.item.ModItems;

public class ModTools {
	public static final Item CHISEL = ModItems.register("chisel", ChiselItem::new, new Item.Settings().maxDamage(32));

	public static void init() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.add(ModTools.CHISEL);
		});
	}
}
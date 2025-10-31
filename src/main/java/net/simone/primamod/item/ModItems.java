package net.simone.primamod.item;

import net.simone.primamod.PrimaMod;

import java.util.function.Function; 

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
	public static final Item RAW_PINK_GARNET = register("raw_pink_garnet");
	public static final Item PINK_GARNET = register("pink_garnet");
	
	public static Item register(String name) {
		return register(name, Item::new, new Item.Settings());
	}

	public static Item register(String name, Item.Settings settings) {
		return register(name, Item::new, settings);
	}

	public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PrimaMod.MOD_ID, name));

		Item item = itemFactory.apply(settings.registryKey(itemKey));

		Registry.register(Registries.ITEM, itemKey, item);

		return item;
	}

	public static void init() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.add(ModItems.RAW_PINK_GARNET);
			entries.add(ModItems.PINK_GARNET);
		});
	}
}
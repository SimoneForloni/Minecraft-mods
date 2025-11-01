package net.simone.primamod.groups;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.simone.primamod.block.blocks.ModBlocks;
import net.simone.primamod.init.PrimaMod;
import net.simone.primamod.item.items.ModItems;
import net.simone.primamod.item.tools.ModTools;

public class ModGroups {
	// Create the registry key
	public static final RegistryKey<ItemGroup> PINK_GARNET_GROUP = RegistryKey.of(
		Registries.ITEM_GROUP.getKey(), 
		Identifier.of(PrimaMod.MOD_ID, "pink_garnet_group")
	);
	
	// Build the item group (but don't register it yet)
	public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
		.icon(() -> new ItemStack(ModItems.PINK_GARNET))
		.displayName(Text.translatable("itemgroup.primamod.pink_garnet_group"))
		.build();
	
	// Initialize method to register everything
	public static void init() {
		// Register the item group
		Registry.register(Registries.ITEM_GROUP, PINK_GARNET_GROUP, CUSTOM_ITEM_GROUP);
		
		// Add items to the group
		ItemGroupEvents.modifyEntriesEvent(PINK_GARNET_GROUP).register(entries -> {
			entries.add(ModItems.RAW_PINK_GARNET);
			entries.add(ModItems.PINK_GARNET);
			
			entries.add(ModTools.CHISEL);

			entries.add(ModBlocks.PINK_GARNET_BLOCK.asItem());
			entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK.asItem());

			entries.add(ModBlocks.PINK_GARNET_ORE.asItem());
			entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE.asItem());
			
			entries.add(ModBlocks.MAGIC_BLOCK.asItem());
		});
	} 
}
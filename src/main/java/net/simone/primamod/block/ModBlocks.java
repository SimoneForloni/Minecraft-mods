package net.simone.primamod.block;

import net.simone.primamod.PrimaMod;

import java.util.function.*;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {

	public static final Block PINK_GARNET_BLOCK = register("pink_garnet_block", Block::new, AbstractBlock.Settings.create()
			.strength(4f)
      .requiresTool()
      .sounds(BlockSoundGroup.AMETHYST_BLOCK),
			true
  );

	public static final Block RAW_PINK_GARNET_BLOCK = register(
		"raw_pink_garnet_block", 
    Block::new, 
		AbstractBlock.Settings.create()
      .strength(4f)
      .requiresTool()
      .sounds(BlockSoundGroup.AMETHYST_BLOCK),
			true
  );

	private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
		// Create a registry key for the block
		RegistryKey<Block> blockKey = keyOfBlock(name);
		// Create the block instance
		Block block = blockFactory.apply(settings.registryKey(blockKey));

		// Sometimes, you may not want to register an item for the block.
		// Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
		if (shouldRegisterItem) {
			// Items need to be registered with a different type of registry key, but the ID
			// can be the same.
			RegistryKey<Item> itemKey = keyOfItem(name);

			BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
			Registry.register(Registries.ITEM, itemKey, blockItem);

		}
	return Registry.register(Registries.BLOCK, blockKey, block);
}

	private static RegistryKey<Block> keyOfBlock(String name) {
		return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(PrimaMod.MOD_ID, name));
	}

	private static RegistryKey<Item> keyOfItem(String name) {
		return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PrimaMod.MOD_ID, name));
	}

	

	public static void initialize() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
			itemGroup.add(ModBlocks.PINK_GARNET_BLOCK.asItem());
			itemGroup.add(ModBlocks.RAW_PINK_GARNET_BLOCK.asItem());
		});
	}
}

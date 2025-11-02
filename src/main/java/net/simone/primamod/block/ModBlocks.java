package net.simone.primamod.block;

import java.util.function.*;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.sound.BlockSoundGroup;
import net.simone.primamod.block.blocks.MagicBlock;
import net.simone.primamod.init.PrimaMod;

public class ModBlocks {

	public static final Block PINK_GARNET_BLOCK = register(
		"pink_garnet_block",
		Block::new,
		AbstractBlock.Settings.create()
			.strength(4f)
			.requiresTool()
			.sounds(BlockSoundGroup.AMETHYST_BLOCK),
			true
	);
	public static final Block RAW_PINK_GARNET_BLOCK = register(
		"raw_pink_garnet_block",
		Block::new,
		AbstractBlock.Settings.create()
			.strength(3f)
			.requiresTool()
			.sounds(BlockSoundGroup.AMETHYST_BLOCK),
			true
  );

	public static final Block PINK_GARNET_ORE = register(
		"pink_garnet_ore", 
		(settings) -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), settings), 
		AbstractBlock.Settings.create()
			.strength(3f)
			.requiresTool()
			.sounds(BlockSoundGroup.STONE),
			true
	);
	public static final Block PINK_GARNET_DEEPSLATE_ORE = register(
		"pink_garnet_deepslate_ore",
		(settings) -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), settings),
		AbstractBlock.Settings.create()
			.strength(4.5f)
			.requiresTool()
			.sounds(BlockSoundGroup.DEEPSLATE),
			true
	);
	
	public static final Block MAGIC_BLOCK = register(
		"magic_block",
		MagicBlock::new,
		AbstractBlock.Settings.create()
			.strength(4.5f)
			.requiresTool()
			.sounds(BlockSoundGroup.DEEPSLATE),
			true
	);

	private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
		RegistryKey<Block> blockKey = keyOfBlock(name);

		Block block = blockFactory.apply(settings.registryKey(blockKey));

		if (shouldRegisterItem) {
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

	

	public static void init() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
			itemGroup.add(ModBlocks.PINK_GARNET_BLOCK.asItem());
			itemGroup.add(ModBlocks.RAW_PINK_GARNET_BLOCK.asItem());

			itemGroup.add(ModBlocks.PINK_GARNET_ORE.asItem());
			itemGroup.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE.asItem());
			
			itemGroup.add(ModBlocks.MAGIC_BLOCK.asItem());
		});
	}
}

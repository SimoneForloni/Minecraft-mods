package net.simone.primamod.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;
import net.simone.primamod.block.ModBlocks;
import net.simone.primamod.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
	public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}
	
	@Override
	public void generate() {
		addDrop(ModBlocks.PINK_GARNET_BLOCK);
		addDrop(ModBlocks.RAW_PINK_GARNET_BLOCK);
		addDrop(ModBlocks.MAGIC_BLOCK);

		addDrop(ModBlocks.PINK_GARNET_ORE, oreDrops(ModBlocks.PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
		addDrop(ModBlocks.PINK_GARNET_DEEPSLATE_ORE, multipleItemDrops(ModItems.RAW_PINK_GARNET, 1.0f, 4.0f));
	}

		public LootTable.Builder multipleItemDrops(Item item, float min, float max) {
			return LootTable.builder()
				.pool(LootPool.builder()
					.rolls(ConstantLootNumberProvider.create(1.0f))
					.with(ItemEntry.builder(item)
						.apply(SetCountLootFunction.builder(
							UniformLootNumberProvider.create(min, max))))
					.conditionally(SurvivesExplosionLootCondition.builder()));
    }
    
    public LootTable.Builder multipleItemDrops(Item item, int count) {
			return LootTable.builder()
				.pool(LootPool.builder()
					.rolls(ConstantLootNumberProvider.create(1.0f))
					.with(ItemEntry.builder(item)
						.apply(SetCountLootFunction.builder(
							ConstantLootNumberProvider.create(count))))
					.conditionally(SurvivesExplosionLootCondition.builder()));
    }
}

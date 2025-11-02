package net.simone.primamod.item;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.simone.primamod.block.ModBlocks;

public class ModFuels {
	
	public static void init() {
		// In Fabric 1.21.10, si usa FuelRegistryEvents invece di FuelRegistry.INSTANCE
		
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			// Pink Garnet brucia per 3200 tick (16 item) - come 2 carboni
			builder.add(ModItems.PINK_GARNET, 3200);
			
			// Raw Pink Garnet brucia per 1600 tick (8 item) - come 1 carbone
			builder.add(ModItems.RAW_PINK_GARNET, 1600);
			
			// Pink Garnet Block brucia per 32000 tick (160 item) - come 2 carbone blocks
			builder.add(ModBlocks.PINK_GARNET_BLOCK, 32000);
		});
	}
}
package net.simone.primamod.init;

import net.fabricmc.api.ModInitializer;
import net.simone.primamod.block.blocks.ModBlocks;
import net.simone.primamod.effect.ModEffects;
import net.simone.primamod.groups.ModGroups;
import net.simone.primamod.item.items.ModItems;
import net.simone.primamod.item.tools.ModTools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrimaMod implements ModInitializer {
	public static final String MOD_ID = "primamod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModGroups.init();
		ModItems.init();
		ModTools.init();
		ModBlocks.init();
		ModEffects.init();
	}
}
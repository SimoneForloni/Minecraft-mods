package net.simone.primamod;

import net.fabricmc.api.ModInitializer;
import net.simone.primamod.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrimaMod implements ModInitializer {
	public static final String MOD_ID = "primamod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
	}
}
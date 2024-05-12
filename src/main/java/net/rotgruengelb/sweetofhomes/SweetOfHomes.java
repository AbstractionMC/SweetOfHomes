package net.rotgruengelb.sweetofhomes;

import net.fabricmc.api.ModInitializer;
import net.rotgruengelb.sweetofhomes.block.SoHBlocks;
import net.rotgruengelb.sweetofhomes.item.SoHItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SweetOfHomes implements ModInitializer {

	public static final String MOD_ID = "sweetofhomes";
	public static final Logger LOGGER = LoggerFactory.getLogger("sweetofhomes");

	@Override
	public void onInitialize() {
		SoHBlocks.registerModBlocks();
		SoHItems.registerModItems();
	}
}
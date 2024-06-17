package net.rotgruengelb.sweetofhomes;

import net.fabricmc.api.ModInitializer;
import net.rotgruengelb.sweetofhomes.block.HomesBlocks;
import net.rotgruengelb.sweetofhomes.entity.HomesEntities;
import net.rotgruengelb.sweetofhomes.item.HomesItems;
import net.rotgruengelb.sweetofhomes.world.HomesGameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SweetOfHomes implements ModInitializer {

	public static final String MOD_ID = "sweetofhomes";
	public static final Logger LOGGER = LoggerFactory.getLogger("sweetofhomes");

	@Override
	public void onInitialize() {
		HomesBlocks.registerModBlocks();
		HomesItems.registerModItems();
		HomesGameRules.registerModGameRules();
		HomesEntities.registerModEntities();
	}
}
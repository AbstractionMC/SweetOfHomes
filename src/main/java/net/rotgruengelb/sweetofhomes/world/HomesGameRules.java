package net.rotgruengelb.sweetofhomes.world;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import net.rotgruengelb.sweetofhomes.SweetOfHomes;

public class HomesGameRules {

	public static final GameRules.Key<GameRules.BooleanRule> SHOW_COPPER_WRENCH_MESSAGES = GameRuleRegistry.register(SweetOfHomes.MOD_ID + ".showCopperWrenchMessages", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(false));

	public static void registerModGameRules() {
		SweetOfHomes.LOGGER.debug("Registering HomesGameRules for " + SweetOfHomes.MOD_ID);
	}
}

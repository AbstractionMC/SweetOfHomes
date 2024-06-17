package net.rotgruengelb.sweetofhomes.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.rotgruengelb.sweetofhomes.SweetOfHomes;

import java.util.ArrayList;
import java.util.List;

public class HomesItems {

	public static final Item COPPER_WRENCH = registerItem("copper_wrench", new CopperWrenchItem(new FabricItemSettings().maxCount(1)));
	public static final Item COPPER_NUGGET = registerItem("copper_nugget", new Item(new FabricItemSettings()));

	private static Item registerItem(String name, Item item) {
		ALL.ITEMS.add(item);
		return Registry.register(Registries.ITEM, new Identifier(SweetOfHomes.MOD_ID, name), item);
	}

	private static Item registerMusicDisc(String name, int comparatorOutput, SoundEvent soundEvent, int lengthInSeconds) {

		return registerItem("music_disc_" + name, new MusicDiscItem(comparatorOutput, soundEvent, new FabricItemSettings().maxCount(1)
				.rarity(Rarity.RARE), lengthInSeconds));
	}

	public static void addItemsToItemGroup() {
	}

	private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
		ItemGroupEvents.modifyEntriesEvent(group)
				.register(entries -> entries.add(item));
	}

	public static void registerModItems() {
		SweetOfHomes.LOGGER.debug("Registering HomesItems for " + SweetOfHomes.MOD_ID);

		addItemsToItemGroup();
	}

	public static class ALL {
		public static final List<Item> ITEMS = new ArrayList<>();
	}
}
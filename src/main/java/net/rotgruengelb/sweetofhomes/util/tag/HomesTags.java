package net.rotgruengelb.sweetofhomes.util.tag;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.rotgruengelb.sweetofhomes.SweetOfHomes;

public class HomesTags {

	public static class BLOCKS {
		public static final TagKey<Block> WOODEN_PILLARS = TagKey.of(RegistryKeys.BLOCK, new Identifier(SweetOfHomes.MOD_ID, "wooden_pillars"));
	}

	public static class ITEMS {
		public static final TagKey<Item> WOODEN_PILLARS = TagKey.of(RegistryKeys.ITEM, new Identifier(SweetOfHomes.MOD_ID, "wooden_pillars"));
	}
}

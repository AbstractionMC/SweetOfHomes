package net.rotgruengelb.sweetofhomes.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rotgruengelb.sweetofhomes.SweetOfHomes;

public class SoHBlocks {

	public static final Block AMETHYST_BRICKS = registerBlock("amethyst_bricks", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
	public static final Block CALCITE_BRICKS = registerBlock("calcite_bricks", new Block(FabricBlockSettings.copyOf(Blocks.CALCITE)));
	public static final Block PAPER_WALL = registerBlock("paper_wall", new Block(FabricBlockSettings.copyOf(Blocks.BAMBOO_PLANKS)));
	public static final Block COPPER_BLITZ = registerBlock("copper_blitz", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)));
	public static final Block COPPER_PANELS = registerBlock("copper_panels", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)));

	private static Block registerBlockNoItem(String name, Block block) {
		return Registry.register(Registries.BLOCK, new Identifier(SweetOfHomes.MOD_ID, name), block);
	}

	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, new BlockItem(block, new FabricItemSettings()));
		return Registry.register(Registries.BLOCK, new Identifier(SweetOfHomes.MOD_ID, name), block);
	}

	private static BlockItem registerBlockItem(String name, BlockItem blockItem) {
		BlockItem item = Registry.register(Registries.ITEM, new Identifier(SweetOfHomes.MOD_ID, name), blockItem);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
			content.add(item);
		});
		return item;
	}

	public static void registerModBlocks() {
		SweetOfHomes.LOGGER.debug("Registering SoHBlocks for " + SweetOfHomes.MOD_ID);
	}
}

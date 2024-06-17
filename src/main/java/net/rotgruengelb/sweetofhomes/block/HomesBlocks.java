package net.rotgruengelb.sweetofhomes.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.rotgruengelb.sweetofhomes.SweetOfHomes;

@SuppressWarnings("unused")
public class HomesBlocks {
	public static final Block AMETHYST_BRICKS = registerBlock("amethyst_bricks", new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)));
	public static final Block CALCITE_BRICKS = registerBlock("calcite_bricks", new Block(FabricBlockSettings.copyOf(Blocks.CALCITE)));
	public static final Block PAPER_WALL = registerBlock("paper_wall", new Block(FabricBlockSettings.copyOf(Blocks.BAMBOO_PLANKS)));
	public static final Block COPPER_BLITZ = registerCopperBlitz("copper_blitz", new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.COPPER_BLOCK);
	public static final Block EXPOSED_COPPER_BLITZ = registerCopperBlitz("exposed_copper_blitz", new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.EXPOSED_COPPER);
	public static final Block WEATHERED_COPPER_BLITZ = registerCopperBlitz("weathered_copper_blitz", new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WEATHERED_COPPER);
	public static final Block OXIDIZED_COPPER_BLITZ = registerCopperBlitz("oxidized_copper_blitz", new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.OXIDIZED_COPPER);
	public static final Block WAXED_COPPER_BLITZ = registerCopperBlitz("waxed_copper_blitz", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WAXED_COPPER_BLOCK);
	public static final Block WAXED_EXPOSED_COPPER_BLITZ = registerCopperBlitz("waxed_exposed_copper_blitz", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WAXED_EXPOSED_COPPER);
	public static final Block WAXED_WEATHERED_COPPER_BLITZ = registerCopperBlitz("waxed_weathered_copper_blitz", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WAXED_WEATHERED_COPPER);
	public static final Block WAXED_OXIDIZED_COPPER_BLITZ = registerCopperBlitz("waxed_oxidized_copper_blitz", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WAXED_OXIDIZED_COPPER);
	public static final Block COPPER_PANELS = registerCopperPanels("copper_panels", new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.CUT_COPPER_SLAB, Items.COPPER_BLOCK);
	public static final Block EXPOSED_COPPER_PANELS = registerCopperPanels("exposed_copper_panels", new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.EXPOSED_CUT_COPPER_SLAB, Items.EXPOSED_COPPER);
	public static final Block WEATHERED_COPPER_PANELS = registerCopperPanels("weathered_copper_panels", new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WEATHERED_CUT_COPPER_SLAB, Items.WEATHERED_COPPER);
	public static final Block OXIDIZED_COPPER_PANELS = registerCopperPanels("oxidized_copper_panels", new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.OXIDIZED_CUT_COPPER_SLAB, Items.OXIDIZED_COPPER);
	public static final Block WAXED_COPPER_PANELS = registerCopperPanels("waxed_copper_panels", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WAXED_CUT_COPPER_SLAB, Items.WAXED_COPPER_BLOCK);
	public static final Block WAXED_EXPOSED_COPPER_PANELS = registerCopperPanels("waxed_exposed_copper_panels", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WAXED_EXPOSED_CUT_COPPER_SLAB, Items.WAXED_EXPOSED_COPPER);
	public static final Block WAXED_WEATHERED_COPPER_PANELS = registerCopperPanels("waxed_weathered_copper_panels", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WAXED_WEATHERED_CUT_COPPER_SLAB, Items.WAXED_WEATHERED_COPPER);
	public static final Block WAXED_OXIDIZED_COPPER_PANELS = registerCopperPanels("waxed_oxidized_copper_panels", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WAXED_OXIDIZED_CUT_COPPER_SLAB, Items.WAXED_OXIDIZED_COPPER);
	public static final Block COPPER_PILLAR = registerCopperPillar("copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.COPPER_BLOCK);
	public static final Block EXPOSED_COPPER_PILLAR = registerCopperPillar("exposed_copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.EXPOSED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.EXPOSED_COPPER);
	public static final Block WEATHERED_COPPER_PILLAR = registerCopperPillar("weathered_copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.WEATHERED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WEATHERED_COPPER);
	public static final Block OXIDIZED_COPPER_PILLAR = registerCopperPillar("oxidized_copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.OXIDIZED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.OXIDIZED_COPPER);
	public static final Block WAXED_COPPER_PILLAR = registerCopperPillar("waxed_copper_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WAXED_COPPER_BLOCK);
	public static final Block WAXED_EXPOSED_COPPER_PILLAR = registerCopperPillar("waxed_exposed_copper_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WAXED_EXPOSED_COPPER);
	public static final Block WAXED_WEATHERED_COPPER_PILLAR = registerCopperPillar("waxed_weathered_copper_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WAXED_WEATHERED_COPPER);
	public static final Block WAXED_OXIDIZED_COPPER_PILLAR = registerCopperPillar("waxed_oxidized_copper_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK)), Items.WAXED_OXIDIZED_COPPER);
	public static final Block ACACIA_PILLAR = registerWoodPillar("acacia_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS)), Items.ACACIA_PLANKS);
	public static final Block BIRCH_PILLAR = registerWoodPillar("birch_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS)), Items.BIRCH_PLANKS);
	public static final Block CRIMSON_PILLAR = registerWoodPillar("crimson_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS)), Items.CRIMSON_PLANKS);
	public static final Block DARK_OAK_PILLAR = registerWoodPillar("dark_oak_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS)), Items.DARK_OAK_PLANKS);
	public static final Block JUNGLE_PILLAR = registerWoodPillar("jungle_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_PLANKS)), Items.JUNGLE_PLANKS);
	public static final Block OAK_PILLAR = registerWoodPillar("oak_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)), Items.OAK_PLANKS);
	public static final Block SPRUCE_PILLAR = registerWoodPillar("spruce_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS)), Items.SPRUCE_PLANKS);
	public static final Block WARPED_PILLAR = registerWoodPillar("warped_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS)), Items.WARPED_PLANKS);
	public static final Block CHERRY_PILLAR = registerWoodPillar("cherry_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)), Items.CHERRY_PLANKS);
	public static final Block MANGROVE_PILLAR = registerWoodPillar("mangrove_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.MANGROVE_PLANKS)), Items.MANGROVE_PLANKS);
	public static final Block BAMBOO_PILLAR = registerWoodPillar("bamboo_pillar", new PillarBlock(FabricBlockSettings.copyOf(Blocks.BAMBOO_PLANKS)), Items.BAMBOO_PLANKS);
	public static final Block ACACIA_CHAIR = registerChair("acacia_chair", new ChairBlock(chairSettings(Blocks.ACACIA_PLANKS)));
	public static final Block BIRCH_CHAIR = registerChair("birch_chair", new ChairBlock(chairSettings(Blocks.BIRCH_PLANKS)));
	public static final Block CRIMSON_CHAIR = registerChair("crimson_chair", new ChairBlock(chairSettings(Blocks.CRIMSON_PLANKS)));
	public static final Block DARK_OAK_CHAIR = registerChair("dark_oak_chair", new ChairBlock(chairSettings(Blocks.DARK_OAK_PLANKS)));
	public static final Block JUNGLE_CHAIR = registerChair("jungle_chair", new ChairBlock(chairSettings(Blocks.JUNGLE_PLANKS)));
	public static final Block OAK_CHAIR = registerChair("oak_chair", new ChairBlock(chairSettings(Blocks.OAK_PLANKS)));
	public static final Block SPRUCE_CHAIR = registerChair("spruce_chair", new ChairBlock(chairSettings(Blocks.SPRUCE_PLANKS)));
	public static final Block WARPED_CHAIR = registerChair("warped_chair", new ChairBlock(chairSettings(Blocks.WARPED_PLANKS)));
	public static final Block CHERRY_CHAIR = registerChair("cherry_chair", new ChairBlock(chairSettings(Blocks.CHERRY_PLANKS)));
	public static final Block MANGROVE_CHAIR = registerChair("mangrove_chair", new ChairBlock(chairSettings(Blocks.MANGROVE_PLANKS)));
	public static final Block BAMBOO_CHAIR = registerChair("bamboo_chair", new ChairBlock(chairSettings(Blocks.BAMBOO_PLANKS)));

	private static Block registerBlockNoItem(String name, Block block) {
		return registerBlock(name, block, false);
	}

	private static Block registerBlock(String name, Block block, boolean withItem) {
		SHomesBlocksCollections.BLOCKS.add(block);
		if (withItem) {
			registerBlockItem(name, new BlockItem(block, new FabricItemSettings()));
		}
		return Registry.register(Registries.BLOCK, new Identifier(SweetOfHomes.MOD_ID, name), block);
	}

	private static Block registerBlock(String name, Block block) {
		return registerBlock(name, block, true);
	}

	private static Block registerCopperBlitz(String name, Block block, Item base) {
		SHomesBlocksCollections.CRAFTING_GEN.COPPER_BLITZ_CRAFTING.put(block, base);
		SHomesBlocksCollections.COPPER_BLOCKS.add(block);
		return registerBlock(name, block);
	}

	private static Block registerChair(String name, Block block) {
		SHomesBlocksCollections.WOOD_BLOCKS.add(block);
		SHomesBlocksCollections.CHAIR_BOCKS.add((ChairBlock) block);
		return registerBlock(name, block);
	}

	private static FabricBlockSettings chairSettings(Block block) {
		return FabricBlockSettings.copyOf(block)
				.nonOpaque()
				.allowsSpawning(Blocks::never)
				.solidBlock(Blocks::never)
				.suffocates(Blocks::never)
				.blockVision(Blocks::never);
	}

	private static Block registerCopperPillar(String name, Block block, Item base) {
		SHomesBlocksCollections.CRAFTING_GEN.COPPER_PILLAR_CRAFTING.put(block, base);
		SHomesBlocksCollections.COPPER_BLOCKS.add(block);
		return registerBlock(name, block);
	}

	private static Block registerWoodPillar(String name, Block block, Item base) {
		SHomesBlocksCollections.addWoodPillar(block, base);
		return registerBlock(name, block);
	}

	private static Block registerCopperPanels(String name, Block block, Item base, Item cuttingBase) {
		SHomesBlocksCollections.CRAFTING_GEN.COPPER_PANELS_CRAFTING.put(block, new Pair<>(base, cuttingBase));
		SHomesBlocksCollections.COPPER_BLOCKS.add(block);
		return registerBlock(name, block);
	}

	private static void registerBlockItem(String name, BlockItem blockItem) {
		BlockItem item = Registry.register(Registries.ITEM, new Identifier(SweetOfHomes.MOD_ID, name), blockItem);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
				.register(content -> content.add(item));
	}

	public static void registerModBlocks() {
		SweetOfHomes.LOGGER.debug("Registering HomesBlocks for " + SweetOfHomes.MOD_ID);

		SHomesBlocksCollections.initializeCollections();
	}
}

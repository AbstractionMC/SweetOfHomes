package net.rotgruengelb.sweetofhomes.block;

import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Pair;

import java.util.*;

import static net.rotgruengelb.sweetofhomes.block.HomesBlocks.*;

public class SHomesBlocksCollections {
	public static final List<Block> BLOCKS = new ArrayList<>();
	public static final List<Block> COPPER_BLOCKS = new ArrayList<>();
	public static final List<Block> WOOD_BLOCKS = new ArrayList<>();
	public static final List<Block> WOODEN_PILLAR_BLOCKS = new ArrayList<>();
	public static final List<ChairBlock> CHAIR_BOCKS = new ArrayList<>();

	private static void copperBlocksHelper(Block unaffected, Block exposed, Block weathered, Block oxidized, Block waxedUnaffected, Block waxedExposed, Block waxedWeathered, Block waxedOxidized) {
		OxidizableBlocksRegistry.registerOxidizableBlockPair(unaffected, exposed);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(exposed, weathered);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(weathered, oxidized);

		OxidizableBlocksRegistry.registerWaxableBlockPair(unaffected, waxedUnaffected);
		OxidizableBlocksRegistry.registerWaxableBlockPair(exposed, waxedExposed);
		OxidizableBlocksRegistry.registerWaxableBlockPair(weathered, waxedWeathered);
		OxidizableBlocksRegistry.registerWaxableBlockPair(oxidized, waxedOxidized);
	}

	public static void initializeCollections() {
		SHomesBlocksCollections.copperBlocksSimpleModelHelper(COPPER_PANELS, EXPOSED_COPPER_PANELS, WEATHERED_COPPER_PANELS, OXIDIZED_COPPER_PANELS, WAXED_COPPER_PANELS, WAXED_EXPOSED_COPPER_PANELS, WAXED_WEATHERED_COPPER_PANELS, WAXED_OXIDIZED_COPPER_PANELS);
		SHomesBlocksCollections.copperBlocksSimpleModelHelper(COPPER_BLITZ, EXPOSED_COPPER_BLITZ, WEATHERED_COPPER_BLITZ, OXIDIZED_COPPER_BLITZ, WAXED_COPPER_BLITZ, WAXED_EXPOSED_COPPER_BLITZ, WAXED_WEATHERED_COPPER_BLITZ, WAXED_OXIDIZED_COPPER_BLITZ);
		SHomesBlocksCollections.copperBlocksPillarModelHelper(COPPER_PILLAR, EXPOSED_COPPER_PILLAR, WEATHERED_COPPER_PILLAR, OXIDIZED_COPPER_PILLAR, WAXED_COPPER_PILLAR, WAXED_EXPOSED_COPPER_PILLAR, WAXED_WEATHERED_COPPER_PILLAR, WAXED_OXIDIZED_COPPER_PILLAR);
	}

	public static void copperBlocksSimpleModelHelper(Block unaffected, Block exposed, Block weathered, Block oxidized, Block waxedUnaffected, Block waxedExposed, Block waxedWeathered, Block waxedOxidized) {
		copperBlocksHelper(unaffected, exposed, weathered, oxidized, waxedUnaffected, waxedExposed, waxedWeathered, waxedOxidized);

		MODEL_GEN.UNWAXED_COPPER_BLOCKS_SIMPLE_MODEL.addAll(Arrays.asList(unaffected, exposed, weathered, oxidized));
		MODEL_GEN.WAXED_COPPER_BLOCKS_SIMPLE_MODEL.addAll(Arrays.asList(waxedUnaffected, waxedExposed, waxedWeathered, waxedOxidized));
	}

	public static void copperBlocksPillarModelHelper(Block unaffected, Block exposed, Block weathered, Block oxidized, Block waxedUnaffected, Block waxedExposed, Block waxedWeathered, Block waxedOxidized) {
		copperBlocksHelper(unaffected, exposed, weathered, oxidized, waxedUnaffected, waxedExposed, waxedWeathered, waxedOxidized);

		MODEL_GEN.UNWAXED_COPPER_BLOCKS_PILLAR_MODEL.addAll(Arrays.asList(unaffected, exposed, weathered, oxidized));
		MODEL_GEN.WAXED_COPPER_BLOCKS_PILLAR_MODEL.addAll(Arrays.asList(waxedUnaffected, waxedExposed, waxedWeathered, waxedOxidized));
	}

	public static void addWoodPillar(Block block, Item base) {
		WOOD_BLOCKS.add(block);
		WOODEN_PILLAR_BLOCKS.add(block);
		MODEL_GEN.WOOD_BLOCKS_PILLAR_MODEL.add(block);
		CRAFTING_GEN.WOOD_PILLAR_CRAFTING.put(block, base);
	}

	public static class MODEL_GEN {
		public static final List<Block> UNWAXED_COPPER_BLOCKS_SIMPLE_MODEL = new ArrayList<>();
		public static final List<Block> WAXED_COPPER_BLOCKS_SIMPLE_MODEL = new ArrayList<>();

		public static final List<Block> UNWAXED_COPPER_BLOCKS_PILLAR_MODEL = new ArrayList<>();
		public static final List<Block> WAXED_COPPER_BLOCKS_PILLAR_MODEL = new ArrayList<>();

		public static final List<Block> WOOD_BLOCKS_PILLAR_MODEL = new ArrayList<>();
	}

	public static class CRAFTING_GEN {
		public static final Map<ItemConvertible, Pair<Item, Item>> COPPER_PANELS_CRAFTING = new HashMap<>();
		public static final Map<ItemConvertible, Item> COPPER_BLITZ_CRAFTING = new HashMap<>();
		public static final Map<ItemConvertible, Item> COPPER_PILLAR_CRAFTING = new HashMap<>();

		public static final Map<ItemConvertible, Item> WOOD_PILLAR_CRAFTING = new HashMap<>();
	}
}

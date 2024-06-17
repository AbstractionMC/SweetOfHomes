package net.rotgruengelb.sweetofhomes.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.rotgruengelb.sweetofhomes.block.HomesBlocks;
import net.rotgruengelb.sweetofhomes.block.SHomesBlocksCollections;
import net.rotgruengelb.sweetofhomes.util.tag.HomesTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		FabricTagBuilder pickaxe_mineable = getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(HomesBlocks.AMETHYST_BRICKS)
				.add(HomesBlocks.CALCITE_BRICKS);

		FabricTagBuilder needs_stone_tool = getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL);

		SHomesBlocksCollections.COPPER_BLOCKS.forEach(block -> {
			pickaxe_mineable.add(block);
			needs_stone_tool.add(block);
		});
		SHomesBlocksCollections.WOOD_BLOCKS.forEach(block -> getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(block));
		SHomesBlocksCollections.WOODEN_PILLAR_BLOCKS.forEach(block -> getOrCreateTagBuilder(HomesTags.BLOCKS.WOODEN_PILLARS).add(block));
		getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(HomesBlocks.PAPER_WALL);
		getOrCreateTagBuilder(BlockTags.VIBRATION_RESONATORS).add(HomesBlocks.AMETHYST_BRICKS);
		getOrCreateTagBuilder(BlockTags.CRYSTAL_SOUND_BLOCKS).add(HomesBlocks.AMETHYST_BRICKS);

	}
}

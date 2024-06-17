package net.rotgruengelb.sweetofhomes.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.rotgruengelb.sweetofhomes.block.HomesBlocks;
import net.rotgruengelb.sweetofhomes.block.SHomesBlocksCollections;
import net.rotgruengelb.sweetofhomes.item.HomesItems;
import net.rotgruengelb.sweetofhomes.util.tag.HomesTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

	public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		SHomesBlocksCollections.WOODEN_PILLAR_BLOCKS.forEach(block -> getOrCreateTagBuilder(HomesTags.ITEMS.WOODEN_PILLARS).add(block.asItem()));
		getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD).add(HomesBlocks.WARPED_PILLAR.asItem())
				.add(HomesBlocks.CRIMSON_PILLAR.asItem());
		getOrCreateTagBuilder(ConventionalItemTags.NUGGETS).add(HomesItems.COPPER_NUGGET);
	}
}

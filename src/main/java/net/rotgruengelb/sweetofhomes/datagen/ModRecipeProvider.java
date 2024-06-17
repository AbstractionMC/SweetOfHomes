package net.rotgruengelb.sweetofhomes.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.rotgruengelb.sweetofhomes.block.HomesBlocks;
import net.rotgruengelb.sweetofhomes.block.SHomesBlocksCollections;
import net.rotgruengelb.sweetofhomes.item.HomesItems;

public class ModRecipeProvider extends FabricRecipeProvider {
	public ModRecipeProvider(FabricDataOutput output) {
		super(output);
	}

	public static void offer2x2ABBARecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible inputA, ItemConvertible inputB, int count) {
		ShapedRecipeJsonBuilder.create(category, output, count)
				.input('A', inputA)
				.input('B', inputB)
				.pattern("AB")
				.pattern("BA")
				.criterion(RecipeProvider.hasItem(inputA), RecipeProvider.conditionsFromItem(inputA))
				.criterion(RecipeProvider.hasItem(inputB), RecipeProvider.conditionsFromItem(inputB))
				.offerTo(exporter);
	}

	public static void offer3x3PillarRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible inputCore, ItemConvertible inputSide, int count) {
		ShapedRecipeJsonBuilder.create(category, output, count)
				.input('S', inputSide)
				.input('C', inputCore)
				.pattern("SCS")
				.pattern("SCS")
				.pattern("SCS")
				.criterion(RecipeProvider.hasItem(inputCore), RecipeProvider.conditionsFromItem(inputCore))
				.criterion(RecipeProvider.hasItem(inputSide), RecipeProvider.conditionsFromItem(inputSide))
				.offerTo(exporter);
	}

	public static void offer2x2CompactingRecipe(RecipeExporter exporter, RecipeCategory category, ItemConvertible output, ItemConvertible input, int count) {
		ShapedRecipeJsonBuilder.create(category, output, count)
				.input('#', input)
				.pattern("##")
				.pattern("##")
				.criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input))
				.offerTo(exporter);
	}

	@Override
	public void generate(RecipeExporter exporter) {

		SHomesBlocksCollections.CRAFTING_GEN.COPPER_BLITZ_CRAFTING.forEach((block, base) -> {
			offer2x2ABBARecipe(exporter, RecipeCategory.BUILDING_BLOCKS, block, HomesItems.COPPER_NUGGET, base, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, block, base, 4);
		});

		SHomesBlocksCollections.CRAFTING_GEN.COPPER_PANELS_CRAFTING.forEach((block, basePair) -> {
			offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, block, basePair.getLeft(), 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, block, basePair.getRight(), 4);
		});

		SHomesBlocksCollections.CRAFTING_GEN.COPPER_PILLAR_CRAFTING.forEach((block, core) -> {
			offer3x3PillarRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, block, core, HomesItems.COPPER_NUGGET, 4);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, block, core, 4);
		});

		SHomesBlocksCollections.CRAFTING_GEN.WOOD_PILLAR_CRAFTING.forEach((block, base) -> offer3x3PillarRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, block, base, Items.STICK, 4));

		offer2x2ABBARecipe(exporter, RecipeCategory.BUILDING_BLOCKS, HomesBlocks.AMETHYST_BRICKS, Items.AMETHYST_SHARD, Items.AMETHYST_BLOCK, 2);
		offer2x2ABBARecipe(exporter, RecipeCategory.BUILDING_BLOCKS, HomesBlocks.PAPER_WALL, Items.STICK, Items.PAPER, 4);
		offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, HomesBlocks.CALCITE_BRICKS, Items.CALCITE, 4);
		offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, HomesBlocks.CALCITE_BRICKS, Items.CALCITE, 4);
		offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, HomesItems.COPPER_NUGGET, RecipeCategory.MISC, Items.COPPER_INGOT);
	}
}

package net.rotgruengelb.sweetofhomes.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;
import net.rotgruengelb.sweetofhomes.block.ChairBlock;
import net.rotgruengelb.sweetofhomes.block.HomesBlocks;
import net.rotgruengelb.sweetofhomes.block.SHomesBlocksCollections;
import net.rotgruengelb.sweetofhomes.item.HomesItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
	public static final TexturedModel.Factory CUBE_ALL_NO_WAXED = TexturedModel.makeFactory(ModModelProvider::allRemoveWaxed, Models.CUBE_ALL);
	public static final TexturedModel.Factory TEMPLATE_CHAIR = TexturedModel.makeFactory(TextureMap::texture, MODELS.TEMPLATE_CHAIR);

	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	public static TextureMap allRemoveWaxed(Block block) {
		Identifier identifier = TextureMap.getId(block);
		identifier = new Identifier(identifier.getNamespace(), identifier.getPath()
				.replace("waxed_", ""));
		return TextureMap.all(identifier);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator gen) {
		gen.registerSimpleCubeAll(HomesBlocks.AMETHYST_BRICKS);
		gen.registerSimpleCubeAll(HomesBlocks.CALCITE_BRICKS);
		gen.registerSimpleCubeAll(HomesBlocks.PAPER_WALL);
		for (int i = 0; i < SHomesBlocksCollections.MODEL_GEN.WAXED_COPPER_BLOCKS_SIMPLE_MODEL.size(); i++) {
			gen.registerSimpleCubeAll(SHomesBlocksCollections.MODEL_GEN.UNWAXED_COPPER_BLOCKS_SIMPLE_MODEL.get(i));
			gen.registerParented(SHomesBlocksCollections.MODEL_GEN.UNWAXED_COPPER_BLOCKS_SIMPLE_MODEL.get(i), SHomesBlocksCollections.MODEL_GEN.WAXED_COPPER_BLOCKS_SIMPLE_MODEL.get(i));
		}
		for (int i = 0; i < SHomesBlocksCollections.MODEL_GEN.WAXED_COPPER_BLOCKS_PILLAR_MODEL.size(); i++) {
			gen.registerAxisRotated(SHomesBlocksCollections.MODEL_GEN.UNWAXED_COPPER_BLOCKS_PILLAR_MODEL.get(i), TexturedModel.CUBE_ALL);
			gen.registerAxisRotated(SHomesBlocksCollections.MODEL_GEN.WAXED_COPPER_BLOCKS_PILLAR_MODEL.get(i), CUBE_ALL_NO_WAXED);
		}
		SHomesBlocksCollections.CHAIR_BOCKS.forEach(block -> registerChair(block, gen));
		SHomesBlocksCollections.MODEL_GEN.WOOD_BLOCKS_PILLAR_MODEL.forEach(block -> gen.registerAxisRotated(block, TexturedModel.CUBE_ALL));

	}

	@Override
	public void generateItemModels(ItemModelGenerator gen) {
		gen.register(HomesItems.COPPER_NUGGET, Models.GENERATED);
		gen.register(HomesItems.COPPER_WRENCH, Models.HANDHELD);
	}

	public final void registerChair(ChairBlock chair, BlockStateModelGenerator generator) {
		Identifier identifier = TEMPLATE_CHAIR.upload(chair, generator.modelCollector);
		generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(chair, identifier)
				.coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
	}

	private static class MODELS {
		public static final Model TEMPLATE_CHAIR = block("template_chair", TextureKey.TEXTURE);

		private static Model block(String parent, TextureKey... requiredTextureKeys) {
			return new Model(Optional.of(new Identifier("sweetofhomes", "block/" + parent)), Optional.empty(), requiredTextureKeys);
		}
	}
}

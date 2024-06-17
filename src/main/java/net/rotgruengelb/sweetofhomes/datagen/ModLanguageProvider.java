package net.rotgruengelb.sweetofhomes.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.rotgruengelb.sweetofhomes.block.SHomesBlocksCollections;
import net.rotgruengelb.sweetofhomes.item.HomesItems;

public class ModLanguageProvider extends FabricLanguageProvider {
	protected ModLanguageProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	public static String convertSnakeCaseToTitleCase(String snakeCaseText) {
		String[] words = snakeCaseText.split("_");

		StringBuilder titleCaseText = new StringBuilder();

		for (String word : words) {
			if (!word.isEmpty()) {
				titleCaseText.append(Character.toUpperCase(word.charAt(0)))
						.append(word.substring(1)
								.toLowerCase())
						.append(" ");
			}
		}
		return titleCaseText.toString()
				.trim();
	}

	@Override
	public void generateTranslations(TranslationBuilder translationBuilder) {
		for (Block block : SHomesBlocksCollections.BLOCKS) {
			translationBuilder.add(block, convertSnakeCaseToTitleCase(Registries.BLOCK.getId(block)
					.getPath()));
		}
		for (Item item : HomesItems.ALL.ITEMS) {
			translationBuilder.add(item, convertSnakeCaseToTitleCase(Registries.ITEM.getId(item)
					.getPath()));
		}
	}
}

package net.rotgruengelb.sweetofhomes.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.rotgruengelb.sweetofhomes.block.SHomesBlocksCollections;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
	protected ModLootTableProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		for (Block block : SHomesBlocksCollections.BLOCKS) {
			addDrop(block);
		}
	}
}

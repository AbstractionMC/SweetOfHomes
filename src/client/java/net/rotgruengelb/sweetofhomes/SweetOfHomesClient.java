package net.rotgruengelb.sweetofhomes;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.rotgruengelb.sweetofhomes.block.SHomesBlocksCollections;
import net.rotgruengelb.sweetofhomes.client.render.entity.ChairEntityRenderer;
import net.rotgruengelb.sweetofhomes.entity.HomesEntities;

public class SweetOfHomesClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		SHomesBlocksCollections.CHAIR_BOCKS.forEach((block) -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));
		EntityRendererRegistry.register(HomesEntities.CHAIR_ENTITY, ChairEntityRenderer::new); }
}
package net.rotgruengelb.sweetofhomes.client.render.entity;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.rotgruengelb.sweetofhomes.entity.ChairEntity;

public class ChairEntityRenderer extends EntityRenderer<ChairEntity> {

	public ChairEntityRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
	}

	@Override
	public Identifier getTexture(ChairEntity entity) {
		if (MinecraftClient.getInstance().crosshairTarget instanceof EntityHitResult entityHitResult) {
			Entity hitEntity = entityHitResult.getEntity();
		}

		return null;
	}
}

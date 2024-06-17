package net.rotgruengelb.sweetofhomes.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rotgruengelb.sweetofhomes.SweetOfHomes;

public class HomesEntities {
	public static final EntityType<ChairEntity> CHAIR_ENTITY = Registry.register(Registries.ENTITY_TYPE, new Identifier(SweetOfHomes.MOD_ID, "chair_entity"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, ChairEntity::new)
			.dimensions(EntityDimensions.fixed(0f, 0f))
			.build());

	public static void registerModEntities() {
		SweetOfHomes.LOGGER.debug("Registering HomesEntities for " + SweetOfHomes.MOD_ID);
	}
}

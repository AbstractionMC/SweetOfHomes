package net.rotgruengelb.sweetofhomes.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class OxidizablePillarBlock extends PillarBlock implements Oxidizable {
	public static final MapCodec<OxidizablePillarBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(OxidationLevel.CODEC.fieldOf("weathering_state")
					.forGetter(Degradable::getDegradationLevel), createSettingsCodec())
			.apply(instance, OxidizablePillarBlock::new));
	private final Oxidizable.OxidationLevel oxidationLevel;

	public OxidizablePillarBlock(Oxidizable.OxidationLevel oxidationLevel, AbstractBlock.Settings settings) {
		super(settings);
		this.oxidationLevel = oxidationLevel;
	}

	public MapCodec<OxidizablePillarBlock> getCodec() {
		return CODEC;
	}

	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		this.tickDegradation(state, world, pos, random);
	}

	public boolean hasRandomTicks(BlockState state) {
		return Oxidizable.getIncreasedOxidationBlock(state.getBlock())
				.isPresent();
	}

	public Oxidizable.OxidationLevel getDegradationLevel() {
		return this.oxidationLevel;
	}
}

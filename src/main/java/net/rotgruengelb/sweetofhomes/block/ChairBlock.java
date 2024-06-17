package net.rotgruengelb.sweetofhomes.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.rotgruengelb.sweetofhomes.entity.ChairEntity;

import java.util.stream.Stream;

public class ChairBlock extends HorizontalFacingBlock implements Waterloggable {
	public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
	public static final MapCodec<ChairBlock> CODEC = ChairBlock.createCodec(ChairBlock::new);

	public ChairBlock(AbstractBlock.Settings settings) {
		super(settings);
		this.setDefaultState(this.stateManager.getDefaultState()
				.with(FACING, Direction.NORTH)
				.with(WATERLOGGED, false));
	}

	public MapCodec<ChairBlock> getCodec() {
		return CODEC;
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		FluidState fluidState = ctx.getWorld()
				.getFluidState(ctx.getBlockPos());
		return this.getDefaultState()
				.with(FACING, ctx.getHorizontalPlayerFacing()
						.getOpposite())
				.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return ChairVoxelShapes.getVoxelShapeForDirection(state.get(FACING));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		if (state.get(WATERLOGGED)) {
			return Fluids.WATER.getStill(false);
		}
		return super.getFluidState(state);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING)
				.add(WATERLOGGED);
	}

	@Override
	public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
		return false;
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		return ChairEntity.make(world, pos, 0.2, player, state.get(FACING));
	}

	private static class ChairVoxelShapes {
		public static final VoxelShape SOUTH_VOXELSHAPE = Stream.of(Block.createCuboidShape(12, 0, 12, 14, 7, 14), Block.createCuboidShape(2, 0, 12, 4, 7, 14), Block.createCuboidShape(12, 0, 2, 14, 7, 4), Block.createCuboidShape(2, 0, 2, 4, 7, 4), Block.createCuboidShape(1, 7, 1, 15, 9, 15), Block.createCuboidShape(2, 9, 1, 14, 24, 3))
				.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR))
				.get();
		public static final VoxelShape WEST_VOXELSHAPE = Stream.of(Block.createCuboidShape(2, 0, 12, 4, 7, 14), Block.createCuboidShape(2, 0, 2, 4, 7, 4), Block.createCuboidShape(12, 0, 12, 14, 7, 14), Block.createCuboidShape(12, 0, 2, 14, 7, 4), Block.createCuboidShape(1, 7, 1, 15, 9, 15), Block.createCuboidShape(13, 9, 2, 15, 24, 14))
				.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR))
				.get();
		private static final VoxelShape NORTH_VOXELSHAPE = Stream.of(Block.createCuboidShape(2, 0, 2, 4, 7, 4), Block.createCuboidShape(12, 0, 2, 14, 7, 4), Block.createCuboidShape(2, 0, 12, 4, 7, 14), Block.createCuboidShape(12, 0, 12, 14, 7, 14), Block.createCuboidShape(1, 7, 1, 15, 9, 15), Block.createCuboidShape(2, 9, 13, 14, 24, 15))
				.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR))
				.get();
		private static final VoxelShape EAST_VOXELSHAPE = Stream.of(Block.createCuboidShape(12, 0, 2, 14, 7, 4), Block.createCuboidShape(12, 0, 12, 14, 7, 14), Block.createCuboidShape(2, 0, 2, 4, 7, 4), Block.createCuboidShape(2, 0, 12, 4, 7, 14), Block.createCuboidShape(1, 7, 1, 15, 9, 15), Block.createCuboidShape(1, 9, 2, 3, 24, 14))
				.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR))
				.get();

		public static VoxelShape getVoxelShapeForDirection(Direction direction) {
			return switch (direction) {
				case EAST -> EAST_VOXELSHAPE;
				case SOUTH -> SOUTH_VOXELSHAPE;
				case WEST -> WEST_VOXELSHAPE;
				default -> NORTH_VOXELSHAPE;
			};
		}
	}
}
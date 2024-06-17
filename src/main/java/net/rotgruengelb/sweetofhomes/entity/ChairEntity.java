package net.rotgruengelb.sweetofhomes.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class ChairEntity extends Entity {
	public ChairEntity(EntityType<? extends Entity> type, World world) {
		super(HomesEntities.CHAIR_ENTITY, world);
		this.setNoGravity(true);
	}

	private ChairEntity(World world, BlockPos blockPos, double yOffset, Direction direction) {
		this(HomesEntities.CHAIR_ENTITY, world);
		this.setPos(blockPos.getX() + 0.5, blockPos.getY() + yOffset, blockPos.getZ() + 0.5);
		this.setRotation(direction.asRotation(), 0F);
	}

	public static ActionResult make(World world, BlockPos pos, double yOffset, PlayerEntity player, Direction direction) {
		if (!world.isClient) {
			List<ChairEntity> seats = world.getEntitiesByClass(ChairEntity.class, new Box(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0, pos.getY() + 1.0, pos.getZ() + 1.0), entity -> true);
			if (seats.isEmpty()) {
				ChairEntity seat = new ChairEntity(world, pos, yOffset, direction);
				world.spawnEntity(seat);
				player.startRiding(seat, false);
			}
		}
		return ActionResult.SUCCESS;
	}

	@Override
	protected void initDataTracker() { }

	@Override
	public void tick() {
		super.tick();
		if (!this.getWorld().isClient) {
			if (this.getPassengerList()
					.isEmpty() || this.getWorld()
					.isAir(this.getBlockPos())) {
				this.remove(RemovalReason.DISCARDED);
				this.getWorld()
						.updateNeighbors(getBlockPos(), this.getWorld()
								.getBlockState(getBlockPos())
								.getBlock());
			}
		}
	}

	@Override
	protected void readCustomDataFromNbt(NbtCompound nbt) { }

	@Override
	protected void writeCustomDataToNbt(NbtCompound nbt) { }

	//	@Override
	//	public double getPassengersRidingOffset() {
	//		return 0.0;
	//	}

	@Override
	protected boolean canAddPassenger(Entity entity) {
		return entity instanceof LivingEntity;
	}

	//	@Override
	//	public Vec3d updatePassengerForDismount(LivingEntity passenger) {
	//		Direction original = this.getMovementDirection();
	//		Direction[] offsets = {original, original.rotateYClockwise(), original.rotateYCounterclockwise(), original.getOpposite()};
	//		for (Direction dir : offsets) {
	//			Vec3d safeVec = Dismounting.findRespawnPos(passenger.getType(), this.getWorld(), passenger.getBlockPos()
	//					.offset(dir), false);
	//			if (safeVec != null) {
	//				return safeVec.add(0, 0.25, 0);
	//			}
	//		}
	//		return super.updatePassengerForDismount(passenger);
	//	}

	@Override
	protected void addPassenger(Entity entity) {
		super.addPassenger(entity);
		entity.setBodyYaw(this.getYaw());
	}

	@Override
	protected void updatePassengerPosition(Entity passenger, PositionUpdater positionUpdater) {
		super.updatePassengerPosition(passenger, positionUpdater);
		this.clampYaw(passenger);
	}

	@Override
	public void onPassengerLookAround(Entity passenger) {
		this.clampYaw(passenger);
		super.onPassengerLookAround(passenger);
	}

	private void clampYaw(Entity untypedPassenger) {
		if (!(untypedPassenger instanceof LivingEntity passenger)) {
			return;
		}
		float wrappedYaw = MathHelper.wrapDegrees(passenger.getBodyYaw() - this.getYaw());
		float clampedYaw = MathHelper.clamp(wrappedYaw, -120.0F, 120.0F);
		passenger.bodyYaw = clampedYaw - wrappedYaw;
		passenger.headYaw = passenger.getBodyYaw();

	}
}
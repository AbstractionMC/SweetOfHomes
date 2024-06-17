package net.rotgruengelb.sweetofhomes.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.rotgruengelb.sweetofhomes.world.HomesGameRules;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class CopperWrenchItem extends Item {

	public CopperWrenchItem(Settings settings) {
		super(settings);
	}

	private static <T extends Comparable<T>> BlockState cycle(BlockState state, Property<T> property, boolean inverse) {
		return state.with(property, CopperWrenchItem.cycle(property.getValues(), state.get(property), inverse));
	}

	private static <T> T cycle(Iterable<T> elements, @Nullable T current, boolean inverse) {
		return inverse ? Util.previous(elements, current) : Util.next(elements, current);
	}

	private static void sendMessage(PlayerEntity player, Text message) {
		if (player.getWorld()
				.getGameRules()
				.getBoolean(HomesGameRules.SHOW_COPPER_WRENCH_MESSAGES)) {
			((ServerPlayerEntity) player).sendMessageToClient(message, true);
		}
	}

	private static <T extends Comparable<T>> String getValueString(BlockState state, Property<T> property) {
		return property.name(state.get(property));
	}

	@Override
	public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity player) {
		if (!world.isClient) {
			this.use(player, state, world, pos, false, player.getStackInHand(Hand.MAIN_HAND));
		}
		return false;
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		BlockPos blockPos;
		PlayerEntity playerEntity = context.getPlayer();
		World world = context.getWorld();
		if (!world.isClient && playerEntity != null && !this.use(playerEntity, world.getBlockState(blockPos = context.getBlockPos()), world, blockPos, true, context.getStack())) {
			return ActionResult.FAIL;
		}
		return ActionResult.success(world.isClient);
	}

	private boolean use(PlayerEntity player, BlockState state, WorldAccess world, BlockPos pos, boolean update, ItemStack stack) {
		Block block = state.getBlock();
		StateManager<Block, BlockState> stateManager = block.getStateManager();
		Collection<Property<?>> collection = stateManager.getProperties();
		String string = Registries.BLOCK.getId(block)
				.toString();
		if (collection.isEmpty()) {
			return false;
		}
		NbtCompound nbtCompound = stack.getOrCreateSubNbt("SelectedProperty");
		String string2 = nbtCompound.getString(string);
		Property<?> property = stateManager.getProperty(string2);
		if (update) {
			if (property == null) {
				property = collection.iterator()
						.next();
			}
			BlockState blockState = CopperWrenchItem.cycle(state, property, player.shouldCancelInteraction());
			world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS | Block.FORCE_STATE);
			player.playSound(SoundEvents.ITEM_SPYGLASS_USE, 1.0f, 1.0f);
			player.incrementStat(Stats.USED.getOrCreateStat(this));
			CopperWrenchItem.sendMessage(player, Text.translatable(this.getTranslationKey() + ".update", property.getName(), CopperWrenchItem.getValueString(blockState, property)));
		} else {
			property = CopperWrenchItem.cycle(collection, property, player.shouldCancelInteraction());
			String propertyName = property.getName();
			nbtCompound.putString(string, propertyName);
			CopperWrenchItem.sendMessage(player, Text.translatable(this.getTranslationKey() + ".select", propertyName, CopperWrenchItem.getValueString(state, property)));
		}
		return true;
	}
}


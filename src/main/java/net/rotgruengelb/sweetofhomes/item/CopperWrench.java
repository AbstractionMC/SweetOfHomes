package net.rotgruengelb.sweetofhomes.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CopperWrench extends Item {
	public CopperWrench(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
		playerEntity.playSound(SoundEvents.ENTITY_VILLAGER_WORK_TOOLSMITH, 1, 1);
		return TypedActionResult.success(playerEntity.getStackInHand(hand));
	}
}
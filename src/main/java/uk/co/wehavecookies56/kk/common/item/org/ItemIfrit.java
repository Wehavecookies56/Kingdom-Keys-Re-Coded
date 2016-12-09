package uk.co.wehavecookies56.kk.common.item.org;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityIfrit;

public class ItemIfrit extends ItemChakram {
	public ItemIfrit (ToolMaterial material) {
		super(material);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {
		if(!player.getCapability(ModCapabilities.PLAYER_STATS, null).getRecharge())
		{
			if (!player.isSneaking()) {
				world.playSound(player.posX, player.posY, player.posZ, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), false);
				EntityIfrit entity = new EntityIfrit(world, player);
				world.spawnEntity(entity);
				entity.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1f, 1);
				if (!player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) 
					player.getCapability(ModCapabilities.PLAYER_STATS, null).remMP(7);
				player.swingArm(hand);
			}
			return ActionResult.newResult(EnumActionResult.SUCCESS, itemStack);
		}
		return ActionResult.newResult(EnumActionResult.FAIL, itemStack);
	}
}
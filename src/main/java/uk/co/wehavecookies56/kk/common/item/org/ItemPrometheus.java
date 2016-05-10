package uk.co.wehavecookies56.kk.common.item.org;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityPrometheus;

public class ItemPrometheus extends ItemChakram {
	public ItemPrometheus (ToolMaterial material) {
		super(material);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {
		if (!player.isSneaking()) {
			world.playSound(player.posX, player.posY, player.posZ, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), false);
			EntityPrometheus entity = new EntityPrometheus(world, player);
			world.spawnEntityInWorld(entity);
			entity.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1f, 1);
			player.swingArm(hand);
		}
		return ActionResult.newResult(EnumActionResult.SUCCESS, itemStack);
	}
}

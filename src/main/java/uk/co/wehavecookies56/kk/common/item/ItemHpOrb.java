package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemHpOrb extends Item {
	public ItemHpOrb () {
		setMaxStackSize(64);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player, EnumHand hand) {
		if (!(player.getHealth() == 20)) {
			player.heal(2);
			player.inventory.decrStackSize(player.inventory.currentItem, 1);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
	}
}

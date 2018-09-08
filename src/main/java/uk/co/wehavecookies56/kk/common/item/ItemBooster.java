package uk.co.wehavecookies56.kk.common.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.api.menu.IItemCategory;
import uk.co.wehavecookies56.kk.api.menu.ItemCategory;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKBase;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.RemoveItemInSlotAndGiveEffect;

public class ItemBooster extends ItemKKBase implements IItemCategory{
	public ItemBooster(String name) {
		super(name);
		setMaxStackSize(1);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (world.isRemote) {
			if (player.getHeldItemMainhand() != null) {
				if (player.getHeldItemMainhand().getItem() == ModItems.PowerBoost) {
					PacketDispatcher.sendToServer(new RemoveItemInSlotAndGiveEffect(Strings.PowerBoost, player.inventory.currentItem));
				} else if(player.getHeldItemMainhand().getItem() == ModItems.MagicBoost){
					PacketDispatcher.sendToServer(new RemoveItemInSlotAndGiveEffect(Strings.MagicBoost, player.inventory.currentItem));
				} else if(player.getHeldItemMainhand().getItem() == ModItems.DefenseBoost){
					PacketDispatcher.sendToServer(new RemoveItemInSlotAndGiveEffect(Strings.DefenseBoost, player.inventory.currentItem));
				} else if(player.getHeldItemMainhand().getItem() == ModItems.APBoost){
					PacketDispatcher.sendToServer(new RemoveItemInSlotAndGiveEffect(Strings.APBoost, player.inventory.currentItem));
				}
				player.getActiveItemStack().setCount(player.getActiveItemStack().getCount() - 1);
			}
		}

		player.world.playSound(player, player.getPosition(), ModSounds.itemget, SoundCategory.MASTER, 1.0f, 1.0f);
		return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		
		if (stack != null && stack.getItem() != null) {
			if (stack.getItem() == ModItems.PowerBoost) {
				tooltip.add("Permanently increases Strength by 1");
			} else if(stack.getItem() == ModItems.MagicBoost){
		        tooltip.add("Permanently increases Magic by 1");
			} else if(stack.getItem() == ModItems.DefenseBoost){
		        tooltip.add("Permanently increases Defense by 1");
			} else if(stack.getItem() == ModItems.APBoost){
		        tooltip.add("Permanently increases Max AP by 1");
			}
		}

		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public ItemCategory getCategory() {
		return ItemCategory.CONSUMABLE;
	}
}

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
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.api.menu.IItemCategory;
import uk.co.wehavecookies56.kk.api.menu.ItemCategory;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
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
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if(!world.isRemote) {
			if (player.getHeldItemMainhand() != null) {
				if (player.getHeldItemMainhand().getItem() == ModItems.PowerBoost) {
			        if(!player.capabilities.isCreativeMode)
			            player.inventory.removeStackFromSlot(player.inventory.currentItem);
			        player.getCapability(ModCapabilities.PLAYER_STATS, null).addStrength(1);
			        TextComponentTranslation powMessage = new TextComponentTranslation(Strings.Chat_PowerBoost, new TextComponentTranslation(""+player.getCapability(ModCapabilities.PLAYER_STATS, null).getStrength()));
			        powMessage.getStyle().setColor(TextFormatting.GREEN);
			        player.sendMessage(powMessage);
				}
				else if(player.getHeldItemMainhand().getItem() == ModItems.MagicBoost){
	                if(!player.capabilities.isCreativeMode)
	                    player.inventory.removeStackFromSlot(player.inventory.currentItem);
	                player.getCapability(ModCapabilities.PLAYER_STATS, null).addMagic(1);
	                TextComponentTranslation magMessage = new TextComponentTranslation(Strings.Chat_MagicBoost, new TextComponentTranslation(""+player.getCapability(ModCapabilities.PLAYER_STATS, null).getMagic()));
	                magMessage.getStyle().setColor(TextFormatting.GREEN);
	                player.sendMessage(magMessage);
				}
				else if(player.getHeldItemMainhand().getItem() == ModItems.DefenseBoost){
	                if(!player.capabilities.isCreativeMode)
	                    player.inventory.removeStackFromSlot(player.inventory.currentItem);
	                player.getCapability(ModCapabilities.PLAYER_STATS, null).addDefense(1);
	                TextComponentTranslation strMessage = new TextComponentTranslation(Strings.Chat_DefenseBoost, new TextComponentTranslation(""+player.getCapability(ModCapabilities.PLAYER_STATS, null).getDefense()));
	                strMessage.getStyle().setColor(TextFormatting.GREEN);
	                player.sendMessage(strMessage);			
				}
				else if(player.getHeldItemMainhand().getItem() == ModItems.APBoost){
	                if(!player.capabilities.isCreativeMode)
	                    player.inventory.removeStackFromSlot(player.inventory.currentItem);
	                player.getCapability(ModCapabilities.PLAYER_STATS, null).addMaxAP(1);
	                TextComponentTranslation apMessage = new TextComponentTranslation(Strings.Chat_APBoost, new TextComponentTranslation(""+player.getCapability(ModCapabilities.PLAYER_STATS, null).getMaxAP()));
	                apMessage.getStyle().setColor(TextFormatting.GREEN);
	                player.sendMessage(apMessage);
				}
				player.getActiveItemStack().setCount(player.getActiveItemStack().getCount() - 1);
			}
		}

		player.world.playSound(player, player.getPosition(), ModSounds.itemget, SoundCategory.MASTER, 1.0f, 1.0f);
		return super.onItemRightClick(world, player, hand);
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

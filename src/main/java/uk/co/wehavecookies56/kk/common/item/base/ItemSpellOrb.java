package uk.co.wehavecookies56.kk.common.item.base;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.LevelUpMagic;
import uk.co.wehavecookies56.kk.common.util.Utils;

public abstract class ItemSpellOrb extends Item {

	String magic;

	public ItemSpellOrb (String magic) {
		this.magic = magic;
		setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World world, EntityPlayer player, EnumHand hand) {
		if (world.isRemote) {
			PacketDispatcher.sendToServer(new LevelUpMagic(this.magic));
		}
		return super.onItemRightClick(itemStackIn, world, player, hand);
	}
	
	public String getMagicLevelName(EntityPlayer player, String magic){
		String magicName;
		int magicLevel = player.getCapability(ModCapabilities.MAGIC_STATE, null).getMagicLevel(magic);
		return magic;
	}

	@Override
	public void addInformation (ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		tooltip.add(Utils.translateToLocal(Constants.getMagicName(magic, player.getCapability(ModCapabilities.MAGIC_STATE, null).getMagicLevel(magic))));
		super.addInformation(stack, player, tooltip, advanced);
	}

	public String getMagicName () {
		return magic;
	}

	public void setMagicName (String magic) {
		this.magic = magic;
	}
}

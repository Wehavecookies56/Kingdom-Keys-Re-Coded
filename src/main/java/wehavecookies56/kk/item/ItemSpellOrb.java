package wehavecookies56.kk.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Constants;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.magics.LevelUpMagic;
import wehavecookies56.kk.util.TextHelper;

public abstract class ItemSpellOrb extends Item {

	String magic;

	public ItemSpellOrb (String magic) {
		this.magic = magic;
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player) {
		if (world.isRemote) PacketDispatcher.sendToServer(new LevelUpMagic(this.magic));
		return stack;
	}
	
	public String getMagicLevelName(EntityPlayer player, String magic){
		String magicName;
		int magicLevel = ExtendedPlayer.get(player).getMagicLevel(magic);
		return magic;
	}

	@Override
	public void addInformation (ItemStack stack, EntityPlayer player, List tooltip, boolean advanced) {
		tooltip.add(TextHelper.localize(Constants.getMagicName(magic, ExtendedPlayer.get(player).getMagicLevel(magic))));
		super.addInformation(stack, player, tooltip, advanced);
	}

	public String getMagicName () {
		return magic;
	}

	public void setMagicName (String magic) {
		this.magic = magic;
	}
}

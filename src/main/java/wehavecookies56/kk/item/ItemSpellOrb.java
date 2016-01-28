package wehavecookies56.kk.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.magics.LevelUpMagic;
import wehavecookies56.kk.util.TextHelper;

public class ItemSpellOrb extends Item {

	String magic, unlocalizedName;
	
	public ItemSpellOrb(String magic, String unlocalizedName) {
		this.magic = magic;
		this.unlocalizedName = unlocalizedName;
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(world.isRemote){
			PacketDispatcher.sendToServer(new LevelUpMagic(this.magic));
		}
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(TextHelper.localize(this.unlocalizedName));
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

	public String getMagicName() {
		return unlocalizedName;
	}

	public void setMagicName(String unlocalizedName) {
		this.unlocalizedName = unlocalizedName;
	}	
}

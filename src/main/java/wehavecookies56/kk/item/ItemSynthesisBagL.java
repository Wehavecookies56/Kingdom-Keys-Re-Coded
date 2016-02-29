package wehavecookies56.kk.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.OpenGui;
import wehavecookies56.kk.util.TextHelper;

public class ItemSynthesisBagL extends Item {

	public ItemSynthesisBagL () {
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick (ItemStack itemStackIn, World world, EntityPlayer player) {
		// if (!world.isRemote){
		// player.openGui(KingdomKeys.instance,
		// KingdomKeys.GUI_SYNTHESISBAG_INV, player.worldObj, 0, 0, 0);
		if (world.isRemote) PacketDispatcher.sendToServer(new OpenGui(KingdomKeys.GUI_SYNTHESISBAGL_INV));
		// }
		return itemStackIn;
	}

	@Override
	public void addInformation (ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		int x = 30;
		String s = TextHelper.localize(Strings.SynthesisBagDesc);
		s = s.replaceAll("(.{" + x + ",}?)\\s+", "$1\n");
		String[] splitS = s.split("\n");
		for (String element : splitS)
			tooltip.add(element);
	}
}

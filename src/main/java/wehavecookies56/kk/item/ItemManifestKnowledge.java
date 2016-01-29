package wehavecookies56.kk.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.ManifestKnowledgePacket;

public class ItemManifestKnowledge extends Item {

	public ItemManifestKnowledge () {
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick (ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if (worldIn.isRemote) PacketDispatcher.sendToServer(new ManifestKnowledgePacket());
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}

}

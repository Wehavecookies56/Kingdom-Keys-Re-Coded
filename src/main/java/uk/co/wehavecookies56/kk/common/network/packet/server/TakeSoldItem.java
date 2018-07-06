package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemSynthesisMaterial;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMunnyData;

public class TakeSoldItem extends AbstractMessage.AbstractServerMessage<TakeSoldItem> {

	public TakeSoldItem() {
	}

	int munnyToGive;
	int quantityToBuy;
	ItemStack soldItem;

	public TakeSoldItem(int spentMunny, int quantity, ItemStack boughtItem) {
		this.munnyToGive = spentMunny;
		this.quantityToBuy = quantity;
		this.soldItem = boughtItem;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.munnyToGive = buffer.readInt();
		this.quantityToBuy = buffer.readInt();
		this.soldItem = buffer.readItemStack();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(munnyToGive);
		buffer.writeInt(quantityToBuy);
		buffer.writeItemStack(soldItem);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		if (soldItem.hasTagCompound()) { // Synthesis item
			if (soldItem.getTagCompound().hasKey("material")) {
				//System.out.println(soldItem + " " + soldItem.getTagCompound().hasKey("material"));
				for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
					if (player.inventory.getStackInSlot(i).getItem() instanceof ItemSynthesisMaterial) {
						ItemStack invItem = player.inventory.getStackInSlot(i);
						if (invItem.getTagCompound().getString("material").equals(soldItem.getTagCompound().getString("material"))) { // If player has the synthesis item
							// System.out.println(invItem.getTagCompound().getString("material")+">"+soldItem.getTagCompound().getString("material"));
							if (quantityToBuy >= player.inventory.getStackInSlot(i).getCount()) { // If the amount you want to sell is bigger or equals to the amount you have
								player.inventory.removeStackFromSlot(i); // Remove the item
								quantityToBuy -= player.inventory.getStackInSlot(i).getCount();
							} else if (quantityToBuy < player.inventory.getStackInSlot(i).getCount()) {
								player.inventory.getStackInSlot(i).shrink(quantityToBuy);
								quantityToBuy = 0;
							}
						}
					}
				}
			}
		} else { // Non synthesis item
			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				ItemStack invItem = player.inventory.getStackInSlot(i);
				if (invItem.isItemEqual(soldItem)) { // If player has the item
					// System.out.println(invItem.getTagCompound().getString("material")+">"+soldItem.getTagCompound().getString("material"));
					if (quantityToBuy >= player.inventory.getStackInSlot(i).getCount()) { // If the amount you want to sell is bigger or equals to the amount you have
						player.inventory.removeStackFromSlot(i); // Remove the item
						quantityToBuy -= player.inventory.getStackInSlot(i).getCount();
					} else if (quantityToBuy < player.inventory.getStackInSlot(i).getCount()) {
						player.inventory.getStackInSlot(i).shrink(quantityToBuy);
						quantityToBuy = 0;
					}
				}

			}
		}

		player.getCapability(ModCapabilities.MUNNY, null).addMunny(munnyToGive);
		PacketDispatcher.sendTo(new SyncMunnyData(player.getCapability(ModCapabilities.MUNNY, null)), (EntityPlayerMP) player);
	}

}

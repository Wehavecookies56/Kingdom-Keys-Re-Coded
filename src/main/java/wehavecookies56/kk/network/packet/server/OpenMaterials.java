package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.api.materials.MaterialRegistry;
import wehavecookies56.kk.entities.ExtendedPlayerMaterials;
import wehavecookies56.kk.item.ItemSynthesisMaterial;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class OpenMaterials extends AbstractServerMessage<OpenMaterials> {

	public OpenMaterials () {}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process (EntityPlayer player, Side side) {
		for (int i = 0; i < 36; i++)
			if (player.inventory.mainInventory[i] != null) if (player.inventory.mainInventory[i].getItem() instanceof ItemSynthesisMaterial) {
				if (player.inventory.mainInventory[i].hasTagCompound()) {
					String s = player.inventory.mainInventory[i].getTagCompound().getString("material");
					if (MaterialRegistry.isMaterialRegistered(s)) ExtendedPlayerMaterials.get(player).addMaterial(MaterialRegistry.get(s), player.inventory.mainInventory[i].stackSize);
					player.inventory.setInventorySlotContents(i, null);
				}

			} else if (MaterialRegistry.isMaterialRegistered(player.inventory.mainInventory[i].getItem().getUnlocalizedName().toString())) {
				ExtendedPlayerMaterials.get(player).addMaterial(MaterialRegistry.get(player.inventory.mainInventory[i].getItem().getUnlocalizedName()), player.inventory.mainInventory[i].stackSize);
				player.inventory.setInventorySlotContents(i, null);
			}
	}

}

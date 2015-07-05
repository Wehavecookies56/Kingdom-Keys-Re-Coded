package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import com.ibm.icu.text.Replaceable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayerMaterials;
import wehavecookies56.kk.item.ItemSynthesisMaterial;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class OpenMaterials extends AbstractServerMessage<OpenMaterials> {

	public OpenMaterials() {}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process(EntityPlayer player, Side side) {
		ExtendedPlayerMaterials props = ExtendedPlayerMaterials.get(player);
		for (int i = 0; i < 35; i++){
			if(player.inventory.mainInventory[i] != null){
				if(player.inventory.mainInventory[i].getItem() instanceof ItemSynthesisMaterial){
					int stackSize = player.inventory.mainInventory[i].stackSize;
					if(player.inventory.mainInventory[i].hasTagCompound()){
						String s = player.inventory.mainInventory[i].getTagCompound().getString("material") + ".x." + stackSize;
						String sA = s.replaceAll("[0-9]","").replaceAll(".x.", "");
						for(int j = 0; j < props.materials.size(); j++){
							if(props.materials.get(j) == player.inventory.mainInventory[i].toString()){

							}
						}
						ExtendedPlayerMaterials.get(player).addMaterial(s);
						System.out.println("s");
						player.inventory.setInventorySlotContents(i, null);
					}

				}
			}
		}
	}
}

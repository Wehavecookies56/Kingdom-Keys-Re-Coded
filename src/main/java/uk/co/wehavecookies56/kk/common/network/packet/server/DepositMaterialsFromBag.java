package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.container.inventory.InventorySynthesisBagL;
import uk.co.wehavecookies56.kk.common.container.inventory.InventorySynthesisBagM;
import uk.co.wehavecookies56.kk.common.container.inventory.InventorySynthesisBagS;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMaterialData;

public class DepositMaterialsFromBag extends AbstractMessage.AbstractServerMessage<DepositMaterialsFromBag> {

	public DepositMaterialsFromBag () {}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process (EntityPlayer player, Side side) {
		for (int i = 0; i < 36; i++)
		{
			if (player.inventory.mainInventory.get(i) != ItemStack.EMPTY)
			{
				if (player.inventory.mainInventory.get(i).getItem() == ModItems.SynthesisBagS)
				{
					InventorySynthesisBagS bag = new InventorySynthesisBagS(player.inventory.getStackInSlot(i));
					for (int j = 0; j < bag.getSizeInventory(); j++)
					{
						ItemStack bagItem = bag.getStackInSlot(j);
						if (bagItem != ItemStack.EMPTY)
						{
							if (bagItem.hasTagCompound()) 
							{
								String s = bagItem.getTagCompound().getString("material");
								if (MaterialRegistry.isMaterialRegistered(s))
								{ 
									player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(MaterialRegistry.get(s), bag.getStackInSlot(j).getCount());
								}
								bag.setInventorySlotContents(j, ItemStack.EMPTY);
							}
						} else if (MaterialRegistry.isMaterialRegistered(player.inventory.mainInventory.get(i).getItem().getUnlocalizedName().toString())) {
							player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(MaterialRegistry.get(player.inventory.mainInventory.get(i).getItem().getUnlocalizedName()), player.inventory.mainInventory.get(i).getCount());
							player.inventory.setInventorySlotContents(i, ItemStack.EMPTY);
						}
						PacketDispatcher.sendTo(new SyncMaterialData(player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null)), (EntityPlayerMP) player);
					}
				}else if (player.inventory.mainInventory.get(i).getItem() == ModItems.SynthesisBagM)
				{
					InventorySynthesisBagM bag = new InventorySynthesisBagM(player.inventory.getStackInSlot(i));
					for (int j = 0; j < bag.getSizeInventory(); j++)
					{
						ItemStack bagItem = bag.getStackInSlot(j);
						if (bagItem != ItemStack.EMPTY)
						{
							if (bagItem.hasTagCompound()) 
							{
								String s = bagItem.getTagCompound().getString("material");
								if (MaterialRegistry.isMaterialRegistered(s))
								{ 
									player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(MaterialRegistry.get(s), bag.getStackInSlot(j).getCount());
								}
								bag.setInventorySlotContents(j, ItemStack.EMPTY);
							}
						} else if (MaterialRegistry.isMaterialRegistered(player.inventory.mainInventory.get(i).getItem().getUnlocalizedName().toString())) {
							player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(MaterialRegistry.get(player.inventory.mainInventory.get(i).getItem().getUnlocalizedName()), player.inventory.mainInventory.get(i).getCount());
							player.inventory.setInventorySlotContents(i, ItemStack.EMPTY);
						}
						PacketDispatcher.sendTo(new SyncMaterialData(player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null)), (EntityPlayerMP) player);
					}
				}else if (player.inventory.mainInventory.get(i).getItem() == ModItems.SynthesisBagL)
				{
					InventorySynthesisBagL bag = new InventorySynthesisBagL(player.inventory.getStackInSlot(i));
					for (int j = 0; j < bag.getSizeInventory(); j++)
					{
						ItemStack bagItem = bag.getStackInSlot(j);
						if (bagItem != ItemStack.EMPTY)
						{
							if (bagItem.hasTagCompound()) 
							{
								String s = bagItem.getTagCompound().getString("material");
								if (MaterialRegistry.isMaterialRegistered(s))
								{ 
									player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(MaterialRegistry.get(s), bag.getStackInSlot(j).getCount());
								}
								bag.setInventorySlotContents(j, ItemStack.EMPTY);
							}
						} else if (MaterialRegistry.isMaterialRegistered(player.inventory.mainInventory.get(i).getItem().getUnlocalizedName().toString())) {
							player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(MaterialRegistry.get(player.inventory.mainInventory.get(i).getItem().getUnlocalizedName()), player.inventory.mainInventory.get(i).getCount());
							player.inventory.setInventorySlotContents(i, ItemStack.EMPTY);
						}
						PacketDispatcher.sendTo(new SyncMaterialData(player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null)), (EntityPlayerMP) player);
					}
				} 
			}
		}
	}
}

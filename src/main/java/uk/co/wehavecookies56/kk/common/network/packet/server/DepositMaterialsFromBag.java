package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
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
        for (int i = 0; i < 36; i++) {
            if (player.inventory.mainInventory.get(i) != ItemStack.EMPTY) {
                if (player.inventory.mainInventory.get(i).getItem() == ModItems.SynthesisBagS) {
                    IItemHandler bag = player.inventory.mainInventory.get(i).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
                    removeMaterial(bag, player, i);
                } else if (player.inventory.mainInventory.get(i).getItem() == ModItems.SynthesisBagM) {
                    IItemHandler bag = player.inventory.mainInventory.get(i).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
                    removeMaterial(bag, player, i);
                } else if (player.inventory.mainInventory.get(i).getItem() == ModItems.SynthesisBagL) {
                    IItemHandler bag = player.inventory.mainInventory.get(i).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
                    removeMaterial(bag, player, i);
                }
            }
        }
    }

    public void removeMaterial(IItemHandler bag, EntityPlayer player, int i) {
        for (int j = 0; j < bag.getSlots(); j++) {
            ItemStack bagItem = bag.getStackInSlot(j);
            if (bagItem != ItemStack.EMPTY) {
                if (bagItem.hasTagCompound()) {
                    String s = bagItem.getTagCompound().getString("material");
                    if (MaterialRegistry.isMaterialRegistered(s)) {
                        player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(MaterialRegistry.get(s), bag.getStackInSlot(j).getCount());
                    }
                    bag.extractItem(j, bag.getStackInSlot(j).getCount(), false);
                }
            } else if (MaterialRegistry.isMaterialRegistered(player.inventory.mainInventory.get(i).getItem().getUnlocalizedName())) {
                player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(MaterialRegistry.get(player.inventory.mainInventory.get(i).getItem().getUnlocalizedName()), player.inventory.mainInventory.get(i).getCount());
                player.inventory.setInventorySlotContents(i, ItemStack.EMPTY);
            }
            PacketDispatcher.sendTo(new SyncMaterialData(player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null)), (EntityPlayerMP) player);
        }

    }

}

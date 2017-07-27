package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemSynthesisMaterial;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMaterialData;

public class OpenMaterials extends AbstractMessage.AbstractServerMessage<OpenMaterials> {

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
        {
            if (!ItemStack.areItemStacksEqual(player.inventory.mainInventory.get(i), ItemStack.EMPTY))
            {
                if (player.inventory.mainInventory.get(i).getItem() instanceof ItemSynthesisMaterial)
                {
                    if (player.inventory.mainInventory.get(i).hasTagCompound())
                    {
                        String s = player.inventory.mainInventory.get(i).getTagCompound().getString("material");
                        if (MaterialRegistry.isMaterialRegistered(s))
                        {
                            player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(MaterialRegistry.get(s), player.inventory.mainInventory.get(i).getCount());
                        }
                        player.inventory.setInventorySlotContents(i, ItemStack.EMPTY);
                    }
                } else if (MaterialRegistry.isMaterialRegistered(player.inventory.mainInventory.get(i).getItem().getUnlocalizedName().toString())) {
                    player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(MaterialRegistry.get(player.inventory.mainInventory.get(i).getItem().getUnlocalizedName()), player.inventory.mainInventory.get(i).getCount());
                    player.inventory.setInventorySlotContents(i, ItemStack.EMPTY);
                }
                PacketDispatcher.sendTo(new SyncMaterialData(player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null)), (EntityPlayerMP) player);
            }
        }
        /*for (int i = 0; i < 36; i++)
            if (player.inventory.mainInventory[i] != null) if (player.inventory.mainInventory[i].getItem() instanceof ItemSynthesisMaterial) {
                if (player.inventory.mainInventory[i].hasTagCompound()) {
                    String s = player.inventory.mainInventory[i].getTagCompound().getString("material");
                    if (MaterialRegistry.isMaterialRegistered(s)) player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(MaterialRegistry.get(s), player.inventory.mainInventory[i].stackSize);
                    player.inventory.setInventorySlotContents(i, null);
                }

            } else if (MaterialRegistry.isMaterialRegistered(player.inventory.mainInventory[i].getItem().getUnlocalizedName().toString())) {
                player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(MaterialRegistry.get(player.inventory.mainInventory[i].getItem().getUnlocalizedName()), player.inventory.mainInventory[i].stackSize);
                player.inventory.setInventorySlotContents(i, null);
            }
        PacketDispatcher.sendTo(new SyncMaterialData(player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null)), (EntityPlayerMP) player);
        */
    }

}

package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;

public class SynthesisMaterialPickup extends AbstractServerMessage<SynthesisMaterialPickup> {

    public SynthesisMaterialPickup () {}

    ItemStack toRemove;
    ItemStack bag;
    int slot;

    public SynthesisMaterialPickup (ItemStack toRemove, ItemStack bag, int slot) {
        this.toRemove = toRemove;
        this.bag = bag;
        this.slot = slot;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        toRemove = buffer.readItemStack();
        bag = buffer.readItemStack();
        slot = buffer.readInt();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeItemStack(toRemove);
        buffer.writeItemStack(bag);
        buffer.writeInt(slot);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        //player.inventory.consumeInventoryItem(toRemove.getItem());
        toRemove.setCount(toRemove.getCount()-1);
        if (bag.getItem().equals(ModItems.SynthesisBagL)) {
            IItemHandler bagL = bag.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            for (int i = 0; i < bagL.getSlots(); i++)
                if (bagL.getStackInSlot(i) == ItemStack.EMPTY) {
                    bagL.insertItem(0, toRemove, false);
                    break;
                }
        }

    }

}

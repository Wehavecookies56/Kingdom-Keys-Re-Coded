package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.items.ItemStackHandler;
import uk.co.wehavecookies56.kk.api.abilities.AbilityEvent;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.item.base.ItemRealKeyblade;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.OpenPlayerItemsGUI;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncItemsInventory;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncKeybladeData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncLevelData;

public class EquipPotion extends AbstractMessage.AbstractServerMessage<EquipPotion> {

    ItemStack potion;
    int slot, potionSlot;

    public EquipPotion() {}

    public EquipPotion(ItemStack potion, int slot, int potionSlot) {
        this.potion = potion;
        this.slot = slot;
        this.potionSlot = potionSlot;
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        potion = buffer.readItemStack();
        slot = buffer.readInt();
        potionSlot = buffer.readInt();
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeItemStack(potion);
        buffer.writeInt(slot);
        buffer.writeInt(potionSlot);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        ItemStackHandler chainInv = player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu();
        ItemStack current = chainInv.getStackInSlot(potionSlot);
        ItemStack currentToInv = current.copy();
        ItemStack toEquip = potion.copy();
        
        player.inventory.setInventorySlotContents(slot, currentToInv);
        chainInv.setStackInSlot(potionSlot, toEquip);
        PacketDispatcher.sendTo(new SyncItemsInventory(player.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) player);
        PacketDispatcher.sendTo(new OpenPlayerItemsGUI(), (EntityPlayerMP) player);
    }
}

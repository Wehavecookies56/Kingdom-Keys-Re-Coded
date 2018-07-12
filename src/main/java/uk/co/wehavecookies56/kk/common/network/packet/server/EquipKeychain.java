package uk.co.wehavecookies56.kk.common.network.packet.server;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.items.ItemStackHandler;
import uk.co.wehavecookies56.kk.api.abilities.Ability;
import uk.co.wehavecookies56.kk.api.abilities.AbilityEvent;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SummonKeybladeCapability;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.item.base.ItemRealKeyblade;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.OpenPlayerItemsGUI;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncKeybladeData;

import java.io.IOException;

public class EquipKeychain extends AbstractMessage.AbstractServerMessage<EquipKeychain> {

    ItemStack chain;
    int slot, chainSlot;

    public EquipKeychain() {}

    public EquipKeychain(ItemStack chain, int slot, int chainSlot) {
        this.chain = chain;
        this.slot = slot;
        this.chainSlot = chainSlot;
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        chain = buffer.readItemStack();
        slot = buffer.readInt();
        chainSlot = buffer.readInt();
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeItemStack(chain);
        buffer.writeInt(slot);
        buffer.writeInt(chainSlot);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        ItemStackHandler chainInv = player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain();
        ItemStack current = chainInv.getStackInSlot(chainSlot);
        ItemStack currentToInv = current.copy();
        ItemStack toEquip = chain.copy();
        if (current.getItem() instanceof ItemKeychain) {
            ItemKeychain chainItem = (ItemKeychain) current.getItem();
            if (chainItem.getKeyblade() instanceof ItemRealKeyblade) {
                ItemRealKeyblade keyblade = (ItemRealKeyblade) chainItem.getKeyblade();
                if (keyblade.getAbility() != null) {
                    MinecraftForge.EVENT_BUS.post(new AbilityEvent.Unequip(player, keyblade.getAbility()));
                }
            }
        }
        if (chain.getItem() instanceof ItemKeychain) {
            ItemKeychain chainItem = (ItemKeychain) chain.getItem();
            if (chainItem.getKeyblade() instanceof ItemRealKeyblade) {
                ItemRealKeyblade keyblade = (ItemRealKeyblade) chainItem.getKeyblade();
                if (keyblade.getAbility() != null) {
                    MinecraftForge.EVENT_BUS.post(new AbilityEvent.Equip(player, keyblade.getAbility()));
                }
            }
        }
        player.inventory.setInventorySlotContents(slot, currentToInv);
        chainInv.setStackInSlot(chainSlot, toEquip);
        PacketDispatcher.sendTo(new SyncKeybladeData(player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null)), (EntityPlayerMP) player);
        PacketDispatcher.sendTo(new OpenPlayerItemsGUI(), (EntityPlayerMP) player);
    }
}

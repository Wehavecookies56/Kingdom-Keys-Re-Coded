package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnKeybladeParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncKeybladeData;

public class SummonKeyblade extends AbstractMessage.AbstractServerMessage<SummonKeyblade> {

    int offHandSlot;
    EnumHand hand;

    public SummonKeyblade () {}

    public SummonKeyblade (EnumHand hand, int offHandSlot) {
        this.hand = hand;
        this.offHandSlot = offHandSlot;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        hand = EnumHand.values()[buffer.readInt()];
        offHandSlot = buffer.readInt();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeInt(hand.ordinal());
        buffer.writeInt(offHandSlot);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        ItemStack keychain = player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain().getStackInSlot(offHandSlot);
        ItemStack keyblade = new ItemStack(((ItemKeychain)(keychain.getItem())).getKeyblade());
        if (keychain.hasTagCompound()) {
            keyblade.setTagCompound(keychain.getTagCompound());
        }
        if (hand == EnumHand.MAIN_HAND) {
            player.inventory.setInventorySlotContents(player.inventory.currentItem, keyblade);
        } else {
            player.inventory.offHandInventory.set(0, keyblade);
        }
        player.world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.summon, SoundCategory.MASTER, 1.0f, 1.0f);
        player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).setIsKeybladeSummoned(hand, true);
        player.sendMessage(new TextComponentTranslation(TextFormatting.DARK_GREEN + "Summoned " + player.getHeldItem(hand).getDisplayName()));

        PacketDispatcher.sendToAllAround(new SpawnKeybladeParticles(player), player, 64.0D);

        PacketDispatcher.sendTo(new SyncKeybladeData(player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null)), (EntityPlayerMP) player);
    }
}
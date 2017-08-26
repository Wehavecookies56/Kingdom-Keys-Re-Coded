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
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncKeybladeData;

public class DeSummonKeyblade extends AbstractServerMessage<DeSummonKeyblade> {

    public DeSummonKeyblade () {}

    EnumHand hand;

    public DeSummonKeyblade (EnumHand hand) {
        this.hand = hand;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        hand = EnumHand.values()[buffer.readInt()];
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeInt(hand.ordinal());
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        player.sendMessage(new TextComponentTranslation(TextFormatting.DARK_GREEN + "Desummoned " + player.getHeldItem(hand).getDisplayName()));
        if (hand == EnumHand.MAIN_HAND)
            player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
        else
            player.inventory.offHandInventory.set(0, ItemStack.EMPTY);
        player.world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.unsummon, SoundCategory.MASTER, 1.0f, 1.0f);
        player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).setIsKeybladeSummoned(hand, false);
        PacketDispatcher.sendTo(new SyncKeybladeData(player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null)), (EntityPlayerMP) player);
    }

}

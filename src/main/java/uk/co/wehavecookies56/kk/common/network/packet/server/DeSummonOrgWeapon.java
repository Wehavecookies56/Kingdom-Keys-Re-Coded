package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgXIIIData;

public class DeSummonOrgWeapon extends AbstractServerMessage<DeSummonOrgWeapon> {

    public DeSummonOrgWeapon() {}

    EnumHand hand;

    public DeSummonOrgWeapon(EnumHand hand) {
        this.hand = hand;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {

    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {

    }

    @Override
    public void process (EntityPlayer player, Side side) {
        if (hand == EnumHand.MAIN_HAND)
            player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
        else
            player.inventory.offHandInventory.set(0, ItemStack.EMPTY);
        player.world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.unsummon, SoundCategory.MASTER, 1.0f, 1.0f);
        player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setWeaponSummoned(hand, false);
        PacketDispatcher.sendTo(new SyncOrgXIIIData(player.getCapability(ModCapabilities.ORGANIZATION_XIII, null)), (EntityPlayerMP) player);
    }

}

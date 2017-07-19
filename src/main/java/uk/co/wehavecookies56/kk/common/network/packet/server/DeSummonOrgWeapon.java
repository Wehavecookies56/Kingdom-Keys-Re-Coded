package uk.co.wehavecookies56.kk.common.network.packet.server;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncKeybladeData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgXIIIData;

import java.io.IOException;

public class DeSummonOrgWeapon extends AbstractServerMessage<DeSummonOrgWeapon> {

    public DeSummonOrgWeapon() {}

    ItemStack toRemove;

    public DeSummonOrgWeapon(ItemStack toRemove) {
        this.toRemove = toRemove;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        toRemove = buffer.readItemStack();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeItemStack(toRemove);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
        player.world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.unsummon, SoundCategory.MASTER, 1.0f, 1.0f);
        player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setWeaponSummoned(false);
        PacketDispatcher.sendTo(new SyncOrgXIIIData(player.getCapability(ModCapabilities.ORGANIZATION_XIII, null)), (EntityPlayerMP) player);
    }

}

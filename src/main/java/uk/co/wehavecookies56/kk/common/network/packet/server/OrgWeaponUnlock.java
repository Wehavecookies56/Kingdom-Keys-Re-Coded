package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.OrganizationXIIICapability;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgXIIIData;

/**
 * Created by Toby on 09/02/2017.
 */
public class

OrgWeaponUnlock extends AbstractMessage.AbstractServerMessage<OrgWeaponUnlock> {

    Item unlock;
    int points;

    public OrgWeaponUnlock() {

    }

    public OrgWeaponUnlock(Item unlock, int points) {
        this.unlock = unlock;
        this.points = points;
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        unlock = buffer.readItemStack().getItem();
        points = buffer.readInt();
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeItemStack(new ItemStack(unlock));
        buffer.writeInt(points);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        OrganizationXIIICapability.IOrganizationXIII org = player.getCapability(ModCapabilities.ORGANIZATION_XIII, null);
        org.addUnlockedWeapon(unlock);
        org.removePoints(points);
        PacketDispatcher.sendTo(new SyncOrgXIIIData(org), (EntityPlayerMP) player);
    }
}

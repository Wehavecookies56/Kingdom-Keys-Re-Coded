package uk.co.wehavecookies56.kk.common.network.packet.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

import java.io.IOException;

/**
 * Created by Toby on 09/04/2017.
 */
public class OpenOrgGUI extends AbstractMessage.AbstractClientMessage<OpenOrgGUI> {

    public OpenOrgGUI() {

    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {

    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {

    }

    @Override
    public void process(EntityPlayer player, Side side) {
        player.openGui(KingdomKeys.instance, GuiIDs.GUI_ORG, player.world, (int) player.posX, (int) player.posY, (int) player.posZ);
    }
}

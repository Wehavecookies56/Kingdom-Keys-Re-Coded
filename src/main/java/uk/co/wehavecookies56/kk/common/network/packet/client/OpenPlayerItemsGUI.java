package uk.co.wehavecookies56.kk.common.network.packet.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.client.gui.GuiMenu_Items_Player;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

import java.io.IOException;

public class OpenPlayerItemsGUI extends AbstractMessage.AbstractClientMessage<OpenPlayerItemsGUI> {

    public OpenPlayerItemsGUI() {
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {

    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void process(EntityPlayer player, Side side) {
        if (side == Side.CLIENT) {
            Minecraft.getMinecraft().displayGuiScreen(new GuiMenu_Items_Player());
        }
    }
}

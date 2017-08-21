package uk.co.wehavecookies56.kk.common.network.packet.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.gui.GuiOverlay;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

import java.io.IOException;

public class ShowOverlayPacket extends AbstractMessage.AbstractClientMessage<ShowOverlayPacket> {

    String type;
    int munny;

    public ShowOverlayPacket () {}

    public ShowOverlayPacket (String type) {
        this.type = type;
    }

    public ShowOverlayPacket (String type, int munny) {
        this.type = type;
        this.munny = munny;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        this.type = buffer.readString(50);
        this.munny = buffer.readInt();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeString(this.type);
        buffer.writeInt(this.munny);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        if (this.type.equals("exp")) {
            GuiOverlay.showExp = true;
            GuiOverlay.timeExp = (int) Minecraft.getSystemTime() / 1000;
        }
        if (this.type.equals("munny")) {
            GuiOverlay.showMunny = true;
            GuiOverlay.timeMunny = (int) Minecraft.getSystemTime() / 1000;
            GuiOverlay.munnyGet = this.munny;
        }
        if (this.type.equals("levelup")) {
            GuiOverlay.showLevelUp = true;
            GuiOverlay.timeLevelUp = (int) Minecraft.getSystemTime() / 1000;
        }
    }

}

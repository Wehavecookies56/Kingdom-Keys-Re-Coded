package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.gui.GuiOverlay;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class ShowOverlayPacket extends AbstractMessage.AbstractClientMessage<ShowOverlayPacket> {

    String type;
    int munny;
    String driveForm;

    public ShowOverlayPacket () {}

    public ShowOverlayPacket (String type) {
        this.type = type;
        this.driveForm="";
    }
    
    public ShowOverlayPacket (String type, int munny) {
        this.type = type;
        this.munny = munny;
        this.driveForm="";
    }
    
    public ShowOverlayPacket (String type, String driveForm) {
        this.type = type;
        this.driveForm = driveForm;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        this.type = buffer.readString(50);
        this.munny = buffer.readInt();
        this.driveForm = buffer.readString(25);
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeString(this.type);
        buffer.writeInt(this.munny);
        buffer.writeString(this.driveForm);
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
        if (this.type.equals("drivelevelup")) {
            GuiOverlay.showDriveLevelUp = true;
            GuiOverlay.timeDriveLevelUp = (int) Minecraft.getSystemTime() / 1000;
            GuiOverlay.driveForm = this.driveForm;
        }
    }

}

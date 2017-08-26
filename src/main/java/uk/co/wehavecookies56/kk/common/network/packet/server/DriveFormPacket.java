package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.driveforms.DriveForm;
import uk.co.wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class DriveFormPacket extends AbstractMessage.AbstractServerMessage<DriveFormPacket> {

    public DriveFormPacket () {}

    boolean revert;
    String form;
    DriveForm df;

    public DriveFormPacket (String driveform, Boolean revert) {
        this.revert = revert;
        this.form = driveform;
    }

    public DriveFormPacket (String driveform) {
        this.form = driveform;
        this.revert = false;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        this.form = buffer.readString(100);
        this.revert = buffer.readBoolean();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeString(form);
        buffer.writeBoolean(revert);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        if (this.revert) {
            if (DriveFormRegistry.isDriveFormRegistered(form)) 
            	DriveFormRegistry.get(form).endDrive(player);
        } else {
            if (DriveFormRegistry.isDriveFormRegistered(form))
            	DriveFormRegistry.get(form).initDrive(player);
        }
    }
}

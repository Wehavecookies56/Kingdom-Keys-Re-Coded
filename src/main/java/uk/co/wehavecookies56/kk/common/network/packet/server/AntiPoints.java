package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class AntiPoints extends AbstractMessage.AbstractServerMessage<AntiPoints> {

    public AntiPoints () {}

    int points;

    public AntiPoints (int ammount) {
        this.points = ammount;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        this.points = buffer.readInt();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeInt(points);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        if(player.getCapability(ModCapabilities.DRIVE_STATE, null).getAntiPoints()+points < 0){
            player.getCapability(ModCapabilities.DRIVE_STATE, null).setAntiPoints(0);
        }else {
            player.getCapability(ModCapabilities.DRIVE_STATE, null).setAntiPoints(player.getCapability(ModCapabilities.DRIVE_STATE, null).getAntiPoints() + points);
        }
    }
}

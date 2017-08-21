package uk.co.wehavecookies56.kk.common.network.packet.server;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;

import java.io.IOException;

public class MagnetBloxMotion extends AbstractServerMessage<MagnetBloxMotion> {

    double x, y, z;

    int facing;

    public MagnetBloxMotion () {}

    public MagnetBloxMotion (double x, double y, double z, int facing) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.facing = facing;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        this.x = buffer.readDouble();
        this.y = buffer.readDouble();
        this.z = buffer.readDouble();
        this.facing = buffer.readInt();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeDouble(this.x);
        buffer.writeDouble(this.y);
        buffer.writeDouble(this.z);
        buffer.writeInt(this.facing);

    }

    @Override
    public void process (EntityPlayer player, Side side) {
        player.motionY *= this.y;
    }

}

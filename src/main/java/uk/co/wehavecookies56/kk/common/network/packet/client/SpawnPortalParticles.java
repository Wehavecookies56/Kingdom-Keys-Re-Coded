package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class SpawnPortalParticles extends AbstractMessage.AbstractClientMessage<SpawnPortalParticles> {

    double x, y, z;
    int lvl;

    public SpawnPortalParticles () {}

    public SpawnPortalParticles (BlockPos pos) {
        x = pos.getX()+0.5;
        y = pos.getY();
        z = pos.getZ()+0.5;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        x = buffer.readDouble();
        y = buffer.readDouble();
        z = buffer.readDouble();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeDouble(x);
        buffer.writeDouble(y);
        buffer.writeDouble(z);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        double r;
        r = 1D;
        for (int a = 1; a <= 360; a += 10) {
            double x = this.x + (r * Math.cos(Math.toRadians(a)));
            double z = this.z + (r * Math.sin(Math.toRadians(a)));
            for(double i=0;i<3;i=i+0.25){
            player.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, this.y+i, z, 0.0D, 0.0D, 0.0D);
            //player.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x, this.y+i, z, 0.0D, 0.0D, 0.0D);
            }

        }
    }
}

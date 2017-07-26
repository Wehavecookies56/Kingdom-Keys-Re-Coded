package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class SpawnKeybladeParticles extends AbstractMessage.AbstractClientMessage<SpawnKeybladeParticles> {

    double x, y, z;

    public SpawnKeybladeParticles () {}

    public SpawnKeybladeParticles (Entity entity) {
        x = entity.posX;
        y = entity.posY;
        z = entity.posZ;
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
    	Random rand = new Random();
    	Vec3d userPos = new Vec3d(player.posX, player.posY, player.posZ);
    	Vec3d vCenter = new Vec3d((rand.nextFloat() - 0.5F) * 0.8F+0.4, (rand.nextFloat() - 0.5F) * 2F-1.3D, (rand.nextFloat() - 0.5F) * 0.8F-0.38D);
	    vCenter.rotateYaw((float) Math.toRadians(-player.renderYawOffset));
	    vCenter = vCenter.addVector(-player.motionX * 0.2D, -player.motionY * 0.2D, -player.motionZ * 0.2D);
	    Vec3d v = userPos.addVector(-vCenter.x, vCenter.y, -vCenter.z);
	    double r = 0.5D;
	    for (int a = 1; a <= 360; a += 7) {
            double x = v.x + (r * Math.cos(Math.toRadians(a)));
            double z = v.z + (r * Math.sin(Math.toRadians(a)));

            player.world.spawnParticle(EnumParticleTypes.REDSTONE, x+1, y, z+0.3, 0.5D, 0.5D, 1.0D);

        }
	   // player.world.spawnParticle(EnumParticleTypes.REDSTONE, v.x+1, v.y+2, v.z+0.3, 0.5D, 0.5D, 1.0D);
          /*  player.world.spawnParticle(EnumParticleTypes.FLAME, x, this.y + 1.25D, z, 0.0D, 0.0D, 0.0D);
            player.world.spawnParticle(EnumParticleTypes.FLAME, x, this.y + 1.05D, z, 0.0D, 0.0D, 0.0D);*/

        
          
        
    }
}

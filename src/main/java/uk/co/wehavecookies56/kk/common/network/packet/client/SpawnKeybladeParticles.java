package uk.co.wehavecookies56.kk.common.network.packet.client;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.util.Utils;

import java.io.IOException;

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
    	Vec3d userPos = new Vec3d(player.posX, player.posY, player.posZ);
    	Vec3d vCenter = new Vec3d(0.4,-1.3D, -0.38D);
    	vCenter = vCenter.rotateYaw((float) Math.toRadians(-player.renderYawOffset));
	    Vec3d v = userPos.addVector(-vCenter.x, vCenter.y, -vCenter.z);
	    for (int a = 0; a < 300; a++) {
	    	player.world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, v.x, y+1, v.z,Utils.randomWithRange(-0.2,0.2),Utils.randomWithRange(-0.2,0.2),Utils.randomWithRange(-0.2,0.2));
            //player.world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, x, y+1, z,rand.nextDouble()*2-1,rand.nextDouble()*2-1,rand.nextDouble()*2-1);
        }
    }

}

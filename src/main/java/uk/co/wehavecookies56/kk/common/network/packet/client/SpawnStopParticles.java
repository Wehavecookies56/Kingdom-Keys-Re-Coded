package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class SpawnStopParticles extends AbstractMessage.AbstractClientMessage<SpawnStopParticles> {

	double x, y, z;
	int lvl;

	public SpawnStopParticles () {}

	public SpawnStopParticles (Entity entity, int level) {
		x = entity.posX;
		y = entity.posY;
		z = entity.posZ;
		lvl = level;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		x = buffer.readDouble();
		y = buffer.readDouble();
		z = buffer.readDouble();
		lvl = buffer.readInt();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeDouble(x);
		buffer.writeDouble(y);
		buffer.writeDouble(z);
		buffer.writeInt(lvl);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		double r=0;
		switch (this.lvl) {
			case 1:
				r = 2D;
				break;
			case 2:
				r = 3D;
				break;
			case 3:
				r = 4D;
				break;
		}
		
		for (int a = 1; a <= 360; a += 15) {
			double x = this.x + (r * Math.cos(Math.toRadians(a)));
			double z = this.z + (r * Math.sin(Math.toRadians(a)));
            player.world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, x, y+1, z, 0,0.2,0);
            if(this.lvl > 1)
            	player.world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, x, y+2.5, z, 0,0.2,0);
            if(this.lvl > 2)
                player.world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, x, y+4, z, 0,0.2,0);

		}
	}

}

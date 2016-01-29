package wehavecookies56.kk.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractClientMessage;

public class SpawnAeroParticles extends AbstractClientMessage<SpawnAeroParticles> {

	double x, y, z;
	int lvl;

	public SpawnAeroParticles () {}

	public SpawnAeroParticles (Entity entity, int level) {
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
		double r;
		switch (this.lvl) {
			case 1:
				r = 1.5D;
				for (int a = 1; a <= 360; a += 15) {
					double x = this.x + (r * Math.cos(Math.toRadians(a)));
					double z = this.z + (r * Math.sin(Math.toRadians(a)));
					player.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, x, this.y, z, 0.0D, 0.5D, 0.0D);
				}
				break;
			case 2:

				break;
			case 3:
				r = 4.0D;
				for (int a = 1; a <= 360; a += 15) {
					double x = this.x + (r * Math.cos(Math.toRadians(a)));
					double z = this.z + (r * Math.sin(Math.toRadians(a)));
					player.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, x, this.y, z, 0.0D, 0.5D, 0.0D);
				}
				break;
		}
	}

}

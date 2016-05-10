package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;

public class SpawnThunderParticles extends AbstractClientMessage<SpawnThunderParticles> {

	double x, y, z;
	int lvl;
	double ex = 0, ey, ez;

	public SpawnThunderParticles () {}

	public SpawnThunderParticles (Entity entity, int level) {
		x = entity.posX;
		y = entity.posY;
		z = entity.posZ;
		lvl = level;
	}

	public SpawnThunderParticles (double ex, double ey, double ez) {
		this.ex = ex;
		this.ey = ey;
		this.ez = ez;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		x = buffer.readDouble();
		y = buffer.readDouble();
		z = buffer.readDouble();
		lvl = buffer.readInt();
		ex = buffer.readDouble();
		ey = buffer.readDouble();
		ez = buffer.readDouble();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeDouble(x);
		buffer.writeDouble(y);
		buffer.writeDouble(z);
		buffer.writeInt(lvl);
		buffer.writeDouble(ex);
		buffer.writeDouble(ey);
		buffer.writeDouble(ez);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		double r = 2.0D;
		if (ex != 0) player.worldObj.spawnEntityInWorld((new EntityLightningBolt(player.worldObj, ex, ey, ez, false)));
		switch (this.lvl) {
			case 1:

				for (int a = 1; a <= 360; a += 7) {
					double x = this.x + (r * Math.cos(Math.toRadians(a)));
					double z = this.z + (r * Math.sin(Math.toRadians(a)));

					player.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, x, this.y + 1, z, 30, 15, 0);
				}
				break;
			case 2:

				for (int a = 1; a <= 360; a += 7) {
					double x = this.x + (r * Math.cos(Math.toRadians(a)));
					double z = this.z + (r * Math.sin(Math.toRadians(a)));

					player.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, x, this.y + 1, z, 30, 15, 0);
				}
				break;
			case 3:

				for (int a = 1; a <= 360; a += 7) {
					double x = this.x + (r * Math.cos(Math.toRadians(a)));
					double z = this.z + (r * Math.sin(Math.toRadians(a)));

					player.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, x, this.y + 1, z, 30, 15, 0);
				}
				break;
		}
	}
}

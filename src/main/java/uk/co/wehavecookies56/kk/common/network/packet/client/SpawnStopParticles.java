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
		double r = 1.5D;
		switch (this.lvl) {
			case 1:
				r = 1.5D;
				for (int a = 1; a <= 360; a += 15) {
					double x = this.x + (r * Math.cos(Math.toRadians(a)));
					double z = this.z + (r * Math.sin(Math.toRadians(a)));
					player.worldObj.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, x, this.y + 2, z, 0.0D, 0.5D, 0.0D);
				}
				break;
			case 2:
				r = 1.5D;
				for (int a = 1; a <= 360; a += 15) {
					double x = this.x + (r * Math.cos(Math.toRadians(a)));
					double z = this.z + (r * Math.sin(Math.toRadians(a)));
					player.worldObj.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, x, this.y + 2, z, 0.0D, 0.5D, 0.0D);
				}
				break;
			case 3:
				r = 1.5D;
				for (int a = 1; a <= 360; a += 15) {
					double x = this.x + (r * Math.cos(Math.toRadians(a)));
					double z = this.z + (r * Math.sin(Math.toRadians(a)));
					player.worldObj.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, x, this.y + 2, z, 0.0D, 0.5D, 0.0D);
				}
				break;
			// player.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL,
			// x,
			// player.posY, z, 0.0D, 1.0D, 0.0D);
		}
	}

}

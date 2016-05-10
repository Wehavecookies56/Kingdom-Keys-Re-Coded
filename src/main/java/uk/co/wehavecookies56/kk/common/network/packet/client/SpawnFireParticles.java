package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class SpawnFireParticles extends AbstractMessage.AbstractClientMessage<SpawnFireParticles> {

	double x, y, z;
	int lvl;

	public SpawnFireParticles () {}

	public SpawnFireParticles (Entity entity, int level) {
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
				for (int a = 1; a <= 360; a += 7) {
					double x = this.x + (r * Math.cos(Math.toRadians(a)));
					double z = this.z + (r * Math.sin(Math.toRadians(a)));

					player.worldObj.spawnParticle(EnumParticleTypes.FLAME, x, this.y + 1.25D, z, 0.0D, 0.0D, 0.0D);
					player.worldObj.spawnParticle(EnumParticleTypes.FLAME, x, this.y + 1.05D, z, 0.0D, 0.0D, 0.0D);

				}
				break;

			case 2:
				r = 1.7D;
				for (int a = 1; a <= 360; a += 7) {
					double x = this.x + (r * Math.cos(Math.toRadians(a)));
					double z = this.z + (r * Math.sin(Math.toRadians(a)));

					player.worldObj.spawnParticle(EnumParticleTypes.FLAME, x, this.y + 1.65D, z, 0.0D, 0.0D, 0.0D);
					player.worldObj.spawnParticle(EnumParticleTypes.FLAME, x, this.y + 1.05D, z, 0.0D, 0.0D, 0.0D);

				}
				break;

			case 3:
				r = 2D;
				for (int a = 1; a <= 360; a += 7) {
					double x = this.x + (r * Math.cos(Math.toRadians(a)));
					double z = this.z + (r * Math.sin(Math.toRadians(a)));
					double x2 = this.x + (r / 1.3 * Math.cos(Math.toRadians(a)));
					double z2 = this.z + (r / 1.3 * Math.sin(Math.toRadians(a)));

					KingdomKeys.proxy.spawnTestParticle(player.worldObj, x2, this.y + 2.0D, z2, 0.0D, 0.0D, 0.0D);
					KingdomKeys.proxy.spawnTestParticle(player.worldObj, x2, this.y + 2.0D, z2, 0.0D, 0.0D, 0.0D);
					KingdomKeys.proxy.spawnTestParticle(player.worldObj, x, this.y + 1.5D, z, 0.0D, 0.0D, 0.0D);
					KingdomKeys.proxy.spawnTestParticle(player.worldObj, x, this.y + 1D, z, 0.0D, 0.0D, 0.0D);
					KingdomKeys.proxy.spawnTestParticle(player.worldObj, x, this.y + 0.5D, z, 0.0D, 0.0D, 0.0D);
					KingdomKeys.proxy.spawnTestParticle(player.worldObj, x, this.y + 0.0D, z, 0.0D, 0.0D, 0.0D);
				}
				break;
		}
	}
}

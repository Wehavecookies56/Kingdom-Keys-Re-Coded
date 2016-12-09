package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class SpawnDriveFormParticles extends AbstractMessage.AbstractClientMessage<SpawnDriveFormParticles> {

	double px, py, pz;
	EntityPlayer player;

	public SpawnDriveFormParticles () {}

	public SpawnDriveFormParticles (Entity entity) {
		px = entity.posX;
		py = entity.posY;
		pz = entity.posZ;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		px = buffer.readDouble();
		py = buffer.readDouble();
		pz = buffer.readDouble();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeDouble(px);
		buffer.writeDouble(py);
		buffer.writeDouble(pz);
	}

	@Override
	public void process (EntityPlayer player, Side side) {

		double r;
		r = 1.2D;
		for (int a = 1; a <= 360; a += 7)
			for (double i = 0; i < 2.5; i = i + 0.2) {
				double x = px + (r * Math.cos(Math.toRadians(a)));
				double z = pz + (r * Math.sin(Math.toRadians(a)));
				if (i < 0.5 || i > 2) {
					x = px + (r / 1.3 * Math.cos(Math.toRadians(a)));
					z = pz + (r / 1.3 * Math.sin(Math.toRadians(a)));
				}
				if (i < 0.3 || i > 2.2) {
					x = px + (r / 1.5 * Math.cos(Math.toRadians(a)));
					z = pz + (r / 1.5 * Math.sin(Math.toRadians(a)));
				}
				if (i > 1 && i < 1.5) {
					x = px + (r * 1.1 * Math.cos(Math.toRadians(a)));
					z = pz + (r * 1.1 * Math.sin(Math.toRadians(a)));
				}
				player.world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, x, py + i, z, 0.0D, 0.3, 0.0D);
			}
	}
}

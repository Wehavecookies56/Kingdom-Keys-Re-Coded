package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class SpawnWisdomShotParticles extends AbstractMessage.AbstractClientMessage<SpawnWisdomShotParticles> {

	double x, y, z;

	public SpawnWisdomShotParticles () {}

	public SpawnWisdomShotParticles (Entity entity) {
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
		player.world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
	}
}
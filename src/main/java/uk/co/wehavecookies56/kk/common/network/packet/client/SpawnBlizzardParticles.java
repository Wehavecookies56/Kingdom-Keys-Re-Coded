package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class SpawnBlizzardParticles extends AbstractMessage.AbstractClientMessage<SpawnBlizzardParticles> {

	double x, y, z;
	int lvl;

	public SpawnBlizzardParticles () {}

	public SpawnBlizzardParticles (Entity entity, int level) {
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
		switch (this.lvl) {
			case 1:
				player.world.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
				player.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
				break;
			case 2:
				player.world.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
				player.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
				break;
			case 3:
				player.world.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
				player.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
				break;
		}
	}
}

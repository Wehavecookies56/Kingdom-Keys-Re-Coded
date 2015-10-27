package wehavecookies56.kk.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractClientMessage;

public class SpawnThunderParticles extends AbstractClientMessage<SpawnThunderParticles> {

	double x, y, z;
	int lvl;
	public SpawnThunderParticles() {}

	public SpawnThunderParticles(Entity entity, int level) {
		x = entity.posX;
		y = entity.posY;
		z = entity.posZ;
		lvl = level;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		x = buffer.readDouble();
		y = buffer.readDouble();
		z = buffer.readDouble();
		lvl = buffer.readInt();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeDouble(x);
		buffer.writeDouble(y);
		buffer.writeDouble(z);
		buffer.writeInt(lvl);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		double r = 1.5D;
		switch(this.lvl)
		{
			case 1:
				for(int a = 1; a <= 360; a+=7){
					double x = this.x + (r * Math.cos(Math.toRadians(a)));
					double z = this.z + (r * Math.sin(Math.toRadians(a)));
		
					player.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, x, this.y+1, z, 30, 15, 0);
				}
			break;
		}
	}
}

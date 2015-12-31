package wehavecookies56.kk.network.packet.client;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractClientMessage;
import wehavecookies56.kk.util.SoundHelper;

public class SpawnDriveFormParticles extends AbstractClientMessage<SpawnDriveFormParticles> {

	double x, y, z;

	public SpawnDriveFormParticles() {}

	public SpawnDriveFormParticles(Entity entity) {
		x = entity.posX;
		y = entity.posY;
		z = entity.posZ;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		x = buffer.readDouble();
		y = buffer.readDouble();
		z = buffer.readDouble();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeDouble(x);
		buffer.writeDouble(y);
		buffer.writeDouble(z);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		double r;
		r = 1.2D;
		for(int a = 1; a <= 360; a+=7){
			for(double i = 0; i<2.5; i= i+0.2)
			{
				double x = player.posX + (r * Math.cos(Math.toRadians(a)));
				double z = player.posZ + (r * Math.sin(Math.toRadians(a)));
				if(i < 0.5 || i > 2)
				{
					x = player.posX + (r/1.3 * Math.cos(Math.toRadians(a)));
					z = player.posZ + (r/1.3 * Math.sin(Math.toRadians(a)));
				}
				if(i < 0.3 || i > 2.2)
				{
					x = player.posX + (r/1.5 * Math.cos(Math.toRadians(a)));
					z = player.posZ + (r/1.5 * Math.sin(Math.toRadians(a)));
				}
				if(i > 1 && i < 1.5)
				{
					x = player.posX + (r*1.1 * Math.cos(Math.toRadians(a)));
					z = player.posZ + (r*1.1 * Math.sin(Math.toRadians(a)));
				}
				/*double x2 = player.posX + (r/1.3 * Math.cos(Math.toRadians(a)));
				double z2 = player.posZ + (r/1.3 * Math.sin(Math.toRadians(a)));*/
				player.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, x, player.posY + i, z, 0.0D, 0.3, 0.0D);
		/*	player.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, x, player.posY + 2.0D, z, 0.0D, 0.0D, 0.0D);
			player.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, x, player.posY + 1.5D, z, 0.0D, 0.0D, 0.0D);
			player.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, x, player.posY + 1.0D, z, 0.0D, 0.0D, 0.0D);
			player.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, x, player.posY + 0.5D, z, 0.0D, 0.0D, 0.0D);
			player.worldObj.spawnParticle(EnumParticleTypes.CRIT_MAGIC, x2, player.posY + 0.0D, z2, 0.0D, 0.0D, 0.0D);*/
			}
		}
	}
}



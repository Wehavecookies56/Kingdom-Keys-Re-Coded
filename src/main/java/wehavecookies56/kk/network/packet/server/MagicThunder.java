package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.magic.EntityThunder;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class MagicThunder extends AbstractServerMessage<MagicThunder> {

	public MagicThunder() {}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {}

	@Override
	public void process(EntityPlayer player, Side side) {
		double posy = player.posY;
		World world = player.worldObj;
		if(!player.onGround)
		{
			//something to figure out the player position
		}
		EntityThunder thunder;
		thunder = new EntityThunder(world, player.posX+2, player.posY, player.posZ);
		world.spawnEntityInWorld(thunder);
		thunder = new EntityThunder(world, player.posX, player.posY, player.posZ+2);
		world.spawnEntityInWorld(thunder);
		thunder = new EntityThunder(world, player.posX-2, player.posY, player.posZ);
		world.spawnEntityInWorld(thunder);
		thunder = new EntityThunder(world, player.posX, player.posY, player.posZ-2);
		world.spawnEntityInWorld(thunder);

		thunder = new EntityThunder(world, player.posX+2, player.posY, player.posZ+2);
		world.spawnEntityInWorld(thunder);
		thunder = new EntityThunder(world, player.posX+2, player.posY, player.posZ+2);
		world.spawnEntityInWorld(thunder);
		thunder = new EntityThunder(world, player.posX-2, player.posY, player.posZ-2);
		world.spawnEntityInWorld(thunder);
		thunder = new EntityThunder(world, player.posX-2, player.posY, player.posZ-2);
		world.spawnEntityInWorld(thunder);
	}

}

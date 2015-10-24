package wehavecookies56.kk.network.packet.server.magics;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.magic.EntityAero;
import wehavecookies56.kk.entities.magic.EntityAeroga;
import wehavecookies56.kk.entities.magic.EntityAerora;
import wehavecookies56.kk.lib.Constants;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class MagicAero extends AbstractServerMessage<MagicAero> {

	public MagicAero() {}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process(EntityPlayer player, Side side){
		if(!ExtendedPlayer.get(player).cheatMode)
		{
			ExtendedPlayer.get(player).removeMp(Constants.AERO_COST);
		}		World world = player.worldObj;
		if(!world.isRemote)
		{
			switch(ExtendedPlayer.get(player).getMagicLevel("Aero"))
			{
			case 1:
				world.spawnEntityInWorld(new EntityAero(world, player, player.posX, player.posY, player.posZ));
			break;
			case 2:
				world.spawnEntityInWorld(new EntityAerora(world, player, player.posX, player.posY, player.posZ));
			break;
			case 3:
				world.spawnEntityInWorld(new EntityAeroga(world, player, player.posX, player.posY, player.posZ));
			break;
			}
		}
	}

}

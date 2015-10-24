package wehavecookies56.kk.network.packet.server.magics;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.magic.EntityCura;
import wehavecookies56.kk.entities.magic.EntityCuraga;
import wehavecookies56.kk.entities.magic.EntityCure;
import wehavecookies56.kk.lib.Constants;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class MagicCure extends AbstractServerMessage<MagicCure> {

	public MagicCure() {}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process(EntityPlayer player, Side side) {
		if(!ExtendedPlayer.get(player).cheatMode)
		{
			ExtendedPlayer.get(player).setMp(0);
		}
		World world = player.worldObj;
		switch(ExtendedPlayer.get(player).getMagicLevel("Cure")){
		case 1:
			player.heal(6);
			world.spawnEntityInWorld(new EntityCure(world, player, player.posX, player.posY, player.posZ));
			break;
		case 2:
			player.heal(20);
			world.spawnEntityInWorld(new EntityCura(world, player, player.posX, player.posY, player.posZ));
			break;
		case 3:
			player.heal(80);
			world.spawnEntityInWorld(new EntityCuraga(world, player, player.posX, player.posY, player.posZ));
			break;
		}

	}
}

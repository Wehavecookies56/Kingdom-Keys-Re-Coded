package wehavecookies56.kk.network.packet.server.magics;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.magic.EntityFira;
import wehavecookies56.kk.entities.magic.EntityFiraga;
import wehavecookies56.kk.entities.magic.EntityFire;
import wehavecookies56.kk.lib.Constants;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class MagicFire extends AbstractServerMessage<MagicFire> {

	public MagicFire () {}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process (EntityPlayer player, Side side) {
		if (!ExtendedPlayer.get(player).cheatMode) ExtendedPlayer.get(player).removeMp(Constants.getCost(Strings.Spell_Fire));
		World world = player.worldObj;
		switch (ExtendedPlayer.get(player).getMagicLevel(Strings.Spell_Fire)) {
			case 1:
				world.spawnEntityInWorld(new EntityFire(world, player, player.posX, player.posY, player.posZ, 1));
				break;
			case 2:
				world.spawnEntityInWorld(new EntityFira(world, player, player.posX, player.posY, player.posZ, 1));
				break;
			case 3:
				world.spawnEntityInWorld(new EntityFiraga(world, player, player.posX, player.posY, player.posZ, 1));
				break;
		}
	}
}
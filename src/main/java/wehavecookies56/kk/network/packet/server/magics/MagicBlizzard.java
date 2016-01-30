package wehavecookies56.kk.network.packet.server.magics;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.magic.EntityBlizzaga;
import wehavecookies56.kk.entities.magic.EntityBlizzara;
import wehavecookies56.kk.entities.magic.EntityBlizzard;
import wehavecookies56.kk.lib.Constants;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class MagicBlizzard extends AbstractServerMessage<MagicBlizzard> {

	public MagicBlizzard () {}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process (EntityPlayer player, Side side) {
		if (!ExtendedPlayer.get(player).cheatMode) ExtendedPlayer.get(player).removeMp(Constants.getCost(Strings.Gui_CommandMenu_Magic_Blizzard));
		World world = player.worldObj;
		switch (ExtendedPlayer.get(player).getMagicLevel("Blizzard")) {
			case 1:
				world.spawnEntityInWorld(new EntityBlizzard(world, player));
				break;
			case 2:
				world.spawnEntityInWorld(new EntityBlizzara(world, player));
				break;
			case 3:
				world.spawnEntityInWorld(new EntityBlizzaga(world, player));
				break;
		}
	}

}

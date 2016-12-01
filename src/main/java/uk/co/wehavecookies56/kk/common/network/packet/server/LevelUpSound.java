package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class LevelUpSound extends AbstractMessage.AbstractServerMessage<LevelUpSound> {

	public LevelUpSound () {}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		player.world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.levelup, SoundCategory.MASTER, 1.0f, 1.0f);
	}
}

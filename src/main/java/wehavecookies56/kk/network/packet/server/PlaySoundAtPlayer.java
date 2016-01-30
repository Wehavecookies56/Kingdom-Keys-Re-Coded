package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.util.SoundHelper;

public class PlaySoundAtPlayer extends AbstractServerMessage<PlaySoundAtPlayer> {

	String sound;
	float volume, pitch;

	public PlaySoundAtPlayer () {}

	public PlaySoundAtPlayer (String sound, float volume, float pitch) {
		this.sound = sound;
		this.volume = volume;
		this.pitch = pitch;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		this.sound = buffer.readStringFromBuffer(100);
		this.volume = buffer.readFloat();
		this.pitch = buffer.readFloat();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeString(sound);
		buffer.writeFloat(volume);
		buffer.writeFloat(pitch);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		SoundHelper.playSoundAtEntity(player.worldObj, player, sound, volume, pitch);
	}

}

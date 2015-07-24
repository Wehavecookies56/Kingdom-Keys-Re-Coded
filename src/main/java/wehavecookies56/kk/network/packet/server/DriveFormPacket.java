package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.api.driveforms.DriveForm;
import wehavecookies56.kk.driveforms.DriveFormValor;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class DriveFormPacket extends AbstractServerMessage<DriveFormPacket> {

	public DriveFormPacket() {}

	boolean revert;
	String form;
	DriveForm df;

	public DriveFormPacket(Boolean revert)
	{
		this.revert = revert;
		this.form = "";
	}

	public DriveFormPacket(String driveform)
	{
		this.form = driveform;
		this.revert = false;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.form = buffer.readStringFromBuffer(100);
		this.revert = buffer.readBoolean();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeString(form);
		buffer.writeBoolean(revert);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		System.out.println(form);
		if(this.revert)
		{
			ExtendedPlayer.get(player).setInDrive(false);
		}
		if(this.form.equals("valor"))
		{
			df = new DriveFormValor();
			df.initDrive((EntityPlayer) player);
		}

	}

}

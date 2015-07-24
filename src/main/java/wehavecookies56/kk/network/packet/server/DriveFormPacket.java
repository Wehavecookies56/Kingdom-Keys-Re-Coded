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
	}
	
	public DriveFormPacket(String driveform)
	{
		this.form = driveform;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process(EntityPlayer player, Side side) {
		if(this.revert)
		{
			ExtendedPlayer.get(player).setInDrive(false);
		}
		if(this.form == "valor")
		{
			df = new DriveFormValor();
		}
		df.initDrive((EntityPlayer) player);

	}

}

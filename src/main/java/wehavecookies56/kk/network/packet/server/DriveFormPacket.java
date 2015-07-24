package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.api.driveforms.DriveForm;
import wehavecookies56.kk.driveforms.DriveFormAnti;
import wehavecookies56.kk.driveforms.DriveFormFinal;
import wehavecookies56.kk.driveforms.DriveFormLimit;
import wehavecookies56.kk.driveforms.DriveFormMaster;
import wehavecookies56.kk.driveforms.DriveFormValor;
import wehavecookies56.kk.driveforms.DriveFormWisdom;
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
		if(this.revert)
		{
			ExtendedPlayer.get(player).setInDrive(false);
			ExtendedPlayer.get(player).setDriveInUse("none");
		}
		
		if(this.form.equals("valor"))
		{			
			df = new DriveFormValor();
			ExtendedPlayer.get(player).setDriveInUse("valor");
		}
		else if(this.form.equals("wisdom"))
		{
			df = new DriveFormWisdom();
			ExtendedPlayer.get(player).setDriveInUse("wisdom");
		}
		else if(this.form.equals("limit"))
		{
			df = new DriveFormLimit();
			ExtendedPlayer.get(player).setDriveInUse("limit");
		}
		else if(this.form.equals("master"))
		{
			df = new DriveFormMaster();
			ExtendedPlayer.get(player).setDriveInUse("master");
		}
		else if(this.form.equals("final"))
		{
			df = new DriveFormFinal();
			ExtendedPlayer.get(player).setDriveInUse("final");
		}
		else if(this.form.equals("anti"))
		{
			df = new DriveFormAnti();
			ExtendedPlayer.get(player).setDriveInUse("anti");
		}
		System.out.println(df);

		df.initDrive((EntityPlayer) player);
	}

}

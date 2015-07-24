package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.api.driveforms.DriveForm;
import wehavecookies56.kk.driveforms.DriveFormValor;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class ValorInit extends AbstractServerMessage<ValorInit> {

	public ValorInit() {}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process(EntityPlayer player, Side side) {
		DriveForm df = new DriveFormValor();
		df.initDrive((EntityPlayer) player);

	}

}

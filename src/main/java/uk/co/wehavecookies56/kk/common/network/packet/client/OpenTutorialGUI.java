package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.core.helper.GuiHelper;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

/**
 * Created by Toby on 09/04/2017.
 */
public class OpenTutorialGUI extends AbstractMessage.AbstractClientMessage<OpenTutorialGUI> {

	int id;
	boolean always;
	
    public OpenTutorialGUI() {

    }
    
    public OpenTutorialGUI(int id) {
    	this.id = id;
    	this.always = false;
    }
    
    public OpenTutorialGUI(int id, boolean always) {
    	this.id = id;
    	this.always = always;
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
    	id = buffer.readInt();
    	always = buffer.readBoolean();
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
    	buffer.writeInt(id);
    	buffer.writeBoolean(always);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
    	GuiHelper.openTutorial(id,always);
    }
}

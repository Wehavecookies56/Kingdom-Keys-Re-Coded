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
	
    public OpenTutorialGUI() {

    }
    
    public OpenTutorialGUI(int id) {
    	this.id = id;
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
    	id = buffer.readInt();
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
    	buffer.writeInt(id);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        //player.openGui(KingdomKeys.instance, GuiIDs.GUI_TUTORIAL, player.world, (int) player.posX, (int) player.posY, (int) player.posZ);
    	GuiHelper.openTutorial(id);
    }
}

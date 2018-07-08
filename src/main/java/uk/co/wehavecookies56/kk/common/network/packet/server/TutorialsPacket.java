package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.Tutorial;
import uk.co.wehavecookies56.kk.common.lib.Tutorials;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncTutorials;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;

public class TutorialsPacket extends AbstractServerMessage<TutorialsPacket> {


	private int id;

    public TutorialsPacket () {}

    public TutorialsPacket (int id) {
        this.id = id;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        id = buffer.readInt();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeInt(id);
    }


    @Override
    public void process (EntityPlayer player, Side side) {
    	if(!player.getCapability(ModCapabilities.TUTORIALS, null).getKnownTutorial(id)) {
			Tutorial tutorial = Tutorials.getTutorialById(id);
    		player.sendMessage(new TextComponentTranslation("You unlocked a new tutorial: \""+tutorial.getTutorialName()+"\""));
    		player.getCapability(ModCapabilities.TUTORIALS, null).setKnownTutorial(id,true);
    	}
    	
    	PacketDispatcher.sendTo(new SyncTutorials(player.getCapability(ModCapabilities.TUTORIALS, null)), (EntityPlayerMP) player);
    }

}

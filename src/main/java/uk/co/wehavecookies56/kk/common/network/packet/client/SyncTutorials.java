package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisRecipeCapability;
import uk.co.wehavecookies56.kk.common.capability.TutorialsCapability;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class SyncTutorials extends AbstractMessage.AbstractClientMessage<SyncTutorials> {

    private List<Integer> tutorials;

    public SyncTutorials() {}

    public SyncTutorials(TutorialsCapability.ITutorials tutorial) {
        this.tutorials = tutorial.getKnownTutorials();
       // System.out.println(tutorials);

    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
    	tutorials = new ArrayList<Integer>();
        while(buffer.isReadable()){
        	tutorials.add(buffer.readInt());
        }
    	//System.out.println(tutorials);

    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        for (int i = 0; i < tutorials.size(); i++){
            buffer.writeInt(tutorials.get(i));
        }
       // System.out.println(tutorials);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        final TutorialsCapability.ITutorials tutorial = player.getCapability(ModCapabilities.TUTORIALS, null);
        for (int i = 0; i < tutorials.size(); i++) {
        	tutorial.setKnownTutorial(tutorials.get(i), true);
        }
    }


}

package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncFreeDevRecipeData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMaterialData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMunnyData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncRecipeData;

public class OpenSynthesis extends AbstractMessage.AbstractServerMessage<OpenSynthesis> {

    public OpenSynthesis() {}

    @Override
    protected void read (PacketBuffer buffer) throws IOException {

    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {

    }

    @Override
    public void process (EntityPlayer player, Side side) {
        PacketDispatcher.sendTo(new SyncMunnyData(player.getCapability(ModCapabilities.MUNNY, null)), (EntityPlayerMP) player);
        PacketDispatcher.sendTo(new SyncRecipeData(player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null)), (EntityPlayerMP) player);
        PacketDispatcher.sendTo(new SyncFreeDevRecipeData(player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null)), (EntityPlayerMP) player);
        PacketDispatcher.sendTo(new SyncMaterialData(player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null)), (EntityPlayerMP) player);
    }
}

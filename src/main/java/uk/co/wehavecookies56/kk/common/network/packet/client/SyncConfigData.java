package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;

public class SyncConfigData extends AbstractClientMessage<SyncConfigData> {

    double xpMultiplier;

    public SyncConfigData() {}

    public SyncConfigData(double xp) {
        this.xpMultiplier = xp;
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        this.xpMultiplier = buffer.readDouble();
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeDouble(this.xpMultiplier);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        MainConfig.entities.xpMultiplier = xpMultiplier;
    }
}

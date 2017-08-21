package uk.co.wehavecookies56.kk.common.network.packet.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;

import java.io.IOException;

public class SyncHudData extends AbstractClientMessage<SyncHudData> {

    boolean hudMode;

    public SyncHudData() {}

    public SyncHudData(PlayerStatsCapability.IPlayerStats stats) {
        this.hudMode = stats.getHudMode();
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        this.hudMode = buffer.readBoolean();
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeBoolean(this.hudMode);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        player.getCapability(ModCapabilities.PLAYER_STATS, null).setHudMode(this.hudMode);
    }
}

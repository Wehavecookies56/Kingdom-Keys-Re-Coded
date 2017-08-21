package uk.co.wehavecookies56.kk.common.network.packet.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.CheatModeCapability;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;

import java.io.IOException;

public class SyncCheatModeData extends AbstractClientMessage<SyncCheatModeData> {

    boolean cheatmode;

    public SyncCheatModeData() {}

    public SyncCheatModeData(CheatModeCapability.ICheatMode state, PlayerStatsCapability.IPlayerStats stats) {
        this.cheatmode = state.getCheatMode();
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        this.cheatmode = buffer.readBoolean();
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeBoolean(this.cheatmode);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        final CheatModeCapability.ICheatMode state = player.getCapability(ModCapabilities.CHEAT_MODE, null);
        state.setCheatMode(this.cheatmode);
    }
}

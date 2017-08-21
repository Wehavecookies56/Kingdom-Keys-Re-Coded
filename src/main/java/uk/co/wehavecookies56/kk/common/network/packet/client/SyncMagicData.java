package uk.co.wehavecookies56.kk.common.network.packet.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.MagicStateCapability.IMagicState;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;

import java.io.IOException;

public class SyncMagicData extends AbstractClientMessage<SyncMagicData> {

    int
    fireLevel,
    blizzardLevel,
    thunderLevel,
    cureLevel,
    aeroLevel,
    stopLevel;
    double mp;

    public SyncMagicData() {}

    public SyncMagicData(IMagicState state, PlayerStatsCapability.IPlayerStats stats) {
        this.fireLevel = state.getMagicLevel(Strings.Spell_Fire);
        this.blizzardLevel = state.getMagicLevel(Strings.Spell_Blizzard);
        this.thunderLevel = state.getMagicLevel(Strings.Spell_Thunder);
        this.cureLevel = state.getMagicLevel(Strings.Spell_Cure);
        this.aeroLevel = state.getMagicLevel(Strings.Spell_Aero);
        this.stopLevel = state.getMagicLevel(Strings.Spell_Stop);
        this.mp = stats.getMP();
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        this.fireLevel = buffer.readInt();
        this.blizzardLevel = buffer.readInt();
        this.thunderLevel = buffer.readInt();
        this.cureLevel = buffer.readInt();
        this.aeroLevel = buffer.readInt();
        this.stopLevel = buffer.readInt();
        this.mp = buffer.readDouble();
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeInt(this.fireLevel);
        buffer.writeInt(this.blizzardLevel);
        buffer.writeInt(this.thunderLevel);
        buffer.writeInt(this.cureLevel);
        buffer.writeInt(this.aeroLevel);
        buffer.writeInt(this.stopLevel);
        buffer.writeDouble(this.mp);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        final IMagicState state = player.getCapability(ModCapabilities.MAGIC_STATE, null);
        final PlayerStatsCapability.IPlayerStats stats = player.getCapability(ModCapabilities.PLAYER_STATS, null);
        state.setMagicLevel(Strings.Spell_Fire, fireLevel);
        state.setMagicLevel(Strings.Spell_Blizzard, blizzardLevel);
        state.setMagicLevel(Strings.Spell_Thunder, thunderLevel);
        state.setMagicLevel(Strings.Spell_Cure, cureLevel);
        state.setMagicLevel(Strings.Spell_Aero, aeroLevel);
        state.setMagicLevel(Strings.Spell_Stop, stopLevel);
        stats.setMP(mp);
    }
}

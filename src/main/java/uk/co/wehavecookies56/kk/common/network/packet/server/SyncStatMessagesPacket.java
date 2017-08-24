package uk.co.wehavecookies56.kk.common.network.packet.server;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability.IPlayerStats;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

import java.io.IOException;

public class SyncStatMessagesPacket extends AbstractMessage.AbstractClientMessage<SyncStatMessagesPacket> {

    String stat;

    public SyncStatMessagesPacket () {}

    public SyncStatMessagesPacket (String stat) {
        this.stat = stat;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        this.stat = buffer.readString(50);
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeString(this.stat);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        if (this.stat != null) {
            IPlayerStats STATS = player.getCapability(ModCapabilities.PLAYER_STATS, null);
            if (this.stat.equals("clr")) STATS.getMessages().clear();
            if (this.stat.equals(Strings.Stats_LevelUp_Def)) STATS.getMessages().add(Strings.Stats_LevelUp_Def);
            if (this.stat.equals(Strings.Stats_LevelUp_Str)) STATS.getMessages().add(Strings.Stats_LevelUp_Str);
            if (this.stat.equals(Strings.Stats_LevelUp_Magic)) STATS.getMessages().add(Strings.Stats_LevelUp_Magic);
            if (this.stat.equals(Strings.Stats_LevelUp_HP)) STATS.getMessages().add(Strings.Stats_LevelUp_HP);
            if (this.stat.equals("fir")) STATS.getMessages().add("fir");
            if (this.stat.equals("bli")) STATS.getMessages().add("bli");
            if (this.stat.equals("thu")) STATS.getMessages().add("thu");
            if (this.stat.equals("cur")) STATS.getMessages().add("cur");
            if (this.stat.equals("gra")) STATS.getMessages().add("gra");
            if (this.stat.equals("aer")) STATS.getMessages().add("aer");
            if (this.stat.equals("sto")) STATS.getMessages().add("sto");
            if (this.stat.equals(Strings.Stats_LevelUp_FormGauge)) STATS.getMessages().add(Strings.Stats_LevelUp_FormGauge);
            if (this.stat.equals(Strings.Stats_LevelUp_HighJump)) STATS.getMessages().add(Strings.Stats_LevelUp_HighJump);
            if (this.stat.equals(Strings.Stats_LevelUp_QuickRun)) STATS.getMessages().add(Strings.Stats_LevelUp_QuickRun);
            if (this.stat.equals(Strings.Stats_LevelUp_DodgeRoll)) STATS.getMessages().add(Strings.Stats_LevelUp_DodgeRoll);
            if (this.stat.equals(Strings.Stats_LevelUp_AerialDodge)) STATS.getMessages().add(Strings.Stats_LevelUp_AerialDodge);
            if (this.stat.equals(Strings.Stats_LevelUp_Glide)) STATS.getMessages().add(Strings.Stats_LevelUp_Glide);

        }
    }

}

package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.MunnyCapability.IMunny;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;

public class SyncMunnyData extends AbstractClientMessage<SyncMunnyData> {

    int munny;

    public SyncMunnyData() {}

    public SyncMunnyData(IMunny munny) {
        this.munny = munny.getMunny();
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        this.munny = buffer.readInt();
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeInt(this.munny);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        final IMunny munny = player.getCapability(ModCapabilities.MUNNY, null);
        munny.setMunny(this.munny);
    }

}

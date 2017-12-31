package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SummonKeybladeCapability.ISummonKeyblade;
import uk.co.wehavecookies56.kk.common.container.inventory.InventoryKeychain;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;

public class SyncKeybladeData extends AbstractClientMessage<SyncKeybladeData> {

    boolean summonedMainHand;
    boolean summonedOffHand;
    NBTTagCompound data;
    int activeSlot;

    public SyncKeybladeData() {}

    public SyncKeybladeData(ISummonKeyblade keyblade) {
        this.summonedMainHand = keyblade.getIsKeybladeSummoned(EnumHand.MAIN_HAND);
        this.summonedOffHand = keyblade.getIsKeybladeSummoned(EnumHand.OFF_HAND);
        this.activeSlot = keyblade.activeSlot();
        this.data = new NBTTagCompound();
        data.setTag(InventoryKeychain.SAVE_KEY, keyblade.getInventoryKeychain().serializeNBT());
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        this.summonedMainHand = buffer.readBoolean();
        this.summonedOffHand = buffer.readBoolean();
        this.activeSlot = buffer.readInt();
        this.data = buffer.readCompoundTag();
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeBoolean(this.summonedMainHand);
        buffer.writeBoolean(this.summonedOffHand);
        buffer.writeInt(this.activeSlot);
        buffer.writeCompoundTag(data);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        final ISummonKeyblade keyblade = player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null);
        keyblade.setIsKeybladeSummoned(EnumHand.MAIN_HAND, this.summonedMainHand);
        keyblade.setIsKeybladeSummoned(EnumHand.OFF_HAND, this.summonedOffHand);
        keyblade.setActiveSlot(this.activeSlot);
        keyblade.getInventoryKeychain().deserializeNBT(data.getCompoundTag(InventoryKeychain.SAVE_KEY));
    }

}

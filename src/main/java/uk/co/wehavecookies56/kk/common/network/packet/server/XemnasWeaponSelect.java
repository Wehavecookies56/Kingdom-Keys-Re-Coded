package uk.co.wehavecookies56.kk.common.network.packet.server;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

import java.io.IOException;

public class XemnasWeaponSelect extends AbstractMessage.AbstractServerMessage<XemnasWeaponSelect>
{

    ItemStack weapon;

    public XemnasWeaponSelect() {

    }

    public XemnasWeaponSelect(ItemStack weapon) {
        this.weapon = weapon;
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        weapon = buffer.readItemStack();
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeItemStack(weapon);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        player.getCapability(ModCapabilities.Xemnas, null).setCurrentWeapon(weapon.getItem());
    }
}

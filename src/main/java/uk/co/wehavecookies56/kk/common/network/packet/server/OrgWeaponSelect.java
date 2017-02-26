package uk.co.wehavecookies56.kk.common.network.packet.server;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.util.Utils;

import java.io.IOException;

/**
 * Created by Toby on 09/02/2017.
 */
public class

OrgWeaponSelect extends AbstractMessage.AbstractServerMessage<OrgWeaponSelect> {

    ItemStack weapon;

    public OrgWeaponSelect() {

    }

    public OrgWeaponSelect(ItemStack weapon) {
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
        player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(weapon.getItem());
    }
}

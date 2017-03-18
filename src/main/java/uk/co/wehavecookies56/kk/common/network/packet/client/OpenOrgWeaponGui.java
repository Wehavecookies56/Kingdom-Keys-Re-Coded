package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.gui.GuiOrgWeapon;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

/**
 * Created by Toby on 04/05/2016.
 */
public class OpenOrgWeaponGui extends AbstractMessage.AbstractClientMessage<OpenOrgWeaponGui> {

    public OpenOrgWeaponGui() {}

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
    }

    @Override
    public void process(EntityPlayer player, Side side) {
    	Minecraft.getMinecraft().displayGuiScreen(new GuiOrgWeapon());
    }
}

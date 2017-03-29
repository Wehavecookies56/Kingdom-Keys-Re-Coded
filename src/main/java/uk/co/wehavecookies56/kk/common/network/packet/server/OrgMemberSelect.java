package uk.co.wehavecookies56.kk.common.network.packet.server;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgXIIIData;
import uk.co.wehavecookies56.kk.common.util.Utils;

import java.io.IOException;

/**
 * Created by Toby on 09/02/2017.
 */
public class

OrgMemberSelect extends AbstractMessage.AbstractServerMessage<OrgMemberSelect> {

    Utils.OrgMember member;

    public OrgMemberSelect() {

    }

    public OrgMemberSelect(Utils.OrgMember member) {
        this.member = member;
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        member = Utils.OrgMember.values()[buffer.readInt()];
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeInt(member.ordinal());
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setMember(member);
        player.sendMessage(new TextComponentString("You have aligned with " + member.name()));
        switch (member) {
            case AXEL: player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(ModItems.Ashes); break;
            case DEMYX: player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(ModItems.BasicModel); break;
            case LARXENE: player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(ModItems.Trancheuse); break;
            case LEXAEUS: player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(ModItems.Reticence); break;
            case LUXORD: player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(ModItems.TheFool); break;
            case MARLUXIA: player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(ModItems.FickleErica); break;
            case ROXAS: player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(ModItems.KingdomKey); break;

            case SAIX: player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(ModItems.NewMoon); break;
            case VEXEN: player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(ModItems.TesterZero); break;
            case XALDIN: player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(ModItems.Zephyr); break;
            case XEMNAS: player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(ModItems.Malice); break;
            case XIGBAR: player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(ModItems.Standalone); break;
            case ZEXION: player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(ModItems.BlackPrimer); break;
        }
		PacketDispatcher.sendTo(new SyncOrgXIIIData(player.getCapability(ModCapabilities.ORGANIZATION_XIII, null)), (EntityPlayerMP) player);
    }
}

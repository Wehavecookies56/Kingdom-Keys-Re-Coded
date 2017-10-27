package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.OrganizationXIIICapability;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgXIIIData;
import uk.co.wehavecookies56.kk.common.util.Utils;

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
        OrganizationXIIICapability.IOrganizationXIII org = player.getCapability(ModCapabilities.ORGANIZATION_XIII, null);
        if (player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getIsKeybladeSummoned(EnumHand.MAIN_HAND)) {
            Utils.summonWeapon(player, EnumHand.MAIN_HAND, 0);
        }
        if (player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getIsKeybladeSummoned(EnumHand.OFF_HAND)) {
            Utils.summonWeapon(player, EnumHand.OFF_HAND, 0);
        }
        org.setMember(member);
        player.sendMessage(new TextComponentString("You have aligned with " + member.name()));
        switch (member) {
            case AXEL: org.setCurrentWeapon(ModItems.Ashes); org.addUnlockedWeapon(ModItems.Ashes); break;
            case DEMYX: org.setCurrentWeapon(ModItems.BasicModel); org.addUnlockedWeapon(ModItems.BasicModel); break;
            case LARXENE: org.setCurrentWeapon(ModItems.Trancheuse); org.addUnlockedWeapon(ModItems.Trancheuse); break;
            case LEXAEUS: org.setCurrentWeapon(ModItems.Reticence); org.addUnlockedWeapon(ModItems.Reticence); break;
            case LUXORD: org.setCurrentWeapon(ModItems.TheFool); org.addUnlockedWeapon(ModItems.TheFool); break;
            case MARLUXIA: org.setCurrentWeapon(ModItems.FickleErica); org.addUnlockedWeapon(ModItems.FickleErica); break;
            case ROXAS: org.setCurrentWeapon(ModItems.KingdomKey); org.addUnlockedWeapon(ModItems.KingdomKey); break;

            case SAIX: org.setCurrentWeapon(ModItems.NewMoon); org.addUnlockedWeapon(ModItems.NewMoon); break;
            case VEXEN: org.setCurrentWeapon(ModItems.TesterZero); org.addUnlockedWeapon(ModItems.TesterZero); break;
            case XALDIN: org.setCurrentWeapon(ModItems.Zephyr); org.addUnlockedWeapon(ModItems.Zephyr); break;
            case XEMNAS: org.setCurrentWeapon(ModItems.Malice); org.addUnlockedWeapon(ModItems.Malice); break;
            case XIGBAR: org.setCurrentWeapon(ModItems.Standalone); org.addUnlockedWeapon(ModItems.Standalone); break;
            case ZEXION: org.setCurrentWeapon(ModItems.BlackPrimer); org.addUnlockedWeapon(ModItems.BlackPrimer); break;
        }
        PacketDispatcher.sendTo(new SyncOrgXIIIData(org), (EntityPlayerMP) player);
    }
}

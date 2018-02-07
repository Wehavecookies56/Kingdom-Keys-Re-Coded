package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.OrganizationXIIICapability;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;
import uk.co.wehavecookies56.kk.common.util.PortalCoords;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class SyncOrgXIIIData extends AbstractClientMessage<SyncOrgXIIIData> {

    Utils.OrgMember member;
    Item weapon;
    List<Item> weapons;
    boolean summonedMainHand;
    boolean summonedOffHand;
    boolean opened;
    //int dim;
   // double orgPortalX;
    //double orgPortalY;
    //double orgPortalZ;
    
    PortalCoords[] orgPortalCoords = {new PortalCoords((byte)0,0,0,0,0),new PortalCoords((byte)0,0,0,0,0),new PortalCoords((byte)0,0,0,0,0)};
    int unlockPoints;

    public SyncOrgXIIIData() {}

    public SyncOrgXIIIData(OrganizationXIIICapability.IOrganizationXIII organizationXIII) {
        this.member = organizationXIII.getMember();
        this.weapon = organizationXIII.currentWeapon();
        this.summonedMainHand = organizationXIII.summonedWeapon(EnumHand.MAIN_HAND);
        this.summonedOffHand = organizationXIII.summonedWeapon(EnumHand.OFF_HAND);
        this.weapons = organizationXIII.unlockedWeapons();
        this.opened = organizationXIII.getOpenedGUI();
        //this.dim = organizationXIII.getPortalDimension();
        for(byte i=0;i<3;i++) {
        	this.orgPortalCoords[i] = organizationXIII.getPortalCoords((byte)i);
        }
        this.unlockPoints = organizationXIII.getUnlockPoints();
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        this.member = Utils.OrgMember.values()[buffer.readInt()];
        this.weapon = buffer.readItemStack().getItem();
        this.summonedMainHand = buffer.readBoolean();
        this.summonedOffHand = buffer.readBoolean();
        this.opened = buffer.readBoolean();

        for(byte i=0;i<3;i++) {
    		this.orgPortalCoords[i].setPID(buffer.readByte());
    		this.orgPortalCoords[i].setX(buffer.readDouble());
    		this.orgPortalCoords[i].setY(buffer.readDouble());
    		this.orgPortalCoords[i].setZ(buffer.readDouble());
    		this.orgPortalCoords[i].setDimID(buffer.readInt());
        }

        this.unlockPoints = buffer.readInt();

        weapons = new ArrayList<>();
        while(buffer.isReadable()) {
            weapons.add(buffer.readItemStack().getItem());
        }
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeInt(this.member.ordinal());
        buffer.writeItemStack(new ItemStack(this.weapon));
        buffer.writeBoolean(this.summonedMainHand);
        buffer.writeBoolean(this.summonedOffHand);
        buffer.writeBoolean(this.opened);
        
        for(byte i=0;i<3;i++) {
        	buffer.writeByte(this.orgPortalCoords[i].getPID());
        	buffer.writeDouble(this.orgPortalCoords[i].getX());
        	buffer.writeDouble(this.orgPortalCoords[i].getY());
        	buffer.writeDouble(this.orgPortalCoords[i].getZ());
        	buffer.writeInt(this.orgPortalCoords[i].getDimID());
        }
        buffer.writeInt(this.unlockPoints);

        for (int i = 0; i < weapons.size(); i++) {
            buffer.writeItemStack(new ItemStack(this.weapons.get(i)));
        }
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        final OrganizationXIIICapability.IOrganizationXIII organizationXIII = player.getCapability(ModCapabilities.ORGANIZATION_XIII, null);
        organizationXIII.setMember(this.member);
        organizationXIII.setCurrentWeapon(this.weapon);
        organizationXIII.setUnlockedWeapons(this.weapons);
        organizationXIII.setWeaponSummoned(EnumHand.MAIN_HAND, this.summonedMainHand);
        organizationXIII.setWeaponSummoned(EnumHand.OFF_HAND, this.summonedOffHand);
        organizationXIII.setOpenedGUI(this.opened);

        for(byte i=0;i<3;i++) {
        	organizationXIII.setPortalCoords(i, this.orgPortalCoords[i]);
        }
        organizationXIII.setUnlockPoints(this.unlockPoints);
    }

}

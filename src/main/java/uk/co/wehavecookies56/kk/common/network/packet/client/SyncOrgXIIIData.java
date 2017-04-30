package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.OrganizationXIIICapability;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class SyncOrgXIIIData extends AbstractClientMessage<SyncOrgXIIIData> {

	Utils.OrgMember member;
	Item weapon;
	List<Item> weapons;
	boolean summoned, opened;
	double orgPortalX;
	double orgPortalY;
	double orgPortalZ;

	public SyncOrgXIIIData() {}

	public SyncOrgXIIIData(OrganizationXIIICapability.IOrganizationXIII organizationXIII) {
		this.member = organizationXIII.getMember();
		this.weapon = organizationXIII.currentWeapon();
		this.summoned = organizationXIII.summonedWeapon();
		this.weapons = organizationXIII.unlockedWeapons();
		this.opened = organizationXIII.getOpenedGUI();
		this.orgPortalX = organizationXIII.getPortalX();
		this.orgPortalY = organizationXIII.getPortalY();
		this.orgPortalZ = organizationXIII.getPortalZ();
	}
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.member = Utils.OrgMember.values()[buffer.readInt()];
		this.weapon = buffer.readItemStack().getItem();
		this.summoned = buffer.readBoolean();
		this.opened = buffer.readBoolean();
		this.orgPortalX = buffer.readDouble();
		this.orgPortalY = buffer.readDouble();
		this.orgPortalZ = buffer.readDouble();

		weapons = new ArrayList<>();
		while(buffer.isReadable()) {
			weapons.add(buffer.readItemStack().getItem());
		}
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(this.member.ordinal());
		buffer.writeItemStack(new ItemStack(this.weapon));
		buffer.writeBoolean(this.summoned);
		buffer.writeBoolean(this.opened);
		buffer.writeDouble(this.orgPortalX);
		buffer.writeDouble(this.orgPortalY);
		buffer.writeDouble(this.orgPortalZ);
		
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
		organizationXIII.setWeaponSummoned(this.summoned);
		organizationXIII.setOpenedGUI(this.opened);
		organizationXIII.setPortalX(this.orgPortalX);
		organizationXIII.setPortalY(this.orgPortalY);
		organizationXIII.setPortalZ(this.orgPortalZ);
	}

}

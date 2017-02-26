package uk.co.wehavecookies56.kk.common.network.packet.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.MunnyCapability.IMunny;
import uk.co.wehavecookies56.kk.common.capability.OrganizationXIIICapability;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;
import uk.co.wehavecookies56.kk.common.util.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SyncOrgXIIIData extends AbstractClientMessage<SyncOrgXIIIData> {

	Utils.OrgMember member;
	Item weapon;
	List<Item> weapons;
	boolean summoned;

	public SyncOrgXIIIData() {}

	public SyncOrgXIIIData(OrganizationXIIICapability.IOrganizationXIII organizationXIII) {
		this.member = organizationXIII.getMember();
		this.weapon = organizationXIII.currentWeapon();
		this.summoned = organizationXIII.summonedWeapon();
		this.weapons = organizationXIII.unlockedWeapons();
	}
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.member = Utils.OrgMember.values()[buffer.readInt()];
		this.weapon = buffer.readItemStack().getItem();
		this.summoned = buffer.readBoolean();
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
	}

}

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

public class SyncOrgXIIIData extends AbstractClientMessage<SyncOrgXIIIData> {

	Utils.OrgMember member;
	Item weapon;

	public SyncOrgXIIIData() {}

	public SyncOrgXIIIData(OrganizationXIIICapability.IOrganizationXIII organizationXIII) {
		this.member = organizationXIII.getMember();
		this.weapon = organizationXIII.currentWeapon();
	}
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.member = Utils.OrgMember.values()[buffer.readInt()];
		this.weapon = buffer.readItemStack().getItem();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(this.member.ordinal());
		buffer.writeItemStack(new ItemStack(this.weapon));
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		final OrganizationXIIICapability.IOrganizationXIII organizationXIII = player.getCapability(ModCapabilities.ORGANIZATION_XIII, null);
		organizationXIII.setMember(this.member);
		organizationXIII.setCurrentWeapon(this.weapon);
	}

}

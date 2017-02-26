package uk.co.wehavecookies56.kk.common.network.packet.server;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.item.org.IOrgWeapon;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncKeybladeData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgXIIIData;

import java.io.IOException;

public class SummonOrgWeapon extends AbstractMessage.AbstractServerMessage<SummonOrgWeapon> {

	ItemStack stack;

	public SummonOrgWeapon() {}

	public SummonOrgWeapon(Item weapon) {
		this.stack = new ItemStack(weapon);
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		stack = buffer.readItemStack();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeItemStack(stack);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		ItemStack slot = stack;
		
		player.inventory.setInventorySlotContents(player.inventory.currentItem, stack);
		player.world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.summon, SoundCategory.MASTER, 1.0f, 1.0f);
		player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setWeaponSummoned(true);
		PacketDispatcher.sendTo(new SyncOrgXIIIData(player.getCapability(ModCapabilities.ORGANIZATION_XIII, null)), (EntityPlayerMP) player);
	}
}
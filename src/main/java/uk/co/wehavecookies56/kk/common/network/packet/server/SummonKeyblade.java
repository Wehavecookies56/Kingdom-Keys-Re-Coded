package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncKeybladeData;

public class SummonKeyblade extends AbstractMessage.AbstractServerMessage<SummonKeyblade> {

	ItemStack stack;

	public SummonKeyblade () {}

	public SummonKeyblade (ItemKeyblade itemKeyblade) {
		this.stack = new ItemStack(itemKeyblade);
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
		ItemStack slot = player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain().getStackInSlot(0);
		ItemStack keyblade = new ItemStack(stack.getItem(), 1, 0, slot.serializeNBT());
		
		player.inventory.setInventorySlotContents(player.inventory.currentItem, keyblade);
		player.world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.summon, SoundCategory.MASTER, 1.0f, 1.0f);
		player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).setIsKeybladeSummoned(true);
		PacketDispatcher.sendTo(new SyncKeybladeData(player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null)), (EntityPlayerMP) player);
	}
}
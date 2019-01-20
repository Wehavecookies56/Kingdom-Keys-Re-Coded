package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.items.ItemStackHandler;
import uk.co.wehavecookies56.kk.common.capability.MagicStateCapability.IMagicState;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.item.base.ItemSpellOrb;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMagicData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMagicInventory;

public class SwapMagic extends AbstractMessage.AbstractServerMessage<SwapMagic> {

	public SwapMagic() {
	}

	int i;
	String dir;

	public SwapMagic(int i, String dir) {
		this.i = i;
		this.dir = dir;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		i = buffer.readInt();
		dir = buffer.readString(10);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(i);
		buffer.writeString(dir);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		// System.out.println(i+" "+dir);//TODO cambiar +1 por +1 o -1
		IMagicState MAGIC_STATE = player.getCapability(ModCapabilities.MAGIC_STATE, null);
		ItemStackHandler inv = MAGIC_STATE.getInventorySpells();
		ItemSpellOrb spell = (ItemSpellOrb) inv.getStackInSlot(i).getItem();

		int slotTo;
		if (dir.equals("up")) {
			if (i == 0) {
				slotTo = inv.getSlots() - 1;
			} else {
				slotTo = i - 1;
			}
		} else {
			if (i == inv.getSlots() - 1) {
				slotTo = 0;
			} else {
				slotTo = i + 1;
			}
		}

		if (ItemStack.areItemsEqual(inv.getStackInSlot(slotTo), ItemStack.EMPTY)) {
			inv.setStackInSlot(slotTo, new ItemStack(spell));
			inv.setStackInSlot(i, ItemStack.EMPTY);
		} else {
			ItemSpellOrb spellTo = (ItemSpellOrb) inv.getStackInSlot(slotTo).getItem();
			System.out.println("Swap " + spell.getMagicName() + " With " + spellTo.getMagicName() + "\n");
			
			inv.setStackInSlot(slotTo, new ItemStack(spell));
			inv.setStackInSlot(i, new ItemStack(spellTo));
		}

		PacketDispatcher.sendTo(new SyncMagicInventory(MAGIC_STATE), (EntityPlayerMP) player);
	}
}

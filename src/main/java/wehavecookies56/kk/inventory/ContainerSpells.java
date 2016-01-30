package wehavecookies56.kk.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import wehavecookies56.kk.item.ItemSpellOrb;

public class ContainerSpells extends Container {
	private static final int INV_START = InventorySpells.INV_SIZE, INV_END = INV_START + 26, HOTBAR_START = INV_END + 1,
			HOTBAR_END = HOTBAR_START + 8;

	public ContainerSpells(EntityPlayer player, InventoryPlayer inventoryPlayer, InventorySpells inventory) {
		int i;
		for (i = 0; i < INV_START; i++)
			addSlotToContainer(new SlotCustom(inventory, i, 26 + (18 * i), 30, 4));
		for (i = 0; i < 3; ++i)
			for (int j = 0; j < 9; ++j)
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
		for (i = 0; i < 9; ++i)
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
		ItemStack itemstack = null;
		Slot slot = this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 < INV_START) {
				if (!mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1, true))
					return null;
				slot.onSlotChange(itemstack1, itemstack);
			} else if (itemstack1.getItem() instanceof ItemSpellOrb) {
				if (!mergeItemStack(itemstack1, 0, InventorySpells.INV_SIZE, false))
					return null;
			} else if (par2 >= INV_START && par2 < HOTBAR_START) {
				if (!mergeItemStack(itemstack1, HOTBAR_START, HOTBAR_START + 1, false))
					return null;
			} else if (par2 >= HOTBAR_START && par2 < HOTBAR_END + 1)
				if (!mergeItemStack(itemstack1, INV_START, INV_END + 1, false))
					return null;
			if (itemstack1.stackSize == 0)
				slot.putStack((ItemStack) null);
			else
				slot.onSlotChanged();

			if (itemstack1.stackSize == itemstack.stackSize)
				return null;

			slot.onPickupFromSlot(player, itemstack1);
		}
		return itemstack;
	}
}

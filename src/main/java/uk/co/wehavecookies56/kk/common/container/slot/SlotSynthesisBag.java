package uk.co.wehavecookies56.kk.common.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.common.item.ItemSynthesisBagS;
import uk.co.wehavecookies56.kk.common.item.base.ItemSynthesisMaterial;

public class SlotSynthesisBag extends Slot {

	public SlotSynthesisBag (IInventory inventory, int index, int x, int y) {
		super(inventory, index, x, y);
	}

	@Override
	public boolean isItemValid (ItemStack stack) {
		return !(stack.getItem() instanceof ItemSynthesisBagS) && stack.getItem() instanceof ItemSynthesisMaterial;
	}
}

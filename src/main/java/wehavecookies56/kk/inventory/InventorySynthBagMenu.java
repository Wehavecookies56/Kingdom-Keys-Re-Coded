package wehavecookies56.kk.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import wehavecookies56.kk.item.ItemSynthesisBagL;
import wehavecookies56.kk.item.ItemSynthesisBagM;
import wehavecookies56.kk.item.ItemSynthesisBagS;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.TextHelper;

public class InventorySynthBagMenu extends AbstractInventory {
	private final String name = TextHelper.localize(Strings.SynthBagInventory);

	/** The key used to store and retrieve the inventory from NBT */
	private static final String SAVE_KEY = "SynthBagInvKey";
	
	public static final int INV_SIZE = 1;
	
	public InventorySynthBagMenu() {
		this.inventory = new ItemStack[INV_SIZE];
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public boolean hasCustomName() {
		return true;
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if(stack.getItem() instanceof ItemSynthesisBagS || stack.getItem() instanceof ItemSynthesisBagM || stack.getItem() instanceof ItemSynthesisBagL)
		{
			return true;
		}
		return false;
	}

	@Override
	protected String getNbtKey() {
		return SAVE_KEY;
	}
	
	public void copy(AbstractInventory inv) {
		for (int i = 0; i < inv.getSizeInventory(); ++i) {
			ItemStack stack = inv.getStackInSlot(i);
			inventory[i] = (stack == null ? null : stack.copy());
		}
		markDirty();
	}

}

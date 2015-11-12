package wehavecookies56.kk.inventory;

import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.item.ItemKeychain;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.TextHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class InventorySynthesisBag extends AbstractInventory {
	private final String name = TextHelper.localize(Strings.KeychainInventory);

	/** The key used to store and retrieve the inventory from NBT */
	public static final int INV_SIZE = 63;
	
	public InventorySynthesisBag(EntityPlayer player, ItemStack itemStack) {
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
		return stack.getItem() instanceof ItemKeychain;
	}
	
	public void copy(AbstractInventory inv) {
		for (int i = 0; i < inv.getSizeInventory(); ++i) {
			ItemStack stack = inv.getStackInSlot(i);
			inventory[i] = (stack == null ? null : stack.copy());
		}
		markDirty();
	}

	@Override
	protected String getNbtKey() {
		// TODO Auto-generated method stub
		return null;
	}

}

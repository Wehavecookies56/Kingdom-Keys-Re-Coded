package wehavecookies56.kk.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import wehavecookies56.kk.item.KKPotion;
import wehavecookies56.kk.util.TextHelper;

public class InventoryPotionsMenu extends AbstractInventory {
	private final String name = TextHelper.localize("Potions Menu");

	/** The key used to store and retrieve the inventory from NBT */
	private static final String SAVE_KEY = "PotionsInvKey";
    private ItemStack[] inv;
	public static final int INV_SIZE = 5;
	
	public InventoryPotionsMenu() {
		this.inventory = new ItemStack[INV_SIZE];
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
		return stack.getItem() instanceof KKPotion;
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

	@Override
	public String getCommandSenderName() {
		return name;
	}
	
	@Override
	public IChatComponent getDisplayName() {
		return new ChatComponentText(name);
	}
}

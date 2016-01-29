package wehavecookies56.kk.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.item.ItemDriveForm;
import wehavecookies56.kk.item.ItemSpellOrb;
import wehavecookies56.kk.util.TextHelper;

public class InventoryDriveForms extends AbstractInventory {
	private final String name = TextHelper.localize("Drive Forms");

	/** The key used to store and retrieve the inventory from NBT */
	private static final String SAVE_KEY = "DriveInvKey";
	private ItemStack[] inv;
	public static final int INV_SIZE = 5;

	public InventoryDriveForms () {
		this.inventory = new ItemStack[INV_SIZE];
	}

	@Override
	public boolean hasCustomName () {
		return true;
	}

	@Override
	public int getInventoryStackLimit () {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer (EntityPlayer player) {
		return true;
	}

	@Override
	public void markDirty () {
		ExtendedPlayer.driveForms.clear();
		for (int i = 0; i < getSizeInventory(); i++)
			if (getStackInSlot(i) != null) ExtendedPlayer.driveForms.add(((ItemDriveForm) getStackInSlot(i).getItem()).getDriveFormName());
		super.markDirty();
	}

	@Override
	public boolean isItemValidForSlot (int index, ItemStack stack) {
		return stack.getItem() instanceof ItemSpellOrb;
	}

	@Override
	protected String getNbtKey () {
		return SAVE_KEY;
	}

	public void copy (AbstractInventory inv) {
		for (int i = 0; i < inv.getSizeInventory(); ++i) {
			ItemStack stack = inv.getStackInSlot(i);
			inventory[i] = (stack == null ? null : stack.copy());
		}
		markDirty();
	}

	@Override
	public String getCommandSenderName () {
		return name;
	}

	@Override
	public IChatComponent getDisplayName () {
		return new ChatComponentText(name);
	}
}

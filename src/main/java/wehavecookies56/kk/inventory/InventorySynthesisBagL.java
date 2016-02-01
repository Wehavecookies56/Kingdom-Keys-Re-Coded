package wehavecookies56.kk.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import wehavecookies56.kk.item.ItemSynthesisBagL;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.TextHelper;

public class InventorySynthesisBagL extends AbstractInventory {

	private String name = TextHelper.localize(Strings.SynthesisBagLInventory);

	private static final String SAVE_KEY = "SynthesisBagLInventory";

	public static final int INV_SIZE = 56;

	private final ItemStack invStack;

	public InventorySynthesisBagL (ItemStack stack) {
		inventory = new ItemStack[INV_SIZE];
		this.invStack = stack;
		if (!invStack.hasTagCompound()) invStack.setTagCompound(new NBTTagCompound());
		readFromNBT(invStack.getTagCompound());
	}

	@Override
	public int getInventoryStackLimit () {
		return 64;
	}

	@Override
	public boolean hasCustomName () {
		return name.length() > 0;
	}

	@Override
	public void markDirty () {
		for (int i = 0; i < getSizeInventory(); i++)
			if (getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0) inventory[i] = null;
		writeToNBT(invStack.getTagCompound());
	}

	@Override
	public boolean isUseableByPlayer (EntityPlayer player) {
		return player.getHeldItem() == invStack;
	}

	@Override
	public boolean isItemValidForSlot (int index, ItemStack stack) {
		return !(stack.getItem() instanceof ItemSynthesisBagL);
	}

	@Override
	protected String getNbtKey () {
		return SAVE_KEY;
	}

	@Override
	public void setInventorySlotContents (int slot, ItemStack itemstack) {
		inventory[slot] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) itemstack.stackSize = getInventoryStackLimit();
		writeToNBT(invStack.getTagCompound());
	}

	@Override
	public String getName () {
		return name;
	}

	@Override
	public IChatComponent getDisplayName () {
		return new ChatComponentText(name);
	}

}

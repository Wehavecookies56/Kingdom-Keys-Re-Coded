package uk.co.wehavecookies56.kk.common.container.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.item.ItemSynthesisBagL;
import uk.co.wehavecookies56.kk.common.lib.Strings;

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
		return player.getHeldItem(EnumHand.MAIN_HAND) == invStack;
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
	public String getName () {
		return name;
	}

	@Override
	public ITextComponent getDisplayName () {
		return new TextComponentString(name);
	}

}

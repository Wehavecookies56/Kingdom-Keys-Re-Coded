package wehavecookies56.kk.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import wehavecookies56.kk.item.ItemSynthesisBagM;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.TextHelper;

public class InventorySynthesisBagM extends AbstractInventory {

	private String name = TextHelper.localize(Strings.SynthesisBagMInventory);
	
	private static final String SAVE_KEY = "SynthesisBagMInventory";
	
	public static final int INV_SIZE = 28;
	
	private final ItemStack invStack;
	
	public InventorySynthesisBagM(ItemStack stack) {
		inventory = new ItemStack[INV_SIZE];
		this.invStack = stack;
		if(!invStack.hasTagCompound()){
			invStack.setTagCompound(new NBTTagCompound());
		}
		readFromNBT(invStack.getTagCompound());
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public boolean hasCustomName() {
		return name.length() > 0;
	}

	@Override
	public void markDirty() {
		for(int i = 0; i < getSizeInventory(); i++){
			if(getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0){
				inventory[i] = null;
			}
		}
		writeToNBT(invStack.getTagCompound());
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return player.getHeldItem() == invStack;
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return !(stack.getItem() instanceof ItemSynthesisBagM);
	}

	@Override
	protected String getNbtKey() {
		return SAVE_KEY;
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

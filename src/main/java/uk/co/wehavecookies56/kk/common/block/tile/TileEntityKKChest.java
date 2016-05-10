package uk.co.wehavecookies56.kk.common.block.tile;

import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class TileEntityKKChest extends TileEntity implements IInventory {
	ItemStack keyblade;
	final int NUMBER_OF_SLOTS = 36;
	private ItemStack[] itemStacks = new ItemStack[NUMBER_OF_SLOTS];

	@Override
	public int getSizeInventory () {
		return itemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot (int slotIndex) {
		return itemStacks[slotIndex];
	}

	@Override
	public ItemStack decrStackSize (int slotIndex, int count) {
		ItemStack itemStackInSlot = getStackInSlot(slotIndex);
		if (itemStackInSlot == null) return null;

		ItemStack itemStackRemoved;
		if (itemStackInSlot.stackSize <= count) {
			itemStackRemoved = itemStackInSlot;
			setInventorySlotContents(slotIndex, null);
		} else {
			itemStackRemoved = itemStackInSlot.splitStack(count);
			if (itemStackInSlot.stackSize == 0) setInventorySlotContents(slotIndex, null);
		}
		markDirty();
		return itemStackRemoved;
	}

	@Override
	public void setInventorySlotContents (int slotIndex, ItemStack itemstack) {
		itemStacks[slotIndex] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) itemstack.stackSize = getInventoryStackLimit();
		markDirty();
	}

	@Override
	public int getInventoryStackLimit () {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer (EntityPlayer player) {
		if (this.worldObj.getTileEntity(this.pos) != this) return false;
		final double X_CENTRE_OFFSET = 0.5;
		final double Y_CENTRE_OFFSET = 0.5;
		final double Z_CENTRE_OFFSET = 0.5;
		final double MAXIMUM_DISTANCE_SQ = 8.0 * 8.0;
		return player.getDistanceSq(pos.getX() + X_CENTRE_OFFSET, pos.getY() + Y_CENTRE_OFFSET, pos.getZ() + Z_CENTRE_OFFSET) < MAXIMUM_DISTANCE_SQ;
	}

	@Override
	public boolean isItemValidForSlot (int slotIndex, ItemStack itemstack) {
		return true;
	}

	@Override
	public void writeToNBT (NBTTagCompound parentNBTTagCompound) {
		super.writeToNBT(parentNBTTagCompound);

		NBTTagList dataForAllSlots = new NBTTagList();
		for (int i = 0; i < this.itemStacks.length; ++i)
			if (this.itemStacks[i] != null) {
				NBTTagCompound dataForThisSlot = new NBTTagCompound();
				dataForThisSlot.setByte("Slot", (byte) i);
				this.itemStacks[i].writeToNBT(dataForThisSlot);
				dataForAllSlots.appendTag(dataForThisSlot);
			}
		parentNBTTagCompound.setTag("Items", dataForAllSlots);

		NBTTagCompound keybladeCompound = new NBTTagCompound();
		if (keyblade != null)
			keyblade.writeToNBT(keybladeCompound);
		parentNBTTagCompound.setTag("Keyblade", keybladeCompound);

	}

	@Override
	public void readFromNBT (NBTTagCompound parentNBTTagCompound) {
		super.readFromNBT(parentNBTTagCompound);
		final byte NBT_TYPE_COMPOUND = 10;
		NBTTagList dataForAllSlots = parentNBTTagCompound.getTagList("Items", NBT_TYPE_COMPOUND);

		Arrays.fill(itemStacks, null);
		for (int i = 0; i < dataForAllSlots.tagCount(); ++i) {
			NBTTagCompound dataForOneSlot = dataForAllSlots.getCompoundTagAt(i);
			int slotIndex = dataForOneSlot.getByte("Slot") & 255;
			if (slotIndex >= 0 && slotIndex < this.itemStacks.length) this.itemStacks[slotIndex] = ItemStack.loadItemStackFromNBT(dataForOneSlot);
		}

		NBTTagCompound keybladeCompound = parentNBTTagCompound.getCompoundTag("Keyblade");
		keyblade = ItemStack.loadItemStackFromNBT(keybladeCompound);
	}

	@Override
	public void clear () {
		Arrays.fill(itemStacks, null);
	}

	@Override
	public boolean hasCustomName () {
		return false;
	}

	@Override
	public ITextComponent getDisplayName () {
		return hasCustomName() ? new TextComponentString(getName()) : new TextComponentTranslation(getName(), new Object[0]);
	}
	
	

	@Override
	public ItemStack removeStackFromSlot (int slotIndex) {
		ItemStack itemStack = getStackInSlot(slotIndex);
		if (itemStack != null) setInventorySlotContents(slotIndex, null);
		return itemStack;
	}

	@Override
	public void openInventory (EntityPlayer player) {}

	@Override
	public void closeInventory (EntityPlayer player) {}

	@Override
	public int getField (int id) {
		return 0;
	}

	@Override
	public void setField (int id, int value) {}

	@Override
	public int getFieldCount () {
		return 0;
	}

	@Override
	public String getName () {
		return TextHelper.localize(Strings.KKChestInventory);
	}

	public ItemStack getKeyblade() {
		return keyblade;
	}

	public void setKeyblade(ItemStack keyblade) {
		this.keyblade = keyblade;
	}
}
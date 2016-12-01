package uk.co.wehavecookies56.kk.common.block.tile;

import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;
/**
 * Created by Toby on 06/11/2016.
 */
public class TileEntityPedestal extends TileEntity implements IInventory {
	final int NUMBER_OF_SLOTS = 1;
	private ItemStack[] itemStacks = new ItemStack[NUMBER_OF_SLOTS];
	public int rotation=0;
	public ItemStack keyblade;

	public void setRotation(char option){
		if(option == '-')
			if(rotation<=0)
				rotation=4;
			else
				rotation--;
		else if(option=='+')
			if(rotation>=4)
				rotation=0;
			else
				rotation++;
		markDirty();
	}
	
	public int getRotation(){
		return this.rotation;
	}
	
	
	public void setKeyblade(ItemStack keyblade){
		this.keyblade = keyblade;
		markDirty();
	}
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
		if (itemStackInSlot.getCount() <= count) {
			itemStackRemoved = itemStackInSlot;
			setInventorySlotContents(slotIndex, ItemStack.EMPTY);
		} else {
			itemStackRemoved = itemStackInSlot.splitStack(count);
			if (itemStackInSlot.getCount() == 0) setInventorySlotContents(slotIndex, ItemStack.EMPTY);
		}
		markDirty();
		return itemStackRemoved;
	}

	@Override
	public void setInventorySlotContents (int slotIndex, ItemStack itemstack) {
		itemStacks[slotIndex] = itemstack;
		if (itemstack != ItemStack.EMPTY && itemstack.getCount() > getInventoryStackLimit())
			itemstack.setCount(getInventoryStackLimit());
		markDirty();
	}

	@Override
	public int getInventoryStackLimit () {
		return 1;
	}

	@Override
	public boolean isUsableByPlayer (EntityPlayer player) {
		if (this.world.getTileEntity(this.pos) != this) return false;
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
	public NBTTagCompound writeToNBT (NBTTagCompound parentNBTTagCompound) {
		super.writeToNBT(parentNBTTagCompound);

		NBTTagList dataForAllSlots = new NBTTagList();
		for (int i = 0; i < this.itemStacks.length; ++i)
			if (this.itemStacks[i] != ItemStack.EMPTY) {
				NBTTagCompound dataForThisSlot = new NBTTagCompound();
				dataForThisSlot.setByte("Slot", (byte) i);
				this.itemStacks[i].writeToNBT(dataForThisSlot);
				dataForAllSlots.appendTag(dataForThisSlot);
			}
		parentNBTTagCompound.setTag("Items", dataForAllSlots);	
		parentNBTTagCompound.setInteger("Rotation", rotation);
		NBTTagCompound keybladeCompound = new NBTTagCompound();
		if (keyblade != ItemStack.EMPTY)
			keyblade.writeToNBT(keybladeCompound);
		parentNBTTagCompound.setTag("Keyblade", keybladeCompound);
		return parentNBTTagCompound;
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
			if (slotIndex >= 0 && slotIndex < this.itemStacks.length) 
				this.itemStacks[slotIndex] = new ItemStack(dataForOneSlot);
		}
		rotation = parentNBTTagCompound.getInteger("Rotation");
		NBTTagCompound keybladeCompound = parentNBTTagCompound.getCompoundTag("Keyblade");
		keyblade = new ItemStack(keybladeCompound);
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
		return Utils.translateToLocal(Strings.Pedestal);
	}

	@Override
	public boolean isEmpty() {
		return itemStacks.length == 0;
	}
}
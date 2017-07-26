package uk.co.wehavecookies56.kk.common.block.tile;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.util.Utils;

/**
 * Created by Toby on 06/11/2016.
 */
public class TileEntityPedestal extends TileEntity {
    final int NUMBER_OF_SLOTS = 1;
    private ItemStackHandler itemStacks = new ItemStackHandler(NUMBER_OF_SLOTS);
    public int rotation=0;
    public ItemStack keyblade;

    public void setRotation(char option){
        if(option == '-')
            if(rotation<=0)
                rotation=3;
            else
                rotation--;
        else if(option=='+')
            if(rotation>=3)
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

    public ItemStack getKeyblade() {
        return this.keyblade;
    }

    @Override
    public NBTTagCompound writeToNBT (NBTTagCompound parentNBTTagCompound) {
        parentNBTTagCompound.setTag("inventory", itemStacks.serializeNBT());
        parentNBTTagCompound.setInteger("Rotation", rotation);
        NBTTagCompound keybladeCompound = new NBTTagCompound();
        if (keyblade != null)
            keyblade.writeToNBT(keybladeCompound);
        parentNBTTagCompound.setTag("Keyblade", keybladeCompound);
        return super.writeToNBT(parentNBTTagCompound);
    }

    @Override
    public void readFromNBT (NBTTagCompound parentNBTTagCompound) {
        itemStacks.deserializeNBT(parentNBTTagCompound.getCompoundTag("inventory"));
        rotation = parentNBTTagCompound.getInteger("Rotation");
        NBTTagCompound keybladeCompound = parentNBTTagCompound.getCompoundTag("Keyblade");
        keyblade = new ItemStack(keybladeCompound);
        super.readFromNBT(parentNBTTagCompound);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ||  super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)itemStacks : super.getCapability(capability, facing);
    }

    @Override
    public ITextComponent getDisplayName () {
        if (getKeyblade() != null && getKeyblade() != ItemStack.EMPTY) {
            return new TextComponentTranslation(getName(), "");
        }else
            return null;
    }

    public String getName() {
        if (getKeyblade() != null && getKeyblade() != ItemStack.EMPTY) {
            if(getKeyblade().getItem() instanceof ItemKeychain)
                return Utils.translateToLocal(((ItemKeychain) getKeyblade().getItem()).getKeyblade().getUnlocalizedName()+".name");
            else
                return Utils.translateToLocal(getKeyblade().getDisplayName());
        }
        return null;
    }
}
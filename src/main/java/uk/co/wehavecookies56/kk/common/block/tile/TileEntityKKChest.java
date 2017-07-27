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
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class TileEntityKKChest extends TileEntity {
    ItemStack keyblade;
    final int NUMBER_OF_SLOTS = 36;
    private ItemStackHandler itemStacks = new ItemStackHandler(NUMBER_OF_SLOTS);

    @Override
    public NBTTagCompound writeToNBT (NBTTagCompound parentNBTTagCompound) {
        parentNBTTagCompound.setTag("inventory", itemStacks.serializeNBT());
        NBTTagCompound keybladeCompound = new NBTTagCompound();
        if (keyblade != null && !ItemStack.areItemStacksEqual(keyblade, ItemStack.EMPTY))
            keyblade.writeToNBT(keybladeCompound);
        parentNBTTagCompound.setTag("Keyblade", keybladeCompound);
        return parentNBTTagCompound;
    }

    @Override
    public void readFromNBT (NBTTagCompound parentNBTTagCompound) {
        super.readFromNBT(parentNBTTagCompound);
        itemStacks.deserializeNBT(parentNBTTagCompound.getCompoundTag("inventory"));
        NBTTagCompound keybladeCompound = parentNBTTagCompound.getCompoundTag("Keyblade");
        keyblade = new ItemStack(keybladeCompound);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)itemStacks : super.getCapability(capability, facing);
    }

    public ItemStack getKeyblade() {
        return keyblade;
    }

    @Nullable
    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentTranslation(Strings.KKChest);
    }

    public void setKeyblade(ItemStack keyblade) {
        this.keyblade = keyblade;
    }
}
package uk.co.wehavecookies56.kk.common.block.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class TileEntityOrgPortal extends TileEntity{
    String ownerName;
    final int NUMBER_OF_SLOTS = 36;
    private ItemStack[] itemStacks = new ItemStack[NUMBER_OF_SLOTS];

    @Override
    public NBTTagCompound writeToNBT (NBTTagCompound parentNBTTagCompound) {
        super.writeToNBT(parentNBTTagCompound);
        if (ownerName != null)
            parentNBTTagCompound.setString("owner", ownerName);
        return parentNBTTagCompound;
    }

    @Override
    public void readFromNBT (NBTTagCompound parentNBTTagCompound) {
        super.readFromNBT(parentNBTTagCompound);
        final byte NBT_TYPE_COMPOUND = 10;

        ownerName = parentNBTTagCompound.getString("owner");
    }

    @Override
    public ITextComponent getDisplayName () {
        return new TextComponentTranslation(ownerName+"'s Portal", new Object[0]);
    }

    public String getOwner() {
        return ownerName;
    }

    public void setOwner(EntityPlayer player) {
        this.ownerName = player.getDisplayNameString();
    }
}
package uk.co.wehavecookies56.kk.common.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.items.ItemStackHandler;
import uk.co.wehavecookies56.kk.common.container.inventory.InventoryKeychain;

public class SummonKeybladeCapability {

    public interface ISummonKeyblade {
        boolean getIsKeybladeSummoned();
        void setIsKeybladeSummoned(boolean summoned);

        ItemStackHandler getInventoryKeychain();
    }

    public static class Storage implements IStorage<ISummonKeyblade> {

        @Override
        public NBTBase writeNBT(Capability<ISummonKeyblade> capability, ISummonKeyblade instance, EnumFacing side) {
            NBTTagCompound properties = new NBTTagCompound();
            properties.setBoolean("Is Keyblade Summoned", instance.getIsKeybladeSummoned());
            properties.setTag(InventoryKeychain.SAVE_KEY, instance.getInventoryKeychain().serializeNBT());

            return properties;
        }

        @Override
        public void readNBT(Capability<ISummonKeyblade> capability, ISummonKeyblade instance, EnumFacing side, NBTBase nbt) {
            NBTTagCompound properties = (NBTTagCompound) nbt;
            instance.setIsKeybladeSummoned(properties.getBoolean("Is Keyblade Summoned"));

            instance.getInventoryKeychain().deserializeNBT(properties.getCompoundTag(InventoryKeychain.SAVE_KEY));
        }
    }

    public static class Default implements ISummonKeyblade {
        private boolean keybladeSummoned = false;

        private final ItemStackHandler inventoryKeychain = new ItemStackHandler(InventoryKeychain.INV_SIZE);

        @Override public boolean getIsKeybladeSummoned() {return this.keybladeSummoned;}
        @Override public void setIsKeybladeSummoned(boolean summoned) {this.keybladeSummoned = summoned;}
        @Override public ItemStackHandler getInventoryKeychain(){return this.inventoryKeychain;}

    }
}



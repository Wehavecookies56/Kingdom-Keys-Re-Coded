package uk.co.wehavecookies56.kk.common.container.inventory;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class InventorySynthesisBagS implements ICapabilityProvider, INBTSerializable<NBTBase> {

    public static String name = Utils.translateToLocal(Strings.SynthesisBagSInventory);

    private static final String SAVE_KEY = "SynthesisBagSInventory";

    public static final int INV_SIZE = 14;

    ItemStackHandler inventory = new ItemStackHandler(INV_SIZE);

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.writeNBT(inventory, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.readNBT(inventory, null, nbt);
    }
}

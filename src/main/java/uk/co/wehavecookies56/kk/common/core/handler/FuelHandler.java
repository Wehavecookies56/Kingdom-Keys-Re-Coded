package uk.co.wehavecookies56.kk.common.core.handler;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import uk.co.wehavecookies56.kk.common.item.ModItems;

public class FuelHandler implements IFuelHandler {

    int burnTimeInSeconds = 120;
    int ticksPerSecond = 20;

    @Override
    public int getBurnTime (ItemStack fuel) {
        if (fuel.getItem() == ModItems.BlazingInfusedCoal) return burnTimeInSeconds * ticksPerSecond;
        return 0;
    }

}

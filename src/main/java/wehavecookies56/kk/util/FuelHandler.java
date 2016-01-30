package wehavecookies56.kk.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import wehavecookies56.kk.item.ModItems;

public class FuelHandler implements IFuelHandler {

	int burnTimeInSeconds = 120;
	int ticksPerSecond = 20;

	@Override
	public int getBurnTime (ItemStack fuel) {
		if (fuel.getItem() == ModItems.BlazingInfusedCoal) return burnTimeInSeconds * ticksPerSecond;
		return 0;
	}

}

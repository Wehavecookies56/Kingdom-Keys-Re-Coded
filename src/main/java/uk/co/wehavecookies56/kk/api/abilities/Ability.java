package uk.co.wehavecookies56.kk.api.abilities;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public abstract class Ability extends IForgeRegistryEntry.Impl<Ability> {

    public abstract int getAPCost();

    public abstract String getName();

}

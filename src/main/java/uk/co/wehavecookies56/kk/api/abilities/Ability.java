package uk.co.wehavecookies56.kk.api.abilities;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Ability extends IForgeRegistryEntry.Impl<Ability> {

    int apCost;
    String name;

    public Ability (int apCost, String name) {
        this.apCost = apCost;
        this.name = name;
    }

    public int getApCost() {
        return apCost;
    }

    public String getName() {
        return name;
    }
}

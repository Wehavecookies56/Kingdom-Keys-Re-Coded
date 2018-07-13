package uk.co.wehavecookies56.kk.api.abilities;

import net.minecraftforge.registries.IForgeRegistryEntry;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class Ability extends IForgeRegistryEntry.Impl<Ability> {

    int apCost;
    String name;

    public Ability (int apCost, String name) {
        this.apCost = apCost;
        this.name = name;
        setRegistryName(Reference.MODID+":"+name);
    }

    public int getApCost() {
        return apCost;
    }

    public String getName() {
        return name;
    }
}

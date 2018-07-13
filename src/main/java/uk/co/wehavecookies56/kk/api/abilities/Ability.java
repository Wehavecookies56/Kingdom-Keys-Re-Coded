package uk.co.wehavecookies56.kk.api.abilities;

import net.minecraftforge.registries.IForgeRegistryEntry;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class Ability extends IForgeRegistryEntry.Impl<Ability> {

    int apCost;
    String name;
    Category category;
    
    public Ability (int apCost, String name, Category cat) {
        this.apCost = apCost;
        this.name = name;
        this.category = cat;
        
        setRegistryName(Reference.MODID+":"+name);
    }

    public int getApCost() {
        return apCost;
    }

    public String getName() {
        return name;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public enum Category{
    	ACTION,
    	GROWTH,
    	SUPPORT,
    	WEAPONS
    }
}

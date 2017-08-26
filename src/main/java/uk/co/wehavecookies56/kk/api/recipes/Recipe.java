package uk.co.wehavecookies56.kk.api.recipes;

import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.api.materials.Material;

public abstract class Recipe {

    public abstract String getName ();

    public abstract ItemStack getResult ();

    public abstract Map<Material, Integer> getRequirements ();

    public boolean useRecipe (EntityPlayer player) {
        return true;
    }
}

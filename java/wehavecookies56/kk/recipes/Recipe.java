package wehavecookies56.kk.recipes;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

/**
 * Doesn't do anything yet
 */

public abstract class Recipe {
	
	public abstract String getName();
	
	public abstract Item getResult();
	
	public abstract List<String> getRequirements();
		
	public boolean useRecipe(EntityPlayer player){
		//TODO Remove Required Materials from Synthesis Table
		
		return true;
	}
}

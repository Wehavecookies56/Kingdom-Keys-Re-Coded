package wehavecookies56.kk.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Strings;

public class ItemPotion extends ItemFood{

	String potionType;
	
    public ItemPotion(int food, boolean wolf, String type) {
        super(food, wolf);       
        this.setUnlocalizedName(Strings.Potion);
        this.setAlwaysEdible();
        this.potionType = type;
    }
    
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.DRINK;
    }
    
    @Override
    public void onFoodEaten(ItemStack item, World world, EntityPlayer player)
    {
    	if(potionType == "hp")
    	{
    		player.heal(player.getMaxHealth()/3);
    	}
    	else if (potionType == "mp")
    	{
    		ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp()/3);
    	}
    	else if(potionType == "elixir")
    	{
    		ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp()/3);
    		player.heal(player.getMaxHealth()/3);
    	}
        if (!player.capabilities.isCreativeMode)
        {
        	player.inventory.addItemStackToInventory(new ItemStack(ModItems.EmptyBottle));
        }
    }
}
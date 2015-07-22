package wehavecookies56.kk.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.lib.Strings;

public class ItemPotion extends ItemFood{

    public ItemPotion(int food, boolean wolf) {
        super(food, wolf);       
        this.setUnlocalizedName(Strings.Potion);
        this.setAlwaysEdible();
    }
    
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.DRINK;
    }
    
    @Override
    public void onFoodEaten(ItemStack item, World world, EntityPlayer player)
    {
    	System.out.println("Eat");
		player.heal(16);
    	
        if (!player.capabilities.isCreativeMode)
        {
            //item.stackSize--;
        	player.inventory.addItemStackToInventory(new ItemStack(ModItems.EmptyBottle));
        }
    }
}
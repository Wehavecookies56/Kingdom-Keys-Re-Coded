package wehavecookies56.kk.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.inventory.InventoryPotionsMenu;
import wehavecookies56.kk.lib.Strings;

public class KKPotion extends ItemFood{

	String potionType;
	
    public KKPotion(int food, boolean wolf, String type) {
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
    	if(potionType == "hp2")
    	{
    		player.heal(player.getMaxHealth()*2/3);
    	}
    	else if (potionType == "mp2")
    	{
    		ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp()*2/3);
    	}
    	else if(potionType == "elixir2")
    	{
    		ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp()*2/3);
    		player.heal(player.getMaxHealth()*2/3);
    	}
    	else if(potionType == "hp3")
    	{
    		player.heal(player.getMaxHealth());
    	}
    	else if (potionType == "mp3")
    	{
    		ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp());
    	}
    	else if(potionType == "elixir3")
    	{
    		ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp());
    		player.heal(player.getMaxHealth());
    	}
        if (!player.capabilities.isCreativeMode)
        {
        	player.inventory.addItemStackToInventory(new ItemStack(ModItems.EmptyBottle));
        }
    }

	public static boolean usePotion(EntityPlayer player, InventoryPotionsMenu inventory, int slot)
	{
		if(inventory.getStackInSlot(slot).getItem() instanceof ItemPotion)
		{
			player.heal(player.getMaxHealth()/3);
			inventory.setInventorySlotContents(slot, null);
			return true;
		}
		else if (inventory.getStackInSlot(slot).getItem() instanceof ItemEther)
		{
			ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp()/3);
			inventory.setInventorySlotContents(slot, null);
			return true;
		}
		else if (inventory.getStackInSlot(slot).getItem() instanceof ItemElixir)
		{
			ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp()/3);
			player.heal(player.getMaxHealth()/3);
			inventory.setInventorySlotContents(slot, null);
			return true;
		}
		return false;
	}
}
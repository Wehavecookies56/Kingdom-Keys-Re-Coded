package wehavecookies56.kk.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Strings;

public class ItemElixir extends KKPotion{

	String potionType;
	
    public ItemElixir(int food, boolean wolf, String type) {
        super(food, wolf, type);       
        this.setUnlocalizedName(Strings.Potion);
        this.setAlwaysEdible();
        this.potionType = type;
    }
}
package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.api.menu.IItemCategory;
import uk.co.wehavecookies56.kk.api.menu.ItemCategory;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.GiveItemInSlot;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class ItemIceCream extends ItemFood implements IItemCategory{

    int win;

    public ItemIceCream (String name, int food, boolean wolf) {
        super(food, wolf);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(ModItems.tabKingdomKeys);
        setAlwaysEdible();

    }

    @Override
    public EnumAction getItemUseAction (ItemStack p_77661_1_) {
        return EnumAction.EAT;
    }

    @Override
    public void onFoodEaten (ItemStack item, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode && world.isRemote) {
            int slot;
            win = Utils.randomWithRange(0, 20);
            if (win == 6){
                if(player.inventory.hasItemStack(new ItemStack(ModItems.WinnerStick))){
                    PacketDispatcher.sendToServer(new GiveItemInSlot(new ItemStack(ModItems.WinnerStick), player.inventory.getSlotFor(new ItemStack(ModItems.WinnerStick)),true));
                }else{
                    PacketDispatcher.sendToServer(new GiveItemInSlot(new ItemStack(ModItems.WinnerStick), player.inventory.getFirstEmptyStack(), false));
                }
            }else{
                if(player.inventory.hasItemStack(new ItemStack(Items.STICK)))
                {
                    PacketDispatcher.sendToServer(new GiveItemInSlot(new ItemStack(Items.STICK), player.inventory.getSlotFor(new ItemStack(ModItems.WinnerStick)),true));
                }else{
                    PacketDispatcher.sendToServer(new GiveItemInSlot(new ItemStack(Items.STICK), player.inventory.getFirstEmptyStack(), false));
                }
            }
        }
    }

	@Override
	public ItemCategory getCategory() {
		return ItemCategory.CONSUMABLE;
	}
}
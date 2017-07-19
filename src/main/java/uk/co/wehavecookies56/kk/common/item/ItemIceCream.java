package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.GiveItemInSlot;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class ItemIceCream extends ItemFood {

    int win;

    public ItemIceCream (int food, boolean wolf) {
        super(food, wolf);
        setUnlocalizedName(Strings.Potion);
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
}
package wehavecookies56.kk.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.inventory.InventoryPotionsMenu;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.AntiPoints;
import wehavecookies56.kk.network.packet.server.ChangeHP;
import wehavecookies56.kk.network.packet.server.ChangeMP;
import wehavecookies56.kk.network.packet.server.DriveFormPacket;
import wehavecookies56.kk.network.packet.server.RemoveItemInSlot;
import wehavecookies56.kk.util.SoundHelper;

public class ItemKKPotion extends ItemFood{

	String potionType, unlocalizedName;
	
    public ItemKKPotion(int food, boolean wolf, String type, String unlocalizedName) {
        super(food, wolf);       
        this.setUnlocalizedName(Strings.Potion);
        this.setAlwaysEdible();
        this.potionType = type;
    }
    
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.DRINK;
    }
    
    public String getItemName() {
		return unlocalizedName;
	}

	public void setItemName(String unlocalizedName) {
		this.unlocalizedName = unlocalizedName;
	}	
    
    public static void getItem(EntityPlayer player, World world, String item){		
		switch(item){
		case "potion":
			PacketDispatcher.sendToServer(new ChangeHP(player.getMaxHealth()/3,"+"));
			Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Potion, 1f, 1f, false);

			break;
		case "ether":
			PacketDispatcher.sendToServer(new ChangeMP(ExtendedPlayer.get(player).getMaxMp()/3,"+"));
			Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Potion, 1f, 1f, false);

			break;
		case "elixir":
			PacketDispatcher.sendToServer(new ChangeMP(ExtendedPlayer.get(player).getMaxMp()/3,"+"));
			PacketDispatcher.sendToServer(new ChangeHP(player.getMaxHealth()/3,"+"));
			Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Potion, 1f, 1f, false);

			break;
		default:
			break;
		}
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

	public static void usePotion(EntityPlayer player, InventoryPotionsMenu inventory, int slot)
	{
		if(inventory.getStackInSlot(slot).getItem() instanceof ItemPotion)
		{
			PacketDispatcher.sendToServer(new ChangeHP(player.getMaxHealth()/3,"+"));
			inventory.setInventorySlotContents(slot, null);
		}
		else if (inventory.getStackInSlot(slot).getItem() instanceof ItemEther)
		{
			PacketDispatcher.sendToServer(new ChangeMP(ExtendedPlayer.get(player).getMaxMp()/3,"+"));
			inventory.setInventorySlotContents(slot, null);
		}
		else if (inventory.getStackInSlot(slot).getItem() instanceof ItemElixir)
		{
			PacketDispatcher.sendToServer(new ChangeMP(ExtendedPlayer.get(player).getMaxMp()/3,"+"));
			PacketDispatcher.sendToServer(new ChangeHP(player.getMaxHealth()/3,"+"));
			inventory.setInventorySlotContents(slot, null);
		}
		Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Potion, 1f, 1f, false);
		PacketDispatcher.sendToServer(new RemoveItemInSlot("potion", slot, true));	
	}
}
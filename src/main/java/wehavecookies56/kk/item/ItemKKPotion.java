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
import wehavecookies56.kk.network.packet.server.RemoveItemInSlot;
import wehavecookies56.kk.util.SoundHelper;

public abstract class ItemKKPotion extends ItemFood {

	String potionType, unlocalizedName;

	public ItemKKPotion (int food, boolean wolf, String type, String unlocalizedName) {
		super(food, wolf);
		setUnlocalizedName(Strings.Potion);
		setAlwaysEdible();
		this.potionType = type;
		this.unlocalizedName = unlocalizedName;
	}

	@Override
	public EnumAction getItemUseAction (ItemStack item) {
		return EnumAction.DRINK;
	}

	public String getItemName () {
		return unlocalizedName;
	}

	public void setItemName (String unlocalizedName) {
		this.unlocalizedName = unlocalizedName;
	}

	public static void getItem (EntityPlayer player, World world, String item, int slot) {
		while (ExtendedPlayer.get(player).inventoryPotions.getStackInSlot(slot) == null) {
			slot++;
		}
		switch (item) {
			case "potion":
				((ItemKKPotion) ModItems.Potion).getPotionEffect(player);
				Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Potion, 1f, 1f, false);
				ExtendedPlayer.get(player).inventoryPotions.setInventorySlotContents(slot, null);
				PacketDispatcher.sendToServer(new RemoveItemInSlot("potion", slot, true));
				break;
			case "ether":
				((ItemKKPotion) ModItems.Ether).getPotionEffect(player);
				Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Potion, 1f, 1f, false);
				ExtendedPlayer.get(player).inventoryPotions.setInventorySlotContents(slot, null);
				PacketDispatcher.sendToServer(new RemoveItemInSlot("potion", slot, true));
				break;
			case "elixir":
				((ItemKKPotion) ModItems.Elixir).getPotionEffect(player);
				Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Potion, 1f, 1f, false);
				ExtendedPlayer.get(player).inventoryPotions.setInventorySlotContents(slot, null);
				PacketDispatcher.sendToServer(new RemoveItemInSlot("potion", slot, true));
				break;
			default:
				break;
		}
	}

	@Override
	public void onFoodEaten (ItemStack item, World world, EntityPlayer player) {
		potionEffect(player);

		/*
		 * if (potionType == "hp") player.heal(player.getMaxHealth() / 3); else
		 * if (potionType == "mp")
		 * ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp(
		 * ) / 3); else if (potionType == "elixir") {
		 * ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp(
		 * ) / 3); player.heal(player.getMaxHealth() / 3); }
		 * 
		 * if (potionType == "hp2") player.heal(player.getMaxHealth() * 2 / 3);
		 * else if (potionType == "mp2")
		 * ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp(
		 * ) * 2 / 3); else if (potionType == "elixir2") {
		 * ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp(
		 * ) * 2 / 3); player.heal(player.getMaxHealth() * 2 / 3); } else if
		 * (potionType == "hp3") player.heal(player.getMaxHealth()); else if
		 * (potionType == "mp3")
		 * ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp(
		 * )); else if (potionType == "elixir3") {
		 * ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp(
		 * )); player.heal(player.getMaxHealth()); }
		 */
		if (!player.capabilities.isCreativeMode) player.inventory.addItemStackToInventory(new ItemStack(ModItems.EmptyBottle));
	}

	/**
	 * Set what the potion does when used e.g. Healing, MP restore, etc.
	 *
	 * @return
	 */
	public abstract void potionEffect (EntityPlayer player);

	public void getPotionEffect (EntityPlayer player) {
		potionEffect(player);
	}

	public void usePotion (EntityPlayer player, InventoryPotionsMenu inventory, int slot) {
		if (inventory.getStackInSlot(slot) != null) if (inventory.getStackInSlot(slot).getItem() instanceof ItemKKPotion) {
			inventory.setInventorySlotContents(slot, null);
			Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Potion, 1f, 1f, false);
			PacketDispatcher.sendToServer(new RemoveItemInSlot("potion", slot, true));
		}
	}
}
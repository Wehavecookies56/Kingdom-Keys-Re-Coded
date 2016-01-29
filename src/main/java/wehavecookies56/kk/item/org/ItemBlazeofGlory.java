package wehavecookies56.kk.item.org;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wehavecookies56.kk.entities.projectiles.EntityEternalFlames;

public class ItemBlazeofGlory extends ItemSword {
	int strength;

	public ItemBlazeofGlory (ToolMaterial material) {
		super(material);
		setMaxStackSize(1);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public EnumRarity getRarity (ItemStack par1ItemStack) {
		return EnumRarity.UNCOMMON;
	}

	@Override
	public void onPlayerStoppedUsing (ItemStack stack, World world, EntityPlayer player, int timeLeft) {
		this.strength = timeLeft;
		if (!player.isSneaking()) {
			// TODO set strength

			world.playSoundAtEntity(player, "mob.ghast.fireball", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			world.spawnEntityInWorld(new EntityEternalFlames(world, player, -(strength) + 71999));
			player.swingItem();
		} else
			player.setItemInUse(stack, getMaxItemUseDuration(stack));
	}

	@Override
	public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player) {
		player.setItemInUse(stack, getMaxItemUseDuration(stack));
		return stack;
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void addInformation (ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("VIII Axel");
	}
}

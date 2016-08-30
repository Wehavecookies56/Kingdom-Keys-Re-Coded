package uk.co.wehavecookies56.kk.common.item.org;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntitySharpshooterBullet;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;

public class ItemSharpshooter extends ItemOrgWeapon {

	public ItemSharpshooter (ToolMaterial material) {
		super(material);
		setMaxStackSize(1);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public EnumRarity getRarity (ItemStack par1ItemStack) {
		return EnumRarity.UNCOMMON;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		if (!player.isSneaking()) {
			if (player.getCapability(ModCapabilities.PLAYER_STATS, null).getMP() > 0 && !player.getCapability(ModCapabilities.PLAYER_STATS, null).getRecharge() || player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) {
				world.playSound(player.posX, player.posY, player.posZ, ModSounds.sharpshooterbullet, SoundCategory.PLAYERS, 0.5F, 1F / (itemRand.nextFloat() * 0.4F + 0.8F), false);
				EntitySharpshooterBullet bullet = new EntitySharpshooterBullet(world,player);
				world.spawnEntityInWorld(bullet);
				bullet.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 3f, 0);
				if (!player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) 
					player.getCapability(ModCapabilities.PLAYER_STATS, null).remMP(7);
				player.swingArm(EnumHand.MAIN_HAND);
			}
		} else {
			//player.setItemInUse(stack, getMaxItemUseDuration(stack));
		}
		return super.onItemRightClick(stack, world, player, hand);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void addInformation (ItemStack itemStack, EntityPlayer player, List<String> dataList, boolean bool) {
		dataList.add("II Xigbar");
	}
}

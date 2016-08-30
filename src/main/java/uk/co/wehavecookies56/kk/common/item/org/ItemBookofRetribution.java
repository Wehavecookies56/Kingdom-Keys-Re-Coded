package uk.co.wehavecookies56.kk.common.item.org;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.world.dimension.ModDimensions;
import uk.co.wehavecookies56.kk.common.world.dimension.TeleporterDiveToTheHeart;

public class ItemBookofRetribution extends ItemOrgWeapon {

	public ItemBookofRetribution (ToolMaterial material) {
		super(material);
		setMaxStackSize(1);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public EnumRarity getRarity (ItemStack par1ItemStack) {
		return EnumRarity.UNCOMMON;
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void addInformation (ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("VI Zexion");
	}

	/*
	TEMP WAY TO TRAVEL TO DIMENSION
	 */
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if (hand.equals(EnumHand.MAIN_HAND)){
			if (playerIn.dimension != ModDimensions.diveToTheHeartID)
				if (!worldIn.isRemote)
					new TeleporterDiveToTheHeart(worldIn.getMinecraftServer().getServer().worldServerForDimension(ModDimensions.diveToTheHeartID)).teleport(playerIn, worldIn);
		}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}
}

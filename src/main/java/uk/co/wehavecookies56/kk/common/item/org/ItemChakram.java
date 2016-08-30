package uk.co.wehavecookies56.kk.common.item.org;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;

public class ItemChakram extends ItemOrgWeapon {

	public ItemChakram(ToolMaterial material) {
		super(material);
		setMaxStackSize(1);
		setCreativeTab(ModItems.tabKingdomKeys);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public EnumRarity getRarity (ItemStack par1ItemStack) {
		return EnumRarity.UNCOMMON;
	}

	@Override
	public boolean hitEntity (ItemStack item, EntityLivingBase entity, EntityLivingBase p_77644_3_) {
		entity.setFire(5);
		return super.hitEntity(item, entity, p_77644_3_);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void addInformation (ItemStack itemStack, EntityPlayer player, List<String> dataList, boolean bool) {
		dataList.add("VIII Axel");
	}

}

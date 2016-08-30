package uk.co.wehavecookies56.kk.common.item.base;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemOrgWeapon extends ItemSword{

	public ItemOrgWeapon(ToolMaterial material) {
		super(material);
		setMaxStackSize(1);
	}
	
	@Override
	@SideOnly (Side.CLIENT)
	public EnumRarity getRarity (ItemStack par1ItemStack) {
		return EnumRarity.UNCOMMON;
	}
	
	/*@Override
	@SideOnly (Side.CLIENT)
	public void addInformation (ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) 
	{
	}*/

}

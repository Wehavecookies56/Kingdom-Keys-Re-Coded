package uk.co.wehavecookies56.kk.common.item.org;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.client.gui.GuiOrg;
import uk.co.wehavecookies56.kk.client.gui.GuiOrgWeapon;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;

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

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		if (worldIn.isRemote) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiOrgWeapon());
		}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
	}
}

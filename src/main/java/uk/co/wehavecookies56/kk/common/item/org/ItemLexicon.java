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
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.util.Utils.OrgMember;

public class ItemLexicon extends ItemOrgWeapon implements IOrgWeapon{

	public ItemLexicon (double strength, double magic)  {
		super(strength,magic);
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
	public OrgMember getMember() {
		return Utils.OrgMember.ZEXION;
	}
}

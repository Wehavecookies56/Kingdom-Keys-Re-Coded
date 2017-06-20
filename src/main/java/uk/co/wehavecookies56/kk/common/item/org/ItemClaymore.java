package uk.co.wehavecookies56.kk.common.item.org;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.DesummonClaymore;
import uk.co.wehavecookies56.kk.common.network.packet.server.SummonClaymore;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.util.Utils.OrgMember;

public class ItemClaymore extends ItemOrgWeapon implements IOrgWeapon{

	public ItemClaymore (double strength, double magic)  {
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
		dataList.add(Utils.translateToLocal(Strings.LunaticDesc));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if(player.getActiveItemStack().getItemDamage()==0){
			if(world.isRemote){
				PacketDispatcher.sendToServer(new SummonClaymore((ItemClaymore) player.getActiveItemStack().getItem()));
			}else{
				player.getActiveItemStack().setItemDamage(1);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, player.getActiveItemStack());
				player.world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.summon, SoundCategory.MASTER, 1.0f, 1.0f);
			}
		}else{
			if(world.isRemote){
				PacketDispatcher.sendToServer(new DesummonClaymore((ItemClaymore) player.getActiveItemStack().getItem()));
			}else{
				player.getActiveItemStack().setItemDamage(0);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, player.getActiveItemStack());
				player.world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.unsummon, SoundCategory.MASTER, 1.0f, 1.0f);
			}
		}
		return super.onItemRightClick(world, player, hand);
	}

	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
		super.getSubItems(itemIn, tab, subItems);
		subItems.add(new ItemStack(itemIn, 1, 1));
	}

	@Override
	public OrgMember getMember() {
		return Utils.OrgMember.SAIX;
	}
}

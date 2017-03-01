package uk.co.wehavecookies56.kk.common.item.org;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.entity.projectiles.*;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.util.Utils.OrgMember;

public class ItemChakram extends ItemOrgWeapon implements IOrgWeapon{
	String weapon;
	public ItemChakram (double strength, double magic, String weapon)  {
		super(strength,magic);
		this.weapon=weapon;
		setMaxStackSize(1);
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
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {
		Entity entity;
		switch(weapon){
			case Strings.Ashes:
				entity = new EntityAshes(world, player);
				break;
			case Strings.BlazeofGlory:
				entity = new EntityBlazeofGlory(world, player);
				break;
			case Strings.EternalFlames:
				entity = new EntityEternalFlames(world, player);
				break;
			case Strings.Ifrit:
				entity = new EntityIfrit(world, player);
				break;
			case Strings.Prometheus:
				entity = new EntityPrometheus(world, player);
				break;
			case Strings.Prominence:
				entity = new EntityProminence(world, player);
				break;
			case Strings.MoulinRouge:
				entity = new EntityMoulinRouge(world, player);
				break;
			default:
				entity = new EntityEternalFlames(world, player);
				break;
		}

		if(!player.getCapability(ModCapabilities.PLAYER_STATS, null).getRecharge())
		{
			if (!player.isSneaking()) {
				world.playSound(player.posX, player.posY, player.posZ, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F), false);
				world.spawnEntity(entity);
				((EntityThrowable) entity).setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1f, 1);
				if (!player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) 
					player.getCapability(ModCapabilities.PLAYER_STATS, null).remMP(7);
				player.swingArm(hand);
			}
			return ActionResult.newResult(EnumActionResult.SUCCESS, itemStack);
		}
		return ActionResult.newResult(EnumActionResult.FAIL, itemStack);
	}

	@Override
	public OrgMember getMember() {
		return Utils.OrgMember.AXEL;
	}
	
}

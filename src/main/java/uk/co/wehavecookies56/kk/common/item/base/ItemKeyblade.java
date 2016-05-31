package uk.co.wehavecookies56.kk.common.item.base;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockDoor.EnumDoorHalf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.AttackEntity;

public class ItemKeyblade extends ItemSword {
	int magic, strength;
	public String description;

	//TODO Set attack speed

	public ItemKeyblade (int strength, int magic) {
		super(EnumHelper.addToolMaterial("KEYBLADE", -4, -1, 0, 0, 20));
		this.magic = magic;
		this.strength = strength;
		setMaxStackSize(1);
		setCreativeTab(ModItems.tabKingdomKeys);
	}
	public int getStrength() {
		return this.strength;
	}
	
	public int getMagic() {
		return this.magic;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setMagic(int magic) {
		this.magic = magic;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player, EnumHand hand) {
		if(player.isSneaking()) {
			
		} else {
			if (worldIn.isRemote){
				RayTraceResult rtr = Minecraft.getMinecraft().objectMouseOver;
				if (player.getHeldItem(EnumHand.OFF_HAND) != null && player.getHeldItem(EnumHand.OFF_HAND).getItem() instanceof ItemKeyblade) {
					if(player.swingProgress <= 0)
						player.swingArm(EnumHand.OFF_HAND);
					if (rtr.entityHit != null) {
						PacketDispatcher.sendToServer(new AttackEntity(rtr.entityHit.getEntityId()));
						return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
					}
					return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemStackIn);
				}
				
			}
		}
		return super.onItemRightClick(itemStackIn, worldIn, player, hand);
	}

	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (stack.getItem() == ModItems.WoodenKeyblade || stack.getItem() == ModItems.WoodenStick || stack.getItem() == ModItems.DreamSword)
			return super.onItemUse(stack, player, world, pos, hand, facing, hitX, hitY, hitZ);

		if (world.getBlockState(pos).getBlock() instanceof BlockDoor) {
			SoundEvent sound;
			PlayerStatsCapability.IPlayerStats STATS = player.getCapability(ModCapabilities.PLAYER_STATS, null);
			if ((!STATS.getRecharge()) || player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) {
				if (!player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) STATS.remMP(30);

				if (world.getBlockState(pos).getValue(BlockDoor.HALF) == EnumDoorHalf.UPPER) {
					world.setBlockState(pos.down(), world.getBlockState(pos.down()).withProperty(BlockDoor.OPEN, !world.getBlockState(pos.down()).getValue(BlockDoor.OPEN)));
					sound = world.getBlockState(pos.down()).getValue(BlockDoor.OPEN) ? SoundEvents.BLOCK_IRON_DOOR_CLOSE : SoundEvents.BLOCK_IRON_DOOR_OPEN;
					world.playSound(player, pos, sound, SoundCategory.BLOCKS, 1.0f, 1.0f);
					return EnumActionResult.SUCCESS;
				} else {
					world.setBlockState(pos, world.getBlockState(pos).withProperty(BlockDoor.OPEN, !world.getBlockState(pos).getValue(BlockDoor.OPEN)));
					sound = world.getBlockState(pos).getValue(BlockDoor.OPEN) ? SoundEvents.BLOCK_IRON_DOOR_CLOSE : SoundEvents.BLOCK_IRON_DOOR_OPEN;
					world.playSound(player, pos, sound, SoundCategory.BLOCKS, 1.0f, 1.0f);
					return EnumActionResult.SUCCESS;
				}
			}
		}
		return super.onItemUse(stack, player, world, pos, hand, facing, hitX, hitY, hitZ);
	}
	
}

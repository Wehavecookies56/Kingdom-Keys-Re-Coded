package wehavecookies56.kk.item;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockDoor.EnumDoorHalf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import wehavecookies56.kk.entities.ExtendedPlayer;

public class ItemKeyblade extends ItemSword {

	public ItemKeyblade (ToolMaterial material) {
		super(material);
		setMaxStackSize(1);
	}

	@Override
	public boolean onItemUse (ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (stack.getItem() == ModItems.WoodenKeyblade || stack.getItem() == ModItems.WoodenStick || stack.getItem() == ModItems.DreamSword) return false;

		if (world.getBlockState(pos).getBlock() instanceof BlockDoor) {
			String sound;
			if ((!ExtendedPlayer.get(player).inRecharge) || ExtendedPlayer.get(player).cheatMode) {
				if (!ExtendedPlayer.get(player).cheatMode) ExtendedPlayer.get(player).removeMp(30);

				if (world.getBlockState(pos).getValue(BlockDoor.HALF) == EnumDoorHalf.UPPER) {
					world.setBlockState(pos.down(), world.getBlockState(pos.down()).withProperty(BlockDoor.OPEN, !world.getBlockState(pos.down()).getValue(BlockDoor.OPEN)));
					sound = world.getBlockState(pos.down()).getValue(BlockDoor.OPEN) ? "random.door_close" : "random.door_open";
					world.playSoundAtEntity(player, sound, 1.0f, 1.0f);
					return true;
				} else {
					world.setBlockState(pos, world.getBlockState(pos).withProperty(BlockDoor.OPEN, !world.getBlockState(pos).getValue(BlockDoor.OPEN)));
					sound = world.getBlockState(pos).getValue(BlockDoor.OPEN) ? "random.door_close" : "random.door_open";
					world.playSoundAtEntity(player, sound, 1.0f, 1.0f);
					return true;
				}
			}
		}
		return false;
	}
}

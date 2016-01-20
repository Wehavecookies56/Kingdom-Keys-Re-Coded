package wehavecookies56.kk.item;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockDoor.EnumDoorHalf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

public class ItemKeyblade extends ItemSword {

	public ItemKeyblade(ToolMaterial material) {
		super(material);
		this.setMaxStackSize(1);
	}
	
	@Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote){
			if(world.getBlockState(pos).getBlock() instanceof BlockDoor)
			{
				String sound = "";
				if(world.getBlockState(pos).getValue(BlockDoor.HALF) == EnumDoorHalf.UPPER){
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
		return true;
	}
}

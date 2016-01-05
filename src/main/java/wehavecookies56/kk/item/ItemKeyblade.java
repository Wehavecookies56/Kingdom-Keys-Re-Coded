package wehavecookies56.kk.item;

import net.minecraft.block.BlockDoor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKeyblade extends ItemSword {

	public ItemKeyblade(ToolMaterial material) {
		super(material);
		this.setMaxStackSize(1);
	}
	
	@Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(world.getBlockState(pos).getBlock() instanceof BlockDoor)
		{
			System.out.println("xDD");
		}
		else
		{
			System.out.println(pos.getX()+", "+pos.getY()+", "+pos.getZ());
			System.out.println(world.getBlockState(pos).getBlock());

		}
		return true;
	}
}

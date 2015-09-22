package wehavecookies56.kk.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import wehavecookies56.kk.entities.TileEntityKKChest;

public class GuiHandler implements IGuiHandler {

	private static final int GUIID_KKChest = 30;
	public static int getGuiID() 
	{
		return GUIID_KKChest;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileEntityKKChest) {
			TileEntityKKChest tileEntityInventoryBasic = (TileEntityKKChest) tileEntity;
			return new ContainerKKChest(player.inventory, tileEntityInventoryBasic);
		}
		return null;
	}


	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == 0) {
            return new GuiReports();
        }
		if(ID == GUIID_KKChest)
		{
			BlockPos xyz = new BlockPos(x, y, z);
			TileEntity tileEntity = world.getTileEntity(xyz);
			if (tileEntity instanceof TileEntityKKChest) {
				TileEntityKKChest tileEntityInventoryBasic = (TileEntityKKChest) tileEntity;
				return new GuiKKChest(player.inventory, tileEntityInventoryBasic);
			}
		}
        return null;
    }
}

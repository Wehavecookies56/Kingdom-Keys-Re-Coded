package wehavecookies56.kk.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wehavecookies56.kk.client.gui.GuiSynthesis;
import wehavecookies56.kk.entities.ExtendedPlayerRecipes;
import wehavecookies56.kk.entities.TileEntitySynthesisTable;
import wehavecookies56.kk.item.ItemSynthesisMaterial;

public class BlockSynthesisTable extends Block implements ITileEntityProvider {

	protected BlockSynthesisTable(Material material, String toolClass, int level, float hardness, float resistance) {
		super(material);
		this.setHarvestLevel(toolClass, level);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		Minecraft.getMinecraft().displayGuiScreen(new GuiSynthesis(null));
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntitySynthesisTable();
	}

}

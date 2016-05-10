package uk.co.wehavecookies56.kk.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntitySynthesisTable;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMaterialData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncRecipeData;

public class BlockSynthesisTable extends Block implements ITileEntityProvider {

	protected BlockSynthesisTable (Material material, String toolClass, int level, float hardness, float resistance) {
		super(material);
		this.setHarvestLevel(toolClass, level);
		setHardness(hardness);
		setResistance(resistance);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, ModSounds.kupo, SoundCategory.MASTER, 0.5F, 1.0F);
		playerIn.openGui(KingdomKeys.instance, GuiIDs.GUI_SYNTHESISTABLE, worldIn, pos.getX(), pos.getY(), pos.getZ());
		if (!worldIn.isRemote){
			PacketDispatcher.sendTo(new SyncRecipeData(playerIn.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null)), (EntityPlayerMP) playerIn);
			PacketDispatcher.sendTo(new SyncMaterialData(playerIn.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null)), (EntityPlayerMP) playerIn);
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity (World worldIn, int meta) {
		return new TileEntitySynthesisTable();
	}

}
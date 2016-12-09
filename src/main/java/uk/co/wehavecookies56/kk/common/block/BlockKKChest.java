package uk.co.wehavecookies56.kk.common.block;

import java.util.Random;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityKKChest;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;

public class BlockKKChest extends Block implements ITileEntityProvider {
	protected Random rand = new Random();

	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	public BlockKKChest (Material material, String toolClass, int level, float hardness, float resistance) {
		super(material);
		this.setHarvestLevel(toolClass, level);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		setHardness(hardness);
		setResistance(resistance);
		setSoundType(SoundType.STONE);
	}

	@Override
	public TileEntity createNewTileEntity (World worldIn, int meta) {
		return new TileEntityKKChest();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			if (player.getHeldItem(EnumHand.MAIN_HAND) != null && player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemKeyblade)
				if (player.getHeldItem(EnumHand.MAIN_HAND).getItem() != ModItems.WoodenKeyblade && player.getHeldItem(EnumHand.MAIN_HAND).getItem() != ModItems.WoodenStick && player.getHeldItem(EnumHand.MAIN_HAND).getItem() != ModItems.DreamSword) {
					if (world.getTileEntity(pos) instanceof TileEntityKKChest) {
						TileEntityKKChest te = (TileEntityKKChest) world.getTileEntity(pos);
						if (te.getKeyblade() == null) {
							te.setKeyblade(player.getHeldItemMainhand());
							te.markDirty();

							player.sendMessage(new TextComponentString(TextFormatting.GREEN + "Set " + heldItem.getDisplayName() + " as the keyblade to unlock the chest"));

							player.openGui(KingdomKeys.instance, GuiIDs.GUI_KKCHEST_INV, world, pos.getX(), pos.getY(), pos.getZ());
							return true;
						} else if (te.getKeyblade().getItem() != null && te.getKeyblade().getItem() == player.getHeldItemMainhand().getItem()) {
							player.openGui(KingdomKeys.instance, GuiIDs.GUI_KKCHEST_INV, world, pos.getX(), pos.getY(), pos.getZ());
							return true;
						} else if (hand == EnumHand.MAIN_HAND) {
							player.sendMessage(new TextComponentString(TextFormatting.RED + "The chest is locked with another keyblade"));
							return false;
						} else {
							return false;
						}
					}
				}
		}
		return false;
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		setDefaultFacing(worldIn, pos, state);
	}

	private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			IBlockState iblockstate = worldIn.getBlockState(pos.north());
			IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
			IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
			IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
			EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

			if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock()) {
				enumfacing = EnumFacing.SOUTH;
			}
			else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock()) {
				enumfacing = EnumFacing.NORTH;
			}
			else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock()) {
				enumfacing = EnumFacing.EAST;
			}
			else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock()) {
				enumfacing = EnumFacing.WEST;
			}

			worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
		}
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}

    @SideOnly(Side.CLIENT)
	public IBlockState getStateForEntityRender(IBlockState state) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
	}
    
    
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer (this, new IProperty[] {FACING});
    }

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}

	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getFront(meta);
		if (enumfacing.getAxis() == EnumFacing.Axis.Y) enumfacing = EnumFacing.NORTH;
		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	public void breakBlock (World worldIn, BlockPos pos, IBlockState state) {

		IInventory inventory = worldIn.getTileEntity(pos) instanceof IInventory ? (IInventory) worldIn.getTileEntity(pos) : null;

		if (inventory != null) {
			for (int i = 0; i < inventory.getSizeInventory(); i++)
				if (inventory.getStackInSlot(i) != null) {
					EntityItem item = new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory.getStackInSlot(i));

					float multiplier = 0.1f;
					float motionX = worldIn.rand.nextFloat() - 0.5f;
					float motionY = worldIn.rand.nextFloat() - 0.5f;
					float motionZ = worldIn.rand.nextFloat() - 0.5f;

					item.motionX = motionX * multiplier;
					item.motionY = motionY * multiplier;
					item.motionZ = motionZ * multiplier;

					worldIn.spawnEntity(item);
				}
			inventory.clear();
		}
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public BlockRenderLayer getBlockLayer () {
		return BlockRenderLayer.SOLID;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean isOpaqueCube (IBlockState state) {
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean isFullCube (IBlockState state) {
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
		
}

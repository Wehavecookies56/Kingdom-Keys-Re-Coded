package uk.co.wehavecookies56.kk.common.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
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
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
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

public class BlockKKChest extends BlockContainer implements ITileEntityProvider {
	protected Random rand = new Random();

	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	protected BlockKKChest (Material material, String toolClass, int level, float hardness, float resistance) {
		super(material);
		this.setHarvestLevel(toolClass, level);
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

							player.addChatComponentMessage(new TextComponentString(TextFormatting.GREEN + "Set " + heldItem.getDisplayName() + " as the keyblade to unlock the chest"));

							player.openGui(KingdomKeys.instance, GuiIDs.GUI_KKCHEST_INV, world, pos.getX(), pos.getY(), pos.getZ());
							return true;
						} else if (te.getKeyblade().getItem() != null && te.getKeyblade().getItem() == player.getHeldItemMainhand().getItem()) {
							player.openGui(KingdomKeys.instance, GuiIDs.GUI_KKCHEST_INV, world, pos.getX(), pos.getY(), pos.getZ());
							return true;
						} else if (hand == EnumHand.MAIN_HAND){
							player.addChatComponentMessage(new TextComponentString(TextFormatting.RED + "The chest is locked with another keyblade"));
							return false;
						} else {
							return false;
						}
					}
				}
		}
		return false;
	}

	public static EnumFacing getFacingFromEntity(World worldIn, BlockPos clickedBlock, EntityLivingBase entityIn) {
		return entityIn.getHorizontalFacing().getOpposite();
	} 
	
	@Override
	public void onBlockPlacedBy (World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, getFacingFromEntity(worldIn, pos, placer)), 2);
	}
	
	@Override
	public IBlockState onBlockPlaced (World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, getFacingFromEntity(worldIn, pos, placer));
	}
	
    
    @SideOnly(Side.CLIENT)
	public IBlockState getStateForEntityRender(IBlockState state) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
	}
    
    
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer (this, new IProperty[] {FACING});
    }
    
    public int getMetaFromState(IBlockState state) {
		return ((EnumFacing)state.getValue(FACING)).getIndex();
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

					worldIn.spawnEntityInWorld(item);
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
	public boolean isVisuallyOpaque () {
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
		
}

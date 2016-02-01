package wehavecookies56.kk.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wehavecookies56.kk.entities.TileEntityKKChest;
import wehavecookies56.kk.item.ItemKeyblade;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.util.GuiHelper;

public class BlockKKChest extends BlockContainer implements ITileEntityProvider {
	protected Random rand = new Random();

	public static final PropertyDirection FACING = PropertyDirection.create("facing");

	protected BlockKKChest (Material material, String toolClass, int level, float hardness, float resistance) {
		super(material);
		this.setHarvestLevel(toolClass, level);
		setHardness(hardness);
		setResistance(resistance);
	}

	@Override
	public TileEntity createNewTileEntity (World worldIn, int meta) {
		return new TileEntityKKChest();
	}

	@Override
	public boolean onBlockActivated (World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (world.isRemote) return true;
		if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemKeyblade) if (player.getHeldItem().getItem() != ModItems.WoodenKeyblade && player.getHeldItem().getItem() != ModItems.WoodenStick && player.getHeldItem().getItem() != ModItems.DreamSword) {
			GuiHelper.openKKChest(player, world, pos);
			return true;
		}
		return false;
	}

	public static EnumFacing getFacingFromEntity(World worldIn, BlockPos clickedBlock, EntityLivingBase entityIn) {
		return entityIn.getHorizontalFacing().getOpposite();
	} 
	
	@Override
	public void onBlockPlacedBy (World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, getFacingFromEntity(worldIn, pos, placer)), 2);
		System.out.println(getFacingFromEntity(worldIn, pos, placer));
	}
	
	@Override
	public IBlockState onBlockPlaced (World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, getFacingFromEntity(worldIn, pos, placer));
	}
	
    
    @SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
    }
    
    
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] {FACING});
    }
    
    public int getMetaFromState(IBlockState state) {
        byte b0 = 0;
        int i = b0 | ((EnumFacing)state.getValue(FACING)).getIndex();

        return i;
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
	public EnumWorldBlockLayer getBlockLayer () {
		return EnumWorldBlockLayer.SOLID;
	}

	@Override
	public boolean isOpaqueCube () {
		return false;
	}

	@Override
	public boolean isFullCube () {
		return false;
	}

	@Override
	public boolean isVisuallyOpaque () {
		return false;
	}

	@Override
	public int getRenderType () {
		return 3;
	}
}

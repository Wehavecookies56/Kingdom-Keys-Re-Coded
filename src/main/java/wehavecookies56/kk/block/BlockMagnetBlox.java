package wehavecookies56.kk.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMagnetBlox extends BlockBlox {
	

	protected BlockMagnetBlox(Material material, String toolClass, int level,
			float hardness, float resistance) {
		super(material, toolClass, level, hardness, resistance);

	}
	public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
   
	@Override
	public int getMetaFromState(IBlockState state)
	{
    	EnumFacing facing = (EnumFacing)state.getValue(PROPERTYFACING);
	    int facingbits = facing.getHorizontalIndex();
	    return facingbits;
	}
    
    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
      return state;
    }
    
    @Override
    protected BlockState createBlockState()
    {
      return new BlockState(this, new IProperty[] {PROPERTYFACING});
    }
    
    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
      // find the quadrant the player is facing
      EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);
      System.out.println(enumfacing);

      return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing);
    }
}

package wehavecookies56.kk.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SpawnCureParticles;
import wehavecookies56.kk.util.TextHelper;

public class BlockSavePoint extends Block {

	protected BlockSavePoint(Material material, String toolClass, int level, float hardness, float resistance) {
		super(material);
        this.setBlockBounds(0, 0, 0, 1, 0.1F, 1);
        this.setTickRandomly(true);
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, this.tickRate(world));
		super.onBlockAdded(world, pos, state);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entity) {
		if (!world.isRemote){
			this.updateState(world, pos);
	    }
	}

	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random) {}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		if (!world.isRemote){
			this.updateState(world, pos);
	    }
	}

	private void updateState(World world, BlockPos pos){
		List list = world.getEntitiesWithinAABBExcludingEntity((Entity)null, new AxisAlignedBB(pos.add(0, 0, 0), pos.add(1, 1, 1)));
		if(!list.isEmpty())
		{
			for(int i=0; i<list.size();i++)
			{
				Entity e = (Entity) list.get(i);
				if(e instanceof EntityPlayer){
    				EntityPlayer player = (EntityPlayer) e;
    				player.heal(4);
    			 	ExtendedPlayer.get(player).setMp(100);
    			 	if (player.getFoodStats().getFoodLevel() <20)
    			 	{
    			 		player.getFoodStats().addStats(4, 0);
    			 	}
	    			PacketDispatcher.sendToAllAround(new SpawnCureParticles(pos,true), player, 64.0D);

    		    	if(e.isSneaking()){
    		    		if(((EntityPlayer) e).getBedLocation() != pos)
    		    		{
    		    			((EntityPlayer) e).setSpawnChunk(pos, true, 0);
    		    			((EntityPlayer) e).setSpawnPoint(pos, true);
    		    			TextHelper.sendFormattedChatMessage("Spawn point saved!", EnumChatFormatting.GREEN, player);

    		    		}

    		    	}
				}
			}
		}
		world.scheduleUpdate(pos, this, this.tickRate(world));
	}

	@Override
	public int tickRate(World worldIn) {
		return 15;
	}

	@SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
		return new AxisAlignedBB(pos.add(0, 0, 0), pos.add(1, 0.1, 1));
	}

	@Override
	public boolean isOpaqueCube(){
        return false;
    }

	@Override
    public boolean isFullCube(){
        return false;
    }

	@Override
	public Item getItemDropped(IBlockState state, Random r, int fortune)
	{
		return Item.getItemFromBlock(this);
	}

}

package uk.co.wehavecookies56.kk.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnCureParticles;

import java.util.List;
import java.util.Random;

public class BlockSavePoint extends Block {

	protected BlockSavePoint (Material material, String toolClass, int level, float hardness, float resistance) {
		super(material);
		//setBlockBounds(0, 0, 0, 1, 0.1F, 1);
		setTickRandomly(true);
		//setSoundType(SoundType.STONE);
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, tickRate(world));
		super.onBlockAdded(world, pos, state);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entityIn) {
		if (!world.isRemote) updateState(world, pos);
	}

	@Override
	public void randomTick (World worldIn, BlockPos pos, IBlockState state, Random random) {}

	@Override
	public void updateTick (World world, BlockPos pos, IBlockState state, Random rand) {
		if (!world.isRemote) updateState(world, pos);
	}

	private void updateState (World world, BlockPos pos) {
		List list = world.getEntitiesWithinAABBExcludingEntity((Entity) null, new AxisAlignedBB(pos.add(0, 0, 0), pos.add(1, 1, 1)));
		if (!list.isEmpty()) for (int i = 0; i < list.size(); i++) {
			Entity e = (Entity) list.get(i);
			if (e instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) e;

				if (player.isSneaking() && player.getBedLocation() != pos) {
					player.setSpawnChunk(pos, true, 0);
					player.setSpawnPoint(pos, true);
					TextHelper.sendFormattedChatMessage("Spawn point saved!", TextFormatting.GREEN, player);
					world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.savespawn, SoundCategory.BLOCKS, 1.0f, 1.0f);
				}
					
				if(player.getHealth() != player.getMaxHealth())
				{
					player.heal(4);
					player.getCapability(ModCapabilities.PLAYER_STATS, null).setMP(100);
					if (player.getFoodStats().getFoodLevel() < 20) player.getFoodStats().addStats(4, 0);
					world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.savepoint, SoundCategory.BLOCKS, 1.0f, 1.0f);
					PacketDispatcher.sendToAllAround(new SpawnCureParticles(pos, true), player, 64.0D);
				}
			}
		}
		world.scheduleUpdate(new BlockPos(pos), this, this.tickRate(world));
	}

	@Override
	public int tickRate (World worldIn) {
		return 15;
	}

	@Override
	@SideOnly (Side.CLIENT)
	public BlockRenderLayer getBlockLayer () {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@SuppressWarnings("deprecation")
	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World world, BlockPos pos) {
		return new AxisAlignedBB(new BlockPos(0, 0, 0), new BlockPos(1, 0.1, 1));
	}

    @SuppressWarnings("deprecation")
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState worldIn, World pos, BlockPos state) {
		return new AxisAlignedBB(new BlockPos(0, 0, 0), new BlockPos(1, 0.1, 1));
	}

    @SuppressWarnings("deprecation")
    @Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

    @SuppressWarnings("deprecation")
    @Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	

	@Override
	public Item getItemDropped (IBlockState state, Random r, int fortune) {
		return Item.getItemFromBlock(this);
	}

}

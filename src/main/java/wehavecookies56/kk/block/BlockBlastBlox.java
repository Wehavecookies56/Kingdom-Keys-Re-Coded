package wehavecookies56.kk.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import wehavecookies56.kk.entities.block.EntityBlastBlox;

public class BlockBlastBlox extends BlockBlox {

	protected BlockBlastBlox (Material material, String toolClass, int level, float hardness, float resistance) {
		super(material, toolClass, level, hardness, resistance);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox (World worldIn, BlockPos pos, IBlockState state) {
		float f = 0.0625F;
		return AxisAlignedBB.fromBounds(pos.getX() + f, pos.getY(), pos.getZ() + f, pos.getX() + 1 - f, pos.getY() + 1 - f, pos.getZ() + 1 - f);
	}

	@Override
	public void onEntityCollidedWithBlock (World world, BlockPos pos, IBlockState state, Entity entity) {
		explode(world, pos.getX(), pos.getY(), pos.getZ(), 1, entity instanceof EntityLivingBase ? (EntityLivingBase) entity : null);
		world.setBlockToAir(pos);
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped (Random par1Random) {
		return 1;
	}

	/**
	 * Called upon the block being destroyed by an explosion
	 */
	@Override
	public void onBlockDestroyedByExplosion (World par1World, BlockPos pos, Explosion par5Explosion) {
		if (!par1World.isRemote) {
			EntityBlastBlox entitytntprimed = new EntityBlastBlox(par1World, pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, par5Explosion.getExplosivePlacedBy());
			entitytntprimed.fuse = par1World.rand.nextInt(entitytntprimed.fuse / 4) + entitytntprimed.fuse / 8;
			par1World.spawnEntityInWorld(entitytntprimed);
		}
	}

	/**
	 * Called right before the block is destroyed by a player. Args: world, x,
	 * y, z, metaData
	 */

	@Override
	public void onBlockDestroyedByPlayer (World world, BlockPos pos, IBlockState state) {
		System.out.println(Minecraft.getMinecraft().thePlayer.getHeldItem().getItem());
		if (Minecraft.getMinecraft().thePlayer.getHeldItem().getItem() == Items.apple) explode(world, pos.getX(), pos.getY(), pos.getZ(), state.getBlock().getMetaFromState(state), (EntityLivingBase) null);
	}

	public void explode (World world, int x, int y, int z, int state, EntityLivingBase entity) {
		if (!world.isRemote) if ((state & 1) == 1) {
			EntityBlastBlox entitytntprimed = new EntityBlastBlox(world, x + 0.5F, y + 0.5F, z + 0.5F, entity);
			entitytntprimed.fuse = 50;
			world.spawnEntityInWorld(entitytntprimed);
			world.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
		}
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */

	@Override
	public boolean onBlockActivated (World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem() == new ItemStack(Items.flint_and_steel)) {
			explode(world, pos.getX(), pos.getY(), pos.getZ(), 1, player);
			world.setBlockToAir(pos);
			player.getCurrentEquippedItem().damageItem(1, player);
			return true;
		} else
			return super.onBlockActivated(world, pos, state, player, side, hitX, hitY, hitZ);
	}

	/**
	 * Triggered whenever an entity collides with this block (enters into the
	 * block). Args: world, x, y, z, entity
	 */
	@Override
	public void onBlockClicked (World world, BlockPos pos, EntityPlayer player) {
		if (player.getHeldItem() != null) {
			if (player.getHeldItem().getItem() == Items.feather)
				world.destroyBlock(pos, true);
			else {
				explode(world, pos.getX(), pos.getY(), pos.getZ(), 1, player);
				world.setBlockToAir(pos);
			}
		} else {
			explode(world, pos.getX(), pos.getY(), pos.getZ(), 1, player);
			world.setBlockToAir(pos);
		}
	}

	/**
	 * Return whether this block can drop from an explosion.
	 */
	@Override
	public boolean canDropFromExplosion (Explosion par1Explosion) {
		return false;
	}

}
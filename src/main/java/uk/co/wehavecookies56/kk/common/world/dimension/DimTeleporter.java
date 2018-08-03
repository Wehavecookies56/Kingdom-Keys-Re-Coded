package uk.co.wehavecookies56.kk.common.world.dimension;

import java.util.Random;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.ITeleporter;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.block.base.BlockStationOfAwakening;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.capability.FirstTimeJoinCapability;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.world.WorldLoader;
import uk.co.wehavecookies56.kk.common.world.WorldSavedDataKingdomKeys;

/**
 * Created by Toby on 01/08/2016.
 */
public class DimTeleporter implements ITeleporter {

	BlockPos pos;
	int dimension;

	public DimTeleporter(BlockPos pos, int dimension) {
		this.pos = pos;
		this.dimension = dimension;
	}

	public Vec3d getSpawnPoint(BlockPos pos, World world) {
		Vec3d centre = new Vec3d((pos.getX()) + 0.5, (pos.getY()) + 0.5, (pos.getZ()) + 0.5);
		return centre;
	}

	@Override
	public void placeEntity(World world, Entity entity, float yaw) {
		if (entity instanceof EntityPlayer) {
			EntityPlayerMP playerMP = (EntityPlayerMP) entity;
			playerMP.motionX = playerMP.motionY = playerMP.motionZ = 0;

			WorldSavedDataKingdomKeys data = WorldSavedDataKingdomKeys.get(world);

			if (dimension == ModDimensions.destinyIslandsID || dimension == ModDimensions.traverseTownID) {
				if (!data.isGenerated()) {
					entity.sendMessage(new TextComponentTranslation("Generating world, this will take a while..."));
					entity.sendMessage(new TextComponentTranslation("This only happens the first time you visit the world"));
					WorldLoader loader = new WorldLoader();
					loader.processAndGenerateStructureFile(Utils.getDimensionIDAndBlockPos(dimension).name, world.getMinecraftServer().getServer().getWorld(Utils.getDimensionIDAndBlockPos(dimension).id), Utils.getDimensionIDAndBlockPos(dimension).offset);

					entity.sendMessage(new TextComponentTranslation("World generated completed, please wait while chunks load..."));
					entity.sendMessage(new TextComponentTranslation("Expect a large performance drop while this happens"));
					data.setGenerated(true);
				}
			} else if(dimension == ModDimensions.diveToTheHeartID) {
				generateSOA(world);
			}

			if (pos == null) { // TODO spawn point for overworld
				pos = playerMP.getBedLocation();
				if(pos == null) {
			        FirstTimeJoinCapability.IFirstTimeJoin originalPos = playerMP.getCapability(ModCapabilities.FIRST_TIME_JOIN, null);
			        pos = new BlockPos(originalPos.getPosX(),originalPos.getPosY(),originalPos.getPosZ());
				}
			}
			Vec3d destination = getSpawnPoint(pos, world);
			playerMP.connection.setPlayerLocation(destination.x, destination.y, destination.z, playerMP.rotationYaw, playerMP.rotationPitch);
		}
	}

	private void generateSOA(World world) {
		double dx = -1;
        double dy = 64;
        double dz = -1;
        
		int radius = 15;
        int barrierRadius = 16;
        int barrierHeight = 5;
        
        for(int i = 0; i<barrierHeight; i++) {
            for(float j = 0; j < 2 * Math.PI * barrierRadius; j += 0.5) {
                world.setBlockState(new BlockPos((int)Math.floor(dx + Math.sin(j) * barrierRadius), dy +i, (int)Math.floor(dz + Math.cos(j) * barrierRadius)), Blocks.BARRIER.getDefaultState());
            }
        }
        
        for(float i = 0; i < radius+2; i += 0.5) {
            for(float j = 0; j < 2 * Math.PI * i; j += 0.5) {
                if(i > radius) {
                    world.setBlockState(new BlockPos((int)Math.floor(dx + Math.sin(j) * i), dy, (int)Math.floor(dz + Math.cos(j) * i)), Blocks.BARRIER.getDefaultState());
                }else {
                    world.setBlockState(new BlockPos((int)Math.floor(dx + Math.sin(j) * i), dy, (int)Math.floor(dz + Math.cos(j) * i)), Blocks.GLOWSTONE.getDefaultState());
                }
            }
        }
        
        world.setBlockState(new BlockPos(dx+(-12), dy, dz+(-13)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 0));
        world.setBlockState(new BlockPos(dx+(-4), dy, dz+(-13)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 1));
        world.setBlockState(new BlockPos(dx+(4), dy, dz+(-13)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 2));
        world.setBlockState(new BlockPos(dx+(12), dy, dz+(-13)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 3));

        world.setBlockState(new BlockPos(dx+(-12), dy, dz+(-5)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 4));
        world.setBlockState(new BlockPos(dx+(-4), dy, dz+(-5)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 5));
        world.setBlockState(new BlockPos(dx+(4), dy, dz+(-5)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 6));
        world.setBlockState(new BlockPos(dx+(12), dy, dz+(-5)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 7));

        world.setBlockState(new BlockPos(dx+(-12), dy, dz+(3)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 8));
        world.setBlockState(new BlockPos(dx+(-4), dy, dz+(3)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 9));
        world.setBlockState(new BlockPos(dx+(4), dy, dz+(3)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 10));
        world.setBlockState(new BlockPos(dx+(12), dy, dz+(3)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 11));

        world.setBlockState(new BlockPos(dx+(-12), dy, dz+(11)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 12));
        world.setBlockState(new BlockPos(dx+(-4), dy, dz+(11)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 13));
        world.setBlockState(new BlockPos(dx+(4), dy, dz+(11)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 14));
        world.setBlockState(new BlockPos(dx+(12), dy, dz+(11)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 15));

        TileEntityPedestal shieldPedestal = new TileEntityPedestal();
        shieldPedestal.setKeyblade(new ItemStack(ModItems.DreamShield));
        shieldPedestal.itemStacks.setStackInSlot(0, new ItemStack(ModItems.DreamShield));
        shieldPedestal.rotation = 3;
        world.setBlockState(new BlockPos(dx-12, dy+1, dz), ModBlocks.Pedestal.getDefaultState()); //Shield
        world.setTileEntity(new BlockPos(dx-12, dy+1, dz), shieldPedestal);
        
        TileEntityPedestal staffPedestal = new TileEntityPedestal();
        staffPedestal.setKeyblade(new ItemStack(ModItems.DreamStaff));
        staffPedestal.itemStacks.setStackInSlot(0, new ItemStack(ModItems.DreamStaff));
        staffPedestal.rotation=1;
        world.setBlockState(new BlockPos(dx+12, dy+1, dz), ModBlocks.Pedestal.getDefaultState()); //Staff
        world.setTileEntity(new BlockPos(dx+12, dy+1, dz), staffPedestal);

        TileEntityPedestal swordPedestal = new TileEntityPedestal();
        swordPedestal.setKeyblade(new ItemStack(ModItems.DreamSword));
        swordPedestal.itemStacks.setStackInSlot(0, new ItemStack(ModItems.DreamSword));
        swordPedestal.rotation=1;
        world.setBlockState(new BlockPos(dx, dy+1, dz-12), ModBlocks.Pedestal.getDefaultState());  //Sword
        world.setTileEntity(new BlockPos(dx, dy+1, dz-12), swordPedestal);

        world.setBlockState(new BlockPos(dx, dy+1, dz+12), ModBlocks.StationOfAwakeningDoor.getDefaultState());	}

}

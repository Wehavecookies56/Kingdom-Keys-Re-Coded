package uk.co.wehavecookies56.kk.common.world;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntityStructure;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.registry.GameRegistry;
import scala.actors.threadpool.Arrays;
import uk.co.wehavecookies56.kk.common.block.BlockKKChest;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WorldLoader {

    public WorldLoader() {

    }

    public void processAndGenerateStructureFile(ResourceLocation file, WorldServer world, int xOffset, int yOffset, int zOffset) {
        try {
            InputStream inputStream = Minecraft.getMinecraft().getResourceManager().getResource(file).getInputStream();
            NBTTagCompound main = CompressedStreamTools.readCompressed(inputStream);

            NBTTagList palette = main.getTagList("palette", Constants.NBT.TAG_COMPOUND);

            NBTTagList blocks = main.getTagList("blocks", Constants.NBT.TAG_COMPOUND);

            List<IBlockState> blockStates = new ArrayList<>();

            System.out.println("Generating World with " + blocks.tagCount() + " blocks");
            NBTTagCompound firstBlock = blocks.getCompoundTagAt(0);
            BlockPos firstPos = new BlockPos(firstBlock.getTagList("pos", 3).getIntAt(0), firstBlock.getTagList("pos", 3).getIntAt(1), firstBlock.getTagList("pos", 3).getIntAt(2));
            System.out.println("Starting with position " + firstPos.getX()+xOffset + " " + firstPos.getY()+yOffset + " " + firstPos.getZ()+zOffset);

            for (int i = 0; i < palette.tagCount(); i++) {
                NBTTagCompound block = palette.getCompoundTagAt(i);
                blockStates.add(NBTUtil.readBlockState(block));
            }

            for (int i = 0; i < blocks.tagCount(); i++) {
                NBTTagCompound block = blocks.getCompoundTagAt(i);
                BlockPos blockpos = new BlockPos(block.getTagList("pos", 3).getIntAt(0)+xOffset, block.getTagList("pos", 3).getIntAt(1)+yOffset, block.getTagList("pos", 3).getIntAt(2)+zOffset);
                IBlockState state = blockStates.get(block.getInteger("state"));
                if (block.hasKey("nbt")) {
                    NBTTagCompound nbtData = block.getCompoundTag("nbt");
                    TileEntityStructure.create(world, nbtData);
                }
                if (state.getBlock() == Blocks.OAK_DOOR)
                    if (world.getBlockState(blockpos.down()).getBlock() == Blocks.AIR)
                        world.setBlockState(blockpos.down(), Blocks.DIRT.getDefaultState(), 2);
                if (state.getBlock() == Blocks.TORCH && state.getValue(BlockTorch.FACING) == EnumFacing.WEST)
                    if (world.getBlockState(blockpos.east()).getBlock() == Blocks.AIR)
                        world.setBlockState(blockpos.east(), Blocks.DIRT.getDefaultState(), 2);
                if (state.getBlock() == Blocks.TORCH && state.getValue(BlockTorch.FACING) == EnumFacing.EAST)
                    if (world.getBlockState(blockpos.west()).getBlock() == Blocks.AIR)
                        world.setBlockState(blockpos.west(), Blocks.DIRT.getDefaultState(), 2);
                if (state.getBlock() == Blocks.TORCH && state.getValue(BlockTorch.FACING) == EnumFacing.NORTH)
                    if (world.getBlockState(blockpos.south()).getBlock() == Blocks.AIR)
                        world.setBlockState(blockpos.south(), Blocks.DIRT.getDefaultState(), 2);
                if (state.getBlock() == Blocks.TORCH && state.getValue(BlockTorch.FACING) == EnumFacing.SOUTH)
                    if (world.getBlockState(blockpos.north()).getBlock() == Blocks.AIR)
                        world.setBlockState(blockpos.north(), Blocks.DIRT.getDefaultState(), 2);
                if (state.getBlock() == Blocks.TORCH && state.getValue(BlockTorch.FACING) == EnumFacing.UP)
                    if (world.getBlockState(blockpos.down()).getBlock() == Blocks.AIR)
                        world.setBlockState(blockpos.down(), Blocks.DIRT.getDefaultState(), 2);
                if (state.getBlock() == Blocks.CHEST)
                    world.setBlockState(blockpos, ModBlocks.KKChest.getDefaultState().withProperty(BlockKKChest.FACING, state.getValue(BlockChest.FACING)));
                else
                    world.setBlockState(blockpos, state, 2);
                //System.out.println(i + ":" + state.getBlock() + " " + blockpos.getY());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}

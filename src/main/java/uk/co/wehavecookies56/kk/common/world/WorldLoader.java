package uk.co.wehavecookies56.kk.common.world;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.jnbt.*;

import java.io.IOException;
import java.util.Map;

public class WorldLoader {

    Map<String, Tag> tags;
    //y
    short height;
    //x
    short width;
    //z
    short length;

    public WorldLoader() {

    }

    public NBTInputStream openSchematic (ResourceLocation file) {
        if (file.getResourcePath().contains(".world")) {
            try {
                return new NBTInputStream(Minecraft.getMinecraft().getResourceManager().getResource(file).getInputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public <T extends Tag> T getTag(String name, Class<T> tagType) {
        if (tags != null) {
            if (tags.containsKey(name)) {
                return (T) tags.get(name);
            }
            try {
                return (T) tagType.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return null;
        }
    }

    public BlockPos getSpawnLocation(ResourceLocation file, World world, int xOffset, int yOffset, int zOffset) {
        BlockPos spawn = new BlockPos(0+xOffset, 64+yOffset, 0+zOffset);
        NBTInputStream is = openSchematic(file);
        try {
            CompoundTag main = (CompoundTag) is.readTag();
            if (!main.getName().equals("World")) {
                throw new IllegalArgumentException("Schematic is not KK format");
            }
            tags = main.getValue();
            int[] spawnLocation = getTag("spawnLocation", IntArrayTag.class).getValue();
            spawn = new BlockPos(spawnLocation[0]+xOffset, spawnLocation[1]+yOffset, spawnLocation[2]+zOffset);
            is.close();
            return spawn;
        } catch (IOException e){
            e.printStackTrace();
        }
        return spawn;
    }

    public void processAndGenerateSchematic(ResourceLocation file, World world, int xOffset, int yOffset, int zOffset) {
        NBTInputStream is = openSchematic(file);
        try {
            CompoundTag main = (CompoundTag) is.readTag();
            if (!main.getName().equals("World")) {
                throw new IllegalArgumentException("Schematic is not KK format");
            }
            tags = main.getValue();
            if (!tags.containsKey("Blocks")) {
                throw new IllegalArgumentException("Blocks tag missing from schematic");
            }
            width = getTag("Width", ShortTag.class).getValue();
            height = getTag("Height", ShortTag.class).getValue();
            length = getTag("Length", ShortTag.class).getValue();
            String materialsVer = getTag("Materials", StringTag.class).getValue();
            if (!materialsVer.equals("Alpha")) {
                throw new IllegalArgumentException("Materials should are not from Alpha");
            }
            byte version = getTag("itemStackVersion", ByteTag.class).getValue();
            if (version != 18) {
                throw new IllegalArgumentException("Invalid itemstack version");
            }
            byte[] blocks = getTag("Blocks", ByteArrayTag.class).getValue();
            byte[] blockMeta = getTag("Data", ByteArrayTag.class).getValue();
            Map<String, Tag> BlockIDs = getTag("BlockIDs", CompoundTag.class).getValue();

            for(int x = 0; x < width; x++) {
                for(int y = 0; y < height; y++) {
                    for(int z = 0; z < length; z++) {
                        int index = y * width * length + z * width + x;
                        if (BlockIDs.get(String.valueOf(blocks[index])) != null) {
                            if (!BlockIDs.get(String.valueOf(blocks[index])).getValue().equals("minecraft:air")) {
                                if (GameRegistry.findRegistry(Block.class).containsKey(new ResourceLocation(BlockIDs.get(String.valueOf(blocks[index])).getValue().toString()))) {
                                    BlockPos pos = new BlockPos(x + xOffset, y + yOffset, z + zOffset);
                                    Block block = GameRegistry.findRegistry(Block.class).getValue(new ResourceLocation(BlockIDs.get(String.valueOf(blocks[index])).getValue().toString()));
                                    if (blockMeta[index] == 0) {
                                        world.setBlockState(pos, block.getDefaultState());
                                    } else {
                                        world.setBlockState(pos, block.getStateFromMeta(blockMeta[index]));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            is.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}

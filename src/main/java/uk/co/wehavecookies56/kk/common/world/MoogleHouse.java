package uk.co.wehavecookies56.kk.common.world;

import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityMoogle;
import uk.co.wehavecookies56.kk.common.lib.Reference;

import java.util.List;
import java.util.Random;

public class MoogleHouse extends StructureVillagePieces.Village {

    public static ResourceLocation chest = new ResourceLocation(Reference.MODID, "chests/moogle_house");

    public MoogleHouse() { }

    public MoogleHouse(StructureVillagePieces.Start piece, int something, Random random, StructureBoundingBox boundingBox, EnumFacing facing) {
        super(piece, something);
        this.setCoordBaseMode(facing);
        this.boundingBox = boundingBox;
    }

    private int groundLevel = -1;

    protected void placeDoor(World worldIn, StructureBoundingBox boundingBoxIn, Random rand, int x, int y, int z, EnumFacing facing, BlockDoor.EnumHingePosition hinge) {
        this.setBlockState(worldIn, Blocks.OAK_DOOR.getDefaultState().withProperty(BlockDoor.FACING, facing).withProperty(BlockDoor.HINGE, hinge), x, y, z, boundingBoxIn);
        this.setBlockState(worldIn, Blocks.OAK_DOOR.getDefaultState().withProperty(BlockDoor.FACING, facing).withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER).withProperty(BlockDoor.HINGE, hinge), x, y + 1, z, boundingBoxIn);
    }

    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox boundingBox) {
        if (groundLevel < 0) {
            groundLevel = this.getAverageGroundLevel(world, boundingBox);
            if (groundLevel < 0)
                return true;
            this.boundingBox.offset(0, groundLevel - this.boundingBox.maxY + 5 - 1, 0);
        }

        //this.fillWithBlocks(world, boundingBox, 0,0,0, 10,9,8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        IBlockState darkOak = Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK);
        IBlockState darkOakLog = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);

        this.fillWithAir(world, boundingBox, 0, 0, 0, 6, 6, 6);
        //Bottom layers of cobble
        this.fillWithBlocks(world, boundingBox, 0, 0, 0, 6, 0, 6, Blocks.COBBLESTONE.getDefaultState(), Blocks.COBBLESTONE.getDefaultState(), false);
        this.fillWithBlocks(world, boundingBox, 1, 0, 1, 5, 0, 5, ModBlocks.HardBlox.getDefaultState(), ModBlocks.HardBlox.getDefaultState(), false);
        this.fillWithBlocks(world, boundingBox, 2, 0, 2, 4, 0, 4, Blocks.WOOL.getStateFromMeta(15), Blocks.WOOL.getStateFromMeta(15), false);
        this.fillWithBlocks(world, boundingBox, 0, 1, 0, 6, 1, 6, Blocks.COBBLESTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        //Fill inside of top layer of cobble with air
        this.fillWithAir(world, boundingBox, 1, 1, 1, 5, 1, 5);
        this.generateDoor(world, boundingBox, random, 3, 1, 0, EnumFacing.NORTH, Blocks.OAK_DOOR);

        this.setBlockState(world, Blocks.COBBLESTONE.getDefaultState(), 0, 2, 0, boundingBox);
        this.setBlockState(world, darkOak, 1, 2, 0, boundingBox);
        this.setBlockState(world, darkOak, 2, 2, 0, boundingBox);
        this.setBlockState(world, darkOak, 4, 2, 0, boundingBox);
        this.setBlockState(world, darkOak, 5, 2, 0, boundingBox);
        this.setBlockState(world, Blocks.COBBLESTONE.getDefaultState(), 6, 2, 0, boundingBox);

        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 1, 1, 1, boundingBox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 2, 1, 1, boundingBox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 1, 2, 1, boundingBox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 2, 2, 1, boundingBox);

        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 5, 1, 1, boundingBox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 5, 1, 2, boundingBox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 5, 1, 3, boundingBox);
        this.setBlockState(world, ModBlocks.SynthesisTable.getDefaultState(), 5, 1, 5, boundingBox);

        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 5, 3, 1, boundingBox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 5, 3, 2, boundingBox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 5, 3, 3, boundingBox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 5, 3, 4, boundingBox);
        this.setBlockState(world, Blocks.BOOKSHELF.getDefaultState(), 5, 3, 5, boundingBox);

        this.generateChest(world, boundingBox, random, 1, 1, 5, chest);

        this.setBlockState(world, Blocks.COBBLESTONE.getDefaultState(), 0, 3, 0, boundingBox);
        this.setBlockState(world, darkOak, 1, 3, 0, boundingBox);
        this.setBlockState(world, darkOak, 2, 3, 0, boundingBox);
        this.setBlockState(world, darkOak, 3, 3, 0, boundingBox);
        this.setBlockState(world, darkOak, 4, 3, 0, boundingBox);
        this.setBlockState(world, darkOak, 5, 3, 0, boundingBox);
        this.setBlockState(world, Blocks.COBBLESTONE.getDefaultState(), 6, 3, 0, boundingBox);

        this.fillWithBlocks(world, boundingBox, 0, 4, 0, 6, 4, 6, darkOakLog, darkOakLog, false);
        this.fillWithAir(world, boundingBox, 1, 4, 1, 5, 4, 5);

        this.fillWithBlocks(world, boundingBox, 1, 5, 1, 5, 5, 5, darkOakLog, darkOakLog, false);
        this.fillWithBlocks(world, boundingBox, 2, 5, 2, 4, 5, 4, Blocks.GLASS.getDefaultState(), Blocks.GLASS.getDefaultState(), false);

        this.setBlockState(world, darkOak, 0, 2, 1, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 2, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 3, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 0, 2, 4, boundingBox);
        this.setBlockState(world, darkOak, 0, 2, 5, boundingBox);
        this.setBlockState(world, Blocks.COBBLESTONE.getDefaultState(), 0, 2, 6, boundingBox);

        this.setBlockState(world, darkOak, 0, 3, 1, boundingBox);
        this.setBlockState(world, darkOak, 0, 3, 2, boundingBox);
        this.setBlockState(world, darkOak, 0, 3, 3, boundingBox);
        this.setBlockState(world, darkOak, 0, 3, 4, boundingBox);
        this.setBlockState(world, darkOak, 0, 3, 5, boundingBox);
        this.setBlockState(world, Blocks.COBBLESTONE.getDefaultState(), 0, 3, 6, boundingBox);

        this.setBlockState(world, darkOak, 6, 2, 1, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 2, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 3, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 6, 2, 4, boundingBox);
        this.setBlockState(world, darkOak, 6, 2, 5, boundingBox);
        this.setBlockState(world, Blocks.COBBLESTONE.getDefaultState(), 6, 2, 6, boundingBox);

        this.setBlockState(world, darkOak, 6, 3, 1, boundingBox);
        this.setBlockState(world, darkOak, 6, 3, 2, boundingBox);
        this.setBlockState(world, darkOak, 6, 3, 3, boundingBox);
        this.setBlockState(world, darkOak, 6, 3, 4, boundingBox);
        this.setBlockState(world, darkOak, 6, 3, 5, boundingBox);
        this.setBlockState(world, Blocks.COBBLESTONE.getDefaultState(), 6, 3, 6, boundingBox);

        this.setBlockState(world, darkOak, 1, 2, 6, boundingBox);
        this.setBlockState(world, darkOak, 2, 2, 6, boundingBox);
        this.setBlockState(world, darkOak, 3, 2, 6, boundingBox);
        this.setBlockState(world, darkOak, 4, 2, 6, boundingBox);
        this.setBlockState(world, darkOak, 5, 2, 6, boundingBox);

        this.setBlockState(world, darkOak, 1, 3, 6, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 2, 3, 6, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 3, 3, 6, boundingBox);
        this.setBlockState(world, Blocks.GLASS_PANE.getDefaultState(), 4, 3, 6, boundingBox);
        this.setBlockState(world, darkOak, 5, 3, 6, boundingBox);

        this.setBlockState(world, Blocks.WALL_SIGN.getDefaultState().withProperty(BlockWallSign.FACING, EnumFacing.NORTH.getOpposite()), 2, 2, -1, boundingBox);
        TileEntitySign sign = new TileEntitySign();
        sign.signText[0] = new TextComponentTranslation("Moogle");
        sign.signText[1] = new TextComponentTranslation("Shop");
        world.setTileEntity(new BlockPos(getXWithOffset(2, -1), getYWithOffset(2), getZWithOffset(2, -1)), sign);

        EntityMoogle moogle = new EntityMoogle(world, false);
        moogle.setPosition(getXWithOffset(3, 3), getYWithOffset(2), getZWithOffset(3, 3));
        world.spawnEntity(moogle);
        return true;
    }

    public static class VillageManager implements VillagerRegistry.IVillageCreationHandler {

        @Override
        public StructureVillagePieces.Village buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List<StructureComponent> pieces, Random random, int p1, int p2, int p3, EnumFacing facing, int p5) {
            StructureBoundingBox boundingBox = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, 7, 6, 7, facing);
            return new MoogleHouse(startPiece, p5, random, boundingBox, facing);
        }

        @Override
        public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int i) {
            return new StructureVillagePieces.PieceWeight(MoogleHouse.class, 15, MathHelper.getInt(random, 0 + i, 1 + i));
        }

        @Override
        public Class<?> getComponentClass() {
            return MoogleHouse.class;
        }
    }

}

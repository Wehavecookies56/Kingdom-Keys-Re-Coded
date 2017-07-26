package uk.co.wehavecookies56.kk.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.network.packet.client.PedestalRotation;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;

public class BlockPedestal extends Block implements ITileEntityProvider{

    protected BlockPedestal (Material material, String toolClass, int level, float hardness, float resistance, String name) {
        super(material);
        this.setHarvestLevel(toolClass, level);
        setHardness(hardness);
        setResistance(resistance);
        setCreativeTab(ModBlocks.tabKingdomKeysBlocks);
        setRegistryName(name);
        setUnlocalizedName(name);
    }

    public TileEntity createNewTileEntity (World worldIn, int meta) {
        return new TileEntityPedestal();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntityPedestal te = (TileEntityPedestal) world.getTileEntity(pos);
            player.openGui(KingdomKeys.instance, GuiIDs.GUI_PEDESTAL_INV, world, pos.getX(), pos.getY(), pos.getZ());
            PacketDispatcher.sendToAll(new PedestalRotation(te));
            return true;
        }
        return false;
    }

    @Override
    public void breakBlock (World worldIn, BlockPos pos, IBlockState state) {

        TileEntityPedestal te = (TileEntityPedestal) worldIn.getTileEntity(pos);
        IItemHandler inventory = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);

        if (inventory != null) {
            for (int i = 0; i < inventory.getSlots(); i++)
                if (inventory.getStackInSlot(i) != ItemStack.EMPTY) {
                    EntityItem item = new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory.getStackInSlot(i));

                    float multiplier = 0.1f;
                    float motionX = worldIn.rand.nextFloat() - 0.5f;
                    float motionY = worldIn.rand.nextFloat() - 0.5f;
                    float motionZ = worldIn.rand.nextFloat() - 0.5f;

                    item.motionX = motionX * multiplier;
                    item.motionY = motionY * multiplier;
                    item.motionZ = motionZ * multiplier;

                    worldIn.spawnEntity(item);
                }
        }
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return true;
    }
}

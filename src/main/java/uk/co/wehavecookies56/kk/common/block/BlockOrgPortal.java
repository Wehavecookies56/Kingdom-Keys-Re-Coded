package uk.co.wehavecookies56.kk.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityOrgPortal;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgXIIIData;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class BlockOrgPortal extends Block implements ITileEntityProvider{

    protected BlockOrgPortal (Material material, String toolClass, int level, float hardness, float resistance) {
        super(material);
        this.setHarvestLevel(toolClass, level);
        //this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setHardness(hardness);
        setResistance(resistance);
        setSoundType(SoundType.STONE);
    }

    @Override
    public TileEntity createNewTileEntity (World worldIn, int meta) {
        return new TileEntityOrgPortal();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember() != Utils.OrgMember.NONE) {
                if (world.getTileEntity(pos) instanceof TileEntityOrgPortal) {
                    //System.out.println("hi");

                    TileEntityOrgPortal te = (TileEntityOrgPortal) world.getTileEntity(pos);

                    if (te.getOwner() == null) {
                        te.setOwner(player);
                        te.markDirty();

                        player.sendMessage(new TextComponentString(TextFormatting.GREEN + "This is now " + player.getDisplayNameString() + "'s portal"));
                        player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setPortalX(pos.getX());
                        player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setPortalY(pos.getY());
                        player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setPortalZ(pos.getZ());
                        //System.out.println(pos.getX()+","+pos.getY()+","+pos.getZ());
                        PacketDispatcher.sendTo(new SyncOrgXIIIData(player.getCapability(ModCapabilities.ORGANIZATION_XIII, null)), (EntityPlayerMP) player);
                        return true;

                    }else if(te.getOwner().equals(player.getDisplayNameString())){
                        player.sendMessage(new TextComponentString(TextFormatting.YELLOW + "This is your portal"));
                    }else {
                        player.sendMessage(new TextComponentString(TextFormatting.RED + "This portal belongs to "+player.getDisplayNameString()));
                        return false;
                    }

                }
            }
        }
        return false;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        if (!world.isRemote) {
            //System.out.println(world.getTileEntity(pos));

            if (world.getTileEntity(pos) instanceof TileEntityOrgPortal) {
                TileEntityOrgPortal te = (TileEntityOrgPortal) world.getTileEntity(pos);
                if (te.getOwner() != null) {
                    EntityPlayer player = world.getPlayerEntityByName(te.getOwner());
                    player.sendMessage(new TextComponentString(TextFormatting.RED + "Portal destination disappeared"));
                    player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setPortalX(0);
                    player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setPortalY(0);
                    player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setPortalZ(0);
                    PacketDispatcher.sendTo(new SyncOrgXIIIData(player.getCapability(ModCapabilities.ORGANIZATION_XIII, null)), (EntityPlayerMP) player);
                    //System.out.println(player);
                }
            }
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state) {



        super.onBlockDestroyedByPlayer(world, pos, state);
    }
}

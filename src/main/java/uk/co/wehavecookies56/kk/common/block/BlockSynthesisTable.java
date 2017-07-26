package uk.co.wehavecookies56.kk.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntitySynthesisTable;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncFreeDevRecipeData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMaterialData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncRecipeData;
import uk.co.wehavecookies56.kk.common.network.packet.server.OpenSynthesis;

public class BlockSynthesisTable extends Block implements ITileEntityProvider {

    protected BlockSynthesisTable (Material material, String toolClass, int level, float hardness, float resistance, String name) {
        super(material);
        this.setHarvestLevel(toolClass, level);
        setHardness(hardness);
        setResistance(resistance);
        setCreativeTab(ModBlocks.tabKingdomKeysBlocks);
        setRegistryName(name);
        setUnlocalizedName(name);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, ModSounds.kupo, SoundCategory.BLOCKS, 0.5F, 1.0F);
        if(world.isRemote)
            PacketDispatcher.sendToServer(new OpenSynthesis());
        player.openGui(KingdomKeys.instance, GuiIDs.GUI_SYNTHESISTABLE, world, pos.getX(), pos.getY(), pos.getZ());
        if (!world.isRemote){
            PacketDispatcher.sendTo(new SyncRecipeData(player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null)), (EntityPlayerMP) player);
            PacketDispatcher.sendTo(new SyncFreeDevRecipeData(player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null)), (EntityPlayerMP) player);
            PacketDispatcher.sendTo(new SyncMaterialData(player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null)), (EntityPlayerMP) player);
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity (World worldIn, int meta) {
        return new TileEntitySynthesisTable();
    }

}
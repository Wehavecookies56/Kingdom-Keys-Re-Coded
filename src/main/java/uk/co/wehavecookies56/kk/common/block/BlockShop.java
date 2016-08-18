package uk.co.wehavecookies56.kk.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.block.base.BlockBlox;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.OpenMenu;
import uk.co.wehavecookies56.kk.common.network.packet.server.OpenShop;

import javax.annotation.Nullable;

/**
 * Created by Toby on 19/07/2016.
 */
public class BlockShop extends BlockBlox {

    public BlockShop(Material material, String toolClass, int level, float hardness, float resistance) {
        super(material, toolClass, level, hardness, resistance);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        PacketDispatcher.sendToServer(new OpenShop());
    	playerIn.openGui(KingdomKeys.instance, GuiIDs.GUI_SHOP, worldIn, pos.getX(), pos.getY(), pos.getZ());
        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, ModSounds.kupo, SoundCategory.BLOCKS, 0.5F, 1.0F);

        return true;
    }
}

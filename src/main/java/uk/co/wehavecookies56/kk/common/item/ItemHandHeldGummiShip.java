package uk.co.wehavecookies56.kk.common.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKBase;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.LevelUpMagic;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.world.dimension.ModDimensions;
import uk.co.wehavecookies56.kk.common.world.dimension.TeleporterDestinyIslands;
import uk.co.wehavecookies56.kk.common.world.dimension.TeleporterDiveToTheHeart;
import uk.co.wehavecookies56.kk.common.world.dimension.TeleporterOverworld;
import uk.co.wehavecookies56.kk.common.world.dimension.TeleporterTraverseTown;

public class ItemHandHeldGummiShip extends ItemKKBase {

    public ItemHandHeldGummiShip (String name) {
        super(name);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
    	if (!player.world.isRemote) {
        	if(player.dimension == ModDimensions.destinyIslandsID) {
        		new TeleporterTraverseTown(player.world.getMinecraftServer().getServer().getWorld(ModDimensions.traverseTownID)).teleport(((EntityPlayer) player), player.world);
        	} else if(player.dimension == ModDimensions.traverseTownID) {
                new TeleporterOverworld(player.world.getMinecraftServer().getServer().getWorld(0)).teleport((player), player.world);
        	} else {
                new TeleporterDestinyIslands(player.world.getMinecraftServer().getServer().getWorld(ModDimensions.destinyIslandsID)).teleport(((EntityPlayer) player), player.world);
        	}
        }
        return super.onItemRightClick(world, player, hand);
    }   

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation (ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag) {
    	if(Minecraft.getMinecraft().player != null)
        tooltip.add("You are in: "+DimensionType.getById(Minecraft.getMinecraft().player.dimension));
        super.addInformation(stack, world, tooltip, flag);
    }
}

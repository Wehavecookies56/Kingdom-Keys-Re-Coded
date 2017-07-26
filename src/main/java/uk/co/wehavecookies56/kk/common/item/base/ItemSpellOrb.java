package uk.co.wehavecookies56.kk.common.item.base;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.LevelUpMagic;
import uk.co.wehavecookies56.kk.common.util.Utils;

import javax.annotation.Nullable;

public abstract class ItemSpellOrb extends ItemKKBase {

    String magic;

    public ItemSpellOrb (String name, String magic) {
        super(name);
        this.magic = magic;
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (world.isRemote) {
            PacketDispatcher.sendToServer(new LevelUpMagic(this.magic));
        }
        return super.onItemRightClick(world, player, hand);
    }

    public String getMagicLevelName(EntityPlayer player, String magic){
        String magicName;
        int magicLevel = player.getCapability(ModCapabilities.MAGIC_STATE, null).getMagicLevel(magic);
        return magic;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation (ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag) {
        if (Minecraft.getMinecraft().player != null)
            tooltip.add(Utils.translateToLocal(Constants.getMagicName(magic, Minecraft.getMinecraft().player.getCapability(ModCapabilities.MAGIC_STATE, null).getMagicLevel(magic))));
        super.addInformation(stack, world, tooltip, flag);
    }

    public String getMagicName () {
        return magic;
    }

    public void setMagicName (String magic) {
        this.magic = magic;
    }
}

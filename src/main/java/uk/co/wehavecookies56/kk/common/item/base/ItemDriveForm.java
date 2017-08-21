package uk.co.wehavecookies56.kk.common.item.base;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.LevelUpDrive;
import uk.co.wehavecookies56.kk.common.util.Utils;

import javax.annotation.Nullable;
import java.util.List;

public abstract class ItemDriveForm extends ItemKKBase {

    String form;

    public ItemDriveForm (String name, String form) {
        super(name);
        this.form = form;
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (world.isRemote) PacketDispatcher.sendToServer(new LevelUpDrive(this.form, 1));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(Utils.translateToLocal(this.form));
        if (DriveFormRegistry.get(this.form) != null)
            tooltip.add(TextFormatting.GOLD + "Costs " + (DriveFormRegistry.get(this.form).getCost() / 100) + " drive gauges");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    public String getDriveFormName () {
        return form;
    }

    public void setDriveFormName (String form) {
        this.form = form;
    }

}

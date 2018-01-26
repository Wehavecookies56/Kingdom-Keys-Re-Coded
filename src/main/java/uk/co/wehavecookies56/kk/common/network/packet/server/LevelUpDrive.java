package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.container.inventory.InventoryDriveForms;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.item.base.ItemDriveForm;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveInventory;

public class LevelUpDrive extends AbstractMessage.AbstractServerMessage<LevelUpDrive> {

    String form;
    int levels;
    public LevelUpDrive () {}

    public LevelUpDrive (String form, int level) {
        this.form = form;
        this.levels = level;

    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        form = buffer.readString(40);
        levels = buffer.readInt();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeString(form);
        buffer.writeInt(levels);
    }
    
    public static EntityPlayer getPlayerFromUsername(String username) {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
            return null;

        return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(username);
    }
    
    @Override
    public void process (EntityPlayer player, Side side) {

        int hasDriveInSlot = -1, nullSlot = -1;

        if (levels == 7) {
            player.getCapability(ModCapabilities.DRIVE_STATE, null).setDriveGaugeLevel(player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveGaugeLevel()+1);
            player.getCapability(ModCapabilities.DRIVE_STATE, null).setDP(player.getCapability(ModCapabilities.DRIVE_STATE, null).getMaxDP());
            PacketDispatcher.sendTo(new SyncDriveData(player.getCapability(ModCapabilities.DRIVE_STATE, null)), (EntityPlayerMP) player);

            TextComponentTranslation driMessage = new TextComponentTranslation(Strings.Chat_DriveBoost, new TextComponentTranslation(""+player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveGaugeLevel()));
            driMessage.getStyle().setColor(TextFormatting.GREEN);
            player.sendMessage(driMessage);
        }

        PacketDispatcher.sendTo(new SyncDriveData(player.getCapability(ModCapabilities.DRIVE_STATE, null)), (EntityPlayerMP) player);
        player.getCapability(ModCapabilities.DRIVE_STATE, null).setDriveLevel(form, levels);
        for (int i = 0; i < InventoryDriveForms.INV_SIZE; i++) {
            if (!ItemStack.areItemStacksEqual(player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().getStackInSlot(i), ItemStack.EMPTY)) {
                if (ItemStack.areItemStacksEqual(player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().getStackInSlot(i), player.getHeldItem(EnumHand.MAIN_HAND))) {
                    hasDriveInSlot = i;
                }
            } else {
                nullSlot = i;
                break;
            }
        }

        if (hasDriveInSlot == -1) {
            player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().setStackInSlot(nullSlot, player.getHeldItem(EnumHand.MAIN_HAND));
            System.out.println(player.getHeldItemMainhand());
            if(player.getHeldItemMainhand().getItem() instanceof ItemDriveForm) {
                String form = ((ItemDriveForm) player.getHeldItemMainhand().getItem()).getDriveFormName();
                //System.out.println(form+"\n"+player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveLevel(form));
                if(player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveLevel(form) == 0) {
                    player.getCapability(ModCapabilities.DRIVE_STATE, null).setDriveLevel(form, 1);
                }
            }
            player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);

            TextComponentTranslation learnMessage = new TextComponentTranslation(Strings.Chat_Drive_Learn, new TextComponentTranslation(this.form));
            learnMessage.getStyle().setColor(TextFormatting.YELLOW);
            player.sendMessage(learnMessage);
        } else {
            TextComponentTranslation errorMessage = new TextComponentTranslation(Strings.Chat_Drive_Error, new TextComponentTranslation(this.form));
            errorMessage.getStyle().setColor(TextFormatting.YELLOW);
            player.sendMessage(errorMessage);
        }
        PacketDispatcher.sendTo(new SyncDriveInventory(player.getCapability(ModCapabilities.DRIVE_STATE, null)), (EntityPlayerMP) player);
        PacketDispatcher.sendTo(new SyncDriveData(player.getCapability(ModCapabilities.DRIVE_STATE, null)), (EntityPlayerMP) player);
    }
}
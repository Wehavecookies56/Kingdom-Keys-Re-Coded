package uk.co.wehavecookies56.kk.common.driveform;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;
import uk.co.wehavecookies56.kk.api.driveforms.DriveForm;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;
import uk.co.wehavecookies56.kk.common.network.packet.server.DriveFormPacket;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class DriveFormAnti extends DriveForm {
    double cost;

    public DriveFormAnti (double cost) {
        this.cost = cost;
    }

    @Override
    public String getName () {
        return Strings.Form_Anti;
    }

    @Override
    public ResourceLocation getTexture () {
        return new ResourceLocation(Reference.MODID, "textures/driveform/anti.png");
    }

    @Override
    public boolean hasOffHand() {
        return false;
    }

    @Override
    public int getKeychainSlot() {
        return 0;
    }

    @Override
    public double getCost () {
        return cost;
    }

    @Override
    public void initDrive (EntityPlayer player) {
        super.initDrive(player);
        if (player.getCapability(ModCapabilities.DRIVE_STATE, null).getActiveDriveName().equals(getName()))
            player.sendMessage(new TextComponentTranslation(TextFormatting.BLACK + "Anti form activated"));
    }

    @Override
    public void update (EntityPlayer player) {
        if (!player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()){
            if (player.getCapability(ModCapabilities.DRIVE_STATE, null).getFP() > 0) {
                player.getCapability(ModCapabilities.DRIVE_STATE, null).remFP(0.1);
                if (player.getCapability(ModCapabilities.DRIVE_STATE, null).getFP() < 0) {
                    player.getCapability(ModCapabilities.DRIVE_STATE, null).setFP(0);
                    endDrive(player);
                    if (player.world.isRemote) {
                        PacketDispatcher.sendToServer(new DriveFormPacket(getName(), true));
                    }
                }
            }else{
            	System.out.println(FMLCommonHandler.instance().getEffectiveSide());
                endDrive(player);
                
            }
        }
    }

    @Override
    public void endDrive (EntityPlayer player) {
    	player.getCapability(ModCapabilities.DRIVE_STATE, null).setFP(0);
        player.getCapability(ModCapabilities.DRIVE_STATE, null).remDP(getCost());
        if (player.getCapability(ModCapabilities.DRIVE_STATE, null).getDP() < 0) {
            player.getCapability(ModCapabilities.DRIVE_STATE, null).setDP(0);
        }
        player.getCapability(ModCapabilities.DRIVE_STATE, null).setInDrive(false);
        player.getCapability(ModCapabilities.DRIVE_STATE, null).setActiveDriveName("none");
        
        player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).setActiveSlot(-1);
        if (!player.world.isRemote)
            PacketDispatcher.sendTo(new SyncDriveData(player.getCapability(ModCapabilities.DRIVE_STATE, null)), (EntityPlayerMP) player);
    }

	@Override
	public int[] getExpCosts() {
		return new int[] {};
	}

}

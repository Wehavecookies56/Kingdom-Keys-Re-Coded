package uk.co.wehavecookies56.kk.api.driveforms;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.FMLCommonHandler;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnDriveFormParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;
import uk.co.wehavecookies56.kk.common.network.packet.server.DriveFormPacket;
import uk.co.wehavecookies56.kk.common.util.Utils;

public abstract class DriveForm {

    public abstract String getName ();

    public abstract ResourceLocation getTexture ();

    public abstract double getCost ();

    public abstract boolean hasOffHand ();

    public abstract int getKeychainSlot ();
    
    public abstract int[] getExpCosts();

    public boolean summonKeyblades(EntityPlayer player) {
        if (hasOffHand()) {
            if (!ItemStack.areItemStacksEqual(player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain().getStackInSlot(0), ItemStack.EMPTY) && !ItemStack.areItemStacksEqual(player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain().getStackInSlot(1), ItemStack.EMPTY)) {
                if (ItemStack.areItemStacksEqual(player.getHeldItemMainhand(), ItemStack.EMPTY) && ItemStack.areItemStacksEqual(player.getHeldItemOffhand(), ItemStack.EMPTY)) {
                    Utils.summonWeapon(player, EnumHand.MAIN_HAND, 0);
                    Utils.summonWeapon(player, EnumHand.OFF_HAND, getKeychainSlot());
                    if (player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).activeSlot() == -1) {
                        player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).setActiveSlot(player.inventory.currentItem);
                    }
                    return true;
                } else {
                    player.sendMessage(new TextComponentTranslation("Main hand and off hand slot must both be empty to activate form"));
                }
            } else {
                player.sendMessage(new TextComponentTranslation("Required keychains are missing"));
            }
            return false;
        } else {
            if (!ItemStack.areItemStacksEqual(player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain().getStackInSlot(0), ItemStack.EMPTY)) {
                if (ItemStack.areItemStacksEqual(player.getHeldItemMainhand(), ItemStack.EMPTY) && ItemStack.areItemStacksEqual(player.getHeldItemOffhand(), ItemStack.EMPTY)) {
                    Utils.summonWeapon(player, EnumHand.MAIN_HAND, 0);
                    if (player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).activeSlot() == -1) {
                        player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).setActiveSlot(player.inventory.currentItem);
                    }
                    return true;
                } else {
                    player.sendMessage(new TextComponentTranslation("Main hand and off hand slot must both be empty to activate form"));
                }
            } else {
                player.sendMessage(new TextComponentTranslation("Required keychains are missing"));
            }
            return false;
        }
    }

    public void initDrive (EntityPlayer player) {
    	String form = getName();
    	System.out.println(form);
        if(!form.equals(Strings.Form_Anti)) {
	    	if (!summonKeyblades(player)) {
	            player.world.playSound(player, player.getPosition(), ModSounds.error, SoundCategory.MASTER, 1.0f, 1.0f);
	            return;
	        }
        }
        player.getCapability(ModCapabilities.DRIVE_STATE, null).setActiveDriveName(getName());
        player.getCapability(ModCapabilities.DRIVE_STATE, null).setInDrive(true);
        player.getCapability(ModCapabilities.DRIVE_STATE, null).setFP(player.getCapability(ModCapabilities.DRIVE_STATE, null).getFormGaugeLevel(getName()) * 100);
        PacketDispatcher.sendTo(new SyncDriveData(player.getCapability(ModCapabilities.DRIVE_STATE, null)), (EntityPlayerMP) player);
        PacketDispatcher.sendToAllAround(new SpawnDriveFormParticles(player), player, 64.0D);
        player.world.playSound((EntityPlayer)null, player.getPosition(), ModSounds.drive, SoundCategory.MASTER, 1.0f, 1.0f);
    }

    public void update (EntityPlayer player) {
        if (player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).activeSlot() == -1) {
            player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).setActiveSlot(player.inventory.currentItem);
        }
        if (player.world.isRemote) {
            GuiScreen currScreen = Minecraft.getMinecraft().currentScreen;
            if (currScreen instanceof GuiContainer) {
                Minecraft.getMinecraft().displayGuiScreen(null);
                player.sendMessage(new TextComponentTranslation("Cannot open containers while drive form is active"));
            }
        }
        if (player.inventory.currentItem != player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).activeSlot())
            player.inventory.currentItem = player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).activeSlot();
      
        if (ItemStack.areItemStacksEqual(player.inventory.getItemStack(), new ItemStack(((ItemKeychain)player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain().getStackInSlot(0).getItem()).getKeyblade()))) {
            player.inventory.setItemStack(ItemStack.EMPTY);
            player.inventory.setInventorySlotContents(player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).activeSlot(), new ItemStack(((ItemKeychain)player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain().getStackInSlot(0).getItem()).getKeyblade()));
        }
        if (hasOffHand() && ItemStack.areItemStacksEqual(player.inventory.getItemStack(), new ItemStack(((ItemKeychain)player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain().getStackInSlot(getKeychainSlot()).getItem()).getKeyblade()))) {
            player.inventory.setItemStack(ItemStack.EMPTY);
            player.inventory.offHandInventory.set(0, new ItemStack(((ItemKeychain)player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain().getStackInSlot(1).getItem()).getKeyblade()));
        }
        if (ItemStack.areItemStacksEqual(player.inventory.getStackInSlot(player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).activeSlot()), ItemStack.EMPTY)) {
            player.inventory.setInventorySlotContents(player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).activeSlot(), new ItemStack(((ItemKeychain)player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain().getStackInSlot(0).getItem()).getKeyblade()));
        }
        if (hasOffHand() &&ItemStack.areItemStacksEqual(player.inventory.offHandInventory.get(0), ItemStack.EMPTY)) {
            player.inventory.offHandInventory.set(0, new ItemStack(((ItemKeychain)player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain().getStackInSlot(1).getItem()).getKeyblade()));
        }
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
                Utils.summonWeapon(player, EnumHand.MAIN_HAND, 0);
                if(hasOffHand())
                    Utils.summonWeapon(player, EnumHand.OFF_HAND, getKeychainSlot());
                player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                player.inventory.offHandInventory.set(0, ItemStack.EMPTY);
            }
        }
    }

    public void endDrive (EntityPlayer player) {
        player.getCapability(ModCapabilities.DRIVE_STATE, null).setFP(0);
        player.getCapability(ModCapabilities.DRIVE_STATE, null).remDP(getCost());
        if (player.getCapability(ModCapabilities.DRIVE_STATE, null).getDP() < 0) {
            player.getCapability(ModCapabilities.DRIVE_STATE, null).setDP(0);
        }
        player.getCapability(ModCapabilities.DRIVE_STATE, null).setInDrive(false);
        player.getCapability(ModCapabilities.DRIVE_STATE, null).setActiveDriveName("none");
        Utils.summonWeapon(player, EnumHand.MAIN_HAND, 0);
        if (hasOffHand())
            Utils.summonWeapon(player, EnumHand.OFF_HAND, getKeychainSlot());
        player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
        player.inventory.offHandInventory.set(0, ItemStack.EMPTY);
        player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).setActiveSlot(-1);
        if (!player.world.isRemote)
            PacketDispatcher.sendTo(new SyncDriveData(player.getCapability(ModCapabilities.DRIVE_STATE, null)), (EntityPlayerMP) player);

    }

}

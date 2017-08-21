package uk.co.wehavecookies56.kk.api.driveforms;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemDriveForm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriveFormRegistry {

    private static Map<String, DriveForm> driveFormMap = new HashMap<String, DriveForm>();

    public static Map<String, DriveForm> getDriveFormMap () {
        return ImmutableMap.copyOf(driveFormMap);
    }

    public static boolean registerDriveForm (DriveForm driveForm) {
        if (isDriveFormRegistered(driveForm.getName())) return false;
        driveFormMap.put(driveForm.getName(), driveForm);
        return true;
    }

    public static boolean isDriveFormRegistered (DriveForm driveForm) {
        return isDriveFormRegistered(driveForm.getName());
    }

    public static boolean isDriveFormRegistered (String name) {
        return driveFormMap.containsKey(name);
    }

    public static DriveForm get (String name) {
        return driveFormMap.get(name);
    }

    public static boolean learnDriveForm (EntityPlayer player, String name) {
        if (player != null && !isDriveFormKnown(player, name)) {
            DriveForm driveForm = driveFormMap.get(name);
            player.getCapability(ModCapabilities.DRIVE_STATE, null).learnDriveForm(driveForm);
            return true;
        }
        return false;
    }

    public static boolean isDriveFormKnown (EntityPlayer player, String name) {
        List<String> driveCommands = new ArrayList<String>();
        driveCommands.clear();
        for (int i = 0; i < Minecraft.getMinecraft().player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().getSlots(); i++)
            if (!ItemStack.areItemStacksEqual(Minecraft.getMinecraft().player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().getStackInSlot(i), ItemStack.EMPTY)) driveCommands.add(((ItemDriveForm) Minecraft.getMinecraft().player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().getStackInSlot(i).getItem()).getDriveFormName());
        return driveCommands.contains(name);
    }

}

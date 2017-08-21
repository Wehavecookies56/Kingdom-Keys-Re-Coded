package uk.co.wehavecookies56.kk.common.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.OrganizationXIIICapability;
import uk.co.wehavecookies56.kk.common.capability.SummonKeybladeCapability;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.item.base.ItemRealKeyblade;
import uk.co.wehavecookies56.kk.common.item.org.IOrgWeapon;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.DeSummonKeyblade;
import uk.co.wehavecookies56.kk.common.network.packet.server.DeSummonOrgWeapon;
import uk.co.wehavecookies56.kk.common.network.packet.server.SummonKeyblade;
import uk.co.wehavecookies56.kk.common.network.packet.server.SummonOrgWeapon;

/**
 * Created by Toby on 19/07/2016.
 */
public class Utils {

    /**
     * Method for generating random integer between the 2 parameters, The order of
     * min and max do not matter.
     *
     * @param min minimum value that the random integer can be
     * @param max maximum value that the random integer can be
     * @return a random integer
     */
    public static int randomWithRange (int min, int max) {
        int range = Math.abs(max - min) + 1;
        return (int) (Math.random() * range) + (min <= max ? min : max);
    }

    /**
     * Method for generating random doubles between the 2 parameters, The order of
     * min and max do not matter.
     *
     * @param min minimum value that the random double can be
     * @param max maximum value that the random double can be
     * @return a random double
     */
    public static double randomWithRange (double min, double max) {
        double range = Math.abs(max - min);
        return (Math.random() * range) + (min <= max ? min : max);
    }

    /**
     * Method for generating random floats between the 2 parameters, The order of
     * min and max do not matter.
     *
     * @param min minimum value that the random float can be
     * @param max maximum value that the random float can be
     * @return a random float
     */
    public static float randomWithRange (float min, float max) {
        float range = Math.abs(max - min) + 1;
        return (float) (Math.random() * range) + (min <= max ? min : max);
    }

    /**
     * Replacement for {@link net.minecraft.util.text.translation.I18n#translateToLocalFormatted(String, Object...)}
     * @param name the unlocalized string to translate
     * @param format the format of the string
     * @return the translated string
     */
    public static String translateToLocalFormatted(String name, Object... format) {
        TextComponentTranslation translation = new TextComponentTranslation(name, format);
        return translation.getFormattedText();
    }

    /**
     * Replacement for {@link net.minecraft.util.text.translation.I18n#translateToLocal(String)}
     * @param name the unlocalized string to translate
     * @return the translated string
     */
    public static String translateToLocal(String name) {
        TextComponentTranslation translation = new TextComponentTranslation(name);
        return translation.getFormattedText();
    }

    public static boolean summonWeapon(EntityPlayer player, EnumHand hand, int keychainSlot) {
        SummonKeybladeCapability.ISummonKeyblade summonCap = player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null);
        OrganizationXIIICapability.IOrganizationXIII organizationXIIICap = player.getCapability(ModCapabilities.ORGANIZATION_XIII, null);

        if (organizationXIIICap.getMember() == Utils.OrgMember.NONE) {
            if (ItemStack.areItemStacksEqual(summonCap.getInventoryKeychain().getStackInSlot(keychainSlot), ItemStack.EMPTY)) {
                player.sendMessage(new TextComponentTranslation(TextFormatting.RED + "Missing keychain to summon"));
                return false;
            }
            if (!summonCap.getIsKeybladeSummoned(hand) && ItemStack.areItemStacksEqual(player.getHeldItem(hand), ItemStack.EMPTY) && summonCap.getInventoryKeychain().getStackInSlot(0).getItem() instanceof ItemKeychain) {
                summonCap.setActiveSlot(player.inventory.currentItem);
                if (player.world.isRemote)
                    PacketDispatcher.sendToServer(new SummonKeyblade(hand, keychainSlot));
                return true;
            } else if (!ItemStack.areItemStacksEqual(player.getHeldItem(hand), ItemStack.EMPTY) && player.getHeldItem(hand).getItem() instanceof ItemRealKeyblade && summonCap.getIsKeybladeSummoned(hand)) {
                if (player.world.isRemote)
                    PacketDispatcher.sendToServer(new DeSummonKeyblade(hand));
                player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                player.inventory.offHandInventory.set(0, ItemStack.EMPTY);
                return true;
            } else {
                return false;
            }
        } else {
            if (!organizationXIIICap.summonedWeapon(hand) && ItemStack.areItemStacksEqual(player.getHeldItem(hand), ItemStack.EMPTY)) {
                if (player.world.isRemote)
                    PacketDispatcher.sendToServer(new SummonOrgWeapon(hand, organizationXIIICap.currentWeapon()));
                if (hand == EnumHand.MAIN_HAND)
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(organizationXIIICap.currentWeapon()));
                else
                    player.inventory.offHandInventory.set(0, new ItemStack(organizationXIIICap.currentWeapon()));
                organizationXIIICap.setWeaponSummoned(hand, true);
                return true;
            } else if (!ItemStack.areItemStacksEqual(player.getHeldItem(hand), ItemStack.EMPTY) && player.getHeldItem(hand).getItem() instanceof IOrgWeapon || (organizationXIIICap.getMember() == Utils.OrgMember.ROXAS && !ItemStack.areItemStacksEqual(player.getHeldItem(hand), ItemStack.EMPTY) && player.getHeldItem(hand).getItem() instanceof ItemKeyblade)) {
                if (player.world.isRemote) {
                    PacketDispatcher.sendToServer(new DeSummonOrgWeapon(hand));
                }
                organizationXIIICap.setWeaponSummoned(hand, false);
                if (hand == EnumHand.MAIN_HAND)
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                else
                    player.inventory.offHandInventory.set(0, ItemStack.EMPTY);
                return true;
            } else {
                return false;
            }
        }
    }

    public static enum OrgMember { XEMNAS, XIGBAR, XALDIN, VEXEN, LEXAEUS, ZEXION, SAIX, AXEL, DEMYX, LUXORD, MARLUXIA, LARXENE, ROXAS, NONE}

}

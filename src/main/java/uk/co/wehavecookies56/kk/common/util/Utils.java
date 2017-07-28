package uk.co.wehavecookies56.kk.common.util;

import net.minecraft.util.text.TextComponentTranslation;

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

    public static enum OrgMember { XEMNAS, XIGBAR, XALDIN, VEXEN, LEXAEUS, ZEXION, SAIX, AXEL, DEMYX, LUXORD, MARLUXIA, LARXENE, ROXAS, NONE}

}

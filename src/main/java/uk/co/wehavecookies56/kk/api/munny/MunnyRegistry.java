package uk.co.wehavecookies56.kk.api.munny;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Toby on 19/07/2016.
 */
public class MunnyRegistry {

    public static Map<ItemStack, Integer> munnyValues = new HashMap<ItemStack, Integer>();

    public static Logger apiLogger = LogManager.getFormatterLogger("kkMunnyAPI");

    static {
        ItemStack orichalcum = new ItemStack(ModItems.SynthesisMaterial);
        orichalcum.setTagCompound(new NBTTagCompound());
        orichalcum.getTagCompound().setString("material", "sm.orichalcum");
        orichalcum.getTagCompound().setString("rank", "sm.rank.a");

        addMunnyValueFromOreDict("ingotIron", 1000);
        addMunnyValue(new ItemStack(Blocks.DIRT), 1);
        addMunnyValue(orichalcum, 10000);
    }

    public static boolean addMunnyValue(ItemStack item, int value) {
        if (!munnyValues.containsKey(item)) {
            munnyValues.put(item, value);
            apiLogger.log(Level.INFO, "Registered %s munny value.", item.getDisplayName());
            return true;
        } else {
            apiLogger.log(Level.WARN, "Item %s has already had a munny value registered.", item.getDisplayName());
            return false;
        }
    }

    public static boolean addMunnyValueFromOreDict(String name, int value) {
        List<ItemStack> oreStacks = OreDictionary.getOres(name);
        if (oreStacks.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < oreStacks.size(); i++) {
                if (!munnyValues.containsKey(oreStacks.get(i))) {
                    munnyValues.put(oreStacks.get(i), value);
                    apiLogger.log(Level.INFO, "Registered %s munny value.", oreStacks.get(i).getDisplayName());
                } else {
                    apiLogger.log(Level.WARN, "Item %s has already had a munny value registered.", oreStacks.get(i).getDisplayName());
                    return false;
                }
            }
            return true;
        }
    }

}

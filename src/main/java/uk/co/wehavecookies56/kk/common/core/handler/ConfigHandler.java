package uk.co.wehavecookies56.kk.common.core.handler;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class ConfigHandler {

    public static Configuration config;

    public void init(File file, ConfigHandler handler) {
        config = new Configuration(file);
        config.load();
        handler.load();

        MinecraftForge.EVENT_BUS.register(handler);
    }

    final String WORLDGEN = propertyCategory("worldgen", Configuration.CATEGORY_GENERAL);
    final String SPAWNING = propertyCategory("spawning", Configuration.CATEGORY_GENERAL);
    final String NETWORK = propertyCategory("network", Configuration.CATEGORY_GENERAL);
    final String INTERFACE = propertyCategory("interface", Configuration.CATEGORY_CLIENT);
    final String SOUND = propertyCategory("sound", Configuration.CATEGORY_CLIENT);
    final String ITEMS = propertyCategory("items", Configuration.CATEGORY_GENERAL);
    final String TOOLMATERIALS = propertyCategory("toolmaterials", ITEMS);

    public void load() {
        if (config.hasChanged())
            config.save();
    }

    public boolean configProperty(String name, String description, boolean defaultValue, String category) {
        Property property = config.get(category, name, defaultValue);
        property.setComment(description);
        return property.getBoolean(defaultValue);
    }

    public int configProperty(String name, String description, int defaultValue, String category) {
        Property property = config.get(category, name, defaultValue);
        property.setComment(description);
        return property.getInt(defaultValue);
    }

    public double configProperty(String name, String description, double defaultValue, String category) {
        Property property = config.get(category, name, defaultValue);
        property.setComment(description);
        return property.getDouble(defaultValue);
    }

    public String configProperty(String name, String description, String defaultValue, String category) {
        Property property = config.get(category, name, defaultValue);
        property.setComment(description);
        return property.getString();
    }

    public Property configProperty(String name, String description, int[] defaultValue, String category) {
        Property property = config.get(category, name, defaultValue);
        property.setComment(description);
        return property;
    }

    public Property configBooleanProperty(String name, String description, boolean defaultValue, String category) {
        Property property = config.get(category, name, defaultValue);
        property.setComment(description);
        return property;
    }

    public String propertyCategory(String name, String parent) {
        return parent + Configuration.CATEGORY_SPLITTER + name;
    }

    // Sync config when changed
    @SubscribeEvent
    public void OnConfigChanged (ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Reference.MODID)) load();
    }
}

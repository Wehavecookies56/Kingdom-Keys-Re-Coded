package uk.co.wehavecookies56.kk.common.core.handler;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class ConfigHandler {

	public static Configuration config;

	public static String[] items;

	public static boolean
			EnableWorldGen = true,
			EnableUpdateCheck = true,
			EnableHeartsOnHUD = false,
			EnableCustomMusic = true,
			ForceEnableCustomMusic = false,
			DisableVanillaTooltip = true,
			EnableStationOfAwakening = true;
	;

	public static int[] interfaceColour = new int[] { 255, 0, 0 };
	
	public static int guiAlpha = 255;
	
	public static double damageMultiplier = 1;
	
	public static boolean chat = true;
	
	public static Property interfaceColourProperty, EnableHeartsOnHUDProperty, EnableCustomMusicProperty;

	public static void init(File file) {
		config = new Configuration(file);
		config.load();
		load();

		MinecraftForge.EVENT_BUS.register(new ConfigHandler());
	}

	public static void load() {

		final String WORLDGEN = propertyCategory("worldgen", Configuration.CATEGORY_GENERAL);
		final String NETWORK = propertyCategory("network", Configuration.CATEGORY_GENERAL);
		final String INTERFACE = propertyCategory("interface", Configuration.CATEGORY_CLIENT);
		final String SOUND = propertyCategory("sound", Configuration.CATEGORY_CLIENT);
		final String ITEMS = propertyCategory("items", Configuration.CATEGORY_GENERAL);
		final String TOOLMATERIALS = propertyCategory("toolmaterials", ITEMS);

		//WORLDGEN
		EnableWorldGen = configProperty("Enable World Gen", "Toggles all world generation performed by this mod", EnableWorldGen, WORLDGEN);
		EnableStationOfAwakening = configProperty("Enable Station of Awakening", "Toggles whether the Station of Awakening should be enabled", EnableStationOfAwakening, WORLDGEN);

		//NETWORK
		EnableUpdateCheck = configProperty("Enable Update Checking", "Toggles whether the update checker checks for updates", EnableUpdateCheck, NETWORK);

		//INTERFACE
		guiAlpha = configProperty("Gui Alpha (W.I.P.)", "Sets the Command Menu and Bars opacity (0-255)", guiAlpha, INTERFACE);
		chat = configProperty("Enable Custom Chat", "It makes the chat have custom colors for KK helpers", chat, INTERFACE);
		EnableHeartsOnHUDProperty = configBooleanProperty("Enable hearts on HUD", "Toggles rendering of hearts on the HUD", EnableHeartsOnHUD, INTERFACE);
		EnableHeartsOnHUD = EnableHeartsOnHUDProperty.getBoolean();

		interfaceColourProperty = configProperty("Interface colour", "Set the colour of the interface with RGB values", interfaceColour, INTERFACE);
		interfaceColour = interfaceColourProperty.getIntList();

		//SOUND
		EnableCustomMusicProperty = configBooleanProperty("Enable custom music", "Toggles the custom music that plays, requires the music resource pack", EnableCustomMusic, SOUND);
		EnableCustomMusic = EnableCustomMusicProperty.getBoolean();
		ForceEnableCustomMusic = configProperty("Force Enable custom music", "Force toggles the custom music that plays regardless of whether the resource pack is loaded", ForceEnableCustomMusic, SOUND);

		//ITEMS
		DisableVanillaTooltip = configProperty("Disable Vanilla Tooltips", "Disables the vanilla tooltip information for keyblades", DisableVanillaTooltip, INTERFACE);
		damageMultiplier = configProperty("Keyblade damage multiplier", "Keyblade Strength and Magic will be multiplied by the amount (can be decimal)", damageMultiplier, ITEMS);
		if (config.hasChanged()) config.save();
	}

	private static boolean configProperty(String name, String description, boolean defaultValue, String category) {
		Property property = config.get(category, name, defaultValue);
		property.setComment(description);
		return property.getBoolean(defaultValue);
	}

	public static int configProperty(String name, String description, int defaultValue, String category) {
		Property property = config.get(category, name, defaultValue);
		property.setComment(description);
		return property.getInt(defaultValue);
	}

	public static double configProperty(String name, String description, double defaultValue, String category) {
		Property property = config.get(category, name, defaultValue);
		property.setComment(description);
		return property.getDouble(defaultValue);
	}

	public static String configProperty(String name, String description, String defaultValue, String category) {
		Property property = config.get(category, name, defaultValue);
		property.setComment(description);
		return property.getString();
	}

	public static Property configProperty(String name, String description, int[] defaultValue, String category) {
		Property property = config.get(category, name, defaultValue);
		property.setComment(description);
		return property;
	}

	public static Property configBooleanProperty(String name, String description, boolean defaultValue, String category) {
		Property property = config.get(category, name, defaultValue);
		property.setComment(description);
		return property;
	}

	public static String propertyCategory(String name, String parent) {
		return parent + Configuration.CATEGORY_SPLITTER + name;
	}

	// Sync config when changed
	@SubscribeEvent
	public void OnConfigChanged (ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(Reference.MODID)) load();
	}
}

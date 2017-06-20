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

	public static String[] items;

	public static boolean
			EnableWorldGen = true,
			EnableUpdateCheck = true,
			EnableHeartsOnHUD = false,
			EnableCustomMusic = true,
			ForceEnableCustomMusic = false,
			DisableVanillaTooltip = true,
			EnableStationOfAwakening = true,
			chat = true
	;

	public static int[] interfaceColour = new int[] { 255, 0, 0 };
	
	public static int
			guiAlpha = 255,
			shadowRatio=15,
			gigaShadowRatio=5,
			redNocturneRatio=10,
			blueRhapsodyRatio=10,
			yellowOperaRatio=10,
			greenRequiemRatio=10,
			AlwaysShowGUI = 2
			;
	
	public static double damageMultiplier = 1.0;
	
	public static String StationOfAwakeningID = "auto";
	
	public static Property interfaceColourProperty, EnableHeartsOnHUDProperty, EnableCustomMusicProperty, AlwaysShowGUIProperty;

	public static void init(File file) {
		config = new Configuration(file);
		config.load();
		load();

		MinecraftForge.EVENT_BUS.register(new ConfigHandler());
	}

	public static void load() {

		final String WORLDGEN = propertyCategory("worldgen", Configuration.CATEGORY_GENERAL);
		final String SPAWNING = propertyCategory("spawning", Configuration.CATEGORY_GENERAL);
		final String NETWORK = propertyCategory("network", Configuration.CATEGORY_GENERAL);
		final String INTERFACE = propertyCategory("interface", Configuration.CATEGORY_CLIENT);
		final String SOUND = propertyCategory("sound", Configuration.CATEGORY_CLIENT);
		final String ITEMS = propertyCategory("items", Configuration.CATEGORY_GENERAL);
		final String TOOLMATERIALS = propertyCategory("toolmaterials", ITEMS);

		//WORLDGEN
		EnableWorldGen = configProperty("Enable World Gen", "Toggles all world generation performed by this mod", EnableWorldGen, WORLDGEN);
		EnableStationOfAwakening = configProperty("Enable Station of Awakening", "Toggles whether the Station of Awakening should be enabled", EnableStationOfAwakening, WORLDGEN);
		StationOfAwakeningID = configProperty("Station of Awakening ID", "Sets Station of Awakening's ID (default \"auto\")", StationOfAwakeningID, WORLDGEN);

		//SPAWNING
		shadowRatio = configProperty("Shadow spawning ratio", "Sets Shadow heartless spawning ratio", shadowRatio, SPAWNING);
		gigaShadowRatio = configProperty("GigaShadow spawning ratio", "Sets Giga Shadow heartless spawning ratio", gigaShadowRatio, SPAWNING);
		redNocturneRatio = configProperty("Red Necturne spawning ratio", "Sets Red Nocturne heartless spawning ratio", redNocturneRatio, SPAWNING);
		blueRhapsodyRatio = configProperty("Blue Rhapsody spawning ratio", "Sets Blue Rhapsody heartless spawning ratio", blueRhapsodyRatio, SPAWNING);
		yellowOperaRatio = configProperty("Yellow Opera spawning ratio", "Sets Yellow Opera heartless spawning ratio", yellowOperaRatio, SPAWNING);
		greenRequiemRatio = configProperty("Green Requiem spawning ratio", "Sets Green Requiem heartless spawning ratio", greenRequiemRatio, SPAWNING);
		
		//NETWORK
		EnableUpdateCheck = configProperty("Enable Update Checking", "Toggles whether the update checker checks for updates", EnableUpdateCheck, NETWORK);

		//INTERFACE
		guiAlpha = configProperty("Gui Alpha (W.I.P.)", "Sets the Command Menu and Bars opacity (0-255)", guiAlpha, INTERFACE);
		chat = configProperty("Enable Custom Chat", "It makes the chat have custom colors for KK helpers", chat, INTERFACE);
		EnableHeartsOnHUDProperty = configBooleanProperty("Enable hearts on HUD", "Toggles rendering of hearts on the HUD", EnableHeartsOnHUD, INTERFACE);
		EnableHeartsOnHUD = EnableHeartsOnHUDProperty.getBoolean();

		interfaceColourProperty = configProperty("Interface colour", "Set the colour of the interface with RGB values", interfaceColour, INTERFACE);
		interfaceColour = interfaceColourProperty.getIntList();

		AlwaysShowGUIProperty = config.get(INTERFACE, "Always show GUI", AlwaysShowGUI);
		AlwaysShowGUIProperty.setComment("Always show the GUI overlay mode (2 = always on, 1 = on with keyblade, 0 = off)");
		AlwaysShowGUI = AlwaysShowGUIProperty.getInt();

		//SOUND
		EnableCustomMusicProperty = configBooleanProperty("Enable custom music", "Toggles the custom music that plays, requires the music resource pack", EnableCustomMusic, SOUND);
		EnableCustomMusic = EnableCustomMusicProperty.getBoolean();
		ForceEnableCustomMusic = configProperty("Force Enable custom music", "Force toggles the custom music that plays regardless of whether the resource pack is loaded", ForceEnableCustomMusic, SOUND);

		//ITEMS
		DisableVanillaTooltip = configProperty("Disable Vanilla Tooltips", "Disables the vanilla tooltip information for keyblades", DisableVanillaTooltip, INTERFACE);
		damageMultiplier = configProperty("Keyblade damage multiplier", "Keyblade Strength and Magic will be multiplied by the amount (can be decimal)", damageMultiplier, ITEMS);
		
		if (config.hasChanged())
			config.save();
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
	
	public static void toggleShowGUI () {
		AlwaysShowGUI += 1;
		if (AlwaysShowGUI > 2)
			AlwaysShowGUI = 0;
		AlwaysShowGUIProperty.set(AlwaysShowGUI);
		config.save();
	}
	
	@SideOnly(Side.CLIENT)
	public static boolean displayGUI () {
		if (AlwaysShowGUI == 0)
			return false;
		Minecraft mc = Minecraft.getMinecraft();
		return ((AlwaysShowGUI == 2) || ((mc.player.getHeldItemMainhand() != ItemStack.EMPTY) && ((mc.player.getHeldItemMainhand().getItem() instanceof ItemKeyblade) || mc.player.getHeldItemMainhand().getItem() instanceof ItemOrgWeapon)));
	}
}

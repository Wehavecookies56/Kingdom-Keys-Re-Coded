package uk.co.wehavecookies56.kk.common.core.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.item.org.IOrgWeapon;
import uk.co.wehavecookies56.kk.common.lib.Reference;

/**
 * Created by Toby on 16/07/2017.
 */
@Config(modid = Reference.MODID, name = Reference.MODID + "/MainConfig")
@Config.LangKey("kk.mainconfig.title")
public class MainConfig {

	public static Worldgen worldgen = new Worldgen();
	public static Network network = new Network();
	public static Items items = new Items();
	public static Entities entities = new Entities();

	public static class Worldgen {

		@Config.Name("Enable World Gen")
		@Config.Comment("Toggles all world generation performed by this mod")
		public boolean EnableWorldGen = true;

		@Config.Name("Enable Station of Awakening")
		@Config.Comment("Toggles whether the Station of Awakening should be enabled")
		public boolean EnableStationOfAwakening = true;

		@Config.Name("Station of Awakening ID")
		@Config.Comment("Sets Station of Awakening's ID (default \"auto\")")
		public String StationOfAwakeningID = "auto";

		@Config.Name("Enable Synthesis Materials Ores")
		@Config.Comment("Enables the ores that drop synthesis materials which are now replaced by mob drops")
		public boolean EnableSynthesisOres = false;

	}

	public static class Network {

	}

	public static class Items {

		@Config.Name("Disable Vanilla Keyblade Tooltips")
		@Config.Comment("Disables the vanilla tooltip information for keyblades")
		public boolean DisableVanillaTooltip = true;

		@Config.Name("Keyblade damage multiplier")
		@Config.Comment("Keyblade Strength and Magic will be multiplied by the amount (can be decimal)")
		public double damageMultiplier = 1.0;

	}

	public static class Entities {
		@Config.Name("Disable mob drops")
		@Config.Comment("Disables all the items dropped from mobs added by KK (This includes: hearts, munny, hp, mp, dp, recipes)")
		public boolean disableDrops = false;

		@Config.Name("List of enabled mob drops")
		@Config.Comment("Remove an item from this list to disable it from dropping")
		public String[] dropsList = { "recipe", "darkheart", "heart", "pureheart", "kingdomhearts", "munny", "spellorb", "dporb", "hporb", "mporb" };

		

	}

	public static Client client = new Client();

	public static class Client {

		public HUD hud = new HUD();
		public Sound sound = new Sound();

		@Config.Name("Tutorials pop up")
		@Config.Comment("Should tutorials pop up when you unlock them? Might leave you vulnerable in servers.")
		public boolean tutorialsPopup = true;

		public class HUD {

			@Config.Name("Enable hearts on HUD")
			@Config.Comment("Toggles rendering of hearts on the HUD")
			public boolean EnableHeartsOnHUD = false;

			@Config.Name("Always show GUI")
			@Config.Comment("Always show the GUI overlay mode (2 = always on, 1 = on with keyblade, 0 = off)")
			public int AlwaysShowGUI = 2;

			@Config.Name("Enable Custom Chat")
			@Config.Comment("When enabled KK devs will have coloured names")
			public boolean chat = false;

			@Config.Name("Interface Colour")
			@Config.Comment("RGB Values for the interface can be changed within the config menu in game")
			public int[] interfaceColour = new int[] { 255, 0, 0 };

			@Config.Name("Gui Alpha (W.I.P.)")
			@Config.Comment("Sets the Command Menu and Bars opacity (0-255)")
			public int guiAlpha = 255;

		}

		public class Sound {

			@Config.Name("Enable custom music")
			@Config.Comment("CURRENTLY NOT IMPLEMENTED Toggles the custom music that plays, requires the music resource pack")
			public boolean EnableCustomMusic = true;

			@Config.Name("Force Enable custom music")
			@Config.Comment("CURRENTLY NOT IMPLEMENTED Force toggles the custom music that plays regardless of whether the resource pack is loaded")
			public boolean ForceEnableCustomMusic = false;

		}

	}

	public static void toggleShowGUI() {
		client.hud.AlwaysShowGUI += 1;
		if (client.hud.AlwaysShowGUI > 2)
			client.hud.AlwaysShowGUI = 0;
		ConfigManager.sync(Reference.MODID, Config.Type.INSTANCE);
	}

	@SideOnly(Side.CLIENT)
	public static boolean displayGUI() {
		if (client.hud.AlwaysShowGUI == 0)
			return false;
		Minecraft mc = Minecraft.getMinecraft();
		return ((client.hud.AlwaysShowGUI == 2) || ((!ItemStack.areItemStacksEqual(mc.player.getHeldItemMainhand(), ItemStack.EMPTY)) && ((mc.player.getHeldItemMainhand().getItem() instanceof ItemKeyblade) || mc.player.getHeldItemMainhand().getItem() instanceof IOrgWeapon)));
	}

	@Mod.EventBusSubscriber(modid = Reference.MODID)
	private static class Events {

		@SubscribeEvent
		public static void onConfigChanged(ConfigChangedEvent event) {
			if (event.getModID().equals(Reference.MODID)) {
				ConfigManager.sync(Reference.MODID, Config.Type.INSTANCE);
			}
		}

	}
}

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
@Config(modid = Reference.MODID, name = Reference.MODID + "/SpawningConfig")
@Config.LangKey("kk.spawningconfig.title")
public class SpawningConfig {

	public static Heartless heartless = new Heartless();
	public static Nobody nobodies = new Nobody();
	public static Others others = new Others();

	@Config.Name("Spawn heartless and nobodies at start")
	@Config.Comment("Enables spawning of heartless without requiring to defeat the Ender Dragon first")
	public static boolean startingHeartlessSpawn = false;

	@Config.RequiresMcRestart
	@Config.Name("Enable all heartless spawns")
	@Config.Comment("Toggle all heartless from spawning")
	public static boolean spawnHeartless = true;

	@Config.RequiresMcRestart
	@Config.Name("Enable all moogle spawns")
	@Config.Comment("Toggle all moogles from spawning")
	public static boolean spawnMoogles = true;

	@Config.RequiresMcRestart
	@Config.Name("Enable all nobody spawns")
	@Config.Comment("Toggle all nobodies from spawning")
	public static boolean spawnNobodies = true;

	public static class Heartless {

		@Config.RequiresMcRestart
		@Config.Name("Prevent Heartless spawning in biomes")
		@Config.Comment("Any biome in this list will prevent heartless to spawn in (with support for other mod biomes)")
		public String[] heartlessBiomeExclusion = {};

		// Pureblood
		@Config.RequiresMcRestart
		@Config.Name("Shadow spawning ratio")
		@Config.Comment("Sets Shadow heartless spawning ratio")
		public int shadowRatio = 30;

		@Config.RequiresMcRestart
		@Config.Name("Mega Shadow spawning ratio")
		@Config.Comment("Sets Mega Shadow heartless spawning ratio")
		public int megaShadowRatio = 5;

		@Config.RequiresMcRestart
		@Config.Name("Giga Shadow spawning ratio")
		@Config.Comment("Sets Giga Shadow heartless spawning ratio")
		public int gigaShadowRatio = 2;

		@Config.RequiresMcRestart
		@Config.Name("Darkball spawning ratio")
		@Config.Comment("Sets Darkball heartless spawning ratio")
		public int darkballRatio = 15;		
		
		// Emblem
		@Config.RequiresMcRestart
		@Config.Name("Red Nocturne spawning ratio")
		@Config.Comment("Sets Red Nocturne heartless spawning ratio")
		public int redNocturneRatio = 20;

		@Config.RequiresMcRestart
		@Config.Name("Blue Rhapsody spawning ratio")
		@Config.Comment("Sets Blue Rhapsody heartless spawning ratio")
		public int blueRhapsodyRatio = 20;

		@Config.RequiresMcRestart
		@Config.Name("Yellow Opera spawning ratio")
		@Config.Comment("Sets Yellow Opera heartless spawning ratio")
		public int yellowOperaRatio = 20;

		@Config.RequiresMcRestart
		@Config.Name("Green Requiem spawning ratio")
		@Config.Comment("Sets Green Requiem heartless spawning ratio")
		public int greenRequiemRatio = 20;

		@Config.RequiresMcRestart
		@Config.Name("Crimson Jazz spawning ratio")
		@Config.Comment("Sets Crimson Jazz heartless spawning ratio")
		public int crimsonJazzRatio = 5;

		@Config.RequiresMcRestart
		@Config.Name("Emerald Blues spawning ratio")
		@Config.Comment("Sets Emerald Blues heartless spawning ratio")
		public int emeraldBluesRatio = 5;

		@Config.RequiresMcRestart
		@Config.Name("Silver Rock spawning ratio")
		@Config.Comment("Sets Silver Rock heartless spawning ratio")
		public int silverRockRatio = 5;

		@Config.RequiresMcRestart
		@Config.Name("Minute Bomb spawning ratio")
		@Config.Comment("Sets Minute Bomb heartless spawning ratio")
		public int minuteBombRatio = 6;

		@Config.RequiresMcRestart
		@Config.Name("Skater Bomb spawning ratio")
		@Config.Comment("Sets Skater Bomb heartless spawning ratio")
		public int skaterBombRatio = 5;

		@Config.RequiresMcRestart
		@Config.Name("Storm Bomb spawning ratio")
		@Config.Comment("Sets Storm Bomb heartless spawning ratio")
		public int stormBombRatio = 3;

		@Config.RequiresMcRestart
		@Config.Name("Detonator spawning ratio")
		@Config.Comment("Sets Detonator heartless spawning ratio")
		public int detonatorRatio = 2;

		@Config.RequiresMcRestart
		@Config.Name("Dire Plant spawning ratio")
		@Config.Comment("Sets Dire Plant heartless spawning ratio")
		public int direPlantRatio = 10;
		
		@Config.RequiresMcRestart
		@Config.Name("Large Body spawning ratio")
		@Config.Comment("Sets Large Body heartless spawning ratio")
		public int largeBodyRatio = 15;
	}

	public static class Nobody {

		@Config.RequiresMcRestart
		@Config.Name("Prevent Nobodies spawning in biomes")
		@Config.Comment("Any biome in this list will prevent nobodies to spawn in (with support for other mod biomes)")
		public String[] nobodiesBiomeExclusion = {};

		@Config.RequiresMcRestart
		@Config.Name("Dusk spawning ratio")
		@Config.Comment("Sets Dusk nobody spawning ratio")
		public int dusktRatio = 3;
		
		@Config.RequiresMcRestart
		@Config.Name("Creeper spawning ratio")
		@Config.Comment("Sets Creeper nobody spawning ratio")
		public int creeperRatio = 40;
	}

	public static class Others {

		@Config.RequiresMcRestart
		@Config.Name("Prevent other mobs spawning in biomes")
		@Config.Comment("Any biome in this list will prevent other mobs like Moogles to spawn in (with support for other mod biomes)")
		public String[] othersBiomeExclusion = {};

		@Config.RequiresMcRestart
		@Config.Name("Moogle spawning ratio")
		@Config.Comment("Moogle spawning ratio")
		public int moogleRatio = 5;
	}
}

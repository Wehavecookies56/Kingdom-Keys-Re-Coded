package wehavecookies56.kk.util;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import wehavecookies56.kk.lib.Reference;

public class SoundHelper {

	public static void playSoundAtEntity(World world, Entity entity, String name, float volume, float pitch){
		world.playSoundAtEntity(entity, name, volume, pitch);
	}

	public static final String BASE = Reference.MODID+":";

	public static String
	Summon = BASE + "summon",
	UnSummon = BASE + "unsummon",
	Error = BASE + "error",
	Select = BASE + "select",
	Move = BASE + "move",
	Cancel = BASE + "cancel",
	LazyAfternoons = BASE + "music.Lazy Afternoons",
	Drive = BASE + "drive",
	AntiDrive = BASE + "antidrive",
	Potion = BASE + "potion"
	;
}

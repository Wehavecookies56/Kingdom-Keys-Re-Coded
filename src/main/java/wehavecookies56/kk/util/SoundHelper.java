package wehavecookies56.kk.util;

import wehavecookies56.kk.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class SoundHelper {

	public static void playSoundAtEntity(World world, Entity entity, String name, float volume, float pitch){
		world.playSoundAtEntity(entity, name, volume, pitch);
	}
		
	public static final String BASE = Reference.MODID+":";
	
	public static String
	Summon = BASE + "summon",
	UnSummon = BASE + "unsummon",
	Error = BASE + "error",
	LazyAfternoons = BASE + "music.Lazy Afternoons";
	;
}

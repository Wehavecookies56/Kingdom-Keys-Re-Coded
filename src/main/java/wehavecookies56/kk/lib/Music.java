package wehavecookies56.kk.lib;

import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Music {
	public static PositionedSoundRecord lazyAfternoons = PositionedSoundRecord.create(new ResourceLocation(Reference.MODID, "music.Lazy Afternoons"));
	public static PositionedSoundRecord sinisterSundown = PositionedSoundRecord.create(new ResourceLocation(Reference.MODID, "music.Sinister Sundown"));
	public static PositionedSoundRecord dearlyBelovedDDD = PositionedSoundRecord.create(new ResourceLocation(Reference.MODID, "music.Dearly Beloved (DDD)"));
	public static PositionedSoundRecord dearlyBelovedBBS = PositionedSoundRecord.create(new ResourceLocation(Reference.MODID, "music.Dearly Beloved (BBS)"));
	public static PositionedSoundRecord dearlyBelovedDays = PositionedSoundRecord.create(new ResourceLocation(Reference.MODID, "music.Dearly Beloved (Days)"));
	public static PositionedSoundRecord dearlyBelovedKH1 = PositionedSoundRecord.create(new ResourceLocation(Reference.MODID, "music.Dearly Beloved (KH1)"));
	public static PositionedSoundRecord dearlyBelovedKH2 = PositionedSoundRecord.create(new ResourceLocation(Reference.MODID, "music.Dearly Beloved (KH2)"));
	public static PositionedSoundRecord dearlyBelovedCoded = PositionedSoundRecord.create(new ResourceLocation(Reference.MODID, "music.Dearly Beloved (Coded)"));
	public static PositionedSoundRecord dearlyBelovedReCoM = PositionedSoundRecord.create(new ResourceLocation(Reference.MODID, "music.Dearly Beloved (ReCoM)"));
	public static PositionedSoundRecord dearlyBelovedCoM = PositionedSoundRecord.create(new ResourceLocation(Reference.MODID, "music.Dearly Beloved (CoM)"));

}

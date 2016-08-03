package uk.co.wehavecookies56.kk.common.world.dimension;

import net.minecraft.client.audio.MusicTicker;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderEnd;
import net.minecraftforge.common.DimensionManager;

/**
 * Created by Toby on 01/08/2016.
 */
public class ModDimensions {

    public static DimensionType diveToTheHeart;
    public static int diveToTheHeartID;

    public static void init() {
        diveToTheHeartID = DimensionManager.getNextFreeDimId();
        diveToTheHeart = DimensionType.register("Dive to the Heart", "", diveToTheHeartID, WorldProviderDiveToTheHeart.class, false);
        DimensionManager.registerDimension(diveToTheHeartID, diveToTheHeart);
    }

}

package uk.co.wehavecookies56.kk.common.world.dimension;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import uk.co.wehavecookies56.kk.common.core.handler.ConfigHandler;

/**
 * Created by Toby on 01/08/2016.
 */
public class ModDimensions {

    public static DimensionType diveToTheHeart;
    public static int diveToTheHeartID;

    public static void init() {
    //Not really working
        //    if(ConfigHandler.StationOfAwakeningID.equals("auto"))
        diveToTheHeartID = DimensionManager.getNextFreeDimId();
        //else
        //diveToTheHeartID = Integer.parseInt(ConfigHandler.StationOfAwakeningID);
        diveToTheHeart = DimensionType.register("Dive to the Heart", "", diveToTheHeartID, WorldProviderDiveToTheHeart.class, false);
        DimensionManager.registerDimension(diveToTheHeartID, diveToTheHeart);
    }

}

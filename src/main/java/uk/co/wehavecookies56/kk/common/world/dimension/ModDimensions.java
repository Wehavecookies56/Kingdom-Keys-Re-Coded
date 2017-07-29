package uk.co.wehavecookies56.kk.common.world.dimension;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

/**
 * Created by Toby on 01/08/2016.
 */
public class ModDimensions {

    public static DimensionType diveToTheHeart, traverseTown;
    public static int diveToTheHeartID, traverseTownID;

    public static void init() {
    //Not really working
        //    if(ConfigHandler.StationOfAwakeningID.equals("auto"))
        diveToTheHeartID = DimensionManager.getNextFreeDimId();
        traverseTownID = diveToTheHeartID++;
        //else
        //diveToTheHeartID = Integer.parseInt(ConfigHandler.StationOfAwakeningID);
        diveToTheHeart = DimensionType.register("Dive to the Heart", "", diveToTheHeartID, WorldProviderDiveToTheHeart.class, false);
        traverseTown = DimensionType.register("Traverse Town", "", traverseTownID, WorldProviderTraverseTown.class, false);
        DimensionManager.registerDimension(diveToTheHeartID, diveToTheHeart);
        DimensionManager.registerDimension(traverseTownID, traverseTown);
    }

}

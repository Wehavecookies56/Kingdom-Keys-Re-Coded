package uk.co.wehavecookies56.kk.common.world.dimension;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

/**
 * Created by Toby on 01/08/2016.
 */
public class ModDimensions {

    public static DimensionType diveToTheHeart, traverseTown, destinyIslands;
    public static int diveToTheHeartID, traverseTownID, destinyIslandsID;

    public static void init() {
    //Not really working
        //    if(ConfigHandler.StationOfAwakeningID.equals("auto"))
        diveToTheHeartID = DimensionManager.getNextFreeDimId();
        diveToTheHeart = DimensionType.register("Dive to the Heart", "", diveToTheHeartID, WorldProviderDiveToTheHeart.class, false);
        DimensionManager.registerDimension(diveToTheHeartID, diveToTheHeart);
        traverseTownID = DimensionManager.getNextFreeDimId();
        traverseTown = DimensionType.register("Traverse Town", "", traverseTownID, WorldProviderTraverseTown.class, false);
        DimensionManager.registerDimension(traverseTownID, traverseTown);
        destinyIslandsID = DimensionManager.getNextFreeDimId();
        destinyIslands = DimensionType.register("Destiny Islands", "", destinyIslandsID, WorldProviderDestinyIslands.class, false);
        DimensionManager.registerDimension(destinyIslandsID, destinyIslands);
        //else
        //diveToTheHeartID = Integer.parseInt(ConfigHandler.StationOfAwakeningID);

    }
}

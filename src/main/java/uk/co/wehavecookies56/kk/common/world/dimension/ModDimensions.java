package uk.co.wehavecookies56.kk.common.world.dimension;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;

/**
 * Created by Toby on 01/08/2016.
 */
public class ModDimensions {

    public static DimensionType diveToTheHeart, traverseTown, destinyIslands;
    public static int diveToTheHeartID, traverseTownID, destinyIslandsID;

    public static void init() {
        diveToTheHeartID = getDimIDFromString(MainConfig.worldgen.StationOfAwakeningID);
        diveToTheHeart = DimensionType.register("Dive to the Heart", "", diveToTheHeartID, WorldProviderDiveToTheHeart.class, false);
        DimensionManager.registerDimension(diveToTheHeartID, diveToTheHeart);
        traverseTownID = getDimIDFromString(MainConfig.worldgen.TraverseTownID);
        traverseTown = DimensionType.register("Traverse Town", "", traverseTownID, WorldProviderTraverseTown.class, false);
        DimensionManager.registerDimension(traverseTownID, traverseTown);
        destinyIslandsID = getDimIDFromString(MainConfig.worldgen.DestinyIslandsID);
        destinyIslands = DimensionType.register("Destiny Islands", "", destinyIslandsID, WorldProviderDestinyIslands.class, false);
        DimensionManager.registerDimension(destinyIslandsID, destinyIslands);
    }

    static int getDimIDFromString(String string) {
        return string.equals("auto") ? DimensionManager.getNextFreeDimId() : Integer.parseInt(string);
    }
}

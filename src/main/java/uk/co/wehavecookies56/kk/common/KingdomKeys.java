package uk.co.wehavecookies56.kk.common;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;
import uk.co.wehavecookies56.kk.common.core.command.*;
import uk.co.wehavecookies56.kk.common.core.proxy.CommonProxy;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityMoogle;
import uk.co.wehavecookies56.kk.common.entity.mobs.IKHMob;
import uk.co.wehavecookies56.kk.common.lib.Reference;


@Mod (name = Reference.MODNAME, modid = Reference.MODID, version = Reference.MODVER, modLanguage = "java", updateJSON = "https://raw.githubusercontent.com/Wehavecookies56/Kingdom-Keys-Re-Coded/master/update.json")
public class KingdomKeys {

    @SidedProxy (clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
    public static CommonProxy proxy;

    @Mod.Instance (Reference.MODID)
    public static KingdomKeys instance;

    public static Logger logger;

    public static EnumCreatureType HEARTLESS = EnumHelper.addCreatureType(Reference.MODID + ":heartless", IKHMob.class, 30, Material.AIR, false, false);
    public static EnumCreatureType MOOGLE = EnumHelper.addCreatureType(Reference.MODID + ":moogles", EntityMoogle.class, 10, Material.AIR, true, false);

    @EventHandler
    public void preInit (FMLPreInitializationEvent e) {
        logger = e.getModLog();

        proxy.preInit(e);
    }

    @EventHandler
    public void init (FMLInitializationEvent e) {
        proxy.init(e);
    }

    @EventHandler
    public void postInit (FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    @EventHandler
    public void serverStart (FMLServerStartingEvent e) {
        e.registerServerCommand(new CommandLearnRecipe());
        e.registerServerCommand(new CommandGiveMunny());
        e.registerServerCommand(new CommandCheatMode());
        e.registerServerCommand(new CommandRemoveKeychain());
        e.registerServerCommand(new CommandResetLevel());
        e.registerServerCommand(new CommandLevelUp());
        e.registerServerCommand(new CommandDriveLevel());
        e.registerServerCommand(new CommandShowHud());
        e.registerServerCommand(new CommandDimension());

        logger.info("Commands loaded");
    }

}

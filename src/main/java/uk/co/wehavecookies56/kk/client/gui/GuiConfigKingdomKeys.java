package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import uk.co.wehavecookies56.kk.common.core.handler.ConfigHandler;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class GuiConfigKingdomKeys extends GuiConfig {

	public GuiConfigKingdomKeys (GuiScreen parent) {
		super(parent, new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Reference.MODID, false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
	}

}

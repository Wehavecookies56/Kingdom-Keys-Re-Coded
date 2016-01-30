package wehavecookies56.kk.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.lib.Reference;

public class GuiConfigKingdomKeys extends GuiConfig {

	public GuiConfigKingdomKeys(GuiScreen parent) {
		super(parent,
				new ConfigElement(KingdomKeys.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
				Reference.MODID, false, false, GuiConfig.getAbridgedConfigPath(KingdomKeys.config.toString()));
	}

}

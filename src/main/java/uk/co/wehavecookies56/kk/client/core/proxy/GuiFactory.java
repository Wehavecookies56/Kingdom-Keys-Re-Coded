package uk.co.wehavecookies56.kk.client.core.proxy;

import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;
import uk.co.wehavecookies56.kk.client.gui.GuiConfigKingdomKeys;

public class GuiFactory implements IModGuiFactory {

	@Override
	public void initialize (Minecraft minecraftInstance) {

	}

	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass () {
		return GuiConfigKingdomKeys.class;
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories () {
		return null;
	}

	@Override
	public RuntimeOptionGuiHandler getHandlerFor (RuntimeOptionCategoryElement element) {
		return null;
	}

}

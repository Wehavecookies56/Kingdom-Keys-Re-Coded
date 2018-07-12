package uk.co.wehavecookies56.kk.client.gui.redesign;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.abilities.AbilityEvent;
import uk.co.wehavecookies56.kk.client.gui.GuiMenu_Bars;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.ability.Abilities;
import uk.co.wehavecookies56.kk.common.ability.AbilityScan;

import java.io.IOException;

@Mod.EventBusSubscriber(value = Side.CLIENT)
public class GuiAbilities extends GuiScreen {

    GuiMenu_Bars background;

    GuiMenuButton test;

    public GuiAbilities() {
        mc = Minecraft.getMinecraft();
        this.background = new GuiMenu_Bars("Abilities");
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        background.drawBars();
        background.drawBiomeDim();
        background.drawMunnyTime();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {
        background.width = width;
        background.height = height;
        background.init();
        buttonList.add(test = new GuiMenuButton(0, 0, 0, 200, "TEST ABILITY EVENT"));
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0) {
            MinecraftForge.EVENT_BUS.post(new AbilityEvent.Equip(mc.player, Abilities.scan));
        }
        super.actionPerformed(button);
    }

    @SubscribeEvent
    public static void equipAbility(AbilityEvent.Equip event) {
        KingdomKeys.logger.info("Equipped " + event.getAbility().getName());
    }
}

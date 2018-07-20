package uk.co.wehavecookies56.kk.client.gui.redesign;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.abilities.Ability;
import uk.co.wehavecookies56.kk.api.abilities.AbilityEvent;
import uk.co.wehavecookies56.kk.client.gui.GuiMenu_Bars;
import uk.co.wehavecookies56.kk.common.ability.ModAbilities;
import uk.co.wehavecookies56.kk.common.capability.AbilitiesCapability.IAbilities;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncUnlockedAbilities;
import uk.co.wehavecookies56.kk.common.network.packet.server.EquipAbility;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability.IPlayerStats;
import uk.co.wehavecookies56.kk.common.lib.Reference;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import com.google.common.math.Stats;

@Mod.EventBusSubscriber(value = Side.CLIENT)
public class GuiAbilities extends GuiScreen {

	GuiMenu_Bars background;

	public GuiAbilities() {
		mc = Minecraft.getMinecraft();
		this.background = new GuiMenu_Bars("Abilities");
	}

	@Override
	public void initGui() {
		background.width = width;
		background.height = height;
		background.init();

		IAbilities ABILITIES = mc.player.getCapability(ModCapabilities.ABILITIES, null);
		int id = 0;

		for (int i = 0; i < ABILITIES.getUnlockedAbilities().size(); i++) {
			Ability ability = ABILITIES.getUnlockedAbilities().get(i);
			buttonList.add(new GuiMenuButton(id++, 0, id * 20, 100, ability.getName()));
			System.out.println(ability.getName());
		}

		super.initGui();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		background.drawBars();
		background.drawBiomeDim();
		background.drawMunnyTime();
		drawAP();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	private void drawAP() {

		IAbilities ABILITIES = mc.player.getCapability(ModCapabilities.ABILITIES, null);
		IPlayerStats STATS = mc.player.getCapability(ModCapabilities.PLAYER_STATS, null);

		Ability hoveredAbility = null;
		for (int i = 0; i < buttonList.size(); i++) {
			Ability ability = ABILITIES.getUnlockedAbilities().get(i);
			String text = "";
			if (ABILITIES.getEquippedAbility(ability)) {
				text = "[-] "; // Has to unequip
			} else {
				text = "[+] "; // Has to equip
			}
			text += Utils.translateToLocal(ability.getName()) + " (" + ability.getApCost() + ") [" + ability.getCategory() + "]";
			GuiMenuButton button = (GuiMenuButton) buttonList.get(i);
			if (ability.getApCost() > STATS.getMaxAP() - STATS.getConsumedAP() && !ABILITIES.getEquippedAbility(ability)) {
				button.enabled = false;
			}
			button.displayString = text;
			
			if (button.isHovered())
				hoveredAbility = ABILITIES.getUnlockedAbilities().get(button.id);
		}

		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());

		int screenWidth = sr.getScaledWidth();
		int screenHeight = sr.getScaledHeight();

		int barWidth = 100;
		int posX = screenWidth - barWidth;
		int posY = screenHeight - 100;
		float scale = 1F;

		int ap = STATS.getConsumedAP();
		int maxAP = STATS.getMaxAP();
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/mpbar.png"));

		// Background
		GL11.glPushMatrix();
		{
			GL11.glTranslatef((posX - 2) * scale, posY * scale, 0);
			GL11.glScalef(barWidth, scale, 0);
			drawTexturedModalRect(0, 0, 2, 22, 1, 7);
		}
		GL11.glPopMatrix();

		int requiredAP = 0;
		if(hoveredAbility != null)
			requiredAP = hoveredAbility.getApCost();
		else
			requiredAP = 0;
			//System.out.println(hoveredAbility.getName());
		//System.out.println(requiredAP);
		
		// Foreground
		GL11.glPushMatrix();
		{
			int v = 12;
			if(requiredAP > STATS.getMaxAP() - STATS.getConsumedAP() && hoveredAbility != null && !ABILITIES.getEquippedAbility(hoveredAbility))
				v = 2;
			int percent = ap * barWidth / maxAP;
			GL11.glTranslatef((posX - 2) * scale, posY * scale, 0);
			GL11.glScalef(percent, scale, 0);
			drawTexturedModalRect(0, 0, 2, v, 1, 7);
		}
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		{
			GL11.glTranslatef((posX - 2) * scale, posY * scale + 10, 0);
			GL11.glScalef(scale, scale, 0);
			drawString(mc.fontRenderer, "AP: " + ap + "/" + maxAP, 0, 0, 0xFFFFFF);
		}
		GL11.glPopMatrix();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		IAbilities ABILITIES = mc.player.getCapability(ModCapabilities.ABILITIES, null);

		Ability ability = ABILITIES.getUnlockedAbilities().get(button.id);
		IPlayerStats STATS = mc.player.getCapability(ModCapabilities.PLAYER_STATS, null);
		if (ABILITIES.getEquippedAbility(ability)) {
			MinecraftForge.EVENT_BUS.post(new AbilityEvent.Unequip(mc.player, ability));
			STATS.setConsumedAP(STATS.getConsumedAP() - ability.getApCost());
			ABILITIES.equipAbility(ability, false);

		} else {
			MinecraftForge.EVENT_BUS.post(new AbilityEvent.Equip(mc.player, ability));
			if (STATS.getConsumedAP() + ability.getApCost() > STATS.getMaxAP()) {
				System.out.println("Not enough AP");
			} else {
				STATS.setConsumedAP(STATS.getConsumedAP() + ability.getApCost());
				ABILITIES.equipAbility(ability, true);
			}
		}
		PacketDispatcher.sendToServer(new EquipAbility(ability.getName()));

		mc.displayGuiScreen(this); // TODO change this to a proper updating method
		// updateScreen();
		super.actionPerformed(button);
	}
}

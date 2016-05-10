package uk.co.wehavecookies56.kk.client.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.GuiScrollingList;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisMaterialCapability.ISynthesisMaterial;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;

public class GuiMaterialList extends GuiScrollingList {

	private GuiSynthesis parent;

	FontRenderer f = Minecraft.getMinecraft().fontRendererObj;
	RenderItem ir = Minecraft.getMinecraft().getRenderItem();
	static ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
	static int width = sr.getScaledWidth();
	static int height = sr.getScaledHeight();
	static int sizeX = 150;
	static int posX = 5;
	static int posY = (height - 200) / 2;

	public GuiMaterialList (GuiSynthesis parent) {
		super(parent.mc, 150, 500, 60, parent.height - ((parent.height / 8) + 70 / 16), 8, 35, parent.width, parent.width);
		this.parent = parent;
	}

	@Override
	protected int getSize () {
		return Minecraft.getMinecraft().thePlayer.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).getKnownMaterialsMap().size();
	}

	@Override
	protected void elementClicked (int index, boolean doubleClick) {
		parent.materialSelected = index;
	}

	@Override
	protected boolean isSelected (int index) {
		if (index == parent.materialSelected) return true;
		return false;
	}

	@Override
	protected void drawBackground () {}

	@Override
	protected void drawSlot (int var1, int var2, int var3, int var4, Tessellator var5) {

		ISynthesisMaterial MATS = Minecraft.getMinecraft().thePlayer.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null);
		
		List<String> materials = new ArrayList<String>();

		materials.addAll(MATS.getKnownMaterialsMap().keySet());

		this.f.drawString(f.trimStringToWidth(TextHelper.localize(materials.get(var1).toString() + ".name") + " x" + MATS.getKnownMaterialsMap().get(materials.get(var1)), listWidth - 10), this.left + 3, var3 + 2, 0xFFFFFF);
		Material m = MaterialRegistry.get(materials.get(var1).toString());
		if (m.getTexture() != null) {
			GL11.glPushMatrix();
			{
				ResourceLocation texture = m.getTexture();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(this.left + 3, var3 + 12, 0);
				GL11.glScalef(0.0625f, 0.0625f, 0.0625f);
				parent.drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			}
			GL11.glPopMatrix();
		} else {
			ItemStack item = m.getItem();
			this.ir.renderItemAndEffectIntoGUI(item, this.left + 3, var3 + 12);
		}
	}
}

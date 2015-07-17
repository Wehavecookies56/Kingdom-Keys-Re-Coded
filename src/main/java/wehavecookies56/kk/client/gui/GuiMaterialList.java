package wehavecookies56.kk.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraftforge.fml.client.GuiScrollingList;
import wehavecookies56.kk.entities.ExtendedPlayerMaterials;
import wehavecookies56.kk.lib.Lists;
import wehavecookies56.kk.util.TextHelper;

public class GuiMaterialList extends GuiScrollingList {

	private GuiSynthesis parent;

	FontRenderer f = Minecraft.getMinecraft().fontRendererObj;
	RenderItem ir = Minecraft.getMinecraft().getRenderItem();
	static ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
	static int width = sr.getScaledWidth();
	static int height = sr.getScaledHeight();
	static int sizeX = 150;
	static int posX = 5;
	static int posY = (height-200)/2;

	public GuiMaterialList(GuiSynthesis parent){
		super(parent.mc, 150, 300, 60, parent.height - ((parent.height/8)+70/16), 8, 35);
		this.parent = parent;
	}

	@Override
	protected int getSize(){
		return Lists.materials.size();
	}

	@Override
	protected void elementClicked(int index, boolean doubleClick){}

	@Override
	protected boolean isSelected(int index){
		return false;
	}

	@Override
	protected void drawBackground(){}

	@Override
	protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5)
	{
		ExtendedPlayerMaterials props = ExtendedPlayerMaterials.get(Minecraft.getMinecraft().thePlayer);

		this.f.drawString(f.trimStringToWidth(TextHelper.localize(Lists.materials.get(var1) + ".name") + " x" + props.arrayOfAmounts[var1], listWidth - 10), this.left + 3, var3 + 2, 0xFFFFFF);

	}
}

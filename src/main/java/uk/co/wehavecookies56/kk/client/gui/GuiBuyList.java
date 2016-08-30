package uk.co.wehavecookies56.kk.client.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.client.GuiScrollingList;
import uk.co.wehavecookies56.kk.api.munny.MunnyRegistry;
import uk.co.wehavecookies56.kk.common.core.handler.event.ItemEvents;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiBuyList extends GuiScrollingList {

	private GuiShop parent;

	FontRenderer f = Minecraft.getMinecraft().fontRendererObj;
	RenderItem ir = Minecraft.getMinecraft().getRenderItem();
	static ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
	static int width = sr.getScaledWidth();
	static int height = sr.getScaledHeight();
	static int sizeX = 150;
	static int posX = 5;
	static int posY = (height - 200) / 2;

	public static List<ItemStack> itemsForSale = new ArrayList<ItemStack>();

	public GuiBuyList(GuiShop parent) {
		super(parent.mc, 190, 300, 60, parent.height - ((parent.height / 8) + 70 / 16), 8, 35, parent.width, parent.height);
		this.parent = parent;
		itemsForSale.clear();
		itemsForSale.add(new ItemStack(Items.IRON_INGOT));
		ItemStack orichalcum = new ItemStack(ModItems.SynthesisMaterial);
		orichalcum.setTagCompound(new NBTTagCompound());
		orichalcum.getTagCompound().setString("material", "sm.orichalcum");
		orichalcum.getTagCompound().setString("rank", "sm.rank.a");
		itemsForSale.add(orichalcum);
	}

	@Override
	protected int getSize () {
		return itemsForSale.size();
	}

	@Override
	protected void elementClicked (int index, boolean doubleClick) {
		parent.buySelected = index;
		parent.updateButtons();
	}

	@Override
	protected boolean isSelected (int index) {
		if (index == parent.buySelected) return true;
		return false;
	}

	@Override
	protected void drawBackground () {

	}

	@Override
	protected void drawSlot (int slotIdx, int entryRight, int slotTop, int slotBuffer, Tessellator tess) {

		String name = itemsForSale.get(slotIdx).getDisplayName();

		if (itemsForSale.get(slotIdx).hasTagCompound()) {
			if (itemsForSale.get(slotIdx).getTagCompound().hasKey("material")) {
				name = Utils.translateToLocal(itemsForSale.get(slotIdx).getTagCompound().getString("material") + ".name");
			}
		}
		Minecraft.getMinecraft().fontRendererObj.drawString(name, this.left + 3, slotTop, 0xFFFFFF);
		for (ItemStack stack : MunnyRegistry.munnyValues.keySet()) {
			if (ItemEvents.areItemStacksEqual(stack, itemsForSale.get(slotIdx))) {
				Minecraft.getMinecraft().fontRendererObj.drawString(MunnyRegistry.munnyValues.get(stack)+"", this.left + 3, slotTop + 12, 0xFFFF55);
			}
		}
	}

	public void drawBuySelected() {
		int posX = 220;
		if (parent.buySelected != -1) {
			Minecraft.getMinecraft().renderEngine.bindTexture(parent.optionsBackground);
			drawGradientRect(posX - 10, 60, 700, parent.height - ((parent.height / 8) + 70 / 16), -1072689136, -804253680);
		}
		GL11.glPushMatrix(); {
			GL11.glTranslatef(posX, 70, 0);
			GL11.glScalef(2, 2, 2);
			parent.drawString(Minecraft.getMinecraft().fontRendererObj, itemsForSale.get(parent.buySelected).getDisplayName(), 0, 0, 0xFFFFFF);
		}
		GL11.glPopMatrix();
		parent.drawString(Minecraft.getMinecraft().fontRendererObj, Utils.translateToLocal(Strings.Gui_Shop_Buy_Quantity), 220, parent.height - ((parent.height / 8) + 70 / 16) - 60, 0xFFFFFF);
		GL11.glPushMatrix(); {
			GL11.glTranslatef(posX, 90, 0);
			for (ItemStack stack : MunnyRegistry.munnyValues.keySet()) {
				if (ItemEvents.areItemStacksEqual(stack, itemsForSale.get(parent.buySelected))) {
					Minecraft.getMinecraft().fontRendererObj.drawString(Utils.translateToLocal(Strings.Gui_Shop_Buy_Cost) + ": " + MunnyRegistry.munnyValues.get(stack), 0, 0, 0xFFFF55);
				}
			}
		}
		GL11.glPopMatrix();
	}

}
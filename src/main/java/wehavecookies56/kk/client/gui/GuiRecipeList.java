package wehavecookies56.kk.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.fml.client.GuiIngameModOptions;
import net.minecraftforge.fml.client.GuiScrollingList;

public class GuiRecipeList extends GuiScrollingList {

	private GuiSynthesis parent;
	
	FontRenderer f = Minecraft.getMinecraft().fontRendererObj;

    public GuiRecipeList(GuiSynthesis parent)
    {
        super(parent.mc, parent.width - 10, parent.height, (int)(parent.height*0.25f)- 25, (int)(parent.height), 2, 35);
        this.parent = parent;
    }

    @Override
    protected int getSize()
    {
        return 10;
    }

    @Override
    protected void elementClicked(int index, boolean doubleClick)
    {
    	
    }

    @Override
    protected boolean isSelected(int index)
    {
        return false;
    }

    @Override
    protected void drawBackground()
    {
    }

    @Override
    protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5)
    {
    	
        f.drawString(f.trimStringToWidth("Kingdom Key", listWidth - 10), this.left + 3, var3 + 2, 0xFF2222);
        f.drawString(f.trimStringToWidth("1", listWidth - 10), this.left + 3, var3 + 12, 0xFF2222);
        f.drawString(f.trimStringToWidth("1", listWidth - 10), this.left + 3, var3 + 22, 0xFF2222);

       // f.drawString(f.trimStringToWidth("Test 3", listWidth - 10), this.left + 3 , var3 + 32, 0xFF2222);
       // f.drawString(f.trimStringToWidth("Test 3", listWidth - 10), this.left + 3 , var3 + 42, 0xFF2222);
       // f.drawString(f.trimStringToWidth("Test 3", listWidth - 10), this.left + 3 , var3 + 52, 0xFF2222);
       // f.drawString(f.trimStringToWidth("Test 3", listWidth - 10), this.left + 3 , var3 + 62, 0xFF2222);
       // f.drawString(f.trimStringToWidth("Test 3", listWidth - 10), this.left + 3 , var3 + 72, 0xFF2222);
       // f.drawString(f.trimStringToWidth("Test 3", listWidth - 10), this.left + 3 , var3 + 82, 0xFF2222);
       // f.drawString(f.trimStringToWidth("Test 3", listWidth - 10), this.left + 3 , var3 + 92, 0xFF2222);
       // f.drawString(f.trimStringToWidth("Test 3", listWidth - 10), this.left + 3 , var3 + 102, 0xFF2222);
       // f.drawString(f.trimStringToWidth("Test 3", listWidth - 10), this.left + 3 , var3 + 112, 0xFF2222);
       // f.drawString(f.trimStringToWidth("Test 3", listWidth - 10), this.left + 3 , var3 + 122, 0xFF2222);
       // f.drawString(f.trimStringToWidth("Test 3", listWidth - 10), this.left + 3 , var3 + 132, 0xFF2222);
       // f.drawString(f.trimStringToWidth("Test 3", listWidth - 10), this.left + 3 , var3 + 142, 0xFF2222);

    }


}

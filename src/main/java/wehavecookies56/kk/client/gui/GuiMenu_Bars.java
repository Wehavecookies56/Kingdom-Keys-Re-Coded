package wehavecookies56.kk.client.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.OpenGui;
import wehavecookies56.kk.util.TextHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiMenu_Bars extends GuiScreen {

	String name;

	public GuiMenu_Bars(String name) {
		this.name = name;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		RenderHelper.disableStandardItemLighting();
		drawBackground(width, height);
		GL11.glPushMatrix();{
			drawCenteredString(fontRendererObj, mc.thePlayer.getDisplayNameString().toString(), this.width/2, this.height/2 + 80, 0xFFFFFF);
			drawCenteredString(fontRendererObj, "HP: "+(int)mc.thePlayer.getHealth(), this.width/2-20, this.height/2 + 90, 0x00FF00);
			drawCenteredString(fontRendererObj, "MP: "+(int)ExtendedPlayer.get(mc.thePlayer).getMp(), this.width/2+20, this.height/2 + 90, 0x4444FF);

			drawCenteredString(fontRendererObj, "Level: "+ExtendedPlayer.get(mc.thePlayer).getLevel(), this.width/2, this.height/2 + 100, 0xFFFFFF);
			
		}GL11.glPopMatrix();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	public static final ResourceLocation optionsBackground = new ResourceLocation(Reference.MODID, "textures/gui/menubg.png");

	public static String getWorldMinutes(World world) {
        int time = (int) Math.abs((world.getWorldTime() + 6000) % 24000);
        if((time % 1000) * 6 / 100 < 10){
        	return "0" + (time % 1000) * 6 / 100;
        }else{
        	return Integer.toString((time % 1000) * 6 / 100);
        }
    }

    public static int getWorldHours(World world) {
        int time = (int)Math.abs((world.getWorldTime()+ 6000) % 24000);
        return (int)((float)time / 1000F);
    }

	protected void drawBackground(int screenWidth, int screenHeight) {
		Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
		GL11.glPushMatrix();
		{
			GL11.glColor3ub((byte)24, (byte)36, (byte)214);
			//GL11.glColor4f(0.3F, 0.3F, 0.3F, 1.0F);
			//GL11.glScalef(2f, 2f, 2f);
			drawDefaultBackground();
			drawModalRectWithCustomSizedTexture(0, 0, 0, 0, screenWidth, 60, 32, 32);
			drawModalRectWithCustomSizedTexture(0, screenHeight - ((screenHeight/8)+70/16), 0, 0, screenWidth, 70, 32, 32);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		{
			GL11.glScalef(2, 2, 2);
			String title = TextHelper.localize(name);
			drawString(fontRendererObj, title, 5, 5, 0xFFFFFF);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		{
			drawString(fontRendererObj, mc.thePlayer.worldObj.provider.getDimensionName(), screenWidth - fontRendererObj.getStringWidth(mc.thePlayer.worldObj.provider.getDimensionName()) - 5, 5, 0xFFFFFF);
			drawString(fontRendererObj, mc.thePlayer.worldObj.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName, screenWidth - fontRendererObj.getStringWidth(mc.thePlayer.worldObj.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName) - 5, 20, 0xFFFFFF);
			drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Menu_Main_Time) +": " + getWorldHours(mc.theWorld) + ":" + getWorldMinutes(mc.theWorld), 5, screenHeight - ((screenHeight/8)-300/16), 0xFFFFFF);
			ExtendedPlayer props = ExtendedPlayer.get(mc.thePlayer);
			drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Menu_Main_Munny) + ": " + props.getMunny(), 5, screenHeight - ((screenHeight/8)-100/16), 0xFFD000);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();{
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GuiInventory.drawEntityOnScreen(this.width/2, (int)(this.height/2 + 75), 70, 0, 0, mc.thePlayer);
			//GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.75F);
		}GL11.glPopMatrix();

	}

}

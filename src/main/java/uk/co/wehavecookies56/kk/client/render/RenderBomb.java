package uk.co.wehavecookies56.kk.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability.IPlayerStats;
import uk.co.wehavecookies56.kk.common.entity.EntityXPGet;
import uk.co.wehavecookies56.kk.common.entity.mobs.BaseEntityBomb;

public class RenderBomb extends RenderKHMob{

	public RenderBomb(RenderManager mg, ModelBase model, float scale, String staticTexture) {
		super(mg, model, scale, staticTexture);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doRender(EntityLiving entity, double x, double y, double z, float entityYaw, float partialTicks) {

		if (entity instanceof BaseEntityBomb) {
			Minecraft mc = Minecraft.getMinecraft();
			BaseEntityBomb bomb = (BaseEntityBomb) entity;

			GL11.glPushMatrix();
			{
				GL11.glTranslated(x, y + 1, z);

				// GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
				// OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 128.0F,
				// 128.0F);

				GL11.glScaled(0.05, 0.05, 0.05);
				GL11.glRotated(180, 0, 1, 0);
				GL11.glRotated(180, 1, 0, 0);
				GL11.glRotatef(mc.player.getPitchYaw().y, 0, 1, 0);
				GL11.glRotatef(-mc.player.getPitchYaw().x, 1, 0, 0);

				System.out.println(bomb);
				
				
				mc.fontRenderer.drawString(bomb.ticksToExplode+"", -mc.fontRenderer.getStringWidth(bomb.ticksToExplode+"") / 2, 0, 0x0099ff);
					
				
				// GL11.glRotatef(rotation += 4, 0, 1, 0);

				// bindEntityTexture(entity);

				// this.model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

				// GL11.glPopAttrib();

			}
			GL11.glPopMatrix();
		}
	}

}

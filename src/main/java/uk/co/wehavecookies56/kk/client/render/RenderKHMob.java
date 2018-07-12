package uk.co.wehavecookies56.kk.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import uk.co.wehavecookies56.kk.common.entity.mobs.BaseEntityBomb;

public class RenderKHMob extends RenderLiving<EntityLiving> implements IRenderFactory<EntityMob> {

	private float scale;
	private ModelBase model;
	private String texturesSprite;
	private ResourceLocation texture;

	public RenderKHMob(RenderManager mg, ModelBase model, float scale, String staticTexture) {
		super(mg, model, scale / 2);
		this.model = model;
		this.scale = scale;
		this.texturesSprite = staticTexture;
		this.texture = new ResourceLocation("kk:textures/mobs/" + staticTexture + ".png");
	}

	@Override
	protected void preRenderCallback(EntityLiving entity, float i) {
		if (entity instanceof EntityMob)
			GL11.glScalef(this.scale, this.scale, this.scale);
	}

	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return this.texture;
	}

	public Render<? super EntityMob> createRenderFor(RenderManager manager) {
		return new RenderKHMob(manager, model, scale, texturesSprite);
	}

	@Override
	public void doRender(EntityLiving entity, double x, double y, double z, float entityYaw, float partialTicks) {
		if (entity instanceof BaseEntityBomb) {
			Minecraft mc = Minecraft.getMinecraft();
			BaseEntityBomb bomb = (BaseEntityBomb) entity;

			if (bomb.ticksToExplode <= 60) //TODO Make this somehow work 
			{
				GL11.glPushMatrix();
				{
					GL11.glTranslated(x, y + 1, z);

					GL11.glScaled(0.05, 0.05, 0.05);
					GL11.glRotated(180, 0, 1, 0);
					GL11.glRotated(180, 1, 0, 0);
					GL11.glRotatef(mc.player.getPitchYaw().y, 0, 1, 0);
					GL11.glRotatef(-mc.player.getPitchYaw().x, 1, 0, 0);

					System.out.println(bomb.ticksToExplode);

					String text = bomb.ticksToExplode / 20 + "";
					mc.fontRenderer.drawString(text, -mc.fontRenderer.getStringWidth(text) / 2, -20, 0xffffff);

					GL11.glColor4f(1, 1, 1, 1);
				}
				GL11.glPopMatrix();
			}
		}
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
}

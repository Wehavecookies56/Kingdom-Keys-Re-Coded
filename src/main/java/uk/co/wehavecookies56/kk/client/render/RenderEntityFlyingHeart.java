package uk.co.wehavecookies56.kk.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import uk.co.wehavecookies56.kk.client.model.ModelFlyingHeart;
import uk.co.wehavecookies56.kk.common.entity.EntityFlyingHeart;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class RenderEntityFlyingHeart extends Render implements IRenderFactory<EntityFlyingHeart>
{

	ModelBase model;
	float rotation;

	public RenderEntityFlyingHeart(RenderManager renderManager)
	{
		super(renderManager);
		shadowSize = 1;
		this.model = new ModelFlyingHeart();
		rotation = 0;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation(Reference.MODID, "textures/items/models/flyingheart.png");
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch)
	{
		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z); // OLD : (entity.ticksExisted/5f)-1

		GL11.glPushAttrib(GL11.GL_ENABLE_BIT);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 128.0F, 128.0F);

		float ticks = entity.ticksExisted;
		if (ticks < 10) // Growing
			GL11.glScalef(ticks * 0.0005f, ticks * 0.0005f, ticks * 0.0005f);
		else if (ticks > EntityFlyingHeart.MAX_TICKS - 10) // Disappearing
			GL11.glScalef((30 - ticks) * 0.0005f, (30 - ticks) * 0.0005f, (30 - ticks) * 0.0005f);
		else // Static size
			GL11.glScalef(0.005f, 0.005f, 0.005f);

		GL11.glRotatef(rotation += 4, 0, 1, 0);

		bindEntityTexture(entity);

		// GL11.glScalef(-1.0F, -1.0F, 1.0F);
		this.model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

		GL11.glPopAttrib();
		GL11.glPopMatrix();
	}

	@Override
	public Render<? super EntityFlyingHeart> createRenderFor(RenderManager manager)
	{
		return new RenderEntityFlyingHeart(manager);
	}

}

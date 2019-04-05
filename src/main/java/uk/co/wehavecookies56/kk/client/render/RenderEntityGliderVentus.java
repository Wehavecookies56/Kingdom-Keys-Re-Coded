package uk.co.wehavecookies56.kk.client.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import uk.co.wehavecookies56.kk.client.model.ModelGliderVentus;
import uk.co.wehavecookies56.kk.common.entity.EntityGliderTerra;
import uk.co.wehavecookies56.kk.common.entity.EntityGliderVentus;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class RenderEntityGliderVentus extends Render implements IRenderFactory<EntityGliderVentus> {

	ModelBase model;

	public RenderEntityGliderVentus(RenderManager renderManager) {
		super(renderManager);
		shadowSize = 1;
		this.model = new ModelGliderVentus();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation(Reference.MODID, "textures/entities/models/ventus.png");
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch) {
		GL11.glPushMatrix();
		{
			GL11.glTranslated(x, y + 0.5, z);
			GL11.glRotated(-entity.rotationYaw, 0, 1, 0);
			GL11.glRotated(-90, 1, 0, 0);
			bindEntityTexture(entity);
			GL11.glScalef(1.0F, 1.0F, 1.0F);
			this.model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		GL11.glPopMatrix();
	}

	@Override
	public Render<? super EntityGliderVentus> createRenderFor(RenderManager manager) {
		return new RenderEntityGliderVentus(manager);
	}
}

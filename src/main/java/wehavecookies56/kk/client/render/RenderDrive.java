package wehavecookies56.kk.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderDrive extends RendererLivingEntity<EntityLivingBase> {

	private ResourceLocation texture;
	
	public RenderDrive (RenderManager renderManagerIn, ModelBase modelBaseIn,
	float shadowSizeIn) {
		super(renderManagerIn, modelBaseIn, shadowSizeIn);
	    this.texture = new ResourceLocation("kk:textures/armour/Valor_A.png");
	}

	@Override
	protected ResourceLocation getEntityTexture (EntityLivingBase entity) {
		return texture;
	}
	
	@Override
	public void doRender (EntityLivingBase entity, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

}

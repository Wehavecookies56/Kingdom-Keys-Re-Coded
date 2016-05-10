package uk.co.wehavecookies56.kk.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.entity.block.EntityBlastBlox;

public class RenderBlastBlox extends Render<EntityBlastBlox> {

	public RenderBlastBlox (RenderManager render) {
		super(render);
		this.shadowSize = 0.5F;
	}

	@Override
	public void doRender (EntityBlastBlox entity, double x, double y, double z, float p_76986_8_, float p_76986_9_) {
		BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x, (float) y + 0.5F, (float) z);
		float f2;

		if (entity.fuse - p_76986_9_ + 1.0F < 10.0F) {
			f2 = 1.0F - (entity.fuse - p_76986_9_ + 1.0F) / 10.0F;
			f2 = MathHelper.clamp_float(f2, 0.0F, 1.0F);
			f2 *= f2;
			f2 *= f2;
			float f3 = 1.0F + f2 * 0.3F;
			GlStateManager.scale(f3, f3, f3);
		}

		f2 = (1.0F - (entity.fuse - p_76986_9_ + 1.0F) / 100.0F) * 0.8F;
		bindEntityTexture(entity);
		GlStateManager.translate(-0.5F, -0.5F, 0.5F);
		blockrendererdispatcher.renderBlockBrightness(ModBlocks.BlastBlox.getDefaultState(), entity.getBrightness(p_76986_9_));
		GlStateManager.translate(0.0F, 0.0F, 1.0F);

		if (entity.fuse / 5 % 2 == 0) {
			GlStateManager.disableTexture2D();
			GlStateManager.disableLighting();
			GlStateManager.enableBlend();
			GlStateManager.blendFunc(770, 772);
			GlStateManager.color(1.0F, 1.0F, 1.0F, f2);
			GlStateManager.doPolygonOffset(-3.0F, -3.0F);
			GlStateManager.enablePolygonOffset();
			blockrendererdispatcher.renderBlockBrightness(ModBlocks.BlastBlox.getDefaultState(), 1.0F);
			GlStateManager.doPolygonOffset(0.0F, 0.0F);
			GlStateManager.disablePolygonOffset();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			GlStateManager.disableBlend();
			GlStateManager.enableLighting();
			GlStateManager.enableTexture2D();
		}

		GlStateManager.popMatrix();
		super.doRender(entity, x, y, z, p_76986_8_, p_76986_9_);
	}

	protected ResourceLocation func_180563_a (EntityBlastBlox p_180563_1_) {
		return TextureMap.LOCATION_BLOCKS_TEXTURE;
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture (EntityBlastBlox par1Entity) {
		return func_180563_a(par1Entity);

	}

}
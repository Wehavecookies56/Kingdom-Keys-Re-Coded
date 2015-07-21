package wehavecookies56.kk.client.render;

import wehavecookies56.kk.entities.block.EntityBlastBlox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderBlastBlox extends Render{

	public RenderBlastBlox(RenderManager render) {
		super(render);
        this.shadowSize = 0.5F;
	}

	public void doRender(EntityTNTPrimed p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)p_76986_2_, (float)p_76986_4_ + 0.5F, (float)p_76986_6_);
        float f2;

        if ((float)p_76986_1_.fuse - p_76986_9_ + 1.0F < 10.0F)
        {
            f2 = 1.0F - ((float)p_76986_1_.fuse - p_76986_9_ + 1.0F) / 10.0F;
            f2 = MathHelper.clamp_float(f2, 0.0F, 1.0F);
            f2 *= f2;
            f2 *= f2;
            float f3 = 1.0F + f2 * 0.3F;
            GlStateManager.scale(f3, f3, f3);
        }

        f2 = (1.0F - ((float)p_76986_1_.fuse - p_76986_9_ + 1.0F) / 100.0F) * 0.8F;
        this.bindEntityTexture(p_76986_1_);
        GlStateManager.translate(-0.5F, -0.5F, 0.5F);
        blockrendererdispatcher.func_175016_a(Blocks.tnt.getDefaultState(), p_76986_1_.getBrightness(p_76986_9_));
        GlStateManager.translate(0.0F, 0.0F, 1.0F);

        if (p_76986_1_.fuse / 5 % 2 == 0)
        {
            GlStateManager.func_179090_x();
            GlStateManager.disableLighting();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 772);
            GlStateManager.color(1.0F, 1.0F, 1.0F, f2);
            GlStateManager.doPolygonOffset(-3.0F, -3.0F);
            GlStateManager.enablePolygonOffset();
            blockrendererdispatcher.func_175016_a(Blocks.tnt.getDefaultState(), 1.0F);
            GlStateManager.doPolygonOffset(0.0F, 0.0F);
            GlStateManager.disablePolygonOffset();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.disableBlend();
            GlStateManager.enableLighting();
            GlStateManager.func_179098_w();
        }

        GlStateManager.popMatrix();
        super.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

    protected ResourceLocation func_180563_a(EntityBlastBlox p_180563_1_)
    {
        return TextureMap.locationBlocksTexture;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_180563_a((EntityBlastBlox)par1Entity);

    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityTNTPrimed)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
package wehavecookies56.kk.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.entity.Entity;
import wehavecookies56.kk.entities.EntityItemMetalChocobo;

public class RenderEntityBlizzard extends RenderEntityItem {

	public RenderEntityBlizzard() {
		super(Minecraft.getMinecraft().getRenderManager(), Minecraft.getMinecraft().getRenderItem());
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {}

}

package wehavecookies56.kk.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import wehavecookies56.kk.entities.EntityItemMetalChocobo;

public class RenderEntityItemKeyblade extends RenderEntityItem {

	public RenderEntityItemKeyblade() {
		super(Minecraft.getMinecraft().getRenderManager(), Minecraft.getMinecraft().getRenderItem());
	}

	@Override
	public void doRender(EntityItem entity, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

}
